package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
public final class xr8 extends ig8 {
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
    public xr8(BaseFragmentActivity context) {
        super(R.layout.obfuscated_res_0x7f0d063c);
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

    public static final Boolean S(NewsRemindMessage newsRemindMessage) {
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

    public final String R(int i) {
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

    public static final Pair T(xr8 this$0, NewsRemindMessage newsRemindMessage) {
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

    public static final void U(xr8 this$0, Pair pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, pair) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.V(((Number) pair.getFirst()).intValue(), ((Boolean) pair.getSecond()).booleanValue());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = (ImageView) j(R.id.iv_icon);
            this.f = (TextView) j(R.id.new_message);
            this.h = j(R.id.obfuscated_res_0x7f090b3d);
            this.i = j(R.id.obfuscated_res_0x7f090b45);
            this.j = j(R.id.obfuscated_res_0x7f091913);
            this.k = j(R.id.obfuscated_res_0x7f091914);
        }
    }

    public final void Q(op8 data) {
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
                i = R.drawable.obfuscated_res_0x7f080fbe;
            } else {
                i = R.drawable.obfuscated_res_0x7f080fc8;
            }
            imageView.setImageResource(i);
            View view3 = this.h;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgView");
            } else {
                view2 = view3;
            }
            view2.setTag(Long.valueOf(data.c()));
            m().setSelected(data.d());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView, com.baidu.tieba.hg8
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
    public final void V(int i, boolean z) {
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
            nl6.f(view2, i2);
            if (i > 0) {
                View view3 = this.k;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemindBg");
                    view3 = null;
                }
                nl6.f(view3, 8);
                TextView textView2 = this.f;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                } else {
                    textView = textView2;
                }
                textView.setText(R(i));
            } else if (z) {
                ?? r6 = this.k;
                if (r6 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemindBg");
                } else {
                    textView = r6;
                }
                nl6.f(textView, 0);
            } else {
                ?? r62 = this.k;
                if (r62 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemindBg");
                } else {
                    textView = r62;
                }
                nl6.f(textView, 8);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView, com.baidu.tieba.yf8
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.c();
            y5c k = k();
            if (k != null) {
                k.a(NewsRemindMsgMonitor.f.a().k().k(new q1c() { // from class: com.baidu.tieba.dr8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.q1c
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? xr8.S((NewsRemindMessage) obj) : invokeL.objValue;
                    }
                }).p(new q1c() { // from class: com.baidu.tieba.kr8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.q1c
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? xr8.T(xr8.this, (NewsRemindMessage) obj) : invokeL.objValue;
                    }
                }).H(new m1c() { // from class: com.baidu.tieba.or8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.m1c
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            xr8.U(xr8.this, (Pair) obj);
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

    @Override // com.baidu.tieba.hg8
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
                if (m().isSelected()) {
                    i2 = R.color.CAM_X0622;
                }
                imageView.setColorFilter(SkinManager.getColor(i2));
                View view3 = this.h;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBgView");
                    view3 = null;
                }
                view3.setBackgroundResource(R.drawable.obfuscated_res_0x7f080fc0);
            } else {
                ImageView imageView2 = this.g;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                    imageView2 = null;
                }
                if (m().isSelected()) {
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
                view4.setBackgroundResource(R.drawable.obfuscated_res_0x7f080fbf);
            }
            TextView textView = this.f;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                textView = null;
            }
            EMManager.from(textView).setTextColor(R.color.CAM_X0101).setBackGroundColor(R.color.CAM_X0301);
            View view5 = this.i;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgCountBgView");
                view5 = null;
            }
            EMManager.from(view5).setBorderColor(R.color.CAM_X0202);
            View view6 = this.k;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemindBg");
                view6 = null;
            }
            EMManager.from(view6).setBorderColor(R.color.CAM_X0202);
            View view7 = this.j;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemind");
            } else {
                view2 = view7;
            }
            EMManager.from(view2).setBackGroundColor(R.color.CAM_X0301);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            TextView textView = this.f;
            View view2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                textView = null;
            }
            EMManager.from(textView).setCorner(R.string.J_X07).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X10).setTextColor(R.color.CAM_X0101).setBackGroundColor(R.color.CAM_X0301);
            View view3 = this.i;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgCountBgView");
                view3 = null;
            }
            EMManager.from(view3).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X04).setBorderColor(R.color.CAM_X0202);
            View view4 = this.j;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemind");
                view4 = null;
            }
            EMManager.from(view4).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0301);
            View view5 = this.k;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemindBg");
            } else {
                view2 = view5;
            }
            EMManager.from(view2).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X04).setBorderColor(R.color.CAM_X0202);
        }
    }
}
