package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.DownloadManagerActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i28;
import com.repackage.ll4;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PersonOftenFuncItemView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TextView b;
    public i28 c;

    /* loaded from: classes3.dex */
    public class a implements ll4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ PersonOftenFuncItemView e;

        public a(PersonOftenFuncItemView personOftenFuncItemView, String str, String str2, String str3, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personOftenFuncItemView, str, str2, str3, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = personOftenFuncItemView;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = i;
        }

        @Override // com.repackage.ll4
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    if (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) {
                        UrlManager.getInstance().dealOneLink(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{UrlSchemaHelper.GO_TO_YY_PERSONAL_CENTER_PAGE});
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(TbadkCoreApplication.getInst(), this.a, this.b, this.c, this.d, true)));
            }
        }

        @Override // com.repackage.ll4
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a(false);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PersonOftenFuncItemView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(i28 i28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, i28Var) == null) {
            this.c = i28Var;
            this.a.setImageResource(i28Var.b);
            this.b.setText(i28Var.e);
        }
    }

    public void b(String str, String str2, String str3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, i) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new a(this, str, str2, str3, i)));
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_PERSON_LIVE_TAB_CLICK));
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        i28 i28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || (i28Var = this.c) == null) {
            return;
        }
        int i = i28Var.a;
        String valueOf = String.valueOf(TbadkCoreApplication.getCurrentAccountId());
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        String displayName = currentAccountInfo.getDisplayName();
        String accountNameShow = currentAccountInfo.getAccountNameShow();
        int sex = currentAccountInfo.getSex();
        String portrait = currentAccountInfo.getPortrait();
        if (i == 10) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(getContext(), valueOf, displayName, accountNameShow, sex, "iowner_gift")));
        } else if (i == 12) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MembercenterActivityConfig(getContext())));
        } else if (i == 15) {
            c("https://tieba.baidu.com/mo/q/wise-business-merchant/serviceCenter");
        } else if (i == 18) {
            c(TbConfig.URL_JUMP_TAG_CARDBOX);
        } else if (i != 25) {
            switch (i) {
                case 50:
                    c("https://wappass.baidu.com/v6/safetyInspection?adapter=3");
                    return;
                case 51:
                    c("http://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
                    return;
                case 52:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DownloadManagerActivityConfig(getContext(), 1)));
                    return;
                case 53:
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", Long.valueOf(TbadkCoreApplication.getCurrentAccountId()));
                    hashMap.put("entryType", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(TbadkCoreApplication.getInst().getApplicationContext(), "AuthenticationCenterPage", hashMap)));
                    return;
                default:
                    return;
            }
        } else {
            b(valueOf, displayName, portrait, sex);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PersonOftenFuncItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonOftenFuncItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d06a7, this);
        inflate.setOnClickListener(this);
        this.a = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091365);
        this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091366);
    }
}
