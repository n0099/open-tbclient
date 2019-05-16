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
    private String bVL;
    private Map<String, ImageUrlData> cli;
    private boolean ddZ;
    private String foH;
    private ArrayList<String> gRA;
    private String gRC;
    private String gRD;
    private String gRL;
    private String gRM;
    private String gRN;
    private boolean gRO;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> gRB = new HashMap<>();
    private boolean mIsReserver = true;
    private a gRE = null;
    private int gRF = 0;
    private boolean gRG = false;
    private boolean gRH = false;
    private b gRI = null;
    private AdvertAppInfo gRJ = null;
    private boolean gRK = false;

    /* loaded from: classes3.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void ar(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.ddZ = false;
        this.gRA = arrayList;
        this.cli = map;
        if (this.gRA == null) {
            this.gRA = new ArrayList<>();
        }
        Iterator<String> it = this.gRA.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.gRB.put(d.yZ(next), next);
        }
        this.bVL = str3;
        this.foH = str2;
        this.mForumId = str;
        this.gRD = str4;
        this.mThreadType = i;
        this.ddZ = this.gRD == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.gRO = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.gRM = str;
    }

    public void zb(String str) {
        this.gRN = str;
    }

    public void mD(boolean z) {
        this.gRO = z;
    }

    public void mE(boolean z) {
        this.mIsReserver = z;
    }

    public void bFR() {
        this.gRK = false;
        if (!this.ddZ) {
            e(this.bVL, this.gRD, 10, 0);
        }
    }

    public void bFS() {
        this.gRK = true;
        String str = this.gRA.get(0);
        if (StringUtils.isNull(this.gRC)) {
            this.gRC = d.yZ(str);
        }
        e(this.bVL, this.gRC, 0, 10);
    }

    private void e(String str, String str2, int i, int i2) {
        if (this.gRE != null) {
            if (str2 == null || !str2.equals(this.gRE.getPicId())) {
                this.gRE.cancel();
            } else {
                return;
            }
        }
        this.gRE = new a(str, str2, i, i2);
        this.gRE.setPriority(3);
        this.gRE.execute(new Object[0]);
    }

    public void mF(boolean z) {
        this.gRG = z;
    }

    public void mG(boolean z) {
        this.gRH = z;
    }

    public void a(b bVar) {
        this.gRI = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String bVL;
        private int gRP;
        private int gRQ;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.bVL = null;
            this.mPicId = null;
            this.gRP = 0;
            this.gRQ = 0;
            this.mPicId = str2;
            this.bVL = str;
            this.gRP = i;
            this.gRQ = i2;
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
            this.mNetWork.o("kw", e.this.foH);
            this.mNetWork.o("tid", this.bVL);
            if (this.mPicId != null) {
                this.mNetWork.o(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.o("source", String.valueOf(e.this.gRH ? 1 : 2));
            e.this.gRH = false;
            this.mNetWork.o(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.gRP));
            this.mNetWork.o("prev", String.valueOf(this.gRQ));
            this.mNetWork.o("not_see_lz", String.valueOf(e.this.gRG ? 0 : 1));
            this.mNetWork.o("is_top_agree", String.valueOf(e.this.gRO ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.mNetWork.o("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.o("obj_type", e.this.mFrom);
            } else {
                this.mNetWork.o("obj_type", ImageViewerConfig.FROM_OTHER);
            }
            if (TextUtils.isEmpty(e.this.gRL)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.agM().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.gRL = com.baidu.tbadk.core.sharedPref.b.agM().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.o("applist", e.this.gRL);
            bFT();
            this.mNetWork.ahC().aiB().bTE = false;
            String ahe = this.mNetWork.ahe();
            if (!this.mNetWork.ahC().aiC().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.al(ahe, true);
            return hVar;
        }

        private void bFT() {
            this.mNetWork.o("forum_id", e.this.mForumId);
            this.mNetWork.o("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.o("scr_w", String.valueOf(l.af(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("scr_h", String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("q_type", String.valueOf(ar.ail().ain() ? 2 : 1));
            this.mNetWork.o("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.o("page_name", "PB");
            this.mNetWork.o("pic_index", String.valueOf(e.this.gRA.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.ia();
            }
            e.this.gRE = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.cli != null) {
                e.this.gRE = null;
                if (hVar == null) {
                    if (e.this.gRI != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.ahG();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.gRI.ar(i, str);
                        return;
                    }
                    return;
                }
                boolean aa = v.aa(hVar.bGc());
                if (e.this.mIsReset && !aa) {
                    e.this.gRA.clear();
                    e.this.cli.clear();
                    e.this.gRB.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.gRF = hVar.getImageNum();
                }
                e.this.gRJ = hVar.bGd();
                if (this.mPicId == null) {
                    e.this.gRA.clear();
                    e.this.gRB.clear();
                }
                LinkedList<f> bGc = hVar.bGc();
                int size = bGc.size();
                if (size <= 0) {
                    e.this.ddZ = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = bGc.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.bFU();
                        if (ap.equals(imageUrlData.id, e.this.gRN)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.gRM);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.bFY();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.axW();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.bVL, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(fVar.bFV(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.gRG;
                        imageUrlData.overAllIndex = fVar.bFY();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.bFW();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.bFX();
                        if (fVar.bGa() != null) {
                            imageUrlData.richTextArray = fVar.bGa().toString();
                        }
                        imageUrlData.isFirstPost = fVar.bGb();
                        if (fVar.afl() != null) {
                            imageUrlData.agreeData = fVar.afl();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.bFZ();
                            if (fVar.bGb()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.gRB.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.gRB.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.cli.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.cli.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (ap.equals(imageUrlData.id, e.this.gRN)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.gRM);
                                }
                            }
                        } else {
                            e.this.cli.put(str2, imageUrlData);
                            if (e.this.gRK) {
                                e.this.gRA.add(i2, str2);
                            } else {
                                e.this.gRA.add(str2);
                            }
                            e.this.gRB.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.c(bGc, 0);
                    if (fVar2 != null) {
                        e.this.gRC = fVar2.bFU();
                    }
                    f fVar3 = (f) v.c(bGc, size - 1);
                    if (fVar3 != null) {
                        e.this.gRD = fVar3.bFU();
                        e.this.ddZ = ((long) e.this.gRF) == fVar3.bFY();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.cli.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.cli.values()) {
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
                    e.this.bVL = this.bVL;
                    z = true;
                }
                int a2 = e.this.gRK ? v.a(e.this.gRA, (String) e.this.gRB.get(this.mPicId)) - 1 : i3;
                if (e.this.gRI != null) {
                    e.this.gRI.a(e.this.gRA, a2, e.this.gRF, false, null, z, e.this.gRJ, aa);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.axQ() != null && fVar.axQ().length() > 0) {
            return fVar.axQ();
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
        sb.append(ap.bh(fVar.getImageUrl()));
        return sb.toString();
    }
}
