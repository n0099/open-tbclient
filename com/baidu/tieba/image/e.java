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
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tbadk.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes21.dex */
public class e {
    private String alT;
    private boolean ddD;
    private String eyL;
    private String eyM;
    private Map<String, ImageUrlData> fcI;
    public String fjU;
    private String iBk;
    public ForumData jjm;
    private ArrayList<AlaInfoData> krA;
    private String krB;
    private String krC;
    private String krK;
    private String krL;
    private String krM;
    private boolean krN;
    private int krP;
    public MetaData krQ;
    public String krR;
    public boolean krS;
    private ArrayList<String> kry;
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
    private HashMap<String, String> krz = new HashMap<>();
    private boolean mIsReserver = true;
    private a krD = null;
    private int krE = 0;
    private boolean krF = false;
    private boolean krG = false;
    private b krH = null;
    private AdvertAppInfo krI = null;
    private boolean krJ = false;
    private boolean krO = false;

    /* loaded from: classes21.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void bx(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        this.ddD = false;
        this.kry = arrayList;
        this.fcI = map;
        if (this.kry == null) {
            this.kry = new ArrayList<>();
        }
        Iterator<String> it = this.kry.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.krz.put(d.Nh(next), next);
        }
        this.alT = str3;
        this.mNid = str4;
        this.iBk = str2;
        this.mForumId = str;
        this.krC = str5;
        this.mThreadType = i;
        this.ddD = this.krC == null;
        this.mUserId = str6;
        this.mFrom = str7;
        this.mIsReset = z;
        this.krN = false;
        this.krP = i2;
        this.mRecomSource = str8;
        this.mRecomAbTag = str9;
        this.mRecomWeight = str10;
        this.mRecomExtra = str11;
    }

    public void setSourceImageRectInScreen(String str) {
        this.krL = str;
    }

    public void Nj(String str) {
        this.krM = str;
    }

    public void sw(boolean z) {
        this.krN = z;
    }

    public String blI() {
        return this.eyL;
    }

    public String blJ() {
        return this.eyM;
    }

    public ArrayList<AlaInfoData> cUK() {
        return this.krA;
    }

    public void sx(boolean z) {
        this.mIsReserver = z;
    }

    public void cUL() {
        this.krJ = false;
        if (!this.ddD) {
            c(this.alT, this.krC, 10, 0);
        }
    }

    public void cUM() {
        this.krJ = true;
        String str = this.kry.get(0);
        if (StringUtils.isNull(this.krB)) {
            this.krB = d.Nh(str);
        }
        c(this.alT, this.krB, 0, 10);
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.krD != null) {
            if (str2 == null || !str2.equals(this.krD.getPicId())) {
                this.krD.cancel();
            } else {
                return;
            }
        }
        this.krD = new a(str, str2, i, i2);
        this.krD.setPriority(3);
        this.krD.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void sy(boolean z) {
        this.krF = z;
    }

    public void sz(boolean z) {
        this.krG = z;
    }

    public void a(b bVar) {
        this.krH = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String alT;
        private aa bVi = null;
        private int krT;
        private int krU;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.alT = null;
            this.mPicId = null;
            this.krT = 0;
            this.krU = 0;
            this.mPicId = str2;
            this.alT = str;
            this.krT = i;
            this.krU = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public h doInBackground(Object... objArr) {
            this.bVi = new aa(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.bVi.addPostData("kw", e.this.iBk);
            this.bVi.addPostData("tid", this.alT);
            if (this.mPicId != null) {
                this.bVi.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.bVi.addPostData("post_id", e.this.mPostId);
            }
            this.bVi.addPostData("source", String.valueOf(e.this.krG ? 1 : 2));
            e.this.krG = false;
            this.bVi.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.krT));
            this.bVi.addPostData("prev", String.valueOf(this.krU));
            this.bVi.addPostData("not_see_lz", String.valueOf(e.this.krF ? 0 : 1));
            this.bVi.addPostData("is_top_agree", String.valueOf(e.this.krN ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.bVi.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.bVi.addPostData("obj_type", e.this.mFrom);
            } else {
                this.bVi.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.krK)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bnH().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.krK = com.baidu.tbadk.core.sharedPref.b.bnH().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.bVi.addPostData("applist", e.this.krK);
            String bBq = y.bBq();
            if (!TextUtils.isEmpty(bBq)) {
                this.bVi.addPostData("oaid", bBq);
            }
            this.bVi.addPostData("ad_ext_params", AdExtParam.a.bAE().bAF());
            cUN();
            this.bVi.bon().boT().mNeedBackgroundLogin = false;
            String postNetData = this.bVi.postNetData();
            if (!this.bVi.bon().boU().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.aS(postNetData, true);
            return hVar;
        }

        private void cUN() {
            this.bVi.addPostData("forum_id", e.this.mForumId);
            this.bVi.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.bVi.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.bVi.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.bVi.addPostData("q_type", String.valueOf(au.boO().boP() ? 2 : 1));
            this.bVi.addPostData("_os_version", Build.VERSION.RELEASE);
            this.bVi.addPostData("page_name", "PB");
            this.bVi.addPostData("pic_index", String.valueOf(e.this.kry.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bVi != null) {
                this.bVi.cancelNetConnect();
            }
            e.this.krD = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.fcI != null) {
                e.this.krD = null;
                if (hVar == null) {
                    if (e.this.krH != null) {
                        String str = null;
                        int i = -1;
                        if (this.bVi != null) {
                            i = this.bVi.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.bVi.getErrorString();
                            }
                        }
                        e.this.krH.bx(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(hVar.cUW());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.kry.clear();
                    e.this.fcI.clear();
                    e.this.krz.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.krE = hVar.getImageNum();
                }
                e.this.krI = hVar.cUZ();
                e.this.fjU = hVar.fjU;
                e.this.replyPrivateFlag = hVar.cUY();
                e.this.krQ = hVar.krQ;
                e.this.krR = hVar.krR;
                e.this.krS = hVar.ksg == 1;
                if (this.mPicId == null) {
                    e.this.kry.clear();
                    e.this.krz.clear();
                }
                LinkedList<f> cUW = hVar.cUW();
                int size = cUW.size();
                if (size <= 0) {
                    e.this.ddD = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = cUW.get(i2);
                        String a2 = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.cUO();
                        if (at.equals(imageUrlData.id, e.this.krM)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.krL);
                        }
                        imageUrlData.imageUrl = a2;
                        String str2 = a2 + "*" + fVar.cUS();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.bDI();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.forumName = e.this.iBk;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.alT, -1L);
                        imageUrlData.nid = e.this.mNid;
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.cUP(), -1L);
                        imageUrlData.userId = fVar.getUserId();
                        imageUrlData.userNameShow = StringUtils.isNull(fVar.buS()) ? fVar.getUserName() : fVar.buS();
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.krF;
                        imageUrlData.overAllIndex = fVar.cUS();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.cUQ();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.cUR();
                        imageUrlData.from = e.this.mFrom;
                        if (fVar.cUU() != null) {
                            imageUrlData.richTextArray = fVar.cUU().toString();
                        }
                        imageUrlData.isFirstPost = fVar.cUV();
                        if (fVar.blR() != null) {
                            imageUrlData.agreeData = fVar.blR();
                            imageUrlData.agreeData.isFromImageViewer = true;
                            imageUrlData.agreeData.mImageViewerFromPage = e.this.mFrom;
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.nid = imageUrlData.nid;
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.cUT();
                            if (fVar.cUV()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                            imageUrlData.agreeData.cardType = e.this.krP;
                            imageUrlData.agreeData.recomSource = e.this.mRecomSource;
                            imageUrlData.agreeData.recomAbTag = e.this.mRecomAbTag;
                            imageUrlData.agreeData.recomExtra = e.this.mRecomExtra;
                            imageUrlData.agreeData.recomWeight = e.this.mRecomWeight;
                        }
                        if (e.this.krz.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.krz.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.fcI.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.fcI.put(str3, imageUrlData);
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
                                imageUrlData2.forumName = e.this.iBk;
                                if (at.equals(imageUrlData.id, e.this.krM)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.krL);
                                }
                            }
                        } else if (e.this.krO) {
                            e.this.krE = e.this.fcI.size();
                            e.this.krI = null;
                        } else {
                            e.this.fcI.put(str2, imageUrlData);
                            if (e.this.krJ) {
                                e.this.kry.add(i2, str2);
                            } else {
                                e.this.kry.add(str2);
                            }
                            e.this.krz.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) com.baidu.tbadk.core.util.y.getItem(cUW, 0);
                    if (fVar2 != null) {
                        e.this.krB = fVar2.cUO();
                    }
                    f fVar3 = (f) com.baidu.tbadk.core.util.y.getItem(cUW, size - 1);
                    if (fVar3 != null) {
                        e.this.krC = fVar3.cUO();
                        e.this.ddD = ((long) e.this.krE) == fVar3.cUS();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.fcI.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.fcI.values()) {
                                if (imageUrlData5.postId != j || imageUrlData5.agreeData == null) {
                                    imageUrlData5 = imageUrlData3;
                                } else {
                                    imageUrlData4.agreeData = imageUrlData5.agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                    imageUrlData4.userId = imageUrlData5.userId;
                                    imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                    imageUrlData4.forumId = e.this.mForumId;
                                    imageUrlData4.forumName = e.this.iBk;
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
                            imageUrlData4.forumName = e.this.iBk;
                        }
                    }
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.alT = this.alT;
                    z = true;
                }
                int position = e.this.krJ ? com.baidu.tbadk.core.util.y.getPosition(e.this.kry, (String) e.this.krz.get(this.mPicId)) - 1 : i3;
                e.this.eyL = hVar.blI();
                e.this.eyM = hVar.blJ();
                e.this.jjm = hVar.bya();
                if (e.this.krA == null) {
                    e.this.krA = new ArrayList();
                    if (hVar.cUX() != null && hVar.cUW().size() > 0) {
                        e.this.krA.addAll(hVar.cUX());
                    }
                }
                if (e.this.krH != null) {
                    e.this.krH.a(e.this.kry, position, e.this.krE, false, null, z, e.this.krI, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.bDC() != null && fVar.bDC().length() > 0) {
            return fVar.bDC();
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

    public void sA(boolean z) {
        this.krO = z;
    }
}
