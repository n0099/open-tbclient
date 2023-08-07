package com.baidu.tieba.impersonal.components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.impersonal.components.PersonalMsgContainer;
import com.baidu.tieba.n97;
import com.baidu.tieba.nt8;
import com.baidu.tieba.yt8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u00042\u00020\u0005B#\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00028\u0001¢\u0006\u0002\u0010\u001aJ\r\u0010\u001b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0012J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\u0014\u0010\u001f\u001a\u00020\u00192\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00018\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/tieba/impersonal/components/PersonalMsgContainer;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroid/view/View;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "left", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(ZLandroid/content/Context;Landroid/util/AttributeSet;)V", "avatar", "Lcom/baidu/tbadk/core/view/HeadImageView;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "container", "Landroid/widget/LinearLayout;", "nickName", "Landroid/widget/TextView;", "resend", "Landroid/widget/ImageView;", "rootContainer", "addChild", "", "(Landroid/view/View;)V", "getChild", "()Landroid/view/View;", "getChildContainer", "onChangeSkin", "updateState", "state", "Lcom/baidu/tieba/impersonal/components/uistate/BasePersonalMsgUiState;", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public final class PersonalMsgContainer<T, V extends View> extends ConstraintLayout implements n97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;
    public final ConstraintLayout b;
    public final HeadImageView c;
    public final TextView d;
    public final LinearLayout e;
    public final ImageView f;
    public V g;

    public static final void b(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, view2) == null) {
        }
    }

    public static final void e(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PersonalMsgContainer(boolean z, final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = z;
        if (z) {
            i = R.layout.obfuscated_res_0x7f0d053d;
        } else {
            i = R.layout.obfuscated_res_0x7f0d053e;
        }
        LayoutInflater.from(context).inflate(i, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091f73);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.root_container)");
        this.b = (ConstraintLayout) findViewById;
        View findViewById2 = findViewById(R.id.obfuscated_res_0x7f090316);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.avatar)");
        this.c = (HeadImageView) findViewById2;
        View findViewById3 = findViewById(R.id.obfuscated_res_0x7f091945);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.nickname)");
        this.d = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.obfuscated_res_0x7f0907b1);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.container)");
        this.e = (LinearLayout) findViewById4;
        View findViewById5 = findViewById(R.id.btn_msgitem_resend);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.btn_msgitem_resend)");
        this.f = (ImageView) findViewById5;
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gt8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    PersonalMsgContainer.a(context, this, view2);
                }
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.kt8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    PersonalMsgContainer.b(view2);
                }
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lt8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    PersonalMsgContainer.e(view2);
                }
            }
        });
    }

    public /* synthetic */ PersonalMsgContainer(boolean z, Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, context, (i & 4) != 0 ? null : attributeSet);
    }

    public static final void a(Context context, PersonalMsgContainer this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BdUtilHelper.hideSoftKeyPad(context, this$0);
        }
    }

    public static final void k(nt8 state, View it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, state, it) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Function2<View, yt8<T>, Unit> e = state.e();
            if (e != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                e.invoke(it, state.c());
            }
        }
    }

    @Override // com.baidu.tieba.n97
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d.setTextColor(getResources().getColor(R.color.CAM_X0605));
            HeadImageView headImageView = this.c;
            headImageView.setPlaceHolderAutoChangeSkinType(1);
            headImageView.setIsRound(true);
            headImageView.setAutoChangeStyle(false);
            headImageView.setBorderWidth(UtilHelper.getDimenPixelSize(R.dimen.tbds3));
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            headImageView.setDrawBorder(true);
            if (this.a) {
                SkinManager.setBackgroundResource(this.e, R.drawable.obfuscated_res_0x7f081194);
            } else {
                SkinManager.setBackgroundResource(this.e, R.drawable.obfuscated_res_0x7f081193);
            }
        }
    }

    public final void f(V child) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, child) == null) {
            Intrinsics.checkNotNullParameter(child, "child");
            this.g = child;
            this.e.removeAllViews();
            this.e.addView(child);
        }
    }

    public final V getChild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (V) invokeV.objValue;
    }

    public final LinearLayout getChildContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final void h(final nt8<T> state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.c.startLoad(state.c().e().b(), 12, false);
            this.d.setText(state.c().e().a());
            if (state.c().e().d() && state.c().e().c() == 2) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            this.f.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.it8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        PersonalMsgContainer.k(nt8.this, view2);
                    }
                }
            });
            c();
        }
    }
}
