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
    private Map<String, ImageUrlData> aTZ;
    private String bjn;
    private String dLt;
    private ArrayList<String> fkC;
    private String fkE;
    private String fkF;
    private boolean fkG;
    private String fkO;
    private String fkP;
    private String fkQ;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> fkD = new HashMap<>();
    private boolean mIsReserver = true;
    private a fkH = null;
    private int fkI = 0;
    private boolean fkJ = false;
    private boolean fkK = false;
    private b fkL = null;
    private AdvertAppInfo fkM = null;
    private boolean fkN = false;

    /* loaded from: classes3.dex */
    public interface b {
        void W(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.fkG = false;
        this.fkC = arrayList;
        this.aTZ = map;
        if (this.fkC == null) {
            this.fkC = new ArrayList<>();
        }
        Iterator<String> it = this.fkC.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.fkD.put(d.rh(next), next);
        }
        this.bjn = str3;
        this.dLt = str2;
        this.mForumId = str;
        this.fkF = str4;
        this.mThreadType = i;
        this.fkG = this.fkF == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
    }

    public void setSourceImageRectInScreen(String str) {
        this.fkP = str;
    }

    public void rk(String str) {
        this.fkQ = str;
    }

    public void jo(boolean z) {
        this.mIsReserver = z;
    }

    public void aXJ() {
        this.fkN = false;
        if (!this.fkG) {
            e(this.bjn, this.fkF, 10, 0);
        }
    }

    public void aXK() {
        this.fkN = true;
        String str = this.fkC.get(0);
        if (StringUtils.isNull(this.fkE)) {
            this.fkE = d.rh(str);
        }
        e(this.bjn, this.fkE, 0, 10);
    }

    private void e(String str, String str2, int i, int i2) {
        if (this.fkH != null) {
            if (str2 == null || !str2.equals(this.fkH.getPicId())) {
                this.fkH.cancel();
            } else {
                return;
            }
        }
        this.fkH = new a(str, str2, i, i2);
        this.fkH.setPriority(3);
        this.fkH.execute(new Object[0]);
    }

    public void jp(boolean z) {
        this.fkJ = z;
    }

    public void jq(boolean z) {
        this.fkK = z;
    }

    public void a(b bVar) {
        this.fkL = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String bjn;
        private int fkR;
        private int fkS;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.bjn = null;
            this.mPicId = null;
            this.fkR = 0;
            this.fkS = 0;
            this.mPicId = str2;
            this.bjn = str;
            this.fkR = i;
            this.fkS = i2;
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
            this.mNetWork.x("kw", e.this.dLt);
            this.mNetWork.x("tid", this.bjn);
            if (this.mPicId != null) {
                this.mNetWork.x(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.x("source", String.valueOf(e.this.fkK ? 1 : 2));
            e.this.fkK = false;
            this.mNetWork.x(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.fkR));
            this.mNetWork.x("prev", String.valueOf(this.fkS));
            this.mNetWork.x("not_see_lz", String.valueOf(e.this.fkJ ? 0 : 1));
            if (!e.this.mIsReserver) {
                this.mNetWork.x("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.x("obj_type", e.this.mFrom);
            }
            if (TextUtils.isEmpty(e.this.fkO)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.fkO = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.x("applist", e.this.fkO);
            aXL();
            this.mNetWork.Dw().Eu().aDU = false;
            String CY = this.mNetWork.CY();
            if (!this.mNetWork.Dw().Ev().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.P(CY, true);
            return hVar;
        }

        private void aXL() {
            this.mNetWork.x("forum_id", e.this.mForumId);
            this.mNetWork.x("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.x("scr_w", String.valueOf(l.aO(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.x("scr_h", String.valueOf(l.aQ(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.x("q_type", String.valueOf(aq.Ee().Eg() ? 2 : 1));
            this.mNetWork.x("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.x("page_name", "PB");
            this.mNetWork.x("pic_index", String.valueOf(e.this.fkC.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            e.this.fkH = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.aTZ != null) {
                e.this.fkH = null;
                if (hVar == null) {
                    if (e.this.fkL != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.DA();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.fkL.W(i, str);
                        return;
                    }
                    return;
                }
                boolean I = v.I(hVar.aXR());
                if (e.this.mIsReset && !I) {
                    e.this.fkC.clear();
                    e.this.aTZ.clear();
                    e.this.fkD.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.fkI = hVar.getImageNum();
                }
                e.this.fkM = hVar.aXS();
                if (this.mPicId == null) {
                    e.this.fkC.clear();
                    e.this.fkD.clear();
                }
                LinkedList<f> aXR = hVar.aXR();
                int size = aXR.size();
                if (size <= 0) {
                    e.this.fkG = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = aXR.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.aXM();
                        if (ao.equals(imageUrlData.id, e.this.fkQ)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.fkP);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.aXQ();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.SV();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.bjn, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(fVar.aXN(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.fkJ;
                        imageUrlData.overAllIndex = fVar.aXQ();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.aXO();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.aXP();
                        if (e.this.fkD.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.fkD.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.aTZ.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.aTZ.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                if (ao.equals(imageUrlData.id, e.this.fkQ)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.fkP);
                                }
                            }
                        } else {
                            e.this.aTZ.put(str2, imageUrlData);
                            if (e.this.fkN) {
                                e.this.fkC.add(i2, str2);
                            } else {
                                e.this.fkC.add(str2);
                            }
                            e.this.fkD.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.d(aXR, 0);
                    if (fVar2 != null) {
                        e.this.fkE = fVar2.aXM();
                    }
                    f fVar3 = (f) v.d(aXR, size - 1);
                    if (fVar3 != null) {
                        e.this.fkF = fVar3.aXM();
                        e.this.fkG = ((long) e.this.fkI) == fVar3.aXQ();
                    }
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.bjn = this.bjn;
                    z = true;
                }
                int a2 = e.this.fkN ? v.a(e.this.fkC, (String) e.this.fkD.get(this.mPicId)) - 1 : i3;
                if (e.this.fkL != null) {
                    e.this.fkL.a(e.this.fkC, a2, e.this.fkI, false, null, z, e.this.fkM, I);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.SO() != null && fVar.SO().length() > 0) {
            return fVar.SO();
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
