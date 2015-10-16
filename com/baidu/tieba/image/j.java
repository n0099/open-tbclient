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
    private String aTM;
    HashMap<String, ImageUrlData> ajT;
    private ArrayList<String> bOQ;
    private String bOS;
    private String bOT;
    private boolean bOZ;
    private String mForumId;
    private String mFrom;
    private String mUserId;
    private String bOR = null;
    private String ajZ = null;
    private boolean bOU = false;
    private boolean bOV = true;
    private a bOW = null;
    private int bOX = 0;
    private boolean bOY = false;
    private b bPa = null;
    private HashMap<String, String> bPb = new HashMap<>();
    private com.baidu.tbadk.core.data.b bPc = null;

    /* loaded from: classes.dex */
    public interface b {
        void F(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, com.baidu.tbadk.core.data.b bVar);
    }

    public j(ArrayList<String> arrayList, HashMap<String, ImageUrlData> hashMap, String str, String str2, String str3, String str4, String str5, String str6) {
        this.bOQ = null;
        this.bOS = null;
        this.mForumId = null;
        this.aTM = null;
        this.bOT = null;
        this.bOZ = false;
        this.mUserId = null;
        this.bOQ = arrayList;
        this.ajT = hashMap;
        if (this.bOQ == null) {
            this.bOQ = new ArrayList<>();
        }
        int size = this.bOQ.size();
        for (int i = 0; i < size; i++) {
            String str7 = this.bOQ.get(i);
            this.bPb.put(iQ(str7), str7);
        }
        this.bOS = str3;
        this.aTM = str2;
        this.mForumId = str;
        this.bOT = str4;
        if (this.bOT == null) {
            this.bOZ = true;
        }
        this.mUserId = str5;
        this.mFrom = str6;
    }

    public void dE(boolean z) {
        this.bOV = z;
    }

    public void aad() {
        if (!this.bOU && !this.bOZ) {
            c(this.bOS, this.bOT, 10, 0);
        }
    }

    public void aae() {
        if (!this.bOZ) {
            if (!this.bOU) {
                aad();
            } else if (this.bOR != null && this.bOR.length() > 0) {
                this.bOV = true;
                c(this.bOR, null, 0, 10);
            }
        }
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.bOW != null) {
            if (str2 == null || !str2.equals(this.bOW.getPicId())) {
                this.bOW.cancel();
            } else {
                return;
            }
        }
        this.bOW = new a(str, str2, i, i2);
        this.bOW.setPriority(3);
        this.bOW.execute(new Object[0]);
    }

    public void a(b bVar) {
        this.bPa = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, m> {
        private com.baidu.tbadk.core.util.w Ti = null;
        private String bOS;
        private String bPd;
        private int bPe;
        private int bPf;

        public a(String str, String str2, int i, int i2) {
            this.bOS = null;
            this.bPd = null;
            this.bPe = 0;
            this.bPf = 0;
            this.bPd = str2;
            this.bOS = str;
            this.bPe = i;
            this.bPf = i2;
        }

        public String getPicId() {
            return this.bPd;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public m doInBackground(Object... objArr) {
            this.Ti = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IMAGE_PB_ADDRESS);
            this.Ti.o("kw", j.this.aTM);
            this.Ti.o("tid", this.bOS);
            if (this.bPd != null) {
                this.Ti.o("pic_id", this.bPd);
            }
            this.Ti.o("next", String.valueOf(this.bPe));
            this.Ti.o("prev", String.valueOf(this.bPf));
            if (!j.this.bOY) {
                this.Ti.o("not_see_lz", String.valueOf(1));
            }
            BdLog.d("mIsReserver=" + j.this.bOV);
            if (!j.this.bOV) {
                this.Ti.o("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(j.this.mFrom, true)) {
                this.Ti.o("obj_type", j.this.mFrom);
            }
            aaf();
            this.Ti.uh().uY().abO = false;
            String tG = this.Ti.tG();
            if (!this.Ti.uh().uZ().qV()) {
                return null;
            }
            m mVar = new m();
            mVar.y(tG, true);
            return mVar;
        }

        private void aaf() {
            this.Ti.o("forum_id", j.this.mForumId);
            this.Ti.o("user_id", j.this.mUserId == null ? "0" : j.this.mUserId);
            this.Ti.o("scr_w", String.valueOf(com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp())));
            this.Ti.o("scr_h", String.valueOf(com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp())));
            this.Ti.o("q_type", String.valueOf(at.uJ().uL() ? 2 : 1));
            this.Ti.o("_os_version", Build.VERSION.RELEASE);
            this.Ti.o("net_type", com.baidu.tbadk.core.util.a.i.getNetType());
            this.Ti.o("page_name", "PB");
            this.Ti.o("pic_index", String.valueOf(j.this.bOQ.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.Ti != null) {
                this.Ti.gJ();
            }
            j.this.bOW = null;
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
            j.this.bOW = null;
            if (mVar != null) {
                j.this.bOX = mVar.getImageNum();
                j.this.bPc = mVar.aah();
                if (this.bPd == null) {
                    j.this.bOQ.clear();
                    j.this.bPb.clear();
                }
                LinkedList<l> aag = mVar.aag();
                int size = aag.size();
                if (size <= 0) {
                    j.this.bOU = true;
                } else {
                    for (int i3 = 0; i3 < size; i3++) {
                        l lVar = aag.get(i3);
                        String a = j.this.a(lVar);
                        String iQ = j.this.iQ(a);
                        if (!j.this.bPb.containsKey(iQ)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = a;
                            imageUrlData.urlType = 10;
                            imageUrlData.originalUrl = lVar.Fj();
                            imageUrlData.originalSize = lVar.getOriginalSize();
                            j.this.bOQ.add(a);
                            j.this.ajT.put(a, imageUrlData);
                            j.this.bPb.put(iQ, a);
                        }
                    }
                    l lVar2 = aag.get(size - 1);
                    j.this.bOT = lVar2.getImageID();
                    if (j.this.bOX == lVar2.getIndex()) {
                        j.this.bOU = true;
                    } else {
                        j.this.bOU = false;
                    }
                }
                boolean z2 = j.this.bOU && j.this.bOR != null && j.this.bOR.length() > 0;
                if (this.bPd == null) {
                    j.this.bOS = this.bOS;
                    z = true;
                    i = 0;
                } else {
                    z = false;
                    i = -1;
                }
                if (j.this.bPa != null) {
                    j.this.bPa.a(j.this.bOQ, i, j.this.bOX, z2, j.this.ajZ, z, j.this.bPc);
                }
            } else if (j.this.bPa != null) {
                if (this.Ti != null) {
                    i2 = this.Ti.ul();
                    str = this.bPd == null ? this.Ti.getErrorString() : null;
                } else {
                    i2 = -1;
                    str = null;
                }
                j.this.bPa.F(i2, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(l lVar) {
        if (lVar.Ff() != null && lVar.Ff().length() > 0) {
            return lVar.Ff();
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
        sb.append(as.aR(lVar.getImageUrl()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String iQ(String str) {
        int lastIndexOf;
        int indexOf;
        String aS = as.aS(str);
        if (aS != null) {
            if (aS.indexOf(".baidu.com") != -1 && (lastIndexOf = aS.lastIndexOf("/")) != -1 && (indexOf = aS.indexOf(".", lastIndexOf)) != -1) {
                return aS.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aS;
    }
}
