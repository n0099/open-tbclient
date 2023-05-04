package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tieba.image.ImageViewerActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class q48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageViewerActivity a;
    public b b;
    public Runnable c;
    public View.OnClickListener d;
    public final int e;
    public final int f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q48 a;

        public a(q48 q48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q48Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends PopupWindow implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Activity a;
        public View b;
        public EMTextView c;
        public ImageView d;
        public ImageView e;
        public ImageView f;
        public ImageView g;
        public ImageView h;
        public MultiImageView i;
        public ab5 j;
        public final /* synthetic */ q48 k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(q48 q48Var, Activity activity) {
            super(activity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q48Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = q48Var;
            this.a = activity;
            this.j = new ab5(activity, null);
            setWidth(ii.l(activity) - (q48Var.f * 2));
            setHeight(-2);
            setFocusable(false);
            setTouchable(true);
            setOutsideTouchable(true);
            setBackgroundDrawable(new ColorDrawable(0));
            a();
            d();
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0403, (ViewGroup) null);
                this.b = inflate;
                this.c = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f09240b);
                ImageView imageView = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091cbf);
                this.d = imageView;
                imageView.setImageDrawable(this.a.getDrawable(R.drawable.icon_mask_share_qq40_svg));
                this.d.setOnClickListener(this);
                ImageView imageView2 = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091cc4);
                this.e = imageView2;
                imageView2.setImageDrawable(this.a.getDrawable(R.drawable.icon_mask_share_qqzone40_svg));
                this.e.setOnClickListener(this);
                ImageView imageView3 = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09288f);
                this.f = imageView3;
                imageView3.setImageDrawable(this.a.getDrawable(R.drawable.icon_mask_share_wechat40_svg));
                this.f.setOnClickListener(this);
                ImageView imageView4 = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f092891);
                this.g = imageView4;
                imageView4.setImageDrawable(this.a.getDrawable(R.drawable.icon_mask_share_circle40_svg));
                this.g.setOnClickListener(this);
                ImageView imageView5 = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09288e);
                this.h = imageView5;
                imageView5.setImageDrawable(this.a.getDrawable(R.drawable.icon_share_wechatexpression));
                this.h.setOnClickListener(this);
                setContentView(this.b);
                GreyUtil.grey(this);
            }
        }

        public final ShareItem b() {
            InterceptResult invokeV;
            UrlDragImageView currentUrlDragImageView;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                MultiImageView multiImageView = this.i;
                if (multiImageView == null || (currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView()) == null) {
                    return null;
                }
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                if (imageUrlData == null) {
                    str = "";
                    str2 = str;
                } else {
                    str = imageUrlData.imageUrl;
                    str2 = BigImageLoaderProc.getNameMd5FromUrl(str);
                }
                if (TextUtils.isEmpty(str)) {
                    str = this.i.getCurrentImageUrl();
                    str2 = TbMd5.getNameMd5FromUrl(str);
                }
                ShareItem shareItem = new ShareItem();
                int i = 5;
                if (imageUrlData != null) {
                    long j = imageUrlData.threadId;
                    if (j > 0) {
                        shareItem.x = TbConfig.HTTPS_PB_PREFIX + j + "?fr=share";
                    }
                    shareItem.O = j + "";
                    shareItem.N = imageUrlData.forumId;
                    i = this.k.e(imageUrlData.from);
                }
                if (!hi.isEmpty(str)) {
                    shareItem.z = Uri.parse(str);
                    shareItem.k0 = 2;
                    Bundle bundle = new Bundle();
                    bundle.putString("path", "images");
                    bundle.putString("name", str2);
                    bundle.putBoolean("formatData", true);
                    bundle.putBoolean("isSubDir", true);
                    bundle.putBoolean("isSdcard", false);
                    bundle.putBoolean("isSavedCache", true);
                    shareItem.E = bundle;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("tid", shareItem.O);
                bundle2.putString("fid", shareItem.N);
                bundle2.putString("uid", TbadkCoreApplication.getCurrentAccount());
                bundle2.putInt("obj_source", i);
                bundle2.putInt("obj_locate", 12);
                shareItem.l(bundle2);
                return shareItem;
            }
            return (ShareItem) invokeV.objValue;
        }

        public final boolean c(ShareItem shareItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareItem)) == null) {
                if (!TextUtils.isEmpty(shareItem.D0) && !TextUtils.isEmpty(shareItem.E0)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void f(MultiImageView multiImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, multiImageView) == null) {
                this.i = multiImageView;
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
                g35 d = g35.d(this.b);
                d.o(R.string.J_X06);
                d.f(R.color.CAM_X0204);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.i = null;
                this.a = null;
                this.j = null;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ShareItem b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048582, this, view2) != null) || (b = b()) == null) {
                return;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                ii.P(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (view2 == this.d) {
                if (to9.b(this.a, "com.tencent.mobileqq")) {
                    if (c(b) && b.b() != null && b.b().contains(4)) {
                        ua5.f(b, this.a, 8, null);
                        return;
                    } else {
                        this.j.m(b);
                        return;
                    }
                }
                Activity activity = this.a;
                BdToast.b(activity, activity.getText(R.string.share_qq_not_install)).o();
            } else if (view2 == this.e) {
                if (to9.b(this.a, "com.tencent.mobileqq")) {
                    if (c(b) && b.b() != null && b.b().contains(4)) {
                        ua5.f(b, this.a, 4, null);
                        return;
                    } else {
                        this.j.n(b);
                        return;
                    }
                }
                Activity activity2 = this.a;
                BdToast.b(activity2, activity2.getText(R.string.share_qq_not_install)).o();
            } else if (view2 == this.f) {
                if (c(b) && b.b() != null && b.b().contains(3)) {
                    ua5.f(b, this.a, 3, null);
                } else if (b.s0 != 1) {
                    this.j.r(b);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_source", 22).param("tid", b.O).param("fid", b.N));
            } else if (view2 == this.g) {
                if (c(b) && b.b() != null && b.b().contains(2)) {
                    ua5.f(b, this.a, 2, null);
                } else if (b.s0 != 1) {
                    if (b.b) {
                        b.w = "【" + b.v + "】 " + b.w;
                    }
                    this.j.s(b);
                }
            } else if (view2 == this.h && this.k.d != null) {
                this.k.d.onClick(view2);
            }
        }
    }

    public q48(ImageViewerActivity imageViewerActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageViewerActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        this.f = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);
        this.a = imageViewerActivity;
        this.b = new b(this, imageViewerActivity);
        this.c = new a(this);
    }

    public final int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if ("index".equals(str)) {
                return 1;
            }
            if (ImageViewerConfig.FROM_CONCERN.equals(str)) {
                return 2;
            }
            if ("hot_topic".equals(str)) {
                return 3;
            }
            if ("frs".equals(str)) {
                return 4;
            }
            return 5;
        }
        return invokeL.intValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = this.b;
            if (bVar != null) {
                bVar.e();
            }
            this.a = null;
            this.d = null;
        }
    }

    public void g(MultiImageView multiImageView, int i, View.OnClickListener onClickListener) {
        b bVar;
        String str;
        String str2;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, multiImageView, i, onClickListener) == null) && (bVar = this.b) != null && multiImageView != null) {
            if (!bVar.isShowing()) {
                lg.m(this.b, multiImageView, 81, 0, i + yh.b(this.a) + this.e);
                int i2 = 5;
                UrlDragImageView currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView();
                String str3 = "";
                if (currentUrlDragImageView == null || (imageUrlData = currentUrlDragImageView.getmAssistUrlData()) == null) {
                    str = "";
                    str2 = str;
                } else {
                    String str4 = imageUrlData.threadId + "";
                    str2 = imageUrlData.forumId + "";
                    str3 = imageUrlData.postId + "";
                    int e = e(imageUrlData.from);
                    str = str4;
                    i2 = e;
                }
                TiebaStatic.log(new StatisticItem("c14045").param("post_id", str3).param("tid", str).param("fid", str2).param("obj_source", i2));
            }
            this.b.f(multiImageView);
            this.d = onClickListener;
            jg.a().removeCallbacks(this.c);
            jg.a().postDelayed(this.c, 5000L);
        }
    }
}
