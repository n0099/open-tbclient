package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.os.Bundle;
import android.view.View;
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
import com.baidu.tieba.im.message.ClearChatMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ao8;
import com.repackage.dq4;
import com.repackage.e47;
import com.repackage.mc5;
import com.repackage.mg;
import com.repackage.p77;
import com.repackage.pc5;
import com.repackage.qn8;
import com.repackage.r57;
import com.repackage.r77;
import com.repackage.tb5;
import com.repackage.ya;
import com.repackage.z67;
/* loaded from: classes3.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements PersonalTalkSettingModel.g, BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener mBlockSyncSuccessListener;
    public PersonalTalkSettingModel mModel;
    public ao8 mUserBlockController;
    public qn8 mUserReportController;
    public r77 mView;
    public ya switchListener;
    public long userId;

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getError() != 0 || customResponsedMessage.getCmd() != 2921690 || this.a.mModel == null || this.a.mModel.i == null) {
                return;
            }
            this.a.mModel.i.E(this.a.userId);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalTalkSettingActivity a;

        /* loaded from: classes3.dex */
        public class a extends mc5<Boolean> {
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
            @Override // com.repackage.mc5
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(e47.v().p(String.valueOf(this.a.a.userId))) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes3.dex */
        public class b implements tb5<Boolean> {
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
            @Override // com.repackage.tb5
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    this.a.a.closeLoadingDialog();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ClearChatMsgResponsedMessage());
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f04b2, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.a.a.userId), 2, null, 1)));
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
                this.a.showLoadingDialog(null);
                pc5.c(new a(this), new b(this));
                p77.a("c14632");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ya {
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
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.closeLoadingDialog();
                if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage)) {
                    RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) socketResponsedMessage.getOrginalMessage();
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    if (responseUpdateMaskInfoMessage.getError() != 0 || responseUpdateMaskInfoMessage.hasError()) {
                        this.a.onSettingChanged(false, requestUpdateMaskInfoMessage.isSettingMask());
                    } else if (requestUpdateMaskInfoMessage.getMaskType() == 9) {
                        this.a.onSettingChanged(!responseUpdateMaskInfoMessage.hasError(), requestUpdateMaskInfoMessage.isSettingMask());
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    r57.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.b.userId), false);
                    return null;
                }
                r57.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.b.userId), true);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
                this.b.mView.f(null);
                this.b.mView.b(!this.a);
                this.b.mView.f(this.b);
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
        this.mBlockSyncSuccessListener = new a(this, 2921690);
        this.switchListener = new d(this, 104102);
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, bundle) == null) {
            if (bundle == null) {
                this.userId = getIntent().getLongExtra("userId", 0L);
            } else {
                this.userId = bundle.getLong("userId");
            }
            this.mModel = new PersonalTalkSettingModel(this, this, this.userId);
            this.mUserBlockController = new ao8(getPageContext(), getUniqueId());
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            r77 r77Var = new r77(this);
            this.mView = r77Var;
            r77Var.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSettingChanged(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                boolean M = this.mModel.M();
                this.mModel.Q(z2);
                this.mView.b(z2);
                new e(this, z2).execute(new Void[0]);
                if (M != this.mModel.M()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                    return;
                }
                return;
            }
            mg.a().postDelayed(new f(this, z2), 500L);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view2, BdSwitchView.SwitchState switchState) {
        r77 r77Var;
        PersonalTalkSettingModel personalTalkSettingModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) || view2 == null || (r77Var = this.mView) == null || r77Var.n == null || (personalTalkSettingModel = this.mModel) == null || personalTalkSettingModel.getUid() != this.userId) {
            return;
        }
        if (view2 == this.mView.n.getTopToChatSwitch()) {
            z67.c(String.valueOf(this.userId), BdSwitchView.SwitchState.ON == switchState);
            if (view2.getTag() != null) {
                p77.b("c14654", switchState);
                view2.setTag(null);
            }
        } else if (view2 == this.mView.n.getChatNeglectSwitch()) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                closeLoadingDialog();
                showLoadingDialog(null);
                this.mModel.R(true);
            } else {
                closeLoadingDialog();
                showLoadingDialog(null);
                this.mModel.R(false);
            }
            if (view2.getTag() != null) {
                p77.b("c14631", switchState);
                view2.setTag(null);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            getLayoutMode().k(i == 1);
            this.mView.d(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        ao8 ao8Var;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f092290) {
                PersonalTalkSettingModel personalTalkSettingModel = this.mModel;
                if (personalTalkSettingModel == null || personalTalkSettingModel.J() == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.mModel.J().name)));
                p77.a("c14629");
            } else if (id == R.id.obfuscated_res_0x7f091d80) {
                dq4 dq4Var = new dq4(getPageContext().getPageActivity());
                dq4Var.setMessage(getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f0fae)).setPositiveButton(R.string.obfuscated_res_0x7f0f0260, new c(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new b(this)).create(getPageContext());
                dq4Var.show();
            } else if (id != R.id.obfuscated_res_0x7f091d81) {
                if (id != R.id.obfuscated_res_0x7f09011a || (ao8Var = this.mUserBlockController) == null || this.mModel == null) {
                    return;
                }
                ao8Var.n(this.userId);
            } else {
                if (this.mUserReportController == null && (runTask = MessageManager.getInstance().runTask(2921343, qn8.class, getPageContext().getPageActivity())) != null) {
                    this.mUserReportController = (qn8) runTask.getData();
                }
                qn8 qn8Var = this.mUserReportController;
                if (qn8Var != null) {
                    qn8Var.b(getUniqueId());
                    this.mUserReportController.c(String.valueOf(this.userId));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_PERSON_TALK_REPORT_CLICK).param("obj_locate", 2));
                }
                p77.a("c14635");
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            initView();
            initData(bundle);
            registerListener(this.switchListener);
            registerListener(this.mBlockSyncSuccessListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            this.mModel.N();
            this.mUserBlockController.l();
            MessageManager.getInstance().unRegisterListener(this.mBlockSyncSuccessListener);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("userId", this.userId);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingModel.g
    public void updateUI() {
        PersonalTalkSettingModel personalTalkSettingModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            closeLoadingDialog();
            r77 r77Var = this.mView;
            if (r77Var == null || (personalTalkSettingModel = this.mModel) == null) {
                return;
            }
            r77Var.h(personalTalkSettingModel);
        }
    }
}
