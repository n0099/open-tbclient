package com.baidu.tieba;

import android.text.SpannableString;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.video.message.VideoTabHttpResMessage;
import com.baidu.tieba.homepage.video.message.VideoTabRequestMessage;
import com.baidu.tieba.homepage.video.message.VideoTabSocketResMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.RecomVideo.DataRes;
import tbclient.RecomVideo.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class lx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public f b;
    public List<in> c;
    public List<ThreadInfo> d;
    public List<ThreadPersonalized> e;
    public DataRes.Builder f;
    public boolean g;
    public boolean h;
    public za i;

    /* loaded from: classes5.dex */
    public interface f {
        void a(int i, boolean z, boolean z2);

        void b(int i, String str, boolean z);
    }

    /* loaded from: classes5.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lx7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lx7 lx7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lx7Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = lx7Var;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.g = false;
                this.a.h = false;
                if (responsedMessage != null) {
                    this.a.g(responsedMessage);
                } else if (this.a.b != null) {
                    this.a.b.b(-1, "", false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends vr5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(lx7 lx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vr5
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                t05.d();
                me<byte[]> c = t05.c("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
                if (c != null && (bArr = c.get(TbadkCoreApplication.getCurrentAccount())) != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException e) {
                        BdLog.e(e);
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements zq5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lx7 a;

        public c(lx7 lx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lx7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zq5
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) && dataRes != null) {
                this.a.f = new DataRes.Builder(dataRes);
                int count = ListUtils.getCount(dataRes.thread_list);
                if (count <= 0) {
                    return;
                }
                this.a.i(dataRes, false);
                if (this.a.b != null) {
                    this.a.b.a(count, false, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends cw5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qi6 j;
        public final /* synthetic */ ThreadData k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(lx7 lx7Var, int i, String str, qi6 qi6Var, ThreadData threadData) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lx7Var, Integer.valueOf(i), str, qi6Var, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = qi6Var;
            this.k = threadData;
        }

        @Override // com.baidu.tieba.cw5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                mx7.e(this.j);
                PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(view2.getContext(), d(), null);
                if (this.k.getThreadVideoInfo() != null) {
                    z = true;
                } else {
                    z = false;
                }
                personInfoActivityConfig.setIsVideoThread(z);
                personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_HOME);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends vr5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;

        public e(lx7 lx7Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lx7Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = builder;
        }

        @Override // com.baidu.tieba.vr5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                t05.d();
                try {
                    t05.c("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).g(TbadkCoreApplication.getCurrentAccount(), builder.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    public lx7(TbPageContext tbPageContext, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = true;
        this.i = new a(this, CmdConfigHttp.CMD_VIDEO_TAB, 309648);
        this.a = tbPageContext;
        this.b = fVar;
        this.c = new LinkedList();
        this.d = new LinkedList();
        this.e = new LinkedList();
        zn5 zn5Var = new zn5(309648);
        zn5Var.setResponsedClass(VideoTabSocketResMessage.class);
        zn5Var.g(true);
        MessageManager.getInstance().registerTask(zn5Var);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_TAB, xo9.a(TbConfig.URL_VIDEO_TAB, 309648));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(VideoTabHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void i(DataRes dataRes, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, dataRes, z) == null) {
            m(dataRes.thread_list, !z);
            n(dataRes.thread_personalized, !z);
            List<in> s = s();
            this.c = s;
            kx7.b(this.e, s);
        }
    }

    public final void v(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, builder) == null) {
            zr5.b(new e(this, builder), null);
        }
    }

    public final void g(ResponsedMessage<?> responsedMessage) {
        DataRes dataRes;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
            if (responsedMessage instanceof VideoTabSocketResMessage) {
                dataRes = ((VideoTabSocketResMessage) responsedMessage).mResultData;
            } else if (responsedMessage instanceof VideoTabHttpResMessage) {
                dataRes = ((VideoTabHttpResMessage) responsedMessage).mResultData;
            } else {
                dataRes = null;
            }
            if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof VideoTabRequestMessage) && ((VideoTabRequestMessage) responsedMessage.getOrginalMessage().getExtra()).load_type == 2) {
                z = true;
            } else {
                z = false;
            }
            if (dataRes != null && ListUtils.getCount(dataRes.thread_list) > 0) {
                i = ListUtils.getCount(dataRes.thread_list);
                i(dataRes, z);
                if (!ListUtils.isEmpty(dataRes.thread_list)) {
                    t(z);
                }
            } else {
                i = 0;
            }
            if (this.b != null) {
                if (responsedMessage.getError() != 0) {
                    this.b.b(responsedMessage.getError(), responsedMessage.getErrorString(), z);
                } else {
                    this.b.a(i, z, false);
                }
            }
        }
    }

    public List<in> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            zr5.b(new b(this), new c(this));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().registerListener(this.i);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.g) {
            return;
        }
        this.g = true;
        if (this.h) {
            k();
            this.h = false;
        }
        VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
        videoTabRequestMessage.new_net_type = BdNetTypeUtil.netType();
        videoTabRequestMessage.load_type = 1;
        videoTabRequestMessage.page_thread_count = 12;
        videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.a.sendMessage(videoTabRequestMessage);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.g) {
            return;
        }
        this.g = true;
        VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
        videoTabRequestMessage.new_net_type = BdNetTypeUtil.netType();
        videoTabRequestMessage.load_type = 2;
        videoTabRequestMessage.page_thread_count = 12;
        videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.a.sendMessage(videoTabRequestMessage);
    }

    public final void m(List<ThreadInfo> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048582, this, list, z) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.d);
            this.d.clear();
            this.d.addAll(linkedList);
            return;
        }
        this.d.addAll(list);
    }

    public final void n(List<ThreadPersonalized> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048583, this, list, z) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.e);
            this.e.clear();
            this.e.addAll(linkedList);
            return;
        }
        this.e.addAll(list);
    }

    public void q(String str) {
        DataRes.Builder builder;
        Long l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && (builder = this.f) != null && !ListUtils.isEmpty(builder.thread_list)) {
            long g = gg.g(str, 0L);
            for (int i = 0; i < this.f.thread_list.size(); i++) {
                ThreadInfo threadInfo = this.f.thread_list.get(i);
                if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == g) {
                    this.f.thread_list.remove(i);
                    v(this.f);
                    return;
                }
            }
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, str) != null) || ListUtils.isEmpty(this.c)) {
            return;
        }
        Iterator<in> it = this.c.iterator();
        while (it.hasNext()) {
            in next = it.next();
            if (next instanceof qi6) {
                qi6 qi6Var = (qi6) next;
                if (qi6Var.getThreadData() != null && qi6Var.getThreadData().getTid() != null && qi6Var.getThreadData().getTid().equals(str)) {
                    it.remove();
                }
            }
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            DataRes.Builder builder = new DataRes.Builder();
            if (ListUtils.getCount(this.d) >= 12) {
                if (z) {
                    List<ThreadInfo> list = this.d;
                    builder.thread_list = list.subList(list.size() - 12, this.d.size());
                    u(builder, true);
                } else {
                    builder.thread_list = this.d.subList(0, 12);
                    u(builder, false);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.d);
                builder.thread_list = arrayList;
                u(builder, false);
            }
            this.f = builder;
            v(builder);
        }
    }

    public final List<in> s() {
        InterceptResult invokeV;
        yi6 g;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            LinkedList linkedList = new LinkedList();
            if (ListUtils.isEmpty(this.d)) {
                return linkedList;
            }
            char c2 = 0;
            int i = 0;
            for (ThreadInfo threadInfo : this.d) {
                ThreadData threadData2 = new ThreadData();
                threadData2.parserProtobuf(threadInfo);
                threadData2.isFromVideoTab = true;
                if (zi6.N(threadData2)) {
                    yi6 g2 = cu7.g(threadData2);
                    if (g2 != null && (threadData = g2.a) != null && threadData.getForumData() != null && !StringUtils.isNull(g2.a.getForumData().b) && !g2.a.isWorksInfo()) {
                        g2.g = threadData2.getTid();
                        g2.position = i;
                        cu7.r(g2);
                        linkedList.add(g2);
                    } else {
                        yi6 g3 = cu7.g(threadData2);
                        if (g3 != null) {
                            g3.g = threadData2.getTid();
                            g3.position = i;
                            cu7.t(g3);
                        }
                        if (g3 != null && g3.isValid()) {
                            linkedList.add(g3);
                        }
                    }
                    int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                    qi6 e2 = cu7.e(threadData2);
                    if (e2 != null) {
                        e2.g = threadData2.getTid();
                        e2.position = i;
                        if (e2 instanceof yi6) {
                            if (threadData2.isBJHNormalThreadType()) {
                                cu7.u(e2);
                            } else if (threadData2.picCount() == 1) {
                                cu7.w(e2);
                                e2.j = imageWidthAndHeight[c2];
                                e2.k = imageWidthAndHeight[1];
                            } else if (threadData2.picCount() >= 2) {
                                cu7.v(e2);
                            } else {
                                cu7.x(e2);
                            }
                        } else if (e2 instanceof zi6) {
                            cu7.y(e2);
                        }
                    }
                    if (e2 != null && e2.isValid()) {
                        if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null && threadData2.getForumData() != null && !StringUtils.isNull(threadData2.getForumData().b)) {
                            String string = TbadkCoreApplication.getInst().getString(R.string.at_username);
                            Object[] objArr = new Object[1];
                            objArr[c2] = threadData2.getAuthor().getName_show();
                            String format = String.format(string, objArr);
                            SpannableString spannableString = new SpannableString(format);
                            spannableString.setSpan(new d(this, 16, threadData2.getAuthor().getUserId(), e2, threadData2), 0, format.length() - 1, 33);
                            e2.a.insertUsernameIntoTitleOrAbstract(spannableString);
                        }
                        linkedList.add(e2);
                    }
                    if (threadData2.showCardEnterFourm() && (g = cu7.g(threadData2)) != null) {
                        g.g = threadData2.getTid();
                        g.position = i;
                        cu7.q(g);
                        if (yi6.W(threadData2)) {
                            g.E("1");
                        } else if (zi6.N(threadData2)) {
                            g.E("2");
                        }
                        if (threadData2.showCardEnterFourm() && !StringUtils.isNull(threadData2.getForum_name())) {
                            linkedList.add(g);
                        } else if (!StringUtils.isNull(threadData2.getForum_name())) {
                            linkedList.add(g);
                        }
                    }
                    if (threadInfo.top_agree_post != null) {
                        yi6 g4 = cu7.g(threadData2);
                        if (g4 != null) {
                            g4.g = threadData2.getTid();
                            g4.position = i;
                            cu7.s(g4);
                        }
                        if (g4 != null && g4.isValid()) {
                            linkedList.add(g4);
                        }
                    }
                    yi6 g5 = cu7.g(threadData2);
                    if (g5 != null) {
                        g5.g = threadData2.getTid();
                        g5.position = i;
                        cu7.p(g5);
                    }
                    if (g5 != null && g5.isValid()) {
                        linkedList.add(g5);
                    }
                    i++;
                }
                c2 = 0;
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final void u(DataRes.Builder builder, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048590, this, builder, z) != null) || builder == null) {
            return;
        }
        if (ListUtils.getCount(this.e) >= 12) {
            if (z) {
                List<ThreadPersonalized> list = this.e;
                builder.thread_personalized = list.subList(list.size() - 12, this.e.size());
                return;
            }
            builder.thread_personalized = this.e.subList(0, 12);
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.e);
        builder.thread_personalized = linkedList;
    }
}
