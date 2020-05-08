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
    private String ahO;
    private Map<String, ImageUrlData> dSj;
    private String drE;
    private String drF;
    private boolean eET;
    private String gYo;
    private ArrayList<String> iDa;
    private String iDc;
    private String iDd;
    private String iDl;
    private String iDm;
    private String iDn;
    private boolean iDo;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private String mPostId;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> iDb = new HashMap<>();
    private boolean mIsReserver = true;
    private a iDe = null;
    private int iDf = 0;
    private boolean iDg = false;
    private boolean iDh = false;
    private b iDi = null;
    private AdvertAppInfo iDj = null;
    private boolean iDk = false;
    private boolean iDp = false;

    /* loaded from: classes8.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void ba(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eET = false;
        this.iDa = arrayList;
        this.dSj = map;
        if (this.iDa == null) {
            this.iDa = new ArrayList<>();
        }
        Iterator<String> it = this.iDa.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.iDb.put(d.Fz(next), next);
        }
        this.ahO = str3;
        this.gYo = str2;
        this.mForumId = str;
        this.iDd = str4;
        this.mThreadType = i;
        this.eET = this.iDd == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.iDo = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.iDm = str;
    }

    public void FB(String str) {
        this.iDn = str;
    }

    public void pv(boolean z) {
        this.iDo = z;
    }

    public String aMi() {
        return this.drE;
    }

    public String aMj() {
        return this.drF;
    }

    public void pw(boolean z) {
        this.mIsReserver = z;
    }

    public void cld() {
        this.iDk = false;
        if (!this.eET) {
            d(this.ahO, this.iDd, 10, 0);
        }
    }

    public void cle() {
        this.iDk = true;
        String str = this.iDa.get(0);
        if (StringUtils.isNull(this.iDc)) {
            this.iDc = d.Fz(str);
        }
        d(this.ahO, this.iDc, 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.iDe != null) {
            if (str2 == null || !str2.equals(this.iDe.getPicId())) {
                this.iDe.cancel();
            } else {
                return;
            }
        }
        this.iDe = new a(str, str2, i, i2);
        this.iDe.setPriority(3);
        this.iDe.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void px(boolean z) {
        this.iDg = z;
    }

    public void py(boolean z) {
        this.iDh = z;
    }

    public void a(b bVar) {
        this.iDi = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String ahO;
        private x blK = null;
        private int iDq;
        private int iDr;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.ahO = null;
            this.mPicId = null;
            this.iDq = 0;
            this.iDr = 0;
            this.mPicId = str2;
            this.ahO = str;
            this.iDq = i;
            this.iDr = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public h doInBackground(Object... objArr) {
            this.blK = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.blK.addPostData("kw", e.this.gYo);
            this.blK.addPostData("tid", this.ahO);
            if (this.mPicId != null) {
                this.blK.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.blK.addPostData("post_id", e.this.mPostId);
            }
            this.blK.addPostData("source", String.valueOf(e.this.iDh ? 1 : 2));
            e.this.iDh = false;
            this.blK.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.iDq));
            this.blK.addPostData("prev", String.valueOf(this.iDr));
            this.blK.addPostData("not_see_lz", String.valueOf(e.this.iDg ? 0 : 1));
            this.blK.addPostData("is_top_agree", String.valueOf(e.this.iDo ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.blK.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.blK.addPostData("obj_type", e.this.mFrom);
            } else {
                this.blK.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.iDl)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aNT().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.iDl = com.baidu.tbadk.core.sharedPref.b.aNT().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.blK.addPostData("applist", e.this.iDl);
            String bax = w.bax();
            if (!TextUtils.isEmpty(bax)) {
                this.blK.addPostData("oaid", bax);
            }
            clf();
            this.blK.aOw().aOW().mNeedBackgroundLogin = false;
            String postNetData = this.blK.postNetData();
            if (!this.blK.aOw().aOX().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.av(postNetData, true);
            return hVar;
        }

        private void clf() {
            this.blK.addPostData("forum_id", e.this.mForumId);
            this.blK.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.blK.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.blK.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.blK.addPostData("q_type", String.valueOf(ar.aOS().aOT() ? 2 : 1));
            this.blK.addPostData("_os_version", Build.VERSION.RELEASE);
            this.blK.addPostData("page_name", "PB");
            this.blK.addPostData("pic_index", String.valueOf(e.this.iDa.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.blK != null) {
                this.blK.cancelNetConnect();
            }
            e.this.iDe = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.dSj != null) {
                e.this.iDe = null;
                if (hVar == null) {
                    if (e.this.iDi != null) {
                        String str = null;
                        int i = -1;
                        if (this.blK != null) {
                            i = this.blK.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.blK.getErrorString();
                            }
                        }
                        e.this.iDi.ba(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = v.isEmpty(hVar.clo());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.iDa.clear();
                    e.this.dSj.clear();
                    e.this.iDb.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.iDf = hVar.getImageNum();
                }
                e.this.iDj = hVar.clp();
                if (this.mPicId == null) {
                    e.this.iDa.clear();
                    e.this.iDb.clear();
                }
                LinkedList<f> clo = hVar.clo();
                int size = clo.size();
                if (size <= 0) {
                    e.this.eET = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = clo.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.clg();
                        if (aq.equals(imageUrlData.id, e.this.iDn)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.iDm);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.clk();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.bcB();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.ahO, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.clh(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.iDg;
                        imageUrlData.overAllIndex = fVar.clk();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.cli();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.clj();
                        if (fVar.clm() != null) {
                            imageUrlData.richTextArray = fVar.clm().toString();
                        }
                        imageUrlData.isFirstPost = fVar.cln();
                        if (fVar.aMq() != null) {
                            imageUrlData.agreeData = fVar.aMq();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.cll();
                            if (fVar.cln()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.iDb.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.iDb.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.dSj.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.dSj.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (aq.equals(imageUrlData.id, e.this.iDn)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.iDm);
                                }
                            }
                        } else if (e.this.iDp) {
                            e.this.iDf = e.this.dSj.size();
                            e.this.iDj = null;
                        } else {
                            e.this.dSj.put(str2, imageUrlData);
                            if (e.this.iDk) {
                                e.this.iDa.add(i2, str2);
                            } else {
                                e.this.iDa.add(str2);
                            }
                            e.this.iDb.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.getItem(clo, 0);
                    if (fVar2 != null) {
                        e.this.iDc = fVar2.clg();
                    }
                    f fVar3 = (f) v.getItem(clo, size - 1);
                    if (fVar3 != null) {
                        e.this.iDd = fVar3.clg();
                        e.this.eET = ((long) e.this.iDf) == fVar3.clk();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.dSj.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.dSj.values()) {
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
                    e.this.ahO = this.ahO;
                    z = true;
                }
                int position = e.this.iDk ? v.getPosition(e.this.iDa, (String) e.this.iDb.get(this.mPicId)) - 1 : i3;
                e.this.drE = hVar.aMi();
                e.this.drF = hVar.aMj();
                if (e.this.iDi != null) {
                    e.this.iDi.a(e.this.iDa, position, e.this.iDf, false, null, z, e.this.iDj, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.bcv() != null && fVar.bcv().length() > 0) {
            return fVar.bcv();
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
        this.iDp = z;
    }
}
