package com.baidu.wallet.base.widget.dialog.model;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BaseDialogModel extends BaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener defaultListener;
    public int dialogBackgound;
    public boolean hideButtons;
    public boolean hideNegativeBtn;
    public boolean hidePositiveBtn;
    public boolean hideTitle;
    public View.OnClickListener negativeBtnClickListener;
    public CharSequence negativeBtnText;
    public boolean negativeBtnTextBold;
    public int negativeBtnTextColor;
    public int negativeBtnTextId;
    public int negativeBtnTextSize;
    public View.OnClickListener positiveBtnClickListener;
    public CharSequence positiveBtnText;
    public boolean positiveBtnTextBold;
    public int positiveBtnTextColor;
    public int positiveBtnTextId;
    public int positiveBtnTextSize;
    public CharSequence title;
    public int titleId;

    public BaseDialogModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dialogBackgound = 0;
        this.positiveBtnTextSize = 0;
        this.positiveBtnTextColor = 0;
        this.negativeBtnTextSize = 0;
        this.negativeBtnTextColor = 0;
        this.hideNegativeBtn = false;
        this.hidePositiveBtn = false;
        this.hideTitle = false;
        this.hideButtons = false;
        this.negativeBtnTextBold = true;
        this.positiveBtnTextBold = true;
    }
}
