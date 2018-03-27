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
    private String bCV;
    private Map<String, ImageUrlData> bmj;
    private String dEh;
    private ArrayList<String> eVb;
    private String eVd;
    private boolean eVe;
    private String eVl;
    private String eVm;
    private String eVn;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> eVc = new HashMap<>();
    private boolean mIsReserver = true;
    private a eVf = null;
    private int eVg = 0;
    private boolean eVh = false;
    private b eVi = null;
    private AdvertAppInfo eVj = null;
    private boolean eVk = false;

    /* loaded from: classes3.dex */
    public interface b {
        void P(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eVb = null;
        this.bCV = null;
        this.mForumId = null;
        this.dEh = null;
        this.eVd = null;
        this.eVe = false;
        this.mUserId = null;
        this.eVb = arrayList;
        this.bmj = map;
        if (this.eVb == null) {
            this.eVb = new ArrayList<>();
        }
        Iterator<String> it = this.eVb.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.eVc.put(d.oe(next), next);
        }
        this.bCV = str3;
        this.dEh = str2;
        this.mForumId = str;
        this.eVd = str4;
        this.mThreadType = i;
        this.eVe = this.eVd == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
    }

    public void setSourceImageRectInScreen(String str) {
        this.eVm = str;
    }

    public void oi(String str) {
        this.eVn = str;
    }

    public void ir(boolean z) {
        this.mIsReserver = z;
    }

    public void aOh() {
        this.eVk = false;
        if (!this.eVe) {
            d(this.bCV, this.eVd, 10, 0);
        }
    }

    public void aOi() {
        this.eVk = true;
        d(this.bCV, d.oe(this.eVb.get(0)), 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.eVf != null) {
            if (str2 == null || !str2.equals(this.eVf.getPicId())) {
                this.eVf.cancel();
            } else {
                return;
            }
        }
        this.eVf = new a(str, str2, i, i2);
        this.eVf.setPriority(3);
        this.eVf.execute(new Object[0]);
    }

    public void is(boolean z) {
        this.eVh = z;
    }

    public void a(b bVar) {
        this.eVi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private String bCV;
        private int eVo;
        private int eVp;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.bCV = null;
            this.mPicId = null;
            this.eVo = 0;
            this.eVp = 0;
            this.mPicId = str2;
            this.bCV = str;
            this.eVo = i;
            this.eVp = i2;
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
            this.mNetWork.n("kw", e.this.dEh);
            this.mNetWork.n("tid", this.bCV);
            if (this.mPicId != null) {
                this.mNetWork.n(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.n("next", String.valueOf(this.eVo));
            this.mNetWork.n("prev", String.valueOf(this.eVp));
            this.mNetWork.n("not_see_lz", String.valueOf(e.this.eVh ? 0 : 1));
            if (!e.this.mIsReserver) {
                this.mNetWork.n("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.n("obj_type", e.this.mFrom);
            }
            if (TextUtils.isEmpty(e.this.eVl)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.eVl = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.n("applist", e.this.eVl);
            aOj();
            this.mNetWork.Cz().Dw().aYa = false;
            String Cb = this.mNetWork.Cb();
            if (!this.mNetWork.Cz().Dx().isRequestSuccess()) {
                return null;
            }
            g gVar = new g();
            gVar.K(Cb, true);
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
            this.mNetWork.n("pic_index", String.valueOf(e.this.eVb.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.mS();
            }
            e.this.eVf = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (e.this.bmj != null) {
                e.this.eVf = null;
                if (gVar == null) {
                    if (e.this.eVi != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.CD();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.eVi.P(i, str);
                        return;
                    }
                    return;
                }
                boolean E = v.E(gVar.aOp());
                if (e.this.mIsReset && !E) {
                    e.this.eVb.clear();
                    e.this.bmj.clear();
                    e.this.eVc.clear();
                }
                if (gVar.getImageNum() != 0) {
                    e.this.eVg = gVar.getImageNum();
                }
                e.this.eVj = gVar.aOq();
                if (this.mPicId == null) {
                    e.this.eVb.clear();
                    e.this.eVc.clear();
                }
                LinkedList<f> aOp = gVar.aOp();
                int size = aOp.size();
                if (size <= 0) {
                    e.this.eVe = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = aOp.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.aOk();
                        if (am.equals(imageUrlData.id, e.this.eVn)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.eVm);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.aOo();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.RF();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.bCV, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(fVar.aOl(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.eVh;
                        imageUrlData.overAllIndex = fVar.aOo();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.aOm();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.aOn();
                        if (e.this.eVc.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.eVc.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.bmj.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.bmj.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                if (am.equals(imageUrlData.id, e.this.eVn)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.eVm);
                                }
                            }
                        } else {
                            e.this.bmj.put(str2, imageUrlData);
                            if (e.this.eVk) {
                                e.this.eVb.add(i2, str2);
                            } else {
                                e.this.eVb.add(str2);
                            }
                            e.this.eVc.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = aOp.get(size - 1);
                    e.this.eVd = fVar2.aOk();
                    e.this.eVe = ((long) e.this.eVg) == fVar2.aOo();
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.bCV = this.bCV;
                    z = true;
                }
                int a2 = e.this.eVk ? v.a(e.this.eVb, (String) e.this.eVc.get(this.mPicId)) - 1 : i3;
                if (e.this.eVi != null) {
                    e.this.eVi.a(e.this.eVb, a2, e.this.eVg, false, null, z, e.this.eVj, E);
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
