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
    private Map<String, ImageUrlData> aHi;
    private String aWq;
    private String dmg;
    private ArrayList<String> eJI;
    private String eJK;
    private boolean eJL;
    private String eJS;
    private String eJT;
    private String eJU;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> eJJ = new HashMap<>();
    private boolean mIsReserver = true;
    private a eJM = null;
    private int eJN = 0;
    private boolean eJO = false;
    private b eJP = null;
    private AdvertAppInfo eJQ = null;
    private boolean eJR = false;

    /* loaded from: classes3.dex */
    public interface b {
        void X(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eJI = null;
        this.aWq = null;
        this.mForumId = null;
        this.dmg = null;
        this.eJK = null;
        this.eJL = false;
        this.mUserId = null;
        this.eJI = arrayList;
        this.aHi = map;
        if (this.eJI == null) {
            this.eJI = new ArrayList<>();
        }
        Iterator<String> it = this.eJI.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.eJJ.put(d.pe(next), next);
        }
        this.aWq = str3;
        this.dmg = str2;
        this.mForumId = str;
        this.eJK = str4;
        this.mThreadType = i;
        this.eJL = this.eJK == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
    }

    public void setSourceImageRectInScreen(String str) {
        this.eJT = str;
    }

    public void ph(String str) {
        this.eJU = str;
    }

    public void ij(boolean z) {
        this.mIsReserver = z;
    }

    public void aPG() {
        this.eJR = false;
        if (!this.eJL) {
            d(this.aWq, this.eJK, 10, 0);
        }
    }

    public void aPH() {
        this.eJR = true;
        d(this.aWq, d.pe(this.eJI.get(0)), 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.eJM != null) {
            if (str2 == null || !str2.equals(this.eJM.getPicId())) {
                this.eJM.cancel();
            } else {
                return;
            }
        }
        this.eJM = new a(str, str2, i, i2);
        this.eJM.setPriority(3);
        this.eJM.execute(new Object[0]);
    }

    public void ik(boolean z) {
        this.eJO = z;
    }

    public void a(b bVar) {
        this.eJP = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private String aWq;
        private int eJV;
        private int eJW;
        private y mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.aWq = null;
            this.mPicId = null;
            this.eJV = 0;
            this.eJW = 0;
            this.mPicId = str2;
            this.aWq = str;
            this.eJV = i;
            this.eJW = i2;
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
            this.mNetWork.o("kw", e.this.dmg);
            this.mNetWork.o("tid", this.aWq);
            if (this.mPicId != null) {
                this.mNetWork.o(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.o("next", String.valueOf(this.eJV));
            this.mNetWork.o("prev", String.valueOf(this.eJW));
            this.mNetWork.o("not_see_lz", String.valueOf(e.this.eJO ? 0 : 1));
            if (!e.this.mIsReserver) {
                this.mNetWork.o("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.o("obj_type", e.this.mFrom);
            }
            if (TextUtils.isEmpty(e.this.eJS)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.eJS = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.o("applist", e.this.eJS);
            aPI();
            this.mNetWork.yM().zK().arS = false;
            String yo = this.mNetWork.yo();
            if (!this.mNetWork.yM().zL().isRequestSuccess()) {
                return null;
            }
            g gVar = new g();
            gVar.G(yo, true);
            return gVar;
        }

        private void aPI() {
            this.mNetWork.o("forum_id", e.this.mForumId);
            this.mNetWork.o("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.o("scr_w", String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("scr_h", String.valueOf(l.aj(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("q_type", String.valueOf(ar.zu().zw() ? 2 : 1));
            this.mNetWork.o("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.o("page_name", "PB");
            this.mNetWork.o("pic_index", String.valueOf(e.this.eJI.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            e.this.eJM = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (e.this.aHi != null) {
                e.this.eJM = null;
                if (gVar == null) {
                    if (e.this.eJP != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.yQ();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.eJP.X(i, str);
                        return;
                    }
                    return;
                }
                boolean z = w.z(gVar.aPO());
                if (e.this.mIsReset && !z) {
                    e.this.eJI.clear();
                    e.this.aHi.clear();
                    e.this.eJJ.clear();
                }
                if (gVar.getImageNum() != 0) {
                    e.this.eJN = gVar.getImageNum();
                }
                e.this.eJQ = gVar.aPP();
                if (this.mPicId == null) {
                    e.this.eJI.clear();
                    e.this.eJJ.clear();
                }
                LinkedList<f> aPO = gVar.aPO();
                int size = aPO.size();
                if (size <= 0) {
                    e.this.eJL = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = aPO.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.aPJ();
                        if (ap.equals(imageUrlData.id, e.this.eJU)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.eJT);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.aPN();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.NU();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.aWq, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(fVar.aPK(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.eJO;
                        imageUrlData.overAllIndex = fVar.aPN();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.aPL();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.aPM();
                        if (e.this.eJJ.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.eJJ.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.aHi.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.aHi.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                if (ap.equals(imageUrlData.id, e.this.eJU)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.eJT);
                                }
                            }
                        } else {
                            e.this.aHi.put(str2, imageUrlData);
                            if (e.this.eJR) {
                                e.this.eJI.add(i2, str2);
                            } else {
                                e.this.eJI.add(str2);
                            }
                            e.this.eJJ.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = aPO.get(size - 1);
                    e.this.eJK = fVar2.aPJ();
                    e.this.eJL = ((long) e.this.eJN) == fVar2.aPN();
                }
                boolean z2 = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.aWq = this.aWq;
                    z2 = true;
                }
                int a2 = e.this.eJR ? w.a(e.this.eJI, (String) e.this.eJJ.get(this.mPicId)) - 1 : i3;
                if (e.this.eJP != null) {
                    e.this.eJP.a(e.this.eJI, a2, e.this.eJN, false, null, z2, e.this.eJQ, z);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.NN() != null && fVar.NN().length() > 0) {
            return fVar.NN();
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
