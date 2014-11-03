package com.baidu.tieba.mention;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes.dex */
public class v extends FragmentPagerAdapter {
    private CustomMessageListener Sg;
    private BaseFragment[] aLU;
    private int[] bfV;
    private int mq;

    public v(FragmentManager fragmentManager, boolean z) {
        super(fragmentManager);
        this.Sg = new w(this, 2008002);
        if (!z) {
            SU();
            return;
        }
        MessageManager.getInstance().registerListener(this.Sg);
        boolean sendMessage = MessageManager.getInstance().sendMessage(new CustomMessage(2008002));
        MessageManager.getInstance().unRegisterListener(this.Sg);
        if (!sendMessage) {
            SU();
        }
    }

    private void SU() {
        this.aLU = new BaseFragment[]{new ae(), new a()};
        this.bfV = new int[]{1, 2};
        this.mq = this.aLU.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i < 0 || i >= this.mq) {
            return null;
        }
        return this.aLU[i];
    }

    public int gf(int i) {
        return this.bfV[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mq;
    }
}
