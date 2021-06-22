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
import d.a.o0.f1.h.e;
import d.a.o0.g1.b.h;
/* loaded from: classes4.dex */
public class MessageCenterFragment extends BaseFragment implements VoiceManager.j {

    /* renamed from: e  reason: collision with root package name */
    public h f17722e;

    /* renamed from: f  reason: collision with root package name */
    public VoiceManager f17723f;

    /* renamed from: g  reason: collision with root package name */
    public TbTabLayout.c f17724g = new a();

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f17725h = new b(2001384);

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f17726i = new c(2001626);

    /* loaded from: classes4.dex */
    public class a implements TbTabLayout.c {
        public a() {
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void a(TbTabLayout.f fVar) {
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void c(TbTabLayout.f fVar) {
        }

        @Override // com.baidu.adp.widget.design.TbTabLayout.c
        public void e(TbTabLayout.f fVar) {
            if (fVar == null) {
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
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && MessageCenterFragment.this.isPrimary() && MessageCenterFragment.this.f17722e != null) {
                MessageCenterFragment.this.f17722e.p();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MessageCenterFragment.this.K0(customResponsedMessage);
            }
        }
    }

    public void I0() {
        getActivity().finish();
    }

    public void J0() {
        AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getContext(), 0, false);
        atListActivityConfig.setIsForChat(true);
        sendMessage(new CustomMessage(2002001, atListActivityConfig));
        TiebaStatic.log("c12929");
    }

    public final void K0(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null || (responsedMessage instanceof NewsRemindMessage)) {
            return;
        }
        BdLog.e("transform error");
    }

    public final void L0(Intent intent, Bundle bundle) {
        h hVar = this.f17722e;
        if (hVar != null) {
            hVar.r(1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i2) {
        if (this.f17722e != null) {
            super.changeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        if (this.f17723f == null) {
            this.f17723f = VoiceManager.instance();
        }
        return this.f17723f;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        h hVar = this.f17722e;
        if (hVar != null) {
            hVar.n(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        h hVar = this.f17722e;
        if (hVar != null) {
            hVar.onChangeSkinType(this.mSkinType);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.f17725h);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_center_activity, viewGroup, false);
        h hVar = new h(this);
        this.f17722e = hVar;
        hVar.k(inflate, bundle);
        this.f17722e.r(2);
        this.f17722e.e(this.f17724g);
        this.f17726i.setPriority(Integer.MAX_VALUE);
        registerListener(this.f17726i);
        L0(getActivity().getIntent(), bundle);
        VoiceManager voiceManager = getVoiceManager();
        this.f17723f = voiceManager;
        voiceManager.onCreate(getPageContext());
        TiebaStatic.log(new StatisticItem("c11941"));
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        e.m().c();
        MessageManager.getInstance().unRegisterListener(this.f17726i);
        h hVar = this.f17722e;
        if (hVar != null) {
            hVar.o();
            this.f17722e.q(this.f17724g);
        }
        VoiceManager voiceManager = this.f17723f;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
    }

    public void onNewIntent(Intent intent) {
        e.m().c();
        if (this.f17723f == null) {
            VoiceManager voiceManager = getVoiceManager();
            this.f17723f = voiceManager;
            voiceManager.onCreate(getPageContext());
        }
        if (intent != null) {
            L0(intent, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        VoiceManager voiceManager = this.f17723f;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        VoiceManager voiceManager = this.f17723f;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        TbTabLayout.f f2;
        h hVar = this.f17722e;
        if (hVar == null || (f2 = hVar.f()) == null) {
            return;
        }
        bundle.putInt("Selected_Tab", f2.d());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = this.f17723f;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        VoiceManager voiceManager = this.f17723f;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        h hVar = this.f17722e;
        if (hVar != null) {
            hVar.s(z);
        }
    }
}
