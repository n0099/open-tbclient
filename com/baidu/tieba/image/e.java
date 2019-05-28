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
    private boolean dea;
    private String foI;
    private ArrayList<String> gRD;
    private String gRF;
    private String gRG;
    private String gRO;
    private String gRP;
    private String gRQ;
    private boolean gRR;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> gRE = new HashMap<>();
    private boolean mIsReserver = true;
    private a gRH = null;
    private int gRI = 0;
    private boolean gRJ = false;
    private boolean gRK = false;
    private b gRL = null;
    private AdvertAppInfo gRM = null;
    private boolean gRN = false;

    /* loaded from: classes3.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void ar(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.dea = false;
        this.gRD = arrayList;
        this.cli = map;
        if (this.gRD == null) {
            this.gRD = new ArrayList<>();
        }
        Iterator<String> it = this.gRD.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.gRE.put(d.yZ(next), next);
        }
        this.bVL = str3;
        this.foI = str2;
        this.mForumId = str;
        this.gRG = str4;
        this.mThreadType = i;
        this.dea = this.gRG == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.gRR = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.gRP = str;
    }

    public void zb(String str) {
        this.gRQ = str;
    }

    public void mD(boolean z) {
        this.gRR = z;
    }

    public void mE(boolean z) {
        this.mIsReserver = z;
    }

    public void bFU() {
        this.gRN = false;
        if (!this.dea) {
            e(this.bVL, this.gRG, 10, 0);
        }
    }

    public void bFV() {
        this.gRN = true;
        String str = this.gRD.get(0);
        if (StringUtils.isNull(this.gRF)) {
            this.gRF = d.yZ(str);
        }
        e(this.bVL, this.gRF, 0, 10);
    }

    private void e(String str, String str2, int i, int i2) {
        if (this.gRH != null) {
            if (str2 == null || !str2.equals(this.gRH.getPicId())) {
                this.gRH.cancel();
            } else {
                return;
            }
        }
        this.gRH = new a(str, str2, i, i2);
        this.gRH.setPriority(3);
        this.gRH.execute(new Object[0]);
    }

    public void mF(boolean z) {
        this.gRJ = z;
    }

    public void mG(boolean z) {
        this.gRK = z;
    }

    public void a(b bVar) {
        this.gRL = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String bVL;
        private int gRS;
        private int gRT;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.bVL = null;
            this.mPicId = null;
            this.gRS = 0;
            this.gRT = 0;
            this.mPicId = str2;
            this.bVL = str;
            this.gRS = i;
            this.gRT = i2;
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
            this.mNetWork.o("kw", e.this.foI);
            this.mNetWork.o("tid", this.bVL);
            if (this.mPicId != null) {
                this.mNetWork.o(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.o("source", String.valueOf(e.this.gRK ? 1 : 2));
            e.this.gRK = false;
            this.mNetWork.o(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.gRS));
            this.mNetWork.o("prev", String.valueOf(this.gRT));
            this.mNetWork.o("not_see_lz", String.valueOf(e.this.gRJ ? 0 : 1));
            this.mNetWork.o("is_top_agree", String.valueOf(e.this.gRR ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.mNetWork.o("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.o("obj_type", e.this.mFrom);
            } else {
                this.mNetWork.o("obj_type", ImageViewerConfig.FROM_OTHER);
            }
            if (TextUtils.isEmpty(e.this.gRO)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.agM().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.gRO = com.baidu.tbadk.core.sharedPref.b.agM().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.o("applist", e.this.gRO);
            bFW();
            this.mNetWork.ahC().aiB().bTE = false;
            String ahe = this.mNetWork.ahe();
            if (!this.mNetWork.ahC().aiC().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.al(ahe, true);
            return hVar;
        }

        private void bFW() {
            this.mNetWork.o("forum_id", e.this.mForumId);
            this.mNetWork.o("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.o("scr_w", String.valueOf(l.af(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("scr_h", String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("q_type", String.valueOf(ar.ail().ain() ? 2 : 1));
            this.mNetWork.o("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.o("page_name", "PB");
            this.mNetWork.o("pic_index", String.valueOf(e.this.gRD.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.ia();
            }
            e.this.gRH = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.cli != null) {
                e.this.gRH = null;
                if (hVar == null) {
                    if (e.this.gRL != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.ahG();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.gRL.ar(i, str);
                        return;
                    }
                    return;
                }
                boolean aa = v.aa(hVar.bGf());
                if (e.this.mIsReset && !aa) {
                    e.this.gRD.clear();
                    e.this.cli.clear();
                    e.this.gRE.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.gRI = hVar.getImageNum();
                }
                e.this.gRM = hVar.bGg();
                if (this.mPicId == null) {
                    e.this.gRD.clear();
                    e.this.gRE.clear();
                }
                LinkedList<f> bGf = hVar.bGf();
                int size = bGf.size();
                if (size <= 0) {
                    e.this.dea = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = bGf.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.bFX();
                        if (ap.equals(imageUrlData.id, e.this.gRQ)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.gRP);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.bGb();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.axX();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.bVL, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(fVar.bFY(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.gRJ;
                        imageUrlData.overAllIndex = fVar.bGb();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.bFZ();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.bGa();
                        if (fVar.bGd() != null) {
                            imageUrlData.richTextArray = fVar.bGd().toString();
                        }
                        imageUrlData.isFirstPost = fVar.bGe();
                        if (fVar.afl() != null) {
                            imageUrlData.agreeData = fVar.afl();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.bGc();
                            if (fVar.bGe()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.gRE.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.gRE.get(imageUrlData.id);
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
                                if (ap.equals(imageUrlData.id, e.this.gRQ)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.gRP);
                                }
                            }
                        } else {
                            e.this.cli.put(str2, imageUrlData);
                            if (e.this.gRN) {
                                e.this.gRD.add(i2, str2);
                            } else {
                                e.this.gRD.add(str2);
                            }
                            e.this.gRE.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.c(bGf, 0);
                    if (fVar2 != null) {
                        e.this.gRF = fVar2.bFX();
                    }
                    f fVar3 = (f) v.c(bGf, size - 1);
                    if (fVar3 != null) {
                        e.this.gRG = fVar3.bFX();
                        e.this.dea = ((long) e.this.gRI) == fVar3.bGb();
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
                int a2 = e.this.gRN ? v.a(e.this.gRD, (String) e.this.gRE.get(this.mPicId)) - 1 : i3;
                if (e.this.gRL != null) {
                    e.this.gRL.a(e.this.gRD, a2, e.this.gRI, false, null, z, e.this.gRM, aa);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.axR() != null && fVar.axR().length() > 0) {
            return fVar.axR();
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
