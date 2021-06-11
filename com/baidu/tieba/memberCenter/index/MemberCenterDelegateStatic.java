package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.m0.e0.c;
import d.a.m0.e0.d;
/* loaded from: classes3.dex */
public class MemberCenterDelegateStatic extends d.a.m0.e0.b {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f18303a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f18304b;

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c fragmentTabStructure;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                return;
            }
            MemberCenterDelegateStatic memberCenterDelegateStatic = new MemberCenterDelegateStatic();
            ((d) customResponsedMessage.getData()).a(memberCenterDelegateStatic);
            if (((d) customResponsedMessage.getData()).b() == null || (fragmentTabStructure = memberCenterDelegateStatic.getFragmentTabStructure()) == null) {
                return;
            }
            fragmentTabStructure.f53008a.setArguments(new Bundle());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                MemberCenterDelegateStatic.this.f18303a.setVisibility(8);
            } else if (!TbadkCoreApplication.isLogin()) {
                MemberCenterDelegateStatic.this.f18303a.setVisibility(8);
            } else {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
                if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() > j.l("maintab_member_center_red_tip_" + currentAccount, 0L)) {
                    MemberCenterDelegateStatic.this.f18303a.setVisibility(0);
                } else {
                    MemberCenterDelegateStatic.this.f18303a.setVisibility(8);
                }
            }
        }
    }

    static {
        new a(2007002);
    }

    @Override // d.a.m0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f53008a = new MemberCenterFragment();
        cVar.f53012e = 14;
        cVar.f53009b = R.string.member;
        return cVar;
    }

    @Override // d.a.m0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.f18303a = new ImageView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.f12937f = this.mIndicator;
        aVar.f12934c = l.e(context, 3.0f);
        ImageView imageView = this.f18303a;
        aVar.f12932a = imageView;
        aVar.f12935d = R.drawable.icon_news_down_bar_one;
        imageView.setVisibility(8);
        this.mIndicator.a("member_center_red_tip", aVar);
        return this.mIndicator;
    }

    @Override // d.a.m0.e0.b
    public boolean isAvailable() {
        return MainTabActivityConfig.MEMBER_CENTER_TAB_AVAILABLE;
    }

    @Override // d.a.m0.e0.b
    public void onAdd() {
        super.onAdd();
        this.f18304b = new b(2016459);
    }

    @Override // d.a.m0.e0.b
    public void onRemove() {
        super.onRemove();
        this.f18303a = null;
        MessageManager.getInstance().unRegisterListener(this.f18304b);
    }
}
