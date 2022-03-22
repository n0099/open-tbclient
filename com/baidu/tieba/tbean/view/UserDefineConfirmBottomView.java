package com.baidu.tieba.tbean.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class UserDefineConfirmBottomView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f36236b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f36237c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f36238d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f36239e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f36240f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f36241g;

    /* renamed from: h  reason: collision with root package name */
    public String f36242h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserDefineConfirmBottomView(Context context) {
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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0863, (ViewGroup) this, true);
            setOrientation(1);
            this.f36236b = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0906bb);
            this.f36237c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09036b);
            this.f36238d = (TextView) findViewById(R.id.obfuscated_res_0x7f09036c);
            this.f36239e = (TextView) findViewById(R.id.obfuscated_res_0x7f09036a);
            this.f36240f = (TextView) findViewById(R.id.obfuscated_res_0x7f09229e);
            this.f36236b.setOnClickListener(null);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.f36237c.setVisibility(0);
            } else {
                this.f36237c.setVisibility(4);
            }
        }
    }

    public void setBigTbeanToastText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            String format = String.format(this.a.getString(R.string.obfuscated_res_0x7f0f02fe), StringHelper.numberUniform(i));
            this.f36242h = format;
            this.f36238d.setText(format);
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f36241g = onClickListener;
            this.f36239e.setOnClickListener(onClickListener);
            this.f36240f.setOnClickListener(this.f36241g);
        }
    }

    public void setPayEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.f36238d.setText(this.f36242h);
                this.f36238d.setGravity(3);
                b(true);
                this.f36240f.setEnabled(true);
                this.f36237c.setVisibility(0);
                this.f36239e.setVisibility(0);
                return;
            }
            this.f36238d.setText(R.string.obfuscated_res_0x7f0f14a2);
            this.f36238d.setGravity(17);
            this.f36240f.setEnabled(false);
            b(false);
            this.f36237c.setVisibility(0);
            this.f36239e.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserDefineConfirmBottomView(Context context, @Nullable AttributeSet attributeSet) {
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserDefineConfirmBottomView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }
}
