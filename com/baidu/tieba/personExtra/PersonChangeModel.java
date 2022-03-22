package com.baidu.tieba.personExtra;

import android.text.TextUtils;
import c.a.d.a.f;
import c.a.d.f.p.l;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.R;
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
/* loaded from: classes5.dex */
public class PersonChangeModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonChangeData a;

    /* renamed from: b  reason: collision with root package name */
    public b f35424b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d.c.g.a f35425c;

    /* loaded from: classes5.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonChangeModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonChangeModel personChangeModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = personChangeModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
                if (z || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        if (this.a.f35424b != null) {
                            this.a.f35424b.a(responsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    if (z) {
                        ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                        this.a.B(profileSocketResponseMessage.getNicknameInfo(), profileSocketResponseMessage.GetUser());
                    }
                    if (responsedMessage instanceof ProfileHttpResponseMessage) {
                        ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                        this.a.B(profileHttpResponseMessage.getNicknameInfo(), profileHttpResponseMessage.GetUser());
                    }
                    if (this.a.f35424b != null) {
                        this.a.f35424b.b();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f35425c = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.a = personChangeData;
        if (personChangeData == null) {
            this.a = new PersonChangeData();
        }
        this.f35425c.getHttpMessageListener().setSelfListener(true);
        this.f35425c.getSocketMessageListener().setSelfListener(true);
        registerListener(this.f35425c);
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PersonChangeData personChangeData = this.a;
            if (personChangeData == null) {
                return false;
            }
            return ((TextUtils.isEmpty(personChangeData.getNameShow()) && TextUtils.isEmpty(this.a.getTempNickName())) || TextUtils.isEmpty(this.a.getPortrait()) || ListUtils.isEmpty(this.a.getInterestedForums()) || this.a.getBirthdayTime() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void B(NicknameInfo nicknameInfo, User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nicknameInfo, user) == null) {
            this.a = new PersonChangeData();
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                this.a.setPortrait(currentAccountInfo.getPortrait());
                this.a.setName(currentAccountInfo.getDisplayName());
                this.a.setSex(currentAccountInfo.getSex());
                this.a.setNameShow(currentAccountInfo.getAccountNameShow());
                this.a.setMem(currentAccountInfo.getMemberType());
            }
            if (nicknameInfo != null) {
                this.a.setNickNameLeftDays(nicknameInfo.left_days.intValue());
            }
            if (user != null) {
                this.a.setName(user.name_show);
                this.a.setSex(user.sex.intValue());
                this.a.setIntro(user.intro);
                this.a.setForumAge(user.tb_age);
                this.a.setTiebaId(user.tieba_uid);
                AlaUserInfo alaUserInfo = user.ala_info;
                if (alaUserInfo != null) {
                    this.a.setAlaId(alaUserInfo.ala_id.longValue());
                }
                BirthdayInfo birthdayInfo = user.birthday_info;
                if (birthdayInfo != null) {
                    this.a.setUserAge(birthdayInfo.age.intValue());
                    this.a.setBirthdayTime(user.birthday_info.birthday_time.longValue());
                    this.a.setBirthdayShowStatus(user.birthday_info.birthday_show_status.intValue());
                }
                BusinessAccountInfo businessAccountInfo = user.business_account_info;
                if (businessAccountInfo != null) {
                    PersonChangeData personChangeData = this.a;
                    Integer num = businessAccountInfo.is_business_account;
                    personChangeData.setIsBusinessAccount(num != null ? num.toString() : "0");
                }
            }
        }
    }

    public PersonChangeData C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (PersonChangeData) invokeV.objValue;
    }

    public void D(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f35424b = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!l.A()) {
                this.f35424b.a(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c15));
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
}
