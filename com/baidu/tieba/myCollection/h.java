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
    private EditMarkActivity bGX;
    private boolean bHd;
    private boolean bHe;
    private int mSize;
    private final ArrayList<MarkData> Sk = new ArrayList<>();
    private boolean awn = false;
    private ArrayList<ProgressBar> bHf = null;
    private View.OnClickListener bHg = null;
    private boolean bHh = false;
    private boolean hasMore = true;
    private boolean bHi = true;

    public h(EditMarkActivity editMarkActivity) {
        this.bGX = editMarkActivity;
        dJ(true);
        ZH();
    }

    public void ZG() {
        if (this.bHf != null) {
            Iterator<ProgressBar> it = this.bHf.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void ZH() {
        this.bHd = false;
        if (this.Sk == null) {
            this.mSize = 0;
        } else {
            int size = this.Sk.size();
            if (size == 0) {
                if (this.bHe) {
                    this.mSize = 0;
                    this.bHd = true;
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
        this.bHh = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.Sk.clear();
        if (arrayList != null) {
            this.Sk.addAll(arrayList);
        }
        ZH();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Sk.size() == 0) {
            return this.mSize;
        }
        if (this.bHi) {
            return this.mSize + 1;
        }
        return this.mSize;
    }

    public void dI(boolean z) {
        this.bHi = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.bHd) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.bHd && (size = this.Sk.size()) > 0 && i < size) {
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
                    view4 = com.baidu.adp.lib.g.b.hr().inflate(this.bGX.getPageContext().getPageActivity(), r.home_mark_item, null);
                    jVar = new j(this, null);
                    jVar.aKE = (TextView) view4.findViewById(q.home_lv_markitem_reply);
                    jVar.bzn = (LinearLayout) view4.findViewById(q.home_lv_markitem_content);
                    jVar.mTitle = (TextView) view4.findViewById(q.home_lv_markitem_title);
                    jVar.bHo = (Button) view4.findViewById(q.home_lv_markitem_delete);
                    jVar.bHl = (ImageView) view4.findViewById(q.mark_comment_icon);
                    jVar.bHm = (ImageView) view4.findViewById(q.new_mark_mention_fack);
                    jVar.bHn = (LinearLayout) view4.findViewById(q.new_mark);
                    jVar.aGI = (TextView) view4.findViewById(q.home_lv_markitem_forum_name);
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
                view4 = com.baidu.adp.lib.g.b.hr().inflate(this.bGX.getPageContext().getPageActivity(), r.page_item, null);
                iVar2.bHj = (TextView) view4.findViewById(q.page_text);
                iVar2.mProgress = (ProgressBar) view4.findViewById(q.progress);
                if (this.bHf == null) {
                    this.bHf = new ArrayList<>();
                }
                this.bHf.add(iVar2.mProgress);
                view4.setTag(iVar2);
                jVar = null;
                iVar = iVar2;
            } else {
                jVar = null;
                view4 = view;
                iVar = (i) view.getTag();
            }
            this.bGX.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.bGX.getLayoutMode().j(view4);
            if (getItemViewType(i) == 1) {
                if (this.bHh) {
                    iVar.mProgress.setVisibility(0);
                    iVar.bHj.setText(this.bGX.getPageContext().getString(t.loading));
                    ay.b(iVar.bHj, n.pb_more_txt, 1);
                    view2 = view4;
                } else if (!this.hasMore) {
                    iVar.mProgress.setVisibility(8);
                    iVar.bHj.setText(this.bGX.getPageContext().getString(t.no_more_mark));
                    ay.b(iVar.bHj, n.pb_list_morebutton_nomore_text, 1);
                    view2 = view4;
                } else {
                    iVar.mProgress.setVisibility(8);
                    iVar.bHj.setText(this.bGX.getPageContext().getString(t.loading));
                    ay.b(iVar.bHj, n.pb_more_txt, 1);
                    view2 = view4;
                }
            } else {
                if (this.bHd) {
                    jVar.aKE.setVisibility(8);
                    jVar.bzn.setVisibility(8);
                    jVar.bHo.setVisibility(8);
                    a(jVar, false);
                } else {
                    jVar.aKE.setVisibility(0);
                    jVar.bzn.setVisibility(0);
                    if (this.awn) {
                        jVar.bHo.setVisibility(0);
                    } else {
                        jVar.bHo.setVisibility(8);
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
                        jVar.aKE.setVisibility(8);
                        jVar.bHl.setVisibility(8);
                    } else {
                        jVar.bHl.setVisibility(0);
                        jVar.aKE.setVisibility(0);
                        jVar.aKE.setText(String.valueOf(replyNum));
                    }
                    String title = markData.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        jVar.mTitle.setText(title);
                    } else {
                        jVar.mTitle.setText("");
                    }
                    if (!TextUtils.isEmpty(markData.getForumName())) {
                        jVar.aGI.setText(String.valueOf(markData.getForumName()) + this.bGX.getPageContext().getString(t.bar));
                    } else {
                        jVar.aGI.setText("");
                    }
                    jVar.bHo.setOnClickListener(this.bHg);
                    jVar.bHo.setFocusable(false);
                    jVar.bHo.setTag(Integer.valueOf(i));
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
        if (this.bHd || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void dJ(boolean z) {
        this.bHe = z;
    }

    public void setEditState(boolean z) {
        this.awn = z;
    }

    public boolean Fc() {
        return this.awn;
    }

    public void r(View.OnClickListener onClickListener) {
        this.bHg = onClickListener;
    }

    private void a(j jVar, boolean z) {
        if (jVar != null && jVar.bHn != null && jVar.bHm != null) {
            if (z) {
                jVar.bHn.setVisibility(0);
                jVar.bHm.setVisibility(4);
                return;
            }
            jVar.bHn.setVisibility(8);
            jVar.bHm.setVisibility(8);
        }
    }
}
