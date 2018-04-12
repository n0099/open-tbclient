package com.baidu.tieba.play.a;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.v;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes.dex */
public class b {
    private static b fQW = null;
    private com.baidu.tieba.play.a.a fQV;
    private InterfaceC0199b fQX = null;
    private int fQY = 0;

    /* renamed from: com.baidu.tieba.play.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0199b {
        void bN(String str, String str2);
    }

    private b() {
    }

    public static b bhe() {
        if (fQW == null) {
            synchronized (b.class) {
                if (fQW == null) {
                    fQW = new b();
                }
            }
        }
        return fQW;
    }

    public void a(InterfaceC0199b interfaceC0199b) {
        this.fQX = interfaceC0199b;
    }

    public boolean rt(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (ru(str) && this.fQV.bhd().size() > this.fQY) {
            if (this.fQX != null) {
                InterfaceC0199b interfaceC0199b = this.fQX;
                List<String> bhd = this.fQV.bhd();
                int i = this.fQY;
                this.fQY = i + 1;
                interfaceC0199b.bN(bhd.get(i), str);
            }
            return true;
        } else if (this.fQV != null && this.fQV.bhd() != null && this.fQV.bhd().size() <= this.fQY) {
            this.fQY = 0;
            this.fQV = null;
            return false;
        } else {
            this.fQY = 0;
            this.fQV = null;
            a aVar = new a();
            aVar.setHost(str);
            aVar.execute(new Void[0]);
            return true;
        }
    }

    private boolean ru(String str) {
        return (this.fQV == null || TextUtils.isEmpty(str) || !str.equals(this.fQV.getHost()) || v.w(this.fQV.bhd()) || this.fQV.cP(System.currentTimeMillis()) || this.fQV.bhd().size() <= this.fQY) ? false : true;
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, com.baidu.tieba.play.a.a, Void> {
        private String yF = null;

        public a() {
        }

        public void setHost(String str) {
            this.yF = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00cd A[Catch: Exception -> 0x00db, TryCatch #11 {Exception -> 0x00db, blocks: (B:39:0x00c8, B:41:0x00cd, B:43:0x00d2, B:45:0x00d7), top: B:75:0x00c8 }] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00d2 A[Catch: Exception -> 0x00db, TryCatch #11 {Exception -> 0x00db, blocks: (B:39:0x00c8, B:41:0x00cd, B:43:0x00d2, B:45:0x00d7), top: B:75:0x00c8 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00d7 A[Catch: Exception -> 0x00db, TRY_LEAVE, TryCatch #11 {Exception -> 0x00db, blocks: (B:39:0x00c8, B:41:0x00cd, B:43:0x00d2, B:45:0x00d7), top: B:75:0x00c8 }] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) new URL("https://180.76.76.112/v2/0011/?dn=" + this.yF).openConnection();
                try {
                    httpsURLConnection3.setDoOutput(true);
                    httpsURLConnection3.setDoInput(true);
                    httpsURLConnection3.setUseCaches(false);
                    httpsURLConnection3.setConnectTimeout(5000);
                    httpsURLConnection3.setReadTimeout(10000);
                    httpsURLConnection3.setRequestProperty("Host", "httpsdns.baidu.com");
                    httpsURLConnection3.setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.tieba.play.a.b.a.1
                        @Override // javax.net.ssl.HostnameVerifier
                        public boolean verify(String str, SSLSession sSLSession) {
                            return HttpsURLConnection.getDefaultHostnameVerifier().verify("httpsdns.baidu.com", sSLSession);
                        }
                    });
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
                            publishProgress(aVar.rs(stringBuffer.toString()));
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
            if ((aVarArr[0] != null) && aVarArr[0].getHost() != null && aVarArr[0].getHost().equals(this.yF)) {
                b.this.fQV = aVarArr[0];
                if (!v.w(aVarArr[0].bhd()) && b.this.fQX != null) {
                    b.this.fQX.bN(aVarArr[0].bhd().get(0), aVarArr[0].getHost());
                    return;
                }
            }
            if (b.this.fQX != null) {
                b.this.fQX.bN(null, null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
        }
    }
}
