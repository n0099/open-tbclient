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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
    private Map<String, ImageUrlData> cdd;
    private String ctw;
    private String eYw;
    private String gAA;
    private String gAB;
    private boolean gAC;
    private ArrayList<String> gAn;
    private String gAp;
    private String gAq;
    private boolean gAr;
    private String gAz;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> gAo = new HashMap<>();
    private boolean mIsReserver = true;
    private a gAs = null;
    private int gAt = 0;
    private boolean gAu = false;
    private boolean gAv = false;
    private b gAw = null;
    private AdvertAppInfo gAx = null;
    private boolean gAy = false;

    /* loaded from: classes3.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void ao(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.gAr = false;
        this.gAn = arrayList;
        this.cdd = map;
        if (this.gAn == null) {
            this.gAn = new ArrayList<>();
        }
        Iterator<String> it = this.gAn.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.gAo.put(d.xK(next), next);
        }
        this.ctw = str3;
        this.eYw = str2;
        this.mForumId = str;
        this.gAq = str4;
        this.mThreadType = i;
        this.gAr = this.gAq == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.gAC = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.gAA = str;
    }

    public void xM(String str) {
        this.gAB = str;
    }

    public void lO(boolean z) {
        this.gAC = z;
    }

    public void lP(boolean z) {
        this.mIsReserver = z;
    }

    public void byj() {
        this.gAy = false;
        if (!this.gAr) {
            e(this.ctw, this.gAq, 10, 0);
        }
    }

    public void byk() {
        this.gAy = true;
        String str = this.gAn.get(0);
        if (StringUtils.isNull(this.gAp)) {
            this.gAp = d.xK(str);
        }
        e(this.ctw, this.gAp, 0, 10);
    }

    private void e(String str, String str2, int i, int i2) {
        if (this.gAs != null) {
            if (str2 == null || !str2.equals(this.gAs.getPicId())) {
                this.gAs.cancel();
            } else {
                return;
            }
        }
        this.gAs = new a(str, str2, i, i2);
        this.gAs.setPriority(3);
        this.gAs.execute(new Object[0]);
    }

    public void lQ(boolean z) {
        this.gAu = z;
    }

    public void lR(boolean z) {
        this.gAv = z;
    }

    public void a(b bVar) {
        this.gAw = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String ctw;
        private int gAD;
        private int gAE;
        private x mNetWork = null;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.ctw = null;
            this.mPicId = null;
            this.gAD = 0;
            this.gAE = 0;
            this.mPicId = str2;
            this.ctw = str;
            this.gAD = i;
            this.gAE = i2;
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
            this.mNetWork.x("kw", e.this.eYw);
            this.mNetWork.x("tid", this.ctw);
            if (this.mPicId != null) {
                this.mNetWork.x(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            this.mNetWork.x("source", String.valueOf(e.this.gAv ? 1 : 2));
            e.this.gAv = false;
            this.mNetWork.x(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.gAD));
            this.mNetWork.x("prev", String.valueOf(this.gAE));
            this.mNetWork.x("not_see_lz", String.valueOf(e.this.gAu ? 0 : 1));
            this.mNetWork.x("is_top_agree", String.valueOf(e.this.gAC ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.mNetWork.x("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.mNetWork.x("obj_type", e.this.mFrom);
            } else {
                this.mNetWork.x("obj_type", ImageViewerConfig.FROM_OTHER);
            }
            if (TextUtils.isEmpty(e.this.gAz)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    e.this.gAz = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", "");
                }
            }
            this.mNetWork.x("applist", e.this.gAz);
            byl();
            this.mNetWork.acE().adC().bLS = false;
            String acg = this.mNetWork.acg();
            if (!this.mNetWork.acE().adD().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.aj(acg, true);
            return hVar;
        }

        private void byl() {
            this.mNetWork.x("forum_id", e.this.mForumId);
            this.mNetWork.x("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.mNetWork.x("scr_w", String.valueOf(l.aO(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.x("scr_h", String.valueOf(l.aQ(TbadkCoreApplication.getInst().getApp())));
            this.mNetWork.x("q_type", String.valueOf(ar.adm().ado() ? 2 : 1));
            this.mNetWork.x("_os_version", Build.VERSION.RELEASE);
            this.mNetWork.x("page_name", "PB");
            this.mNetWork.x("pic_index", String.valueOf(e.this.gAn.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            e.this.gAs = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.cdd != null) {
                e.this.gAs = null;
                if (hVar == null) {
                    if (e.this.gAw != null) {
                        String str = null;
                        int i = -1;
                        if (this.mNetWork != null) {
                            i = this.mNetWork.acI();
                            if (this.mPicId == null) {
                                str = this.mNetWork.getErrorString();
                            }
                        }
                        e.this.gAw.ao(i, str);
                        return;
                    }
                    return;
                }
                boolean T = v.T(hVar.byu());
                if (e.this.mIsReset && !T) {
                    e.this.gAn.clear();
                    e.this.cdd.clear();
                    e.this.gAo.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.gAt = hVar.getImageNum();
                }
                e.this.gAx = hVar.byv();
                if (this.mPicId == null) {
                    e.this.gAn.clear();
                    e.this.gAo.clear();
                }
                LinkedList<f> byu = hVar.byu();
                int size = byu.size();
                if (size <= 0) {
                    e.this.gAr = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = byu.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.bym();
                        if (ap.equals(imageUrlData.id, e.this.gAB)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.gAA);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.byq();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.asR();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.g.b.d(this.ctw, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.g.b.d(fVar.byn(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.gAu;
                        imageUrlData.overAllIndex = fVar.byq();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.byo();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.byp();
                        if (fVar.bys() != null) {
                            imageUrlData.richTextArray = fVar.bys().toString();
                        }
                        imageUrlData.isFirstPost = fVar.byt();
                        if (fVar.aaE() != null) {
                            imageUrlData.agreeData = fVar.aaE();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.byr();
                            if (fVar.byt()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.gAo.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.gAo.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.cdd.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.cdd.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (ap.equals(imageUrlData.id, e.this.gAB)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.gAA);
                                }
                            }
                        } else {
                            e.this.cdd.put(str2, imageUrlData);
                            if (e.this.gAy) {
                                e.this.gAn.add(i2, str2);
                            } else {
                                e.this.gAn.add(str2);
                            }
                            e.this.gAo.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.c(byu, 0);
                    if (fVar2 != null) {
                        e.this.gAp = fVar2.bym();
                    }
                    f fVar3 = (f) v.c(byu, size - 1);
                    if (fVar3 != null) {
                        e.this.gAq = fVar3.bym();
                        e.this.gAr = ((long) e.this.gAt) == fVar3.byq();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.cdd.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.cdd.values()) {
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
                    e.this.ctw = this.ctw;
                    z = true;
                }
                int a2 = e.this.gAy ? v.a(e.this.gAn, (String) e.this.gAo.get(this.mPicId)) - 1 : i3;
                if (e.this.gAw != null) {
                    e.this.gAw.a(e.this.gAn, a2, e.this.gAt, false, null, z, e.this.gAx, T);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.asL() != null && fVar.asL().length() > 0) {
            return fVar.asL();
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
        sb.append(ap.bx(fVar.getImageUrl()));
        return sb.toString();
    }
}
