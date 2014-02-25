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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MarkData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class af extends BaseAdapter {
    private EditMarkActivity a;
    private ArrayList<MarkData> b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f = false;
    private ArrayList<ProgressBar> g = null;
    private View.OnClickListener h = null;
    private boolean i = false;
    private boolean j = true;
    private boolean k = true;

    public af(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
        d(true);
        b();
    }

    public void a() {
        if (this.g != null) {
            Iterator<ProgressBar> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void a(boolean z) {
        this.j = z;
    }

    public void b() {
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

    public void b(boolean z) {
        this.i = z;
    }

    public void a(ArrayList<MarkData> arrayList) {
        this.b = arrayList;
        b();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null || this.b.size() == 0) {
            return this.c;
        }
        if (this.k) {
            return this.c + 1;
        }
        return this.c;
    }

    public void c(boolean z) {
        this.k = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.d) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.d && (size = this.b.size()) > 0 && i < size) {
            return this.b.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.b == null || i < this.b.size()) {
            return i;
        }
        return -1L;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x028b: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:73:0x028a */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        ah ahVar;
        View view4;
        ag agVar = null;
        try {
            try {
                if (getItemViewType(i) == 0) {
                    if (view == null || !(view.getTag() instanceof ah)) {
                        view4 = LayoutInflater.from(this.a).inflate(R.layout.home_mark_item, (ViewGroup) null);
                        ahVar = new ah(this, null);
                        ahVar.b = (TextView) view4.findViewById(R.id.home_lv_markitem_reply);
                        ahVar.c = (LinearLayout) view4.findViewById(R.id.home_lv_markitem_content);
                        ahVar.d = (TextView) view4.findViewById(R.id.home_lv_markitem_title);
                        ahVar.h = (Button) view4.findViewById(R.id.home_lv_markitem_delete);
                        ahVar.a = (ImageView) view4.findViewById(R.id.mark_comment_icon);
                        ahVar.f = (ImageView) view4.findViewById(R.id.new_mark_mention_fack);
                        ahVar.g = (LinearLayout) view4.findViewById(R.id.new_mark);
                        ahVar.e = (TextView) view4.findViewById(R.id.home_lv_markitem_forum_name);
                        view4.setTag(ahVar);
                    } else {
                        ahVar = (ah) view.getTag();
                        view4 = view;
                    }
                } else if (getItemViewType(i) != 1) {
                    ahVar = null;
                    view4 = view;
                } else if (view == null || !(view.getTag() instanceof ag)) {
                    LayoutInflater from = LayoutInflater.from(this.a);
                    ag agVar2 = new ag(this, null);
                    view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    agVar2.a = (TextView) view4.findViewById(R.id.page_text);
                    agVar2.b = (ProgressBar) view4.findViewById(R.id.progress);
                    if (this.g == null) {
                        this.g = new ArrayList<>();
                    }
                    this.g.add(agVar2.b);
                    view4.setTag(agVar2);
                    ahVar = null;
                    agVar = agVar2;
                } else {
                    ahVar = null;
                    view4 = view;
                    agVar = (ag) view.getTag();
                }
                int al = TiebaApplication.g().al();
                this.a.getLayoutMode().a(al == 1);
                this.a.getLayoutMode().a(view4);
                if (getItemViewType(i) == 1) {
                    if (this.i) {
                        agVar.b.setVisibility(0);
                        agVar.a.setText(this.a.getString(R.string.loading));
                        if (al == 1) {
                            agVar.a.setTextColor(this.a.getResources().getColor(R.color.pb_more_txt_1));
                            view2 = view4;
                        } else {
                            agVar.a.setTextColor(this.a.getResources().getColor(R.color.pb_more_txt));
                            view2 = view4;
                        }
                    } else if (!this.j) {
                        agVar.b.setVisibility(8);
                        agVar.a.setText(this.a.getString(R.string.no_more_mark));
                        if (al == 1) {
                            agVar.a.setTextColor(this.a.getResources().getColor(R.color.pb_list_morebutton_nomore_text_1));
                            view2 = view4;
                        } else {
                            agVar.a.setTextColor(this.a.getResources().getColor(R.color.pb_list_morebutton_nomore_text));
                            view2 = view4;
                        }
                    } else {
                        agVar.b.setVisibility(8);
                        agVar.a.setText(this.a.getString(R.string.loading));
                        if (al == 1) {
                            agVar.a.setTextColor(this.a.getResources().getColor(R.color.pb_more_txt_1));
                            view2 = view4;
                        } else {
                            agVar.a.setTextColor(this.a.getResources().getColor(R.color.pb_more_txt));
                            view2 = view4;
                        }
                    }
                } else {
                    if (this.d) {
                        ahVar.b.setVisibility(8);
                        ahVar.c.setVisibility(8);
                        ahVar.h.setVisibility(8);
                        a(ahVar, false);
                    } else {
                        ahVar.b.setVisibility(0);
                        ahVar.c.setVisibility(0);
                        if (this.f) {
                            ahVar.h.setVisibility(0);
                        } else {
                            ahVar.h.setVisibility(8);
                        }
                    }
                    Object item = getItem(i);
                    if (item != null) {
                        MarkData markData = (MarkData) item;
                        if (markData.getNewCounts() > 0) {
                            a(ahVar, true);
                        } else {
                            a(ahVar, false);
                        }
                        int replyNum = markData.getReplyNum();
                        if (replyNum < 0) {
                            ahVar.b.setVisibility(8);
                            ahVar.a.setVisibility(8);
                        } else {
                            ahVar.a.setVisibility(0);
                            ahVar.b.setVisibility(0);
                            ahVar.b.setText(String.valueOf(replyNum));
                        }
                        String title = markData.getTitle();
                        if (!TextUtils.isEmpty(title)) {
                            ahVar.d.setText(title);
                        } else {
                            ahVar.d.setText("");
                        }
                        if (!TextUtils.isEmpty(markData.getForumName())) {
                            ahVar.e.setText(String.valueOf(markData.getForumName()) + this.a.getString(R.string.bar));
                        } else {
                            ahVar.e.setText("");
                        }
                        ahVar.h.setOnClickListener(this.h);
                        ahVar.h.setFocusable(false);
                        ahVar.h.setTag(Integer.valueOf(i));
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
    public boolean isEnabled(int i) {
        if (this.d || (!this.j && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void d(boolean z) {
        this.e = z;
    }

    public void e(boolean z) {
        this.f = z;
    }

    public boolean c() {
        return this.f;
    }

    public void a(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    private void a(ah ahVar, boolean z) {
        if (ahVar != null && ahVar.g != null && ahVar.f != null) {
            if (z) {
                ahVar.g.setVisibility(0);
                ahVar.f.setVisibility(4);
                return;
            }
            ahVar.g.setVisibility(8);
            ahVar.f.setVisibility(8);
        }
    }
}
