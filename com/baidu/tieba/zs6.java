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
import com.baidu.tieba.hd7;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.message.ConcernPageHttpResMessage;
import com.baidu.tieba.homepage.concern.message.ConcernPageRequestMessage;
import com.baidu.tieba.homepage.concern.message.ConcernPageSocketResMessage;
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
public final class zs6 extends hd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public final Map<String, cd7> e;
    public final Map<String, String> f;
    public ConcernFragment g;
    public final NetMessageListener h;

    /* loaded from: classes9.dex */
    public static final class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zs6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(zs6 zs6Var) {
            super(CmdConfigHttp.CMD_CONCERN_PAGE, 309474);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zs6Var};
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
            this.a = zs6Var;
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
            hd7.a c;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            this.a.f(false);
            if (responsedMessage == null) {
                ConcernFragment n = this.a.n();
                if (n != null) {
                    wra.a(n, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "concern tab network data null"));
                    return;
                }
                return;
            }
            if (responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if ((extra instanceof ConcernPageRequestMessage) && ((ConcernPageRequestMessage) extra).getLoadType() == 1) {
                    z = true;
                    if (responsedMessage.getError() == 0) {
                        this.a.a().d = responsedMessage.getError();
                        this.a.a().e = responsedMessage.getErrorString();
                        ConcernFragment n2 = this.a.n();
                        if (n2 != null) {
                            wra.a(n2, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "concern tab network data wrong, error code: " + responsedMessage.getError() + " error msg " + responsedMessage.getErrorString()));
                        }
                    } else {
                        this.a.a().d = 0;
                        DataRes dataRes = null;
                        if (responsedMessage instanceof ConcernPageSocketResMessage) {
                            dataRes = ((ConcernPageSocketResMessage) responsedMessage).getResultData();
                        } else if (responsedMessage instanceof ConcernPageHttpResMessage) {
                            dataRes = ((ConcernPageHttpResMessage) responsedMessage).getResultData();
                        }
                        this.a.u(dataRes, z);
                    }
                    c = this.a.c();
                    if (c == null) {
                        c.a(this.a.a());
                        return;
                    }
                    return;
                }
            }
            z = false;
            if (responsedMessage.getError() == 0) {
            }
            c = this.a.c();
            if (c == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zs6(Context context) {
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
                        if (r(threadData)) {
                            hashMap.put(threadData.tid, threadData);
                        }
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final void y(ConcernFragment concernFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, concernFragment) == null) {
            this.g = concernFragment;
        }
    }

    public final void p(yc7<?> yc7Var, Map<String, ? extends ThreadData> map) {
        i87 i87Var;
        n87<?> n87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, yc7Var, map) == null) && (yc7Var instanceof i87) && (n87Var = (i87Var = (i87) yc7Var).c) != null) {
            String g = n87Var.g();
            if (!TextUtils.isEmpty(g)) {
                i87Var.c.j(map.get(g));
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
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    public final ConcernFragment n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (ConcernFragment) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return a().c;
        }
        return invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && !d()) {
            f(true);
            ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
            concernPageRequestMessage.setPageTag("0");
            concernPageRequestMessage.setLoadType(1);
            concernPageRequestMessage.setIsNewFeed(1);
            MessageManager.getInstance().sendMessage(concernPageRequestMessage);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !d()) {
            f(true);
            ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
            concernPageRequestMessage.setPageTag(this.d);
            concernPageRequestMessage.setLoadType(2);
            concernPageRequestMessage.setIsNewFeed(1);
            MessageManager.getInstance().sendMessage(concernPageRequestMessage);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_PAGE, hja.a(TbConfig.URL_CONCERN_PAGE, 309474));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernPageHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TbSocketMessageTask tbSocketMessageTask = new TbSocketMessageTask(309474);
            tbSocketMessageTask.setResponsedClass(ConcernPageSocketResMessage.class);
            tbSocketMessageTask.setNeedAck(true);
            MessageManager.getInstance().registerTask(tbSocketMessageTask);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Iterator<yc7<?>> it = a().a.iterator();
            while (it.hasNext()) {
                yc7<?> next = it.next();
                if (next != null && (next.b() instanceof d87)) {
                    Object b = next.b();
                    if (b != null) {
                        d97 h = ((d87) b).h();
                        if (h != null && Intrinsics.areEqual("recommend_user", h.getType())) {
                            it.remove();
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.component.uistate.RecommendCardUiState");
                    }
                }
            }
            hd7.a c = c();
            if (c != null) {
                c.a(a());
            }
        }
    }

    public final void q(Object data) {
        yc7<?> yc7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                ma7 ma7Var = p97.a().get("fake_wall");
                if (ma7Var != null) {
                    yc7Var = ma7Var.b(data);
                } else {
                    yc7Var = null;
                }
                int i = 0;
                for (yc7<?> yc7Var2 : a().a) {
                    if (!(yc7Var2.b() instanceof i67)) {
                        break;
                    }
                    Object b = yc7Var2.b();
                    if (b != null) {
                        if (!(((i67) b).a().a instanceof wp6)) {
                            break;
                        }
                        i++;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.feed.card.uistate.OtherTemplateUiState");
                    }
                }
                if (yc7Var != null) {
                    a().a.add(i, yc7Var);
                }
                hd7.a c = c();
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

    public final boolean z(String userId) {
        InterceptResult invokeL;
        hd7.a c;
        n87<?> n87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, userId)) == null) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Iterator<yc7<?>> it = a().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                yc7<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if ((next instanceof i87) && (n87Var = ((i87) next).c) != null && Intrinsics.areEqual(userId, n87Var.h())) {
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

    public final boolean r(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData)) == null) {
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

    public final void u(Message message, boolean z) {
        ma7 ma7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, message, z) == null) {
            boolean z2 = false;
            if (!(message instanceof DataRes)) {
                ConcernFragment concernFragment = this.g;
                if (concernFragment != null) {
                    wra.a(concernFragment, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "concern tab parse data wrong data type"));
                    return;
                }
                return;
            }
            if (z) {
                a().a.clear();
            }
            DataRes dataRes = (DataRes) message;
            PageData pageData = dataRes.page_data;
            if (pageData != null && !ListUtils.isEmpty(pageData.feed_list)) {
                Map<String, ThreadData> j = j(dataRes.thread_info);
                try {
                    for (LayoutFactory layoutFactory : ((DataRes) message).page_data.feed_list) {
                        if (layoutFactory != null) {
                            ma7 ma7Var2 = p97.a().get(layoutFactory.layout);
                            if (ma7Var2 != null) {
                                if (ma7Var2 instanceof bd7) {
                                    ((bd7) ma7Var2).d(this.e);
                                }
                                if (ma7Var2 instanceof cc7) {
                                    ((cc7) ma7Var2).a(this.f);
                                }
                                yc7<?> b = ma7Var2.b(layoutFactory);
                                p(b, j);
                                if (b != null) {
                                    a().a.add(b);
                                }
                            } else {
                                BdLog.e("no layout for " + layoutFactory.layout);
                            }
                        }
                    }
                    if (z && ((DataRes) message).user_follow_live != null && !ListUtils.isEmpty(((DataRes) message).user_follow_live.user_follow_live) && (ma7Var = p97.a().get("ala_live_attention")) != null) {
                        a().a.add(0, ma7Var.b(((DataRes) message).user_follow_live));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    ConcernFragment concernFragment2 = this.g;
                    if (concernFragment2 != null) {
                        wra.a(concernFragment2, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "concern tab parse data empty exception " + e.getMessage()));
                    }
                    if (GlobalBuildConfig.isDebug()) {
                        throw e;
                    }
                }
                a97 a2 = a();
                Integer num = dataRes.has_more;
                if (num != null && num.intValue() == 1) {
                    z2 = true;
                }
                a2.c = z2;
                this.d = dataRes.page_tag;
                if (a().a.size() > 1) {
                    cd7 cd7Var = this.e.get("concern_reco_show");
                    if (cd7Var instanceof ft6) {
                        ((ft6) cd7Var).b("1");
                        return;
                    }
                    return;
                }
                return;
            }
            ConcernFragment concernFragment3 = this.g;
            if (concernFragment3 != null) {
                wra.a(concernFragment3, new Pair(PushMessageHelper.ERROR_TYPE, "home_follow"), new Pair("error_info", "concern tab parse data empty list"));
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.e.put(PageInfo.KEY, new ot6());
            this.e.put("image_click", new lt6());
            this.e.put("head_click_selector1", new it6());
            this.e.put("head_click_selector2", new jt6());
            this.e.put("head_click_selector3", new kt6());
            this.e.put("user_head_click1", new st6(3));
            Map<String, cd7> map = this.e;
            at6 at6Var = new at6();
            at6Var.b("1");
            map.put("user_head_click2", at6Var);
            this.e.put("live_user_head_click", new mt6());
            Map<String, cd7> map2 = this.e;
            at6 at6Var2 = new at6();
            at6Var2.b("4");
            map2.put("video_click", at6Var2);
            Map<String, cd7> map3 = this.e;
            at6 at6Var3 = new at6();
            at6Var3.b("5");
            map3.put("rich_text_at_click", at6Var3);
            Map<String, cd7> map4 = this.e;
            at6 at6Var4 = new at6();
            at6Var4.b("6");
            map4.put("origin_card_click", at6Var4);
            Map<String, cd7> map5 = this.e;
            at6 at6Var5 = new at6();
            at6Var5.b("8");
            map5.put("comment_btn_click", at6Var5);
            this.e.put("enter_forum_btn_click", new ht6("2"));
            this.e.put("live_head_show", new nt6());
            this.e.put("rich_text_topic_click", new qt6());
            Map<String, cd7> map6 = this.e;
            pt6 pt6Var = new pt6();
            pt6Var.b("2");
            map6.put("rich_text_item_click", pt6Var);
            this.e.put("rich_text_video_topic_click", new rt6());
            this.e.put("concern_reco_show", new ft6());
            this.e.put("concern_reco_click_head", new ct6());
            this.e.put("concern_reco_follow_btn", new dt6());
            this.e.put("concern_reco_unfollow_btn", new et6());
            Map<String, cd7> map7 = this.e;
            tt6 tt6Var = new tt6();
            tt6Var.d("2");
            tt6Var.b("6");
            map7.put("virtual_head_show", tt6Var);
            Map<String, cd7> map8 = this.e;
            tt6 tt6Var2 = new tt6();
            tt6Var2.d("1");
            tt6Var2.b("6");
            map8.put("virtual_head_click", tt6Var2);
        }
    }
}
