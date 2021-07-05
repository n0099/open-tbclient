package com.baidu.tieba.personPolymeric.mode;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes5.dex */
public class PersonPolymericModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RN = 20;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.m2.e.a f20163e;

    /* renamed from: f  reason: collision with root package name */
    public int f20164f;

    /* renamed from: g  reason: collision with root package name */
    public String f20165g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.m2.h.b f20166h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.m2.h.a f20167i;
    public boolean j;
    public d.a.c.c.g.a k;
    public CustomMessageListener l;
    public CustomMessageListener m;
    public CustomMessageListener n;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonPolymericModel f20168a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonPolymericModel personPolymericModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f20168a = personPolymericModel;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
            if ((z || (responsedMessage instanceof ProfileHttpResponseMessage)) && this.f20168a.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                d.a.s0.j2.c cVar = z ? (ProfileSocketResponseMessage) responsedMessage : null;
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    cVar = (ProfileHttpResponseMessage) responsedMessage;
                }
                if (cVar.getErrorCode() == 0) {
                    this.f20168a.f20163e.v(cVar);
                }
                d.a.s0.m2.b.d().n(System.currentTimeMillis() - d.a.s0.m2.b.d().e());
                if (responsedMessage.getError() == 0) {
                    this.f20168a.f20166h.b(this.f20168a.f20163e);
                } else {
                    this.f20168a.f20166h.b(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonPolymericModel f20169a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonPolymericModel personPolymericModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericModel, Integer.valueOf(i2)};
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
            this.f20169a = personPolymericModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.s0.s3.a) && customResponsedMessage.getOrginalMessage().getTag() == this.f20169a.unique_id) {
                d.a.s0.s3.a aVar = (d.a.s0.s3.a) customResponsedMessage.getData();
                DataRes dataRes = aVar.f65437a;
                if (aVar.f65439c != 0 || StringUtils.isNULL(dataRes.is_mute)) {
                    return;
                }
                if (dataRes.is_mute.equals("0")) {
                    this.f20169a.f20164f = 0;
                    this.f20169a.f20165g = dataRes.mute_confirm;
                    if (k.isEmpty(this.f20169a.f20165g)) {
                        this.f20169a.f20165g = "确定禁言？";
                    }
                } else if (dataRes.is_mute.equals("1")) {
                    this.f20169a.f20164f = 1;
                }
                this.f20169a.f20167i.a(0, this.f20169a.f20164f, this.f20169a.f20165g, aVar.f65439c, aVar.f65438b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonPolymericModel f20170a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonPolymericModel personPolymericModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericModel, Integer.valueOf(i2)};
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
            this.f20170a = personPolymericModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() != this.f20170a.unique_id) {
                return;
            }
            UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
            if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                this.f20170a.f20164f = 1;
            }
            this.f20170a.f20167i.a(1, this.f20170a.f20164f, this.f20170a.f20165g, userMuteAddResponseMessage.getMuteErrorCode(), userMuteAddResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonPolymericModel f20171a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonPolymericModel personPolymericModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personPolymericModel, Integer.valueOf(i2)};
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
            this.f20171a = personPolymericModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() != this.f20171a.unique_id) {
                return;
            }
            this.f20171a.f20164f = 0;
            UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
            this.f20171a.f20167i.a(2, this.f20171a.f20164f, this.f20171a.f20165g, userMuteDelResponseMessage.getMuteErrorCode(), userMuteDelResponseMessage.getMuteMessage());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonPolymericModel(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseFragmentActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bdUniqueId, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20164f = -1;
        this.f20165g = "";
        this.k = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.l = new b(this, 2001426);
        this.m = new c(this, 2001427);
        this.n = new d(this, 2001428);
        setUniqueId(bdUniqueId);
        if (!z) {
            registerListener(this.l);
            registerListener(this.m);
            registerListener(this.n);
        }
        this.j = z;
        registerListener(this.k);
    }

    public d.a.s0.m2.e.a H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20163e : (d.a.s0.m2.e.a) invokeV.objValue;
    }

    public void I(long j, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, str) == null) && j.A()) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Long.valueOf(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L)));
            }
            if (!this.j) {
                profileRequestMessage.set_friend_uid(Long.valueOf(j));
                profileRequestMessage.set_is_guest(1);
            }
            profileRequestMessage.set_friend_uid_portrait(str);
            profileRequestMessage.set_need_post_count(1);
            profileRequestMessage.set_pn(1);
            profileRequestMessage.set_rn(20);
            profileRequestMessage.set_has_plist(1);
            profileRequestMessage.set_from_db(false);
            profileRequestMessage.set_error_hint(true);
            profileRequestMessage.setSelf(true);
            profileRequestMessage.setTag(this.unique_id);
            profileRequestMessage.setIs_from_usercenter(1);
            profileRequestMessage.setPage(2);
            sendMessage(profileRequestMessage);
        }
    }

    public void J(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) && j.A()) {
            long f2 = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            if (j == f2 || !TbadkCoreApplication.isLogin()) {
                return;
            }
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = f2;
            userMuteCheckCustomMessage.userIdT = j;
            BdUniqueId bdUniqueId = this.unique_id;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f20163e.w();
        }
    }

    public void L(d.a.s0.m2.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f20166h = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void M(d.a.s0.m2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f20167i = aVar;
        }
    }

    public void N(d.a.s0.m2.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f20163e = aVar;
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

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            cancelLoadData();
            MessageManager.getInstance().unRegisterListener(getUniqueId());
        }
    }
}
