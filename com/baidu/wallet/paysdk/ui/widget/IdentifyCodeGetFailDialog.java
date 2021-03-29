package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.utils.BdWalletUtils;
/* loaded from: classes5.dex */
public class IdentifyCodeGetFailDialog extends PromptDialog {

    /* renamed from: a  reason: collision with root package name */
    public VerifyCodeType f26392a;

    /* loaded from: classes5.dex */
    public enum VerifyCodeType {
        SMS,
        VOICE
    }

    public IdentifyCodeGetFailDialog(Context context) {
        this(context, VerifyCodeType.SMS);
    }

    private String b() {
        return this.f26392a == VerifyCodeType.VOICE ? "ebpay_get_voice_code_error_title" : "ebpay_get_sms_error_dialog_title";
    }

    private SpannableStringBuilder c() {
        String string = ResUtils.getString(this.mContext, "ebpay_operation_tip1");
        String string2 = ResUtils.getString(this.mContext, "ebpay_operation_tip2");
        String string3 = ResUtils.getString(this.mContext, "ebpay_operation_tip3");
        String string4 = ResUtils.getString(this.mContext, "ebpay_operation_tip4");
        String string5 = ResUtils.getString(this.mContext, "ebpay_operation_tip5");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.append((CharSequence) string2);
        spannableStringBuilder.append((CharSequence) string3);
        spannableStringBuilder.append((CharSequence) string4);
        spannableStringBuilder.append((CharSequence) string5);
        spannableStringBuilder.append((CharSequence) BdWalletUtils.getKefuPhoneNum(this.mContext));
        return spannableStringBuilder;
    }

    private SpannableStringBuilder d() {
        String string = ResUtils.getString(this.mContext, "ebpay_operation_tip1");
        String string2 = ResUtils.getString(this.mContext, "ebpay_operation_voice_verify_tip2");
        String string3 = ResUtils.getString(this.mContext, "ebpay_operation_voice_verify_tip3");
        String string4 = ResUtils.getString(this.mContext, "ebpay_operation_voice_verify_tip4");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.append((CharSequence) string2);
        spannableStringBuilder.append((CharSequence) string3);
        spannableStringBuilder.append((CharSequence) string4);
        spannableStringBuilder.append((CharSequence) BdWalletUtils.getKefuPhoneNum(this.mContext));
        return spannableStringBuilder;
    }

    @Override // com.baidu.wallet.base.widget.dialog.WalletDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleText(ResUtils.getString(this.mContext, b()));
        showCloseBtn(false);
        setMessage(a());
        setNegativeBtn(ResUtils.getString(this.mContext, "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.widget.IdentifyCodeGetFailDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IdentifyCodeGetFailDialog.this.dismiss();
            }
        });
        final String kefuPhoneNum = BdWalletUtils.getKefuPhoneNum(this.mContext);
        setPositiveBtn(ResUtils.getString(this.mContext, "ebpay_contact_kefu"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.widget.IdentifyCodeGetFailDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    IdentifyCodeGetFailDialog.this.mContext.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + kefuPhoneNum)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public IdentifyCodeGetFailDialog(Context context, VerifyCodeType verifyCodeType) {
        super(context);
        this.f26392a = verifyCodeType;
    }

    private SpannableStringBuilder a() {
        return this.f26392a == VerifyCodeType.VOICE ? d() : c();
    }
}
