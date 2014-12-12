package com.baidu.tieba.myCollection;

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
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class i extends BaseAdapter {
    private EditMarkActivity bwL;
    private boolean bwQ;
    private boolean bwR;
    private int mSize;
    private final ArrayList<MarkData> mData = new ArrayList<>();
    private boolean alV = false;
    private ArrayList<ProgressBar> bwS = null;
    private View.OnClickListener bwT = null;
    private boolean bwU = false;
    private boolean hasMore = true;
    private boolean bwV = true;

    public i(EditMarkActivity editMarkActivity) {
        this.bwL = editMarkActivity;
        dE(true);
        Wc();
    }

    public void TK() {
        if (this.bwS != null) {
            Iterator<ProgressBar> it = this.bwS.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void Wc() {
        this.bwQ = false;
        if (this.mData == null) {
            this.mSize = 0;
        } else {
            int size = this.mData.size();
            if (size == 0) {
                if (this.bwR) {
                    this.mSize = 0;
                    this.bwQ = true;
                } else {
                    this.mSize = 0;
                }
            } else {
                this.mSize = size;
            }
        }
        notifyDataSetChanged();
    }

    public void dC(boolean z) {
        this.bwU = z;
    }

    public void r(ArrayList<MarkData> arrayList) {
        this.mData.clear();
        if (arrayList != null) {
            this.mData.addAll(arrayList);
        }
        Wc();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData.size() == 0) {
            return this.mSize;
        }
        if (this.bwV) {
            return this.mSize + 1;
        }
        return this.mSize;
    }

    public void dD(boolean z) {
        this.bwV = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.bwQ) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.bwQ && (size = this.mData.size()) > 0 && i < size) {
            return this.mData.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.mData == null || i < this.mData.size()) {
            return i;
        }
        return -1L;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0239: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:63:0x0238 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        k kVar;
        View view4;
        j jVar = null;
        try {
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            if (getItemViewType(i) == 0) {
                if (view == null || !(view.getTag() instanceof k)) {
                    view4 = com.baidu.adp.lib.g.b.ek().inflate(this.bwL.getPageContext().getPageActivity(), x.home_mark_item, null);
                    kVar = new k(this, null);
                    kVar.aBt = (TextView) view4.findViewById(w.home_lv_markitem_reply);
                    kVar.aNb = (LinearLayout) view4.findViewById(w.home_lv_markitem_content);
                    kVar.mTitle = (TextView) view4.findViewById(w.home_lv_markitem_title);
                    kVar.bxb = (Button) view4.findViewById(w.home_lv_markitem_delete);
                    kVar.bwY = (ImageView) view4.findViewById(w.mark_comment_icon);
                    kVar.bwZ = (ImageView) view4.findViewById(w.new_mark_mention_fack);
                    kVar.bxa = (LinearLayout) view4.findViewById(w.new_mark);
                    kVar.aPs = (TextView) view4.findViewById(w.home_lv_markitem_forum_name);
                    view4.setTag(kVar);
                } else {
                    kVar = (k) view.getTag();
                    view4 = view;
                }
            } else if (getItemViewType(i) != 1) {
                kVar = null;
                view4 = view;
            } else if (view == null || !(view.getTag() instanceof j)) {
                j jVar2 = new j(this, null);
                view4 = com.baidu.adp.lib.g.b.ek().inflate(this.bwL.getPageContext().getPageActivity(), x.page_item, null);
                jVar2.bwW = (TextView) view4.findViewById(w.page_text);
                jVar2.mProgress = (ProgressBar) view4.findViewById(w.progress);
                if (this.bwS == null) {
                    this.bwS = new ArrayList<>();
                }
                this.bwS.add(jVar2.mProgress);
                view4.setTag(jVar2);
                kVar = null;
                jVar = jVar2;
            } else {
                kVar = null;
                view4 = view;
                jVar = (j) view.getTag();
            }
            this.bwL.getLayoutMode().ab(TbadkApplication.getInst().getSkinType() == 1);
            this.bwL.getLayoutMode().h(view4);
            if (getItemViewType(i) == 1) {
                if (this.bwU) {
                    jVar.mProgress.setVisibility(0);
                    jVar.bwW.setText(this.bwL.getPageContext().getString(z.loading));
                    ax.b(jVar.bwW, t.pb_more_txt, 1);
                    view2 = view4;
                } else if (!this.hasMore) {
                    jVar.mProgress.setVisibility(8);
                    jVar.bwW.setText(this.bwL.getPageContext().getString(z.no_more_mark));
                    ax.b(jVar.bwW, t.pb_list_morebutton_nomore_text, 1);
                    view2 = view4;
                } else {
                    jVar.mProgress.setVisibility(8);
                    jVar.bwW.setText(this.bwL.getPageContext().getString(z.loading));
                    ax.b(jVar.bwW, t.pb_more_txt, 1);
                    view2 = view4;
                }
            } else {
                if (this.bwQ) {
                    kVar.aBt.setVisibility(8);
                    kVar.aNb.setVisibility(8);
                    kVar.bxb.setVisibility(8);
                    a(kVar, false);
                } else {
                    kVar.aBt.setVisibility(0);
                    kVar.aNb.setVisibility(0);
                    if (this.alV) {
                        kVar.bxb.setVisibility(0);
                    } else {
                        kVar.bxb.setVisibility(8);
                    }
                }
                Object item = getItem(i);
                if (item != null) {
                    MarkData markData = (MarkData) item;
                    if (markData.getNewCounts() > 0) {
                        a(kVar, true);
                    } else {
                        a(kVar, false);
                    }
                    int replyNum = markData.getReplyNum();
                    if (replyNum < 0) {
                        kVar.aBt.setVisibility(8);
                        kVar.bwY.setVisibility(8);
                    } else {
                        kVar.bwY.setVisibility(0);
                        kVar.aBt.setVisibility(0);
                        kVar.aBt.setText(String.valueOf(replyNum));
                    }
                    String title = markData.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        kVar.mTitle.setText(title);
                    } else {
                        kVar.mTitle.setText("");
                    }
                    if (!TextUtils.isEmpty(markData.getForumName())) {
                        kVar.aPs.setText(String.valueOf(markData.getForumName()) + this.bwL.getPageContext().getString(z.bar));
                    } else {
                        kVar.aPs.setText("");
                    }
                    kVar.bxb.setOnClickListener(this.bwT);
                    kVar.bxb.setFocusable(false);
                    kVar.bxb.setTag(Integer.valueOf(i));
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
        if (this.bwQ || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void dE(boolean z) {
        this.bwR = z;
    }

    public void setEditState(boolean z) {
        this.alV = z;
    }

    public boolean Ay() {
        return this.alV;
    }

    public void x(View.OnClickListener onClickListener) {
        this.bwT = onClickListener;
    }

    private void a(k kVar, boolean z) {
        if (kVar != null && kVar.bxa != null && kVar.bwZ != null) {
            if (z) {
                kVar.bxa.setVisibility(0);
                kVar.bwZ.setVisibility(4);
                return;
            }
            kVar.bxa.setVisibility(8);
            kVar.bwZ.setVisibility(8);
        }
    }
}
