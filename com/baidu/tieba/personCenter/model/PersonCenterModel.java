package com.baidu.tieba.personCenter.model;

import android.os.Looper;
import android.os.MessageQueue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.r0.m0.h;
import d.a.r0.m0.k;
import d.a.s0.k2.e.f;
/* loaded from: classes5.dex */
public class PersonCenterModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUEST_NO_NETWORK = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f19976e;

    /* renamed from: f  reason: collision with root package name */
    public c f19977f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19978g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f19979h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f19980i;
    public boolean mIsDataLoaded;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterModel f19981a;

        /* renamed from: com.baidu.tieba.personCenter.model.PersonCenterModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0235a implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ResponsedMessage f19982a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f19983b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f19984c;

            public C0235a(a aVar, ResponsedMessage responsedMessage, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, responsedMessage, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19984c = aVar;
                this.f19982a = responsedMessage;
                this.f19983b = j;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f19984c.f19981a.B(true, this.f19982a, this.f19983b);
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonCenterModel personCenterModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19981a = personCenterModel;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && this.f19981a.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage.getError() != 0) {
                    this.f19981a.f19977f.onFail(responsedMessage.getError(), responsedMessage.getErrorString());
                } else {
                    PersonCenterModel personCenterModel = this.f19981a;
                    personCenterModel.mIsDataLoaded = true;
                    personCenterModel.f19977f.a(this.f19981a.f19976e);
                }
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    Looper.myQueue().addIdleHandler(new C0235a(this, responsedMessage, System.currentTimeMillis()));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterModel f19985a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonCenterModel personCenterModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19985a = personCenterModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                this.f19985a.C((PersonChangeData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(f fVar);

        void onFail(int i2, String str);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsDataLoaded = false;
        this.f19978g = false;
        this.f19979h = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.f19980i = new b(this, 2001380);
        setUniqueId(bdUniqueId);
        registerListener(this.f19980i);
        registerListener(this.f19979h);
    }

    public f A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19976e : (f) invokeV.objValue;
    }

    public void B(boolean z, ResponsedMessage<?> responsedMessage, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), responsedMessage, Long.valueOf(j)}) == null) && k.d().g() && d.a.s0.k2.a.d().b() > 0) {
            long f2 = d.a.s0.k2.a.d().f();
            long b2 = d.a.s0.k2.a.d().b();
            long c2 = d.a.s0.k2.a.d().c();
            long j2 = f2 + b2;
            long a2 = d.a.s0.k2.a.d().a();
            if (a2 > 0 && j > a2) {
                j2 = j - a2;
            }
            new h(1008, z, responsedMessage, 0L, b2, c2, false, 0L, 0L, j2).c();
            d.a.s0.k2.a.d().h(0L);
        }
    }

    public final void C(PersonChangeData personChangeData) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, personChangeData) == null) || personChangeData == null || (fVar = this.f19976e) == null || fVar.p() == null || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        E();
        D(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
    }

    public void D(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            if (!j.A()) {
                this.f19977f.onFail(-1, null);
            } else if (TbadkCoreApplication.getCurrentAccount() == null) {
            } else {
                ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
                profileRequestMessage.set_uid(Long.valueOf(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L)));
                profileRequestMessage.set_need_post_count(1);
                profileRequestMessage.set_pn(1);
                profileRequestMessage.set_rn(1);
                profileRequestMessage.set_has_plist(1);
                profileRequestMessage.set_from_db(false);
                profileRequestMessage.set_error_hint(true);
                profileRequestMessage.setSelf(true);
                profileRequestMessage.setTag(this.unique_id);
                if (this.f19978g) {
                    profileRequestMessage.setIs_from_usercenter(1);
                } else {
                    profileRequestMessage.setIs_from_usercenter(0);
                }
                profileRequestMessage.setPage(1);
                f fVar = new f();
                this.f19976e = fVar;
                profileRequestMessage.setPersonCenterData(fVar);
                sendMessage(profileRequestMessage);
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f19976e = new f();
        }
    }

    public void F(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f19977f = cVar;
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f19978g = z;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            cancelLoadData();
            D(TbadkCoreApplication.getCurrentAccountId());
            return true;
        }
        return invokeV.booleanValue;
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
}
