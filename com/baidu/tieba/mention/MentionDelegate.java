package com.baidu.tieba.mention;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
public class MentionDelegate extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d createFragmentTabStructure() {
        if (isAvailable()) {
            com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
            dVar.a = new c();
            dVar.c = 3;
            dVar.b = com.baidu.tieba.a.k.remind;
            return dVar;
        }
        return null;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.a.i.fragmenttabindicator, (ViewGroup) null);
        return this.mIndicator;
    }
}
