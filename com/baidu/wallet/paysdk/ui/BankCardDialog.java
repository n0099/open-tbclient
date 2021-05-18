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
    public LinearLayout f25589a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25590b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25591c;

    /* renamed from: d  reason: collision with root package name */
    public List<CardDisplayInfo> f25592d;

    /* renamed from: e  reason: collision with root package name */
    public IListItemClickCallback f25593e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25594f;

    /* loaded from: classes5.dex */
    public static class CardDisplayInfo {

        /* renamed from: a  reason: collision with root package name */
        public String f25607a;

        /* renamed from: b  reason: collision with root package name */
        public String f25608b;

        /* renamed from: c  reason: collision with root package name */
        public String f25609c;

        /* renamed from: d  reason: collision with root package name */
        public String f25610d;

        /* renamed from: e  reason: collision with root package name */
        public String f25611e;

        public CardDisplayInfo(String str, String str2, String str3, String str4) {
            this.f25609c = "1";
            this.f25610d = "";
            this.f25611e = "";
            this.f25607a = str;
            this.f25608b = str2;
            this.f25609c = str3;
            this.f25610d = str4;
            this.f25611e = "";
        }
    }

    /* loaded from: classes5.dex */
    public interface IListItemClickCallback {
        void onChangeSucceed();
    }

    public BankCardDialog(Context context) {
        super(context);
        this.f25591c = false;
        this.f25594f = false;
        this.f25590b = context;
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (BankCardDialog.this.f25594f) {
                    PasswordController.getPassWordInstance().clearCheckPwdListener();
                }
            }
        });
    }

    public int getChooseIndex() {
        if (this.f25591c) {
            return -2;
        }
        for (int i2 = 0; i2 < this.f25589a.getChildCount(); i2++) {
            ImageButton imageButton = (ImageButton) this.f25589a.getChildAt(i2).findViewById(ResUtils.id(this.f25590b, "bank_card_check_btn"));
            if (imageButton != null && imageButton.isSelected()) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.wallet.base.widget.BaseTipDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(this.f25590b);
        }
        setTitleMessage(ResUtils.getString(this.f25590b, "bank_card_dialog_title"));
        findViewById(ResUtils.id(this.f25590b, "dialog_btns")).setVisibility(8);
        View inflate = this.mInflater.inflate(ResUtils.layout(this.f25590b, "wallet_base_bank_card_dialog_content_layout"), (ViewGroup) null);
        this.f25589a = (LinearLayout) inflate.findViewById(ResUtils.id(this.f25590b, "content_layout"));
        addContentView(inflate);
    }

    public void setBankList(List<CardDisplayInfo> list, int i2, boolean z, int i3, String str) {
        this.f25592d = list;
        a(i2, z, i3, str);
    }

    public void setOnIListItemClickCallback(IListItemClickCallback iListItemClickCallback) {
        this.f25593e = iListItemClickCallback;
    }

    private void a(int i2, final boolean z, final int i3, final String str) {
        List<CardDisplayInfo> list = this.f25592d;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f25589a.removeAllViews();
        int i4 = 0;
        while (true) {
            if (i4 >= this.f25592d.size()) {
                break;
            }
            final CardDisplayInfo cardDisplayInfo = this.f25592d.get(i4);
            View inflate = this.mInflater.inflate(ResUtils.layout(this.f25590b, "wallet_base_bank_card_dialog_item"), (ViewGroup) null);
            this.f25589a.addView(inflate);
            TextView textView = (TextView) inflate.findViewById(ResUtils.id(this.f25590b, "card_tip_tv"));
            ((NetImageView) inflate.findViewById(ResUtils.id(this.f25590b, "wallet_personal_my_bank_card_icon"))).setImageUrl(cardDisplayInfo.f25607a);
            ((TextView) inflate.findViewById(ResUtils.id(this.f25590b, "card_name_tv"))).setText(cardDisplayInfo.f25608b);
            if (!"1".equals(cardDisplayInfo.f25609c) && !TextUtils.isEmpty(cardDisplayInfo.f25610d)) {
                textView.setText(cardDisplayInfo.f25610d);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            if (!"1".equals(cardDisplayInfo.f25609c)) {
                r3 = 0.4f;
            }
            ViewHelper.setAlpha(inflate, r3);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!"1".equals(cardDisplayInfo.f25609c) && !TextUtils.isEmpty(cardDisplayInfo.f25610d)) {
                        GlobalUtils.toast(BankCardDialog.this.f25590b, cardDisplayInfo.f25610d);
                    }
                    if (BankCardDialog.this.f25593e != null) {
                        BankCardDialog.this.f25593e.onChangeSucceed();
                        BankCardDialog.this.f25593e = null;
                    }
                }
            });
            i4++;
        }
        View inflate2 = this.mInflater.inflate(ResUtils.layout(this.f25590b, "wallet_balance_bank_card_dialog_add_card_item"), (ViewGroup) null);
        this.f25589a.addView(inflate2);
        ViewHelper.setAlpha(inflate2, z ? 1.0f : 0.4f);
        inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (z) {
                    int i5 = i3;
                    if (i5 == 1) {
                        BaiduPay.getInstance().bindCardAuth(BankCardDialog.this.f25590b, false);
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BankCardDialog.this.dismiss();
                            }
                        }, 300L);
                        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_AuthorizePay_AddCard);
                    } else if (i5 != 2) {
                        BaiduPay.getInstance().bindCard(BankCardDialog.this.f25590b, new BaiduPay.IBindCardCallback() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3.2
                            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                            public void onChangeFailed(String str2) {
                                BankCardDialog.this.f25591c = false;
                                BankCardDialog.this.dismiss();
                            }

                            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                            public void onChangeSucceed(String str2) {
                                BankCardDialog.this.f25591c = true;
                                GlobalUtils.toast(BankCardDialog.this.f25590b, ResUtils.getString(BankCardDialog.this.f25590b, "wallet_base_bind_success"));
                                BankCardDialog.this.dismiss();
                            }
                        }, PayRequestCache.BindCategory.Initiative, 1, "", null, null, null, false, null);
                    } else {
                        BankCardDialog.this.a(str);
                        if (BankCardDialog.this.f25593e != null) {
                            BankCardDialog.this.f25593e.onChangeSucceed();
                            BankCardDialog.this.f25593e = null;
                        }
                    }
                } else if (i3 != 1) {
                    GlobalUtils.toast(BankCardDialog.this.f25590b, ResUtils.getString(BankCardDialog.this.f25590b, "ebpay_bank_count_beyond"));
                } else {
                    GlobalUtils.toast(BankCardDialog.this.f25590b, ResUtils.getString(BankCardDialog.this.f25590b, "ebpay_bankcard_overflow_tips2"));
                }
            }
        });
        ((TextView) findViewById(ResUtils.id(this.f25590b, "wallet_balance_bankcard_select"))).setText(ResUtils.getString(this.f25590b, "ebpay_use_new_card") + "                       ");
        a(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        BaiduPay.getInstance().bindCard(this.f25590b, new BaiduPay.IBindCardCallback() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.4
            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
            public void onChangeFailed(String str2) {
                BankCardDialog.this.f25591c = false;
                BankCardDialog.this.dismiss();
            }

            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
            public void onChangeSucceed(String str2) {
                BankCardDialog.this.f25591c = true;
                GlobalUtils.toast(BankCardDialog.this.f25590b, ResUtils.getString(BankCardDialog.this.f25590b, "wallet_base_bind_success"));
                BankCardDialog.this.dismiss();
            }
        }, PayRequestCache.BindCategory.Initiative, 1, null, str, null, null, true, BeanConstants.FROM_BIND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        final int i3 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.f25589a.getChildCount() - 1) {
                return;
            }
            View childAt = this.f25589a.getChildAt(i3);
            ImageButton imageButton = (ImageButton) childAt.findViewById(ResUtils.id(this.f25590b, "bank_card_check_btn"));
            if (i3 != i2) {
                z = false;
            }
            imageButton.setSelected(z);
            childAt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!"1".equals(((CardDisplayInfo) BankCardDialog.this.f25592d.get(i3)).f25609c)) {
                        if (TextUtils.isEmpty(((CardDisplayInfo) BankCardDialog.this.f25592d.get(i3)).f25610d)) {
                            return;
                        }
                        GlobalUtils.toast(BankCardDialog.this.f25590b, ((CardDisplayInfo) BankCardDialog.this.f25592d.get(i3)).f25610d);
                        return;
                    }
                    BankCardDialog.this.f25591c = false;
                    BankCardDialog.this.a(i3);
                    BankCardDialog.this.dismiss();
                }
            });
            i3++;
        }
    }
}
