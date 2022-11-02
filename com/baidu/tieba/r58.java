package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class r58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public HeadImageView b;
    public TextView c;
    public TextView d;
    public ImageView e;

    public r58(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0958, (ViewGroup) null);
        this.a = inflate;
        this.b = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092736);
        this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092738);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092739);
        ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092737);
        this.e = imageView;
        imageView.setVisibility(0);
        this.a.setTag(this);
    }

    public static r58 b(Context context, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, view2)) == null) {
            if (view2 != null && view2.getTag() != null && (view2.getTag() instanceof r58)) {
                return (r58) view2.getTag();
            }
            return new r58(context);
        }
        return (r58) invokeLL.objValue;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public void c(String str, String str2, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.c.setText(str);
            this.b.setImageDrawable(null);
            this.d.setText(StringHelper.getFormatTime(j));
            this.b.K(str2, 28, false);
        }
    }
}
