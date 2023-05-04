package com.baidu.tieba.personCenter.model;

import android.os.Looper;
import android.os.MessageQueue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tieba.a9;
import com.baidu.tieba.cn5;
import com.baidu.tieba.gg;
import com.baidu.tieba.jg;
import com.baidu.tieba.k59;
import com.baidu.tieba.me;
import com.baidu.tieba.p49;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.t05;
import com.baidu.tieba.ur6;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Profile.ProfileResIdl;
/* loaded from: classes5.dex */
public class PersonCenterModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUEST_NO_NETWORK = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public k59 a;
    public d b;
    public boolean c;
    public boolean d;
    public za e;
    public CustomMessageListener f;
    public boolean mIsDataLoaded;

    /* loaded from: classes5.dex */
    public interface d {
        void a(k59 k59Var);

        void onFail(int i, String str);
    }

    /* loaded from: classes5.dex */
    public class a implements me.a<byte[]> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterModel a;

        /* renamed from: com.baidu.tieba.personCenter.model.PersonCenterModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0398a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0398a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    PersonCenterModel personCenterModel = this.a.a;
                    if (!personCenterModel.mIsDataLoaded) {
                        personCenterModel.setErrorString(null);
                        if (this.a.a.b != null) {
                            this.a.a.b.a(this.a.a.a);
                        }
                    }
                }
            }
        }

        public a(PersonCenterModel personCenterModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personCenterModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.me.a
        /* renamed from: b */
        public void a(String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr) == null) && bArr != null) {
                boolean z = true;
                try {
                    this.a.a.b((ProfileResIdl) new Wire(new Class[0]).parseFrom(bArr, ProfileResIdl.class));
                } catch (Exception e) {
                    BdLog.e(e);
                    z = false;
                }
                if (z) {
                    jg.a().post(new RunnableC0398a(this));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterModel a;

        /* loaded from: classes5.dex */
        public class a implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResponsedMessage a;
            public final /* synthetic */ long b;
            public final /* synthetic */ b c;

            public a(b bVar, ResponsedMessage responsedMessage, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, responsedMessage, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = responsedMessage;
                this.b = j;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.c.a.b0(true, this.a, this.b);
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonCenterModel personCenterModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = personCenterModel;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if ((!(responsedMessage instanceof ProfileSocketResponseMessage) && !(responsedMessage instanceof ProfileHttpResponseMessage)) || this.a.unique_id != responsedMessage.getOrginalMessage().getTag()) {
                    return;
                }
                if (responsedMessage.getError() == 0) {
                    PersonCenterModel personCenterModel = this.a;
                    personCenterModel.mIsDataLoaded = true;
                    if (personCenterModel.b != null) {
                        this.a.b.a(this.a.a);
                    }
                } else if (this.a.b != null) {
                    this.a.b.onFail(responsedMessage.getError(), responsedMessage.getErrorString());
                }
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    Looper.myQueue().addIdleHandler(new a(this, responsedMessage, System.currentTimeMillis()));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonCenterModel personCenterModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personCenterModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PersonChangeData)) {
                return;
            }
            this.a.c0((PersonChangeData) customResponsedMessage.getData());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCenterModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsDataLoaded = false;
        this.c = false;
        this.d = true;
        this.e = new b(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.f = new c(this, 2001380);
        setUniqueId(bdUniqueId);
        registerListener(this.f);
        registerListener(this.e);
    }

    public void f0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.b = dVar;
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.c = z;
        }
    }

    public k59 Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (k59) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            t05.c("tb_user_profile", TbadkCoreApplication.getCurrentAccountName()).f("profile_cache_key", new a(this));
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a = new k59();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            cancelLoadData();
            d0(TbadkCoreApplication.getCurrentAccountId());
            return true;
        }
        return invokeV.booleanValue;
    }

    public void b0(boolean z, ResponsedMessage<?> responsedMessage, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), responsedMessage, Long.valueOf(j)}) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && p49.d().b() > 0) {
            long f = p49.d().f();
            long b2 = p49.d().b();
            long c2 = p49.d().c();
            long j2 = f + b2;
            long a2 = p49.d().a();
            if (a2 > 0 && j > a2) {
                j2 = j - a2;
            }
            new cn5(1008, z, responsedMessage, 0L, b2, c2, false, 0L, 0L, j2).c();
            p49.d().h(0L);
        }
    }

    public final void c0(PersonChangeData personChangeData) {
        k59 k59Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, personChangeData) == null) && personChangeData != null && (k59Var = this.a) != null && k59Var.A() != null && TbadkCoreApplication.getCurrentAccount() != null) {
            e0();
            d0(gg.g(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }

    public void d0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                d dVar = this.b;
                if (dVar != null) {
                    dVar.onFail(-1, null);
                }
            } else if (TbadkCoreApplication.getCurrentAccount() == null) {
            } else {
                if (this.d) {
                    this.d = false;
                    a0();
                }
                ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
                profileRequestMessage.set_uid(Long.valueOf(gg.g(TbadkCoreApplication.getCurrentAccount(), 0L)));
                profileRequestMessage.set_need_post_count(1);
                profileRequestMessage.set_pn(1);
                profileRequestMessage.set_rn(1);
                profileRequestMessage.set_has_plist(1);
                profileRequestMessage.set_from_db(false);
                profileRequestMessage.set_error_hint(true);
                profileRequestMessage.setSelf(true);
                profileRequestMessage.setTag(this.unique_id);
                if (this.c) {
                    profileRequestMessage.setIs_from_usercenter(1);
                } else {
                    profileRequestMessage.setIs_from_usercenter(0);
                }
                profileRequestMessage.setPage(1);
                profileRequestMessage.setNeedUsergrowthTask(1);
                profileRequestMessage.setHistoryForumIds(ur6.n().k());
                profileRequestMessage.setHistoryForumNames(ur6.n().l());
                k59 k59Var = new k59();
                this.a = k59Var;
                profileRequestMessage.setPersonCenterData(k59Var);
                sendMessage(profileRequestMessage);
            }
        }
    }
}
