package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import d.a.n0.g1.b.e;
/* loaded from: classes4.dex */
public class ChatAggregationFragment extends BaseFragment implements d.a.m0.g0.c.a, NoNetworkView.b {

    /* renamed from: e  reason: collision with root package name */
    public e f17558e;

    /* renamed from: f  reason: collision with root package name */
    public ViewEventCenter f17559f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f17560g = new a(2005016);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f17561h = new b(2016321);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            if (ChatAggregationFragment.this.f17558e != null) {
                ChatAggregationFragment.this.f17558e.p0(true);
            }
            MentionActivityConfig.newJumpIn = true;
            if (ChatAggregationFragment.this.f17558e != null) {
                ChatAggregationFragment.this.f17558e.L();
                ChatAggregationFragment.this.f17558e.w0(TbadkCoreApplication.isLogin(), true ^ TbadkCoreApplication.isLogin());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (ChatAggregationFragment.this.f17558e != null) {
                    ChatAggregationFragment.this.f17558e.S(intent);
                }
            }
        }
    }

    public ViewEventCenter E0() {
        if (this.f17559f == null) {
            this.f17559f = new ViewEventCenter();
        }
        return this.f17559f;
    }

    public final boolean F0(Intent intent) {
        return (intent == null || intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1) == -1) ? false : true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void b(boolean z) {
        e eVar = this.f17558e;
        if (eVar != null) {
            eVar.R(z);
        }
    }

    @Override // d.a.m0.g0.c.a
    public boolean isEventMustSelf() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 12011) {
            Bundle extras = intent.getExtras();
            String string = extras.getString("user_id");
            String string2 = extras.getString("user_name");
            String string3 = extras.getString("name_show");
            String string4 = extras.getString("portrait");
            if (string2 == null || string == null) {
                return;
            }
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getActivity(), Long.parseLong(string), string2, string3, string4, 0)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        e eVar = this.f17558e;
        if (eVar != null) {
            eVar.N(getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        e eVar = new e(this);
        this.f17558e = eVar;
        if (bundle != null) {
            eVar.J(bundle);
        } else {
            eVar.J(null);
        }
        View P = this.f17558e.P();
        this.f17558e.N(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        E0().addEventDelegate(this);
        registerListener(this.f17560g);
        registerListener(this.f17561h);
        return P;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.f17560g);
        MessageManager.getInstance().unRegisterListener(this.f17561h);
        e eVar = this.f17558e;
        if (eVar != null) {
            eVar.K();
        }
    }

    @Override // d.a.m0.g0.c.a
    public boolean onEventDispatch(d.a.m0.g0.c.b bVar) {
        return bVar == null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        e eVar = this.f17558e;
        if (eVar != null) {
            eVar.A();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (getActivity() != null && F0(getActivity().getIntent())) {
            this.f17558e.S(getActivity().getIntent());
        } else {
            this.f17558e.L();
        }
        super.onViewCreated(view, bundle);
    }

    public void p() {
        e eVar = this.f17558e;
        if (eVar != null) {
            eVar.j0();
        }
    }
}
