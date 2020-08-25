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
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tbadk.util.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes15.dex */
public class e {
    private String akY;
    private boolean cGW;
    private Map<String, ImageUrlData> eFT;
    public String eMt;
    private String ebR;
    private String ebS;
    private String hSH;
    public ForumData iAy;
    private String jHF;
    private String jHG;
    private String jHH;
    private boolean jHI;
    private int jHK;
    public MetaData jHL;
    public String jHM;
    public boolean jHN;
    private ArrayList<String> jHt;
    private ArrayList<AlaInfoData> jHv;
    private String jHw;
    private String jHx;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private String mNid;
    private String mPostId;
    private String mRecomAbTag;
    private String mRecomExtra;
    private String mRecomSource;
    private String mRecomWeight;
    private int mThreadType;
    private String mUserId;
    public int replyPrivateFlag;
    private HashMap<String, String> jHu = new HashMap<>();
    private boolean mIsReserver = true;
    private a jHy = null;
    private int jHz = 0;
    private boolean jHA = false;
    private boolean jHB = false;
    private b jHC = null;
    private AdvertAppInfo jHD = null;
    private boolean jHE = false;
    private boolean jHJ = false;

    /* loaded from: classes15.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void bj(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        this.cGW = false;
        this.jHt = arrayList;
        this.eFT = map;
        if (this.jHt == null) {
            this.jHt = new ArrayList<>();
        }
        Iterator<String> it = this.jHt.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.jHu.put(d.Lr(next), next);
        }
        this.akY = str3;
        this.mNid = str4;
        this.hSH = str2;
        this.mForumId = str;
        this.jHx = str5;
        this.mThreadType = i;
        this.cGW = this.jHx == null;
        this.mUserId = str6;
        this.mFrom = str7;
        this.mIsReset = z;
        this.jHI = false;
        this.jHK = i2;
        this.mRecomSource = str8;
        this.mRecomAbTag = str9;
        this.mRecomWeight = str10;
        this.mRecomExtra = str11;
    }

    public void setSourceImageRectInScreen(String str) {
        this.jHG = str;
    }

    public void Lt(String str) {
        this.jHH = str;
    }

    public void ro(boolean z) {
        this.jHI = z;
    }

    public String bgm() {
        return this.ebR;
    }

    public String bgn() {
        return this.ebS;
    }

    public ArrayList<AlaInfoData> cKo() {
        return this.jHv;
    }

    public void rp(boolean z) {
        this.mIsReserver = z;
    }

    public void cKp() {
        this.jHE = false;
        if (!this.cGW) {
            c(this.akY, this.jHx, 10, 0);
        }
    }

    public void cKq() {
        this.jHE = true;
        String str = this.jHt.get(0);
        if (StringUtils.isNull(this.jHw)) {
            this.jHw = d.Lr(str);
        }
        c(this.akY, this.jHw, 0, 10);
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.jHy != null) {
            if (str2 == null || !str2.equals(this.jHy.getPicId())) {
                this.jHy.cancel();
            } else {
                return;
            }
        }
        this.jHy = new a(str, str2, i, i2);
        this.jHy.setPriority(3);
        this.jHy.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void rq(boolean z) {
        this.jHA = z;
    }

    public void rr(boolean z) {
        this.jHB = z;
    }

    public void a(b bVar) {
        this.jHC = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String akY;
        private aa bDY = null;
        private int jHO;
        private int jHP;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.akY = null;
            this.mPicId = null;
            this.jHO = 0;
            this.jHP = 0;
            this.mPicId = str2;
            this.akY = str;
            this.jHO = i;
            this.jHP = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public h doInBackground(Object... objArr) {
            this.bDY = new aa(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.bDY.addPostData("kw", e.this.hSH);
            this.bDY.addPostData("tid", this.akY);
            if (this.mPicId != null) {
                this.bDY.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.bDY.addPostData("post_id", e.this.mPostId);
            }
            this.bDY.addPostData("source", String.valueOf(e.this.jHB ? 1 : 2));
            e.this.jHB = false;
            this.bDY.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.jHO));
            this.bDY.addPostData("prev", String.valueOf(this.jHP));
            this.bDY.addPostData("not_see_lz", String.valueOf(e.this.jHA ? 0 : 1));
            this.bDY.addPostData("is_top_agree", String.valueOf(e.this.jHI ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.bDY.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.bDY.addPostData("obj_type", e.this.mFrom);
            } else {
                this.bDY.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.jHF)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.jHF = com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.bDY.addPostData("applist", e.this.jHF);
            String bvD = x.bvD();
            if (!TextUtils.isEmpty(bvD)) {
                this.bDY.addPostData("oaid", bvD);
            }
            this.bDY.addPostData("ad_ext_params", AdExtParam.a.buW().buX());
            cKr();
            this.bDY.biQ().bjv().mNeedBackgroundLogin = false;
            String postNetData = this.bDY.postNetData();
            if (!this.bDY.biQ().bjw().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.aM(postNetData, true);
            return hVar;
        }

        private void cKr() {
            this.bDY.addPostData("forum_id", e.this.mForumId);
            this.bDY.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.bDY.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.bDY.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.bDY.addPostData("q_type", String.valueOf(au.bjr().bjs() ? 2 : 1));
            this.bDY.addPostData("_os_version", Build.VERSION.RELEASE);
            this.bDY.addPostData("page_name", "PB");
            this.bDY.addPostData("pic_index", String.valueOf(e.this.jHt.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bDY != null) {
                this.bDY.cancelNetConnect();
            }
            e.this.jHy = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.eFT != null) {
                e.this.jHy = null;
                if (hVar == null) {
                    if (e.this.jHC != null) {
                        String str = null;
                        int i = -1;
                        if (this.bDY != null) {
                            i = this.bDY.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.bDY.getErrorString();
                            }
                        }
                        e.this.jHC.bj(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = y.isEmpty(hVar.cKA());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.jHt.clear();
                    e.this.eFT.clear();
                    e.this.jHu.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.jHz = hVar.getImageNum();
                }
                e.this.jHD = hVar.cKD();
                e.this.eMt = hVar.eMt;
                e.this.replyPrivateFlag = hVar.cKC();
                e.this.jHL = hVar.jHL;
                e.this.jHM = hVar.jHM;
                e.this.jHN = hVar.jIb == 1;
                if (this.mPicId == null) {
                    e.this.jHt.clear();
                    e.this.jHu.clear();
                }
                LinkedList<f> cKA = hVar.cKA();
                int size = cKA.size();
                if (size <= 0) {
                    e.this.cGW = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = cKA.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.cKs();
                        if (at.equals(imageUrlData.id, e.this.jHH)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.jHG);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.cKw();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.bxV();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.forumName = e.this.hSH;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.akY, -1L);
                        imageUrlData.nid = e.this.mNid;
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.cKt(), -1L);
                        imageUrlData.userId = fVar.getUserId();
                        imageUrlData.userNameShow = StringUtils.isNull(fVar.bpu()) ? fVar.getUserName() : fVar.bpu();
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.jHA;
                        imageUrlData.overAllIndex = fVar.cKw();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.cKu();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.cKv();
                        imageUrlData.from = e.this.mFrom;
                        if (fVar.cKy() != null) {
                            imageUrlData.richTextArray = fVar.cKy().toString();
                        }
                        imageUrlData.isFirstPost = fVar.cKz();
                        if (fVar.bgv() != null) {
                            imageUrlData.agreeData = fVar.bgv();
                            imageUrlData.agreeData.isFromImageViewer = true;
                            imageUrlData.agreeData.mImageViewerFromPage = e.this.mFrom;
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.nid = imageUrlData.nid;
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.cKx();
                            if (fVar.cKz()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                            imageUrlData.agreeData.cardType = e.this.jHK;
                            imageUrlData.agreeData.recomSource = e.this.mRecomSource;
                            imageUrlData.agreeData.recomAbTag = e.this.mRecomAbTag;
                            imageUrlData.agreeData.recomExtra = e.this.mRecomExtra;
                            imageUrlData.agreeData.recomWeight = e.this.mRecomWeight;
                        }
                        if (e.this.jHu.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.jHu.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.eFT.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.eFT.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                imageUrlData2.userId = imageUrlData.userId;
                                imageUrlData2.userNameShow = imageUrlData.userNameShow;
                                imageUrlData2.forumId = e.this.mForumId;
                                imageUrlData2.forumName = e.this.hSH;
                                if (at.equals(imageUrlData.id, e.this.jHH)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.jHG);
                                }
                            }
                        } else if (e.this.jHJ) {
                            e.this.jHz = e.this.eFT.size();
                            e.this.jHD = null;
                        } else {
                            e.this.eFT.put(str2, imageUrlData);
                            if (e.this.jHE) {
                                e.this.jHt.add(i2, str2);
                            } else {
                                e.this.jHt.add(str2);
                            }
                            e.this.jHu.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) y.getItem(cKA, 0);
                    if (fVar2 != null) {
                        e.this.jHw = fVar2.cKs();
                    }
                    f fVar3 = (f) y.getItem(cKA, size - 1);
                    if (fVar3 != null) {
                        e.this.jHx = fVar3.cKs();
                        e.this.cGW = ((long) e.this.jHz) == fVar3.cKw();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.eFT.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.eFT.values()) {
                                if (imageUrlData5.postId != j || imageUrlData5.agreeData == null) {
                                    imageUrlData5 = imageUrlData3;
                                } else {
                                    imageUrlData4.agreeData = imageUrlData5.agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                    imageUrlData4.userId = imageUrlData5.userId;
                                    imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                    imageUrlData4.forumId = e.this.mForumId;
                                    imageUrlData4.forumName = e.this.hSH;
                                }
                                imageUrlData3 = imageUrlData5;
                            }
                        } else if (j == imageUrlData3.postId) {
                            imageUrlData4.agreeData = imageUrlData3.agreeData;
                            imageUrlData4.richTextArray = imageUrlData3.richTextArray;
                            imageUrlData4.commentNum = imageUrlData3.commentNum;
                            imageUrlData4.userId = imageUrlData3.userId;
                            imageUrlData4.userNameShow = imageUrlData3.userNameShow;
                            imageUrlData4.forumId = e.this.mForumId;
                            imageUrlData4.forumName = e.this.hSH;
                        }
                    }
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.akY = this.akY;
                    z = true;
                }
                int position = e.this.jHE ? y.getPosition(e.this.jHt, (String) e.this.jHu.get(this.mPicId)) - 1 : i3;
                e.this.ebR = hVar.bgm();
                e.this.ebS = hVar.bgn();
                e.this.iAy = hVar.bss();
                if (e.this.jHv == null) {
                    e.this.jHv = new ArrayList();
                    if (hVar.cKB() != null && hVar.cKA().size() > 0) {
                        e.this.jHv.addAll(hVar.cKB());
                    }
                }
                if (e.this.jHC != null) {
                    e.this.jHC.a(e.this.jHt, position, e.this.jHz, false, null, z, e.this.jHD, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.bxP() != null && fVar.bxP().length() > 0) {
            return fVar.bxP();
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
        sb.append(at.getUrlEncode(fVar.getImageUrl()));
        return sb.toString();
    }

    public void rs(boolean z) {
        this.jHJ = z;
    }
}
