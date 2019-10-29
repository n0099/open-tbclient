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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes3.dex */
public class e {
    private Map<String, ImageUrlData> cAw;
    private String cmS;
    private boolean dqS;
    private String fvg;
    private ArrayList<String> gYE;
    private String gYG;
    private String gYH;
    private String gYP;
    private String gYQ;
    private String gYR;
    private boolean gYS;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> gYF = new HashMap<>();
    private boolean mIsReserver = true;
    private a gYI = null;
    private int gYJ = 0;
    private boolean gYK = false;
    private boolean gYL = false;
    private b gYM = null;
    private AdvertAppInfo gYN = null;
    private boolean gYO = false;

    /* loaded from: classes3.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void ar(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.dqS = false;
        this.gYE = arrayList;
        this.cAw = map;
        if (this.gYE == null) {
            this.gYE = new ArrayList<>();
        }
        Iterator<String> it = this.gYE.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.gYF.put(d.yE(next), next);
        }
        this.cmS = str3;
        this.fvg = str2;
        this.mForumId = str;
        this.gYH = str4;
        this.mThreadType = i;
        this.dqS = this.gYH == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.gYS = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.gYQ = str;
    }

    public void yG(String str) {
        this.gYR = str;
    }

    public void mJ(boolean z) {
        this.gYS = z;
    }

    public void mK(boolean z) {
        this.mIsReserver = z;
    }

    public void bGn() {
        this.gYO = false;
        if (!this.dqS) {
            d(this.cmS, this.gYH, 10, 0);
        }
    }

    public void bGo() {
        this.gYO = true;
        String str = this.gYE.get(0);
        if (StringUtils.isNull(this.gYG)) {
            this.gYG = d.yE(str);
        }
        d(this.cmS, this.gYG, 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.gYI != null) {
            if (str2 == null || !str2.equals(this.gYI.getPicId())) {
                this.gYI.cancel();
            } else {
                return;
            }
        }
        this.gYI = new a(str, str2, i, i2);
        this.gYI.setPriority(3);
        this.gYI.execute(new Object[0]);
    }

    public void mL(boolean z) {
        this.gYK = z;
    }

    public void mM(boolean z) {
        this.gYL = z;
    }

    public void a(b bVar) {
        this.gYM = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private x bVP = null;
        private String cmS;
        private int gYT;
        private int gYU;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.cmS = null;
            this.mPicId = null;
            this.gYT = 0;
            this.gYU = 0;
            this.mPicId = str2;
            this.cmS = str;
            this.gYT = i;
            this.gYU = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public h doInBackground(Object... objArr) {
            this.bVP = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.bVP.addPostData("kw", e.this.fvg);
            this.bVP.addPostData("tid", this.cmS);
            if (this.mPicId != null) {
                this.bVP.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.bVP.addPostData("source", String.valueOf(e.this.gYL ? 1 : 2));
            e.this.gYL = false;
            this.bVP.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.gYT));
            this.bVP.addPostData("prev", String.valueOf(this.gYU));
            this.bVP.addPostData("not_see_lz", String.valueOf(e.this.gYK ? 0 : 1));
            this.bVP.addPostData("is_top_agree", String.valueOf(e.this.gYS ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.bVP.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.bVP.addPostData("obj_type", e.this.mFrom);
            } else {
                this.bVP.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.gYP)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.alR().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.gYP = com.baidu.tbadk.core.sharedPref.b.alR().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.bVP.addPostData("applist", e.this.gYP);
            bGp();
            this.bVP.amr().amR().mNeedBackgroundLogin = false;
            String postNetData = this.bVP.postNetData();
            if (!this.bVP.amr().amS().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.al(postNetData, true);
            return hVar;
        }

        private void bGp() {
            this.bVP.addPostData("forum_id", e.this.mForumId);
            this.bVP.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.bVP.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.bVP.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.bVP.addPostData("q_type", String.valueOf(ar.amO().isFrsShowBigImage() ? 2 : 1));
            this.bVP.addPostData("_os_version", Build.VERSION.RELEASE);
            this.bVP.addPostData("page_name", "PB");
            this.bVP.addPostData("pic_index", String.valueOf(e.this.gYE.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bVP != null) {
                this.bVP.cancelNetConnect();
            }
            e.this.gYI = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.cAw != null) {
                e.this.gYI = null;
                if (hVar == null) {
                    if (e.this.gYM != null) {
                        String str = null;
                        int i = -1;
                        if (this.bVP != null) {
                            i = this.bVP.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.bVP.getErrorString();
                            }
                        }
                        e.this.gYM.ar(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = v.isEmpty(hVar.bGy());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.gYE.clear();
                    e.this.cAw.clear();
                    e.this.gYF.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.gYJ = hVar.getImageNum();
                }
                e.this.gYN = hVar.bGz();
                if (this.mPicId == null) {
                    e.this.gYE.clear();
                    e.this.gYF.clear();
                }
                LinkedList<f> bGy = hVar.bGy();
                int size = bGy.size();
                if (size <= 0) {
                    e.this.dqS = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = bGy.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.bGq();
                        if (aq.equals(imageUrlData.id, e.this.gYR)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.gYQ);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.bGu();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.azG();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.toLong(this.cmS, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.toLong(fVar.bGr(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.gYK;
                        imageUrlData.overAllIndex = fVar.bGu();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.bGs();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.bGt();
                        if (fVar.bGw() != null) {
                            imageUrlData.richTextArray = fVar.bGw().toString();
                        }
                        imageUrlData.isFirstPost = fVar.bGx();
                        if (fVar.akv() != null) {
                            imageUrlData.agreeData = fVar.akv();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.bGv();
                            if (fVar.bGx()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.gYF.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.gYF.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.cAw.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.cAw.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (aq.equals(imageUrlData.id, e.this.gYR)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.gYQ);
                                }
                            }
                        } else {
                            e.this.cAw.put(str2, imageUrlData);
                            if (e.this.gYO) {
                                e.this.gYE.add(i2, str2);
                            } else {
                                e.this.gYE.add(str2);
                            }
                            e.this.gYF.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.getItem(bGy, 0);
                    if (fVar2 != null) {
                        e.this.gYG = fVar2.bGq();
                    }
                    f fVar3 = (f) v.getItem(bGy, size - 1);
                    if (fVar3 != null) {
                        e.this.gYH = fVar3.bGq();
                        e.this.dqS = ((long) e.this.gYJ) == fVar3.bGu();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.cAw.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.cAw.values()) {
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
                    e.this.cmS = this.cmS;
                    z = true;
                }
                int position = e.this.gYO ? v.getPosition(e.this.gYE, (String) e.this.gYF.get(this.mPicId)) - 1 : i3;
                if (e.this.gYM != null) {
                    e.this.gYM.a(e.this.gYE, position, e.this.gYJ, false, null, z, e.this.gYN, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.azA() != null && fVar.azA().length() > 0) {
            return fVar.azA();
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
}
