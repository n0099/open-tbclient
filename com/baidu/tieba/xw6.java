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
import com.baidu.tieba.dz;
import com.baidu.tieba.jx;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xw6 extends qn<p26, ThreadCardViewHolder<p26>> implements to5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public jo d;
    public boolean e;
    public ug<ImageView> f;
    public ug<GifView> g;
    public i26<p26> h;

    /* loaded from: classes6.dex */
    public class a implements vg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw6 a;

        public a(xw6 xw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (hq4.c().g()) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.b.getPageActivity());
                boolean g = hq4.c().g();
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
    }

    /* loaded from: classes6.dex */
    public class b implements vg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw6 a;

        public b(xw6 xw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        public GifView e(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) {
                gifView.setTag(null);
                if (hq4.c().g()) {
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
        @Override // com.baidu.tieba.vg
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.b.getPageActivity());
                boolean g = hq4.c().g();
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
    }

    /* loaded from: classes6.dex */
    public class c extends i26<p26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw6 b;

        public c(xw6 xw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xw6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, p26 p26Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, p26Var) == null) {
                this.b.G(view2, p26Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements jx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(xw6 xw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.jx.b
        public void a(yq4 yq4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, yq4Var, view2) == null) || yq4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0924b6) {
                yq4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092488) {
                yq4Var.objType = 4;
            } else {
                yq4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw6 a;

        public e(xw6 xw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof wn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                wn wnVar = (wn) cdo;
                if (wnVar.c() instanceof p26) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    p26 p26Var = (p26) wnVar.c();
                    p26Var.f = 1;
                    if (this.a.h != null) {
                        this.a.h.a(threadCardViewHolder.getView(), p26Var);
                    }
                    if (e37.a(this.a.b, wnVar.c())) {
                        return;
                    }
                    ThreadCardUtils.jumpToPB((yq4) p26Var, view2.getContext(), 1, false, kx.a((jo) viewGroup, view2, i));
                    threadCardViewHolder.a().o(new dz.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw6 a;

        public f(xw6 xw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof wn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                wn wnVar = (wn) cdo;
                if (wnVar.c() instanceof p26) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    p26 p26Var = (p26) wnVar.c();
                    p26Var.f = 1;
                    if (this.a.h != null) {
                        this.a.h.a(threadCardViewHolder.getView(), p26Var);
                    }
                    ThreadCardUtils.jumpToPB((yq4) p26Var, view2.getContext(), 1, false);
                    threadCardViewHolder.a().o(new dz.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx a;
        public final /* synthetic */ xw6 b;

        public g(xw6 xw6Var, zx zxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw6Var, zxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xw6Var;
            this.a = zxVar;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            p26 p26Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = cdo instanceof wn;
                if (z) {
                    wn wnVar = (wn) cdo;
                    if ((wnVar.c() instanceof p26) && cdo != null && wnVar.c() != null && (p26Var = (p26) wnVar.c()) != null && (threadData = p26Var.a) != null && p26Var.u && threadData.getItem() != null) {
                        if (p26Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast b = BdToast.b(this.b.b.getContext(), this.b.b.getString(R.string.obfuscated_res_0x7f0f1537));
                            b.f(BdToast.ToastIcon.FAILURE);
                            b.i();
                            return;
                        }
                        int a = xy4.a(p26Var.a.getItem().button_link_type.intValue(), p26Var.a.getItem().apk_detail != null ? p26Var.a.getItem().apk_detail.pkg_source.intValue() : 0);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(p26Var.a.getItem());
                        ItemCardHelper.q(this.a.v(), p26Var.a.getItem().item_id.longValue(), this.a.u(itemData), p26Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(p26Var.a.getItem().forum_name, String.valueOf(p26Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    wn wnVar2 = (wn) cdo;
                    if (wnVar2.c() instanceof p26) {
                        ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                        p26 p26Var2 = (p26) wnVar2.c();
                        p26Var2.f = 1;
                        if (this.b.h != null) {
                            this.b.h.a(threadCardViewHolder.getView(), p26Var2);
                        }
                        ThreadCardUtils.jumpToPB((yq4) p26Var2, view2.getContext(), 1, false, kx.a((jo) viewGroup, view2, i));
                        threadCardViewHolder.a().o(new dz.a(1));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw6 a;

        public h(xw6 xw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof wn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                wn wnVar = (wn) cdo;
                if (wnVar.c() instanceof p26) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    p26 p26Var = (p26) wnVar.c();
                    p26Var.f = 1;
                    if (this.a.h != null) {
                        this.a.h.a(threadCardViewHolder.getView(), p26Var);
                    }
                    ThreadCardUtils.jumpToPB((yq4) p26Var, view2.getContext(), 1, false, kx.a((jo) viewGroup, view2, i));
                    threadCardViewHolder.a().o(new dz.a(1));
                }
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

        public i(xw6 xw6Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw6Var, viewGroup, view2, Integer.valueOf(i)};
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
                ((PbActivityConfig) intentConfig).setVideoOriginArea(kx.a((jo) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xw6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new ug<>(new a(this), 12, 0);
        this.g = new ug<>(new b(this), 20, 0);
        this.h = new c(this);
        this.b = tbPageContext;
        v();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
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
    @Override // com.baidu.tieba.qn
    /* renamed from: B */
    public View onFillBottomViewHolder(int i2, View view2, ViewGroup viewGroup, p26 p26Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, p26Var, threadCardViewHolder})) == null) {
            if (p26Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || p26Var.a == null) {
                return null;
            }
            p26Var.I(p26Var.position + 1);
            threadCardViewHolder.a().q(i2);
            if (threadCardViewHolder.a().f() instanceof uy) {
                ((uy) threadCardViewHolder.a().f()).C(new i(this, viewGroup, view2, i2));
            }
            if (threadCardViewHolder.a() instanceof so5) {
                threadCardViewHolder.a().b(this.c);
            }
            threadCardViewHolder.s(false, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.e(p26Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.h);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: C */
    public View onFillContentViewHolder(int i2, View view2, ViewGroup viewGroup, p26 p26Var, ThreadCardViewHolder<p26> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, p26Var, threadCardViewHolder})) == null) {
            if (p26Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || p26Var.a == null) {
                return null;
            }
            p26Var.I(p26Var.position + 1);
            b26.b().a(p26Var.f("c12351"));
            threadCardViewHolder.a().q(i2);
            if (threadCardViewHolder.a() instanceof so5) {
                threadCardViewHolder.a().b(this.c);
            }
            if (p26Var.p) {
                fy fyVar = (fy) threadCardViewHolder.a().g();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fyVar.f.d.getLayoutParams();
                layoutParams.width = p26Var.j;
                layoutParams.height = p26Var.k;
                if (fyVar.f.d.getVisibility() != 8) {
                    fyVar.f.d.setLayoutParams(layoutParams);
                }
            }
            threadCardViewHolder.e(p26Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.h);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: D */
    public View onFillExtendViewHolder(int i2, View view2, ViewGroup viewGroup, p26 p26Var, ThreadCardViewHolder<p26> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, p26Var, threadCardViewHolder})) == null) {
            if (p26Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || p26Var.a == null) {
                return null;
            }
            p26Var.I(p26Var.position + 1);
            threadCardViewHolder.a().q(i2);
            if (threadCardViewHolder.a() instanceof so5) {
                threadCardViewHolder.a().b(this.c);
            }
            if (p26Var.y) {
                b26.b().a(new StatisticItem("c13424"));
            }
            threadCardViewHolder.e(p26Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.h);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: E */
    public View onFillHeaderViewHolder(int i2, View view2, ViewGroup viewGroup, p26 p26Var, ThreadCardViewHolder<p26> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, p26Var, threadCardViewHolder})) == null) {
            if (p26Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || p26Var.a == null) {
                return null;
            }
            p26Var.I(p26Var.position + 1);
            threadCardViewHolder.a().q(i2);
            if (threadCardViewHolder.a() instanceof so5) {
                threadCardViewHolder.a().b(this.c);
            }
            if (p26Var.m) {
                threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
            } else if (p26Var.n) {
                b26.b().a(p26Var.B());
                ro5.c().a(p26Var.B());
                d37.i(p26Var.a, this.a, p26Var.n());
            }
            threadCardViewHolder.e(p26Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.h);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: F */
    public View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, p26 p26Var, ThreadCardViewHolder<p26> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, p26Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void G(View view2, p26 p26Var) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, view2, p26Var) == null) || view2 == null || p26Var == null || p26Var.getThreadData() == null || StringUtils.isNull(p26Var.getThreadData().getTid())) {
            return;
        }
        int id = view2.getId();
        int i2 = 1;
        if (p26Var.m) {
            if (id == R.id.obfuscated_res_0x7f092180) {
                sw6.b(view2, p26Var, 2);
            } else if (id != R.id.obfuscated_res_0x7f092488 && id != R.id.obfuscated_res_0x7f0924b6) {
                if (view2 instanceof TbImageView) {
                    sw6.b(view2, p26Var, 3);
                }
            } else {
                sw6.b(view2, p26Var, 1);
            }
        } else if (p26Var.n) {
            b26.b().d(true);
            if (id != R.id.obfuscated_res_0x7f090a72 && id != R.id.obfuscated_res_0x7f090a71 && id != R.id.obfuscated_res_0x7f090a73 && id != R.id.obfuscated_res_0x7f090a74) {
                if (p26Var.isVideoThreadType()) {
                    A = p26Var.C();
                } else {
                    A = p26Var.A();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
                ro5.c().i("page_concern", "clk_", A);
            } else {
                TiebaStatic.log(p26Var.j());
                ro5.c().i("page_concern", "clk_", p26Var.j());
                i2 = 9;
            }
            d37.d(p26Var.a, this.a, p26Var.n(), i2);
        } else if (!p26Var.o && !p26Var.p && !p26Var.q && !p26Var.r) {
            if (p26Var.v) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                if (threadCardViewHolder != null) {
                    ThreadCardUtils.jumpToPB((yq4) p26Var.getThreadData(), view2.getContext(), 1, false);
                    threadCardViewHolder.a().o(new dz.a(1));
                }
            } else if (p26Var.x) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092180) {
                    sw6.b(view2, p26Var, 2);
                } else if (id == R.id.obfuscated_res_0x7f090a8f) {
                    sw6.b(view2, p26Var, 7);
                }
            } else if (p26Var.y) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092180) {
                    sw6.b(view2, p26Var, 2);
                } else if (id == R.id.obfuscated_res_0x7f090cd9) {
                    StatisticItem statisticItem = new StatisticItem("c13423");
                    statisticItem.param("obj_locate", 4);
                    statisticItem.param("tid", p26Var.g);
                    ThreadData threadData = p26Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", p26Var.a.getTopAgreePost().L());
                    }
                    TiebaStatic.log(statisticItem);
                } else if (id == R.id.obfuscated_res_0x7f090cd4) {
                    StatisticItem statisticItem2 = new StatisticItem("c13423");
                    statisticItem2.param("obj_locate", 2);
                    statisticItem2.param("tid", p26Var.g);
                    ThreadData threadData2 = p26Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", p26Var.a.getTopAgreePost().L());
                    }
                    TiebaStatic.log(statisticItem2);
                } else if (id == R.id.obfuscated_res_0x7f090cd7 || id == R.id.obfuscated_res_0x7f090cd8) {
                    StatisticItem statisticItem3 = new StatisticItem("c13423");
                    statisticItem3.param("obj_locate", 1);
                    statisticItem3.param("tid", p26Var.g);
                    ThreadData threadData3 = p26Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", p26Var.a.getTopAgreePost().L());
                    }
                    TiebaStatic.log(statisticItem3);
                } else if (id == R.id.obfuscated_res_0x7f090cd3) {
                    StatisticItem statisticItem4 = new StatisticItem("c13423");
                    statisticItem4.param("obj_locate", 5);
                    statisticItem4.param("tid", p26Var.g);
                    ThreadData threadData4 = p26Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", p26Var.a.getTopAgreePost().L());
                    }
                    TiebaStatic.log(statisticItem4);
                } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.obfuscated_res_0x7f090cd5) instanceof Integer)) {
                    StatisticItem statisticItem5 = new StatisticItem("c13423");
                    statisticItem5.param("obj_locate", 3);
                    statisticItem5.param("tid", p26Var.g);
                    ThreadData threadData5 = p26Var.a;
                    if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                        statisticItem5.param("pid", p26Var.a.getTopAgreePost().L());
                    }
                    TiebaStatic.log(statisticItem5);
                }
            } else if (p26Var.A && (view2.getId() == R.id.obfuscated_res_0x7f092180 || view2.getId() == R.id.obfuscated_res_0x7f092194)) {
                sw6.b(view2, p26Var, 2);
            }
        } else if (view2.getId() == R.id.obfuscated_res_0x7f092180) {
            sw6.b(view2, p26Var, 2);
        } else if (view2 instanceof TbImageView) {
            sw6.b(view2, p26Var, 3);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f092181 || view2.getId() == R.id.obfuscated_res_0x7f092173) {
            sw6.b(view2, p26Var, 2);
        }
        if (id == R.id.obfuscated_res_0x7f092194 || id == R.id.obfuscated_res_0x7f092196 || id == R.id.obfuscated_res_0x7f092197) {
            sw6.b(view2, p26Var, 8);
        }
    }

    public void H(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, joVar) == null) {
            this.d = joVar;
        }
    }

    @Override // com.baidu.tieba.to5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.c = str;
        }
    }

    @Override // com.baidu.tieba.qn
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? p26.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qn
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? p26.I : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qn
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? p26.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qn
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? p26.D : (BdUniqueId) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            x26.R = "c10705";
            x26.S = "c10730";
            x26.T = "c10731";
            x26.U = "c10704";
            x26.V = "c10755";
            x26.W = "c10710";
            x26.X = "c10736";
            x26.Y = "c10737";
            x26.Z = "c10711";
            x26.a0 = "c10758";
            x26.b0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: w */
    public ThreadCardViewHolder<p26> onCreateBottomViewHolder(ViewGroup viewGroup, p26 p26Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, viewGroup, p26Var)) == null) {
            sy.b bVar = new sy.b(this.b.getPageActivity(), false);
            uy uyVar = new uy(this.b.getPageActivity());
            er4 er4Var = new er4();
            er4Var.b = 9;
            er4Var.h = 9;
            uyVar.w(er4Var);
            uyVar.y(9);
            uyVar.E("personalize_page");
            uyVar.D(4);
            uyVar.z(1);
            uyVar.c(32);
            uyVar.x(false);
            bVar.m(uyVar);
            sy k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder<p26> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: x */
    public ThreadCardViewHolder<p26> onCreateContentViewHolder(ViewGroup viewGroup, p26 p26Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, viewGroup, p26Var)) == null) {
            sy.b bVar = new sy.b(this.b.getPageActivity(), false);
            if (p26Var.o) {
                vx vxVar = new vx(this.b.getPageActivity());
                vxVar.D(this.f, this.g);
                vxVar.y(ImageViewerConfig.FROM_CONCERN);
                vxVar.A(1);
                vxVar.z(this.e);
                vxVar.x(1);
                bVar.n(vxVar);
            } else if (p26Var.p) {
                fy fyVar = new fy(this.b.getPageActivity());
                fyVar.r(ImageViewerConfig.FROM_CONCERN);
                fyVar.s(this.e);
                bVar.n(fyVar);
            } else if (p26Var.q) {
                cy cyVar = new cy(this.b.getPageActivity());
                cyVar.t(ImageViewerConfig.FROM_CONCERN);
                cyVar.u(this.e);
                bVar.n(cyVar);
            } else if (p26Var.r) {
                gy gyVar = new gy(this.b.getPageActivity());
                gyVar.s(ImageViewerConfig.FROM_CONCERN);
                gyVar.t(this.e);
                bVar.n(gyVar);
            }
            sy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder<p26> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: y */
    public ThreadCardViewHolder<p26> onCreateExtendViewHolder(ViewGroup viewGroup, p26 p26Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, viewGroup, p26Var)) == null) {
            sy.b bVar = new sy.b(this.b.getPageActivity(), false);
            zx zxVar = new zx(this.b.getPageActivity());
            zxVar.A(2);
            zxVar.t();
            zxVar.x(true);
            bVar.h(zxVar);
            bVar.h(new oy(this.b.getPageActivity()));
            bVar.h(new hy(this.b.getPageActivity()));
            qx qxVar = new qx(this.b.getPageActivity());
            qxVar.u();
            bVar.h(qxVar);
            ux uxVar = new ux(this.b.getPageActivity());
            uxVar.y(this.e);
            uxVar.x(ImageViewerConfig.FROM_CONCERN);
            bVar.h(uxVar);
            sy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder<p26> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new g(this, zxVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: z */
    public ThreadCardViewHolder<p26> onCreateHeaderViewHolder(ViewGroup viewGroup, p26 p26Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, viewGroup, p26Var)) == null) {
            if (p26Var == null) {
                return null;
            }
            sy.b bVar = new sy.b(this.b.getPageActivity());
            if (p26Var.m) {
                jx jxVar = new jx(this.b.getPageActivity());
                jxVar.u(this.a);
                jxVar.c(128);
                jxVar.d(1024);
                jxVar.t(new d(this));
                bVar.o(jxVar);
            } else if (p26Var.n) {
                bVar.o(new sx(this.b.getPageActivity()));
            }
            sy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.r(1);
            ThreadCardViewHolder<p26> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }
}
