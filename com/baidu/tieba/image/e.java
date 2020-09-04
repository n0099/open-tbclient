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
    private String ala;
    private boolean cHa;
    private Map<String, ImageUrlData> eFX;
    public String eMx;
    private String ebV;
    private String ebW;
    private String hSN;
    public ForumData iAE;
    private ArrayList<AlaInfoData> jHB;
    private String jHC;
    private String jHD;
    private String jHL;
    private String jHM;
    private String jHN;
    private boolean jHO;
    private int jHQ;
    public MetaData jHR;
    public String jHS;
    public boolean jHT;
    private ArrayList<String> jHz;
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
    private HashMap<String, String> jHA = new HashMap<>();
    private boolean mIsReserver = true;
    private a jHE = null;
    private int jHF = 0;
    private boolean jHG = false;
    private boolean jHH = false;
    private b jHI = null;
    private AdvertAppInfo jHJ = null;
    private boolean jHK = false;
    private boolean jHP = false;

    /* loaded from: classes15.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void bi(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        this.cHa = false;
        this.jHz = arrayList;
        this.eFX = map;
        if (this.jHz == null) {
            this.jHz = new ArrayList<>();
        }
        Iterator<String> it = this.jHz.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.jHA.put(d.Ls(next), next);
        }
        this.ala = str3;
        this.mNid = str4;
        this.hSN = str2;
        this.mForumId = str;
        this.jHD = str5;
        this.mThreadType = i;
        this.cHa = this.jHD == null;
        this.mUserId = str6;
        this.mFrom = str7;
        this.mIsReset = z;
        this.jHO = false;
        this.jHQ = i2;
        this.mRecomSource = str8;
        this.mRecomAbTag = str9;
        this.mRecomWeight = str10;
        this.mRecomExtra = str11;
    }

    public void setSourceImageRectInScreen(String str) {
        this.jHM = str;
    }

    public void Lu(String str) {
        this.jHN = str;
    }

    public void rq(boolean z) {
        this.jHO = z;
    }

    public String bgm() {
        return this.ebV;
    }

    public String bgn() {
        return this.ebW;
    }

    public ArrayList<AlaInfoData> cKp() {
        return this.jHB;
    }

    public void rr(boolean z) {
        this.mIsReserver = z;
    }

    public void cKq() {
        this.jHK = false;
        if (!this.cHa) {
            c(this.ala, this.jHD, 10, 0);
        }
    }

    public void cKr() {
        this.jHK = true;
        String str = this.jHz.get(0);
        if (StringUtils.isNull(this.jHC)) {
            this.jHC = d.Ls(str);
        }
        c(this.ala, this.jHC, 0, 10);
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.jHE != null) {
            if (str2 == null || !str2.equals(this.jHE.getPicId())) {
                this.jHE.cancel();
            } else {
                return;
            }
        }
        this.jHE = new a(str, str2, i, i2);
        this.jHE.setPriority(3);
        this.jHE.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void rs(boolean z) {
        this.jHG = z;
    }

    public void rt(boolean z) {
        this.jHH = z;
    }

    public void a(b bVar) {
        this.jHI = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String ala;
        private aa bEb = null;
        private int jHU;
        private int jHV;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.ala = null;
            this.mPicId = null;
            this.jHU = 0;
            this.jHV = 0;
            this.mPicId = str2;
            this.ala = str;
            this.jHU = i;
            this.jHV = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public h doInBackground(Object... objArr) {
            this.bEb = new aa(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.bEb.addPostData("kw", e.this.hSN);
            this.bEb.addPostData("tid", this.ala);
            if (this.mPicId != null) {
                this.bEb.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.bEb.addPostData("post_id", e.this.mPostId);
            }
            this.bEb.addPostData("source", String.valueOf(e.this.jHH ? 1 : 2));
            e.this.jHH = false;
            this.bEb.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.jHU));
            this.bEb.addPostData("prev", String.valueOf(this.jHV));
            this.bEb.addPostData("not_see_lz", String.valueOf(e.this.jHG ? 0 : 1));
            this.bEb.addPostData("is_top_agree", String.valueOf(e.this.jHO ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.bEb.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.bEb.addPostData("obj_type", e.this.mFrom);
            } else {
                this.bEb.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.jHL)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.jHL = com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.bEb.addPostData("applist", e.this.jHL);
            String bvE = x.bvE();
            if (!TextUtils.isEmpty(bvE)) {
                this.bEb.addPostData("oaid", bvE);
            }
            this.bEb.addPostData("ad_ext_params", AdExtParam.a.buX().buY());
            cKs();
            this.bEb.biQ().bjv().mNeedBackgroundLogin = false;
            String postNetData = this.bEb.postNetData();
            if (!this.bEb.biQ().bjw().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.aM(postNetData, true);
            return hVar;
        }

        private void cKs() {
            this.bEb.addPostData("forum_id", e.this.mForumId);
            this.bEb.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.bEb.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.bEb.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.bEb.addPostData("q_type", String.valueOf(au.bjr().bjs() ? 2 : 1));
            this.bEb.addPostData("_os_version", Build.VERSION.RELEASE);
            this.bEb.addPostData("page_name", "PB");
            this.bEb.addPostData("pic_index", String.valueOf(e.this.jHz.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bEb != null) {
                this.bEb.cancelNetConnect();
            }
            e.this.jHE = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.eFX != null) {
                e.this.jHE = null;
                if (hVar == null) {
                    if (e.this.jHI != null) {
                        String str = null;
                        int i = -1;
                        if (this.bEb != null) {
                            i = this.bEb.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.bEb.getErrorString();
                            }
                        }
                        e.this.jHI.bi(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = y.isEmpty(hVar.cKB());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.jHz.clear();
                    e.this.eFX.clear();
                    e.this.jHA.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.jHF = hVar.getImageNum();
                }
                e.this.jHJ = hVar.cKE();
                e.this.eMx = hVar.eMx;
                e.this.replyPrivateFlag = hVar.cKD();
                e.this.jHR = hVar.jHR;
                e.this.jHS = hVar.jHS;
                e.this.jHT = hVar.jIh == 1;
                if (this.mPicId == null) {
                    e.this.jHz.clear();
                    e.this.jHA.clear();
                }
                LinkedList<f> cKB = hVar.cKB();
                int size = cKB.size();
                if (size <= 0) {
                    e.this.cHa = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = cKB.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.cKt();
                        if (at.equals(imageUrlData.id, e.this.jHN)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.jHM);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.cKx();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.bxW();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.forumName = e.this.hSN;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.ala, -1L);
                        imageUrlData.nid = e.this.mNid;
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.cKu(), -1L);
                        imageUrlData.userId = fVar.getUserId();
                        imageUrlData.userNameShow = StringUtils.isNull(fVar.bpv()) ? fVar.getUserName() : fVar.bpv();
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.jHG;
                        imageUrlData.overAllIndex = fVar.cKx();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.cKv();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.cKw();
                        imageUrlData.from = e.this.mFrom;
                        if (fVar.cKz() != null) {
                            imageUrlData.richTextArray = fVar.cKz().toString();
                        }
                        imageUrlData.isFirstPost = fVar.cKA();
                        if (fVar.bgv() != null) {
                            imageUrlData.agreeData = fVar.bgv();
                            imageUrlData.agreeData.isFromImageViewer = true;
                            imageUrlData.agreeData.mImageViewerFromPage = e.this.mFrom;
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.nid = imageUrlData.nid;
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.cKy();
                            if (fVar.cKA()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                            imageUrlData.agreeData.cardType = e.this.jHQ;
                            imageUrlData.agreeData.recomSource = e.this.mRecomSource;
                            imageUrlData.agreeData.recomAbTag = e.this.mRecomAbTag;
                            imageUrlData.agreeData.recomExtra = e.this.mRecomExtra;
                            imageUrlData.agreeData.recomWeight = e.this.mRecomWeight;
                        }
                        if (e.this.jHA.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.jHA.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.eFX.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.eFX.put(str3, imageUrlData);
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
                                imageUrlData2.forumName = e.this.hSN;
                                if (at.equals(imageUrlData.id, e.this.jHN)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.jHM);
                                }
                            }
                        } else if (e.this.jHP) {
                            e.this.jHF = e.this.eFX.size();
                            e.this.jHJ = null;
                        } else {
                            e.this.eFX.put(str2, imageUrlData);
                            if (e.this.jHK) {
                                e.this.jHz.add(i2, str2);
                            } else {
                                e.this.jHz.add(str2);
                            }
                            e.this.jHA.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) y.getItem(cKB, 0);
                    if (fVar2 != null) {
                        e.this.jHC = fVar2.cKt();
                    }
                    f fVar3 = (f) y.getItem(cKB, size - 1);
                    if (fVar3 != null) {
                        e.this.jHD = fVar3.cKt();
                        e.this.cHa = ((long) e.this.jHF) == fVar3.cKx();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.eFX.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.eFX.values()) {
                                if (imageUrlData5.postId != j || imageUrlData5.agreeData == null) {
                                    imageUrlData5 = imageUrlData3;
                                } else {
                                    imageUrlData4.agreeData = imageUrlData5.agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                    imageUrlData4.userId = imageUrlData5.userId;
                                    imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                    imageUrlData4.forumId = e.this.mForumId;
                                    imageUrlData4.forumName = e.this.hSN;
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
                            imageUrlData4.forumName = e.this.hSN;
                        }
                    }
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.ala = this.ala;
                    z = true;
                }
                int position = e.this.jHK ? y.getPosition(e.this.jHz, (String) e.this.jHA.get(this.mPicId)) - 1 : i3;
                e.this.ebV = hVar.bgm();
                e.this.ebW = hVar.bgn();
                e.this.iAE = hVar.bst();
                if (e.this.jHB == null) {
                    e.this.jHB = new ArrayList();
                    if (hVar.cKC() != null && hVar.cKB().size() > 0) {
                        e.this.jHB.addAll(hVar.cKC());
                    }
                }
                if (e.this.jHI != null) {
                    e.this.jHI.a(e.this.jHz, position, e.this.jHF, false, null, z, e.this.jHJ, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.bxQ() != null && fVar.bxQ().length() > 0) {
            return fVar.bxQ();
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

    public void ru(boolean z) {
        this.jHP = z;
    }
}
