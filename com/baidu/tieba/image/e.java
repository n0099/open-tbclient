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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes3.dex */
public class e {
    private Map<String, ImageUrlData> aKw;
    private String aZG;
    private String dsd;
    private ArrayList<String> eQY;
    private String eRa;
    private boolean eRb;
    private String eRi;
    private String eRj;
    private String eRk;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> eQZ = new HashMap<>();
    private boolean mIsReserver = true;
    private a eRc = null;
    private int eRd = 0;
    private boolean eRe = false;
    private b eRf = null;
    private AdvertAppInfo eRg = null;
    private boolean eRh = false;

    /* loaded from: classes3.dex */
    public interface b {
        void X(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eQY = null;
        this.aZG = null;
        this.mForumId = null;
        this.dsd = null;
        this.eRa = null;
        this.eRb = false;
        this.mUserId = null;
        this.eQY = arrayList;
        this.aKw = map;
        if (this.eQY == null) {
            this.eQY = new ArrayList<>();
        }
        Iterator<String> it = this.eQY.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.eQZ.put(d.pJ(next), next);
        }
        this.aZG = str3;
        this.dsd = str2;
        this.mForumId = str;
        this.eRa = str4;
        this.mThreadType = i;
        this.eRb = this.eRa == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
    }

    public void setSourceImageRectInScreen(String str) {
        this.eRj = str;
    }

    public void pM(String str) {
        this.eRk = str;
    }

    public void iH(boolean z) {
        this.mIsReserver = z;
    }

    public void aRT() {
        this.eRh = false;
        if (!this.eRb) {
            d(this.aZG, this.eRa, 10, 0);
        }
    }

    public void aRU() {
        this.eRh = true;
        d(this.aZG, d.pJ(this.eQY.get(0)), 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.eRc != null) {
            if (str2 == null || !str2.equals(this.eRc.getPicId())) {
                this.eRc.cancel();
            } else {
                return;
            }
        }
        this.eRc = new a(str, str2, i, i2);
        this.eRc.setPriority(3);
        this.eRc.execute(new Object[0]);
    }

    public void iI(boolean z) {
        this.eRe = z;
    }

    public void a(b bVar) {
        this.eRf = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String aZG;
        private int eRl;
        private int eRm;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.aZG = null;
            this.mPicId = null;
            this.eRl = 0;
            this.eRm = 0;
            this.mPicId = str2;
            this.aZG = str;
            this.eRl = i;
            this.eRm = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public h doInBackground(Object... objArr) {
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.mNetWork.u("kw", e.this.dsd);
            this.mNetWork.u("tid", this.aZG);
            if (this.mPicId != null) {
                this.mNetWork.u(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.u("next", String.valueOf(this.eRl));
            this.mNetWork.u("prev", String.valueOf(this.eRm));
            this.mNetWork.u("not_see_lz", String.valueOf(e.this.eRe ? 0 : 1));
            if (!e.this.mIsReserver) {
                this.mNetWork.u("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.u("obj_type", e.this.mFrom);
            }
            if (TextUtils.isEmpty(e.this.eRi)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.eRi = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.u("applist", e.this.eRi);
            aRV();
            this.mNetWork.zR().AP().auq = false;
            String zt = this.mNetWork.zt();
            if (!this.mNetWork.zR().AQ().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.H(zt, true);
            return hVar;
        }

        private void aRV() {
            this.mNetWork.u("forum_id", e.this.mForumId);
            this.mNetWork.u("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.u("scr_w", String.valueOf(l.aO(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.u("scr_h", String.valueOf(l.aQ(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.u("q_type", String.valueOf(aq.Az().AB() ? 2 : 1));
            this.mNetWork.u("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.u("page_name", "PB");
            this.mNetWork.u("pic_index", String.valueOf(e.this.eQY.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.iT();
            }
            e.this.eRc = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.aKw != null) {
                e.this.eRc = null;
                if (hVar == null) {
                    if (e.this.eRf != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.zV();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.eRf.X(i, str);
                        return;
                    }
                    return;
                }
                boolean z = v.z(hVar.aSb());
                if (e.this.mIsReset && !z) {
                    e.this.eQY.clear();
                    e.this.aKw.clear();
                    e.this.eQZ.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.eRd = hVar.getImageNum();
                }
                e.this.eRg = hVar.aSc();
                if (this.mPicId == null) {
                    e.this.eQY.clear();
                    e.this.eQZ.clear();
                }
                LinkedList<f> aSb = hVar.aSb();
                int size = aSb.size();
                if (size <= 0) {
                    e.this.eRb = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = aSb.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.aRW();
                        if (ao.equals(imageUrlData.id, e.this.eRk)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.eRj);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.aSa();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.Pn();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.aZG, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(fVar.aRX(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.eRe;
                        imageUrlData.overAllIndex = fVar.aSa();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.aRY();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.aRZ();
                        if (e.this.eQZ.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.eQZ.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.aKw.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.aKw.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                if (ao.equals(imageUrlData.id, e.this.eRk)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.eRj);
                                }
                            }
                        } else {
                            e.this.aKw.put(str2, imageUrlData);
                            if (e.this.eRh) {
                                e.this.eQY.add(i2, str2);
                            } else {
                                e.this.eQY.add(str2);
                            }
                            e.this.eQZ.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = aSb.get(size - 1);
                    e.this.eRa = fVar2.aRW();
                    e.this.eRb = ((long) e.this.eRd) == fVar2.aSa();
                }
                boolean z2 = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.aZG = this.aZG;
                    z2 = true;
                }
                int a2 = e.this.eRh ? v.a(e.this.eQY, (String) e.this.eQZ.get(this.mPicId)) - 1 : i3;
                if (e.this.eRf != null) {
                    e.this.eRf.a(e.this.eQY, a2, e.this.eRd, false, null, z2, e.this.eRg, z);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.Pg() != null && fVar.Pg().length() > 0) {
            return fVar.Pg();
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
        sb.append(ao.by(fVar.getImageUrl()));
        return sb.toString();
    }
}
