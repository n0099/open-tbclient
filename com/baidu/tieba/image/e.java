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
    private Map<String, ImageUrlData> aOY;
    private String beh;
    private String dAf;
    private ArrayList<String> eYF;
    private String eYH;
    private boolean eYI;
    private String eYP;
    private String eYQ;
    private String eYR;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> eYG = new HashMap<>();
    private boolean mIsReserver = true;
    private a eYJ = null;
    private int eYK = 0;
    private boolean eYL = false;
    private b eYM = null;
    private AdvertAppInfo eYN = null;
    private boolean eYO = false;

    /* loaded from: classes3.dex */
    public interface b {
        void X(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eYF = null;
        this.beh = null;
        this.mForumId = null;
        this.dAf = null;
        this.eYH = null;
        this.eYI = false;
        this.mUserId = null;
        this.eYF = arrayList;
        this.aOY = map;
        if (this.eYF == null) {
            this.eYF = new ArrayList<>();
        }
        Iterator<String> it = this.eYF.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.eYG.put(d.ql(next), next);
        }
        this.beh = str3;
        this.dAf = str2;
        this.mForumId = str;
        this.eYH = str4;
        this.mThreadType = i;
        this.eYI = this.eYH == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
    }

    public void setSourceImageRectInScreen(String str) {
        this.eYQ = str;
    }

    public void qo(String str) {
        this.eYR = str;
    }

    public void iZ(boolean z) {
        this.mIsReserver = z;
    }

    public void aVh() {
        this.eYO = false;
        if (!this.eYI) {
            d(this.beh, this.eYH, 10, 0);
        }
    }

    public void aVi() {
        this.eYO = true;
        d(this.beh, d.ql(this.eYF.get(0)), 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.eYJ != null) {
            if (str2 == null || !str2.equals(this.eYJ.getPicId())) {
                this.eYJ.cancel();
            } else {
                return;
            }
        }
        this.eYJ = new a(str, str2, i, i2);
        this.eYJ.setPriority(3);
        this.eYJ.execute(new Object[0]);
    }

    public void ja(boolean z) {
        this.eYL = z;
    }

    public void a(b bVar) {
        this.eYM = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String beh;
        private int eYS;
        private int eYT;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.beh = null;
            this.mPicId = null;
            this.eYS = 0;
            this.eYT = 0;
            this.mPicId = str2;
            this.beh = str;
            this.eYS = i;
            this.eYT = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: y */
        public h doInBackground(Object... objArr) {
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.mNetWork.x("kw", e.this.dAf);
            this.mNetWork.x("tid", this.beh);
            if (this.mPicId != null) {
                this.mNetWork.x(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.x(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.eYS));
            this.mNetWork.x("prev", String.valueOf(this.eYT));
            this.mNetWork.x("not_see_lz", String.valueOf(e.this.eYL ? 0 : 1));
            if (!e.this.mIsReserver) {
                this.mNetWork.x("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.x("obj_type", e.this.mFrom);
            }
            if (TextUtils.isEmpty(e.this.eYP)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.eYP = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.x("applist", e.this.eYP);
            aVj();
            this.mNetWork.BY().CW().azb = false;
            String BA = this.mNetWork.BA();
            if (!this.mNetWork.BY().CX().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.O(BA, true);
            return hVar;
        }

        private void aVj() {
            this.mNetWork.x("forum_id", e.this.mForumId);
            this.mNetWork.x("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.x("scr_w", String.valueOf(l.aO(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.x("scr_h", String.valueOf(l.aQ(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.x("q_type", String.valueOf(aq.CG().CI() ? 2 : 1));
            this.mNetWork.x("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.x("page_name", "PB");
            this.mNetWork.x("pic_index", String.valueOf(e.this.eYF.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            e.this.eYJ = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.aOY != null) {
                e.this.eYJ = null;
                if (hVar == null) {
                    if (e.this.eYM != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.Cc();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.eYM.X(i, str);
                        return;
                    }
                    return;
                }
                boolean J = v.J(hVar.aVp());
                if (e.this.mIsReset && !J) {
                    e.this.eYF.clear();
                    e.this.aOY.clear();
                    e.this.eYG.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.eYK = hVar.getImageNum();
                }
                e.this.eYN = hVar.aVq();
                if (this.mPicId == null) {
                    e.this.eYF.clear();
                    e.this.eYG.clear();
                }
                LinkedList<f> aVp = hVar.aVp();
                int size = aVp.size();
                if (size <= 0) {
                    e.this.eYI = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = aVp.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.aVk();
                        if (ao.equals(imageUrlData.id, e.this.eYR)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.eYQ);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.aVo();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.Ri();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.beh, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(fVar.aVl(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.eYL;
                        imageUrlData.overAllIndex = fVar.aVo();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.aVm();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.aVn();
                        if (e.this.eYG.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.eYG.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.aOY.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.aOY.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                if (ao.equals(imageUrlData.id, e.this.eYR)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.eYQ);
                                }
                            }
                        } else {
                            e.this.aOY.put(str2, imageUrlData);
                            if (e.this.eYO) {
                                e.this.eYF.add(i2, str2);
                            } else {
                                e.this.eYF.add(str2);
                            }
                            e.this.eYG.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = aVp.get(size - 1);
                    e.this.eYH = fVar2.aVk();
                    e.this.eYI = ((long) e.this.eYK) == fVar2.aVo();
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.beh = this.beh;
                    z = true;
                }
                int a2 = e.this.eYO ? v.a(e.this.eYF, (String) e.this.eYG.get(this.mPicId)) - 1 : i3;
                if (e.this.eYM != null) {
                    e.this.eYM.a(e.this.eYF, a2, e.this.eYK, false, null, z, e.this.eYN, J);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.Rb() != null && fVar.Rb().length() > 0) {
            return fVar.Rb();
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
