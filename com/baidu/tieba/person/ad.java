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
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ad extends BaseAdapter {
    Context a;
    com.baidu.tieba.c.ar b;
    private ArrayList c = new ArrayList();

    public ad(Context context, com.baidu.tieba.c.ar arVar) {
        this.a = null;
        this.b = null;
        this.a = context;
        this.b = arVar;
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
            if (((com.baidu.tieba.c.as) getItem(i)).a() == 0) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x01dd: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:55:0x01dc */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        int itemViewType;
        int ar;
        View view3;
        ah ahVar;
        ai aiVar;
        View view4;
        String string;
        ag agVar = null;
        try {
            itemViewType = getItemViewType(i);
            ar = TiebaApplication.d().ar();
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
                    if (ar == 1) {
                        aiVar.a.setBackgroundResource(R.drawable.icon_time_node_1);
                        aiVar.b.setTextColor(-11446171);
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
                    if (ar == 1) {
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
                        if (ar == 1) {
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
            com.baidu.tieba.c.as asVar = (com.baidu.tieba.c.as) getItem(i);
            if (itemViewType == 0) {
                aiVar.b.setText(String.valueOf(asVar.b()) + this.a.getString(R.string.month));
                return view4;
            } else if (itemViewType == 1) {
                ahVar.d.setText(asVar.e());
                ahVar.e.setText(String.valueOf(asVar.f()) + this.a.getString(R.string.forum));
                ahVar.e.setOnClickListener(new ae(this, asVar));
                if (asVar.a() == 2) {
                    if (ar == 1) {
                        ahVar.b.setBackgroundResource(R.drawable.icon_thread_node_1);
                    } else {
                        ahVar.b.setBackgroundResource(R.drawable.icon_thread_node);
                    }
                    string = this.a.getString(R.string.add_thread);
                } else {
                    if (ar == 1) {
                        ahVar.b.setBackgroundResource(R.drawable.icon_reply_node_1);
                    } else {
                        ahVar.b.setBackgroundResource(R.drawable.icon_reply_node);
                    }
                    string = this.a.getString(R.string.add_reply);
                }
                int parseInt = Integer.parseInt(asVar.d());
                if (parseInt <= 0) {
                    ahVar.c.setText(String.valueOf(string) + asVar.c());
                    ahVar.c.setTextSize(2, 15.0f);
                    if (ar == 1) {
                        ahVar.c.setTextColor(-8682095);
                    } else {
                        ahVar.c.setTextColor(-14277082);
                    }
                } else {
                    String d = asVar.d();
                    if (parseInt > 999) {
                        d = "999+";
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(string);
                    sb.append(asVar.c());
                    int length = sb.toString().length();
                    sb.append("  ");
                    sb.append(this.a.getString(R.string.reply_prefix));
                    sb.append(d);
                    sb.append(this.a.getString(R.string.reply_suffix));
                    int length2 = sb.toString().length();
                    SpannableString spannableString = new SpannableString(sb.toString());
                    spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.d.ag.a(this.a, 15.0f)), 0, length, 18);
                    spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.d.ag.a(this.a, 12.0f)), length + 1, length2, 18);
                    if (ar == 1) {
                        spannableString.setSpan(new ForegroundColorSpan(-8682095), 0, length, 18);
                        spannableString.setSpan(new ForegroundColorSpan(-11446171), length + 1, length2, 18);
                    } else {
                        spannableString.setSpan(new ForegroundColorSpan(-14277082), 0, length, 18);
                        spannableString.setSpan(new ForegroundColorSpan(-6710887), length + 1, length2, 18);
                    }
                    ahVar.c.setText(spannableString);
                }
                ahVar.a.setOnClickListener(new af(this, asVar));
                return view4;
            } else if (itemViewType == 2) {
                if (this.b.d()) {
                    agVar.a.setText(R.string.load_more);
                } else {
                    agVar.a.setText(R.string.no_more_to_load);
                }
                if (((AllPostActivity) this.a).d()) {
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
            com.baidu.tieba.d.ae.b(getClass().getName(), "", "MyPostListAdapter.getView error = " + exc.getMessage());
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
                        com.baidu.tieba.d.ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
