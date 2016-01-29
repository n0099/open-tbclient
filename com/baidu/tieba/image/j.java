package com.baidu.tieba.image;

import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class j {
    private String aer;
    Map<String, ImageUrlData> anI;
    private String bfv;
    private ArrayList<String> coc;
    private String coe;
    private String cof;
    private boolean cok;
    private String mForumId;
    private int mThreadType;
    private String mUserId;
    private String cod = null;
    private String anO = null;
    private boolean cog = false;
    private boolean mIsReserver = true;
    private a coh = null;
    private int coi = 0;
    private boolean coj = false;
    private b col = null;

    /* renamed from: com  reason: collision with root package name */
    private HashMap<String, String> f127com = new HashMap<>();
    private com.baidu.tbadk.core.data.c con = null;
    private boolean coo = false;

    /* loaded from: classes.dex */
    public interface b {
        void I(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, com.baidu.tbadk.core.data.c cVar);
    }

    public j(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.coc = null;
        this.coe = null;
        this.mForumId = null;
        this.bfv = null;
        this.cof = null;
        this.cok = false;
        this.mUserId = null;
        this.coc = arrayList;
        this.anI = map;
        if (this.coc == null) {
            this.coc = new ArrayList<>();
        }
        int size = this.coc.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str7 = this.coc.get(i2);
            this.f127com.put(jF(str7), str7);
        }
        this.coe = str3;
        this.bfv = str2;
        this.mForumId = str;
        this.cof = str4;
        this.mThreadType = i;
        if (this.cof == null) {
            this.cok = true;
        }
        this.mUserId = str5;
        this.aer = str6;
    }

    public void el(boolean z) {
        this.mIsReserver = z;
    }

    public void aiq() {
        this.coo = false;
        if (!this.cog && !this.cok) {
            c(this.coe, this.cof, 10, 0);
        }
    }

    public void air() {
        this.coo = true;
        c(this.coe, jF(this.coc.get(0)), 0, 10);
    }

    public void ais() {
        if (!this.cok) {
            if (!this.cog) {
                aiq();
            } else if (this.cod != null && this.cod.length() > 0) {
                this.mIsReserver = true;
                c(this.cod, null, 0, 10);
            }
        }
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.coh != null) {
            if (str2 == null || !str2.equals(this.coh.getPicId())) {
                this.coh.cancel();
            } else {
                return;
            }
        }
        this.coh = new a(str, str2, i, i2);
        this.coh.setPriority(3);
        this.coh.execute(new Object[0]);
    }

    public void em(boolean z) {
        this.coj = z;
    }

    public void a(b bVar) {
        this.col = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, l> {
        private aa Ty = null;
        private String coe;
        private String cop;
        private int coq;
        private int cor;

        public a(String str, String str2, int i, int i2) {
            this.coe = null;
            this.cop = null;
            this.coq = 0;
            this.cor = 0;
            this.cop = str2;
            this.coe = str;
            this.coq = i;
            this.cor = i2;
        }

        public String getPicId() {
            return this.cop;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public l doInBackground(Object... objArr) {
            this.Ty = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IMAGE_PB_ADDRESS);
            this.Ty.p("kw", j.this.bfv);
            this.Ty.p("tid", this.coe);
            if (this.cop != null) {
                this.Ty.p("pic_id", this.cop);
            }
            this.Ty.p("next", String.valueOf(this.coq));
            this.Ty.p("prev", String.valueOf(this.cor));
            this.Ty.p("not_see_lz", String.valueOf(j.this.coj ? 0 : 1));
            BdLog.d("mIsReserver=" + j.this.mIsReserver);
            if (!j.this.mIsReserver) {
                this.Ty.p("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(j.this.aer, true)) {
                this.Ty.p("obj_type", j.this.aer);
            }
            ait();
            this.Ty.vB().wv().adM = false;
            String uZ = this.Ty.uZ();
            if (!this.Ty.vB().ww().rl()) {
                return null;
            }
            l lVar = new l();
            lVar.z(uZ, true);
            return lVar;
        }

        private void ait() {
            this.Ty.p("forum_id", j.this.mForumId);
            this.Ty.p("user_id", j.this.mUserId == null ? "0" : j.this.mUserId);
            this.Ty.p("scr_w", String.valueOf(com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp())));
            this.Ty.p("scr_h", String.valueOf(com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp())));
            this.Ty.p("q_type", String.valueOf(ax.wg().wi() ? 2 : 1));
            this.Ty.p("_os_version", Build.VERSION.RELEASE);
            this.Ty.p("net_type", com.baidu.tbadk.core.util.a.j.getNetType());
            this.Ty.p("page_name", "PB");
            this.Ty.p("pic_index", String.valueOf(j.this.coc.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.Ty != null) {
                this.Ty.gT();
            }
            j.this.coh = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(l lVar) {
            boolean z;
            int i;
            String str = null;
            int i2 = 0;
            super.onPostExecute(lVar);
            if (j.this.anI != null) {
                j.this.coh = null;
                if (lVar != null) {
                    j.this.coi = lVar.getImageNum();
                    j.this.con = lVar.aix();
                    if (this.cop == null) {
                        j.this.coc.clear();
                        j.this.f127com.clear();
                    }
                    LinkedList<k> aiw = lVar.aiw();
                    int size = aiw.size();
                    if (size <= 0) {
                        j.this.cog = true;
                    } else {
                        for (int i3 = 0; i3 < size; i3++) {
                            k kVar = aiw.get(i3);
                            String a = j.this.a(kVar);
                            String jF = j.this.jF(a);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = a;
                            imageUrlData.urlType = 10;
                            imageUrlData.originalUrl = kVar.Hk();
                            imageUrlData.originalSize = kVar.getOriginalSize();
                            imageUrlData.threadId = com.baidu.adp.lib.h.b.c(this.coe, -1L);
                            imageUrlData.postId = com.baidu.adp.lib.h.b.c(kVar.aiu(), -1L);
                            imageUrlData.mIsReserver = j.this.mIsReserver;
                            imageUrlData.mIsSeeHost = j.this.coj;
                            imageUrlData.overAllIndex = kVar.aiv();
                            imageUrlData.mThreadType = j.this.mThreadType;
                            if (j.this.f127com.containsKey(jF)) {
                                String str2 = (String) j.this.f127com.get(jF);
                                ImageUrlData imageUrlData2 = j.this.anI.get(str2);
                                if (imageUrlData2 == null) {
                                    j.this.anI.put(str2, imageUrlData);
                                } else {
                                    imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                }
                            } else {
                                j.this.anI.put(a, imageUrlData);
                                if (j.this.coo) {
                                    j.this.coc.add(i3, a);
                                } else {
                                    j.this.coc.add(a);
                                }
                                j.this.f127com.put(jF, a);
                            }
                        }
                        k kVar2 = aiw.get(size - 1);
                        j.this.cof = kVar2.getImageID();
                        if (j.this.coi == kVar2.getIndex()) {
                            j.this.cog = true;
                        } else {
                            j.this.cog = false;
                        }
                    }
                    boolean z2 = j.this.cog && j.this.cod != null && j.this.cod.length() > 0;
                    if (this.cop == null) {
                        j.this.coe = this.coe;
                        z = true;
                    } else {
                        z = false;
                        i2 = -1;
                    }
                    int a2 = j.this.coo ? com.baidu.tbadk.core.util.x.a(j.this.coc, (String) j.this.f127com.get(this.cop)) - 1 : i2;
                    if (j.this.col != null) {
                        j.this.col.a(j.this.coc, a2, j.this.coi, z2, j.this.anO, z, j.this.con);
                    }
                } else if (j.this.col != null) {
                    if (this.Ty != null) {
                        i = this.Ty.vF();
                        if (this.cop == null) {
                            str = this.Ty.getErrorString();
                        }
                    } else {
                        i = -1;
                    }
                    j.this.col.I(i, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(k kVar) {
        if (kVar.Hg() != null && kVar.Hg().length() > 0) {
            return kVar.Hg();
        }
        StringBuilder sb = new StringBuilder(150);
        if (kVar.getHeight() * kVar.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
            double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (kVar.getHeight() * kVar.getWidth()));
            sb.append("width=");
            sb.append(String.valueOf((int) (kVar.getWidth() * sqrt)));
            sb.append("&height=");
            sb.append(String.valueOf((int) (sqrt * kVar.getHeight())));
        } else {
            sb.append("width=");
            sb.append(String.valueOf(kVar.getWidth()));
            sb.append("&height=");
            sb.append(String.valueOf(kVar.getHeight()));
        }
        sb.append("&src=");
        sb.append(aw.aS(kVar.getImageUrl()));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jF(String str) {
        int lastIndexOf;
        int indexOf;
        String aT = aw.aT(str);
        if (aT != null) {
            if (aT.indexOf(".baidu.com") != -1 && (lastIndexOf = aT.lastIndexOf("/")) != -1 && (indexOf = aT.indexOf(".", lastIndexOf)) != -1) {
                return aT.substring(lastIndexOf + 1, indexOf);
            }
            return null;
        }
        return aT;
    }
}
