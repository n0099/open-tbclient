package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonInfoMoreDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f55625e;

    /* renamed from: f  reason: collision with root package name */
    public View f55626f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f55627g;

    /* renamed from: h  reason: collision with root package name */
    public float f55628h;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonInfoMoreDialog f55629e;

        public a(PersonInfoMoreDialog personInfoMoreDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personInfoMoreDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55629e = personInfoMoreDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55629e.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoMoreDialog(Context context) {
        super(context, 16973835);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55628h = 0.33f;
        this.f55625e = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(R.layout.person_info_more_dialog);
            Display defaultDisplay = ((WindowManager) this.f55625e.getSystemService("window")).getDefaultDisplay();
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = defaultDisplay.getWidth();
            getWindow().setAttributes(attributes);
            getWindow().setBackgroundDrawableResource(R.color.transparent);
            getWindow().setDimAmount(this.f55628h);
            getWindow().setGravity(80);
            getWindow().setWindowAnimations(R.style.pb_more_pop_anim);
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root_view);
            this.f55627g = linearLayout;
            linearLayout.setOnClickListener(new a(this));
            if (this.f55626f == null) {
                return;
            }
            this.f55627g.removeAllViews();
            if (this.f55626f.getParent() != null) {
                if (this.f55626f.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.f55626f.getParent()).removeView(this.f55626f);
                    this.f55627g.addView(this.f55626f);
                    return;
                }
                return;
            }
            this.f55627g.addView(this.f55626f);
        }
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f55626f = view;
            LinearLayout linearLayout = this.f55627g;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                if (this.f55626f.getParent() != null) {
                    if (this.f55626f.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.f55626f.getParent()).removeView(this.f55626f);
                        this.f55627g.addView(this.f55626f);
                        return;
                    }
                    return;
                }
                this.f55627g.addView(this.f55626f);
            }
        }
    }

    public void setWindowDimAmount(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            this.f55628h = f2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoMoreDialog(Context context, View view) {
        super(context, 16973835);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55628h = 0.33f;
        this.f55625e = context;
        this.f55626f = view;
    }
}
