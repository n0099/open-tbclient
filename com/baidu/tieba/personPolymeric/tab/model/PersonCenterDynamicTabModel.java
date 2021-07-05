package com.baidu.tieba.personPolymeric.tab.model;

import androidx.core.view.InputDeviceCompat;
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
import d.a.r0.r.q.b2;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes5.dex */
public class PersonCenterDynamicTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f20190e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20191f;

    /* renamed from: g  reason: collision with root package name */
    public b f20192g;

    /* renamed from: h  reason: collision with root package name */
    public final List<b2> f20193h;

    /* renamed from: i  reason: collision with root package name */
    public long f20194i;
    public User j;
    public MetaData k;
    public BdUniqueId l;
    public final d.a.c.c.g.a m;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterDynamicTabModel f20195a;

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
            this.f20195a = personCenterDynamicTabModel;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.f20195a.l) {
                return;
            }
            List<b2> list = null;
            if (responsedMessage instanceof PersonCenterDynamicTabHttpResMessage) {
                PersonCenterDynamicTabHttpResMessage personCenterDynamicTabHttpResMessage = (PersonCenterDynamicTabHttpResMessage) responsedMessage;
                j = personCenterDynamicTabHttpResMessage.mCursor;
                z = personCenterDynamicTabHttpResMessage.mHasMore;
                list = personCenterDynamicTabHttpResMessage.mThreadDataList;
            } else if (responsedMessage instanceof PersonCenterDynamicTabSocketResMessage) {
                PersonCenterDynamicTabSocketResMessage personCenterDynamicTabSocketResMessage = (PersonCenterDynamicTabSocketResMessage) responsedMessage;
                j = personCenterDynamicTabSocketResMessage.mCursor;
                z = personCenterDynamicTabSocketResMessage.mHasMore;
                list = personCenterDynamicTabSocketResMessage.mThreadDataList;
            } else {
                j = 0;
                z = false;
            }
            if (responsedMessage.getError() != 0) {
                if (this.f20195a.f20192g != null) {
                    this.f20195a.f20192g.b(this.f20195a.f20190e == 0);
                    return;
                }
                return;
            }
            if (!ListUtils.isEmpty(list)) {
                this.f20195a.H(list);
                this.f20195a.f20193h.addAll(list);
            }
            this.f20195a.f20191f = z;
            if (this.f20195a.f20192g != null) {
                this.f20195a.f20192g.a(this.f20195a.f20193h, this.f20195a.f20191f, this.f20195a.f20190e == 0);
            }
            this.f20195a.f20190e = j;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(List<b2> list, boolean z, boolean z2);

        void b(boolean z);
    }

    public PersonCenterDynamicTabModel(TbPageContext tbPageContext, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20190e = 0L;
        this.f20191f = false;
        this.f20193h = new ArrayList();
        this.l = BdUniqueId.gen();
        a aVar = new a(this, CmdConfigHttp.CMD_PERSON_CENTER_DYNAMIC_TAB, 309647);
        this.m = aVar;
        this.f20194i = j;
        aVar.setTag(this.l);
        MessageManager.getInstance().registerListener(this.m);
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20191f : invokeV.booleanValue;
    }

    public final void F(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            PersonCenterDynamicTabRequestMessage personCenterDynamicTabRequestMessage = new PersonCenterDynamicTabRequestMessage(this.f20194i, j, 10);
            personCenterDynamicTabRequestMessage.setTag(this.l);
            MessageManager.getInstance().sendMessage(personCenterDynamicTabRequestMessage);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            F(this.f20190e);
        }
    }

    public final void H(List<b2> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || this.j == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (b2 b2Var : list) {
            if (b2Var.H() != null) {
                b2Var.H().getNewGodData().parserProtobuf(this.j.new_god_data);
                b2Var.H().getBazhuGradeData().parserProtobuf(this.j.bazhu_grade);
                b2Var.H().setBaijiahaoInfo(this.j.baijiahao_info);
                if (this.k != null) {
                    b2Var.H().setPrivSetsData(this.k.getPrivSetsData());
                }
                b2Var.O2();
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f20190e = 0L;
            this.f20193h.clear();
            F(this.f20190e);
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
            this.f20192g = bVar;
        }
    }

    public void L(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, user) == null) {
            this.j = user;
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
            this.f20190e = 0L;
            this.f20191f = false;
            this.f20193h.clear();
            if (this.m != null) {
                MessageManager.getInstance().unRegisterListener(this.m);
            }
        }
    }
}
