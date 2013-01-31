package com.baidu.tieba.person;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ad extends BaseAdapter {
    Context a;
    com.baidu.tieba.b.j b;
    private ArrayList c = new ArrayList();

    public ad(Context context, com.baidu.tieba.b.j jVar) {
        this.a = null;
        this.b = null;
        this.a = context;
        this.b = jVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null || this.b.a().size() == 0) {
            return 0;
        }
        return this.b.a().size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null || i < 0 || i >= this.b.a().size()) {
            return null;
        }
        return this.b.a().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.b == null ? 0 : 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (getItem(i) != null) {
            if (((com.baidu.tieba.b.k) getItem(i)).a() == 0) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x01ea: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:59:0x01e9 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        int itemViewType;
        int af;
        View view3;
        ah ahVar;
        ai aiVar;
        View view4;
        String string;
        ag agVar = null;
        try {
            itemViewType = getItemViewType(i);
            af = TiebaApplication.b().af();
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.a);
                if (itemViewType == 0) {
                    view4 = from.inflate(R.layout.time_node, (ViewGroup) null);
                    aiVar = new ai(this);
                    aiVar.b = (TextView) view4.findViewById(R.id.time_text);
                    aiVar.a = (ImageView) view4.findViewById(R.id.time_icon);
                    if (af == 1) {
                        aiVar.a.setBackgroundResource(R.drawable.icon_time_node_1);
                    }
                    view4.setTag(aiVar);
                    ahVar = null;
                } else if (itemViewType == 1) {
                    view4 = from.inflate(R.layout.my_post_node, (ViewGroup) null);
                    ah ahVar2 = new ah(this);
                    ahVar2.a = (LinearLayout) view4.findViewById(R.id.post_info);
                    ahVar2.c = (TextView) view4.findViewById(R.id.title);
                    ahVar2.d = (TextView) view4.findViewById(R.id.post_time);
                    ahVar2.e = (TextView) view4.findViewById(R.id.forum);
                    ahVar2.b = (ImageView) view4.findViewById(R.id.post_icon);
                    if (af == 1) {
                        ahVar2.a.setBackgroundResource(R.drawable.time_line_node_content_bg_skin_1);
                    }
                    view4.setTag(ahVar2);
                    ahVar = ahVar2;
                    aiVar = null;
                } else {
                    if (itemViewType == 2) {
                        view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                        ag agVar2 = new ag(this);
                        agVar2.a = (TextView) view4.findViewById(R.id.page_text);
                        agVar2.b = (ProgressBar) view4.findViewById(R.id.progress);
                        if (af == 1) {
                            agVar2.a.setTextColor(-3618616);
                        }
                        view4.setTag(agVar2);
                        this.c.add(agVar2.b);
                        ahVar = null;
                        aiVar = null;
                        agVar = agVar2;
                    }
                    ahVar = null;
                    aiVar = null;
                    view4 = view;
                }
            } else if (itemViewType == 0) {
                ahVar = null;
                aiVar = (ai) view.getTag();
                view4 = view;
            } else if (itemViewType == 1) {
                ahVar = (ah) view.getTag();
                aiVar = null;
                view4 = view;
            } else {
                if (itemViewType == 2) {
                    ahVar = null;
                    aiVar = null;
                    view4 = view;
                    agVar = (ag) view.getTag();
                }
                ahVar = null;
                aiVar = null;
                view4 = view;
            }
            com.baidu.tieba.b.k kVar = (com.baidu.tieba.b.k) getItem(i);
            if (itemViewType == 0) {
                aiVar.b.setText(String.valueOf(kVar.b()) + this.a.getString(R.string.month));
                return view4;
            } else if (itemViewType == 1) {
                ahVar.d.setText(kVar.e());
                ahVar.e.setText(String.valueOf(kVar.f()) + this.a.getString(R.string.forum));
                ahVar.e.setOnClickListener(new ae(this, kVar));
                if (kVar.a() == 2) {
                    if (af == 1) {
                        ahVar.b.setBackgroundResource(R.drawable.icon_thread_node_1);
                    }
                    string = this.a.getString(R.string.add_thread);
                } else {
                    if (af == 1) {
                        ahVar.b.setBackgroundResource(R.drawable.icon_reply_node_1);
                    }
                    string = this.a.getString(R.string.add_reply);
                }
                int parseInt = Integer.parseInt(kVar.d());
                if (parseInt <= 0) {
                    ahVar.c.setText(String.valueOf(string) + kVar.c());
                    if (af == 1) {
                        ahVar.c.setTextColor(-3618616);
                    } else {
                        ahVar.c.setTextColor(-14277082);
                    }
                    ahVar.c.setTextSize(2, 15.0f);
                } else {
                    String d = kVar.d();
                    if (parseInt > 999) {
                        d = "999+";
                    }
                    SpannableString spannableString = new SpannableString(String.valueOf(string) + kVar.c() + "  " + this.a.getString(R.string.reply_prefix) + d + this.a.getString(R.string.reply_suffix));
                    spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.c.ah.a(this.a, 15.0f)), 0, string.length() + kVar.c().length(), 18);
                    if (af == 1) {
                        spannableString.setSpan(new ForegroundColorSpan(-3618616), 0, string.length() + kVar.c().length(), 18);
                    } else {
                        spannableString.setSpan(new ForegroundColorSpan(-14277082), 0, string.length() + kVar.c().length(), 18);
                    }
                    ahVar.c.setText(spannableString);
                }
                ahVar.a.setOnClickListener(new af(this, kVar));
                return view4;
            } else if (itemViewType == 2) {
                if (this.b.d()) {
                    agVar.a.setText(R.string.load_more);
                } else {
                    agVar.a.setText(R.string.no_more_to_load);
                }
                if (((AllPostActivity) this.a).k()) {
                    agVar.b.setVisibility(0);
                    return view4;
                }
                agVar.b.setVisibility(8);
                return view4;
            } else {
                return view4;
            }
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            com.baidu.tieba.c.af.b(getClass().getName(), "", "MyPostListAdapter.getView error = " + exc.getMessage());
            return view2;
        }
    }

    public void a() {
        if (this.c != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.c.size()) {
                    try {
                        ((ProgressBar) this.c.get(i2)).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.c.af.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.c.clear();
                    return;
                }
            }
        }
    }
}
