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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
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

    public j(EditMarkActivity editMarkActivity) {
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

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0275: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:72:0x0274 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        l lVar;
        View view4;
        k kVar = null;
        try {
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            if (getItemViewType(i) == 0) {
                if (view == null || !(view.getTag() instanceof l)) {
                    view4 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.home_mark_item, (ViewGroup) null);
                    lVar = new l(this, null);
                    lVar.b = (TextView) view4.findViewById(com.baidu.tieba.u.home_lv_markitem_reply);
                    lVar.c = (LinearLayout) view4.findViewById(com.baidu.tieba.u.home_lv_markitem_content);
                    lVar.d = (TextView) view4.findViewById(com.baidu.tieba.u.home_lv_markitem_title);
                    lVar.h = (Button) view4.findViewById(com.baidu.tieba.u.home_lv_markitem_delete);
                    lVar.a = (ImageView) view4.findViewById(com.baidu.tieba.u.mark_comment_icon);
                    lVar.f = (ImageView) view4.findViewById(com.baidu.tieba.u.new_mark_mention_fack);
                    lVar.g = (LinearLayout) view4.findViewById(com.baidu.tieba.u.new_mark);
                    lVar.e = (TextView) view4.findViewById(com.baidu.tieba.u.home_lv_markitem_forum_name);
                    view4.setTag(lVar);
                } else {
                    lVar = (l) view.getTag();
                    view4 = view;
                }
            } else if (getItemViewType(i) != 1) {
                lVar = null;
                view4 = view;
            } else if (view == null || !(view.getTag() instanceof k)) {
                LayoutInflater from = LayoutInflater.from(this.a);
                k kVar2 = new k(this, null);
                view4 = from.inflate(com.baidu.tieba.v.page_item, (ViewGroup) null);
                kVar2.a = (TextView) view4.findViewById(com.baidu.tieba.u.page_text);
                kVar2.b = (ProgressBar) view4.findViewById(com.baidu.tieba.u.progress);
                if (this.g == null) {
                    this.g = new ArrayList<>();
                }
                this.g.add(kVar2.b);
                view4.setTag(kVar2);
                lVar = null;
                kVar = kVar2;
            } else {
                lVar = null;
                view4 = view;
                kVar = (k) view.getTag();
            }
            int skinType = TbadkApplication.m252getInst().getSkinType();
            this.a.getLayoutMode().a(skinType == 1);
            this.a.getLayoutMode().a(view4);
            if (getItemViewType(i) == 1) {
                if (this.i) {
                    kVar.b.setVisibility(0);
                    kVar.a.setText(this.a.getString(com.baidu.tieba.x.loading));
                    if (skinType == 1) {
                        kVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.pb_more_txt_1));
                        view2 = view4;
                    } else {
                        kVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.pb_more_txt));
                        view2 = view4;
                    }
                } else if (!this.j) {
                    kVar.b.setVisibility(8);
                    kVar.a.setText(this.a.getString(com.baidu.tieba.x.no_more_mark));
                    if (skinType == 1) {
                        kVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.pb_list_morebutton_nomore_text_1));
                        view2 = view4;
                    } else {
                        kVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.pb_list_morebutton_nomore_text));
                        view2 = view4;
                    }
                } else {
                    kVar.b.setVisibility(8);
                    kVar.a.setText(this.a.getString(com.baidu.tieba.x.loading));
                    if (skinType == 1) {
                        kVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.pb_more_txt_1));
                        view2 = view4;
                    } else {
                        kVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.pb_more_txt));
                        view2 = view4;
                    }
                }
            } else {
                if (this.d) {
                    lVar.b.setVisibility(8);
                    lVar.c.setVisibility(8);
                    lVar.h.setVisibility(8);
                    a(lVar, false);
                } else {
                    lVar.b.setVisibility(0);
                    lVar.c.setVisibility(0);
                    if (this.f) {
                        lVar.h.setVisibility(0);
                    } else {
                        lVar.h.setVisibility(8);
                    }
                }
                Object item = getItem(i);
                if (item != null) {
                    MarkData markData = (MarkData) item;
                    if (markData.getNewCounts() > 0) {
                        a(lVar, true);
                    } else {
                        a(lVar, false);
                    }
                    int replyNum = markData.getReplyNum();
                    if (replyNum < 0) {
                        lVar.b.setVisibility(8);
                        lVar.a.setVisibility(8);
                    } else {
                        lVar.a.setVisibility(0);
                        lVar.b.setVisibility(0);
                        lVar.b.setText(String.valueOf(replyNum));
                    }
                    String title = markData.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        lVar.d.setText(title);
                    } else {
                        lVar.d.setText("");
                    }
                    if (!TextUtils.isEmpty(markData.getForumName())) {
                        lVar.e.setText(String.valueOf(markData.getForumName()) + this.a.getString(com.baidu.tieba.x.bar));
                    } else {
                        lVar.e.setText("");
                    }
                    lVar.h.setOnClickListener(this.h);
                    lVar.h.setFocusable(false);
                    lVar.h.setTag(Integer.valueOf(i));
                    view2 = view4;
                } else {
                    return view4;
                }
            }
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            BdLog.e(exc.getMessage());
            return view2;
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

    private void a(l lVar, boolean z) {
        if (lVar != null && lVar.g != null && lVar.f != null) {
            if (z) {
                lVar.g.setVisibility(0);
                lVar.f.setVisibility(4);
                return;
            }
            lVar.g.setVisibility(8);
            lVar.f.setVisibility(8);
        }
    }
}
