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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private boolean cby;
    private boolean cbz;
    private TbPageContext<?> mPageContext;
    private int mSize;
    private final ArrayList<MarkData> Xf = new ArrayList<>();
    private boolean aEr = false;
    private ArrayList<ProgressBar> cbA = null;
    private View.OnClickListener cbB = null;
    private boolean cbC = false;
    private boolean hasMore = true;
    private boolean cbD = true;

    public m(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        ea(true);
        adx();
    }

    public void adw() {
        if (this.cbA != null) {
            Iterator<ProgressBar> it = this.cbA.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void adx() {
        this.cby = false;
        if (this.Xf == null) {
            this.mSize = 0;
        } else {
            int size = this.Xf.size();
            if (size == 0) {
                if (this.cbz) {
                    this.mSize = 0;
                    this.cby = true;
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
        this.cbC = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.Xf.clear();
        if (arrayList != null) {
            this.Xf.addAll(arrayList);
        }
        adx();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xf.size() == 0) {
            return this.mSize;
        }
        if (this.cbD) {
            return this.mSize + 1;
        }
        return this.mSize;
    }

    public void dZ(boolean z) {
        this.cbD = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.cby) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.cby && (size = this.Xf.size()) > 0 && i < size) {
            return this.Xf.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xf == null || i < this.Xf.size()) {
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
                        bVar.aTd = (TextView) view3.findViewById(i.f.home_lv_markitem_reply);
                        bVar.bRm = (LinearLayout) view3.findViewById(i.f.home_lv_markitem_content);
                        bVar.aPf = (TextView) view3.findViewById(i.f.home_lv_markitem_title);
                        bVar.cbI = (Button) view3.findViewById(i.f.home_lv_markitem_delete);
                        bVar.cbG = (ImageView) view3.findViewById(i.f.new_mark_mention_fack);
                        bVar.cbH = (LinearLayout) view3.findViewById(i.f.new_mark);
                        bVar.aNr = (TextView) view3.findViewById(i.f.home_lv_markitem_forum_name);
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
                    aVar2.cbE = (TextView) view3.findViewById(i.f.page_text);
                    aVar2.mProgress = (ProgressBar) view3.findViewById(i.f.progress);
                    if (this.cbA == null) {
                        this.cbA = new ArrayList<>();
                    }
                    this.cbA.add(aVar2.mProgress);
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
                    aVar.cbE.setVisibility(0);
                    if (this.cbC) {
                        aVar.mProgress.setVisibility(0);
                        aVar.cbE.setText(this.mPageContext.getString(i.h.loading));
                        am.b(aVar.cbE, i.c.pb_more_txt, 1);
                    } else if (!this.hasMore) {
                        aVar.mProgress.setVisibility(8);
                        aVar.cbE.setText(this.mPageContext.getString(i.h.no_more_mark));
                        am.b(aVar.cbE, i.c.pb_list_morebutton_nomore_text, 1);
                    } else {
                        aVar.mProgress.setVisibility(8);
                        aVar.cbE.setVisibility(8);
                    }
                } else {
                    if (this.cby) {
                        bVar.aTd.setVisibility(8);
                        bVar.bRm.setVisibility(8);
                        bVar.cbI.setVisibility(8);
                        a(bVar, false);
                    } else {
                        bVar.aTd.setVisibility(0);
                        bVar.bRm.setVisibility(0);
                        if (this.aEr) {
                            bVar.cbI.setVisibility(0);
                        } else {
                            bVar.cbI.setVisibility(8);
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
                            bVar.aTd.setVisibility(8);
                        } else {
                            bVar.aTd.setVisibility(0);
                            bVar.aTd.setText(String.valueOf(replyNum));
                        }
                        String title = markData.getTitle();
                        if (!TextUtils.isEmpty(title)) {
                            if (markData.isPhotoLiveThread()) {
                                bVar.aPf.setText(a((int) bVar.aPf.getTextSize(), title));
                            } else {
                                bVar.aPf.setText(title);
                            }
                        } else {
                            bVar.aPf.setText("");
                        }
                        if (!TextUtils.isEmpty(markData.getForumName())) {
                            bVar.aNr.setText(String.valueOf(markData.getForumName()) + this.mPageContext.getString(i.h.bar));
                        } else {
                            bVar.aNr.setText("");
                        }
                        bVar.cbI.setOnClickListener(this.cbB);
                        bVar.cbI.setFocusable(false);
                        bVar.cbI.setTag(Integer.valueOf(i));
                    } else {
                        return view3;
                    }
                }
                bVar.aTd.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
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
        Bitmap cw = am.cw(i.e.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cw);
        bitmapDrawable.setBounds(0, 0, cw.getWidth(), i);
        spannableStringBuilder.setSpan(new com.baidu.tbadk.widget.g(bitmapDrawable), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, i);
        spannableStringBuilder.setSpan(new com.baidu.tbadk.widget.g(colorDrawable), 1, "live".length() + "space".length(), 33);
        return ar.a(spannableStringBuilder);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cby || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void ea(boolean z) {
        this.cbz = z;
    }

    public void setEditState(boolean z) {
        this.aEr = z;
    }

    public boolean FV() {
        return this.aEr;
    }

    public void x(View.OnClickListener onClickListener) {
        this.cbB = onClickListener;
    }

    private void a(b bVar, boolean z) {
        if (bVar != null && bVar.cbH != null && bVar.cbG != null) {
            if (z) {
                bVar.cbH.setVisibility(0);
                bVar.cbG.setVisibility(4);
                return;
            }
            bVar.cbH.setVisibility(8);
            bVar.cbG.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        TextView aNr;
        TextView aPf;
        TextView aTd;
        LinearLayout bRm;
        ImageView cbG;
        LinearLayout cbH;
        Button cbI;

        private b() {
        }

        /* synthetic */ b(m mVar, b bVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView cbE;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }
    }
}
