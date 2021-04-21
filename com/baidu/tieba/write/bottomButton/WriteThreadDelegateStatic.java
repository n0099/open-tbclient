package com.baidu.tieba.write.bottomButton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import d.b.i0.e0.b;
import d.b.i0.e0.c;
/* loaded from: classes5.dex */
public class WriteThreadDelegateStatic extends b {
    @Override // d.b.i0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f50884a = new WriteThreadFragment();
        cVar.f50888e = 9;
        cVar.f50885b = R.string.send;
        cVar.f50887d = R.drawable.icon_tabbar_add_n;
        cVar.i = c.j;
        return cVar;
    }

    @Override // d.b.i0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.mIndicator = maintabBottomIndicator;
        return maintabBottomIndicator;
    }

    @Override // d.b.i0.e0.b
    public boolean isAvailable() {
        return true;
    }
}
