package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tieba.immessagecenter.msgtab.obs.NewsRemindMsgMonitor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class yn8 extends td8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity e;
    public TextView f;
    public ImageView g;
    public View h;
    public View i;
    public View j;
    public View k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yn8(BaseFragmentActivity context) {
        super(R.layout.obfuscated_res_0x7f0d062c);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = context;
        this.l = -1;
    }

    public static final Boolean Q(NewsRemindMessage newsRemindMessage) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, newsRemindMessage)) == null) {
            if (newsRemindMessage != null) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeL.objValue;
    }

    public final String O(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i > 100) {
                return "99+";
            }
            if (i > 0) {
                return String.valueOf(i);
            }
            return "0";
        }
        return (String) invokeI.objValue;
    }

    public static final Pair R(yn8 this$0, NewsRemindMessage newsRemindMessage) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, this$0, newsRemindMessage)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int i = this$0.l;
            int i2 = 0;
            if (i == 2) {
                i2 = newsRemindMessage.getChatCount();
                z = newsRemindMessage.hasChatRemind();
            } else {
                if (i == 1) {
                    i2 = newsRemindMessage.getMsgCount() + newsRemindMessage.getNotificationCount();
                }
                z = false;
            }
            return new Pair(Integer.valueOf(i2), Boolean.valueOf(z));
        }
        return (Pair) invokeLL.objValue;
    }

    public static final void S(yn8 this$0, Pair pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, pair) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.T(((Number) pair.getFirst()).intValue(), ((Boolean) pair.getSecond()).booleanValue());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = (ImageView) g(R.id.iv_icon);
            this.f = (TextView) g(R.id.new_message);
            this.h = g(R.id.obfuscated_res_0x7f090b23);
            this.i = g(R.id.obfuscated_res_0x7f090b2b);
            this.j = g(R.id.obfuscated_res_0x7f0918e9);
            this.k = g(R.id.obfuscated_res_0x7f0918ea);
        }
    }

    public final void N(dm8 data) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.l = data.getType();
            ImageView imageView = this.g;
            View view2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                imageView = null;
            }
            if (data.getType() == 2) {
                i = R.drawable.obfuscated_res_0x7f080fab;
            } else {
                i = R.drawable.obfuscated_res_0x7f080fb5;
            }
            imageView.setImageResource(i);
            View view3 = this.h;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgView");
            } else {
                view2 = view3;
            }
            view2.setTag(Long.valueOf(data.c()));
            l().setSelected(data.d());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView, com.baidu.tieba.sd8
    public void d(boolean z) {
        int color;
        int color2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            ImageView imageView = null;
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                ImageView imageView2 = this.g;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                } else {
                    imageView = imageView2;
                }
                if (z) {
                    color2 = SkinManager.getColor(R.color.CAM_X0622);
                } else {
                    color2 = SkinManager.getColor(R.color.CAM_X0341);
                }
                imageView.setColorFilter(color2);
                return;
            }
            ImageView imageView3 = this.g;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
            } else {
                imageView = imageView3;
            }
            if (z) {
                color = -1;
            } else {
                color = SkinManager.getColor(R.color.CAM_X0341);
            }
            imageView.setColorFilter(color);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.view.View] */
    public final void T(int i, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            View view2 = this.i;
            TextView textView = null;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgCountBgView");
                view2 = null;
            }
            if (i > 0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            bn6.f(view2, i2);
            if (i > 0) {
                View view3 = this.k;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemindBg");
                    view3 = null;
                }
                bn6.f(view3, 8);
                TextView textView2 = this.f;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                } else {
                    textView = textView2;
                }
                textView.setText(O(i));
            } else if (z) {
                ?? r6 = this.k;
                if (r6 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemindBg");
                } else {
                    textView = r6;
                }
                bn6.f(textView, 0);
            } else {
                ?? r62 = this.k;
                if (r62 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemindBg");
                } else {
                    textView = r62;
                }
                bn6.f(textView, 8);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView, com.baidu.tieba.jd8
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.b();
            xxb j = j();
            if (j != null) {
                j.a(NewsRemindMsgMonitor.f.a().k().k(new ptb() { // from class: com.baidu.tieba.dn8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.ptb
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? yn8.Q((NewsRemindMessage) obj) : invokeL.objValue;
                    }
                }).p(new ptb() { // from class: com.baidu.tieba.ln8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.ptb
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? yn8.R(yn8.this, (NewsRemindMessage) obj) : invokeL.objValue;
                    }
                }).F(new ltb() { // from class: com.baidu.tieba.pn8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.ltb
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            yn8.S(yn8.this, (Pair) obj);
                        }
                    }
                }));
            }
        }
    }

    public final BaseFragmentActivity getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (BaseFragmentActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sd8
    public void onChangeSkinType(int i) {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            int i2 = R.color.CAM_X0341;
            View view2 = null;
            if (i == 4) {
                ImageView imageView = this.g;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                    imageView = null;
                }
                if (l().isSelected()) {
                    i2 = R.color.CAM_X0622;
                }
                imageView.setColorFilter(SkinManager.getColor(i2));
                View view3 = this.h;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBgView");
                    view3 = null;
                }
                view3.setBackgroundResource(R.drawable.obfuscated_res_0x7f080fad);
            } else {
                ImageView imageView2 = this.g;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                    imageView2 = null;
                }
                if (l().isSelected()) {
                    color = -1;
                } else {
                    color = SkinManager.getColor(R.color.CAM_X0341);
                }
                imageView2.setColorFilter(color);
                View view4 = this.h;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBgView");
                    view4 = null;
                }
                view4.setBackgroundResource(R.drawable.obfuscated_res_0x7f080fac);
            }
            TextView textView = this.f;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                textView = null;
            }
            s75 d = s75.d(textView);
            d.x(R.color.CAM_X0101);
            d.f(R.color.CAM_X0301);
            View view5 = this.i;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgCountBgView");
                view5 = null;
            }
            s75.d(view5).l(R.color.CAM_X0202);
            View view6 = this.k;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemindBg");
                view6 = null;
            }
            s75.d(view6).l(R.color.CAM_X0202);
            View view7 = this.j;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemind");
            } else {
                view2 = view7;
            }
            s75.d(view2).f(R.color.CAM_X0301);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            TextView textView = this.f;
            View view2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                textView = null;
            }
            s75 d = s75.d(textView);
            d.o(R.string.J_X07);
            d.D(R.string.F_X02);
            d.C(R.dimen.T_X10);
            d.x(R.color.CAM_X0101);
            d.f(R.color.CAM_X0301);
            View view3 = this.i;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgCountBgView");
                view3 = null;
            }
            s75 d2 = s75.d(view3);
            d2.o(R.string.J_X07);
            d2.m(R.dimen.L_X04);
            d2.l(R.color.CAM_X0202);
            View view4 = this.j;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemind");
                view4 = null;
            }
            s75 d3 = s75.d(view4);
            d3.o(R.string.J_X07);
            d3.f(R.color.CAM_X0301);
            View view5 = this.k;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemindBg");
            } else {
                view2 = view5;
            }
            s75 d4 = s75.d(view2);
            d4.o(R.string.J_X07);
            d4.m(R.dimen.L_X04);
            d4.l(R.color.CAM_X0202);
        }
    }
}
