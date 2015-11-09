package com.baidu.tieba.image;

import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class j {
    private String aTU;
    HashMap<String, ImageUrlData> ajY;
    private ArrayList<String> bPl;
    private String bPn;
    private String bPo;
    private boolean bPu;
    private String mForumId;
    private String mFrom;
    private String mUserId;
    private String bPm = null;
    private String ake = null;
    private boolean bPp = false;
    private boolean bPq = true;
    private a bPr = null;
    private int bPs = 0;
    private boolean bPt = false;
    private b bPv = null;
    private HashMap<String, String> bPw = new HashMap<>();
    private com.baidu.tbadk.core.data.b bPx = null;

    /* loaded from: classes.dex */
    public interface b {
        void F(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, com.baidu.tbadk.core.data.b bVar);
    }

    public j(ArrayList<String> arrayList, HashMap<String, ImageUrlData> hashMap, String str, String str2, String str3, String str4, String str5, String str6) {
        this.bPl = null;
        this.bPn = null;
        this.mForumId = null;
        this.aTU = null;
        this.bPo = null;
        this.bPu = false;
        this.mUserId = null;
        this.bPl = arrayList;
        this.ajY = hashMap;
        if (this.bPl == null) {
            this.bPl = new ArrayList<>();
        }
        int size = this.bPl.size();
        for (int i = 0; i < size; i++) {
            String str7 = this.bPl.get(i);
            this.bPw.put(iS(str7), str7);
        }
        this.bPn = str3;
        this.aTU = str2;
        this.mForumId = str;
        this.bPo = str4;
        if (this.bPo == null) {
            this.bPu = true;
        }
        this.mUserId = str5;
        this.mFrom = str6;
    }

    public void dG(boolean z) {
        this.bPq = z;
    }

    public void aau() {
        if (!this.bPp && !this.bPu) {
            c(this.bPn, this.bPo, 10, 0);
        }
    }

    public void aav() {
        if (!this.bPu) {
            if (!this.bPp) {
                aau();
            } else if (this.bPm != null && this.bPm.length() > 0) {
                this.bPq = true;
                c(this.bPm, null, 0, 10);
            }
        }
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.bPr != null) {
            if (str2 == null || !str2.equals(this.bPr.getPicId())) {
                this.bPr.cancel();
            } else {
                return;
            }
        }
        this.bPr = new a(str, str2, i, i2);
        this.bPr.setPriority(3);
        this.bPr.execute(new Object[0]);
    }

    public void a(b bVar) {
        this.bPv = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, m> {
        private com.baidu.tbadk.core.util.w Tj = null;
        private int bPA;
        private String bPn;
        private String bPy;
        private int bPz;

        public a(String str, String str2, int i, int i2) {
            this.bPn = null;
            this.bPy = null;
            this.bPz = 0;
            this.bPA = 0;
            this.bPy = str2;
            this.bPn = str;
            this.bPz = i;
            this.bPA = i2;
        }

        public String getPicId() {
            return this.bPy;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public m doInBackground(Object... objArr) {
            this.Tj = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IMAGE_PB_ADDRESS);
            this.Tj.o("kw", j.this.aTU);
            this.Tj.o("tid", this.bPn);
            if (this.bPy != null) {
                this.Tj.o("pic_id", this.bPy);
            }
            this.Tj.o("next", String.valueOf(this.bPz));
            this.Tj.o("prev", String.valueOf(this.bPA));
            if (!j.this.bPt) {
                this.Tj.o("not_see_lz", String.valueOf(1));
            }
            BdLog.d("mIsReserver=" + j.this.bPq);
            if (!j.this.bPq) {
                this.Tj.o("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(j.this.mFrom, true)) {
                this.Tj.o("obj_type", j.this.mFrom);
            }
            aaw();
            this.Tj.uh().uZ().abT = false;
            String tG = this.Tj.tG();
            if (!this.Tj.uh().va().qT()) {
                return null;
            }
            m mVar = new m();
            mVar.y(tG, true);
            return mVar;
        }

        private void aaw() {
            this.Tj.o("forum_id", j.this.mForumId);
            this.Tj.o("user_id", j.this.mUserId == null ? "0" : j.this.mUserId);
            this.Tj.o("scr_w", String.valueOf(com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp())));
            this.Tj.o("scr_h", String.valueOf(com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp())));
            this.Tj.o("q_type", String.valueOf(at.uK().uM() ? 2 : 1));
            this.Tj.o("_os_version", Build.VERSION.RELEASE);
            this.Tj.o("net_type", com.baidu.tbadk.core.util.a.i.getNetType());
            this.Tj.o("page_name", "PB");
            this.Tj.o("pic_index", String.valueOf(j.this.bPl.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.Tj != null) {
                this.Tj.gJ();
            }
            j.this.bPr = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(m mVar) {
            boolean z;
            int i;
            int i2;
            String str;
            super.onPostExecute(mVar);
            j.this.bPr = null;
            if (mVar != null) {
                j.this.bPs = mVar.getImageNum();
                j.this.bPx = mVar.aay();
                if (this.bPy == null) {
                    j.this.bPl.clear();
                    j.this.bPw.clear();
                }
                LinkedList<l> aax = mVar.aax();
                int size = aax.size();
                if (size <= 0) {
                    j.this.bPp = true;
                } else {
                    for (int i3 = 0; i3 < size; i3++) {
                        l lVar = aax.get(i3);
                        String a = j.this.a(lVar);
                        String iS = j.this.iS(a);
                        if (!j.this.bPw.containsKey(iS)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = a;
                            imageUrlData.urlType = 10;
                            imageUrlData.originalUrl = lVar.Fa();
                            imageUrlData.originalSize = lVar.getOriginalSize();
                            j.this.bPl.add(a);
                            j.this.ajY.put(a, imageUrlData);
                            j.this.bPw.put(iS, a);
                        }
                    }
                    l lVar2 = aax.get(size - 1);
                    j.this.bPo = lVar2.getImageID();
                    if (j.this.bPs == lVar2.getIndex()) {
                        j.this.bPp = true;
                    } else {
                        j.this.bPp = false;
                    }
                }
                boolean z2 = j.this.bPp && j.this.bPm != null && j.this.bPm.length() > 0;
                if (this.bPy == null) {
                    j.this.bPn = this.bPn;
                    z = true;
                    i = 0;
                } else {
                    z = false;
                    i = -1;
                }
                if (j.this.bPv != null) {
                    j.this.bPv.a(j.this.bPl, i, j.this.bPs, z2, j.this.ake, z, j.this.bPx);
                }
            } else if (j.this.bPv != null) {
                if (this.Tj != null) {
                    i2 = this.Tj.ul();
                    str = this.bPy == null ? this.Tj.getErrorString() : null;
                } else {
                    i2 = -1;
                    str = null;
                }
                j.this.bPv.F(i2, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(l lVar) {
        if (lVar.EW() != null && lVar.EW().length() > 0) {
            return lVar.EW();
        }
        StringBuilder sb = new StringBuilder((int) SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
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
        sb.append(as.aP(lVar.getImageUrl()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String iS(String str) {
        int lastIndexOf;
        int indexOf;
        String aQ = as.aQ(str);
        if (aQ != null) {
            if (aQ.indexOf(".baidu.com") != -1 && (lastIndexOf = aQ.lastIndexOf("/")) != -1 && (indexOf = aQ.indexOf(".", lastIndexOf)) != -1) {
                return aQ.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aQ;
    }
}
