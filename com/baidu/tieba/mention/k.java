package com.baidu.tieba.mention;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
public class k extends FragmentPagerAdapter {
    private com.baidu.tbadk.core.d[] a;
    private int[] b;
    private int c;
    private CustomMessageListener d;

    public k(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.d = new l(this, 2010002);
        MessageManager.getInstance().registerListener(this.d);
        boolean sendMessage = MessageManager.getInstance().sendMessage(new CustomMessage(2010002));
        MessageManager.getInstance().unRegisterListener(this.d);
        if (!sendMessage) {
            this.a = new com.baidu.tbadk.core.d[]{new af(), new a()};
            this.b = new int[]{1, 2};
            this.c = this.a.length;
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i < 0 || i >= this.c) {
            return null;
        }
        return this.a[i];
    }

    public int a(int i) {
        return this.b[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.c;
    }
}
