package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f33900b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f33901c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f33902d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33903e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33904f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33905g;

    /* renamed from: h  reason: collision with root package name */
    public ShareFromGameCenterMsgData f33906h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b(context);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.setFocusable(true);
            this.a.setFocusableInTouchMode(true);
            this.a.requestFocus();
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d037d, this);
            setOrientation(1);
            this.a = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090c72);
            this.f33904f = (TextView) findViewById(R.id.obfuscated_res_0x7f091ce0);
            this.f33900b = (EditText) findViewById(R.id.obfuscated_res_0x7f090c70);
            this.f33901c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090c75);
            this.f33902d = (BarImageView) findViewById(R.id.obfuscated_res_0x7f090c74);
            this.f33903e = (TextView) findViewById(R.id.obfuscated_res_0x7f090c71);
            SkinManager.setViewTextColor(this.f33904f, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f33900b, R.color.CAM_X0105, 2);
            this.f33900b.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setViewTextColor(this.f33903e, R.color.CAM_X0106, 1);
            this.f33900b.setPadding(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5), 0, 0, 0);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090c6f);
            this.f33905g = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0108, 1);
            a();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f33904f.setText(this.f33906h.getTitle());
            this.f33901c.setTag(this.f33906h.getImageUrl());
            this.f33901c.J(this.f33906h.getImageUrl(), 17, false);
            this.f33902d.setVisibility(0);
            this.f33902d.setTag(this.f33906h.getShareSourceIcon());
            this.f33902d.J(this.f33906h.getShareSourceIcon(), 17, false);
            this.f33903e.setText(this.f33906h.getContent());
            TextView textView = this.f33905g;
            textView.setText("来自" + this.f33906h.getShareSource());
        }
    }

    public EditText getChatMsgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33900b : (EditText) invokeV.objValue;
    }

    public String getLeaveMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            EditText editText = this.f33900b;
            if (editText != null) {
                return m.charSequence2String(editText.getText(), null);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, shareFromGameCenterMsgData) == null) {
            this.f33906h = shareFromGameCenterMsgData;
            c();
        }
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareFromPBMsgData) == null) {
            this.f33904f.setText(shareFromPBMsgData.getTitle());
            if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
                shareFromPBMsgData.setImageUrl("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
            }
            this.f33901c.setTag(shareFromPBMsgData.getImageUrl());
            this.f33901c.J(shareFromPBMsgData.getImageUrl(), 17, false);
            this.f33902d.setVisibility(8);
            this.f33903e.setText(shareFromPBMsgData.getContent());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new LinearLayout.LayoutParams(-1, -2) : (LinearLayout.LayoutParams) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Game2GroupShareDialogView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(context);
    }
}
