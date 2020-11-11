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
    private boolean djz;
    private String eEA;
    private String eEB;
    private Map<String, ImageUrlData> fiB;
    public String fpM;
    private String iHh;
    public ForumData jpk;
    private String kxG;
    private String kxH;
    private String kxI;
    private boolean kxJ;
    private int kxL;
    public MetaData kxM;
    public String kxN;
    public boolean kxO;
    private ArrayList<String> kxu;
    private ArrayList<AlaInfoData> kxw;
    private String kxx;
    private String kxy;
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
    private HashMap<String, String> kxv = new HashMap<>();
    private boolean mIsReserver = true;
    private a kxz = null;
    private int kxA = 0;
    private boolean kxB = false;
    private boolean kxC = false;
    private b kxD = null;
    private AdvertAppInfo kxE = null;
    private boolean kxF = false;
    private boolean kxK = false;

    /* loaded from: classes21.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void bB(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        this.djz = false;
        this.kxu = arrayList;
        this.fiB = map;
        if (this.kxu == null) {
            this.kxu = new ArrayList<>();
        }
        Iterator<String> it = this.kxu.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.kxv.put(d.Ny(next), next);
        }
        this.alT = str3;
        this.mNid = str4;
        this.iHh = str2;
        this.mForumId = str;
        this.kxy = str5;
        this.mThreadType = i;
        this.djz = this.kxy == null;
        this.mUserId = str6;
        this.mFrom = str7;
        this.mIsReset = z;
        this.kxJ = false;
        this.kxL = i2;
        this.mRecomSource = str8;
        this.mRecomAbTag = str9;
        this.mRecomWeight = str10;
        this.mRecomExtra = str11;
    }

    public void setSourceImageRectInScreen(String str) {
        this.kxH = str;
    }

    public void NA(String str) {
        this.kxI = str;
    }

    public void sF(boolean z) {
        this.kxJ = z;
    }

    public String boi() {
        return this.eEA;
    }

    public String boj() {
        return this.eEB;
    }

    public ArrayList<AlaInfoData> cXl() {
        return this.kxw;
    }

    public void sG(boolean z) {
        this.mIsReserver = z;
    }

    public void cXm() {
        this.kxF = false;
        if (!this.djz) {
            c(this.alT, this.kxy, 10, 0);
        }
    }

    public void cXn() {
        this.kxF = true;
        String str = this.kxu.get(0);
        if (StringUtils.isNull(this.kxx)) {
            this.kxx = d.Ny(str);
        }
        c(this.alT, this.kxx, 0, 10);
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.kxz != null) {
            if (str2 == null || !str2.equals(this.kxz.getPicId())) {
                this.kxz.cancel();
            } else {
                return;
            }
        }
        this.kxz = new a(str, str2, i, i2);
        this.kxz.setPriority(3);
        this.kxz.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void sH(boolean z) {
        this.kxB = z;
    }

    public void sI(boolean z) {
        this.kxC = z;
    }

    public void a(b bVar) {
        this.kxD = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String alT;
        private aa caS = null;
        private int kxP;
        private int kxQ;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.alT = null;
            this.mPicId = null;
            this.kxP = 0;
            this.kxQ = 0;
            this.mPicId = str2;
            this.alT = str;
            this.kxP = i;
            this.kxQ = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public h doInBackground(Object... objArr) {
            this.caS = new aa(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.caS.addPostData("kw", e.this.iHh);
            this.caS.addPostData("tid", this.alT);
            if (this.mPicId != null) {
                this.caS.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.caS.addPostData("post_id", e.this.mPostId);
            }
            this.caS.addPostData("source", String.valueOf(e.this.kxC ? 1 : 2));
            e.this.kxC = false;
            this.caS.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.kxP));
            this.caS.addPostData("prev", String.valueOf(this.kxQ));
            this.caS.addPostData("not_see_lz", String.valueOf(e.this.kxB ? 0 : 1));
            this.caS.addPostData("is_top_agree", String.valueOf(e.this.kxJ ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.caS.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.caS.addPostData("obj_type", e.this.mFrom);
            } else {
                this.caS.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.kxG)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bqh().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.kxG = com.baidu.tbadk.core.sharedPref.b.bqh().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.caS.addPostData("applist", e.this.kxG);
            String bDP = y.bDP();
            if (!TextUtils.isEmpty(bDP)) {
                this.caS.addPostData("oaid", bDP);
            }
            this.caS.addPostData("ad_ext_params", AdExtParam.a.bDd().bDe());
            cXo();
            this.caS.bqN().brt().mNeedBackgroundLogin = false;
            String postNetData = this.caS.postNetData();
            if (!this.caS.bqN().bru().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.aS(postNetData, true);
            return hVar;
        }

        private void cXo() {
            this.caS.addPostData("forum_id", e.this.mForumId);
            this.caS.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.caS.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.caS.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.caS.addPostData("q_type", String.valueOf(au.bro().brp() ? 2 : 1));
            this.caS.addPostData("_os_version", Build.VERSION.RELEASE);
            this.caS.addPostData("page_name", "PB");
            this.caS.addPostData("pic_index", String.valueOf(e.this.kxu.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.caS != null) {
                this.caS.cancelNetConnect();
            }
            e.this.kxz = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.fiB != null) {
                e.this.kxz = null;
                if (hVar == null) {
                    if (e.this.kxD != null) {
                        String str = null;
                        int i = -1;
                        if (this.caS != null) {
                            i = this.caS.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.caS.getErrorString();
                            }
                        }
                        e.this.kxD.bB(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(hVar.cXx());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.kxu.clear();
                    e.this.fiB.clear();
                    e.this.kxv.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.kxA = hVar.getImageNum();
                }
                e.this.kxE = hVar.cXA();
                e.this.fpM = hVar.fpM;
                e.this.replyPrivateFlag = hVar.cXz();
                e.this.kxM = hVar.kxM;
                e.this.kxN = hVar.kxN;
                e.this.kxO = hVar.kyc == 1;
                if (this.mPicId == null) {
                    e.this.kxu.clear();
                    e.this.kxv.clear();
                }
                LinkedList<f> cXx = hVar.cXx();
                int size = cXx.size();
                if (size <= 0) {
                    e.this.djz = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = cXx.get(i2);
                        String a2 = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.cXp();
                        if (at.equals(imageUrlData.id, e.this.kxI)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.kxH);
                        }
                        imageUrlData.imageUrl = a2;
                        String str2 = a2 + "*" + fVar.cXt();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.bGh();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.forumName = e.this.iHh;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.alT, -1L);
                        imageUrlData.nid = e.this.mNid;
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.cXq(), -1L);
                        imageUrlData.userId = fVar.getUserId();
                        imageUrlData.userNameShow = StringUtils.isNull(fVar.bxr()) ? fVar.getUserName() : fVar.bxr();
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.kxB;
                        imageUrlData.overAllIndex = fVar.cXt();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.cXr();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.cXs();
                        imageUrlData.from = e.this.mFrom;
                        if (fVar.cXv() != null) {
                            imageUrlData.richTextArray = fVar.cXv().toString();
                        }
                        imageUrlData.isFirstPost = fVar.cXw();
                        if (fVar.bor() != null) {
                            imageUrlData.agreeData = fVar.bor();
                            imageUrlData.agreeData.isFromImageViewer = true;
                            imageUrlData.agreeData.mImageViewerFromPage = e.this.mFrom;
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.nid = imageUrlData.nid;
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.cXu();
                            if (fVar.cXw()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                            imageUrlData.agreeData.cardType = e.this.kxL;
                            imageUrlData.agreeData.recomSource = e.this.mRecomSource;
                            imageUrlData.agreeData.recomAbTag = e.this.mRecomAbTag;
                            imageUrlData.agreeData.recomExtra = e.this.mRecomExtra;
                            imageUrlData.agreeData.recomWeight = e.this.mRecomWeight;
                        }
                        if (e.this.kxv.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.kxv.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.fiB.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.fiB.put(str3, imageUrlData);
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
                                imageUrlData2.forumName = e.this.iHh;
                                if (at.equals(imageUrlData.id, e.this.kxI)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.kxH);
                                }
                            }
                        } else if (e.this.kxK) {
                            e.this.kxA = e.this.fiB.size();
                            e.this.kxE = null;
                        } else {
                            e.this.fiB.put(str2, imageUrlData);
                            if (e.this.kxF) {
                                e.this.kxu.add(i2, str2);
                            } else {
                                e.this.kxu.add(str2);
                            }
                            e.this.kxv.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) com.baidu.tbadk.core.util.y.getItem(cXx, 0);
                    if (fVar2 != null) {
                        e.this.kxx = fVar2.cXp();
                    }
                    f fVar3 = (f) com.baidu.tbadk.core.util.y.getItem(cXx, size - 1);
                    if (fVar3 != null) {
                        e.this.kxy = fVar3.cXp();
                        e.this.djz = ((long) e.this.kxA) == fVar3.cXt();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.fiB.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.fiB.values()) {
                                if (imageUrlData5.postId != j || imageUrlData5.agreeData == null) {
                                    imageUrlData5 = imageUrlData3;
                                } else {
                                    imageUrlData4.agreeData = imageUrlData5.agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                    imageUrlData4.userId = imageUrlData5.userId;
                                    imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                    imageUrlData4.forumId = e.this.mForumId;
                                    imageUrlData4.forumName = e.this.iHh;
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
                            imageUrlData4.forumName = e.this.iHh;
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
                int position = e.this.kxF ? com.baidu.tbadk.core.util.y.getPosition(e.this.kxu, (String) e.this.kxv.get(this.mPicId)) - 1 : i3;
                e.this.eEA = hVar.boi();
                e.this.eEB = hVar.boj();
                e.this.jpk = hVar.bAz();
                if (e.this.kxw == null) {
                    e.this.kxw = new ArrayList();
                    if (hVar.cXy() != null && hVar.cXx().size() > 0) {
                        e.this.kxw.addAll(hVar.cXy());
                    }
                }
                if (e.this.kxD != null) {
                    e.this.kxD.a(e.this.kxu, position, e.this.kxA, false, null, z, e.this.kxE, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.bGb() != null && fVar.bGb().length() > 0) {
            return fVar.bGb();
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

    public void sJ(boolean z) {
        this.kxK = z;
    }
}
