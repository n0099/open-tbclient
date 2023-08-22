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
import com.baidu.tieba.cx;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kz7 extends om<ro6, ThreadCardViewHolder<ro6>> implements s46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public hn d;
    public boolean e;
    public ag<ImageView> f;
    public ag<GifView> g;
    public jo6<ro6> h;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
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
    @Override // com.baidu.tieba.om
    /* renamed from: H */
    public View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, ro6 ro6Var, ThreadCardViewHolder<ro6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, ro6Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements bg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz7 a;

        public a(kz7 kz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
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
                    foreDrawableImageView.stopLoading();
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
                    if (h05.c().g()) {
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
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.reset();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.b.getPageActivity());
                boolean g = h05.c().g();
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
    public class b implements bg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz7 a;

        public b(kz7 kz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.m();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.p();
                gifView.m();
                gifView.setImageDrawable(null);
                gifView.q();
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
                if (h05.c().g()) {
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
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.b.getPageActivity());
                boolean g = h05.c().g();
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
    public class c extends jo6<ro6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz7 b;

        public c(kz7 kz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jo6
        /* renamed from: d */
        public void a(View view2, ro6 ro6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ro6Var) != null) {
                return;
            }
            this.b.I(view2, ro6Var);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements cx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(kz7 kz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.cx.b
        public void a(w05 w05Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, w05Var, view2) == null) && w05Var != null) {
                if (view2.getId() == R.id.user_name) {
                    w05Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    w05Var.objType = 4;
                } else {
                    w05Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz7 a;

        public e(kz7 kz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz7Var;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (bnVar instanceof um) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                um umVar = (um) bnVar;
                if (!(umVar.c() instanceof ro6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ro6 ro6Var = (ro6) umVar.c();
                ro6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), ro6Var);
                }
                if (!n68.a(this.a.b, umVar.c())) {
                    ThreadCardUtils.jumpToPB((w05) ro6Var, view2.getContext(), 1, false, dx.a((hn) viewGroup, view2, i));
                    threadCardViewHolder.b().p(new yy.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz7 a;

        public f(kz7 kz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz7Var;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (bnVar instanceof um) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                um umVar = (um) bnVar;
                if (!(umVar.c() instanceof ro6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ro6 ro6Var = (ro6) umVar.c();
                ro6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), ro6Var);
                }
                ThreadCardUtils.jumpToPB((w05) ro6Var, view2.getContext(), 1, false);
                threadCardViewHolder.b().p(new yy.a(1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wx a;
        public final /* synthetic */ kz7 b;

        public g(kz7 kz7Var, wx wxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz7Var, wxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kz7Var;
            this.a = wxVar;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            ro6 ro6Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = bnVar instanceof um;
                int i2 = 0;
                if (z) {
                    um umVar = (um) bnVar;
                    if ((umVar.c() instanceof ro6) && bnVar != null && umVar.c() != null && (ro6Var = (ro6) umVar.c()) != null && (threadData = ro6Var.a) != null && ro6Var.u && threadData.getItem() != null) {
                        if (ro6Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast.makeText(this.b.b.getContext(), this.b.b.getString(R.string.video_is_checking)).setIcon(BdToast.ToastIcon.FAILURE).show();
                            return;
                        }
                        int intValue = ro6Var.a.getItem().button_link_type.intValue();
                        if (ro6Var.a.getItem().apk_detail != null) {
                            i2 = ro6Var.a.getItem().apk_detail.pkg_source.intValue();
                        }
                        int a = ma5.a(intValue, i2);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(ro6Var.a.getItem());
                        ItemCardHelper.q(this.a.B(), ro6Var.a.getItem().item_id.longValue(), this.a.A(itemData), ro6Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(ro6Var.a.getItem().forum_name, String.valueOf(ro6Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    um umVar2 = (um) bnVar;
                    if (!(umVar2.c() instanceof ro6)) {
                        return;
                    }
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    ro6 ro6Var2 = (ro6) umVar2.c();
                    ro6Var2.f = 1;
                    if (this.b.h != null) {
                        this.b.h.a(threadCardViewHolder.getView(), ro6Var2);
                    }
                    ThreadCardUtils.jumpToPB((w05) ro6Var2, view2.getContext(), 1, false, dx.a((hn) viewGroup, view2, i));
                    threadCardViewHolder.b().p(new yy.a(1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz7 a;

        public h(kz7 kz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz7Var;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (bnVar instanceof um) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                um umVar = (um) bnVar;
                if (!(umVar.c() instanceof ro6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ro6 ro6Var = (ro6) umVar.c();
                ro6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), ro6Var);
                }
                ThreadCardUtils.jumpToPB((w05) ro6Var, view2.getContext(), 1, false, dx.a((hn) viewGroup, view2, i));
                threadCardViewHolder.b().p(new yy.a(1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ThreadCommentAndPraiseInfoLayout.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public i(kz7 kz7Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz7Var, viewGroup, view2, Integer.valueOf(i)};
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
                ((PbActivityConfig) intentConfig).setVideoOriginArea(dx.a((hn) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kz7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new ag<>(new a(this), 12, 0);
        this.g = new ag<>(new b(this), 20, 0);
        this.h = new c(this);
        this.b = tbPageContext;
        x();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: B */
    public ThreadCardViewHolder<ro6> onCreateHeaderViewHolder(ViewGroup viewGroup, ro6 ro6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, ro6Var)) == null) {
            if (ro6Var == null) {
                return null;
            }
            ny.b bVar = new ny.b(this.b.getPageActivity());
            if (ro6Var.m) {
                cx cxVar = new cx(this.b.getPageActivity());
                cxVar.q(this.a);
                cxVar.f(128);
                cxVar.g(1024);
                cxVar.z(new d(this));
                bVar.o(cxVar);
            } else if (ro6Var.n) {
                bVar.o(new mx(this.b.getPageActivity()));
            }
            ny k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<ro6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: y */
    public ThreadCardViewHolder<ro6> onCreateBottomViewHolder(ViewGroup viewGroup, ro6 ro6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, viewGroup, ro6Var)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity(), false);
            py pyVar = new py(this.b.getPageActivity());
            c15 c15Var = new c15();
            c15Var.b = 9;
            c15Var.h = 9;
            pyVar.C(c15Var);
            pyVar.E(9);
            pyVar.K("personalize_page");
            pyVar.J(4);
            pyVar.F(1);
            pyVar.f(32);
            pyVar.D(false);
            bVar.m(pyVar);
            ny k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<ro6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    public void J(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hnVar) == null) {
            this.d = hnVar;
        }
    }

    @Override // com.baidu.tieba.s46
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: A */
    public ThreadCardViewHolder<ro6> onCreateExtendViewHolder(ViewGroup viewGroup, ro6 ro6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, viewGroup, ro6Var)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity(), false);
            wx wxVar = new wx(this.b.getPageActivity());
            wxVar.G(2);
            wxVar.z();
            wxVar.D(true);
            bVar.h(wxVar);
            bVar.h(new jy(this.b.getPageActivity()));
            bVar.h(new dy(this.b.getPageActivity()));
            kx kxVar = new kx(this.b.getPageActivity());
            kxVar.A();
            bVar.h(kxVar);
            ox oxVar = new ox(this.b.getPageActivity());
            oxVar.E(this.e);
            oxVar.D(ImageViewerConfig.FROM_CONCERN);
            bVar.h(oxVar);
            ny k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<ro6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new g(this, wxVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: z */
    public ThreadCardViewHolder<ro6> onCreateContentViewHolder(ViewGroup viewGroup, ro6 ro6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, viewGroup, ro6Var)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity(), false);
            if (ro6Var.o) {
                px pxVar = new px(this.b.getPageActivity());
                pxVar.I(this.f, this.g);
                pxVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                pxVar.F(1);
                pxVar.E(this.e);
                pxVar.D(1);
                bVar.n(pxVar);
            } else if (ro6Var.p) {
                bVar.n(by.u(this.b.getPageActivity(), ImageViewerConfig.FROM_CONCERN, this.e));
            } else if (ro6Var.q) {
                zx zxVar = new zx(this.b.getPageActivity());
                zxVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                zxVar.z(this.e);
                bVar.n(zxVar);
            } else if (ro6Var.r) {
                cy cyVar = new cy(this.b.getPageActivity());
                cyVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                cyVar.y(this.e);
                bVar.n(cyVar);
            }
            ny k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<ro6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: D */
    public View onFillBottomViewHolder(int i2, View view2, ViewGroup viewGroup, ro6 ro6Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, ro6Var, threadCardViewHolder})) == null) {
            if (ro6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && ro6Var.a != null) {
                ro6Var.A(ro6Var.position + 1);
                threadCardViewHolder.b().r(i2);
                if (threadCardViewHolder.b().f() instanceof py) {
                    ((py) threadCardViewHolder.b().f()).I(new i(this, viewGroup, view2, i2));
                }
                if (threadCardViewHolder.b() instanceof r46) {
                    threadCardViewHolder.b().b(this.c);
                }
                threadCardViewHolder.u(false, Align.ALIGN_RIGHT_BOTTOM);
                threadCardViewHolder.f(ro6Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: E */
    public View onFillContentViewHolder(int i2, View view2, ViewGroup viewGroup, ro6 ro6Var, ThreadCardViewHolder<ro6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, ro6Var, threadCardViewHolder})) == null) {
            if (ro6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && ro6Var.a != null) {
                ro6Var.A(ro6Var.position + 1);
                co6.b().a(ro6Var.d("c12351"));
                threadCardViewHolder.b().r(i2);
                if (threadCardViewHolder.b() instanceof r46) {
                    threadCardViewHolder.b().b(this.c);
                }
                if (ro6Var.p) {
                    by byVar = (by) threadCardViewHolder.b().g();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) byVar.f.d.getLayoutParams();
                    layoutParams.width = ro6Var.j;
                    layoutParams.height = ro6Var.k;
                    if (byVar.f.d.getVisibility() != 8) {
                        byVar.f.d.setLayoutParams(layoutParams);
                    }
                }
                threadCardViewHolder.f(ro6Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: G */
    public View onFillHeaderViewHolder(int i2, View view2, ViewGroup viewGroup, ro6 ro6Var, ThreadCardViewHolder<ro6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, ro6Var, threadCardViewHolder})) == null) {
            if (ro6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && ro6Var.a != null) {
                ro6Var.A(ro6Var.position + 1);
                threadCardViewHolder.b().r(i2);
                if (threadCardViewHolder.b() instanceof r46) {
                    threadCardViewHolder.b().b(this.c);
                }
                if (ro6Var.m) {
                    threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
                } else if (ro6Var.n) {
                    co6.b().a(ro6Var.r());
                    q46.c().a(ro6Var.r());
                    m68.p(ro6Var.a, this.a, ro6Var.h());
                }
                threadCardViewHolder.f(ro6Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: F */
    public View onFillExtendViewHolder(int i2, View view2, ViewGroup viewGroup, ro6 ro6Var, ThreadCardViewHolder<ro6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, ro6Var, threadCardViewHolder})) == null) {
            if (ro6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && ro6Var.a != null) {
                ro6Var.A(ro6Var.position + 1);
                threadCardViewHolder.b().r(i2);
                if (threadCardViewHolder.b() instanceof r46) {
                    threadCardViewHolder.b().b(this.c);
                }
                if (ro6Var.y) {
                    co6.b().a(new StatisticItem("c13424"));
                }
                threadCardViewHolder.f(ro6Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void I(View view2, ro6 ro6Var) {
        StatisticItem q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, ro6Var) == null) && view2 != null && ro6Var != null && ro6Var.getThreadData() != null && !StringUtils.isNull(ro6Var.getThreadData().getTid())) {
            int id = view2.getId();
            int i2 = 1;
            if (ro6Var.m) {
                if (id == R.id.thread_card_root) {
                    gz7.b(view2, ro6Var, 2);
                } else if (id != R.id.user_avatar && id != R.id.user_name) {
                    if (view2 instanceof TbImageView) {
                        gz7.b(view2, ro6Var, 3);
                    }
                } else {
                    gz7.b(view2, ro6Var, 1);
                }
            } else if (ro6Var.n) {
                co6.b().d(true);
                if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread) {
                    if (ro6Var.isVideoThreadType()) {
                        q = ro6Var.t();
                    } else {
                        q = ro6Var.q();
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(q));
                    q46.c().i("page_concern", "clk_", q);
                } else {
                    TiebaStatic.log(ro6Var.f());
                    q46.c().i("page_concern", "clk_", ro6Var.f());
                    i2 = 9;
                }
                m68.d(ro6Var.a, this.a, ro6Var.h(), i2);
            } else if (!ro6Var.o && !ro6Var.p && !ro6Var.q && !ro6Var.r) {
                if (ro6Var.v) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    if (threadCardViewHolder != null) {
                        ThreadCardUtils.jumpToPB((w05) ro6Var.getThreadData(), view2.getContext(), 1, false);
                        threadCardViewHolder.b().p(new yy.a(1));
                    }
                } else if (ro6Var.x) {
                    if (view2.getId() == R.id.thread_card_root) {
                        gz7.b(view2, ro6Var, 2);
                    } else if (id == R.id.forum_name_text) {
                        gz7.b(view2, ro6Var, 7);
                    }
                } else if (ro6Var.y) {
                    if (view2.getId() == R.id.thread_card_root) {
                        gz7.b(view2, ro6Var, 2);
                    } else if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c13423");
                        statisticItem.param("obj_locate", 4);
                        statisticItem.param("tid", ro6Var.g);
                        ThreadData threadData = ro6Var.a;
                        if (threadData != null && threadData.getTopAgreePost() != null) {
                            statisticItem.param("pid", ro6Var.a.getTopAgreePost().S());
                        }
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c13423");
                        statisticItem2.param("obj_locate", 2);
                        statisticItem2.param("tid", ro6Var.g);
                        ThreadData threadData2 = ro6Var.a;
                        if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                            statisticItem2.param("pid", ro6Var.a.getTopAgreePost().S());
                        }
                        TiebaStatic.log(statisticItem2);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (id == R.id.god_reply_agree_view) {
                            StatisticItem statisticItem3 = new StatisticItem("c13423");
                            statisticItem3.param("obj_locate", 5);
                            statisticItem3.param("tid", ro6Var.g);
                            ThreadData threadData3 = ro6Var.a;
                            if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                statisticItem3.param("pid", ro6Var.a.getTopAgreePost().S());
                            }
                            TiebaStatic.log(statisticItem3);
                        } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                            StatisticItem statisticItem4 = new StatisticItem("c13423");
                            statisticItem4.param("obj_locate", 3);
                            statisticItem4.param("tid", ro6Var.g);
                            ThreadData threadData4 = ro6Var.a;
                            if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                statisticItem4.param("pid", ro6Var.a.getTopAgreePost().S());
                            }
                            TiebaStatic.log(statisticItem4);
                        }
                    } else {
                        StatisticItem statisticItem5 = new StatisticItem("c13423");
                        statisticItem5.param("obj_locate", 1);
                        statisticItem5.param("tid", ro6Var.g);
                        ThreadData threadData5 = ro6Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", ro6Var.a.getTopAgreePost().S());
                        }
                        TiebaStatic.log(statisticItem5);
                    }
                } else if (ro6Var.A && (view2.getId() == R.id.thread_card_root || view2.getId() == R.id.thread_info_commont_container)) {
                    gz7.b(view2, ro6Var, 2);
                }
            } else if (view2.getId() == R.id.thread_card_root) {
                gz7.b(view2, ro6Var, 2);
            } else if (view2 instanceof TbImageView) {
                gz7.b(view2, ro6Var, 3);
            } else if (view2.getId() == R.id.thread_card_title || view2.getId() == R.id.thread_card_abstract) {
                gz7.b(view2, ro6Var, 2);
            }
            if (id == R.id.thread_info_commont_container || id == R.id.thread_info_commont_img || id == R.id.thread_info_commont_num) {
                gz7.b(view2, ro6Var, 8);
            }
        }
    }

    @Override // com.baidu.tieba.om
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return ro6.M;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.om
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return ro6.I;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.om
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return ro6.L;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.om
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return ro6.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            zo6.f1193T = "c10705";
            zo6.U = "c10730";
            zo6.V = "c10731";
            zo6.W = "c10704";
            zo6.X = "c10755";
            zo6.Y = "c10710";
            zo6.Z = "c10736";
            zo6.a0 = "c10737";
            zo6.b0 = "c10711";
            zo6.c0 = "c10758";
            zo6.d0 = "c10757";
        }
    }
}
