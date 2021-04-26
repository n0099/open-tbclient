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
    public LinearLayout f26344a;

    /* renamed from: b  reason: collision with root package name */
    public Context f26345b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26346c;

    /* renamed from: d  reason: collision with root package name */
    public List<CardDisplayInfo> f26347d;

    /* renamed from: e  reason: collision with root package name */
    public IListItemClickCallback f26348e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26349f;

    /* loaded from: classes5.dex */
    public static class CardDisplayInfo {

        /* renamed from: a  reason: collision with root package name */
        public String f26362a;

        /* renamed from: b  reason: collision with root package name */
        public String f26363b;

        /* renamed from: c  reason: collision with root package name */
        public String f26364c;

        /* renamed from: d  reason: collision with root package name */
        public String f26365d;

        /* renamed from: e  reason: collision with root package name */
        public String f26366e;

        public CardDisplayInfo(String str, String str2, String str3, String str4) {
            this.f26364c = "1";
            this.f26365d = "";
            this.f26366e = "";
            this.f26362a = str;
            this.f26363b = str2;
            this.f26364c = str3;
            this.f26365d = str4;
            this.f26366e = "";
        }
    }

    /* loaded from: classes5.dex */
    public interface IListItemClickCallback {
        void onChangeSucceed();
    }

    public BankCardDialog(Context context) {
        super(context);
        this.f26346c = false;
        this.f26349f = false;
        this.f26345b = context;
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (BankCardDialog.this.f26349f) {
                    PasswordController.getPassWordInstance().clearCheckPwdListener();
                }
            }
        });
    }

    public int getChooseIndex() {
        if (this.f26346c) {
            return -2;
        }
        for (int i2 = 0; i2 < this.f26344a.getChildCount(); i2++) {
            ImageButton imageButton = (ImageButton) this.f26344a.getChildAt(i2).findViewById(ResUtils.id(this.f26345b, "bank_card_check_btn"));
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
            this.mInflater = LayoutInflater.from(this.f26345b);
        }
        setTitleMessage(ResUtils.getString(this.f26345b, "bank_card_dialog_title"));
        findViewById(ResUtils.id(this.f26345b, "dialog_btns")).setVisibility(8);
        View inflate = this.mInflater.inflate(ResUtils.layout(this.f26345b, "wallet_base_bank_card_dialog_content_layout"), (ViewGroup) null);
        this.f26344a = (LinearLayout) inflate.findViewById(ResUtils.id(this.f26345b, "content_layout"));
        addContentView(inflate);
    }

    public void setBankList(List<CardDisplayInfo> list, int i2, boolean z, int i3, String str) {
        this.f26347d = list;
        a(i2, z, i3, str);
    }

    public void setOnIListItemClickCallback(IListItemClickCallback iListItemClickCallback) {
        this.f26348e = iListItemClickCallback;
    }

    private void a(int i2, final boolean z, final int i3, final String str) {
        List<CardDisplayInfo> list = this.f26347d;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f26344a.removeAllViews();
        int i4 = 0;
        while (true) {
            if (i4 >= this.f26347d.size()) {
                break;
            }
            final CardDisplayInfo cardDisplayInfo = this.f26347d.get(i4);
            View inflate = this.mInflater.inflate(ResUtils.layout(this.f26345b, "wallet_base_bank_card_dialog_item"), (ViewGroup) null);
            this.f26344a.addView(inflate);
            TextView textView = (TextView) inflate.findViewById(ResUtils.id(this.f26345b, "card_tip_tv"));
            ((NetImageView) inflate.findViewById(ResUtils.id(this.f26345b, "wallet_personal_my_bank_card_icon"))).setImageUrl(cardDisplayInfo.f26362a);
            ((TextView) inflate.findViewById(ResUtils.id(this.f26345b, "card_name_tv"))).setText(cardDisplayInfo.f26363b);
            if (!"1".equals(cardDisplayInfo.f26364c) && !TextUtils.isEmpty(cardDisplayInfo.f26365d)) {
                textView.setText(cardDisplayInfo.f26365d);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            if (!"1".equals(cardDisplayInfo.f26364c)) {
                r3 = 0.4f;
            }
            ViewHelper.setAlpha(inflate, r3);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!"1".equals(cardDisplayInfo.f26364c) && !TextUtils.isEmpty(cardDisplayInfo.f26365d)) {
                        GlobalUtils.toast(BankCardDialog.this.f26345b, cardDisplayInfo.f26365d);
                    }
                    if (BankCardDialog.this.f26348e != null) {
                        BankCardDialog.this.f26348e.onChangeSucceed();
                        BankCardDialog.this.f26348e = null;
                    }
                }
            });
            i4++;
        }
        View inflate2 = this.mInflater.inflate(ResUtils.layout(this.f26345b, "wallet_balance_bank_card_dialog_add_card_item"), (ViewGroup) null);
        this.f26344a.addView(inflate2);
        ViewHelper.setAlpha(inflate2, z ? 1.0f : 0.4f);
        inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (z) {
                    int i5 = i3;
                    if (i5 == 1) {
                        BaiduPay.getInstance().bindCardAuth(BankCardDialog.this.f26345b, false);
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BankCardDialog.this.dismiss();
                            }
                        }, 300L);
                        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_AuthorizePay_AddCard);
                    } else if (i5 != 2) {
                        BaiduPay.getInstance().bindCard(BankCardDialog.this.f26345b, new BaiduPay.IBindCardCallback() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3.2
                            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                            public void onChangeFailed(String str2) {
                                BankCardDialog.this.f26346c = false;
                                BankCardDialog.this.dismiss();
                            }

                            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                            public void onChangeSucceed(String str2) {
                                BankCardDialog.this.f26346c = true;
                                GlobalUtils.toast(BankCardDialog.this.f26345b, ResUtils.getString(BankCardDialog.this.f26345b, "wallet_base_bind_success"));
                                BankCardDialog.this.dismiss();
                            }
                        }, PayRequestCache.BindCategory.Initiative, 1, "", null, null, null, false, null);
                    } else {
                        BankCardDialog.this.a(str);
                        if (BankCardDialog.this.f26348e != null) {
                            BankCardDialog.this.f26348e.onChangeSucceed();
                            BankCardDialog.this.f26348e = null;
                        }
                    }
                } else if (i3 != 1) {
                    GlobalUtils.toast(BankCardDialog.this.f26345b, ResUtils.getString(BankCardDialog.this.f26345b, "ebpay_bank_count_beyond"));
                } else {
                    GlobalUtils.toast(BankCardDialog.this.f26345b, ResUtils.getString(BankCardDialog.this.f26345b, "ebpay_bankcard_overflow_tips2"));
                }
            }
        });
        ((TextView) findViewById(ResUtils.id(this.f26345b, "wallet_balance_bankcard_select"))).setText(ResUtils.getString(this.f26345b, "ebpay_use_new_card") + "                       ");
        a(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        BaiduPay.getInstance().bindCard(this.f26345b, new BaiduPay.IBindCardCallback() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.4
            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
            public void onChangeFailed(String str2) {
                BankCardDialog.this.f26346c = false;
                BankCardDialog.this.dismiss();
            }

            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
            public void onChangeSucceed(String str2) {
                BankCardDialog.this.f26346c = true;
                GlobalUtils.toast(BankCardDialog.this.f26345b, ResUtils.getString(BankCardDialog.this.f26345b, "wallet_base_bind_success"));
                BankCardDialog.this.dismiss();
            }
        }, PayRequestCache.BindCategory.Initiative, 1, null, str, null, null, true, BeanConstants.FROM_BIND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        final int i3 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.f26344a.getChildCount() - 1) {
                return;
            }
            View childAt = this.f26344a.getChildAt(i3);
            ImageButton imageButton = (ImageButton) childAt.findViewById(ResUtils.id(this.f26345b, "bank_card_check_btn"));
            if (i3 != i2) {
                z = false;
            }
            imageButton.setSelected(z);
            childAt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!"1".equals(((CardDisplayInfo) BankCardDialog.this.f26347d.get(i3)).f26364c)) {
                        if (TextUtils.isEmpty(((CardDisplayInfo) BankCardDialog.this.f26347d.get(i3)).f26365d)) {
                            return;
                        }
                        GlobalUtils.toast(BankCardDialog.this.f26345b, ((CardDisplayInfo) BankCardDialog.this.f26347d.get(i3)).f26365d);
                        return;
                    }
                    BankCardDialog.this.f26346c = false;
                    BankCardDialog.this.a(i3);
                    BankCardDialog.this.dismiss();
                }
            });
            i3++;
        }
    }
}
