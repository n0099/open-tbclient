package com.baidu.tieba.mention;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.d.ac;
import com.baidu.tieba.d.ad;
import com.baidu.tieba.d.ae;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private Context a;
    private ArrayList b;
    private com.baidu.tieba.d.a c;
    private String d;
    private int h;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private ArrayList j = new ArrayList();
    private int i = 3;

    public e(Context context, ArrayList arrayList) {
        this.a = context;
        this.b = arrayList;
        this.d = this.a.getText(R.string.forum).toString();
        this.c = new com.baidu.tieba.d.a(this.a);
    }

    public void a() {
        if (this.j != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.j.size()) {
                    try {
                        ((ProgressBar) this.j.get(i2)).setVisibility(8);
                    } catch (Exception e) {
                        ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.j.clear();
                    return;
                }
            }
        }
    }

    public void a(ArrayList arrayList) {
        this.b = arrayList;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public boolean b() {
        return this.f;
    }

    public void c(boolean z) {
        this.g = z;
    }

    public boolean c() {
        return this.g;
    }

    public void a(int i) {
        this.h = i;
    }

    public void b(int i) {
        this.i = i;
    }

    public int d() {
        return this.i;
    }

    public com.baidu.tieba.d.a e() {
        return this.c;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            int size = this.b.size();
            if (this.e) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.b.size()) {
            return null;
        }
        return this.b.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.e && i == getCount() - 1) {
            i = -2;
        }
        return i;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00e6: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x00e5 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        g gVar;
        View view4;
        g gVar2;
        try {
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        if (this.b == null) {
            return view;
        }
        int ar = TiebaApplication.d().ar();
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.a);
                if (getItemViewType(i) == 0) {
                    if (this.h == 0) {
                        view4 = from.inflate(R.layout.mention_replyme_item, (ViewGroup) null);
                    } else {
                        view4 = from.inflate(R.layout.mention_atme_item, (ViewGroup) null);
                    }
                    g gVar3 = new g(this, null);
                    gVar3.d = (LinearLayout) view4.findViewById(R.id.contentContainer);
                    gVar3.e = (ImageView) view4.findViewById(R.id.photo);
                    gVar3.f = (TextView) view4.findViewById(R.id.user_name);
                    gVar3.f.getPaint().setFakeBoldText(true);
                    gVar3.g = (TextView) view4.findViewById(R.id.time);
                    gVar3.h = (TextView) view4.findViewById(R.id.content);
                    if (this.h == 0) {
                        gVar3.i = (TextView) view4.findViewById(R.id.title);
                        gVar3.j = (TextView) view4.findViewById(R.id.forum);
                        gVar3.k = (TextView) view4.findViewById(R.id.reply_type);
                    }
                    gVar3.c = new f(this);
                    gVar3.e.setOnClickListener(gVar3.c);
                    gVar2 = gVar3;
                } else {
                    view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    g gVar4 = new g(this, null);
                    gVar4.a = (TextView) view4.findViewById(R.id.page_text);
                    gVar4.b = (ProgressBar) view4.findViewById(R.id.progress);
                    this.j.add(gVar4.b);
                    gVar2 = gVar4;
                }
                view4.setTag(gVar2);
                gVar = gVar2;
            } else {
                gVar = (g) view.getTag();
                view4 = view;
            }
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            ae.b(getClass().getName(), "", "ReplymeAdapter.getView error = " + exc.getMessage());
            return view2;
        }
        if (getItemViewType(i) == 1) {
            long itemId = getItemId(i);
            if (itemId == -1) {
                if (this.f) {
                    gVar.b.setVisibility(0);
                    gVar.a.setText(R.string.loading);
                } else {
                    gVar.b.setVisibility(8);
                    gVar.a.setText(R.string.refresh);
                }
            } else if (itemId == -2) {
                if (this.g) {
                    gVar.b.setVisibility(0);
                    gVar.a.setText(R.string.loading);
                } else {
                    gVar.b.setVisibility(8);
                    gVar.a.setText(R.string.more);
                }
            }
            if (ar == 1) {
                if (gVar.a != null) {
                    gVar.a.setTextColor(this.a.getResources().getColor(R.color.skin_1_common_color));
                    return view4;
                }
                return view4;
            }
            gVar.a.setTextColor(this.a.getResources().getColor(R.color.black));
            return view4;
        }
        com.baidu.tieba.a.r rVar = (com.baidu.tieba.a.r) getItem(i);
        if (rVar != null) {
            gVar.f.setText(rVar.i().d());
            gVar.g.setText(ad.a(rVar.b()));
            gVar.h.setText(rVar.e());
            gVar.f.setTextSize(com.baidu.tieba.a.i.q());
            gVar.h.setTextSize(com.baidu.tieba.a.i.n());
            if (this.h == 0) {
                if (rVar.a() == 1) {
                    gVar.k.setText(this.a.getString(R.string.mention_replyme_post));
                    gVar.i.setText(rVar.f());
                } else {
                    gVar.k.setText(this.a.getString(R.string.mention_replyme_thread));
                    gVar.i.setText(rVar.c());
                }
                if (rVar.d() != null && rVar.d().length() > 0) {
                    gVar.j.setVisibility(0);
                    gVar.j.setText(">" + ad.a(rVar.d(), 12).concat(this.d));
                } else {
                    gVar.j.setVisibility(8);
                }
            }
            gVar.e.setVisibility(0);
            String e3 = rVar.i().e();
            gVar.e.setTag(null);
            if (e3 != null && e3.length() > 0) {
                com.baidu.adp.widget.a.b b = this.c.b(e3);
                if (b != null) {
                    b.b(gVar.e);
                } else {
                    gVar.e.setTag(e3);
                    gVar.e.setImageResource(R.drawable.photo);
                }
            } else {
                gVar.e.setImageResource(R.drawable.photo);
            }
            gVar.c.b(rVar.i().a());
            gVar.c.a(rVar.i().c());
            gVar.e.setOnClickListener(gVar.c);
            if (gVar.k != null) {
                ac.b(gVar.k, ar);
            }
            ac.b(gVar.f, ar);
            if (ar == 1) {
                if (gVar.d != null) {
                    ac.h(gVar.d, (int) R.drawable.message_replyme_1);
                }
                if (gVar.i != null) {
                    gVar.i.setTextColor(this.a.getResources().getColor(R.color.skin_1_third_common_color));
                }
                gVar.h.setTextColor(this.a.getResources().getColor(R.color.skin_1_second_common_color));
                view2 = view4;
            } else {
                if (gVar.d != null) {
                    ac.h(gVar.d, (int) R.drawable.message_replyme);
                }
                if (gVar.i != null) {
                    gVar.i.setTextColor(-12040120);
                }
                gVar.h.setTextColor(-12040120);
                view2 = view4;
            }
            return view2;
        }
        return view4;
    }
}
