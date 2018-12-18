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
    private Map<String, ImageUrlData> aTn;
    private String biw;
    private String dHV;
    private ArrayList<String> fgN;
    private String fgP;
    private String fgQ;
    private boolean fgR;
    private String fgZ;
    private String fha;
    private String fhb;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> fgO = new HashMap<>();
    private boolean mIsReserver = true;
    private a fgS = null;
    private int fgT = 0;
    private boolean fgU = false;
    private boolean fgV = false;
    private b fgW = null;
    private AdvertAppInfo fgX = null;
    private boolean fgY = false;

    /* loaded from: classes3.dex */
    public interface b {
        void T(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.fgR = false;
        this.fgN = arrayList;
        this.aTn = map;
        if (this.fgN == null) {
            this.fgN = new ArrayList<>();
        }
        Iterator<String> it = this.fgN.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.fgO.put(d.qO(next), next);
        }
        this.biw = str3;
        this.dHV = str2;
        this.mForumId = str;
        this.fgQ = str4;
        this.mThreadType = i;
        this.fgR = this.fgQ == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
    }

    public void setSourceImageRectInScreen(String str) {
        this.fha = str;
    }

    public void qR(String str) {
        this.fhb = str;
    }

    public void jl(boolean z) {
        this.mIsReserver = z;
    }

    public void aWv() {
        this.fgY = false;
        if (!this.fgR) {
            d(this.biw, this.fgQ, 10, 0);
        }
    }

    public void aWw() {
        this.fgY = true;
        String str = this.fgN.get(0);
        if (StringUtils.isNull(this.fgP)) {
            this.fgP = d.qO(str);
        }
        d(this.biw, this.fgP, 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.fgS != null) {
            if (str2 == null || !str2.equals(this.fgS.getPicId())) {
                this.fgS.cancel();
            } else {
                return;
            }
        }
        this.fgS = new a(str, str2, i, i2);
        this.fgS.setPriority(3);
        this.fgS.execute(new Object[0]);
    }

    public void jm(boolean z) {
        this.fgU = z;
    }

    public void jn(boolean z) {
        this.fgV = z;
    }

    public void a(b bVar) {
        this.fgW = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String biw;
        private int fhc;
        private int fhd;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.biw = null;
            this.mPicId = null;
            this.fhc = 0;
            this.fhd = 0;
            this.mPicId = str2;
            this.biw = str;
            this.fhc = i;
            this.fhd = i2;
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
            this.mNetWork.x("kw", e.this.dHV);
            this.mNetWork.x("tid", this.biw);
            if (this.mPicId != null) {
                this.mNetWork.x(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.x("source", String.valueOf(e.this.fgV ? 1 : 2));
            e.this.fgV = false;
            this.mNetWork.x(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.fhc));
            this.mNetWork.x("prev", String.valueOf(this.fhd));
            this.mNetWork.x("not_see_lz", String.valueOf(e.this.fgU ? 0 : 1));
            if (!e.this.mIsReserver) {
                this.mNetWork.x("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.x("obj_type", e.this.mFrom);
            }
            if (TextUtils.isEmpty(e.this.fgZ)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.fgZ = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.x("applist", e.this.fgZ);
            aWx();
            this.mNetWork.Dj().Eh().aDq = false;
            String CL = this.mNetWork.CL();
            if (!this.mNetWork.Dj().Ei().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.Q(CL, true);
            return hVar;
        }

        private void aWx() {
            this.mNetWork.x("forum_id", e.this.mForumId);
            this.mNetWork.x("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.x("scr_w", String.valueOf(l.aO(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.x("scr_h", String.valueOf(l.aQ(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.x("q_type", String.valueOf(aq.DR().DT() ? 2 : 1));
            this.mNetWork.x("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.x("page_name", "PB");
            this.mNetWork.x("pic_index", String.valueOf(e.this.fgN.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            e.this.fgS = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.aTn != null) {
                e.this.fgS = null;
                if (hVar == null) {
                    if (e.this.fgW != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.Dn();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.fgW.T(i, str);
                        return;
                    }
                    return;
                }
                boolean I = v.I(hVar.aWD());
                if (e.this.mIsReset && !I) {
                    e.this.fgN.clear();
                    e.this.aTn.clear();
                    e.this.fgO.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.fgT = hVar.getImageNum();
                }
                e.this.fgX = hVar.aWE();
                if (this.mPicId == null) {
                    e.this.fgN.clear();
                    e.this.fgO.clear();
                }
                LinkedList<f> aWD = hVar.aWD();
                int size = aWD.size();
                if (size <= 0) {
                    e.this.fgR = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = aWD.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.aWy();
                        if (ao.equals(imageUrlData.id, e.this.fhb)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.fha);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.aWC();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.Sx();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.biw, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(fVar.aWz(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.fgU;
                        imageUrlData.overAllIndex = fVar.aWC();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.aWA();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.aWB();
                        if (e.this.fgO.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.fgO.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.aTn.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.aTn.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                if (ao.equals(imageUrlData.id, e.this.fhb)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.fha);
                                }
                            }
                        } else {
                            e.this.aTn.put(str2, imageUrlData);
                            if (e.this.fgY) {
                                e.this.fgN.add(i2, str2);
                            } else {
                                e.this.fgN.add(str2);
                            }
                            e.this.fgO.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.d(aWD, 0);
                    if (fVar2 != null) {
                        e.this.fgP = fVar2.aWy();
                    }
                    f fVar3 = (f) v.d(aWD, size - 1);
                    if (fVar3 != null) {
                        e.this.fgQ = fVar3.aWy();
                        e.this.fgR = ((long) e.this.fgT) == fVar3.aWC();
                    }
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.biw = this.biw;
                    z = true;
                }
                int a2 = e.this.fgY ? v.a(e.this.fgN, (String) e.this.fgO.get(this.mPicId)) - 1 : i3;
                if (e.this.fgW != null) {
                    e.this.fgW.a(e.this.fgN, a2, e.this.fgT, false, null, z, e.this.fgX, I);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.Sq() != null && fVar.Sq().length() > 0) {
            return fVar.Sq();
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
