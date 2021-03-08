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
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.AdExtParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes7.dex */
public class d {
    private String anU;
    private boolean dsO;
    private String eSQ;
    private String eSR;
    private String eVa;
    public String fFk;
    private Map<String, ImageUrlData> fxV;
    public ForumData jUi;
    private String jhW;
    public boolean kWA;
    private int kWB;
    private ArrayList<String> kWg;
    private ArrayList<AlaInfoData> kWi;
    private String kWj;
    private String kWk;
    private String kWs;
    private String kWt;
    private String kWu;
    private boolean kWv;
    private int kWx;
    public MetaData kWy;
    public String kWz;
    private String mForumId;
    private String mFrom;
    private boolean mIsReset;
    private String mPostId;
    private String mRecomAbTag;
    private String mRecomExtra;
    private String mRecomSource;
    private String mRecomWeight;
    private int mThreadType;
    private String mUserId;
    public int replyPrivateFlag;
    private HashMap<String, String> kWh = new HashMap<>();
    private boolean mIsReserver = true;
    private a kWl = null;
    private int kWm = 0;
    private boolean kWn = false;
    private boolean kWo = false;
    private b kWp = null;
    private AdvertAppInfo kWq = null;
    private boolean kWr = false;
    private boolean kWw = false;

    /* loaded from: classes7.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void bG(int i, String str);
    }

    public d(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        this.dsO = false;
        this.kWg = arrayList;
        this.fxV = map;
        if (this.kWg == null) {
            this.kWg = new ArrayList<>();
        }
        Iterator<String> it = this.kWg.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.kWh.put(com.baidu.tieba.image.b.Ny(next), next);
        }
        this.anU = str3;
        this.eVa = str4;
        this.jhW = str2;
        this.mForumId = str;
        this.kWk = str5;
        this.mThreadType = i;
        this.dsO = this.kWk == null;
        this.mUserId = str6;
        this.mFrom = str7;
        this.mIsReset = z;
        this.kWv = false;
        this.kWx = i2;
        this.mRecomSource = str8;
        this.mRecomAbTag = str9;
        this.mRecomWeight = str10;
        this.mRecomExtra = str11;
    }

    public void setSourceImageRectInScreen(String str) {
        this.kWt = str;
    }

    public void NA(String str) {
        this.kWu = str;
    }

    public void tu(boolean z) {
        this.kWv = z;
    }

    public String bpC() {
        return this.eSQ;
    }

    public String bpD() {
        return this.eSR;
    }

    public ArrayList<AlaInfoData> cZX() {
        return this.kWi;
    }

    public int cZY() {
        return this.kWB;
    }

    public void tv(boolean z) {
        this.mIsReserver = z;
    }

    public void cZZ() {
        this.kWr = false;
        if (!this.dsO) {
            c(this.anU, this.kWk, 10, 0);
        }
    }

    public void daa() {
        this.kWr = true;
        String str = this.kWg.get(0);
        if (StringUtils.isNull(this.kWj)) {
            this.kWj = com.baidu.tieba.image.b.Ny(str);
        }
        c(this.anU, this.kWj, 0, 10);
    }

    private void c(String str, String str2, int i, int i2) {
        if (this.kWl != null) {
            if (str2 == null || !str2.equals(this.kWl.getPicId())) {
                this.kWl.cancel();
            } else {
                return;
            }
        }
        this.kWl = new a(str, str2, i, i2);
        this.kWl.setPriority(3);
        this.kWl.execute(new Object[0]);
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void tw(boolean z) {
        this.kWn = z;
    }

    public void tx(boolean z) {
        this.kWo = z;
    }

    public void a(b bVar) {
        this.kWp = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private String anU;
        private aa cnM = null;
        private int kWC;
        private int kWD;
        private String mPicId;

        public a(String str, String str2, int i, int i2) {
            this.anU = null;
            this.mPicId = null;
            this.kWC = 0;
            this.kWD = 0;
            this.mPicId = str2;
            this.anU = str;
            this.kWC = i;
            this.kWD = i2;
        }

        public String getPicId() {
            return this.mPicId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public g doInBackground(Object... objArr) {
            this.cnM = new aa(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
            this.cnM.addPostData("kw", d.this.jhW);
            this.cnM.addPostData("tid", this.anU);
            if (this.mPicId != null) {
                this.cnM.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, this.mPicId);
            }
            if (!TextUtils.isEmpty(d.this.mPostId) && !"0".equals(d.this.mPostId)) {
                this.cnM.addPostData("post_id", d.this.mPostId);
            }
            this.cnM.addPostData("source", String.valueOf(d.this.kWo ? 1 : 2));
            d.this.kWo = false;
            this.cnM.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.kWC));
            this.cnM.addPostData("prev", String.valueOf(this.kWD));
            this.cnM.addPostData("not_see_lz", String.valueOf(d.this.kWn ? 0 : 1));
            this.cnM.addPostData("is_top_agree", String.valueOf(d.this.kWv ? 1 : 2));
            if (!d.this.mIsReserver) {
                this.cnM.addPostData("r", String.valueOf(1));
            }
            if (!StringUtils.isNull(d.this.mFrom, true)) {
                this.cnM.addPostData("obj_type", d.this.mFrom);
            } else {
                this.cnM.addPostData("obj_type", "other");
            }
            if (TextUtils.isEmpty(d.this.kWs)) {
                if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.brR().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                    d.this.kWs = com.baidu.tbadk.core.sharedPref.b.brR().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, "");
                }
            }
            this.cnM.addPostData("applist", d.this.kWs);
            String uF = com.baidu.helios.b.ai(TbadkCoreApplication.getInst()).uF();
            if (!TextUtils.isEmpty(uF)) {
                this.cnM.addPostData("oaid", uF);
            }
            this.cnM.addPostData("ad_ext_params", AdExtParam.a.bEY().bEZ());
            dab();
            this.cnM.bsu().btd().mNeedBackgroundLogin = false;
            String postNetData = this.cnM.postNetData();
            if (!this.cnM.bsu().bte().isRequestSuccess()) {
                return null;
            }
            g gVar = new g();
            gVar.aS(postNetData, true);
            return gVar;
        }

        private void dab() {
            this.cnM.addPostData("forum_id", d.this.mForumId);
            this.cnM.addPostData("user_id", d.this.mUserId == null ? "0" : d.this.mUserId);
            this.cnM.addPostData("scr_w", String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
            this.cnM.addPostData("scr_h", String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
            this.cnM.addPostData("q_type", String.valueOf(av.bsV().bsW() ? 2 : 1));
            this.cnM.addPostData("_os_version", Build.VERSION.RELEASE);
            this.cnM.addPostData("page_name", "PB");
            this.cnM.addPostData("pic_index", String.valueOf(d.this.kWg.size()));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.cnM != null) {
                this.cnM.cancelNetConnect();
            }
            d.this.kWl = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (d.this.fxV != null) {
                d.this.kWl = null;
                if (gVar == null) {
                    if (d.this.kWp != null) {
                        String str = null;
                        int i = -1;
                        if (this.cnM != null) {
                            i = this.cnM.getServerErrorCode();
                            if (this.mPicId == null) {
                                str = this.cnM.getErrorString();
                            }
                        }
                        d.this.kWp.bG(i, str);
                        return;
                    }
                    return;
                }
                boolean isEmpty = y.isEmpty(gVar.dak());
                if (d.this.mIsReset && !isEmpty) {
                    d.this.kWg.clear();
                    d.this.fxV.clear();
                    d.this.kWh.clear();
                }
                if (gVar.getImageNum() != 0) {
                    d.this.kWm = gVar.getImageNum();
                }
                d.this.kWq = gVar.blJ();
                d.this.kWB = gVar.kWB;
                d.this.fFk = gVar.fFk;
                d.this.replyPrivateFlag = gVar.dam();
                d.this.kWy = gVar.kWy;
                d.this.kWz = gVar.kWz;
                d.this.kWA = gVar.kWP == 1;
                if (this.mPicId == null) {
                    d.this.kWg.clear();
                    d.this.kWh.clear();
                }
                LinkedList<e> dak = gVar.dak();
                int size = dak.size();
                if (size <= 0) {
                    d.this.dsO = true;
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        e eVar = dak.get(i2);
                        String a2 = d.this.a(eVar);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.id = eVar.dac();
                        if (au.equals(imageUrlData.id, d.this.kWu)) {
                            imageUrlData.setSourceImageRectInScreen(d.this.kWt);
                        }
                        imageUrlData.imageUrl = a2;
                        String str2 = a2 + "*" + eVar.dag();
                        imageUrlData.urlType = 10;
                        imageUrlData.originalUrl = eVar.bHZ();
                        imageUrlData.originalSize = eVar.getOriginalSize();
                        imageUrlData.forumId = d.this.mForumId;
                        imageUrlData.forumName = d.this.jhW;
                        imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(this.anU, -1L);
                        imageUrlData.nid = d.this.eVa;
                        imageUrlData.postId = com.baidu.adp.lib.f.b.toLong(eVar.dad(), -1L);
                        imageUrlData.userId = eVar.getUserId();
                        imageUrlData.userNameShow = StringUtils.isNull(eVar.bzd()) ? eVar.getUserName() : eVar.bzd();
                        imageUrlData.mIsReserver = d.this.mIsReserver;
                        imageUrlData.mIsSeeHost = d.this.kWn;
                        imageUrlData.overAllIndex = eVar.dag();
                        imageUrlData.mThreadType = d.this.mThreadType;
                        imageUrlData.mPicType = eVar.getPicType();
                        imageUrlData.mTagName = eVar.getTagName();
                        imageUrlData.mIsShowOrigonButton = eVar.dae();
                        imageUrlData.isLongPic = eVar.isLongPic();
                        imageUrlData.isBlockedPic = eVar.daf();
                        imageUrlData.from = d.this.mFrom;
                        if (eVar.dai() != null) {
                            imageUrlData.richTextArray = eVar.dai().toString();
                        }
                        imageUrlData.isFirstPost = eVar.daj();
                        if (eVar.bpL() != null) {
                            imageUrlData.agreeData = eVar.bpL();
                            imageUrlData.agreeData.isFromImageViewer = true;
                            imageUrlData.agreeData.mImageViewerFromPage = d.this.mFrom;
                            imageUrlData.agreeData.forumId = d.this.mForumId;
                            imageUrlData.agreeData.threadId = String.valueOf(imageUrlData.threadId);
                            imageUrlData.agreeData.nid = imageUrlData.nid;
                            imageUrlData.agreeData.postId = String.valueOf(imageUrlData.postId);
                            imageUrlData.agreeData.indexOfPic = imageUrlData.overAllIndex;
                            imageUrlData.commentNum = eVar.dah();
                            if (eVar.daj()) {
                                imageUrlData.agreeData.objType = 3;
                                imageUrlData.agreeData.isInThread = true;
                                imageUrlData.agreeData.isInPost = false;
                            } else {
                                imageUrlData.agreeData.objType = 1;
                                imageUrlData.agreeData.isInThread = false;
                                imageUrlData.agreeData.isInPost = true;
                            }
                            imageUrlData.agreeData.cardType = d.this.kWx;
                            imageUrlData.agreeData.recomSource = d.this.mRecomSource;
                            imageUrlData.agreeData.recomAbTag = d.this.mRecomAbTag;
                            imageUrlData.agreeData.recomExtra = d.this.mRecomExtra;
                            imageUrlData.agreeData.recomWeight = d.this.mRecomWeight;
                        }
                        if (d.this.kWh.containsKey(imageUrlData.id)) {
                            String str3 = (String) d.this.kWh.get(imageUrlData.id);
                            ImageUrlData imageUrlData2 = (ImageUrlData) d.this.fxV.get(str3);
                            if (imageUrlData2 == null) {
                                d.this.fxV.put(str3, imageUrlData);
                            } else {
                                imageUrlData2.imageUrl = imageUrlData.imageUrl;
                                imageUrlData2.overAllIndex = imageUrlData.overAllIndex;
                                imageUrlData2.mIsShowOrigonButton = imageUrlData.mIsShowOrigonButton;
                                imageUrlData2.isLongPic = imageUrlData.isLongPic;
                                imageUrlData2.richTextArray = imageUrlData.richTextArray;
                                imageUrlData2.commentNum = imageUrlData.commentNum;
                                imageUrlData2.agreeData = imageUrlData.agreeData;
                                imageUrlData2.isFirstPost = imageUrlData.isFirstPost;
                                imageUrlData2.userId = imageUrlData.userId;
                                imageUrlData2.userNameShow = imageUrlData.userNameShow;
                                imageUrlData2.forumId = d.this.mForumId;
                                imageUrlData2.forumName = d.this.jhW;
                                if (au.equals(imageUrlData.id, d.this.kWu)) {
                                    imageUrlData2.setSourceImageRectInScreen(d.this.kWt);
                                }
                            }
                        } else if (d.this.kWw) {
                            d.this.kWm = d.this.fxV.size();
                            d.this.kWq = null;
                        } else {
                            d.this.fxV.put(str2, imageUrlData);
                            if (d.this.kWr) {
                                d.this.kWg.add(i2, str2);
                            } else {
                                d.this.kWg.add(str2);
                            }
                            d.this.kWh.put(imageUrlData.id, str2);
                        }
                    }
                    e eVar2 = (e) y.getItem(dak, 0);
                    if (eVar2 != null) {
                        d.this.kWj = eVar2.dac();
                    }
                    e eVar3 = (e) y.getItem(dak, size - 1);
                    if (eVar3 != null) {
                        d.this.kWk = eVar3.dac();
                        d.this.dsO = ((long) d.this.kWm) == eVar3.dag();
                    }
                }
                ImageUrlData imageUrlData3 = null;
                for (ImageUrlData imageUrlData4 : d.this.fxV.values()) {
                    if (imageUrlData4.agreeData == null) {
                        long j = imageUrlData4.postId;
                        if (imageUrlData3 == null) {
                            for (ImageUrlData imageUrlData5 : d.this.fxV.values()) {
                                if (imageUrlData5.postId != j || imageUrlData5.agreeData == null) {
                                    imageUrlData5 = imageUrlData3;
                                } else {
                                    imageUrlData4.agreeData = imageUrlData5.agreeData;
                                    imageUrlData4.richTextArray = imageUrlData5.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData5.commentNum;
                                    imageUrlData4.userId = imageUrlData5.userId;
                                    imageUrlData4.userNameShow = imageUrlData5.userNameShow;
                                    imageUrlData4.forumId = d.this.mForumId;
                                    imageUrlData4.forumName = d.this.jhW;
                                }
                                imageUrlData3 = imageUrlData5;
                            }
                        } else if (j == imageUrlData3.postId) {
                            imageUrlData4.agreeData = imageUrlData3.agreeData;
                            imageUrlData4.richTextArray = imageUrlData3.richTextArray;
                            imageUrlData4.commentNum = imageUrlData3.commentNum;
                            imageUrlData4.userId = imageUrlData3.userId;
                            imageUrlData4.userNameShow = imageUrlData3.userNameShow;
                            imageUrlData4.forumId = d.this.mForumId;
                            imageUrlData4.forumName = d.this.jhW;
                        }
                    }
                }
                boolean z = false;
                int i3 = -1;
                if (this.mPicId == null) {
                    i3 = 0;
                    d.this.anU = this.anU;
                    z = true;
                }
                int position = d.this.kWr ? y.getPosition(d.this.kWg, (String) d.this.kWh.get(this.mPicId)) - 1 : i3;
                d.this.eSQ = gVar.bpC();
                d.this.eSR = gVar.bpD();
                d.this.jUi = gVar.bCn();
                if (d.this.kWi == null) {
                    d.this.kWi = new ArrayList();
                    if (gVar.dal() != null && gVar.dak().size() > 0) {
                        d.this.kWi.addAll(gVar.dal());
                    }
                }
                if (d.this.kWp != null) {
                    d.this.kWp.a(d.this.kWg, position, d.this.kWm, false, null, z, d.this.kWq, isEmpty);
                }
                d.this.mIsReset = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(e eVar) {
        if (eVar.bHT() != null && eVar.bHT().length() > 0) {
            return eVar.bHT();
        }
        StringBuilder sb = new StringBuilder(150);
        int threadImageMaxWidth = TbConfig.getThreadImageMaxWidth();
        if (eVar.getHeight() * eVar.getWidth() > threadImageMaxWidth * threadImageMaxWidth) {
            double sqrt = Math.sqrt((threadImageMaxWidth * threadImageMaxWidth) / (eVar.getHeight() * eVar.getWidth()));
            sb.append("width=");
            sb.append(String.valueOf((int) (eVar.getWidth() * sqrt)));
            sb.append("&height=");
            sb.append(String.valueOf((int) (sqrt * eVar.getHeight())));
        } else {
            sb.append("width=");
            sb.append(String.valueOf(eVar.getWidth()));
            sb.append("&height=");
            sb.append(String.valueOf(eVar.getHeight()));
        }
        sb.append("&src=");
        sb.append(au.getUrlEncode(eVar.getImageUrl()));
        return sb.toString();
    }

    public void ty(boolean z) {
        this.kWw = z;
    }
}
