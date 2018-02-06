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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
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
    private String bDf;
    private Map<String, ImageUrlData> bmt;
    private String dEq;
    private ArrayList<String> eUZ;
    private String eVb;
    private boolean eVc;
    private String eVj;
    private String eVk;
    private String eVl;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> eVa = new HashMap<>();
    private boolean mIsReserver = true;
    private a eVd = null;
    private int eVe = 0;
    private boolean eVf = false;
    private b eVg = null;
    private AdvertAppInfo eVh = null;
    private boolean eVi = false;

    /* loaded from: classes3.dex */
    public interface b {
        void P(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eUZ = null;
        this.bDf = null;
        this.mForumId = null;
        this.dEq = null;
        this.eVb = null;
        this.eVc = false;
        this.mUserId = null;
        this.eUZ = arrayList;
        this.bmt = map;
        if (this.eUZ == null) {
            this.eUZ = new ArrayList<>();
        }
        Iterator<String> it = this.eUZ.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.eVa.put(d.oe(next), next);
        }
        this.bDf = str3;
        this.dEq = str2;
        this.mForumId = str;
        this.eVb = str4;
        this.mThreadType = i;
        this.eVc = this.eVb == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
    }

    public void setSourceImageRectInScreen(String str) {
        this.eVk = str;
    }

    public void oi(String str) {
        this.eVl = str;
    }

    public void im(boolean z) {
        this.mIsReserver = z;
    }

    public void aOh() {
        this.eVi = false;
        if (!this.eVc) {
            d(this.bDf, this.eVb, 10, 0);
        }
    }

    public void aOi() {
        this.eVi = true;
        d(this.bDf, d.oe(this.eUZ.get(0)), 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.eVd != null) {
            if (str2 == null || !str2.equals(this.eVd.getPicId())) {
                this.eVd.cancel();
            } else {
                return;
            }
        }
        this.eVd = new a(str, str2, i, i2);
        this.eVd.setPriority(3);
        this.eVd.execute(new Object[0]);
    }

    public void in(boolean z) {
        this.eVf = z;
    }

    public void a(b bVar) {
        this.eVg = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private String bDf;
        private int eVm;
        private int eVn;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.bDf = null;
            this.mPicId = null;
            this.eVm = 0;
            this.eVn = 0;
            this.mPicId = str2;
            this.bDf = str;
            this.eVm = i;
            this.eVn = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public g doInBackground(Object... objArr) {
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.mNetWork.n("kw", e.this.dEq);
            this.mNetWork.n("tid", this.bDf);
            if (this.mPicId != null) {
                this.mNetWork.n(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.n("next", String.valueOf(this.eVm));
            this.mNetWork.n("prev", String.valueOf(this.eVn));
            this.mNetWork.n("not_see_lz", String.valueOf(e.this.eVf ? 0 : 1));
            if (!e.this.mIsReserver) {
                this.mNetWork.n("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.n("obj_type", e.this.mFrom);
            }
            if (TextUtils.isEmpty(e.this.eVj)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.eVj = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.n("applist", e.this.eVj);
            aOj();
            this.mNetWork.Cz().Dw().aYk = false;
            String Cb = this.mNetWork.Cb();
            if (!this.mNetWork.Cz().Dx().isRequestSuccess()) {
                return null;
            }
            g gVar = new g();
            gVar.L(Cb, true);
            return gVar;
        }

        private void aOj() {
            this.mNetWork.n("forum_id", e.this.mForumId);
            this.mNetWork.n("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.n("scr_w", String.valueOf(l.ao(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.n("scr_h", String.valueOf(l.aq(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.n("q_type", String.valueOf(ao.De().Dg() ? 2 : 1));
            this.mNetWork.n("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.n("page_name", "PB");
            this.mNetWork.n("pic_index", String.valueOf(e.this.eUZ.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.mS();
            }
            e.this.eVd = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (e.this.bmt != null) {
                e.this.eVd = null;
                if (gVar == null) {
                    if (e.this.eVg != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.CD();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.eVg.P(i, str);
                        return;
                    }
                    return;
                }
                boolean E = v.E(gVar.aOp());
                if (e.this.mIsReset && !E) {
                    e.this.eUZ.clear();
                    e.this.bmt.clear();
                    e.this.eVa.clear();
                }
                if (gVar.getImageNum() != 0) {
                    e.this.eVe = gVar.getImageNum();
                }
                e.this.eVh = gVar.aOq();
                if (this.mPicId == null) {
                    e.this.eUZ.clear();
                    e.this.eVa.clear();
                }
                LinkedList<f> aOp = gVar.aOp();
                int size = aOp.size();
                if (size <= 0) {
                    e.this.eVc = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = aOp.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.aOk();
                        if (am.equals(imageUrlData.id, e.this.eVl)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.eVk);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.aOo();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.RF();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.bDf, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(fVar.aOl(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.eVf;
                        imageUrlData.overAllIndex = fVar.aOo();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.aOm();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.aOn();
                        if (e.this.eVa.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.eVa.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.bmt.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.bmt.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                if (am.equals(imageUrlData.id, e.this.eVl)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.eVk);
                                }
                            }
                        } else {
                            e.this.bmt.put(str2, imageUrlData);
                            if (e.this.eVi) {
                                e.this.eUZ.add(i2, str2);
                            } else {
                                e.this.eUZ.add(str2);
                            }
                            e.this.eVa.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = aOp.get(size - 1);
                    e.this.eVb = fVar2.aOk();
                    e.this.eVc = ((long) e.this.eVe) == fVar2.aOo();
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.bDf = this.bDf;
                    z = true;
                }
                int a2 = e.this.eVi ? v.a(e.this.eUZ, (String) e.this.eVa.get(this.mPicId)) - 1 : i3;
                if (e.this.eVg != null) {
                    e.this.eVg.a(e.this.eUZ, a2, e.this.eVe, false, null, z, e.this.eVh, E);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.Rz() != null && fVar.Rz().length() > 0) {
            return fVar.Rz();
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
        sb.append(am.aV(fVar.getImageUrl()));
        return sb.toString();
    }
}
