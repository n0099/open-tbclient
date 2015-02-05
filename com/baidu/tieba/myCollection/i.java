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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class i extends BaseAdapter {
    private EditMarkActivity byt;
    private boolean byy;
    private boolean byz;
    private int mSize;
    private final ArrayList<MarkData> amM = new ArrayList<>();
    private boolean amL = false;
    private ArrayList<ProgressBar> byA = null;
    private View.OnClickListener byB = null;
    private boolean byC = false;
    private boolean hasMore = true;
    private boolean byD = true;

    public i(EditMarkActivity editMarkActivity) {
        this.byt = editMarkActivity;
        dK(true);
        WC();
    }

    public void Ub() {
        if (this.byA != null) {
            Iterator<ProgressBar> it = this.byA.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void WC() {
        this.byy = false;
        if (this.amM == null) {
            this.mSize = 0;
        } else {
            int size = this.amM.size();
            if (size == 0) {
                if (this.byz) {
                    this.mSize = 0;
                    this.byy = true;
                } else {
                    this.mSize = 0;
                }
            } else {
                this.mSize = size;
            }
        }
        notifyDataSetChanged();
    }

    public void dI(boolean z) {
        this.byC = z;
    }

    public void s(ArrayList<MarkData> arrayList) {
        this.amM.clear();
        if (arrayList != null) {
            this.amM.addAll(arrayList);
        }
        WC();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.amM.size() == 0) {
            return this.mSize;
        }
        if (this.byD) {
            return this.mSize + 1;
        }
        return this.mSize;
    }

    public void dJ(boolean z) {
        this.byD = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.byy) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.byy && (size = this.amM.size()) > 0 && i < size) {
            return this.amM.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.amM == null || i < this.amM.size()) {
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
                    view4 = com.baidu.adp.lib.g.b.ei().inflate(this.byt.getPageContext().getPageActivity(), x.home_mark_item, null);
                    kVar = new k(this, null);
                    kVar.aCr = (TextView) view4.findViewById(w.home_lv_markitem_reply);
                    kVar.aOj = (LinearLayout) view4.findViewById(w.home_lv_markitem_content);
                    kVar.mTitle = (TextView) view4.findViewById(w.home_lv_markitem_title);
                    kVar.byJ = (Button) view4.findViewById(w.home_lv_markitem_delete);
                    kVar.byG = (ImageView) view4.findViewById(w.mark_comment_icon);
                    kVar.byH = (ImageView) view4.findViewById(w.new_mark_mention_fack);
                    kVar.byI = (LinearLayout) view4.findViewById(w.new_mark);
                    kVar.aQw = (TextView) view4.findViewById(w.home_lv_markitem_forum_name);
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
                view4 = com.baidu.adp.lib.g.b.ei().inflate(this.byt.getPageContext().getPageActivity(), x.page_item, null);
                jVar2.byE = (TextView) view4.findViewById(w.page_text);
                jVar2.mProgress = (ProgressBar) view4.findViewById(w.progress);
                if (this.byA == null) {
                    this.byA = new ArrayList<>();
                }
                this.byA.add(jVar2.mProgress);
                view4.setTag(jVar2);
                kVar = null;
                jVar = jVar2;
            } else {
                kVar = null;
                view4 = view;
                jVar = (j) view.getTag();
            }
            this.byt.getLayoutMode().ab(TbadkApplication.getInst().getSkinType() == 1);
            this.byt.getLayoutMode().h(view4);
            if (getItemViewType(i) == 1) {
                if (this.byC) {
                    jVar.mProgress.setVisibility(0);
                    jVar.byE.setText(this.byt.getPageContext().getString(z.loading));
                    bc.b(jVar.byE, t.pb_more_txt, 1);
                    view2 = view4;
                } else if (!this.hasMore) {
                    jVar.mProgress.setVisibility(8);
                    jVar.byE.setText(this.byt.getPageContext().getString(z.no_more_mark));
                    bc.b(jVar.byE, t.pb_list_morebutton_nomore_text, 1);
                    view2 = view4;
                } else {
                    jVar.mProgress.setVisibility(8);
                    jVar.byE.setText(this.byt.getPageContext().getString(z.loading));
                    bc.b(jVar.byE, t.pb_more_txt, 1);
                    view2 = view4;
                }
            } else {
                if (this.byy) {
                    kVar.aCr.setVisibility(8);
                    kVar.aOj.setVisibility(8);
                    kVar.byJ.setVisibility(8);
                    a(kVar, false);
                } else {
                    kVar.aCr.setVisibility(0);
                    kVar.aOj.setVisibility(0);
                    if (this.amL) {
                        kVar.byJ.setVisibility(0);
                    } else {
                        kVar.byJ.setVisibility(8);
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
                        kVar.aCr.setVisibility(8);
                        kVar.byG.setVisibility(8);
                    } else {
                        kVar.byG.setVisibility(0);
                        kVar.aCr.setVisibility(0);
                        kVar.aCr.setText(String.valueOf(replyNum));
                    }
                    String title = markData.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        kVar.mTitle.setText(title);
                    } else {
                        kVar.mTitle.setText("");
                    }
                    if (!TextUtils.isEmpty(markData.getForumName())) {
                        kVar.aQw.setText(String.valueOf(markData.getForumName()) + this.byt.getPageContext().getString(z.bar));
                    } else {
                        kVar.aQw.setText("");
                    }
                    kVar.byJ.setOnClickListener(this.byB);
                    kVar.byJ.setFocusable(false);
                    kVar.byJ.setTag(Integer.valueOf(i));
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
        if (this.byy || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void dK(boolean z) {
        this.byz = z;
    }

    public void setEditState(boolean z) {
        this.amL = z;
    }

    public boolean AT() {
        return this.amL;
    }

    public void y(View.OnClickListener onClickListener) {
        this.byB = onClickListener;
    }

    private void a(k kVar, boolean z) {
        if (kVar != null && kVar.byI != null && kVar.byH != null) {
            if (z) {
                kVar.byI.setVisibility(0);
                kVar.byH.setVisibility(4);
                return;
            }
            kVar.byI.setVisibility(8);
            kVar.byH.setVisibility(8);
        }
    }
}
