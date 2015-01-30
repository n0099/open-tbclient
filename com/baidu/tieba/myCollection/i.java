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
    private boolean byA;
    private EditMarkActivity byu;
    private boolean byz;
    private int mSize;
    private final ArrayList<MarkData> amP = new ArrayList<>();
    private boolean amO = false;
    private ArrayList<ProgressBar> byB = null;
    private View.OnClickListener byC = null;
    private boolean byD = false;
    private boolean hasMore = true;
    private boolean byE = true;

    public i(EditMarkActivity editMarkActivity) {
        this.byu = editMarkActivity;
        dK(true);
        WH();
    }

    public void Ug() {
        if (this.byB != null) {
            Iterator<ProgressBar> it = this.byB.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void WH() {
        this.byz = false;
        if (this.amP == null) {
            this.mSize = 0;
        } else {
            int size = this.amP.size();
            if (size == 0) {
                if (this.byA) {
                    this.mSize = 0;
                    this.byz = true;
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
        this.byD = z;
    }

    public void s(ArrayList<MarkData> arrayList) {
        this.amP.clear();
        if (arrayList != null) {
            this.amP.addAll(arrayList);
        }
        WH();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.amP.size() == 0) {
            return this.mSize;
        }
        if (this.byE) {
            return this.mSize + 1;
        }
        return this.mSize;
    }

    public void dJ(boolean z) {
        this.byE = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.byz) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.byz && (size = this.amP.size()) > 0 && i < size) {
            return this.amP.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.amP == null || i < this.amP.size()) {
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
                    view4 = com.baidu.adp.lib.g.b.ei().inflate(this.byu.getPageContext().getPageActivity(), x.home_mark_item, null);
                    kVar = new k(this, null);
                    kVar.aCu = (TextView) view4.findViewById(w.home_lv_markitem_reply);
                    kVar.aOk = (LinearLayout) view4.findViewById(w.home_lv_markitem_content);
                    kVar.mTitle = (TextView) view4.findViewById(w.home_lv_markitem_title);
                    kVar.byK = (Button) view4.findViewById(w.home_lv_markitem_delete);
                    kVar.byH = (ImageView) view4.findViewById(w.mark_comment_icon);
                    kVar.byI = (ImageView) view4.findViewById(w.new_mark_mention_fack);
                    kVar.byJ = (LinearLayout) view4.findViewById(w.new_mark);
                    kVar.aQx = (TextView) view4.findViewById(w.home_lv_markitem_forum_name);
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
                view4 = com.baidu.adp.lib.g.b.ei().inflate(this.byu.getPageContext().getPageActivity(), x.page_item, null);
                jVar2.byF = (TextView) view4.findViewById(w.page_text);
                jVar2.mProgress = (ProgressBar) view4.findViewById(w.progress);
                if (this.byB == null) {
                    this.byB = new ArrayList<>();
                }
                this.byB.add(jVar2.mProgress);
                view4.setTag(jVar2);
                kVar = null;
                jVar = jVar2;
            } else {
                kVar = null;
                view4 = view;
                jVar = (j) view.getTag();
            }
            this.byu.getLayoutMode().ab(TbadkApplication.getInst().getSkinType() == 1);
            this.byu.getLayoutMode().h(view4);
            if (getItemViewType(i) == 1) {
                if (this.byD) {
                    jVar.mProgress.setVisibility(0);
                    jVar.byF.setText(this.byu.getPageContext().getString(z.loading));
                    bc.b(jVar.byF, t.pb_more_txt, 1);
                    view2 = view4;
                } else if (!this.hasMore) {
                    jVar.mProgress.setVisibility(8);
                    jVar.byF.setText(this.byu.getPageContext().getString(z.no_more_mark));
                    bc.b(jVar.byF, t.pb_list_morebutton_nomore_text, 1);
                    view2 = view4;
                } else {
                    jVar.mProgress.setVisibility(8);
                    jVar.byF.setText(this.byu.getPageContext().getString(z.loading));
                    bc.b(jVar.byF, t.pb_more_txt, 1);
                    view2 = view4;
                }
            } else {
                if (this.byz) {
                    kVar.aCu.setVisibility(8);
                    kVar.aOk.setVisibility(8);
                    kVar.byK.setVisibility(8);
                    a(kVar, false);
                } else {
                    kVar.aCu.setVisibility(0);
                    kVar.aOk.setVisibility(0);
                    if (this.amO) {
                        kVar.byK.setVisibility(0);
                    } else {
                        kVar.byK.setVisibility(8);
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
                        kVar.aCu.setVisibility(8);
                        kVar.byH.setVisibility(8);
                    } else {
                        kVar.byH.setVisibility(0);
                        kVar.aCu.setVisibility(0);
                        kVar.aCu.setText(String.valueOf(replyNum));
                    }
                    String title = markData.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        kVar.mTitle.setText(title);
                    } else {
                        kVar.mTitle.setText("");
                    }
                    if (!TextUtils.isEmpty(markData.getForumName())) {
                        kVar.aQx.setText(String.valueOf(markData.getForumName()) + this.byu.getPageContext().getString(z.bar));
                    } else {
                        kVar.aQx.setText("");
                    }
                    kVar.byK.setOnClickListener(this.byC);
                    kVar.byK.setFocusable(false);
                    kVar.byK.setTag(Integer.valueOf(i));
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
        if (this.byz || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void dK(boolean z) {
        this.byA = z;
    }

    public void setEditState(boolean z) {
        this.amO = z;
    }

    public boolean AZ() {
        return this.amO;
    }

    public void y(View.OnClickListener onClickListener) {
        this.byC = onClickListener;
    }

    private void a(k kVar, boolean z) {
        if (kVar != null && kVar.byJ != null && kVar.byI != null) {
            if (z) {
                kVar.byJ.setVisibility(0);
                kVar.byI.setVisibility(4);
                return;
            }
            kVar.byJ.setVisibility(8);
            kVar.byI.setVisibility(8);
        }
    }
}
