package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tieba.R;
import d.b.j0.e1.h.e;
import d.b.j0.f1.b.h;
/* loaded from: classes4.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.j {

    /* renamed from: e  reason: collision with root package name */
    public h f17998e;

    /* renamed from: f  reason: collision with root package name */
    public VoiceManager f17999f;

    /* renamed from: g  reason: collision with root package name */
    public TbTabLayout.c f18000g = new a();

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f18001h = new b(2001384);
    public final CustomMessageListener i = new c(2001626);

    /* loaded from: classes4.dex */
    public class a implements TbTabLayout.c {
        public a() {
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void b(TbTabLayout.f fVar) {
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void d(TbTabLayout.f fVar) {
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void f(TbTabLayout.f fVar) {
            if (fVar == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.f17998e != null) {
                MessageCenterFragment.this.f17998e.q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.I0(customResponsedMessage);
            }
        }
    }

    public void G0() {
        getActivity().finish();
    }

    public void H0() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    public final void I0(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null || (responsedMessage instanceof NewsRemindMessage)) {
            return;
        }
        BdLog.e("transform error");
    }

    public final void J0(Intent intent, Bundle bundle) {
        h hVar = this.f17998e;
        if (hVar != null) {
            hVar.s(1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.f17998e != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        if (this.f17999f == null) {
            this.f17999f = VoiceManager.instance();
        }
        return this.f17999f;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        h hVar = this.f17998e;
        if (hVar != null) {
            hVar.n(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        h hVar = this.f17998e;
        if (hVar != null) {
            hVar.onChangeSkinType(this.mSkinType);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.f18001h);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        h hVar = new h(this);
        this.f17998e = hVar;
        hVar.k(inflate, bundle);
        this.f17998e.s(2);
        this.f17998e.e(this.f18000g);
        this.i.setPriority(Integer.MAX_VALUE);
        registerListener(this.i);
        J0(getActivity().getIntent(), bundle);
        VoiceManager voiceManager = getVoiceManager();
        this.f17999f = voiceManager;
        voiceManager.onCreate(getPageContext());
        TiebaStatic.log(new StatisticItem("c11941"));
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        e.m().c();
        MessageManager.getInstance().unRegisterListener(this.i);
        h hVar = this.f17998e;
        if (hVar != null) {
            hVar.o();
            this.f17998e.r(this.f18000g);
        }
        VoiceManager voiceManager = this.f17999f;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
    }

    public void onNewIntent(Intent intent) {
        e.m().c();
        if (this.f17999f == null) {
            VoiceManager voiceManager = getVoiceManager();
            this.f17999f = voiceManager;
            voiceManager.onCreate(getPageContext());
        }
        if (intent != null) {
            J0(intent, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        VoiceManager voiceManager = this.f17999f;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        VoiceManager voiceManager = this.f17999f;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.f f2;
        h hVar = this.f17998e;
        if (hVar == null || (f2 = hVar.f()) == null) {
            return;
        }
        bundle.putInt("Selected_Tab", f2.d());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = this.f17999f;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        VoiceManager voiceManager = this.f17999f;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        h hVar = this.f17998e;
        if (hVar != null) {
            hVar.u(z);
        }
    }
}
