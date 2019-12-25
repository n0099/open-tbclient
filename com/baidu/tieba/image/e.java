package com.baidu.tieba.image;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes5.dex */
public class e {
    private String OC;
    private String cNP;
    private String cNQ;
    private Map<String, ImageUrlData> dnm;
    private boolean eai;
    private String giS;
    private ArrayList<String> hLO;
    private String hLQ;
    private String hLR;
    private String hLZ;
    private String hMa;
    private String hMb;
    private boolean hMc;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private String mPostId;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> hLP = new HashMap<>();
    private boolean mIsReserver = true;
    private a hLS = null;
    private int hLT = 0;
    private boolean hLU = false;
    private boolean hLV = false;
    private b hLW = null;
    private AdvertAppInfo hLX = null;
    private boolean hLY = false;
    private boolean hMd = false;

    /* loaded from: classes5.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void aF(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eai = false;
        this.hLO = arrayList;
        this.dnm = map;
        if (this.hLO == null) {
            this.hLO = new ArrayList<>();
        }
        Iterator<String> it = this.hLO.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.hLP.put(d.Dn(next), next);
        }
        this.OC = str3;
        this.giS = str2;
        this.mForumId = str;
        this.hLR = str4;
        this.mThreadType = i;
        this.eai = this.hLR == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.hMc = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.hMa = str;
    }

    public void Dp(String str) {
        this.hMb = str;
    }

    public void nX(boolean z) {
        this.hMc = z;
    }

    public String aBk() {
        return this.cNP;
    }

    public String aBl() {
        return this.cNQ;
    }

    public void nY(boolean z) {
        this.mIsReserver = z;
    }

    public void bXy() {
        this.hLY = false;
        if (!this.eai) {
            d(this.OC, this.hLR, 10, 0);
        }
    }

    public void bXz() {
        this.hLY = true;
        String str = this.hLO.get(0);
        if (StringUtils.isNull(this.hLQ)) {
            this.hLQ = d.Dn(str);
        }
        d(this.OC, this.hLQ, 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.hLS != null) {
            if (str2 == null || !str2.equals(this.hLS.getPicId())) {
                this.hLS.cancel();
            } else {
                return;
            }
        }
        this.hLS = new a(str, str2, i, i2);
        this.hLS.setPriority(3);
        this.hLS.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void nZ(boolean z) {
        this.hLU = z;
    }

    public void oa(boolean z) {
        this.hLV = z;
    }

    public void a(b bVar) {
        this.hLW = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String OC;
        private x cHo = null;
        private int hMe;
        private int hMf;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.OC = null;
            this.mPicId = null;
            this.hMe = 0;
            this.hMf = 0;
            this.mPicId = str2;
            this.OC = str;
            this.hMe = i;
            this.hMf = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public h doInBackground(Object... objArr) {
            this.cHo = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.cHo.addPostData("kw", e.this.giS);
            this.cHo.addPostData("tid", this.OC);
            if (this.mPicId != null) {
                this.cHo.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.cHo.addPostData("post_id", e.this.mPostId);
            }
            this.cHo.addPostData("source", String.valueOf(e.this.hLV ? 1 : 2));
            e.this.hLV = false;
            this.cHo.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.hMe));
            this.cHo.addPostData("prev", String.valueOf(this.hMf));
            this.cHo.addPostData("not_see_lz", String.valueOf(e.this.hLU ? 0 : 1));
            this.cHo.addPostData("is_top_agree", String.valueOf(e.this.hMc ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.cHo.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.cHo.addPostData("obj_type", e.this.mFrom);
            } else {
                this.cHo.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.hLZ)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aCY().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.hLZ = com.baidu.tbadk.core.sharedPref.b.aCY().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.cHo.addPostData("applist", e.this.hLZ);
            String aPz = w.aPz();
            if (!TextUtils.isEmpty(aPz)) {
                this.cHo.addPostData("oaid", aPz);
            }
            bXA();
            this.cHo.aDB().aEb().mNeedBackgroundLogin = false;
            String postNetData = this.cHo.postNetData();
            if (!this.cHo.aDB().aEc().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.ap(postNetData, true);
            return hVar;
        }

        private void bXA() {
            this.cHo.addPostData("forum_id", e.this.mForumId);
            this.cHo.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.cHo.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.cHo.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.cHo.addPostData("q_type", String.valueOf(ar.aDX().aDY() ? 2 : 1));
            this.cHo.addPostData("_os_version", Build.VERSION.RELEASE);
            this.cHo.addPostData("page_name", "PB");
            this.cHo.addPostData("pic_index", String.valueOf(e.this.hLO.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.cHo != null) {
                this.cHo.cancelNetConnect();
            }
            e.this.hLS = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.dnm != null) {
                e.this.hLS = null;
                if (hVar == null) {
                    if (e.this.hLW != null) {
                        String str = null;
                        int i = -1;
                        if (this.cHo != null) {
                            i = this.cHo.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.cHo.getErrorString();
                            }
                        }
                        e.this.hLW.aF(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = v.isEmpty(hVar.bXJ());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.hLO.clear();
                    e.this.dnm.clear();
                    e.this.hLP.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.hLT = hVar.getImageNum();
                }
                e.this.hLX = hVar.bXK();
                if (this.mPicId == null) {
                    e.this.hLO.clear();
                    e.this.hLP.clear();
                }
                LinkedList<f> bXJ = hVar.bXJ();
                int size = bXJ.size();
                if (size <= 0) {
                    e.this.eai = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = bXJ.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.bXB();
                        if (aq.equals(imageUrlData.id, e.this.hMb)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.hMa);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.bXF();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.aRC();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.OC, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.bXC(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.hLU;
                        imageUrlData.overAllIndex = fVar.bXF();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.bXD();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.bXE();
                        if (fVar.bXH() != null) {
                            imageUrlData.richTextArray = fVar.bXH().toString();
                        }
                        imageUrlData.isFirstPost = fVar.bXI();
                        if (fVar.aBt() != null) {
                            imageUrlData.agreeData = fVar.aBt();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.bXG();
                            if (fVar.bXI()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.hLP.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.hLP.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.dnm.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.dnm.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (aq.equals(imageUrlData.id, e.this.hMb)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.hMa);
                                }
                            }
                        } else if (e.this.hMd) {
                            e.this.hLT = e.this.dnm.size();
                            e.this.hLX = null;
                        } else {
                            e.this.dnm.put(str2, imageUrlData);
                            if (e.this.hLY) {
                                e.this.hLO.add(i2, str2);
                            } else {
                                e.this.hLO.add(str2);
                            }
                            e.this.hLP.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.getItem(bXJ, 0);
                    if (fVar2 != null) {
                        e.this.hLQ = fVar2.bXB();
                    }
                    f fVar3 = (f) v.getItem(bXJ, size - 1);
                    if (fVar3 != null) {
                        e.this.hLR = fVar3.bXB();
                        e.this.eai = ((long) e.this.hLT) == fVar3.bXF();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.dnm.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.dnm.values()) {
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
                    e.this.OC = this.OC;
                    z = true;
                }
                int position = e.this.hLY ? v.getPosition(e.this.hLO, (String) e.this.hLP.get(this.mPicId)) - 1 : i3;
                e.this.cNP = hVar.aBk();
                e.this.cNQ = hVar.aBl();
                if (e.this.hLW != null) {
                    e.this.hLW.a(e.this.hLO, position, e.this.hLT, false, null, z, e.this.hLX, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.aRw() != null && fVar.aRw().length() > 0) {
            return fVar.aRw();
        }
        StringBuilder sb = new StringBuilder(150);
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
        sb.append(aq.getUrlEncode(fVar.getImageUrl()));
        return sb.toString();
    }

    public void ob(boolean z) {
        this.hMd = z;
    }
}
