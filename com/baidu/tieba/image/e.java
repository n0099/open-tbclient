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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes8.dex */
public class e {
    private String Pk;
    private String cSr;
    private String cSs;
    private Map<String, ImageUrlData> dsi;
    private boolean eeY;
    private String gpb;
    private ArrayList<String> hTd;
    private String hTf;
    private String hTg;
    private String hTo;
    private String hTp;
    private String hTq;
    private boolean hTr;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private String mPostId;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> hTe = new HashMap<>();
    private boolean mIsReserver = true;
    private a hTh = null;
    private int hTi = 0;
    private boolean hTj = false;
    private boolean hTk = false;
    private b hTl = null;
    private AdvertAppInfo hTm = null;
    private boolean hTn = false;
    private boolean hTs = false;

    /* loaded from: classes8.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void aL(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eeY = false;
        this.hTd = arrayList;
        this.dsi = map;
        if (this.hTd == null) {
            this.hTd = new ArrayList<>();
        }
        Iterator<String> it = this.hTd.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.hTe.put(d.DN(next), next);
        }
        this.Pk = str3;
        this.gpb = str2;
        this.mForumId = str;
        this.hTg = str4;
        this.mThreadType = i;
        this.eeY = this.hTg == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.hTr = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.hTp = str;
    }

    public void DP(String str) {
        this.hTq = str;
    }

    public void or(boolean z) {
        this.hTr = z;
    }

    public String aDW() {
        return this.cSr;
    }

    public String aDX() {
        return this.cSs;
    }

    public void os(boolean z) {
        this.mIsReserver = z;
    }

    public void caE() {
        this.hTn = false;
        if (!this.eeY) {
            d(this.Pk, this.hTg, 10, 0);
        }
    }

    public void caF() {
        this.hTn = true;
        String str = this.hTd.get(0);
        if (StringUtils.isNull(this.hTf)) {
            this.hTf = d.DN(str);
        }
        d(this.Pk, this.hTf, 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.hTh != null) {
            if (str2 == null || !str2.equals(this.hTh.getPicId())) {
                this.hTh.cancel();
            } else {
                return;
            }
        }
        this.hTh = new a(str, str2, i, i2);
        this.hTh.setPriority(3);
        this.hTh.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void ot(boolean z) {
        this.hTj = z;
    }

    public void ou(boolean z) {
        this.hTk = z;
    }

    public void a(b bVar) {
        this.hTl = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String Pk;
        private x cLQ = null;
        private int hTt;
        private int hTu;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.Pk = null;
            this.mPicId = null;
            this.hTt = 0;
            this.hTu = 0;
            this.mPicId = str2;
            this.Pk = str;
            this.hTt = i;
            this.hTu = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public h doInBackground(Object... objArr) {
            this.cLQ = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.cLQ.addPostData("kw", e.this.gpb);
            this.cLQ.addPostData("tid", this.Pk);
            if (this.mPicId != null) {
                this.cLQ.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.cLQ.addPostData("post_id", e.this.mPostId);
            }
            this.cLQ.addPostData("source", String.valueOf(e.this.hTk ? 1 : 2));
            e.this.hTk = false;
            this.cLQ.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.hTt));
            this.cLQ.addPostData("prev", String.valueOf(this.hTu));
            this.cLQ.addPostData("not_see_lz", String.valueOf(e.this.hTj ? 0 : 1));
            this.cLQ.addPostData("is_top_agree", String.valueOf(e.this.hTr ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.cLQ.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.cLQ.addPostData("obj_type", e.this.mFrom);
            } else {
                this.cLQ.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.hTo)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aFH().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.hTo = com.baidu.tbadk.core.sharedPref.b.aFH().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.cLQ.addPostData("applist", e.this.hTo);
            String aSq = w.aSq();
            if (!TextUtils.isEmpty(aSq)) {
                this.cLQ.addPostData("oaid", aSq);
            }
            caG();
            this.cLQ.aGk().aGL().mNeedBackgroundLogin = false;
            String postNetData = this.cLQ.postNetData();
            if (!this.cLQ.aGk().aGM().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.ap(postNetData, true);
            return hVar;
        }

        private void caG() {
            this.cLQ.addPostData("forum_id", e.this.mForumId);
            this.cLQ.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.cLQ.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.cLQ.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.cLQ.addPostData("q_type", String.valueOf(ar.aGH().aGI() ? 2 : 1));
            this.cLQ.addPostData("_os_version", Build.VERSION.RELEASE);
            this.cLQ.addPostData("page_name", "PB");
            this.cLQ.addPostData("pic_index", String.valueOf(e.this.hTd.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.cLQ != null) {
                this.cLQ.cancelNetConnect();
            }
            e.this.hTh = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.dsi != null) {
                e.this.hTh = null;
                if (hVar == null) {
                    if (e.this.hTl != null) {
                        String str = null;
                        int i = -1;
                        if (this.cLQ != null) {
                            i = this.cLQ.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.cLQ.getErrorString();
                            }
                        }
                        e.this.hTl.aL(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = v.isEmpty(hVar.caP());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.hTd.clear();
                    e.this.dsi.clear();
                    e.this.hTe.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.hTi = hVar.getImageNum();
                }
                e.this.hTm = hVar.caQ();
                if (this.mPicId == null) {
                    e.this.hTd.clear();
                    e.this.hTe.clear();
                }
                LinkedList<f> caP = hVar.caP();
                int size = caP.size();
                if (size <= 0) {
                    e.this.eeY = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = caP.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.caH();
                        if (aq.equals(imageUrlData.id, e.this.hTq)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.hTp);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.caL();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.aUt();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.Pk, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.caI(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.hTj;
                        imageUrlData.overAllIndex = fVar.caL();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.caJ();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.caK();
                        if (fVar.caN() != null) {
                            imageUrlData.richTextArray = fVar.caN().toString();
                        }
                        imageUrlData.isFirstPost = fVar.caO();
                        if (fVar.aEe() != null) {
                            imageUrlData.agreeData = fVar.aEe();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.caM();
                            if (fVar.caO()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.hTe.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.hTe.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.dsi.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.dsi.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (aq.equals(imageUrlData.id, e.this.hTq)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.hTp);
                                }
                            }
                        } else if (e.this.hTs) {
                            e.this.hTi = e.this.dsi.size();
                            e.this.hTm = null;
                        } else {
                            e.this.dsi.put(str2, imageUrlData);
                            if (e.this.hTn) {
                                e.this.hTd.add(i2, str2);
                            } else {
                                e.this.hTd.add(str2);
                            }
                            e.this.hTe.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.getItem(caP, 0);
                    if (fVar2 != null) {
                        e.this.hTf = fVar2.caH();
                    }
                    f fVar3 = (f) v.getItem(caP, size - 1);
                    if (fVar3 != null) {
                        e.this.hTg = fVar3.caH();
                        e.this.eeY = ((long) e.this.hTi) == fVar3.caL();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.dsi.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.dsi.values()) {
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
                    e.this.Pk = this.Pk;
                    z = true;
                }
                int position = e.this.hTn ? v.getPosition(e.this.hTd, (String) e.this.hTe.get(this.mPicId)) - 1 : i3;
                e.this.cSr = hVar.aDW();
                e.this.cSs = hVar.aDX();
                if (e.this.hTl != null) {
                    e.this.hTl.a(e.this.hTd, position, e.this.hTi, false, null, z, e.this.hTm, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.aUn() != null && fVar.aUn().length() > 0) {
            return fVar.aUn();
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

    public void ov(boolean z) {
        this.hTs = z;
    }
}
