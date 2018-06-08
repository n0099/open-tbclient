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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes3.dex */
public class e {
    private Map<String, ImageUrlData> aGr;
    private String aVt;
    private String dhv;
    private ArrayList<String> eCd;
    private String eCf;
    private boolean eCg;
    private String eCn;
    private String eCo;
    private String eCp;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> eCe = new HashMap<>();
    private boolean mIsReserver = true;
    private a eCh = null;
    private int eCi = 0;
    private boolean eCj = false;
    private b eCk = null;
    private AdvertAppInfo eCl = null;
    private boolean eCm = false;

    /* loaded from: classes3.dex */
    public interface b {
        void Y(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eCd = null;
        this.aVt = null;
        this.mForumId = null;
        this.dhv = null;
        this.eCf = null;
        this.eCg = false;
        this.mUserId = null;
        this.eCd = arrayList;
        this.aGr = map;
        if (this.eCd == null) {
            this.eCd = new ArrayList<>();
        }
        Iterator<String> it = this.eCd.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.eCe.put(d.oZ(next), next);
        }
        this.aVt = str3;
        this.dhv = str2;
        this.mForumId = str;
        this.eCf = str4;
        this.mThreadType = i;
        this.eCg = this.eCf == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
    }

    public void setSourceImageRectInScreen(String str) {
        this.eCo = str;
    }

    public void pc(String str) {
        this.eCp = str;
    }

    public void hW(boolean z) {
        this.mIsReserver = z;
    }

    public void aOd() {
        this.eCm = false;
        if (!this.eCg) {
            d(this.aVt, this.eCf, 10, 0);
        }
    }

    public void aOe() {
        this.eCm = true;
        d(this.aVt, d.oZ(this.eCd.get(0)), 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.eCh != null) {
            if (str2 == null || !str2.equals(this.eCh.getPicId())) {
                this.eCh.cancel();
            } else {
                return;
            }
        }
        this.eCh = new a(str, str2, i, i2);
        this.eCh.setPriority(3);
        this.eCh.execute(new Object[0]);
    }

    public void hX(boolean z) {
        this.eCj = z;
    }

    public void a(b bVar) {
        this.eCk = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private String aVt;
        private int eCq;
        private int eCr;
        private y mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.aVt = null;
            this.mPicId = null;
            this.eCq = 0;
            this.eCr = 0;
            this.mPicId = str2;
            this.aVt = str;
            this.eCq = i;
            this.eCr = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public g doInBackground(Object... objArr) {
            this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.mNetWork.o("kw", e.this.dhv);
            this.mNetWork.o("tid", this.aVt);
            if (this.mPicId != null) {
                this.mNetWork.o(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.o("next", String.valueOf(this.eCq));
            this.mNetWork.o("prev", String.valueOf(this.eCr));
            this.mNetWork.o("not_see_lz", String.valueOf(e.this.eCj ? 0 : 1));
            if (!e.this.mIsReserver) {
                this.mNetWork.o("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.o("obj_type", e.this.mFrom);
            }
            if (TextUtils.isEmpty(e.this.eCn)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.eCn = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.o("applist", e.this.eCn);
            aOf();
            this.mNetWork.yJ().zI().arL = false;
            String yl = this.mNetWork.yl();
            if (!this.mNetWork.yJ().zJ().isRequestSuccess()) {
                return null;
            }
            g gVar = new g();
            gVar.G(yl, true);
            return gVar;
        }

        private void aOf() {
            this.mNetWork.o("forum_id", e.this.mForumId);
            this.mNetWork.o("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.o("scr_w", String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("scr_h", String.valueOf(l.aj(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.o("q_type", String.valueOf(aq.zq().zs() ? 2 : 1));
            this.mNetWork.o("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.o("page_name", "PB");
            this.mNetWork.o("pic_index", String.valueOf(e.this.eCd.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            e.this.eCh = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (e.this.aGr != null) {
                e.this.eCh = null;
                if (gVar == null) {
                    if (e.this.eCk != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.yN();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.eCk.Y(i, str);
                        return;
                    }
                    return;
                }
                boolean z = w.z(gVar.aOl());
                if (e.this.mIsReset && !z) {
                    e.this.eCd.clear();
                    e.this.aGr.clear();
                    e.this.eCe.clear();
                }
                if (gVar.getImageNum() != 0) {
                    e.this.eCi = gVar.getImageNum();
                }
                e.this.eCl = gVar.aOm();
                if (this.mPicId == null) {
                    e.this.eCd.clear();
                    e.this.eCe.clear();
                }
                LinkedList<f> aOl = gVar.aOl();
                int size = aOl.size();
                if (size <= 0) {
                    e.this.eCg = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = aOl.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.aOg();
                        if (ao.equals(imageUrlData.id, e.this.eCp)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.eCo);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.aOk();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.NC();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.aVt, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(fVar.aOh(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.eCj;
                        imageUrlData.overAllIndex = fVar.aOk();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.aOi();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.aOj();
                        if (e.this.eCe.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.eCe.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.aGr.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.aGr.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                if (ao.equals(imageUrlData.id, e.this.eCp)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.eCo);
                                }
                            }
                        } else {
                            e.this.aGr.put(str2, imageUrlData);
                            if (e.this.eCm) {
                                e.this.eCd.add(i2, str2);
                            } else {
                                e.this.eCd.add(str2);
                            }
                            e.this.eCe.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = aOl.get(size - 1);
                    e.this.eCf = fVar2.aOg();
                    e.this.eCg = ((long) e.this.eCi) == fVar2.aOk();
                }
                boolean z2 = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.aVt = this.aVt;
                    z2 = true;
                }
                int a2 = e.this.eCm ? w.a(e.this.eCd, (String) e.this.eCe.get(this.mPicId)) - 1 : i3;
                if (e.this.eCk != null) {
                    e.this.eCk.a(e.this.eCd, a2, e.this.eCi, false, null, z2, e.this.eCl, z);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.Nx() != null && fVar.Nx().length() > 0) {
            return fVar.Nx();
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
        sb.append(ao.be(fVar.getImageUrl()));
        return sb.toString();
    }
}
