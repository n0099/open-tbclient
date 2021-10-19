package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.os.Bundle;
import android.view.View;
import c.a.q0.d1.i0;
import c.a.q0.d1.l0;
import c.a.q0.d1.q;
import c.a.q0.s.s.a;
import c.a.r0.l1.h.m;
import c.a.r0.m1.a.b.b.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements f.e, BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.m1.a.b.b.f mModel;
    public c.a.r0.s3.a mUserReportController;
    public c.a.r0.m1.a.b.b.g mView;
    public c.a.e.c.g.c switchListener;
    public long userId;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f53444e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PersonalTalkSettingActivity f53445f;

        public a(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingActivity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53445f = personalTalkSettingActivity;
            this.f53444e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53445f.mView.e(null);
                this.f53445f.mView.b(!this.f53444e);
                this.f53445f.mView.e(this.f53445f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalTalkSettingActivity f53446e;

        public b(PersonalTalkSettingActivity personalTalkSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53446e = personalTalkSettingActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalTalkSettingActivity f53447e;

        public c(PersonalTalkSettingActivity personalTalkSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53447e = personalTalkSettingActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f53447e.mModel.q(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalTalkSettingActivity f53448e;

        public d(PersonalTalkSettingActivity personalTalkSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53448e = personalTalkSettingActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalTalkSettingActivity f53449e;

        /* loaded from: classes7.dex */
        public class a extends i0<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f53450a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53450a = eVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // c.a.q0.d1.i0
            public Boolean doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(m.t().o(String.valueOf(this.f53450a.f53449e.userId))) : (Boolean) invokeV.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public class b implements q<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f53451a;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53451a = eVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.q0.d1.q
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                    this.f53451a.f53449e.closeLoadingDialog();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new ClearChatMsgResponsedMessage());
                    this.f53451a.f53449e.showToast(R.string.delete_success, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.f53451a.f53449e.userId), 2, null, 1)));
                }
            }
        }

        public e(PersonalTalkSettingActivity personalTalkSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53449e = personalTalkSettingActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f53449e.showLoadingDialog(null);
                l0.c(new a(this), new b(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalTalkSettingActivity f53452e;

        public f(PersonalTalkSettingActivity personalTalkSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53452e = personalTalkSettingActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalTalkSettingActivity f53453e;

        public g(PersonalTalkSettingActivity personalTalkSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53453e = personalTalkSettingActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                TiebaStatic.log("personalchat_morepage_addblack");
                this.f53453e.mModel.q(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f53454e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PersonalTalkSettingActivity f53455f;

        public h(PersonalTalkSettingActivity personalTalkSettingActivity, c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53455f = personalTalkSettingActivity;
            this.f53454e = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f53454e.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalTalkSettingActivity f53456a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PersonalTalkSettingActivity personalTalkSettingActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingActivity, Integer.valueOf(i2)};
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
            this.f53456a = personalTalkSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.f53456a.closeLoadingDialog();
                if ((socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage)) {
                    RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) socketResponsedMessage.getOrginalMessage();
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    if (requestUpdateMaskInfoMessage.getMaskType() == 9) {
                        this.f53456a.onSettingChanged(!responseUpdateMaskInfoMessage.hasError(), requestUpdateMaskInfoMessage.isSettingMask());
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f53457a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalTalkSettingActivity f53458b;

        public j(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalTalkSettingActivity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53458b = personalTalkSettingActivity;
            this.f53457a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                if (!this.f53457a) {
                    c.a.r0.l1.t.e.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f53458b.userId), false);
                    return null;
                }
                c.a.r0.l1.t.e.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f53458b.userId), true);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public PersonalTalkSettingActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.switchListener = new i(this, 104102);
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bundle) == null) {
            if (bundle == null) {
                this.userId = getIntent().getLongExtra("userId", 0L);
            } else {
                this.userId = bundle.getLong("userId");
            }
            this.mModel = new c.a.r0.m1.a.b.b.f(this, this, this.userId);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            c.a.r0.m1.a.b.b.g gVar = new c.a.r0.m1.a.b.b.g(this);
            this.mView = gVar;
            gVar.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSettingChanged(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                boolean m = this.mModel.m();
                this.mModel.o(z2);
                this.mView.b(z2);
                new j(this, z2).execute(new Void[0]);
                if (m != this.mModel.m()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                    return;
                }
                return;
            }
            c.a.e.e.m.e.a().postDelayed(new a(this, z2), 500L);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
            boolean z = BdSwitchView.SwitchState.ON == switchState;
            if (z) {
                if (c.a.q0.t.d.d.d().s() && c.a.q0.t.d.d.d().p()) {
                    closeLoadingDialog();
                    showLoadingDialog(null);
                    this.mModel.p(z);
                    return;
                }
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getActivity());
                aVar.setMessageId(R.string.error_open_personal_single_alloff);
                aVar.setNegativeButton(getResources().getString(R.string.group_create_private_isee), new h(this, aVar));
                aVar.create(getPageContext());
                aVar.show();
                onSettingChanged(false, z);
                return;
            }
            closeLoadingDialog();
            showLoadingDialog(null);
            this.mModel.p(z);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(i2 == 1);
            this.mView.d(i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            int id = view.getId();
            if (id == R.id.user_info_lin) {
                c.a.r0.m1.a.b.b.f fVar = this.mModel;
                if (fVar == null || fVar.j() == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.mModel.j().name)));
            } else if (id == R.id.remove_from_black_man) {
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getPageContext().getPageActivity());
                aVar.setMessage(getPageContext().getContext().getString(R.string.add_black_alert, this.mModel.j().nameShow)).setPositiveButton(R.string.alert_yes_button, new c(this)).setNegativeButton(R.string.cancel, new b(this)).create(getPageContext());
                aVar.show();
            } else if (id == R.id.st_delete_talk_history) {
                c.a.q0.s.s.a aVar2 = new c.a.q0.s.s.a(getPageContext().getPageActivity());
                aVar2.setMessage(getPageContext().getContext().getString(R.string.remove_personal_history)).setPositiveButton(R.string.alert_yes_button, new e(this)).setNegativeButton(R.string.cancel, new d(this)).create(getPageContext());
                aVar2.show();
            } else if (id == R.id.st_report) {
                if (this.mUserReportController == null && (runTask = MessageManager.getInstance().runTask(2921343, c.a.r0.s3.a.class, getPageContext().getPageActivity())) != null) {
                    this.mUserReportController = (c.a.r0.s3.a) runTask.getData();
                }
                c.a.r0.s3.a aVar3 = this.mUserReportController;
                if (aVar3 != null) {
                    aVar3.b(getUniqueId());
                    this.mUserReportController.c(String.valueOf(this.userId));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_PERSON_TALK_REPORT_CLICK).param("obj_locate", 2));
                }
            } else if (id == R.id.add_to_black) {
                c.a.q0.s.s.a aVar4 = new c.a.q0.s.s.a(getPageContext().getPageActivity());
                aVar4.setTitle(getPageContext().getContext().getString(R.string.sure_add_somebody_to_black, this.mModel.j().nameShow));
                aVar4.setMessage(getPageContext().getContext().getString(R.string.remove_black_alert)).setPositiveButton(R.string.alert_yes_button, new g(this)).setNegativeButton(R.string.cancel, new f(this)).create(getPageContext());
                aVar4.show();
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
            registerListener(205003, this.mModel.k());
            registerListener(104102, this.mModel.k());
            registerListener(2001115, this.mModel.i());
            registerListener(this.switchListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            this.mModel.n();
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

    @Override // c.a.r0.m1.a.b.b.f.e
    public void updateUI() {
        c.a.r0.m1.a.b.b.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            closeLoadingDialog();
            c.a.r0.m1.a.b.b.g gVar = this.mView;
            if (gVar == null || (fVar = this.mModel) == null) {
                return;
            }
            gVar.g(fVar);
        }
    }
}
