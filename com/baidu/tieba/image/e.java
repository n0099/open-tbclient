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
/* loaded from: classes20.dex */
public class e {
    private String alA;
    private boolean cJa;
    private Map<String, ImageUrlData> eIe;
    public String ePo;
    private String eef;
    private String eeg;
    private String hZN;
    public ForumData iHZ;
    private ArrayList<String> jQb;
    private ArrayList<AlaInfoData> jQd;
    private String jQe;
    private String jQf;
    private String jQn;
    private String jQo;
    private String jQp;
    private boolean jQq;
    private int jQs;
    public MetaData jQt;
    public String jQu;
    public boolean jQv;
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
    private HashMap<String, String> jQc = new HashMap<>();
    private boolean mIsReserver = true;
    private a jQg = null;
    private int jQh = 0;
    private boolean jQi = false;
    private boolean jQj = false;
    private b jQk = null;
    private AdvertAppInfo jQl = null;
    private boolean jQm = false;
    private boolean jQr = false;

    /* loaded from: classes20.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void bm(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        this.cJa = false;
        this.jQb = arrayList;
        this.eIe = map;
        if (this.jQb == null) {
            this.jQb = new ArrayList<>();
        }
        Iterator<String> it = this.jQb.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.jQc.put(d.LU(next), next);
        }
        this.alA = str3;
        this.mNid = str4;
        this.hZN = str2;
        this.mForumId = str;
        this.jQf = str5;
        this.mThreadType = i;
        this.cJa = this.jQf == null;
        this.mUserId = str6;
        this.mFrom = str7;
        this.mIsReset = z;
        this.jQq = false;
        this.jQs = i2;
        this.mRecomSource = str8;
        this.mRecomAbTag = str9;
        this.mRecomWeight = str10;
        this.mRecomExtra = str11;
    }

    public void setSourceImageRectInScreen(String str) {
        this.jQo = str;
    }

    public void LW(String str) {
        this.jQp = str;
    }

    public void ry(boolean z) {
        this.jQq = z;
    }

    public String bhg() {
        return this.eef;
    }

    public String bhh() {
        return this.eeg;
    }

    public ArrayList<AlaInfoData> cNV() {
        return this.jQd;
    }

    public void rz(boolean z) {
        this.mIsReserver = z;
    }

    public void cNW() {
        this.jQm = false;
        if (!this.cJa) {
            c(this.alA, this.jQf, 10, 0);
        }
    }

    public void cNX() {
        this.jQm = true;
        String str = this.jQb.get(0);
        if (StringUtils.isNull(this.jQe)) {
            this.jQe = d.LU(str);
        }
        c(this.alA, this.jQe, 0, 10);
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.jQg != null) {
            if (str2 == null || !str2.equals(this.jQg.getPicId())) {
                this.jQg.cancel();
            } else {
                return;
            }
        }
        this.jQg = new a(str, str2, i, i2);
        this.jQg.setPriority(3);
        this.jQg.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void rA(boolean z) {
        this.jQi = z;
    }

    public void rB(boolean z) {
        this.jQj = z;
    }

    public void a(b bVar) {
        this.jQk = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String alA;
        private aa bGb = null;
        private int jQw;
        private int jQx;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.alA = null;
            this.mPicId = null;
            this.jQw = 0;
            this.jQx = 0;
            this.mPicId = str2;
            this.alA = str;
            this.jQw = i;
            this.jQx = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public h doInBackground(Object... objArr) {
            this.bGb = new aa(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.bGb.addPostData("kw", e.this.hZN);
            this.bGb.addPostData("tid", this.alA);
            if (this.mPicId != null) {
                this.bGb.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.bGb.addPostData("post_id", e.this.mPostId);
            }
            this.bGb.addPostData("source", String.valueOf(e.this.jQj ? 1 : 2));
            e.this.jQj = false;
            this.bGb.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.jQw));
            this.bGb.addPostData("prev", String.valueOf(this.jQx));
            this.bGb.addPostData("not_see_lz", String.valueOf(e.this.jQi ? 0 : 1));
            this.bGb.addPostData("is_top_agree", String.valueOf(e.this.jQq ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.bGb.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.bGb.addPostData("obj_type", e.this.mFrom);
            } else {
                this.bGb.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.jQn)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bjf().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.jQn = com.baidu.tbadk.core.sharedPref.b.bjf().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.bGb.addPostData("applist", e.this.jQn);
            String bwN = y.bwN();
            if (!TextUtils.isEmpty(bwN)) {
                this.bGb.addPostData("oaid", bwN);
            }
            this.bGb.addPostData("ad_ext_params", AdExtParam.a.bwb().bwc());
            cNY();
            this.bGb.bjL().bkq().mNeedBackgroundLogin = false;
            String postNetData = this.bGb.postNetData();
            if (!this.bGb.bjL().bkr().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.aM(postNetData, true);
            return hVar;
        }

        private void cNY() {
            this.bGb.addPostData("forum_id", e.this.mForumId);
            this.bGb.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.bGb.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.bGb.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.bGb.addPostData("q_type", String.valueOf(au.bkm().bkn() ? 2 : 1));
            this.bGb.addPostData("_os_version", Build.VERSION.RELEASE);
            this.bGb.addPostData("page_name", "PB");
            this.bGb.addPostData("pic_index", String.valueOf(e.this.jQb.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bGb != null) {
                this.bGb.cancelNetConnect();
            }
            e.this.jQg = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.eIe != null) {
                e.this.jQg = null;
                if (hVar == null) {
                    if (e.this.jQk != null) {
                        String str = null;
                        int i = -1;
                        if (this.bGb != null) {
                            i = this.bGb.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.bGb.getErrorString();
                            }
                        }
                        e.this.jQk.bm(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = com.baidu.tbadk.core.util.y.isEmpty(hVar.cOh());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.jQb.clear();
                    e.this.eIe.clear();
                    e.this.jQc.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.jQh = hVar.getImageNum();
                }
                e.this.jQl = hVar.cOk();
                e.this.ePo = hVar.ePo;
                e.this.replyPrivateFlag = hVar.cOj();
                e.this.jQt = hVar.jQt;
                e.this.jQu = hVar.jQu;
                e.this.jQv = hVar.jQJ == 1;
                if (this.mPicId == null) {
                    e.this.jQb.clear();
                    e.this.jQc.clear();
                }
                LinkedList<f> cOh = hVar.cOh();
                int size = cOh.size();
                if (size <= 0) {
                    e.this.cJa = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = cOh.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.cNZ();
                        if (at.equals(imageUrlData.id, e.this.jQp)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.jQo);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.cOd();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.bzf();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.forumName = e.this.hZN;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.alA, -1L);
                        imageUrlData.nid = e.this.mNid;
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.cOa(), -1L);
                        imageUrlData.userId = fVar.getUserId();
                        imageUrlData.userNameShow = StringUtils.isNull(fVar.bqp()) ? fVar.getUserName() : fVar.bqp();
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.jQi;
                        imageUrlData.overAllIndex = fVar.cOd();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.cOb();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.cOc();
                        imageUrlData.from = e.this.mFrom;
                        if (fVar.cOf() != null) {
                            imageUrlData.richTextArray = fVar.cOf().toString();
                        }
                        imageUrlData.isFirstPost = fVar.cOg();
                        if (fVar.bhp() != null) {
                            imageUrlData.agreeData = fVar.bhp();
                            imageUrlData.agreeData.isFromImageViewer = true;
                            imageUrlData.agreeData.mImageViewerFromPage = e.this.mFrom;
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.nid = imageUrlData.nid;
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.cOe();
                            if (fVar.cOg()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                            imageUrlData.agreeData.cardType = e.this.jQs;
                            imageUrlData.agreeData.recomSource = e.this.mRecomSource;
                            imageUrlData.agreeData.recomAbTag = e.this.mRecomAbTag;
                            imageUrlData.agreeData.recomExtra = e.this.mRecomExtra;
                            imageUrlData.agreeData.recomWeight = e.this.mRecomWeight;
                        }
                        if (e.this.jQc.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.jQc.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.eIe.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.eIe.put(str3, imageUrlData);
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
                                imageUrlData2.forumName = e.this.hZN;
                                if (at.equals(imageUrlData.id, e.this.jQp)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.jQo);
                                }
                            }
                        } else if (e.this.jQr) {
                            e.this.jQh = e.this.eIe.size();
                            e.this.jQl = null;
                        } else {
                            e.this.eIe.put(str2, imageUrlData);
                            if (e.this.jQm) {
                                e.this.jQb.add(i2, str2);
                            } else {
                                e.this.jQb.add(str2);
                            }
                            e.this.jQc.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) com.baidu.tbadk.core.util.y.getItem(cOh, 0);
                    if (fVar2 != null) {
                        e.this.jQe = fVar2.cNZ();
                    }
                    f fVar3 = (f) com.baidu.tbadk.core.util.y.getItem(cOh, size - 1);
                    if (fVar3 != null) {
                        e.this.jQf = fVar3.cNZ();
                        e.this.cJa = ((long) e.this.jQh) == fVar3.cOd();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.eIe.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.eIe.values()) {
                                if (imageUrlData5.postId != j || imageUrlData5.agreeData == null) {
                                    imageUrlData5 = imageUrlData3;
                                } else {
                                    imageUrlData4.agreeData = imageUrlData5.agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                    imageUrlData4.userId = imageUrlData5.userId;
                                    imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                    imageUrlData4.forumId = e.this.mForumId;
                                    imageUrlData4.forumName = e.this.hZN;
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
                            imageUrlData4.forumName = e.this.hZN;
                        }
                    }
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.alA = this.alA;
                    z = true;
                }
                int position = e.this.jQm ? com.baidu.tbadk.core.util.y.getPosition(e.this.jQb, (String) e.this.jQc.get(this.mPicId)) - 1 : i3;
                e.this.eef = hVar.bhg();
                e.this.eeg = hVar.bhh();
                e.this.iHZ = hVar.btx();
                if (e.this.jQd == null) {
                    e.this.jQd = new ArrayList();
                    if (hVar.cOi() != null && hVar.cOh().size() > 0) {
                        e.this.jQd.addAll(hVar.cOi());
                    }
                }
                if (e.this.jQk != null) {
                    e.this.jQk.a(e.this.jQb, position, e.this.jQh, false, null, z, e.this.jQl, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.byZ() != null && fVar.byZ().length() > 0) {
            return fVar.byZ();
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

    public void rC(boolean z) {
        this.jQr = z;
    }
}
