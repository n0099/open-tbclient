package com.baidu.tieba.personCenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.m0.z0.n;
/* loaded from: classes5.dex */
public class PersonCenterFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public long f19729e;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.h2.d.b f19733i;
    public String k;
    public String l;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19730f = true;
    @Deprecated

    /* renamed from: g  reason: collision with root package name */
    public boolean f19731g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19732h = false;
    public long j = 0;
    public boolean m = false;
    public CustomMessageListener n = new a(2016560);
    public CustomMessageListener o = new b(2921033);
    public CustomMessageListener p = new c(2921378);
    public MessageQueue.IdleHandler q = new f();

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016560) {
                PersonCenterFragment.this.L0(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !PersonCenterFragment.this.f19730f) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str = (String) data;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                PersonCenterFragment.this.k = str;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !PersonCenterFragment.this.f19730f) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                PersonCenterFragment.this.l = (String) data;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends f0<Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.m0.z0.f0
        public Boolean doInBackground() {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_FEEDBACK_TIP);
            netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
            String postNetData = netWork.postNetData();
            d.a.n0.h2.e.b bVar = new d.a.n0.h2.e.b();
            bVar.c(postNetData);
            if (bVar.b() == 0 && bVar.a() > 0) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements n<Boolean> {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            if (bool.booleanValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016561, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements MessageQueue.IdleHandler {
        public f() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            PersonCenterFragment.this.M0();
            return false;
        }
    }

    public final void L0(boolean z) {
        if (!z) {
            M0();
        } else if (getPageContext() == null || getPageContext().getPageActivity() == null) {
        } else {
            Looper.myQueue().removeIdleHandler(this.q);
            Looper.myQueue().addIdleHandler(this.q);
        }
    }

    public final void M0() {
        long l = d.a.m0.r.d0.b.j().l("key_feedback_tip", 0L);
        if (!TbadkCoreApplication.isLogin() || System.currentTimeMillis() - l <= StringHelper.MS_TO_HOUR * 4) {
            return;
        }
        h0.b(new d(), new e());
        d.a.m0.r.d0.b.j().w("key_feedback_tip", System.currentTimeMillis());
    }

    public final void N0(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.f19729e = intent.getLongExtra("user_id", d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.f19730f = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.f19731g = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
        } else if (bundle != null) {
            this.f19729e = bundle.getLong("user_id", d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.f19730f = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.f19731g = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.m0.k0.a
    public String getCurrentPageKey() {
        if (this.f19732h) {
            return null;
        }
        return "a011";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        d.a.n0.h2.a.d().h(System.currentTimeMillis() - d.a.n0.h2.a.d().a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.f19732h = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
        getPageStayDurationItem().k = "1";
        L0(true);
        MessageManager.getInstance().registerListener(this.n);
        MessageManager.getInstance().registerListener(this.o);
        MessageManager.getInstance().registerListener(this.p);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.n0.h2.d.b bVar = this.f19733i;
        if (bVar != null) {
            bVar.f(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        d.a.n0.h2.a.d().g(System.currentTimeMillis());
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        N0(bundle);
        View inflate = layoutInflater.inflate(R.layout.fragment_my_tab_layout, (ViewGroup) null);
        d.a.n0.h2.d.b bVar = new d.a.n0.h2.d.b(inflate, getPageContext(), getUniqueId());
        this.f19733i = bVar;
        bVar.e();
        this.m = false;
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            this.f19733i.j();
            this.m = true;
        }
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.n0.h2.d.b bVar = this.f19733i;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.n);
        MessageManager.getInstance().unRegisterListener(this.o);
        MessageManager.getInstance().unRegisterListener(this.p);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.j > 0) {
            TiebaStatic.log(new StatisticItem("c12263").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf((System.currentTimeMillis() - this.j) / 1000)).param("obj_type", 2));
            this.j = 0L;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        this.f19733i.k(isPrimary());
        if (isPrimary()) {
            if (!this.m) {
                this.m = true;
                this.f19733i.j();
            }
            if (!StringUtils.isNull(this.k)) {
                this.f19733i.i(this.k);
                this.k = null;
            }
            if (!StringUtils.isNull(this.l)) {
                this.f19733i.h(this.l);
                this.l = null;
            } else {
                this.f19733i.j();
            }
            this.f19733i.l();
            d.a.m0.r.d0.b.j().t("key_feedback_tip_tab_show", false);
            if (TbSingleton.getInstance().isShowShoubaiDynamicGuide()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921423));
            }
        } else {
            this.f19733i.d();
        }
        if (isAdded()) {
            d.a.n0.u2.a.v().F();
        }
        d.a.n0.u2.a.v().I(isPrimary());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.f19730f && this.f19731g) {
            this.j = System.currentTimeMillis();
        } else {
            this.j = -1L;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putLong("user_id", this.f19729e);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_USER_SELF, this.f19730f);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_BIGV, this.f19731g);
        }
    }
}
