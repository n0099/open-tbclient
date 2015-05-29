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
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.n;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private EditMarkActivity bGW;
    private boolean bHc;
    private boolean bHd;
    private int mSize;
    private final ArrayList<MarkData> Sk = new ArrayList<>();
    private boolean awm = false;
    private ArrayList<ProgressBar> bHe = null;
    private View.OnClickListener bHf = null;
    private boolean bHg = false;
    private boolean hasMore = true;
    private boolean bHh = true;

    public h(EditMarkActivity editMarkActivity) {
        this.bGW = editMarkActivity;
        dJ(true);
        ZG();
    }

    public void ZF() {
        if (this.bHe != null) {
            Iterator<ProgressBar> it = this.bHe.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void ZG() {
        this.bHc = false;
        if (this.Sk == null) {
            this.mSize = 0;
        } else {
            int size = this.Sk.size();
            if (size == 0) {
                if (this.bHd) {
                    this.mSize = 0;
                    this.bHc = true;
                } else {
                    this.mSize = 0;
                }
            } else {
                this.mSize = size;
            }
        }
        notifyDataSetChanged();
    }

    public void dH(boolean z) {
        this.bHg = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.Sk.clear();
        if (arrayList != null) {
            this.Sk.addAll(arrayList);
        }
        ZG();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Sk.size() == 0) {
            return this.mSize;
        }
        if (this.bHh) {
            return this.mSize + 1;
        }
        return this.mSize;
    }

    public void dI(boolean z) {
        this.bHh = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.bHc) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.bHc && (size = this.Sk.size()) > 0 && i < size) {
            return this.Sk.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Sk == null || i < this.Sk.size()) {
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
        j jVar;
        View view4;
        i iVar = null;
        try {
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            if (getItemViewType(i) == 0) {
                if (view == null || !(view.getTag() instanceof j)) {
                    view4 = com.baidu.adp.lib.g.b.hr().inflate(this.bGW.getPageContext().getPageActivity(), r.home_mark_item, null);
                    jVar = new j(this, null);
                    jVar.aKD = (TextView) view4.findViewById(q.home_lv_markitem_reply);
                    jVar.bzm = (LinearLayout) view4.findViewById(q.home_lv_markitem_content);
                    jVar.mTitle = (TextView) view4.findViewById(q.home_lv_markitem_title);
                    jVar.bHn = (Button) view4.findViewById(q.home_lv_markitem_delete);
                    jVar.bHk = (ImageView) view4.findViewById(q.mark_comment_icon);
                    jVar.bHl = (ImageView) view4.findViewById(q.new_mark_mention_fack);
                    jVar.bHm = (LinearLayout) view4.findViewById(q.new_mark);
                    jVar.aGH = (TextView) view4.findViewById(q.home_lv_markitem_forum_name);
                    view4.setTag(jVar);
                } else {
                    jVar = (j) view.getTag();
                    view4 = view;
                }
            } else if (getItemViewType(i) != 1) {
                jVar = null;
                view4 = view;
            } else if (view == null || !(view.getTag() instanceof i)) {
                i iVar2 = new i(this, null);
                view4 = com.baidu.adp.lib.g.b.hr().inflate(this.bGW.getPageContext().getPageActivity(), r.page_item, null);
                iVar2.bHi = (TextView) view4.findViewById(q.page_text);
                iVar2.mProgress = (ProgressBar) view4.findViewById(q.progress);
                if (this.bHe == null) {
                    this.bHe = new ArrayList<>();
                }
                this.bHe.add(iVar2.mProgress);
                view4.setTag(iVar2);
                jVar = null;
                iVar = iVar2;
            } else {
                jVar = null;
                view4 = view;
                iVar = (i) view.getTag();
            }
            this.bGW.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.bGW.getLayoutMode().j(view4);
            if (getItemViewType(i) == 1) {
                if (this.bHg) {
                    iVar.mProgress.setVisibility(0);
                    iVar.bHi.setText(this.bGW.getPageContext().getString(t.loading));
                    ay.b(iVar.bHi, n.pb_more_txt, 1);
                    view2 = view4;
                } else if (!this.hasMore) {
                    iVar.mProgress.setVisibility(8);
                    iVar.bHi.setText(this.bGW.getPageContext().getString(t.no_more_mark));
                    ay.b(iVar.bHi, n.pb_list_morebutton_nomore_text, 1);
                    view2 = view4;
                } else {
                    iVar.mProgress.setVisibility(8);
                    iVar.bHi.setText(this.bGW.getPageContext().getString(t.loading));
                    ay.b(iVar.bHi, n.pb_more_txt, 1);
                    view2 = view4;
                }
            } else {
                if (this.bHc) {
                    jVar.aKD.setVisibility(8);
                    jVar.bzm.setVisibility(8);
                    jVar.bHn.setVisibility(8);
                    a(jVar, false);
                } else {
                    jVar.aKD.setVisibility(0);
                    jVar.bzm.setVisibility(0);
                    if (this.awm) {
                        jVar.bHn.setVisibility(0);
                    } else {
                        jVar.bHn.setVisibility(8);
                    }
                }
                Object item = getItem(i);
                if (item != null) {
                    MarkData markData = (MarkData) item;
                    if (markData.getNewCounts() > 0) {
                        a(jVar, true);
                    } else {
                        a(jVar, false);
                    }
                    int replyNum = markData.getReplyNum();
                    if (replyNum < 0) {
                        jVar.aKD.setVisibility(8);
                        jVar.bHk.setVisibility(8);
                    } else {
                        jVar.bHk.setVisibility(0);
                        jVar.aKD.setVisibility(0);
                        jVar.aKD.setText(String.valueOf(replyNum));
                    }
                    String title = markData.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        jVar.mTitle.setText(title);
                    } else {
                        jVar.mTitle.setText("");
                    }
                    if (!TextUtils.isEmpty(markData.getForumName())) {
                        jVar.aGH.setText(String.valueOf(markData.getForumName()) + this.bGW.getPageContext().getString(t.bar));
                    } else {
                        jVar.aGH.setText("");
                    }
                    jVar.bHn.setOnClickListener(this.bHf);
                    jVar.bHn.setFocusable(false);
                    jVar.bHn.setTag(Integer.valueOf(i));
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
        if (this.bHc || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void dJ(boolean z) {
        this.bHd = z;
    }

    public void setEditState(boolean z) {
        this.awm = z;
    }

    public boolean Fb() {
        return this.awm;
    }

    public void r(View.OnClickListener onClickListener) {
        this.bHf = onClickListener;
    }

    private void a(j jVar, boolean z) {
        if (jVar != null && jVar.bHm != null && jVar.bHl != null) {
            if (z) {
                jVar.bHm.setVisibility(0);
                jVar.bHl.setVisibility(4);
                return;
            }
            jVar.bHm.setVisibility(8);
            jVar.bHl.setVisibility(8);
        }
    }
}
