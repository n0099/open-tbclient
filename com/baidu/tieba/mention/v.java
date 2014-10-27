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
    private CustomMessageListener Sc;
    private BaseFragment[] aLG;
    private int[] bfH;
    private int mq;

    public v(FragmentManager fragmentManager, boolean z) {
        super(fragmentManager);
        this.Sc = new w(this, 2008002);
        if (!z) {
            SR();
            return;
        }
        MessageManager.getInstance().registerListener(this.Sc);
        boolean sendMessage = MessageManager.getInstance().sendMessage(new CustomMessage(2008002));
        MessageManager.getInstance().unRegisterListener(this.Sc);
        if (!sendMessage) {
            SR();
        }
    }

    private void SR() {
        this.aLG = new BaseFragment[]{new ae(), new a()};
        this.bfH = new int[]{1, 2};
        this.mq = this.aLG.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i < 0 || i >= this.mq) {
            return null;
        }
        return this.aLG[i];
    }

    public int gf(int i) {
        return this.bfH[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mq;
    }
}
