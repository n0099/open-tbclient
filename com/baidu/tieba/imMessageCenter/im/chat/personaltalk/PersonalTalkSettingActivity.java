package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.an7;
import com.baidu.tieba.b49;
import com.baidu.tieba.bh;
import com.baidu.tieba.cn7;
import com.baidu.tieba.dk5;
import com.baidu.tieba.dl5;
import com.baidu.tieba.dr4;
import com.baidu.tieba.im.message.ClearChatMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingModel;
import com.baidu.tieba.m49;
import com.baidu.tieba.ni7;
import com.baidu.tieba.tb;
import com.baidu.tieba.uj7;
import com.baidu.tieba.wv4;
import com.baidu.tieba.zg7;
import com.baidu.tieba.zk5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements PersonalTalkSettingModel.g, BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cn7 a;
    public PersonalTalkSettingModel b;
    public b49 c;
    public m49 d;
    public long e;
    public final CustomMessageListener f;
    public tb g;

    /* loaded from: classes4.dex */
    public class c implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalTalkSettingActivity a;

        /* loaded from: classes4.dex */
        public class a extends zk5<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tieba.zk5
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return Boolean.valueOf(zg7.w().p(String.valueOf(this.a.a.e)));
                }
                return (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements dk5<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.dk5
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    this.a.a.closeLoadingDialog();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ClearChatMsgResponsedMessage());
                    this.a.a.showToast(R.string.delete_success, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.a.a.e), 2, null, 1)));
                }
            }
        }

        public c(PersonalTalkSettingActivity personalTalkSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalTalkSettingActivity;
        }

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                wv4Var.dismiss();
                this.a.showLoadingDialog(null);
                dl5.c(new a(this), new b(this));
                an7.a("c14632");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalTalkSettingActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonalTalkSettingActivity personalTalkSettingActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalTalkSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getError() == 0 && customResponsedMessage.getCmd() == 2921690 && this.a.b != null && this.a.b.i != null) {
                this.a.b.i.M(this.a.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalTalkSettingActivity a;

        public b(PersonalTalkSettingActivity personalTalkSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalTalkSettingActivity;
        }

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                wv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends tb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalTalkSettingActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonalTalkSettingActivity personalTalkSettingActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalTalkSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /* renamed from: a */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) {
                this.a.closeLoadingDialog();
                if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 104102 || !(socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) || !(socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage)) {
                    return;
                }
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) socketResponsedMessage.getOrginalMessage();
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                if (responseUpdateMaskInfoMessage.getError() == 0 && !responseUpdateMaskInfoMessage.hasError()) {
                    if (requestUpdateMaskInfoMessage.getMaskType() != 9) {
                        return;
                    }
                    this.a.D1(!responseUpdateMaskInfoMessage.hasError(), requestUpdateMaskInfoMessage.isSettingMask());
                    return;
                }
                this.a.D1(false, requestUpdateMaskInfoMessage.isSettingMask());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ PersonalTalkSettingActivity b;

        public e(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingActivity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalTalkSettingActivity;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                if (!this.a) {
                    ni7.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.b.e), false);
                    return null;
                }
                ni7.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.b.e), true);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ PersonalTalkSettingActivity b;

        public f(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingActivity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalTalkSettingActivity;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.f(null);
                this.b.a.b(!this.a);
                this.b.a.f(this.b);
            }
        }
    }

    public PersonalTalkSettingActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this, 2921690);
        this.g = new d(this, 104102);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            dr4 layoutMode = getLayoutMode();
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            layoutMode.l(z);
            this.a.d(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            C1();
            A1(bundle);
            registerListener(this.g);
            registerListener(this.f);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("userId", this.e);
        }
    }

    public final void A1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            if (bundle == null) {
                this.e = getIntent().getLongExtra("userId", 0L);
            } else {
                this.e = bundle.getLong("userId");
            }
            this.b = new PersonalTalkSettingModel(this, this, this.e);
            this.d = new m49(getPageContext(), getUniqueId());
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            cn7 cn7Var = new cn7(this);
            this.a = cn7Var;
            cn7Var.f(this);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingModel.g
    public void K() {
        PersonalTalkSettingModel personalTalkSettingModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            closeLoadingDialog();
            cn7 cn7Var = this.a;
            if (cn7Var != null && (personalTalkSettingModel = this.b) != null) {
                cn7Var.h(personalTalkSettingModel);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            this.b.U();
            this.d.l();
            MessageManager.getInstance().unRegisterListener(this.f);
        }
    }

    public final void D1(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                boolean isNotify = this.b.isNotify();
                this.b.setNotify(z2);
                this.a.b(z2);
                new e(this, z2).execute(new Void[0]);
                if (isNotify != this.b.isNotify()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                    return;
                }
                return;
            }
            bh.a().postDelayed(new f(this, z2), 500L);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void f0(View view2, BdSwitchView.SwitchState switchState) {
        cn7 cn7Var;
        PersonalTalkSettingModel personalTalkSettingModel;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, view2, switchState) != null) || view2 == null || (cn7Var = this.a) == null || cn7Var.n == null || (personalTalkSettingModel = this.b) == null || personalTalkSettingModel.getUid() != this.e) {
            return;
        }
        boolean z2 = true;
        if (view2 == this.a.n.getTopToChatSwitch()) {
            String valueOf = String.valueOf(this.e);
            if (BdSwitchView.SwitchState.ON != switchState) {
                z2 = false;
            }
            uj7.c(valueOf, z2);
            if (view2.getTag() != null) {
                an7.b("c14654", switchState);
                view2.setTag(null);
            }
        } else if (view2 == this.a.n.getChatNeglectSwitch()) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                closeLoadingDialog();
                showLoadingDialog(null);
                this.b.X(true);
            } else {
                closeLoadingDialog();
                showLoadingDialog(null);
                this.b.X(false);
            }
            if (view2.getTag() != null) {
                an7.b("c14631", switchState);
                view2.setTag(null);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        m49 m49Var;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f09259f) {
                PersonalTalkSettingModel personalTalkSettingModel = this.b;
                if (personalTalkSettingModel != null && personalTalkSettingModel.R() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.e), this.b.R().name)));
                    an7.a("c14629");
                }
            } else if (id == R.id.obfuscated_res_0x7f09205a) {
                wv4 wv4Var = new wv4(getPageContext().getPageActivity());
                wv4Var.setMessage(getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f106f)).setPositiveButton(R.string.alert_yes_button, new c(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f037e, new b(this)).create(getPageContext());
                wv4Var.show();
            } else if (id == R.id.obfuscated_res_0x7f09205b) {
                if (this.c == null && (runTask = MessageManager.getInstance().runTask(2921343, b49.class, getPageContext().getPageActivity())) != null) {
                    this.c = (b49) runTask.getData();
                }
                b49 b49Var = this.c;
                if (b49Var != null) {
                    b49Var.b(getUniqueId());
                    this.c.c(String.valueOf(this.e));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_PERSON_TALK_REPORT_CLICK).param("obj_locate", 2));
                }
                an7.a("c14635");
            } else if (id == R.id.obfuscated_res_0x7f09012d && (m49Var = this.d) != null && this.b != null) {
                m49Var.n(this.e);
            }
        }
    }
}
