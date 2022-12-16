package com.baidu.tieba.personPolymeric.tab.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabHttpResMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabRequestMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabSocketResMessage;
import com.baidu.tieba.qb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes5.dex */
public class PersonCenterDynamicTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public boolean b;
    public b c;
    public final List<ThreadData> d;
    public long e;
    public User f;
    public MetaData g;
    public BdUniqueId h;
    public final qb i;

    /* loaded from: classes5.dex */
    public interface b {
        void a(List<ThreadData> list, boolean z, boolean z2);

        void b(boolean z);
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

    /* loaded from: classes5.dex */
    public class a extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterDynamicTabModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonCenterDynamicTabModel personCenterDynamicTabModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterDynamicTabModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = personCenterDynamicTabModel;
        }

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.a.h) {
                return;
            }
            List<ThreadData> list = null;
            boolean z2 = false;
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
            if (responsedMessage.getError() == 0) {
                if (!ListUtils.isEmpty(list)) {
                    this.a.R(list);
                    this.a.d.addAll(list);
                }
                this.a.b = z;
                if (this.a.c != null) {
                    b bVar = this.a.c;
                    List<ThreadData> list2 = this.a.d;
                    boolean z3 = this.a.b;
                    if (this.a.a == 0) {
                        z2 = true;
                    }
                    bVar.a(list2, z3, z2);
                }
                this.a.a = j;
            } else if (this.a.c != null) {
                b bVar2 = this.a.c;
                if (this.a.a == 0) {
                    z2 = true;
                }
                bVar2.b(z2);
            }
        }
    }

    public PersonCenterDynamicTabModel(TbPageContext tbPageContext, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.b = false;
        this.d = new ArrayList();
        this.h = BdUniqueId.gen();
        a aVar = new a(this, CmdConfigHttp.CMD_PERSON_CENTER_DYNAMIC_TAB, 309647);
        this.i = aVar;
        this.e = j;
        aVar.setTag(this.h);
        MessageManager.getInstance().registerListener(this.i);
    }

    public final void P(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            PersonCenterDynamicTabRequestMessage personCenterDynamicTabRequestMessage = new PersonCenterDynamicTabRequestMessage(this.e, j, 10);
            personCenterDynamicTabRequestMessage.setTag(this.h);
            MessageManager.getInstance().sendMessage(personCenterDynamicTabRequestMessage);
        }
    }

    public void T(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, metaData) == null) {
            this.g = metaData;
        }
    }

    public void U(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.c = bVar;
        }
    }

    public void V(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, user) == null) {
            this.f = user;
            S();
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            P(this.a);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = 0L;
            this.d.clear();
            P(this.a);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a = 0L;
            this.b = false;
            this.d.clear();
            if (this.i != null) {
                MessageManager.getInstance().unRegisterListener(this.i);
            }
        }
    }

    public final void R(List<ThreadData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && this.f != null && !ListUtils.isEmpty(list)) {
            for (ThreadData threadData : list) {
                if (threadData.getAuthor() != null) {
                    threadData.getAuthor().getNewGodData().parserProtobuf(this.f.new_god_data);
                    threadData.getAuthor().getBazhuGradeData().parserProtobuf(this.f.bazhu_grade);
                    threadData.getAuthor().setBaijiahaoInfo(this.f.baijiahao_info);
                    if (this.g != null) {
                        threadData.getAuthor().setPrivSetsData(this.g.getPrivSetsData());
                    }
                    threadData.praserTimeConsumingInfo();
                }
            }
        }
    }
}
