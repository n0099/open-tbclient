package com.baidu.tieba.personCenter.model;

import android.os.Looper;
import android.os.MessageQueue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tieba.da;
import com.baidu.tieba.e05;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.tp5;
import com.baidu.tieba.u8a;
import com.baidu.tieba.z7a;
import com.baidu.tieba.zx6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Profile.ProfileResIdl;
/* loaded from: classes7.dex */
public class PersonCenterModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUEST_NO_NETWORK = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public u8a a;
    public d b;
    public boolean c;
    public boolean d;
    public NetMessageListener e;
    public CustomMessageListener f;
    public boolean mIsDataLoaded;

    /* loaded from: classes7.dex */
    public interface d {
        void a(u8a u8aVar);

        void onFail(int i, String str);
    }

    /* loaded from: classes7.dex */
    public class a implements da.a<byte[]> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterModel a;

        /* renamed from: com.baidu.tieba.personCenter.model.PersonCenterModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0440a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0440a(a aVar) {
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
        @Override // com.baidu.tieba.da.a
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
                    SafeHandler.getInst().post(new RunnableC0440a(this));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterModel a;

        /* loaded from: classes7.dex */
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
                    this.c.a.U(true, this.a, this.b);
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

        @Override // com.baidu.adp.framework.listener.NetMessageListener
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

    /* loaded from: classes7.dex */
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
            this.a.V((PersonChangeData) customResponsedMessage.getData());
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
                super((BdPageContext) newInitContext.callArgs[0]);
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

    public void Y(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.b = dVar;
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.c = z;
        }
    }

    public u8a S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (u8a) invokeV.objValue;
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e05.j("tb_user_profile", TbadkCoreApplication.getCurrentAccountName()).f("profile_cache_key", new a(this));
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = new u8a();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            cancelLoadData();
            W(TbadkCoreApplication.getCurrentAccountId());
            return true;
        }
        return invokeV.booleanValue;
    }

    public void U(boolean z, ResponsedMessage<?> responsedMessage, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), responsedMessage, Long.valueOf(j)}) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && z7a.d().b() > 0) {
            long f = z7a.d().f();
            long b2 = z7a.d().b();
            long c2 = z7a.d().c();
            long j2 = f + b2;
            long a2 = z7a.d().a();
            if (a2 > 0 && j > a2) {
                j2 = j - a2;
            }
            new tp5(1008, z, responsedMessage, 0L, b2, c2, false, 0L, 0L, j2).c();
            z7a.d().h(0L);
        }
    }

    public final void V(PersonChangeData personChangeData) {
        u8a u8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, personChangeData) == null) && personChangeData != null && (u8aVar = this.a) != null && u8aVar.A() != null && TbadkCoreApplication.getCurrentAccount() != null) {
            X();
            W(JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
        }
    }

    public void W(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                d dVar = this.b;
                if (dVar != null) {
                    dVar.onFail(-1, null);
                }
            } else if (TbadkCoreApplication.getCurrentAccount() == null) {
            } else {
                if (this.d) {
                    this.d = false;
                    T();
                }
                ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
                profileRequestMessage.set_uid(Long.valueOf(JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)));
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
                profileRequestMessage.setHistoryForumIds(zx6.o().l());
                profileRequestMessage.setHistoryForumNames(zx6.o().m());
                u8a u8aVar = new u8a();
                this.a = u8aVar;
                profileRequestMessage.setPersonCenterData(u8aVar);
                sendMessage(profileRequestMessage);
            }
        }
    }
}
