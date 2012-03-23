package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.util.GzipHelper;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public class FatalErrorService extends Service {
    private UpLoadErrorTask mTask = null;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.mTask != null) {
            this.mTask.cancel();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (this.mTask == null) {
            this.mTask = new UpLoadErrorTask(this, null);
            this.mTask.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class UpLoadErrorTask extends AsyncTask<String, Integer, String> {
        private NetWork mNetwork;

        private UpLoadErrorTask() {
            this.mNetwork = null;
        }

        /* synthetic */ UpLoadErrorTask(FatalErrorService fatalErrorService, UpLoadErrorTask upLoadErrorTask) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [89=4, 90=4, 94=4, 95=4, 97=4] */
        private void sendLogFile(String name, String net_address, boolean need_compress) {
            ByteArrayOutputStream outputstream = null;
            FileInputStream in = null;
            try {
                try {
                    File file = FileHelper.GetFile(name);
                    if (file != null && file.length() > Config.FATAL_ERROR_FILE_UPLOAD_SIZE) {
                        FileInputStream in2 = new FileInputStream(file);
                        try {
                            byte[] bArr = null;
                            ByteArrayOutputStream outputstream2 = new ByteArrayOutputStream(1024);
                            try {
                                if (need_compress) {
                                    GzipHelper.compress(in2, outputstream2);
                                } else {
                                    byte[] buffer = new byte[1024];
                                    while (true) {
                                        int count = in2.read(buffer, 0, 1024);
                                        if (count == -1) {
                                            break;
                                        }
                                        outputstream2.write(buffer, 0, count);
                                    }
                                    outputstream2.flush();
                                }
                                byte[] data = outputstream2.toByteArray();
                                if (data == null) {
                                    if (outputstream2 != null) {
                                        try {
                                            outputstream2.close();
                                        } catch (Exception e) {
                                        }
                                    }
                                    if (in2 != null) {
                                        try {
                                            in2.close();
                                        } catch (Exception e2) {
                                        }
                                    }
                                    return;
                                }
                                this.mNetwork = new NetWork(Config.SERVER_ADDRESS + net_address);
                                this.mNetwork.addPostData("logfile", data);
                                this.mNetwork.postMultiNetData();
                                if (this.mNetwork.isRequestSuccess()) {
                                    file.delete();
                                    in = in2;
                                    outputstream = outputstream2;
                                } else {
                                    in = in2;
                                    outputstream = outputstream2;
                                }
                            } catch (Exception e3) {
                                ex = e3;
                                in = in2;
                                outputstream = outputstream2;
                                TiebaLog.e(getClass().getName(), "sendLogFile", ex.getMessage());
                                if (outputstream != null) {
                                    try {
                                        outputstream.close();
                                    } catch (Exception e4) {
                                    }
                                }
                                if (in != null) {
                                    try {
                                        in.close();
                                        return;
                                    } catch (Exception e5) {
                                        return;
                                    }
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                in = in2;
                                outputstream = outputstream2;
                                if (outputstream != null) {
                                    try {
                                        outputstream.close();
                                    } catch (Exception e6) {
                                    }
                                }
                                if (in != null) {
                                    try {
                                        in.close();
                                    } catch (Exception e7) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e8) {
                            ex = e8;
                            in = in2;
                        } catch (Throwable th2) {
                            th = th2;
                            in = in2;
                        }
                    }
                    if (outputstream != null) {
                        try {
                            outputstream.close();
                        } catch (Exception e9) {
                        }
                    }
                    if (in != null) {
                        try {
                            in.close();
                        } catch (Exception e10) {
                        }
                    }
                } catch (Exception e11) {
                    ex = e11;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... params) {
            sendLogFile(Config.FATAL_ERROR_FILE, Config.ERROR_UPLOAD_SERVER, true);
            sendLogFile(Config.LOG_ERROR_FILE, Config.ERROR_LOG_SERVER, false);
            return null;
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            FatalErrorService.this.mTask = null;
            super.cancel(true);
            FatalErrorService.this.stopSelf();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((UpLoadErrorTask) result);
            FatalErrorService.this.mTask = null;
            FatalErrorService.this.stopSelf();
        }
    }
}
