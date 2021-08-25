package com.baidu.tieba.personPolymeric.tab.model;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.c2;
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
/* loaded from: classes7.dex */
public class PersonCenterDynamicTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f55881e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55882f;

    /* renamed from: g  reason: collision with root package name */
    public b f55883g;

    /* renamed from: h  reason: collision with root package name */
    public final List<c2> f55884h;

    /* renamed from: i  reason: collision with root package name */
    public long f55885i;

    /* renamed from: j  reason: collision with root package name */
    public User f55886j;
    public MetaData k;
    public BdUniqueId l;
    public final c.a.e.c.g.a m;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterDynamicTabModel f55887a;

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
            this.f55887a = personCenterDynamicTabModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j2;
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.f55887a.l) {
                return;
            }
            List<c2> list = null;
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
                if (this.f55887a.f55883g != null) {
                    this.f55887a.f55883g.b(this.f55887a.f55881e == 0);
                    return;
                }
                return;
            }
            if (!ListUtils.isEmpty(list)) {
                this.f55887a.H(list);
                this.f55887a.f55884h.addAll(list);
            }
            this.f55887a.f55882f = z;
            if (this.f55887a.f55883g != null) {
                this.f55887a.f55883g.a(this.f55887a.f55884h, this.f55887a.f55882f, this.f55887a.f55881e == 0);
            }
            this.f55887a.f55881e = j2;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(List<c2> list, boolean z, boolean z2);

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
        this.f55881e = 0L;
        this.f55882f = false;
        this.f55884h = new ArrayList();
        this.l = BdUniqueId.gen();
        a aVar = new a(this, CmdConfigHttp.CMD_PERSON_CENTER_DYNAMIC_TAB, 309647);
        this.m = aVar;
        this.f55885i = j2;
        aVar.setTag(this.l);
        MessageManager.getInstance().registerListener(this.m);
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55882f : invokeV.booleanValue;
    }

    public final void F(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            PersonCenterDynamicTabRequestMessage personCenterDynamicTabRequestMessage = new PersonCenterDynamicTabRequestMessage(this.f55885i, j2, 10);
            personCenterDynamicTabRequestMessage.setTag(this.l);
            MessageManager.getInstance().sendMessage(personCenterDynamicTabRequestMessage);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            F(this.f55881e);
        }
    }

    public final void H(List<c2> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || this.f55886j == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (c2 c2Var : list) {
            if (c2Var.J() != null) {
                c2Var.J().getNewGodData().parserProtobuf(this.f55886j.new_god_data);
                c2Var.J().getBazhuGradeData().parserProtobuf(this.f55886j.bazhu_grade);
                c2Var.J().setBaijiahaoInfo(this.f55886j.baijiahao_info);
                if (this.k != null) {
                    c2Var.J().setPrivSetsData(this.k.getPrivSetsData());
                }
                c2Var.Y2();
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f55881e = 0L;
            this.f55884h.clear();
            F(this.f55881e);
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
            this.f55883g = bVar;
        }
    }

    public void L(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, user) == null) {
            this.f55886j = user;
            I();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
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
            this.f55881e = 0L;
            this.f55882f = false;
            this.f55884h.clear();
            if (this.m != null) {
                MessageManager.getInstance().unRegisterListener(this.m);
            }
        }
    }
}
