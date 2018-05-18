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
    private String aNv;
    private Map<String, ImageUrlData> axW;
    private String cYh;
    private ArrayList<String> eqM;
    private String eqO;
    private boolean eqP;
    private String eqW;
    private String eqX;
    private String eqY;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> eqN = new HashMap<>();
    private boolean mIsReserver = true;
    private a eqQ = null;
    private int eqR = 0;
    private boolean eqS = false;
    private b eqT = null;
    private AdvertAppInfo eqU = null;
    private boolean eqV = false;

    /* loaded from: classes3.dex */
    public interface b {
        void Y(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eqM = null;
        this.aNv = null;
        this.mForumId = null;
        this.cYh = null;
        this.eqO = null;
        this.eqP = false;
        this.mUserId = null;
        this.eqM = arrayList;
        this.axW = map;
        if (this.eqM == null) {
            this.eqM = new ArrayList<>();
        }
        Iterator<String> it = this.eqM.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.eqN.put(d.om(next), next);
        }
        this.aNv = str3;
        this.cYh = str2;
        this.mForumId = str;
        this.eqO = str4;
        this.mThreadType = i;
        this.eqP = this.eqO == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
    }

    public void setSourceImageRectInScreen(String str) {
        this.eqX = str;
    }

    public void oq(String str) {
        this.eqY = str;
    }

    public void hQ(boolean z) {
        this.mIsReserver = z;
    }

    public void aJi() {
        this.eqV = false;
        if (!this.eqP) {
            d(this.aNv, this.eqO, 10, 0);
        }
    }

    public void aJj() {
        this.eqV = true;
        d(this.aNv, d.om(this.eqM.get(0)), 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.eqQ != null) {
            if (str2 == null || !str2.equals(this.eqQ.getPicId())) {
                this.eqQ.cancel();
            } else {
                return;
            }
        }
        this.eqQ = new a(str, str2, i, i2);
        this.eqQ.setPriority(3);
        this.eqQ.execute(new Object[0]);
    }

    public void hR(boolean z) {
        this.eqS = z;
    }

    public void a(b bVar) {
        this.eqT = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private String aNv;
        private int eqZ;
        private int era;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.aNv = null;
            this.mPicId = null;
            this.eqZ = 0;
            this.era = 0;
            this.mPicId = str2;
            this.aNv = str;
            this.eqZ = i;
            this.era = i2;
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
            this.mNetWork.n("kw", e.this.cYh);
            this.mNetWork.n("tid", this.aNv);
            if (this.mPicId != null) {
                this.mNetWork.n(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.n("next", String.valueOf(this.eqZ));
            this.mNetWork.n("prev", String.valueOf(this.era));
            this.mNetWork.n("not_see_lz", String.valueOf(e.this.eqS ? 0 : 1));
            if (!e.this.mIsReserver) {
                this.mNetWork.n("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.n("obj_type", e.this.mFrom);
            }
            if (TextUtils.isEmpty(e.this.eqW)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.eqW = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.n("applist", e.this.eqW);
            aJk();
            this.mNetWork.vi().wh().ajD = false;
            String uK = this.mNetWork.uK();
            if (!this.mNetWork.vi().wi().isRequestSuccess()) {
                return null;
            }
            g gVar = new g();
            gVar.G(uK, true);
            return gVar;
        }

        private void aJk() {
            this.mNetWork.n("forum_id", e.this.mForumId);
            this.mNetWork.n("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.n("scr_w", String.valueOf(l.af(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.n("scr_h", String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.n("q_type", String.valueOf(ap.vP().vR() ? 2 : 1));
            this.mNetWork.n("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.n("page_name", "PB");
            this.mNetWork.n("pic_index", String.valueOf(e.this.eqM.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.eW();
            }
            e.this.eqQ = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (e.this.axW != null) {
                e.this.eqQ = null;
                if (gVar == null) {
                    if (e.this.eqT != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.vm();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.eqT.Y(i, str);
                        return;
                    }
                    return;
                }
                boolean w = v.w(gVar.aJq());
                if (e.this.mIsReset && !w) {
                    e.this.eqM.clear();
                    e.this.axW.clear();
                    e.this.eqN.clear();
                }
                if (gVar.getImageNum() != 0) {
                    e.this.eqR = gVar.getImageNum();
                }
                e.this.eqU = gVar.aJr();
                if (this.mPicId == null) {
                    e.this.eqM.clear();
                    e.this.eqN.clear();
                }
                LinkedList<f> aJq = gVar.aJq();
                int size = aJq.size();
                if (size <= 0) {
                    e.this.eqP = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = aJq.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.aJl();
                        if (an.equals(imageUrlData.id, e.this.eqY)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.eqX);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.aJp();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.Kd();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.aNv, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(fVar.aJm(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.eqS;
                        imageUrlData.overAllIndex = fVar.aJp();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.aJn();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.aJo();
                        if (e.this.eqN.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.eqN.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.axW.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.axW.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                if (an.equals(imageUrlData.id, e.this.eqY)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.eqX);
                                }
                            }
                        } else {
                            e.this.axW.put(str2, imageUrlData);
                            if (e.this.eqV) {
                                e.this.eqM.add(i2, str2);
                            } else {
                                e.this.eqM.add(str2);
                            }
                            e.this.eqN.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = aJq.get(size - 1);
                    e.this.eqO = fVar2.aJl();
                    e.this.eqP = ((long) e.this.eqR) == fVar2.aJp();
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.aNv = this.aNv;
                    z = true;
                }
                int a2 = e.this.eqV ? v.a(e.this.eqM, (String) e.this.eqN.get(this.mPicId)) - 1 : i3;
                if (e.this.eqT != null) {
                    e.this.eqT.a(e.this.eqM, a2, e.this.eqR, false, null, z, e.this.eqU, w);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.JY() != null && fVar.JY().length() > 0) {
            return fVar.JY();
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
