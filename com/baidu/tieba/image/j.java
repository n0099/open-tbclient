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
/* loaded from: classes.dex */
public class j {
    private String aZi;
    HashMap<String, ImageUrlData> alJ;
    private String cfA;
    private String cfB;
    private boolean cfH;
    private ArrayList<String> cfy;
    private String mForumId;
    private String mFrom;
    private String mUserId;
    private String cfz = null;
    private String alP = null;
    private boolean cfC = false;
    private boolean cfD = true;
    private a cfE = null;
    private int cfF = 0;
    private boolean cfG = false;
    private b cfI = null;
    private HashMap<String, String> cfJ = new HashMap<>();
    private com.baidu.tbadk.core.data.b cfK = null;

    /* loaded from: classes.dex */
    public interface b {
        void G(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, com.baidu.tbadk.core.data.b bVar);
    }

    public j(ArrayList<String> arrayList, HashMap<String, ImageUrlData> hashMap, String str, String str2, String str3, String str4, String str5, String str6) {
        this.cfy = null;
        this.cfA = null;
        this.mForumId = null;
        this.aZi = null;
        this.cfB = null;
        this.cfH = false;
        this.mUserId = null;
        this.cfy = arrayList;
        this.alJ = hashMap;
        if (this.cfy == null) {
            this.cfy = new ArrayList<>();
        }
        int size = this.cfy.size();
        for (int i = 0; i < size; i++) {
            String str7 = this.cfy.get(i);
            this.cfJ.put(jm(str7), str7);
        }
        this.cfA = str3;
        this.aZi = str2;
        this.mForumId = str;
        this.cfB = str4;
        if (this.cfB == null) {
            this.cfH = true;
        }
        this.mUserId = str5;
        this.mFrom = str6;
    }

    public void ee(boolean z) {
        this.cfD = z;
    }

    public void aea() {
        if (!this.cfC && !this.cfH) {
            c(this.cfA, this.cfB, 10, 0);
        }
    }

    public void aeb() {
        if (!this.cfH) {
            if (!this.cfC) {
                aea();
            } else if (this.cfz != null && this.cfz.length() > 0) {
                this.cfD = true;
                c(this.cfz, null, 0, 10);
            }
        }
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.cfE != null) {
            if (str2 == null || !str2.equals(this.cfE.getPicId())) {
                this.cfE.cancel();
            } else {
                return;
            }
        }
        this.cfE = new a(str, str2, i, i2);
        this.cfE.setPriority(3);
        this.cfE.execute(new Object[0]);
    }

    public void ef(boolean z) {
        this.cfG = z;
    }

    public void a(b bVar) {
        this.cfI = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, m> {
        private ab Ty = null;
        private String cfA;
        private String cfL;
        private int cfM;
        private int cfN;

        public a(String str, String str2, int i, int i2) {
            this.cfA = null;
            this.cfL = null;
            this.cfM = 0;
            this.cfN = 0;
            this.cfL = str2;
            this.cfA = str;
            this.cfM = i;
            this.cfN = i2;
        }

        public String getPicId() {
            return this.cfL;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public m doInBackground(Object... objArr) {
            this.Ty = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IMAGE_PB_ADDRESS);
            this.Ty.o("kw", j.this.aZi);
            this.Ty.o("tid", this.cfA);
            if (this.cfL != null) {
                this.Ty.o("pic_id", this.cfL);
            }
            this.Ty.o("next", String.valueOf(this.cfM));
            this.Ty.o("prev", String.valueOf(this.cfN));
            this.Ty.o("not_see_lz", String.valueOf(j.this.cfG ? 0 : 1));
            BdLog.d("mIsReserver=" + j.this.cfD);
            if (!j.this.cfD) {
                this.Ty.o("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(j.this.mFrom, true)) {
                this.Ty.o("obj_type", j.this.mFrom);
            }
            aec();
            this.Ty.uM().vF().acL = false;
            String ul = this.Ty.ul();
            if (!this.Ty.uM().vG().rf()) {
                return null;
            }
            m mVar = new m();
            mVar.A(ul, true);
            return mVar;
        }

        private void aec() {
            this.Ty.o("forum_id", j.this.mForumId);
            this.Ty.o("user_id", j.this.mUserId == null ? "0" : j.this.mUserId);
            this.Ty.o("scr_w", String.valueOf(com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp())));
            this.Ty.o("scr_h", String.valueOf(com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp())));
            this.Ty.o("q_type", String.valueOf(ay.vq().vs() ? 2 : 1));
            this.Ty.o("_os_version", Build.VERSION.RELEASE);
            this.Ty.o("net_type", com.baidu.tbadk.core.util.a.i.getNetType());
            this.Ty.o("page_name", "PB");
            this.Ty.o("pic_index", String.valueOf(j.this.cfy.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.Ty != null) {
                this.Ty.gL();
            }
            j.this.cfE = null;
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
            j.this.cfE = null;
            if (mVar != null) {
                j.this.cfF = mVar.getImageNum();
                j.this.cfK = mVar.aee();
                if (this.cfL == null) {
                    j.this.cfy.clear();
                    j.this.cfJ.clear();
                }
                LinkedList<l> aed = mVar.aed();
                int size = aed.size();
                if (size <= 0) {
                    j.this.cfC = true;
                } else {
                    for (int i3 = 0; i3 < size; i3++) {
                        l lVar = aed.get(i3);
                        String a = j.this.a(lVar);
                        String jm = j.this.jm(a);
                        if (!j.this.cfJ.containsKey(jm)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = a;
                            imageUrlData.urlType = 10;
                            imageUrlData.originalUrl = lVar.Gd();
                            imageUrlData.originalSize = lVar.getOriginalSize();
                            j.this.cfy.add(a);
                            j.this.alJ.put(a, imageUrlData);
                            j.this.cfJ.put(jm, a);
                        }
                    }
                    l lVar2 = aed.get(size - 1);
                    j.this.cfB = lVar2.getImageID();
                    if (j.this.cfF == lVar2.getIndex()) {
                        j.this.cfC = true;
                    } else {
                        j.this.cfC = false;
                    }
                }
                boolean z2 = j.this.cfC && j.this.cfz != null && j.this.cfz.length() > 0;
                if (this.cfL == null) {
                    j.this.cfA = this.cfA;
                    z = true;
                    i = 0;
                } else {
                    z = false;
                    i = -1;
                }
                if (j.this.cfI != null) {
                    j.this.cfI.a(j.this.cfy, i, j.this.cfF, z2, j.this.alP, z, j.this.cfK);
                }
            } else if (j.this.cfI != null) {
                if (this.Ty != null) {
                    i2 = this.Ty.uQ();
                    str = this.cfL == null ? this.Ty.getErrorString() : null;
                } else {
                    i2 = -1;
                    str = null;
                }
                j.this.cfI.G(i2, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(l lVar) {
        if (lVar.FZ() != null && lVar.FZ().length() > 0) {
            return lVar.FZ();
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
    public String jm(String str) {
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
