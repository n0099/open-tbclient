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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes8.dex */
public class e {
    private String ajO;
    private String dMk;
    private String dMl;
    private boolean dxm;
    private Map<String, ImageUrlData> epf;
    private String hzC;
    private ArrayList<String> jjN;
    private ArrayList<AlaInfoData> jjP;
    private String jjQ;
    private String jjR;
    private String jjZ;
    private String jka;
    private String jkb;
    private boolean jkc;
    private int jke;
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
    private HashMap<String, String> jjO = new HashMap<>();
    private boolean mIsReserver = true;
    private a jjS = null;
    private int jjT = 0;
    private boolean jjU = false;
    private boolean jjV = false;
    private b jjW = null;
    private AdvertAppInfo jjX = null;
    private boolean jjY = false;
    private boolean jkd = false;

    /* loaded from: classes8.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void bj(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        this.dxm = false;
        this.jjN = arrayList;
        this.epf = map;
        if (this.jjN == null) {
            this.jjN = new ArrayList<>();
        }
        Iterator<String> it = this.jjN.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.jjO.put(d.HK(next), next);
        }
        this.ajO = str3;
        this.mNid = str4;
        this.hzC = str2;
        this.mForumId = str;
        this.jjR = str5;
        this.mThreadType = i;
        this.dxm = this.jjR == null;
        this.mUserId = str6;
        this.mFrom = str7;
        this.mIsReset = z;
        this.jkc = false;
        this.jke = i2;
        this.mRecomSource = str8;
        this.mRecomAbTag = str9;
        this.mRecomWeight = str10;
        this.mRecomExtra = str11;
    }

    public void setSourceImageRectInScreen(String str) {
        this.jka = str;
    }

    public void HM(String str) {
        this.jkb = str;
    }

    public void qb(boolean z) {
        this.jkc = z;
    }

    public String aTX() {
        return this.dMk;
    }

    public String aTY() {
        return this.dMl;
    }

    public ArrayList<AlaInfoData> cvC() {
        return this.jjP;
    }

    public void qc(boolean z) {
        this.mIsReserver = z;
    }

    public void cvD() {
        this.jjY = false;
        if (!this.dxm) {
            c(this.ajO, this.jjR, 10, 0);
        }
    }

    public void cvE() {
        this.jjY = true;
        String str = this.jjN.get(0);
        if (StringUtils.isNull(this.jjQ)) {
            this.jjQ = d.HK(str);
        }
        c(this.ajO, this.jjQ, 0, 10);
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.jjS != null) {
            if (str2 == null || !str2.equals(this.jjS.getPicId())) {
                this.jjS.cancel();
            } else {
                return;
            }
        }
        this.jjS = new a(str, str2, i, i2);
        this.jjS.setPriority(3);
        this.jjS.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void qd(boolean z) {
        this.jjU = z;
    }

    public void qe(boolean z) {
        this.jjV = z;
    }

    public void a(b bVar) {
        this.jjW = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String ajO;
        private y byb = null;
        private int jkf;
        private int jkg;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.ajO = null;
            this.mPicId = null;
            this.jkf = 0;
            this.jkg = 0;
            this.mPicId = str2;
            this.ajO = str;
            this.jkf = i;
            this.jkg = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public h doInBackground(Object... objArr) {
            this.byb = new y(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.byb.addPostData("kw", e.this.hzC);
            this.byb.addPostData("tid", this.ajO);
            if (this.mPicId != null) {
                this.byb.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.byb.addPostData("post_id", e.this.mPostId);
            }
            this.byb.addPostData("source", String.valueOf(e.this.jjV ? 1 : 2));
            e.this.jjV = false;
            this.byb.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.jkf));
            this.byb.addPostData("prev", String.valueOf(this.jkg));
            this.byb.addPostData("not_see_lz", String.valueOf(e.this.jjU ? 0 : 1));
            this.byb.addPostData("is_top_agree", String.valueOf(e.this.jkc ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.byb.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.byb.addPostData("obj_type", e.this.mFrom);
            } else {
                this.byb.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.jjZ)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aVP().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.jjZ = com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.byb.addPostData("applist", e.this.jjZ);
            String biX = x.biX();
            if (!TextUtils.isEmpty(biX)) {
                this.byb.addPostData("oaid", biX);
            }
            cvF();
            this.byb.aWu().aWV().mNeedBackgroundLogin = false;
            String postNetData = this.byb.postNetData();
            if (!this.byb.aWu().aWW().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.aK(postNetData, true);
            return hVar;
        }

        private void cvF() {
            this.byb.addPostData("forum_id", e.this.mForumId);
            this.byb.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.byb.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.byb.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.byb.addPostData("q_type", String.valueOf(as.aWR().aWS() ? 2 : 1));
            this.byb.addPostData("_os_version", Build.VERSION.RELEASE);
            this.byb.addPostData("page_name", "PB");
            this.byb.addPostData("pic_index", String.valueOf(e.this.jjN.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.byb != null) {
                this.byb.cancelNetConnect();
            }
            e.this.jjS = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.epf != null) {
                e.this.jjS = null;
                if (hVar == null) {
                    if (e.this.jjW != null) {
                        String str = null;
                        int i = -1;
                        if (this.byb != null) {
                            i = this.byb.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.byb.getErrorString();
                            }
                        }
                        e.this.jjW.bj(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = w.isEmpty(hVar.cvO());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.jjN.clear();
                    e.this.epf.clear();
                    e.this.jjO.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.jjT = hVar.getImageNum();
                }
                e.this.jjX = hVar.cvQ();
                if (this.mPicId == null) {
                    e.this.jjN.clear();
                    e.this.jjO.clear();
                }
                LinkedList<f> cvO = hVar.cvO();
                int size = cvO.size();
                if (size <= 0) {
                    e.this.dxm = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = cvO.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.cvG();
                        if (ar.equals(imageUrlData.id, e.this.jkb)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.jka);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.cvK();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.bln();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.ajO, -1L);
                        imageUrlData.nid = e.this.mNid;
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.cvH(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.jjU;
                        imageUrlData.overAllIndex = fVar.cvK();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.cvI();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.cvJ();
                        imageUrlData.from = e.this.mFrom;
                        if (fVar.cvM() != null) {
                            imageUrlData.richTextArray = fVar.cvM().toString();
                        }
                        imageUrlData.isFirstPost = fVar.cvN();
                        if (fVar.aUg() != null) {
                            imageUrlData.agreeData = fVar.aUg();
                            imageUrlData.agreeData.isFromImageViewer = true;
                            imageUrlData.agreeData.mImageViewerFromPage = e.this.mFrom;
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.nid = imageUrlData.nid;
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.cvL();
                            if (fVar.cvN()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                            imageUrlData.agreeData.cardType = e.this.jke;
                            imageUrlData.agreeData.recomSource = e.this.mRecomSource;
                            imageUrlData.agreeData.recomAbTag = e.this.mRecomAbTag;
                            imageUrlData.agreeData.recomExtra = e.this.mRecomExtra;
                            imageUrlData.agreeData.recomWeight = e.this.mRecomWeight;
                        }
                        if (e.this.jjO.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.jjO.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.epf.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.epf.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (ar.equals(imageUrlData.id, e.this.jkb)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.jka);
                                }
                            }
                        } else if (e.this.jkd) {
                            e.this.jjT = e.this.epf.size();
                            e.this.jjX = null;
                        } else {
                            e.this.epf.put(str2, imageUrlData);
                            if (e.this.jjY) {
                                e.this.jjN.add(i2, str2);
                            } else {
                                e.this.jjN.add(str2);
                            }
                            e.this.jjO.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) w.getItem(cvO, 0);
                    if (fVar2 != null) {
                        e.this.jjQ = fVar2.cvG();
                    }
                    f fVar3 = (f) w.getItem(cvO, size - 1);
                    if (fVar3 != null) {
                        e.this.jjR = fVar3.cvG();
                        e.this.dxm = ((long) e.this.jjT) == fVar3.cvK();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.epf.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.epf.values()) {
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
                    e.this.ajO = this.ajO;
                    z = true;
                }
                int position = e.this.jjY ? w.getPosition(e.this.jjN, (String) e.this.jjO.get(this.mPicId)) - 1 : i3;
                e.this.dMk = hVar.aTX();
                e.this.dMl = hVar.aTY();
                if (e.this.jjP == null) {
                    e.this.jjP = new ArrayList();
                    if (hVar.cvP() != null && hVar.cvO().size() > 0) {
                        e.this.jjP.addAll(hVar.cvP());
                    }
                }
                if (e.this.jjW != null) {
                    e.this.jjW.a(e.this.jjN, position, e.this.jjT, false, null, z, e.this.jjX, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.blh() != null && fVar.blh().length() > 0) {
            return fVar.blh();
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
        sb.append(ar.getUrlEncode(fVar.getImageUrl()));
        return sb.toString();
    }

    public void qf(boolean z) {
        this.jkd = z;
    }
}
