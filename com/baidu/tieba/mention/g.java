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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class g extends BaseAdapter {
    private final Context a;
    private final com.baidu.tbadk.editortool.ab c;
    private final String d;
    private int h;
    private boolean[] k = new boolean[0];
    private ArrayList<com.baidu.tieba.data.o> b = null;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private final ArrayList<ProgressBar> j = new ArrayList<>();
    private int i = 3;

    public g(Context context, ArrayList<com.baidu.tieba.data.o> arrayList) {
        this.a = context;
        this.d = this.a.getText(com.baidu.tieba.a.k.forum).toString();
        this.c = new com.baidu.tbadk.editortool.ab(this.a);
    }

    public final void a() {
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

    public final void a(ArrayList<com.baidu.tieba.data.o> arrayList, boolean z) {
        if (!z) {
            this.k = new boolean[Math.min(100, com.baidu.tbadk.coreExtra.messageCenter.a.a().g(this.h))];
        }
        this.b = arrayList;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final void b(boolean z) {
        this.f = false;
    }

    public final boolean b() {
        return this.f;
    }

    public final void c(boolean z) {
        this.g = z;
    }

    public final boolean c() {
        return this.g;
    }

    public final void a(int i) {
        this.h = i;
    }

    public final void b(int i) {
        this.i = i;
    }

    public final int d() {
        return this.i;
    }

    public final com.baidu.tbadk.editortool.ab e() {
        return this.c;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
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
    public final Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.b.size()) {
            return null;
        }
        return this.b.get(itemId);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        if (i == getCount() - 1) {
            i = -2;
        }
        return i;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00dd: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:30:0x00dc */
    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
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
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.a);
                if (getItemViewType(i) == 0) {
                    if (this.h == 1) {
                        view4 = from.inflate(com.baidu.tieba.a.i.mention_replyme_item, (ViewGroup) null);
                    } else {
                        view4 = from.inflate(com.baidu.tieba.a.i.mention_atme_item, (ViewGroup) null);
                    }
                    j jVar3 = new j(this, (byte) 0);
                    jVar3.l = (LinearLayout) view4.findViewById(com.baidu.tieba.a.h.reply_container);
                    jVar3.d = (ImageView) view4.findViewById(com.baidu.tieba.a.h.photo);
                    jVar3.e = (TextView) view4.findViewById(com.baidu.tieba.a.h.user_name);
                    jVar3.f = (TextView) view4.findViewById(com.baidu.tieba.a.h.time);
                    jVar3.h = view4.findViewById(com.baidu.tieba.a.h.line);
                    jVar3.g = (TextView) view4.findViewById(com.baidu.tieba.a.h.content);
                    if (this.h == 1) {
                        jVar3.i = (TextView) view4.findViewById(com.baidu.tieba.a.h.title);
                        jVar3.j = (TextView) view4.findViewById(com.baidu.tieba.a.h.forum);
                        jVar3.k = (TextView) view4.findViewById(com.baidu.tieba.a.h.reply_type);
                    }
                    jVar3.c = new i(this);
                    jVar3.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    jVar3.d.setOnClickListener(jVar3.c);
                    jVar2 = jVar3;
                } else {
                    view4 = from.inflate(com.baidu.tieba.a.i.new_pb_list_more, (ViewGroup) null);
                    j jVar4 = new j(this, (byte) 0);
                    jVar4.a = (TextView) view4.findViewById(com.baidu.tieba.a.h.pb_more_text);
                    jVar4.b = (ProgressBar) view4.findViewById(com.baidu.tieba.a.h.progress);
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
            exc = e2;
            view2 = view3;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "", "ReplymeAdapter.getView error = " + exc.getMessage());
            return view2;
        }
        if (getItemViewType(i) == 1) {
            long itemId = getItemId(i);
            if (itemId == -1) {
                if (this.f) {
                    jVar.b.setVisibility(0);
                    jVar.a.setText(com.baidu.tieba.a.k.loading);
                } else {
                    jVar.b.setVisibility(8);
                    jVar.a.setText(com.baidu.tieba.a.k.refresh);
                }
            } else if (itemId == -2) {
                if (this.g) {
                    jVar.b.setVisibility(0);
                    jVar.a.setText(com.baidu.tieba.a.k.loading);
                } else if (this.e) {
                    jVar.b.setVisibility(0);
                    jVar.a.setText(com.baidu.tieba.a.k.loading);
                } else {
                    jVar.b.setVisibility(8);
                    jVar.a.setText(com.baidu.tieba.a.k.no_more_msg);
                }
            }
            if (TbadkApplication.j().l() == 1) {
                jVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.pb_more_txt_1));
                return view4;
            }
            jVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.pb_more_txt));
            return view4;
        }
        com.baidu.tieba.data.o oVar = (com.baidu.tieba.data.o) getItem(i);
        if (oVar != null) {
            if ("zan".equals(oVar.a())) {
                List<com.baidu.tieba.data.w> c = oVar.c();
                if (c != null && c.size() > 0) {
                    com.baidu.tieba.data.w wVar = c.get(0);
                    jVar.e.setText(wVar.c());
                    jVar.f.setText(bc.a(oVar.e()));
                    if (c.size() > 3) {
                        jVar.g.setText(String.format(this.a.getString(com.baidu.tieba.a.k.message_praise_like_list_more), c.get(0).c(), c.get(1).c(), c.get(2).c(), Integer.valueOf(oVar.b())));
                    } else if (c.size() > 2) {
                        jVar.g.setText(String.format(this.a.getString(com.baidu.tieba.a.k.message_praise_like_list_3), c.get(0).c(), c.get(1).c(), c.get(2).c()));
                    } else if (c.size() > 1) {
                        jVar.g.setText(String.format(this.a.getString(com.baidu.tieba.a.k.message_praise_like_list_2), c.get(0).c(), c.get(1).c()));
                    } else {
                        jVar.g.setText(String.format(this.a.getString(com.baidu.tieba.a.k.message_praise_like_list_1), c.get(0).c()));
                    }
                    jVar.k.setText(this.a.getString(com.baidu.tieba.a.k.mention_praiseme_post));
                    jVar.i.setText(oVar.f());
                    if (oVar.g() != null && oVar.g().length() > 0) {
                        jVar.j.setVisibility(0);
                        jVar.j.setText(String.valueOf(this.a.getString(com.baidu.tieba.a.k.reply_from)) + bc.a(oVar.g(), 12).concat(this.d));
                    } else {
                        jVar.j.setVisibility(8);
                    }
                    jVar.d.setVisibility(0);
                    String d = wVar.d();
                    ImageView imageView = jVar.d;
                    if (d != null && d.length() > 0) {
                        com.baidu.tbadk.editortool.ab abVar = this.c;
                        com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(d);
                        if (b != null) {
                            jVar.d.setTag(null);
                            b.a(jVar.d);
                        } else {
                            this.c.c(d, new h(this, imageView, d));
                        }
                    } else {
                        jVar.d.setImageResource(com.baidu.tieba.a.g.photo);
                    }
                    jVar.c.b(wVar.a());
                    jVar.c.a(wVar.b());
                    jVar.d.setOnClickListener(jVar.c);
                } else {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "", "ReplymeAdapter.getView error =  is zan msg but like list is null.");
                }
            } else {
                jVar.e.setText(oVar.l().getName_show());
                jVar.f.setText(bc.a(oVar.e()));
                jVar.g.setText(oVar.h());
                if (this.h == 1) {
                    if (oVar.d() == 1) {
                        jVar.k.setText(this.a.getString(com.baidu.tieba.a.k.mention_replyme_post));
                        jVar.i.setText(oVar.i());
                    } else {
                        jVar.k.setText(this.a.getString(com.baidu.tieba.a.k.mention_replyme_thread));
                        jVar.i.setText(oVar.f());
                    }
                    if (oVar.g() != null && oVar.g().length() > 0) {
                        jVar.j.setVisibility(0);
                        jVar.j.setText(String.valueOf(this.a.getString(com.baidu.tieba.a.k.reply_from)) + bc.a(oVar.g(), 12).concat(this.d));
                    } else {
                        jVar.j.setVisibility(8);
                    }
                }
                jVar.d.setVisibility(0);
                String portrait = oVar.l().getPortrait();
                jVar.d.setTag(null);
                if (portrait != null && portrait.length() > 0) {
                    com.baidu.tbadk.editortool.ab abVar2 = this.c;
                    com.baidu.adp.widget.ImageView.b b2 = com.baidu.tbadk.imageManager.e.a().b(portrait);
                    if (b2 != null) {
                        b2.a(jVar.d);
                        jVar.c.b(oVar.l().getUserId());
                        jVar.c.a(oVar.l().getUserName());
                        jVar.d.setOnClickListener(jVar.c);
                    } else {
                        jVar.d.setTag(portrait);
                    }
                }
                jVar.d.setImageResource(com.baidu.tieba.a.g.photo);
                jVar.c.b(oVar.l().getUserId());
                jVar.c.a(oVar.l().getUserName());
                jVar.d.setOnClickListener(jVar.c);
            }
            int l = TbadkApplication.j().l();
            if (l == 1) {
                ba.e(view4, com.baidu.tieba.a.g.list_selector_1);
            } else {
                ba.e(view4, com.baidu.tieba.a.g.list_selector);
            }
            ba.f(jVar.h, com.baidu.tieba.a.e.cp_bg_line_b);
            if (l == 1) {
                if (jVar.l != null) {
                    jVar.l.setBackgroundResource(com.baidu.tieba.a.g.nearby_reply_bg_pressed_1);
                }
                if (jVar.i != null) {
                    jVar.i.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.c_5f6c7a));
                }
                if (jVar.j != null) {
                    jVar.j.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.c_515865));
                }
                if (jVar.f != null) {
                    jVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.c_515865));
                    jVar.f.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(this.a.getResources(), BitmapFactory.decodeResource(this.a.getResources(), com.baidu.tieba.a.g.icon_little_time_1)), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (jVar.g != null) {
                    jVar.g.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.c_7b8591));
                }
                if (jVar.k != null) {
                    jVar.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.c_5f6c7a));
                }
                if (jVar.e != null) {
                    jVar.e.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.c_515865));
                    view2 = view4;
                    return view2;
                }
            } else {
                if (jVar.l != null) {
                    jVar.l.setBackgroundResource(com.baidu.tieba.a.g.search_preycotbj);
                }
                if (jVar.j != null) {
                    jVar.j.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.c_b2b6ba));
                }
                if (jVar.f != null) {
                    jVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.c_b2b6ba));
                    jVar.f.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(this.a.getResources(), BitmapFactory.decodeResource(this.a.getResources(), com.baidu.tieba.a.g.icon_little_time)), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (jVar.i != null) {
                    jVar.i.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.search_text_title));
                }
                if (jVar.g != null) {
                    jVar.g.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.c_262626));
                }
                if (jVar.k != null) {
                    jVar.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.search_text_title));
                }
                if (jVar.e != null) {
                    jVar.e.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.search_text_title));
                }
            }
            view2 = view4;
            return view2;
        }
        return view4;
    }
}
