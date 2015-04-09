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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private EditMarkActivity bEb;
    private boolean bEh;
    private boolean bEi;
    private int mSize;
    private final ArrayList<MarkData> auK = new ArrayList<>();
    private boolean auJ = false;
    private ArrayList<ProgressBar> bEj = null;
    private View.OnClickListener bEk = null;
    private boolean bEl = false;
    private boolean hasMore = true;
    private boolean bEm = true;

    public h(EditMarkActivity editMarkActivity) {
        this.bEb = editMarkActivity;
        dx(true);
        Yg();
    }

    public void WU() {
        if (this.bEj != null) {
            Iterator<ProgressBar> it = this.bEj.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void Yg() {
        this.bEh = false;
        if (this.auK == null) {
            this.mSize = 0;
        } else {
            int size = this.auK.size();
            if (size == 0) {
                if (this.bEi) {
                    this.mSize = 0;
                    this.bEh = true;
                } else {
                    this.mSize = 0;
                }
            } else {
                this.mSize = size;
            }
        }
        notifyDataSetChanged();
    }

    public void setRefreshing(boolean z) {
        this.bEl = z;
    }

    public void p(ArrayList<MarkData> arrayList) {
        this.auK.clear();
        if (arrayList != null) {
            this.auK.addAll(arrayList);
        }
        Yg();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auK.size() == 0) {
            return this.mSize;
        }
        if (this.bEm) {
            return this.mSize + 1;
        }
        return this.mSize;
    }

    public void dw(boolean z) {
        this.bEm = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.bEh) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.bEh && (size = this.auK.size()) > 0 && i < size) {
            return this.auK.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.auK == null || i < this.auK.size()) {
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
                    view4 = com.baidu.adp.lib.g.b.hH().inflate(this.bEb.getPageContext().getPageActivity(), w.home_mark_item, null);
                    jVar = new j(this, null);
                    jVar.aIv = (TextView) view4.findViewById(v.home_lv_markitem_reply);
                    jVar.bwE = (LinearLayout) view4.findViewById(v.home_lv_markitem_content);
                    jVar.mTitle = (TextView) view4.findViewById(v.home_lv_markitem_title);
                    jVar.bEs = (Button) view4.findViewById(v.home_lv_markitem_delete);
                    jVar.bEp = (ImageView) view4.findViewById(v.mark_comment_icon);
                    jVar.bEq = (ImageView) view4.findViewById(v.new_mark_mention_fack);
                    jVar.bEr = (LinearLayout) view4.findViewById(v.new_mark);
                    jVar.aED = (TextView) view4.findViewById(v.home_lv_markitem_forum_name);
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
                view4 = com.baidu.adp.lib.g.b.hH().inflate(this.bEb.getPageContext().getPageActivity(), w.page_item, null);
                iVar2.bEn = (TextView) view4.findViewById(v.page_text);
                iVar2.mProgress = (ProgressBar) view4.findViewById(v.progress);
                if (this.bEj == null) {
                    this.bEj = new ArrayList<>();
                }
                this.bEj.add(iVar2.mProgress);
                view4.setTag(iVar2);
                jVar = null;
                iVar = iVar2;
            } else {
                jVar = null;
                view4 = view;
                iVar = (i) view.getTag();
            }
            this.bEb.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.bEb.getLayoutMode().h(view4);
            if (getItemViewType(i) == 1) {
                if (this.bEl) {
                    iVar.mProgress.setVisibility(0);
                    iVar.bEn.setText(this.bEb.getPageContext().getString(y.loading));
                    ba.b(iVar.bEn, s.pb_more_txt, 1);
                    view2 = view4;
                } else if (!this.hasMore) {
                    iVar.mProgress.setVisibility(8);
                    iVar.bEn.setText(this.bEb.getPageContext().getString(y.no_more_mark));
                    ba.b(iVar.bEn, s.pb_list_morebutton_nomore_text, 1);
                    view2 = view4;
                } else {
                    iVar.mProgress.setVisibility(8);
                    iVar.bEn.setText(this.bEb.getPageContext().getString(y.loading));
                    ba.b(iVar.bEn, s.pb_more_txt, 1);
                    view2 = view4;
                }
            } else {
                if (this.bEh) {
                    jVar.aIv.setVisibility(8);
                    jVar.bwE.setVisibility(8);
                    jVar.bEs.setVisibility(8);
                    a(jVar, false);
                } else {
                    jVar.aIv.setVisibility(0);
                    jVar.bwE.setVisibility(0);
                    if (this.auJ) {
                        jVar.bEs.setVisibility(0);
                    } else {
                        jVar.bEs.setVisibility(8);
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
                        jVar.aIv.setVisibility(8);
                        jVar.bEp.setVisibility(8);
                    } else {
                        jVar.bEp.setVisibility(0);
                        jVar.aIv.setVisibility(0);
                        jVar.aIv.setText(String.valueOf(replyNum));
                    }
                    String title = markData.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        jVar.mTitle.setText(title);
                    } else {
                        jVar.mTitle.setText("");
                    }
                    if (!TextUtils.isEmpty(markData.getForumName())) {
                        jVar.aED.setText(String.valueOf(markData.getForumName()) + this.bEb.getPageContext().getString(y.bar));
                    } else {
                        jVar.aED.setText("");
                    }
                    jVar.bEs.setOnClickListener(this.bEk);
                    jVar.bEs.setFocusable(false);
                    jVar.bEs.setTag(Integer.valueOf(i));
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
        if (this.bEh || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void dx(boolean z) {
        this.bEi = z;
    }

    public void setEditState(boolean z) {
        this.auJ = z;
    }

    public boolean Eo() {
        return this.auJ;
    }

    public void s(View.OnClickListener onClickListener) {
        this.bEk = onClickListener;
    }

    private void a(j jVar, boolean z) {
        if (jVar != null && jVar.bEr != null && jVar.bEq != null) {
            if (z) {
                jVar.bEr.setVisibility(0);
                jVar.bEq.setVisibility(4);
                return;
            }
            jVar.bEr.setVisibility(8);
            jVar.bEq.setVisibility(8);
        }
    }
}
