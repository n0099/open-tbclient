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
/* loaded from: classes6.dex */
public class e {
    private String OG;
    private String cNZ;
    private String cOa;
    private Map<String, ImageUrlData> dny;
    private boolean ear;
    private String gmb;
    private String hPC;
    private String hPD;
    private String hPE;
    private boolean hPF;
    private ArrayList<String> hPr;
    private String hPt;
    private String hPu;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private String mPostId;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> hPs = new HashMap<>();
    private boolean mIsReserver = true;
    private a hPv = null;
    private int hPw = 0;
    private boolean hPx = false;
    private boolean hPy = false;
    private b hPz = null;
    private AdvertAppInfo hPA = null;
    private boolean hPB = false;
    private boolean hPG = false;

    /* loaded from: classes6.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void aL(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.ear = false;
        this.hPr = arrayList;
        this.dny = map;
        if (this.hPr == null) {
            this.hPr = new ArrayList<>();
        }
        Iterator<String> it = this.hPr.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.hPs.put(d.Dx(next), next);
        }
        this.OG = str3;
        this.gmb = str2;
        this.mForumId = str;
        this.hPu = str4;
        this.mThreadType = i;
        this.ear = this.hPu == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.hPF = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.hPD = str;
    }

    public void Dz(String str) {
        this.hPE = str;
    }

    public void oj(boolean z) {
        this.hPF = z;
    }

    public String aBD() {
        return this.cNZ;
    }

    public String aBE() {
        return this.cOa;
    }

    public void ok(boolean z) {
        this.mIsReserver = z;
    }

    public void bYH() {
        this.hPB = false;
        if (!this.ear) {
            d(this.OG, this.hPu, 10, 0);
        }
    }

    public void bYI() {
        this.hPB = true;
        String str = this.hPr.get(0);
        if (StringUtils.isNull(this.hPt)) {
            this.hPt = d.Dx(str);
        }
        d(this.OG, this.hPt, 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.hPv != null) {
            if (str2 == null || !str2.equals(this.hPv.getPicId())) {
                this.hPv.cancel();
            } else {
                return;
            }
        }
        this.hPv = new a(str, str2, i, i2);
        this.hPv.setPriority(3);
        this.hPv.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void ol(boolean z) {
        this.hPx = z;
    }

    public void om(boolean z) {
        this.hPy = z;
    }

    public void a(b bVar) {
        this.hPz = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String OG;
        private x cHA = null;
        private int hPH;
        private int hPI;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.OG = null;
            this.mPicId = null;
            this.hPH = 0;
            this.hPI = 0;
            this.mPicId = str2;
            this.OG = str;
            this.hPH = i;
            this.hPI = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public h doInBackground(Object... objArr) {
            this.cHA = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.cHA.addPostData("kw", e.this.gmb);
            this.cHA.addPostData("tid", this.OG);
            if (this.mPicId != null) {
                this.cHA.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.cHA.addPostData("post_id", e.this.mPostId);
            }
            this.cHA.addPostData("source", String.valueOf(e.this.hPy ? 1 : 2));
            e.this.hPy = false;
            this.cHA.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.hPH));
            this.cHA.addPostData("prev", String.valueOf(this.hPI));
            this.cHA.addPostData("not_see_lz", String.valueOf(e.this.hPx ? 0 : 1));
            this.cHA.addPostData("is_top_agree", String.valueOf(e.this.hPF ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.cHA.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.cHA.addPostData("obj_type", e.this.mFrom);
            } else {
                this.cHA.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.hPC)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aDr().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.hPC = com.baidu.tbadk.core.sharedPref.b.aDr().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.cHA.addPostData("applist", e.this.hPC);
            String aPS = w.aPS();
            if (!TextUtils.isEmpty(aPS)) {
                this.cHA.addPostData("oaid", aPS);
            }
            bYJ();
            this.cHA.aDU().aEu().mNeedBackgroundLogin = false;
            String postNetData = this.cHA.postNetData();
            if (!this.cHA.aDU().aEv().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.ap(postNetData, true);
            return hVar;
        }

        private void bYJ() {
            this.cHA.addPostData("forum_id", e.this.mForumId);
            this.cHA.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.cHA.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.cHA.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.cHA.addPostData("q_type", String.valueOf(ar.aEq().aEr() ? 2 : 1));
            this.cHA.addPostData("_os_version", Build.VERSION.RELEASE);
            this.cHA.addPostData("page_name", "PB");
            this.cHA.addPostData("pic_index", String.valueOf(e.this.hPr.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.cHA != null) {
                this.cHA.cancelNetConnect();
            }
            e.this.hPv = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.dny != null) {
                e.this.hPv = null;
                if (hVar == null) {
                    if (e.this.hPz != null) {
                        String str = null;
                        int i = -1;
                        if (this.cHA != null) {
                            i = this.cHA.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.cHA.getErrorString();
                            }
                        }
                        e.this.hPz.aL(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = v.isEmpty(hVar.bYS());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.hPr.clear();
                    e.this.dny.clear();
                    e.this.hPs.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.hPw = hVar.getImageNum();
                }
                e.this.hPA = hVar.bYT();
                if (this.mPicId == null) {
                    e.this.hPr.clear();
                    e.this.hPs.clear();
                }
                LinkedList<f> bYS = hVar.bYS();
                int size = bYS.size();
                if (size <= 0) {
                    e.this.ear = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = bYS.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.bYK();
                        if (aq.equals(imageUrlData.id, e.this.hPE)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.hPD);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.bYO();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.aRW();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.OG, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.bYL(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.hPx;
                        imageUrlData.overAllIndex = fVar.bYO();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.bYM();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.bYN();
                        if (fVar.bYQ() != null) {
                            imageUrlData.richTextArray = fVar.bYQ().toString();
                        }
                        imageUrlData.isFirstPost = fVar.bYR();
                        if (fVar.aBM() != null) {
                            imageUrlData.agreeData = fVar.aBM();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.bYP();
                            if (fVar.bYR()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.hPs.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.hPs.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.dny.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.dny.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (aq.equals(imageUrlData.id, e.this.hPE)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.hPD);
                                }
                            }
                        } else if (e.this.hPG) {
                            e.this.hPw = e.this.dny.size();
                            e.this.hPA = null;
                        } else {
                            e.this.dny.put(str2, imageUrlData);
                            if (e.this.hPB) {
                                e.this.hPr.add(i2, str2);
                            } else {
                                e.this.hPr.add(str2);
                            }
                            e.this.hPs.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.getItem(bYS, 0);
                    if (fVar2 != null) {
                        e.this.hPt = fVar2.bYK();
                    }
                    f fVar3 = (f) v.getItem(bYS, size - 1);
                    if (fVar3 != null) {
                        e.this.hPu = fVar3.bYK();
                        e.this.ear = ((long) e.this.hPw) == fVar3.bYO();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.dny.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.dny.values()) {
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
                    e.this.OG = this.OG;
                    z = true;
                }
                int position = e.this.hPB ? v.getPosition(e.this.hPr, (String) e.this.hPs.get(this.mPicId)) - 1 : i3;
                e.this.cNZ = hVar.aBD();
                e.this.cOa = hVar.aBE();
                if (e.this.hPz != null) {
                    e.this.hPz.a(e.this.hPr, position, e.this.hPw, false, null, z, e.this.hPA, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.aRQ() != null && fVar.aRQ().length() > 0) {
            return fVar.aRQ();
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

    public void on(boolean z) {
        this.hPG = z;
    }
}
