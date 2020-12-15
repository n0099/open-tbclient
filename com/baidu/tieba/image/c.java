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
/* loaded from: classes21.dex */
public class c {
    private String amY;
    private boolean doR;
    private String eJU;
    private String eJV;
    private Map<String, ImageUrlData> fpg;
    public String fwy;
    private String iSP;
    public ForumData jDs;
    private ArrayList<String> kLd;
    private ArrayList<AlaInfoData> kLf;
    private String kLg;
    private String kLh;
    private String kLp;
    private String kLq;
    private String kLr;
    private boolean kLs;
    private int kLu;
    public MetaData kLv;
    public String kLw;
    public boolean kLx;
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
    private HashMap<String, String> kLe = new HashMap<>();
    private boolean mIsReserver = true;
    private a kLi = null;
    private int kLj = 0;
    private boolean kLk = false;
    private boolean kLl = false;
    private b kLm = null;
    private AdvertAppInfo kLn = null;
    private boolean kLo = false;
    private boolean kLt = false;

    /* loaded from: classes21.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void bz(int i, String str);
    }

    public c(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        this.doR = false;
        this.kLd = arrayList;
        this.fpg = map;
        if (this.kLd == null) {
            this.kLd = new ArrayList<>();
        }
        Iterator<String> it = this.kLd.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.kLe.put(com.baidu.tieba.image.b.Oe(next), next);
        }
        this.amY = str3;
        this.mNid = str4;
        this.iSP = str2;
        this.mForumId = str;
        this.kLh = str5;
        this.mThreadType = i;
        this.doR = this.kLh == null;
        this.mUserId = str6;
        this.mFrom = str7;
        this.mIsReset = z;
        this.kLs = false;
        this.kLu = i2;
        this.mRecomSource = str8;
        this.mRecomAbTag = str9;
        this.mRecomWeight = str10;
        this.mRecomExtra = str11;
    }

    public void setSourceImageRectInScreen(String str) {
        this.kLq = str;
    }

    public void Og(String str) {
        this.kLr = str;
    }

    public void tk(boolean z) {
        this.kLs = z;
    }

    public String bqz() {
        return this.eJU;
    }

    public String bqA() {
        return this.eJV;
    }

    public ArrayList<AlaInfoData> dbU() {
        return this.kLf;
    }

    public void tl(boolean z) {
        this.mIsReserver = z;
    }

    public void dbV() {
        this.kLo = false;
        if (!this.doR) {
            c(this.amY, this.kLh, 10, 0);
        }
    }

    public void dbW() {
        this.kLo = true;
        String str = this.kLd.get(0);
        if (StringUtils.isNull(this.kLg)) {
            this.kLg = com.baidu.tieba.image.b.Oe(str);
        }
        c(this.amY, this.kLg, 0, 10);
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.kLi != null) {
            if (str2 == null || !str2.equals(this.kLi.getPicId())) {
                this.kLi.cancel();
            } else {
                return;
            }
        }
        this.kLi = new a(str, str2, i, i2);
        this.kLi.setPriority(3);
        this.kLi.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void tm(boolean z) {
        this.kLk = z;
    }

    public void tn(boolean z) {
        this.kLl = z;
    }

    public void a(b bVar) {
        this.kLm = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends BdAsyncTask<Object, Integer, f> {
        private String amY;
        private aa cfI = null;
        private int kLy;
        private int kLz;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.amY = null;
            this.mPicId = null;
            this.kLy = 0;
            this.kLz = 0;
            this.mPicId = str2;
            this.amY = str;
            this.kLy = i;
            this.kLz = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public f doInBackground(Object... objArr) {
            this.cfI = new aa(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.cfI.addPostData("kw", c.this.iSP);
            this.cfI.addPostData("tid", this.amY);
            if (this.mPicId != null) {
                this.cfI.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(c.this.mPostId) && !"0".equals(c.this.mPostId)) {
                this.cfI.addPostData("post_id", c.this.mPostId);
            }
            this.cfI.addPostData("source", String.valueOf(c.this.kLl ? 1 : 2));
            c.this.kLl = false;
            this.cfI.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.kLy));
            this.cfI.addPostData("prev", String.valueOf(this.kLz));
            this.cfI.addPostData("not_see_lz", String.valueOf(c.this.kLk ? 0 : 1));
            this.cfI.addPostData("is_top_agree", String.valueOf(c.this.kLs ? 1 : 2));
            if (!c.this.mIsReserver) {
                this.cfI.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(c.this.mFrom, true)) {
                this.cfI.addPostData("obj_type", c.this.mFrom);
            } else {
                this.cfI.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(c.this.kLp)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    c.this.kLp = com.baidu.tbadk.core.sharedPref.b.bsO().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.cfI.addPostData("applist", c.this.kLp);
            String zj = com.baidu.helios.b.al(TbadkCoreApplication.getInst()).zj();
            if (!TextUtils.isEmpty(zj)) {
                this.cfI.addPostData("oaid", zj);
            }
            this.cfI.addPostData("ad_ext_params", AdExtParam.a.bFX().bFY());
            dbX();
            this.cfI.btv().bue().mNeedBackgroundLogin = false;
            String postNetData = this.cfI.postNetData();
            if (!this.cfI.btv().buf().isRequestSuccess()) {
                return null;
            }
            f fVar = new f();
            fVar.aT(postNetData, true);
            return fVar;
        }

        private void dbX() {
            this.cfI.addPostData("forum_id", c.this.mForumId);
            this.cfI.addPostData("user_id", c.this.mUserId == null ? "0" : c.this.mUserId);
            this.cfI.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.cfI.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.cfI.addPostData("q_type", String.valueOf(av.btX().btY() ? 2 : 1));
            this.cfI.addPostData("_os_version", Build.VERSION.RELEASE);
            this.cfI.addPostData("page_name", "PB");
            this.cfI.addPostData("pic_index", String.valueOf(c.this.kLd.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.cfI != null) {
                this.cfI.cancelNetConnect();
            }
            c.this.kLi = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(f fVar) {
            super.onPostExecute(fVar);
            if (c.this.fpg != null) {
                c.this.kLi = null;
                if (fVar == null) {
                    if (c.this.kLm != null) {
                        String str = null;
                        int i = -1;
                        if (this.cfI != null) {
                            i = this.cfI.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.cfI.getErrorString();
                            }
                        }
                        c.this.kLm.bz(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = y.isEmpty(fVar.dcg());
                if (c.this.mIsReset && !isEmpty) {
                    c.this.kLd.clear();
                    c.this.fpg.clear();
                    c.this.kLe.clear();
                }
                if (fVar.getImageNum() != 0) {
                    c.this.kLj = fVar.getImageNum();
                }
                c.this.kLn = fVar.bmI();
                c.this.fwy = fVar.fwy;
                c.this.replyPrivateFlag = fVar.dci();
                c.this.kLv = fVar.kLv;
                c.this.kLw = fVar.kLw;
                c.this.kLx = fVar.kLL == 1;
                if (this.mPicId == null) {
                    c.this.kLd.clear();
                    c.this.kLe.clear();
                }
                LinkedList<d> dcg = fVar.dcg();
                int size = dcg.size();
                if (size <= 0) {
                    c.this.doR = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        d dVar = dcg.get(i2);
                        String a2 = c.this.a(dVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = dVar.dbY();
                        if (au.equals(imageUrlData.id, c.this.kLr)) {
                            imageUrlData.setSourceImageRectInScreen(c.this.kLq);
                        }
                        imageUrlData.imageUrl = a2;
                        String str2 = a2 + "*" + dVar.dcc();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = dVar.bJa();
                        imageUrlData.originalSize = dVar.getOriginalSize();
                        imageUrlData.forumId = c.this.mForumId;
                        imageUrlData.forumName = c.this.iSP;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.amY, -1L);
                        imageUrlData.nid = c.this.mNid;
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(dVar.dbZ(), -1L);
                        imageUrlData.userId = dVar.getUserId();
                        imageUrlData.userNameShow = StringUtils.isNull(dVar.bAh()) ? dVar.getUserName() : dVar.bAh();
                        imageUrlData.mIsReserver = c.this.mIsReserver;
                        imageUrlData.mIsSeeHost = c.this.kLk;
                        imageUrlData.overAllIndex = dVar.dcc();
                        imageUrlData.mThreadType = c.this.mThreadType;
                        imageUrlData.mPicType = dVar.getPicType();
                        imageUrlData.mTagName = dVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = dVar.dca();
                        imageUrlData.isLongPic = dVar.isLongPic();
                        imageUrlData.isBlockedPic = dVar.dcb();
                        imageUrlData.from = c.this.mFrom;
                        if (dVar.dce() != null) {
                            imageUrlData.richTextArray = dVar.dce().toString();
                        }
                        imageUrlData.isFirstPost = dVar.dcf();
                        if (dVar.bqI() != null) {
                            imageUrlData.agreeData = dVar.bqI();
                            imageUrlData.agreeData.isFromImageViewer = true;
                            imageUrlData.agreeData.mImageViewerFromPage = c.this.mFrom;
                            imageUrlData.agreeData.forumId = c.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.nid = imageUrlData.nid;
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = dVar.dcd();
                            if (dVar.dcf()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                            imageUrlData.agreeData.cardType = c.this.kLu;
                            imageUrlData.agreeData.recomSource = c.this.mRecomSource;
                            imageUrlData.agreeData.recomAbTag = c.this.mRecomAbTag;
                            imageUrlData.agreeData.recomExtra = c.this.mRecomExtra;
                            imageUrlData.agreeData.recomWeight = c.this.mRecomWeight;
                        }
                        if (c.this.kLe.containsKey(imageUrlData.id)) {
                            String str3 = (String) c.this.kLe.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) c.this.fpg.get(str3);
                            if (imageUrlData2 == null) {
                                c.this.fpg.put(str3, imageUrlData);
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
                                imageUrlData2.forumName = c.this.iSP;
                                if (au.equals(imageUrlData.id, c.this.kLr)) {
                                    imageUrlData2.setSourceImageRectInScreen(c.this.kLq);
                                }
                            }
                        } else if (c.this.kLt) {
                            c.this.kLj = c.this.fpg.size();
                            c.this.kLn = null;
                        } else {
                            c.this.fpg.put(str2, imageUrlData);
                            if (c.this.kLo) {
                                c.this.kLd.add(i2, str2);
                            } else {
                                c.this.kLd.add(str2);
                            }
                            c.this.kLe.put(imageUrlData.id, str2);
                        }
                    }
                    d dVar2 = (d) y.getItem(dcg, 0);
                    if (dVar2 != null) {
                        c.this.kLg = dVar2.dbY();
                    }
                    d dVar3 = (d) y.getItem(dcg, size - 1);
                    if (dVar3 != null) {
                        c.this.kLh = dVar3.dbY();
                        c.this.doR = ((long) c.this.kLj) == dVar3.dcc();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : c.this.fpg.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : c.this.fpg.values()) {
                                if (imageUrlData5.postId != j || imageUrlData5.agreeData == null) {
                                    imageUrlData5 = imageUrlData3;
                                } else {
                                    imageUrlData4.agreeData = imageUrlData5.agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                    imageUrlData4.userId = imageUrlData5.userId;
                                    imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                    imageUrlData4.forumId = c.this.mForumId;
                                    imageUrlData4.forumName = c.this.iSP;
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
                            imageUrlData4.forumName = c.this.iSP;
                        }
                    }
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    c.this.amY = this.amY;
                    z = true;
                }
                int position = c.this.kLo ? y.getPosition(c.this.kLd, (String) c.this.kLe.get(this.mPicId)) - 1 : i3;
                c.this.eJU = fVar.bqz();
                c.this.eJV = fVar.bqA();
                c.this.jDs = fVar.bDp();
                if (c.this.kLf == null) {
                    c.this.kLf = new ArrayList();
                    if (fVar.dch() != null && fVar.dcg().size() > 0) {
                        c.this.kLf.addAll(fVar.dch());
                    }
                }
                if (c.this.kLm != null) {
                    c.this.kLm.a(c.this.kLd, position, c.this.kLj, false, null, z, c.this.kLn, isEmpty);
                }
                c.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(d dVar) {
        if (dVar.bIU() != null && dVar.bIU().length() > 0) {
            return dVar.bIU();
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

    public void to(boolean z) {
        this.kLt = z;
    }
}
