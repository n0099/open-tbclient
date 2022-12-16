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
public class wz6 extends kn<o56, ThreadCardViewHolder<o56>> implements hr5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public Cdo d;
    public boolean e;
    public og<ImageView> f;
    public og<GifView> g;
    public h56<o56> h;

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
    public View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, o56 o56Var, ThreadCardViewHolder<o56> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, o56Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements pg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wz6 a;

        public a(wz6 wz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wz6Var;
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
                    if (dr4.c().g()) {
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
                boolean g = dr4.c().g();
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
        public final /* synthetic */ wz6 a;

        public b(wz6 wz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wz6Var;
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
                if (dr4.c().g()) {
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
                boolean g = dr4.c().g();
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
    public class c extends h56<o56> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wz6 b;

        public c(wz6 wz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h56
        /* renamed from: d */
        public void a(View view2, o56 o56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, o56Var) != null) {
                return;
            }
            this.b.G(view2, o56Var);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements dx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(wz6 wz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz6Var};
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
        public void a(vr4 vr4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, vr4Var, view2) == null) && vr4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    vr4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    vr4Var.objType = 4;
                } else {
                    vr4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wz6 a;

        public e(wz6 wz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wz6Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof qn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                qn qnVar = (qn) xnVar;
                if (!(qnVar.c() instanceof o56)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                o56 o56Var = (o56) qnVar.c();
                o56Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), o56Var);
                }
                if (!g67.a(this.a.b, qnVar.c())) {
                    ThreadCardUtils.jumpToPB((vr4) o56Var, view2.getContext(), 1, false, ex.a((Cdo) viewGroup, view2, i));
                    threadCardViewHolder.a().p(new zy.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wz6 a;

        public f(wz6 wz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wz6Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof qn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                qn qnVar = (qn) xnVar;
                if (!(qnVar.c() instanceof o56)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                o56 o56Var = (o56) qnVar.c();
                o56Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), o56Var);
                }
                ThreadCardUtils.jumpToPB((vr4) o56Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vx a;
        public final /* synthetic */ wz6 b;

        public g(wz6 wz6Var, vx vxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz6Var, vxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wz6Var;
            this.a = vxVar;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            o56 o56Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = xnVar instanceof qn;
                int i2 = 0;
                if (z) {
                    qn qnVar = (qn) xnVar;
                    if ((qnVar.c() instanceof o56) && xnVar != null && qnVar.c() != null && (o56Var = (o56) qnVar.c()) != null && (threadData = o56Var.a) != null && o56Var.u && threadData.getItem() != null) {
                        if (o56Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast b = BdToast.b(this.b.b.getContext(), this.b.b.getString(R.string.video_is_checking));
                            b.f(BdToast.ToastIcon.FAILURE);
                            b.i();
                            return;
                        }
                        int intValue = o56Var.a.getItem().button_link_type.intValue();
                        if (o56Var.a.getItem().apk_detail != null) {
                            i2 = o56Var.a.getItem().apk_detail.pkg_source.intValue();
                        }
                        int a = yz4.a(intValue, i2);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(o56Var.a.getItem());
                        ItemCardHelper.q(this.a.y(), o56Var.a.getItem().item_id.longValue(), this.a.x(itemData), o56Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(o56Var.a.getItem().forum_name, String.valueOf(o56Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    qn qnVar2 = (qn) xnVar;
                    if (!(qnVar2.c() instanceof o56)) {
                        return;
                    }
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    o56 o56Var2 = (o56) qnVar2.c();
                    o56Var2.f = 1;
                    if (this.b.h != null) {
                        this.b.h.a(threadCardViewHolder.getView(), o56Var2);
                    }
                    ThreadCardUtils.jumpToPB((vr4) o56Var2, view2.getContext(), 1, false, ex.a((Cdo) viewGroup, view2, i));
                    threadCardViewHolder.a().p(new zy.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wz6 a;

        public h(wz6 wz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wz6Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof qn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                qn qnVar = (qn) xnVar;
                if (!(qnVar.c() instanceof o56)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                o56 o56Var = (o56) qnVar.c();
                o56Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), o56Var);
                }
                ThreadCardUtils.jumpToPB((vr4) o56Var, view2.getContext(), 1, false, ex.a((Cdo) viewGroup, view2, i));
                threadCardViewHolder.a().p(new zy.a(1));
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

        public i(wz6 wz6Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz6Var, viewGroup, view2, Integer.valueOf(i)};
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
    public wz6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    public ThreadCardViewHolder<o56> onCreateBottomViewHolder(ViewGroup viewGroup, o56 o56Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, viewGroup, o56Var)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            qy qyVar = new qy(this.b.getPageActivity());
            bs4 bs4Var = new bs4();
            bs4Var.b = 9;
            bs4Var.h = 9;
            qyVar.z(bs4Var);
            qyVar.B(9);
            qyVar.H("personalize_page");
            qyVar.G(4);
            qyVar.C(1);
            qyVar.f(32);
            qyVar.A(false);
            bVar.m(qyVar);
            oy k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<o56> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: z */
    public ThreadCardViewHolder<o56> onCreateHeaderViewHolder(ViewGroup viewGroup, o56 o56Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, viewGroup, o56Var)) == null) {
            if (o56Var == null) {
                return null;
            }
            oy.b bVar = new oy.b(this.b.getPageActivity());
            if (o56Var.m) {
                dx dxVar = new dx(this.b.getPageActivity());
                dxVar.x(this.a);
                dxVar.f(128);
                dxVar.g(1024);
                dxVar.w(new d(this));
                bVar.o(dxVar);
            } else if (o56Var.n) {
                bVar.o(new mx(this.b.getPageActivity()));
            }
            oy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<o56> threadCardViewHolder = new ThreadCardViewHolder<>(k);
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

    @Override // com.baidu.tieba.hr5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: B */
    public View onFillBottomViewHolder(int i2, View view2, ViewGroup viewGroup, o56 o56Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, o56Var, threadCardViewHolder})) == null) {
            if (o56Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && o56Var.a != null) {
                o56Var.I(o56Var.position + 1);
                threadCardViewHolder.a().r(i2);
                if (threadCardViewHolder.a().f() instanceof qy) {
                    ((qy) threadCardViewHolder.a().f()).F(new i(this, viewGroup, view2, i2));
                }
                if (threadCardViewHolder.a() instanceof gr5) {
                    threadCardViewHolder.a().b(this.c);
                }
                threadCardViewHolder.s(false, Align.ALIGN_RIGHT_BOTTOM);
                threadCardViewHolder.e(o56Var);
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
    /* renamed from: C */
    public View onFillContentViewHolder(int i2, View view2, ViewGroup viewGroup, o56 o56Var, ThreadCardViewHolder<o56> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, o56Var, threadCardViewHolder})) == null) {
            if (o56Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && o56Var.a != null) {
                o56Var.I(o56Var.position + 1);
                a56.b().a(o56Var.f("c12351"));
                threadCardViewHolder.a().r(i2);
                if (threadCardViewHolder.a() instanceof gr5) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (o56Var.p) {
                    by byVar = (by) threadCardViewHolder.a().g();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) byVar.f.d.getLayoutParams();
                    layoutParams.width = o56Var.j;
                    layoutParams.height = o56Var.k;
                    if (byVar.f.d.getVisibility() != 8) {
                        byVar.f.d.setLayoutParams(layoutParams);
                    }
                }
                threadCardViewHolder.e(o56Var);
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
    public View onFillHeaderViewHolder(int i2, View view2, ViewGroup viewGroup, o56 o56Var, ThreadCardViewHolder<o56> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, o56Var, threadCardViewHolder})) == null) {
            if (o56Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && o56Var.a != null) {
                o56Var.I(o56Var.position + 1);
                threadCardViewHolder.a().r(i2);
                if (threadCardViewHolder.a() instanceof gr5) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (o56Var.m) {
                    threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
                } else if (o56Var.n) {
                    a56.b().a(o56Var.x());
                    fr5.c().a(o56Var.x());
                    f67.k(o56Var.a, this.a, o56Var.m());
                }
                threadCardViewHolder.e(o56Var);
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
    /* renamed from: D */
    public View onFillExtendViewHolder(int i2, View view2, ViewGroup viewGroup, o56 o56Var, ThreadCardViewHolder<o56> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, o56Var, threadCardViewHolder})) == null) {
            if (o56Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && o56Var.a != null) {
                o56Var.I(o56Var.position + 1);
                threadCardViewHolder.a().r(i2);
                if (threadCardViewHolder.a() instanceof gr5) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (o56Var.y) {
                    a56.b().a(new StatisticItem("c13424"));
                }
                threadCardViewHolder.e(o56Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void G(View view2, o56 o56Var) {
        StatisticItem v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view2, o56Var) == null) && view2 != null && o56Var != null && o56Var.getThreadData() != null && !StringUtils.isNull(o56Var.getThreadData().getTid())) {
            int id = view2.getId();
            int i2 = 1;
            if (o56Var.m) {
                if (id == R.id.thread_card_root) {
                    rz6.b(view2, o56Var, 2);
                } else if (id != R.id.user_avatar && id != R.id.user_name) {
                    if (view2 instanceof TbImageView) {
                        rz6.b(view2, o56Var, 3);
                    }
                } else {
                    rz6.b(view2, o56Var, 1);
                }
            } else if (o56Var.n) {
                a56.b().d(true);
                if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread) {
                    if (o56Var.isVideoThreadType()) {
                        v = o56Var.y();
                    } else {
                        v = o56Var.v();
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(v));
                    fr5.c().i("page_concern", "clk_", v);
                } else {
                    TiebaStatic.log(o56Var.i());
                    fr5.c().i("page_concern", "clk_", o56Var.i());
                    i2 = 9;
                }
                f67.d(o56Var.a, this.a, o56Var.m(), i2);
            } else if (!o56Var.o && !o56Var.p && !o56Var.q && !o56Var.r) {
                if (o56Var.v) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    if (threadCardViewHolder != null) {
                        ThreadCardUtils.jumpToPB((vr4) o56Var.getThreadData(), view2.getContext(), 1, false);
                        threadCardViewHolder.a().p(new zy.a(1));
                    }
                } else if (o56Var.x) {
                    if (view2.getId() == R.id.thread_card_root) {
                        rz6.b(view2, o56Var, 2);
                    } else if (id == R.id.forum_name_text) {
                        rz6.b(view2, o56Var, 7);
                    }
                } else if (o56Var.y) {
                    if (view2.getId() == R.id.thread_card_root) {
                        rz6.b(view2, o56Var, 2);
                    } else if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c13423");
                        statisticItem.param("obj_locate", 4);
                        statisticItem.param("tid", o56Var.g);
                        ThreadData threadData = o56Var.a;
                        if (threadData != null && threadData.getTopAgreePost() != null) {
                            statisticItem.param("pid", o56Var.a.getTopAgreePost().M());
                        }
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c13423");
                        statisticItem2.param("obj_locate", 2);
                        statisticItem2.param("tid", o56Var.g);
                        ThreadData threadData2 = o56Var.a;
                        if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                            statisticItem2.param("pid", o56Var.a.getTopAgreePost().M());
                        }
                        TiebaStatic.log(statisticItem2);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (id == R.id.god_reply_agree_view) {
                            StatisticItem statisticItem3 = new StatisticItem("c13423");
                            statisticItem3.param("obj_locate", 5);
                            statisticItem3.param("tid", o56Var.g);
                            ThreadData threadData3 = o56Var.a;
                            if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                statisticItem3.param("pid", o56Var.a.getTopAgreePost().M());
                            }
                            TiebaStatic.log(statisticItem3);
                        } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                            StatisticItem statisticItem4 = new StatisticItem("c13423");
                            statisticItem4.param("obj_locate", 3);
                            statisticItem4.param("tid", o56Var.g);
                            ThreadData threadData4 = o56Var.a;
                            if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                statisticItem4.param("pid", o56Var.a.getTopAgreePost().M());
                            }
                            TiebaStatic.log(statisticItem4);
                        }
                    } else {
                        StatisticItem statisticItem5 = new StatisticItem("c13423");
                        statisticItem5.param("obj_locate", 1);
                        statisticItem5.param("tid", o56Var.g);
                        ThreadData threadData5 = o56Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", o56Var.a.getTopAgreePost().M());
                        }
                        TiebaStatic.log(statisticItem5);
                    }
                } else if (o56Var.A && (view2.getId() == R.id.thread_card_root || view2.getId() == R.id.thread_info_commont_container)) {
                    rz6.b(view2, o56Var, 2);
                }
            } else if (view2.getId() == R.id.thread_card_root) {
                rz6.b(view2, o56Var, 2);
            } else if (view2 instanceof TbImageView) {
                rz6.b(view2, o56Var, 3);
            } else if (view2.getId() == R.id.thread_card_title || view2.getId() == R.id.thread_card_abstract) {
                rz6.b(view2, o56Var, 2);
            }
            if (id == R.id.thread_info_commont_container || id == R.id.thread_info_commont_img || id == R.id.thread_info_commont_num) {
                rz6.b(view2, o56Var, 8);
            }
        }
    }

    @Override // com.baidu.tieba.kn
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return o56.M;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kn
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return o56.I;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kn
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return o56.L;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kn
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return o56.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            w56.R = "c10705";
            w56.S = "c10730";
            w56.T = "c10731";
            w56.U = "c10704";
            w56.V = "c10755";
            w56.W = "c10710";
            w56.X = "c10736";
            w56.Y = "c10737";
            w56.Z = "c10711";
            w56.a0 = "c10758";
            w56.b0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: x */
    public ThreadCardViewHolder<o56> onCreateContentViewHolder(ViewGroup viewGroup, o56 o56Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, viewGroup, o56Var)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            if (o56Var.o) {
                px pxVar = new px(this.b.getPageActivity());
                pxVar.G(this.f, this.g);
                pxVar.B(ImageViewerConfig.FROM_CONCERN);
                pxVar.D(1);
                pxVar.C(this.e);
                pxVar.A(1);
                bVar.n(pxVar);
            } else if (o56Var.p) {
                by byVar = new by(this.b.getPageActivity());
                byVar.u(ImageViewerConfig.FROM_CONCERN);
                byVar.v(this.e);
                bVar.n(byVar);
            } else if (o56Var.q) {
                yx yxVar = new yx(this.b.getPageActivity());
                yxVar.w(ImageViewerConfig.FROM_CONCERN);
                yxVar.x(this.e);
                bVar.n(yxVar);
            } else if (o56Var.r) {
                cy cyVar = new cy(this.b.getPageActivity());
                cyVar.v(ImageViewerConfig.FROM_CONCERN);
                cyVar.w(this.e);
                bVar.n(cyVar);
            }
            oy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<o56> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: y */
    public ThreadCardViewHolder<o56> onCreateExtendViewHolder(ViewGroup viewGroup, o56 o56Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, viewGroup, o56Var)) == null) {
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
            k.s(1);
            ThreadCardViewHolder<o56> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new g(this, vxVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }
}
