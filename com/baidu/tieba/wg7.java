package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
public class wg7 {
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
    public ArrayList<jh7> e;
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
    public class a extends BdAsyncTask<Object, Integer, zg7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public String b;
        public String c;
        public int d;
        public int e;
        public final /* synthetic */ wg7 f;

        public a(wg7 wg7Var, String str, String str2, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg7Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = wg7Var;
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
                this.a.addPostData("scr_w", String.valueOf(yi.l(TbadkCoreApplication.getInst().getApp())));
                this.a.addPostData("scr_h", String.valueOf(yi.j(TbadkCoreApplication.getInst().getApp())));
                NetWork netWork2 = this.a;
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    i = 2;
                } else {
                    i = 1;
                }
                netWork2.addPostData("q_type", String.valueOf(i));
                this.a.addPostData("_os_version", aj.k());
                this.a.addPostData("page_name", "PB");
                this.a.addPostData("pic_index", String.valueOf(this.f.a.size()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public zg7 doInBackground(Object... objArr) {
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
                this.a.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.d));
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
                    this.a.addPostData("obj_type", ImageViewerConfig.FROM_OTHER);
                }
                if (TextUtils.isEmpty(this.f.y)) {
                    if (System.currentTimeMillis() - py4.k().m("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                        this.f.y = py4.k().q("applist_intalled_apk_ids", "");
                    }
                }
                this.a.addPostData("applist", this.f.y);
                String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
                if (!TextUtils.isEmpty(lastCachedOid)) {
                    this.a.addPostData("oaid", lastCachedOid);
                }
                this.a.addPostData("app_transmit_data", fi5.a());
                this.a.addPostData("ad_ext_params", AdExtParam.a.b().a());
                b();
                this.a.getNetContext().getRequest().mNeedBackgroundLogin = false;
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    zg7 zg7Var = new zg7();
                    zg7Var.n(postNetData, true);
                    return zg7Var;
                }
                return null;
            }
            return (zg7) invokeL.objValue;
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
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void onPostExecute(zg7 zg7Var) {
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
            String str2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, zg7Var) == null) {
                super.onPostExecute(zg7Var);
                if (this.f.c == null) {
                    return;
                }
                String str3 = null;
                this.f.o = null;
                if (zg7Var == null) {
                    if (this.f.s != null) {
                        NetWork netWork = this.a;
                        if (netWork != null) {
                            i3 = netWork.getServerErrorCode();
                            if (this.c == null) {
                                str3 = this.a.getErrorString();
                            }
                        } else {
                            i3 = -1;
                        }
                        this.f.s.b(i3, str3);
                        return;
                    }
                    return;
                }
                boolean isEmpty = ListUtils.isEmpty(zg7Var.g());
                if (this.f.A && !isEmpty) {
                    this.f.a.clear();
                    this.f.c.clear();
                    this.f.b.clear();
                }
                if (zg7Var.h() != 0) {
                    this.f.p = zg7Var.h();
                }
                this.f.t = zg7Var.a();
                this.f.R = zg7Var.m;
                wg7 wg7Var = this.f;
                wg7Var.L = zg7Var.i;
                wg7Var.M = zg7Var.j();
                wg7 wg7Var2 = this.f;
                wg7Var2.N = zg7Var.k;
                wg7Var2.O = zg7Var.j;
                if (zg7Var.l == 1) {
                    z = true;
                } else {
                    z = false;
                }
                wg7Var2.P = z;
                if (this.c == null) {
                    this.f.a.clear();
                    this.f.b.clear();
                }
                LinkedList<xg7> g = zg7Var.g();
                int size = g.size();
                if (size > 0) {
                    int i4 = 0;
                    while (i4 < size) {
                        xg7 xg7Var = g.get(i4);
                        String V = this.f.V(xg7Var);
                        ImageUrlData imageUrlData2 = new ImageUrlData();
                        String g2 = xg7Var.g();
                        imageUrlData2.id = g2;
                        if (StringHelper.equals(g2, this.f.B)) {
                            imageUrlData2.setSourceImageRectInScreen(this.f.z);
                        }
                        imageUrlData2.imageUrl = V;
                        String str4 = V + "*" + xg7Var.l();
                        imageUrlData2.mWidth = xg7Var.t();
                        imageUrlData2.mHeigth = xg7Var.f();
                        imageUrlData2.urlType = 10;
                        imageUrlData2.originalUrl = xg7Var.j();
                        boolean z5 = isEmpty;
                        imageUrlData2.originalSize = xg7Var.k();
                        imageUrlData2.picId = xg7Var.m();
                        imageUrlData2.forumId = this.f.i;
                        imageUrlData2.forumName = this.f.j;
                        imageUrlData2.threadId = xg.g(this.b, -1L);
                        imageUrlData2.nid = this.f.h;
                        imageUrlData2.postId = xg.g(xg7Var.c(), -1L);
                        imageUrlData2.userId = xg7Var.q();
                        if (StringUtils.isNull(xg7Var.s())) {
                            s = xg7Var.r();
                        } else {
                            s = xg7Var.s();
                        }
                        imageUrlData2.userNameShow = s;
                        imageUrlData2.mIsReserver = this.f.n;
                        imageUrlData2.mIsSeeHost = this.f.q;
                        imageUrlData2.overAllIndex = xg7Var.l();
                        imageUrlData2.mThreadType = this.f.w;
                        imageUrlData2.mPicType = xg7Var.n();
                        imageUrlData2.mTagName = xg7Var.p();
                        imageUrlData2.mIsShowOrigonButton = xg7Var.x();
                        imageUrlData2.isLongPic = xg7Var.w();
                        imageUrlData2.isBlockedPic = xg7Var.u();
                        imageUrlData2.from = this.f.v;
                        if (xg7Var.o() != null) {
                            imageUrlData2.richTextArray = xg7Var.o().toString();
                        }
                        imageUrlData2.isFirstPost = xg7Var.v();
                        if (xg7Var.a() != null) {
                            AgreeData a = xg7Var.a();
                            imageUrlData2.agreeData = a;
                            a.isFromImageViewer = true;
                            a.mImageViewerFromPage = this.f.v;
                            imageUrlData2.agreeData.forumId = this.f.i;
                            imageUrlData2.agreeData.threadId = String.valueOf(imageUrlData2.threadId);
                            AgreeData agreeData2 = imageUrlData2.agreeData;
                            agreeData2.nid = imageUrlData2.nid;
                            agreeData2.postId = String.valueOf(imageUrlData2.postId);
                            imageUrlData2.agreeData.indexOfPic = imageUrlData2.overAllIndex;
                            imageUrlData2.commentNum = xg7Var.d();
                            if (xg7Var.v()) {
                                AgreeData agreeData3 = imageUrlData2.agreeData;
                                agreeData3.objType = 3;
                                agreeData3.isInThread = true;
                                agreeData3.isInPost = false;
                            } else {
                                AgreeData agreeData4 = imageUrlData2.agreeData;
                                agreeData4.objType = 1;
                                agreeData4.isInThread = false;
                                agreeData4.isInPost = true;
                            }
                            imageUrlData2.agreeData.cardType = this.f.G;
                            imageUrlData2.agreeData.recomSource = this.f.H;
                            imageUrlData2.agreeData.recomAbTag = this.f.I;
                            imageUrlData2.agreeData.recomExtra = this.f.K;
                            imageUrlData2.agreeData.recomWeight = this.f.J;
                        }
                        imageUrlData2.faceGroupInfoData = xg7Var.e();
                        String str5 = imageUrlData2.id + "_" + xg7Var.l();
                        if (!this.f.S.isEmpty() && this.f.S.contains(imageUrlData2.id) && this.f.b.containsKey(imageUrlData2.id)) {
                            String str6 = (String) this.f.b.get(imageUrlData2.id);
                            this.f.S.remove(imageUrlData2.id);
                            this.f.a.remove(str6);
                            this.f.b.remove(imageUrlData2.id);
                            ImageUrlData imageUrlData3 = (ImageUrlData) this.f.c.get(str6);
                            if (imageUrlData3 != null) {
                                imageUrlData3.imageUrl = imageUrlData2.imageUrl;
                                imageUrlData3.picId = imageUrlData2.picId;
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
                            }
                            this.f.c.remove(str6);
                            this.f.c.put(str4, imageUrlData2);
                            this.f.a.add(str4);
                            this.f.b.put(str5, str4);
                        } else if (this.f.b.containsKey(str5)) {
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
                                wg7 wg7Var3 = this.f;
                                wg7Var3.p = wg7Var3.c.size();
                                str2 = null;
                                this.f.t = null;
                            } else {
                                str2 = null;
                                this.f.c.put(str4, imageUrlData2);
                                if (this.f.x && i4 < this.f.a.size()) {
                                    this.f.a.add(i4, str4);
                                } else {
                                    this.f.a.add(str4);
                                }
                                this.f.b.put(str5, str4);
                            }
                            i4++;
                            isEmpty = z5;
                            str3 = str2;
                        }
                        str2 = null;
                        i4++;
                        isEmpty = z5;
                        str3 = str2;
                    }
                    imageUrlData = str3;
                    z2 = isEmpty;
                    xg7 xg7Var2 = (xg7) ListUtils.getItem(g, 0);
                    if (xg7Var2 != null) {
                        this.f.k = xg7Var2.g();
                    }
                    xg7 xg7Var3 = (xg7) ListUtils.getItem(g, size - 1);
                    if (xg7Var3 != null) {
                        this.f.l = xg7Var3.g();
                        wg7 wg7Var4 = this.f;
                        if (wg7Var4.p == xg7Var3.l()) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        wg7Var4.m = z4;
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
                this.f.E = zg7Var.e();
                this.f.F = zg7Var.k();
                this.f.Q = zg7Var.f();
                if (this.f.d == null) {
                    this.f.d = new ArrayList();
                    if (zg7Var.d() != null && zg7Var.g().size() > 0) {
                        this.f.d.addAll(zg7Var.d());
                    }
                }
                if (zg7Var.i() != null && !zg7Var.i().isEmpty()) {
                    if (this.f.e == null) {
                        this.f.e = new ArrayList();
                    } else {
                        this.f.e.clear();
                    }
                    this.f.e.addAll(zg7Var.i());
                }
                if (this.f.s != null) {
                    this.f.s.a(this.f.a, i2, this.f.p, false, null, z3, this.f.t, z2);
                }
                this.f.A = false;
            }
        }
    }

    public wg7(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
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
            String a2 = vg7.a(next);
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

    public final String V(xg7 xg7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xg7Var)) == null) {
            if (xg7Var.b() != null && xg7Var.b().length() > 0) {
                return xg7Var.b();
            }
            StringBuilder sb = new StringBuilder(150);
            int threadImageMaxWidth = TbConfig.getThreadImageMaxWidth();
            int i = threadImageMaxWidth * threadImageMaxWidth;
            if (xg7Var.f() * xg7Var.t() > i) {
                double sqrt = Math.sqrt(i / (xg7Var.f() * xg7Var.t()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (xg7Var.t() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (xg7Var.f() * sqrt)));
            } else {
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf(xg7Var.t()));
                sb.append("&height=");
                sb.append(String.valueOf(xg7Var.f()));
            }
            sb.append("&src=");
            sb.append(xi.getUrlEncode(xg7Var.h()));
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

    public ArrayList<jh7> Y() {
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

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.x = true;
            String str = this.a.get(0);
            if (StringUtils.isNull(this.k)) {
                this.k = vg7.a(str);
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
