package com.baidu.tieba.immessagecenter.mention.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tieba.R;
import com.baidu.tieba.d85;
import com.baidu.tieba.da5;
import com.baidu.tieba.l9;
import com.baidu.tieba.vg5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0003\u001d\u001e\u001fB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\bJ\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0014J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\rR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/tieba/immessagecenter/mention/base/NotificationView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/baidu/tieba/immessagecenter/mention/base/NotificationView$Binding;", "mOnCloseListener", "Lcom/baidu/tieba/immessagecenter/mention/base/NotificationView$OnCloseListener;", "mSkinChangeListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mSkinType", "pageContext", "Lcom/baidu/adp/base/BdPageContext;", "onAttachedToWindow", "", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onClick", "v", "Landroid/view/View;", "onDetachedFromWindow", "setOnCloseListener", "onCloseListener", "Binding", "Companion", "OnCloseListener", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NotificationView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public final l9<?> b;
    public int c;
    public b d;
    public final CustomMessageListener e;

    /* loaded from: classes6.dex */
    public interface b {
        void onClose();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1552701513, "Lcom/baidu/tieba/immessagecenter/mention/base/NotificationView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1552701513, "Lcom/baidu/tieba/immessagecenter/mention/base/NotificationView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NotificationView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NotificationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final C0351a g;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public RelativeLayout b;
        public ImageView c;
        public TextView d;
        public TextView e;
        public ImageView f;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1792521318, "Lcom/baidu/tieba/immessagecenter/mention/base/NotificationView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1792521318, "Lcom/baidu/tieba/immessagecenter/mention/base/NotificationView$a;");
                    return;
                }
            }
            g = new C0351a(null);
        }

        /* renamed from: com.baidu.tieba.immessagecenter.mention.base.NotificationView$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0351a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public /* synthetic */ C0351a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public C0351a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public final a a(View root) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, root)) == null) {
                    Intrinsics.checkNotNullParameter(root, "root");
                    a aVar = new a();
                    aVar.j(root);
                    View findViewById = root.findViewById(R.id.obfuscated_res_0x7f0919c0);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.open_notify_background)");
                    aVar.h((RelativeLayout) findViewById);
                    View findViewById2 = root.findViewById(R.id.obfuscated_res_0x7f0910c1);
                    Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.img_focus)");
                    aVar.g((ImageView) findViewById2);
                    View findViewById3 = root.findViewById(R.id.obfuscated_res_0x7f0919bd);
                    Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.open_desc)");
                    aVar.i((TextView) findViewById3);
                    View findViewById4 = root.findViewById(R.id.obfuscated_res_0x7f0904cd);
                    Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.btn_open)");
                    aVar.e((TextView) findViewById4);
                    View findViewById5 = root.findViewById(R.id.img_close);
                    Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.img_close)");
                    aVar.f((ImageView) findViewById5);
                    return aVar;
                }
                return (a) invokeL.objValue;
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final TextView a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TextView textView = this.e;
                if (textView != null) {
                    return textView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("btnOpen");
                return null;
            }
            return (TextView) invokeV.objValue;
        }

        public final ImageView b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ImageView imageView = this.f;
                if (imageView != null) {
                    return imageView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("imgClose");
                return null;
            }
            return (ImageView) invokeV.objValue;
        }

        public final RelativeLayout c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                RelativeLayout relativeLayout = this.b;
                if (relativeLayout != null) {
                    return relativeLayout;
                }
                Intrinsics.throwUninitializedPropertyAccessException("notifyContainer");
                return null;
            }
            return (RelativeLayout) invokeV.objValue;
        }

        public final TextView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                TextView textView = this.d;
                if (textView != null) {
                    return textView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("openDesc");
                return null;
            }
            return (TextView) invokeV.objValue;
        }

        public final void e(TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, textView) == null) {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.e = textView;
            }
        }

        public final void f(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, imageView) == null) {
                Intrinsics.checkNotNullParameter(imageView, "<set-?>");
                this.f = imageView;
            }
        }

        public final void g(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, imageView) == null) {
                Intrinsics.checkNotNullParameter(imageView, "<set-?>");
                this.c = imageView;
            }
        }

        public final void h(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, relativeLayout) == null) {
                Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
                this.b = relativeLayout;
            }
        }

        public final void i(TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, textView) == null) {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.d = textView;
            }
        }

        public final void j(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
                Intrinsics.checkNotNullParameter(view2, "<set-?>");
                this.a = view2;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NotificationView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(NotificationView notificationView) {
            super(2001304);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {notificationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = notificationView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getCmd() != 2001304) {
                    return;
                }
                this.a.a(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NotificationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ImageView b2;
        TextView a2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = TbadkApplication.getInst().getCurrentPageContext(getContext());
        this.c = 3;
        this.e = new c(this);
        View rootView = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d074b, (ViewGroup) this, true);
        a.C0351a c0351a = a.g;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        a a3 = c0351a.a(rootView);
        this.a = a3;
        if (a3 != null && (a2 = a3.a()) != null) {
            a2.setOnClickListener(this);
        }
        a aVar = this.a;
        if (aVar != null && (b2 = aVar.b()) != null) {
            b2.setOnClickListener(this);
        }
        a(TbadkCoreApplication.getInst().getSkinType());
    }

    public /* synthetic */ NotificationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void a(int i) {
        RelativeLayout relativeLayout;
        TextView textView;
        ImageView b2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || i == this.c) {
            return;
        }
        this.c = i;
        DrawableSelector gradientLinear = TBSelector.makeDrawableSelector().setShape(0).radius((float) R.string.J_X01).gradientLinear(DrawableSelector.LEFT_RIGHT, Arrays.copyOf(new int[]{R.color.open_notify_start_color, R.color.open_notify_start_color, R.color.open_notify_end_color}, 3));
        a aVar = this.a;
        TextView textView2 = null;
        if (aVar != null) {
            relativeLayout = aVar.c();
        } else {
            relativeLayout = null;
        }
        gradientLinear.into(relativeLayout);
        a aVar2 = this.a;
        if (aVar2 != null && (b2 = aVar2.b()) != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(b2, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0110, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        a aVar3 = this.a;
        if (aVar3 != null) {
            textView = aVar3.d();
        } else {
            textView = null;
        }
        d85 d = d85.d(textView);
        d.C(R.dimen.tbds36);
        d.x(R.color.CAM_X0107);
        d.D(R.string.F_X01);
        a aVar4 = this.a;
        if (aVar4 != null) {
            textView2 = aVar4.a();
        }
        d85 d2 = d85.d(textView2);
        d2.C(R.dimen.tbds36);
        d2.D(R.string.F_X01);
        d2.x(R.color.CAM_X0341);
        d85.d(this).f(R.color.CAM_X0201);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.e);
            TiebaStatic.log("c13704");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.e);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Integer num;
        Integer num2;
        Integer num3;
        ImageView b2;
        TextView a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            Integer num4 = null;
            if (view2 != null) {
                num = Integer.valueOf(view2.getId());
            } else {
                num = null;
            }
            a aVar = this.a;
            if (aVar != null && (a2 = aVar.a()) != null) {
                num2 = Integer.valueOf(a2.getId());
            } else {
                num2 = null;
            }
            if (Intrinsics.areEqual(num, num2)) {
                vg5.e(this.b);
                TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 1));
                return;
            }
            if (view2 != null) {
                num3 = Integer.valueOf(view2.getId());
            } else {
                num3 = null;
            }
            a aVar2 = this.a;
            if (aVar2 != null && (b2 = aVar2.b()) != null) {
                num4 = Integer.valueOf(b2.getId());
            }
            if (Intrinsics.areEqual(num3, num4)) {
                da5.p().H("key_im_open_notification_close_time", System.currentTimeMillis());
                b bVar = this.d;
                if (bVar != null && bVar != null) {
                    bVar.onClose();
                }
                TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 2));
            }
        }
    }

    public final void setOnCloseListener(b onCloseListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onCloseListener) == null) {
            Intrinsics.checkNotNullParameter(onCloseListener, "onCloseListener");
            this.d = onCloseListener;
        }
    }
}
