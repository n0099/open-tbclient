package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
/* loaded from: classes8.dex */
public class u08 extends pm<up6, ThreadCardViewHolder<up6>> implements o56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public in d;
    public boolean e;
    public bg<ImageView> f;
    public bg<GifView> g;
    public mp6<up6> h;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
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
    @Override // com.baidu.tieba.pm
    /* renamed from: H */
    public View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, up6 up6Var, ThreadCardViewHolder<up6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, up6Var, threadCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements cg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u08 a;

        public a(u08 u08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u08Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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
                    if (m05.c().g()) {
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
        @Override // com.baidu.tieba.cg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.b.getPageActivity());
                boolean g = m05.c().g();
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

    /* loaded from: classes8.dex */
    public class b implements cg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u08 a;

        public b(u08 u08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u08Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.h();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.k();
                gifView.h();
                gifView.setImageDrawable(null);
                gifView.l();
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
                if (m05.c().g()) {
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
        @Override // com.baidu.tieba.cg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.b.getPageActivity());
                boolean g = m05.c().g();
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

    /* loaded from: classes8.dex */
    public class c extends mp6<up6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u08 b;

        public c(u08 u08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, up6 up6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, up6Var) != null) {
                return;
            }
            this.b.I(view2, up6Var);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements dx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(u08 u08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u08Var};
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
        public void a(b15 b15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, b15Var, view2) == null) && b15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    b15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    b15Var.objType = 4;
                } else {
                    b15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u08 a;

        public e(u08 u08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u08Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof vm) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                vm vmVar = (vm) cnVar;
                if (!(vmVar.c() instanceof up6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                up6 up6Var = (up6) vmVar.c();
                up6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), up6Var);
                }
                if (!z78.b(this.a.b, vmVar.c())) {
                    ThreadCardUtils.jumpToPB((b15) up6Var, view2.getContext(), 1, false, ex.a((in) viewGroup, view2, i));
                    threadCardViewHolder.a().p(new zy.a(1));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u08 a;

        public f(u08 u08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u08Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof vm) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                vm vmVar = (vm) cnVar;
                if (!(vmVar.c() instanceof up6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                up6 up6Var = (up6) vmVar.c();
                up6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), up6Var);
                }
                ThreadCardUtils.jumpToPB((b15) up6Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx a;
        public final /* synthetic */ u08 b;

        public g(u08 u08Var, xx xxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u08Var, xxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u08Var;
            this.a = xxVar;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            up6 up6Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = cnVar instanceof vm;
                int i2 = 0;
                if (z) {
                    vm vmVar = (vm) cnVar;
                    if ((vmVar.c() instanceof up6) && cnVar != null && vmVar.c() != null && (up6Var = (up6) vmVar.c()) != null && (threadData = up6Var.a) != null && up6Var.u && threadData.getItem() != null) {
                        if (up6Var.a.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                            BdToast.makeText(this.b.b.getContext(), this.b.b.getString(R.string.video_is_checking)).setIcon(BdToast.ToastIcon.FAILURE).show();
                            return;
                        }
                        int intValue = up6Var.a.getItem().button_link_type.intValue();
                        if (up6Var.a.getItem().apk_detail != null) {
                            i2 = up6Var.a.getItem().apk_detail.pkg_source.intValue();
                        }
                        int a = wa5.a(intValue, i2);
                        ItemData itemData = new ItemData();
                        itemData.parseProto(up6Var.a.getItem());
                        ItemCardHelper.q(this.a.A(), up6Var.a.getItem().item_id.longValue(), this.a.z(itemData), up6Var.a.getTid(), a, "", 2);
                        ItemClickJumpUtil.itemClickJump(up6Var.a.getItem().forum_name, String.valueOf(up6Var.a.getItem().item_id), 2, 2);
                        return;
                    }
                }
                if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    vm vmVar2 = (vm) cnVar;
                    if (!(vmVar2.c() instanceof up6)) {
                        return;
                    }
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    up6 up6Var2 = (up6) vmVar2.c();
                    up6Var2.f = 1;
                    if (this.b.h != null) {
                        this.b.h.a(threadCardViewHolder.getView(), up6Var2);
                    }
                    ThreadCardUtils.jumpToPB((b15) up6Var2, view2.getContext(), 1, false, ex.a((in) viewGroup, view2, i));
                    threadCardViewHolder.a().p(new zy.a(1));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u08 a;

        public h(u08 u08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u08Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof vm) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                vm vmVar = (vm) cnVar;
                if (!(vmVar.c() instanceof up6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                up6 up6Var = (up6) vmVar.c();
                up6Var.f = 1;
                if (this.a.h != null) {
                    this.a.h.a(threadCardViewHolder.getView(), up6Var);
                }
                ThreadCardUtils.jumpToPB((b15) up6Var, view2.getContext(), 1, false, ex.a((in) viewGroup, view2, i));
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements ThreadCommentAndPraiseInfoLayout.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public i(u08 u08Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u08Var, viewGroup, view2, Integer.valueOf(i)};
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
                ((PbActivityConfig) intentConfig).setVideoOriginArea(ex.a((in) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new bg<>(new a(this), 12, 0);
        this.g = new bg<>(new b(this), 20, 0);
        this.h = new c(this);
        this.b = tbPageContext;
        x();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: B */
    public ThreadCardViewHolder<up6> onCreateHeaderViewHolder(ViewGroup viewGroup, up6 up6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, up6Var)) == null) {
            if (up6Var == null) {
                return null;
            }
            oy.b bVar = new oy.b(this.b.getPageActivity());
            if (up6Var.m) {
                dx dxVar = new dx(this.b.getPageActivity());
                dxVar.p(this.a);
                dxVar.e(128);
                dxVar.f(1024);
                dxVar.y(new d(this));
                bVar.o(dxVar);
            } else if (up6Var.n) {
                bVar.o(new nx(this.b.getPageActivity()));
            }
            oy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<up6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: y */
    public ThreadCardViewHolder<up6> onCreateBottomViewHolder(ViewGroup viewGroup, up6 up6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, viewGroup, up6Var)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            qy qyVar = new qy(this.b.getPageActivity());
            h15 h15Var = new h15();
            h15Var.b = 9;
            h15Var.h = 9;
            qyVar.D(h15Var);
            qyVar.F(9);
            qyVar.L("personalize_page");
            qyVar.K(4);
            qyVar.G(1);
            qyVar.e(32);
            qyVar.E(false);
            bVar.m(qyVar);
            oy k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<up6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new h(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    public void J(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, inVar) == null) {
            this.d = inVar;
        }
    }

    @Override // com.baidu.tieba.o56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: A */
    public ThreadCardViewHolder<up6> onCreateExtendViewHolder(ViewGroup viewGroup, up6 up6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, viewGroup, up6Var)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            xx xxVar = new xx(this.b.getPageActivity());
            xxVar.F(2);
            xxVar.y();
            xxVar.C(true);
            bVar.h(xxVar);
            bVar.h(new ky(this.b.getPageActivity()));
            bVar.h(new ey(this.b.getPageActivity()));
            lx lxVar = new lx(this.b.getPageActivity());
            lxVar.z();
            bVar.h(lxVar);
            px pxVar = new px(this.b.getPageActivity());
            pxVar.D(this.e);
            pxVar.C(ImageViewerConfig.FROM_CONCERN);
            bVar.h(pxVar);
            oy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<up6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new g(this, xxVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: z */
    public ThreadCardViewHolder<up6> onCreateContentViewHolder(ViewGroup viewGroup, up6 up6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, viewGroup, up6Var)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            if (up6Var.o) {
                qx qxVar = new qx(this.b.getPageActivity());
                qxVar.H(this.f, this.g);
                qxVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                qxVar.E(1);
                qxVar.D(this.e);
                qxVar.C(1);
                bVar.n(qxVar);
            } else if (up6Var.p) {
                bVar.n(cy.t(this.b.getPageActivity(), ImageViewerConfig.FROM_CONCERN, this.e));
            } else if (up6Var.q) {
                ay ayVar = new ay(this.b.getPageActivity());
                ayVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                ayVar.y(this.e);
                bVar.n(ayVar);
            } else if (up6Var.r) {
                dy dyVar = new dy(this.b.getPageActivity());
                dyVar.setFrom(ImageViewerConfig.FROM_CONCERN);
                dyVar.x(this.e);
                bVar.n(dyVar);
            }
            oy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<up6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: D */
    public View onFillBottomViewHolder(int i2, View view2, ViewGroup viewGroup, up6 up6Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, up6Var, threadCardViewHolder})) == null) {
            if (up6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && up6Var.a != null) {
                up6Var.B(up6Var.position + 1);
                threadCardViewHolder.a().r(i2);
                if (threadCardViewHolder.a().f() instanceof qy) {
                    ((qy) threadCardViewHolder.a().f()).J(new i(this, viewGroup, view2, i2));
                }
                if (threadCardViewHolder.a() instanceof n56) {
                    threadCardViewHolder.a().b(this.c);
                }
                threadCardViewHolder.t(false, Align.ALIGN_RIGHT_BOTTOM);
                threadCardViewHolder.e(up6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: E */
    public View onFillContentViewHolder(int i2, View view2, ViewGroup viewGroup, up6 up6Var, ThreadCardViewHolder<up6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, up6Var, threadCardViewHolder})) == null) {
            if (up6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && up6Var.a != null) {
                up6Var.B(up6Var.position + 1);
                ep6.b().a(up6Var.d("c12351"));
                threadCardViewHolder.a().r(i2);
                if (threadCardViewHolder.a() instanceof n56) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (up6Var.p) {
                    gp6.a(threadCardViewHolder.a().g(), up6Var.j, up6Var.k);
                }
                threadCardViewHolder.e(up6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: G */
    public View onFillHeaderViewHolder(int i2, View view2, ViewGroup viewGroup, up6 up6Var, ThreadCardViewHolder<up6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, up6Var, threadCardViewHolder})) == null) {
            if (up6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && up6Var.a != null) {
                up6Var.B(up6Var.position + 1);
                threadCardViewHolder.a().r(i2);
                if (threadCardViewHolder.a() instanceof n56) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (up6Var.m) {
                    threadCardViewHolder.t(true, Align.ALIGN_RIGHT_TOP);
                } else if (up6Var.n) {
                    ep6.b().a(up6Var.s());
                    m56.c().a(up6Var.s());
                    x78.p(up6Var.a, this.a, up6Var.h());
                }
                threadCardViewHolder.e(up6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: F */
    public View onFillExtendViewHolder(int i2, View view2, ViewGroup viewGroup, up6 up6Var, ThreadCardViewHolder<up6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, up6Var, threadCardViewHolder})) == null) {
            if (up6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && up6Var.a != null) {
                up6Var.B(up6Var.position + 1);
                threadCardViewHolder.a().r(i2);
                if (threadCardViewHolder.a() instanceof n56) {
                    threadCardViewHolder.a().b(this.c);
                }
                if (up6Var.y) {
                    ep6.b().a(new StatisticItem("c13424"));
                }
                threadCardViewHolder.e(up6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.h);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void I(View view2, up6 up6Var) {
        StatisticItem q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, up6Var) == null) && view2 != null && up6Var != null && up6Var.getThreadData() != null && !StringUtils.isNull(up6Var.getThreadData().getTid())) {
            int id = view2.getId();
            int i2 = 1;
            if (up6Var.m) {
                if (id == R.id.thread_card_root) {
                    q08.b(view2, up6Var, 2);
                } else if (id != R.id.user_avatar && id != R.id.user_name) {
                    if (view2 instanceof TbImageView) {
                        q08.b(view2, up6Var, 3);
                    }
                } else {
                    q08.b(view2, up6Var, 1);
                }
            } else if (up6Var.n) {
                ep6.b().d(true);
                if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread) {
                    if (up6Var.isVideoThreadType()) {
                        q = up6Var.t();
                    } else {
                        q = up6Var.q();
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(q));
                    m56.c().i("page_concern", "clk_", q);
                } else {
                    TiebaStatic.log(up6Var.f());
                    m56.c().i("page_concern", "clk_", up6Var.f());
                    i2 = 9;
                }
                x78.d(up6Var.a, this.a, up6Var.h(), i2);
            } else if (!up6Var.o && !up6Var.p && !up6Var.q && !up6Var.r) {
                if (up6Var.v) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    if (threadCardViewHolder != null) {
                        ThreadCardUtils.jumpToPB((b15) up6Var.getThreadData(), view2.getContext(), 1, false);
                        threadCardViewHolder.a().p(new zy.a(1));
                    }
                } else if (up6Var.x) {
                    if (view2.getId() == R.id.thread_card_root) {
                        q08.b(view2, up6Var, 2);
                    } else if (id == R.id.forum_name_text) {
                        q08.b(view2, up6Var, 7);
                    }
                } else if (up6Var.y) {
                    if (view2.getId() == R.id.thread_card_root) {
                        q08.b(view2, up6Var, 2);
                    } else if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c13423");
                        statisticItem.param("obj_locate", 4);
                        statisticItem.param("tid", up6Var.g);
                        ThreadData threadData = up6Var.a;
                        if (threadData != null && threadData.getTopAgreePost() != null) {
                            statisticItem.param("pid", up6Var.a.getTopAgreePost().U());
                        }
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c13423");
                        statisticItem2.param("obj_locate", 2);
                        statisticItem2.param("tid", up6Var.g);
                        ThreadData threadData2 = up6Var.a;
                        if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                            statisticItem2.param("pid", up6Var.a.getTopAgreePost().U());
                        }
                        TiebaStatic.log(statisticItem2);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (id == R.id.god_reply_agree_view) {
                            StatisticItem statisticItem3 = new StatisticItem("c13423");
                            statisticItem3.param("obj_locate", 5);
                            statisticItem3.param("tid", up6Var.g);
                            ThreadData threadData3 = up6Var.a;
                            if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                statisticItem3.param("pid", up6Var.a.getTopAgreePost().U());
                            }
                            TiebaStatic.log(statisticItem3);
                        } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                            StatisticItem statisticItem4 = new StatisticItem("c13423");
                            statisticItem4.param("obj_locate", 3);
                            statisticItem4.param("tid", up6Var.g);
                            ThreadData threadData4 = up6Var.a;
                            if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                statisticItem4.param("pid", up6Var.a.getTopAgreePost().U());
                            }
                            TiebaStatic.log(statisticItem4);
                        }
                    } else {
                        StatisticItem statisticItem5 = new StatisticItem("c13423");
                        statisticItem5.param("obj_locate", 1);
                        statisticItem5.param("tid", up6Var.g);
                        ThreadData threadData5 = up6Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", up6Var.a.getTopAgreePost().U());
                        }
                        TiebaStatic.log(statisticItem5);
                    }
                } else if (up6Var.A && (view2.getId() == R.id.thread_card_root || view2.getId() == R.id.thread_info_commont_container)) {
                    q08.b(view2, up6Var, 2);
                }
            } else if (view2.getId() == R.id.thread_card_root) {
                q08.b(view2, up6Var, 2);
            } else if (view2 instanceof TbImageView) {
                q08.b(view2, up6Var, 3);
            } else if (view2.getId() == R.id.thread_card_title || view2.getId() == R.id.thread_card_abstract) {
                q08.b(view2, up6Var, 2);
            }
            if (id == R.id.thread_info_commont_container || id == R.id.thread_info_commont_img || id == R.id.thread_info_commont_num) {
                q08.b(view2, up6Var, 8);
            }
        }
    }

    @Override // com.baidu.tieba.pm
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return up6.M;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pm
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return up6.I;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pm
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return up6.L;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pm
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return up6.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            cq6.f1090T = "c10705";
            cq6.U = "c10730";
            cq6.V = "c10731";
            cq6.W = "c10704";
            cq6.X = "c10755";
            cq6.Y = "c10710";
            cq6.Z = "c10736";
            cq6.a0 = "c10737";
            cq6.b0 = "c10711";
            cq6.c0 = "c10758";
            cq6.d0 = "c10757";
        }
    }
}
