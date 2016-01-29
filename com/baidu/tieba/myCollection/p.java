package com.baidu.tieba.myCollection;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private TbPageContext<?> Nw;
    private boolean cES;
    private boolean cET;
    private int mSize;
    private final ArrayList<MarkData> YX = new ArrayList<>();
    private boolean aIX = false;
    private ArrayList<ProgressBar> cEU = null;
    private View.OnClickListener cEV = null;
    private boolean cEW = false;
    private boolean hasMore = true;
    private boolean cEX = true;

    public p(TbPageContext<?> tbPageContext) {
        this.Nw = tbPageContext;
        eQ(true);
        ann();
    }

    public void anm() {
        if (this.cEU != null) {
            Iterator<ProgressBar> it = this.cEU.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void ann() {
        this.cES = false;
        if (this.YX == null) {
            this.mSize = 0;
        } else {
            int size = this.YX.size();
            if (size == 0) {
                if (this.cET) {
                    this.mSize = 0;
                    this.cES = true;
                } else {
                    this.mSize = 0;
                }
            } else {
                this.mSize = size;
            }
        }
        notifyDataSetChanged();
    }

    public void eO(boolean z) {
        this.cEW = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.YX.clear();
        if (arrayList != null) {
            this.YX.addAll(arrayList);
        }
        ann();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.YX.size() == 0) {
            return this.mSize;
        }
        if (this.cEX) {
            return this.mSize + 1;
        }
        return this.mSize;
    }

    public void eP(boolean z) {
        this.cEX = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.cES) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.cES && (size = this.YX.size()) > 0 && i < size) {
            return this.YX.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.YX == null || i < this.YX.size()) {
            return i;
        }
        return -1L;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x023b: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:67:0x023a */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        b bVar;
        View view4;
        a aVar = null;
        try {
        } catch (Exception e) {
            exc = e;
            view2 = view;
        }
        try {
            if (getItemViewType(i) == 0) {
                if (view == null || !(view.getTag() instanceof b)) {
                    view4 = LayoutInflater.from(this.Nw.getPageActivity()).inflate(t.h.home_mark_item, (ViewGroup) null);
                    bVar = new b(this, null);
                    bVar.beY = (TextView) view4.findViewById(t.g.home_lv_markitem_reply);
                    bVar.csP = (LinearLayout) view4.findViewById(t.g.home_lv_markitem_content);
                    bVar.aPr = (TextView) view4.findViewById(t.g.home_lv_markitem_title);
                    bVar.cFc = (Button) view4.findViewById(t.g.home_lv_markitem_delete);
                    bVar.cFa = (ImageView) view4.findViewById(t.g.new_mark_mention_fack);
                    bVar.cFb = (LinearLayout) view4.findViewById(t.g.new_mark);
                    bVar.aPa = (TextView) view4.findViewById(t.g.home_lv_markitem_forum_name);
                    view4.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                    view4 = view;
                }
            } else if (getItemViewType(i) != 1) {
                bVar = null;
                view4 = view;
            } else if (view == null || !(view.getTag() instanceof a)) {
                a aVar2 = new a(this, null);
                view4 = LayoutInflater.from(this.Nw.getPageActivity()).inflate(t.h.page_item, (ViewGroup) null);
                aVar2.cEY = (TextView) view4.findViewById(t.g.page_text);
                aVar2.aNo = (ProgressBar) view4.findViewById(t.g.progress);
                if (this.cEU == null) {
                    this.cEU = new ArrayList<>();
                }
                this.cEU.add(aVar2.aNo);
                view4.setTag(aVar2);
                bVar = null;
                aVar = aVar2;
            } else {
                bVar = null;
                view4 = view;
                aVar = (a) view.getTag();
            }
            this.Nw.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.Nw.getLayoutMode().x(view4);
            if (getItemViewType(i) == 1) {
                aVar.cEY.setVisibility(0);
                if (this.cEW) {
                    aVar.aNo.setVisibility(0);
                    aVar.cEY.setText(this.Nw.getString(t.j.loading));
                    ar.b(aVar.cEY, t.d.pb_more_txt, 1);
                    view2 = view4;
                } else if (!this.hasMore) {
                    aVar.aNo.setVisibility(8);
                    aVar.cEY.setText(this.Nw.getString(t.j.no_more_mark));
                    ar.b(aVar.cEY, t.d.pb_list_morebutton_nomore_text, 1);
                    view2 = view4;
                } else {
                    aVar.aNo.setVisibility(8);
                    aVar.cEY.setText(this.Nw.getString(t.j.loading));
                    ar.b(aVar.cEY, t.d.pb_more_txt, 1);
                    view2 = view4;
                }
            } else if (getItemViewType(i) == 0) {
                if (this.cES) {
                    bVar.beY.setVisibility(8);
                    bVar.csP.setVisibility(8);
                    bVar.cFc.setVisibility(8);
                    a(bVar, false);
                } else {
                    bVar.beY.setVisibility(0);
                    bVar.csP.setVisibility(0);
                    if (this.aIX) {
                        bVar.cFc.setVisibility(0);
                    } else {
                        bVar.cFc.setVisibility(8);
                    }
                }
                Object item = getItem(i);
                if (item != null) {
                    MarkData markData = (MarkData) item;
                    if (markData.getNewCounts() > 0) {
                        a(bVar, true);
                    } else {
                        a(bVar, false);
                    }
                    int replyNum = markData.getReplyNum();
                    if (replyNum < 0) {
                        bVar.beY.setVisibility(8);
                    } else {
                        bVar.beY.setVisibility(0);
                        bVar.beY.setText(String.valueOf(replyNum));
                    }
                    String title = markData.getTitle();
                    if (!TextUtils.isEmpty(title)) {
                        if (markData.isPhotoLiveThread()) {
                            bVar.aPr.setText(a((int) bVar.aPr.getTextSize(), title));
                        } else {
                            bVar.aPr.setText(title);
                        }
                    } else {
                        bVar.aPr.setText("");
                    }
                    if (!TextUtils.isEmpty(markData.getForumName())) {
                        bVar.aPa.setText(String.valueOf(markData.getForumName()) + this.Nw.getString(t.j.bar));
                    } else {
                        bVar.aPa.setText("");
                    }
                    bVar.cFc.setOnClickListener(this.cEV);
                    bVar.cFc.setFocusable(false);
                    bVar.cFc.setTag(Integer.valueOf(i));
                    bVar.beY.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    view2 = view4;
                } else {
                    return view4;
                }
            } else {
                view2 = view4;
            }
        } catch (Exception e2) {
            view2 = view3;
            exc = e2;
            BdLog.e(exc.getMessage());
            return view2;
        }
        return view2;
    }

    public SpannableStringBuilder a(int i, CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cO = ar.cO(t.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
        bitmapDrawable.setBounds(0, 0, cO.getWidth(), i);
        spannableStringBuilder.setSpan(new com.baidu.tbadk.widget.f(bitmapDrawable), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, i);
        spannableStringBuilder.setSpan(new com.baidu.tbadk.widget.f(colorDrawable), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cES || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void eQ(boolean z) {
        this.cET = z;
    }

    public void setEditState(boolean z) {
        this.aIX = z;
    }

    public boolean Il() {
        return this.aIX;
    }

    public void D(View.OnClickListener onClickListener) {
        this.cEV = onClickListener;
    }

    private void a(b bVar, boolean z) {
        if (bVar != null && bVar.cFb != null && bVar.cFa != null) {
            if (z) {
                bVar.cFb.setVisibility(0);
                bVar.cFa.setVisibility(4);
                return;
            }
            bVar.cFb.setVisibility(8);
            bVar.cFa.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        TextView aPa;
        TextView aPr;
        TextView beY;
        ImageView cFa;
        LinearLayout cFb;
        Button cFc;
        LinearLayout csP;

        private b() {
        }

        /* synthetic */ b(p pVar, b bVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        ProgressBar aNo;
        TextView cEY;

        private a() {
        }

        /* synthetic */ a(p pVar, a aVar) {
            this();
        }
    }
}
