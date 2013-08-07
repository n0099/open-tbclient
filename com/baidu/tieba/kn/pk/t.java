package com.baidu.tieba.kn.pk;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.baidu.cyberplayer.sdk.BVideoView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.kn.pk.widget.PullAndPull;
import com.baidu.tieba.util.ah;
import com.slidingmenu.lib.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
/* loaded from: classes.dex */
public class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected s f1225a;
    public com.baidu.tieba.kn.pk.widget.b b;
    ImageView c;
    public long d;
    private BdPullRefreshScrollView e;
    private PKingActivity f;
    private ProgressBar g;
    private ImageView h;
    private TextView i;
    private LinearLayout j;
    private LinearLayout k;
    private TextView l;
    private boolean m;
    private PullAndPull n;
    private PullAndPull o;
    private long p;
    private long q;
    private LinkedList r = new LinkedList();

    public ProgressBar a() {
        return this.g;
    }

    public ImageView b() {
        return this.h;
    }

    public t(PKingActivity pKingActivity, String str) {
        this.f = pKingActivity;
        this.e = (BdPullRefreshScrollView) pKingActivity.findViewById(R.id.pullScrollView);
        this.e.setOnPullDownListener(pKingActivity);
        this.b = new com.baidu.tieba.kn.pk.widget.b(pKingActivity, pKingActivity);
        this.b.c();
        this.g = (ProgressBar) pKingActivity.findViewById(R.id.progress);
        this.n = (PullAndPull) pKingActivity.findViewById(R.id.voters_left);
        this.o = (PullAndPull) pKingActivity.findViewById(R.id.voters_right);
        this.i = (TextView) pKingActivity.findViewById(R.id.title_text);
        if (str != null) {
            this.i.setText(str);
        }
        this.k = (LinearLayout) pKingActivity.findViewById(R.id.voters_panel);
        this.j = (LinearLayout) pKingActivity.findViewById(R.id.voters_tips_panel);
        this.l = (TextView) pKingActivity.findViewById(R.id.voters_tips);
        c();
    }

    protected void c() {
        View findViewById = this.f.findViewById(R.id.title);
        this.h = (ImageView) this.f.findViewById(R.id.back);
        this.h.setOnClickListener(this.f);
        ((ImageView) this.f.findViewById(R.id.share_weixin)).setOnClickListener(this.f);
        ((ImageView) this.f.findViewById(R.id.share_qqfriend)).setOnClickListener(this.f);
        ((ImageView) this.f.findViewById(R.id.share_qqzone)).setOnClickListener(this.f);
        ((ImageView) this.f.findViewById(R.id.share_sina)).setOnClickListener(this.f);
        ah.a(this.h, 0);
        ah.a((ImageView) this.f.findViewById(R.id.home), 0);
        ah.d(findViewById, 0);
        ah.f(this.i, 0);
        this.c = (ImageView) this.f.findViewById(R.id.cmd_folder);
        this.c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c && !this.b.a()) {
            if (this.b.g()) {
                this.c.setImageResource(R.drawable.icon_pk_upward_selector);
                this.b.e();
                return;
            }
            this.c.setImageResource(R.drawable.icon_pk_downward_selector);
            this.b.f();
        }
    }

    private void a(String str) {
        if (str != null) {
            this.j.setVisibility(0);
            this.k.setVisibility(8);
            this.l.setText(str);
            return;
        }
        this.j.setVisibility(8);
        this.k.setVisibility(0);
    }

    public void a(Handler handler, com.baidu.tieba.util.a aVar, s sVar) {
        com.baidu.adp.widget.a.b a2;
        com.baidu.adp.widget.a.b a3;
        this.g.setVisibility(8);
        this.e.c();
        if (sVar == null) {
            this.e.setVisibility(0);
            return;
        }
        a(handler);
        if (sVar.a()) {
            this.e.setVisibility(0);
            if (this.f1225a == null) {
                a(sVar.b());
            }
            this.f.a(sVar.b());
            return;
        }
        this.f1225a = sVar;
        this.n.setData(sVar);
        this.o.setData(sVar);
        if (this.n != null) {
            this.n.a();
        }
        if (this.o != null) {
            this.o.a();
        }
        this.i.setText(this.f1225a.c());
        this.b.a(this.f1225a.b);
        this.b.a("PK规则", this.f1225a.c);
        this.b.a(String.valueOf(sVar.j.e) + this.f.getString(R.string.forum), sVar.j.g, this.f);
        this.b.b(String.valueOf(sVar.k.e) + this.f.getString(R.string.forum), sVar.k.g, this.f);
        this.n.a();
        this.o.a();
        this.p = this.f1225a.j.h;
        this.q = this.f1225a.k.h;
        if (sVar.g().isEmpty() && sVar.h().isEmpty()) {
            this.m = false;
            a(this.f.getString(R.string.kn_data_no_vote));
        } else {
            this.m = true;
            a((String) null);
            a(sVar.g(), true);
            a(sVar.h(), false);
            Iterator it = sVar.g().iterator();
            while (it.hasNext()) {
                this.p -= ((y) it.next()).b;
            }
            Iterator it2 = sVar.h().iterator();
            while (it2.hasNext()) {
                this.q -= ((y) it2.next()).b;
            }
            a(handler, sVar.g(), true);
            a(handler, sVar.h(), false);
        }
        d();
        String str = sVar.j.c;
        if (str != null && (a3 = aVar.a(str, new u(this, str))) != null) {
            this.b.a(a3.f());
        }
        String str2 = sVar.k.c;
        if (str2 != null && (a2 = aVar.a(str2, new v(this, str2))) != null) {
            this.b.b(a2.f());
        }
        this.e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        this.b.a(this.p);
        this.b.b(this.q);
    }

    public void a(Handler handler) {
        if (this.f1225a != null) {
            this.f1225a.g().clear();
            this.f1225a.h().clear();
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            handler.removeCallbacks((Runnable) it.next());
        }
        this.r.clear();
    }

    public void a(Handler handler, h hVar) {
        this.e.c();
        if (hVar != null) {
            if (!this.m && hVar.c().isEmpty() && hVar.d().isEmpty()) {
                a("请为您支持的选手投票吧！");
            } else {
                this.m = true;
                a((String) null);
            }
            hVar.a(this.f1225a.d());
            this.p = hVar.b.h;
            this.q = hVar.c.h;
            if (hVar.c() != null) {
                Iterator it = hVar.c().iterator();
                while (it.hasNext()) {
                    this.p -= ((y) it.next()).b;
                }
                a(handler, hVar.c(), true);
            }
            if (hVar.d() != null) {
                Iterator it2 = hVar.d().iterator();
                while (it2.hasNext()) {
                    this.q -= ((y) it2.next()).b;
                }
                a(handler, hVar.d(), false);
            }
            d();
        }
    }

    public void a(LinkedList linkedList, boolean z) {
        int size = linkedList.size() - 10;
        long d = this.f1225a.d() / 1000;
        int i = 0;
        while (i < size && d - ((y) linkedList.get(i)).c <= 15) {
            i++;
        }
        LinkedList linkedList2 = new LinkedList();
        for (int i2 = 0; i2 < i && i2 < 15; i2++) {
            linkedList2.addLast((y) linkedList.removeFirst());
        }
        while (linkedList.size() > 10) {
            linkedList.removeLast();
        }
        while (!linkedList.isEmpty()) {
            a((y) linkedList.removeLast(), z, false);
        }
        linkedList.addAll(linkedList2);
    }

    public void e() {
        this.g.setVisibility(8);
        this.e.c();
        this.e.setVisibility(0);
    }

    protected void a(Handler handler, LinkedList linkedList, boolean z) {
        if (linkedList != null && !linkedList.isEmpty()) {
            int min = 15000 / Math.min(linkedList.size(), 15);
            Random random = new Random();
            int i = 0;
            for (int i2 = 0; i2 < linkedList.size() && i2 < 15; i2++) {
                y yVar = (y) linkedList.get((linkedList.size() - 1) - i2);
                i += Math.max((int) BVideoView.MEDIA_INFO_VIDEO_TRACK_LAGGING, (random.nextInt(600) + min) - 300);
                if (i < 0) {
                    i = 0;
                } else if (i > 15000) {
                    i = 15000;
                }
                if (yVar.f1242a != null) {
                    this.d = Math.max(yVar.c, this.d);
                    if (i2 == 0 && yVar.f1242a.equalsIgnoreCase(TiebaApplication.I())) {
                        i = 0;
                    }
                    if (com.baidu.adp.lib.e.d.a()) {
                        com.baidu.adp.lib.e.d.c("time to go:" + i + ", time interval:" + min);
                    }
                    w wVar = new w(this, yVar, z);
                    this.r.addLast(wVar);
                    handler.postDelayed(wVar, i);
                }
            }
            linkedList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(y yVar, boolean z, boolean z2) {
        PullAndPull pullAndPull;
        if (z) {
            pullAndPull = this.n;
        } else {
            pullAndPull = this.o;
        }
        pullAndPull.a(yVar, z, z2);
    }
}
