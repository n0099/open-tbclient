package com.baidu.tieba.play.a;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.ar.util.IoUtils;
import com.baidu.tbadk.core.util.w;
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
    private static b ghM = null;
    private com.baidu.tieba.play.a.a ghL;
    private InterfaceC0216b ghN = null;
    private int ghO = 0;

    /* renamed from: com.baidu.tieba.play.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0216b {
        void bU(String str, String str2);
    }

    private b() {
    }

    public static b bkZ() {
        if (ghM == null) {
            synchronized (b.class) {
                if (ghM == null) {
                    ghM = new b();
                }
            }
        }
        return ghM;
    }

    public void a(InterfaceC0216b interfaceC0216b) {
        this.ghN = interfaceC0216b;
    }

    public boolean sg(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (sh(str) && this.ghL.bkY().size() > this.ghO) {
            if (this.ghN != null) {
                InterfaceC0216b interfaceC0216b = this.ghN;
                List<String> bkY = this.ghL.bkY();
                int i = this.ghO;
                this.ghO = i + 1;
                interfaceC0216b.bU(bkY.get(i), str);
            }
            return true;
        } else if (this.ghL != null && this.ghL.bkY() != null && this.ghL.bkY().size() <= this.ghO) {
            this.ghO = 0;
            this.ghL = null;
            return false;
        } else {
            this.ghO = 0;
            this.ghL = null;
            a aVar = new a();
            aVar.setHost(str);
            aVar.execute(new Void[0]);
            return true;
        }
    }

    private boolean sh(String str) {
        return (this.ghL == null || TextUtils.isEmpty(str) || !str.equals(this.ghL.getHost()) || w.z(this.ghL.bkY()) || this.ghL.cN(System.currentTimeMillis()) || this.ghL.bkY().size() <= this.ghO) ? false : true;
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Void, com.baidu.tieba.play.a.a, Void> {
        private String EL = null;

        public a() {
        }

        public void setHost(String str) {
            this.EL = str;
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
                HttpsURLConnection httpsURLConnection3 = (HttpsURLConnection) new URL("https://180.76.76.112/v2/0011/?dn=" + this.EL).openConnection();
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
                        inputStreamReader = new InputStreamReader(inputStream, IoUtils.UTF_8);
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
                            publishProgress(aVar.sf(stringBuffer.toString()));
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
            if ((aVarArr[0] != null) && aVarArr[0].getHost() != null && aVarArr[0].getHost().equals(this.EL)) {
                b.this.ghL = aVarArr[0];
                if (!w.z(aVarArr[0].bkY()) && b.this.ghN != null) {
                    b.this.ghN.bU(aVarArr[0].bkY().get(0), aVarArr[0].getHost());
                    return;
                }
            }
            if (b.this.ghN != null) {
                b.this.ghN.bU(null, null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
        }
    }
}
