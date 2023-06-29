package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lz;
import com.baidu.tieba.wz;
import com.baidu.tieba.zx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ov7 extends kn<yo6, ThreadCardViewHolder<yo6>> implements p56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public Cdo d;
    public boolean e;
    public mg<ImageView> f;
    public mg<GifView> g;
    public qo6<yo6> h;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: C */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return null;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: H */
    public View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, yo6 yo6Var, ThreadCardViewHolder<yo6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, yo6Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements ng<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ov7 a;

        public a(ov7 ov7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ov7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ov7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ng
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ng
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ng
        /* renamed from: f */
        public void b(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, imageView) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.R();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (r05.c().g()) {
                        tbImageView.setAdjustViewBounds(false);
                        tbImageView.setInterceptOnClick(false);
                    } else {
                        tbImageView.setDefaultResource(R.drawable.icon_click);
                        tbImageView.setAdjustViewBounds(true);
                        tbImageView.setInterceptOnClick(true);
                    }
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        public ImageView h(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imageView)) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.R();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.H();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ng
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.b.getPageActivity());
                boolean g = r05.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                    foreDrawableImageView.setAdjustViewBounds(true);
                    foreDrawableImageView.setInterceptOnClick(true);
                }
                return foreDrawableImageView;
            }
            return (ImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ng<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ov7 a;

        public b(ov7 ov7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ov7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ov7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ng
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ng
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ng
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.e0();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.h0();
                gifView.e0();
                gifView.setImageDrawable(null);
                gifView.i0();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }

        public GifView e(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) {
                gifView.setTag(null);
                if (r05.c().g()) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ng
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.b.getPageActivity());
                boolean g = r05.c().g();
                gifView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends qo6<yo6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ov7 b;

        public c(ov7 ov7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ov7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ov7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qo6
        /* renamed from: d */
        public void a(View view2, yo6 yo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, yo6Var) != null) {
                return;
            }
            this.b.I(view2, yo6Var);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements zx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(ov7 ov7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ov7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zx.b
        public void a(l15 l15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, l15Var, view2) == null) && l15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    l15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    l15Var.objType = 4;
                } else {
                    l15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ov7 a;

        public e(ov7 ov7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ov7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ov7Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof qn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                qn qnVar = (qn) xnVar;
                if (!(qnVar.c() instanceof yo6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                yo6 yo6Var = (yo6) qnVar.c();
                yo6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), yo6Var);
                }
                if (!e28.a(this.a.b, qnVar.c())) {
                    ThreadCardUtils.jumpToPB((l15) yo6Var, view2.getContext(), 1, false, ay.a((Cdo) viewGroup, view2, i));
                    threadCardViewHolder.a().p(new wz.a(1));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ov7 a;

        public f(ov7 ov7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ov7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ov7Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof qn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                qn qnVar = (qn) xnVar;
                if (!(qnVar.c() instanceof yo6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                yo6 yo6Var = (yo6) qnVar.c();
                yo6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), yo6Var);
                }
                ThreadCardUtils.jumpToPB((l15) yo6Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().p(new wz.a(1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ty a;
        public final /* synthetic */ ov7 b;

        public g(ov7 ov7Var, ty tyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ov7Var, tyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ov7Var;
            this.a = tyVar;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            yo6 yo6Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = xnVar instanceof qn;
                int i2 = 0;
                if (z) {
                    qn qnVar = (qn) xnVar;
                    if ((qnVar.c() instanceof yo6) && xnVar != null && qnVar.c() != null && (yo6Var = (yo6) qnVar.c()) != null && (threadData = yo6Var.a) != null && yo6Var.u && threadData.getItem() != null) {
                        if (yo6Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast b = BdToast.b(this.b.b.getContext(), this.b.b.getString(R.string.video_is_checking));
                            b.g(BdToast.ToastIcon.FAILURE);
                            b.q();
                            return;
                        }
                        int intValue = yo6Var.a.getItem().button_link_type.intValue();
                        if (yo6Var.a.getItem().apk_detail != null) {
                            i2 = yo6Var.a.getItem().apk_detail.pkg_source.intValue();
                        }
                        int a = ya5.a(intValue, i2);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(yo6Var.a.getItem());
                        ItemCardHelper.q(this.a.A(), yo6Var.a.getItem().item_id.longValue(), this.a.z(itemData), yo6Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(yo6Var.a.getItem().forum_name, String.valueOf(yo6Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    qn qnVar2 = (qn) xnVar;
                    if (!(qnVar2.c() instanceof yo6)) {
                        return;
                    }
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    yo6 yo6Var2 = (yo6) qnVar2.c();
                    yo6Var2.f = 1;
                    if (this.b.h != null) {
                        this.b.h.a(threadCardViewHolder.getView(), yo6Var2);
                    }
                    ThreadCardUtils.jumpToPB((l15) yo6Var2, view2.getContext(), 1, false, ay.a((Cdo) viewGroup, view2, i));
                    threadCardViewHolder.a().p(new wz.a(1));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ov7 a;

        public h(ov7 ov7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ov7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ov7Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof qn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                qn qnVar = (qn) xnVar;
                if (!(qnVar.c() instanceof yo6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                yo6 yo6Var = (yo6) qnVar.c();
                yo6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), yo6Var);
                }
                ThreadCardUtils.jumpToPB((l15) yo6Var, view2.getContext(), 1, false, ay.a((Cdo) viewGroup, view2, i));
                threadCardViewHolder.a().p(new wz.a(1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements ThreadCommentAndPraiseInfoLayout.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public i(ov7 ov7Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ov7Var, viewGroup, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.m
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(ay.a((Cdo) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ov7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = true;
        this.f = new mg<>(new a(this), 12, 0);
        this.g = new mg<>(new b(this), 20, 0);
        this.h = new c(this);
        this.b = tbPageContext;
        x();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: B */
    public ThreadCardViewHolder<yo6> onCreateHeaderViewHolder(ViewGroup viewGroup, yo6 yo6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, yo6Var)) == null) {
            if (yo6Var == null) {
                return null;
            }
            lz.b bVar = new lz.b(this.b.getPageActivity());
            if (yo6Var.m) {
                zx zxVar = new zx(this.b.getPageActivity());
                zxVar.z(this.a);
                zxVar.f(128);
                zxVar.g(1024);
                zxVar.y(new d(this));
                bVar.o(zxVar);
            } else if (yo6Var.n) {
                bVar.o(new jy(this.b.getPageActivity()));
            }
            lz k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<yo6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: y */
    public ThreadCardViewHolder<yo6> onCreateBottomViewHolder(ViewGroup viewGroup, yo6 yo6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, viewGroup, yo6Var)) == null) {
            lz.b bVar = new lz.b(this.b.getPageActivity(), false);
            nz nzVar = new nz(this.b.getPageActivity());
            r15 r15Var = new r15();
            r15Var.b = 9;
            r15Var.h = 9;
            nzVar.B(r15Var);
            nzVar.D(9);
            nzVar.J("personalize_page");
            nzVar.I(4);
            nzVar.E(1);
            nzVar.f(32);
            nzVar.C(false);
            bVar.m(nzVar);
            lz k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<yo6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    public void J(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cdo) == null) {
            this.d = cdo;
        }
    }

    @Override // com.baidu.tieba.p56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: A */
    public ThreadCardViewHolder<yo6> onCreateExtendViewHolder(ViewGroup viewGroup, yo6 yo6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, viewGroup, yo6Var)) == null) {
            lz.b bVar = new lz.b(this.b.getPageActivity(), false);
            ty tyVar = new ty(this.b.getPageActivity());
            tyVar.F(2);
            tyVar.y();
            tyVar.C(true);
            bVar.h(tyVar);
            bVar.h(new hz(this.b.getPageActivity()));
            bVar.h(new az(this.b.getPageActivity()));
            hy hyVar = new hy(this.b.getPageActivity());
            hyVar.z();
            bVar.h(hyVar);
            ly lyVar = new ly(this.b.getPageActivity());
            lyVar.D(this.e);
            lyVar.C(ImageViewerConfig.FROM_CONCERN);
            bVar.h(lyVar);
            lz k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<yo6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new g(this, tyVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: z */
    public ThreadCardViewHolder<yo6> onCreateContentViewHolder(ViewGroup viewGroup, yo6 yo6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, viewGroup, yo6Var)) == null) {
            lz.b bVar = new lz.b(this.b.getPageActivity(), false);
            if (yo6Var.o) {
                my myVar = new my(this.b.getPageActivity());
                myVar.H(this.f, this.g);
                myVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                myVar.E(1);
                myVar.D(this.e);
                myVar.C(1);
                bVar.n(myVar);
            } else if (yo6Var.p) {
                yy yyVar = new yy(this.b.getPageActivity());
                yyVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                yyVar.u(this.e);
                bVar.n(yyVar);
            } else if (yo6Var.q) {
                wy wyVar = new wy(this.b.getPageActivity());
                wyVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                wyVar.y(this.e);
                bVar.n(wyVar);
            } else if (yo6Var.r) {
                zy zyVar = new zy(this.b.getPageActivity());
                zyVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                zyVar.x(this.e);
                bVar.n(zyVar);
            }
            lz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<yo6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: D */
    public View onFillBottomViewHolder(int i2, View view2, ViewGroup viewGroup, yo6 yo6Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, yo6Var, threadCardViewHolder})) == null) {
            if (yo6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && yo6Var.a != null) {
                yo6Var.B(yo6Var.position + 1);
                threadCardViewHolder.a().r(i2);
                if (threadCardViewHolder.a().f() instanceof nz) {
                    ((nz) threadCardViewHolder.a().f()).H(new i(this, viewGroup, view2, i2));
                }
                if (threadCardViewHolder.a() instanceof o56) {
                    threadCardViewHolder.a().b(this.c);
                }
                threadCardViewHolder.t(false, Align.ALIGN_RIGHT_BOTTOM);
                threadCardViewHolder.e(yo6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: E */
    public View onFillContentViewHolder(int i2, View view2, ViewGroup viewGroup, yo6 yo6Var, ThreadCardViewHolder<yo6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, yo6Var, threadCardViewHolder})) == null) {
            if (yo6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && yo6Var.a != null) {
                yo6Var.B(yo6Var.position + 1);
                jo6.b().a(yo6Var.d("c12351"));
                threadCardViewHolder.a().r(i2);
                if (threadCardViewHolder.a() instanceof o56) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (yo6Var.p) {
                    yy yyVar = (yy) threadCardViewHolder.a().g();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yyVar.f.d.getLayoutParams();
                    layoutParams.width = yo6Var.j;
                    layoutParams.height = yo6Var.k;
                    if (yyVar.f.d.getVisibility() != 8) {
                        yyVar.f.d.setLayoutParams(layoutParams);
                    }
                }
                threadCardViewHolder.e(yo6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: G */
    public View onFillHeaderViewHolder(int i2, View view2, ViewGroup viewGroup, yo6 yo6Var, ThreadCardViewHolder<yo6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, yo6Var, threadCardViewHolder})) == null) {
            if (yo6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && yo6Var.a != null) {
                yo6Var.B(yo6Var.position + 1);
                threadCardViewHolder.a().r(i2);
                if (threadCardViewHolder.a() instanceof o56) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (yo6Var.m) {
                    threadCardViewHolder.t(true, Align.ALIGN_RIGHT_TOP);
                } else if (yo6Var.n) {
                    jo6.b().a(yo6Var.s());
                    n56.c().a(yo6Var.s());
                    d28.p(yo6Var.a, this.a, yo6Var.i());
                }
                threadCardViewHolder.e(yo6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: F */
    public View onFillExtendViewHolder(int i2, View view2, ViewGroup viewGroup, yo6 yo6Var, ThreadCardViewHolder<yo6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, yo6Var, threadCardViewHolder})) == null) {
            if (yo6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && yo6Var.a != null) {
                yo6Var.B(yo6Var.position + 1);
                threadCardViewHolder.a().r(i2);
                if (threadCardViewHolder.a() instanceof o56) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (yo6Var.y) {
                    jo6.b().a(new StatisticItem("c13424"));
                }
                threadCardViewHolder.e(yo6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void I(View view2, yo6 yo6Var) {
        StatisticItem q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, yo6Var) == null) && view2 != null && yo6Var != null && yo6Var.getThreadData() != null && !StringUtils.isNull(yo6Var.getThreadData().getTid())) {
            int id = view2.getId();
            int i2 = 1;
            if (yo6Var.m) {
                if (id == R.id.thread_card_root) {
                    kv7.b(view2, yo6Var, 2);
                } else if (id != R.id.user_avatar && id != R.id.user_name) {
                    if (view2 instanceof TbImageView) {
                        kv7.b(view2, yo6Var, 3);
                    }
                } else {
                    kv7.b(view2, yo6Var, 1);
                }
            } else if (yo6Var.n) {
                jo6.b().d(true);
                if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread) {
                    if (yo6Var.isVideoThreadType()) {
                        q = yo6Var.u();
                    } else {
                        q = yo6Var.q();
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(q));
                    n56.c().i("page_concern", "clk_", q);
                } else {
                    TiebaStatic.log(yo6Var.f());
                    n56.c().i("page_concern", "clk_", yo6Var.f());
                    i2 = 9;
                }
                d28.d(yo6Var.a, this.a, yo6Var.i(), i2);
            } else if (!yo6Var.o && !yo6Var.p && !yo6Var.q && !yo6Var.r) {
                if (yo6Var.v) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    if (threadCardViewHolder != null) {
                        ThreadCardUtils.jumpToPB((l15) yo6Var.getThreadData(), view2.getContext(), 1, false);
                        threadCardViewHolder.a().p(new wz.a(1));
                    }
                } else if (yo6Var.x) {
                    if (view2.getId() == R.id.thread_card_root) {
                        kv7.b(view2, yo6Var, 2);
                    } else if (id == R.id.forum_name_text) {
                        kv7.b(view2, yo6Var, 7);
                    }
                } else if (yo6Var.y) {
                    if (view2.getId() == R.id.thread_card_root) {
                        kv7.b(view2, yo6Var, 2);
                    } else if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c13423");
                        statisticItem.param("obj_locate", 4);
                        statisticItem.param("tid", yo6Var.g);
                        ThreadData threadData = yo6Var.a;
                        if (threadData != null && threadData.getTopAgreePost() != null) {
                            statisticItem.param("pid", yo6Var.a.getTopAgreePost().S());
                        }
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c13423");
                        statisticItem2.param("obj_locate", 2);
                        statisticItem2.param("tid", yo6Var.g);
                        ThreadData threadData2 = yo6Var.a;
                        if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                            statisticItem2.param("pid", yo6Var.a.getTopAgreePost().S());
                        }
                        TiebaStatic.log(statisticItem2);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (id == R.id.god_reply_agree_view) {
                            StatisticItem statisticItem3 = new StatisticItem("c13423");
                            statisticItem3.param("obj_locate", 5);
                            statisticItem3.param("tid", yo6Var.g);
                            ThreadData threadData3 = yo6Var.a;
                            if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                statisticItem3.param("pid", yo6Var.a.getTopAgreePost().S());
                            }
                            TiebaStatic.log(statisticItem3);
                        } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                            StatisticItem statisticItem4 = new StatisticItem("c13423");
                            statisticItem4.param("obj_locate", 3);
                            statisticItem4.param("tid", yo6Var.g);
                            ThreadData threadData4 = yo6Var.a;
                            if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                statisticItem4.param("pid", yo6Var.a.getTopAgreePost().S());
                            }
                            TiebaStatic.log(statisticItem4);
                        }
                    } else {
                        StatisticItem statisticItem5 = new StatisticItem("c13423");
                        statisticItem5.param("obj_locate", 1);
                        statisticItem5.param("tid", yo6Var.g);
                        ThreadData threadData5 = yo6Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", yo6Var.a.getTopAgreePost().S());
                        }
                        TiebaStatic.log(statisticItem5);
                    }
                } else if (yo6Var.A && (view2.getId() == R.id.thread_card_root || view2.getId() == R.id.thread_info_commont_container)) {
                    kv7.b(view2, yo6Var, 2);
                }
            } else if (view2.getId() == R.id.thread_card_root) {
                kv7.b(view2, yo6Var, 2);
            } else if (view2 instanceof TbImageView) {
                kv7.b(view2, yo6Var, 3);
            } else if (view2.getId() == R.id.thread_card_title || view2.getId() == R.id.thread_card_abstract) {
                kv7.b(view2, yo6Var, 2);
            }
            if (id == R.id.thread_info_commont_container || id == R.id.thread_info_commont_img || id == R.id.thread_info_commont_num) {
                kv7.b(view2, yo6Var, 8);
            }
        }
    }

    @Override // com.baidu.tieba.kn
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return yo6.M;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kn
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return yo6.I;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kn
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return yo6.L;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kn
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return yo6.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            gp6.f1101T = "c10705";
            gp6.U = "c10730";
            gp6.V = "c10731";
            gp6.W = "c10704";
            gp6.X = "c10755";
            gp6.Y = "c10710";
            gp6.Z = "c10736";
            gp6.a0 = "c10737";
            gp6.b0 = "c10711";
            gp6.c0 = "c10758";
            gp6.d0 = "c10757";
        }
    }
}
