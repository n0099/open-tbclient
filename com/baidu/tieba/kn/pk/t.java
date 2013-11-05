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
import com.baidu.tieba.util.bb;
import com.slidingmenu.lib.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
/* loaded from: classes.dex */
public class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected s f1787a;
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
    private LinkedList<Runnable> r = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long a(t tVar, long j) {
        long j2 = tVar.p + j;
        tVar.p = j2;
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long b(t tVar, long j) {
        long j2 = tVar.q + j;
        tVar.q = j2;
        return j2;
    }

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
        bb.a(this.h, 0);
        bb.a((ImageView) this.f.findViewById(R.id.home), 0);
        bb.d(findViewById, 0);
        bb.f(this.i, 0);
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
        com.baidu.adp.widget.ImageView.e a2;
        com.baidu.adp.widget.ImageView.e a3;
        this.g.setVisibility(8);
        this.e.c();
        if (sVar == null) {
            this.e.setVisibility(0);
            return;
        }
        a(handler);
        if (sVar.b()) {
            this.e.setVisibility(0);
            if (this.f1787a == null) {
                a(sVar.c());
            }
            this.f.a(sVar.c());
            return;
        }
        this.f1787a = sVar;
        this.n.setData(sVar);
        this.o.setData(sVar);
        if (this.n != null) {
            this.n.a();
        }
        if (this.o != null) {
            this.o.a();
        }
        this.i.setText(this.f1787a.d());
        this.b.a(this.f1787a.b);
        this.b.a("PK规则", this.f1787a.c);
        this.b.a(sVar.j.e + this.f.getString(R.string.forum), sVar.j.g, this.f);
        this.b.b(sVar.k.e + this.f.getString(R.string.forum), sVar.k.g, this.f);
        this.n.a();
        this.o.a();
        this.p = this.f1787a.j.h;
        this.q = this.f1787a.k.h;
        if (sVar.h().isEmpty() && sVar.i().isEmpty()) {
            this.m = false;
            a(this.f.getString(R.string.kn_data_no_vote));
        } else {
            this.m = true;
            a((String) null);
            a(sVar.h(), true);
            a(sVar.i(), false);
            Iterator<y> it = sVar.h().iterator();
            while (it.hasNext()) {
                this.p -= it.next().b;
            }
            Iterator<y> it2 = sVar.i().iterator();
            while (it2.hasNext()) {
                this.q -= it2.next().b;
            }
            a(handler, sVar.h(), true);
            a(handler, sVar.i(), false);
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
        if (this.f1787a != null) {
            this.f1787a.h().clear();
            this.f1787a.i().clear();
        }
        Iterator<Runnable> it = this.r.iterator();
        while (it.hasNext()) {
            handler.removeCallbacks(it.next());
        }
        this.r.clear();
    }

    public void a(Handler handler, h hVar) {
        this.e.c();
        if (hVar != null) {
            if (!this.m && hVar.d().isEmpty() && hVar.e().isEmpty()) {
                a("请为你支持的选手投票吧！");
            } else {
                this.m = true;
                a((String) null);
            }
            hVar.a(this.f1787a.e());
            this.p = hVar.b.h;
            this.q = hVar.c.h;
            if (hVar.d() != null) {
                Iterator<y> it = hVar.d().iterator();
                while (it.hasNext()) {
                    this.p -= it.next().b;
                }
                a(handler, hVar.d(), true);
            }
            if (hVar.e() != null) {
                Iterator<y> it2 = hVar.e().iterator();
                while (it2.hasNext()) {
                    this.q -= it2.next().b;
                }
                a(handler, hVar.e(), false);
            }
            d();
        }
    }

    public void a(LinkedList<y> linkedList, boolean z) {
        int size = linkedList.size() - 10;
        long e = this.f1787a.e() / 1000;
        int i = 0;
        while (i < size && e - linkedList.get(i).c <= 15) {
            i++;
        }
        LinkedList linkedList2 = new LinkedList();
        for (int i2 = 0; i2 < i && i2 < 15; i2++) {
            linkedList2.addLast(linkedList.removeFirst());
        }
        while (linkedList.size() > 10) {
            linkedList.removeLast();
        }
        while (!linkedList.isEmpty()) {
            a(linkedList.removeLast(), z, false);
        }
        linkedList.addAll(linkedList2);
    }

    public void e() {
        this.g.setVisibility(8);
        this.e.c();
        this.e.setVisibility(0);
    }

    protected void a(Handler handler, LinkedList<y> linkedList, boolean z) {
        if (linkedList != null && !linkedList.isEmpty()) {
            int min = 15000 / Math.min(linkedList.size(), 15);
            Random random = new Random();
            int i = 0;
            for (int i2 = 0; i2 < linkedList.size() && i2 < 15; i2++) {
                y yVar = linkedList.get((linkedList.size() - 1) - i2);
                i += Math.max((int) BVideoView.MEDIA_INFO_VIDEO_TRACK_LAGGING, (random.nextInt(600) + min) - 300);
                if (i < 0) {
                    i = 0;
                } else if (i > 15000) {
                    i = 15000;
                }
                if (yVar.f1804a != null) {
                    this.d = Math.max(yVar.c, this.d);
                    if (i2 == 0 && yVar.f1804a.equalsIgnoreCase(TiebaApplication.H())) {
                        i = 0;
                    }
                    if (com.baidu.adp.lib.h.d.a()) {
                        com.baidu.adp.lib.h.d.d("time to go:" + i + ", time interval:" + min);
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
