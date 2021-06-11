package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment;
import com.vivo.push.PushClientConstants;
import d.a.m0.e0.c;
import d.a.m0.e0.d;
/* loaded from: classes4.dex */
public class ImMessageCenterDelegateStatic extends d.a.m0.e0.b {

    /* renamed from: a  reason: collision with root package name */
    public MessageRedDotView f17530a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f17531b;

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
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
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i2;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Pair)) {
                boolean z = false;
                try {
                    Pair pair = (Pair) customResponsedMessage.getData();
                    i2 = ((Integer) pair.first).intValue();
                    try {
                        z = ((Boolean) pair.second).booleanValue();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    i2 = 0;
                }
                ImMessageCenterDelegateStatic.this.b(z, i2);
            }
        }
    }

    static {
        a aVar = new a(2007002);
        aVar.setPriority(7);
        MessageManager.getInstance().registerListener(aVar);
    }

    public final void b(boolean z, int i2) {
        MessageRedDotView messageRedDotView = this.f17530a;
        if (messageRedDotView == null) {
            return;
        }
        if (z) {
            messageRedDotView.setThreeDotMode(2);
            this.f17530a.f(i2);
            this.f17530a.setVisibility(0);
            if (TbSingleton.getInstance().isShowVivoBadge()) {
                c(this.f17530a.getContext(), i2);
                return;
            }
            return;
        }
        messageRedDotView.setVisibility(8);
        if (TbSingleton.getInstance().isShowVivoBadge()) {
            c(this.f17530a.getContext(), 0);
        }
    }

    public final void c(Context context, int i2) {
        Intent intent = new Intent();
        intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        intent.putExtra("packageName", "com.baidu.tieba");
        intent.putExtra(PushClientConstants.TAG_CLASS_NAME, "com.baidu.tieba.LogoActivity");
        intent.putExtra("notificationNum", i2);
        intent.addFlags(16777216);
        context.sendBroadcast(intent);
    }

    @Override // d.a.m0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f53008a = new MessageCenterFragment();
        cVar.f53012e = 3;
        cVar.f53009b = R.string.my_message;
        cVar.f53013f = R.raw.lottie_tab_msg;
        cVar.f53016i = c.l;
        cVar.f53015h = d.a.m0.e0.e.c.d().c("message");
        return cVar;
    }

    @Override // d.a.m0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.f17530a = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        TbFragmentTabIndicator tbFragmentTabIndicator = this.mIndicator;
        aVar.f12937f = tbFragmentTabIndicator;
        aVar.f12932a = this.f17530a;
        aVar.f12933b = true;
        tbFragmentTabIndicator.b("msg", aVar);
        this.f17530a.setVisibility(4);
        if (!TbSingleton.getInstance().isShowVivoBadge()) {
            c(this.f17530a.getContext(), 0);
        }
        return this.mIndicator;
    }

    @Override // d.a.m0.e0.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // d.a.m0.e0.b
    public void onAdd() {
        this.f17531b = new b(2921002);
        MessageManager.getInstance().registerListener(this.f17531b);
    }

    @Override // d.a.m0.e0.b
    public void onRemove() {
        super.onRemove();
        MessageManager.getInstance().unRegisterListener(this.f17531b);
    }
}
