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
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.BaseTipDialog;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.util.List;
/* loaded from: classes5.dex */
public class BankCardDialog extends BaseTipDialog {
    public static final int SIGN_PAY = 1;
    public static final int WITHDRAW_ADD_CARD = 2;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f25872a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25873b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25874c;

    /* renamed from: d  reason: collision with root package name */
    public List<CardDisplayInfo> f25875d;

    /* renamed from: e  reason: collision with root package name */
    public IListItemClickCallback f25876e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25877f;

    /* loaded from: classes5.dex */
    public static class CardDisplayInfo {

        /* renamed from: a  reason: collision with root package name */
        public String f25890a;

        /* renamed from: b  reason: collision with root package name */
        public String f25891b;

        /* renamed from: c  reason: collision with root package name */
        public String f25892c;

        /* renamed from: d  reason: collision with root package name */
        public String f25893d;

        /* renamed from: e  reason: collision with root package name */
        public String f25894e;

        public CardDisplayInfo(String str, String str2, String str3, String str4) {
            this.f25892c = "1";
            this.f25893d = "";
            this.f25894e = "";
            this.f25890a = str;
            this.f25891b = str2;
            this.f25892c = str3;
            this.f25893d = str4;
            this.f25894e = "";
        }
    }

    /* loaded from: classes5.dex */
    public interface IListItemClickCallback {
        void onChangeSucceed();
    }

    public BankCardDialog(Context context) {
        super(context);
        this.f25874c = false;
        this.f25877f = false;
        this.f25873b = context;
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (BankCardDialog.this.f25877f) {
                    PasswordController.getPassWordInstance().clearCheckPwdListener();
                }
            }
        });
    }

    public int getChooseIndex() {
        if (this.f25874c) {
            return -2;
        }
        for (int i = 0; i < this.f25872a.getChildCount(); i++) {
            ImageButton imageButton = (ImageButton) this.f25872a.getChildAt(i).findViewById(ResUtils.id(this.f25873b, "bank_card_check_btn"));
            if (imageButton != null && imageButton.isSelected()) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.baidu.wallet.base.widget.BaseTipDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(this.f25873b);
        }
        setTitleMessage(ResUtils.getString(this.f25873b, "bank_card_dialog_title"));
        findViewById(ResUtils.id(this.f25873b, "dialog_btns")).setVisibility(8);
        View inflate = this.mInflater.inflate(ResUtils.layout(this.f25873b, "wallet_base_bank_card_dialog_content_layout"), (ViewGroup) null);
        this.f25872a = (LinearLayout) inflate.findViewById(ResUtils.id(this.f25873b, "content_layout"));
        addContentView(inflate);
    }

    public void setBankList(List<CardDisplayInfo> list, int i, boolean z, int i2, String str) {
        this.f25875d = list;
        a(i, z, i2, str);
    }

    public void setOnIListItemClickCallback(IListItemClickCallback iListItemClickCallback) {
        this.f25876e = iListItemClickCallback;
    }

    private void a(int i, final boolean z, final int i2, final String str) {
        List<CardDisplayInfo> list = this.f25875d;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f25872a.removeAllViews();
        int i3 = 0;
        while (true) {
            if (i3 >= this.f25875d.size()) {
                break;
            }
            final CardDisplayInfo cardDisplayInfo = this.f25875d.get(i3);
            View inflate = this.mInflater.inflate(ResUtils.layout(this.f25873b, "wallet_base_bank_card_dialog_item"), (ViewGroup) null);
            this.f25872a.addView(inflate);
            TextView textView = (TextView) inflate.findViewById(ResUtils.id(this.f25873b, "card_tip_tv"));
            ((NetImageView) inflate.findViewById(ResUtils.id(this.f25873b, "wallet_personal_my_bank_card_icon"))).setImageUrl(cardDisplayInfo.f25890a);
            ((TextView) inflate.findViewById(ResUtils.id(this.f25873b, "card_name_tv"))).setText(cardDisplayInfo.f25891b);
            if (!"1".equals(cardDisplayInfo.f25892c) && !TextUtils.isEmpty(cardDisplayInfo.f25893d)) {
                textView.setText(cardDisplayInfo.f25893d);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            if (!"1".equals(cardDisplayInfo.f25892c)) {
                r3 = 0.4f;
            }
            ViewHelper.setAlpha(inflate, r3);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!"1".equals(cardDisplayInfo.f25892c) && !TextUtils.isEmpty(cardDisplayInfo.f25893d)) {
                        GlobalUtils.toast(BankCardDialog.this.f25873b, cardDisplayInfo.f25893d);
                    }
                    if (BankCardDialog.this.f25876e != null) {
                        BankCardDialog.this.f25876e.onChangeSucceed();
                        BankCardDialog.this.f25876e = null;
                    }
                }
            });
            i3++;
        }
        View inflate2 = this.mInflater.inflate(ResUtils.layout(this.f25873b, "wallet_balance_bank_card_dialog_add_card_item"), (ViewGroup) null);
        this.f25872a.addView(inflate2);
        ViewHelper.setAlpha(inflate2, z ? 1.0f : 0.4f);
        inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (z) {
                    int i4 = i2;
                    if (i4 == 1) {
                        BaiduPay.getInstance().bindCardAuth(BankCardDialog.this.f25873b, false);
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BankCardDialog.this.dismiss();
                            }
                        }, 300L);
                        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_AuthorizePay_AddCard);
                    } else if (i4 != 2) {
                        BaiduPay.getInstance().bindCard(BankCardDialog.this.f25873b, new BaiduPay.IBindCardCallback() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3.2
                            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                            public void onChangeFailed(String str2) {
                                BankCardDialog.this.f25874c = false;
                                BankCardDialog.this.dismiss();
                            }

                            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                            public void onChangeSucceed(String str2) {
                                BankCardDialog.this.f25874c = true;
                                GlobalUtils.toast(BankCardDialog.this.f25873b, ResUtils.getString(BankCardDialog.this.f25873b, "wallet_base_bind_success"));
                                BankCardDialog.this.dismiss();
                            }
                        }, PayRequestCache.BindCategory.Initiative, 1, "", null, null, null, false, null);
                    } else {
                        BankCardDialog.this.a(str);
                        if (BankCardDialog.this.f25876e != null) {
                            BankCardDialog.this.f25876e.onChangeSucceed();
                            BankCardDialog.this.f25876e = null;
                        }
                    }
                } else if (i2 != 1) {
                    GlobalUtils.toast(BankCardDialog.this.f25873b, ResUtils.getString(BankCardDialog.this.f25873b, "ebpay_bank_count_beyond"));
                } else {
                    GlobalUtils.toast(BankCardDialog.this.f25873b, ResUtils.getString(BankCardDialog.this.f25873b, "ebpay_bankcard_overflow_tips2"));
                }
            }
        });
        ((TextView) findViewById(ResUtils.id(this.f25873b, "wallet_balance_bankcard_select"))).setText(ResUtils.getString(this.f25873b, "ebpay_use_new_card") + "                       ");
        a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        BaiduPay.getInstance().bindCard(this.f25873b, new BaiduPay.IBindCardCallback() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.4
            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
            public void onChangeFailed(String str2) {
                BankCardDialog.this.f25874c = false;
                BankCardDialog.this.dismiss();
            }

            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
            public void onChangeSucceed(String str2) {
                BankCardDialog.this.f25874c = true;
                GlobalUtils.toast(BankCardDialog.this.f25873b, ResUtils.getString(BankCardDialog.this.f25873b, "wallet_base_bind_success"));
                BankCardDialog.this.dismiss();
            }
        }, PayRequestCache.BindCategory.Initiative, 1, null, str, null, null, true, BeanConstants.FROM_BIND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        final int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.f25872a.getChildCount() - 1) {
                return;
            }
            View childAt = this.f25872a.getChildAt(i2);
            ImageButton imageButton = (ImageButton) childAt.findViewById(ResUtils.id(this.f25873b, "bank_card_check_btn"));
            if (i2 != i) {
                z = false;
            }
            imageButton.setSelected(z);
            childAt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!"1".equals(((CardDisplayInfo) BankCardDialog.this.f25875d.get(i2)).f25892c)) {
                        if (TextUtils.isEmpty(((CardDisplayInfo) BankCardDialog.this.f25875d.get(i2)).f25893d)) {
                            return;
                        }
                        GlobalUtils.toast(BankCardDialog.this.f25873b, ((CardDisplayInfo) BankCardDialog.this.f25875d.get(i2)).f25893d);
                        return;
                    }
                    BankCardDialog.this.f25874c = false;
                    BankCardDialog.this.a(i2);
                    BankCardDialog.this.dismiss();
                }
            });
            i2++;
        }
    }
}
