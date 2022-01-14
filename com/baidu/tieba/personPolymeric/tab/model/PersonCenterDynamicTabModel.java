package com.baidu.tieba.personPolymeric.tab.model;

import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.e2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabHttpResMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabRequestMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabSocketResMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes12.dex */
public class PersonCenterDynamicTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f47256e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47257f;

    /* renamed from: g  reason: collision with root package name */
    public b f47258g;

    /* renamed from: h  reason: collision with root package name */
    public final List<e2> f47259h;

    /* renamed from: i  reason: collision with root package name */
    public long f47260i;

    /* renamed from: j  reason: collision with root package name */
    public User f47261j;
    public MetaData k;
    public BdUniqueId l;
    public final c.a.d.c.g.a m;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterDynamicTabModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonCenterDynamicTabModel personCenterDynamicTabModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterDynamicTabModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = personCenterDynamicTabModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j2;
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.a.l) {
                return;
            }
            List<e2> list = null;
            if (responsedMessage instanceof PersonCenterDynamicTabHttpResMessage) {
                PersonCenterDynamicTabHttpResMessage personCenterDynamicTabHttpResMessage = (PersonCenterDynamicTabHttpResMessage) responsedMessage;
                j2 = personCenterDynamicTabHttpResMessage.mCursor;
                z = personCenterDynamicTabHttpResMessage.mHasMore;
                list = personCenterDynamicTabHttpResMessage.mThreadDataList;
            } else if (responsedMessage instanceof PersonCenterDynamicTabSocketResMessage) {
                PersonCenterDynamicTabSocketResMessage personCenterDynamicTabSocketResMessage = (PersonCenterDynamicTabSocketResMessage) responsedMessage;
                j2 = personCenterDynamicTabSocketResMessage.mCursor;
                z = personCenterDynamicTabSocketResMessage.mHasMore;
                list = personCenterDynamicTabSocketResMessage.mThreadDataList;
            } else {
                j2 = 0;
                z = false;
            }
            if (responsedMessage.getError() != 0) {
                if (this.a.f47258g != null) {
                    this.a.f47258g.b(this.a.f47256e == 0);
                    return;
                }
                return;
            }
            if (!ListUtils.isEmpty(list)) {
                this.a.H(list);
                this.a.f47259h.addAll(list);
            }
            this.a.f47257f = z;
            if (this.a.f47258g != null) {
                this.a.f47258g.a(this.a.f47259h, this.a.f47257f, this.a.f47256e == 0);
            }
            this.a.f47256e = j2;
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void a(List<e2> list, boolean z, boolean z2);

        void b(boolean z);
    }

    public PersonCenterDynamicTabModel(TbPageContext tbPageContext, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47256e = 0L;
        this.f47257f = false;
        this.f47259h = new ArrayList();
        this.l = BdUniqueId.gen();
        a aVar = new a(this, CmdConfigHttp.CMD_PERSON_CENTER_DYNAMIC_TAB, 309647);
        this.m = aVar;
        this.f47260i = j2;
        aVar.setTag(this.l);
        MessageManager.getInstance().registerListener(this.m);
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47257f : invokeV.booleanValue;
    }

    public final void F(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            PersonCenterDynamicTabRequestMessage personCenterDynamicTabRequestMessage = new PersonCenterDynamicTabRequestMessage(this.f47260i, j2, 10);
            personCenterDynamicTabRequestMessage.setTag(this.l);
            MessageManager.getInstance().sendMessage(personCenterDynamicTabRequestMessage);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            F(this.f47256e);
        }
    }

    public final void H(List<e2> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || this.f47261j == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (e2 e2Var : list) {
            if (e2Var.J() != null) {
                e2Var.J().getNewGodData().parserProtobuf(this.f47261j.new_god_data);
                e2Var.J().getBazhuGradeData().parserProtobuf(this.f47261j.bazhu_grade);
                e2Var.J().setBaijiahaoInfo(this.f47261j.baijiahao_info);
                if (this.k != null) {
                    e2Var.J().setPrivSetsData(this.k.getPrivSetsData());
                }
                e2Var.i3();
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f47256e = 0L;
            this.f47259h.clear();
            F(this.f47256e);
        }
    }

    public void J(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, metaData) == null) {
            this.k = metaData;
        }
    }

    public void K(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f47258g = bVar;
        }
    }

    public void L(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, user) == null) {
            this.f47261j = user;
            I();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f47256e = 0L;
            this.f47257f = false;
            this.f47259h.clear();
            if (this.m != null) {
                MessageManager.getInstance().unRegisterListener(this.m);
            }
        }
    }
}
