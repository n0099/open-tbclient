package com.baidu.wallet.paysdk.ui.widget.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView;
import com.dxmpay.wallet.base.datamodel.UserData;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes13.dex */
public class a extends AuthorizeInfoView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AuthorizeInfoView authorizeInfoView) {
        super(authorizeInfoView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {authorizeInfoView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((AuthorizeInfoView) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView.b
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null) {
            return;
        }
        if (obj instanceof Authorize) {
            Authorize authorize = (Authorize) obj;
            this.a.setLogo(authorize.sp_logo_url);
            this.a.setTitle(authorize.sp_company_title);
            this.a.setTips(authorize.authorize_action_desc);
            String[] strArr = authorize.authorize_desc;
            int i2 = 0;
            if (strArr != null && strArr.length > 0) {
                this.a.setDesc(strArr[0]);
            }
            if (authorize.detail_info == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(authorize.detail_info.introduce)) {
                sb.append(authorize.detail_info.introduce);
                sb.append(StringUtils.LF);
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
                    this.a.setTipMessage(sb.toString());
                    return;
                }
            }
        } else if (obj instanceof UserData.UserModel) {
            this.a.setPhone(((UserData.UserModel) obj).authorize_display_name);
        }
    }
}
