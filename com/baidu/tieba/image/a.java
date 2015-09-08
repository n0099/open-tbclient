package com.baidu.tieba.image;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a {
    private String aUF;
    private ArrayList<String> bLl;
    private String bLn;
    private String bLo;
    private boolean bLu;
    private String bLm = null;
    private String alg = null;
    private boolean bLp = false;
    private boolean bLq = true;
    private C0063a bLr = null;
    private int bLs = 0;
    private boolean bLt = false;
    private b bLv = null;
    private HashMap<String, String> bLw = new HashMap<>();

    /* loaded from: classes.dex */
    public interface b {
        void D(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2);
    }

    public a(ArrayList<String> arrayList, String str, String str2, String str3) {
        this.bLl = null;
        this.bLn = null;
        this.aUF = null;
        this.bLo = null;
        this.bLu = false;
        this.bLl = arrayList;
        if (this.bLl == null) {
            this.bLl = new ArrayList<>();
        }
        int size = this.bLl.size();
        for (int i = 0; i < size; i++) {
            String str4 = this.bLl.get(i);
            this.bLw.put(iH(str4), str4);
        }
        this.bLn = str2;
        this.aUF = str;
        this.bLo = str3;
        if (this.bLo == null) {
            this.bLu = true;
        }
    }

    public void dE(boolean z) {
        this.bLq = z;
    }

    public void YY() {
        if (!this.bLp && !this.bLu) {
            c(this.bLn, this.bLo, 10, 0);
        }
    }

    public void YZ() {
        if (!this.bLu) {
            if (!this.bLp) {
                YY();
            } else if (this.bLm != null && this.bLm.length() > 0) {
                this.bLq = true;
                c(this.bLm, null, 0, 10);
            }
        }
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.bLr != null) {
            if (str2 == null || !str2.equals(this.bLr.getPicId())) {
                this.bLr.cancel();
            } else {
                return;
            }
        }
        this.bLr = new C0063a(str, str2, i, i2);
        this.bLr.setPriority(3);
        this.bLr.execute(new Object[0]);
    }

    public void a(b bVar) {
        this.bLv = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.image.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0063a extends BdAsyncTask<Object, Integer, c> {
        private v Tv = null;
        private String bLn;
        private String bLx;
        private int bLy;
        private int bLz;

        public C0063a(String str, String str2, int i, int i2) {
            this.bLn = null;
            this.bLx = null;
            this.bLy = 0;
            this.bLz = 0;
            this.bLx = str2;
            this.bLn = str;
            this.bLy = i;
            this.bLz = i2;
        }

        public String getPicId() {
            return this.bLx;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public c doInBackground(Object... objArr) {
            this.Tv = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IMAGE_PB_ADDRESS);
            this.Tv.o("kw", a.this.aUF);
            this.Tv.o("tid", this.bLn);
            if (this.bLx != null) {
                this.Tv.o("pic_id", this.bLx);
            }
            this.Tv.o("next", String.valueOf(this.bLy));
            this.Tv.o("prev", String.valueOf(this.bLz));
            if (!a.this.bLt) {
                this.Tv.o("not_see_lz", String.valueOf(1));
            }
            BdLog.d("mIsReserver=" + a.this.bLq);
            if (!a.this.bLq) {
                this.Tv.o("r", String.valueOf(1));
            }
            this.Tv.uj().uZ().abM = false;
            String tI = this.Tv.tI();
            if (!this.Tv.uj().va().qZ()) {
                return null;
            }
            c cVar = new c();
            cVar.w(tI, true);
            return cVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.Tv != null) {
                this.Tv.gJ();
            }
            a.this.bLr = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(c cVar) {
            boolean z;
            int i;
            int i2;
            String str;
            super.onPostExecute(cVar);
            a.this.bLr = null;
            if (cVar != null) {
                a.this.bLs = cVar.getImageNum();
                a.this.alg = cVar.Zb();
                a.this.bLm = cVar.Za();
                if (this.bLx == null) {
                    a.this.bLl.clear();
                    a.this.bLw.clear();
                }
                LinkedList<com.baidu.tieba.image.b> Zc = cVar.Zc();
                int size = Zc.size();
                if (size <= 0) {
                    a.this.bLp = true;
                } else {
                    for (int i3 = 0; i3 < size; i3++) {
                        String a = a.this.a(Zc.get(i3));
                        String iH = a.this.iH(a);
                        if (!a.this.bLw.containsKey(iH)) {
                            a.this.bLl.add(a);
                            a.this.bLw.put(iH, a);
                        }
                    }
                    com.baidu.tieba.image.b bVar = Zc.get(size - 1);
                    a.this.bLo = bVar.getImageID();
                    if (a.this.bLs == bVar.getIndex()) {
                        a.this.bLp = true;
                    } else {
                        a.this.bLp = false;
                    }
                }
                boolean z2 = a.this.bLp && a.this.bLm != null && a.this.bLm.length() > 0;
                if (this.bLx == null) {
                    a.this.bLn = this.bLn;
                    z = true;
                    i = 0;
                } else {
                    z = false;
                    i = -1;
                }
                if (a.this.bLv != null) {
                    a.this.bLv.a(a.this.bLl, i, a.this.bLs, z2, a.this.alg, z);
                }
            } else if (a.this.bLv != null) {
                if (this.Tv != null) {
                    i2 = this.Tv.un();
                    str = this.bLx == null ? this.Tv.getErrorString() : null;
                } else {
                    i2 = -1;
                    str = null;
                }
                a.this.bLv.D(i2, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(com.baidu.tieba.image.b bVar) {
        if (bVar.Fs() != null && bVar.Fs().length() > 0) {
            return bVar.Fs();
        }
        StringBuilder sb = new StringBuilder((int) SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        if (bVar.getHeight() * bVar.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
            double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bVar.getHeight() * bVar.getWidth()));
            sb.append("width=");
            sb.append(String.valueOf((int) (bVar.getWidth() * sqrt)));
            sb.append("&height=");
            sb.append(String.valueOf((int) (sqrt * bVar.getHeight())));
        } else {
            sb.append("width=");
            sb.append(String.valueOf(bVar.getWidth()));
            sb.append("&height=");
            sb.append(String.valueOf(bVar.getHeight()));
        }
        sb.append("&src=");
        sb.append(aq.aR(bVar.getImageUrl()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String iH(String str) {
        int lastIndexOf;
        int indexOf;
        String aS = aq.aS(str);
        if (aS != null) {
            if (aS.indexOf(".baidu.com") != -1 && (lastIndexOf = aS.lastIndexOf("/")) != -1 && (indexOf = aS.indexOf(".", lastIndexOf)) != -1) {
                return aS.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aS;
    }
}
