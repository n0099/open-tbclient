package com.baidu.tieba.recommend;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.TiebaApplication;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class DailyRecommendFragment extends BaseFragment {
    private ab c;
    private w d;
    private String g;
    private final String b = DailyRecommendFragment.class.getSimpleName();
    private Handler e = null;
    private Runnable f = null;

    /* renamed from: a  reason: collision with root package name */
    l f1626a = new r(this);
    private com.baidu.adp.widget.ListView.r h = new s(this);
    private com.baidu.adp.widget.ListView.b i = new t(this);

    public void a() {
        this.e = new Handler();
        this.f = new u(this);
    }

    public void B() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            a(true, simpleDateFormat.format(new Date(simpleDateFormat.parse(this.g).getTime() - Util.MILLSECONDS_OF_DAY)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void D() {
        this.d = new w(g());
        this.d.a(new v(this));
        a(false, (String) null);
    }

    public void a(String str) {
        com.baidu.tieba.util.am.a((Context) g(), str);
    }

    private void E() {
        this.c = new ab(this, this.h, this.f1626a);
        this.c.a(this.i);
        this.c.c();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void n() {
        super.n();
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
            this.e.postDelayed(this.f, 300L);
        }
        this.c.h();
        if (TiebaApplication.f().t()) {
            StatService.onEvent(g(), "recommend_feature", "visit", 1);
        }
    }

    public void a(boolean z, String str) {
        C();
        if (str == null && z) {
            StatService.onEvent(this.c.a(), "recommend_pull", "pull");
            this.d.a();
        } else if (str == null && !z) {
            this.d.b();
        } else if (str != null && z) {
            this.c.b();
            this.d.a(str);
        }
    }

    public void C() {
        this.d.cancelLoadData();
    }

    @Override // android.support.v4.app.Fragment
    public void o() {
        super.o();
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
        }
        super.o();
    }

    @Override // android.support.v4.app.Fragment
    public void p() {
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
        }
        this.c.d();
        C();
        super.p();
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a();
        E();
        D();
        return this.c.g();
    }

    @Override // android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
    }

    @Override // com.baidu.tieba.BaseFragment
    public void a(int i) {
        this.c.a(i);
    }
}
