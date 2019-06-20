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
    private String bVM;
    private Map<String, ImageUrlData> clj;
    private boolean deb;
    private String foI;
    private ArrayList<String> gRF;
    private String gRH;
    private String gRI;
    private String gRQ;
    private String gRR;
    private String gRS;
    private boolean gRT;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> gRG = new HashMap<>();
    private boolean mIsReserver = true;
    private a gRJ = null;
    private int gRK = 0;
    private boolean gRL = false;
    private boolean gRM = false;
    private b gRN = null;
    private AdvertAppInfo gRO = null;
    private boolean gRP = false;

    /* loaded from: classes3.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void ar(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.deb = false;
        this.gRF = arrayList;
        this.clj = map;
        if (this.gRF == null) {
            this.gRF = new ArrayList<>();
        }
        Iterator<String> it = this.gRF.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.gRG.put(d.zb(next), next);
        }
        this.bVM = str3;
        this.foI = str2;
        this.mForumId = str;
        this.gRI = str4;
        this.mThreadType = i;
        this.deb = this.gRI == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.gRT = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.gRR = str;
    }

    public void zd(String str) {
        this.gRS = str;
    }

    public void mE(boolean z) {
        this.gRT = z;
    }

    public void mF(boolean z) {
        this.mIsReserver = z;
    }

    public void bFV() {
        this.gRP = false;
        if (!this.deb) {
            e(this.bVM, this.gRI, 10, 0);
        }
    }

    public void bFW() {
        this.gRP = true;
        String str = this.gRF.get(0);
        if (StringUtils.isNull(this.gRH)) {
            this.gRH = d.zb(str);
        }
        e(this.bVM, this.gRH, 0, 10);
    }

    private void e(String str, String str2, int i, int i2) {
        if (this.gRJ != null) {
            if (str2 == null || !str2.equals(this.gRJ.getPicId())) {
                this.gRJ.cancel();
            } else {
                return;
            }
        }
        this.gRJ = new a(str, str2, i, i2);
        this.gRJ.setPriority(3);
        this.gRJ.execute(new Object[0]);
    }

    public void mG(boolean z) {
        this.gRL = z;
    }

    public void mH(boolean z) {
        this.gRM = z;
    }

    public void a(b bVar) {
        this.gRN = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String bVM;
        private int gRU;
        private int gRV;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.bVM = null;
            this.mPicId = null;
            this.gRU = 0;
            this.gRV = 0;
            this.mPicId = str2;
            this.bVM = str;
            this.gRU = i;
            this.gRV = i2;
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
            this.mNetWork.o("tid", this.bVM);
            if (this.mPicId != null) {
                this.mNetWork.o(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.o("source", String.valueOf(e.this.gRM ? 1 : 2));
            e.this.gRM = false;
            this.mNetWork.o(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.gRU));
            this.mNetWork.o("prev", String.valueOf(this.gRV));
            this.mNetWork.o("not_see_lz", String.valueOf(e.this.gRL ? 0 : 1));
            this.mNetWork.o("is_top_agree", String.valueOf(e.this.gRT ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.mNetWork.o("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.o("obj_type", e.this.mFrom);
            } else {
                this.mNetWork.o("obj_type", ImageViewerConfig.FROM_OTHER);
            }
            if (TextUtils.isEmpty(e.this.gRQ)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.agM().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.gRQ = com.baidu.tbadk.core.sharedPref.b.agM().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.o("applist", e.this.gRQ);
            bFX();
            this.mNetWork.ahC().aiB().bTF = false;
            String ahe = this.mNetWork.ahe();
            if (!this.mNetWork.ahC().aiC().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.al(ahe, true);
            return hVar;
        }

        private void bFX() {
            this.mNetWork.o("forum_id", e.this.mForumId);
            this.mNetWork.o("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.o("scr_w", String.valueOf(l.af(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("scr_h", String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("q_type", String.valueOf(ar.ail().ain() ? 2 : 1));
            this.mNetWork.o("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.o("page_name", "PB");
            this.mNetWork.o("pic_index", String.valueOf(e.this.gRF.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.ia();
            }
            e.this.gRJ = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.clj != null) {
                e.this.gRJ = null;
                if (hVar == null) {
                    if (e.this.gRN != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.ahG();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.gRN.ar(i, str);
                        return;
                    }
                    return;
                }
                boolean aa = v.aa(hVar.bGg());
                if (e.this.mIsReset && !aa) {
                    e.this.gRF.clear();
                    e.this.clj.clear();
                    e.this.gRG.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.gRK = hVar.getImageNum();
                }
                e.this.gRO = hVar.bGh();
                if (this.mPicId == null) {
                    e.this.gRF.clear();
                    e.this.gRG.clear();
                }
                LinkedList<f> bGg = hVar.bGg();
                int size = bGg.size();
                if (size <= 0) {
                    e.this.deb = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = bGg.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.bFY();
                        if (ap.equals(imageUrlData.id, e.this.gRS)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.gRR);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.bGc();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.axX();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.bVM, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(fVar.bFZ(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.gRL;
                        imageUrlData.overAllIndex = fVar.bGc();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.bGa();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.bGb();
                        if (fVar.bGe() != null) {
                            imageUrlData.richTextArray = fVar.bGe().toString();
                        }
                        imageUrlData.isFirstPost = fVar.bGf();
                        if (fVar.afl() != null) {
                            imageUrlData.agreeData = fVar.afl();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.bGd();
                            if (fVar.bGf()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.gRG.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.gRG.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.clj.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.clj.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (ap.equals(imageUrlData.id, e.this.gRS)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.gRR);
                                }
                            }
                        } else {
                            e.this.clj.put(str2, imageUrlData);
                            if (e.this.gRP) {
                                e.this.gRF.add(i2, str2);
                            } else {
                                e.this.gRF.add(str2);
                            }
                            e.this.gRG.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.c(bGg, 0);
                    if (fVar2 != null) {
                        e.this.gRH = fVar2.bFY();
                    }
                    f fVar3 = (f) v.c(bGg, size - 1);
                    if (fVar3 != null) {
                        e.this.gRI = fVar3.bFY();
                        e.this.deb = ((long) e.this.gRK) == fVar3.bGc();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.clj.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.clj.values()) {
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
                    e.this.bVM = this.bVM;
                    z = true;
                }
                int a2 = e.this.gRP ? v.a(e.this.gRF, (String) e.this.gRG.get(this.mPicId)) - 1 : i3;
                if (e.this.gRN != null) {
                    e.this.gRN.a(e.this.gRF, a2, e.this.gRK, false, null, z, e.this.gRO, aa);
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
