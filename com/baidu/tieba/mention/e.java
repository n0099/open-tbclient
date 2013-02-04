package com.baidu.tieba.mention;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.c.ad;
import com.baidu.tieba.c.ae;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private Context a;
    private ArrayList b;
    private com.baidu.tieba.c.a c;
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
        this.c = new com.baidu.tieba.c.a(this.a);
    }

    public void a() {
        if (this.j == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.j.size()) {
                this.j.clear();
                return;
            }
            try {
                ((ProgressBar) this.j.get(i2)).setVisibility(8);
            } catch (Exception e) {
                ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
            }
            i = i2 + 1;
        }
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(ArrayList arrayList) {
        this.b = arrayList;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b(int i) {
        this.i = i;
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

    public int d() {
        return this.i;
    }

    public com.baidu.tieba.c.a e() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            int size = this.b.size();
            return this.e ? size + 1 : size;
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

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : 1;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00bb: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:27:0x00ba */
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
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.a);
                if (getItemViewType(i) == 0) {
                    view4 = this.h == 0 ? from.inflate(R.layout.mention_replyme_item, (ViewGroup) null) : from.inflate(R.layout.mention_atme_item, (ViewGroup) null);
                    g gVar3 = new g(this, null);
                    gVar3.d = (ImageView) view4.findViewById(R.id.photo);
                    gVar3.e = (TextView) view4.findViewById(R.id.user_name);
                    gVar3.e.getPaint().setFakeBoldText(true);
                    gVar3.f = (TextView) view4.findViewById(R.id.time);
                    gVar3.g = (TextView) view4.findViewById(R.id.content);
                    if (this.h == 0) {
                        gVar3.h = (TextView) view4.findViewById(R.id.title);
                        gVar3.i = (TextView) view4.findViewById(R.id.forum);
                        gVar3.j = (TextView) view4.findViewById(R.id.reply_type);
                    }
                    gVar3.c = new f(this);
                    gVar3.d.setOnClickListener(gVar3.c);
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
                    return view4;
                }
                gVar.b.setVisibility(8);
                gVar.a.setText(R.string.refresh);
                return view4;
            } else if (itemId == -2) {
                if (this.g) {
                    gVar.b.setVisibility(0);
                    gVar.a.setText(R.string.loading);
                    return view4;
                }
                gVar.b.setVisibility(8);
                gVar.a.setText(R.string.more);
                return view4;
            } else {
                return view4;
            }
        }
        com.baidu.tieba.a.o oVar = (com.baidu.tieba.a.o) getItem(i);
        if (oVar != null) {
            gVar.e.setText(oVar.i().c());
            gVar.f.setText(ad.a(oVar.b()));
            gVar.g.setText(oVar.e());
            gVar.e.setTextSize(com.baidu.tieba.a.h.l());
            gVar.g.setTextSize(com.baidu.tieba.a.h.k());
            if (this.h == 0) {
                if (oVar.a() == 1) {
                    gVar.j.setText(this.a.getString(R.string.mention_replyme_post));
                    gVar.h.setText(oVar.f());
                } else {
                    gVar.j.setText(this.a.getString(R.string.mention_replyme_thread));
                    gVar.h.setText(oVar.c());
                }
                if (oVar.d() == null || oVar.d().length() <= 0) {
                    gVar.i.setVisibility(8);
                } else {
                    gVar.i.setVisibility(0);
                    gVar.i.setText(">" + ad.a(oVar.d(), 12).concat(this.d));
                }
            }
            gVar.d.setVisibility(0);
            String d = oVar.i().d();
            gVar.d.setTag(null);
            if (d == null || d.length() <= 0) {
                gVar.d.setImageResource(R.drawable.photo);
            } else {
                Bitmap b = this.c.b(d);
                if (b != null) {
                    gVar.d.setImageBitmap(b);
                } else {
                    gVar.d.setTag(d);
                    gVar.d.setImageResource(R.drawable.photo);
                }
            }
            gVar.c.b(oVar.i().a());
            gVar.c.a(oVar.i().b());
            gVar.d.setOnClickListener(gVar.c);
            view2 = view4;
            return view2;
        }
        return view4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
