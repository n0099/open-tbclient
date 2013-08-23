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
import com.baidu.tieba.util.ao;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.aq;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class f extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1329a;
    private ArrayList b;
    private com.baidu.tieba.util.a c;
    private String d;
    private int h;
    private boolean[] k = new boolean[0];
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private ArrayList j = new ArrayList();
    private int i = 3;

    public f(Context context, ArrayList arrayList) {
        this.f1329a = context;
        this.b = arrayList;
        this.d = this.f1329a.getText(R.string.forum).toString();
        this.c = new com.baidu.tieba.util.a(this.f1329a);
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
                        aq.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.j.clear();
                    return;
                }
            }
        }
    }

    public void a(int i) {
        if (i >= 0 && i < this.k.length) {
            this.k[i] = true;
        }
    }

    public void a(ArrayList arrayList, boolean z) {
        if (!z) {
            this.k = new boolean[Math.min(100, r.a().a(this.h))];
        }
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

    public void b(int i) {
        this.h = i;
    }

    public void c(int i) {
        this.i = i;
    }

    public int d() {
        return this.i;
    }

    public com.baidu.tieba.util.a e() {
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

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00ef: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x00ee */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        h hVar;
        View view4;
        h hVar2;
        try {
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        if (this.b == null) {
            return view;
        }
        int an = TiebaApplication.g().an();
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.f1329a);
                if (getItemViewType(i) == 0) {
                    if (this.h == 1) {
                        view4 = from.inflate(R.layout.mention_replyme_item, (ViewGroup) null);
                    } else {
                        view4 = from.inflate(R.layout.mention_atme_item, (ViewGroup) null);
                    }
                    h hVar3 = new h(this, null);
                    hVar3.d = (LinearLayout) view4.findViewById(R.id.contentContainer);
                    hVar3.e = (ImageView) view4.findViewById(R.id.photo);
                    hVar3.f = (TextView) view4.findViewById(R.id.user_name);
                    hVar3.f.getPaint().setFakeBoldText(true);
                    hVar3.g = (TextView) view4.findViewById(R.id.time);
                    hVar3.h = (TextView) view4.findViewById(R.id.content);
                    if (this.h == 1) {
                        hVar3.i = (TextView) view4.findViewById(R.id.title);
                        hVar3.j = (TextView) view4.findViewById(R.id.forum);
                        hVar3.k = (TextView) view4.findViewById(R.id.reply_type);
                    }
                    hVar3.c = new g(this);
                    hVar3.e.setOnClickListener(hVar3.c);
                    hVar3.l = (ImageView) view4.findViewById(R.id.tip_new_msg);
                    hVar2 = hVar3;
                } else {
                    view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    h hVar4 = new h(this, null);
                    hVar4.f1331a = (TextView) view4.findViewById(R.id.page_text);
                    hVar4.b = (ProgressBar) view4.findViewById(R.id.progress);
                    this.j.add(hVar4.b);
                    hVar2 = hVar4;
                }
                view4.setTag(hVar2);
                hVar = hVar2;
            } else {
                hVar = (h) view.getTag();
                view4 = view;
            }
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            aq.b(getClass().getName(), "", "ReplymeAdapter.getView error = " + exc.getMessage());
            return view2;
        }
        if (getItemViewType(i) == 1) {
            long itemId = getItemId(i);
            if (itemId == -1) {
                if (this.f) {
                    hVar.b.setVisibility(0);
                    hVar.f1331a.setText(R.string.loading);
                } else {
                    hVar.b.setVisibility(8);
                    hVar.f1331a.setText(R.string.refresh);
                }
            } else if (itemId == -2) {
                if (this.g) {
                    hVar.b.setVisibility(0);
                    hVar.f1331a.setText(R.string.loading);
                } else {
                    hVar.b.setVisibility(8);
                    hVar.f1331a.setText(R.string.more);
                }
            }
            if (an == 1) {
                if (hVar.f1331a != null) {
                    ao.g((View) hVar.f1331a, (int) R.drawable.btn_w_square_1);
                    hVar.f1331a.setTextColor(-8682095);
                    return view4;
                }
                return view4;
            }
            ao.g((View) hVar.f1331a, (int) R.drawable.btn_w_square);
            hVar.f1331a.setTextColor(-14277082);
            return view4;
        }
        if (an == 1) {
            ao.g(view4, (int) R.drawable.list_selector_1);
        } else {
            ao.g(view4, (int) R.drawable.list_selector);
        }
        com.baidu.tieba.data.u uVar = (com.baidu.tieba.data.u) getItem(i);
        if (uVar != null) {
            hVar.f.setText(uVar.i().getName_show());
            hVar.g.setText(ap.g(new Date(uVar.b())));
            hVar.h.setText(uVar.e());
            hVar.f.setTextSize(com.baidu.tieba.data.g.r());
            hVar.h.setTextSize(com.baidu.tieba.data.g.o());
            if (this.h == 1) {
                if (uVar.a() == 1) {
                    hVar.k.setText(this.f1329a.getString(R.string.mention_replyme_post));
                    hVar.i.setText(uVar.f());
                } else {
                    hVar.k.setText(this.f1329a.getString(R.string.mention_replyme_thread));
                    hVar.i.setText(uVar.c());
                }
                if (uVar.d() != null && uVar.d().length() > 0) {
                    hVar.j.setVisibility(0);
                    hVar.j.setText(">" + ap.a(uVar.d(), 12).concat(this.d));
                } else {
                    hVar.j.setVisibility(8);
                }
            }
            hVar.e.setVisibility(0);
            String portrait = uVar.i().getPortrait();
            hVar.e.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                com.baidu.adp.widget.a.b c = this.c.c(portrait);
                if (c != null) {
                    c.a(hVar.e);
                } else {
                    hVar.e.setTag(portrait);
                    hVar.e.setImageResource(R.drawable.photo);
                }
            } else {
                hVar.e.setImageResource(R.drawable.photo);
            }
            hVar.c.b(uVar.i().getId());
            hVar.c.a(uVar.i().getName());
            hVar.e.setOnClickListener(hVar.c);
            if (hVar.k != null) {
                ao.b(hVar.k, an);
            }
            ao.b(hVar.f, an);
            if (an == 1) {
                if (hVar.d != null) {
                    ao.g(hVar.d, (int) R.drawable.message_replyme_1);
                }
                if (hVar.i != null) {
                    hVar.i.setTextColor(this.f1329a.getResources().getColor(R.color.skin_1_third_common_color));
                }
                hVar.h.setTextColor(this.f1329a.getResources().getColor(R.color.skin_1_second_common_color));
                view2 = view4;
            } else {
                if (hVar.d != null) {
                    ao.g(hVar.d, (int) R.drawable.message_replyme);
                }
                if (hVar.i != null) {
                    hVar.i.setTextColor(-12040120);
                }
                hVar.h.setTextColor(-12040120);
                view2 = view4;
            }
            return view2;
        }
        return view4;
    }
}
