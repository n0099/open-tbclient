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
public class af extends BaseAdapter {
    Context a;
    com.baidu.tieba.model.bk b;
    private ArrayList<ProgressBar> c = new ArrayList<>();

    public af(Context context, com.baidu.tieba.model.bk bkVar) {
        this.a = null;
        this.b = null;
        this.a = context;
        this.b = bkVar;
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
            if (((com.baidu.tieba.model.bl) getItem(i)).a() == 0) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        ai aiVar;
        aj ajVar;
        ak akVar;
        View view3;
        String string;
        ai aiVar2;
        ak akVar2;
        aj ajVar2 = null;
        try {
            int itemViewType = getItemViewType(i);
            int an = TiebaApplication.h().an();
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.a);
                if (itemViewType == 0) {
                    view = from.inflate(R.layout.time_node, (ViewGroup) null);
                    akVar2 = new ak(this);
                    akVar2.b = (TextView) view.findViewById(R.id.time_text);
                    akVar2.a = (ImageView) view.findViewById(R.id.time_icon);
                    if (an == 1) {
                        akVar2.a.setBackgroundResource(R.drawable.icon_time_node_1);
                        akVar2.b.setTextColor(-11446171);
                    }
                    view.setTag(akVar2);
                    aiVar2 = null;
                } else if (itemViewType == 1) {
                    view = from.inflate(R.layout.my_post_node, (ViewGroup) null);
                    aj ajVar3 = new aj(this);
                    ajVar3.a = (LinearLayout) view.findViewById(R.id.post_info);
                    ajVar3.c = (TextView) view.findViewById(R.id.title);
                    ajVar3.d = (TextView) view.findViewById(R.id.post_time);
                    ajVar3.e = (TextView) view.findViewById(R.id.forum);
                    ajVar3.b = (ImageView) view.findViewById(R.id.post_icon);
                    if (an == 1) {
                        ajVar3.a.setBackgroundResource(R.drawable.time_line_node_content_bg_skin_1);
                    }
                    view.setTag(ajVar3);
                    aiVar2 = null;
                    akVar2 = null;
                    ajVar2 = ajVar3;
                } else if (itemViewType == 2) {
                    view = from.inflate(R.layout.post_list_page_item, (ViewGroup) null);
                    ai aiVar3 = new ai(this);
                    aiVar3.a = (TextView) view.findViewById(R.id.page_text);
                    aiVar3.b = (ProgressBar) view.findViewById(R.id.progress);
                    if (an == 1) {
                        aiVar3.a.setTextColor(-8682095);
                    }
                    view.setTag(aiVar3);
                    this.c.add(aiVar3.b);
                    aiVar2 = aiVar3;
                    akVar2 = null;
                } else {
                    aiVar2 = null;
                    akVar2 = null;
                }
                ajVar = ajVar2;
                akVar = akVar2;
                aiVar = aiVar2;
                view3 = view;
            } else if (itemViewType == 0) {
                aiVar = null;
                ajVar = null;
                akVar = (ak) view.getTag();
                view3 = view;
            } else if (itemViewType == 1) {
                aiVar = null;
                ajVar = (aj) view.getTag();
                akVar = null;
                view3 = view;
            } else if (itemViewType == 2) {
                aiVar = (ai) view.getTag();
                ajVar = null;
                akVar = null;
                view3 = view;
            } else {
                aiVar = null;
                ajVar = null;
                akVar = null;
                view3 = view;
            }
            try {
                com.baidu.tieba.model.bl blVar = (com.baidu.tieba.model.bl) getItem(i);
                if (itemViewType == 0) {
                    akVar.b.setText(blVar.b() + this.a.getString(R.string.month));
                } else if (itemViewType == 1) {
                    ajVar.d.setText(blVar.e());
                    ajVar.e.setText(blVar.f() + this.a.getString(R.string.forum));
                    ajVar.e.setOnClickListener(new ag(this, blVar));
                    if (blVar.a() == 2) {
                        if (an == 1) {
                            ajVar.b.setBackgroundResource(R.drawable.icon_thread_node_1);
                        } else {
                            ajVar.b.setBackgroundResource(R.drawable.icon_thread_node);
                        }
                        string = this.a.getString(R.string.add_thread);
                    } else {
                        if (an == 1) {
                            ajVar.b.setBackgroundResource(R.drawable.icon_reply_node_1);
                        } else {
                            ajVar.b.setBackgroundResource(R.drawable.icon_reply_node);
                        }
                        string = this.a.getString(R.string.add_reply);
                    }
                    int parseInt = Integer.parseInt(blVar.d());
                    if (parseInt <= 0) {
                        ajVar.c.setText(string + blVar.c());
                        ajVar.c.setTextSize(2, 15.0f);
                        if (an == 1) {
                            ajVar.c.setTextColor(-8682095);
                        } else {
                            ajVar.c.setTextColor(-14277082);
                        }
                    } else {
                        String d = blVar.d();
                        if (parseInt > 999) {
                            d = "999+";
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(string);
                        sb.append(blVar.c());
                        int length = sb.toString().length();
                        sb.append("  ");
                        sb.append(this.a.getString(R.string.reply_prefix));
                        sb.append(d);
                        sb.append(this.a.getString(R.string.reply_suffix));
                        int length2 = sb.toString().length();
                        SpannableString spannableString = new SpannableString(sb.toString());
                        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.h.g.a(this.a, 15.0f)), 0, length, 18);
                        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.h.g.a(this.a, 12.0f)), length + 1, length2, 18);
                        if (an == 1) {
                            spannableString.setSpan(new ForegroundColorSpan(-8682095), 0, length, 18);
                            spannableString.setSpan(new ForegroundColorSpan(-11446171), length + 1, length2, 18);
                        } else {
                            spannableString.setSpan(new ForegroundColorSpan(-14277082), 0, length, 18);
                            spannableString.setSpan(new ForegroundColorSpan(-6710887), length + 1, length2, 18);
                        }
                        ajVar.c.setText(spannableString);
                    }
                    ajVar.a.setOnClickListener(new ah(this, blVar));
                } else if (itemViewType == 2) {
                    if (this.b.g()) {
                        aiVar.a.setText(R.string.load_more);
                    } else {
                        aiVar.a.setText(R.string.no_more_to_load);
                    }
                    if (((AllPostActivity) this.a).b()) {
                        aiVar.b.setVisibility(0);
                    } else {
                        aiVar.b.setVisibility(8);
                    }
                }
                return view3;
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                com.baidu.tieba.util.be.b(getClass().getName(), "", "MyPostListAdapter.getView error = " + exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    public void a() {
        if (this.c != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.c.size()) {
                    try {
                        this.c.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.util.be.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
