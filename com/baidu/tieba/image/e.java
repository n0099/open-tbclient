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
    private String alS;
    private boolean cVd;
    private Map<String, ImageUrlData> eUl;
    private String eqk;
    private String eql;
    public String fbv;
    public ForumData iWP;
    private String ioO;
    private ArrayList<String> kfa;
    private ArrayList<AlaInfoData> kfc;
    private String kfd;
    private String kfe;
    private String kfm;
    private String kfn;
    private String kfo;
    private boolean kfp;
    private int kfr;
    public MetaData kfs;
    public String kft;
    public boolean kfu;
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
    private HashMap<String, String> kfb = new HashMap<>();
    private boolean mIsReserver = true;
    private a kff = null;
    private int kfg = 0;
    private boolean kfh = false;
    private boolean kfi = false;
    private b kfj = null;
    private AdvertAppInfo kfk = null;
    private boolean kfl = false;
    private boolean kfq = false;

    /* loaded from: classes21.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void bw(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        this.cVd = false;
        this.kfa = arrayList;
        this.eUl = map;
        if (this.kfa == null) {
            this.kfa = new ArrayList<>();
        }
        Iterator<String> it = this.kfa.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.kfb.put(d.MJ(next), next);
        }
        this.alS = str3;
        this.mNid = str4;
        this.ioO = str2;
        this.mForumId = str;
        this.kfe = str5;
        this.mThreadType = i;
        this.cVd = this.kfe == null;
        this.mUserId = str6;
        this.mFrom = str7;
        this.mIsReset = z;
        this.kfp = false;
        this.kfr = i2;
        this.mRecomSource = str8;
        this.mRecomAbTag = str9;
        this.mRecomWeight = str10;
        this.mRecomExtra = str11;
    }

    public void setSourceImageRectInScreen(String str) {
        this.kfn = str;
    }

    public void ML(String str) {
        this.kfo = str;
    }

    public void se(boolean z) {
        this.kfp = z;
    }

    public String bjP() {
        return this.eqk;
    }

    public String bjQ() {
        return this.eql;
    }

    public ArrayList<AlaInfoData> cRD() {
        return this.kfc;
    }

    public void sf(boolean z) {
        this.mIsReserver = z;
    }

    public void cRE() {
        this.kfl = false;
        if (!this.cVd) {
            c(this.alS, this.kfe, 10, 0);
        }
    }

    public void cRF() {
        this.kfl = true;
        String str = this.kfa.get(0);
        if (StringUtils.isNull(this.kfd)) {
            this.kfd = d.MJ(str);
        }
        c(this.alS, this.kfd, 0, 10);
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.kff != null) {
            if (str2 == null || !str2.equals(this.kff.getPicId())) {
                this.kff.cancel();
            } else {
                return;
            }
        }
        this.kff = new a(str, str2, i, i2);
        this.kff.setPriority(3);
        this.kff.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void sg(boolean z) {
        this.kfh = z;
    }

    public void sh(boolean z) {
        this.kfi = z;
    }

    public void a(b bVar) {
        this.kfj = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String alS;
        private aa bML = null;
        private int kfv;
        private int kfw;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.alS = null;
            this.mPicId = null;
            this.kfv = 0;
            this.kfw = 0;
            this.mPicId = str2;
            this.alS = str;
            this.kfv = i;
            this.kfw = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public h doInBackground(Object... objArr) {
            this.bML = new aa(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.bML.addPostData("kw", e.this.ioO);
            this.bML.addPostData("tid", this.alS);
            if (this.mPicId != null) {
                this.bML.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.bML.addPostData("post_id", e.this.mPostId);
            }
            this.bML.addPostData("source", String.valueOf(e.this.kfi ? 1 : 2));
            e.this.kfi = false;
            this.bML.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.kfv));
            this.bML.addPostData("prev", String.valueOf(this.kfw));
            this.bML.addPostData("not_see_lz", String.valueOf(e.this.kfh ? 0 : 1));
            this.bML.addPostData("is_top_agree", String.valueOf(e.this.kfp ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.bML.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.bML.addPostData("obj_type", e.this.mFrom);
            } else {
                this.bML.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.kfm)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.blO().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.kfm = com.baidu.tbadk.core.sharedPref.b.blO().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.bML.addPostData("applist", e.this.kfm);
            String bzx = y.bzx();
            if (!TextUtils.isEmpty(bzx)) {
                this.bML.addPostData("oaid", bzx);
            }
            this.bML.addPostData("ad_ext_params", AdExtParam.a.byL().byM());
            cRG();
            this.bML.bmu().bna().mNeedBackgroundLogin = false;
            String postNetData = this.bML.postNetData();
            if (!this.bML.bmu().bnb().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.aQ(postNetData, true);
            return hVar;
        }

        private void cRG() {
            this.bML.addPostData("forum_id", e.this.mForumId);
            this.bML.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.bML.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.bML.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.bML.addPostData("q_type", String.valueOf(au.bmV().bmW() ? 2 : 1));
            this.bML.addPostData("_os_version", Build.VERSION.RELEASE);
            this.bML.addPostData("page_name", "PB");
            this.bML.addPostData("pic_index", String.valueOf(e.this.kfa.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bML != null) {
                this.bML.cancelNetConnect();
            }
            e.this.kff = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.eUl != null) {
                e.this.kff = null;
                if (hVar == null) {
                    if (e.this.kfj != null) {
                        String str = null;
                        int i = -1;
                        if (this.bML != null) {
                            i = this.bML.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.bML.getErrorString();
                            }
                        }
                        e.this.kfj.bw(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(hVar.cRP());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.kfa.clear();
                    e.this.eUl.clear();
                    e.this.kfb.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.kfg = hVar.getImageNum();
                }
                e.this.kfk = hVar.cRS();
                e.this.fbv = hVar.fbv;
                e.this.replyPrivateFlag = hVar.cRR();
                e.this.kfs = hVar.kfs;
                e.this.kft = hVar.kft;
                e.this.kfu = hVar.kfI == 1;
                if (this.mPicId == null) {
                    e.this.kfa.clear();
                    e.this.kfb.clear();
                }
                LinkedList<f> cRP = hVar.cRP();
                int size = cRP.size();
                if (size <= 0) {
                    e.this.cVd = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = cRP.get(i2);
                        String a2 = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.cRH();
                        if (at.equals(imageUrlData.id, e.this.kfo)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.kfn);
                        }
                        imageUrlData.imageUrl = a2;
                        String str2 = a2 + "*" + fVar.cRL();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.bBP();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.forumName = e.this.ioO;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.alS, -1L);
                        imageUrlData.nid = e.this.mNid;
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.cRI(), -1L);
                        imageUrlData.userId = fVar.getUserId();
                        imageUrlData.userNameShow = StringUtils.isNull(fVar.bsZ()) ? fVar.getUserName() : fVar.bsZ();
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.kfh;
                        imageUrlData.overAllIndex = fVar.cRL();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.cRJ();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.cRK();
                        imageUrlData.from = e.this.mFrom;
                        if (fVar.cRN() != null) {
                            imageUrlData.richTextArray = fVar.cRN().toString();
                        }
                        imageUrlData.isFirstPost = fVar.cRO();
                        if (fVar.bjY() != null) {
                            imageUrlData.agreeData = fVar.bjY();
                            imageUrlData.agreeData.isFromImageViewer = true;
                            imageUrlData.agreeData.mImageViewerFromPage = e.this.mFrom;
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.nid = imageUrlData.nid;
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.cRM();
                            if (fVar.cRO()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                            imageUrlData.agreeData.cardType = e.this.kfr;
                            imageUrlData.agreeData.recomSource = e.this.mRecomSource;
                            imageUrlData.agreeData.recomAbTag = e.this.mRecomAbTag;
                            imageUrlData.agreeData.recomExtra = e.this.mRecomExtra;
                            imageUrlData.agreeData.recomWeight = e.this.mRecomWeight;
                        }
                        if (e.this.kfb.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.kfb.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.eUl.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.eUl.put(str3, imageUrlData);
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
                                imageUrlData2.forumName = e.this.ioO;
                                if (at.equals(imageUrlData.id, e.this.kfo)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.kfn);
                                }
                            }
                        } else if (e.this.kfq) {
                            e.this.kfg = e.this.eUl.size();
                            e.this.kfk = null;
                        } else {
                            e.this.eUl.put(str2, imageUrlData);
                            if (e.this.kfl) {
                                e.this.kfa.add(i2, str2);
                            } else {
                                e.this.kfa.add(str2);
                            }
                            e.this.kfb.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) com.baidu.tbadk.core.util.y.getItem(cRP, 0);
                    if (fVar2 != null) {
                        e.this.kfd = fVar2.cRH();
                    }
                    f fVar3 = (f) com.baidu.tbadk.core.util.y.getItem(cRP, size - 1);
                    if (fVar3 != null) {
                        e.this.kfe = fVar3.cRH();
                        e.this.cVd = ((long) e.this.kfg) == fVar3.cRL();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.eUl.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.eUl.values()) {
                                if (imageUrlData5.postId != j || imageUrlData5.agreeData == null) {
                                    imageUrlData5 = imageUrlData3;
                                } else {
                                    imageUrlData4.agreeData = imageUrlData5.agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                    imageUrlData4.userId = imageUrlData5.userId;
                                    imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                    imageUrlData4.forumId = e.this.mForumId;
                                    imageUrlData4.forumName = e.this.ioO;
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
                            imageUrlData4.forumName = e.this.ioO;
                        }
                    }
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.alS = this.alS;
                    z = true;
                }
                int position = e.this.kfl ? com.baidu.tbadk.core.util.y.getPosition(e.this.kfa, (String) e.this.kfb.get(this.mPicId)) - 1 : i3;
                e.this.eqk = hVar.bjP();
                e.this.eql = hVar.bjQ();
                e.this.iWP = hVar.bwh();
                if (e.this.kfc == null) {
                    e.this.kfc = new ArrayList();
                    if (hVar.cRQ() != null && hVar.cRP().size() > 0) {
                        e.this.kfc.addAll(hVar.cRQ());
                    }
                }
                if (e.this.kfj != null) {
                    e.this.kfj.a(e.this.kfa, position, e.this.kfg, false, null, z, e.this.kfk, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.bBJ() != null && fVar.bBJ().length() > 0) {
            return fVar.bBJ();
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

    public void si(boolean z) {
        this.kfq = z;
    }
}
