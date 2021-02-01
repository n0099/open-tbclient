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
/* loaded from: classes8.dex */
public class d {
    private String amC;
    private boolean drl;
    private String eRp;
    private String eRq;
    private String eTz;
    public String fDL;
    private Map<String, ImageUrlData> fww;
    public ForumData jSl;
    private String jfZ;
    private ArrayList<String> kTQ;
    private ArrayList<AlaInfoData> kTS;
    private String kTT;
    private String kTU;
    private String kUc;
    private String kUd;
    private String kUe;
    private boolean kUf;
    private int kUh;
    public MetaData kUi;
    public String kUj;
    public boolean kUk;
    private int kUl;
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
    private HashMap<String, String> kTR = new HashMap<>();
    private boolean mIsReserver = true;
    private a kTV = null;
    private int kTW = 0;
    private boolean kTX = false;
    private boolean kTY = false;
    private b kTZ = null;
    private AdvertAppInfo kUa = null;
    private boolean kUb = false;
    private boolean kUg = false;

    /* loaded from: classes8.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void bG(int i, String str);
    }

    public d(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        this.drl = false;
        this.kTQ = arrayList;
        this.fww = map;
        if (this.kTQ == null) {
            this.kTQ = new ArrayList<>();
        }
        Iterator<String> it = this.kTQ.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.kTR.put(com.baidu.tieba.image.b.Nr(next), next);
        }
        this.amC = str3;
        this.eTz = str4;
        this.jfZ = str2;
        this.mForumId = str;
        this.kTU = str5;
        this.mThreadType = i;
        this.drl = this.kTU == null;
        this.mUserId = str6;
        this.mFrom = str7;
        this.mIsReset = z;
        this.kUf = false;
        this.kUh = i2;
        this.mRecomSource = str8;
        this.mRecomAbTag = str9;
        this.mRecomWeight = str10;
        this.mRecomExtra = str11;
    }

    public void setSourceImageRectInScreen(String str) {
        this.kUd = str;
    }

    public void Nt(String str) {
        this.kUe = str;
    }

    public void tu(boolean z) {
        this.kUf = z;
    }

    public String bpA() {
        return this.eRp;
    }

    public String bpB() {
        return this.eRq;
    }

    public ArrayList<AlaInfoData> cZH() {
        return this.kTS;
    }

    public int cZI() {
        return this.kUl;
    }

    public void tv(boolean z) {
        this.mIsReserver = z;
    }

    public void cZJ() {
        this.kUb = false;
        if (!this.drl) {
            c(this.amC, this.kTU, 10, 0);
        }
    }

    public void cZK() {
        this.kUb = true;
        String str = this.kTQ.get(0);
        if (StringUtils.isNull(this.kTT)) {
            this.kTT = com.baidu.tieba.image.b.Nr(str);
        }
        c(this.amC, this.kTT, 0, 10);
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.kTV != null) {
            if (str2 == null || !str2.equals(this.kTV.getPicId())) {
                this.kTV.cancel();
            } else {
                return;
            }
        }
        this.kTV = new a(str, str2, i, i2);
        this.kTV.setPriority(3);
        this.kTV.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void tw(boolean z) {
        this.kTX = z;
    }

    public void tx(boolean z) {
        this.kTY = z;
    }

    public void a(b bVar) {
        this.kTZ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private String amC;
        private aa cml = null;
        private int kUm;
        private int kUn;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.amC = null;
            this.mPicId = null;
            this.kUm = 0;
            this.kUn = 0;
            this.mPicId = str2;
            this.amC = str;
            this.kUm = i;
            this.kUn = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public g doInBackground(Object... objArr) {
            this.cml = new aa(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.cml.addPostData("kw", d.this.jfZ);
            this.cml.addPostData("tid", this.amC);
            if (this.mPicId != null) {
                this.cml.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(d.this.mPostId) && !"0".equals(d.this.mPostId)) {
                this.cml.addPostData("post_id", d.this.mPostId);
            }
            this.cml.addPostData("source", String.valueOf(d.this.kTY ? 1 : 2));
            d.this.kTY = false;
            this.cml.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.kUm));
            this.cml.addPostData("prev", String.valueOf(this.kUn));
            this.cml.addPostData("not_see_lz", String.valueOf(d.this.kTX ? 0 : 1));
            this.cml.addPostData("is_top_agree", String.valueOf(d.this.kUf ? 1 : 2));
            if (!d.this.mIsReserver) {
                this.cml.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(d.this.mFrom, true)) {
                this.cml.addPostData("obj_type", d.this.mFrom);
            } else {
                this.cml.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(d.this.kUc)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    d.this.kUc = com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.cml.addPostData("applist", d.this.kUc);
            String uC = com.baidu.helios.b.aj(TbadkCoreApplication.getInst()).uC();
            if (!TextUtils.isEmpty(uC)) {
                this.cml.addPostData("oaid", uC);
            }
            this.cml.addPostData("ad_ext_params", AdExtParam.a.bEU().bEV());
            cZL();
            this.cml.bsr().bta().mNeedBackgroundLogin = false;
            String postNetData = this.cml.postNetData();
            if (!this.cml.bsr().btb().isRequestSuccess()) {
                return null;
            }
            g gVar = new g();
            gVar.aS(postNetData, true);
            return gVar;
        }

        private void cZL() {
            this.cml.addPostData("forum_id", d.this.mForumId);
            this.cml.addPostData("user_id", d.this.mUserId == null ? "0" : d.this.mUserId);
            this.cml.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.cml.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.cml.addPostData("q_type", String.valueOf(av.bsS().bsT() ? 2 : 1));
            this.cml.addPostData("_os_version", Build.VERSION.RELEASE);
            this.cml.addPostData("page_name", "PB");
            this.cml.addPostData("pic_index", String.valueOf(d.this.kTQ.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.cml != null) {
                this.cml.cancelNetConnect();
            }
            d.this.kTV = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (d.this.fww != null) {
                d.this.kTV = null;
                if (gVar == null) {
                    if (d.this.kTZ != null) {
                        String str = null;
                        int i = -1;
                        if (this.cml != null) {
                            i = this.cml.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.cml.getErrorString();
                            }
                        }
                        d.this.kTZ.bG(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = y.isEmpty(gVar.cZU());
                if (d.this.mIsReset && !isEmpty) {
                    d.this.kTQ.clear();
                    d.this.fww.clear();
                    d.this.kTR.clear();
                }
                if (gVar.getImageNum() != 0) {
                    d.this.kTW = gVar.getImageNum();
                }
                d.this.kUa = gVar.blH();
                d.this.kUl = gVar.kUl;
                d.this.fDL = gVar.fDL;
                d.this.replyPrivateFlag = gVar.cZW();
                d.this.kUi = gVar.kUi;
                d.this.kUj = gVar.kUj;
                d.this.kUk = gVar.kUz == 1;
                if (this.mPicId == null) {
                    d.this.kTQ.clear();
                    d.this.kTR.clear();
                }
                LinkedList<e> cZU = gVar.cZU();
                int size = cZU.size();
                if (size <= 0) {
                    d.this.drl = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        e eVar = cZU.get(i2);
                        String a2 = d.this.a(eVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = eVar.cZM();
                        if (au.equals(imageUrlData.id, d.this.kUe)) {
                            imageUrlData.setSourceImageRectInScreen(d.this.kUd);
                        }
                        imageUrlData.imageUrl = a2;
                        String str2 = a2 + "*" + eVar.cZQ();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = eVar.bHV();
                        imageUrlData.originalSize = eVar.getOriginalSize();
                        imageUrlData.forumId = d.this.mForumId;
                        imageUrlData.forumName = d.this.jfZ;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.amC, -1L);
                        imageUrlData.nid = d.this.eTz;
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(eVar.cZN(), -1L);
                        imageUrlData.userId = eVar.getUserId();
                        imageUrlData.userNameShow = StringUtils.isNull(eVar.bza()) ? eVar.getUserName() : eVar.bza();
                        imageUrlData.mIsReserver = d.this.mIsReserver;
                        imageUrlData.mIsSeeHost = d.this.kTX;
                        imageUrlData.overAllIndex = eVar.cZQ();
                        imageUrlData.mThreadType = d.this.mThreadType;
                        imageUrlData.mPicType = eVar.getPicType();
                        imageUrlData.mTagName = eVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = eVar.cZO();
                        imageUrlData.isLongPic = eVar.isLongPic();
                        imageUrlData.isBlockedPic = eVar.cZP();
                        imageUrlData.from = d.this.mFrom;
                        if (eVar.cZS() != null) {
                            imageUrlData.richTextArray = eVar.cZS().toString();
                        }
                        imageUrlData.isFirstPost = eVar.cZT();
                        if (eVar.bpJ() != null) {
                            imageUrlData.agreeData = eVar.bpJ();
                            imageUrlData.agreeData.isFromImageViewer = true;
                            imageUrlData.agreeData.mImageViewerFromPage = d.this.mFrom;
                            imageUrlData.agreeData.forumId = d.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.nid = imageUrlData.nid;
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = eVar.cZR();
                            if (eVar.cZT()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                            imageUrlData.agreeData.cardType = d.this.kUh;
                            imageUrlData.agreeData.recomSource = d.this.mRecomSource;
                            imageUrlData.agreeData.recomAbTag = d.this.mRecomAbTag;
                            imageUrlData.agreeData.recomExtra = d.this.mRecomExtra;
                            imageUrlData.agreeData.recomWeight = d.this.mRecomWeight;
                        }
                        if (d.this.kTR.containsKey(imageUrlData.id)) {
                            String str3 = (String) d.this.kTR.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) d.this.fww.get(str3);
                            if (imageUrlData2 == null) {
                                d.this.fww.put(str3, imageUrlData);
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
                                imageUrlData2.forumName = d.this.jfZ;
                                if (au.equals(imageUrlData.id, d.this.kUe)) {
                                    imageUrlData2.setSourceImageRectInScreen(d.this.kUd);
                                }
                            }
                        } else if (d.this.kUg) {
                            d.this.kTW = d.this.fww.size();
                            d.this.kUa = null;
                        } else {
                            d.this.fww.put(str2, imageUrlData);
                            if (d.this.kUb) {
                                d.this.kTQ.add(i2, str2);
                            } else {
                                d.this.kTQ.add(str2);
                            }
                            d.this.kTR.put(imageUrlData.id, str2);
                        }
                    }
                    e eVar2 = (e) y.getItem(cZU, 0);
                    if (eVar2 != null) {
                        d.this.kTT = eVar2.cZM();
                    }
                    e eVar3 = (e) y.getItem(cZU, size - 1);
                    if (eVar3 != null) {
                        d.this.kTU = eVar3.cZM();
                        d.this.drl = ((long) d.this.kTW) == eVar3.cZQ();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : d.this.fww.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : d.this.fww.values()) {
                                if (imageUrlData5.postId != j || imageUrlData5.agreeData == null) {
                                    imageUrlData5 = imageUrlData3;
                                } else {
                                    imageUrlData4.agreeData = imageUrlData5.agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                    imageUrlData4.userId = imageUrlData5.userId;
                                    imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                    imageUrlData4.forumId = d.this.mForumId;
                                    imageUrlData4.forumName = d.this.jfZ;
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
                            imageUrlData4.forumName = d.this.jfZ;
                        }
                    }
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    d.this.amC = this.amC;
                    z = true;
                }
                int position = d.this.kUb ? y.getPosition(d.this.kTQ, (String) d.this.kTR.get(this.mPicId)) - 1 : i3;
                d.this.eRp = gVar.bpA();
                d.this.eRq = gVar.bpB();
                d.this.jSl = gVar.bCk();
                if (d.this.kTS == null) {
                    d.this.kTS = new ArrayList();
                    if (gVar.cZV() != null && gVar.cZU().size() > 0) {
                        d.this.kTS.addAll(gVar.cZV());
                    }
                }
                if (d.this.kTZ != null) {
                    d.this.kTZ.a(d.this.kTQ, position, d.this.kTW, false, null, z, d.this.kUa, isEmpty);
                }
                d.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(e eVar) {
        if (eVar.bHP() != null && eVar.bHP().length() > 0) {
            return eVar.bHP();
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
        sb.append(au.getUrlEncode(eVar.getImageUrl()));
        return sb.toString();
    }

    public void ty(boolean z) {
        this.kUg = z;
    }
}
