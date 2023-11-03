package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.TbSocketMessageTask;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.message.ConcernPageHttpResMessage;
import com.baidu.tieba.homepage.concern.message.ConcernPageRequestMessage;
import com.baidu.tieba.homepage.concern.message.ConcernPageSocketResMessage;
import com.baidu.tieba.lb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import tbclient.LayoutFactory;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
import tbclient.Userlike.PageData;
/* loaded from: classes9.dex */
public final class yo6 extends lb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public final Map<String, gb7> e;
    public final Map<String, String> f;
    public ConcernFragment g;
    public final NetMessageListener h;

    /* loaded from: classes9.dex */
    public static final class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yo6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(yo6 yo6Var) {
            super(CmdConfigHttp.CMD_CONCERN_PAGE, 309474);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yo6Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.adp.framework.listener.NetMessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            lb7.a d;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.i(false);
                if (responsedMessage == null) {
                    ConcernFragment o = this.a.o();
                    if (o != null) {
                        pza.a(o, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "concern tab network data null"));
                        return;
                    }
                    return;
                }
                if (responsedMessage.getOrginalMessage() != null) {
                    Object extra = responsedMessage.getOrginalMessage().getExtra();
                    if ((extra instanceof ConcernPageRequestMessage) && ((ConcernPageRequestMessage) extra).getLoadType() == 1) {
                        z = true;
                        if (responsedMessage.getError() == 0) {
                            this.a.b().d = responsedMessage.getError();
                            this.a.b().e = responsedMessage.getErrorString();
                            ConcernFragment o2 = this.a.o();
                            if (o2 != null) {
                                pza.a(o2, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "concern tab network data wrong, error code: " + responsedMessage.getError() + " error msg " + responsedMessage.getErrorString()));
                            }
                        } else {
                            this.a.b().d = 0;
                            DataRes dataRes = null;
                            if (responsedMessage instanceof ConcernPageSocketResMessage) {
                                dataRes = ((ConcernPageSocketResMessage) responsedMessage).getResultData();
                            } else if (responsedMessage instanceof ConcernPageHttpResMessage) {
                                dataRes = ((ConcernPageHttpResMessage) responsedMessage).getResultData();
                            }
                            this.a.t(dataRes, z);
                        }
                        d = this.a.d();
                        if (d == null) {
                            d.a(this.a.b());
                            return;
                        }
                        return;
                    }
                }
                z = false;
                if (responsedMessage.getError() == 0) {
                }
                d = this.a.d();
                if (d == null) {
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yo6(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = new HashMap();
        this.f = new HashMap();
        this.h = new a(this);
        v();
        w();
        MessageManager.getInstance().registerListener(this.h);
        x();
        m();
        u();
    }

    public final void r(Object data) {
        za7<?> za7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                i87 i87Var = r67.a().get("fake_wall");
                if (i87Var != null) {
                    za7Var = i87Var.b(data);
                } else {
                    za7Var = null;
                }
                int i = 0;
                for (za7<?> za7Var2 : b().a) {
                    if (!(za7Var2.b() instanceof s27)) {
                        break;
                    }
                    Object b = za7Var2.b();
                    if (b != null) {
                        if (!(((s27) b).a().a instanceof bm6)) {
                            break;
                        }
                        i++;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.card.uistate.OtherTemplateUiState");
                    }
                }
                if (za7Var != null) {
                    b().a.add(i, za7Var);
                }
                lb7.a d = d();
                if (d != null) {
                    d.a(b());
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (!GlobalBuildConfig.isDebug()) {
                    return;
                }
                throw e;
            }
        }
    }

    public final boolean z(String userId) {
        InterceptResult invokeL;
        lb7.a d;
        e57<?> e57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, userId)) == null) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Iterator<za7<?>> it = b().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                za7<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if ((next instanceof v47) && (e57Var = ((v47) next).c) != null && Intrinsics.areEqual(userId, e57Var.n())) {
                    it.remove();
                    z = true;
                }
            }
            if (z && (d = d()) != null) {
                d.a(b());
            }
            if (z && b().a.size() < 9) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void y(ConcernFragment concernFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, concernFragment) == null) {
            this.g = concernFragment;
        }
    }

    @Override // com.baidu.tieba.lb7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    @Override // com.baidu.tieba.lb7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !e()) {
            i(true);
            ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
            concernPageRequestMessage.setPageTag("0");
            concernPageRequestMessage.setLoadType(1);
            concernPageRequestMessage.setIsNewFeed(1);
            MessageManager.getInstance().sendMessage(concernPageRequestMessage);
        }
    }

    @Override // com.baidu.tieba.lb7
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !e()) {
            i(true);
            ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
            concernPageRequestMessage.setPageTag(this.d);
            concernPageRequestMessage.setLoadType(2);
            concernPageRequestMessage.setIsNewFeed(1);
            MessageManager.getInstance().sendMessage(concernPageRequestMessage);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.put("page_from", ImageViewerConfig.FROM_CONCERN);
        }
    }

    public final ConcernFragment o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return (ConcernFragment) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return b().c;
        }
        return invokeV.booleanValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_PAGE, cra.a(TbConfig.URL_CONCERN_PAGE, 309474));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernPageHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            TbSocketMessageTask tbSocketMessageTask = new TbSocketMessageTask(309474);
            tbSocketMessageTask.setResponsedClass(ConcernPageSocketResMessage.class);
            tbSocketMessageTask.setNeedAck(true);
            MessageManager.getInstance().registerTask(tbSocketMessageTask);
        }
    }

    public final Map<String, ThreadData> l(List<ConcernData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            HashMap hashMap = new HashMap();
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && list != null) {
                for (ConcernData concernData : list) {
                    if (concernData.thread_list != null) {
                        ThreadData threadData = new ThreadData();
                        threadData.setFromConcern(true);
                        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                        threadData.parserProtobuf(concernData.thread_list);
                        if (s(threadData)) {
                            hashMap.put(threadData.tid, threadData);
                        }
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Iterator<za7<?>> it = b().a.iterator();
            while (it.hasNext()) {
                za7<?> next = it.next();
                if (next != null && (next.b() instanceof p47)) {
                    Object b = next.b();
                    if (b != null) {
                        b67 l = ((p47) b).l();
                        if (l != null && Intrinsics.areEqual("recommend_user", l.d())) {
                            it.remove();
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.component.uistate.RecommendCardUiState");
                    }
                }
            }
            lb7.a d = d();
            if (d != null) {
                d.a(b());
            }
        }
    }

    public final void q(za7<?> za7Var, Map<String, ? extends ThreadData> map) {
        v47 v47Var;
        e57<?> e57Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, za7Var, map) == null) && (za7Var instanceof v47) && (e57Var = (v47Var = (v47) za7Var).c) != null) {
            String m = e57Var.m();
            if (!TextUtils.isEmpty(m)) {
                v47Var.c.s(map.get(m));
            }
        }
    }

    public final boolean s(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, threadData)) == null) {
            if (threadData == null || threadData.isShareThread || threadData.itemData != null || threadData.itemStarData != null) {
                return false;
            }
            int i = threadData.threadType;
            if (i != 0 && i != 11 && i != 40) {
                return threadData.isUgcThreadType();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void t(Message message, boolean z) {
        i87 i87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, message, z) == null) {
            boolean z2 = false;
            if (!(message instanceof DataRes)) {
                ConcernFragment concernFragment = this.g;
                if (concernFragment != null) {
                    pza.a(concernFragment, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "concern tab parse data wrong data type"));
                    return;
                }
                return;
            }
            if (z) {
                b().a.clear();
            }
            DataRes dataRes = (DataRes) message;
            PageData pageData = dataRes.page_data;
            if (pageData != null && !ListUtils.isEmpty(pageData.feed_list)) {
                Map<String, ThreadData> l = l(dataRes.thread_info);
                try {
                    for (LayoutFactory layoutFactory : ((DataRes) message).page_data.feed_list) {
                        if (layoutFactory != null) {
                            i87 i87Var2 = r67.a().get(layoutFactory.layout);
                            if (i87Var2 != null) {
                                if (i87Var2 instanceof fb7) {
                                    ((fb7) i87Var2).d(this.e);
                                }
                                if (i87Var2 instanceof ca7) {
                                    ((ca7) i87Var2).a(this.f);
                                }
                                za7<?> b = i87Var2.b(layoutFactory);
                                q(b, l);
                                if (b != null) {
                                    b().a.add(b);
                                }
                            } else {
                                BdLog.e("no layout for " + layoutFactory.layout);
                            }
                        }
                    }
                    if (z && ((DataRes) message).user_follow_live != null && !ListUtils.isEmpty(((DataRes) message).user_follow_live.user_follow_live) && (i87Var = r67.a().get("ala_live_attention")) != null) {
                        b().a.add(0, i87Var.b(((DataRes) message).user_follow_live));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    ConcernFragment concernFragment2 = this.g;
                    if (concernFragment2 != null) {
                        pza.a(concernFragment2, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "concern tab parse data empty exception " + e.getMessage()));
                    }
                    if (GlobalBuildConfig.isDebug()) {
                        throw e;
                    }
                }
                y57 b2 = b();
                Integer num = dataRes.has_more;
                if (num != null && num.intValue() == 1) {
                    z2 = true;
                }
                b2.c = z2;
                this.d = dataRes.page_tag;
                if (b().a.size() > 1) {
                    gb7 gb7Var = this.e.get("concern_reco_show");
                    if (gb7Var instanceof ep6) {
                        ((ep6) gb7Var).b("1");
                        return;
                    }
                    return;
                }
                return;
            }
            ConcernFragment concernFragment3 = this.g;
            if (concernFragment3 != null) {
                pza.a(concernFragment3, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "concern tab parse data empty list"));
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            HashMap<String, i87> a2 = r67.a();
            Intrinsics.checkNotNullExpressionValue(a2, "getItemDataMap()");
            a2.put("ala_live_attention", new vo6());
            HashMap<String, i87> a3 = r67.a();
            Intrinsics.checkNotNullExpressionValue(a3, "getItemDataMap()");
            a3.put("fake_wall", new wo6());
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.e.put(PageInfo.KEY, new np6());
            this.e.put("image_click", new kp6());
            this.e.put("head_click_selector1", new hp6());
            this.e.put("head_click_selector2", new ip6());
            this.e.put("head_click_selector3", new jp6());
            this.e.put("user_head_click1", new rp6(3));
            Map<String, gb7> map = this.e;
            zo6 zo6Var = new zo6();
            zo6Var.b("1");
            map.put("user_head_click2", zo6Var);
            this.e.put("live_user_head_click", new lp6());
            Map<String, gb7> map2 = this.e;
            zo6 zo6Var2 = new zo6();
            zo6Var2.b("4");
            map2.put("video_click", zo6Var2);
            Map<String, gb7> map3 = this.e;
            zo6 zo6Var3 = new zo6();
            zo6Var3.b("5");
            map3.put("rich_text_at_click", zo6Var3);
            Map<String, gb7> map4 = this.e;
            zo6 zo6Var4 = new zo6();
            zo6Var4.b("6");
            map4.put("origin_card_click", zo6Var4);
            Map<String, gb7> map5 = this.e;
            zo6 zo6Var5 = new zo6();
            zo6Var5.b("8");
            map5.put("comment_btn_click", zo6Var5);
            this.e.put("enter_forum_btn_click", new gp6("2"));
            this.e.put("live_head_show", new mp6());
            this.e.put("rich_text_topic_click", new pp6());
            Map<String, gb7> map6 = this.e;
            op6 op6Var = new op6();
            op6Var.b("2");
            map6.put("rich_text_item_click", op6Var);
            this.e.put("rich_text_video_topic_click", new qp6());
            this.e.put("concern_reco_show", new ep6());
            this.e.put("concern_reco_click_head", new bp6());
            this.e.put("concern_reco_follow_btn", new cp6());
            this.e.put("concern_reco_unfollow_btn", new dp6());
            Map<String, gb7> map7 = this.e;
            sp6 sp6Var = new sp6();
            sp6Var.d("2");
            sp6Var.b("6");
            map7.put("virtual_head_show", sp6Var);
            Map<String, gb7> map8 = this.e;
            sp6 sp6Var2 = new sp6();
            sp6Var2.d("1");
            sp6Var2.b("6");
            map8.put("virtual_head_click", sp6Var2);
        }
    }
}
