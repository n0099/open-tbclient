package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.base.widget.dialog.PromptTipDialog;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
/* loaded from: classes5.dex */
public class AuthorizeInfoView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f26178a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26179b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26180c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26181d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26182e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26183f;

    /* renamed from: g  reason: collision with root package name */
    public String f26184g;

    /* renamed from: h  reason: collision with root package name */
    public String f26185h;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0265a {

            /* renamed from: a  reason: collision with root package name */
            public static a f26187a = new a();
        }

        public static a a() {
            return C0265a.f26187a;
        }

        public a() {
        }

        public b a(int i2, AuthorizeInfoView authorizeInfoView) {
            if (i2 != 1) {
                return null;
            }
            return new com.baidu.wallet.paysdk.ui.widget.a.a(authorizeInfoView);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public AuthorizeInfoView f26188a;

        public b(AuthorizeInfoView authorizeInfoView) {
            this.f26188a = authorizeInfoView;
        }

        public abstract void a(Object obj);
    }

    public AuthorizeInfoView(Context context) {
        super(context);
        this.f26184g = "";
        this.f26185h = "";
        a();
    }

    public void refreshView() {
        Authorize authorize;
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (payResponse == null || (authorize = payResponse.authorize) == null) {
            return;
        }
        this.f26178a.setImageUrl(authorize.sp_logo_url);
        this.f26179b.setText(authorize.sp_company_title);
        setTips(authorize.authorize_action_desc);
        String[] strArr = authorize.authorize_desc;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            this.f26181d.setText(strArr[0]);
        }
        UserData.UserModel userModel = payResponse.user;
        if (userModel != null) {
            this.f26183f.setText(userModel.authorize_display_name);
        }
        Authorize.AuthDetailInfo authDetailInfo = authorize.detail_info;
        if (authDetailInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(authDetailInfo.introduce)) {
            this.f26185h += authorize.detail_info.introduce + "\n";
        }
        while (true) {
            String[] strArr2 = authorize.detail_info.detail;
            if (i2 >= strArr2.length) {
                return;
            }
            if (!TextUtils.isEmpty(strArr2[i2])) {
                this.f26185h += "\n· " + authorize.detail_info.detail[i2];
            }
            i2++;
        }
    }

    public void setAmount(String str) {
        TextView textView = this.f26182e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setDesc(String str) {
        TextView textView = this.f26181d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setLogo(String str) {
        NetImageView netImageView = this.f26178a;
        if (netImageView != null) {
            netImageView.setImageUrl(str);
        }
    }

    public void setPhone(String str) {
        TextView textView = this.f26183f;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTipMessage(String str) {
        this.f26185h = str;
    }

    public void setTips(String str) {
        TextView textView = this.f26180c;
        if (textView != null) {
            textView.setText(str);
        }
        this.f26184g = str;
    }

    public void setTitle(String str) {
        TextView textView = this.f26179b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_authorize_info_view"), this);
        this.f26178a = (NetImageView) findViewById(ResUtils.id(getContext(), "ni_sp_logo"));
        this.f26179b = (TextView) findViewById(ResUtils.id(getContext(), "tv_sp_name"));
        this.f26180c = (TextView) findViewById(ResUtils.id(getContext(), "tv_sp_action"));
        this.f26181d = (TextView) findViewById(ResUtils.id(getContext(), "tv_auth_desc"));
        this.f26182e = (TextView) findViewById(ResUtils.id(getContext(), "tv_amount_tips"));
        this.f26183f = (TextView) findViewById(ResUtils.id(getContext(), "tv_amount_phone"));
        this.f26180c.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TextUtils.isEmpty(AuthorizeInfoView.this.f26185h)) {
                    return;
                }
                PromptTipDialog promptTipDialog = new PromptTipDialog(AuthorizeInfoView.this.getContext());
                promptTipDialog.setTitleMessage(AuthorizeInfoView.this.f26184g);
                promptTipDialog.setMessage(AuthorizeInfoView.this.f26185h);
                promptTipDialog.setButtonMessage(ResUtils.getString(AuthorizeInfoView.this.getContext(), "ebpay_know"));
                promptTipDialog.show();
            }
        });
    }

    public AuthorizeInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26184g = "";
        this.f26185h = "";
        a();
    }

    public AuthorizeInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f26184g = "";
        this.f26185h = "";
        a();
    }
}
