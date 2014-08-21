package com.baidu.tieba.person;

import android.text.TextUtils;
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

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        this.a.runOnUiThread(new k(this));
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
        m mVar;
        View view4;
        l lVar = null;
        try {
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            if (getItemViewType(i) == 0) {
                if (view == null || !(view.getTag() instanceof m)) {
                    view4 = com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.home_mark_item, null);
                    mVar = new m(this, null);
                    mVar.b = (TextView) view4.findViewById(com.baidu.tieba.u.home_lv_markitem_reply);
                    mVar.c = (LinearLayout) view4.findViewById(com.baidu.tieba.u.home_lv_markitem_content);
                    mVar.d = (TextView) view4.findViewById(com.baidu.tieba.u.home_lv_markitem_title);
                    mVar.h = (Button) view4.findViewById(com.baidu.tieba.u.home_lv_markitem_delete);
                    mVar.a = (ImageView) view4.findViewById(com.baidu.tieba.u.mark_comment_icon);
                    mVar.f = (ImageView) view4.findViewById(com.baidu.tieba.u.new_mark_mention_fack);
                    mVar.g = (LinearLayout) view4.findViewById(com.baidu.tieba.u.new_mark);
                    mVar.e = (TextView) view4.findViewById(com.baidu.tieba.u.home_lv_markitem_forum_name);
                    view4.setTag(mVar);
                } else {
                    mVar = (m) view.getTag();
                    view4 = view;
                }
            } else if (getItemViewType(i) != 1) {
                mVar = null;
                view4 = view;
            } else if (view == null || !(view.getTag() instanceof l)) {
                l lVar2 = new l(this, null);
                view4 = com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.page_item, null);
                lVar2.a = (TextView) view4.findViewById(com.baidu.tieba.u.page_text);
                lVar2.b = (ProgressBar) view4.findViewById(com.baidu.tieba.u.progress);
                if (this.g == null) {
                    this.g = new ArrayList<>();
                }
                this.g.add(lVar2.b);
                view4.setTag(lVar2);
                mVar = null;
                lVar = lVar2;
            } else {
                mVar = null;
                view4 = view;
                lVar = (l) view.getTag();
            }
            int skinType = TbadkApplication.m252getInst().getSkinType();
            this.a.getLayoutMode().a(skinType == 1);
            this.a.getLayoutMode().a(view4);
            if (getItemViewType(i) == 1) {
                if (this.i) {
                    lVar.b.setVisibility(0);
                    lVar.a.setText(this.a.getString(com.baidu.tieba.x.loading));
                    if (skinType == 1) {
                        lVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.pb_more_txt_1));
                        view2 = view4;
                    } else {
                        lVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.pb_more_txt));
                        view2 = view4;
                    }
                } else if (!this.j) {
                    lVar.b.setVisibility(8);
                    lVar.a.setText(this.a.getString(com.baidu.tieba.x.no_more_mark));
                    if (skinType == 1) {
                        lVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.pb_list_morebutton_nomore_text_1));
                        view2 = view4;
                    } else {
                        lVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.pb_list_morebutton_nomore_text));
                        view2 = view4;
                    }
                } else {
                    lVar.b.setVisibility(8);
                    lVar.a.setText(this.a.getString(com.baidu.tieba.x.loading));
                    if (skinType == 1) {
                        lVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.pb_more_txt_1));
                        view2 = view4;
                    } else {
                        lVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.pb_more_txt));
                        view2 = view4;
                    }
                }
            } else {
                if (this.d) {
                    mVar.b.setVisibility(8);
                    mVar.c.setVisibility(8);
                    mVar.h.setVisibility(8);
                    a(mVar, false);
                } else {
                    mVar.b.setVisibility(0);
                    mVar.c.setVisibility(0);
                    if (this.f) {
                        mVar.h.setVisibility(0);
                    } else {
                        mVar.h.setVisibility(8);
                    }
                }
                Object item = getItem(i);
                if (item != null) {
                    MarkData markData = (MarkData) item;
                    if (markData.getNewCounts() > 0) {
                        a(mVar, true);
                    } else {
                        a(mVar, false);
                    }
                    int replyNum = markData.getReplyNum();
                    if (replyNum < 0) {
                        mVar.b.setVisibility(8);
                        mVar.a.setVisibility(8);
                    } else {
                        mVar.a.setVisibility(0);
                        mVar.b.setVisibility(0);
                        mVar.b.setText(String.valueOf(replyNum));
                    }
                    String title = markData.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        mVar.d.setText(title);
                    } else {
                        mVar.d.setText("");
                    }
                    if (!TextUtils.isEmpty(markData.getForumName())) {
                        mVar.e.setText(String.valueOf(markData.getForumName()) + this.a.getString(com.baidu.tieba.x.bar));
                    } else {
                        mVar.e.setText("");
                    }
                    mVar.h.setOnClickListener(this.h);
                    mVar.h.setFocusable(false);
                    mVar.h.setTag(Integer.valueOf(i));
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

    private void a(m mVar, boolean z) {
        if (mVar != null && mVar.g != null && mVar.f != null) {
            if (z) {
                mVar.g.setVisibility(0);
                mVar.f.setVisibility(4);
                return;
            }
            mVar.g.setVisibility(8);
            mVar.f.setVisibility(8);
        }
    }
}
