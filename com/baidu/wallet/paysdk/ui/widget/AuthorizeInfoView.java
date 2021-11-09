package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.widget.dialog.PromptTipDialog;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes10.dex */
public class AuthorizeInfoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f60391a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60392b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60393c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60394d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60395e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60396f;

    /* renamed from: g  reason: collision with root package name */
    public String f60397g;

    /* renamed from: h  reason: collision with root package name */
    public String f60398h;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C1820a {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static a f60400a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-483576918, "Lcom/baidu/wallet/paysdk/ui/widget/AuthorizeInfoView$a$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-483576918, "Lcom/baidu/wallet/paysdk/ui/widget/AuthorizeInfoView$a$a;");
                        return;
                    }
                }
                f60400a = new a();
            }
        }

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C1820a.f60400a : (a) invokeV.objValue;
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public b a(int i2, AuthorizeInfoView authorizeInfoView) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, authorizeInfoView)) == null) {
                if (i2 != 1) {
                    return null;
                }
                return new com.baidu.wallet.paysdk.ui.widget.a.a(authorizeInfoView);
            }
            return (b) invokeIL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AuthorizeInfoView f60401a;

        public b(AuthorizeInfoView authorizeInfoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authorizeInfoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60401a = authorizeInfoView;
        }

        public abstract void a(Object obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthorizeInfoView(Context context) {
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
        this.f60397g = "";
        this.f60398h = "";
        a();
    }

    public void refreshView() {
        DirectPayContentResponse payResponse;
        Authorize authorize;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (payResponse = PayDataCache.getInstance().getPayResponse()) == null || (authorize = payResponse.authorize) == null) {
            return;
        }
        this.f60391a.setImageUrl(authorize.sp_logo_url);
        this.f60392b.setText(authorize.sp_company_title);
        setTips(authorize.authorize_action_desc);
        String[] strArr = authorize.authorize_desc;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            this.f60394d.setText(strArr[0]);
        }
        UserData.UserModel userModel = payResponse.user;
        if (userModel != null) {
            this.f60396f.setText(userModel.authorize_display_name);
        }
        Authorize.AuthDetailInfo authDetailInfo = authorize.detail_info;
        if (authDetailInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(authDetailInfo.introduce)) {
            this.f60398h += authorize.detail_info.introduce + StringUtils.LF;
        }
        while (true) {
            String[] strArr2 = authorize.detail_info.detail;
            if (i2 >= strArr2.length) {
                return;
            }
            if (!TextUtils.isEmpty(strArr2[i2])) {
                this.f60398h += "\n· " + authorize.detail_info.detail[i2];
            }
            i2++;
        }
    }

    public void setAmount(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (textView = this.f60395e) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setDesc(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (textView = this.f60394d) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setLogo(String str) {
        NetImageView netImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (netImageView = this.f60391a) == null) {
            return;
        }
        netImageView.setImageUrl(str);
    }

    public void setPhone(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (textView = this.f60396f) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setTipMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f60398h = str;
        }
    }

    public void setTips(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            TextView textView = this.f60393c;
            if (textView != null) {
                textView.setText(str);
            }
            this.f60397g = str;
        }
    }

    public void setTitle(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (textView = this.f60392b) == null) {
            return;
        }
        textView.setText(str);
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_authorize_info_view"), this);
            this.f60391a = (NetImageView) findViewById(ResUtils.id(getContext(), "ni_sp_logo"));
            this.f60392b = (TextView) findViewById(ResUtils.id(getContext(), "tv_sp_name"));
            this.f60393c = (TextView) findViewById(ResUtils.id(getContext(), "tv_sp_action"));
            this.f60394d = (TextView) findViewById(ResUtils.id(getContext(), "tv_auth_desc"));
            this.f60395e = (TextView) findViewById(ResUtils.id(getContext(), "tv_amount_tips"));
            this.f60396f = (TextView) findViewById(ResUtils.id(getContext(), "tv_amount_phone"));
            this.f60393c.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AuthorizeInfoView f60399a;

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
                    this.f60399a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f60399a.f60398h)) {
                        return;
                    }
                    PromptTipDialog promptTipDialog = new PromptTipDialog(this.f60399a.getContext());
                    promptTipDialog.setTitleMessage(this.f60399a.f60397g);
                    promptTipDialog.setMessage(this.f60399a.f60398h);
                    promptTipDialog.setButtonMessage(ResUtils.getString(this.f60399a.getContext(), "dxm_ebpay_know"));
                    promptTipDialog.show();
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthorizeInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60397g = "";
        this.f60398h = "";
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthorizeInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f60397g = "";
        this.f60398h = "";
        a();
    }
}
