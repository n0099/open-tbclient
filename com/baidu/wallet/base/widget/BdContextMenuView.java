package com.baidu.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.BdMenu;
import com.baidu.wallet.base.widget.BdMenuItem;
import java.util.List;
/* loaded from: classes8.dex */
public class BdContextMenuView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f60371a = "BdContextMenuView";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f60372b = true;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mMenuLoaded;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    public BdContextMenuView(Context context, AttributeSet attributeSet, int i2) {
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
        this.mMenuLoaded = false;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(1);
            setGravity(17);
            setBackgroundResource(ResUtils.drawable(getContext(), getBackgroundResId()));
            setFocusable(true);
            setFocusableInTouchMode(true);
        }
    }

    public View createSeparator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            View view = new View(context);
            view.setBackgroundResource(ResUtils.color(context, getSeparatorResId()));
            return view;
        }
        return (View) invokeL.objValue;
    }

    public String getBackgroundResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "wallet_base_menu_bg_white_corner" : (String) invokeV.objValue;
    }

    public String getMenuItemBackgroudResId(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) {
            return null;
        }
        return (String) invokeII.objValue;
    }

    public String getMenuItemViewLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "wallet_base_menu_item_view" : (String) invokeV.objValue;
    }

    public String getSeparatorResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "wallet_base_menu_item_separateColor" : (String) invokeV.objValue;
    }

    public void layoutMenu(List<BdMenuItem> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || this.mMenuLoaded) {
            return;
        }
        removeAllViews();
        int size = list.size();
        if (size <= 0) {
            return;
        }
        Context context = getContext();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(context.getResources().getDimensionPixelSize(ResUtils.dimen(getContext(), "bd_wallet_menu_item_width")), 2);
        for (int i2 = 0; i2 < size; i2++) {
            addView(a(list.get(i2), getMenuItemBackgroudResId(i2, size)));
            if (i2 < size - 1) {
                addView(createSeparator(context), layoutParams);
            }
        }
        this.mMenuLoaded = true;
    }

    @Override // com.baidu.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdMenuItem) == null) {
        }
    }

    @Override // com.baidu.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mMenuLoaded = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdContextMenuView(Context context, AttributeSet attributeSet) {
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
        this.mMenuLoaded = false;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdContextMenuView(Context context) {
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
        this.mMenuLoaded = false;
        a();
    }

    private View a(BdMenuItem bdMenuItem, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, bdMenuItem, str)) == null) {
            Context context = getContext();
            TextView textView = (TextView) LayoutInflater.from(context).inflate(ResUtils.layout(getContext(), getMenuItemViewLayoutId()), (ViewGroup) this, false);
            textView.setText(bdMenuItem.getTitle());
            textView.setTextColor(getResources().getColor(ResUtils.color(getContext(), "wallet_base_font_text1Color")));
            textView.setBackgroundResource(ResUtils.drawable(getContext(), "wallet_base_menu_item_bg_selector"));
            Drawable icon = bdMenuItem.getIcon();
            if (icon != null) {
                textView.setCompoundDrawablesWithIntrinsicBounds(icon, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            textView.setOnClickListener(new View.OnClickListener(this, bdMenuItem) { // from class: com.baidu.wallet.base.widget.BdContextMenuView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BdMenuItem f60373a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BdContextMenuView f60374b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bdMenuItem};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60374b = this;
                    this.f60373a = bdMenuItem;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BdMenuItem.OnItemClickListener onClickListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (onClickListener = this.f60373a.getOnClickListener()) == null) {
                        return;
                    }
                    onClickListener.onClick(this.f60373a);
                }
            });
            if (!TextUtils.isEmpty(str)) {
                int paddingBottom = textView.getPaddingBottom();
                int paddingTop = textView.getPaddingTop();
                int paddingRight = textView.getPaddingRight();
                int paddingLeft = textView.getPaddingLeft();
                textView.setBackgroundResource(ResUtils.drawable(context, str));
                textView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
            return textView;
        }
        return (View) invokeLL.objValue;
    }
}
