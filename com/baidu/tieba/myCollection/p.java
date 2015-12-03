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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private boolean cuk;
    private boolean cul;
    private TbPageContext<?> mPageContext;
    private int mSize;
    private final ArrayList<MarkData> XX = new ArrayList<>();
    private boolean aGu = false;
    private ArrayList<ProgressBar> cum = null;
    private View.OnClickListener cun = null;
    private boolean cuo = false;
    private boolean hasMore = true;
    private boolean cup = true;

    public p(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        eE(true);
        aic();
    }

    public void aib() {
        if (this.cum != null) {
            Iterator<ProgressBar> it = this.cum.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void aic() {
        this.cuk = false;
        if (this.XX == null) {
            this.mSize = 0;
        } else {
            int size = this.XX.size();
            if (size == 0) {
                if (this.cul) {
                    this.mSize = 0;
                    this.cuk = true;
                } else {
                    this.mSize = 0;
                }
            } else {
                this.mSize = size;
            }
        }
        notifyDataSetChanged();
    }

    public void eC(boolean z) {
        this.cuo = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.XX.clear();
        if (arrayList != null) {
            this.XX.addAll(arrayList);
        }
        aic();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.XX.size() == 0) {
            return this.mSize;
        }
        if (this.cup) {
            return this.mSize + 1;
        }
        return this.mSize;
    }

    public void eD(boolean z) {
        this.cup = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.cuk) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.cuk && (size = this.XX.size()) > 0 && i < size) {
            return this.XX.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.XX == null || i < this.XX.size()) {
            return i;
        }
        return -1L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        b bVar;
        View view3;
        a aVar = null;
        try {
            try {
                if (getItemViewType(i) == 0) {
                    if (view == null || !(view.getTag() instanceof b)) {
                        view3 = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(n.g.home_mark_item, (ViewGroup) null);
                        bVar = new b(this, null);
                        bVar.aYK = (TextView) view3.findViewById(n.f.home_lv_markitem_reply);
                        bVar.cif = (LinearLayout) view3.findViewById(n.f.home_lv_markitem_content);
                        bVar.aUB = (TextView) view3.findViewById(n.f.home_lv_markitem_title);
                        bVar.cuv = (Button) view3.findViewById(n.f.home_lv_markitem_delete);
                        bVar.cut = (ImageView) view3.findViewById(n.f.new_mark_mention_fack);
                        bVar.cuu = (LinearLayout) view3.findViewById(n.f.new_mark);
                        bVar.aLY = (TextView) view3.findViewById(n.f.home_lv_markitem_forum_name);
                        view3.setTag(bVar);
                    } else {
                        bVar = (b) view.getTag();
                        view3 = view;
                    }
                } else if (getItemViewType(i) != 1) {
                    bVar = null;
                    view3 = view;
                } else if (view == null || !(view.getTag() instanceof a)) {
                    a aVar2 = new a(this, null);
                    view3 = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(n.g.page_item, (ViewGroup) null);
                    aVar2.cuq = (TextView) view3.findViewById(n.f.page_text);
                    aVar2.mProgress = (ProgressBar) view3.findViewById(n.f.progress);
                    if (this.cum == null) {
                        this.cum = new ArrayList<>();
                    }
                    this.cum.add(aVar2.mProgress);
                    view3.setTag(aVar2);
                    bVar = null;
                    aVar = aVar2;
                } else {
                    bVar = null;
                    view3 = view;
                    aVar = (a) view.getTag();
                }
                this.mPageContext.getLayoutMode().af(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                this.mPageContext.getLayoutMode().k(view3);
                if (getItemViewType(i) == 1) {
                    aVar.cuq.setVisibility(0);
                    if (this.cuo) {
                        aVar.mProgress.setVisibility(0);
                        aVar.cuq.setText(this.mPageContext.getString(n.i.loading));
                        as.b(aVar.cuq, n.c.pb_more_txt, 1);
                    } else if (!this.hasMore) {
                        aVar.mProgress.setVisibility(8);
                        aVar.cuq.setText(this.mPageContext.getString(n.i.no_more_mark));
                        as.b(aVar.cuq, n.c.pb_list_morebutton_nomore_text, 1);
                    } else {
                        aVar.mProgress.setVisibility(8);
                        aVar.cuq.setVisibility(8);
                    }
                } else {
                    if (this.cuk) {
                        bVar.aYK.setVisibility(8);
                        bVar.cif.setVisibility(8);
                        bVar.cuv.setVisibility(8);
                        a(bVar, false);
                    } else {
                        bVar.aYK.setVisibility(0);
                        bVar.cif.setVisibility(0);
                        if (this.aGu) {
                            bVar.cuv.setVisibility(0);
                        } else {
                            bVar.cuv.setVisibility(8);
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
                            bVar.aYK.setVisibility(8);
                        } else {
                            bVar.aYK.setVisibility(0);
                            bVar.aYK.setText(String.valueOf(replyNum));
                        }
                        String title = markData.getTitle();
                        if (!TextUtils.isEmpty(title)) {
                            if (markData.isPhotoLiveThread()) {
                                bVar.aUB.setText(a((int) bVar.aUB.getTextSize(), title));
                            } else {
                                bVar.aUB.setText(title);
                            }
                        } else {
                            bVar.aUB.setText("");
                        }
                        if (!TextUtils.isEmpty(markData.getForumName())) {
                            bVar.aLY.setText(String.valueOf(markData.getForumName()) + this.mPageContext.getString(n.i.bar));
                        } else {
                            bVar.aLY.setText("");
                        }
                        bVar.cuv.setOnClickListener(this.cun);
                        bVar.cuv.setFocusable(false);
                        bVar.cuv.setTag(Integer.valueOf(i));
                    } else {
                        return view3;
                    }
                }
                bVar.aYK.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
                view2 = view3;
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                BdLog.e(exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        return view2;
    }

    public SpannableStringBuilder a(int i, CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cE = as.cE(n.e.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cE);
        bitmapDrawable.setBounds(0, 0, cE.getWidth(), i);
        spannableStringBuilder.setSpan(new com.baidu.tbadk.widget.f(bitmapDrawable), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, i);
        spannableStringBuilder.setSpan(new com.baidu.tbadk.widget.f(colorDrawable), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cuk || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void eE(boolean z) {
        this.cul = z;
    }

    public void setEditState(boolean z) {
        this.aGu = z;
    }

    public boolean GV() {
        return this.aGu;
    }

    public void x(View.OnClickListener onClickListener) {
        this.cun = onClickListener;
    }

    private void a(b bVar, boolean z) {
        if (bVar != null && bVar.cuu != null && bVar.cut != null) {
            if (z) {
                bVar.cuu.setVisibility(0);
                bVar.cut.setVisibility(4);
                return;
            }
            bVar.cuu.setVisibility(8);
            bVar.cut.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        TextView aLY;
        TextView aUB;
        TextView aYK;
        LinearLayout cif;
        ImageView cut;
        LinearLayout cuu;
        Button cuv;

        private b() {
        }

        /* synthetic */ b(p pVar, b bVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView cuq;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(p pVar, a aVar) {
            this();
        }
    }
}
