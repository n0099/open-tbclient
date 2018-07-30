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
    private String aWq;
    private String dmi;
    private ArrayList<String> eJN;
    private String eJP;
    private boolean eJQ;
    private String eJX;
    private String eJY;
    private String eJZ;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> eJO = new HashMap<>();
    private boolean mIsReserver = true;
    private a eJR = null;
    private int eJS = 0;
    private boolean eJT = false;
    private b eJU = null;
    private AdvertAppInfo eJV = null;
    private boolean eJW = false;

    /* loaded from: classes3.dex */
    public interface b {
        void X(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eJN = null;
        this.aWq = null;
        this.mForumId = null;
        this.dmi = null;
        this.eJP = null;
        this.eJQ = false;
        this.mUserId = null;
        this.eJN = arrayList;
        this.aHj = map;
        if (this.eJN == null) {
            this.eJN = new ArrayList<>();
        }
        Iterator<String> it = this.eJN.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.eJO.put(d.pc(next), next);
        }
        this.aWq = str3;
        this.dmi = str2;
        this.mForumId = str;
        this.eJP = str4;
        this.mThreadType = i;
        this.eJQ = this.eJP == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
    }

    public void setSourceImageRectInScreen(String str) {
        this.eJY = str;
    }

    public void pf(String str) {
        this.eJZ = str;
    }

    public void ij(boolean z) {
        this.mIsReserver = z;
    }

    public void aPJ() {
        this.eJW = false;
        if (!this.eJQ) {
            d(this.aWq, this.eJP, 10, 0);
        }
    }

    public void aPK() {
        this.eJW = true;
        d(this.aWq, d.pc(this.eJN.get(0)), 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.eJR != null) {
            if (str2 == null || !str2.equals(this.eJR.getPicId())) {
                this.eJR.cancel();
            } else {
                return;
            }
        }
        this.eJR = new a(str, str2, i, i2);
        this.eJR.setPriority(3);
        this.eJR.execute(new Object[0]);
    }

    public void ik(boolean z) {
        this.eJT = z;
    }

    public void a(b bVar) {
        this.eJU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private String aWq;
        private int eKa;
        private int eKb;
        private y mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.aWq = null;
            this.mPicId = null;
            this.eKa = 0;
            this.eKb = 0;
            this.mPicId = str2;
            this.aWq = str;
            this.eKa = i;
            this.eKb = i2;
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
            this.mNetWork.o("kw", e.this.dmi);
            this.mNetWork.o("tid", this.aWq);
            if (this.mPicId != null) {
                this.mNetWork.o(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.o("next", String.valueOf(this.eKa));
            this.mNetWork.o("prev", String.valueOf(this.eKb));
            this.mNetWork.o("not_see_lz", String.valueOf(e.this.eJT ? 0 : 1));
            if (!e.this.mIsReserver) {
                this.mNetWork.o("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.o("obj_type", e.this.mFrom);
            }
            if (TextUtils.isEmpty(e.this.eJX)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.eJX = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.o("applist", e.this.eJX);
            aPL();
            this.mNetWork.yO().zM().arR = false;
            String yq = this.mNetWork.yq();
            if (!this.mNetWork.yO().zN().isRequestSuccess()) {
                return null;
            }
            g gVar = new g();
            gVar.G(yq, true);
            return gVar;
        }

        private void aPL() {
            this.mNetWork.o("forum_id", e.this.mForumId);
            this.mNetWork.o("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.o("scr_w", String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("scr_h", String.valueOf(l.aj(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("q_type", String.valueOf(ar.zw().zy() ? 2 : 1));
            this.mNetWork.o("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.o("page_name", "PB");
            this.mNetWork.o("pic_index", String.valueOf(e.this.eJN.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            e.this.eJR = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (e.this.aHj != null) {
                e.this.eJR = null;
                if (gVar == null) {
                    if (e.this.eJU != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.yS();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.eJU.X(i, str);
                        return;
                    }
                    return;
                }
                boolean z = w.z(gVar.aPR());
                if (e.this.mIsReset && !z) {
                    e.this.eJN.clear();
                    e.this.aHj.clear();
                    e.this.eJO.clear();
                }
                if (gVar.getImageNum() != 0) {
                    e.this.eJS = gVar.getImageNum();
                }
                e.this.eJV = gVar.aPS();
                if (this.mPicId == null) {
                    e.this.eJN.clear();
                    e.this.eJO.clear();
                }
                LinkedList<f> aPR = gVar.aPR();
                int size = aPR.size();
                if (size <= 0) {
                    e.this.eJQ = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = aPR.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.aPM();
                        if (ap.equals(imageUrlData.id, e.this.eJZ)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.eJY);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.aPQ();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.NV();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.aWq, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(fVar.aPN(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.eJT;
                        imageUrlData.overAllIndex = fVar.aPQ();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.aPO();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.aPP();
                        if (e.this.eJO.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.eJO.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.aHj.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.aHj.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                if (ap.equals(imageUrlData.id, e.this.eJZ)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.eJY);
                                }
                            }
                        } else {
                            e.this.aHj.put(str2, imageUrlData);
                            if (e.this.eJW) {
                                e.this.eJN.add(i2, str2);
                            } else {
                                e.this.eJN.add(str2);
                            }
                            e.this.eJO.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = aPR.get(size - 1);
                    e.this.eJP = fVar2.aPM();
                    e.this.eJQ = ((long) e.this.eJS) == fVar2.aPQ();
                }
                boolean z2 = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.aWq = this.aWq;
                    z2 = true;
                }
                int a2 = e.this.eJW ? w.a(e.this.eJN, (String) e.this.eJO.get(this.mPicId)) - 1 : i3;
                if (e.this.eJU != null) {
                    e.this.eJU.a(e.this.eJN, a2, e.this.eJS, false, null, z2, e.this.eJV, z);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.NO() != null && fVar.NO().length() > 0) {
            return fVar.NO();
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
        sb.append(ap.bh(fVar.getImageUrl()));
        return sb.toString();
    }
}
