package com.baidu.tieba.image;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes3.dex */
public class e {
    private Map<String, ImageUrlData> aHj;
    private String aWo;
    private String djs;
    private ArrayList<String> eFT;
    private String eFV;
    private boolean eFW;
    private String eGd;
    private String eGe;
    private String eGf;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> eFU = new HashMap<>();
    private boolean mIsReserver = true;
    private a eFX = null;
    private int eFY = 0;
    private boolean eFZ = false;
    private b eGa = null;
    private AdvertAppInfo eGb = null;
    private boolean eGc = false;

    /* loaded from: classes3.dex */
    public interface b {
        void V(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eFT = null;
        this.aWo = null;
        this.mForumId = null;
        this.djs = null;
        this.eFV = null;
        this.eFW = false;
        this.mUserId = null;
        this.eFT = arrayList;
        this.aHj = map;
        if (this.eFT == null) {
            this.eFT = new ArrayList<>();
        }
        Iterator<String> it = this.eFT.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.eFU.put(d.pa(next), next);
        }
        this.aWo = str3;
        this.djs = str2;
        this.mForumId = str;
        this.eFV = str4;
        this.mThreadType = i;
        this.eFW = this.eFV == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
    }

    public void setSourceImageRectInScreen(String str) {
        this.eGe = str;
    }

    public void pd(String str) {
        this.eGf = str;
    }

    public void ig(boolean z) {
        this.mIsReserver = z;
    }

    public void aOJ() {
        this.eGc = false;
        if (!this.eFW) {
            d(this.aWo, this.eFV, 10, 0);
        }
    }

    public void aOK() {
        this.eGc = true;
        d(this.aWo, d.pa(this.eFT.get(0)), 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.eFX != null) {
            if (str2 == null || !str2.equals(this.eFX.getPicId())) {
                this.eFX.cancel();
            } else {
                return;
            }
        }
        this.eFX = new a(str, str2, i, i2);
        this.eFX.setPriority(3);
        this.eFX.execute(new Object[0]);
    }

    public void ih(boolean z) {
        this.eFZ = z;
    }

    public void a(b bVar) {
        this.eGa = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private String aWo;
        private int eGg;
        private int eGh;
        private y mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.aWo = null;
            this.mPicId = null;
            this.eGg = 0;
            this.eGh = 0;
            this.mPicId = str2;
            this.aWo = str;
            this.eGg = i;
            this.eGh = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public g doInBackground(Object... objArr) {
            this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.mNetWork.o("kw", e.this.djs);
            this.mNetWork.o("tid", this.aWo);
            if (this.mPicId != null) {
                this.mNetWork.o(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.o("next", String.valueOf(this.eGg));
            this.mNetWork.o("prev", String.valueOf(this.eGh));
            this.mNetWork.o("not_see_lz", String.valueOf(e.this.eFZ ? 0 : 1));
            if (!e.this.mIsReserver) {
                this.mNetWork.o("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.o("obj_type", e.this.mFrom);
            }
            if (TextUtils.isEmpty(e.this.eGd)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.eGd = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.o("applist", e.this.eGd);
            aOL();
            this.mNetWork.yX().zX().aso = false;
            String yz = this.mNetWork.yz();
            if (!this.mNetWork.yX().zY().isRequestSuccess()) {
                return null;
            }
            g gVar = new g();
            gVar.H(yz, true);
            return gVar;
        }

        private void aOL() {
            this.mNetWork.o("forum_id", e.this.mForumId);
            this.mNetWork.o("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.o("scr_w", String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("scr_h", String.valueOf(l.aj(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("q_type", String.valueOf(ar.zF().zH() ? 2 : 1));
            this.mNetWork.o("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.o("page_name", "PB");
            this.mNetWork.o("pic_index", String.valueOf(e.this.eFT.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            e.this.eFX = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (e.this.aHj != null) {
                e.this.eFX = null;
                if (gVar == null) {
                    if (e.this.eGa != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.zb();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.eGa.V(i, str);
                        return;
                    }
                    return;
                }
                boolean A = w.A(gVar.aOR());
                if (e.this.mIsReset && !A) {
                    e.this.eFT.clear();
                    e.this.aHj.clear();
                    e.this.eFU.clear();
                }
                if (gVar.getImageNum() != 0) {
                    e.this.eFY = gVar.getImageNum();
                }
                e.this.eGb = gVar.aOS();
                if (this.mPicId == null) {
                    e.this.eFT.clear();
                    e.this.eFU.clear();
                }
                LinkedList<f> aOR = gVar.aOR();
                int size = aOR.size();
                if (size <= 0) {
                    e.this.eFW = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = aOR.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.aOM();
                        if (ap.equals(imageUrlData.id, e.this.eGf)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.eGe);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.aOQ();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.NV();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.aWo, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(fVar.aON(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.eFZ;
                        imageUrlData.overAllIndex = fVar.aOQ();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.aOO();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.aOP();
                        if (e.this.eFU.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.eFU.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.aHj.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.aHj.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                if (ap.equals(imageUrlData.id, e.this.eGf)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.eGe);
                                }
                            }
                        } else {
                            e.this.aHj.put(str2, imageUrlData);
                            if (e.this.eGc) {
                                e.this.eFT.add(i2, str2);
                            } else {
                                e.this.eFT.add(str2);
                            }
                            e.this.eFU.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = aOR.get(size - 1);
                    e.this.eFV = fVar2.aOM();
                    e.this.eFW = ((long) e.this.eFY) == fVar2.aOQ();
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.aWo = this.aWo;
                    z = true;
                }
                int a2 = e.this.eGc ? w.a(e.this.eFT, (String) e.this.eFU.get(this.mPicId)) - 1 : i3;
                if (e.this.eGa != null) {
                    e.this.eGa.a(e.this.eFT, a2, e.this.eFY, false, null, z, e.this.eGb, A);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.NQ() != null && fVar.NQ().length() > 0) {
            return fVar.NQ();
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        int threadImageMaxWidth = TbConfig.getThreadImageMaxWidth();
        if (fVar.getHeight() * fVar.getWidth() > threadImageMaxWidth * threadImageMaxWidth) {
            double sqrt = Math.sqrt((threadImageMaxWidth * threadImageMaxWidth) / (fVar.getHeight() * fVar.getWidth()));
            sb.append("width=");
            sb.append(String.valueOf((int) (fVar.getWidth() * sqrt)));
            sb.append("&height=");
            sb.append(String.valueOf((int) (sqrt * fVar.getHeight())));
        } else {
            sb.append("width=");
            sb.append(String.valueOf(fVar.getWidth()));
            sb.append("&height=");
            sb.append(String.valueOf(fVar.getHeight()));
        }
        sb.append("&src=");
        sb.append(ap.bg(fVar.getImageUrl()));
        return sb.toString();
    }
}
