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
import d.b.i0.e1.b.e;
/* loaded from: classes3.dex */
public class ChatAggregationFragment extends BaseFragment implements d.b.h0.g0.c.a, NoNetworkView.b {

    /* renamed from: e  reason: collision with root package name */
    public e f18307e;

    /* renamed from: f  reason: collision with root package name */
    public ViewEventCenter f18308f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f18309g = new a(2005016);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f18310h = new b(2016321);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            if (ChatAggregationFragment.this.f18307e != null) {
                ChatAggregationFragment.this.f18307e.r0(true);
            }
            MentionActivityConfig.newJumpIn = true;
            if (ChatAggregationFragment.this.f18307e != null) {
                ChatAggregationFragment.this.f18307e.O();
                ChatAggregationFragment.this.f18307e.w0(TbadkCoreApplication.isLogin(), true ^ TbadkCoreApplication.isLogin());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (ChatAggregationFragment.this.f18307e != null) {
                    ChatAggregationFragment.this.f18307e.U(intent);
                }
            }
        }
    }

    public ViewEventCenter F0() {
        if (this.f18308f == null) {
            this.f18308f = new ViewEventCenter();
        }
        return this.f18308f;
    }

    public final boolean G0(Intent intent) {
        return (intent == null || intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1) == -1) ? false : true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void b(boolean z) {
        e eVar = this.f18307e;
        if (eVar != null) {
            eVar.T(z);
        }
    }

    @Override // d.b.h0.g0.c.a
    public boolean isEventMustSelf() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 12011) {
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
    public void onChangeSkinType(int i) {
        e eVar = this.f18307e;
        if (eVar != null) {
            eVar.P(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        e eVar = new e(this);
        this.f18307e = eVar;
        if (bundle != null) {
            eVar.L(bundle);
        } else {
            eVar.L(null);
        }
        View R = this.f18307e.R();
        this.f18307e.P(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        F0().addEventDelegate(this);
        registerListener(this.f18309g);
        registerListener(this.f18310h);
        return R;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.f18309g);
        MessageManager.getInstance().unRegisterListener(this.f18310h);
        e eVar = this.f18307e;
        if (eVar != null) {
            eVar.M();
        }
    }

    @Override // d.b.h0.g0.c.a
    public boolean onEventDispatch(d.b.h0.g0.c.b bVar) {
        return bVar == null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        e eVar = this.f18307e;
        if (eVar != null) {
            eVar.E();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (getActivity() != null && G0(getActivity().getIntent())) {
            this.f18307e.U(getActivity().getIntent());
        } else {
            this.f18307e.O();
        }
        super.onViewCreated(view, bundle);
    }

    public void w() {
        e eVar = this.f18307e;
        if (eVar != null) {
            eVar.n0();
        }
    }
}
