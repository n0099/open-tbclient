package com.baidu.tieba.memberCenter.memberprivilege;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.MemberExchangeActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayResultActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.MemberTaskCenterActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.TailManagementActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleListModel;
import com.baidu.tieba.memberCenter.bubble.ResponseBubbleListMessage;
import com.baidu.tieba.memberCenter.index.MembercenterActivity;
import com.baidu.tieba.memberCenter.memberExchange.MemberExchangeActivity;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity;
import com.baidu.tieba.memberCenter.memberpay.CardBoxMemberPayActivity;
import com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity;
import com.baidu.tieba.memberCenter.memberpay.MemberPayResultActivity;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
import com.baidu.tieba.memberCenter.tail.edit.TailEditActivity;
import com.baidu.tieba.memberCenter.tail.management.TailManagementActivity;
import com.baidu.tieba.memberCenter.tail.message.AddTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.AddTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailSocketResponseMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.z0.p0;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class MemberCenterStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr.length != 0) {
                    String str4 = strArr[0];
                    if (str4.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_CARD_BOX_MEMBER_BUY) && str4.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_CARD_BOX_MEMBER_BUY_ASSIST)) {
                        if (!d.a.c.e.p.j.z()) {
                            BdToast.c(tbPageContext.getPageActivity(), tbPageContext.getString(R.string.neterror)).q();
                        } else if (ViewHelper.checkUpIsLogin(tbPageContext.getPageActivity())) {
                            Bundle i2 = p0.i(str4);
                            str = "";
                            if (i2 != null) {
                                String string = !d.a.c.e.p.k.isEmpty(i2.getString(CardBoxMemberPayActivityConfig.PACKET_ID)) ? i2.getString(CardBoxMemberPayActivityConfig.PACKET_ID) : "";
                                str3 = !d.a.c.e.p.k.isEmpty(i2.getString(MemberPayStatistic.REFER_PAGE)) ? i2.getString(MemberPayStatistic.REFER_PAGE) : "";
                                str2 = d.a.c.e.p.k.isEmpty(i2.getString(MemberPayStatistic.CLICK_ZONE)) ? "" : i2.getString(MemberPayStatistic.CLICK_ZONE);
                                str = string;
                            } else {
                                str2 = "";
                                str3 = str2;
                            }
                            if (tbPageContext != null) {
                                tbPageContext.sendMessage(new CustomMessage(2002001, new CardBoxMemberPayActivityConfig(tbPageContext.getPageActivity(), str, str3, str2)));
                            }
                        }
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (!StringUtils.isNull(str) && str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_EXCHANGE)) {
                        if (!d.a.c.e.p.j.z()) {
                            BdToast.c(tbPageContext.getPageActivity(), tbPageContext.getString(R.string.neterror)).q();
                        } else if (ViewHelper.checkUpIsLogin(tbPageContext.getPageActivity())) {
                            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
                            String d2 = p0.d(str, MemberExchangeActivityConfig.MEMBER_NAME);
                            String d3 = p0.d(str, MemberExchangeActivityConfig.MEMBER_LEVEL_IMAGE);
                            String d4 = p0.d(str, MemberExchangeActivityConfig.DUE_DATE);
                            String d5 = p0.d(str, MemberExchangeActivityConfig.DESC_STR);
                            if (tbPageContext != null) {
                                tbPageContext.sendMessage(new CustomMessage(2002001, new MemberExchangeActivityConfig(tbPageContext.getPageActivity(), currentPortrait, d2, d3, d4, d5)));
                            }
                        }
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.GOTO_TAIL_MANAGER)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TailManagementActivityConfig(tbPageContext.getPageActivity())));
                        return 1;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<d.a.o0.w.m> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context)) {
                    return null;
                }
                return new CustomResponsedMessage<>(2001342, new d.a.p0.v1.h.e.a(customMessage.getData(), 1));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<d.a.o0.w.m> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context)) {
                    return null;
                }
                return new CustomResponsedMessage<>(2001343, new d.a.p0.v1.h.d.b(customMessage.getData()));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Object> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2001294, new d.a.p0.v1.g.b()) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class g implements CustomMessageTask.CustomRunnable<TbPageContext> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<TbPageContext> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof TbPageContext)) {
                    BubbleListModel bubbleListModel = new BubbleListModel(customMessage.getData());
                    bubbleListModel.C();
                    bubbleListModel.F(0, d.a.c.e.p.l.k(customMessage.getData().getPageActivity()), d.a.c.e.p.l.i(customMessage.getData().getPageActivity()));
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class h implements CustomMessageTask.CustomRunnable<HttpResponsedMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage<HttpResponsedMessage> customMessage) {
            InterceptResult invokeL;
            BubbleListData bubbleListData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                String str = null;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof ResponseBubbleListMessage) || (bubbleListData = ((ResponseBubbleListMessage) customMessage.getData()).getBubbleListData()) == null || bubbleListData.getB_info() == null || bubbleListData.getB_info().size() <= 0) {
                    return null;
                }
                Iterator<BubbleListData.BubbleData> it = bubbleListData.getB_info().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    BubbleListData.BubbleData next = it.next();
                    if (next.getIs_free() == 1) {
                        str = next.getB_url();
                        break;
                    }
                }
                return new CustomResponsedMessage<>(2001284, str);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class i implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<d.a.o0.w.m> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context)) {
                    return null;
                }
                return new CustomResponsedMessage<>(2001339, new d.a.p0.v1.b.b(customMessage.getData()));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class j implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr == null || strArr.length == 0 || !strArr[0].contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_TASK_CENTER)) {
                    return 3;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberTaskCenterActivityConfig(tbPageContext.getPageActivity())));
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class k implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (!StringUtils.isNull(str) && str.equals(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_CENTER) && tbPageContext != null) {
                        if (ViewHelper.checkUpIsLogin(tbPageContext.getContext())) {
                            tbPageContext.sendMessage(new CustomMessage(2002001, new MembercenterActivityConfig(tbPageContext.getPageActivity())));
                        }
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class l implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Bundle i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (!StringUtils.isNull(str) && str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.PAY_MEMBER_PAGE) && (i2 = p0.i(str)) != null && tbPageContext.getPageActivity() != null) {
                        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                        int vipStatus = (currentAccountInfo == null || currentAccountInfo.getVipInfo() == null) ? 0 : currentAccountInfo.getVipInfo().getVipStatus();
                        String string = i2.getString("fromtype");
                        String string2 = i2.getString(MemberPayStatistic.REFER_PAGE);
                        String string3 = i2.getString(MemberPayStatistic.CLICK_ZONE);
                        if (!StringUtils.isNull(string)) {
                            if (string.equals(TbadkCoreStatisticKey.TAIL_PAY_MEMBER_SUCCESS)) {
                                i3 = 6;
                            } else if (string.equals(TbadkCoreStatisticKey.BUBBLE_PAY_MEMBER_SUCCESS)) {
                                i3 = 7;
                            }
                            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) tbPageContext.getPageActivity(), vipStatus, false, i3, d.a.c.e.m.b.d(i2.getString(MemberPayActivityConfig.FROM_SCENE), 0));
                            memberPayActivityConfig.setReferPageClickZone(string2, string3);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                            return 0;
                        }
                        i3 = 0;
                        MemberPayActivityConfig memberPayActivityConfig2 = new MemberPayActivityConfig((Context) tbPageContext.getPageActivity(), vipStatus, false, i3, d.a.c.e.m.b.d(i2.getString(MemberPayActivityConfig.FROM_SCENE), 0));
                        memberPayActivityConfig2.setReferPageClickZone(string2, string3);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig2));
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class m implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if ((str.equals(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_BUY) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_BUY_ASSIST)) && tbPageContext != null) {
                        String d2 = p0.d(str, MemberPayStatistic.REFER_PAGE);
                        String d3 = p0.d(str, MemberPayStatistic.CLICK_ZONE);
                        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(tbPageContext.getPageActivity(), 0);
                        memberPayActivityConfig.setReferPageClickZone(d2, d3);
                        tbPageContext.sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class n implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (!StringUtils.isNull(str) && str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_MEMBER_BUY) && tbPageContext != null) {
                        tbPageContext.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig((Context) tbPageContext.getPageActivity(), true, 220010, (String) null, 25)));
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(543469428, "Lcom/baidu/tieba/memberCenter/memberprivilege/MemberCenterStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(543469428, "Lcom/baidu/tieba/memberCenter/memberprivilege/MemberCenterStatic;");
                return;
            }
        }
        TbadkCoreApplication.getInst().RegisterIntent(TailManagementActivityConfig.class, TailManagementActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(TailEditActivityConfig.class, TailEditActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MemberTaskCenterActivityConfig.class, MemberTaskCenterActivity.class);
        TbadkApplication.getInst().RegisterIntent(BubbleChooseActivityConfig.class, BubbleChooseActivity.class);
        TbadkApplication.getInst().RegisterIntent(MemberPayActivityConfig.class, MemberPayFragmentActivity.class);
        TbadkApplication.getInst().RegisterIntent(MemberPrivilegeActivityConfig.class, MemberPrivilegeActivity.class);
        TbadkApplication.getInst().RegisterIntent(MembercenterActivityConfig.class, MembercenterActivity.class);
        TbadkApplication.getInst().RegisterIntent(CardBoxMemberPayActivityConfig.class, CardBoxMemberPayActivity.class);
        TbadkApplication.getInst().RegisterIntent(MemberPayResultActivityConfig.class, MemberPayResultActivity.class);
        TbadkApplication.getInst().RegisterIntent(MemberExchangeActivityConfig.class, MemberExchangeActivity.class);
        d();
        e();
        b();
        CustomMessageTask customMessageTask = new CustomMessageTask(2001294, new f());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001283, new g());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2001284, new h());
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2001339, new i());
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
        UrlManager.getInstance().addListener(new j());
        UrlManager.getInstance().addListener(new k());
        UrlManager.getInstance().addListener(new l());
        UrlManager.getInstance().addListener(new m());
        UrlManager.getInstance().addListener(new n());
        UrlManager.getInstance().addListener(new a());
        UrlManager.getInstance().addListener(new b());
        UrlManager.getInstance().addListener(new c());
    }

    public MemberCenterStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(TbPageContext<?> tbPageContext, String[] strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, tbPageContext, strArr) == null) || strArr == null || strArr.length == 0) {
            return;
        }
        boolean z = false;
        if (TextUtils.isEmpty(strArr[0])) {
            return;
        }
        String str = strArr[0];
        if ((str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_DRESSUP_CENTER) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_BG) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_CARD_DETAIL)) ? true : true) {
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                UrlManager.getInstance().dealOneLink(tbPageContext, strArr);
                return;
            } else {
                d.a.c.e.p.l.L(tbPageContext.getPageActivity(), R.string.pluginstatus_tip_unknown);
                return;
            }
        }
        UrlManager.getInstance().dealOneLink(tbPageContext, strArr);
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001343, new e());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void c(int i2, int i3, String str, Class<? extends HttpResponsedMessage> cls, Class<? extends SocketResponsedMessage> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, cls, cls2}) == null) {
            d.a.p0.h3.d0.a.h(i3, cls2, false, false);
            d.a.p0.h3.d0.a.c(i3, i2, str, cls, false, false, false, false);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            c(CmdConfigHttp.CMD_TAIL_ADD, 305101, TbConfig.TAIL_ADD, AddTailHttpResponseMessage.class, AddTailSocketResponseMessage.class);
            c(CmdConfigHttp.CMD_TAIL_UPDATE, 305102, TbConfig.TAIL_UPDATE, UpdateTailHttpResponseMessage.class, UpdateTailSocketResponseMessage.class);
            c(CmdConfigHttp.CMD_TAIL_SET, 305104, TbConfig.TAIL_SET, SetTailHttpResponseMessage.class, SetTailSocketResponseMessage.class);
            c(CmdConfigHttp.CMD_TAIL_DELETE, 305103, TbConfig.TAIL_DELETE, DeleteTailHttpResponseMessage.class, DeleteTailSocketResponseMessage.class);
            c(CmdConfigHttp.CMD_TAIL_GET, 305001, TbConfig.TAIL_GET, GetTailsHttpResponseMessage.class, GetTailsSocketResponseMessage.class);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001342, new d());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }
}
