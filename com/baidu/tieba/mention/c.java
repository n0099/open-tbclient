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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private final Context a;
    private ArrayList<com.baidu.tieba.data.p> b;
    private final String c;
    private int g;
    private boolean[] j = new boolean[0];
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private final ArrayList<ProgressBar> i = new ArrayList<>();
    private int h = 3;

    public c(Context context, ArrayList<com.baidu.tieba.data.p> arrayList) {
        this.a = context;
        this.b = arrayList;
        this.c = this.a.getText(com.baidu.tieba.y.forum).toString();
    }

    public void a() {
        if (this.i != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.i.size()) {
                    try {
                        this.i.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.i.clear();
                    return;
                }
            }
        }
    }

    public void a(ArrayList<com.baidu.tieba.data.p> arrayList, boolean z) {
        if (!z) {
            this.j = new boolean[Math.min(100, com.baidu.tbadk.coreExtra.messageCenter.a.a().f(this.g))];
        }
        this.b = arrayList;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public boolean b() {
        return this.e;
    }

    public void c(boolean z) {
        this.f = z;
    }

    public boolean c() {
        return this.f;
    }

    public void a(int i) {
        this.g = i;
    }

    public void b(int i) {
        this.h = i;
    }

    public int d() {
        return this.h;
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

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00dd: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:30:0x00dc */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        e eVar;
        View view4;
        Object obj;
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
                    if (this.g == 1) {
                        view4 = from.inflate(com.baidu.tieba.w.mention_replyme_item, (ViewGroup) null);
                    } else {
                        view4 = from.inflate(com.baidu.tieba.w.mention_atme_item, (ViewGroup) null);
                    }
                    e eVar2 = new e(this, null);
                    eVar2.l = (LinearLayout) view4.findViewById(com.baidu.tieba.v.reply_container);
                    eVar2.d = (HeadImageView) view4.findViewById(com.baidu.tieba.v.photo);
                    eVar2.e = (TextView) view4.findViewById(com.baidu.tieba.v.user_name);
                    eVar2.f = (TextView) view4.findViewById(com.baidu.tieba.v.time);
                    eVar2.h = view4.findViewById(com.baidu.tieba.v.line);
                    eVar2.g = (TextView) view4.findViewById(com.baidu.tieba.v.content);
                    if (this.g == 1) {
                        eVar2.i = (TextView) view4.findViewById(com.baidu.tieba.v.title);
                        eVar2.j = (TextView) view4.findViewById(com.baidu.tieba.v.forum);
                        eVar2.k = (TextView) view4.findViewById(com.baidu.tieba.v.reply_type);
                    }
                    eVar2.c = new d(this);
                    eVar2.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    eVar2.d.setOnClickListener(eVar2.c);
                    obj = eVar2;
                } else {
                    view4 = from.inflate(com.baidu.tieba.w.new_pb_list_more, (ViewGroup) null);
                    e eVar3 = new e(this, null);
                    eVar3.a = (TextView) view4.findViewById(com.baidu.tieba.v.pb_more_text);
                    eVar3.b = (ProgressBar) view4.findViewById(com.baidu.tieba.v.progress);
                    this.i.add(eVar3.b);
                    obj = eVar3;
                }
                view4.setTag(obj);
                eVar = obj;
            } else {
                eVar = (e) view.getTag();
                view4 = view;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view3;
            BdLog.e(exc.getMessage());
            return view2;
        }
        if (getItemViewType(i) == 1) {
            long itemId = getItemId(i);
            if (itemId == -1) {
                if (this.e) {
                    eVar.b.setVisibility(0);
                    eVar.a.setText(com.baidu.tieba.y.loading);
                } else {
                    eVar.b.setVisibility(8);
                    eVar.a.setText(com.baidu.tieba.y.refresh);
                }
            } else if (itemId == -2) {
                if (this.f) {
                    eVar.b.setVisibility(0);
                    eVar.a.setText(com.baidu.tieba.y.loading);
                } else if (this.d) {
                    eVar.b.setVisibility(0);
                    eVar.a.setText(com.baidu.tieba.y.loading);
                } else {
                    eVar.b.setVisibility(8);
                    eVar.a.setText(com.baidu.tieba.y.no_more_msg);
                }
            }
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                eVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.pb_more_txt_1));
                return view4;
            }
            eVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.pb_more_txt));
            return view4;
        }
        com.baidu.tieba.data.p pVar = (com.baidu.tieba.data.p) getItem(i);
        if (pVar != null) {
            if ("zan".equals(pVar.a())) {
                List<com.baidu.tieba.data.y> c = pVar.c();
                if (c != null && c.size() > 0) {
                    com.baidu.tieba.data.y yVar = c.get(0);
                    eVar.e.setText(yVar.c());
                    eVar.f.setText(bm.a(pVar.e()));
                    if (c.size() > 3) {
                        eVar.g.setText(String.format(this.a.getString(com.baidu.tieba.y.message_praise_like_list_more), c.get(0).c(), c.get(1).c(), c.get(2).c(), Integer.valueOf(pVar.b())));
                    } else if (c.size() > 2) {
                        eVar.g.setText(String.format(this.a.getString(com.baidu.tieba.y.message_praise_like_list_3), c.get(0).c(), c.get(1).c(), c.get(2).c()));
                    } else if (c.size() > 1) {
                        eVar.g.setText(String.format(this.a.getString(com.baidu.tieba.y.message_praise_like_list_2), c.get(0).c(), c.get(1).c()));
                    } else {
                        eVar.g.setText(String.format(this.a.getString(com.baidu.tieba.y.message_praise_like_list_1), c.get(0).c()));
                    }
                    eVar.k.setText(this.a.getString(com.baidu.tieba.y.mention_praiseme_post));
                    eVar.i.setText(pVar.f());
                    if (pVar.g() != null && pVar.g().length() > 0) {
                        eVar.j.setVisibility(0);
                        eVar.j.setText(String.valueOf(this.a.getString(com.baidu.tieba.y.reply_from)) + bm.a(pVar.g(), 12).concat(this.c));
                    } else {
                        eVar.j.setVisibility(8);
                    }
                    eVar.d.setVisibility(0);
                    String d = yVar.d();
                    if (d != null && d.length() > 0) {
                        eVar.d.a(d, 12, false);
                    } else {
                        eVar.d.setImageResource(com.baidu.tieba.u.photo);
                    }
                    eVar.c.b(yVar.a());
                    eVar.c.a(yVar.b());
                    eVar.d.setOnClickListener(eVar.c);
                }
            } else {
                eVar.e.setText(pVar.l().getName_show());
                eVar.f.setText(bm.a(pVar.e()));
                eVar.g.setText(pVar.h());
                if (this.g == 1) {
                    if (pVar.d() == 1) {
                        eVar.k.setText(this.a.getString(com.baidu.tieba.y.mention_replyme_post));
                        eVar.i.setText(pVar.i());
                    } else {
                        eVar.k.setText(this.a.getString(com.baidu.tieba.y.mention_replyme_thread));
                        eVar.i.setText(pVar.f());
                    }
                    if (pVar.g() != null && pVar.g().length() > 0) {
                        eVar.j.setVisibility(0);
                        eVar.j.setText(String.valueOf(this.a.getString(com.baidu.tieba.y.reply_from)) + bm.a(pVar.g(), 12).concat(this.c));
                    } else {
                        eVar.j.setVisibility(8);
                    }
                }
                eVar.d.setVisibility(0);
                String portrait = pVar.l().getPortrait();
                eVar.d.setTag(null);
                if (portrait != null && portrait.length() > 0) {
                    eVar.d.a(portrait, 12, false);
                } else {
                    eVar.d.setImageResource(com.baidu.tieba.u.photo);
                }
                eVar.c.b(pVar.l().getUserId());
                eVar.c.a(pVar.l().getUserName());
                eVar.d.setOnClickListener(eVar.c);
            }
            a(eVar, view4);
            view2 = view4;
            return view2;
        }
        return view4;
    }

    private void a(e eVar, View view) {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (skinType == 1) {
            bk.e(view, com.baidu.tieba.u.list_selector_1);
        } else {
            bk.e(view, com.baidu.tieba.u.list_selector);
        }
        bk.f(eVar.h, com.baidu.tieba.s.cp_bg_line_b);
        if (skinType == 1) {
            if (eVar.l != null) {
                eVar.l.setBackgroundResource(com.baidu.tieba.u.nearby_reply_bg_pressed_1);
            }
            if (eVar.i != null) {
                eVar.i.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.c_5f6c7a));
            }
            if (eVar.j != null) {
                eVar.j.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.c_515865));
            }
            if (eVar.f != null) {
                eVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.c_515865));
                eVar.f.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(this.a.getResources(), BitmapFactory.decodeResource(this.a.getResources(), com.baidu.tieba.u.icon_little_time_1)), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (eVar.g != null) {
                eVar.g.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.c_7b8591));
            }
            if (eVar.k != null) {
                eVar.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.c_5f6c7a));
            }
            if (eVar.e != null) {
                eVar.e.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.c_515865));
                return;
            }
            return;
        }
        if (eVar.l != null) {
            eVar.l.setBackgroundResource(com.baidu.tieba.u.search_preycotbj);
        }
        if (eVar.j != null) {
            eVar.j.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.c_b2b6ba));
        }
        if (eVar.f != null) {
            eVar.f.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.c_b2b6ba));
            eVar.f.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(this.a.getResources(), BitmapFactory.decodeResource(this.a.getResources(), com.baidu.tieba.u.icon_little_time)), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (eVar.i != null) {
            eVar.i.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.search_text_title));
        }
        if (eVar.g != null) {
            eVar.g.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.c_262626));
        }
        if (eVar.k != null) {
            eVar.k.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.search_text_title));
        }
        if (eVar.e != null) {
            eVar.e.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.search_text_title));
        }
    }
}
