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
    private EditMarkActivity bAX;
    private boolean bBc;
    private boolean bBd;
    private int mSize;
    private final ArrayList<MarkData> aew = new ArrayList<>();
    private boolean aev = false;
    private ArrayList<ProgressBar> bmb = null;
    private View.OnClickListener bBe = null;
    private boolean bBf = false;
    private boolean hasMore = true;
    private boolean bBg = true;

    public j(EditMarkActivity editMarkActivity) {
        this.bAX = editMarkActivity;
        es(true);
        ZG();
    }

    public void Sy() {
        if (this.bmb != null) {
            Iterator<ProgressBar> it = this.bmb.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void ZG() {
        this.bBc = false;
        if (this.aew == null) {
            this.mSize = 0;
        } else {
            int size = this.aew.size();
            if (size == 0) {
                if (this.bBd) {
                    this.mSize = 0;
                    this.bBc = true;
                } else {
                    this.mSize = 0;
                }
            } else {
                this.mSize = size;
            }
        }
        notifyDataSetChanged();
    }

    public void eq(boolean z) {
        this.bBf = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.aew.clear();
        if (arrayList != null) {
            this.aew.addAll(arrayList);
        }
        ZG();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aew.size() == 0) {
            return this.mSize;
        }
        if (this.bBg) {
            return this.mSize + 1;
        }
        return this.mSize;
    }

    public void er(boolean z) {
        this.bBg = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.bBc) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.bBc && (size = this.aew.size()) > 0 && i < size) {
            return this.aew.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aew == null || i < this.aew.size()) {
            return i;
        }
        return -1L;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0219: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:63:0x0218 */
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
                    view4 = com.baidu.adp.lib.g.b.ek().inflate(this.bAX, com.baidu.tieba.w.home_mark_item, null);
                    lVar = new l(this, null);
                    lVar.azp = (TextView) view4.findViewById(com.baidu.tieba.v.home_lv_markitem_reply);
                    lVar.aKU = (LinearLayout) view4.findViewById(com.baidu.tieba.v.home_lv_markitem_content);
                    lVar.JM = (TextView) view4.findViewById(com.baidu.tieba.v.home_lv_markitem_title);
                    lVar.bBl = (Button) view4.findViewById(com.baidu.tieba.v.home_lv_markitem_delete);
                    lVar.bBi = (ImageView) view4.findViewById(com.baidu.tieba.v.mark_comment_icon);
                    lVar.bBj = (ImageView) view4.findViewById(com.baidu.tieba.v.new_mark_mention_fack);
                    lVar.bBk = (LinearLayout) view4.findViewById(com.baidu.tieba.v.new_mark);
                    lVar.axq = (TextView) view4.findViewById(com.baidu.tieba.v.home_lv_markitem_forum_name);
                    view4.setTag(lVar);
                } else {
                    lVar = (l) view.getTag();
                    view4 = view;
                }
            } else if (getItemViewType(i) != 1) {
                lVar = null;
                view4 = view;
            } else if (view == null || !(view.getTag() instanceof k)) {
                k kVar2 = new k(this, null);
                view4 = com.baidu.adp.lib.g.b.ek().inflate(this.bAX, com.baidu.tieba.w.page_item, null);
                kVar2.bnv = (TextView) view4.findViewById(com.baidu.tieba.v.page_text);
                kVar2.mProgress = (ProgressBar) view4.findViewById(com.baidu.tieba.v.progress);
                if (this.bmb == null) {
                    this.bmb = new ArrayList<>();
                }
                this.bmb.add(kVar2.mProgress);
                view4.setTag(kVar2);
                lVar = null;
                kVar = kVar2;
            } else {
                lVar = null;
                view4 = view;
                kVar = (k) view.getTag();
            }
            this.bAX.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
            this.bAX.getLayoutMode().h(view4);
            if (getItemViewType(i) == 1) {
                if (this.bBf) {
                    kVar.mProgress.setVisibility(0);
                    kVar.bnv.setText(this.bAX.getString(com.baidu.tieba.y.loading));
                    com.baidu.tbadk.core.util.aw.b(kVar.bnv, com.baidu.tieba.s.pb_more_txt, 1);
                    view2 = view4;
                } else if (!this.hasMore) {
                    kVar.mProgress.setVisibility(8);
                    kVar.bnv.setText(this.bAX.getString(com.baidu.tieba.y.no_more_mark));
                    com.baidu.tbadk.core.util.aw.b(kVar.bnv, com.baidu.tieba.s.pb_list_morebutton_nomore_text, 1);
                    view2 = view4;
                } else {
                    kVar.mProgress.setVisibility(8);
                    kVar.bnv.setText(this.bAX.getString(com.baidu.tieba.y.loading));
                    com.baidu.tbadk.core.util.aw.b(kVar.bnv, com.baidu.tieba.s.pb_more_txt, 1);
                    view2 = view4;
                }
            } else {
                if (this.bBc) {
                    lVar.azp.setVisibility(8);
                    lVar.aKU.setVisibility(8);
                    lVar.bBl.setVisibility(8);
                    a(lVar, false);
                } else {
                    lVar.azp.setVisibility(0);
                    lVar.aKU.setVisibility(0);
                    if (this.aev) {
                        lVar.bBl.setVisibility(0);
                    } else {
                        lVar.bBl.setVisibility(8);
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
                        lVar.azp.setVisibility(8);
                        lVar.bBi.setVisibility(8);
                    } else {
                        lVar.bBi.setVisibility(0);
                        lVar.azp.setVisibility(0);
                        lVar.azp.setText(String.valueOf(replyNum));
                    }
                    String title = markData.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        lVar.JM.setText(title);
                    } else {
                        lVar.JM.setText("");
                    }
                    if (!TextUtils.isEmpty(markData.getForumName())) {
                        lVar.axq.setText(String.valueOf(markData.getForumName()) + this.bAX.getString(com.baidu.tieba.y.bar));
                    } else {
                        lVar.axq.setText("");
                    }
                    lVar.bBl.setOnClickListener(this.bBe);
                    lVar.bBl.setFocusable(false);
                    lVar.bBl.setTag(Integer.valueOf(i));
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
        if (this.bBc || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void es(boolean z) {
        this.bBd = z;
    }

    public void setEditState(boolean z) {
        this.aev = z;
    }

    public boolean xd() {
        return this.aev;
    }

    public void w(View.OnClickListener onClickListener) {
        this.bBe = onClickListener;
    }

    private void a(l lVar, boolean z) {
        if (lVar != null && lVar.bBk != null && lVar.bBj != null) {
            if (z) {
                lVar.bBk.setVisibility(0);
                lVar.bBj.setVisibility(4);
                return;
            }
            lVar.bBk.setVisibility(8);
            lVar.bBj.setVisibility(8);
        }
    }
}
