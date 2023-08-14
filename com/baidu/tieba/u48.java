package com.baidu.tieba;

import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes8.dex */
public class u48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends kw5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ e28 c;

        public a(String str, boolean z, e28 e28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), e28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = z;
            this.c = e28Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.kw5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            int i;
            int i2;
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    l45.e();
                    ne<byte[]> d = l45.d("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                    if (d == null) {
                        return Boolean.FALSE;
                    }
                    byte[] bArr = d.get("0");
                    if (bArr != null && bArr.length != 0) {
                        DataRes.Builder builder = new DataRes.Builder((DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class));
                        if (builder.thread_list != null && builder.thread_list.size() > 0) {
                            for (int i3 = 0; i3 < builder.thread_list.size(); i3++) {
                                ThreadInfo threadInfo = builder.thread_list.get(i3);
                                if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == JavaTypesHelper.toLong(this.a, -1L)) {
                                    ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                                    User.Builder builder3 = new User.Builder(builder2.author);
                                    if (this.b) {
                                        i = 1;
                                    } else {
                                        i = 0;
                                    }
                                    builder3.is_like = Integer.valueOf(i);
                                    if (this.b) {
                                        i2 = 1;
                                    } else {
                                        i2 = 0;
                                    }
                                    builder3.has_concerned = Integer.valueOf(i2);
                                    GodInfo.Builder builder4 = new GodInfo.Builder(builder3.god_data);
                                    if (this.b) {
                                        intValue = builder3.fans_num.intValue() + 1;
                                        builder4.followed = 1;
                                    } else {
                                        intValue = builder3.fans_num.intValue() - 1;
                                        builder4.followed = 0;
                                    }
                                    builder3.fans_num = Integer.valueOf(intValue);
                                    builder3.god_data = builder4.build(true);
                                    builder2.author = builder3.build(true);
                                    builder.thread_list.set(i3, builder2.build(true));
                                }
                            }
                            DataRes.Builder builder5 = new DataRes.Builder(builder.build(true));
                            if (this.c != null) {
                                this.c.g(builder5.thread_list);
                            }
                            d.g("0", builder5.build(true).toByteArray());
                            return Boolean.TRUE;
                        }
                        return Boolean.FALSE;
                    }
                    return Boolean.FALSE;
                } catch (Exception e) {
                    BdLog.e(e);
                    return Boolean.FALSE;
                }
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements pv5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pv5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public static void a(UpdateAttentionMessage updateAttentionMessage, e28 e28Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, updateAttentionMessage, e28Var) == null) && updateAttentionMessage != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
            ow5.b(new a(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention, e28Var), new b());
        }
    }

    public static void b(DataRes.Builder builder, UpdateAttentionMessage updateAttentionMessage, e28 e28Var) {
        User user;
        int intValue;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, builder, updateAttentionMessage, e28Var) == null) && builder != null && updateAttentionMessage != null) {
            int i = 0;
            while (true) {
                if (i >= builder.thread_list.size()) {
                    break;
                }
                ThreadInfo threadInfo = builder.thread_list.get(i);
                if (threadInfo != null && (user = threadInfo.author) != null && user.id.longValue() == JavaTypesHelper.toLong(updateAttentionMessage.getData().toUid, -1L)) {
                    ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                    User.Builder builder3 = new User.Builder(builder2.author);
                    builder3.is_like = Integer.valueOf(updateAttentionMessage.getData().isAttention ? 1 : 0);
                    builder3.has_concerned = Integer.valueOf(updateAttentionMessage.getData().isAttention ? 1 : 0);
                    GodInfo.Builder builder4 = new GodInfo.Builder(builder3.god_data);
                    if (updateAttentionMessage.getData().isAttention) {
                        intValue = builder3.fans_num.intValue() + 1;
                        builder4.followed = 1;
                    } else {
                        builder4.followed = 0;
                        intValue = builder3.fans_num.intValue() - 1;
                    }
                    builder3.fans_num = Integer.valueOf(intValue);
                    builder3.god_data = builder4.build(true);
                    builder2.author = builder3.build(true);
                    builder.thread_list.set(i, builder2.build(true));
                } else {
                    i++;
                }
            }
            a(updateAttentionMessage, e28Var);
        }
    }
}
