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
import com.baidu.tieba.homepage.concern.message.ConcernPageHttpResMessage;
import com.baidu.tieba.homepage.concern.message.ConcernPageRequestMessage;
import com.baidu.tieba.homepage.concern.message.ConcernPageSocketResMessage;
import com.baidu.tieba.yc7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tbclient.LayoutFactory;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
import tbclient.Userlike.PageData;
/* loaded from: classes8.dex */
public final class ts6 extends yc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public final Map<String, tc7> e;
    public final Map<String, String> f;
    public final NetMessageListener g;

    /* loaded from: classes8.dex */
    public static final class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ts6 ts6Var) {
            super(CmdConfigHttp.CMD_CONCERN_PAGE, 309474);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts6Var};
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
            this.a = ts6Var;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
            if (((com.baidu.tieba.homepage.concern.message.ConcernPageRequestMessage) r0).getLoadType() == 1) goto L13;
         */
        @Override // com.baidu.adp.framework.listener.NetMessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            this.a.f(false);
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof ConcernPageRequestMessage) {
                    z = true;
                }
            }
            z = false;
            if (responsedMessage.getError() != 0) {
                this.a.a().d = responsedMessage.getError();
                this.a.a().e = responsedMessage.getErrorString();
            } else {
                this.a.a().d = 0;
                DataRes dataRes = null;
                if (responsedMessage instanceof ConcernPageSocketResMessage) {
                    dataRes = ((ConcernPageSocketResMessage) responsedMessage).getResultData();
                } else if (responsedMessage instanceof ConcernPageHttpResMessage) {
                    dataRes = ((ConcernPageHttpResMessage) responsedMessage).getResultData();
                }
                this.a.t(dataRes, z);
            }
            yc7.a c = this.a.c();
            if (c != null) {
                c.a(this.a.a());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ts6(Context context) {
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
        this.g = new a(this);
        u();
        v();
        MessageManager.getInstance().registerListener(this.g);
        w();
        k();
    }

    public final Map<String, ThreadData> j(List<ConcernData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            HashMap hashMap = new HashMap();
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && list != null) {
                for (ConcernData concernData : list) {
                    if (concernData.thread_list != null) {
                        ThreadData threadData = new ThreadData();
                        threadData.setFromConcern(true);
                        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                        threadData.parserProtobuf(concernData.thread_list);
                        if (q(threadData)) {
                            hashMap.put(threadData.tid, threadData);
                        }
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final void o(pc7<?> pc7Var, Map<String, ? extends ThreadData> map) {
        b87 b87Var;
        g87<?> g87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, pc7Var, map) == null) && (pc7Var instanceof b87) && (g87Var = (b87Var = (b87) pc7Var).c) != null) {
            String g = g87Var.g();
            if (!TextUtils.isEmpty(g)) {
                b87Var.c.j(map.get(g));
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f.put("page_from", ImageViewerConfig.FROM_CONCERN);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.g);
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return a().c;
        }
        return invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !d()) {
            f(true);
            ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
            concernPageRequestMessage.setPageTag("0");
            concernPageRequestMessage.setLoadType(1);
            concernPageRequestMessage.setIsNewFeed(1);
            MessageManager.getInstance().sendMessage(concernPageRequestMessage);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && !d()) {
            f(true);
            ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
            concernPageRequestMessage.setPageTag(this.d);
            concernPageRequestMessage.setLoadType(2);
            concernPageRequestMessage.setIsNewFeed(1);
            MessageManager.getInstance().sendMessage(concernPageRequestMessage);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_PAGE, bha.a(TbConfig.URL_CONCERN_PAGE, 309474));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernPageHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            TbSocketMessageTask tbSocketMessageTask = new TbSocketMessageTask(309474);
            tbSocketMessageTask.setResponsedClass(ConcernPageSocketResMessage.class);
            tbSocketMessageTask.setNeedAck(true);
            MessageManager.getInstance().registerTask(tbSocketMessageTask);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Iterator<pc7<?>> it = a().a.iterator();
            while (it.hasNext()) {
                pc7<?> next = it.next();
                if (next != null && (next.b() instanceof w77)) {
                    Object b = next.b();
                    if (b != null) {
                        w87 h = ((w77) b).h();
                        if (h != null && Intrinsics.areEqual("recommend_user", h.getType())) {
                            it.remove();
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.component.uistate.RecommendCardUiState");
                    }
                }
            }
            yc7.a c = c();
            if (c != null) {
                c.a(a());
            }
        }
    }

    public final void p(Object data) {
        pc7<?> pc7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                ea7 ea7Var = i97.a().get("fake_wall");
                if (ea7Var != null) {
                    pc7Var = ea7Var.b(data);
                } else {
                    pc7Var = null;
                }
                int i = 0;
                for (pc7<?> pc7Var2 : a().a) {
                    if (!(pc7Var2.b() instanceof b67)) {
                        break;
                    }
                    Object b = pc7Var2.b();
                    if (b != null) {
                        if (!(((b67) b).a().a instanceof qp6)) {
                            break;
                        }
                        i++;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.card.uistate.OtherTemplateUiState");
                    }
                }
                if (pc7Var != null) {
                    a().a.add(i, pc7Var);
                }
                yc7.a c = c();
                if (c != null) {
                    c.a(a());
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

    public final boolean x(String userId) {
        InterceptResult invokeL;
        yc7.a c;
        g87<?> g87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, userId)) == null) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Iterator<pc7<?>> it = a().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                pc7<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if ((next instanceof b87) && (g87Var = ((b87) next).c) != null && Intrinsics.areEqual(userId, g87Var.h())) {
                    it.remove();
                    z = true;
                }
            }
            if (z && (c = c()) != null) {
                c.a(a());
            }
            if (z && a().a.size() < 9) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean q(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, threadData)) == null) {
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
        ea7 ea7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048586, this, message, z) != null) || !(message instanceof DataRes)) {
            return;
        }
        if (z) {
            a().a.clear();
        }
        DataRes dataRes = (DataRes) message;
        PageData pageData = dataRes.page_data;
        if (pageData != null && !ListUtils.isEmpty(pageData.feed_list)) {
            Map<String, ThreadData> j = j(dataRes.thread_info);
            boolean z2 = false;
            try {
                for (LayoutFactory layoutFactory : ((DataRes) message).page_data.feed_list) {
                    if (layoutFactory != null) {
                        ea7 ea7Var2 = i97.a().get(layoutFactory.layout);
                        if (ea7Var2 != null) {
                            if (ea7Var2 instanceof sc7) {
                                ((sc7) ea7Var2).d(this.e);
                            }
                            if (ea7Var2 instanceof tb7) {
                                ((tb7) ea7Var2).a(this.f);
                            }
                            pc7<?> b = ea7Var2.b(layoutFactory);
                            o(b, j);
                            if (b != null) {
                                a().a.add(b);
                            }
                        } else {
                            BdLog.e("no layout for " + layoutFactory.layout);
                        }
                    }
                }
                if (z && ((DataRes) message).user_follow_live != null && !ListUtils.isEmpty(((DataRes) message).user_follow_live.user_follow_live) && (ea7Var = i97.a().get("ala_live_attention")) != null) {
                    a().a.add(0, ea7Var.b(((DataRes) message).user_follow_live));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (GlobalBuildConfig.isDebug()) {
                    throw e;
                }
            }
            t87 a2 = a();
            Integer num = dataRes.has_more;
            if (num != null && num.intValue() == 1) {
                z2 = true;
            }
            a2.c = z2;
            this.d = dataRes.page_tag;
            if (a().a.size() > 1) {
                tc7 tc7Var = this.e.get("concern_reco_show");
                if (tc7Var instanceof zs6) {
                    ((zs6) tc7Var).b("1");
                }
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e.put(PageInfo.KEY, new it6());
            this.e.put("image_click", new ft6());
            this.e.put("head_click_selector1", new ct6());
            this.e.put("head_click_selector2", new dt6());
            this.e.put("head_click_selector3", new et6());
            this.e.put("user_head_click1", new mt6(3));
            Map<String, tc7> map = this.e;
            us6 us6Var = new us6();
            us6Var.b("1");
            map.put("user_head_click2", us6Var);
            this.e.put("live_user_head_click", new gt6());
            Map<String, tc7> map2 = this.e;
            us6 us6Var2 = new us6();
            us6Var2.b("4");
            map2.put("video_click", us6Var2);
            Map<String, tc7> map3 = this.e;
            us6 us6Var3 = new us6();
            us6Var3.b("5");
            map3.put("rich_text_at_click", us6Var3);
            Map<String, tc7> map4 = this.e;
            us6 us6Var4 = new us6();
            us6Var4.b("6");
            map4.put("origin_card_click", us6Var4);
            Map<String, tc7> map5 = this.e;
            us6 us6Var5 = new us6();
            us6Var5.b("8");
            map5.put("comment_btn_click", us6Var5);
            this.e.put("enter_forum_btn_click", new bt6("2"));
            this.e.put("live_head_show", new ht6());
            this.e.put("rich_text_topic_click", new kt6());
            Map<String, tc7> map6 = this.e;
            jt6 jt6Var = new jt6();
            jt6Var.b("2");
            map6.put("rich_text_item_click", jt6Var);
            this.e.put("rich_text_video_topic_click", new lt6());
            this.e.put("concern_reco_show", new zs6());
            this.e.put("concern_reco_click_head", new ws6());
            this.e.put("concern_reco_follow_btn", new xs6());
            this.e.put("concern_reco_unfollow_btn", new ys6());
            Map<String, tc7> map7 = this.e;
            nt6 nt6Var = new nt6();
            nt6Var.d("2");
            nt6Var.b("6");
            map7.put("virtual_head_show", nt6Var);
            Map<String, tc7> map8 = this.e;
            nt6 nt6Var2 = new nt6();
            nt6Var2.d("1");
            nt6Var2.b("6");
            map8.put("virtual_head_click", nt6Var2);
        }
    }
}
