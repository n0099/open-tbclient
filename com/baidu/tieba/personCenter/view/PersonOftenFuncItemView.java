package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.ala.IYYCloudSwitchCallback;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.DownloadManagerActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.TbAiappsLaunchUtil;
import com.baidu.tieba.g4a;
import com.baidu.tieba.qd;
import com.baidu.tieba.s3a;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.w3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class PersonOftenFuncItemView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TextView b;
    public w3a c;
    public boolean d;

    /* loaded from: classes7.dex */
    public class a implements IYYCloudSwitchCallback {
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

        @Override // com.baidu.tbadk.ala.IYYCloudSwitchCallback
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                onSwitchGet(false);
            }
        }

        @Override // com.baidu.tbadk.ala.IYYCloudSwitchCallback
        public void onSwitchGet(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
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

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d07e8, this);
            inflate.setOnClickListener(this);
            this.a = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0916ef);
            this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0916f0);
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
        this.d = false;
        b(context);
    }

    public void a(w3a w3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, w3aVar) == null) {
            this.c = w3aVar;
            this.b.setText(w3aVar.e);
            f();
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
        w3a w3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (w3aVar = this.c) == null) {
            return;
        }
        int i = w3aVar.a;
        if (this.d) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int i2 = iArr[1];
            int height = getHeight();
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
            int i3 = height + i2;
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f070420);
            int mainTabBottomBarHeight = equipmentHeight - TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            if ((i2 > dimenPixelSize && i2 < mainTabBottomBarHeight) || (i3 > dimenPixelSize && i3 < mainTabBottomBarHeight)) {
                if (i == 59) {
                    TiebaStatic.log(new StatisticItem("c14904").addParam("obj_locate", "1").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                } else if (i == 63) {
                    new StatisticItem("c15066").eventStat();
                }
                this.d = false;
            }
        }
    }

    public final void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) {
            TbWebViewActivityConfig activityConfig = BrowserHelper.getActivityConfig(getContext(), "", str, true);
            activityConfig.setFixTitle(z);
            activityConfig.start();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            w3a w3aVar = this.c;
            if (w3aVar.b > 0) {
                this.a.setVisibility(0);
                SkinManager.setImageResource(this.a, this.c.b);
            } else if (w3aVar.m && !TextUtils.isEmpty(w3aVar.k)) {
                this.a.setVisibility(0);
                this.a.startLoad(this.c.k, 10, false);
            } else {
                this.a.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        w3a w3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, view2) != null) || (w3aVar = this.c) == null) {
            return;
        }
        if (w3aVar.m && w3aVar.l != 0) {
            if (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) {
                g4a.a(this.c, ((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext());
                return;
            }
            return;
        }
        int i = this.c.a;
        String valueOf = String.valueOf(TbadkCoreApplication.getCurrentAccountId());
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        String displayName = currentAccountInfo.getDisplayName();
        String accountNameShow = currentAccountInfo.getAccountNameShow();
        int sex = currentAccountInfo.getSex();
        String portrait = currentAccountInfo.getPortrait();
        if (i != 10) {
            String str = null;
            if (i != 12) {
                if (i != 15) {
                    if (i != 18) {
                        if (i != 25) {
                            if (i != 62) {
                                if (i != 63) {
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
                                            String str2 = this.c.f;
                                            if (qd.isEmpty(str2)) {
                                                str2 = s3a.w;
                                            }
                                            BrowserHelper.startWebActivity(getContext(), str2);
                                            return;
                                        case 55:
                                            e(TbConfig.COMMUNITY_CONVENTION, true);
                                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_COMMUNITY_CONVENTION_CLICK).addParam("obj_locate", "1").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                                            return;
                                        case 56:
                                            e(TbConfig.CREATE_BA, true);
                                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_CREATE_BA_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                                            return;
                                        case 57:
                                            e(TbConfig.EARN_MONEY, true);
                                            TiebaStatic.log(new StatisticItem("c14711").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                                            return;
                                        case 58:
                                            TbAiappsLaunchUtil.launch("T43rINkXjgPfdKNXTuhQER2KdACVdB00", "", "1191000600000000", 0);
                                            TiebaStatic.log(new StatisticItem("c14710").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                                            return;
                                        case 59:
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/Lfi6Kbvh1amhBhGpSVNSCXgoqg7eEi6F/pages/home/shelf"));
                                            TiebaStatic.log(new StatisticItem("c14905").addParam("obj_locate", "1").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                                            return;
                                        case 60:
                                            e(TbConfig.EXCHANGE_MALL, false);
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                new StatisticItem("c15067").eventStat();
                                BrowserHelper.startWebActivity(getContext(), (String) null, TbConfig.URL_WELFARE, true);
                                return;
                            }
                            if (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) {
                                UrlManager urlManager = UrlManager.getInstance();
                                TbPageContext<?> pageContext = ((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext();
                                urlManager.dealOneLink(pageContext, new String[]{TbConfig.URL_THEME_CENTER + SkinManager.getCurrentSkinTypeString()}, true);
                            }
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_MY_TAB_GENERAL_DRESS_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                            return;
                        }
                        c(valueOf, displayName, portrait, sex);
                        return;
                    }
                    e(TbConfig.TIEBA_ADDRESS + "mo/q/packetpage/myPacket?tieba_hybrid_enabled=1", true);
                    return;
                }
                e(TbConfig.TIEBA_ADDRESS + "mo/q/wise-business-merchant/serviceCenter", true);
                return;
            }
            MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(getContext());
            if (StringUtils.isNotNull(this.c.f)) {
                membercenterActivityConfig.setUrl(this.c.f);
            } else {
                UserData userData = this.c.g;
                if (userData != null && ListUtils.getItem(userData.getTShowInfoNew(), 0) != null) {
                    str = ((IconData) ListUtils.getItem(this.c.g.getTShowInfoNew(), 0)).getUrl();
                }
                if (StringUtils.isNotNull(str)) {
                    membercenterActivityConfig.setUrl(str);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(getContext(), valueOf, displayName, accountNameShow, sex, "iowner_gift")));
    }
}
