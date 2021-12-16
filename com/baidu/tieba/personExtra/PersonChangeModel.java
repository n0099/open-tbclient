package com.baidu.tieba.personExtra;

import android.text.TextUtils;
import c.a.d.a.f;
import c.a.d.f.p.k;
import c.a.s0.y2.g;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.AlaUserInfo;
import tbclient.BirthdayInfo;
import tbclient.BusinessAccountInfo;
import tbclient.Profile.NicknameInfo;
import tbclient.User;
/* loaded from: classes12.dex */
public class PersonChangeModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public PersonChangeData f48782e;

    /* renamed from: f  reason: collision with root package name */
    public b f48783f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.c.g.a f48784g;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonChangeModel personChangeModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = personChangeModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
                if (z || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        if (this.a.f48783f != null) {
                            this.a.f48783f.a(responsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    if (z) {
                        ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                        this.a.z(profileSocketResponseMessage.getNicknameInfo(), profileSocketResponseMessage.GetUser());
                    }
                    if (responsedMessage instanceof ProfileHttpResponseMessage) {
                        ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                        this.a.z(profileHttpResponseMessage.getNicknameInfo(), profileHttpResponseMessage.GetUser());
                    }
                    if (this.a.f48783f != null) {
                        this.a.f48783f.b();
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void a(String str);

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonChangeModel(f fVar, PersonChangeData personChangeData) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, personChangeData};
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
        this.f48782e = null;
        this.f48784g = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.f48782e = personChangeData;
        if (personChangeData == null) {
            this.f48782e = new PersonChangeData();
        }
        this.f48784g.getHttpMessageListener().setSelfListener(true);
        this.f48784g.getSocketMessageListener().setSelfListener(true);
        registerListener(this.f48784g);
    }

    public PersonChangeData A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f48782e : (PersonChangeData) invokeV.objValue;
    }

    public void B(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f48783f = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!k.A()) {
                this.f48783f.a(TbadkCoreApplication.getInst().getString(g.neterror));
                return false;
            } else if (TbadkCoreApplication.getCurrentAccount() == null) {
                return false;
            } else {
                ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
                profileRequestMessage.set_uid(Long.valueOf(c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L)));
                profileRequestMessage.set_pn(1);
                profileRequestMessage.set_rn(1);
                profileRequestMessage.set_has_plist(1);
                profileRequestMessage.set_from_db(false);
                profileRequestMessage.set_error_hint(true);
                profileRequestMessage.setSelf(true);
                profileRequestMessage.setTag(this.unique_id);
                profileRequestMessage.setIs_from_usercenter(0);
                profileRequestMessage.setPage(1);
                profileRequestMessage.setSelf(true);
                sendMessage(profileRequestMessage);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PersonChangeData personChangeData = this.f48782e;
            if (personChangeData == null) {
                return false;
            }
            return ((TextUtils.isEmpty(personChangeData.getNameShow()) && TextUtils.isEmpty(this.f48782e.getTempNickName())) || TextUtils.isEmpty(this.f48782e.getPortrait()) || ListUtils.isEmpty(this.f48782e.getInterestedForums()) || this.f48782e.getBirthdayTime() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void z(NicknameInfo nicknameInfo, User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, nicknameInfo, user) == null) {
            this.f48782e = new PersonChangeData();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.f48782e.setPortrait(currentAccountInfo.getPortrait());
                this.f48782e.setName(currentAccountInfo.getDisplayName());
                this.f48782e.setSex(currentAccountInfo.getSex());
                this.f48782e.setNameShow(currentAccountInfo.getAccountNameShow());
                this.f48782e.setMem(currentAccountInfo.getMemberType());
            }
            if (nicknameInfo != null) {
                this.f48782e.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (user != null) {
                this.f48782e.setName(user.name_show);
                this.f48782e.setSex(user.sex.intValue());
                this.f48782e.setIntro(user.intro);
                this.f48782e.setForumAge(user.tb_age);
                this.f48782e.setTiebaId(user.tieba_uid);
                AlaUserInfo alaUserInfo = user.ala_info;
                if (alaUserInfo != null) {
                    this.f48782e.setAlaId(alaUserInfo.ala_id.longValue());
                }
                BirthdayInfo birthdayInfo = user.birthday_info;
                if (birthdayInfo != null) {
                    this.f48782e.setUserAge(birthdayInfo.age.intValue());
                    this.f48782e.setBirthdayTime(user.birthday_info.birthday_time.longValue());
                    this.f48782e.setBirthdayShowStatus(user.birthday_info.birthday_show_status.intValue());
                }
                BusinessAccountInfo businessAccountInfo = user.business_account_info;
                if (businessAccountInfo != null) {
                    PersonChangeData personChangeData = this.f48782e;
                    Integer num = businessAccountInfo.is_business_account;
                    personChangeData.setIsBusinessAccount(num != null ? num.toString() : "0");
                }
            }
        }
    }
}
