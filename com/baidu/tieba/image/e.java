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
    private String cSd;
    private String cSe;
    private Map<String, ImageUrlData> drI;
    private boolean eev;
    private String goe;
    private String hRC;
    private String hRD;
    private String hRE;
    private boolean hRF;
    private ArrayList<String> hRr;
    private String hRt;
    private String hRu;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private String mPostId;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> hRs = new HashMap<>();
    private boolean mIsReserver = true;
    private a hRv = null;
    private int hRw = 0;
    private boolean hRx = false;
    private boolean hRy = false;
    private b hRz = null;
    private AdvertAppInfo hRA = null;
    private boolean hRB = false;
    private boolean hRG = false;

    /* loaded from: classes8.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void aL(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eev = false;
        this.hRr = arrayList;
        this.drI = map;
        if (this.hRr == null) {
            this.hRr = new ArrayList<>();
        }
        Iterator<String> it = this.hRr.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.hRs.put(d.DN(next), next);
        }
        this.Pj = str3;
        this.goe = str2;
        this.mForumId = str;
        this.hRu = str4;
        this.mThreadType = i;
        this.eev = this.hRu == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.hRF = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.hRD = str;
    }

    public void DP(String str) {
        this.hRE = str;
    }

    public void ol(boolean z) {
        this.hRF = z;
    }

    public String aDS() {
        return this.cSd;
    }

    public String aDT() {
        return this.cSe;
    }

    public void om(boolean z) {
        this.mIsReserver = z;
    }

    public void cak() {
        this.hRB = false;
        if (!this.eev) {
            d(this.Pj, this.hRu, 10, 0);
        }
    }

    public void cal() {
        this.hRB = true;
        String str = this.hRr.get(0);
        if (StringUtils.isNull(this.hRt)) {
            this.hRt = d.DN(str);
        }
        d(this.Pj, this.hRt, 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.hRv != null) {
            if (str2 == null || !str2.equals(this.hRv.getPicId())) {
                this.hRv.cancel();
            } else {
                return;
            }
        }
        this.hRv = new a(str, str2, i, i2);
        this.hRv.setPriority(3);
        this.hRv.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void on(boolean z) {
        this.hRx = z;
    }

    public void oo(boolean z) {
        this.hRy = z;
    }

    public void a(b bVar) {
        this.hRz = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String Pj;
        private x cLE = null;
        private int hRH;
        private int hRI;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.Pj = null;
            this.mPicId = null;
            this.hRH = 0;
            this.hRI = 0;
            this.mPicId = str2;
            this.Pj = str;
            this.hRH = i;
            this.hRI = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public h doInBackground(Object... objArr) {
            this.cLE = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.cLE.addPostData("kw", e.this.goe);
            this.cLE.addPostData("tid", this.Pj);
            if (this.mPicId != null) {
                this.cLE.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.cLE.addPostData("post_id", e.this.mPostId);
            }
            this.cLE.addPostData("source", String.valueOf(e.this.hRy ? 1 : 2));
            e.this.hRy = false;
            this.cLE.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.hRH));
            this.cLE.addPostData("prev", String.valueOf(this.hRI));
            this.cLE.addPostData("not_see_lz", String.valueOf(e.this.hRx ? 0 : 1));
            this.cLE.addPostData("is_top_agree", String.valueOf(e.this.hRF ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.cLE.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.cLE.addPostData("obj_type", e.this.mFrom);
            } else {
                this.cLE.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.hRC)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.hRC = com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.cLE.addPostData("applist", e.this.hRC);
            String aSl = w.aSl();
            if (!TextUtils.isEmpty(aSl)) {
                this.cLE.addPostData("oaid", aSl);
            }
            cam();
            this.cLE.aGg().aGH().mNeedBackgroundLogin = false;
            String postNetData = this.cLE.postNetData();
            if (!this.cLE.aGg().aGI().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.ap(postNetData, true);
            return hVar;
        }

        private void cam() {
            this.cLE.addPostData("forum_id", e.this.mForumId);
            this.cLE.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.cLE.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.cLE.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.cLE.addPostData("q_type", String.valueOf(ar.aGD().aGE() ? 2 : 1));
            this.cLE.addPostData("_os_version", Build.VERSION.RELEASE);
            this.cLE.addPostData("page_name", "PB");
            this.cLE.addPostData("pic_index", String.valueOf(e.this.hRr.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.cLE != null) {
                this.cLE.cancelNetConnect();
            }
            e.this.hRv = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.drI != null) {
                e.this.hRv = null;
                if (hVar == null) {
                    if (e.this.hRz != null) {
                        String str = null;
                        int i = -1;
                        if (this.cLE != null) {
                            i = this.cLE.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.cLE.getErrorString();
                            }
                        }
                        e.this.hRz.aL(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = v.isEmpty(hVar.cav());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.hRr.clear();
                    e.this.drI.clear();
                    e.this.hRs.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.hRw = hVar.getImageNum();
                }
                e.this.hRA = hVar.caw();
                if (this.mPicId == null) {
                    e.this.hRr.clear();
                    e.this.hRs.clear();
                }
                LinkedList<f> cav = hVar.cav();
                int size = cav.size();
                if (size <= 0) {
                    e.this.eev = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = cav.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.can();
                        if (aq.equals(imageUrlData.id, e.this.hRE)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.hRD);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.car();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.aUo();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.Pj, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.cao(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.hRx;
                        imageUrlData.overAllIndex = fVar.car();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.cap();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.caq();
                        if (fVar.cat() != null) {
                            imageUrlData.richTextArray = fVar.cat().toString();
                        }
                        imageUrlData.isFirstPost = fVar.cau();
                        if (fVar.aEa() != null) {
                            imageUrlData.agreeData = fVar.aEa();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.cas();
                            if (fVar.cau()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.hRs.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.hRs.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.drI.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.drI.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (aq.equals(imageUrlData.id, e.this.hRE)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.hRD);
                                }
                            }
                        } else if (e.this.hRG) {
                            e.this.hRw = e.this.drI.size();
                            e.this.hRA = null;
                        } else {
                            e.this.drI.put(str2, imageUrlData);
                            if (e.this.hRB) {
                                e.this.hRr.add(i2, str2);
                            } else {
                                e.this.hRr.add(str2);
                            }
                            e.this.hRs.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.getItem(cav, 0);
                    if (fVar2 != null) {
                        e.this.hRt = fVar2.can();
                    }
                    f fVar3 = (f) v.getItem(cav, size - 1);
                    if (fVar3 != null) {
                        e.this.hRu = fVar3.can();
                        e.this.eev = ((long) e.this.hRw) == fVar3.car();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.drI.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.drI.values()) {
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
                int position = e.this.hRB ? v.getPosition(e.this.hRr, (String) e.this.hRs.get(this.mPicId)) - 1 : i3;
                e.this.cSd = hVar.aDS();
                e.this.cSe = hVar.aDT();
                if (e.this.hRz != null) {
                    e.this.hRz.a(e.this.hRr, position, e.this.hRw, false, null, z, e.this.hRA, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.aUi() != null && fVar.aUi().length() > 0) {
            return fVar.aUi();
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
        this.hRG = z;
    }
}
