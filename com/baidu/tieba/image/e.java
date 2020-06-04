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
/* loaded from: classes8.dex */
public class e {
    private String ais;
    private String dFA;
    private String dFz;
    private boolean dsC;
    private Map<String, ImageUrlData> egv;
    private String hnl;
    private ArrayList<String> iSB;
    private ArrayList<AlaInfoData> iSD;
    private String iSE;
    private String iSF;
    private String iSN;
    private String iSO;
    private String iSP;
    private boolean iSQ;
    private int iSS;
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
    private HashMap<String, String> iSC = new HashMap<>();
    private boolean mIsReserver = true;
    private a iSG = null;
    private int iSH = 0;
    private boolean iSI = false;
    private boolean iSJ = false;
    private b iSK = null;
    private AdvertAppInfo iSL = null;
    private boolean iSM = false;
    private boolean iSR = false;

    /* loaded from: classes8.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void bf(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        this.dsC = false;
        this.iSB = arrayList;
        this.egv = map;
        if (this.iSB == null) {
            this.iSB = new ArrayList<>();
        }
        Iterator<String> it = this.iSB.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.iSC.put(d.Hi(next), next);
        }
        this.ais = str3;
        this.mNid = str4;
        this.hnl = str2;
        this.mForumId = str;
        this.iSF = str5;
        this.mThreadType = i;
        this.dsC = this.iSF == null;
        this.mUserId = str6;
        this.mFrom = str7;
        this.mIsReset = z;
        this.iSQ = false;
        this.iSS = i2;
        this.mRecomSource = str8;
        this.mRecomAbTag = str9;
        this.mRecomWeight = str10;
        this.mRecomExtra = str11;
    }

    public void setSourceImageRectInScreen(String str) {
        this.iSO = str;
    }

    public void Hk(String str) {
        this.iSP = str;
    }

    public void pR(boolean z) {
        this.iSQ = z;
    }

    public String aSh() {
        return this.dFz;
    }

    public String aSi() {
        return this.dFA;
    }

    public ArrayList<AlaInfoData> crM() {
        return this.iSD;
    }

    public void pS(boolean z) {
        this.mIsReserver = z;
    }

    public void crN() {
        this.iSM = false;
        if (!this.dsC) {
            c(this.ais, this.iSF, 10, 0);
        }
    }

    public void crO() {
        this.iSM = true;
        String str = this.iSB.get(0);
        if (StringUtils.isNull(this.iSE)) {
            this.iSE = d.Hi(str);
        }
        c(this.ais, this.iSE, 0, 10);
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.iSG != null) {
            if (str2 == null || !str2.equals(this.iSG.getPicId())) {
                this.iSG.cancel();
            } else {
                return;
            }
        }
        this.iSG = new a(str, str2, i, i2);
        this.iSG.setPriority(3);
        this.iSG.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void pT(boolean z) {
        this.iSI = z;
    }

    public void pU(boolean z) {
        this.iSJ = z;
    }

    public void a(b bVar) {
        this.iSK = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String ais;
        private x bth = null;
        private int iST;
        private int iSU;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.ais = null;
            this.mPicId = null;
            this.iST = 0;
            this.iSU = 0;
            this.mPicId = str2;
            this.ais = str;
            this.iST = i;
            this.iSU = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public h doInBackground(Object... objArr) {
            this.bth = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.bth.addPostData("kw", e.this.hnl);
            this.bth.addPostData("tid", this.ais);
            if (this.mPicId != null) {
                this.bth.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.bth.addPostData("post_id", e.this.mPostId);
            }
            this.bth.addPostData("source", String.valueOf(e.this.iSJ ? 1 : 2));
            e.this.iSJ = false;
            this.bth.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.iST));
            this.bth.addPostData("prev", String.valueOf(this.iSU));
            this.bth.addPostData("not_see_lz", String.valueOf(e.this.iSI ? 0 : 1));
            this.bth.addPostData("is_top_agree", String.valueOf(e.this.iSQ ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.bth.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.bth.addPostData("obj_type", e.this.mFrom);
            } else {
                this.bth.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.iSN)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.iSN = com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.bth.addPostData("applist", e.this.iSN);
            String bgJ = com.baidu.tbadk.util.x.bgJ();
            if (!TextUtils.isEmpty(bgJ)) {
                this.bth.addPostData("oaid", bgJ);
            }
            crP();
            this.bth.aUA().aVb().mNeedBackgroundLogin = false;
            String postNetData = this.bth.postNetData();
            if (!this.bth.aUA().aVc().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.aI(postNetData, true);
            return hVar;
        }

        private void crP() {
            this.bth.addPostData("forum_id", e.this.mForumId);
            this.bth.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.bth.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.bth.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.bth.addPostData("q_type", String.valueOf(ar.aUX().aUY() ? 2 : 1));
            this.bth.addPostData("_os_version", Build.VERSION.RELEASE);
            this.bth.addPostData("page_name", "PB");
            this.bth.addPostData("pic_index", String.valueOf(e.this.iSB.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bth != null) {
                this.bth.cancelNetConnect();
            }
            e.this.iSG = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.egv != null) {
                e.this.iSG = null;
                if (hVar == null) {
                    if (e.this.iSK != null) {
                        String str = null;
                        int i = -1;
                        if (this.bth != null) {
                            i = this.bth.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.bth.getErrorString();
                            }
                        }
                        e.this.iSK.bf(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = v.isEmpty(hVar.crY());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.iSB.clear();
                    e.this.egv.clear();
                    e.this.iSC.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.iSH = hVar.getImageNum();
                }
                e.this.iSL = hVar.csa();
                if (this.mPicId == null) {
                    e.this.iSB.clear();
                    e.this.iSC.clear();
                }
                LinkedList<f> crY = hVar.crY();
                int size = crY.size();
                if (size <= 0) {
                    e.this.dsC = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = crY.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.crQ();
                        if (aq.equals(imageUrlData.id, e.this.iSP)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.iSO);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.crU();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.biO();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.ais, -1L);
                        imageUrlData.nid = e.this.mNid;
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.crR(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.iSI;
                        imageUrlData.overAllIndex = fVar.crU();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.crS();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.crT();
                        imageUrlData.from = e.this.mFrom;
                        if (fVar.crW() != null) {
                            imageUrlData.richTextArray = fVar.crW().toString();
                        }
                        imageUrlData.isFirstPost = fVar.crX();
                        if (fVar.aSp() != null) {
                            imageUrlData.agreeData = fVar.aSp();
                            imageUrlData.agreeData.isFromImageViewer = true;
                            imageUrlData.agreeData.mImageViewerFromPage = e.this.mFrom;
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.nid = imageUrlData.nid;
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.crV();
                            if (fVar.crX()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                            imageUrlData.agreeData.cardType = e.this.iSS;
                            imageUrlData.agreeData.recomSource = e.this.mRecomSource;
                            imageUrlData.agreeData.recomAbTag = e.this.mRecomAbTag;
                            imageUrlData.agreeData.recomExtra = e.this.mRecomExtra;
                            imageUrlData.agreeData.recomWeight = e.this.mRecomWeight;
                        }
                        if (e.this.iSC.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.iSC.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.egv.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.egv.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (aq.equals(imageUrlData.id, e.this.iSP)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.iSO);
                                }
                            }
                        } else if (e.this.iSR) {
                            e.this.iSH = e.this.egv.size();
                            e.this.iSL = null;
                        } else {
                            e.this.egv.put(str2, imageUrlData);
                            if (e.this.iSM) {
                                e.this.iSB.add(i2, str2);
                            } else {
                                e.this.iSB.add(str2);
                            }
                            e.this.iSC.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.getItem(crY, 0);
                    if (fVar2 != null) {
                        e.this.iSE = fVar2.crQ();
                    }
                    f fVar3 = (f) v.getItem(crY, size - 1);
                    if (fVar3 != null) {
                        e.this.iSF = fVar3.crQ();
                        e.this.dsC = ((long) e.this.iSH) == fVar3.crU();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.egv.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.egv.values()) {
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
                    e.this.ais = this.ais;
                    z = true;
                }
                int position = e.this.iSM ? v.getPosition(e.this.iSB, (String) e.this.iSC.get(this.mPicId)) - 1 : i3;
                e.this.dFz = hVar.aSh();
                e.this.dFA = hVar.aSi();
                if (e.this.iSD == null) {
                    e.this.iSD = new ArrayList();
                    if (hVar.crZ() != null && hVar.crY().size() > 0) {
                        e.this.iSD.addAll(hVar.crZ());
                    }
                }
                if (e.this.iSK != null) {
                    e.this.iSK.a(e.this.iSB, position, e.this.iSH, false, null, z, e.this.iSL, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.biI() != null && fVar.biI().length() > 0) {
            return fVar.biI();
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

    public void pV(boolean z) {
        this.iSR = z;
    }
}
