package com.baidu.wallet.personal.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.personal.ui.ExpiredCouponListFragment;
import com.baidu.wallet.personal.ui.UnuseCouponListFragment;
import com.baidu.wallet.personal.ui.UsedCouponListFragment;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes13.dex */
public class CouponTabHostView extends CouponFragmentTabHost {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final String f54688b;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: c  reason: collision with root package name */
    public String f54689c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54690d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Object, View> f54691e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<Object, ImageView> f54692f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, TabHost.OnTabChangeListener> f54693g;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<String, b> f54694h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f54695i;

    /* renamed from: j  reason: collision with root package name */
    public int f54696j;

    /* loaded from: classes13.dex */
    public static class Indicator extends RelativeLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Indicator(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            a(context);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Indicator(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            a(context);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Indicator(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            a(context);
        }

        private void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
                a aVar = new a();
                this.a = aVar;
                super.setOnClickListener(aVar);
            }
        }

        public void a(CouponTabHostView couponTabHostView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, couponTabHostView, str) == null) {
                a aVar = this.a;
                aVar.f54698c = couponTabHostView;
                aVar.f54697b = str;
            }
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
                this.a.a = onClickListener;
            }
        }
    }

    /* loaded from: classes13.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View.OnClickListener a;

        /* renamed from: b  reason: collision with root package name */
        public String f54697b;

        /* renamed from: c  reason: collision with root package name */
        public CouponTabHostView f54698c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CouponTabHostView couponTabHostView;
            b bVar;
            List asList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f54697b != null && view != null && view.getContext() != null) {
                    if (this.f54697b.equals(UnuseCouponListFragment.FRAGMENT_ID)) {
                        asList = Arrays.asList("unusedtab");
                    } else if (this.f54697b.equals(UsedCouponListFragment.FRAGMENT_ID)) {
                        asList = Arrays.asList("usedtab");
                    } else if (this.f54697b.equals(ExpiredCouponListFragment.FRAGMENT_ID)) {
                        asList = Arrays.asList("expiredtab");
                    }
                    DXMSdkSAUtils.onEventWithValues("CouponTabClick", asList);
                }
                if (this.f54697b != null && (couponTabHostView = this.f54698c) != null && (bVar = (b) couponTabHostView.f54694h.get(this.f54697b)) != null) {
                    bVar.a(view, this.f54697b, this.f54698c.getCurrentTabTag());
                }
                View.OnClickListener onClickListener = this.a;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public interface b {
        void a(View view, String str, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2071518827, "Lcom/baidu/wallet/personal/ui/view/CouponTabHostView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2071518827, "Lcom/baidu/wallet/personal/ui/view/CouponTabHostView;");
                return;
            }
        }
        f54688b = CouponTabHostView.class.getSimpleName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponTabHostView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f54690d = false;
        this.f54693g = new HashMap<>();
        this.f54694h = new HashMap<>();
        this.f54696j = 0;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponTabHostView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f54690d = false;
        this.f54693g = new HashMap<>();
        this.f54694h = new HashMap<>();
        this.f54696j = 0;
        a();
    }

    private View a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            LayoutInflater from = LayoutInflater.from(getContext());
            Indicator indicator = new Indicator(getContext());
            indicator.a(this, str2);
            indicator.setGravity(17);
            View inflate = from.inflate(ResUtils.layout(getContext(), "wallet_personal_coupon_tabhost_item"), (ViewGroup) indicator, true);
            inflate.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
            if (TextUtils.isEmpty(str)) {
                inflate.findViewById(ResUtils.id(getContext(), "coupon_tab_item_textview")).setVisibility(8);
            } else {
                ((TextView) inflate.findViewById(ResUtils.id(getContext(), "coupon_tab_item_textview"))).setText(str);
            }
            inflate.setTag(str2);
            this.f54691e.put(str2, inflate);
            ImageView imageView = (ImageView) inflate.findViewById(ResUtils.id(getContext(), "coupon_tab_red_indicator"));
            if (imageView != null) {
                imageView.setTag(str2);
            }
            this.f54692f.put(str2, imageView);
            return inflate;
        }
        return (View) invokeLL.objValue;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65541, this, i2) == null) || this.f54695i == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(this.f54696j * (DisplayUtils.getDisplayWidth(getContext()) / 3), (DisplayUtils.getDisplayWidth(getContext()) / 3) * i2, 0.0f, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setFillAfter(true);
        this.f54695i.setAnimation(translateAnimation);
        this.f54695i.startAnimation(translateAnimation);
        this.f54696j = i2;
    }

    private void b() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || (imageView = this.f54695i) == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.leftMargin = (DisplayUtils.getDisplayWidth(getContext()) / 6) - (layoutParams.width / 2);
        layoutParams.topMargin = -5;
        this.f54695i.setLayoutParams(layoutParams);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f54691e = new HashMap<>();
            this.f54692f = new HashMap<>();
        }
    }

    public void a(FragmentManager fragmentManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragmentManager) == null) {
            a(getContext(), fragmentManager, ResUtils.id(getContext(), "coupon_tab_content"));
            a(UnuseCouponListFragment.FRAGMENT_ID, UnuseCouponListFragment.class, 0, "未使用", 0);
            a(UsedCouponListFragment.FRAGMENT_ID, UsedCouponListFragment.class, 0, "已使用", 0);
            a(ExpiredCouponListFragment.FRAGMENT_ID, ExpiredCouponListFragment.class, 0, "已失效", 0);
            b();
            setCurrentTab(0);
        }
    }

    public void a(String str, Class<?> cls, int i2, String str2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, cls, Integer.valueOf(i2), str2, Integer.valueOf(i3)}) == null) {
            TabHost.TabSpec newTabSpec = newTabSpec(str);
            newTabSpec.setIndicator(a(str2, str));
            a(newTabSpec, cls, null, i3);
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? TextUtils.equals(getCurrentTabTag(), str) : invokeL.booleanValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || a(str)) {
            return;
        }
        setCurrentTabByTag(str);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onFinishInflate();
            this.a = findViewById(ResUtils.id(getContext(), "coupon_full_content"));
            if (this.f54695i == null) {
                this.f54695i = (ImageView) findViewById(ResUtils.id(getContext(), "tab_line"));
            }
        }
    }

    @Override // com.baidu.wallet.personal.ui.view.CouponFragmentTabHost, android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            super.onTabChanged(str);
            TabHost.OnTabChangeListener onTabChangeListener = this.f54693g.get(str);
            if (onTabChangeListener != null) {
                onTabChangeListener.onTabChanged(str);
            }
            View currentTabView = getCurrentTabView();
            if (currentTabView != null) {
                currentTabView.setFocusable(false);
            }
            a(getCurrentTab());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, view, view2) == null) && getVisibility() == 0) {
            super.requestChildFocus(view, view2);
        }
    }

    public void setNextSelectedTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (this.f54690d) {
                b(str);
            } else {
                this.f54689c = str;
            }
        }
    }

    public void setTabByTag(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && !TextUtils.isEmpty(str) && TextUtils.equals(str, getCurrentTabTag())) {
            setCurrentTabByTag(str);
        }
    }
}
