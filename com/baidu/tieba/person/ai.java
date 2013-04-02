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
public class ai extends BaseAdapter {
    Context a;
    com.baidu.tieba.b.l b;
    private ArrayList c = new ArrayList();

    public ai(Context context, com.baidu.tieba.b.l lVar) {
        this.a = null;
        this.b = null;
        this.a = context;
        this.b = lVar;
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
            if (((com.baidu.tieba.b.m) getItem(i)).a() == 0) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x01d5: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:56:0x01d4 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        am amVar;
        an anVar;
        View view4;
        String string;
        al alVar = null;
        try {
            int itemViewType = getItemViewType(i);
            int ah = TiebaApplication.b().ah();
            try {
                if (view == null) {
                    LayoutInflater from = LayoutInflater.from(this.a);
                    if (itemViewType == 0) {
                        view4 = from.inflate(R.layout.time_node, (ViewGroup) null);
                        anVar = new an(this);
                        anVar.b = (TextView) view4.findViewById(R.id.time_text);
                        anVar.a = (ImageView) view4.findViewById(R.id.time_icon);
                        if (ah == 1) {
                            anVar.a.setBackgroundResource(R.drawable.icon_time_node_1);
                        }
                        view4.setTag(anVar);
                        amVar = null;
                    } else if (itemViewType == 1) {
                        view4 = from.inflate(R.layout.my_post_node, (ViewGroup) null);
                        am amVar2 = new am(this);
                        amVar2.a = (LinearLayout) view4.findViewById(R.id.post_info);
                        amVar2.c = (TextView) view4.findViewById(R.id.title);
                        amVar2.d = (TextView) view4.findViewById(R.id.post_time);
                        amVar2.e = (TextView) view4.findViewById(R.id.forum);
                        amVar2.b = (ImageView) view4.findViewById(R.id.post_icon);
                        if (ah == 1) {
                            amVar2.a.setBackgroundResource(R.drawable.time_line_node_content_bg_skin_1);
                        }
                        view4.setTag(amVar2);
                        amVar = amVar2;
                        anVar = null;
                    } else {
                        if (itemViewType == 2) {
                            view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                            al alVar2 = new al(this);
                            alVar2.a = (TextView) view4.findViewById(R.id.page_text);
                            alVar2.b = (ProgressBar) view4.findViewById(R.id.progress);
                            if (ah == 1) {
                                alVar2.a.setTextColor(-3618616);
                            }
                            view4.setTag(alVar2);
                            this.c.add(alVar2.b);
                            amVar = null;
                            anVar = null;
                            alVar = alVar2;
                        }
                        amVar = null;
                        anVar = null;
                        view4 = view;
                    }
                } else if (itemViewType == 0) {
                    amVar = null;
                    anVar = (an) view.getTag();
                    view4 = view;
                } else if (itemViewType == 1) {
                    amVar = (am) view.getTag();
                    anVar = null;
                    view4 = view;
                } else {
                    if (itemViewType == 2) {
                        amVar = null;
                        anVar = null;
                        view4 = view;
                        alVar = (al) view.getTag();
                    }
                    amVar = null;
                    anVar = null;
                    view4 = view;
                }
                com.baidu.tieba.b.m mVar = (com.baidu.tieba.b.m) getItem(i);
                if (itemViewType == 0) {
                    anVar.b.setText(String.valueOf(mVar.b()) + this.a.getString(R.string.month));
                    return view4;
                } else if (itemViewType == 1) {
                    amVar.d.setText(mVar.e());
                    amVar.e.setText(String.valueOf(mVar.f()) + this.a.getString(R.string.forum));
                    amVar.e.setOnClickListener(new aj(this, mVar));
                    if (mVar.a() == 2) {
                        if (ah == 1) {
                            amVar.b.setBackgroundResource(R.drawable.icon_thread_node_1);
                        } else {
                            amVar.b.setBackgroundResource(R.drawable.icon_thread_node);
                        }
                        string = this.a.getString(R.string.add_thread);
                    } else {
                        if (ah == 1) {
                            amVar.b.setBackgroundResource(R.drawable.icon_reply_node_1);
                        } else {
                            amVar.b.setBackgroundResource(R.drawable.icon_reply_node);
                        }
                        string = this.a.getString(R.string.add_reply);
                    }
                    int parseInt = Integer.parseInt(mVar.d());
                    if (parseInt <= 0) {
                        amVar.c.setText(String.valueOf(string) + mVar.c());
                        if (ah == 1) {
                            amVar.c.setTextColor(-3618616);
                        } else {
                            amVar.c.setTextColor(-14277082);
                        }
                        amVar.c.setTextSize(2, 15.0f);
                    } else {
                        String d = mVar.d();
                        if (parseInt > 999) {
                            d = "999+";
                        }
                        SpannableString spannableString = new SpannableString(String.valueOf(string) + mVar.c() + "  " + this.a.getString(R.string.reply_prefix) + d + this.a.getString(R.string.reply_suffix));
                        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.c.ai.a(this.a, 15.0f)), 0, string.length() + mVar.c().length(), 18);
                        if (ah == 1) {
                            spannableString.setSpan(new ForegroundColorSpan(-3618616), 0, string.length() + mVar.c().length(), 18);
                        } else {
                            spannableString.setSpan(new ForegroundColorSpan(-14277082), 0, string.length() + mVar.c().length(), 18);
                        }
                        amVar.c.setText(spannableString);
                    }
                    amVar.a.setOnClickListener(new ak(this, mVar));
                    return view4;
                } else if (itemViewType == 2) {
                    if (this.b.d()) {
                        alVar.a.setText(R.string.load_more);
                    } else {
                        alVar.a.setText(R.string.no_more_to_load);
                    }
                    if (((AllPostActivity) this.a).k()) {
                        alVar.b.setVisibility(0);
                        return view4;
                    }
                    alVar.b.setVisibility(8);
                    return view4;
                } else {
                    return view4;
                }
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                com.baidu.tieba.c.ag.b(getClass().getName(), "", "MyPostListAdapter.getView error = " + exc.getMessage());
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
                        ((ProgressBar) this.c.get(i2)).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.c.ag.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
