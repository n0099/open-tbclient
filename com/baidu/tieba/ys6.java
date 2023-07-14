package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.concern.message.ConcernPageHttpResMessage;
import com.baidu.tieba.homepage.concern.message.ConcernPageRequestMessage;
import com.baidu.tieba.homepage.concern.message.ConcernPageSocketResMessage;
import com.baidu.tieba.vc7;
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
public final class ys6 extends vc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public final Map<String, qc7> e;
    public final Map<String, String> f;
    public final kb g;

    /* loaded from: classes8.dex */
    public static final class a extends kb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ys6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ys6 ys6Var) {
            super(CmdConfigHttp.CMD_CONCERN_PAGE, 309474);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys6Var};
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
            this.a = ys6Var;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
            if (((com.baidu.tieba.homepage.concern.message.ConcernPageRequestMessage) r0).getLoadType() == 1) goto L13;
         */
        @Override // com.baidu.tieba.kb
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
                this.a.s(dataRes, z);
            }
            vc7.a c = this.a.c();
            if (c != null) {
                c.a(this.a.a());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ys6(Context context) {
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
        t();
        u();
        MessageManager.getInstance().registerListener(this.g);
        v();
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
                        if (p(threadData)) {
                            hashMap.put(threadData.tid, threadData);
                        }
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final void n(mc7<?> mc7Var, Map<String, ? extends ThreadData> map) {
        z77 z77Var;
        e87<?> e87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, mc7Var, map) == null) && (mc7Var instanceof z77) && (e87Var = (z77Var = (z77) mc7Var).c) != null) {
            String g = e87Var.g();
            if (!TextUtils.isEmpty(g)) {
                z77Var.c.j(map.get(g));
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f.put("page_from", ImageViewerConfig.FROM_CONCERN);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return a().c;
        }
        return invokeV.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !d()) {
            f(true);
            ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
            concernPageRequestMessage.setPageTag("0");
            concernPageRequestMessage.setLoadType(1);
            concernPageRequestMessage.setIsNewFeed(1);
            MessageManager.getInstance().sendMessage(concernPageRequestMessage);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !d()) {
            f(true);
            ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
            concernPageRequestMessage.setPageTag(this.d);
            concernPageRequestMessage.setLoadType(2);
            concernPageRequestMessage.setIsNewFeed(1);
            MessageManager.getInstance().sendMessage(concernPageRequestMessage);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_PAGE, gca.a(TbConfig.URL_CONCERN_PAGE, 309474));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernPageHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            av5 av5Var = new av5(309474);
            av5Var.setResponsedClass(ConcernPageSocketResMessage.class);
            av5Var.g(true);
            MessageManager.getInstance().registerTask(av5Var);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Iterator<mc7<?>> it = a().a.iterator();
            while (it.hasNext()) {
                mc7<?> next = it.next();
                if (next != null && (next.b() instanceof u77)) {
                    Object b = next.b();
                    if (b != null) {
                        u87 h = ((u77) b).h();
                        if (h != null && Intrinsics.areEqual("recommend_user", h.getType())) {
                            it.remove();
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.component.uistate.RecommendCardUiState");
                    }
                }
            }
            vc7.a c = c();
            if (c != null) {
                c.a(a());
            }
        }
    }

    public final void o(Object data) {
        mc7<?> mc7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                ca7 ca7Var = g97.a().get("fake_wall");
                if (ca7Var != null) {
                    mc7Var = ca7Var.b(data);
                } else {
                    mc7Var = null;
                }
                int i = 0;
                for (mc7<?> mc7Var2 : a().a) {
                    if (!(mc7Var2.b() instanceof a67)) {
                        break;
                    }
                    Object b = mc7Var2.b();
                    if (b != null) {
                        if (!(((a67) b).a().a instanceof yp6)) {
                            break;
                        }
                        i++;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.card.uistate.OtherTemplateUiState");
                    }
                }
                if (mc7Var != null) {
                    a().a.add(i, mc7Var);
                }
                vc7.a c = c();
                if (c != null) {
                    c.a(a());
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (!s05.e()) {
                    return;
                }
                throw e;
            }
        }
    }

    public final boolean w(String userId) {
        InterceptResult invokeL;
        vc7.a c;
        e87<?> e87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, userId)) == null) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Iterator<mc7<?>> it = a().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                mc7<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if ((next instanceof z77) && (e87Var = ((z77) next).c) != null && Intrinsics.areEqual(userId, e87Var.h())) {
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

    public final boolean p(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, threadData)) == null) {
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

    public final void s(Message message, boolean z) {
        ca7 ca7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048585, this, message, z) != null) || !(message instanceof DataRes)) {
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
                        ca7 ca7Var2 = g97.a().get(layoutFactory.layout);
                        if (ca7Var2 != null) {
                            if (ca7Var2 instanceof pc7) {
                                ((pc7) ca7Var2).d(this.e);
                            }
                            if (ca7Var2 instanceof qb7) {
                                ((qb7) ca7Var2).a(this.f);
                            }
                            mc7<?> b = ca7Var2.b(layoutFactory);
                            n(b, j);
                            if (b != null) {
                                a().a.add(b);
                            }
                        } else {
                            BdLog.e("no layout for " + layoutFactory.layout);
                        }
                    }
                }
                if (z && ((DataRes) message).user_follow_live != null && !ListUtils.isEmpty(((DataRes) message).user_follow_live.user_follow_live) && (ca7Var = g97.a().get("ala_live_attention")) != null) {
                    a().a.add(0, ca7Var.b(((DataRes) message).user_follow_live));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (s05.e()) {
                    throw e;
                }
            }
            r87 a2 = a();
            Integer num = dataRes.has_more;
            if (num != null && num.intValue() == 1) {
                z2 = true;
            }
            a2.c = z2;
            this.d = dataRes.page_tag;
            if (a().a.size() > 1) {
                qc7 qc7Var = this.e.get("concern_reco_show");
                if (qc7Var instanceof et6) {
                    ((et6) qc7Var).b("1");
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e.put(PageInfo.KEY, new nt6());
            this.e.put("image_click", new kt6());
            this.e.put("head_click_selector1", new ht6());
            this.e.put("head_click_selector2", new it6());
            this.e.put("head_click_selector3", new jt6());
            this.e.put("user_head_click1", new rt6(3));
            Map<String, qc7> map = this.e;
            zs6 zs6Var = new zs6();
            zs6Var.b("1");
            map.put("user_head_click2", zs6Var);
            this.e.put("live_user_head_click", new lt6());
            Map<String, qc7> map2 = this.e;
            zs6 zs6Var2 = new zs6();
            zs6Var2.b("4");
            map2.put("video_click", zs6Var2);
            Map<String, qc7> map3 = this.e;
            zs6 zs6Var3 = new zs6();
            zs6Var3.b("5");
            map3.put("rich_text_at_click", zs6Var3);
            Map<String, qc7> map4 = this.e;
            zs6 zs6Var4 = new zs6();
            zs6Var4.b("6");
            map4.put("origin_card_click", zs6Var4);
            Map<String, qc7> map5 = this.e;
            zs6 zs6Var5 = new zs6();
            zs6Var5.b("8");
            map5.put("comment_btn_click", zs6Var5);
            this.e.put("enter_forum_btn_click", new gt6("2"));
            this.e.put("live_head_show", new mt6());
            this.e.put("rich_text_topic_click", new pt6());
            Map<String, qc7> map6 = this.e;
            ot6 ot6Var = new ot6();
            ot6Var.b("2");
            map6.put("rich_text_item_click", ot6Var);
            this.e.put("rich_text_video_topic_click", new qt6());
            this.e.put("concern_reco_show", new et6());
            this.e.put("concern_reco_click_head", new bt6());
            this.e.put("concern_reco_follow_btn", new ct6());
            this.e.put("concern_reco_unfollow_btn", new dt6());
            Map<String, qc7> map7 = this.e;
            st6 st6Var = new st6();
            st6Var.d("2");
            st6Var.b("6");
            map7.put("virtual_head_show", st6Var);
            Map<String, qc7> map8 = this.e;
            st6 st6Var2 = new st6();
            st6Var2.d("1");
            st6Var2.b("6");
            map8.put("virtual_head_click", st6Var2);
        }
    }
}
