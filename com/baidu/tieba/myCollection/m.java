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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private boolean cbJ;
    private boolean cbK;
    private TbPageContext<?> mPageContext;
    private int mSize;
    private final ArrayList<MarkData> Xh = new ArrayList<>();
    private boolean aEC = false;
    private ArrayList<ProgressBar> cbL = null;
    private View.OnClickListener cbM = null;
    private boolean cbN = false;
    private boolean hasMore = true;
    private boolean cbO = true;

    public m(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        ea(true);
        adt();
    }

    public void ads() {
        if (this.cbL != null) {
            Iterator<ProgressBar> it = this.cbL.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void adt() {
        this.cbJ = false;
        if (this.Xh == null) {
            this.mSize = 0;
        } else {
            int size = this.Xh.size();
            if (size == 0) {
                if (this.cbK) {
                    this.mSize = 0;
                    this.cbJ = true;
                } else {
                    this.mSize = 0;
                }
            } else {
                this.mSize = size;
            }
        }
        notifyDataSetChanged();
    }

    public void dY(boolean z) {
        this.cbN = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.Xh.clear();
        if (arrayList != null) {
            this.Xh.addAll(arrayList);
        }
        adt();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xh.size() == 0) {
            return this.mSize;
        }
        if (this.cbO) {
            return this.mSize + 1;
        }
        return this.mSize;
    }

    public void dZ(boolean z) {
        this.cbO = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.cbJ) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.cbJ && (size = this.Xh.size()) > 0 && i < size) {
            return this.Xh.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xh == null || i < this.Xh.size()) {
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
                        view3 = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(i.g.home_mark_item, (ViewGroup) null);
                        bVar = new b(this, null);
                        bVar.aTo = (TextView) view3.findViewById(i.f.home_lv_markitem_reply);
                        bVar.bRx = (LinearLayout) view3.findViewById(i.f.home_lv_markitem_content);
                        bVar.aPq = (TextView) view3.findViewById(i.f.home_lv_markitem_title);
                        bVar.cbT = (Button) view3.findViewById(i.f.home_lv_markitem_delete);
                        bVar.cbR = (ImageView) view3.findViewById(i.f.new_mark_mention_fack);
                        bVar.cbS = (LinearLayout) view3.findViewById(i.f.new_mark);
                        bVar.aNC = (TextView) view3.findViewById(i.f.home_lv_markitem_forum_name);
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
                    view3 = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(i.g.page_item, (ViewGroup) null);
                    aVar2.cbP = (TextView) view3.findViewById(i.f.page_text);
                    aVar2.mProgress = (ProgressBar) view3.findViewById(i.f.progress);
                    if (this.cbL == null) {
                        this.cbL = new ArrayList<>();
                    }
                    this.cbL.add(aVar2.mProgress);
                    view3.setTag(aVar2);
                    bVar = null;
                    aVar = aVar2;
                } else {
                    bVar = null;
                    view3 = view;
                    aVar = (a) view.getTag();
                }
                this.mPageContext.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                this.mPageContext.getLayoutMode().k(view3);
                if (getItemViewType(i) == 1) {
                    aVar.cbP.setVisibility(0);
                    if (this.cbN) {
                        aVar.mProgress.setVisibility(0);
                        aVar.cbP.setText(this.mPageContext.getString(i.h.loading));
                        an.b(aVar.cbP, i.c.pb_more_txt, 1);
                    } else if (!this.hasMore) {
                        aVar.mProgress.setVisibility(8);
                        aVar.cbP.setText(this.mPageContext.getString(i.h.no_more_mark));
                        an.b(aVar.cbP, i.c.pb_list_morebutton_nomore_text, 1);
                    } else {
                        aVar.mProgress.setVisibility(8);
                        aVar.cbP.setVisibility(8);
                    }
                } else {
                    if (this.cbJ) {
                        bVar.aTo.setVisibility(8);
                        bVar.bRx.setVisibility(8);
                        bVar.cbT.setVisibility(8);
                        a(bVar, false);
                    } else {
                        bVar.aTo.setVisibility(0);
                        bVar.bRx.setVisibility(0);
                        if (this.aEC) {
                            bVar.cbT.setVisibility(0);
                        } else {
                            bVar.cbT.setVisibility(8);
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
                            bVar.aTo.setVisibility(8);
                        } else {
                            bVar.aTo.setVisibility(0);
                            bVar.aTo.setText(String.valueOf(replyNum));
                        }
                        String title = markData.getTitle();
                        if (!TextUtils.isEmpty(title)) {
                            if (markData.isPhotoLiveThread()) {
                                bVar.aPq.setText(a((int) bVar.aPq.getTextSize(), title));
                            } else {
                                bVar.aPq.setText(title);
                            }
                        } else {
                            bVar.aPq.setText("");
                        }
                        if (!TextUtils.isEmpty(markData.getForumName())) {
                            bVar.aNC.setText(String.valueOf(markData.getForumName()) + this.mPageContext.getString(i.h.bar));
                        } else {
                            bVar.aNC.setText("");
                        }
                        bVar.cbT.setOnClickListener(this.cbM);
                        bVar.cbT.setFocusable(false);
                        bVar.cbT.setTag(Integer.valueOf(i));
                    } else {
                        return view3;
                    }
                }
                bVar.aTo.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
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
        Bitmap cw = an.cw(i.e.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cw);
        bitmapDrawable.setBounds(0, 0, cw.getWidth(), i);
        spannableStringBuilder.setSpan(new com.baidu.tbadk.widget.g(bitmapDrawable), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, i);
        spannableStringBuilder.setSpan(new com.baidu.tbadk.widget.g(colorDrawable), 1, "live".length() + "space".length(), 33);
        return as.a(spannableStringBuilder);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cbJ || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void ea(boolean z) {
        this.cbK = z;
    }

    public void setEditState(boolean z) {
        this.aEC = z;
    }

    public boolean FR() {
        return this.aEC;
    }

    public void x(View.OnClickListener onClickListener) {
        this.cbM = onClickListener;
    }

    private void a(b bVar, boolean z) {
        if (bVar != null && bVar.cbS != null && bVar.cbR != null) {
            if (z) {
                bVar.cbS.setVisibility(0);
                bVar.cbR.setVisibility(4);
                return;
            }
            bVar.cbS.setVisibility(8);
            bVar.cbR.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        TextView aNC;
        TextView aPq;
        TextView aTo;
        LinearLayout bRx;
        ImageView cbR;
        LinearLayout cbS;
        Button cbT;

        private b() {
        }

        /* synthetic */ b(m mVar, b bVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView cbP;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }
    }
}
