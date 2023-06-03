package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.ext.widget.dialog.AutoOrientationBtnActDialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ui.SelectorTextView;
import com.baidu.searchbox.ui.util.PorterDuffModeHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jx extends AutoOrientationBtnActDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public SelectorTextView c;
    public c d;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx a;

        public a(jx jxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jxVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d.f != null) {
                this.a.d.f.onItemClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx a;

        public b(jx jxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jxVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d.e != null) {
                this.a.d.e.onItemClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends AutoOrientationBtnActDialog.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public float b;
        public int c;
        public int d;
        public AutoOrientationBtnActDialog.OnItemClickListener e;
        public AutoOrientationBtnActDialog.OnItemClickListener f;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.android.ext.widget.dialog.AutoOrientationBtnActDialog.Builder
        public AutoOrientationBtnActDialog getDialog() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                jx jxVar = (jx) super.getDialog();
                jxVar.c(this);
                return jxVar;
            }
            return (AutoOrientationBtnActDialog) invokeV.objValue;
        }

        @Override // com.baidu.android.ext.widget.dialog.AutoOrientationBtnActDialog.Builder
        public AutoOrientationBtnActDialog onCreateDialog() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return new jx();
            }
            return (AutoOrientationBtnActDialog) invokeV.objValue;
        }

        public c e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.a = str;
                return this;
            }
            return (c) invokeL.objValue;
        }

        public c f(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
                this.b = f;
                return this;
            }
            return (c) invokeF.objValue;
        }

        public c g(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                super.setTitle(i);
                return this;
            }
            return (c) invokeI.objValue;
        }

        public c h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                super.setTitle(str);
                return this;
            }
            return (c) invokeL.objValue;
        }

        @Override // com.baidu.android.ext.widget.dialog.AutoOrientationBtnActDialog.Builder
        public /* bridge */ /* synthetic */ AutoOrientationBtnActDialog.Builder setTitle(int i) {
            g(i);
            return this;
        }

        @Override // com.baidu.android.ext.widget.dialog.AutoOrientationBtnActDialog.Builder
        public /* bridge */ /* synthetic */ AutoOrientationBtnActDialog.Builder setTitle(String str) {
            h(str);
            return this;
        }
    }

    public jx() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.d = cVar;
        }
    }

    public final void b() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (cVar = this.d) == null) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.a)) {
            if (this.d.b > 0.0f) {
                this.b.setTextSize(0, this.d.b);
            }
            this.b.setText(this.d.a);
            this.b.setOnClickListener(new a(this));
        } else {
            this.a.setVisibility(8);
        }
        if (this.d.c > 0) {
            this.c.setVisibility(0);
            this.c.setText(AppRuntime.getAppContext().getText(this.d.c));
            this.c.setOnClickListener(new b(this));
        } else {
            this.c.setVisibility(8);
        }
        if (this.d.d > 0) {
            Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(this.d.d);
            PorterDuffModeHelper.decorateSrcATopMode(AppRuntime.getAppContext(), drawable);
            drawable.setBounds(0, 0, DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 12.0f), DeviceUtil.ScreenInfo.dp2px(this.mContext, 12.0f));
            this.c.setCompoundDrawables(drawable, null, null, null);
        }
    }

    @Override // com.baidu.android.ext.widget.dialog.AutoOrientationBtnActDialog
    public View createContentView(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(AppRuntime.getAppContext()).inflate(R.layout.obfuscated_res_0x7f0d09be, viewGroup, false);
            this.a = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ef0);
            this.b = textView;
            textView.setTextColor(AppRuntime.getAppContext().getResources().getColor(R.color.safe_dialog_message));
            SelectorTextView selectorTextView = (SelectorTextView) this.a.findViewById(R.id.obfuscated_res_0x7f091ef1);
            this.c = selectorTextView;
            selectorTextView.setTextColor(AppRuntime.getAppContext().getResources().getColor(R.color.safe_dialog_btn_blue));
            b();
            return this.a;
        }
        return (View) invokeL.objValue;
    }
}
