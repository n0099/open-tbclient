package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes6.dex */
public class kc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public String B;
    public boolean C;
    public boolean D;
    public String E;
    public String F;
    public int G;
    public String H;
    public String I;
    public String J;
    public String K;
    public String L;
    public int M;
    public MetaData N;
    public String O;
    public boolean P;
    public ForumData Q;
    public int R;
    public final HashSet<String> S;
    public ArrayList<String> a;
    public HashMap<String, String> b;
    public Map<String, ImageUrlData> c;
    public ArrayList<AlaInfoData> d;
    public ArrayList<yc8> e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public boolean n;
    public a o;
    public int p;
    public boolean q;
    public boolean r;
    public b s;
    public AdvertAppInfo t;
    public String u;
    public String v;
    public int w;
    public boolean x;
    public String y;
    public String z;

    /* loaded from: classes6.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void b(int i, String str);
    }

    public void j0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Object, Integer, nc8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public String b;
        public String c;
        public int d;
        public int e;
        public final /* synthetic */ kc8 f;

        public a(kc8 kc8Var, String str, String str2, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc8Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = kc8Var;
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = 0;
            this.e = 0;
            this.c = str2;
            this.b = str;
            this.d = i;
            this.e = i2;
        }

        public final void b() {
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.addPostData("forum_id", this.f.i);
                NetWork netWork = this.a;
                if (this.f.u != null) {
                    str = this.f.u;
                } else {
                    str = "0";
                }
                netWork.addPostData("user_id", str);
                this.a.addPostData(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
                this.a.addPostData("scr_w", String.valueOf(wi.l(TbadkCoreApplication.getInst().getApp())));
                this.a.addPostData("scr_h", String.valueOf(wi.j(TbadkCoreApplication.getInst().getApp())));
                NetWork netWork2 = this.a;
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    i = 2;
                } else {
                    i = 1;
                }
                netWork2.addPostData("q_type", String.valueOf(i));
                if (sl9.b()) {
                    this.a.addPostData(HttpRequest.OS_VERSION, yi.k());
                } else {
                    this.a.addPostData(HttpRequest.NEED_DECRYPT, sl9.c());
                    String g = sl9.g(HttpRequest.OS_VERSION);
                    if (!TextUtils.isEmpty(g)) {
                        this.a.addPostData(g, sl9.j());
                    }
                }
                this.a.addPostData("page_name", "PB");
                this.a.addPostData("pic_index", String.valueOf(this.f.a.size()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public nc8 doInBackground(Object... objArr) {
            InterceptResult invokeL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
                this.a = netWork;
                netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f.j);
                this.a.addPostData("tid", this.b);
                String str = this.c;
                if (str != null) {
                    this.a.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, str);
                }
                if (!TextUtils.isEmpty(this.f.f) && !"0".equals(this.f.f)) {
                    this.a.addPostData("post_id", this.f.f);
                }
                NetWork netWork2 = this.a;
                int i2 = 2;
                if (this.f.r) {
                    i = 1;
                } else {
                    i = 2;
                }
                netWork2.addPostData("source", String.valueOf(i));
                this.f.r = false;
                this.a.addPostData("next", String.valueOf(this.d));
                this.a.addPostData("prev", String.valueOf(this.e));
                this.a.addPostData("not_see_lz", String.valueOf(!this.f.q ? 1 : 0));
                NetWork netWork3 = this.a;
                if (this.f.C) {
                    i2 = 1;
                }
                netWork3.addPostData("is_top_agree", String.valueOf(i2));
                if (!this.f.n) {
                    this.a.addPostData("r", String.valueOf(1));
                }
                if (!StringUtils.isNull(this.f.v, true)) {
                    this.a.addPostData("obj_type", this.f.v);
                } else {
                    this.a.addPostData("obj_type", "other");
                }
                if (TextUtils.isEmpty(this.f.y)) {
                    if (System.currentTimeMillis() - o95.p().r("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                        this.f.y = o95.p().w("applist_intalled_apk_ids", "");
                    }
                }
                this.a.addPostData("applist", this.f.y);
                if (sl9.b()) {
                    String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
                    if (!TextUtils.isEmpty(lastCachedOid)) {
                        this.a.addPostData("oaid", lastCachedOid);
                    }
                } else {
                    this.a.addPostData(HttpRequest.NEED_DECRYPT, sl9.c());
                    String g = sl9.g("oaid");
                    if (!TextUtils.isEmpty(g)) {
                        this.a.addPostData(g, sl9.i());
                    }
                }
                this.a.addPostData("app_transmit_data", bw5.a());
                this.a.addPostData("ad_ext_params", AdExtParam.a.b().a());
                b();
                this.a.getNetContext().getRequest().mNeedBackgroundLogin = false;
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    nc8 nc8Var = new nc8();
                    nc8Var.n(postNetData, true);
                    return nc8Var;
                }
                return null;
            }
            return (nc8) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f.o = null;
                super.cancel(true);
            }
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c;
            }
            return (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v26, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r6v56 */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void onPostExecute(nc8 nc8Var) {
            boolean z;
            ImageUrlData imageUrlData;
            boolean z2;
            boolean z3;
            int i;
            int i2;
            String str;
            AgreeData agreeData;
            boolean z4;
            String s;
            int i3;
            String str2;
            int i4;
            int i5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, nc8Var) == null) {
                super.onPostExecute(nc8Var);
                if (this.f.c == null) {
                    return;
                }
                String str3 = null;
                this.f.o = null;
                if (nc8Var == null) {
                    if (this.f.s != null) {
                        NetWork netWork = this.a;
                        if (netWork != null) {
                            i5 = netWork.getServerErrorCode();
                            if (this.c == null) {
                                str3 = this.a.getErrorString();
                            }
                        } else {
                            i5 = -1;
                        }
                        this.f.s.b(i5, str3);
                        return;
                    }
                    return;
                }
                boolean isEmpty = ListUtils.isEmpty(nc8Var.g());
                if (this.f.A && !isEmpty) {
                    this.f.a.clear();
                    this.f.c.clear();
                    this.f.b.clear();
                }
                if (nc8Var.h() != 0) {
                    this.f.p = nc8Var.h();
                }
                this.f.t = nc8Var.a();
                this.f.R = nc8Var.m;
                kc8 kc8Var = this.f;
                kc8Var.L = nc8Var.i;
                kc8Var.M = nc8Var.j();
                kc8 kc8Var2 = this.f;
                kc8Var2.N = nc8Var.k;
                kc8Var2.O = nc8Var.j;
                ?? r6 = 1;
                if (nc8Var.l == 1) {
                    z = true;
                } else {
                    z = false;
                }
                kc8Var2.P = z;
                if (this.c == null) {
                    this.f.a.clear();
                    this.f.b.clear();
                }
                LinkedList<lc8> g = nc8Var.g();
                int size = g.size();
                if (size > 0) {
                    int i6 = 0;
                    while (i6 < size) {
                        lc8 lc8Var = g.get(i6);
                        String V = this.f.V(lc8Var);
                        ImageUrlData imageUrlData2 = new ImageUrlData();
                        String g2 = lc8Var.g();
                        imageUrlData2.id = g2;
                        if (StringHelper.equals(g2, this.f.B)) {
                            imageUrlData2.setSourceImageRectInScreen(this.f.z);
                        }
                        imageUrlData2.imageUrl = V;
                        String str4 = V + "*" + lc8Var.l();
                        imageUrlData2.mWidth = lc8Var.t();
                        imageUrlData2.mHeigth = lc8Var.f();
                        imageUrlData2.urlType = 27;
                        imageUrlData2.originalUrl = lc8Var.j();
                        boolean z5 = isEmpty;
                        imageUrlData2.originalSize = lc8Var.k();
                        imageUrlData2.picId = lc8Var.m();
                        imageUrlData2.forumId = this.f.i;
                        imageUrlData2.forumName = this.f.j;
                        imageUrlData2.threadId = ug.g(this.b, -1L);
                        imageUrlData2.nid = this.f.h;
                        imageUrlData2.postId = ug.g(lc8Var.c(), -1L);
                        imageUrlData2.userId = lc8Var.q();
                        if (StringUtils.isNull(lc8Var.s())) {
                            s = lc8Var.r();
                        } else {
                            s = lc8Var.s();
                        }
                        imageUrlData2.userNameShow = s;
                        imageUrlData2.mIsReserver = this.f.n;
                        imageUrlData2.mIsSeeHost = this.f.q;
                        imageUrlData2.overAllIndex = lc8Var.l();
                        imageUrlData2.mThreadType = this.f.w;
                        imageUrlData2.mPicType = lc8Var.n();
                        imageUrlData2.mTagName = lc8Var.p();
                        imageUrlData2.mIsShowOrigonButton = lc8Var.x();
                        imageUrlData2.isLongPic = lc8Var.w();
                        imageUrlData2.isBlockedPic = lc8Var.u();
                        imageUrlData2.from = this.f.v;
                        if (lc8Var.o() != null) {
                            imageUrlData2.richTextArray = lc8Var.o().toString();
                        }
                        imageUrlData2.isFirstPost = lc8Var.v();
                        if (lc8Var.a() != null) {
                            AgreeData a = lc8Var.a();
                            imageUrlData2.agreeData = a;
                            a.isFromImageViewer = r6;
                            a.mImageViewerFromPage = this.f.v;
                            imageUrlData2.agreeData.forumId = this.f.i;
                            imageUrlData2.agreeData.threadId = String.valueOf(imageUrlData2.threadId);
                            AgreeData agreeData2 = imageUrlData2.agreeData;
                            agreeData2.nid = imageUrlData2.nid;
                            agreeData2.postId = String.valueOf(imageUrlData2.postId);
                            imageUrlData2.agreeData.indexOfPic = imageUrlData2.overAllIndex;
                            imageUrlData2.commentNum = lc8Var.d();
                            if (lc8Var.v()) {
                                AgreeData agreeData3 = imageUrlData2.agreeData;
                                agreeData3.objType = 3;
                                agreeData3.isInThread = r6;
                                agreeData3.isInPost = false;
                            } else {
                                AgreeData agreeData4 = imageUrlData2.agreeData;
                                agreeData4.objType = r6;
                                agreeData4.isInThread = false;
                                agreeData4.isInPost = r6;
                            }
                            imageUrlData2.agreeData.cardType = this.f.G;
                            imageUrlData2.agreeData.recomSource = this.f.H;
                            imageUrlData2.agreeData.recomAbTag = this.f.I;
                            imageUrlData2.agreeData.recomExtra = this.f.K;
                            imageUrlData2.agreeData.recomWeight = this.f.J;
                        }
                        imageUrlData2.faceGroupInfoData = lc8Var.e();
                        String str5 = imageUrlData2.id + "_" + lc8Var.l();
                        if (!this.f.S.isEmpty() && this.f.S.contains(imageUrlData2.id) && this.f.b.containsKey(imageUrlData2.id)) {
                            String str6 = (String) this.f.b.get(imageUrlData2.id);
                            this.f.S.remove(imageUrlData2.id);
                            int indexOf = this.f.a.indexOf(str6);
                            this.f.a.remove(str6);
                            this.f.b.remove(imageUrlData2.id);
                            ImageUrlData imageUrlData3 = (ImageUrlData) this.f.c.get(str6);
                            if (imageUrlData3 != null) {
                                imageUrlData3.imageUrl = imageUrlData2.imageUrl;
                                imageUrlData3.picId = imageUrlData2.picId;
                                i3 = i6;
                                imageUrlData3.overAllIndex = imageUrlData2.overAllIndex;
                                imageUrlData3.mIsShowOrigonButton = imageUrlData2.mIsShowOrigonButton;
                                imageUrlData3.isLongPic = imageUrlData2.isLongPic;
                                imageUrlData3.richTextArray = imageUrlData2.richTextArray;
                                imageUrlData3.commentNum = imageUrlData2.commentNum;
                                imageUrlData3.agreeData = imageUrlData2.agreeData;
                                imageUrlData3.isFirstPost = imageUrlData2.isFirstPost;
                                imageUrlData3.userId = imageUrlData2.userId;
                                imageUrlData3.userNameShow = imageUrlData2.userNameShow;
                                imageUrlData3.forumId = this.f.i;
                                imageUrlData3.forumName = this.f.j;
                                imageUrlData3.mHeigth = imageUrlData2.mHeigth;
                                imageUrlData3.mWidth = imageUrlData2.mWidth;
                                imageUrlData3.faceGroupInfoData = imageUrlData2.faceGroupInfoData;
                                if (StringHelper.equals(imageUrlData2.id, this.f.B)) {
                                    imageUrlData3.setSourceImageRectInScreen(this.f.z);
                                }
                                imageUrlData2.imageThumbUrl = imageUrlData3.imageThumbUrl;
                                imageUrlData2.urlThumbType = imageUrlData3.urlThumbType;
                            } else {
                                i3 = i6;
                            }
                            this.f.c.remove(str6);
                            this.f.c.put(str4, imageUrlData2);
                            if (indexOf >= 0 && indexOf < this.f.a.size()) {
                                this.f.a.add(indexOf, str4);
                            } else {
                                this.f.a.add(str4);
                            }
                            this.f.b.put(str5, str4);
                        } else {
                            i3 = i6;
                            if (this.f.b.containsKey(str5)) {
                                String str7 = (String) this.f.b.get(str5);
                                ImageUrlData imageUrlData4 = (ImageUrlData) this.f.c.get(str7);
                                if (imageUrlData4 == null) {
                                    this.f.c.put(str7, imageUrlData2);
                                } else {
                                    imageUrlData4.imageUrl = imageUrlData2.imageUrl;
                                    imageUrlData4.picId = imageUrlData2.picId;
                                    imageUrlData4.overAllIndex = imageUrlData2.overAllIndex;
                                    imageUrlData4.mIsShowOrigonButton = imageUrlData2.mIsShowOrigonButton;
                                    imageUrlData4.isLongPic = imageUrlData2.isLongPic;
                                    imageUrlData4.richTextArray = imageUrlData2.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData2.commentNum;
                                    imageUrlData4.agreeData = imageUrlData2.agreeData;
                                    imageUrlData4.isFirstPost = imageUrlData2.isFirstPost;
                                    imageUrlData4.userId = imageUrlData2.userId;
                                    imageUrlData4.userNameShow = imageUrlData2.userNameShow;
                                    imageUrlData4.forumId = this.f.i;
                                    imageUrlData4.forumName = this.f.j;
                                    imageUrlData4.mHeigth = imageUrlData2.mHeigth;
                                    imageUrlData4.mWidth = imageUrlData2.mWidth;
                                    imageUrlData4.faceGroupInfoData = imageUrlData2.faceGroupInfoData;
                                    if (StringHelper.equals(imageUrlData2.id, this.f.B)) {
                                        imageUrlData4.setSourceImageRectInScreen(this.f.z);
                                    }
                                }
                            } else {
                                if (this.f.D) {
                                    kc8 kc8Var3 = this.f;
                                    kc8Var3.p = kc8Var3.c.size();
                                    str2 = null;
                                    this.f.t = null;
                                    i4 = i3;
                                } else {
                                    str2 = null;
                                    this.f.c.put(str4, imageUrlData2);
                                    if (this.f.x) {
                                        i4 = i3;
                                        if (i4 < this.f.a.size()) {
                                            this.f.a.add(i4, str4);
                                            this.f.b.put(str5, str4);
                                        }
                                    } else {
                                        i4 = i3;
                                    }
                                    this.f.a.add(str4);
                                    this.f.b.put(str5, str4);
                                }
                                i6 = i4 + 1;
                                isEmpty = z5;
                                str3 = str2;
                                r6 = 1;
                            }
                        }
                        i4 = i3;
                        str2 = null;
                        i6 = i4 + 1;
                        isEmpty = z5;
                        str3 = str2;
                        r6 = 1;
                    }
                    imageUrlData = str3;
                    z2 = isEmpty;
                    lc8 lc8Var2 = (lc8) ListUtils.getItem(g, 0);
                    if (lc8Var2 != null) {
                        this.f.k = lc8Var2.g();
                    }
                    lc8 lc8Var3 = (lc8) ListUtils.getItem(g, size - 1);
                    if (lc8Var3 != null) {
                        this.f.l = lc8Var3.g();
                        kc8 kc8Var4 = this.f;
                        if (kc8Var4.p == lc8Var3.l()) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        kc8Var4.m = z4;
                    }
                } else {
                    imageUrlData = null;
                    z2 = isEmpty;
                    this.f.m = true;
                }
                ImageUrlData imageUrlData5 = imageUrlData;
                for (ImageUrlData imageUrlData6 : this.f.c.values()) {
                    if (imageUrlData6.agreeData == null) {
                        long j = imageUrlData6.postId;
                        if (imageUrlData5 == null) {
                            for (ImageUrlData imageUrlData7 : this.f.c.values()) {
                                if (imageUrlData7.postId == j && (agreeData = imageUrlData7.agreeData) != null) {
                                    imageUrlData6.agreeData = agreeData;
                                    imageUrlData6.richTextArray = imageUrlData7.richTextArray;
                                    imageUrlData6.commentNum = imageUrlData7.commentNum;
                                    imageUrlData6.userId = imageUrlData7.userId;
                                    imageUrlData6.userNameShow = imageUrlData7.userNameShow;
                                    imageUrlData6.faceGroupInfoData = imageUrlData7.faceGroupInfoData;
                                    imageUrlData6.forumId = this.f.i;
                                    imageUrlData6.forumName = this.f.j;
                                    imageUrlData5 = imageUrlData7;
                                }
                            }
                        } else if (j == imageUrlData5.postId) {
                            imageUrlData6.agreeData = imageUrlData5.agreeData;
                            imageUrlData6.richTextArray = imageUrlData5.richTextArray;
                            imageUrlData6.commentNum = imageUrlData5.commentNum;
                            imageUrlData6.userId = imageUrlData5.userId;
                            imageUrlData6.userNameShow = imageUrlData5.userNameShow;
                            imageUrlData6.faceGroupInfoData = imageUrlData5.faceGroupInfoData;
                            imageUrlData6.forumId = this.f.i;
                            imageUrlData6.forumName = this.f.j;
                        }
                    }
                }
                if (this.c == null) {
                    this.f.g = this.b;
                    z3 = true;
                    i = 0;
                } else {
                    z3 = false;
                    i = -1;
                }
                if (this.f.x) {
                    if (this.f.b != null && !this.f.b.isEmpty()) {
                        for (String str8 : this.f.b.keySet()) {
                            if (!TextUtils.isEmpty(str8) && str8.contains(this.c)) {
                                str = (String) this.f.b.get(str8);
                                break;
                            }
                        }
                    }
                    str = imageUrlData;
                    i2 = ListUtils.getPosition(this.f.a, str) - 1;
                } else {
                    i2 = i;
                }
                this.f.E = nc8Var.e();
                this.f.F = nc8Var.k();
                this.f.Q = nc8Var.f();
                if (this.f.d == null) {
                    this.f.d = new ArrayList();
                    if (nc8Var.d() != null && nc8Var.g().size() > 0) {
                        this.f.d.addAll(nc8Var.d());
                    }
                }
                if (nc8Var.i() != null && !nc8Var.i().isEmpty()) {
                    if (this.f.e == null) {
                        this.f.e = new ArrayList();
                    } else {
                        this.f.e.clear();
                    }
                    this.f.e.addAll(nc8Var.i());
                }
                if (this.f.s != null) {
                    this.f.s.a(this.f.a, i2, this.f.p, false, null, z3, this.f.t, z2);
                }
                this.f.A = false;
            }
        }
    }

    public kc8(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, map, str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str8, str9, str10, str11};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        this.m = false;
        this.n = true;
        this.o = null;
        this.p = 0;
        this.q = false;
        this.r = false;
        this.s = null;
        this.t = null;
        this.x = false;
        this.D = false;
        this.S = new HashSet<>();
        this.a = arrayList;
        this.c = map;
        if (arrayList == null) {
            this.a = new ArrayList<>();
        }
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String a2 = jc8.a(next);
            this.b.put(a2, next);
            this.S.add(a2);
        }
        this.g = str3;
        this.h = str4;
        this.j = str2;
        this.i = str;
        this.l = str5;
        this.w = i;
        this.m = str5 == null;
        this.u = str6;
        this.v = str7;
        this.A = z;
        this.C = false;
        this.G = i2;
        this.H = str8;
        this.I = str9;
        this.J = str10;
        this.K = str11;
    }

    public void d0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f = str;
        }
    }

    public void e0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.B = str;
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.r = z;
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.D = z;
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.C = z;
        }
    }

    public void i0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.s = bVar;
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.n = z;
        }
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.q = z;
        }
    }

    public void m0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.z = str;
        }
    }

    public final String V(lc8 lc8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lc8Var)) == null) {
            if (lc8Var.b() != null && lc8Var.b().length() > 0) {
                return lc8Var.b();
            }
            StringBuilder sb = new StringBuilder(150);
            int threadImageMaxWidth = TbConfig.getThreadImageMaxWidth();
            int i = threadImageMaxWidth * threadImageMaxWidth;
            if (lc8Var.f() * lc8Var.t() > i) {
                double sqrt = Math.sqrt(i / (lc8Var.f() * lc8Var.t()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (lc8Var.t() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (lc8Var.f() * sqrt)));
            } else {
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf(lc8Var.t()));
                sb.append("&height=");
                sb.append(String.valueOf(lc8Var.f()));
            }
            sb.append("&src=");
            sb.append(vi.getUrlEncode(lc8Var.h()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public ArrayList<AlaInfoData> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.E;
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<yc8> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.x = false;
            if (this.m) {
                return;
            }
            n0(this.g, this.l, 10, 0);
        }
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.F;
        }
        return (String) invokeV.objValue;
    }

    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.R;
        }
        return invokeV.intValue;
    }

    public void o0() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (aVar = this.o) != null) {
            aVar.cancel();
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.x = true;
            String str = this.a.get(0);
            if (StringUtils.isNull(this.k)) {
                this.k = jc8.a(str);
            }
            n0(this.g, this.k, 0, 10);
        }
    }

    public final void n0(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048594, this, str, str2, i, i2) == null) {
            a aVar = this.o;
            if (aVar != null) {
                if (str2 != null && str2.equals(aVar.d())) {
                    return;
                }
                this.o.cancel();
            }
            a aVar2 = new a(this, str, str2, i, i2);
            this.o = aVar2;
            aVar2.setPriority(3);
            this.o.execute(new Object[0]);
        }
    }
}
