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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
/* loaded from: classes6.dex */
public class c extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f51110b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f51111c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f51112d;

    /* renamed from: e  reason: collision with root package name */
    public a f51113e;

    /* loaded from: classes6.dex */
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
        this.a = context;
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.wallet_base_new_certificate_type_dialog, (ViewGroup) null);
            this.f51110b = inflate;
            this.f51112d = (LinearLayout) inflate.findViewById(R.id.lin_certificate_type_content);
            this.f51111c = (ImageView) this.f51110b.findViewById(R.id.iv_certificate_type_close);
            setTouchable(true);
            setFocusable(true);
            setOutsideTouchable(true);
            setWidth(((WindowManager) this.a.getSystemService("window")).getDefaultDisplay().getWidth());
            setBackgroundDrawable(null);
            this.f51111c.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.widget.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
                    }
                }
            });
            setContentView(this.f51110b);
        }
    }

    public void a(GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, certificateTypeInfoArr) == null) {
            this.f51112d.removeAllViews();
            if (certificateTypeInfoArr == null || certificateTypeInfoArr.length <= 0) {
                return;
            }
            for (int i2 = 0; i2 < certificateTypeInfoArr.length; i2++) {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.wallet_base_new_certificate_type_item, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.view_certificate_type_line);
                ((TextView) inflate.findViewById(R.id.tv_certificate_type)).setText(certificateTypeInfoArr[i2].description);
                if (i2 == certificateTypeInfoArr.length - 1) {
                    findViewById.setVisibility(8);
                }
                this.f51112d.addView(inflate);
                inflate.setOnClickListener(new View.OnClickListener(this, certificateTypeInfoArr, i2) { // from class: com.baidu.wallet.paysdk.ui.widget.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ GetCardInfoResponse.CertificateTypeInfo[] a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f51114b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ c f51115c;

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
                        this.f51115c = this;
                        this.a = certificateTypeInfoArr;
                        this.f51114b = i2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            if (this.f51115c.f51113e != null) {
                                a aVar = this.f51115c.f51113e;
                                GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr2 = this.a;
                                int i3 = this.f51114b;
                                aVar.a(view, certificateTypeInfoArr2[i3], i3);
                            }
                            this.f51115c.dismiss();
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
            this.f51113e = aVar;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout linearLayout = this.f51112d;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            this.a = null;
            this.f51113e = null;
        }
    }
}
