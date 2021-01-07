package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class MemberCenterDelegateStatic extends b {
    private static boolean lix = false;
    private ImageView liw;
    private CustomMessageListener liy;

    static {
        new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.memberCenter.index.MemberCenterDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c fragmentTabStructure;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    MemberCenterDelegateStatic memberCenterDelegateStatic = new MemberCenterDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(memberCenterDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (fragmentTabStructure = memberCenterDelegateStatic.getFragmentTabStructure()) != null) {
                        fragmentTabStructure.frag.setArguments(new Bundle());
                    }
                }
            }
        };
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.MEMBER_CENTER_TAB_AVAILABLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.frag = new MemberCenterFragment();
        cVar.type = 14;
        cVar.textResId = R.string.member;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.liw = new ImageView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.fJQ = this.mIndicator;
        aVar.offsetX = l.dip2px(context, 3.0f);
        aVar.view = this.liw;
        aVar.bgDayRes = R.drawable.icon_news_down_bar_one;
        this.liw.setVisibility(8);
        this.mIndicator.a("member_center_red_tip", aVar);
        return this.mIndicator;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onAdd() {
        super.onAdd();
        lix = true;
        this.liy = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.baidu.tieba.memberCenter.index.MemberCenterDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        MemberCenterDelegateStatic.this.liw.setVisibility(8);
                    } else if (!TbadkCoreApplication.isLogin()) {
                        MemberCenterDelegateStatic.this.liw.setVisibility(8);
                    } else {
                        if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() > com.baidu.tbadk.core.sharedPref.b.bvr().getLong(SharedPrefConfig.MAINTAB_MEMBER_CENTER_RED_TIP + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            MemberCenterDelegateStatic.this.liw.setVisibility(0);
                        } else {
                            MemberCenterDelegateStatic.this.liw.setVisibility(8);
                        }
                    }
                }
            }
        };
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onRemove() {
        super.onRemove();
        this.liw = null;
        MessageManager.getInstance().unRegisterListener(this.liy);
    }
}
