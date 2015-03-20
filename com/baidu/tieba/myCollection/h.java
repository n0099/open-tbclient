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
    private EditMarkActivity bDO;
    private boolean bDU;
    private boolean bDV;
    private int mSize;
    private final ArrayList<MarkData> auC = new ArrayList<>();
    private boolean auB = false;
    private ArrayList<ProgressBar> bDW = null;
    private View.OnClickListener bDX = null;
    private boolean bDY = false;
    private boolean hasMore = true;
    private boolean bDZ = true;

    public h(EditMarkActivity editMarkActivity) {
        this.bDO = editMarkActivity;
        dz(true);
        XU();
    }

    public void WK() {
        if (this.bDW != null) {
            Iterator<ProgressBar> it = this.bDW.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void XU() {
        this.bDU = false;
        if (this.auC == null) {
            this.mSize = 0;
        } else {
            int size = this.auC.size();
            if (size == 0) {
                if (this.bDV) {
                    this.mSize = 0;
                    this.bDU = true;
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
        this.bDY = z;
    }

    public void p(ArrayList<MarkData> arrayList) {
        this.auC.clear();
        if (arrayList != null) {
            this.auC.addAll(arrayList);
        }
        XU();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auC.size() == 0) {
            return this.mSize;
        }
        if (this.bDZ) {
            return this.mSize + 1;
        }
        return this.mSize;
    }

    public void dy(boolean z) {
        this.bDZ = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.bDU) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.bDU && (size = this.auC.size()) > 0 && i < size) {
            return this.auC.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.auC == null || i < this.auC.size()) {
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
                    view4 = com.baidu.adp.lib.g.b.hH().inflate(this.bDO.getPageContext().getPageActivity(), w.home_mark_item, null);
                    jVar = new j(this, null);
                    jVar.aIn = (TextView) view4.findViewById(v.home_lv_markitem_reply);
                    jVar.bwo = (LinearLayout) view4.findViewById(v.home_lv_markitem_content);
                    jVar.mTitle = (TextView) view4.findViewById(v.home_lv_markitem_title);
                    jVar.bEf = (Button) view4.findViewById(v.home_lv_markitem_delete);
                    jVar.bEc = (ImageView) view4.findViewById(v.mark_comment_icon);
                    jVar.bEd = (ImageView) view4.findViewById(v.new_mark_mention_fack);
                    jVar.bEe = (LinearLayout) view4.findViewById(v.new_mark);
                    jVar.aEv = (TextView) view4.findViewById(v.home_lv_markitem_forum_name);
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
                view4 = com.baidu.adp.lib.g.b.hH().inflate(this.bDO.getPageContext().getPageActivity(), w.page_item, null);
                iVar2.bEa = (TextView) view4.findViewById(v.page_text);
                iVar2.mProgress = (ProgressBar) view4.findViewById(v.progress);
                if (this.bDW == null) {
                    this.bDW = new ArrayList<>();
                }
                this.bDW.add(iVar2.mProgress);
                view4.setTag(iVar2);
                jVar = null;
                iVar = iVar2;
            } else {
                jVar = null;
                view4 = view;
                iVar = (i) view.getTag();
            }
            this.bDO.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.bDO.getLayoutMode().h(view4);
            if (getItemViewType(i) == 1) {
                if (this.bDY) {
                    iVar.mProgress.setVisibility(0);
                    iVar.bEa.setText(this.bDO.getPageContext().getString(y.loading));
                    ba.b(iVar.bEa, s.pb_more_txt, 1);
                    view2 = view4;
                } else if (!this.hasMore) {
                    iVar.mProgress.setVisibility(8);
                    iVar.bEa.setText(this.bDO.getPageContext().getString(y.no_more_mark));
                    ba.b(iVar.bEa, s.pb_list_morebutton_nomore_text, 1);
                    view2 = view4;
                } else {
                    iVar.mProgress.setVisibility(8);
                    iVar.bEa.setText(this.bDO.getPageContext().getString(y.loading));
                    ba.b(iVar.bEa, s.pb_more_txt, 1);
                    view2 = view4;
                }
            } else {
                if (this.bDU) {
                    jVar.aIn.setVisibility(8);
                    jVar.bwo.setVisibility(8);
                    jVar.bEf.setVisibility(8);
                    a(jVar, false);
                } else {
                    jVar.aIn.setVisibility(0);
                    jVar.bwo.setVisibility(0);
                    if (this.auB) {
                        jVar.bEf.setVisibility(0);
                    } else {
                        jVar.bEf.setVisibility(8);
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
                        jVar.aIn.setVisibility(8);
                        jVar.bEc.setVisibility(8);
                    } else {
                        jVar.bEc.setVisibility(0);
                        jVar.aIn.setVisibility(0);
                        jVar.aIn.setText(String.valueOf(replyNum));
                    }
                    String title = markData.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        jVar.mTitle.setText(title);
                    } else {
                        jVar.mTitle.setText("");
                    }
                    if (!TextUtils.isEmpty(markData.getForumName())) {
                        jVar.aEv.setText(String.valueOf(markData.getForumName()) + this.bDO.getPageContext().getString(y.bar));
                    } else {
                        jVar.aEv.setText("");
                    }
                    jVar.bEf.setOnClickListener(this.bDX);
                    jVar.bEf.setFocusable(false);
                    jVar.bEf.setTag(Integer.valueOf(i));
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
        if (this.bDU || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void dz(boolean z) {
        this.bDV = z;
    }

    public void setEditState(boolean z) {
        this.auB = z;
    }

    public boolean Ei() {
        return this.auB;
    }

    public void r(View.OnClickListener onClickListener) {
        this.bDX = onClickListener;
    }

    private void a(j jVar, boolean z) {
        if (jVar != null && jVar.bEe != null && jVar.bEd != null) {
            if (z) {
                jVar.bEe.setVisibility(0);
                jVar.bEd.setVisibility(4);
                return;
            }
            jVar.bEe.setVisibility(8);
            jVar.bEd.setVisibility(8);
        }
    }
}
