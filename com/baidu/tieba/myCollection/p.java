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
    private boolean cyl;
    private boolean cym;
    private TbPageContext<?> mPageContext;
    private int mSize;
    private final ArrayList<MarkData> YA = new ArrayList<>();
    private boolean aHV = false;
    private ArrayList<ProgressBar> cyn = null;
    private View.OnClickListener cyo = null;
    private boolean cyp = false;
    private boolean hasMore = true;
    private boolean cyq = true;

    public p(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        eD(true);
        ajp();
    }

    public void ajo() {
        if (this.cyn != null) {
            Iterator<ProgressBar> it = this.cyn.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void ajp() {
        this.cyl = false;
        if (this.YA == null) {
            this.mSize = 0;
        } else {
            int size = this.YA.size();
            if (size == 0) {
                if (this.cym) {
                    this.mSize = 0;
                    this.cyl = true;
                } else {
                    this.mSize = 0;
                }
            } else {
                this.mSize = size;
            }
        }
        notifyDataSetChanged();
    }

    public void eB(boolean z) {
        this.cyp = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.YA.clear();
        if (arrayList != null) {
            this.YA.addAll(arrayList);
        }
        ajp();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.YA.size() == 0) {
            return this.mSize;
        }
        if (this.cyq) {
            return this.mSize + 1;
        }
        return this.mSize;
    }

    public void eC(boolean z) {
        this.cyq = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.cyl) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.cyl && (size = this.YA.size()) > 0 && i < size) {
            return this.YA.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.YA == null || i < this.YA.size()) {
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
                        view3 = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(n.h.home_mark_item, (ViewGroup) null);
                        bVar = new b(this, null);
                        bVar.bcG = (TextView) view3.findViewById(n.g.home_lv_markitem_reply);
                        bVar.cmk = (LinearLayout) view3.findViewById(n.g.home_lv_markitem_content);
                        bVar.aOn = (TextView) view3.findViewById(n.g.home_lv_markitem_title);
                        bVar.cyv = (Button) view3.findViewById(n.g.home_lv_markitem_delete);
                        bVar.cyt = (ImageView) view3.findViewById(n.g.new_mark_mention_fack);
                        bVar.cyu = (LinearLayout) view3.findViewById(n.g.new_mark);
                        bVar.aNz = (TextView) view3.findViewById(n.g.home_lv_markitem_forum_name);
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
                    view3 = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(n.h.page_item, (ViewGroup) null);
                    aVar2.cyr = (TextView) view3.findViewById(n.g.page_text);
                    aVar2.mProgress = (ProgressBar) view3.findViewById(n.g.progress);
                    if (this.cyn == null) {
                        this.cyn = new ArrayList<>();
                    }
                    this.cyn.add(aVar2.mProgress);
                    view3.setTag(aVar2);
                    bVar = null;
                    aVar = aVar2;
                } else {
                    bVar = null;
                    view3 = view;
                    aVar = (a) view.getTag();
                }
                this.mPageContext.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
                this.mPageContext.getLayoutMode().k(view3);
                if (getItemViewType(i) == 1) {
                    aVar.cyr.setVisibility(0);
                    if (this.cyp) {
                        aVar.mProgress.setVisibility(0);
                        aVar.cyr.setText(this.mPageContext.getString(n.j.loading));
                        as.b(aVar.cyr, n.d.pb_more_txt, 1);
                    } else if (!this.hasMore) {
                        aVar.mProgress.setVisibility(8);
                        aVar.cyr.setText(this.mPageContext.getString(n.j.no_more_mark));
                        as.b(aVar.cyr, n.d.pb_list_morebutton_nomore_text, 1);
                    } else {
                        aVar.mProgress.setVisibility(8);
                        aVar.cyr.setText(this.mPageContext.getString(n.j.loading));
                        as.b(aVar.cyr, n.d.pb_more_txt, 1);
                    }
                } else {
                    if (this.cyl) {
                        bVar.bcG.setVisibility(8);
                        bVar.cmk.setVisibility(8);
                        bVar.cyv.setVisibility(8);
                        a(bVar, false);
                    } else {
                        bVar.bcG.setVisibility(0);
                        bVar.cmk.setVisibility(0);
                        if (this.aHV) {
                            bVar.cyv.setVisibility(0);
                        } else {
                            bVar.cyv.setVisibility(8);
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
                            bVar.bcG.setVisibility(8);
                        } else {
                            bVar.bcG.setVisibility(0);
                            bVar.bcG.setText(String.valueOf(replyNum));
                        }
                        String title = markData.getTitle();
                        if (!TextUtils.isEmpty(title)) {
                            if (markData.isPhotoLiveThread()) {
                                bVar.aOn.setText(a((int) bVar.aOn.getTextSize(), title));
                            } else {
                                bVar.aOn.setText(title);
                            }
                        } else {
                            bVar.aOn.setText("");
                        }
                        if (!TextUtils.isEmpty(markData.getForumName())) {
                            bVar.aNz.setText(String.valueOf(markData.getForumName()) + this.mPageContext.getString(n.j.bar));
                        } else {
                            bVar.aNz.setText("");
                        }
                        bVar.cyv.setOnClickListener(this.cyo);
                        bVar.cyv.setFocusable(false);
                        bVar.cyv.setTag(Integer.valueOf(i));
                    } else {
                        return view3;
                    }
                }
                bVar.bcG.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
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
        Bitmap cx = as.cx(n.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cx);
        bitmapDrawable.setBounds(0, 0, cx.getWidth(), i);
        spannableStringBuilder.setSpan(new com.baidu.tbadk.widget.f(bitmapDrawable), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, i);
        spannableStringBuilder.setSpan(new com.baidu.tbadk.widget.f(colorDrawable), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.cyl || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void eD(boolean z) {
        this.cym = z;
    }

    public void setEditState(boolean z) {
        this.aHV = z;
    }

    public boolean GK() {
        return this.aHV;
    }

    public void x(View.OnClickListener onClickListener) {
        this.cyo = onClickListener;
    }

    private void a(b bVar, boolean z) {
        if (bVar != null && bVar.cyu != null && bVar.cyt != null) {
            if (z) {
                bVar.cyu.setVisibility(0);
                bVar.cyt.setVisibility(4);
                return;
            }
            bVar.cyu.setVisibility(8);
            bVar.cyt.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        TextView aNz;
        TextView aOn;
        TextView bcG;
        LinearLayout cmk;
        ImageView cyt;
        LinearLayout cyu;
        Button cyv;

        private b() {
        }

        /* synthetic */ b(p pVar, b bVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView cyr;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(p pVar, a aVar) {
            this();
        }
    }
}
