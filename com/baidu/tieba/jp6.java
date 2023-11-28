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
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.message.ConcernPageHttpResMessage;
import com.baidu.tieba.homepage.concern.message.ConcernPageRequestMessage;
import com.baidu.tieba.tracker.ext.FragmentExtKt;
import com.baidu.tieba.zb7;
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
/* loaded from: classes6.dex */
public final class jp6 extends zb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public final Map<String, ub7> e;
    public final Map<String, String> f;
    public ConcernFragment g;
    public final NetMessageListener h;

    /* loaded from: classes6.dex */
    public static final class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jp6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(jp6 jp6Var) {
            super(CmdConfigHttp.CMD_CONCERN_PAGE, 309474);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jp6Var};
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
            this.a = jp6Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00ca  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.adp.framework.listener.NetMessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            zb7.a d;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.i(false);
                if (responsedMessage == null) {
                    ConcernFragment o = this.a.o();
                    if (o != null) {
                        FragmentExtKt.a(o, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "concern tab network data null"));
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
                                FragmentExtKt.a(o2, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "concern tab network data wrong, error code: " + responsedMessage.getError() + " error msg " + responsedMessage.getErrorString()));
                            }
                        } else {
                            this.a.b().d = 0;
                            DataRes dataRes = null;
                            if (responsedMessage instanceof ConcernPageHttpResMessage) {
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
    public jp6(Context context) {
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
        MessageManager.getInstance().registerListener(this.h);
        w();
        m();
        u();
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

    public final void x(ConcernFragment concernFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, concernFragment) == null) {
            this.g = concernFragment;
        }
    }

    @Override // com.baidu.tieba.zb7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    @Override // com.baidu.tieba.zb7
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

    @Override // com.baidu.tieba.zb7
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
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_PAGE, wva.a(TbConfig.URL_CONCERN_PAGE, 309474));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernPageHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Iterator<nb7<?>> it = b().a.iterator();
            while (it.hasNext()) {
                nb7<?> next = it.next();
                if (next != null && (next.b() instanceof d57)) {
                    Object b = next.b();
                    if (b != null) {
                        p67 l = ((d57) b).l();
                        if (l != null && Intrinsics.areEqual("recommend_user", l.d())) {
                            it.remove();
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.component.uistate.RecommendCardUiState");
                    }
                }
            }
            zb7.a d = d();
            if (d != null) {
                d.a(b());
            }
        }
    }

    public final void q(nb7<?> nb7Var, Map<String, ? extends ThreadData> map) {
        j57 j57Var;
        s57<?> s57Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nb7Var, map) == null) && (nb7Var instanceof j57) && (s57Var = (j57Var = (j57) nb7Var).c) != null) {
            String m = s57Var.m();
            if (!TextUtils.isEmpty(m)) {
                j57Var.c.s(map.get(m));
            }
        }
    }

    public final void r(Object data) {
        nb7<?> nb7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                w87 w87Var = f77.a().get("fake_wall");
                if (w87Var != null) {
                    nb7Var = w87Var.b(data);
                } else {
                    nb7Var = null;
                }
                int i = 0;
                for (nb7<?> nb7Var2 : b().a) {
                    if (!(nb7Var2.b() instanceof e37)) {
                        break;
                    }
                    Object b = nb7Var2.b();
                    if (b != null) {
                        if (!(((e37) b).a().a instanceof mm6)) {
                            break;
                        }
                        i++;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.card.uistate.OtherTemplateUiState");
                    }
                }
                if (nb7Var != null) {
                    b().a.add(i, nb7Var);
                }
                zb7.a d = d();
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

    public final boolean y(String userId) {
        InterceptResult invokeL;
        zb7.a d;
        s57<?> s57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, userId)) == null) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Iterator<nb7<?>> it = b().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                nb7<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if ((next instanceof j57) && (s57Var = ((j57) next).c) != null && Intrinsics.areEqual(userId, s57Var.n())) {
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
        w87 w87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, message, z) == null) {
            boolean z2 = false;
            if (!(message instanceof DataRes)) {
                ConcernFragment concernFragment = this.g;
                if (concernFragment != null) {
                    FragmentExtKt.a(concernFragment, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "concern tab parse data wrong data type"));
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
                            w87 w87Var2 = f77.a().get(layoutFactory.layout);
                            if (w87Var2 instanceof q87) {
                                ((q87) w87Var2).j();
                            }
                            if (w87Var2 != null) {
                                if (w87Var2 instanceof tb7) {
                                    ((tb7) w87Var2).d(this.e);
                                }
                                if (w87Var2 instanceof qa7) {
                                    ((qa7) w87Var2).a(this.f);
                                }
                                nb7<?> b = w87Var2.b(layoutFactory);
                                q(b, l);
                                if (b != null) {
                                    b().a.add(b);
                                }
                            } else {
                                BdLog.e("no layout for " + layoutFactory.layout);
                            }
                        }
                    }
                    if (z && ((DataRes) message).user_follow_live != null && !ListUtils.isEmpty(((DataRes) message).user_follow_live.user_follow_live) && (w87Var = f77.a().get("ala_live_attention")) != null) {
                        b().a.add(0, w87Var.b(((DataRes) message).user_follow_live));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    ConcernFragment concernFragment2 = this.g;
                    if (concernFragment2 != null) {
                        FragmentExtKt.a(concernFragment2, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "concern tab parse data empty exception " + e.getMessage()));
                    }
                    if (GlobalBuildConfig.isDebug()) {
                        throw e;
                    }
                }
                m67 b2 = b();
                Integer num = dataRes.has_more;
                if (num != null && num.intValue() == 1) {
                    z2 = true;
                }
                b2.c = z2;
                this.d = dataRes.page_tag;
                if (b().a.size() > 1) {
                    ub7 ub7Var = this.e.get("concern_reco_show");
                    if (ub7Var instanceof pp6) {
                        ((pp6) ub7Var).b("1");
                        return;
                    }
                    return;
                }
                return;
            }
            ConcernFragment concernFragment3 = this.g;
            if (concernFragment3 != null) {
                FragmentExtKt.a(concernFragment3, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "concern tab parse data empty list"));
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            HashMap<String, w87> a2 = f77.a();
            Intrinsics.checkNotNullExpressionValue(a2, "getItemDataMap()");
            a2.put("ala_live_attention", new gp6());
            HashMap<String, w87> a3 = f77.a();
            Intrinsics.checkNotNullExpressionValue(a3, "getItemDataMap()");
            a3.put("fake_wall", new hp6());
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.e.put(PageInfo.KEY, new yp6());
            this.e.put("image_click", new vp6());
            this.e.put("head_click_selector1", new sp6());
            this.e.put("head_click_selector2", new tp6());
            this.e.put("head_click_selector3", new up6());
            this.e.put("user_head_click1", new cq6(3));
            Map<String, ub7> map = this.e;
            kp6 kp6Var = new kp6();
            kp6Var.b("1");
            map.put("user_head_click2", kp6Var);
            this.e.put("live_user_head_click", new wp6());
            Map<String, ub7> map2 = this.e;
            kp6 kp6Var2 = new kp6();
            kp6Var2.b("4");
            map2.put("video_click", kp6Var2);
            Map<String, ub7> map3 = this.e;
            kp6 kp6Var3 = new kp6();
            kp6Var3.b("5");
            map3.put("rich_text_at_click", kp6Var3);
            Map<String, ub7> map4 = this.e;
            kp6 kp6Var4 = new kp6();
            kp6Var4.b("6");
            map4.put("origin_card_click", kp6Var4);
            Map<String, ub7> map5 = this.e;
            kp6 kp6Var5 = new kp6();
            kp6Var5.b("8");
            map5.put("comment_btn_click", kp6Var5);
            this.e.put("enter_forum_btn_click", new rp6("2"));
            this.e.put("live_head_show", new xp6());
            this.e.put("rich_text_topic_click", new aq6());
            Map<String, ub7> map6 = this.e;
            zp6 zp6Var = new zp6();
            zp6Var.b("2");
            map6.put("rich_text_item_click", zp6Var);
            this.e.put("rich_text_video_topic_click", new bq6());
            this.e.put("concern_reco_show", new pp6());
            this.e.put("concern_reco_click_head", new mp6());
            this.e.put("concern_reco_follow_btn", new np6());
            this.e.put("concern_reco_unfollow_btn", new op6());
            Map<String, ub7> map7 = this.e;
            dq6 dq6Var = new dq6();
            dq6Var.d("2");
            dq6Var.b("6");
            map7.put("virtual_head_show", dq6Var);
            Map<String, ub7> map8 = this.e;
            dq6 dq6Var2 = new dq6();
            dq6Var2.d("1");
            dq6Var2.b("6");
            map8.put("virtual_head_click", dq6Var2);
        }
    }
}
