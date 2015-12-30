package com.baidu.tieba.image;

import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class j {
    Map<String, ImageUrlData> amP;
    private String bde;
    private ArrayList<String> cjC;
    private String cjE;
    private String cjF;
    private boolean cjK;
    private String mForumId;
    private String mFrom;
    private String mUserId;
    private String cjD = null;
    private String amV = null;
    private boolean cjG = false;
    private boolean mIsReserver = true;
    private a cjH = null;
    private int cjI = 0;
    private boolean cjJ = false;
    private b cjL = null;
    private HashMap<String, String> cjM = new HashMap<>();
    private com.baidu.tbadk.core.data.b cjN = null;

    /* loaded from: classes.dex */
    public interface b {
        void G(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, com.baidu.tbadk.core.data.b bVar);
    }

    public j(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6) {
        this.cjC = null;
        this.cjE = null;
        this.mForumId = null;
        this.bde = null;
        this.cjF = null;
        this.cjK = false;
        this.mUserId = null;
        this.cjC = arrayList;
        this.amP = map;
        if (this.cjC == null) {
            this.cjC = new ArrayList<>();
        }
        int size = this.cjC.size();
        for (int i = 0; i < size; i++) {
            String str7 = this.cjC.get(i);
            this.cjM.put(jA(str7), str7);
        }
        this.cjE = str3;
        this.bde = str2;
        this.mForumId = str;
        this.cjF = str4;
        if (this.cjF == null) {
            this.cjK = true;
        }
        this.mUserId = str5;
        this.mFrom = str6;
    }

    public void ee(boolean z) {
        this.mIsReserver = z;
    }

    public void afh() {
        if (!this.cjG && !this.cjK) {
            c(this.cjE, this.cjF, 10, 0);
        }
    }

    public void afi() {
        if (!this.cjK) {
            if (!this.cjG) {
                afh();
            } else if (this.cjD != null && this.cjD.length() > 0) {
                this.mIsReserver = true;
                c(this.cjD, null, 0, 10);
            }
        }
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.cjH != null) {
            if (str2 == null || !str2.equals(this.cjH.getPicId())) {
                this.cjH.cancel();
            } else {
                return;
            }
        }
        this.cjH = new a(str, str2, i, i2);
        this.cjH.setPriority(3);
        this.cjH.execute(new Object[0]);
    }

    public void ef(boolean z) {
        this.cjJ = z;
    }

    public void a(b bVar) {
        this.cjL = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, m> {
        private ab Ua = null;
        private String cjE;
        private String cjO;
        private int cjP;
        private int cjQ;

        public a(String str, String str2, int i, int i2) {
            this.cjE = null;
            this.cjO = null;
            this.cjP = 0;
            this.cjQ = 0;
            this.cjO = str2;
            this.cjE = str;
            this.cjP = i;
            this.cjQ = i2;
        }

        public String getPicId() {
            return this.cjO;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public m doInBackground(Object... objArr) {
            this.Ua = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IMAGE_PB_ADDRESS);
            this.Ua.o("kw", j.this.bde);
            this.Ua.o("tid", this.cjE);
            if (this.cjO != null) {
                this.Ua.o("pic_id", this.cjO);
            }
            this.Ua.o("next", String.valueOf(this.cjP));
            this.Ua.o("prev", String.valueOf(this.cjQ));
            this.Ua.o("not_see_lz", String.valueOf(j.this.cjJ ? 0 : 1));
            BdLog.d("mIsReserver=" + j.this.mIsReserver);
            if (!j.this.mIsReserver) {
                this.Ua.o("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(j.this.mFrom, true)) {
                this.Ua.o("obj_type", j.this.mFrom);
            }
            afj();
            this.Ua.uw().vp().adq = false;
            String tV = this.Ua.tV();
            if (!this.Ua.uw().vq().qO()) {
                return null;
            }
            m mVar = new m();
            mVar.z(tV, true);
            return mVar;
        }

        private void afj() {
            this.Ua.o("forum_id", j.this.mForumId);
            this.Ua.o("user_id", j.this.mUserId == null ? "0" : j.this.mUserId);
            this.Ua.o("scr_w", String.valueOf(com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp())));
            this.Ua.o("scr_h", String.valueOf(com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp())));
            this.Ua.o("q_type", String.valueOf(ay.va().vc() ? 2 : 1));
            this.Ua.o("_os_version", Build.VERSION.RELEASE);
            this.Ua.o("net_type", com.baidu.tbadk.core.util.a.i.getNetType());
            this.Ua.o("page_name", "PB");
            this.Ua.o("pic_index", String.valueOf(j.this.cjC.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.Ua != null) {
                this.Ua.gL();
            }
            j.this.cjH = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(m mVar) {
            int i;
            int i2;
            int i3;
            int i4;
            String str;
            boolean z = true;
            super.onPostExecute(mVar);
            if (j.this.amP != null) {
                j.this.cjH = null;
                if (mVar != null) {
                    j.this.cjI = mVar.getImageNum();
                    j.this.cjN = mVar.afn();
                    if (this.cjO == null) {
                        j.this.cjC.clear();
                        j.this.cjM.clear();
                    }
                    LinkedList<l> afm = mVar.afm();
                    int size = afm.size();
                    if (size <= 0) {
                        j.this.cjG = true;
                        i = 0;
                    } else {
                        for (int i5 = 0; i5 < size; i5++) {
                            l lVar = afm.get(i5);
                            String a = j.this.a(lVar);
                            String jA = j.this.jA(a);
                            if (!j.this.cjM.containsKey(jA)) {
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = a;
                                imageUrlData.urlType = 10;
                                imageUrlData.originalUrl = lVar.FS();
                                imageUrlData.originalSize = lVar.getOriginalSize();
                                imageUrlData.threadId = com.baidu.adp.lib.h.b.c(this.cjE, -1L);
                                imageUrlData.postId = com.baidu.adp.lib.h.b.c(lVar.afk(), -1L);
                                imageUrlData.mIsReserver = j.this.mIsReserver;
                                imageUrlData.mIsSeeHost = j.this.cjJ;
                                imageUrlData.overAllIndex = lVar.afl();
                                j.this.cjC.add(a);
                                j.this.amP.put(a, imageUrlData);
                                j.this.cjM.put(jA, a);
                            }
                        }
                        l lVar2 = afm.get(size - 1);
                        j.this.cjF = lVar2.getImageID();
                        if (j.this.cjI == lVar2.getIndex()) {
                            j.this.cjG = true;
                        } else {
                            j.this.cjG = false;
                        }
                        if (lVar2.afl() <= 0 || lVar2.afl() > j.this.cjI) {
                            i3 = 0;
                        } else {
                            i3 = j.this.mIsReserver ? (com.baidu.tbadk.core.util.y.l(j.this.cjC) + j.this.cjI) - ((int) lVar2.afl()) : (((int) lVar2.afl()) + com.baidu.tbadk.core.util.y.l(j.this.cjC)) - 1;
                        }
                        if (i3 <= 0) {
                            i3 = j.this.cjI;
                        }
                        i = i3;
                    }
                    boolean z2 = j.this.cjG && j.this.cjD != null && j.this.cjD.length() > 0;
                    if (this.cjO == null) {
                        j.this.cjE = this.cjE;
                        i2 = 0;
                    } else {
                        z = false;
                        i2 = -1;
                    }
                    if (j.this.cjL != null) {
                        j.this.cjL.a(j.this.cjC, i2, i, z2, j.this.amV, z, j.this.cjN);
                    }
                } else if (j.this.cjL != null) {
                    if (this.Ua != null) {
                        i4 = this.Ua.uA();
                        str = this.cjO == null ? this.Ua.getErrorString() : null;
                    } else {
                        i4 = -1;
                        str = null;
                    }
                    j.this.cjL.G(i4, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(l lVar) {
        if (lVar.FO() != null && lVar.FO().length() > 0) {
            return lVar.FO();
        }
        StringBuilder sb = new StringBuilder(150);
        if (lVar.getHeight() * lVar.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
            double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (lVar.getHeight() * lVar.getWidth()));
            sb.append("width=");
            sb.append(String.valueOf((int) (lVar.getWidth() * sqrt)));
            sb.append("&height=");
            sb.append(String.valueOf((int) (sqrt * lVar.getHeight())));
        } else {
            sb.append("width=");
            sb.append(String.valueOf(lVar.getWidth()));
            sb.append("&height=");
            sb.append(String.valueOf(lVar.getHeight()));
        }
        sb.append("&src=");
        sb.append(ax.aT(lVar.getImageUrl()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jA(String str) {
        int lastIndexOf;
        int indexOf;
        String aU = ax.aU(str);
        if (aU != null) {
            if (aU.indexOf(".baidu.com") != -1 && (lastIndexOf = aU.lastIndexOf("/")) != -1 && (indexOf = aU.indexOf(".", lastIndexOf)) != -1) {
                return aU.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aU;
    }
}
