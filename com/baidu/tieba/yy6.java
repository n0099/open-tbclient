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
import com.baidu.tieba.dx;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class yy6 extends kn<s46, ThreadCardViewHolder<s46>> implements lq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public Cdo d;
    public boolean e;
    public og<ImageView> f;
    public og<GifView> g;
    public l46<s46> h;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: A */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            return null;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: F */
    public View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, s46 s46Var, ThreadCardViewHolder<s46> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, s46Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements pg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yy6 a;

        public a(yy6 yy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yy6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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
                    foreDrawableImageView.O();
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
                    if (br4.c().g()) {
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
                    foreDrawableImageView.O();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.F();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.b.getPageActivity());
                boolean g = br4.c().g();
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

    /* loaded from: classes6.dex */
    public class b implements pg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yy6 a;

        public b(yy6 yy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yy6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.b0();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.e0();
                gifView.b0();
                gifView.setImageDrawable(null);
                gifView.f0();
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
                if (br4.c().g()) {
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
        @Override // com.baidu.tieba.pg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.b.getPageActivity());
                boolean g = br4.c().g();
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

    /* loaded from: classes6.dex */
    public class c extends l46<s46> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yy6 b;

        public c(yy6 yy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yy6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l46
        /* renamed from: d */
        public void a(View view2, s46 s46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, s46Var) != null) {
                return;
            }
            this.b.G(view2, s46Var);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements dx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(yy6 yy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.dx.b
        public void a(sr4 sr4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, sr4Var, view2) == null) && sr4Var != null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092505) {
                    sr4Var.objType = 3;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0924d7) {
                    sr4Var.objType = 4;
                } else {
                    sr4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yy6 a;

        public e(yy6 yy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yy6Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof qn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                qn qnVar = (qn) xnVar;
                if (!(qnVar.c() instanceof s46)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                s46 s46Var = (s46) qnVar.c();
                s46Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), s46Var);
                }
                if (!h57.a(this.a.b, qnVar.c())) {
                    ThreadCardUtils.jumpToPB((sr4) s46Var, view2.getContext(), 1, false, ex.a((Cdo) viewGroup, view2, i));
                    threadCardViewHolder.a().o(new zy.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yy6 a;

        public f(yy6 yy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yy6Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof qn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                qn qnVar = (qn) xnVar;
                if (!(qnVar.c() instanceof s46)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                s46 s46Var = (s46) qnVar.c();
                s46Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), s46Var);
                }
                ThreadCardUtils.jumpToPB((sr4) s46Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().o(new zy.a(1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vx a;
        public final /* synthetic */ yy6 b;

        public g(yy6 yy6Var, vx vxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy6Var, vxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yy6Var;
            this.a = vxVar;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            s46 s46Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = xnVar instanceof qn;
                int i2 = 0;
                if (z) {
                    qn qnVar = (qn) xnVar;
                    if ((qnVar.c() instanceof s46) && xnVar != null && qnVar.c() != null && (s46Var = (s46) qnVar.c()) != null && (threadData = s46Var.a) != null && s46Var.u && threadData.getItem() != null) {
                        if (s46Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast b = BdToast.b(this.b.b.getContext(), this.b.b.getString(R.string.obfuscated_res_0x7f0f1576));
                            b.f(BdToast.ToastIcon.FAILURE);
                            b.i();
                            return;
                        }
                        int intValue = s46Var.a.getItem().button_link_type.intValue();
                        if (s46Var.a.getItem().apk_detail != null) {
                            i2 = s46Var.a.getItem().apk_detail.pkg_source.intValue();
                        }
                        int a = xz4.a(intValue, i2);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(s46Var.a.getItem());
                        ItemCardHelper.q(this.a.y(), s46Var.a.getItem().item_id.longValue(), this.a.x(itemData), s46Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(s46Var.a.getItem().forum_name, String.valueOf(s46Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    qn qnVar2 = (qn) xnVar;
                    if (!(qnVar2.c() instanceof s46)) {
                        return;
                    }
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    s46 s46Var2 = (s46) qnVar2.c();
                    s46Var2.f = 1;
                    if (this.b.h != null) {
                        this.b.h.a(threadCardViewHolder.getView(), s46Var2);
                    }
                    ThreadCardUtils.jumpToPB((sr4) s46Var2, view2.getContext(), 1, false, ex.a((Cdo) viewGroup, view2, i));
                    threadCardViewHolder.a().o(new zy.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yy6 a;

        public h(yy6 yy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yy6Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof qn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                qn qnVar = (qn) xnVar;
                if (!(qnVar.c() instanceof s46)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                s46 s46Var = (s46) qnVar.c();
                s46Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), s46Var);
                }
                ThreadCardUtils.jumpToPB((sr4) s46Var, view2.getContext(), 1, false, ex.a((Cdo) viewGroup, view2, i));
                threadCardViewHolder.a().o(new zy.a(1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ThreadCommentAndPraiseInfoLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public i(yy6 yy6Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy6Var, viewGroup, view2, Integer.valueOf(i)};
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

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.k
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(ex.a((Cdo) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yy6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new og<>(new a(this), 12, 0);
        this.g = new og<>(new b(this), 20, 0);
        this.h = new c(this);
        this.b = tbPageContext;
        v();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: w */
    public ThreadCardViewHolder<s46> onCreateBottomViewHolder(ViewGroup viewGroup, s46 s46Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, viewGroup, s46Var)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            qy qyVar = new qy(this.b.getPageActivity());
            yr4 yr4Var = new yr4();
            yr4Var.b = 9;
            yr4Var.h = 9;
            qyVar.z(yr4Var);
            qyVar.B(9);
            qyVar.H("personalize_page");
            qyVar.G(4);
            qyVar.C(1);
            qyVar.f(32);
            qyVar.A(false);
            bVar.m(qyVar);
            oy k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder<s46> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: z */
    public ThreadCardViewHolder<s46> onCreateHeaderViewHolder(ViewGroup viewGroup, s46 s46Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, viewGroup, s46Var)) == null) {
            if (s46Var == null) {
                return null;
            }
            oy.b bVar = new oy.b(this.b.getPageActivity());
            if (s46Var.m) {
                dx dxVar = new dx(this.b.getPageActivity());
                dxVar.x(this.a);
                dxVar.f(128);
                dxVar.g(1024);
                dxVar.w(new d(this));
                bVar.o(dxVar);
            } else if (s46Var.n) {
                bVar.o(new mx(this.b.getPageActivity()));
            }
            oy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder<s46> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    public void H(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cdo) == null) {
            this.d = cdo;
        }
    }

    @Override // com.baidu.tieba.lq5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: B */
    public View onFillBottomViewHolder(int i2, View view2, ViewGroup viewGroup, s46 s46Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, s46Var, threadCardViewHolder})) == null) {
            if (s46Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && s46Var.a != null) {
                s46Var.I(s46Var.position + 1);
                threadCardViewHolder.a().q(i2);
                if (threadCardViewHolder.a().f() instanceof qy) {
                    ((qy) threadCardViewHolder.a().f()).F(new i(this, viewGroup, view2, i2));
                }
                if (threadCardViewHolder.a() instanceof kq5) {
                    threadCardViewHolder.a().b(this.c);
                }
                threadCardViewHolder.s(false, Align.ALIGN_RIGHT_BOTTOM);
                threadCardViewHolder.e(s46Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: C */
    public View onFillContentViewHolder(int i2, View view2, ViewGroup viewGroup, s46 s46Var, ThreadCardViewHolder<s46> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, s46Var, threadCardViewHolder})) == null) {
            if (s46Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && s46Var.a != null) {
                s46Var.I(s46Var.position + 1);
                e46.b().a(s46Var.f("c12351"));
                threadCardViewHolder.a().q(i2);
                if (threadCardViewHolder.a() instanceof kq5) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (s46Var.p) {
                    by byVar = (by) threadCardViewHolder.a().g();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) byVar.f.d.getLayoutParams();
                    layoutParams.width = s46Var.j;
                    layoutParams.height = s46Var.k;
                    if (byVar.f.d.getVisibility() != 8) {
                        byVar.f.d.setLayoutParams(layoutParams);
                    }
                }
                threadCardViewHolder.e(s46Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: E */
    public View onFillHeaderViewHolder(int i2, View view2, ViewGroup viewGroup, s46 s46Var, ThreadCardViewHolder<s46> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, s46Var, threadCardViewHolder})) == null) {
            if (s46Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && s46Var.a != null) {
                s46Var.I(s46Var.position + 1);
                threadCardViewHolder.a().q(i2);
                if (threadCardViewHolder.a() instanceof kq5) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (s46Var.m) {
                    threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
                } else if (s46Var.n) {
                    e46.b().a(s46Var.B());
                    jq5.c().a(s46Var.B());
                    g57.i(s46Var.a, this.a, s46Var.n());
                }
                threadCardViewHolder.e(s46Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: D */
    public View onFillExtendViewHolder(int i2, View view2, ViewGroup viewGroup, s46 s46Var, ThreadCardViewHolder<s46> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, s46Var, threadCardViewHolder})) == null) {
            if (s46Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && s46Var.a != null) {
                s46Var.I(s46Var.position + 1);
                threadCardViewHolder.a().q(i2);
                if (threadCardViewHolder.a() instanceof kq5) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (s46Var.y) {
                    e46.b().a(new StatisticItem("c13424"));
                }
                threadCardViewHolder.e(s46Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void G(View view2, s46 s46Var) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view2, s46Var) == null) && view2 != null && s46Var != null && s46Var.getThreadData() != null && !StringUtils.isNull(s46Var.getThreadData().getTid())) {
            int id = view2.getId();
            int i2 = 1;
            if (s46Var.m) {
                if (id == R.id.obfuscated_res_0x7f0921dd) {
                    ty6.b(view2, s46Var, 2);
                } else if (id != R.id.obfuscated_res_0x7f0924d7 && id != R.id.obfuscated_res_0x7f092505) {
                    if (view2 instanceof TbImageView) {
                        ty6.b(view2, s46Var, 3);
                    }
                } else {
                    ty6.b(view2, s46Var, 1);
                }
            } else if (s46Var.n) {
                e46.b().d(true);
                if (id != R.id.obfuscated_res_0x7f090a90 && id != R.id.obfuscated_res_0x7f090a8f && id != R.id.obfuscated_res_0x7f090a91 && id != R.id.obfuscated_res_0x7f090a92) {
                    if (s46Var.isVideoThreadType()) {
                        A = s46Var.C();
                    } else {
                        A = s46Var.A();
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
                    jq5.c().i("page_concern", "clk_", A);
                } else {
                    TiebaStatic.log(s46Var.j());
                    jq5.c().i("page_concern", "clk_", s46Var.j());
                    i2 = 9;
                }
                g57.d(s46Var.a, this.a, s46Var.n(), i2);
            } else if (!s46Var.o && !s46Var.p && !s46Var.q && !s46Var.r) {
                if (s46Var.v) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    if (threadCardViewHolder != null) {
                        ThreadCardUtils.jumpToPB((sr4) s46Var.getThreadData(), view2.getContext(), 1, false);
                        threadCardViewHolder.a().o(new zy.a(1));
                    }
                } else if (s46Var.x) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f0921dd) {
                        ty6.b(view2, s46Var, 2);
                    } else if (id == R.id.obfuscated_res_0x7f090aad) {
                        ty6.b(view2, s46Var, 7);
                    }
                } else if (s46Var.y) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f0921dd) {
                        ty6.b(view2, s46Var, 2);
                    } else if (id == R.id.obfuscated_res_0x7f090d03) {
                        StatisticItem statisticItem = new StatisticItem("c13423");
                        statisticItem.param("obj_locate", 4);
                        statisticItem.param("tid", s46Var.g);
                        ThreadData threadData = s46Var.a;
                        if (threadData != null && threadData.getTopAgreePost() != null) {
                            statisticItem.param("pid", s46Var.a.getTopAgreePost().M());
                        }
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.obfuscated_res_0x7f090cfe) {
                        StatisticItem statisticItem2 = new StatisticItem("c13423");
                        statisticItem2.param("obj_locate", 2);
                        statisticItem2.param("tid", s46Var.g);
                        ThreadData threadData2 = s46Var.a;
                        if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                            statisticItem2.param("pid", s46Var.a.getTopAgreePost().M());
                        }
                        TiebaStatic.log(statisticItem2);
                    } else if (id != R.id.obfuscated_res_0x7f090d01 && id != R.id.obfuscated_res_0x7f090d02) {
                        if (id == R.id.obfuscated_res_0x7f090cfd) {
                            StatisticItem statisticItem3 = new StatisticItem("c13423");
                            statisticItem3.param("obj_locate", 5);
                            statisticItem3.param("tid", s46Var.g);
                            ThreadData threadData3 = s46Var.a;
                            if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                statisticItem3.param("pid", s46Var.a.getTopAgreePost().M());
                            }
                            TiebaStatic.log(statisticItem3);
                        } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.obfuscated_res_0x7f090cff) instanceof Integer)) {
                            StatisticItem statisticItem4 = new StatisticItem("c13423");
                            statisticItem4.param("obj_locate", 3);
                            statisticItem4.param("tid", s46Var.g);
                            ThreadData threadData4 = s46Var.a;
                            if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                statisticItem4.param("pid", s46Var.a.getTopAgreePost().M());
                            }
                            TiebaStatic.log(statisticItem4);
                        }
                    } else {
                        StatisticItem statisticItem5 = new StatisticItem("c13423");
                        statisticItem5.param("obj_locate", 1);
                        statisticItem5.param("tid", s46Var.g);
                        ThreadData threadData5 = s46Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", s46Var.a.getTopAgreePost().M());
                        }
                        TiebaStatic.log(statisticItem5);
                    }
                } else if (s46Var.A && (view2.getId() == R.id.obfuscated_res_0x7f0921dd || view2.getId() == R.id.obfuscated_res_0x7f0921f1)) {
                    ty6.b(view2, s46Var, 2);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0921dd) {
                ty6.b(view2, s46Var, 2);
            } else if (view2 instanceof TbImageView) {
                ty6.b(view2, s46Var, 3);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0921de || view2.getId() == R.id.obfuscated_res_0x7f0921d0) {
                ty6.b(view2, s46Var, 2);
            }
            if (id == R.id.obfuscated_res_0x7f0921f1 || id == R.id.obfuscated_res_0x7f0921f3 || id == R.id.obfuscated_res_0x7f0921f4) {
                ty6.b(view2, s46Var, 8);
            }
        }
    }

    @Override // com.baidu.tieba.kn
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return s46.M;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kn
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return s46.I;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kn
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return s46.L;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kn
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return s46.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            a56.R = "c10705";
            a56.S = "c10730";
            a56.T = "c10731";
            a56.U = "c10704";
            a56.V = "c10755";
            a56.W = "c10710";
            a56.X = "c10736";
            a56.Y = "c10737";
            a56.Z = "c10711";
            a56.a0 = "c10758";
            a56.b0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: x */
    public ThreadCardViewHolder<s46> onCreateContentViewHolder(ViewGroup viewGroup, s46 s46Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, viewGroup, s46Var)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            if (s46Var.o) {
                px pxVar = new px(this.b.getPageActivity());
                pxVar.G(this.f, this.g);
                pxVar.B(ImageViewerConfig.FROM_CONCERN);
                pxVar.D(1);
                pxVar.C(this.e);
                pxVar.A(1);
                bVar.n(pxVar);
            } else if (s46Var.p) {
                by byVar = new by(this.b.getPageActivity());
                byVar.u(ImageViewerConfig.FROM_CONCERN);
                byVar.v(this.e);
                bVar.n(byVar);
            } else if (s46Var.q) {
                yx yxVar = new yx(this.b.getPageActivity());
                yxVar.w(ImageViewerConfig.FROM_CONCERN);
                yxVar.x(this.e);
                bVar.n(yxVar);
            } else if (s46Var.r) {
                cy cyVar = new cy(this.b.getPageActivity());
                cyVar.v(ImageViewerConfig.FROM_CONCERN);
                cyVar.w(this.e);
                bVar.n(cyVar);
            }
            oy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder<s46> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: y */
    public ThreadCardViewHolder<s46> onCreateExtendViewHolder(ViewGroup viewGroup, s46 s46Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, viewGroup, s46Var)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            vx vxVar = new vx(this.b.getPageActivity());
            vxVar.D(2);
            vxVar.w();
            vxVar.A(true);
            bVar.h(vxVar);
            bVar.h(new ky(this.b.getPageActivity()));
            bVar.h(new dy(this.b.getPageActivity()));
            kx kxVar = new kx(this.b.getPageActivity());
            kxVar.x();
            bVar.h(kxVar);
            ox oxVar = new ox(this.b.getPageActivity());
            oxVar.B(this.e);
            oxVar.A(ImageViewerConfig.FROM_CONCERN);
            bVar.h(oxVar);
            oy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder<s46> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new g(this, vxVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }
}
