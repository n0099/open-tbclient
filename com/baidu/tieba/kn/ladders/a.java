package com.baidu.tieba.kn.ladders;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.kn.TimerTextView;
import com.baidu.tieba.kn.ladders.KnLaddersModel;
import com.baidu.tieba.view.ImageViewDrawer;
import com.slidingmenu.lib.R;
import java.util.Date;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.e implements View.OnClickListener, AdapterView.OnItemClickListener, com.baidu.tieba.kn.c {

    /* renamed from: a  reason: collision with root package name */
    private int f1180a;
    private KnLaddersModel.RankInfo[] b;
    private KnLaddersModel.PlayerInfo[] c;
    private KnLaddersModel.PlayerInfo[] d;
    private KnLaddersModel.PlayerInfo[] e;
    private KnLaddersModel.Pic[] f;
    private KnLaddersModel.Name[] g;
    private l h;
    private KnLaddersBannerAdapter i;
    private com.baidu.tieba.util.a j;
    private Activity k;
    private KnLaddersFragment l;
    private g m;

    public a(KnLaddersFragment knLaddersFragment) {
        super(knLaddersFragment.g());
        this.f1180a = 1;
        this.b = new KnLaddersModel.RankInfo[0];
        this.c = new KnLaddersModel.PlayerInfo[0];
        this.d = new KnLaddersModel.PlayerInfo[0];
        this.e = new KnLaddersModel.PlayerInfo[0];
        this.f = new KnLaddersModel.Pic[0];
        this.g = new KnLaddersModel.Name[0];
        this.k = knLaddersFragment.g();
        this.l = knLaddersFragment;
        this.j = new com.baidu.tieba.util.a(this.k);
        int i = (int) ((this.k.getResources().getDisplayMetrics().density * 50.0f) + 0.5d);
        this.j.a(i, i);
    }

    public void a(int i) {
        this.f1180a = i;
        switch (this.f1180a) {
            case 1:
                g();
                this.h.b.setBackgroundResource(R.drawable.bg_subnav_list_s);
                this.h.b.setTextColor(-1);
                break;
            case 2:
                g();
                this.h.c.setBackgroundResource(R.drawable.bg_subnav_list_s);
                this.h.c.setTextColor(-1);
                break;
            case 3:
                g();
                this.h.d.setBackgroundResource(R.drawable.bg_subnav_list_s);
                this.h.d.setTextColor(-1);
                break;
        }
        if (this.m != null) {
            this.m.a(this.f1180a);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        FrsActivity.a(adapterView.getContext(), getItem(i).forum_name, "KnLadders");
    }

    @Override // com.baidu.tieba.kn.c
    public void b_() {
        notifyDataSetChanged();
    }

    public l e() {
        return this.h;
    }

    public KnLaddersBannerAdapter f() {
        return this.i;
    }

    public void a(g gVar) {
        this.m = gVar;
    }

    private void g() {
        this.h.b.setBackgroundDrawable(null);
        this.h.c.setBackgroundDrawable(null);
        this.h.d.setBackgroundDrawable(null);
        this.h.b.setTextColor(this.k.getResources().getColor(R.color.kn_ladders_navigate_text_color));
        this.h.c.setTextColor(this.k.getResources().getColor(R.color.kn_ladders_navigate_text_color));
        this.h.d.setTextColor(this.k.getResources().getColor(R.color.kn_ladders_navigate_text_color));
    }

    public void a(KnLaddersModel.RankInfo[] rankInfoArr) {
        KnLaddersModel.RankInfo[] rankInfoArr2;
        if (rankInfoArr != null) {
            this.b = rankInfoArr;
            for (KnLaddersModel.RankInfo rankInfo : this.b) {
                if (rankInfo.ranking_type == this.g[0].ranking_type) {
                    this.c = rankInfo.players;
                    this.h.b.setText(this.g[0].ranking_name);
                } else if (rankInfo.ranking_type == this.g[1].ranking_type) {
                    this.d = rankInfo.players;
                    this.h.c.setText(this.g[1].ranking_name);
                } else if (rankInfo.ranking_type == this.g[2].ranking_type) {
                    this.e = rankInfo.players;
                    this.h.d.setText(this.g[2].ranking_name);
                }
            }
            notifyDataSetChanged();
        }
    }

    public void a(KnLaddersModel.RankPageInfo rankPageInfo) {
        this.f = rankPageInfo.pics;
        this.g = rankPageInfo.names;
        this.i = new KnLaddersBannerAdapter(this.k, this.f);
        this.h.f1190a.setAdapter(this.i);
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public int getCount() {
        switch (this.f1180a) {
            case 1:
                return this.c.length + 2;
            case 2:
                return this.d.length + 2;
            case 3:
                return this.e.length + 2;
            default:
                return 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    /* renamed from: b */
    public KnLaddersModel.PlayerInfo getItem(int i) {
        if (i == 0 || i == getCount() - 1) {
            return null;
        }
        switch (this.f1180a) {
            case 1:
                return this.c[i - 1];
            case 2:
                return this.d[i - 1];
            case 3:
                return this.e[i - 1];
            default:
                return null;
        }
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == getCount() - 1) {
            return 3;
        }
        return 2;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // com.baidu.adp.widget.ListView.e, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case 1:
                return a(i, view, viewGroup);
            case 2:
                return c(i, view, viewGroup);
            case 3:
                return b(i, view, viewGroup);
            default:
                return null;
        }
    }

    private View a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            View inflate = LayoutInflater.from(this.k).inflate(R.layout.kn_ladders_banner, viewGroup, false);
            this.h = new l(this, inflate);
            this.h.f1190a.setOnPageChangeListener(new b(this));
            return inflate;
        }
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            View inflate = LayoutInflater.from(this.k).inflate(R.layout.kn_ladders_footer, viewGroup, false);
            if (inflate == null) {
                return null;
            }
            inflate.setOnClickListener(new c(this));
            return inflate;
        }
        return view;
    }

    private View c(int i, View view, ViewGroup viewGroup) {
        h hVar;
        if (view == null) {
            h hVar2 = new h(this, null);
            view = LayoutInflater.from(this.k).inflate(R.layout.kn_ladders_item, viewGroup, false);
            hVar2.f1186a = (LinearLayout) view.findViewById(R.id.item_root);
            hVar2.b = (TextView) view.findViewById(R.id.index);
            hVar2.c = (ImageViewDrawer) view.findViewById(R.id.portrait);
            hVar2.d = (TextView) view.findViewById(R.id.name);
            hVar2.e = (TextView) view.findViewById(R.id.tickets);
            hVar2.f = (TimerTextView) view.findViewById(R.id.cooldown);
            hVar2.c.setDefaultId(R.drawable.person_photo);
            view.setTag(hVar2);
            hVar = hVar2;
        } else {
            hVar = (h) view.getTag();
        }
        KnLaddersModel.PlayerInfo item = getItem(i);
        if (item != null) {
            hVar.f1186a.setOnClickListener(new d(this, item));
            if (item.player_name != null) {
                hVar.d.setText(item.player_name);
            }
            hVar.e.setText(String.valueOf(String.valueOf(item.vote_number)) + "票");
            hVar.b.setText(String.format("%02d", Integer.valueOf(i)));
            long a2 = (com.baidu.tieba.kn.a.a().a(item.player_id) - new Date().getTime()) / 1000;
            Log.d("KnLadderAdapter", "@getNormalView cooldown: " + a2);
            if (a2 > 0) {
                hVar.f.setTimeInSeconds(a2);
                hVar.f.setOnCooldown(this);
                hVar.f.setEnabled(false);
                hVar.f.setTextSize(2, 10.0f);
            } else {
                hVar.f.setEnabled(true);
                hVar.f.setText(R.string.kn_start_shake);
                hVar.f.a();
                hVar.f.setTextSize(2, 14.0f);
            }
            hVar.f.setOnClickListener(new e(this, a2, item));
            if (item.big_head_url != null && item.big_head_url.length() > 0) {
                this.j.a(item.big_head_url, new f(this, item, hVar));
                hVar.c.setTag(item.big_head_url);
                hVar.c.invalidate();
            }
            switch (i) {
                case 1:
                    hVar.b.setTextColor(this.k.getResources().getColor(R.color.kn_ladders_1));
                    break;
                case 2:
                    hVar.b.setTextColor(this.k.getResources().getColor(R.color.kn_ladders_2));
                    break;
                case 3:
                    hVar.b.setTextColor(this.k.getResources().getColor(R.color.kn_ladders_3));
                    break;
                default:
                    hVar.b.setTextColor(this.k.getResources().getColor(R.color.kn_ladders_4));
                    break;
            }
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next /* 2131099837 */:
                int currentItem = this.h.f1190a.getCurrentItem() + 1;
                if (currentItem <= this.i.getCount() - 1) {
                    this.h.f1190a.setCurrentItem(currentItem);
                    return;
                }
                return;
            case R.id.pre /* 2131100242 */:
                int currentItem2 = this.h.f1190a.getCurrentItem() - 1;
                if (currentItem2 >= 0) {
                    this.h.f1190a.setCurrentItem(currentItem2);
                    return;
                }
                return;
            case R.id.tab_1 /* 2131100246 */:
                a(1);
                notifyDataSetChanged();
                return;
            case R.id.tab_2 /* 2131100247 */:
                a(2);
                notifyDataSetChanged();
                return;
            case R.id.tab_3 /* 2131100248 */:
                a(3);
                notifyDataSetChanged();
                return;
            default:
                return;
        }
    }
}
