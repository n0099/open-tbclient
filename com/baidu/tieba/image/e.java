package com.baidu.tieba.image;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
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
    private String cma;
    private Map<String, ImageUrlData> czF;
    private boolean dqb;
    private String fup;
    private ArrayList<String> gXN;
    private String gXP;
    private String gXQ;
    private String gXY;
    private String gXZ;
    private String gYa;
    private boolean gYb;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> gXO = new HashMap<>();
    private boolean mIsReserver = true;
    private a gXR = null;
    private int gXS = 0;
    private boolean gXT = false;
    private boolean gXU = false;
    private b gXV = null;
    private AdvertAppInfo gXW = null;
    private boolean gXX = false;

    /* loaded from: classes3.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void aq(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.dqb = false;
        this.gXN = arrayList;
        this.czF = map;
        if (this.gXN == null) {
            this.gXN = new ArrayList<>();
        }
        Iterator<String> it = this.gXN.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.gXO.put(d.yE(next), next);
        }
        this.cma = str3;
        this.fup = str2;
        this.mForumId = str;
        this.gXQ = str4;
        this.mThreadType = i;
        this.dqb = this.gXQ == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.gYb = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.gXZ = str;
    }

    public void yG(String str) {
        this.gYa = str;
    }

    public void mJ(boolean z) {
        this.gYb = z;
    }

    public void mK(boolean z) {
        this.mIsReserver = z;
    }

    public void bGl() {
        this.gXX = false;
        if (!this.dqb) {
            d(this.cma, this.gXQ, 10, 0);
        }
    }

    public void bGm() {
        this.gXX = true;
        String str = this.gXN.get(0);
        if (StringUtils.isNull(this.gXP)) {
            this.gXP = d.yE(str);
        }
        d(this.cma, this.gXP, 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.gXR != null) {
            if (str2 == null || !str2.equals(this.gXR.getPicId())) {
                this.gXR.cancel();
            } else {
                return;
            }
        }
        this.gXR = new a(str, str2, i, i2);
        this.gXR.setPriority(3);
        this.gXR.execute(new Object[0]);
    }

    public void mL(boolean z) {
        this.gXT = z;
    }

    public void mM(boolean z) {
        this.gXU = z;
    }

    public void a(b bVar) {
        this.gXV = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private x bUY = null;
        private String cma;
        private int gYc;
        private int gYd;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.cma = null;
            this.mPicId = null;
            this.gYc = 0;
            this.gYd = 0;
            this.mPicId = str2;
            this.cma = str;
            this.gYc = i;
            this.gYd = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public h doInBackground(Object... objArr) {
            this.bUY = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.bUY.addPostData("kw", e.this.fup);
            this.bUY.addPostData("tid", this.cma);
            if (this.mPicId != null) {
                this.bUY.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.bUY.addPostData("source", String.valueOf(e.this.gXU ? 1 : 2));
            e.this.gXU = false;
            this.bUY.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.gYc));
            this.bUY.addPostData("prev", String.valueOf(this.gYd));
            this.bUY.addPostData("not_see_lz", String.valueOf(e.this.gXT ? 0 : 1));
            this.bUY.addPostData("is_top_agree", String.valueOf(e.this.gYb ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.bUY.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.bUY.addPostData("obj_type", e.this.mFrom);
            } else {
                this.bUY.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.gXY)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.alP().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.gXY = com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.bUY.addPostData("applist", e.this.gXY);
            bGn();
            this.bUY.amp().amP().mNeedBackgroundLogin = false;
            String postNetData = this.bUY.postNetData();
            if (!this.bUY.amp().amQ().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.al(postNetData, true);
            return hVar;
        }

        private void bGn() {
            this.bUY.addPostData("forum_id", e.this.mForumId);
            this.bUY.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.bUY.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.bUY.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.bUY.addPostData("q_type", String.valueOf(ar.amM().isFrsShowBigImage() ? 2 : 1));
            this.bUY.addPostData("_os_version", Build.VERSION.RELEASE);
            this.bUY.addPostData("page_name", "PB");
            this.bUY.addPostData("pic_index", String.valueOf(e.this.gXN.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bUY != null) {
                this.bUY.cancelNetConnect();
            }
            e.this.gXR = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.czF != null) {
                e.this.gXR = null;
                if (hVar == null) {
                    if (e.this.gXV != null) {
                        String str = null;
                        int i = -1;
                        if (this.bUY != null) {
                            i = this.bUY.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.bUY.getErrorString();
                            }
                        }
                        e.this.gXV.aq(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = v.isEmpty(hVar.bGw());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.gXN.clear();
                    e.this.czF.clear();
                    e.this.gXO.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.gXS = hVar.getImageNum();
                }
                e.this.gXW = hVar.bGx();
                if (this.mPicId == null) {
                    e.this.gXN.clear();
                    e.this.gXO.clear();
                }
                LinkedList<f> bGw = hVar.bGw();
                int size = bGw.size();
                if (size <= 0) {
                    e.this.dqb = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = bGw.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.bGo();
                        if (aq.equals(imageUrlData.id, e.this.gYa)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.gXZ);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.bGs();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.azE();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.toLong(this.cma, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.toLong(fVar.bGp(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.gXT;
                        imageUrlData.overAllIndex = fVar.bGs();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.bGq();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.bGr();
                        if (fVar.bGu() != null) {
                            imageUrlData.richTextArray = fVar.bGu().toString();
                        }
                        imageUrlData.isFirstPost = fVar.bGv();
                        if (fVar.akt() != null) {
                            imageUrlData.agreeData = fVar.akt();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.bGt();
                            if (fVar.bGv()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.gXO.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.gXO.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.czF.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.czF.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (aq.equals(imageUrlData.id, e.this.gYa)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.gXZ);
                                }
                            }
                        } else {
                            e.this.czF.put(str2, imageUrlData);
                            if (e.this.gXX) {
                                e.this.gXN.add(i2, str2);
                            } else {
                                e.this.gXN.add(str2);
                            }
                            e.this.gXO.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.getItem(bGw, 0);
                    if (fVar2 != null) {
                        e.this.gXP = fVar2.bGo();
                    }
                    f fVar3 = (f) v.getItem(bGw, size - 1);
                    if (fVar3 != null) {
                        e.this.gXQ = fVar3.bGo();
                        e.this.dqb = ((long) e.this.gXS) == fVar3.bGs();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.czF.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.czF.values()) {
                                if (imageUrlData5.postId != j || imageUrlData5.agreeData == null) {
                                    imageUrlData5 = imageUrlData3;
                                } else {
                                    imageUrlData4.agreeData = imageUrlData5.agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                }
                                imageUrlData3 = imageUrlData5;
                            }
                        } else if (j == imageUrlData3.postId) {
                            imageUrlData4.agreeData = imageUrlData3.agreeData;
                            imageUrlData4.richTextArray = imageUrlData3.richTextArray;
                            imageUrlData4.commentNum = imageUrlData3.commentNum;
                        }
                    }
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.cma = this.cma;
                    z = true;
                }
                int position = e.this.gXX ? v.getPosition(e.this.gXN, (String) e.this.gXO.get(this.mPicId)) - 1 : i3;
                if (e.this.gXV != null) {
                    e.this.gXV.a(e.this.gXN, position, e.this.gXS, false, null, z, e.this.gXW, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.azy() != null && fVar.azy().length() > 0) {
            return fVar.azy();
        }
        StringBuilder sb = new StringBuilder(150);
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
        sb.append(aq.getUrlEncode(fVar.getImageUrl()));
        return sb.toString();
    }
}
