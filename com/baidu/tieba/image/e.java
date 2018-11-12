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
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
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
    private Map<String, ImageUrlData> aPO;
    private String beV;
    private String dBw;
    private ArrayList<String> eZY;
    private String faa;
    private boolean fab;
    private String faj;
    private String fak;
    private String fal;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> eZZ = new HashMap<>();
    private boolean mIsReserver = true;
    private a fac = null;
    private int fad = 0;
    private boolean fae = false;
    private boolean faf = false;
    private b fag = null;
    private AdvertAppInfo fah = null;
    private boolean fai = false;

    /* loaded from: classes3.dex */
    public interface b {
        void T(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eZY = null;
        this.beV = null;
        this.mForumId = null;
        this.dBw = null;
        this.faa = null;
        this.fab = false;
        this.mUserId = null;
        this.eZY = arrayList;
        this.aPO = map;
        if (this.eZY == null) {
            this.eZY = new ArrayList<>();
        }
        Iterator<String> it = this.eZY.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.eZZ.put(d.qm(next), next);
        }
        this.beV = str3;
        this.dBw = str2;
        this.mForumId = str;
        this.faa = str4;
        this.mThreadType = i;
        this.fab = this.faa == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
    }

    public void setSourceImageRectInScreen(String str) {
        this.fak = str;
    }

    public void qp(String str) {
        this.fal = str;
    }

    public void ji(boolean z) {
        this.mIsReserver = z;
    }

    public void aUE() {
        this.fai = false;
        if (!this.fab) {
            d(this.beV, this.faa, 10, 0);
        }
    }

    public void aUF() {
        this.fai = true;
        d(this.beV, d.qm(this.eZY.get(0)), 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.fac != null) {
            if (str2 == null || !str2.equals(this.fac.getPicId())) {
                this.fac.cancel();
            } else {
                return;
            }
        }
        this.fac = new a(str, str2, i, i2);
        this.fac.setPriority(3);
        this.fac.execute(new Object[0]);
    }

    public void jj(boolean z) {
        this.fae = z;
    }

    public void jk(boolean z) {
        this.faf = z;
    }

    public void a(b bVar) {
        this.fag = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String beV;
        private int fam;
        private int fan;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.beV = null;
            this.mPicId = null;
            this.fam = 0;
            this.fan = 0;
            this.mPicId = str2;
            this.beV = str;
            this.fam = i;
            this.fan = i2;
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
            this.mNetWork.x("kw", e.this.dBw);
            this.mNetWork.x("tid", this.beV);
            if (this.mPicId != null) {
                this.mNetWork.x(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.x("source", String.valueOf(e.this.faf ? 1 : 2));
            e.this.faf = false;
            this.mNetWork.x(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.fam));
            this.mNetWork.x("prev", String.valueOf(this.fan));
            this.mNetWork.x("not_see_lz", String.valueOf(e.this.fae ? 0 : 1));
            if (!e.this.mIsReserver) {
                this.mNetWork.x("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.x("obj_type", e.this.mFrom);
            }
            if (TextUtils.isEmpty(e.this.faj)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.faj = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.x("applist", e.this.faj);
            aUG();
            this.mNetWork.Cf().Dd().azQ = false;
            String BH = this.mNetWork.BH();
            if (!this.mNetWork.Cf().De().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.O(BH, true);
            return hVar;
        }

        private void aUG() {
            this.mNetWork.x("forum_id", e.this.mForumId);
            this.mNetWork.x("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.x("scr_w", String.valueOf(l.aO(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.x("scr_h", String.valueOf(l.aQ(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.x("q_type", String.valueOf(aq.CN().CP() ? 2 : 1));
            this.mNetWork.x("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.x("page_name", "PB");
            this.mNetWork.x("pic_index", String.valueOf(e.this.eZY.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            e.this.fac = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.aPO != null) {
                e.this.fac = null;
                if (hVar == null) {
                    if (e.this.fag != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.Cj();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.fag.T(i, str);
                        return;
                    }
                    return;
                }
                boolean I = v.I(hVar.aUM());
                if (e.this.mIsReset && !I) {
                    e.this.eZY.clear();
                    e.this.aPO.clear();
                    e.this.eZZ.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.fad = hVar.getImageNum();
                }
                e.this.fah = hVar.aUN();
                if (this.mPicId == null) {
                    e.this.eZY.clear();
                    e.this.eZZ.clear();
                }
                LinkedList<f> aUM = hVar.aUM();
                int size = aUM.size();
                if (size <= 0) {
                    e.this.fab = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = aUM.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.aUH();
                        if (ao.equals(imageUrlData.id, e.this.fal)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.fak);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.aUL();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.Rr();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.beV, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(fVar.aUI(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.fae;
                        imageUrlData.overAllIndex = fVar.aUL();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.aUJ();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.aUK();
                        if (e.this.eZZ.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.eZZ.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.aPO.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.aPO.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                if (ao.equals(imageUrlData.id, e.this.fal)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.fak);
                                }
                            }
                        } else {
                            e.this.aPO.put(str2, imageUrlData);
                            if (e.this.fai) {
                                e.this.eZY.add(i2, str2);
                            } else {
                                e.this.eZY.add(str2);
                            }
                            e.this.eZZ.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = aUM.get(size - 1);
                    e.this.faa = fVar2.aUH();
                    e.this.fab = ((long) e.this.fad) == fVar2.aUL();
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.beV = this.beV;
                    z = true;
                }
                int a2 = e.this.fai ? v.a(e.this.eZY, (String) e.this.eZZ.get(this.mPicId)) - 1 : i3;
                if (e.this.fag != null) {
                    e.this.fag.a(e.this.eZY, a2, e.this.fad, false, null, z, e.this.fah, I);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.Rk() != null && fVar.Rk().length() > 0) {
            return fVar.Rk();
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
        sb.append(ao.bx(fVar.getImageUrl()));
        return sb.toString();
    }
}
