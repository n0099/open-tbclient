package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.ez4;
import com.baidu.tieba.fw4;
import com.baidu.tieba.kz4;
import com.baidu.tieba.tbadkcore.databinding.LayoutHeadlinesFrameCardBinding;
import com.baidu.tieba.view.SimpleCountDownView;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\b\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001f\u001a\u00020\u0015J\u0010\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\"R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/baidu/tieba/view/CustomFitFrameCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "adapter", "com/baidu/tieba/view/CustomFitFrameCard$adapter$1", "Lcom/baidu/tieba/view/CustomFitFrameCard$adapter$1;", "binding", "Lcom/baidu/tieba/tbadkcore/databinding/LayoutHeadlinesFrameCardBinding;", "headUrls", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "headViewPadding", "", "headViewSize", "headViewStroke", "bindTaskInfoData", "", "taskInfoData", "Lcom/baidu/tbadk/core/data/TaskInfoData;", "changeAutoSwitchVisibility", "visibility", "fillBackgroundCard", "fillCountDownFinishView", "rewardCardData", "Lcom/baidu/tbadk/core/data/RewardCardData;", "fillHeadViews", "onChangeSkin", "setData", "data", "Lcom/baidu/tbadk/core/data/AbsThreadDataSupport;", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class CustomFitFrameCard extends ConstraintLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LayoutHeadlinesFrameCardBinding a;
    public final int b;
    public final int c;
    public final int d;
    public final ArrayList<String> e;
    public final a f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomFitFrameCard(Context context) {
        this(context, null, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* loaded from: classes8.dex */
    public static final class a implements TbImageAutoSwitch.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ CustomFitFrameCard b;

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public a(Context context, CustomFitFrameCard customFitFrameCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, customFitFrameCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = customFitFrameCard;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void a(View view2, int i) {
            HeadImageView headImageView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
                Intrinsics.checkNotNullParameter(view2, "view");
                if (view2 instanceof HeadImageView) {
                    headImageView = (HeadImageView) view2;
                } else {
                    headImageView = null;
                }
                if (headImageView != null) {
                    headImageView.startLoad((String) this.b.e.get(i), 12, false);
                }
            }
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HeadImageView headImageView = new HeadImageView(this.a);
                headImageView.setLayoutParams(new ConstraintLayout.LayoutParams(this.b.b, this.b.b));
                headImageView.setBorderWidth(this.b.c);
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
                headImageView.setIsRound(true);
                headImageView.setDrawBorder(true);
                headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                headImageView.setPlaceHolder(1);
                return headImageView;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.e.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements SimpleCountDownView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomFitFrameCard a;

        public b(CustomFitFrameCard customFitFrameCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {customFitFrameCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = customFitFrameCard;
        }

        @Override // com.baidu.tieba.view.SimpleCountDownView.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.f.setVisibility(8);
                this.a.a.g.setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomFitFrameCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutHeadlinesFrameCardBinding b2 = LayoutHeadlinesFrameCardBinding.b(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(b2, "inflate(LayoutInflater.from(context), this)");
        this.a = b2;
        this.b = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62);
        this.c = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds3);
        this.d = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15);
        this.e = new ArrayList<>();
        this.f = new a(context, this);
        TbImageAutoSwitch tbImageAutoSwitch = this.a.c;
        int i3 = this.b;
        tbImageAutoSwitch.l(3, i3, i3, this.d);
        tbImageAutoSwitch.setAnimationDuration(500);
        tbImageAutoSwitch.setCarouselDelayPeriod(2000);
        tbImageAutoSwitch.setCarouselPeriod(2000);
        tbImageAutoSwitch.setAdapter(this.f);
        TbImage tbImage = this.a.b;
        ScalingUtils.ScaleType FIT_XY = ScalingUtils.ScaleType.FIT_XY;
        Intrinsics.checkNotNullExpressionValue(FIT_XY, "FIT_XY");
        tbImage.setScaleType(FIT_XY);
        f();
    }

    public /* synthetic */ CustomFitFrameCard(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void e(kz4 kz4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, kz4Var) != null) || kz4Var == null) {
            return;
        }
        h(kz4Var);
        ez4 f = kz4Var.f();
        if (f == null) {
            return;
        }
        l(f);
        j(f);
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.a.c.setVisibility(i);
            this.a.e.setVisibility(i);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Drawable drawable = SkinManager.getDrawable(R.drawable.pic_use_header_40_n);
            if (drawable != null) {
                this.a.b.setPlaceHolderDrawable(drawable);
            }
            EMManager.from(this.a.e).setTextColor(R.color.CAM_X0101);
            EMManager.from(this.a.g).setTextColor(R.color.CAM_X0101);
            this.a.f.j();
        }
    }

    public final void h(kz4 kz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kz4Var) == null) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            constraintSet.setDimensionRatio(R.id.background_card, kz4Var.a());
            constraintSet.applyTo(this);
            TbImage tbImage = this.a.b;
            String m = kz4Var.m();
            Intrinsics.checkNotNullExpressionValue(m, "taskInfoData.threadImgUrl");
            tbImage.l(m);
        }
    }

    public final void setData(fw4 fw4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, fw4Var) == null) && fw4Var != null && fw4Var.getThreadData() != null && fw4Var.getThreadData().getTaskInfoData() != null && fw4Var.getThreadData().getTaskInfoData().f() != null) {
            e(fw4Var.getThreadData().getTaskInfoData());
        }
    }

    public final void j(ez4 ez4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ez4Var) == null) {
            this.a.g.setText(ez4Var.c());
            long j = JavaTypesHelper.toLong(ez4Var.d(), 0L) * 1000;
            if (j <= System.currentTimeMillis()) {
                this.a.g.setVisibility(0);
                this.a.f.setVisibility(8);
                return;
            }
            this.a.g.setVisibility(8);
            this.a.f.setVisibility(0);
            this.a.f.l(j, new b(this));
        }
    }

    public final void l(ez4 ez4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ez4Var) == null) {
            if (ListUtils.isEmpty(ez4Var.e())) {
                g(8);
                return;
            }
            this.e.clear();
            this.e.addAll(ez4Var.e());
            g(0);
            this.a.c.q();
            if (!TextUtils.isEmpty(ez4Var.m())) {
                this.a.e.setText(ez4Var.m());
            }
        }
    }
}
