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
import d.b.c.e.p.l;
import d.b.h0.e0.c;
import d.b.h0.e0.d;
/* loaded from: classes3.dex */
public class MemberCenterDelegateStatic extends d.b.h0.e0.b {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f18601a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f18602b;

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
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
            fragmentTabStructure.f50548a.setArguments(new Bundle());
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                MemberCenterDelegateStatic.this.f18601a.setVisibility(8);
            } else if (!TbadkCoreApplication.isLogin()) {
                MemberCenterDelegateStatic.this.f18601a.setVisibility(8);
            } else {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                d.b.h0.r.d0.b j = d.b.h0.r.d0.b.j();
                if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() > j.l("maintab_member_center_red_tip_" + currentAccount, 0L)) {
                    MemberCenterDelegateStatic.this.f18601a.setVisibility(0);
                } else {
                    MemberCenterDelegateStatic.this.f18601a.setVisibility(8);
                }
            }
        }
    }

    static {
        new a(2007002);
    }

    @Override // d.b.h0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f50548a = new MemberCenterFragment();
        cVar.f50552e = 14;
        cVar.f50549b = R.string.member;
        return cVar;
    }

    @Override // d.b.h0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.f18601a = new ImageView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.f13622f = this.mIndicator;
        aVar.f13619c = l.e(context, 3.0f);
        ImageView imageView = this.f18601a;
        aVar.f13617a = imageView;
        aVar.f13620d = R.drawable.icon_news_down_bar_one;
        imageView.setVisibility(8);
        this.mIndicator.a("member_center_red_tip", aVar);
        return this.mIndicator;
    }

    @Override // d.b.h0.e0.b
    public boolean isAvailable() {
        return MainTabActivityConfig.MEMBER_CENTER_TAB_AVAILABLE;
    }

    @Override // d.b.h0.e0.b
    public void onAdd() {
        super.onAdd();
        this.f18602b = new b(2016459);
    }

    @Override // d.b.h0.e0.b
    public void onRemove() {
        super.onRemove();
        this.f18601a = null;
        MessageManager.getInstance().unRegisterListener(this.f18602b);
    }
}
