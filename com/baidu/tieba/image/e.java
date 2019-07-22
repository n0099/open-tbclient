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
    private String bWO;
    private Map<String, ImageUrlData> cmw;
    private boolean dfF;
    private String ftH;
    private ArrayList<String> gXP;
    private String gXR;
    private String gXS;
    private String gYa;
    private String gYb;
    private String gYc;
    private boolean gYd;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> gXQ = new HashMap<>();
    private boolean mIsReserver = true;
    private a gXT = null;
    private int gXU = 0;
    private boolean gXV = false;
    private boolean gXW = false;
    private b gXX = null;
    private AdvertAppInfo gXY = null;
    private boolean gXZ = false;

    /* loaded from: classes3.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void ar(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.dfF = false;
        this.gXP = arrayList;
        this.cmw = map;
        if (this.gXP == null) {
            this.gXP = new ArrayList<>();
        }
        Iterator<String> it = this.gXP.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.gXQ.put(d.zM(next), next);
        }
        this.bWO = str3;
        this.ftH = str2;
        this.mForumId = str;
        this.gXS = str4;
        this.mThreadType = i;
        this.dfF = this.gXS == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.gYd = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.gYb = str;
    }

    public void zO(String str) {
        this.gYc = str;
    }

    public void mS(boolean z) {
        this.gYd = z;
    }

    public void mT(boolean z) {
        this.mIsReserver = z;
    }

    public void bIC() {
        this.gXZ = false;
        if (!this.dfF) {
            e(this.bWO, this.gXS, 10, 0);
        }
    }

    public void bID() {
        this.gXZ = true;
        String str = this.gXP.get(0);
        if (StringUtils.isNull(this.gXR)) {
            this.gXR = d.zM(str);
        }
        e(this.bWO, this.gXR, 0, 10);
    }

    private void e(String str, String str2, int i, int i2) {
        if (this.gXT != null) {
            if (str2 == null || !str2.equals(this.gXT.getPicId())) {
                this.gXT.cancel();
            } else {
                return;
            }
        }
        this.gXT = new a(str, str2, i, i2);
        this.gXT.setPriority(3);
        this.gXT.execute(new Object[0]);
    }

    public void mU(boolean z) {
        this.gXV = z;
    }

    public void mV(boolean z) {
        this.gXW = z;
    }

    public void a(b bVar) {
        this.gXX = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String bWO;
        private int gYe;
        private int gYf;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.bWO = null;
            this.mPicId = null;
            this.gYe = 0;
            this.gYf = 0;
            this.mPicId = str2;
            this.bWO = str;
            this.gYe = i;
            this.gYf = i2;
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
            this.mNetWork.o("kw", e.this.ftH);
            this.mNetWork.o("tid", this.bWO);
            if (this.mPicId != null) {
                this.mNetWork.o(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.o("source", String.valueOf(e.this.gXW ? 1 : 2));
            e.this.gXW = false;
            this.mNetWork.o(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.gYe));
            this.mNetWork.o("prev", String.valueOf(this.gYf));
            this.mNetWork.o("not_see_lz", String.valueOf(e.this.gXV ? 0 : 1));
            this.mNetWork.o("is_top_agree", String.valueOf(e.this.gYd ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.mNetWork.o("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.o("obj_type", e.this.mFrom);
            } else {
                this.mNetWork.o("obj_type", ImageViewerConfig.FROM_OTHER);
            }
            if (TextUtils.isEmpty(e.this.gYa)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.ahO().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.gYa = com.baidu.tbadk.core.sharedPref.b.ahO().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.o("applist", e.this.gYa);
            bIE();
            this.mNetWork.aiE().ajE().bUG = false;
            String aig = this.mNetWork.aig();
            if (!this.mNetWork.aiE().ajF().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.ap(aig, true);
            return hVar;
        }

        private void bIE() {
            this.mNetWork.o("forum_id", e.this.mForumId);
            this.mNetWork.o("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.o("scr_w", String.valueOf(l.af(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("scr_h", String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("q_type", String.valueOf(as.ajo().ajq() ? 2 : 1));
            this.mNetWork.o("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.o("page_name", "PB");
            this.mNetWork.o("pic_index", String.valueOf(e.this.gXP.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.ik();
            }
            e.this.gXT = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.cmw != null) {
                e.this.gXT = null;
                if (hVar == null) {
                    if (e.this.gXX != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.aiI();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.gXX.ar(i, str);
                        return;
                    }
                    return;
                }
                boolean aa = v.aa(hVar.bIN());
                if (e.this.mIsReset && !aa) {
                    e.this.gXP.clear();
                    e.this.cmw.clear();
                    e.this.gXQ.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.gXU = hVar.getImageNum();
                }
                e.this.gXY = hVar.bIO();
                if (this.mPicId == null) {
                    e.this.gXP.clear();
                    e.this.gXQ.clear();
                }
                LinkedList<f> bIN = hVar.bIN();
                int size = bIN.size();
                if (size <= 0) {
                    e.this.dfF = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = bIN.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.bIF();
                        if (aq.bV(imageUrlData.id, e.this.gYc)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.gYb);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.bIJ();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.azj();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.bWO, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(fVar.bIG(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.gXV;
                        imageUrlData.overAllIndex = fVar.bIJ();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.bIH();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.bII();
                        if (fVar.bIL() != null) {
                            imageUrlData.richTextArray = fVar.bIL().toString();
                        }
                        imageUrlData.isFirstPost = fVar.bIM();
                        if (fVar.agn() != null) {
                            imageUrlData.agreeData = fVar.agn();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.bIK();
                            if (fVar.bIM()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.gXQ.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.gXQ.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.cmw.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.cmw.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (aq.bV(imageUrlData.id, e.this.gYc)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.gYb);
                                }
                            }
                        } else {
                            e.this.cmw.put(str2, imageUrlData);
                            if (e.this.gXZ) {
                                e.this.gXP.add(i2, str2);
                            } else {
                                e.this.gXP.add(str2);
                            }
                            e.this.gXQ.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.c(bIN, 0);
                    if (fVar2 != null) {
                        e.this.gXR = fVar2.bIF();
                    }
                    f fVar3 = (f) v.c(bIN, size - 1);
                    if (fVar3 != null) {
                        e.this.gXS = fVar3.bIF();
                        e.this.dfF = ((long) e.this.gXU) == fVar3.bIJ();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.cmw.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.cmw.values()) {
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
                    e.this.bWO = this.bWO;
                    z = true;
                }
                int a2 = e.this.gXZ ? v.a(e.this.gXP, (String) e.this.gXQ.get(this.mPicId)) - 1 : i3;
                if (e.this.gXX != null) {
                    e.this.gXX.a(e.this.gXP, a2, e.this.gXU, false, null, z, e.this.gXY, aa);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.azd() != null && fVar.azd().length() > 0) {
            return fVar.azd();
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
