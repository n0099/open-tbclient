package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ShareFromFrsView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f33907b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33908c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33909d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33910e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33911f;

    /* renamed from: g  reason: collision with root package name */
    public Context f33912g;

    /* renamed from: h  reason: collision with root package name */
    public ShareFromFrsMsgData f33913h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareFromFrsView(Context context, AttributeSet attributeSet) {
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
        this.f33912g = context;
        b();
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return m.cutString(str, 8) + this.f33912g.getString(R.string.obfuscated_res_0x7f0f063c);
        }
        return (String) invokeL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0771, this);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090b98);
            this.f33907b = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f090b39);
            this.f33909d = (TextView) findViewById(R.id.obfuscated_res_0x7f090b86);
            this.f33911f = (TextView) findViewById(R.id.obfuscated_res_0x7f090ba2);
            this.f33908c = (TextView) findViewById(R.id.obfuscated_res_0x7f090b87);
            this.f33910e = (TextView) findViewById(R.id.obfuscated_res_0x7f090ba3);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.setText(a(this.f33913h.getName()));
            this.f33907b.setPlaceHolder(1);
            this.f33907b.setAutoChangeStyle(false);
            this.f33907b.J(this.f33913h.getImageUrl(), 10, false);
            this.f33909d.setText(StringHelper.numFormatOver10000(this.f33913h.getMemberNum()));
            this.f33911f.setText(StringHelper.numFormatOver10000(this.f33913h.getPostNum()));
        }
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, shareFromFrsMsgData) == null) {
            this.f33913h = shareFromFrsMsgData;
            c();
        }
    }

    public void setIsLeft(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.a.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
                this.f33909d.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
                this.f33911f.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
                this.f33908c.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
                this.f33910e.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
                return;
            }
            this.a.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
            this.f33909d.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
            this.f33911f.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
            this.f33908c.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
            this.f33910e.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareFromFrsView(Context context) {
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
        this.f33912g = context;
        b();
    }
}
