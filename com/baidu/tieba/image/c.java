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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.AdExtParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes20.dex */
public class c {
    private String alZ;
    private boolean dhP;
    private String eCS;
    private String eCT;
    private Map<String, ImageUrlData> fhG;
    public String foT;
    private String iHV;
    public ForumData jpQ;
    private ArrayList<String> kxJ;
    private ArrayList<AlaInfoData> kxL;
    private String kxM;
    private String kxN;
    private String kxV;
    private String kxW;
    private String kxX;
    private boolean kxY;
    private int kya;
    public MetaData kyb;
    public String kyc;
    public boolean kyd;
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
    private HashMap<String, String> kxK = new HashMap<>();
    private boolean mIsReserver = true;
    private a kxO = null;
    private int kxP = 0;
    private boolean kxQ = false;
    private boolean kxR = false;
    private b kxS = null;
    private AdvertAppInfo kxT = null;
    private boolean kxU = false;
    private boolean kxZ = false;

    /* loaded from: classes20.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void bz(int i, String str);
    }

    public c(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        this.dhP = false;
        this.kxJ = arrayList;
        this.fhG = map;
        if (this.kxJ == null) {
            this.kxJ = new ArrayList<>();
        }
        Iterator<String> it = this.kxJ.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.kxK.put(com.baidu.tieba.image.b.MW(next), next);
        }
        this.alZ = str3;
        this.mNid = str4;
        this.iHV = str2;
        this.mForumId = str;
        this.kxN = str5;
        this.mThreadType = i;
        this.dhP = this.kxN == null;
        this.mUserId = str6;
        this.mFrom = str7;
        this.mIsReset = z;
        this.kxY = false;
        this.kya = i2;
        this.mRecomSource = str8;
        this.mRecomAbTag = str9;
        this.mRecomWeight = str10;
        this.mRecomExtra = str11;
    }

    public void setSourceImageRectInScreen(String str) {
        this.kxW = str;
    }

    public void MY(String str) {
        this.kxX = str;
    }

    public void sI(boolean z) {
        this.kxY = z;
    }

    public String bnm() {
        return this.eCS;
    }

    public String bnn() {
        return this.eCT;
    }

    public ArrayList<AlaInfoData> cWH() {
        return this.kxL;
    }

    public void sJ(boolean z) {
        this.mIsReserver = z;
    }

    public void cWI() {
        this.kxU = false;
        if (!this.dhP) {
            c(this.alZ, this.kxN, 10, 0);
        }
    }

    public void cWJ() {
        this.kxU = true;
        String str = this.kxJ.get(0);
        if (StringUtils.isNull(this.kxM)) {
            this.kxM = com.baidu.tieba.image.b.MW(str);
        }
        c(this.alZ, this.kxM, 0, 10);
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.kxO != null) {
            if (str2 == null || !str2.equals(this.kxO.getPicId())) {
                this.kxO.cancel();
            } else {
                return;
            }
        }
        this.kxO = new a(str, str2, i, i2);
        this.kxO.setPriority(3);
        this.kxO.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void sK(boolean z) {
        this.kxQ = z;
    }

    public void sL(boolean z) {
        this.kxR = z;
    }

    public void a(b bVar) {
        this.kxS = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a extends BdAsyncTask<Object, Integer, f> {
        private String alZ;
        private aa bZh = null;
        private int kye;
        private int kyf;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.alZ = null;
            this.mPicId = null;
            this.kye = 0;
            this.kyf = 0;
            this.mPicId = str2;
            this.alZ = str;
            this.kye = i;
            this.kyf = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public f doInBackground(Object... objArr) {
            this.bZh = new aa(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.bZh.addPostData("kw", c.this.iHV);
            this.bZh.addPostData("tid", this.alZ);
            if (this.mPicId != null) {
                this.bZh.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(c.this.mPostId) && !"0".equals(c.this.mPostId)) {
                this.bZh.addPostData("post_id", c.this.mPostId);
            }
            this.bZh.addPostData("source", String.valueOf(c.this.kxR ? 1 : 2));
            c.this.kxR = false;
            this.bZh.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.kye));
            this.bZh.addPostData("prev", String.valueOf(this.kyf));
            this.bZh.addPostData("not_see_lz", String.valueOf(c.this.kxQ ? 0 : 1));
            this.bZh.addPostData("is_top_agree", String.valueOf(c.this.kxY ? 1 : 2));
            if (!c.this.mIsReserver) {
                this.bZh.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(c.this.mFrom, true)) {
                this.bZh.addPostData("obj_type", c.this.mFrom);
            } else {
                this.bZh.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(c.this.kxV)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bpu().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    c.this.kxV = com.baidu.tbadk.core.sharedPref.b.bpu().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.bZh.addPostData("applist", c.this.kxV);
            String zr = com.baidu.helios.b.aj(TbadkCoreApplication.getInst()).zr();
            if (!TextUtils.isEmpty(zr)) {
                this.bZh.addPostData("oaid", zr);
            }
            this.bZh.addPostData("ad_ext_params", AdExtParam.a.bCw().bCx());
            cWK();
            this.bZh.bqa().bqH().mNeedBackgroundLogin = false;
            String postNetData = this.bZh.postNetData();
            if (!this.bZh.bqa().bqI().isRequestSuccess()) {
                return null;
            }
            f fVar = new f();
            fVar.aS(postNetData, true);
            return fVar;
        }

        private void cWK() {
            this.bZh.addPostData("forum_id", c.this.mForumId);
            this.bZh.addPostData("user_id", c.this.mUserId == null ? "0" : c.this.mUserId);
            this.bZh.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.bZh.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.bZh.addPostData("q_type", String.valueOf(av.bqC().bqD() ? 2 : 1));
            this.bZh.addPostData("_os_version", Build.VERSION.RELEASE);
            this.bZh.addPostData("page_name", "PB");
            this.bZh.addPostData("pic_index", String.valueOf(c.this.kxJ.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bZh != null) {
                this.bZh.cancelNetConnect();
            }
            c.this.kxO = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(f fVar) {
            super.onPostExecute(fVar);
            if (c.this.fhG != null) {
                c.this.kxO = null;
                if (fVar == null) {
                    if (c.this.kxS != null) {
                        String str = null;
                        int i = -1;
                        if (this.bZh != null) {
                            i = this.bZh.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.bZh.getErrorString();
                            }
                        }
                        c.this.kxS.bz(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = y.isEmpty(fVar.cWT());
                if (c.this.mIsReset && !isEmpty) {
                    c.this.kxJ.clear();
                    c.this.fhG.clear();
                    c.this.kxK.clear();
                }
                if (fVar.getImageNum() != 0) {
                    c.this.kxP = fVar.getImageNum();
                }
                c.this.kxT = fVar.cWW();
                c.this.foT = fVar.foT;
                c.this.replyPrivateFlag = fVar.cWV();
                c.this.kyb = fVar.kyb;
                c.this.kyc = fVar.kyc;
                c.this.kyd = fVar.kyr == 1;
                if (this.mPicId == null) {
                    c.this.kxJ.clear();
                    c.this.kxK.clear();
                }
                LinkedList<d> cWT = fVar.cWT();
                int size = cWT.size();
                if (size <= 0) {
                    c.this.dhP = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        d dVar = cWT.get(i2);
                        String a2 = c.this.a(dVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = dVar.cWL();
                        if (au.equals(imageUrlData.id, c.this.kxX)) {
                            imageUrlData.setSourceImageRectInScreen(c.this.kxW);
                        }
                        imageUrlData.imageUrl = a2;
                        String str2 = a2 + "*" + dVar.cWP();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = dVar.bFA();
                        imageUrlData.originalSize = dVar.getOriginalSize();
                        imageUrlData.forumId = c.this.mForumId;
                        imageUrlData.forumName = c.this.iHV;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.alZ, -1L);
                        imageUrlData.nid = c.this.mNid;
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(dVar.cWM(), -1L);
                        imageUrlData.userId = dVar.getUserId();
                        imageUrlData.userNameShow = StringUtils.isNull(dVar.bwH()) ? dVar.getUserName() : dVar.bwH();
                        imageUrlData.mIsReserver = c.this.mIsReserver;
                        imageUrlData.mIsSeeHost = c.this.kxQ;
                        imageUrlData.overAllIndex = dVar.cWP();
                        imageUrlData.mThreadType = c.this.mThreadType;
                        imageUrlData.mPicType = dVar.getPicType();
                        imageUrlData.mTagName = dVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = dVar.cWN();
                        imageUrlData.isLongPic = dVar.isLongPic();
                        imageUrlData.isBlockedPic = dVar.cWO();
                        imageUrlData.from = c.this.mFrom;
                        if (dVar.cWR() != null) {
                            imageUrlData.richTextArray = dVar.cWR().toString();
                        }
                        imageUrlData.isFirstPost = dVar.cWS();
                        if (dVar.bnv() != null) {
                            imageUrlData.agreeData = dVar.bnv();
                            imageUrlData.agreeData.isFromImageViewer = true;
                            imageUrlData.agreeData.mImageViewerFromPage = c.this.mFrom;
                            imageUrlData.agreeData.forumId = c.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.nid = imageUrlData.nid;
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = dVar.cWQ();
                            if (dVar.cWS()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                            imageUrlData.agreeData.cardType = c.this.kya;
                            imageUrlData.agreeData.recomSource = c.this.mRecomSource;
                            imageUrlData.agreeData.recomAbTag = c.this.mRecomAbTag;
                            imageUrlData.agreeData.recomExtra = c.this.mRecomExtra;
                            imageUrlData.agreeData.recomWeight = c.this.mRecomWeight;
                        }
                        if (c.this.kxK.containsKey(imageUrlData.id)) {
                            String str3 = (String) c.this.kxK.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) c.this.fhG.get(str3);
                            if (imageUrlData2 == null) {
                                c.this.fhG.put(str3, imageUrlData);
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
                                imageUrlData2.forumId = c.this.mForumId;
                                imageUrlData2.forumName = c.this.iHV;
                                if (au.equals(imageUrlData.id, c.this.kxX)) {
                                    imageUrlData2.setSourceImageRectInScreen(c.this.kxW);
                                }
                            }
                        } else if (c.this.kxZ) {
                            c.this.kxP = c.this.fhG.size();
                            c.this.kxT = null;
                        } else {
                            c.this.fhG.put(str2, imageUrlData);
                            if (c.this.kxU) {
                                c.this.kxJ.add(i2, str2);
                            } else {
                                c.this.kxJ.add(str2);
                            }
                            c.this.kxK.put(imageUrlData.id, str2);
                        }
                    }
                    d dVar2 = (d) y.getItem(cWT, 0);
                    if (dVar2 != null) {
                        c.this.kxM = dVar2.cWL();
                    }
                    d dVar3 = (d) y.getItem(cWT, size - 1);
                    if (dVar3 != null) {
                        c.this.kxN = dVar3.cWL();
                        c.this.dhP = ((long) c.this.kxP) == dVar3.cWP();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : c.this.fhG.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : c.this.fhG.values()) {
                                if (imageUrlData5.postId != j || imageUrlData5.agreeData == null) {
                                    imageUrlData5 = imageUrlData3;
                                } else {
                                    imageUrlData4.agreeData = imageUrlData5.agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                    imageUrlData4.userId = imageUrlData5.userId;
                                    imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                    imageUrlData4.forumId = c.this.mForumId;
                                    imageUrlData4.forumName = c.this.iHV;
                                }
                                imageUrlData3 = imageUrlData5;
                            }
                        } else if (j == imageUrlData3.postId) {
                            imageUrlData4.agreeData = imageUrlData3.agreeData;
                            imageUrlData4.richTextArray = imageUrlData3.richTextArray;
                            imageUrlData4.commentNum = imageUrlData3.commentNum;
                            imageUrlData4.userId = imageUrlData3.userId;
                            imageUrlData4.userNameShow = imageUrlData3.userNameShow;
                            imageUrlData4.forumId = c.this.mForumId;
                            imageUrlData4.forumName = c.this.iHV;
                        }
                    }
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    c.this.alZ = this.alZ;
                    z = true;
                }
                int position = c.this.kxU ? y.getPosition(c.this.kxJ, (String) c.this.kxK.get(this.mPicId)) - 1 : i3;
                c.this.eCS = fVar.bnm();
                c.this.eCT = fVar.bnn();
                c.this.jpQ = fVar.bzP();
                if (c.this.kxL == null) {
                    c.this.kxL = new ArrayList();
                    if (fVar.cWU() != null && fVar.cWT().size() > 0) {
                        c.this.kxL.addAll(fVar.cWU());
                    }
                }
                if (c.this.kxS != null) {
                    c.this.kxS.a(c.this.kxJ, position, c.this.kxP, false, null, z, c.this.kxT, isEmpty);
                }
                c.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(d dVar) {
        if (dVar.bFu() != null && dVar.bFu().length() > 0) {
            return dVar.bFu();
        }
        StringBuilder sb = new StringBuilder(150);
        int threadImageMaxWidth = TbConfig.getThreadImageMaxWidth();
        if (dVar.getHeight() * dVar.getWidth() > threadImageMaxWidth * threadImageMaxWidth) {
            double sqrt = Math.sqrt((threadImageMaxWidth * threadImageMaxWidth) / (dVar.getHeight() * dVar.getWidth()));
            sb.append("width=");
            sb.append(String.valueOf((int) (dVar.getWidth() * sqrt)));
            sb.append("&height=");
            sb.append(String.valueOf((int) (sqrt * dVar.getHeight())));
        } else {
            sb.append("width=");
            sb.append(String.valueOf(dVar.getWidth()));
            sb.append("&height=");
            sb.append(String.valueOf(dVar.getHeight()));
        }
        sb.append("&src=");
        sb.append(au.getUrlEncode(dVar.getImageUrl()));
        return sb.toString();
    }

    public void sM(boolean z) {
        this.kxZ = z;
    }
}
