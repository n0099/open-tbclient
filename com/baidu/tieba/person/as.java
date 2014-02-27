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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class as extends BaseAdapter {
    Context a;
    com.baidu.tieba.model.az b;
    private ArrayList<ProgressBar> c = new ArrayList<>();

    public as(Context context, com.baidu.tieba.model.az azVar) {
        this.a = null;
        this.b = null;
        this.a = context;
        this.b = azVar;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.b == null || this.b.d().size() == 0) {
            return 0;
        }
        return this.b.d().size() + 1;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.b == null || i < 0 || i >= this.b.d().size()) {
            return null;
        }
        return this.b.d().get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return this.b == null ? 0 : 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
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
    public final View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        int itemViewType;
        int ae;
        View view3;
        aw awVar;
        ax axVar;
        View view4;
        String string;
        av avVar = null;
        try {
            itemViewType = getItemViewType(i);
            ae = TiebaApplication.g().ae();
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.a);
                if (itemViewType == 0) {
                    view4 = from.inflate(R.layout.time_node, (ViewGroup) null);
                    axVar = new ax(this);
                    axVar.b = (TextView) view4.findViewById(R.id.time_text);
                    axVar.a = (ImageView) view4.findViewById(R.id.time_icon);
                    if (ae == 1) {
                        axVar.a.setBackgroundResource(R.drawable.icon_time_node_1);
                        axVar.b.setTextColor(-11446171);
                    }
                    view4.setTag(axVar);
                    awVar = null;
                } else if (itemViewType == 1) {
                    view4 = from.inflate(R.layout.my_post_node, (ViewGroup) null);
                    aw awVar2 = new aw(this);
                    awVar2.a = (LinearLayout) view4.findViewById(R.id.post_info);
                    awVar2.c = (TextView) view4.findViewById(R.id.title);
                    awVar2.d = (TextView) view4.findViewById(R.id.post_time);
                    awVar2.e = (TextView) view4.findViewById(R.id.forum);
                    awVar2.b = (ImageView) view4.findViewById(R.id.post_icon);
                    if (ae == 1) {
                        awVar2.a.setBackgroundResource(R.drawable.time_line_node_content_bg_skin_1);
                    }
                    view4.setTag(awVar2);
                    awVar = awVar2;
                    axVar = null;
                } else {
                    if (itemViewType == 2) {
                        view4 = from.inflate(R.layout.post_list_page_item, (ViewGroup) null);
                        av avVar2 = new av(this);
                        avVar2.a = (TextView) view4.findViewById(R.id.page_text);
                        avVar2.b = (ProgressBar) view4.findViewById(R.id.progress);
                        if (ae == 1) {
                            avVar2.a.setTextColor(-8682095);
                        }
                        view4.setTag(avVar2);
                        this.c.add(avVar2.b);
                        awVar = null;
                        axVar = null;
                        avVar = avVar2;
                    }
                    awVar = null;
                    axVar = null;
                    view4 = view;
                }
            } else if (itemViewType == 0) {
                awVar = null;
                axVar = (ax) view.getTag();
                view4 = view;
            } else if (itemViewType == 1) {
                awVar = (aw) view.getTag();
                axVar = null;
                view4 = view;
            } else {
                if (itemViewType == 2) {
                    awVar = null;
                    axVar = null;
                    view4 = view;
                    avVar = (av) view.getTag();
                }
                awVar = null;
                axVar = null;
                view4 = view;
            }
            com.baidu.tieba.model.ba baVar = (com.baidu.tieba.model.ba) getItem(i);
            if (itemViewType == 0) {
                axVar.b.setText(String.valueOf(baVar.b()) + this.a.getString(R.string.month));
                return view4;
            } else if (itemViewType == 1) {
                awVar.d.setText(baVar.e());
                awVar.e.setText(String.valueOf(baVar.f()) + this.a.getString(R.string.forum));
                awVar.e.setOnClickListener(new at(this, baVar));
                if (baVar.a() == 2) {
                    if (ae == 1) {
                        awVar.b.setBackgroundResource(R.drawable.icon_thread_node_1);
                    } else {
                        awVar.b.setBackgroundResource(R.drawable.icon_thread_node);
                    }
                    string = this.a.getString(R.string.add_thread);
                } else {
                    if (ae == 1) {
                        awVar.b.setBackgroundResource(R.drawable.icon_reply_node_1);
                    } else {
                        awVar.b.setBackgroundResource(R.drawable.icon_reply_node);
                    }
                    string = this.a.getString(R.string.add_reply);
                }
                int parseInt = Integer.parseInt(baVar.d());
                if (parseInt <= 0) {
                    awVar.c.setText(String.valueOf(string) + baVar.c());
                    awVar.c.setTextSize(2, 15.0f);
                    if (ae == 1) {
                        awVar.c.setTextColor(-8682095);
                    } else {
                        awVar.c.setTextColor(-14277082);
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
                    sb.append(this.a.getString(R.string.reply_prefix));
                    sb.append(d);
                    sb.append(this.a.getString(R.string.reply_suffix));
                    int length2 = sb.toString().length();
                    SpannableString spannableString = new SpannableString(sb.toString());
                    spannableString.setSpan(new AbsoluteSizeSpan(BdUtilHelper.a(this.a, 15.0f)), 0, length, 18);
                    spannableString.setSpan(new AbsoluteSizeSpan(BdUtilHelper.a(this.a, 12.0f)), length + 1, length2, 18);
                    if (ae == 1) {
                        spannableString.setSpan(new ForegroundColorSpan(-8682095), 0, length, 18);
                        spannableString.setSpan(new ForegroundColorSpan(-11446171), length + 1, length2, 18);
                    } else {
                        spannableString.setSpan(new ForegroundColorSpan(-14277082), 0, length, 18);
                        spannableString.setSpan(new ForegroundColorSpan(-6710887), length + 1, length2, 18);
                    }
                    awVar.c.setText(spannableString);
                }
                awVar.a.setOnClickListener(new au(this, baVar));
                return view4;
            } else if (itemViewType == 2) {
                if (this.b.g()) {
                    avVar.a.setText(R.string.load_more);
                } else {
                    avVar.a.setText(R.string.no_more_to_load);
                }
                if (((AllPostActivity) this.a).a()) {
                    avVar.b.setVisibility(0);
                    return view4;
                }
                avVar.b.setVisibility(8);
                return view4;
            } else {
                return view4;
            }
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            com.baidu.adp.lib.util.e.b(getClass().getName(), "", "MyPostListAdapter.getView error = " + exc.getMessage());
            return view2;
        }
    }

    public final void a() {
        if (this.c != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.c.size()) {
                    try {
                        this.c.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.adp.lib.util.e.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
