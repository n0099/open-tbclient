package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.DeviceInfoHelper;
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
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
/* loaded from: classes8.dex */
public class vw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public String C;
    public boolean D;
    public boolean E;
    public String F;
    public String G;
    public int H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String M;
    public int N;
    public MetaData O;
    public String P;
    public boolean Q;
    public ForumData R;
    public int S;

    /* renamed from: T  reason: collision with root package name */
    public final HashSet<String> f1176T;
    public int U;
    public ArrayList<String> a;
    public HashMap<String, String> b;
    public Map<String, ImageUrlData> c;
    public ArrayList<AlaInfoData> d;
    public ArrayList<kx8> e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public boolean o;
    public a p;
    public int q;
    public boolean r;
    public boolean s;
    public b t;
    public AdvertAppInfo u;
    public String v;
    public String w;
    public int x;
    public int y;
    public String z;

    /* loaded from: classes8.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void b(int i, String str);
    }

    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, yw8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public String b;
        public String c;
        public int d;
        public int e;
        public String f;
        public final /* synthetic */ vw8 g;

        public a(vw8 vw8Var, String str, String str2, int i, int i2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vw8Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = vw8Var;
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = 0;
            this.e = 0;
            this.f = "";
            this.c = str2;
            this.b = str;
            this.d = i;
            this.e = i2;
            this.f = str3;
        }

        public final void b() {
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.addPostData("forum_id", this.g.j);
                NetWork netWork = this.a;
                if (this.g.v != null) {
                    str = this.g.v;
                } else {
                    str = "0";
                }
                netWork.addPostData("user_id", str);
                this.a.addPostData(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
                this.a.addPostData("scr_w", String.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                this.a.addPostData("scr_h", String.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                NetWork netWork2 = this.a;
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    i = 2;
                } else {
                    i = 1;
                }
                netWork2.addPostData("q_type", String.valueOf(i));
                if (raa.b()) {
                    this.a.addPostData(HttpRequest.OS_VERSION, DeviceInfoHelper.getOsVersion());
                } else {
                    this.a.addPostData(HttpRequest.NEED_DECRYPT, raa.c());
                    String g = raa.g(HttpRequest.OS_VERSION);
                    if (!TextUtils.isEmpty(g)) {
                        this.a.addPostData(g, raa.j());
                    }
                }
                this.a.addPostData("page_name", "PB");
                this.a.addPostData("pic_index", String.valueOf(this.g.U));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public yw8 doInBackground(Object... objArr) {
            InterceptResult invokeL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
                this.a = netWork;
                netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.g.k);
                this.a.addPostData("tid", this.b);
                String str = this.c;
                if (str != null) {
                    this.a.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, str);
                }
                if (!TextUtils.isEmpty(this.g.g) && !"0".equals(this.g.g)) {
                    this.a.addPostData("post_id", this.g.g);
                }
                if (!TextUtils.isEmpty(this.f) && !"0".equals(this.f)) {
                    this.a.addPostData("current_post_id", this.f);
                }
                NetWork netWork2 = this.a;
                int i2 = 2;
                if (this.g.s) {
                    i = 1;
                } else {
                    i = 2;
                }
                netWork2.addPostData("source", String.valueOf(i));
                this.g.s = false;
                this.a.addPostData("next", String.valueOf(this.d));
                this.a.addPostData("prev", String.valueOf(this.e));
                this.a.addPostData("not_see_lz", String.valueOf(!this.g.r ? 1 : 0));
                NetWork netWork3 = this.a;
                if (this.g.D) {
                    i2 = 1;
                }
                netWork3.addPostData("is_top_agree", String.valueOf(i2));
                if (!this.g.o) {
                    this.a.addPostData("r", String.valueOf(1));
                }
                if (!StringUtils.isNull(this.g.w, true)) {
                    this.a.addPostData("obj_type", this.g.w);
                } else {
                    this.a.addPostData("obj_type", "other");
                }
                if (TextUtils.isEmpty(this.g.z)) {
                    if (System.currentTimeMillis() - SharedPrefHelper.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                        this.g.z = SharedPrefHelper.getInstance().getString("applist_intalled_apk_ids", "");
                    }
                }
                this.a.addPostData("applist", this.g.z);
                if (raa.b()) {
                    String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
                    if (!TextUtils.isEmpty(lastCachedOid)) {
                        this.a.addPostData("oaid", lastCachedOid);
                    }
                } else {
                    this.a.addPostData(HttpRequest.NEED_DECRYPT, raa.c());
                    String g = raa.g("oaid");
                    if (!TextUtils.isEmpty(g)) {
                        this.a.addPostData(g, raa.i());
                    }
                }
                this.a.addPostData("app_transmit_data", ps5.a());
                this.a.addPostData("ad_ext_params", AdExtParam.a.b().a());
                b();
                this.a.getNetContext().getRequest().mNeedBackgroundLogin = false;
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    yw8 yw8Var = new yw8();
                    yw8Var.n(postNetData, true);
                    return yw8Var;
                }
                return null;
            }
            return (yw8) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.g.p = null;
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
        /* JADX WARN: Type inference failed for: r6v30, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r6v60 */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void onPostExecute(yw8 yw8Var) {
            boolean z;
            ImageUrlData imageUrlData;
            boolean z2;
            boolean z3;
            int i;
            int i2;
            String str;
            AgreeData agreeData;
            boolean z4;
            String u;
            int i3;
            String str2;
            int i4;
            int i5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, yw8Var) == null) {
                super.onPostExecute(yw8Var);
                if (this.g.c == null) {
                    return;
                }
                String str3 = null;
                this.g.p = null;
                if (yw8Var == null) {
                    if (this.g.t != null) {
                        NetWork netWork = this.a;
                        if (netWork != null) {
                            i5 = netWork.getServerErrorCode();
                            if (this.c == null) {
                                str3 = this.a.getErrorString();
                            }
                        } else {
                            i5 = -1;
                        }
                        this.g.t.b(i5, str3);
                        return;
                    }
                    return;
                }
                boolean isEmpty = ListUtils.isEmpty(yw8Var.g());
                if (this.g.B && !isEmpty) {
                    this.g.a.clear();
                    this.g.c.clear();
                    this.g.b.clear();
                }
                if (yw8Var.h() != 0) {
                    this.g.q = yw8Var.h();
                }
                this.g.u = yw8Var.a();
                this.g.S = yw8Var.m;
                vw8 vw8Var = this.g;
                vw8Var.M = yw8Var.i;
                vw8Var.N = yw8Var.j();
                vw8 vw8Var2 = this.g;
                vw8Var2.O = yw8Var.k;
                vw8Var2.P = yw8Var.j;
                ?? r6 = 1;
                if (yw8Var.l == 1) {
                    z = true;
                } else {
                    z = false;
                }
                vw8Var2.Q = z;
                if (this.c == null) {
                    this.g.a.clear();
                    this.g.b.clear();
                }
                LinkedList<ww8> g = yw8Var.g();
                int size = g.size();
                if (size > 0) {
                    int i6 = 0;
                    while (i6 < size) {
                        ww8 ww8Var = g.get(i6);
                        String W = this.g.W(ww8Var);
                        ImageUrlData imageUrlData2 = new ImageUrlData();
                        String i7 = ww8Var.i();
                        imageUrlData2.id = i7;
                        if (StringHelper.equals(i7, this.g.C)) {
                            imageUrlData2.setSourceImageRectInScreen(this.g.A);
                        }
                        imageUrlData2.imageUrl = W;
                        String str4 = W + "*" + ww8Var.n();
                        imageUrlData2.mWidth = ww8Var.v();
                        imageUrlData2.mHeigth = ww8Var.h();
                        imageUrlData2.urlType = 27;
                        imageUrlData2.originalUrl = ww8Var.l();
                        boolean z5 = isEmpty;
                        imageUrlData2.originalSize = ww8Var.m();
                        imageUrlData2.picId = ww8Var.o();
                        imageUrlData2.forumId = this.g.j;
                        imageUrlData2.forumName = this.g.k;
                        imageUrlData2.threadId = JavaTypesHelper.toLong(this.b, -1L);
                        imageUrlData2.nid = this.g.i;
                        imageUrlData2.postId = JavaTypesHelper.toLong(ww8Var.d(), -1L);
                        imageUrlData2.userId = ww8Var.s();
                        if (StringUtils.isNull(ww8Var.u())) {
                            u = ww8Var.t();
                        } else {
                            u = ww8Var.u();
                        }
                        imageUrlData2.userNameShow = u;
                        imageUrlData2.mIsReserver = this.g.o;
                        imageUrlData2.mIsSeeHost = this.g.r;
                        imageUrlData2.overAllIndex = ww8Var.n();
                        imageUrlData2.mThreadType = this.g.x;
                        imageUrlData2.mPicType = ww8Var.p();
                        imageUrlData2.mTagName = ww8Var.r();
                        imageUrlData2.mIsShowOrigonButton = ww8Var.z();
                        imageUrlData2.isLongPic = ww8Var.y();
                        imageUrlData2.isBlockedPic = ww8Var.w();
                        imageUrlData2.from = this.g.w;
                        if (ww8Var.q() != null) {
                            imageUrlData2.richTextArray = ww8Var.q().toString();
                        }
                        imageUrlData2.isFirstPost = ww8Var.x();
                        if (ww8Var.a() != null) {
                            AgreeData a = ww8Var.a();
                            imageUrlData2.agreeData = a;
                            a.isFromImageViewer = r6;
                            a.mImageViewerFromPage = this.g.w;
                            imageUrlData2.agreeData.forumId = this.g.j;
                            imageUrlData2.agreeData.threadId = String.valueOf(imageUrlData2.threadId);
                            AgreeData agreeData2 = imageUrlData2.agreeData;
                            agreeData2.nid = imageUrlData2.nid;
                            agreeData2.postId = String.valueOf(imageUrlData2.postId);
                            imageUrlData2.agreeData.indexOfPic = imageUrlData2.overAllIndex;
                            imageUrlData2.commentNum = ww8Var.e();
                            if (ww8Var.x()) {
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
                            imageUrlData2.agreeData.cardType = this.g.H;
                            imageUrlData2.agreeData.recomSource = this.g.I;
                            imageUrlData2.agreeData.recomAbTag = this.g.J;
                            imageUrlData2.agreeData.recomExtra = this.g.L;
                            imageUrlData2.agreeData.recomWeight = this.g.K;
                        }
                        imageUrlData2.faceGroupInfoData = ww8Var.f();
                        imageUrlData2.guideInfo = ww8Var.g();
                        imageUrlData2.alaInfoData = ww8Var.b();
                        String str5 = imageUrlData2.id + "_" + ww8Var.n();
                        if (!this.g.f1176T.isEmpty() && this.g.f1176T.contains(imageUrlData2.id) && this.g.b.containsKey(imageUrlData2.id)) {
                            String str6 = (String) this.g.b.get(imageUrlData2.id);
                            this.g.f1176T.remove(imageUrlData2.id);
                            int indexOf = this.g.a.indexOf(str6);
                            this.g.a.remove(str6);
                            this.g.b.remove(imageUrlData2.id);
                            ImageUrlData imageUrlData3 = (ImageUrlData) this.g.c.get(str6);
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
                                imageUrlData3.forumId = this.g.j;
                                imageUrlData3.forumName = this.g.k;
                                imageUrlData3.mHeigth = imageUrlData2.mHeigth;
                                imageUrlData3.mWidth = imageUrlData2.mWidth;
                                imageUrlData3.faceGroupInfoData = imageUrlData2.faceGroupInfoData;
                                imageUrlData3.guideInfo = imageUrlData2.guideInfo;
                                imageUrlData3.alaInfoData = imageUrlData2.alaInfoData;
                                if (StringHelper.equals(imageUrlData2.id, this.g.C)) {
                                    imageUrlData3.setSourceImageRectInScreen(this.g.A);
                                }
                                imageUrlData2.imageThumbUrl = imageUrlData3.imageThumbUrl;
                                imageUrlData2.urlThumbType = imageUrlData3.urlThumbType;
                            } else {
                                i3 = i6;
                            }
                            this.g.c.remove(str6);
                            this.g.c.put(str4, imageUrlData2);
                            if (indexOf >= 0 && indexOf < this.g.a.size()) {
                                this.g.a.add(indexOf, str4);
                            } else {
                                this.g.a.add(str4);
                            }
                            this.g.b.put(str5, str4);
                        } else {
                            i3 = i6;
                            if (this.g.b.containsKey(str5)) {
                                String str7 = (String) this.g.b.get(str5);
                                ImageUrlData imageUrlData4 = (ImageUrlData) this.g.c.get(str7);
                                if (imageUrlData4 == null) {
                                    this.g.c.put(str7, imageUrlData2);
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
                                    imageUrlData4.forumId = this.g.j;
                                    imageUrlData4.forumName = this.g.k;
                                    imageUrlData4.mHeigth = imageUrlData2.mHeigth;
                                    imageUrlData4.mWidth = imageUrlData2.mWidth;
                                    imageUrlData4.faceGroupInfoData = imageUrlData2.faceGroupInfoData;
                                    imageUrlData4.guideInfo = imageUrlData2.guideInfo;
                                    imageUrlData4.alaInfoData = imageUrlData2.alaInfoData;
                                    if (StringHelper.equals(imageUrlData2.id, this.g.C)) {
                                        imageUrlData4.setSourceImageRectInScreen(this.g.A);
                                    }
                                }
                            } else {
                                if (this.g.E) {
                                    vw8 vw8Var3 = this.g;
                                    vw8Var3.q = vw8Var3.c.size();
                                    str2 = null;
                                    this.g.u = null;
                                    i4 = i3;
                                } else {
                                    str2 = null;
                                    this.g.c.put(str4, imageUrlData2);
                                    if (this.g.y != 1) {
                                        i4 = i3;
                                        if (i4 < this.g.a.size()) {
                                            this.g.a.add(i4, str4);
                                            this.g.b.put(str5, str4);
                                        }
                                    } else {
                                        i4 = i3;
                                    }
                                    this.g.a.add(str4);
                                    this.g.b.put(str5, str4);
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
                    ww8 ww8Var2 = (ww8) ListUtils.getItem(g, 0);
                    if (ww8Var2 != null) {
                        this.g.l = ww8Var2.i();
                    }
                    ww8 ww8Var3 = (ww8) ListUtils.getItem(g, size - 1);
                    if (ww8Var3 != null) {
                        this.g.m = ww8Var3.i();
                        vw8 vw8Var4 = this.g;
                        if (vw8Var4.q == ww8Var3.n()) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        vw8Var4.n = z4;
                    }
                } else {
                    imageUrlData = null;
                    z2 = isEmpty;
                    this.g.n = true;
                }
                ImageUrlData imageUrlData5 = imageUrlData;
                for (ImageUrlData imageUrlData6 : this.g.c.values()) {
                    if (imageUrlData6.agreeData == null) {
                        long j = imageUrlData6.postId;
                        if (imageUrlData5 == null) {
                            for (ImageUrlData imageUrlData7 : this.g.c.values()) {
                                if (imageUrlData7.postId == j && (agreeData = imageUrlData7.agreeData) != null) {
                                    imageUrlData6.agreeData = agreeData;
                                    imageUrlData6.richTextArray = imageUrlData7.richTextArray;
                                    imageUrlData6.commentNum = imageUrlData7.commentNum;
                                    imageUrlData6.userId = imageUrlData7.userId;
                                    imageUrlData6.userNameShow = imageUrlData7.userNameShow;
                                    imageUrlData6.faceGroupInfoData = imageUrlData7.faceGroupInfoData;
                                    imageUrlData6.guideInfo = imageUrlData7.guideInfo;
                                    imageUrlData6.alaInfoData = imageUrlData7.alaInfoData;
                                    imageUrlData6.forumId = this.g.j;
                                    imageUrlData6.forumName = this.g.k;
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
                            imageUrlData6.guideInfo = imageUrlData5.guideInfo;
                            imageUrlData6.alaInfoData = imageUrlData5.alaInfoData;
                            imageUrlData6.forumId = this.g.j;
                            imageUrlData6.forumName = this.g.k;
                        }
                    }
                }
                if (this.c == null) {
                    this.g.h = this.b;
                    z3 = true;
                    i = 0;
                } else {
                    z3 = false;
                    i = -1;
                }
                if (this.g.y != 1) {
                    if (this.g.b != null && !this.g.b.isEmpty() && !TextUtils.isEmpty(this.c)) {
                        for (String str8 : this.g.b.keySet()) {
                            if (!TextUtils.isEmpty(str8) && str8.contains(this.c)) {
                                str = (String) this.g.b.get(str8);
                                break;
                            }
                        }
                    }
                    str = imageUrlData;
                    int position = ListUtils.getPosition(this.g.a, str);
                    if (this.g.y == 2) {
                        position--;
                    }
                    i2 = position;
                } else {
                    i2 = i;
                }
                this.g.F = yw8Var.e();
                this.g.G = yw8Var.k();
                this.g.R = yw8Var.f();
                if (this.g.d == null) {
                    this.g.d = new ArrayList();
                    if (yw8Var.d() != null && yw8Var.g().size() > 0) {
                        this.g.d.addAll(yw8Var.d());
                    }
                }
                if (yw8Var.i() != null && !yw8Var.i().isEmpty()) {
                    if (this.g.e == null) {
                        this.g.e = new ArrayList();
                    } else {
                        this.g.e.clear();
                    }
                    this.g.e.addAll(yw8Var.i());
                }
                if (this.g.t != null) {
                    this.g.t.a(this.g.a, i2, this.g.q, false, null, z3, this.g.u, z2);
                }
                this.g.B = false;
            }
        }
    }

    public vw8(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, map, str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str8, str9, str10, str11, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        this.n = false;
        this.o = true;
        this.p = null;
        this.q = 0;
        this.r = false;
        this.s = false;
        this.t = null;
        this.u = null;
        this.y = 0;
        this.E = false;
        this.f1176T = new HashSet<>();
        this.a = arrayList;
        this.c = map;
        if (arrayList == null) {
            this.a = new ArrayList<>();
        }
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String a2 = uw8.a(next);
            this.b.put(a2, next);
            this.f1176T.add(a2);
        }
        this.h = str3;
        this.i = str4;
        this.k = str2;
        this.j = str;
        this.m = str5;
        this.x = i;
        this.n = str5 == null;
        this.v = str6;
        this.w = str7;
        this.B = z;
        this.D = false;
        this.H = i2;
        this.I = str8;
        this.J = str9;
        this.K = str10;
        this.L = str11;
        this.U = i3;
    }

    public void g0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.g = str;
        }
    }

    public void h0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.C = str;
        }
    }

    public void i0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.U = i;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.s = z;
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.E = z;
        }
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.D = z;
        }
    }

    public void m0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
            this.t = bVar;
        }
    }

    public void n0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f = str;
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.o = z;
        }
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.r = z;
        }
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.A = str;
        }
    }

    public final String W(ww8 ww8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ww8Var)) == null) {
            if (ww8Var.c() != null && ww8Var.c().length() > 0) {
                return ww8Var.c();
            }
            StringBuilder sb = new StringBuilder(150);
            int threadImageMaxWidth = TbConfig.getThreadImageMaxWidth();
            int i = threadImageMaxWidth * threadImageMaxWidth;
            if (ww8Var.h() * ww8Var.v() > i) {
                double sqrt = Math.sqrt(i / (ww8Var.h() * ww8Var.v()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (ww8Var.v() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (ww8Var.h() * sqrt)));
            } else {
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf(ww8Var.v()));
                sb.append("&height=");
                sb.append(String.valueOf(ww8Var.h()));
            }
            sb.append("&src=");
            sb.append(qd.getUrlEncode(ww8Var.j()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public ArrayList<AlaInfoData> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.F;
        }
        return (String) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.y = 0;
            r0(this.h, this.m, 10, 10, this.f);
        }
    }

    public ArrayList<kx8> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.G;
        }
        return (String) invokeV.objValue;
    }

    public int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.S;
        }
        return invokeV.intValue;
    }

    public void s0() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (aVar = this.p) != null) {
            aVar.cancel();
        }
    }

    public final String Y(String str) {
        InterceptResult invokeL;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.c == null || TextUtils.isEmpty(str) || (imageUrlData = this.c.get(str)) == null) {
                return "";
            }
            return String.valueOf(imageUrlData.postId);
        }
        return (String) invokeL.objValue;
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.y = 1;
            if (this.n) {
                return;
            }
            r0(this.h, this.m, 10, 0, Y((String) ListUtils.getItem(this.a, ListUtils.getCount(this.a) - 1)));
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.y = 2;
            String str = (String) ListUtils.getItem(this.a, 0);
            String Y = Y(str);
            if (StringUtils.isNull(this.l)) {
                this.l = uw8.a(str);
            }
            r0(this.h, this.l, 0, 10, Y);
        }
    }

    public final void r0(String str, String str2, int i, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3}) == null) {
            a aVar = this.p;
            if (aVar != null) {
                if (str2 != null && str2.equals(aVar.d())) {
                    return;
                }
                this.p.cancel();
            }
            a aVar2 = new a(this, str, str2, i, i2, str3);
            this.p = aVar2;
            aVar2.setPriority(3);
            this.p.execute(new Object[0]);
        }
    }
}
