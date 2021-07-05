package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.base.widget.dialog.PromptTipDialog;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
/* loaded from: classes6.dex */
public class AuthorizeInfoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f26721a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26722b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26723c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26724d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26725e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26726f;

    /* renamed from: g  reason: collision with root package name */
    public String f26727g;

    /* renamed from: h  reason: collision with root package name */
    public String f26728h;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0290a {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static a f26730a;
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
                f26730a = new a();
            }
        }

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C0290a.f26730a : (a) invokeV.objValue;
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

    /* loaded from: classes6.dex */
    public static abstract class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public AuthorizeInfoView f26731a;

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
            this.f26731a = authorizeInfoView;
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
        this.f26727g = "";
        this.f26728h = "";
        a();
    }

    public void refreshView() {
        DirectPayContentResponse payResponse;
        Authorize authorize;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (payResponse = PayDataCache.getInstance().getPayResponse()) == null || (authorize = payResponse.authorize) == null) {
            return;
        }
        this.f26721a.setImageUrl(authorize.sp_logo_url);
        this.f26722b.setText(authorize.sp_company_title);
        setTips(authorize.authorize_action_desc);
        String[] strArr = authorize.authorize_desc;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            this.f26724d.setText(strArr[0]);
        }
        UserData.UserModel userModel = payResponse.user;
        if (userModel != null) {
            this.f26726f.setText(userModel.authorize_display_name);
        }
        Authorize.AuthDetailInfo authDetailInfo = authorize.detail_info;
        if (authDetailInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(authDetailInfo.introduce)) {
            this.f26728h += authorize.detail_info.introduce + "\n";
        }
        while (true) {
            String[] strArr2 = authorize.detail_info.detail;
            if (i2 >= strArr2.length) {
                return;
            }
            if (!TextUtils.isEmpty(strArr2[i2])) {
                this.f26728h += "\n· " + authorize.detail_info.detail[i2];
            }
            i2++;
        }
    }

    public void setAmount(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (textView = this.f26725e) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setDesc(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (textView = this.f26724d) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setLogo(String str) {
        NetImageView netImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (netImageView = this.f26721a) == null) {
            return;
        }
        netImageView.setImageUrl(str);
    }

    public void setPhone(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (textView = this.f26726f) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setTipMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f26728h = str;
        }
    }

    public void setTips(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            TextView textView = this.f26723c;
            if (textView != null) {
                textView.setText(str);
            }
            this.f26727g = str;
        }
    }

    public void setTitle(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (textView = this.f26722b) == null) {
            return;
        }
        textView.setText(str);
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_authorize_info_view"), this);
            this.f26721a = (NetImageView) findViewById(ResUtils.id(getContext(), "ni_sp_logo"));
            this.f26722b = (TextView) findViewById(ResUtils.id(getContext(), "tv_sp_name"));
            this.f26723c = (TextView) findViewById(ResUtils.id(getContext(), "tv_sp_action"));
            this.f26724d = (TextView) findViewById(ResUtils.id(getContext(), "tv_auth_desc"));
            this.f26725e = (TextView) findViewById(ResUtils.id(getContext(), "tv_amount_tips"));
            this.f26726f = (TextView) findViewById(ResUtils.id(getContext(), "tv_amount_phone"));
            this.f26723c.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AuthorizeInfoView f26729a;

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
                    this.f26729a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f26729a.f26728h)) {
                        return;
                    }
                    PromptTipDialog promptTipDialog = new PromptTipDialog(this.f26729a.getContext());
                    promptTipDialog.setTitleMessage(this.f26729a.f26727g);
                    promptTipDialog.setMessage(this.f26729a.f26728h);
                    promptTipDialog.setButtonMessage(ResUtils.getString(this.f26729a.getContext(), "ebpay_know"));
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
        this.f26727g = "";
        this.f26728h = "";
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
        this.f26727g = "";
        this.f26728h = "";
        a();
    }
}
