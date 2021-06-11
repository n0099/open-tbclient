package com.baidu.tieba.write.bottomButton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import d.a.m0.e0.b;
import d.a.m0.e0.c;
/* loaded from: classes5.dex */
public class WriteThreadDelegateStatic extends b {
    @Override // d.a.m0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f53008a = new WriteThreadFragment();
        cVar.f53012e = 9;
        cVar.f53009b = R.string.send;
        cVar.f53011d = R.drawable.icon_tabbar_add_n;
        cVar.f53016i = c.j;
        return cVar;
    }

    @Override // d.a.m0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.mIndicator = maintabBottomIndicator;
        return maintabBottomIndicator;
    }

    @Override // d.a.m0.e0.b
    public boolean isAvailable() {
        return true;
    }
}
