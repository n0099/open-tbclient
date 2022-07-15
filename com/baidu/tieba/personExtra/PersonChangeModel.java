package com.baidu.tieba.personExtra;

import android.text.TextUtils;
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
import com.repackage.d9;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.za;
import tbclient.AlaUserInfo;
import tbclient.BirthdayInfo;
import tbclient.BusinessAccountInfo;
import tbclient.Profile.NicknameInfo;
import tbclient.User;
/* loaded from: classes3.dex */
public class PersonChangeModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonChangeData a;
    public b b;
    public za c;

    /* loaded from: classes3.dex */
    public class a extends za {
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

        @Override // com.repackage.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
                if (z || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        if (this.a.b != null) {
                            this.a.b.a(responsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    if (z) {
                        ProfileSocketResponseMessage profileSocketResponseMessage = (ProfileSocketResponseMessage) responsedMessage;
                        this.a.D(profileSocketResponseMessage.getNicknameInfo(), profileSocketResponseMessage.GetUser());
                    }
                    if (responsedMessage instanceof ProfileHttpResponseMessage) {
                        ProfileHttpResponseMessage profileHttpResponseMessage = (ProfileHttpResponseMessage) responsedMessage;
                        this.a.D(profileHttpResponseMessage.getNicknameInfo(), profileHttpResponseMessage.GetUser());
                    }
                    if (this.a.b != null) {
                        this.a.b.b();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str);

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonChangeModel(d9 d9Var, PersonChangeData personChangeData) {
        super(d9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var, personChangeData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = new a(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.a = personChangeData;
        if (personChangeData == null) {
            this.a = new PersonChangeData();
        }
        this.c.getHttpMessageListener().setSelfListener(true);
        this.c.getSocketMessageListener().setSelfListener(true);
        registerListener(this.c);
    }

    public boolean C() {
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

    public final void D(NicknameInfo nicknameInfo, User user) {
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
                this.a.setName(user.name);
                this.a.setNameShow(user.name_show);
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
                PersonChangeData personChangeData2 = this.a;
                personChangeData2.nickNameInVerifying = user.editing_nickname;
                personChangeData2.isNickNameInVerifying = user.is_nickname_editing.intValue() == 1;
            }
        }
    }

    public PersonChangeData E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (PersonChangeData) invokeV.objValue;
    }

    public void F(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.b = bVar;
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
            if (!ni.A()) {
                this.b.a(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c2b));
                return false;
            } else if (TbadkCoreApplication.getCurrentAccount() == null) {
                return false;
            } else {
                ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
                profileRequestMessage.set_uid(Long.valueOf(ng.g(TbadkCoreApplication.getCurrentAccount(), 0L)));
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
