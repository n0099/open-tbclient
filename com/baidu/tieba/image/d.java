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
/* loaded from: classes8.dex */
public class d {
    private String anD;
    private boolean dtQ;
    private String eTO;
    private String eTP;
    private String eVY;
    public String fGe;
    private Map<String, ImageUrlData> fyO;
    public ForumData jPU;
    private String jfa;
    private String kQE;
    private String kQF;
    private String kQG;
    private boolean kQH;
    private int kQJ;
    public MetaData kQK;
    public String kQL;
    public boolean kQM;
    private int kQN;
    private ArrayList<String> kQs;
    private ArrayList<AlaInfoData> kQu;
    private String kQv;
    private String kQw;
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
    private HashMap<String, String> kQt = new HashMap<>();
    private boolean mIsReserver = true;
    private a kQx = null;
    private int kQy = 0;
    private boolean kQz = false;
    private boolean kQA = false;
    private b kQB = null;
    private AdvertAppInfo kQC = null;
    private boolean kQD = false;
    private boolean kQI = false;

    /* loaded from: classes8.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void bz(int i, String str);
    }

    public d(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        this.dtQ = false;
        this.kQs = arrayList;
        this.fyO = map;
        if (this.kQs == null) {
            this.kQs = new ArrayList<>();
        }
        Iterator<String> it = this.kQs.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.kQt.put(com.baidu.tieba.image.b.NK(next), next);
        }
        this.anD = str3;
        this.eVY = str4;
        this.jfa = str2;
        this.mForumId = str;
        this.kQw = str5;
        this.mThreadType = i;
        this.dtQ = this.kQw == null;
        this.mUserId = str6;
        this.mFrom = str7;
        this.mIsReset = z;
        this.kQH = false;
        this.kQJ = i2;
        this.mRecomSource = str8;
        this.mRecomAbTag = str9;
        this.mRecomWeight = str10;
        this.mRecomExtra = str11;
    }

    public void setSourceImageRectInScreen(String str) {
        this.kQF = str;
    }

    public void NM(String str) {
        this.kQG = str;
    }

    public void tl(boolean z) {
        this.kQH = z;
    }

    public String btc() {
        return this.eTO;
    }

    public String btd() {
        return this.eTP;
    }

    public ArrayList<AlaInfoData> dbB() {
        return this.kQu;
    }

    public int dbC() {
        return this.kQN;
    }

    public void tm(boolean z) {
        this.mIsReserver = z;
    }

    public void dbD() {
        this.kQD = false;
        if (!this.dtQ) {
            c(this.anD, this.kQw, 10, 0);
        }
    }

    public void dbE() {
        this.kQD = true;
        String str = this.kQs.get(0);
        if (StringUtils.isNull(this.kQv)) {
            this.kQv = com.baidu.tieba.image.b.NK(str);
        }
        c(this.anD, this.kQv, 0, 10);
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.kQx != null) {
            if (str2 == null || !str2.equals(this.kQx.getPicId())) {
                this.kQx.cancel();
            } else {
                return;
            }
        }
        this.kQx = new a(str, str2, i, i2);
        this.kQx.setPriority(3);
        this.kQx.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void tn(boolean z) {
        this.kQz = z;
    }

    public void to(boolean z) {
        this.kQA = z;
    }

    public void a(b bVar) {
        this.kQB = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private String anD;
        private z cmJ = null;
        private int kQO;
        private int kQP;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.anD = null;
            this.mPicId = null;
            this.kQO = 0;
            this.kQP = 0;
            this.mPicId = str2;
            this.anD = str;
            this.kQO = i;
            this.kQP = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public g doInBackground(Object... objArr) {
            this.cmJ = new z(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.cmJ.addPostData("kw", d.this.jfa);
            this.cmJ.addPostData("tid", this.anD);
            if (this.mPicId != null) {
                this.cmJ.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(d.this.mPostId) && !"0".equals(d.this.mPostId)) {
                this.cmJ.addPostData("post_id", d.this.mPostId);
            }
            this.cmJ.addPostData("source", String.valueOf(d.this.kQA ? 1 : 2));
            d.this.kQA = false;
            this.cmJ.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.kQO));
            this.cmJ.addPostData("prev", String.valueOf(this.kQP));
            this.cmJ.addPostData("not_see_lz", String.valueOf(d.this.kQz ? 0 : 1));
            this.cmJ.addPostData("is_top_agree", String.valueOf(d.this.kQH ? 1 : 2));
            if (!d.this.mIsReserver) {
                this.cmJ.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(d.this.mFrom, true)) {
                this.cmJ.addPostData("obj_type", d.this.mFrom);
            } else {
                this.cmJ.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(d.this.kQE)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bvr().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    d.this.kQE = com.baidu.tbadk.core.sharedPref.b.bvr().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.cmJ.addPostData("applist", d.this.kQE);
            String yA = com.baidu.helios.b.ak(TbadkCoreApplication.getInst()).yA();
            if (!TextUtils.isEmpty(yA)) {
                this.cmJ.addPostData("oaid", yA);
            }
            this.cmJ.addPostData("ad_ext_params", AdExtParam.a.bIt().bIu());
            dbF();
            this.cmJ.bvR().bwA().mNeedBackgroundLogin = false;
            String postNetData = this.cmJ.postNetData();
            if (!this.cmJ.bvR().bwB().isRequestSuccess()) {
                return null;
            }
            g gVar = new g();
            gVar.aT(postNetData, true);
            return gVar;
        }

        private void dbF() {
            this.cmJ.addPostData("forum_id", d.this.mForumId);
            this.cmJ.addPostData("user_id", d.this.mUserId == null ? "0" : d.this.mUserId);
            this.cmJ.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.cmJ.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.cmJ.addPostData("q_type", String.valueOf(au.bws().bwt() ? 2 : 1));
            this.cmJ.addPostData("_os_version", Build.VERSION.RELEASE);
            this.cmJ.addPostData("page_name", "PB");
            this.cmJ.addPostData("pic_index", String.valueOf(d.this.kQs.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
            }
            d.this.kQx = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (d.this.fyO != null) {
                d.this.kQx = null;
                if (gVar == null) {
                    if (d.this.kQB != null) {
                        String str = null;
                        int i = -1;
                        if (this.cmJ != null) {
                            i = this.cmJ.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.cmJ.getErrorString();
                            }
                        }
                        d.this.kQB.bz(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = x.isEmpty(gVar.dbO());
                if (d.this.mIsReset && !isEmpty) {
                    d.this.kQs.clear();
                    d.this.fyO.clear();
                    d.this.kQt.clear();
                }
                if (gVar.getImageNum() != 0) {
                    d.this.kQy = gVar.getImageNum();
                }
                d.this.kQC = gVar.bpj();
                d.this.kQN = gVar.kQN;
                d.this.fGe = gVar.fGe;
                d.this.replyPrivateFlag = gVar.dbQ();
                d.this.kQK = gVar.kQK;
                d.this.kQL = gVar.kQL;
                d.this.kQM = gVar.kRb == 1;
                if (this.mPicId == null) {
                    d.this.kQs.clear();
                    d.this.kQt.clear();
                }
                LinkedList<e> dbO = gVar.dbO();
                int size = dbO.size();
                if (size <= 0) {
                    d.this.dtQ = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        e eVar = dbO.get(i2);
                        String a2 = d.this.a(eVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = eVar.dbG();
                        if (at.equals(imageUrlData.id, d.this.kQG)) {
                            imageUrlData.setSourceImageRectInScreen(d.this.kQF);
                        }
                        imageUrlData.imageUrl = a2;
                        String str2 = a2 + "*" + eVar.dbK();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = eVar.bLt();
                        imageUrlData.originalSize = eVar.getOriginalSize();
                        imageUrlData.forumId = d.this.mForumId;
                        imageUrlData.forumName = d.this.jfa;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.anD, -1L);
                        imageUrlData.nid = d.this.eVY;
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(eVar.dbH(), -1L);
                        imageUrlData.userId = eVar.getUserId();
                        imageUrlData.userNameShow = StringUtils.isNull(eVar.bCC()) ? eVar.getUserName() : eVar.bCC();
                        imageUrlData.mIsReserver = d.this.mIsReserver;
                        imageUrlData.mIsSeeHost = d.this.kQz;
                        imageUrlData.overAllIndex = eVar.dbK();
                        imageUrlData.mThreadType = d.this.mThreadType;
                        imageUrlData.mPicType = eVar.getPicType();
                        imageUrlData.mTagName = eVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = eVar.dbI();
                        imageUrlData.isLongPic = eVar.isLongPic();
                        imageUrlData.isBlockedPic = eVar.dbJ();
                        imageUrlData.from = d.this.mFrom;
                        if (eVar.dbM() != null) {
                            imageUrlData.richTextArray = eVar.dbM().toString();
                        }
                        imageUrlData.isFirstPost = eVar.dbN();
                        if (eVar.btl() != null) {
                            imageUrlData.agreeData = eVar.btl();
                            imageUrlData.agreeData.isFromImageViewer = true;
                            imageUrlData.agreeData.mImageViewerFromPage = d.this.mFrom;
                            imageUrlData.agreeData.forumId = d.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.nid = imageUrlData.nid;
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = eVar.dbL();
                            if (eVar.dbN()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                            imageUrlData.agreeData.cardType = d.this.kQJ;
                            imageUrlData.agreeData.recomSource = d.this.mRecomSource;
                            imageUrlData.agreeData.recomAbTag = d.this.mRecomAbTag;
                            imageUrlData.agreeData.recomExtra = d.this.mRecomExtra;
                            imageUrlData.agreeData.recomWeight = d.this.mRecomWeight;
                        }
                        if (d.this.kQt.containsKey(imageUrlData.id)) {
                            String str3 = (String) d.this.kQt.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) d.this.fyO.get(str3);
                            if (imageUrlData2 == null) {
                                d.this.fyO.put(str3, imageUrlData);
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
                                imageUrlData2.forumName = d.this.jfa;
                                if (at.equals(imageUrlData.id, d.this.kQG)) {
                                    imageUrlData2.setSourceImageRectInScreen(d.this.kQF);
                                }
                            }
                        } else if (d.this.kQI) {
                            d.this.kQy = d.this.fyO.size();
                            d.this.kQC = null;
                        } else {
                            d.this.fyO.put(str2, imageUrlData);
                            if (d.this.kQD) {
                                d.this.kQs.add(i2, str2);
                            } else {
                                d.this.kQs.add(str2);
                            }
                            d.this.kQt.put(imageUrlData.id, str2);
                        }
                    }
                    e eVar2 = (e) x.getItem(dbO, 0);
                    if (eVar2 != null) {
                        d.this.kQv = eVar2.dbG();
                    }
                    e eVar3 = (e) x.getItem(dbO, size - 1);
                    if (eVar3 != null) {
                        d.this.kQw = eVar3.dbG();
                        d.this.dtQ = ((long) d.this.kQy) == eVar3.dbK();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : d.this.fyO.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : d.this.fyO.values()) {
                                if (imageUrlData5.postId != j || imageUrlData5.agreeData == null) {
                                    imageUrlData5 = imageUrlData3;
                                } else {
                                    imageUrlData4.agreeData = imageUrlData5.agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                    imageUrlData4.userId = imageUrlData5.userId;
                                    imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                    imageUrlData4.forumId = d.this.mForumId;
                                    imageUrlData4.forumName = d.this.jfa;
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
                            imageUrlData4.forumName = d.this.jfa;
                        }
                    }
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    d.this.anD = this.anD;
                    z = true;
                }
                int position = d.this.kQD ? x.getPosition(d.this.kQs, (String) d.this.kQt.get(this.mPicId)) - 1 : i3;
                d.this.eTO = gVar.btc();
                d.this.eTP = gVar.btd();
                d.this.jPU = gVar.bFL();
                if (d.this.kQu == null) {
                    d.this.kQu = new ArrayList();
                    if (gVar.dbP() != null && gVar.dbO().size() > 0) {
                        d.this.kQu.addAll(gVar.dbP());
                    }
                }
                if (d.this.kQB != null) {
                    d.this.kQB.a(d.this.kQs, position, d.this.kQy, false, null, z, d.this.kQC, isEmpty);
                }
                d.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(e eVar) {
        if (eVar.bLn() != null && eVar.bLn().length() > 0) {
            return eVar.bLn();
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

    public void tp(boolean z) {
        this.kQI = z;
    }
}
