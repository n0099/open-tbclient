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
    private String cSc;
    private String cSd;
    private Map<String, ImageUrlData> drH;
    private boolean eeu;
    private String goc;
    private String hRA;
    private String hRB;
    private String hRC;
    private boolean hRD;
    private ArrayList<String> hRp;
    private String hRr;
    private String hRs;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private String mPostId;
    private int mThreadType;
    private String mUserId;
    private HashMap<String, String> hRq = new HashMap<>();
    private boolean mIsReserver = true;
    private a hRt = null;
    private int hRu = 0;
    private boolean hRv = false;
    private boolean hRw = false;
    private b hRx = null;
    private AdvertAppInfo hRy = null;
    private boolean hRz = false;
    private boolean hRE = false;

    /* loaded from: classes8.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void aL(int i, String str);
    }

    public e(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z) {
        this.eeu = false;
        this.hRp = arrayList;
        this.drH = map;
        if (this.hRp == null) {
            this.hRp = new ArrayList<>();
        }
        Iterator<String> it = this.hRp.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.hRq.put(d.DN(next), next);
        }
        this.Pj = str3;
        this.goc = str2;
        this.mForumId = str;
        this.hRs = str4;
        this.mThreadType = i;
        this.eeu = this.hRs == null;
        this.mUserId = str5;
        this.mFrom = str6;
        this.mIsReset = z;
        this.hRD = false;
    }

    public void setSourceImageRectInScreen(String str) {
        this.hRB = str;
    }

    public void DP(String str) {
        this.hRC = str;
    }

    public void ol(boolean z) {
        this.hRD = z;
    }

    public String aDQ() {
        return this.cSc;
    }

    public String aDR() {
        return this.cSd;
    }

    public void om(boolean z) {
        this.mIsReserver = z;
    }

    public void cai() {
        this.hRz = false;
        if (!this.eeu) {
            d(this.Pj, this.hRs, 10, 0);
        }
    }

    public void caj() {
        this.hRz = true;
        String str = this.hRp.get(0);
        if (StringUtils.isNull(this.hRr)) {
            this.hRr = d.DN(str);
        }
        d(this.Pj, this.hRr, 0, 10);
    }

    private void d(String str, String str2, int i, int i2) {
        if (this.hRt != null) {
            if (str2 == null || !str2.equals(this.hRt.getPicId())) {
                this.hRt.cancel();
            } else {
                return;
            }
        }
        this.hRt = new a(str, str2, i, i2);
        this.hRt.setPriority(3);
        this.hRt.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void on(boolean z) {
        this.hRv = z;
    }

    public void oo(boolean z) {
        this.hRw = z;
    }

    public void a(b bVar) {
        this.hRx = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, h> {
        private String Pj;
        private x cLD = null;
        private int hRF;
        private int hRG;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.Pj = null;
            this.mPicId = null;
            this.hRF = 0;
            this.hRG = 0;
            this.mPicId = str2;
            this.Pj = str;
            this.hRF = i;
            this.hRG = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public h doInBackground(Object... objArr) {
            this.cLD = new x(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.cLD.addPostData("kw", e.this.goc);
            this.cLD.addPostData("tid", this.Pj);
            if (this.mPicId != null) {
                this.cLD.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(e.this.mPostId) && !"0".equals(e.this.mPostId)) {
                this.cLD.addPostData("post_id", e.this.mPostId);
            }
            this.cLD.addPostData("source", String.valueOf(e.this.hRw ? 1 : 2));
            e.this.hRw = false;
            this.cLD.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.hRF));
            this.cLD.addPostData("prev", String.valueOf(this.hRG));
            this.cLD.addPostData("not_see_lz", String.valueOf(e.this.hRv ? 0 : 1));
            this.cLD.addPostData("is_top_agree", String.valueOf(e.this.hRD ? 1 : 2));
            if (!e.this.mIsReserver) {
                this.cLD.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(e.this.mFrom, true)) {
                this.cLD.addPostData("obj_type", e.this.mFrom);
            } else {
                this.cLD.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(e.this.hRA)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aFB().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    e.this.hRA = com.baidu.tbadk.core.sharedPref.b.aFB().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.cLD.addPostData("applist", e.this.hRA);
            String aSj = w.aSj();
            if (!TextUtils.isEmpty(aSj)) {
                this.cLD.addPostData("oaid", aSj);
            }
            cak();
            this.cLD.aGe().aGF().mNeedBackgroundLogin = false;
            String postNetData = this.cLD.postNetData();
            if (!this.cLD.aGe().aGG().isRequestSuccess()) {
                return null;
            }
            h hVar = new h();
            hVar.ap(postNetData, true);
            return hVar;
        }

        private void cak() {
            this.cLD.addPostData("forum_id", e.this.mForumId);
            this.cLD.addPostData("user_id", e.this.mUserId == null ? "0" : e.this.mUserId);
            this.cLD.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.cLD.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.cLD.addPostData("q_type", String.valueOf(ar.aGB().aGC() ? 2 : 1));
            this.cLD.addPostData("_os_version", Build.VERSION.RELEASE);
            this.cLD.addPostData("page_name", "PB");
            this.cLD.addPostData("pic_index", String.valueOf(e.this.hRp.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.cLD != null) {
                this.cLD.cancelNetConnect();
            }
            e.this.hRt = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(h hVar) {
            super.onPostExecute(hVar);
            if (e.this.drH != null) {
                e.this.hRt = null;
                if (hVar == null) {
                    if (e.this.hRx != null) {
                        String str = null;
                        int i = -1;
                        if (this.cLD != null) {
                            i = this.cLD.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.cLD.getErrorString();
                            }
                        }
                        e.this.hRx.aL(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = v.isEmpty(hVar.cat());
                if (e.this.mIsReset && !isEmpty) {
                    e.this.hRp.clear();
                    e.this.drH.clear();
                    e.this.hRq.clear();
                }
                if (hVar.getImageNum() != 0) {
                    e.this.hRu = hVar.getImageNum();
                }
                e.this.hRy = hVar.cau();
                if (this.mPicId == null) {
                    e.this.hRp.clear();
                    e.this.hRq.clear();
                }
                LinkedList<f> cat = hVar.cat();
                int size = cat.size();
                if (size <= 0) {
                    e.this.eeu = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        f fVar = cat.get(i2);
                        String a = e.this.a(fVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = fVar.cal();
                        if (aq.equals(imageUrlData.id, e.this.hRC)) {
                            imageUrlData.setSourceImageRectInScreen(e.this.hRB);
                        }
                        imageUrlData.imageUrl = a;
                        String str2 = a + "*" + fVar.cap();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = fVar.aUm();
                        imageUrlData.originalSize = fVar.getOriginalSize();
                        imageUrlData.forumId = e.this.mForumId;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.Pj, -1L);
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(fVar.cam(), -1L);
                        imageUrlData.mIsReserver = e.this.mIsReserver;
                        imageUrlData.mIsSeeHost = e.this.hRv;
                        imageUrlData.overAllIndex = fVar.cap();
                        imageUrlData.mThreadType = e.this.mThreadType;
                        imageUrlData.mPicType = fVar.getPicType();
                        imageUrlData.mTagName = fVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = fVar.can();
                        imageUrlData.isLongPic = fVar.isLongPic();
                        imageUrlData.isBlockedPic = fVar.cao();
                        if (fVar.car() != null) {
                            imageUrlData.richTextArray = fVar.car().toString();
                        }
                        imageUrlData.isFirstPost = fVar.cas();
                        if (fVar.aDY() != null) {
                            imageUrlData.agreeData = fVar.aDY();
                            imageUrlData.agreeData.forumId = e.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = fVar.caq();
                            if (fVar.cas()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                        }
                        if (e.this.hRq.containsKey(imageUrlData.id)) {
                            String str3 = (String) e.this.hRq.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) e.this.drH.get(str3);
                            if (imageUrlData2 == null) {
                                e.this.drH.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                if (aq.equals(imageUrlData.id, e.this.hRC)) {
                                    imageUrlData2.setSourceImageRectInScreen(e.this.hRB);
                                }
                            }
                        } else if (e.this.hRE) {
                            e.this.hRu = e.this.drH.size();
                            e.this.hRy = null;
                        } else {
                            e.this.drH.put(str2, imageUrlData);
                            if (e.this.hRz) {
                                e.this.hRp.add(i2, str2);
                            } else {
                                e.this.hRp.add(str2);
                            }
                            e.this.hRq.put(imageUrlData.id, str2);
                        }
                    }
                    f fVar2 = (f) v.getItem(cat, 0);
                    if (fVar2 != null) {
                        e.this.hRr = fVar2.cal();
                    }
                    f fVar3 = (f) v.getItem(cat, size - 1);
                    if (fVar3 != null) {
                        e.this.hRs = fVar3.cal();
                        e.this.eeu = ((long) e.this.hRu) == fVar3.cap();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : e.this.drH.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : e.this.drH.values()) {
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
                int position = e.this.hRz ? v.getPosition(e.this.hRp, (String) e.this.hRq.get(this.mPicId)) - 1 : i3;
                e.this.cSc = hVar.aDQ();
                e.this.cSd = hVar.aDR();
                if (e.this.hRx != null) {
                    e.this.hRx.a(e.this.hRp, position, e.this.hRu, false, null, z, e.this.hRy, isEmpty);
                }
                e.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(f fVar) {
        if (fVar.aUg() != null && fVar.aUg().length() > 0) {
            return fVar.aUg();
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
        this.hRE = z;
    }
}
