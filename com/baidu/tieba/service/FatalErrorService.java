package com.baidu.tieba.service;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.telephony.TelephonyManager;
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
            this.mTask = new UpLoadErrorTask();
            this.mTask.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class UpLoadErrorTask extends AsyncTask<String, Integer, String> {
        private NetWork mNetwork;

        private UpLoadErrorTask() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [87=4, 88=4, 92=4, 93=4, 95=5] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... params) {
            Exception ex;
            ByteArrayOutputStream outputstream;
            ByteArrayOutputStream outputstream2 = null;
            FileInputStream in = null;
            try {
                try {
                    File file = FileHelper.CreateFileIfNotFound(Config.FATAL_ERROR_FILE);
                    if (file != null && file.length() > Config.FATAL_ERROR_FILE_UPLOAD_SIZE) {
                        FileInputStream in2 = new FileInputStream(file);
                        try {
                            outputstream = new ByteArrayOutputStream(1024);
                        } catch (Exception e) {
                            ex = e;
                            in = in2;
                        } catch (Throwable th) {
                            th = th;
                            in = in2;
                        }
                        try {
                            GzipHelper.compress(in2, outputstream);
                            byte[] data = outputstream.toByteArray();
                            if (data == null) {
                                if (outputstream != null) {
                                    try {
                                        outputstream.close();
                                    } catch (Exception e2) {
                                    }
                                }
                                if (in2 != null) {
                                    try {
                                        in2.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                return null;
                            }
                            this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/s/logupload");
                            TelephonyManager mTelephonyMgr = (TelephonyManager) FatalErrorService.this.getSystemService("phone");
                            String imei = mTelephonyMgr.getDeviceId();
                            if (imei != null) {
                                this.mNetwork.addPostData("_phone_imei", imei);
                            }
                            this.mNetwork.addPostData("logfile", data);
                            this.mNetwork.postMultiNetData();
                            if (this.mNetwork.isRequestSuccess()) {
                                file.delete();
                            }
                            in = in2;
                            outputstream2 = outputstream;
                        } catch (Exception e4) {
                            ex = e4;
                            in = in2;
                            outputstream2 = outputstream;
                            TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
                            if (outputstream2 != null) {
                                try {
                                    outputstream2.close();
                                } catch (Exception e5) {
                                }
                            }
                            if (in != null) {
                                try {
                                    in.close();
                                } catch (Exception e6) {
                                }
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            in = in2;
                            outputstream2 = outputstream;
                            if (outputstream2 != null) {
                                try {
                                    outputstream2.close();
                                } catch (Exception e7) {
                                }
                            }
                            if (in != null) {
                                try {
                                    in.close();
                                } catch (Exception e8) {
                                }
                            }
                            throw th;
                        }
                    }
                    if (outputstream2 != null) {
                        try {
                            outputstream2.close();
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
                return null;
            } catch (Throwable th3) {
                th = th3;
            }
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
