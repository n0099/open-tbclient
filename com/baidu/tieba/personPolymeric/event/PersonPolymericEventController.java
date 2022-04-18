package com.baidu.tieba.personPolymeric.event;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.MembershipUserInfo;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mg;
import com.repackage.p58;
import com.repackage.t48;
import com.repackage.ul4;
import com.repackage.xz4;
import com.repackage.y76;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
/* loaded from: classes3.dex */
public class PersonPolymericEventController extends p58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t48 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonPolymericEventController(TbPageContext tbPageContext, t48 t48Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, t48Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = t48Var;
    }

    @Override // com.repackage.p58, com.repackage.uw8
    public void a(View view2, y76 y76Var) {
        String str;
        int i;
        MembershipUserInfo membershipUserInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, y76Var) == null) {
            super.a(view2, y76Var);
            if (y76Var == null) {
                return;
            }
            Bundle bundle = y76Var.b;
            String str2 = null;
            UserData userData = bundle != null ? (UserData) bundle.getSerializable(UserData.TYPE_USER) : null;
            int i2 = 1;
            switch (y76Var.a) {
                case 1:
                    if (userData == null) {
                        return;
                    }
                    xz4 xz4Var = new xz4();
                    if (!StringUtils.isNull(userData.getPortrait()) && userData.getPortrait().startsWith("http")) {
                        xz4Var.f(userData.getPortrait());
                    } else {
                        xz4Var.f(userData.getPortraitH());
                    }
                    xz4Var.i(userData.getPortrait());
                    xz4Var.g(true);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(xz4Var);
                    this.e.o().s(xz4Var, arrayList, 0);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 18:
                case 19:
                case 23:
                case 25:
                case 26:
                case 28:
                case 35:
                case 37:
                default:
                    return;
                case 8:
                    this.a.getPageActivity().finish();
                    return;
                case 9:
                    t48 t48Var = this.e;
                    if (t48Var == null || t48Var.m() == null) {
                        return;
                    }
                    TiebaStatic.log("c12207");
                    this.e.m().e();
                    return;
                case 10:
                    if (userData != null) {
                        str = userData.getUserId();
                        str2 = userData.getBg_pic();
                        try {
                            i = mg.e(c(str2).get("props_id"), -1);
                        } catch (URISyntaxException unused) {
                        }
                        if (i == -1 && !str.equals(TbadkCoreApplication.getCurrentAccount())) {
                            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackgroundPreviewActivityConfig(this.a.getPageActivity(), i, (currentAccountInfo == null || StringUtils.isNull(str2) || StringUtils.isNull(currentAccountInfo.getPersonalBgUrl()) || !str2.equalsIgnoreCase(currentAccountInfo.getPersonalBgUrl())) ? 0 : 0)));
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(this.a.getPageActivity())));
                        return;
                    }
                    str = "";
                    i = -1;
                    if (i == -1) {
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(this.a.getPageActivity())));
                    return;
                case 11:
                    if (TbadkCoreApplication.getCurrentAccountInfo() == null) {
                        return;
                    }
                    PersonChangeData personChangeData = new PersonChangeData();
                    if (userData != null) {
                        personChangeData.setPortrait(userData.getPortrait());
                        personChangeData.setName(userData.getUserName());
                        personChangeData.setSex(userData.getSex());
                        personChangeData.setIntro(userData.getIntro());
                        personChangeData.setNameShow(userData.getName_show());
                        personChangeData.setMem(userData.getIsMem());
                        personChangeData.setCanModifyAvatar(userData.canModifyAvatar());
                        personChangeData.setCantModifyAvatarDesc(userData.getCantModifyAvatarDesc());
                        personChangeData.setTiebaId(userData.getmTiebaUid());
                        Bundle bundle2 = y76Var.b;
                        if (bundle2 != null) {
                            personChangeData.setNickNameLeftDays(bundle2.getInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, -1));
                        }
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
                    return;
                case 12:
                    if (userData == null) {
                        return;
                    }
                    TiebaStatic.log("igift_icon_ck");
                    if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                        GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.a.getPageActivity(), userData.getUserIdLong(), userData.getUserName(), userData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
                        giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
                        return;
                    }
                    return;
                case 13:
                    UrlManager.getInstance().dealOneLink(this.a, new String[]{TbConfig.WEB_URL_FANS});
                    return;
                case 14:
                    CurrencyJumpHelper.personGotoBuyBean(this.a.getPageActivity());
                    return;
                case 15:
                    b(8);
                    if (userData == null || (membershipUserInfo = userData.membershipInfo) == null) {
                        return;
                    }
                    String str3 = membershipUserInfo.mLink;
                    if (StringUtils.isNull(str3)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a, new String[]{str3});
                    return;
                case 16:
                    b(7);
                    PersonRedTipManager.getInstance().updateRedTipState(7, false, this.d);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MembercenterActivityConfig(this.a.getPageActivity())));
                    return;
                case 17:
                    b(12);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ConsumptionRecordsActivityConfig(TbadkCoreApplication.getInst().getApplicationContext())));
                    return;
                case 20:
                    b(2);
                    PersonRedTipManager.getInstance().updateRedTipState(3, false, this.d);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.a.getPageActivity())));
                    return;
                case 21:
                    b(5);
                    TiebaStatic.log(new StatisticItem("c11590").param("obj_locate", 2).param("obj_source", this.c));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.a.getPageActivity())));
                    return;
                case 22:
                    TiebaStatic.log(new StatisticItem("c11590").param("obj_locate", 3).param("obj_source", this.c));
                    if (userData == null) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MissonDetailsActivityConfig(this.a.getPageActivity(), 24004, userData.getAnchorLevel(), userData.getPortrait(), userData.getName_show(), "from_person")));
                    return;
                case 24:
                    b(3);
                    PersonRedTipManager.getInstance().updateRedTipState(4, false, this.d);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddressListActivityConfig(this.a.getPageActivity())));
                    return;
                case 27:
                    b(10);
                    TiebaStatic.log(new StatisticItem("c11948"));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigImgPbActivityConfig(this.a.getPageActivity())));
                    return;
                case 29:
                    if (userData == null) {
                        return;
                    }
                    b(6);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.a.getPageActivity(), userData.getUserId(), userData.getUserName(), userData.getPortrait(), userData.getSex(), true)));
                    return;
                case 30:
                    b(1);
                    PersonRedTipManager.getInstance().updateRedTipState(8, false, this.d);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this.a.getPageActivity())));
                    return;
                case 31:
                    b(9);
                    UrlManager.getInstance().dealOneLink(this.a, new String[]{y76Var.b.getString("book_jump_link")}, true);
                    return;
                case 32:
                    if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                        b(4);
                        PersonRedTipManager.getInstance().updateRedTipState(1, false, this.d);
                        if (userData == null || !TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.a.getPageActivity(), userData.getUserId(), userData.getUserName(), userData.getName_show(), userData.getSex(), "iowner_gift")));
                        return;
                    }
                    return;
                case 33:
                    b(11);
                    UrlManager.getInstance().dealOneLink(this.a, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    return;
                case 34:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921008, Boolean.FALSE));
                    return;
                case 36:
                    if (userData == null) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.a.getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getName_show(), userData.getSex())));
                    return;
                case 38:
                    if (userData == null) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.a.getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), userData.getSex(), false)));
                    return;
                case 39:
                    StringBuilder sb = new StringBuilder();
                    sb.append("http://tieba.baidu.com/mo/q/hybrid-main-service/uegServiceCenter?is_yy_user=");
                    sb.append(TbSingleton.getInstance().getSyncYYSwitch() ? "1" : "0");
                    ul4.m(this.a.getPageActivity(), sb.toString());
                    return;
                case 40:
                    if (userData == null || !ViewHelper.checkUpIsLogin(this.a.getPageActivity()) || userData == null || userData.getUserId() == null || userData.getUserName() == null || userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        return;
                    }
                    try {
                        TiebaStatic.log(new StatisticItem("c11593"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.a.getPageActivity(), Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex(), userData.getIsFriend(), userData.getUserType())));
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                case 41:
                    if (userData == null || userData.getBaijiahaoInfo() == null) {
                        return;
                    }
                    xz4 xz4Var2 = new xz4();
                    xz4Var2.f(userData.getBaijiahaoInfo().avatar_h);
                    xz4Var2.i(userData.getBaijiahaoInfo().avatar);
                    xz4Var2.g(false);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(xz4Var2);
                    if (this.e.o() != null) {
                        this.e.o().t(xz4Var2, arrayList2, 0, true);
                        return;
                    }
                    return;
            }
        }
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", i));
        }
    }

    public final Map<String, String> c(String str) throws URISyntaxException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? new HashMap<String, String>(this, str) { // from class: com.baidu.tieba.personPolymeric.event.PersonPolymericEventController.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PersonPolymericEventController this$0;
            public final /* synthetic */ String val$url;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$url = str;
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(this.val$url), "UTF-8")) {
                    put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        } : (Map) invokeL.objValue;
    }
}
