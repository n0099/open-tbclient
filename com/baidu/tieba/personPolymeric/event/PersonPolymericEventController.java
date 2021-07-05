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
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.m.b;
import d.a.r0.t.o;
import d.a.s0.m2.d.g;
import d.a.s0.m2.f.a;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
/* loaded from: classes5.dex */
public class PersonPolymericEventController extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public g f20148e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonPolymericEventController(TbPageContext tbPageContext, g gVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20148e = gVar;
    }

    @Override // d.a.s0.m2.f.a, d.a.s0.z3.f
    public void a(View view, d.a.s0.m0.a aVar) {
        String str;
        int i2;
        MembershipUserInfo membershipUserInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, aVar) == null) {
            super.a(view, aVar);
            if (aVar == null) {
                return;
            }
            Bundle bundle = aVar.f63325b;
            String str2 = null;
            UserData userData = bundle != null ? (UserData) bundle.getSerializable(UserData.TYPE_USER) : null;
            int i3 = 1;
            switch (aVar.f63324a) {
                case 1:
                    if (userData == null) {
                        return;
                    }
                    o oVar = new o();
                    if (!StringUtils.isNull(userData.getPortrait()) && userData.getPortrait().startsWith("http")) {
                        oVar.e(userData.getPortrait());
                    } else {
                        oVar.e(userData.getPortraitH());
                    }
                    oVar.i(userData.getPortrait());
                    oVar.h(true);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(oVar);
                    this.f20148e.o().r(oVar, arrayList, 0);
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
                    this.f63523a.getPageActivity().finish();
                    return;
                case 9:
                    g gVar = this.f20148e;
                    if (gVar == null || gVar.m() == null) {
                        return;
                    }
                    TiebaStatic.log("c12207");
                    this.f20148e.m().e();
                    return;
                case 10:
                    if (userData != null) {
                        str = userData.getUserId();
                        str2 = userData.getBg_pic();
                        try {
                            i2 = b.d(c(str2).get("props_id"), -1);
                        } catch (URISyntaxException unused) {
                        }
                        if (i2 == -1 && !str.equals(TbadkCoreApplication.getCurrentAccount())) {
                            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackgroundPreviewActivityConfig(this.f63523a.getPageActivity(), i2, (currentAccountInfo == null || StringUtils.isNull(str2) || StringUtils.isNull(currentAccountInfo.getPersonalBgUrl()) || !str2.equalsIgnoreCase(currentAccountInfo.getPersonalBgUrl())) ? 0 : 0)));
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(this.f63523a.getPageActivity())));
                        return;
                    }
                    str = "";
                    i2 = -1;
                    if (i2 == -1) {
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(this.f63523a.getPageActivity())));
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
                        Bundle bundle2 = aVar.f63325b;
                        if (bundle2 != null) {
                            personChangeData.setNickNameLeftDays(bundle2.getInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, -1));
                        }
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.f63523a.getPageActivity(), 101, personChangeData, Boolean.FALSE)));
                    return;
                case 12:
                    if (userData == null) {
                        return;
                    }
                    TiebaStatic.log("igift_icon_ck");
                    if (ViewHelper.checkUpIsLogin(this.f63523a.getPageActivity())) {
                        GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.f63523a.getPageActivity(), userData.getUserIdLong(), userData.getUserName(), userData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
                        giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
                        return;
                    }
                    return;
                case 13:
                    UrlManager.getInstance().dealOneLink(this.f63523a, new String[]{TbConfig.WEB_URL_FANS});
                    return;
                case 14:
                    CurrencyJumpHelper.personGotoBuyBean(this.f63523a.getPageActivity());
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
                    UrlManager.getInstance().dealOneLink(this.f63523a, new String[]{str3});
                    return;
                case 16:
                    b(7);
                    d.a.s0.x2.a.v().L(7, false, this.f63526d);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MembercenterActivityConfig(this.f63523a.getPageActivity())));
                    return;
                case 17:
                    b(12);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ConsumptionRecordsActivityConfig(TbadkCoreApplication.getInst().getApplicationContext())));
                    return;
                case 20:
                    b(2);
                    d.a.s0.x2.a.v().L(3, false, this.f63526d);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.f63523a.getPageActivity())));
                    return;
                case 21:
                    b(5);
                    TiebaStatic.log(new StatisticItem("c11590").param("obj_locate", 2).param("obj_source", this.f63525c));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.f63523a.getPageActivity())));
                    return;
                case 22:
                    TiebaStatic.log(new StatisticItem("c11590").param("obj_locate", 3).param("obj_source", this.f63525c));
                    if (userData == null) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MissonDetailsActivityConfig(this.f63523a.getPageActivity(), 24004, userData.getAnchorLevel(), userData.getPortrait(), userData.getName_show(), "from_person")));
                    return;
                case 24:
                    b(3);
                    d.a.s0.x2.a.v().L(4, false, this.f63526d);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddressListActivityConfig(this.f63523a.getPageActivity())));
                    return;
                case 27:
                    b(10);
                    TiebaStatic.log(new StatisticItem("c11948"));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigImgPbActivityConfig(this.f63523a.getPageActivity())));
                    return;
                case 29:
                    if (userData == null) {
                        return;
                    }
                    b(6);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.f63523a.getPageActivity(), userData.getUserId(), userData.getUserName(), userData.getPortrait(), userData.getSex(), true)));
                    return;
                case 30:
                    b(1);
                    d.a.s0.x2.a.v().L(8, false, this.f63526d);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this.f63523a.getPageActivity())));
                    return;
                case 31:
                    b(9);
                    UrlManager.getInstance().dealOneLink(this.f63523a, new String[]{aVar.f63325b.getString("book_jump_link")}, true);
                    return;
                case 32:
                    if (ViewHelper.checkUpIsLogin(this.f63523a.getPageActivity())) {
                        b(4);
                        d.a.s0.x2.a.v().L(1, false, this.f63526d);
                        if (userData == null || !TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.f63523a.getPageActivity(), userData.getUserId(), userData.getUserName(), userData.getName_show(), userData.getSex(), "iowner_gift")));
                        return;
                    }
                    return;
                case 33:
                    b(11);
                    UrlManager.getInstance().dealOneLink(this.f63523a, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    return;
                case 34:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921008, Boolean.FALSE));
                    return;
                case 36:
                    if (userData == null) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.f63523a.getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getName_show(), userData.getSex())));
                    return;
                case 38:
                    if (userData == null) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.f63523a.getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), userData.getSex(), false)));
                    return;
                case 39:
                    StringBuilder sb = new StringBuilder();
                    sb.append("http://tieba.baidu.com/mo/q/hybrid-main-service/uegServiceCenter?is_yy_user=");
                    sb.append(TbSingleton.getInstance().getSyncYYSwitch() ? "1" : "0");
                    d.a.r0.l.a.l(this.f63523a.getPageActivity(), sb.toString());
                    return;
                case 40:
                    if (userData == null || !ViewHelper.checkUpIsLogin(this.f63523a.getPageActivity()) || userData == null || userData.getUserId() == null || userData.getUserName() == null || userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        return;
                    }
                    try {
                        TiebaStatic.log(new StatisticItem("c11593"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.f63523a.getPageActivity(), Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex(), userData.getIsFriend(), userData.getUserType())));
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                case 41:
                    if (userData == null || userData.getBaijiahaoInfo() == null) {
                        return;
                    }
                    o oVar2 = new o();
                    oVar2.e(userData.getBaijiahaoInfo().avatar_h);
                    oVar2.i(userData.getBaijiahaoInfo().avatar);
                    oVar2.h(false);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(oVar2);
                    if (this.f20148e.o() != null) {
                        this.f20148e.o().s(oVar2, arrayList2, 0, true);
                        return;
                    }
                    return;
            }
        }
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", i2));
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
