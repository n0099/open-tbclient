package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.walletsdk.pay.R;
/* loaded from: classes8.dex */
public class c extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f63640a;

    /* renamed from: b  reason: collision with root package name */
    public View f63641b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f63642c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f63643d;

    /* renamed from: e  reason: collision with root package name */
    public a f63644e;

    /* loaded from: classes8.dex */
    public interface a {
        void a(View view, GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
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
        if (context == null) {
            return;
        }
        this.f63640a = context;
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            View inflate = LayoutInflater.from(this.f63640a).inflate(R.layout.wallet_base_new_certificate_type_dialog, (ViewGroup) null);
            this.f63641b = inflate;
            this.f63643d = (LinearLayout) inflate.findViewById(R.id.lin_certificate_type_content);
            this.f63642c = (ImageView) this.f63641b.findViewById(R.id.iv_certificate_type_close);
            setTouchable(true);
            setFocusable(true);
            setOutsideTouchable(true);
            setWidth(((WindowManager) this.f63640a.getSystemService("window")).getDefaultDisplay().getWidth());
            setBackgroundDrawable(null);
            this.f63642c.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.widget.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f63645a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f63645a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f63645a.dismiss();
                    }
                }
            });
            setContentView(this.f63641b);
        }
    }

    public void a(GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, certificateTypeInfoArr) == null) {
            this.f63643d.removeAllViews();
            if (certificateTypeInfoArr == null || certificateTypeInfoArr.length <= 0) {
                return;
            }
            for (int i2 = 0; i2 < certificateTypeInfoArr.length; i2++) {
                View inflate = LayoutInflater.from(this.f63640a).inflate(R.layout.wallet_base_new_certificate_type_item, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.view_certificate_type_line);
                ((TextView) inflate.findViewById(R.id.tv_certificate_type)).setText(certificateTypeInfoArr[i2].description);
                if (i2 == certificateTypeInfoArr.length - 1) {
                    findViewById.setVisibility(8);
                }
                this.f63643d.addView(inflate);
                inflate.setOnClickListener(new View.OnClickListener(this, certificateTypeInfoArr, i2) { // from class: com.baidu.wallet.paysdk.ui.widget.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ GetCardInfoResponse.CertificateTypeInfo[] f63646a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f63647b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ c f63648c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, certificateTypeInfoArr, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f63648c = this;
                        this.f63646a = certificateTypeInfoArr;
                        this.f63647b = i2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            if (this.f63648c.f63644e != null) {
                                a aVar = this.f63648c.f63644e;
                                GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr2 = this.f63646a;
                                int i3 = this.f63647b;
                                aVar.a(view, certificateTypeInfoArr2[i3], i3);
                            }
                            this.f63648c.dismiss();
                        }
                    }
                });
            }
        }
    }

    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            showAtLocation(view, 81, 0, 0);
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f63644e = aVar;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout linearLayout = this.f63643d;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            this.f63640a = null;
            this.f63644e = null;
        }
    }
}
