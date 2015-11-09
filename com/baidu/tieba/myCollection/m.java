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
    private boolean cck;
    private boolean ccl;
    private TbPageContext<?> mPageContext;
    private int mSize;
    private final ArrayList<MarkData> Xk = new ArrayList<>();
    private boolean aDw = false;
    private ArrayList<ProgressBar> ccm = null;
    private View.OnClickListener ccn = null;
    private boolean cco = false;
    private boolean hasMore = true;
    private boolean ccp = true;

    public m(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        ec(true);
        adO();
    }

    public void adN() {
        if (this.ccm != null) {
            Iterator<ProgressBar> it = this.ccm.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void adO() {
        this.cck = false;
        if (this.Xk == null) {
            this.mSize = 0;
        } else {
            int size = this.Xk.size();
            if (size == 0) {
                if (this.ccl) {
                    this.mSize = 0;
                    this.cck = true;
                } else {
                    this.mSize = 0;
                }
            } else {
                this.mSize = size;
            }
        }
        notifyDataSetChanged();
    }

    public void ea(boolean z) {
        this.cco = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.Xk.clear();
        if (arrayList != null) {
            this.Xk.addAll(arrayList);
        }
        adO();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xk.size() == 0) {
            return this.mSize;
        }
        if (this.ccp) {
            return this.mSize + 1;
        }
        return this.mSize;
    }

    public void eb(boolean z) {
        this.ccp = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.cck) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.cck && (size = this.Xk.size()) > 0 && i < size) {
            return this.Xk.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xk == null || i < this.Xk.size()) {
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
                        bVar.aTw = (TextView) view3.findViewById(i.f.home_lv_markitem_reply);
                        bVar.bRS = (LinearLayout) view3.findViewById(i.f.home_lv_markitem_content);
                        bVar.aPy = (TextView) view3.findViewById(i.f.home_lv_markitem_title);
                        bVar.ccu = (Button) view3.findViewById(i.f.home_lv_markitem_delete);
                        bVar.ccs = (ImageView) view3.findViewById(i.f.new_mark_mention_fack);
                        bVar.cct = (LinearLayout) view3.findViewById(i.f.new_mark);
                        bVar.aNK = (TextView) view3.findViewById(i.f.home_lv_markitem_forum_name);
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
                    aVar2.ccq = (TextView) view3.findViewById(i.f.page_text);
                    aVar2.mProgress = (ProgressBar) view3.findViewById(i.f.progress);
                    if (this.ccm == null) {
                        this.ccm = new ArrayList<>();
                    }
                    this.ccm.add(aVar2.mProgress);
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
                    aVar.ccq.setVisibility(0);
                    if (this.cco) {
                        aVar.mProgress.setVisibility(0);
                        aVar.ccq.setText(this.mPageContext.getString(i.h.loading));
                        an.b(aVar.ccq, i.c.pb_more_txt, 1);
                    } else if (!this.hasMore) {
                        aVar.mProgress.setVisibility(8);
                        aVar.ccq.setText(this.mPageContext.getString(i.h.no_more_mark));
                        an.b(aVar.ccq, i.c.pb_list_morebutton_nomore_text, 1);
                    } else {
                        aVar.mProgress.setVisibility(8);
                        aVar.ccq.setVisibility(8);
                    }
                } else {
                    if (this.cck) {
                        bVar.aTw.setVisibility(8);
                        bVar.bRS.setVisibility(8);
                        bVar.ccu.setVisibility(8);
                        a(bVar, false);
                    } else {
                        bVar.aTw.setVisibility(0);
                        bVar.bRS.setVisibility(0);
                        if (this.aDw) {
                            bVar.ccu.setVisibility(0);
                        } else {
                            bVar.ccu.setVisibility(8);
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
                            bVar.aTw.setVisibility(8);
                        } else {
                            bVar.aTw.setVisibility(0);
                            bVar.aTw.setText(String.valueOf(replyNum));
                        }
                        String title = markData.getTitle();
                        if (!TextUtils.isEmpty(title)) {
                            if (markData.isPhotoLiveThread()) {
                                bVar.aPy.setText(a((int) bVar.aPy.getTextSize(), title));
                            } else {
                                bVar.aPy.setText(title);
                            }
                        } else {
                            bVar.aPy.setText("");
                        }
                        if (!TextUtils.isEmpty(markData.getForumName())) {
                            bVar.aNK.setText(String.valueOf(markData.getForumName()) + this.mPageContext.getString(i.h.bar));
                        } else {
                            bVar.aNK.setText("");
                        }
                        bVar.ccu.setOnClickListener(this.ccn);
                        bVar.ccu.setFocusable(false);
                        bVar.ccu.setTag(Integer.valueOf(i));
                    } else {
                        return view3;
                    }
                }
                bVar.aTw.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
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
        if (this.cck || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void ec(boolean z) {
        this.ccl = z;
    }

    public void setEditState(boolean z) {
        this.aDw = z;
    }

    public boolean FO() {
        return this.aDw;
    }

    public void x(View.OnClickListener onClickListener) {
        this.ccn = onClickListener;
    }

    private void a(b bVar, boolean z) {
        if (bVar != null && bVar.cct != null && bVar.ccs != null) {
            if (z) {
                bVar.cct.setVisibility(0);
                bVar.ccs.setVisibility(4);
                return;
            }
            bVar.cct.setVisibility(8);
            bVar.ccs.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        TextView aNK;
        TextView aPy;
        TextView aTw;
        LinearLayout bRS;
        ImageView ccs;
        LinearLayout cct;
        Button ccu;

        private b() {
        }

        /* synthetic */ b(m mVar, b bVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView ccq;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }
    }
}
