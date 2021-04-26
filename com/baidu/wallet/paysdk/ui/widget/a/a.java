package com.baidu.wallet.paysdk.ui.widget.a;

import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView;
/* loaded from: classes5.dex */
public class a extends AuthorizeInfoView.b {
    public a(AuthorizeInfoView authorizeInfoView) {
        super(authorizeInfoView);
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView.b
    public void a(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Authorize) {
            Authorize authorize = (Authorize) obj;
            this.f26829a.setLogo(authorize.sp_logo_url);
            this.f26829a.setTitle(authorize.sp_company_title);
            this.f26829a.setTips(authorize.authorize_action_desc);
            String[] strArr = authorize.authorize_desc;
            int i2 = 0;
            if (strArr != null && strArr.length > 0) {
                this.f26829a.setDesc(strArr[0]);
            }
            if (authorize.detail_info == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(authorize.detail_info.introduce)) {
                sb.append(authorize.detail_info.introduce);
                sb.append("\n");
            }
            while (true) {
                String[] strArr2 = authorize.detail_info.detail;
                if (i2 < strArr2.length) {
                    if (!TextUtils.isEmpty(strArr2[i2])) {
                        sb.append("\n· ");
                        sb.append(authorize.detail_info.detail[i2]);
                    }
                    i2++;
                } else {
                    this.f26829a.setTipMessage(sb.toString());
                    return;
                }
            }
        } else if (obj instanceof UserData.UserModel) {
            this.f26829a.setPhone(((UserData.UserModel) obj).authorize_display_name);
        }
    }
}
