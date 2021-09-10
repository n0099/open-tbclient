package com.baidu.wallet.base.widget.dialog.binding;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.dialog.model.ContentDialogModel;
/* loaded from: classes8.dex */
public class ContentDialogBinding extends BaseDialogBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TextView f60729a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentDialogBinding(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60729a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_text_content"));
    }

    @Override // com.baidu.wallet.base.widget.dialog.binding.BaseDialogBinding, com.baidu.wallet.base.widget.dialog.binding.BaseBinding
    public void executeBindings() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.executeBindings();
            ContentDialogModel contentDialogModel = (ContentDialogModel) getViewModel();
            if (contentDialogModel.hideMessage) {
                this.f60729a.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.titleText.getLayoutParams();
                layoutParams.bottomMargin += ((LinearLayout.LayoutParams) this.f60729a.getLayoutParams()).bottomMargin;
                this.titleText.setLayoutParams(layoutParams);
                return;
            }
            int i2 = contentDialogModel.messageId;
            if (i2 != 0) {
                this.f60729a.setText(i2);
            } else if (!TextUtils.isEmpty(contentDialogModel.message)) {
                this.f60729a.setText(contentDialogModel.message);
            }
            this.f60729a.setMovementMethod(LinkMovementMethod.getInstance());
            int i3 = contentDialogModel.messageColor;
            if (i3 != 0) {
                this.f60729a.setTextColor(i3);
            }
            int i4 = contentDialogModel.backgroundColor;
            if (i4 != 0) {
                this.f60729a.setBackgroundColor(i4);
            }
            int i5 = contentDialogModel.messageSize;
            if (i5 != 0) {
                this.f60729a.setTextSize(i5);
            }
        }
    }
}
