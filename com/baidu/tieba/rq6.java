package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.baidu.tieba.v87;
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
import tbclient.LayoutFactory;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
import tbclient.Userlike.PageData;
/* loaded from: classes7.dex */
public class rq6 extends v87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p57 c;
    public String d;
    public final Map<String, r87> e;
    public Map<String, String> f;
    public boolean g;
    public jb h;

    /* loaded from: classes7.dex */
    public class a extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rq6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rq6 rq6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rq6Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rq6Var;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
            if (((com.baidu.tieba.homepage.concern.message.ConcernPageRequestMessage) r0).getLoadType() == 1) goto L13;
         */
        @Override // com.baidu.tieba.jb
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.g = false;
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
                    this.a.c.c = responsedMessage.getError();
                    this.a.c.d = responsedMessage.getErrorString();
                } else {
                    this.a.c.c = 0;
                    DataRes dataRes = null;
                    if (responsedMessage instanceof ConcernPageSocketResMessage) {
                        dataRes = ((ConcernPageSocketResMessage) responsedMessage).getResultData();
                    } else if (responsedMessage instanceof ConcernPageHttpResMessage) {
                        dataRes = ((ConcernPageHttpResMessage) responsedMessage).getResultData();
                    }
                    this.a.p(dataRes, z);
                }
                if (this.a.b != null) {
                    this.a.b.a(this.a.c);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rq6(Context context) {
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
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = false;
        this.h = new a(this, CmdConfigHttp.CMD_CONCERN_PAGE, 309474);
        this.c = new p57();
        q();
        r();
        MessageManager.getInstance().registerListener(this.h);
        s();
        m();
    }

    @Override // com.baidu.tieba.v87
    public void c(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            try {
                o87<?> b = v57.a().get("fake_wall").b(obj);
                int i = 0;
                for (o87<?> o87Var : this.c.a) {
                    if (!(o87Var.b() instanceof m37) || !(((m37) o87Var.b()).a().a instanceof po6)) {
                        break;
                    }
                    i++;
                }
                this.c.a.add(i, b);
                if (this.b != null) {
                    this.b.a(this.c);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (!g05.e()) {
                    return;
                }
                throw e;
            }
        }
    }

    public final void n(@Nullable o87<?> o87Var, @NonNull Map<String, ThreadData> map) {
        a57 a57Var;
        e57<?> e57Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, o87Var, map) == null) && (o87Var instanceof a57) && (e57Var = (a57Var = (a57) o87Var).c) != null) {
            String e = e57Var.e();
            if (!TextUtils.isEmpty(e)) {
                a57Var.c.h(map.get(e));
            }
        }
    }

    public static boolean o(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, threadData)) == null) {
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

    @Override // com.baidu.tieba.v87
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<o87<?>> it = this.c.a.iterator();
            while (it.hasNext()) {
                o87<?> next = it.next();
                if (next != null && (next.b() instanceof v47)) {
                    v47 v47Var = (v47) next.b();
                    if (v47Var.d() != null && "recommend_user".equals(v47Var.d().getType())) {
                        it.remove();
                    }
                }
            }
            v87.a aVar = this.b;
            if (aVar != null) {
                aVar.a(this.c);
            }
        }
    }

    @Override // com.baidu.tieba.v87
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c.b;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v87
    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.g) {
            this.g = true;
            ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
            concernPageRequestMessage.setPageTag("0");
            concernPageRequestMessage.setLoadType(1);
            concernPageRequestMessage.setIsNewFeed(1);
            MessageManager.getInstance().sendMessage(concernPageRequestMessage);
        }
    }

    @Override // com.baidu.tieba.v87
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !this.g) {
            this.g = true;
            ConcernPageRequestMessage concernPageRequestMessage = new ConcernPageRequestMessage();
            concernPageRequestMessage.setPageTag(this.d);
            concernPageRequestMessage.setLoadType(2);
            concernPageRequestMessage.setIsNewFeed(1);
            MessageManager.getInstance().sendMessage(concernPageRequestMessage);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f.put("page_from", ImageViewerConfig.FROM_CONCERN);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_PAGE, jz9.a(TbConfig.URL_CONCERN_PAGE, 309474));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernPageHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            rt5 rt5Var = new rt5(309474);
            rt5Var.setResponsedClass(ConcernPageSocketResMessage.class);
            rt5Var.g(true);
            MessageManager.getInstance().registerTask(rt5Var);
        }
    }

    @Override // com.baidu.tieba.v87
    public boolean g(@NonNull String str) {
        InterceptResult invokeL;
        e57<?> e57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Iterator<o87<?>> it = this.c.a.iterator();
            while (it.hasNext()) {
                o87<?> next = it.next();
                if ((next instanceof a57) && (e57Var = ((a57) next).c) != null && str.equals(e57Var.f())) {
                    it.remove();
                }
            }
            v87.a aVar = this.b;
            if (aVar != null) {
                aVar.a(this.c);
            }
            if (this.c.a.size() < 9) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public final Map<String, ThreadData> l(@Nullable List<ConcernData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            HashMap hashMap = new HashMap();
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && list != null) {
                for (ConcernData concernData : list) {
                    if (concernData.thread_list != null) {
                        ThreadData threadData = new ThreadData();
                        threadData.setFromConcern(true);
                        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                        threadData.parserProtobuf(concernData.thread_list);
                        if (o(threadData)) {
                            hashMap.put(threadData.tid, threadData);
                        }
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final void p(Message message, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048585, this, message, z) != null) || !(message instanceof DataRes)) {
            return;
        }
        if (z) {
            this.c.a.clear();
        }
        DataRes dataRes = (DataRes) message;
        PageData pageData = dataRes.page_data;
        if (pageData != null && !ListUtils.isEmpty(pageData.feed_list)) {
            Map<String, ThreadData> l = l(dataRes.thread_info);
            boolean z2 = false;
            try {
                for (LayoutFactory layoutFactory : dataRes.page_data.feed_list) {
                    if (layoutFactory != null) {
                        m67 m67Var = v57.a().get(layoutFactory.layout);
                        if (m67Var != null) {
                            if (m67Var instanceof q87) {
                                ((q87) m67Var).c(this.e);
                            }
                            if (m67Var instanceof u77) {
                                ((u77) m67Var).a(this.f);
                            }
                            o87<?> b = m67Var.b(layoutFactory);
                            n(b, l);
                            if (b != null) {
                                this.c.a.add(b);
                            }
                        } else {
                            BdLog.e("no layout for " + layoutFactory.layout);
                        }
                    }
                }
                if (z && dataRes.user_follow_live != null && !ListUtils.isEmpty(dataRes.user_follow_live.user_follow_live)) {
                    this.c.a.add(0, v57.a().get("ala_live_attention").b(dataRes.user_follow_live));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (g05.e()) {
                    throw e;
                }
            }
            p57 p57Var = this.c;
            if (dataRes.has_more.intValue() == 1) {
                z2 = true;
            }
            p57Var.b = z2;
            this.d = dataRes.page_tag;
            if (this.c.a.size() > 1) {
                r87 r87Var = this.e.get("concern_reco_show");
                if (r87Var instanceof xq6) {
                    ((xq6) r87Var).b("1");
                }
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e.put(PageInfo.KEY, new dr6());
            this.e.put("image_click", new ar6());
            Map<String, r87> map = this.e;
            sq6 sq6Var = new sq6();
            sq6Var.b("1");
            map.put("user_info_click2", sq6Var);
            Map<String, r87> map2 = this.e;
            sq6 sq6Var2 = new sq6();
            sq6Var2.b("4");
            map2.put("video_click", sq6Var2);
            Map<String, r87> map3 = this.e;
            sq6 sq6Var3 = new sq6();
            sq6Var3.b("5");
            map3.put("rich_text_at_click", sq6Var3);
            Map<String, r87> map4 = this.e;
            sq6 sq6Var4 = new sq6();
            sq6Var4.b("6");
            map4.put("origin_card_click", sq6Var4);
            Map<String, r87> map5 = this.e;
            sq6 sq6Var5 = new sq6();
            sq6Var5.b("8");
            map5.put("comment_btn_click", sq6Var5);
            this.e.put("enter_forum_btn_click", new zq6());
            this.e.put("live_head_show", new cr6());
            this.e.put("live_head_click", new br6());
            this.e.put("user_info_click", new hr6());
            this.e.put("rich_text_topic_click", new fr6());
            this.e.put("rich_text_item_click", new er6());
            this.e.put("rich_text_video_topic_click", new gr6());
            this.e.put("concern_reco_show", new xq6());
            this.e.put("concern_reco_click_head", new uq6());
            this.e.put("concern_reco_follow_btn", new vq6());
            this.e.put("concern_reco_unfollow_btn", new wq6());
            Map<String, r87> map6 = this.e;
            ir6 ir6Var = new ir6();
            ir6Var.c("2");
            ir6Var.b("6");
            map6.put("virtual_head_show", ir6Var);
            Map<String, r87> map7 = this.e;
            ir6 ir6Var2 = new ir6();
            ir6Var2.c("1");
            ir6Var2.b("6");
            map7.put("virtual_head_click", ir6Var2);
        }
    }
}
