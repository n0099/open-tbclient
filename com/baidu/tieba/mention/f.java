package com.baidu.tieba.mention;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.bg;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1859a;
    private ArrayList<com.baidu.tieba.data.u> b;
    private com.baidu.tieba.util.i c;
    private String d;
    private int h;
    private boolean[] k = new boolean[0];
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private ArrayList<ProgressBar> j = new ArrayList<>();
    private int i = 3;

    public f(Context context, ArrayList<com.baidu.tieba.data.u> arrayList) {
        this.f1859a = context;
        this.b = arrayList;
        this.d = this.f1859a.getText(R.string.forum).toString();
        this.c = new com.baidu.tieba.util.i(this.f1859a);
    }

    public void a() {
        if (this.j != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.j.size()) {
                    try {
                        this.j.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        bg.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.j.clear();
                    return;
                }
            }
        }
    }

    public void a(ArrayList<com.baidu.tieba.data.u> arrayList, boolean z) {
        if (!z) {
            this.k = new boolean[Math.min(100, t.a().b(this.h))];
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

    public void a(int i) {
        this.h = i;
    }

    public void b(int i) {
        this.i = i;
    }

    public int d() {
        return this.i;
    }

    public com.baidu.tieba.util.i e() {
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

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00e1: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x00e0 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        i iVar;
        View view4;
        i iVar2;
        try {
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        if (this.b == null) {
            return view;
        }
        int ap = TiebaApplication.g().ap();
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.f1859a);
                if (getItemViewType(i) == 0) {
                    if (this.h == 1) {
                        view4 = from.inflate(R.layout.mention_replyme_item, (ViewGroup) null);
                    } else {
                        view4 = from.inflate(R.layout.mention_atme_item, (ViewGroup) null);
                    }
                    i iVar3 = new i(this);
                    iVar3.k = (LinearLayout) view4.findViewById(R.id.reply_container);
                    iVar3.d = (ImageView) view4.findViewById(R.id.photo);
                    iVar3.e = (TextView) view4.findViewById(R.id.user_name);
                    iVar3.f = (TextView) view4.findViewById(R.id.time);
                    iVar3.g = (TextView) view4.findViewById(R.id.content);
                    if (this.h == 1) {
                        iVar3.h = (TextView) view4.findViewById(R.id.title);
                        iVar3.i = (TextView) view4.findViewById(R.id.forum);
                        iVar3.j = (TextView) view4.findViewById(R.id.reply_type);
                    }
                    iVar3.c = new h(this);
                    iVar3.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    iVar3.d.setOnClickListener(iVar3.c);
                    iVar2 = iVar3;
                } else {
                    view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    i iVar4 = new i(this);
                    iVar4.f1861a = (TextView) view4.findViewById(R.id.page_text);
                    iVar4.b = (ProgressBar) view4.findViewById(R.id.progress);
                    this.j.add(iVar4.b);
                    iVar2 = iVar4;
                }
                view4.setTag(iVar2);
                iVar = iVar2;
            } else {
                iVar = (i) view.getTag();
                view4 = view;
            }
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            bg.b(getClass().getName(), "", "ReplymeAdapter.getView error = " + exc.getMessage());
            return view2;
        }
        if (getItemViewType(i) == 1) {
            long itemId = getItemId(i);
            if (itemId == -1) {
                if (this.f) {
                    iVar.b.setVisibility(0);
                    iVar.f1861a.setText(R.string.loading);
                } else {
                    iVar.b.setVisibility(8);
                    iVar.f1861a.setText(R.string.refresh);
                }
            } else if (itemId == -2) {
                if (this.g) {
                    iVar.b.setVisibility(0);
                    iVar.f1861a.setText(R.string.loading);
                } else {
                    iVar.b.setVisibility(8);
                    iVar.f1861a.setText(R.string.more);
                }
            }
            if (ap == 1) {
                if (iVar.f1861a != null) {
                    bd.e((View) iVar.f1861a, (int) R.drawable.btn_w_square_1);
                    iVar.f1861a.setTextColor(-8682095);
                    return view4;
                }
                return view4;
            }
            bd.e((View) iVar.f1861a, (int) R.drawable.btn_w_square);
            iVar.f1861a.setTextColor(-14277082);
            return view4;
        }
        if (ap == 1) {
            bd.e(view4, (int) R.drawable.list_selector_1);
        } else {
            bd.e(view4, (int) R.drawable.list_selector);
        }
        com.baidu.tieba.data.u uVar = (com.baidu.tieba.data.u) getItem(i);
        if (uVar != null) {
            iVar.e.setText(uVar.i().getName_show());
            iVar.f.setText(be.b(uVar.b()));
            iVar.g.setText(uVar.e());
            if (this.h == 1) {
                if (uVar.a() == 1) {
                    iVar.j.setText(this.f1859a.getString(R.string.mention_replyme_post));
                    iVar.h.setText(uVar.f());
                } else {
                    iVar.j.setText(this.f1859a.getString(R.string.mention_replyme_thread));
                    iVar.h.setText(uVar.c());
                }
                if (uVar.d() != null && uVar.d().length() > 0) {
                    iVar.i.setVisibility(0);
                    iVar.i.setText(this.f1859a.getString(R.string.reply_from) + be.a(uVar.d(), 12).concat(this.d));
                } else {
                    iVar.i.setVisibility(8);
                }
            }
            iVar.d.setVisibility(0);
            String portrait = uVar.i().getPortrait();
            iVar.d.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                com.baidu.adp.widget.ImageView.e c = this.c.c(portrait);
                if (c != null) {
                    c.a(iVar.d);
                } else {
                    iVar.d.setTag(portrait);
                    iVar.d.setImageResource(R.drawable.photo);
                }
            } else {
                iVar.d.setImageResource(R.drawable.photo);
            }
            iVar.c.b(uVar.i().getId());
            iVar.c.a(uVar.i().getName());
            iVar.d.setOnClickListener(iVar.c);
            if (ap == 1) {
                if (iVar.k != null) {
                    iVar.k.setBackgroundResource(R.drawable.nearby_reply_bg_pressed_1);
                }
                if (iVar.h != null) {
                    iVar.h.setTextColor(this.f1859a.getResources().getColor(R.color.c_5f6c7a));
                }
                if (iVar.i != null) {
                    iVar.i.setTextColor(this.f1859a.getResources().getColor(R.color.c_515865));
                }
                if (iVar.f != null) {
                    iVar.f.setTextColor(this.f1859a.getResources().getColor(R.color.c_515865));
                    iVar.f.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(this.f1859a.getResources(), BitmapFactory.decodeResource(this.f1859a.getResources(), R.drawable.icon_little_time_1)), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (iVar.g != null) {
                    iVar.g.setTextColor(this.f1859a.getResources().getColor(R.color.c_7b8591));
                }
                if (iVar.j != null) {
                    iVar.j.setTextColor(this.f1859a.getResources().getColor(R.color.c_5f6c7a));
                }
                if (iVar.e != null) {
                    iVar.e.setTextColor(this.f1859a.getResources().getColor(R.color.c_515865));
                }
            } else {
                if (iVar.k != null) {
                    iVar.k.setBackgroundResource(R.drawable.search_preycotbj);
                }
                if (iVar.i != null) {
                    iVar.i.setTextColor(this.f1859a.getResources().getColor(R.color.c_b2b6ba));
                }
                if (iVar.f != null) {
                    iVar.f.setTextColor(this.f1859a.getResources().getColor(R.color.c_b2b6ba));
                    iVar.f.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(this.f1859a.getResources(), BitmapFactory.decodeResource(this.f1859a.getResources(), R.drawable.icon_little_time)), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (iVar.h != null) {
                    iVar.h.setTextColor(this.f1859a.getResources().getColor(R.color.search_text_title));
                }
                if (iVar.g != null) {
                    iVar.g.setTextColor(this.f1859a.getResources().getColor(R.color.c_262626));
                }
                if (iVar.j != null) {
                    iVar.j.setTextColor(this.f1859a.getResources().getColor(R.color.search_text_title));
                }
                if (iVar.e != null) {
                    iVar.e.setTextColor(this.f1859a.getResources().getColor(R.color.search_text_title));
                }
            }
            view2 = view4;
            return view2;
        }
        return view4;
    }
}
