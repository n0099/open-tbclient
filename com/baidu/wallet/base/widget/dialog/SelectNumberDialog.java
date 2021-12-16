package com.baidu.wallet.base.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.BaseDialog;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes13.dex */
public class SelectNumberDialog extends BaseDialog implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public AdapterView.OnItemClickListener f52833b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectNumberDialog(Context context) {
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
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        this.a = linearLayout;
        linearLayout.setOrientation(1);
        getWindow().setBackgroundDrawableResource(ResUtils.color(context, "wallet_base_transparent"));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            dismiss();
            if (this.f52833b == null || view.getTag() == null) {
                return;
            }
            this.f52833b.onItemClick(null, view, ((Integer) view.getTag()).intValue(), 0L);
        }
    }

    @Override // com.baidu.apollon.base.widget.BaseDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            addContentView(this.a);
            hideButtons();
            setTitleText("选择手机号");
            setCancelable(true);
        }
    }

    public void setData(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null || list.size() <= 1) {
            return;
        }
        this.a.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(this.mContext, 45.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(this.mContext, 1.0f));
        for (int i2 = 1; i2 < list.size(); i2++) {
            if (i2 > 1) {
                View view = new View(this.mContext);
                view.setBackgroundColor(ResUtils.getColor(this.mContext, "bd_wallet_gray"));
                view.setLayoutParams(layoutParams2);
                this.a.addView(view);
            }
            TextView textView = new TextView(this.mContext);
            textView.setText(list.get(i2));
            textView.setPadding(DisplayUtils.dip2px(this.mContext, 10.0f), 0, 0, 0);
            textView.setGravity(19);
            textView.setLayoutParams(layoutParams);
            textView.setTag(Integer.valueOf(i2));
            textView.setOnClickListener(this);
            this.a.addView(textView);
        }
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onItemClickListener) == null) {
            this.f52833b = onItemClickListener;
        }
    }
}
