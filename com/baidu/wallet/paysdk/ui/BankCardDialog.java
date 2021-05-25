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
    public LinearLayout f25518a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25519b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25520c;

    /* renamed from: d  reason: collision with root package name */
    public List<CardDisplayInfo> f25521d;

    /* renamed from: e  reason: collision with root package name */
    public IListItemClickCallback f25522e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25523f;

    /* loaded from: classes5.dex */
    public static class CardDisplayInfo {

        /* renamed from: a  reason: collision with root package name */
        public String f25536a;

        /* renamed from: b  reason: collision with root package name */
        public String f25537b;

        /* renamed from: c  reason: collision with root package name */
        public String f25538c;

        /* renamed from: d  reason: collision with root package name */
        public String f25539d;

        /* renamed from: e  reason: collision with root package name */
        public String f25540e;

        public CardDisplayInfo(String str, String str2, String str3, String str4) {
            this.f25538c = "1";
            this.f25539d = "";
            this.f25540e = "";
            this.f25536a = str;
            this.f25537b = str2;
            this.f25538c = str3;
            this.f25539d = str4;
            this.f25540e = "";
        }
    }

    /* loaded from: classes5.dex */
    public interface IListItemClickCallback {
        void onChangeSucceed();
    }

    public BankCardDialog(Context context) {
        super(context);
        this.f25520c = false;
        this.f25523f = false;
        this.f25519b = context;
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (BankCardDialog.this.f25523f) {
                    PasswordController.getPassWordInstance().clearCheckPwdListener();
                }
            }
        });
    }

    public int getChooseIndex() {
        if (this.f25520c) {
            return -2;
        }
        for (int i2 = 0; i2 < this.f25518a.getChildCount(); i2++) {
            ImageButton imageButton = (ImageButton) this.f25518a.getChildAt(i2).findViewById(ResUtils.id(this.f25519b, "bank_card_check_btn"));
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
            this.mInflater = LayoutInflater.from(this.f25519b);
        }
        setTitleMessage(ResUtils.getString(this.f25519b, "bank_card_dialog_title"));
        findViewById(ResUtils.id(this.f25519b, "dialog_btns")).setVisibility(8);
        View inflate = this.mInflater.inflate(ResUtils.layout(this.f25519b, "wallet_base_bank_card_dialog_content_layout"), (ViewGroup) null);
        this.f25518a = (LinearLayout) inflate.findViewById(ResUtils.id(this.f25519b, "content_layout"));
        addContentView(inflate);
    }

    public void setBankList(List<CardDisplayInfo> list, int i2, boolean z, int i3, String str) {
        this.f25521d = list;
        a(i2, z, i3, str);
    }

    public void setOnIListItemClickCallback(IListItemClickCallback iListItemClickCallback) {
        this.f25522e = iListItemClickCallback;
    }

    private void a(int i2, final boolean z, final int i3, final String str) {
        List<CardDisplayInfo> list = this.f25521d;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f25518a.removeAllViews();
        int i4 = 0;
        while (true) {
            if (i4 >= this.f25521d.size()) {
                break;
            }
            final CardDisplayInfo cardDisplayInfo = this.f25521d.get(i4);
            View inflate = this.mInflater.inflate(ResUtils.layout(this.f25519b, "wallet_base_bank_card_dialog_item"), (ViewGroup) null);
            this.f25518a.addView(inflate);
            TextView textView = (TextView) inflate.findViewById(ResUtils.id(this.f25519b, "card_tip_tv"));
            ((NetImageView) inflate.findViewById(ResUtils.id(this.f25519b, "wallet_personal_my_bank_card_icon"))).setImageUrl(cardDisplayInfo.f25536a);
            ((TextView) inflate.findViewById(ResUtils.id(this.f25519b, "card_name_tv"))).setText(cardDisplayInfo.f25537b);
            if (!"1".equals(cardDisplayInfo.f25538c) && !TextUtils.isEmpty(cardDisplayInfo.f25539d)) {
                textView.setText(cardDisplayInfo.f25539d);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            if (!"1".equals(cardDisplayInfo.f25538c)) {
                r3 = 0.4f;
            }
            ViewHelper.setAlpha(inflate, r3);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!"1".equals(cardDisplayInfo.f25538c) && !TextUtils.isEmpty(cardDisplayInfo.f25539d)) {
                        GlobalUtils.toast(BankCardDialog.this.f25519b, cardDisplayInfo.f25539d);
                    }
                    if (BankCardDialog.this.f25522e != null) {
                        BankCardDialog.this.f25522e.onChangeSucceed();
                        BankCardDialog.this.f25522e = null;
                    }
                }
            });
            i4++;
        }
        View inflate2 = this.mInflater.inflate(ResUtils.layout(this.f25519b, "wallet_balance_bank_card_dialog_add_card_item"), (ViewGroup) null);
        this.f25518a.addView(inflate2);
        ViewHelper.setAlpha(inflate2, z ? 1.0f : 0.4f);
        inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (z) {
                    int i5 = i3;
                    if (i5 == 1) {
                        BaiduPay.getInstance().bindCardAuth(BankCardDialog.this.f25519b, false);
                        new Handler().postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BankCardDialog.this.dismiss();
                            }
                        }, 300L);
                        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_AuthorizePay_AddCard);
                    } else if (i5 != 2) {
                        BaiduPay.getInstance().bindCard(BankCardDialog.this.f25519b, new BaiduPay.IBindCardCallback() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.3.2
                            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                            public void onChangeFailed(String str2) {
                                BankCardDialog.this.f25520c = false;
                                BankCardDialog.this.dismiss();
                            }

                            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                            public void onChangeSucceed(String str2) {
                                BankCardDialog.this.f25520c = true;
                                GlobalUtils.toast(BankCardDialog.this.f25519b, ResUtils.getString(BankCardDialog.this.f25519b, "wallet_base_bind_success"));
                                BankCardDialog.this.dismiss();
                            }
                        }, PayRequestCache.BindCategory.Initiative, 1, "", null, null, null, false, null);
                    } else {
                        BankCardDialog.this.a(str);
                        if (BankCardDialog.this.f25522e != null) {
                            BankCardDialog.this.f25522e.onChangeSucceed();
                            BankCardDialog.this.f25522e = null;
                        }
                    }
                } else if (i3 != 1) {
                    GlobalUtils.toast(BankCardDialog.this.f25519b, ResUtils.getString(BankCardDialog.this.f25519b, "ebpay_bank_count_beyond"));
                } else {
                    GlobalUtils.toast(BankCardDialog.this.f25519b, ResUtils.getString(BankCardDialog.this.f25519b, "ebpay_bankcard_overflow_tips2"));
                }
            }
        });
        ((TextView) findViewById(ResUtils.id(this.f25519b, "wallet_balance_bankcard_select"))).setText(ResUtils.getString(this.f25519b, "ebpay_use_new_card") + "                       ");
        a(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        BaiduPay.getInstance().bindCard(this.f25519b, new BaiduPay.IBindCardCallback() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.4
            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
            public void onChangeFailed(String str2) {
                BankCardDialog.this.f25520c = false;
                BankCardDialog.this.dismiss();
            }

            @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
            public void onChangeSucceed(String str2) {
                BankCardDialog.this.f25520c = true;
                GlobalUtils.toast(BankCardDialog.this.f25519b, ResUtils.getString(BankCardDialog.this.f25519b, "wallet_base_bind_success"));
                BankCardDialog.this.dismiss();
            }
        }, PayRequestCache.BindCategory.Initiative, 1, null, str, null, null, true, BeanConstants.FROM_BIND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        final int i3 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.f25518a.getChildCount() - 1) {
                return;
            }
            View childAt = this.f25518a.getChildAt(i3);
            ImageButton imageButton = (ImageButton) childAt.findViewById(ResUtils.id(this.f25519b, "bank_card_check_btn"));
            if (i3 != i2) {
                z = false;
            }
            imageButton.setSelected(z);
            childAt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BankCardDialog.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!"1".equals(((CardDisplayInfo) BankCardDialog.this.f25521d.get(i3)).f25538c)) {
                        if (TextUtils.isEmpty(((CardDisplayInfo) BankCardDialog.this.f25521d.get(i3)).f25539d)) {
                            return;
                        }
                        GlobalUtils.toast(BankCardDialog.this.f25519b, ((CardDisplayInfo) BankCardDialog.this.f25521d.get(i3)).f25539d);
                        return;
                    }
                    BankCardDialog.this.f25520c = false;
                    BankCardDialog.this.a(i3);
                    BankCardDialog.this.dismiss();
                }
            });
            i3++;
        }
    }
}
