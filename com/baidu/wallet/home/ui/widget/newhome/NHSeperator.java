package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class NHSeperator extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SP_BOTTOM_LINE = "sp_bottom_line";
    public static final String SP_FULL_LINE = "sp_full_line";
    public static final String SP_NONE = "sp_none";
    public static final String SP_SINGLE_LINE = "sp_single_line";
    public static final String SP_SINGLE_SEP = "sp_single_seperator";
    public transient /* synthetic */ FieldHolder $fh;
    public View mBottomLine;
    public View mSeperator;
    public View mTopLine;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHSeperator(Context context) {
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
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            setOrientation(1);
            View view = new View(getContext());
            this.mTopLine = view;
            view.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_nh_seperate_light"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(getContext(), 0.5f));
            View view2 = new View(getContext());
            this.mSeperator = view2;
            view2.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_extend_home_nh_separate_bright"));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(getContext(), 9.0f));
            View view3 = new View(getContext());
            this.mBottomLine = view3;
            view3.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_home_nh_seperate_light"));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(getContext(), 0.5f));
            addView(this.mTopLine, layoutParams);
            addView(this.mSeperator, layoutParams2);
            addView(this.mBottomLine, layoutParams3);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void setType(String str) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            switch (str.hashCode()) {
                case -2037302618:
                    if (str.equals(SP_BOTTOM_LINE)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -2013672486:
                    if (str.equals(SP_NONE)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1736883252:
                    if (str.equals(SP_SINGLE_SEP)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -601620414:
                    if (str.equals(SP_FULL_LINE)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1134893737:
                    if (str.equals(SP_SINGLE_LINE)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                this.mTopLine.setVisibility(8);
                this.mSeperator.setVisibility(0);
                this.mBottomLine.setVisibility(8);
            } else if (c2 == 1) {
                this.mTopLine.setVisibility(0);
                this.mSeperator.setVisibility(8);
                this.mBottomLine.setVisibility(8);
            } else if (c2 == 2) {
                this.mTopLine.setVisibility(8);
                this.mSeperator.setVisibility(0);
                this.mBottomLine.setVisibility(0);
            } else if (c2 != 3) {
                this.mTopLine.setVisibility(8);
                this.mSeperator.setVisibility(8);
                this.mBottomLine.setVisibility(8);
            } else {
                this.mTopLine.setVisibility(0);
                this.mSeperator.setVisibility(0);
                this.mBottomLine.setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NHSeperator(Context context, AttributeSet attributeSet) {
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
        a();
    }
}
