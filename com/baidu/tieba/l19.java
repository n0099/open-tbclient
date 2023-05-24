package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.Cif;
import com.baidu.tieba.core.widget.SpriteBottomTipView;
import com.baidu.tieba.sprite.FunnySpriteResDownloadUtil;
import com.baidu.tieba.statemachine.animationtip.SpriteAnimationTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* loaded from: classes6.dex */
public class l19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hf a;
    public final WeakReference<Activity> b;
    public final ViewGroup c;
    public gf d;
    public ThreadRecommendInfoData e;
    public String f;
    public f g;
    public SpriteAnimationTipManager h;
    public SpriteBottomTipView i;
    public boolean j;

    /* loaded from: classes6.dex */
    public interface f {
        void onDismiss();
    }

    /* loaded from: classes6.dex */
    public class e implements gf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l19 a;

        @Override // com.baidu.tieba.gf
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.gf
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.gf
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.gf
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                    return;
                }
                this.a.a.m(view2.getContext());
                this.a.a.j();
                this.a.a.n();
            }
        }

        /* loaded from: classes6.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.a.j();
                }
            }
        }

        public e(l19 l19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l19Var;
        }

        @Override // com.baidu.tieba.gf
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0773, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f091a06);
                if (this.a.e != null) {
                    BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091a05);
                    barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                    barImageView.setStrokeWith(ri.g(inflate.getContext(), R.dimen.tbds1));
                    barImageView.setShowOval(false);
                    barImageView.setDrawCorner(true);
                    barImageView.setRadiusById(R.string.J_X06);
                    barImageView.setConrers(15);
                    barImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    barImageView.setPlaceHolder(1);
                    barImageView.setShowOuterBorder(false);
                    barImageView.setShowInnerBorder(true);
                    barImageView.setStrokeColorResId(R.color.CAM_X0602);
                    if (!StringUtils.isNull(this.a.e.recommendIcon)) {
                        barImageView.O(this.a.e.recommendIcon, 10, false, false);
                    }
                    TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091a0a);
                    textView.setText(this.a.e.recommendReason);
                    p45 d = p45.d(textView);
                    d.w(R.color.CAM_X0105);
                    d.B(R.dimen.T_X06);
                    d.C(R.string.F_X02);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091a07);
                    textView2.setText(this.a.e.recommendType);
                    p45 d2 = p45.d(textView2);
                    d2.w(R.color.CAM_X0107);
                    d2.B(R.dimen.T_X08);
                    d2.C(R.string.F_X01);
                    TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f091a08);
                    n75 n75Var = new n75();
                    n75Var.t(R.color.CAM_X0319);
                    tBSpecificationBtn.setConfig(n75Var);
                    tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.check_immediately));
                    inflate.setOnClickListener(new a(this));
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090711);
                    WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
                    imageView.setOnClickListener(new b(this));
                    TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds21)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).setOffsetX(0).setOffsetY(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).into(findViewById);
                }
                return inflate;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(l19 l19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String b = bj5.b("", 0);
                if (b.startsWith("tiebaapp://router/portal")) {
                    UrlManager.getInstance().dealOneLink(TbadkApplication.getInst().getCurrentPageContext(TbadkApplication.getInst().getCurrentActivity()), new String[]{b});
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l19 a;

        public b(l19 l19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.j();
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements SpriteBottomTipView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ l19 b;

        public c(l19 l19Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l19Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l19Var;
            this.a = activity;
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.h.i();
            }
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void onBtnClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.j();
                this.b.m(this.a);
                this.b.n();
            }
        }

        @Override // com.baidu.tieba.core.widget.SpriteBottomTipView.b
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.j();
                this.b.m(this.a);
                this.b.n();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Cif.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l19 a;

        @Override // com.baidu.tieba.Cif.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public d(l19 l19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l19Var;
        }

        @Override // com.baidu.tieba.Cif.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a = null;
            }
        }
    }

    public l19(Activity activity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        new Handler();
        this.j = false;
        this.b = new WeakReference<>(activity);
        this.c = viewGroup;
    }

    public void p(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            this.g = fVar;
        }
    }

    public void q(ThreadRecommendInfoData threadRecommendInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, threadRecommendInfoData) == null) {
            this.e = threadRecommendInfoData;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f = str;
        }
    }

    @NonNull
    public static FrameLayout.LayoutParams g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 83;
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds141);
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.c == null || this.b.get() == null || (threadRecommendInfoData = this.e) == null || !threadRecommendInfoData.isValidData()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final gf h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new e(this);
        }
        return (gf) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if ((this.a != null && (viewGroup = this.c) != null && viewGroup.getVisibility() == 0) || this.j) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final SpriteBottomTipView i(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            SpriteBottomTipView.a aVar = new SpriteBottomTipView.a(activity);
            aVar.c(TbadkCoreApplication.getInst().getString(R.string.check_immediately));
            aVar.i(this.e.recommendReason);
            aVar.d(this.e.recommendType);
            aVar.f(this.e.recommendIcon);
            aVar.e(R.drawable.pic_use_header_28_n);
            aVar.h(true);
            aVar.b(Integer.valueOf((int) R.drawable.funny_sprite_tip_bg_right));
            aVar.g(new c(this, activity));
            return aVar.a();
        }
        return (SpriteBottomTipView) invokeL.objValue;
    }

    public final void m(Context context) {
        Activity activity;
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, context) == null) && (activity = this.b.get()) != null && (threadRecommendInfoData = this.e) != null) {
            if (!TextUtils.isEmpty(threadRecommendInfoData.jumpLink)) {
                UrlManager.getInstance().dealOneLink(TbadkApplication.getInst().getCurrentPageContext(context), new String[]{this.e.jumpLink});
                return;
            }
            long j = this.e.recommendTopicId;
            if (j == 0) {
                return;
            }
            new HotTopicActivityConfig(activity).createNormalConfig(String.valueOf(j), null, null, "2").start();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            hf hfVar = this.a;
            if (hfVar != null) {
                hfVar.e(this.c);
                this.c.setVisibility(8);
                f fVar = this.g;
                if (fVar != null) {
                    fVar.onDismiss();
                }
            }
            SpriteAnimationTipManager spriteAnimationTipManager = this.h;
            if (spriteAnimationTipManager != null) {
                spriteAnimationTipManager.p();
                this.j = false;
                f fVar2 = this.g;
                if (fVar2 != null) {
                    fVar2.onDismiss();
                }
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_RECOMMEND_GUIDE_VIEW_SHOW);
            if (!TextUtils.isEmpty(this.f)) {
                statisticItem.addParam("tid", this.f);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                statisticItem.addParam("uid", currentAccount);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_RECOMMEND_GUIDE_VIEW_JUMP);
            if (!TextUtils.isEmpty(this.f)) {
                statisticItem.addParam("tid", this.f);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                statisticItem.addParam("uid", currentAccount);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ViewGroup viewGroup = this.c;
            if (viewGroup != null && this.a != null) {
                p45 d2 = p45.d((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091a0a));
                d2.w(R.color.CAM_X0105);
                d2.B(R.dimen.T_X06);
                d2.C(R.string.F_X02);
                p45 d3 = p45.d((TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091a07));
                d3.w(R.color.CAM_X0107);
                d3.B(R.dimen.T_X08);
                d3.C(R.string.F_X01);
                ((TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f091a08)).k();
                WebPManager.setPureDrawable((ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090711), R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds21)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).setOffsetX(0).setOffsetY(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).into(this.c.findViewById(R.id.obfuscated_res_0x7f091a06));
                this.c.findViewById(R.id.obfuscated_res_0x7f091a05).postInvalidate();
            }
            SpriteAnimationTipManager spriteAnimationTipManager = this.h;
            if (spriteAnimationTipManager != null) {
                spriteAnimationTipManager.q("see_res");
            }
            SpriteBottomTipView spriteBottomTipView = this.i;
            if (spriteBottomTipView != null) {
                spriteBottomTipView.i(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!f() || (activity = this.b.get()) == null) {
                return false;
            }
            this.c.setVisibility(8);
            hf hfVar = this.a;
            if (hfVar != null) {
                hfVar.e(this.c);
            }
            this.c.setVisibility(0);
            Cif cif = new Cif();
            cif.d(true);
            cif.h(new d(this));
            if (this.d == null) {
                this.d = h();
            }
            cif.a(this.d);
            cif.e(R.anim.obfuscated_res_0x7f010108);
            cif.f(R.anim.obfuscated_res_0x7f010109);
            hf b2 = cif.b();
            this.a = b2;
            b2.p(activity, this.c, false);
            DefaultLog.getInstance().c("PbTopicTip", "展示线上展示话题弹窗");
            k();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Activity activity;
        boolean z;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            DefaultLog.getInstance().c("PbTopicTip", "准备展示精灵动画提示控件");
            if (!f() || (activity = this.b.get()) == null || activity.isFinishing()) {
                return false;
            }
            this.h = new SpriteAnimationTipManager(activity);
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                str = "funny_sprite_appear_day";
            } else {
                str = "funny_sprite_appear_dark";
            }
            rn6 a2 = bj5.a(FunnySpriteResDownloadUtil.i(str, "see_res", true), false, 2);
            if (z) {
                str2 = "funny_sprite_show_day";
            } else {
                str2 = "funny_sprite_show_dark";
            }
            rn6 a3 = bj5.a(FunnySpriteResDownloadUtil.i(str2, "see_res", true), true, 2);
            if (z) {
                str3 = "funny_sprite_exit_day";
            } else {
                str3 = "funny_sprite_exit_dark";
            }
            this.h.u(a2, a3, bj5.a(FunnySpriteResDownloadUtil.i(str3, "see_res", true), false, 2));
            SpriteBottomTipView i = i(activity);
            this.i = i;
            this.h.x(i);
            this.h.s(UtilHelper.getDimenPixelSize(R.dimen.tbds120), UtilHelper.getDimenPixelSize(R.dimen.tbds239));
            this.h.t(g());
            this.h.v(new a(this));
            this.h.r(new b(this));
            this.h.z();
            this.j = true;
            k();
            return true;
        }
        return invokeV.booleanValue;
    }
}
