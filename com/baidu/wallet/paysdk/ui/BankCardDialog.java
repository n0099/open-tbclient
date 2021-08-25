package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.ViewHelper;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.BaseTipDialog;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.List;
/* loaded from: classes8.dex */
public class BankCardDialog extends BaseTipDialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SIGN_PAY = 1;
    public static final int WITHDRAW_ADD_CARD = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f62612a;

    /* renamed from: b  reason: collision with root package name */
    public Context f62613b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62614c;

    /* renamed from: d  reason: collision with root package name */
    public List<CardDisplayInfo> f62615d;

    /* renamed from: e  reason: collision with root package name */
    public IListItemClickCallback f62616e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62617f;

    /* loaded from: classes8.dex */
    public static class CardDisplayInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f62630a;

        /* renamed from: b  reason: collision with root package name */
        public String f62631b;

        /* renamed from: c  reason: collision with root package name */
        public String f62632c;

        /* renamed from: d  reason: collision with root package name */
        public String f62633d;

        /* renamed from: e  reason: collision with root package name */
        public String f62634e;

        public CardDisplayInfo(String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62632c = "1";
            this.f62633d = "";
            this.f62634e = "";
            this.f62630a = str;
            this.f62631b = str2;
            this.f62632c = str3;
            this.f62633d = str4;
            this.f62634e = "";
        }
    }

    /* loaded from: classes8.dex */
    public interface IListItemClickCallback {
        void onChangeSucceed();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankCardDialog(Context context) {
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
        this.f62614c = false;
        this.f62617f = false;
        this.f62613b = context;
        setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BankCardDialog f62618a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f62618a = this;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) && this.f62618a.f62617f) {
                    PasswordController.getPassWordInstance().clearCheckPwdListener();
                }
            }
        });
    }

    public int getChooseIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f62614c) {
                return -2;
            }
            for (int i2 = 0; i2 < this.f62612a.getChildCount(); i2++) {
                ImageButton imageButton = (ImageButton) this.f62612a.getChildAt(i2).findViewById(ResUtils.id(this.f62613b, "bank_card_check_btn"));
                if (imageButton != null && imageButton.isSelected()) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.wallet.base.widget.BaseTipDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from(this.f62613b);
            }
            setTitleMessage(ResUtils.getString(this.f62613b, "bank_card_dialog_title"));
            findViewById(ResUtils.id(this.f62613b, "dialog_btns")).setVisibility(8);
            View inflate = this.mInflater.inflate(ResUtils.layout(this.f62613b, "wallet_base_bank_card_dialog_content_layout"), (ViewGroup) null);
            this.f62612a = (LinearLayout) inflate.findViewById(ResUtils.id(this.f62613b, "content_layout"));
            addContentView(inflate);
        }
    }

    public void setBankList(List<CardDisplayInfo> list, int i2, boolean z, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str}) == null) {
            this.f62615d = list;
            a(i2, z, i3, str);
        }
    }

    public void setOnIListItemClickCallback(IListItemClickCallback iListItemClickCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iListItemClickCallback) == null) {
            this.f62616e = iListItemClickCallback;
        }
    }

    private void a(int i2, boolean z, int i3, String str) {
        List<CardDisplayInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str}) == null) || (list = this.f62615d) == null || list.size() == 0) {
            return;
        }
        this.f62612a.removeAllViews();
        int i4 = 0;
        while (true) {
            if (i4 >= this.f62615d.size()) {
                break;
            }
            CardDisplayInfo cardDisplayInfo = this.f62615d.get(i4);
            View inflate = this.mInflater.inflate(ResUtils.layout(this.f62613b, "wallet_base_bank_card_dialog_item"), (ViewGroup) null);
            this.f62612a.addView(inflate);
            TextView textView = (TextView) inflate.findViewById(ResUtils.id(this.f62613b, "card_tip_tv"));
            ((NetImageView) inflate.findViewById(ResUtils.id(this.f62613b, "wallet_personal_my_bank_card_icon"))).setImageUrl(cardDisplayInfo.f62630a);
            ((TextView) inflate.findViewById(ResUtils.id(this.f62613b, "card_name_tv"))).setText(cardDisplayInfo.f62631b);
            if (!"1".equals(cardDisplayInfo.f62632c) && !TextUtils.isEmpty(cardDisplayInfo.f62633d)) {
                textView.setText(cardDisplayInfo.f62633d);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            if (!"1".equals(cardDisplayInfo.f62632c)) {
                r3 = 0.4f;
            }
            ViewHelper.setAlpha(inflate, r3);
            inflate.setOnClickListener(new View.OnClickListener(this, cardDisplayInfo) { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CardDisplayInfo f62619a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BankCardDialog f62620b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cardDisplayInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62620b = this;
                    this.f62619a = cardDisplayInfo;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!"1".equals(this.f62619a.f62632c) && !TextUtils.isEmpty(this.f62619a.f62633d)) {
                            GlobalUtils.toast(this.f62620b.f62613b, this.f62619a.f62633d);
                        }
                        if (this.f62620b.f62616e != null) {
                            this.f62620b.f62616e.onChangeSucceed();
                            this.f62620b.f62616e = null;
                        }
                    }
                }
            });
            i4++;
        }
        View inflate2 = this.mInflater.inflate(ResUtils.layout(this.f62613b, "wallet_balance_bank_card_dialog_add_card_item"), (ViewGroup) null);
        this.f62612a.addView(inflate2);
        ViewHelper.setAlpha(inflate2, z ? 1.0f : 0.4f);
        inflate2.setOnClickListener(new View.OnClickListener(this, z, i3, str) { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean f62621a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f62622b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f62623c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BankCardDialog f62624d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Boolean.valueOf(z), Integer.valueOf(i3), str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f62624d = this;
                this.f62621a = z;
                this.f62622b = i3;
                this.f62623c = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    if (this.f62621a) {
                        int i5 = this.f62622b;
                        if (i5 == 1) {
                            BaiduPay.getInstance().bindCardAuth(this.f62624d.f62613b, false);
                            new Handler().postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f62625a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i6 = newInitContext.flag;
                                        if ((i6 & 1) != 0) {
                                            int i7 = i6 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f62625a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f62625a.f62624d.dismiss();
                                    }
                                }
                            }, 300L);
                            StatisticManager.onEvent(StatServiceEvent.EVENT_AuthorizePay_AddCard);
                        } else if (i5 != 2) {
                            BaiduPay.getInstance().bindCard(this.f62624d.f62613b, new BaiduPay.IBindCardCallback(this) { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f62626a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i6 = newInitContext.flag;
                                        if ((i6 & 1) != 0) {
                                            int i7 = i6 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f62626a = this;
                                }

                                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                                public void onChangeFailed(String str2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, str2) == null) {
                                        this.f62626a.f62624d.f62614c = false;
                                        this.f62626a.f62624d.dismiss();
                                    }
                                }

                                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                                public void onChangeSucceed(String str2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                                        this.f62626a.f62624d.f62614c = true;
                                        GlobalUtils.toast(this.f62626a.f62624d.f62613b, ResUtils.getString(this.f62626a.f62624d.f62613b, "wallet_base_bind_success"));
                                        this.f62626a.f62624d.dismiss();
                                    }
                                }
                            }, PayRequestCache.BindCategory.Initiative, 1, "", null, null, null, false, null);
                        } else {
                            this.f62624d.a(this.f62623c);
                            if (this.f62624d.f62616e != null) {
                                this.f62624d.f62616e.onChangeSucceed();
                                this.f62624d.f62616e = null;
                            }
                        }
                    } else if (this.f62622b != 1) {
                        GlobalUtils.toast(this.f62624d.f62613b, ResUtils.getString(this.f62624d.f62613b, "ebpay_bank_count_beyond"));
                    } else {
                        GlobalUtils.toast(this.f62624d.f62613b, ResUtils.getString(this.f62624d.f62613b, "ebpay_bankcard_overflow_tips2"));
                    }
                }
            }
        });
        ((TextView) findViewById(ResUtils.id(this.f62613b, "wallet_balance_bankcard_select"))).setText(ResUtils.getString(this.f62613b, "ebpay_use_new_card") + "                       ");
        a(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) {
            BaiduPay.getInstance().bindCard(this.f62613b, new BaiduPay.IBindCardCallback(this) { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BankCardDialog f62627a;

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
                    this.f62627a = this;
                }

                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                public void onChangeFailed(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) {
                        this.f62627a.f62614c = false;
                        this.f62627a.dismiss();
                    }
                }

                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                public void onChangeSucceed(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                        this.f62627a.f62614c = true;
                        GlobalUtils.toast(this.f62627a.f62613b, ResUtils.getString(this.f62627a.f62613b, "wallet_base_bind_success"));
                        this.f62627a.dismiss();
                    }
                }
            }, PayRequestCache.BindCategory.Initiative, 1, null, str, null, null, true, BeanConstants.FROM_BIND);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(65538, this, i2) != null) {
            return;
        }
        int i3 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.f62612a.getChildCount() - 1) {
                return;
            }
            View childAt = this.f62612a.getChildAt(i3);
            ImageButton imageButton = (ImageButton) childAt.findViewById(ResUtils.id(this.f62613b, "bank_card_check_btn"));
            if (i3 != i2) {
                z = false;
            }
            imageButton.setSelected(z);
            childAt.setOnClickListener(new View.OnClickListener(this, i3) { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f62628a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BankCardDialog f62629b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i3)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62629b = this;
                    this.f62628a = i3;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!"1".equals(((CardDisplayInfo) this.f62629b.f62615d.get(this.f62628a)).f62632c)) {
                            if (TextUtils.isEmpty(((CardDisplayInfo) this.f62629b.f62615d.get(this.f62628a)).f62633d)) {
                                return;
                            }
                            GlobalUtils.toast(this.f62629b.f62613b, ((CardDisplayInfo) this.f62629b.f62615d.get(this.f62628a)).f62633d);
                            return;
                        }
                        this.f62629b.f62614c = false;
                        this.f62629b.a(this.f62628a);
                        this.f62629b.dismiss();
                    }
                }
            });
            i3++;
        }
    }
}
