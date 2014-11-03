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
    private EditMarkActivity bBl;
    private boolean bBq;
    private boolean bBr;
    private int mSize;
    private final ArrayList<MarkData> aeE = new ArrayList<>();
    private boolean aeD = false;
    private ArrayList<ProgressBar> bmp = null;
    private View.OnClickListener bBs = null;
    private boolean bBt = false;
    private boolean hasMore = true;
    private boolean bBu = true;

    public j(EditMarkActivity editMarkActivity) {
        this.bBl = editMarkActivity;
        es(true);
        ZI();
    }

    public void SB() {
        if (this.bmp != null) {
            Iterator<ProgressBar> it = this.bmp.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void ZI() {
        this.bBq = false;
        if (this.aeE == null) {
            this.mSize = 0;
        } else {
            int size = this.aeE.size();
            if (size == 0) {
                if (this.bBr) {
                    this.mSize = 0;
                    this.bBq = true;
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
        this.bBt = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.aeE.clear();
        if (arrayList != null) {
            this.aeE.addAll(arrayList);
        }
        ZI();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aeE.size() == 0) {
            return this.mSize;
        }
        if (this.bBu) {
            return this.mSize + 1;
        }
        return this.mSize;
    }

    public void er(boolean z) {
        this.bBu = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.bBq) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.bBq && (size = this.aeE.size()) > 0 && i < size) {
            return this.aeE.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.aeE == null || i < this.aeE.size()) {
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
                    view4 = com.baidu.adp.lib.g.b.ek().inflate(this.bBl, com.baidu.tieba.w.home_mark_item, null);
                    lVar = new l(this, null);
                    lVar.azy = (TextView) view4.findViewById(com.baidu.tieba.v.home_lv_markitem_reply);
                    lVar.aLi = (LinearLayout) view4.findViewById(com.baidu.tieba.v.home_lv_markitem_content);
                    lVar.JN = (TextView) view4.findViewById(com.baidu.tieba.v.home_lv_markitem_title);
                    lVar.bBz = (Button) view4.findViewById(com.baidu.tieba.v.home_lv_markitem_delete);
                    lVar.bBw = (ImageView) view4.findViewById(com.baidu.tieba.v.mark_comment_icon);
                    lVar.bBx = (ImageView) view4.findViewById(com.baidu.tieba.v.new_mark_mention_fack);
                    lVar.bBy = (LinearLayout) view4.findViewById(com.baidu.tieba.v.new_mark);
                    lVar.axz = (TextView) view4.findViewById(com.baidu.tieba.v.home_lv_markitem_forum_name);
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
                view4 = com.baidu.adp.lib.g.b.ek().inflate(this.bBl, com.baidu.tieba.w.page_item, null);
                kVar2.bnJ = (TextView) view4.findViewById(com.baidu.tieba.v.page_text);
                kVar2.mProgress = (ProgressBar) view4.findViewById(com.baidu.tieba.v.progress);
                if (this.bmp == null) {
                    this.bmp = new ArrayList<>();
                }
                this.bmp.add(kVar2.mProgress);
                view4.setTag(kVar2);
                lVar = null;
                kVar = kVar2;
            } else {
                lVar = null;
                view4 = view;
                kVar = (k) view.getTag();
            }
            this.bBl.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
            this.bBl.getLayoutMode().h(view4);
            if (getItemViewType(i) == 1) {
                if (this.bBt) {
                    kVar.mProgress.setVisibility(0);
                    kVar.bnJ.setText(this.bBl.getString(com.baidu.tieba.y.loading));
                    com.baidu.tbadk.core.util.aw.b(kVar.bnJ, com.baidu.tieba.s.pb_more_txt, 1);
                    view2 = view4;
                } else if (!this.hasMore) {
                    kVar.mProgress.setVisibility(8);
                    kVar.bnJ.setText(this.bBl.getString(com.baidu.tieba.y.no_more_mark));
                    com.baidu.tbadk.core.util.aw.b(kVar.bnJ, com.baidu.tieba.s.pb_list_morebutton_nomore_text, 1);
                    view2 = view4;
                } else {
                    kVar.mProgress.setVisibility(8);
                    kVar.bnJ.setText(this.bBl.getString(com.baidu.tieba.y.loading));
                    com.baidu.tbadk.core.util.aw.b(kVar.bnJ, com.baidu.tieba.s.pb_more_txt, 1);
                    view2 = view4;
                }
            } else {
                if (this.bBq) {
                    lVar.azy.setVisibility(8);
                    lVar.aLi.setVisibility(8);
                    lVar.bBz.setVisibility(8);
                    a(lVar, false);
                } else {
                    lVar.azy.setVisibility(0);
                    lVar.aLi.setVisibility(0);
                    if (this.aeD) {
                        lVar.bBz.setVisibility(0);
                    } else {
                        lVar.bBz.setVisibility(8);
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
                        lVar.azy.setVisibility(8);
                        lVar.bBw.setVisibility(8);
                    } else {
                        lVar.bBw.setVisibility(0);
                        lVar.azy.setVisibility(0);
                        lVar.azy.setText(String.valueOf(replyNum));
                    }
                    String title = markData.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        lVar.JN.setText(title);
                    } else {
                        lVar.JN.setText("");
                    }
                    if (!TextUtils.isEmpty(markData.getForumName())) {
                        lVar.axz.setText(String.valueOf(markData.getForumName()) + this.bBl.getString(com.baidu.tieba.y.bar));
                    } else {
                        lVar.axz.setText("");
                    }
                    lVar.bBz.setOnClickListener(this.bBs);
                    lVar.bBz.setFocusable(false);
                    lVar.bBz.setTag(Integer.valueOf(i));
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
        if (this.bBq || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void es(boolean z) {
        this.bBr = z;
    }

    public void setEditState(boolean z) {
        this.aeD = z;
    }

    public boolean xf() {
        return this.aeD;
    }

    public void w(View.OnClickListener onClickListener) {
        this.bBs = onClickListener;
    }

    private void a(l lVar, boolean z) {
        if (lVar != null && lVar.bBy != null && lVar.bBx != null) {
            if (z) {
                lVar.bBy.setVisibility(0);
                lVar.bBx.setVisibility(4);
                return;
            }
            lVar.bBy.setVisibility(8);
            lVar.bBx.setVisibility(8);
        }
    }
}
