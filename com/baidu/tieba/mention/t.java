package com.baidu.tieba.mention;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
public class t extends FragmentPagerAdapter {
    private com.baidu.tbadk.core.d[] a;
    private int[] b;
    private int c;
    private CustomMessageListener d;

    public t(FragmentManager fragmentManager, boolean z) {
        super(fragmentManager);
        this.d = new u(this, 2008002);
        if (!z) {
            a();
            return;
        }
        MessageManager.getInstance().registerListener(this.d);
        boolean sendMessage = MessageManager.getInstance().sendMessage(new CustomMessage(2008002));
        MessageManager.getInstance().unRegisterListener(this.d);
        if (!sendMessage) {
            a();
        }
    }

    private void a() {
        this.a = new com.baidu.tbadk.core.d[]{new an(), new a()};
        this.b = new int[]{1, 2};
        this.c = this.a.length;
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
