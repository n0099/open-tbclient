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
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ae extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    Context f1600a;
    com.baidu.tieba.model.az b;
    private ArrayList c = new ArrayList();

    public ae(Context context, com.baidu.tieba.model.az azVar) {
        this.f1600a = null;
        this.b = null;
        this.f1600a = context;
        this.b = azVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null || this.b.d().size() == 0) {
            return 0;
        }
        return this.b.d().size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null || i < 0 || i >= this.b.d().size()) {
            return null;
        }
        return this.b.d().get(i);
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
            if (((com.baidu.tieba.model.ba) getItem(i)).a() == 0) {
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
        int an;
        View view3;
        ai aiVar;
        aj ajVar;
        View view4;
        String string;
        ah ahVar = null;
        try {
            itemViewType = getItemViewType(i);
            an = TiebaApplication.g().an();
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.f1600a);
                if (itemViewType == 0) {
                    view4 = from.inflate(R.layout.time_node, (ViewGroup) null);
                    ajVar = new aj(this);
                    ajVar.b = (TextView) view4.findViewById(R.id.time_text);
                    ajVar.f1605a = (ImageView) view4.findViewById(R.id.time_icon);
                    if (an == 1) {
                        ajVar.f1605a.setBackgroundResource(R.drawable.icon_time_node_1);
                        ajVar.b.setTextColor(-11446171);
                    }
                    view4.setTag(ajVar);
                    aiVar = null;
                } else if (itemViewType == 1) {
                    view4 = from.inflate(R.layout.my_post_node, (ViewGroup) null);
                    ai aiVar2 = new ai(this);
                    aiVar2.f1604a = (LinearLayout) view4.findViewById(R.id.post_info);
                    aiVar2.c = (TextView) view4.findViewById(R.id.title);
                    aiVar2.d = (TextView) view4.findViewById(R.id.post_time);
                    aiVar2.e = (TextView) view4.findViewById(R.id.forum);
                    aiVar2.b = (ImageView) view4.findViewById(R.id.post_icon);
                    if (an == 1) {
                        aiVar2.f1604a.setBackgroundResource(R.drawable.time_line_node_content_bg_skin_1);
                    }
                    view4.setTag(aiVar2);
                    aiVar = aiVar2;
                    ajVar = null;
                } else {
                    if (itemViewType == 2) {
                        view4 = from.inflate(R.layout.post_list_page_item, (ViewGroup) null);
                        ah ahVar2 = new ah(this);
                        ahVar2.f1603a = (TextView) view4.findViewById(R.id.page_text);
                        ahVar2.b = (ProgressBar) view4.findViewById(R.id.progress);
                        if (an == 1) {
                            ahVar2.f1603a.setTextColor(-8682095);
                        }
                        view4.setTag(ahVar2);
                        this.c.add(ahVar2.b);
                        aiVar = null;
                        ajVar = null;
                        ahVar = ahVar2;
                    }
                    aiVar = null;
                    ajVar = null;
                    view4 = view;
                }
            } else if (itemViewType == 0) {
                aiVar = null;
                ajVar = (aj) view.getTag();
                view4 = view;
            } else if (itemViewType == 1) {
                aiVar = (ai) view.getTag();
                ajVar = null;
                view4 = view;
            } else {
                if (itemViewType == 2) {
                    aiVar = null;
                    ajVar = null;
                    view4 = view;
                    ahVar = (ah) view.getTag();
                }
                aiVar = null;
                ajVar = null;
                view4 = view;
            }
            com.baidu.tieba.model.ba baVar = (com.baidu.tieba.model.ba) getItem(i);
            if (itemViewType == 0) {
                ajVar.b.setText(String.valueOf(baVar.b()) + this.f1600a.getString(R.string.month));
                return view4;
            } else if (itemViewType == 1) {
                aiVar.d.setText(baVar.e());
                aiVar.e.setText(String.valueOf(baVar.f()) + this.f1600a.getString(R.string.forum));
                aiVar.e.setOnClickListener(new af(this, baVar));
                if (baVar.a() == 2) {
                    if (an == 1) {
                        aiVar.b.setBackgroundResource(R.drawable.icon_thread_node_1);
                    } else {
                        aiVar.b.setBackgroundResource(R.drawable.icon_thread_node);
                    }
                    string = this.f1600a.getString(R.string.add_thread);
                } else {
                    if (an == 1) {
                        aiVar.b.setBackgroundResource(R.drawable.icon_reply_node_1);
                    } else {
                        aiVar.b.setBackgroundResource(R.drawable.icon_reply_node);
                    }
                    string = this.f1600a.getString(R.string.add_reply);
                }
                int parseInt = Integer.parseInt(baVar.d());
                if (parseInt <= 0) {
                    aiVar.c.setText(String.valueOf(string) + baVar.c());
                    aiVar.c.setTextSize(2, 15.0f);
                    if (an == 1) {
                        aiVar.c.setTextColor(-8682095);
                    } else {
                        aiVar.c.setTextColor(-14277082);
                    }
                } else {
                    String d = baVar.d();
                    if (parseInt > 999) {
                        d = "999+";
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(string);
                    sb.append(baVar.c());
                    int length = sb.toString().length();
                    sb.append("  ");
                    sb.append(this.f1600a.getString(R.string.reply_prefix));
                    sb.append(d);
                    sb.append(this.f1600a.getString(R.string.reply_suffix));
                    int length2 = sb.toString().length();
                    SpannableString spannableString = new SpannableString(sb.toString());
                    spannableString.setSpan(new AbsoluteSizeSpan(UtilHelper.a(this.f1600a, 15.0f)), 0, length, 18);
                    spannableString.setSpan(new AbsoluteSizeSpan(UtilHelper.a(this.f1600a, 12.0f)), length + 1, length2, 18);
                    if (an == 1) {
                        spannableString.setSpan(new ForegroundColorSpan(-8682095), 0, length, 18);
                        spannableString.setSpan(new ForegroundColorSpan(-11446171), length + 1, length2, 18);
                    } else {
                        spannableString.setSpan(new ForegroundColorSpan(-14277082), 0, length, 18);
                        spannableString.setSpan(new ForegroundColorSpan(-6710887), length + 1, length2, 18);
                    }
                    aiVar.c.setText(spannableString);
                }
                aiVar.f1604a.setOnClickListener(new ag(this, baVar));
                return view4;
            } else if (itemViewType == 2) {
                if (this.b.g()) {
                    ahVar.f1603a.setText(R.string.load_more);
                } else {
                    ahVar.f1603a.setText(R.string.no_more_to_load);
                }
                if (((AllPostActivity) this.f1600a).c()) {
                    ahVar.b.setVisibility(0);
                    return view4;
                }
                ahVar.b.setVisibility(8);
                return view4;
            } else {
                return view4;
            }
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            com.baidu.tieba.util.aq.b(getClass().getName(), "", "MyPostListAdapter.getView error = " + exc.getMessage());
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
                        com.baidu.tieba.util.aq.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
