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
import com.baidu.tieba.util.bq;
import com.baidu.tieba.util.bs;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private Context a;
    private ArrayList<com.baidu.tieba.data.t> b;
    private com.baidu.tieba.util.i c;
    private String d;
    private int h;
    private boolean[] k = new boolean[0];
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private ArrayList<ProgressBar> j = new ArrayList<>();
    private int i = 3;

    public h(Context context, ArrayList<com.baidu.tieba.data.t> arrayList) {
        this.a = context;
        this.b = arrayList;
        this.d = this.a.getText(R.string.forum).toString();
        this.c = new com.baidu.tieba.util.i(this.a);
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
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.j.clear();
                    return;
                }
            }
        }
    }

    public void a(ArrayList<com.baidu.tieba.data.t> arrayList, boolean z) {
        if (!z) {
            this.k = new boolean[Math.min(100, v.a().g(this.h))];
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
            if (size > 0) {
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
        if (i == getCount() - 1) {
            i = -2;
        }
        return i;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00e7: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:31:0x00e6 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        j jVar;
        View view4;
        j jVar2;
        try {
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        if (this.b == null) {
            return view;
        }
        int al = TiebaApplication.g().al();
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.a);
                if (getItemViewType(i) == 0) {
                    if (this.h == 1) {
                        view4 = from.inflate(R.layout.mention_replyme_item, (ViewGroup) null);
                    } else {
                        view4 = from.inflate(R.layout.mention_atme_item, (ViewGroup) null);
                    }
                    j jVar3 = new j(this, null);
                    jVar3.k = (LinearLayout) view4.findViewById(R.id.reply_container);
                    jVar3.d = (ImageView) view4.findViewById(R.id.photo);
                    jVar3.e = (TextView) view4.findViewById(R.id.user_name);
                    jVar3.f = (TextView) view4.findViewById(R.id.time);
                    jVar3.g = (TextView) view4.findViewById(R.id.content);
                    if (this.h == 1) {
                        jVar3.h = (TextView) view4.findViewById(R.id.title);
                        jVar3.i = (TextView) view4.findViewById(R.id.forum);
                        jVar3.j = (TextView) view4.findViewById(R.id.reply_type);
                    }
                    jVar3.c = new i(this);
                    jVar3.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    jVar3.d.setOnClickListener(jVar3.c);
                    jVar2 = jVar3;
                } else {
                    view4 = from.inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    j jVar4 = new j(this, null);
                    jVar4.a = (TextView) view4.findViewById(R.id.pb_more_text);
                    jVar4.b = (ProgressBar) view4.findViewById(R.id.progress);
                    this.j.add(jVar4.b);
                    jVar2 = jVar4;
                }
                view4.setTag(jVar2);
                jVar = jVar2;
            } else {
                jVar = (j) view.getTag();
                view4 = view;
            }
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "", "ReplymeAdapter.getView error = " + exc.getMessage());
            return view2;
        }
        if (getItemViewType(i) == 1) {
            long itemId = getItemId(i);
            if (itemId == -1) {
                if (this.f) {
                    jVar.b.setVisibility(0);
                    jVar.a.setText(R.string.loading);
                } else {
                    jVar.b.setVisibility(8);
                    jVar.a.setText(R.string.refresh);
                }
            } else if (itemId == -2) {
                if (this.g) {
                    jVar.b.setVisibility(0);
                    jVar.a.setText(R.string.loading);
                } else if (this.e) {
                    jVar.b.setVisibility(0);
                    jVar.a.setText(R.string.loading);
                } else {
                    jVar.b.setVisibility(8);
                    jVar.a.setText(R.string.no_more_msg);
                }
            }
            if (TiebaApplication.g().al() == 1) {
                jVar.a.setTextColor(this.a.getResources().getColor(R.color.pb_more_txt_1));
                return view4;
            }
            jVar.a.setTextColor(this.a.getResources().getColor(R.color.pb_more_txt));
            return view4;
        }
        if (al == 1) {
            bq.e(view4, (int) R.drawable.list_selector_1);
        } else {
            bq.e(view4, (int) R.drawable.list_selector);
        }
        com.baidu.tieba.data.t tVar = (com.baidu.tieba.data.t) getItem(i);
        if (tVar != null) {
            jVar.e.setText(tVar.i().getName_show());
            jVar.f.setText(bs.a(tVar.b()));
            jVar.g.setText(tVar.e());
            if (this.h == 1) {
                if (tVar.a() == 1) {
                    jVar.j.setText(this.a.getString(R.string.mention_replyme_post));
                    jVar.h.setText(tVar.f());
                } else {
                    jVar.j.setText(this.a.getString(R.string.mention_replyme_thread));
                    jVar.h.setText(tVar.c());
                }
                if (tVar.d() != null && tVar.d().length() > 0) {
                    jVar.i.setVisibility(0);
                    jVar.i.setText(String.valueOf(this.a.getString(R.string.reply_from)) + bs.a(tVar.d(), 12).concat(this.d));
                } else {
                    jVar.i.setVisibility(8);
                }
            }
            jVar.d.setVisibility(0);
            String portrait = tVar.i().getPortrait();
            jVar.d.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                com.baidu.adp.widget.ImageView.b c = this.c.c(portrait);
                if (c != null) {
                    c.a(jVar.d);
                } else {
                    jVar.d.setTag(portrait);
                    jVar.d.setImageResource(R.drawable.photo);
                }
            } else {
                jVar.d.setImageResource(R.drawable.photo);
            }
            jVar.c.b(tVar.i().getUserId());
            jVar.c.a(tVar.i().getUserName());
            jVar.d.setOnClickListener(jVar.c);
            if (al == 1) {
                if (jVar.k != null) {
                    jVar.k.setBackgroundResource(R.drawable.nearby_reply_bg_pressed_1);
                }
                if (jVar.h != null) {
                    jVar.h.setTextColor(this.a.getResources().getColor(R.color.c_5f6c7a));
                }
                if (jVar.i != null) {
                    jVar.i.setTextColor(this.a.getResources().getColor(R.color.c_515865));
                }
                if (jVar.f != null) {
                    jVar.f.setTextColor(this.a.getResources().getColor(R.color.c_515865));
                    jVar.f.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(this.a.getResources(), BitmapFactory.decodeResource(this.a.getResources(), R.drawable.icon_little_time_1)), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (jVar.g != null) {
                    jVar.g.setTextColor(this.a.getResources().getColor(R.color.c_7b8591));
                }
                if (jVar.j != null) {
                    jVar.j.setTextColor(this.a.getResources().getColor(R.color.c_5f6c7a));
                }
                if (jVar.e != null) {
                    jVar.e.setTextColor(this.a.getResources().getColor(R.color.c_515865));
                    view2 = view4;
                }
                view2 = view4;
            } else {
                if (jVar.k != null) {
                    jVar.k.setBackgroundResource(R.drawable.search_preycotbj);
                }
                if (jVar.i != null) {
                    jVar.i.setTextColor(this.a.getResources().getColor(R.color.c_b2b6ba));
                }
                if (jVar.f != null) {
                    jVar.f.setTextColor(this.a.getResources().getColor(R.color.c_b2b6ba));
                    jVar.f.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(this.a.getResources(), BitmapFactory.decodeResource(this.a.getResources(), R.drawable.icon_little_time)), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (jVar.h != null) {
                    jVar.h.setTextColor(this.a.getResources().getColor(R.color.search_text_title));
                }
                if (jVar.g != null) {
                    jVar.g.setTextColor(this.a.getResources().getColor(R.color.c_262626));
                }
                if (jVar.j != null) {
                    jVar.j.setTextColor(this.a.getResources().getColor(R.color.search_text_title));
                }
                if (jVar.e != null) {
                    jVar.e.setTextColor(this.a.getResources().getColor(R.color.search_text_title));
                    view2 = view4;
                }
                view2 = view4;
            }
            return view2;
        }
        return view4;
    }
}
