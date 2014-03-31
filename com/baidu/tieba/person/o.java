package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class o extends BaseAdapter {
    private EditMarkActivity a;
    private ArrayList<MarkData> b;
    private int c;
    private boolean d;
    private boolean f = false;
    private ArrayList<ProgressBar> g = null;
    private View.OnClickListener h = null;
    private boolean i = false;
    private boolean j = true;
    private boolean k = true;
    private boolean e = true;

    public o(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
        b();
    }

    public final void a() {
        if (this.g != null) {
            Iterator<ProgressBar> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public final void a(boolean z) {
        this.j = z;
    }

    public final void b() {
        this.d = false;
        if (this.b == null) {
            this.c = 0;
        } else {
            int size = this.b.size();
            if (size == 0) {
                if (this.e) {
                    this.c = 0;
                    this.d = true;
                } else {
                    this.c = 0;
                }
            } else {
                this.c = size;
            }
        }
        notifyDataSetChanged();
    }

    public final void b(boolean z) {
        this.i = z;
    }

    public final void a(ArrayList<MarkData> arrayList) {
        this.b = arrayList;
        b();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.b == null || this.b.size() == 0) {
            return this.c;
        }
        if (this.k) {
            return this.c + 1;
        }
        return this.c;
    }

    public final void c(boolean z) {
        this.k = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.d) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        int size;
        if (!this.d && (size = this.b.size()) > 0 && i < size) {
            return this.b.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        if (this.b == null || i < this.b.size()) {
            return i;
        }
        return -1L;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0275: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:72:0x0274 */
    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        q qVar;
        View view4;
        p pVar = null;
        try {
            try {
                if (getItemViewType(i) == 0) {
                    if (view == null || !(view.getTag() instanceof q)) {
                        view4 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.home_mark_item, (ViewGroup) null);
                        qVar = new q(this, (byte) 0);
                        qVar.b = (TextView) view4.findViewById(com.baidu.tieba.a.h.home_lv_markitem_reply);
                        qVar.c = (LinearLayout) view4.findViewById(com.baidu.tieba.a.h.home_lv_markitem_content);
                        qVar.d = (TextView) view4.findViewById(com.baidu.tieba.a.h.home_lv_markitem_title);
                        qVar.h = (Button) view4.findViewById(com.baidu.tieba.a.h.home_lv_markitem_delete);
                        qVar.a = (ImageView) view4.findViewById(com.baidu.tieba.a.h.mark_comment_icon);
                        qVar.f = (ImageView) view4.findViewById(com.baidu.tieba.a.h.new_mark_mention_fack);
                        qVar.g = (LinearLayout) view4.findViewById(com.baidu.tieba.a.h.new_mark);
                        qVar.e = (TextView) view4.findViewById(com.baidu.tieba.a.h.home_lv_markitem_forum_name);
                        view4.setTag(qVar);
                    } else {
                        qVar = (q) view.getTag();
                        view4 = view;
                    }
                } else if (getItemViewType(i) != 1) {
                    qVar = null;
                    view4 = view;
                } else if (view == null || !(view.getTag() instanceof p)) {
                    LayoutInflater from = LayoutInflater.from(this.a);
                    p pVar2 = new p(this, (byte) 0);
                    view4 = from.inflate(com.baidu.tieba.a.i.page_item, (ViewGroup) null);
                    pVar2.a = (TextView) view4.findViewById(com.baidu.tieba.a.h.page_text);
                    pVar2.b = (ProgressBar) view4.findViewById(com.baidu.tieba.a.h.progress);
                    if (this.g == null) {
                        this.g = new ArrayList<>();
                    }
                    this.g.add(pVar2.b);
                    view4.setTag(pVar2);
                    qVar = null;
                    pVar = pVar2;
                } else {
                    qVar = null;
                    view4 = view;
                    pVar = (p) view.getTag();
                }
                int l = TbadkApplication.j().l();
                this.a.getLayoutMode().a(l == 1);
                this.a.getLayoutMode().a(view4);
                if (getItemViewType(i) == 1) {
                    if (this.i) {
                        pVar.b.setVisibility(0);
                        pVar.a.setText(this.a.getString(com.baidu.tieba.a.k.loading));
                        if (l == 1) {
                            pVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.pb_more_txt_1));
                            view2 = view4;
                        } else {
                            pVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.pb_more_txt));
                            view2 = view4;
                        }
                    } else if (!this.j) {
                        pVar.b.setVisibility(8);
                        pVar.a.setText(this.a.getString(com.baidu.tieba.a.k.no_more_mark));
                        if (l == 1) {
                            pVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.pb_list_morebutton_nomore_text_1));
                            view2 = view4;
                        } else {
                            pVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.pb_list_morebutton_nomore_text));
                            view2 = view4;
                        }
                    } else {
                        pVar.b.setVisibility(8);
                        pVar.a.setText(this.a.getString(com.baidu.tieba.a.k.loading));
                        if (l == 1) {
                            pVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.pb_more_txt_1));
                            view2 = view4;
                        } else {
                            pVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.pb_more_txt));
                            view2 = view4;
                        }
                    }
                } else {
                    if (this.d) {
                        qVar.b.setVisibility(8);
                        qVar.c.setVisibility(8);
                        qVar.h.setVisibility(8);
                        a(qVar, false);
                    } else {
                        qVar.b.setVisibility(0);
                        qVar.c.setVisibility(0);
                        if (this.f) {
                            qVar.h.setVisibility(0);
                        } else {
                            qVar.h.setVisibility(8);
                        }
                    }
                    Object item = getItem(i);
                    if (item != null) {
                        MarkData markData = (MarkData) item;
                        if (markData.getNewCounts() > 0) {
                            a(qVar, true);
                        } else {
                            a(qVar, false);
                        }
                        int replyNum = markData.getReplyNum();
                        if (replyNum < 0) {
                            qVar.b.setVisibility(8);
                            qVar.a.setVisibility(8);
                        } else {
                            qVar.a.setVisibility(0);
                            qVar.b.setVisibility(0);
                            qVar.b.setText(String.valueOf(replyNum));
                        }
                        String title = markData.getTitle();
                        if (!TextUtils.isEmpty(title)) {
                            qVar.d.setText(title);
                        } else {
                            qVar.d.setText("");
                        }
                        if (!TextUtils.isEmpty(markData.getForumName())) {
                            qVar.e.setText(String.valueOf(markData.getForumName()) + this.a.getString(com.baidu.tieba.a.k.bar));
                        } else {
                            qVar.e.setText("");
                        }
                        qVar.h.setOnClickListener(this.h);
                        qVar.h.setFocusable(false);
                        qVar.h.setTag(Integer.valueOf(i));
                        view2 = view4;
                    } else {
                        return view4;
                    }
                }
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "", "MarkAdapter.getView error = " + exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int i) {
        if (this.d || (!this.j && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public final void d(boolean z) {
        this.e = z;
    }

    public final void e(boolean z) {
        this.f = z;
    }

    public final boolean c() {
        return this.f;
    }

    public final void a(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    private static void a(q qVar, boolean z) {
        if (qVar != null && qVar.g != null && qVar.f != null) {
            if (z) {
                qVar.g.setVisibility(0);
                qVar.f.setVisibility(4);
                return;
            }
            qVar.g.setVisibility(8);
            qVar.f.setVisibility(8);
        }
    }
}
