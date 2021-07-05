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
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.BaseTipDialog;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.List;
/* loaded from: classes6.dex */
public class BankCardDialog extends BaseTipDialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SIGN_PAY = 1;
    public static final int WITHDRAW_ADD_CARD = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f26246a;

    /* renamed from: b  reason: collision with root package name */
    public Context f26247b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26248c;

    /* renamed from: d  reason: collision with root package name */
    public List<CardDisplayInfo> f26249d;

    /* renamed from: e  reason: collision with root package name */
    public IListItemClickCallback f26250e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26251f;

    /* loaded from: classes6.dex */
    public static class CardDisplayInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f26264a;

        /* renamed from: b  reason: collision with root package name */
        public String f26265b;

        /* renamed from: c  reason: collision with root package name */
        public String f26266c;

        /* renamed from: d  reason: collision with root package name */
        public String f26267d;

        /* renamed from: e  reason: collision with root package name */
        public String f26268e;

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
            this.f26266c = "1";
            this.f26267d = "";
            this.f26268e = "";
            this.f26264a = str;
            this.f26265b = str2;
            this.f26266c = str3;
            this.f26267d = str4;
            this.f26268e = "";
        }
    }

    /* loaded from: classes6.dex */
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
        this.f26248c = false;
        this.f26251f = false;
        this.f26247b = context;
        setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BankCardDialog f26252a;

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
                this.f26252a = this;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) && this.f26252a.f26251f) {
                    PasswordController.getPassWordInstance().clearCheckPwdListener();
                }
            }
        });
    }

    public int getChooseIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f26248c) {
                return -2;
            }
            for (int i2 = 0; i2 < this.f26246a.getChildCount(); i2++) {
                ImageButton imageButton = (ImageButton) this.f26246a.getChildAt(i2).findViewById(ResUtils.id(this.f26247b, "bank_card_check_btn"));
                if (imageButton != null && imageButton.isSelected()) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.wallet.base.widget.BaseTipDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from(this.f26247b);
            }
            setTitleMessage(ResUtils.getString(this.f26247b, "bank_card_dialog_title"));
            findViewById(ResUtils.id(this.f26247b, "dialog_btns")).setVisibility(8);
            View inflate = this.mInflater.inflate(ResUtils.layout(this.f26247b, "wallet_base_bank_card_dialog_content_layout"), (ViewGroup) null);
            this.f26246a = (LinearLayout) inflate.findViewById(ResUtils.id(this.f26247b, "content_layout"));
            addContentView(inflate);
        }
    }

    public void setBankList(List<CardDisplayInfo> list, int i2, boolean z, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str}) == null) {
            this.f26249d = list;
            a(i2, z, i3, str);
        }
    }

    public void setOnIListItemClickCallback(IListItemClickCallback iListItemClickCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iListItemClickCallback) == null) {
            this.f26250e = iListItemClickCallback;
        }
    }

    private void a(int i2, boolean z, int i3, String str) {
        List<CardDisplayInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str}) == null) || (list = this.f26249d) == null || list.size() == 0) {
            return;
        }
        this.f26246a.removeAllViews();
        int i4 = 0;
        while (true) {
            if (i4 >= this.f26249d.size()) {
                break;
            }
            CardDisplayInfo cardDisplayInfo = this.f26249d.get(i4);
            View inflate = this.mInflater.inflate(ResUtils.layout(this.f26247b, "wallet_base_bank_card_dialog_item"), (ViewGroup) null);
            this.f26246a.addView(inflate);
            TextView textView = (TextView) inflate.findViewById(ResUtils.id(this.f26247b, "card_tip_tv"));
            ((NetImageView) inflate.findViewById(ResUtils.id(this.f26247b, "wallet_personal_my_bank_card_icon"))).setImageUrl(cardDisplayInfo.f26264a);
            ((TextView) inflate.findViewById(ResUtils.id(this.f26247b, "card_name_tv"))).setText(cardDisplayInfo.f26265b);
            if (!"1".equals(cardDisplayInfo.f26266c) && !TextUtils.isEmpty(cardDisplayInfo.f26267d)) {
                textView.setText(cardDisplayInfo.f26267d);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            if (!"1".equals(cardDisplayInfo.f26266c)) {
                r3 = 0.4f;
            }
            ViewHelper.setAlpha(inflate, r3);
            inflate.setOnClickListener(new View.OnClickListener(this, cardDisplayInfo) { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CardDisplayInfo f26253a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BankCardDialog f26254b;

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
                    this.f26254b = this;
                    this.f26253a = cardDisplayInfo;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!"1".equals(this.f26253a.f26266c) && !TextUtils.isEmpty(this.f26253a.f26267d)) {
                            GlobalUtils.toast(this.f26254b.f26247b, this.f26253a.f26267d);
                        }
                        if (this.f26254b.f26250e != null) {
                            this.f26254b.f26250e.onChangeSucceed();
                            this.f26254b.f26250e = null;
                        }
                    }
                }
            });
            i4++;
        }
        View inflate2 = this.mInflater.inflate(ResUtils.layout(this.f26247b, "wallet_balance_bank_card_dialog_add_card_item"), (ViewGroup) null);
        this.f26246a.addView(inflate2);
        ViewHelper.setAlpha(inflate2, z ? 1.0f : 0.4f);
        inflate2.setOnClickListener(new View.OnClickListener(this, z, i3, str) { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean f26255a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f26256b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f26257c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ BankCardDialog f26258d;

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
                this.f26258d = this;
                this.f26255a = z;
                this.f26256b = i3;
                this.f26257c = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    if (this.f26255a) {
                        int i5 = this.f26256b;
                        if (i5 == 1) {
                            BaiduPay.getInstance().bindCardAuth(this.f26258d.f26247b, false);
                            new Handler().postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f26259a;

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
                                    this.f26259a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f26259a.f26258d.dismiss();
                                    }
                                }
                            }, 300L);
                            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_AuthorizePay_AddCard);
                        } else if (i5 != 2) {
                            BaiduPay.getInstance().bindCard(this.f26258d.f26247b, new BaiduPay.IBindCardCallback(this) { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f26260a;

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
                                    this.f26260a = this;
                                }

                                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                                public void onChangeFailed(String str2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, str2) == null) {
                                        this.f26260a.f26258d.f26248c = false;
                                        this.f26260a.f26258d.dismiss();
                                    }
                                }

                                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                                public void onChangeSucceed(String str2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                                        this.f26260a.f26258d.f26248c = true;
                                        GlobalUtils.toast(this.f26260a.f26258d.f26247b, ResUtils.getString(this.f26260a.f26258d.f26247b, "wallet_base_bind_success"));
                                        this.f26260a.f26258d.dismiss();
                                    }
                                }
                            }, PayRequestCache.BindCategory.Initiative, 1, "", null, null, null, false, null);
                        } else {
                            this.f26258d.a(this.f26257c);
                            if (this.f26258d.f26250e != null) {
                                this.f26258d.f26250e.onChangeSucceed();
                                this.f26258d.f26250e = null;
                            }
                        }
                    } else if (this.f26256b != 1) {
                        GlobalUtils.toast(this.f26258d.f26247b, ResUtils.getString(this.f26258d.f26247b, "ebpay_bank_count_beyond"));
                    } else {
                        GlobalUtils.toast(this.f26258d.f26247b, ResUtils.getString(this.f26258d.f26247b, "ebpay_bankcard_overflow_tips2"));
                    }
                }
            }
        });
        ((TextView) findViewById(ResUtils.id(this.f26247b, "wallet_balance_bankcard_select"))).setText(ResUtils.getString(this.f26247b, "ebpay_use_new_card") + "                       ");
        a(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) {
            BaiduPay.getInstance().bindCard(this.f26247b, new BaiduPay.IBindCardCallback(this) { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BankCardDialog f26261a;

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
                    this.f26261a = this;
                }

                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                public void onChangeFailed(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) {
                        this.f26261a.f26248c = false;
                        this.f26261a.dismiss();
                    }
                }

                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                public void onChangeSucceed(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                        this.f26261a.f26248c = true;
                        GlobalUtils.toast(this.f26261a.f26247b, ResUtils.getString(this.f26261a.f26247b, "wallet_base_bind_success"));
                        this.f26261a.dismiss();
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
            if (i3 >= this.f26246a.getChildCount() - 1) {
                return;
            }
            View childAt = this.f26246a.getChildAt(i3);
            ImageButton imageButton = (ImageButton) childAt.findViewById(ResUtils.id(this.f26247b, "bank_card_check_btn"));
            if (i3 != i2) {
                z = false;
            }
            imageButton.setSelected(z);
            childAt.setOnClickListener(new View.OnClickListener(this, i3) { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f26262a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BankCardDialog f26263b;

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
                    this.f26263b = this;
                    this.f26262a = i3;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!"1".equals(((CardDisplayInfo) this.f26263b.f26249d.get(this.f26262a)).f26266c)) {
                            if (TextUtils.isEmpty(((CardDisplayInfo) this.f26263b.f26249d.get(this.f26262a)).f26267d)) {
                                return;
                            }
                            GlobalUtils.toast(this.f26263b.f26247b, ((CardDisplayInfo) this.f26263b.f26249d.get(this.f26262a)).f26267d);
                            return;
                        }
                        this.f26263b.f26248c = false;
                        this.f26263b.a(this.f26262a);
                        this.f26263b.dismiss();
                    }
                }
            });
            i3++;
        }
    }
}
