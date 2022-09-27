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
import com.baidu.tbadk.TbSingleton;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.eo4;
import com.baidu.tieba.kc5;
import com.baidu.tieba.mr5;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.u58;
import com.baidu.tieba.yo4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class PersonOftenFuncItemView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TextView b;
    public u58 c;

    /* loaded from: classes5.dex */
    public class a implements eo4 {
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

        @Override // com.baidu.tieba.eo4
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

        @Override // com.baidu.tieba.eo4
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

    public void a(u58 u58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, u58Var) == null) {
            this.c = u58Var;
            this.a.setImageResource(u58Var.b);
            this.b.setText(u58Var.e);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d06ff, this);
            inflate.setOnClickListener(this);
            this.a = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09146d);
            this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09146e);
        }
    }

    public void c(String str, String str2, String str3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, i) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new a(this, str, str2, str3, i)));
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_PERSON_LIVE_TAB_CLICK));
        }
    }

    public void d() {
        u58 u58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (u58Var = this.c) != null && u58Var.a == 59 && TbSingleton.getInstance().isMyTabClicked()) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int i = iArr[1];
            int height = getHeight();
            int i2 = ej.i(TbadkCoreApplication.getInst());
            int i3 = height + i;
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f070306);
            int mainTabBottomBarHeight = i2 - TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            if ((i <= dimenPixelSize || i >= mainTabBottomBarHeight) && (i3 <= dimenPixelSize || i3 >= mainTabBottomBarHeight)) {
                return;
            }
            TbSingleton.getInstance().setMyTabClicked(false);
            TiebaStatic.log(new StatisticItem("c14904").addParam("obj_locate", "1").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(z);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        u58 u58Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view2) == null) || (u58Var = this.c) == null) {
            return;
        }
        int i = u58Var.a;
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
            e(TbConfig.TIEBA_ADDRESS + "mo/q/wise-business-merchant/serviceCenter", true);
        } else if (i == 18) {
            e(TbConfig.TIEBA_ADDRESS + "mo/q/packetpage/myPacket?tieba_hybrid_enabled=1", true);
        } else if (i != 25) {
            switch (i) {
                case 50:
                    e("https://wappass.baidu.com/v6/safetyInspection?adapter=3", true);
                    return;
                case 51:
                    e(TbConfig.TIEBA_ADDRESS + "mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + String.valueOf(TbadkCoreApplication.getCurrentAccountId()), true);
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
                case 54:
                    yo4.o(getContext(), kc5.g("https://boxnovel.baidu.com/boxnovel/tbvipright?data={\"fromaction\": \"tieba\"}"));
                    return;
                case 55:
                    e(TbConfig.COMMUNITY_CONVENTION, true);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_COMMUNITY_CONVENTION_CLICK).addParam("obj_locate", "1").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                    return;
                case 56:
                    e(TbConfig.CREATE_BA + TbConfig.getVersion(), true);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_CREATE_BA_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                    return;
                case 57:
                    e(TbConfig.EARN_MONEY + TbConfig.getVersion(), true);
                    TiebaStatic.log(new StatisticItem("c14711").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                    return;
                case 58:
                    mr5.b("T43rINkXjgPfdKNXTuhQER2KdACVdB00", "", "1191000600000000", 0);
                    TiebaStatic.log(new StatisticItem("c14710").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                    return;
                case 59:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/Lfi6Kbvh1amhBhGpSVNSCXgoqg7eEi6F/pages/home/shelf"));
                    TiebaStatic.log(new StatisticItem("c14905").addParam("obj_locate", "1").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                    return;
                case 60:
                    e(TbConfig.EXCHANGE_MALL + TbConfig.getVersion(), false);
                    return;
                default:
                    return;
            }
        } else {
            c(valueOf, displayName, portrait, sex);
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
        b(context);
    }
}
