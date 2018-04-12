package com.baidu.tieba.image;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
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
    private String aNu;
    private Map<String, ImageUrlData> axV;
    private String cXd;
    private ArrayList<String> epH;
    private String epJ;
    private boolean epK;
    private String epR;
    private String epS;
    private String epT;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> epI = new HashMap<>();
    private boolean mIsReserver = true;
    private a epL = null;
    private int epM = 0;
    private boolean epN = false;
    private b epO = null;
    private AdvertAppInfo epP = null;
    private boolean epQ = false;

    /* loaded from: classes3.dex */
    public interface b {
        void Y(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.epH = null;
        this.aNu = null;
        this.mForumId = null;
        this.cXd = null;
        this.epJ = null;
        this.epK = false;
        this.mUserId = null;
        this.epH = arrayList;
        this.axV = map;
        if (this.epH == null) {
            this.epH = new ArrayList<>();
        }
        Iterator<String> it = this.epH.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.epI.put(d.oj(next), next);
        }
        this.aNu = str3;
        this.cXd = str2;
        this.mForumId = str;
        this.epJ = str4;
        this.mThreadType = i;
        this.epK = this.epJ == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
    }

    public void setSourceImageRectInScreen(String str) {
        this.epS = str;
    }

    public void om(String str) {
        this.epT = str;
    }

    public void hP(boolean z) {
        this.mIsReserver = z;
    }

    public void aJj() {
        this.epQ = false;
        if (!this.epK) {
            d(this.aNu, this.epJ, 10, 0);
        }
    }

    public void aJk() {
        this.epQ = true;
        d(this.aNu, d.oj(this.epH.get(0)), 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.epL != null) {
            if (str2 == null || !str2.equals(this.epL.getPicId())) {
                this.epL.cancel();
            } else {
                return;
            }
        }
        this.epL = new a(str, str2, i, i2);
        this.epL.setPriority(3);
        this.epL.execute(new Object[0]);
    }

    public void hQ(boolean z) {
        this.epN = z;
    }

    public void a(b bVar) {
        this.epO = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private String aNu;
        private int epU;
        private int epV;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.aNu = null;
            this.mPicId = null;
            this.epU = 0;
            this.epV = 0;
            this.mPicId = str2;
            this.aNu = str;
            this.epU = i;
            this.epV = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: z */
        public g doInBackground(Object... objArr) {
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.mNetWork.n("kw", e.this.cXd);
            this.mNetWork.n("tid", this.aNu);
            if (this.mPicId != null) {
                this.mNetWork.n(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.n("next", String.valueOf(this.epU));
            this.mNetWork.n("prev", String.valueOf(this.epV));
            this.mNetWork.n("not_see_lz", String.valueOf(e.this.epN ? 0 : 1));
            if (!e.this.mIsReserver) {
                this.mNetWork.n("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.n("obj_type", e.this.mFrom);
            }
            if (TextUtils.isEmpty(e.this.epR)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.epR = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.n("applist", e.this.epR);
            aJl();
            this.mNetWork.vj().wi().ajD = false;
            String uL = this.mNetWork.uL();
            if (!this.mNetWork.vj().wj().isRequestSuccess()) {
                return null;
            }
            g gVar = new g();
            gVar.G(uL, true);
            return gVar;
        }

        private void aJl() {
            this.mNetWork.n("forum_id", e.this.mForumId);
            this.mNetWork.n("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.n("scr_w", String.valueOf(l.af(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.n("scr_h", String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.n("q_type", String.valueOf(ap.vQ().vS() ? 2 : 1));
            this.mNetWork.n("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.n("page_name", "PB");
            this.mNetWork.n("pic_index", String.valueOf(e.this.epH.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.eW();
            }
            e.this.epL = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (e.this.axV != null) {
                e.this.epL = null;
                if (gVar == null) {
                    if (e.this.epO != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.vn();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.epO.Y(i, str);
                        return;
                    }
                    return;
                }
                boolean w = v.w(gVar.aJr());
                if (e.this.mIsReset && !w) {
                    e.this.epH.clear();
                    e.this.axV.clear();
                    e.this.epI.clear();
                }
                if (gVar.getImageNum() != 0) {
                    e.this.epM = gVar.getImageNum();
                }
                e.this.epP = gVar.aJs();
                if (this.mPicId == null) {
                    e.this.epH.clear();
                    e.this.epI.clear();
                }
                LinkedList<f> aJr = gVar.aJr();
                int size = aJr.size();
                if (size <= 0) {
                    e.this.epK = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = aJr.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.aJm();
                        if (an.equals(imageUrlData.id, e.this.epT)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.epS);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.aJq();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.Kf();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.aNu, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(fVar.aJn(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.epN;
                        imageUrlData.overAllIndex = fVar.aJq();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.aJo();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.aJp();
                        if (e.this.epI.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.epI.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.axV.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.axV.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                if (an.equals(imageUrlData.id, e.this.epT)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.epS);
                                }
                            }
                        } else {
                            e.this.axV.put(str2, imageUrlData);
                            if (e.this.epQ) {
                                e.this.epH.add(i2, str2);
                            } else {
                                e.this.epH.add(str2);
                            }
                            e.this.epI.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = aJr.get(size - 1);
                    e.this.epJ = fVar2.aJm();
                    e.this.epK = ((long) e.this.epM) == fVar2.aJq();
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.aNu = this.aNu;
                    z = true;
                }
                int a2 = e.this.epQ ? v.a(e.this.epH, (String) e.this.epI.get(this.mPicId)) - 1 : i3;
                if (e.this.epO != null) {
                    e.this.epO.a(e.this.epH, a2, e.this.epM, false, null, z, e.this.epP, w);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.Ka() != null && fVar.Ka().length() > 0) {
            return fVar.Ka();
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
        sb.append(an.aS(fVar.getImageUrl()));
        return sb.toString();
    }
}
