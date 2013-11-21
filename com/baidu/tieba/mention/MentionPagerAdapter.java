package com.baidu.tieba.mention;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.chat.ChatListFragment;
/* loaded from: classes.dex */
public class MentionPagerAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final BaseFragment[] f1828a;
    private final int b;

    public MentionPagerAdapter(android.support.v4.app.t tVar) {
        super(tVar);
        this.f1828a = new BaseFragment[]{new ChatListFragment(), new ReplyMeFragment(), new AtMeFragment()};
        this.b = this.f1828a.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment a(int i) {
        if (i < 0 || i >= this.b) {
            return null;
        }
        return this.f1828a[i];
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return this.b;
    }
}
