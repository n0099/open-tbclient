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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.AdExtParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes7.dex */
public class d {
    private String amM;
    private boolean dpa;
    private String ePd;
    private String ePe;
    private String eRn;
    public String fBw;
    private Map<String, ImageUrlData> fug;
    public ForumData jLo;
    private String jat;
    private ArrayList<String> kLN;
    private ArrayList<AlaInfoData> kLP;
    private String kLQ;
    private String kLR;
    private String kLZ;
    private String kMa;
    private String kMb;
    private boolean kMc;
    private int kMe;
    public MetaData kMf;
    public String kMg;
    public boolean kMh;
    private int kMi;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private String mPostId;
    private String mRecomAbTag;
    private String mRecomExtra;
    private String mRecomSource;
    private String mRecomWeight;
    private int mThreadType;
    private String mUserId;
    public int replyPrivateFlag;
    private HashMap<String, String> kLO = new HashMap<>();
    private boolean mIsReserver = true;
    private a kLS = null;
    private int kLT = 0;
    private boolean kLU = false;
    private boolean kLV = false;
    private b kLW = null;
    private AdvertAppInfo kLX = null;
    private boolean kLY = false;
    private boolean kMd = false;

    /* loaded from: classes7.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void bA(int i, String str);
    }

    public d(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        this.dpa = false;
        this.kLN = arrayList;
        this.fug = map;
        if (this.kLN == null) {
            this.kLN = new ArrayList<>();
        }
        Iterator<String> it = this.kLN.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.kLO.put(com.baidu.tieba.image.b.MC(next), next);
        }
        this.amM = str3;
        this.eRn = str4;
        this.jat = str2;
        this.mForumId = str;
        this.kLR = str5;
        this.mThreadType = i;
        this.dpa = this.kLR == null;
        this.mUserId = str6;
        this.mFrom = str7;
        this.mIsReset = z;
        this.kMc = false;
        this.kMe = i2;
        this.mRecomSource = str8;
        this.mRecomAbTag = str9;
        this.mRecomWeight = str10;
        this.mRecomExtra = str11;
    }

    public void setSourceImageRectInScreen(String str) {
        this.kMa = str;
    }

    public void ME(String str) {
        this.kMb = str;
    }

    public void th(boolean z) {
        this.kMc = z;
    }

    public String bpi() {
        return this.ePd;
    }

    public String bpj() {
        return this.ePe;
    }

    public ArrayList<AlaInfoData> cXJ() {
        return this.kLP;
    }

    public int cXK() {
        return this.kMi;
    }

    public void ti(boolean z) {
        this.mIsReserver = z;
    }

    public void cXL() {
        this.kLY = false;
        if (!this.dpa) {
            c(this.amM, this.kLR, 10, 0);
        }
    }

    public void cXM() {
        this.kLY = true;
        String str = this.kLN.get(0);
        if (StringUtils.isNull(this.kLQ)) {
            this.kLQ = com.baidu.tieba.image.b.MC(str);
        }
        c(this.amM, this.kLQ, 0, 10);
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.kLS != null) {
            if (str2 == null || !str2.equals(this.kLS.getPicId())) {
                this.kLS.cancel();
            } else {
                return;
            }
        }
        this.kLS = new a(str, str2, i, i2);
        this.kLS.setPriority(3);
        this.kLS.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void tj(boolean z) {
        this.kLU = z;
    }

    public void tk(boolean z) {
        this.kLV = z;
    }

    public void a(b bVar) {
        this.kLW = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private String amM;
        private z chV = null;
        private int kMj;
        private int kMk;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.amM = null;
            this.mPicId = null;
            this.kMj = 0;
            this.kMk = 0;
            this.mPicId = str2;
            this.amM = str;
            this.kMj = i;
            this.kMk = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public g doInBackground(Object... objArr) {
            this.chV = new z(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.chV.addPostData("kw", d.this.jat);
            this.chV.addPostData("tid", this.amM);
            if (this.mPicId != null) {
                this.chV.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(d.this.mPostId) && !"0".equals(d.this.mPostId)) {
                this.chV.addPostData("post_id", d.this.mPostId);
            }
            this.chV.addPostData("source", String.valueOf(d.this.kLV ? 1 : 2));
            d.this.kLV = false;
            this.chV.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.kMj));
            this.chV.addPostData("prev", String.valueOf(this.kMk));
            this.chV.addPostData("not_see_lz", String.valueOf(d.this.kLU ? 0 : 1));
            this.chV.addPostData("is_top_agree", String.valueOf(d.this.kMc ? 1 : 2));
            if (!d.this.mIsReserver) {
                this.chV.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(d.this.mFrom, true)) {
                this.chV.addPostData("obj_type", d.this.mFrom);
            } else {
                this.chV.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(d.this.kLZ)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.brx().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    d.this.kLZ = com.baidu.tbadk.core.sharedPref.b.brx().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.chV.addPostData("applist", d.this.kLZ);
            String uF = com.baidu.helios.b.aj(TbadkCoreApplication.getInst()).uF();
            if (!TextUtils.isEmpty(uF)) {
                this.chV.addPostData("oaid", uF);
            }
            this.chV.addPostData("ad_ext_params", AdExtParam.a.bEB().bEC());
            cXN();
            this.chV.brX().bsG().mNeedBackgroundLogin = false;
            String postNetData = this.chV.postNetData();
            if (!this.chV.brX().bsH().isRequestSuccess()) {
                return null;
            }
            g gVar = new g();
            gVar.aT(postNetData, true);
            return gVar;
        }

        private void cXN() {
            this.chV.addPostData("forum_id", d.this.mForumId);
            this.chV.addPostData("user_id", d.this.mUserId == null ? "0" : d.this.mUserId);
            this.chV.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.chV.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.chV.addPostData("q_type", String.valueOf(au.bsy().bsz() ? 2 : 1));
            this.chV.addPostData("_os_version", Build.VERSION.RELEASE);
            this.chV.addPostData("page_name", "PB");
            this.chV.addPostData("pic_index", String.valueOf(d.this.kLN.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.chV != null) {
                this.chV.cancelNetConnect();
            }
            d.this.kLS = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (d.this.fug != null) {
                d.this.kLS = null;
                if (gVar == null) {
                    if (d.this.kLW != null) {
                        String str = null;
                        int i = -1;
                        if (this.chV != null) {
                            i = this.chV.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.chV.getErrorString();
                            }
                        }
                        d.this.kLW.bA(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = x.isEmpty(gVar.cXW());
                if (d.this.mIsReset && !isEmpty) {
                    d.this.kLN.clear();
                    d.this.fug.clear();
                    d.this.kLO.clear();
                }
                if (gVar.getImageNum() != 0) {
                    d.this.kLT = gVar.getImageNum();
                }
                d.this.kLX = gVar.blp();
                d.this.kMi = gVar.kMi;
                d.this.fBw = gVar.fBw;
                d.this.replyPrivateFlag = gVar.cXY();
                d.this.kMf = gVar.kMf;
                d.this.kMg = gVar.kMg;
                d.this.kMh = gVar.kMw == 1;
                if (this.mPicId == null) {
                    d.this.kLN.clear();
                    d.this.kLO.clear();
                }
                LinkedList<e> cXW = gVar.cXW();
                int size = cXW.size();
                if (size <= 0) {
                    d.this.dpa = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        e eVar = cXW.get(i2);
                        String a2 = d.this.a(eVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = eVar.cXO();
                        if (at.equals(imageUrlData.id, d.this.kMb)) {
                            imageUrlData.setSourceImageRectInScreen(d.this.kMa);
                        }
                        imageUrlData.imageUrl = a2;
                        String str2 = a2 + "*" + eVar.cXS();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = eVar.bHB();
                        imageUrlData.originalSize = eVar.getOriginalSize();
                        imageUrlData.forumId = d.this.mForumId;
                        imageUrlData.forumName = d.this.jat;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.amM, -1L);
                        imageUrlData.nid = d.this.eRn;
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(eVar.cXP(), -1L);
                        imageUrlData.userId = eVar.getUserId();
                        imageUrlData.userNameShow = StringUtils.isNull(eVar.byI()) ? eVar.getUserName() : eVar.byI();
                        imageUrlData.mIsReserver = d.this.mIsReserver;
                        imageUrlData.mIsSeeHost = d.this.kLU;
                        imageUrlData.overAllIndex = eVar.cXS();
                        imageUrlData.mThreadType = d.this.mThreadType;
                        imageUrlData.mPicType = eVar.getPicType();
                        imageUrlData.mTagName = eVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = eVar.cXQ();
                        imageUrlData.isLongPic = eVar.isLongPic();
                        imageUrlData.isBlockedPic = eVar.cXR();
                        imageUrlData.from = d.this.mFrom;
                        if (eVar.cXU() != null) {
                            imageUrlData.richTextArray = eVar.cXU().toString();
                        }
                        imageUrlData.isFirstPost = eVar.cXV();
                        if (eVar.bpr() != null) {
                            imageUrlData.agreeData = eVar.bpr();
                            imageUrlData.agreeData.isFromImageViewer = true;
                            imageUrlData.agreeData.mImageViewerFromPage = d.this.mFrom;
                            imageUrlData.agreeData.forumId = d.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.nid = imageUrlData.nid;
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = eVar.cXT();
                            if (eVar.cXV()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                            imageUrlData.agreeData.cardType = d.this.kMe;
                            imageUrlData.agreeData.recomSource = d.this.mRecomSource;
                            imageUrlData.agreeData.recomAbTag = d.this.mRecomAbTag;
                            imageUrlData.agreeData.recomExtra = d.this.mRecomExtra;
                            imageUrlData.agreeData.recomWeight = d.this.mRecomWeight;
                        }
                        if (d.this.kLO.containsKey(imageUrlData.id)) {
                            String str3 = (String) d.this.kLO.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) d.this.fug.get(str3);
                            if (imageUrlData2 == null) {
                                d.this.fug.put(str3, imageUrlData);
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
                                imageUrlData2.forumId = d.this.mForumId;
                                imageUrlData2.forumName = d.this.jat;
                                if (at.equals(imageUrlData.id, d.this.kMb)) {
                                    imageUrlData2.setSourceImageRectInScreen(d.this.kMa);
                                }
                            }
                        } else if (d.this.kMd) {
                            d.this.kLT = d.this.fug.size();
                            d.this.kLX = null;
                        } else {
                            d.this.fug.put(str2, imageUrlData);
                            if (d.this.kLY) {
                                d.this.kLN.add(i2, str2);
                            } else {
                                d.this.kLN.add(str2);
                            }
                            d.this.kLO.put(imageUrlData.id, str2);
                        }
                    }
                    e eVar2 = (e) x.getItem(cXW, 0);
                    if (eVar2 != null) {
                        d.this.kLQ = eVar2.cXO();
                    }
                    e eVar3 = (e) x.getItem(cXW, size - 1);
                    if (eVar3 != null) {
                        d.this.kLR = eVar3.cXO();
                        d.this.dpa = ((long) d.this.kLT) == eVar3.cXS();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : d.this.fug.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : d.this.fug.values()) {
                                if (imageUrlData5.postId != j || imageUrlData5.agreeData == null) {
                                    imageUrlData5 = imageUrlData3;
                                } else {
                                    imageUrlData4.agreeData = imageUrlData5.agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                    imageUrlData4.userId = imageUrlData5.userId;
                                    imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                    imageUrlData4.forumId = d.this.mForumId;
                                    imageUrlData4.forumName = d.this.jat;
                                }
                                imageUrlData3 = imageUrlData5;
                            }
                        } else if (j == imageUrlData3.postId) {
                            imageUrlData4.agreeData = imageUrlData3.agreeData;
                            imageUrlData4.richTextArray = imageUrlData3.richTextArray;
                            imageUrlData4.commentNum = imageUrlData3.commentNum;
                            imageUrlData4.userId = imageUrlData3.userId;
                            imageUrlData4.userNameShow = imageUrlData3.userNameShow;
                            imageUrlData4.forumId = d.this.mForumId;
                            imageUrlData4.forumName = d.this.jat;
                        }
                    }
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    d.this.amM = this.amM;
                    z = true;
                }
                int position = d.this.kLY ? x.getPosition(d.this.kLN, (String) d.this.kLO.get(this.mPicId)) - 1 : i3;
                d.this.ePd = gVar.bpi();
                d.this.ePe = gVar.bpj();
                d.this.jLo = gVar.bBS();
                if (d.this.kLP == null) {
                    d.this.kLP = new ArrayList();
                    if (gVar.cXX() != null && gVar.cXW().size() > 0) {
                        d.this.kLP.addAll(gVar.cXX());
                    }
                }
                if (d.this.kLW != null) {
                    d.this.kLW.a(d.this.kLN, position, d.this.kLT, false, null, z, d.this.kLX, isEmpty);
                }
                d.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(e eVar) {
        if (eVar.bHv() != null && eVar.bHv().length() > 0) {
            return eVar.bHv();
        }
        StringBuilder sb = new StringBuilder(150);
        int threadImageMaxWidth = TbConfig.getThreadImageMaxWidth();
        if (eVar.getHeight() * eVar.getWidth() > threadImageMaxWidth * threadImageMaxWidth) {
            double sqrt = Math.sqrt((threadImageMaxWidth * threadImageMaxWidth) / (eVar.getHeight() * eVar.getWidth()));
            sb.append("width=");
            sb.append(String.valueOf((int) (eVar.getWidth() * sqrt)));
            sb.append("&height=");
            sb.append(String.valueOf((int) (sqrt * eVar.getHeight())));
        } else {
            sb.append("width=");
            sb.append(String.valueOf(eVar.getWidth()));
            sb.append("&height=");
            sb.append(String.valueOf(eVar.getHeight()));
        }
        sb.append("&src=");
        sb.append(at.getUrlEncode(eVar.getImageUrl()));
        return sb.toString();
    }

    public void tl(boolean z) {
        this.kMd = z;
    }
}
