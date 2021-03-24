package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment;
import com.vivo.push.PushClientConstants;
import d.b.h0.e0.c;
import d.b.h0.e0.d;
/* loaded from: classes4.dex */
public class ImMessageCenterDelegateStatic extends d.b.h0.e0.b {

    /* renamed from: a  reason: collision with root package name */
    public MessageRedDotView f18208a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f18209b;

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                return;
            }
            ((d) customResponsedMessage.getData()).a(new ImMessageCenterDelegateStatic());
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
            int i;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Pair)) {
                boolean z = false;
                try {
                    Pair pair = (Pair) customResponsedMessage.getData();
                    i = ((Integer) pair.first).intValue();
                    try {
                        z = ((Boolean) pair.second).booleanValue();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    i = 0;
                }
                ImMessageCenterDelegateStatic.this.b(z, i);
            }
        }
    }

    static {
        a aVar = new a(2007002);
        aVar.setPriority(7);
        MessageManager.getInstance().registerListener(aVar);
    }

    public final void b(boolean z, int i) {
        MessageRedDotView messageRedDotView = this.f18208a;
        if (messageRedDotView == null) {
            return;
        }
        if (z) {
            messageRedDotView.setThreeDotMode(2);
            this.f18208a.f(i);
            this.f18208a.setVisibility(0);
            if (TbSingleton.getInstance().isShowVivoBadge()) {
                c(this.f18208a.getContext(), i);
                return;
            }
            return;
        }
        messageRedDotView.setVisibility(8);
        if (TbSingleton.getInstance().isShowVivoBadge()) {
            c(this.f18208a.getContext(), 0);
        }
    }

    public final void c(Context context, int i) {
        Intent intent = new Intent();
        intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        intent.putExtra(InstallAntiBlockingActivity.PARAM_PACKAGE_NAME, "com.baidu.tieba");
        intent.putExtra(PushClientConstants.TAG_CLASS_NAME, "com.baidu.tieba.LogoActivity");
        intent.putExtra("notificationNum", i);
        intent.addFlags(16777216);
        context.sendBroadcast(intent);
    }

    @Override // d.b.h0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f50154a = new MessageCenterFragment();
        cVar.f50158e = 3;
        cVar.f50155b = R.string.my_message;
        cVar.f50159f = R.raw.lottie_tab_msg;
        cVar.f50161h = c.k;
        return cVar;
    }

    @Override // d.b.h0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.f18208a = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        TbFragmentTabIndicator tbFragmentTabIndicator = this.mIndicator;
        aVar.f13960f = tbFragmentTabIndicator;
        aVar.f13955a = this.f18208a;
        aVar.f13956b = true;
        tbFragmentTabIndicator.b("msg", aVar);
        this.f18208a.setVisibility(4);
        if (!TbSingleton.getInstance().isShowVivoBadge()) {
            c(this.f18208a.getContext(), 0);
        }
        return this.mIndicator;
    }

    @Override // d.b.h0.e0.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // d.b.h0.e0.b
    public void onAdd() {
        this.f18209b = new b(2921002);
        MessageManager.getInstance().registerListener(this.f18209b);
    }

    @Override // d.b.h0.e0.b
    public void onRemove() {
        super.onRemove();
        MessageManager.getInstance().unRegisterListener(this.f18209b);
    }
}
