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
/* loaded from: classes8.dex */
public class e {
    private String ahL;
    private Map<String, ImageUrlData> dSe;
    private String drA;
    private String drB;
    private boolean eEO;
    private String gYi;
    private ArrayList<String> iCU;
    private String iCW;
    private String iCX;
    private String iDf;
    private String iDg;
    private String iDh;
    private boolean iDi;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private String mPostId;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> iCV = new HashMap<>();
    private boolean mIsReserver = true;
    private a iCY = null;
    private int iCZ = 0;
    private boolean iDa = false;
    private boolean iDb = false;
    private b iDc = null;
    private AdvertAppInfo iDd = null;
    private boolean iDe = false;
    private boolean iDj = false;

    /* loaded from: classes8.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void ba(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eEO = false;
        this.iCU = arrayList;
        this.dSe = map;
        if (this.iCU == null) {
            this.iCU = new ArrayList<>();
        }
        Iterator<String> it = this.iCU.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.iCV.put(d.Fw(next), next);
        }
        this.ahL = str3;
        this.gYi = str2;
        this.mForumId = str;
        this.iCX = str4;
        this.mThreadType = i;
        this.eEO = this.iCX == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.iDi = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.iDg = str;
    }

    public void Fy(String str) {
        this.iDh = str;
    }

    public void pv(boolean z) {
        this.iDi = z;
    }

    public String aMk() {
        return this.drA;
    }

    public String aMl() {
        return this.drB;
    }

    public void pw(boolean z) {
        this.mIsReserver = z;
    }

    public void clf() {
        this.iDe = false;
        if (!this.eEO) {
            d(this.ahL, this.iCX, 10, 0);
        }
    }

    public void clg() {
        this.iDe = true;
        String str = this.iCU.get(0);
        if (StringUtils.isNull(this.iCW)) {
            this.iCW = d.Fw(str);
        }
        d(this.ahL, this.iCW, 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.iCY != null) {
            if (str2 == null || !str2.equals(this.iCY.getPicId())) {
                this.iCY.cancel();
            } else {
                return;
            }
        }
        this.iCY = new a(str, str2, i, i2);
        this.iCY.setPriority(3);
        this.iCY.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void px(boolean z) {
        this.iDa = z;
    }

    public void py(boolean z) {
        this.iDb = z;
    }

    public void a(b bVar) {
        this.iDc = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String ahL;
        private x blF = null;
        private int iDk;
        private int iDl;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.ahL = null;
            this.mPicId = null;
            this.iDk = 0;
            this.iDl = 0;
            this.mPicId = str2;
            this.ahL = str;
            this.iDk = i;
            this.iDl = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public h doInBackground(Object... objArr) {
            this.blF = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.blF.addPostData("kw", e.this.gYi);
            this.blF.addPostData("tid", this.ahL);
            if (this.mPicId != null) {
                this.blF.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.blF.addPostData("post_id", e.this.mPostId);
            }
            this.blF.addPostData("source", String.valueOf(e.this.iDb ? 1 : 2));
            e.this.iDb = false;
            this.blF.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.iDk));
            this.blF.addPostData("prev", String.valueOf(this.iDl));
            this.blF.addPostData("not_see_lz", String.valueOf(e.this.iDa ? 0 : 1));
            this.blF.addPostData("is_top_agree", String.valueOf(e.this.iDi ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.blF.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.blF.addPostData("obj_type", e.this.mFrom);
            } else {
                this.blF.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.iDf)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aNV().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.iDf = com.baidu.tbadk.core.sharedPref.b.aNV().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.blF.addPostData("applist", e.this.iDf);
            String baz = w.baz();
            if (!TextUtils.isEmpty(baz)) {
                this.blF.addPostData("oaid", baz);
            }
            clh();
            this.blF.aOy().aOZ().mNeedBackgroundLogin = false;
            String postNetData = this.blF.postNetData();
            if (!this.blF.aOy().aPa().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.av(postNetData, true);
            return hVar;
        }

        private void clh() {
            this.blF.addPostData("forum_id", e.this.mForumId);
            this.blF.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.blF.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.blF.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.blF.addPostData("q_type", String.valueOf(ar.aOV().aOW() ? 2 : 1));
            this.blF.addPostData("_os_version", Build.VERSION.RELEASE);
            this.blF.addPostData("page_name", "PB");
            this.blF.addPostData("pic_index", String.valueOf(e.this.iCU.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.blF != null) {
                this.blF.cancelNetConnect();
            }
            e.this.iCY = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.dSe != null) {
                e.this.iCY = null;
                if (hVar == null) {
                    if (e.this.iDc != null) {
                        String str = null;
                        int i = -1;
                        if (this.blF != null) {
                            i = this.blF.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.blF.getErrorString();
                            }
                        }
                        e.this.iDc.ba(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = v.isEmpty(hVar.clq());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.iCU.clear();
                    e.this.dSe.clear();
                    e.this.iCV.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.iCZ = hVar.getImageNum();
                }
                e.this.iDd = hVar.clr();
                if (this.mPicId == null) {
                    e.this.iCU.clear();
                    e.this.iCV.clear();
                }
                LinkedList<f> clq = hVar.clq();
                int size = clq.size();
                if (size <= 0) {
                    e.this.eEO = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = clq.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.cli();
                        if (aq.equals(imageUrlData.id, e.this.iDh)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.iDg);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.clm();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.bcD();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.ahL, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.clj(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.iDa;
                        imageUrlData.overAllIndex = fVar.clm();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.clk();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.cll();
                        if (fVar.clo() != null) {
                            imageUrlData.richTextArray = fVar.clo().toString();
                        }
                        imageUrlData.isFirstPost = fVar.clp();
                        if (fVar.aMs() != null) {
                            imageUrlData.agreeData = fVar.aMs();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.cln();
                            if (fVar.clp()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.iCV.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.iCV.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.dSe.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.dSe.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (aq.equals(imageUrlData.id, e.this.iDh)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.iDg);
                                }
                            }
                        } else if (e.this.iDj) {
                            e.this.iCZ = e.this.dSe.size();
                            e.this.iDd = null;
                        } else {
                            e.this.dSe.put(str2, imageUrlData);
                            if (e.this.iDe) {
                                e.this.iCU.add(i2, str2);
                            } else {
                                e.this.iCU.add(str2);
                            }
                            e.this.iCV.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.getItem(clq, 0);
                    if (fVar2 != null) {
                        e.this.iCW = fVar2.cli();
                    }
                    f fVar3 = (f) v.getItem(clq, size - 1);
                    if (fVar3 != null) {
                        e.this.iCX = fVar3.cli();
                        e.this.eEO = ((long) e.this.iCZ) == fVar3.clm();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.dSe.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.dSe.values()) {
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
                    e.this.ahL = this.ahL;
                    z = true;
                }
                int position = e.this.iDe ? v.getPosition(e.this.iCU, (String) e.this.iCV.get(this.mPicId)) - 1 : i3;
                e.this.drA = hVar.aMk();
                e.this.drB = hVar.aMl();
                if (e.this.iDc != null) {
                    e.this.iDc.a(e.this.iCU, position, e.this.iCZ, false, null, z, e.this.iDd, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.bcx() != null && fVar.bcx().length() > 0) {
            return fVar.bcx();
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

    public void pz(boolean z) {
        this.iDj = z;
    }
}
