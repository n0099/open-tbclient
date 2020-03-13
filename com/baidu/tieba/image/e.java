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
    private String Pj;
    private String cSe;
    private String cSf;
    private Map<String, ImageUrlData> drV;
    private boolean eeI;
    private String gor;
    private ArrayList<String> hRD;
    private String hRF;
    private String hRG;
    private String hRO;
    private String hRP;
    private String hRQ;
    private boolean hRR;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private String mPostId;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> hRE = new HashMap<>();
    private boolean mIsReserver = true;
    private a hRH = null;
    private int hRI = 0;
    private boolean hRJ = false;
    private boolean hRK = false;
    private b hRL = null;
    private AdvertAppInfo hRM = null;
    private boolean hRN = false;
    private boolean hRS = false;

    /* loaded from: classes8.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void aL(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eeI = false;
        this.hRD = arrayList;
        this.drV = map;
        if (this.hRD == null) {
            this.hRD = new ArrayList<>();
        }
        Iterator<String> it = this.hRD.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.hRE.put(d.DO(next), next);
        }
        this.Pj = str3;
        this.gor = str2;
        this.mForumId = str;
        this.hRG = str4;
        this.mThreadType = i;
        this.eeI = this.hRG == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.hRR = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.hRP = str;
    }

    public void DQ(String str) {
        this.hRQ = str;
    }

    public void ol(boolean z) {
        this.hRR = z;
    }

    public String aDS() {
        return this.cSe;
    }

    public String aDT() {
        return this.cSf;
    }

    public void om(boolean z) {
        this.mIsReserver = z;
    }

    public void cal() {
        this.hRN = false;
        if (!this.eeI) {
            d(this.Pj, this.hRG, 10, 0);
        }
    }

    public void cam() {
        this.hRN = true;
        String str = this.hRD.get(0);
        if (StringUtils.isNull(this.hRF)) {
            this.hRF = d.DO(str);
        }
        d(this.Pj, this.hRF, 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.hRH != null) {
            if (str2 == null || !str2.equals(this.hRH.getPicId())) {
                this.hRH.cancel();
            } else {
                return;
            }
        }
        this.hRH = new a(str, str2, i, i2);
        this.hRH.setPriority(3);
        this.hRH.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void on(boolean z) {
        this.hRJ = z;
    }

    public void oo(boolean z) {
        this.hRK = z;
    }

    public void a(b bVar) {
        this.hRL = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String Pj;
        private x cLF = null;
        private int hRT;
        private int hRU;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.Pj = null;
            this.mPicId = null;
            this.hRT = 0;
            this.hRU = 0;
            this.mPicId = str2;
            this.Pj = str;
            this.hRT = i;
            this.hRU = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public h doInBackground(Object... objArr) {
            this.cLF = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.cLF.addPostData("kw", e.this.gor);
            this.cLF.addPostData("tid", this.Pj);
            if (this.mPicId != null) {
                this.cLF.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.cLF.addPostData("post_id", e.this.mPostId);
            }
            this.cLF.addPostData("source", String.valueOf(e.this.hRK ? 1 : 2));
            e.this.hRK = false;
            this.cLF.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.hRT));
            this.cLF.addPostData("prev", String.valueOf(this.hRU));
            this.cLF.addPostData("not_see_lz", String.valueOf(e.this.hRJ ? 0 : 1));
            this.cLF.addPostData("is_top_agree", String.valueOf(e.this.hRR ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.cLF.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.cLF.addPostData("obj_type", e.this.mFrom);
            } else {
                this.cLF.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.hRO)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.hRO = com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.cLF.addPostData("applist", e.this.hRO);
            String aSm = w.aSm();
            if (!TextUtils.isEmpty(aSm)) {
                this.cLF.addPostData("oaid", aSm);
            }
            can();
            this.cLF.aGg().aGH().mNeedBackgroundLogin = false;
            String postNetData = this.cLF.postNetData();
            if (!this.cLF.aGg().aGI().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.ap(postNetData, true);
            return hVar;
        }

        private void can() {
            this.cLF.addPostData("forum_id", e.this.mForumId);
            this.cLF.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.cLF.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.cLF.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.cLF.addPostData("q_type", String.valueOf(ar.aGD().aGE() ? 2 : 1));
            this.cLF.addPostData("_os_version", Build.VERSION.RELEASE);
            this.cLF.addPostData("page_name", "PB");
            this.cLF.addPostData("pic_index", String.valueOf(e.this.hRD.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.cLF != null) {
                this.cLF.cancelNetConnect();
            }
            e.this.hRH = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.drV != null) {
                e.this.hRH = null;
                if (hVar == null) {
                    if (e.this.hRL != null) {
                        String str = null;
                        int i = -1;
                        if (this.cLF != null) {
                            i = this.cLF.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.cLF.getErrorString();
                            }
                        }
                        e.this.hRL.aL(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = v.isEmpty(hVar.caw());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.hRD.clear();
                    e.this.drV.clear();
                    e.this.hRE.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.hRI = hVar.getImageNum();
                }
                e.this.hRM = hVar.cax();
                if (this.mPicId == null) {
                    e.this.hRD.clear();
                    e.this.hRE.clear();
                }
                LinkedList<f> caw = hVar.caw();
                int size = caw.size();
                if (size <= 0) {
                    e.this.eeI = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = caw.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.cao();
                        if (aq.equals(imageUrlData.id, e.this.hRQ)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.hRP);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.cas();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.aUp();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.Pj, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.cap(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.hRJ;
                        imageUrlData.overAllIndex = fVar.cas();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.caq();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.car();
                        if (fVar.cau() != null) {
                            imageUrlData.richTextArray = fVar.cau().toString();
                        }
                        imageUrlData.isFirstPost = fVar.cav();
                        if (fVar.aEa() != null) {
                            imageUrlData.agreeData = fVar.aEa();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.cat();
                            if (fVar.cav()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.hRE.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.hRE.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.drV.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.drV.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (aq.equals(imageUrlData.id, e.this.hRQ)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.hRP);
                                }
                            }
                        } else if (e.this.hRS) {
                            e.this.hRI = e.this.drV.size();
                            e.this.hRM = null;
                        } else {
                            e.this.drV.put(str2, imageUrlData);
                            if (e.this.hRN) {
                                e.this.hRD.add(i2, str2);
                            } else {
                                e.this.hRD.add(str2);
                            }
                            e.this.hRE.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.getItem(caw, 0);
                    if (fVar2 != null) {
                        e.this.hRF = fVar2.cao();
                    }
                    f fVar3 = (f) v.getItem(caw, size - 1);
                    if (fVar3 != null) {
                        e.this.hRG = fVar3.cao();
                        e.this.eeI = ((long) e.this.hRI) == fVar3.cas();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.drV.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.drV.values()) {
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
                    e.this.Pj = this.Pj;
                    z = true;
                }
                int position = e.this.hRN ? v.getPosition(e.this.hRD, (String) e.this.hRE.get(this.mPicId)) - 1 : i3;
                e.this.cSe = hVar.aDS();
                e.this.cSf = hVar.aDT();
                if (e.this.hRL != null) {
                    e.this.hRL.a(e.this.hRD, position, e.this.hRI, false, null, z, e.this.hRM, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.aUj() != null && fVar.aUj().length() > 0) {
            return fVar.aUj();
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

    public void op(boolean z) {
        this.hRS = z;
    }
}
