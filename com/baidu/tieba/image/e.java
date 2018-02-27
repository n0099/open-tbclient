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
    private String bCS;
    private Map<String, ImageUrlData> bmg;
    private String dEe;
    private ArrayList<String> eUN;
    private String eUP;
    private boolean eUQ;
    private String eUX;
    private String eUY;
    private String eUZ;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> eUO = new HashMap<>();
    private boolean mIsReserver = true;
    private a eUR = null;
    private int eUS = 0;
    private boolean eUT = false;
    private b eUU = null;
    private AdvertAppInfo eUV = null;
    private boolean eUW = false;

    /* loaded from: classes3.dex */
    public interface b {
        void P(int i, String str);

        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eUN = null;
        this.bCS = null;
        this.mForumId = null;
        this.dEe = null;
        this.eUP = null;
        this.eUQ = false;
        this.mUserId = null;
        this.eUN = arrayList;
        this.bmg = map;
        if (this.eUN == null) {
            this.eUN = new ArrayList<>();
        }
        Iterator<String> it = this.eUN.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.eUO.put(d.oe(next), next);
        }
        this.bCS = str3;
        this.dEe = str2;
        this.mForumId = str;
        this.eUP = str4;
        this.mThreadType = i;
        this.eUQ = this.eUP == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
    }

    public void setSourceImageRectInScreen(String str) {
        this.eUY = str;
    }

    public void oi(String str) {
        this.eUZ = str;
    }

    public void im(boolean z) {
        this.mIsReserver = z;
    }

    public void aOg() {
        this.eUW = false;
        if (!this.eUQ) {
            d(this.bCS, this.eUP, 10, 0);
        }
    }

    public void aOh() {
        this.eUW = true;
        d(this.bCS, d.oe(this.eUN.get(0)), 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.eUR != null) {
            if (str2 == null || !str2.equals(this.eUR.getPicId())) {
                this.eUR.cancel();
            } else {
                return;
            }
        }
        this.eUR = new a(str, str2, i, i2);
        this.eUR.setPriority(3);
        this.eUR.execute(new Object[0]);
    }

    public void in(boolean z) {
        this.eUT = z;
    }

    public void a(b bVar) {
        this.eUU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private String bCS;
        private int eVa;
        private int eVb;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.bCS = null;
            this.mPicId = null;
            this.eVa = 0;
            this.eVb = 0;
            this.mPicId = str2;
            this.bCS = str;
            this.eVa = i;
            this.eVb = i2;
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
            this.mNetWork.n("kw", e.this.dEe);
            this.mNetWork.n("tid", this.bCS);
            if (this.mPicId != null) {
                this.mNetWork.n(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.n("next", String.valueOf(this.eVa));
            this.mNetWork.n("prev", String.valueOf(this.eVb));
            this.mNetWork.n("not_see_lz", String.valueOf(e.this.eUT ? 0 : 1));
            if (!e.this.mIsReserver) {
                this.mNetWork.n("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.n("obj_type", e.this.mFrom);
            }
            if (TextUtils.isEmpty(e.this.eUX)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.eUX = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.n("applist", e.this.eUX);
            aOi();
            this.mNetWork.Cy().Dv().aXY = false;
            String Ca = this.mNetWork.Ca();
            if (!this.mNetWork.Cy().Dw().isRequestSuccess()) {
                return null;
            }
            g gVar = new g();
            gVar.K(Ca, true);
            return gVar;
        }

        private void aOi() {
            this.mNetWork.n("forum_id", e.this.mForumId);
            this.mNetWork.n("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.n("scr_w", String.valueOf(l.ao(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.n("scr_h", String.valueOf(l.aq(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.n("q_type", String.valueOf(ao.Dd().Df() ? 2 : 1));
            this.mNetWork.n("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.n("page_name", "PB");
            this.mNetWork.n("pic_index", String.valueOf(e.this.eUN.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.mS();
            }
            e.this.eUR = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (e.this.bmg != null) {
                e.this.eUR = null;
                if (gVar == null) {
                    if (e.this.eUU != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.CC();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.eUU.P(i, str);
                        return;
                    }
                    return;
                }
                boolean E = v.E(gVar.aOo());
                if (e.this.mIsReset && !E) {
                    e.this.eUN.clear();
                    e.this.bmg.clear();
                    e.this.eUO.clear();
                }
                if (gVar.getImageNum() != 0) {
                    e.this.eUS = gVar.getImageNum();
                }
                e.this.eUV = gVar.aOp();
                if (this.mPicId == null) {
                    e.this.eUN.clear();
                    e.this.eUO.clear();
                }
                LinkedList<f> aOo = gVar.aOo();
                int size = aOo.size();
                if (size <= 0) {
                    e.this.eUQ = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = aOo.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.aOj();
                        if (am.equals(imageUrlData.id, e.this.eUZ)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.eUY);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.aOn();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.RE();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.c(this.bCS, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.c(fVar.aOk(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.eUT;
                        imageUrlData.overAllIndex = fVar.aOn();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.aOl();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.aOm();
                        if (e.this.eUO.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.eUO.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.bmg.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.bmg.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                if (am.equals(imageUrlData.id, e.this.eUZ)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.eUY);
                                }
                            }
                        } else {
                            e.this.bmg.put(str2, imageUrlData);
                            if (e.this.eUW) {
                                e.this.eUN.add(i2, str2);
                            } else {
                                e.this.eUN.add(str2);
                            }
                            e.this.eUO.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = aOo.get(size - 1);
                    e.this.eUP = fVar2.aOj();
                    e.this.eUQ = ((long) e.this.eUS) == fVar2.aOn();
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    e.this.bCS = this.bCS;
                    z = true;
                }
                int a2 = e.this.eUW ? v.a(e.this.eUN, (String) e.this.eUO.get(this.mPicId)) - 1 : i3;
                if (e.this.eUU != null) {
                    e.this.eUU.a(e.this.eUN, a2, e.this.eUS, false, null, z, e.this.eUV, E);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.Ry() != null && fVar.Ry().length() > 0) {
            return fVar.Ry();
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
