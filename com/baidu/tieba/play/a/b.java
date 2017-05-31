package com.baidu.tieba.play.a;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.x;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes.dex */
public class b {
    private static b fcn = null;
    private com.baidu.tieba.play.a.a fcm;
    private InterfaceC0077b fco = null;
    private int fcp = 0;

    /* renamed from: com.baidu.tieba.play.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0077b {
        void bO(String str, String str2);
    }

    private b() {
    }

    public static b aYf() {
        if (fcn == null) {
            synchronized (b.class) {
                if (fcn == null) {
                    fcn = new b();
                }
            }
        }
        return fcn;
    }

    public void a(InterfaceC0077b interfaceC0077b) {
        this.fco = interfaceC0077b;
    }

    public boolean pj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (pk(str) && this.fcm.aYe().size() > this.fcp) {
            if (this.fco != null) {
                InterfaceC0077b interfaceC0077b = this.fco;
                List<String> aYe = this.fcm.aYe();
                int i = this.fcp;
                this.fcp = i + 1;
                interfaceC0077b.bO(aYe.get(i), str);
            }
            return true;
        } else if (this.fcm != null && this.fcm.aYe() != null && this.fcm.aYe().size() <= this.fcp) {
            this.fcp = 0;
            this.fcm = null;
            return false;
        } else {
            this.fcp = 0;
            this.fcm = null;
            a aVar = new a();
            aVar.gw(str);
            aVar.execute(new Void[0]);
            return true;
        }
    }

    private boolean pk(String str) {
        return (this.fcm == null || TextUtils.isEmpty(str) || !str.equals(this.fcm.getHost()) || x.r(this.fcm.aYe()) || this.fcm.cl(System.currentTimeMillis()) || this.fcm.aYe().size() <= this.fcp) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, com.baidu.tieba.play.a.a, Void> {
        private String AA = null;

        public a() {
        }

        public void gw(String str) {
            this.AA = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00c5 A[Catch: Exception -> 0x00d5, TryCatch #5 {Exception -> 0x00d5, blocks: (B:39:0x00c0, B:41:0x00c5, B:43:0x00ca, B:45:0x00cf), top: B:71:0x00c0 }] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00ca A[Catch: Exception -> 0x00d5, TryCatch #5 {Exception -> 0x00d5, blocks: (B:39:0x00c0, B:41:0x00c5, B:43:0x00ca, B:45:0x00cf), top: B:71:0x00c0 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00cf A[Catch: Exception -> 0x00d5, TRY_LEAVE, TryCatch #5 {Exception -> 0x00d5, blocks: (B:39:0x00c0, B:41:0x00c5, B:43:0x00ca, B:45:0x00cf), top: B:71:0x00c0 }] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Void... voidArr) {
            BufferedReader bufferedReader;
            InputStreamReader inputStreamReader;
            InputStream inputStream;
            HttpsURLConnection httpsURLConnection;
            HttpsURLConnection httpsURLConnection2 = null;
            StringBuffer stringBuffer = new StringBuffer();
            try {
                HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) new URL("https://180.76.76.112/v2/0011/?dn=" + this.AA).openConnection();
                try {
                    httpsURLConnection3.setDoOutput(true);
                    httpsURLConnection3.setDoInput(true);
                    httpsURLConnection3.setUseCaches(false);
                    httpsURLConnection3.setConnectTimeout(5000);
                    httpsURLConnection3.setReadTimeout(10000);
                    httpsURLConnection3.setRequestProperty("Host", "httpsdns.baidu.com");
                    httpsURLConnection3.setHostnameVerifier(new c(this));
                    httpsURLConnection3.setRequestMethod("GET");
                    httpsURLConnection3.connect();
                    inputStream = httpsURLConnection3.getInputStream();
                    try {
                        inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    stringBuffer.append(readLine);
                                } catch (Exception e) {
                                    httpsURLConnection = httpsURLConnection3;
                                    e = e;
                                    try {
                                        e.printStackTrace();
                                        if (inputStreamReader != null) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Exception e2) {
                                            }
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (httpsURLConnection != null) {
                                            httpsURLConnection.disconnect();
                                        }
                                        return null;
                                    } catch (Throwable th) {
                                        th = th;
                                        httpsURLConnection2 = httpsURLConnection;
                                        if (inputStreamReader != null) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Exception e3) {
                                                throw th;
                                            }
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (httpsURLConnection2 != null) {
                                            httpsURLConnection2.disconnect();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    httpsURLConnection2 = httpsURLConnection3;
                                    th = th2;
                                    if (inputStreamReader != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (bufferedReader != null) {
                                    }
                                    if (httpsURLConnection2 != null) {
                                    }
                                    throw th;
                                }
                            }
                            com.baidu.tieba.play.a.a aVar = new com.baidu.tieba.play.a.a();
                            aVar.setStartTime(System.currentTimeMillis());
                            publishProgress(aVar.pi(stringBuffer.toString()));
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (Exception e4) {
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (httpsURLConnection3 != null) {
                                httpsURLConnection3.disconnect();
                            }
                        } catch (Exception e5) {
                            bufferedReader = null;
                            e = e5;
                            httpsURLConnection = httpsURLConnection3;
                        } catch (Throwable th3) {
                            bufferedReader = null;
                            httpsURLConnection2 = httpsURLConnection3;
                            th = th3;
                        }
                    } catch (Exception e6) {
                        bufferedReader = null;
                        inputStreamReader = null;
                        httpsURLConnection = httpsURLConnection3;
                        e = e6;
                    } catch (Throwable th4) {
                        bufferedReader = null;
                        inputStreamReader = null;
                        httpsURLConnection2 = httpsURLConnection3;
                        th = th4;
                    }
                } catch (Exception e7) {
                    bufferedReader = null;
                    inputStreamReader = null;
                    inputStream = null;
                    e = e7;
                    httpsURLConnection = httpsURLConnection3;
                } catch (Throwable th5) {
                    bufferedReader = null;
                    inputStreamReader = null;
                    inputStream = null;
                    httpsURLConnection2 = httpsURLConnection3;
                    th = th5;
                }
            } catch (Exception e8) {
                e = e8;
                httpsURLConnection = null;
                bufferedReader = null;
                inputStreamReader = null;
                inputStream = null;
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
                inputStreamReader = null;
                inputStream = null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(com.baidu.tieba.play.a.a... aVarArr) {
            super.onProgressUpdate(aVarArr);
            if ((aVarArr[0] != null) && aVarArr[0].getHost() != null && aVarArr[0].getHost().equals(this.AA)) {
                b.this.fcm = aVarArr[0];
                if (!x.r(aVarArr[0].aYe()) && b.this.fco != null) {
                    b.this.fco.bO(aVarArr[0].aYe().get(0), aVarArr[0].getHost());
                    return;
                }
            }
            if (b.this.fco != null) {
                b.this.fco.bO(null, null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
        }
    }
}
