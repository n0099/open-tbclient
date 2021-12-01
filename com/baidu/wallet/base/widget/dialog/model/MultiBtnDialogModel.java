package com.baidu.wallet.base.widget.dialog.model;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class MultiBtnDialogModel extends BaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener defaultClickListener;
    public View.OnClickListener firstBtnClickListener;
    public String firstBtnText;
    public boolean firstBtnTextBold;
    public int firstBtnTextId;
    public CharSequence message;
    public int messageId;
    public View.OnClickListener secondBtnClickListener;
    public String secondBtnText;
    public boolean secondBtnTextBold;
    public int secondBtnTextId;
    public View.OnClickListener thirdBtnClickListener;
    public String thirdBtnText;
    public boolean thirdBtnTextBold;
    public int thirdBtnTextId;
    public int titleId;
    public String titleText;

    public MultiBtnDialogModel() {
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
        this.firstBtnTextBold = false;
        this.secondBtnTextBold = false;
        this.thirdBtnTextBold = false;
    }
}
