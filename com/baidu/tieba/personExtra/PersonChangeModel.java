package com.baidu.tieba.personExtra;

import android.text.TextUtils;
import c.a.d.a.f;
import c.a.d.f.p.l;
import c.a.t0.y2.g;
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
    public PersonChangeData f49003e;

    /* renamed from: f  reason: collision with root package name */
    public b f49004f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.c.g.a f49005g;

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
                        if (this.a.f49004f != null) {
                            this.a.f49004f.a(responsedMessage.getErrorString());
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
                    if (this.a.f49004f != null) {
                        this.a.f49004f.b();
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
        this.f49003e = null;
        this.f49005g = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.f49003e = personChangeData;
        if (personChangeData == null) {
            this.f49003e = new PersonChangeData();
        }
        this.f49005g.getHttpMessageListener().setSelfListener(true);
        this.f49005g.getSocketMessageListener().setSelfListener(true);
        registerListener(this.f49005g);
    }

    public PersonChangeData A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f49003e : (PersonChangeData) invokeV.objValue;
    }

    public void B(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f49004f = bVar;
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
            if (!l.A()) {
                this.f49004f.a(TbadkCoreApplication.getInst().getString(g.neterror));
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
            PersonChangeData personChangeData = this.f49003e;
            if (personChangeData == null) {
                return false;
            }
            return ((TextUtils.isEmpty(personChangeData.getNameShow()) && TextUtils.isEmpty(this.f49003e.getTempNickName())) || TextUtils.isEmpty(this.f49003e.getPortrait()) || ListUtils.isEmpty(this.f49003e.getInterestedForums()) || this.f49003e.getBirthdayTime() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void z(NicknameInfo nicknameInfo, User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, nicknameInfo, user) == null) {
            this.f49003e = new PersonChangeData();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.f49003e.setPortrait(currentAccountInfo.getPortrait());
                this.f49003e.setName(currentAccountInfo.getDisplayName());
                this.f49003e.setSex(currentAccountInfo.getSex());
                this.f49003e.setNameShow(currentAccountInfo.getAccountNameShow());
                this.f49003e.setMem(currentAccountInfo.getMemberType());
            }
            if (nicknameInfo != null) {
                this.f49003e.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (user != null) {
                this.f49003e.setName(user.name_show);
                this.f49003e.setSex(user.sex.intValue());
                this.f49003e.setIntro(user.intro);
                this.f49003e.setForumAge(user.tb_age);
                this.f49003e.setTiebaId(user.tieba_uid);
                AlaUserInfo alaUserInfo = user.ala_info;
                if (alaUserInfo != null) {
                    this.f49003e.setAlaId(alaUserInfo.ala_id.longValue());
                }
                BirthdayInfo birthdayInfo = user.birthday_info;
                if (birthdayInfo != null) {
                    this.f49003e.setUserAge(birthdayInfo.age.intValue());
                    this.f49003e.setBirthdayTime(user.birthday_info.birthday_time.longValue());
                    this.f49003e.setBirthdayShowStatus(user.birthday_info.birthday_show_status.intValue());
                }
                BusinessAccountInfo businessAccountInfo = user.business_account_info;
                if (businessAccountInfo != null) {
                    PersonChangeData personChangeData = this.f49003e;
                    Integer num = businessAccountInfo.is_business_account;
                    personChangeData.setIsBusinessAccount(num != null ? num.toString() : "0");
                }
            }
        }
    }
}
