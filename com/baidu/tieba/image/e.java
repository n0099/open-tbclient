package com.baidu.tieba.image;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
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
    private Map<String, ImageUrlData> aTq;
    private String biz;
    private String dKJ;
    private ArrayList<String> fjG;
    private String fjI;
    private String fjJ;
    private boolean fjK;
    private String fjS;
    private String fjT;
    private String fjU;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> fjH = new HashMap<>();
    private boolean mIsReserver = true;
    private a fjL = null;
    private int fjM = 0;
    private boolean fjN = false;
    private boolean fjO = false;
    private b fjP = null;
    private AdvertAppInfo fjQ = null;
    private boolean fjR = false;

    /* loaded from: classes3.dex */
    public interface b {
        void U(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.fjK = false;
        this.fjG = arrayList;
        this.aTq = map;
        if (this.fjG == null) {
            this.fjG = new ArrayList<>();
        }
        Iterator<String> it = this.fjG.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.fjH.put(d.qR(next), next);
        }
        this.biz = str3;
        this.dKJ = str2;
        this.mForumId = str;
        this.fjJ = str4;
        this.mThreadType = i;
        this.fjK = this.fjJ == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
    }

    public void setSourceImageRectInScreen(String str) {
        this.fjT = str;
    }

    public void qU(String str) {
        this.fjU = str;
    }

    public void jo(boolean z) {
        this.mIsReserver = z;
    }

    public void aXj() {
        this.fjR = false;
        if (!this.fjK) {
            d(this.biz, this.fjJ, 10, 0);
        }
    }

    public void aXk() {
        this.fjR = true;
        String str = this.fjG.get(0);
        if (StringUtils.isNull(this.fjI)) {
            this.fjI = d.qR(str);
        }
        d(this.biz, this.fjI, 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.fjL != null) {
            if (str2 == null || !str2.equals(this.fjL.getPicId())) {
                this.fjL.cancel();
            } else {
                return;
            }
        }
        this.fjL = new a(str, str2, i, i2);
        this.fjL.setPriority(3);
        this.fjL.execute(new Object[0]);
    }

    public void jp(boolean z) {
        this.fjN = z;
    }

    public void jq(boolean z) {
        this.fjO = z;
    }

    public void a(b bVar) {
        this.fjP = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String biz;
        private int fjV;
        private int fjW;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.biz = null;
            this.mPicId = null;
            this.fjV = 0;
            this.fjW = 0;
            this.mPicId = str2;
            this.biz = str;
            this.fjV = i;
            this.fjW = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public h doInBackground(Object... objArr) {
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.mNetWork.x("kw", e.this.dKJ);
            this.mNetWork.x("tid", this.biz);
            if (this.mPicId != null) {
                this.mNetWork.x(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.x("source", String.valueOf(e.this.fjO ? 1 : 2));
            e.this.fjO = false;
            this.mNetWork.x(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.fjV));
            this.mNetWork.x("prev", String.valueOf(this.fjW));
            this.mNetWork.x("not_see_lz", String.valueOf(e.this.fjN ? 0 : 1));
            if (!e.this.mIsReserver) {
                this.mNetWork.x("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.x("obj_type", e.this.mFrom);
            }
            if (TextUtils.isEmpty(e.this.fjS)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.fjS = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.x("applist", e.this.fjS);
            aXl();
            this.mNetWork.Dj().Eh().aDr = false;
            String CL = this.mNetWork.CL();
            if (!this.mNetWork.Dj().Ei().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.Q(CL, true);
            return hVar;
        }

        private void aXl() {
            this.mNetWork.x("forum_id", e.this.mForumId);
            this.mNetWork.x("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.x("scr_w", String.valueOf(l.aO(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.x("scr_h", String.valueOf(l.aQ(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.x("q_type", String.valueOf(aq.DR().DT() ? 2 : 1));
            this.mNetWork.x("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.x("page_name", "PB");
            this.mNetWork.x("pic_index", String.valueOf(e.this.fjG.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            e.this.fjL = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.aTq != null) {
                e.this.fjL = null;
                if (hVar == null) {
                    if (e.this.fjP != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.Dn();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.fjP.U(i, str);
                        return;
                    }
                    return;
                }
                boolean I = v.I(hVar.aXr());
                if (e.this.mIsReset && !I) {
                    e.this.fjG.clear();
                    e.this.aTq.clear();
                    e.this.fjH.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.fjM = hVar.getImageNum();
                }
                e.this.fjQ = hVar.aXs();
                if (this.mPicId == null) {
                    e.this.fjG.clear();
                    e.this.fjH.clear();
                }
                LinkedList<f> aXr = hVar.aXr();
                int size = aXr.size();
                if (size <= 0) {
                    e.this.fjK = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = aXr.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.aXm();
                        if (ao.equals(imageUrlData.id, e.this.fjU)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.fjT);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.aXq();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.Sz();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.biz, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(fVar.aXn(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.fjN;
                        imageUrlData.overAllIndex = fVar.aXq();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.aXo();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.aXp();
                        if (e.this.fjH.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.fjH.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.aTq.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.aTq.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                if (ao.equals(imageUrlData.id, e.this.fjU)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.fjT);
                                }
                            }
                        } else {
                            e.this.aTq.put(str2, imageUrlData);
                            if (e.this.fjR) {
                                e.this.fjG.add(i2, str2);
                            } else {
                                e.this.fjG.add(str2);
                            }
                            e.this.fjH.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.d(aXr, 0);
                    if (fVar2 != null) {
                        e.this.fjI = fVar2.aXm();
                    }
                    f fVar3 = (f) v.d(aXr, size - 1);
                    if (fVar3 != null) {
                        e.this.fjJ = fVar3.aXm();
                        e.this.fjK = ((long) e.this.fjM) == fVar3.aXq();
                    }
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.biz = this.biz;
                    z = true;
                }
                int a2 = e.this.fjR ? v.a(e.this.fjG, (String) e.this.fjH.get(this.mPicId)) - 1 : i3;
                if (e.this.fjP != null) {
                    e.this.fjP.a(e.this.fjG, a2, e.this.fjM, false, null, z, e.this.fjQ, I);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.Ss() != null && fVar.Ss().length() > 0) {
            return fVar.Ss();
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
        sb.append(ao.bx(fVar.getImageUrl()));
        return sb.toString();
    }
}
