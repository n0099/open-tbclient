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
import com.baidu.tbadk.core.util.ap;
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
    private Map<String, ImageUrlData> cdb;
    private String ctx;
    private String eYL;
    private ArrayList<String> gAA;
    private String gAC;
    private String gAD;
    private boolean gAE;
    private String gAM;
    private String gAN;
    private String gAO;
    private boolean gAP;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> gAB = new HashMap<>();
    private boolean mIsReserver = true;
    private a gAF = null;
    private int gAG = 0;
    private boolean gAH = false;
    private boolean gAI = false;
    private b gAJ = null;
    private AdvertAppInfo gAK = null;
    private boolean gAL = false;

    /* loaded from: classes3.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void am(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.gAE = false;
        this.gAA = arrayList;
        this.cdb = map;
        if (this.gAA == null) {
            this.gAA = new ArrayList<>();
        }
        Iterator<String> it = this.gAA.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.gAB.put(d.xM(next), next);
        }
        this.ctx = str3;
        this.eYL = str2;
        this.mForumId = str;
        this.gAD = str4;
        this.mThreadType = i;
        this.gAE = this.gAD == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.gAP = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.gAN = str;
    }

    public void xO(String str) {
        this.gAO = str;
    }

    public void lO(boolean z) {
        this.gAP = z;
    }

    public void lP(boolean z) {
        this.mIsReserver = z;
    }

    public void bym() {
        this.gAL = false;
        if (!this.gAE) {
            e(this.ctx, this.gAD, 10, 0);
        }
    }

    public void byn() {
        this.gAL = true;
        String str = this.gAA.get(0);
        if (StringUtils.isNull(this.gAC)) {
            this.gAC = d.xM(str);
        }
        e(this.ctx, this.gAC, 0, 10);
    }

    private void e(String str, String str2, int i, int i2) {
        if (this.gAF != null) {
            if (str2 == null || !str2.equals(this.gAF.getPicId())) {
                this.gAF.cancel();
            } else {
                return;
            }
        }
        this.gAF = new a(str, str2, i, i2);
        this.gAF.setPriority(3);
        this.gAF.execute(new Object[0]);
    }

    public void lQ(boolean z) {
        this.gAH = z;
    }

    public void lR(boolean z) {
        this.gAI = z;
    }

    public void a(b bVar) {
        this.gAJ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String ctx;
        private int gAQ;
        private int gAR;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.ctx = null;
            this.mPicId = null;
            this.gAQ = 0;
            this.gAR = 0;
            this.mPicId = str2;
            this.ctx = str;
            this.gAQ = i;
            this.gAR = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public h doInBackground(Object... objArr) {
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.mNetWork.x("kw", e.this.eYL);
            this.mNetWork.x("tid", this.ctx);
            if (this.mPicId != null) {
                this.mNetWork.x(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.x("source", String.valueOf(e.this.gAI ? 1 : 2));
            e.this.gAI = false;
            this.mNetWork.x(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.gAQ));
            this.mNetWork.x("prev", String.valueOf(this.gAR));
            this.mNetWork.x("not_see_lz", String.valueOf(e.this.gAH ? 0 : 1));
            this.mNetWork.x("is_top_agree", String.valueOf(e.this.gAP ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.mNetWork.x("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.x("obj_type", e.this.mFrom);
            } else {
                this.mNetWork.x("obj_type", ImageViewerConfig.FROM_OTHER);
            }
            if (TextUtils.isEmpty(e.this.gAM)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.gAM = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.x("applist", e.this.gAM);
            byo();
            this.mNetWork.acH().adF().bLP = false;
            String acj = this.mNetWork.acj();
            if (!this.mNetWork.acH().adG().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.ai(acj, true);
            return hVar;
        }

        private void byo() {
            this.mNetWork.x("forum_id", e.this.mForumId);
            this.mNetWork.x("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.x("scr_w", String.valueOf(l.aO(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.x("scr_h", String.valueOf(l.aQ(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.x("q_type", String.valueOf(ar.adp().adr() ? 2 : 1));
            this.mNetWork.x("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.x("page_name", "PB");
            this.mNetWork.x("pic_index", String.valueOf(e.this.gAA.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            e.this.gAF = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.cdb != null) {
                e.this.gAF = null;
                if (hVar == null) {
                    if (e.this.gAJ != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.acL();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.gAJ.am(i, str);
                        return;
                    }
                    return;
                }
                boolean T = v.T(hVar.byx());
                if (e.this.mIsReset && !T) {
                    e.this.gAA.clear();
                    e.this.cdb.clear();
                    e.this.gAB.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.gAG = hVar.getImageNum();
                }
                e.this.gAK = hVar.byy();
                if (this.mPicId == null) {
                    e.this.gAA.clear();
                    e.this.gAB.clear();
                }
                LinkedList<f> byx = hVar.byx();
                int size = byx.size();
                if (size <= 0) {
                    e.this.gAE = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = byx.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.byp();
                        if (ap.equals(imageUrlData.id, e.this.gAO)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.gAN);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.byt();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.asU();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.ctx, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(fVar.byq(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.gAH;
                        imageUrlData.overAllIndex = fVar.byt();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.byr();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.bys();
                        imageUrlData.richTextArray = fVar.byv();
                        imageUrlData.isFirstPost = fVar.byw();
                        if (fVar.aaH() != null) {
                            imageUrlData.agreeData = fVar.aaH();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.byu();
                            if (fVar.byw()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.gAB.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.gAB.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.cdb.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.cdb.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (ap.equals(imageUrlData.id, e.this.gAO)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.gAN);
                                }
                            }
                        } else {
                            e.this.cdb.put(str2, imageUrlData);
                            if (e.this.gAL) {
                                e.this.gAA.add(i2, str2);
                            } else {
                                e.this.gAA.add(str2);
                            }
                            e.this.gAB.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.c(byx, 0);
                    if (fVar2 != null) {
                        e.this.gAC = fVar2.byp();
                    }
                    f fVar3 = (f) v.c(byx, size - 1);
                    if (fVar3 != null) {
                        e.this.gAD = fVar3.byp();
                        e.this.gAE = ((long) e.this.gAG) == fVar3.byt();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.cdb.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.cdb.values()) {
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
                    e.this.ctx = this.ctx;
                    z = true;
                }
                int a2 = e.this.gAL ? v.a(e.this.gAA, (String) e.this.gAB.get(this.mPicId)) - 1 : i3;
                if (e.this.gAJ != null) {
                    e.this.gAJ.a(e.this.gAA, a2, e.this.gAG, false, null, z, e.this.gAK, T);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.asO() != null && fVar.asO().length() > 0) {
            return fVar.asO();
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
        sb.append(ap.bx(fVar.getImageUrl()));
        return sb.toString();
    }
}
