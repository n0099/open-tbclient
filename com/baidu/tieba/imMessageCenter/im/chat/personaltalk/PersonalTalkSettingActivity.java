package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
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
import d.b.i0.r.s.a;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
import d.b.i0.z0.n;
import d.b.j0.e1.h.m;
import d.b.j0.f1.a.b.b.f;
/* loaded from: classes4.dex */
public class PersonalTalkSettingActivity extends BaseActivity<PersonalTalkSettingActivity> implements f.e, BdSwitchView.b {
    public d.b.j0.f1.a.b.b.f mModel;
    public d.b.j0.l3.a mUserReportController;
    public d.b.j0.f1.a.b.b.g mView;
    public d.b.c.c.g.c switchListener = new i(104102);
    public long userId;

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f17898e;

        public a(boolean z) {
            this.f17898e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            PersonalTalkSettingActivity.this.mView.e(null);
            PersonalTalkSettingActivity.this.mView.b(!this.f17898e);
            PersonalTalkSettingActivity.this.mView.e(PersonalTalkSettingActivity.this);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
            PersonalTalkSettingActivity.this.mModel.q(false);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {

        /* loaded from: classes4.dex */
        public class a extends f0<Boolean> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.b.i0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(m.t().o(String.valueOf(PersonalTalkSettingActivity.this.userId)));
            }
        }

        /* loaded from: classes4.dex */
        public class b implements n<Boolean> {
            public b() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.i0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Boolean bool) {
                PersonalTalkSettingActivity.this.closeLoadingDialog();
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ClearChatMsgResponsedMessage());
                PersonalTalkSettingActivity.this.showToast(R.string.delete_success, false);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(PersonalTalkSettingActivity.this.userId), 2, null, 1)));
            }
        }

        public e() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
            PersonalTalkSettingActivity.this.showLoadingDialog(null);
            h0.c(new a(), new b());
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.e {
        public f() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a.e {
        public g() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
            TiebaStatic.log("personalchat_morepage_addblack");
            PersonalTalkSettingActivity.this.mModel.q(true);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f17908e;

        public h(d.b.i0.r.s.a aVar) {
            this.f17908e = aVar;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            this.f17908e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class i extends d.b.c.c.g.c {
        public i(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            PersonalTalkSettingActivity.this.closeLoadingDialog();
            if ((socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage)) {
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) socketResponsedMessage.getOrginalMessage();
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                if (requestUpdateMaskInfoMessage.getMaskType() == 9) {
                    PersonalTalkSettingActivity.this.onSettingChanged(!responseUpdateMaskInfoMessage.hasError(), requestUpdateMaskInfoMessage.isSettingMask());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f17911a;

        public j(boolean z) {
            this.f17911a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (!this.f17911a) {
                d.b.j0.e1.t.e.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(PersonalTalkSettingActivity.this.userId), false);
                return null;
            }
            d.b.j0.e1.t.e.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(PersonalTalkSettingActivity.this.userId), true);
            return null;
        }
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            this.userId = getIntent().getLongExtra("userId", 0L);
        } else {
            this.userId = bundle.getLong("userId");
        }
        this.mModel = new d.b.j0.f1.a.b.b.f(this, this, this.userId);
    }

    private void initView() {
        d.b.j0.f1.a.b.b.g gVar = new d.b.j0.f1.a.b.b.g(this);
        this.mView = gVar;
        gVar.e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSettingChanged(boolean z, boolean z2) {
        if (z) {
            boolean m = this.mModel.m();
            this.mModel.o(z2);
            this.mView.b(z2);
            new j(z2).execute(new Void[0]);
            if (m != this.mModel.m()) {
                MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(3));
                return;
            }
            return;
        }
        d.b.c.e.m.e.a().postDelayed(new a(z2), 500L);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        if (z) {
            if (d.b.i0.s.d.d.d().s() && d.b.i0.s.d.d.d().p()) {
                closeLoadingDialog();
                showLoadingDialog(null);
                this.mModel.p(z);
                return;
            }
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(getActivity());
            aVar.setMessageId(R.string.error_open_personal_single_alloff);
            aVar.setNegativeButton(getResources().getString(R.string.group_create_private_isee), new h(aVar));
            aVar.create(getPageContext());
            aVar.show();
            onSettingChanged(false, z);
            return;
        }
        closeLoadingDialog();
        showLoadingDialog(null);
        this.mModel.p(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        getLayoutMode().k(i2 == 1);
        this.mView.d(i2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        CustomResponsedMessage runTask;
        int id = view.getId();
        if (id == R.id.user_info_lin) {
            d.b.j0.f1.a.b.b.f fVar = this.mModel;
            if (fVar == null || fVar.j() == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), String.valueOf(this.userId), this.mModel.j().name)));
        } else if (id == R.id.remove_from_black_man) {
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(getPageContext().getPageActivity());
            aVar.setMessage(getPageContext().getContext().getString(R.string.add_black_alert, this.mModel.j().nameShow)).setPositiveButton(R.string.alert_yes_button, new c()).setNegativeButton(R.string.cancel, new b()).create(getPageContext());
            aVar.show();
        } else if (id == R.id.st_delete_talk_history) {
            d.b.i0.r.s.a aVar2 = new d.b.i0.r.s.a(getPageContext().getPageActivity());
            aVar2.setMessage(getPageContext().getContext().getString(R.string.remove_personal_history)).setPositiveButton(R.string.alert_yes_button, new e()).setNegativeButton(R.string.cancel, new d()).create(getPageContext());
            aVar2.show();
        } else if (id == R.id.st_report) {
            if (this.mUserReportController == null && (runTask = MessageManager.getInstance().runTask(2921343, d.b.j0.l3.a.class, getPageContext().getPageActivity())) != null) {
                this.mUserReportController = (d.b.j0.l3.a) runTask.getData();
            }
            d.b.j0.l3.a aVar3 = this.mUserReportController;
            if (aVar3 != null) {
                aVar3.a(getUniqueId());
                this.mUserReportController.b(String.valueOf(this.userId));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_PERSON_TALK_REPORT_CLICK).param("obj_locate", 2));
            }
        } else if (id == R.id.add_to_black) {
            d.b.i0.r.s.a aVar4 = new d.b.i0.r.s.a(getPageContext().getPageActivity());
            aVar4.setTitle(getPageContext().getContext().getString(R.string.sure_add_somebody_to_black, this.mModel.j().nameShow));
            aVar4.setMessage(getPageContext().getContext().getString(R.string.remove_black_alert)).setPositiveButton(R.string.alert_yes_button, new g()).setNegativeButton(R.string.cancel, new f()).create(getPageContext());
            aVar4.show();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData(bundle);
        registerListener(205003, this.mModel.k());
        registerListener(104102, this.mModel.k());
        registerListener(2001115, this.mModel.i());
        registerListener(this.switchListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mModel.n();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("userId", this.userId);
    }

    @Override // d.b.j0.f1.a.b.b.f.e
    public void updateUI() {
        d.b.j0.f1.a.b.b.f fVar;
        closeLoadingDialog();
        d.b.j0.f1.a.b.b.g gVar = this.mView;
        if (gVar == null || (fVar = this.mModel) == null) {
            return;
        }
        gVar.g(fVar);
    }
}
