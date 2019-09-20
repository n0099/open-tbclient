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
    private String bXN;
    private Map<String, ImageUrlData> cnz;
    private boolean dhx;
    private String fvT;
    private ArrayList<String> haB;
    private String haD;
    private String haE;
    private String haM;
    private String haN;
    private String haO;
    private boolean haP;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> haC = new HashMap<>();
    private boolean mIsReserver = true;
    private a haF = null;
    private int haG = 0;
    private boolean haH = false;
    private boolean haI = false;
    private b haJ = null;
    private AdvertAppInfo haK = null;
    private boolean haL = false;

    /* loaded from: classes3.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void ar(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.dhx = false;
        this.haB = arrayList;
        this.cnz = map;
        if (this.haB == null) {
            this.haB = new ArrayList<>();
        }
        Iterator<String> it = this.haB.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.haC.put(d.Am(next), next);
        }
        this.bXN = str3;
        this.fvT = str2;
        this.mForumId = str;
        this.haE = str4;
        this.mThreadType = i;
        this.dhx = this.haE == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.haP = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.haN = str;
    }

    public void Ao(String str) {
        this.haO = str;
    }

    public void mV(boolean z) {
        this.haP = z;
    }

    public void mW(boolean z) {
        this.mIsReserver = z;
    }

    public void bJD() {
        this.haL = false;
        if (!this.dhx) {
            e(this.bXN, this.haE, 10, 0);
        }
    }

    public void bJE() {
        this.haL = true;
        String str = this.haB.get(0);
        if (StringUtils.isNull(this.haD)) {
            this.haD = d.Am(str);
        }
        e(this.bXN, this.haD, 0, 10);
    }

    private void e(String str, String str2, int i, int i2) {
        if (this.haF != null) {
            if (str2 == null || !str2.equals(this.haF.getPicId())) {
                this.haF.cancel();
            } else {
                return;
            }
        }
        this.haF = new a(str, str2, i, i2);
        this.haF.setPriority(3);
        this.haF.execute(new Object[0]);
    }

    public void mX(boolean z) {
        this.haH = z;
    }

    public void mY(boolean z) {
        this.haI = z;
    }

    public void a(b bVar) {
        this.haJ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String bXN;
        private int haQ;
        private int haR;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.bXN = null;
            this.mPicId = null;
            this.haQ = 0;
            this.haR = 0;
            this.mPicId = str2;
            this.bXN = str;
            this.haQ = i;
            this.haR = i2;
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
            this.mNetWork.o("kw", e.this.fvT);
            this.mNetWork.o("tid", this.bXN);
            if (this.mPicId != null) {
                this.mNetWork.o(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.o("source", String.valueOf(e.this.haI ? 1 : 2));
            e.this.haI = false;
            this.mNetWork.o(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.haQ));
            this.mNetWork.o("prev", String.valueOf(this.haR));
            this.mNetWork.o("not_see_lz", String.valueOf(e.this.haH ? 0 : 1));
            this.mNetWork.o("is_top_agree", String.valueOf(e.this.haP ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.mNetWork.o("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.o("obj_type", e.this.mFrom);
            } else {
                this.mNetWork.o("obj_type", ImageViewerConfig.FROM_OTHER);
            }
            if (TextUtils.isEmpty(e.this.haM)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.ahU().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.haM = com.baidu.tbadk.core.sharedPref.b.ahU().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.o("applist", e.this.haM);
            bJF();
            this.mNetWork.aiK().ajM().bVp = false;
            String aim = this.mNetWork.aim();
            if (!this.mNetWork.aiK().ajN().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.ap(aim, true);
            return hVar;
        }

        private void bJF() {
            this.mNetWork.o("forum_id", e.this.mForumId);
            this.mNetWork.o("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.o("scr_w", String.valueOf(l.af(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("scr_h", String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("q_type", String.valueOf(ar.ajw().ajy() ? 2 : 1));
            this.mNetWork.o("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.o("page_name", "PB");
            this.mNetWork.o("pic_index", String.valueOf(e.this.haB.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.ik();
            }
            e.this.haF = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.cnz != null) {
                e.this.haF = null;
                if (hVar == null) {
                    if (e.this.haJ != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.aiO();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.haJ.ar(i, str);
                        return;
                    }
                    return;
                }
                boolean aa = v.aa(hVar.bJO());
                if (e.this.mIsReset && !aa) {
                    e.this.haB.clear();
                    e.this.cnz.clear();
                    e.this.haC.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.haG = hVar.getImageNum();
                }
                e.this.haK = hVar.bJP();
                if (this.mPicId == null) {
                    e.this.haB.clear();
                    e.this.haC.clear();
                }
                LinkedList<f> bJO = hVar.bJO();
                int size = bJO.size();
                if (size <= 0) {
                    e.this.dhx = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = bJO.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.bJG();
                        if (aq.bV(imageUrlData.id, e.this.haO)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.haN);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.bJK();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.azx();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.e(this.bXN, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.e(fVar.bJH(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.haH;
                        imageUrlData.overAllIndex = fVar.bJK();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.bJI();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.bJJ();
                        if (fVar.bJM() != null) {
                            imageUrlData.richTextArray = fVar.bJM().toString();
                        }
                        imageUrlData.isFirstPost = fVar.bJN();
                        if (fVar.ags() != null) {
                            imageUrlData.agreeData = fVar.ags();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.bJL();
                            if (fVar.bJN()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.haC.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.haC.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.cnz.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.cnz.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (aq.bV(imageUrlData.id, e.this.haO)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.haN);
                                }
                            }
                        } else {
                            e.this.cnz.put(str2, imageUrlData);
                            if (e.this.haL) {
                                e.this.haB.add(i2, str2);
                            } else {
                                e.this.haB.add(str2);
                            }
                            e.this.haC.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.c(bJO, 0);
                    if (fVar2 != null) {
                        e.this.haD = fVar2.bJG();
                    }
                    f fVar3 = (f) v.c(bJO, size - 1);
                    if (fVar3 != null) {
                        e.this.haE = fVar3.bJG();
                        e.this.dhx = ((long) e.this.haG) == fVar3.bJK();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.cnz.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.cnz.values()) {
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
                    e.this.bXN = this.bXN;
                    z = true;
                }
                int a2 = e.this.haL ? v.a(e.this.haB, (String) e.this.haC.get(this.mPicId)) - 1 : i3;
                if (e.this.haJ != null) {
                    e.this.haJ.a(e.this.haB, a2, e.this.haG, false, null, z, e.this.haK, aa);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.azr() != null && fVar.azr().length() > 0) {
            return fVar.azr();
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
