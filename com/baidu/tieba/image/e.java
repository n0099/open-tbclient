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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.z;
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
    private String ajJ;
    private boolean dDe;
    private String dSv;
    private String dSw;
    private Map<String, ImageUrlData> evu;
    private String hFr;
    private String jsG;
    private String jsH;
    private String jsI;
    private boolean jsJ;
    private int jsL;
    private ArrayList<String> jsu;
    private ArrayList<AlaInfoData> jsw;
    private String jsx;
    private String jsy;
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
    private HashMap<String, String> jsv = new HashMap<>();
    private boolean mIsReserver = true;
    private a jsz = null;
    private int jsA = 0;
    private boolean jsB = false;
    private boolean jsC = false;
    private b jsD = null;
    private AdvertAppInfo jsE = null;
    private boolean jsF = false;
    private boolean jsK = false;

    /* loaded from: classes15.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void bl(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        this.dDe = false;
        this.jsu = arrayList;
        this.evu = map;
        if (this.jsu == null) {
            this.jsu = new ArrayList<>();
        }
        Iterator<String> it = this.jsu.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.jsv.put(d.Iz(next), next);
        }
        this.ajJ = str3;
        this.mNid = str4;
        this.hFr = str2;
        this.mForumId = str;
        this.jsy = str5;
        this.mThreadType = i;
        this.dDe = this.jsy == null;
        this.mUserId = str6;
        this.mFrom = str7;
        this.mIsReset = z;
        this.jsJ = false;
        this.jsL = i2;
        this.mRecomSource = str8;
        this.mRecomAbTag = str9;
        this.mRecomWeight = str10;
        this.mRecomExtra = str11;
    }

    public void setSourceImageRectInScreen(String str) {
        this.jsH = str;
    }

    public void IB(String str) {
        this.jsI = str;
    }

    public void qI(boolean z) {
        this.jsJ = z;
    }

    public String aXT() {
        return this.dSv;
    }

    public String aXU() {
        return this.dSw;
    }

    public ArrayList<AlaInfoData> czA() {
        return this.jsw;
    }

    public void qJ(boolean z) {
        this.mIsReserver = z;
    }

    public void czB() {
        this.jsF = false;
        if (!this.dDe) {
            c(this.ajJ, this.jsy, 10, 0);
        }
    }

    public void czC() {
        this.jsF = true;
        String str = this.jsu.get(0);
        if (StringUtils.isNull(this.jsx)) {
            this.jsx = d.Iz(str);
        }
        c(this.ajJ, this.jsx, 0, 10);
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.jsz != null) {
            if (str2 == null || !str2.equals(this.jsz.getPicId())) {
                this.jsz.cancel();
            } else {
                return;
            }
        }
        this.jsz = new a(str, str2, i, i2);
        this.jsz.setPriority(3);
        this.jsz.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void qK(boolean z) {
        this.jsB = z;
    }

    public void qL(boolean z) {
        this.jsC = z;
    }

    public void a(b bVar) {
        this.jsD = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String ajJ;
        private z byq = null;
        private int jsM;
        private int jsN;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.ajJ = null;
            this.mPicId = null;
            this.jsM = 0;
            this.jsN = 0;
            this.mPicId = str2;
            this.ajJ = str;
            this.jsM = i;
            this.jsN = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public h doInBackground(Object... objArr) {
            this.byq = new z(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.byq.addPostData("kw", e.this.hFr);
            this.byq.addPostData("tid", this.ajJ);
            if (this.mPicId != null) {
                this.byq.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.byq.addPostData("post_id", e.this.mPostId);
            }
            this.byq.addPostData("source", String.valueOf(e.this.jsC ? 1 : 2));
            e.this.jsC = false;
            this.byq.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.jsM));
            this.byq.addPostData("prev", String.valueOf(this.jsN));
            this.byq.addPostData("not_see_lz", String.valueOf(e.this.jsB ? 0 : 1));
            this.byq.addPostData("is_top_agree", String.valueOf(e.this.jsJ ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.byq.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.byq.addPostData("obj_type", e.this.mFrom);
            } else {
                this.byq.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.jsG)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aZP().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.jsG = com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.byq.addPostData("applist", e.this.jsG);
            String bmQ = x.bmQ();
            if (!TextUtils.isEmpty(bmQ)) {
                this.byq.addPostData("oaid", bmQ);
            }
            this.byq.addPostData("ad_ext_params", AdExtParam.a.bmj().bmk());
            czD();
            this.byq.bav().baW().mNeedBackgroundLogin = false;
            String postNetData = this.byq.postNetData();
            if (!this.byq.bav().baX().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.aI(postNetData, true);
            return hVar;
        }

        private void czD() {
            this.byq.addPostData("forum_id", e.this.mForumId);
            this.byq.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.byq.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.byq.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.byq.addPostData("q_type", String.valueOf(at.baS().baT() ? 2 : 1));
            this.byq.addPostData("_os_version", Build.VERSION.RELEASE);
            this.byq.addPostData("page_name", "PB");
            this.byq.addPostData("pic_index", String.valueOf(e.this.jsu.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.byq != null) {
                this.byq.cancelNetConnect();
            }
            e.this.jsz = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.evu != null) {
                e.this.jsz = null;
                if (hVar == null) {
                    if (e.this.jsD != null) {
                        String str = null;
                        int i = -1;
                        if (this.byq != null) {
                            i = this.byq.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.byq.getErrorString();
                            }
                        }
                        e.this.jsD.bl(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = com.baidu.tbadk.core.util.x.isEmpty(hVar.czM());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.jsu.clear();
                    e.this.evu.clear();
                    e.this.jsv.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.jsA = hVar.getImageNum();
                }
                e.this.jsE = hVar.czO();
                if (this.mPicId == null) {
                    e.this.jsu.clear();
                    e.this.jsv.clear();
                }
                LinkedList<f> czM = hVar.czM();
                int size = czM.size();
                if (size <= 0) {
                    e.this.dDe = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = czM.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.czE();
                        if (as.equals(imageUrlData.id, e.this.jsI)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.jsH);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.czI();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.bph();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.ajJ, -1L);
                        imageUrlData.nid = e.this.mNid;
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.czF(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.jsB;
                        imageUrlData.overAllIndex = fVar.czI();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.czG();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.czH();
                        imageUrlData.from = e.this.mFrom;
                        if (fVar.czK() != null) {
                            imageUrlData.richTextArray = fVar.czK().toString();
                        }
                        imageUrlData.isFirstPost = fVar.czL();
                        if (fVar.aYc() != null) {
                            imageUrlData.agreeData = fVar.aYc();
                            imageUrlData.agreeData.isFromImageViewer = true;
                            imageUrlData.agreeData.mImageViewerFromPage = e.this.mFrom;
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.nid = imageUrlData.nid;
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.czJ();
                            if (fVar.czL()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                            imageUrlData.agreeData.cardType = e.this.jsL;
                            imageUrlData.agreeData.recomSource = e.this.mRecomSource;
                            imageUrlData.agreeData.recomAbTag = e.this.mRecomAbTag;
                            imageUrlData.agreeData.recomExtra = e.this.mRecomExtra;
                            imageUrlData.agreeData.recomWeight = e.this.mRecomWeight;
                        }
                        if (e.this.jsv.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.jsv.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.evu.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.evu.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (as.equals(imageUrlData.id, e.this.jsI)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.jsH);
                                }
                            }
                        } else if (e.this.jsK) {
                            e.this.jsA = e.this.evu.size();
                            e.this.jsE = null;
                        } else {
                            e.this.evu.put(str2, imageUrlData);
                            if (e.this.jsF) {
                                e.this.jsu.add(i2, str2);
                            } else {
                                e.this.jsu.add(str2);
                            }
                            e.this.jsv.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) com.baidu.tbadk.core.util.x.getItem(czM, 0);
                    if (fVar2 != null) {
                        e.this.jsx = fVar2.czE();
                    }
                    f fVar3 = (f) com.baidu.tbadk.core.util.x.getItem(czM, size - 1);
                    if (fVar3 != null) {
                        e.this.jsy = fVar3.czE();
                        e.this.dDe = ((long) e.this.jsA) == fVar3.czI();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.evu.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.evu.values()) {
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
                    e.this.ajJ = this.ajJ;
                    z = true;
                }
                int position = e.this.jsF ? com.baidu.tbadk.core.util.x.getPosition(e.this.jsu, (String) e.this.jsv.get(this.mPicId)) - 1 : i3;
                e.this.dSv = hVar.aXT();
                e.this.dSw = hVar.aXU();
                if (e.this.jsw == null) {
                    e.this.jsw = new ArrayList();
                    if (hVar.czN() != null && hVar.czM().size() > 0) {
                        e.this.jsw.addAll(hVar.czN());
                    }
                }
                if (e.this.jsD != null) {
                    e.this.jsD.a(e.this.jsu, position, e.this.jsA, false, null, z, e.this.jsE, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.bpb() != null && fVar.bpb().length() > 0) {
            return fVar.bpb();
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
        sb.append(as.getUrlEncode(fVar.getImageUrl()));
        return sb.toString();
    }

    public void qM(boolean z) {
        this.jsK = z;
    }
}
