package com.baidu.tieba.image;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
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
    private String bWU;
    private Map<String, ImageUrlData> cmD;
    private boolean dfM;
    private String fug;
    private ArrayList<String> gYH;
    private String gYJ;
    private String gYK;
    private String gYS;
    private String gYT;
    private String gYU;
    private boolean gYV;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> gYI = new HashMap<>();
    private boolean mIsReserver = true;
    private a gYL = null;
    private int gYM = 0;
    private boolean gYN = false;
    private boolean gYO = false;
    private b gYP = null;
    private AdvertAppInfo gYQ = null;
    private boolean gYR = false;

    /* loaded from: classes3.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void ar(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.dfM = false;
        this.gYH = arrayList;
        this.cmD = map;
        if (this.gYH == null) {
            this.gYH = new ArrayList<>();
        }
        Iterator<String> it = this.gYH.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.gYI.put(d.zN(next), next);
        }
        this.bWU = str3;
        this.fug = str2;
        this.mForumId = str;
        this.gYK = str4;
        this.mThreadType = i;
        this.dfM = this.gYK == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.gYV = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.gYT = str;
    }

    public void zP(String str) {
        this.gYU = str;
    }

    public void mS(boolean z) {
        this.gYV = z;
    }

    public void mT(boolean z) {
        this.mIsReserver = z;
    }

    public void bIQ() {
        this.gYR = false;
        if (!this.dfM) {
            e(this.bWU, this.gYK, 10, 0);
        }
    }

    public void bIR() {
        this.gYR = true;
        String str = this.gYH.get(0);
        if (StringUtils.isNull(this.gYJ)) {
            this.gYJ = d.zN(str);
        }
        e(this.bWU, this.gYJ, 0, 10);
    }

    private void e(String str, String str2, int i, int i2) {
        if (this.gYL != null) {
            if (str2 == null || !str2.equals(this.gYL.getPicId())) {
                this.gYL.cancel();
            } else {
                return;
            }
        }
        this.gYL = new a(str, str2, i, i2);
        this.gYL.setPriority(3);
        this.gYL.execute(new Object[0]);
    }

    public void mU(boolean z) {
        this.gYN = z;
    }

    public void mV(boolean z) {
        this.gYO = z;
    }

    public void a(b bVar) {
        this.gYP = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String bWU;
        private int gYW;
        private int gYX;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.bWU = null;
            this.mPicId = null;
            this.gYW = 0;
            this.gYX = 0;
            this.mPicId = str2;
            this.bWU = str;
            this.gYW = i;
            this.gYX = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public h doInBackground(Object... objArr) {
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.mNetWork.o("kw", e.this.fug);
            this.mNetWork.o("tid", this.bWU);
            if (this.mPicId != null) {
                this.mNetWork.o(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.o("source", String.valueOf(e.this.gYO ? 1 : 2));
            e.this.gYO = false;
            this.mNetWork.o(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.gYW));
            this.mNetWork.o("prev", String.valueOf(this.gYX));
            this.mNetWork.o("not_see_lz", String.valueOf(e.this.gYN ? 0 : 1));
            this.mNetWork.o("is_top_agree", String.valueOf(e.this.gYV ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.mNetWork.o("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.o("obj_type", e.this.mFrom);
            } else {
                this.mNetWork.o("obj_type", ImageViewerConfig.FROM_OTHER);
            }
            if (TextUtils.isEmpty(e.this.gYS)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.gYS = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.o("applist", e.this.gYS);
            bIS();
            this.mNetWork.aiG().ajG().bUM = false;
            String aii = this.mNetWork.aii();
            if (!this.mNetWork.aiG().ajH().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.ap(aii, true);
            return hVar;
        }

        private void bIS() {
            this.mNetWork.o("forum_id", e.this.mForumId);
            this.mNetWork.o("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.o("scr_w", String.valueOf(l.af(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("scr_h", String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("q_type", String.valueOf(as.ajq().ajs() ? 2 : 1));
            this.mNetWork.o("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.o("page_name", "PB");
            this.mNetWork.o("pic_index", String.valueOf(e.this.gYH.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.ik();
            }
            e.this.gYL = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.cmD != null) {
                e.this.gYL = null;
                if (hVar == null) {
                    if (e.this.gYP != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.aiK();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.gYP.ar(i, str);
                        return;
                    }
                    return;
                }
                boolean aa = v.aa(hVar.bJb());
                if (e.this.mIsReset && !aa) {
                    e.this.gYH.clear();
                    e.this.cmD.clear();
                    e.this.gYI.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.gYM = hVar.getImageNum();
                }
                e.this.gYQ = hVar.bJc();
                if (this.mPicId == null) {
                    e.this.gYH.clear();
                    e.this.gYI.clear();
                }
                LinkedList<f> bJb = hVar.bJb();
                int size = bJb.size();
                if (size <= 0) {
                    e.this.dfM = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = bJb.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.bIT();
                        if (aq.bV(imageUrlData.id, e.this.gYU)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.gYT);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.bIX();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.azl();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.bWU, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(fVar.bIU(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.gYN;
                        imageUrlData.overAllIndex = fVar.bIX();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.bIV();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.bIW();
                        if (fVar.bIZ() != null) {
                            imageUrlData.richTextArray = fVar.bIZ().toString();
                        }
                        imageUrlData.isFirstPost = fVar.bJa();
                        if (fVar.ago() != null) {
                            imageUrlData.agreeData = fVar.ago();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.bIY();
                            if (fVar.bJa()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.gYI.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.gYI.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.cmD.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.cmD.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (aq.bV(imageUrlData.id, e.this.gYU)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.gYT);
                                }
                            }
                        } else {
                            e.this.cmD.put(str2, imageUrlData);
                            if (e.this.gYR) {
                                e.this.gYH.add(i2, str2);
                            } else {
                                e.this.gYH.add(str2);
                            }
                            e.this.gYI.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.c(bJb, 0);
                    if (fVar2 != null) {
                        e.this.gYJ = fVar2.bIT();
                    }
                    f fVar3 = (f) v.c(bJb, size - 1);
                    if (fVar3 != null) {
                        e.this.gYK = fVar3.bIT();
                        e.this.dfM = ((long) e.this.gYM) == fVar3.bIX();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.cmD.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.cmD.values()) {
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
                    e.this.bWU = this.bWU;
                    z = true;
                }
                int a2 = e.this.gYR ? v.a(e.this.gYH, (String) e.this.gYI.get(this.mPicId)) - 1 : i3;
                if (e.this.gYP != null) {
                    e.this.gYP.a(e.this.gYH, a2, e.this.gYM, false, null, z, e.this.gYQ, aa);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.azf() != null && fVar.azf().length() > 0) {
            return fVar.azf();
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
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
        sb.append(aq.bi(fVar.getImageUrl()));
        return sb.toString();
    }
}
