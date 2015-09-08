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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private boolean bXM;
    private boolean bXN;
    private TbPageContext<?> mPageContext;
    private int mSize;
    private final ArrayList<MarkData> Xn = new ArrayList<>();
    private boolean aFm = false;
    private ArrayList<ProgressBar> bXO = null;
    private View.OnClickListener bXP = null;
    private boolean bXQ = false;
    private boolean hasMore = true;
    private boolean bXR = true;

    public m(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        dZ(true);
        acf();
    }

    public void ace() {
        if (this.bXO != null) {
            Iterator<ProgressBar> it = this.bXO.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void acf() {
        this.bXM = false;
        if (this.Xn == null) {
            this.mSize = 0;
        } else {
            int size = this.Xn.size();
            if (size == 0) {
                if (this.bXN) {
                    this.mSize = 0;
                    this.bXM = true;
                } else {
                    this.mSize = 0;
                }
            } else {
                this.mSize = size;
            }
        }
        notifyDataSetChanged();
    }

    public void dX(boolean z) {
        this.bXQ = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.Xn.clear();
        if (arrayList != null) {
            this.Xn.addAll(arrayList);
        }
        acf();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xn.size() == 0) {
            return this.mSize;
        }
        if (this.bXR) {
            return this.mSize + 1;
        }
        return this.mSize;
    }

    public void dY(boolean z) {
        this.bXR = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (getItemId(i) >= 0 || this.bXM) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int size;
        if (!this.bXM && (size = this.Xn.size()) > 0 && i < size) {
            return this.Xn.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.Xn == null || i < this.Xn.size()) {
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
                        bVar.aUh = (TextView) view3.findViewById(i.f.home_lv_markitem_reply);
                        bVar.bNK = (LinearLayout) view3.findViewById(i.f.home_lv_markitem_content);
                        bVar.aQj = (TextView) view3.findViewById(i.f.home_lv_markitem_title);
                        bVar.bXW = (Button) view3.findViewById(i.f.home_lv_markitem_delete);
                        bVar.bXU = (ImageView) view3.findViewById(i.f.new_mark_mention_fack);
                        bVar.bXV = (LinearLayout) view3.findViewById(i.f.new_mark);
                        bVar.aOv = (TextView) view3.findViewById(i.f.home_lv_markitem_forum_name);
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
                    aVar2.bXS = (TextView) view3.findViewById(i.f.page_text);
                    aVar2.mProgress = (ProgressBar) view3.findViewById(i.f.progress);
                    if (this.bXO == null) {
                        this.bXO = new ArrayList<>();
                    }
                    this.bXO.add(aVar2.mProgress);
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
                    aVar.bXS.setVisibility(0);
                    if (this.bXQ) {
                        aVar.mProgress.setVisibility(0);
                        aVar.bXS.setText(this.mPageContext.getString(i.h.loading));
                        al.b(aVar.bXS, i.c.pb_more_txt, 1);
                    } else if (!this.hasMore) {
                        aVar.mProgress.setVisibility(8);
                        aVar.bXS.setText(this.mPageContext.getString(i.h.no_more_mark));
                        al.b(aVar.bXS, i.c.pb_list_morebutton_nomore_text, 1);
                    } else {
                        aVar.mProgress.setVisibility(8);
                        aVar.bXS.setVisibility(8);
                    }
                } else {
                    if (this.bXM) {
                        bVar.aUh.setVisibility(8);
                        bVar.bNK.setVisibility(8);
                        bVar.bXW.setVisibility(8);
                        a(bVar, false);
                    } else {
                        bVar.aUh.setVisibility(0);
                        bVar.bNK.setVisibility(0);
                        if (this.aFm) {
                            bVar.bXW.setVisibility(0);
                        } else {
                            bVar.bXW.setVisibility(8);
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
                            bVar.aUh.setVisibility(8);
                        } else {
                            bVar.aUh.setVisibility(0);
                            bVar.aUh.setText(String.valueOf(replyNum));
                        }
                        String title = markData.getTitle();
                        if (!TextUtils.isEmpty(title)) {
                            if (markData.isPhotoLiveThread()) {
                                bVar.aQj.setText(a((int) bVar.aQj.getTextSize(), title));
                            } else {
                                bVar.aQj.setText(title);
                            }
                        } else {
                            bVar.aQj.setText("");
                        }
                        if (!TextUtils.isEmpty(markData.getForumName())) {
                            bVar.aOv.setText(String.valueOf(markData.getForumName()) + this.mPageContext.getString(i.h.bar));
                        } else {
                            bVar.aOv.setText("");
                        }
                        bVar.bXW.setOnClickListener(this.bXP);
                        bVar.bXW.setFocusable(false);
                        bVar.bXW.setTag(Integer.valueOf(i));
                    } else {
                        return view3;
                    }
                }
                bVar.aUh.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
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
        Bitmap cu = al.cu(i.e.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cu);
        bitmapDrawable.setBounds(0, 0, cu.getWidth(), i);
        spannableStringBuilder.setSpan(new com.baidu.tbadk.widget.i(bitmapDrawable), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, i);
        spannableStringBuilder.setSpan(new com.baidu.tbadk.widget.i(colorDrawable), 1, "live".length() + "space".length(), 33);
        return aq.a(spannableStringBuilder);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.bXM || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void dZ(boolean z) {
        this.bXN = z;
    }

    public void setEditState(boolean z) {
        this.aFm = z;
    }

    public boolean Gb() {
        return this.aFm;
    }

    public void w(View.OnClickListener onClickListener) {
        this.bXP = onClickListener;
    }

    private void a(b bVar, boolean z) {
        if (bVar != null && bVar.bXV != null && bVar.bXU != null) {
            if (z) {
                bVar.bXV.setVisibility(0);
                bVar.bXU.setVisibility(4);
                return;
            }
            bVar.bXV.setVisibility(8);
            bVar.bXU.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        TextView aOv;
        TextView aQj;
        TextView aUh;
        LinearLayout bNK;
        ImageView bXU;
        LinearLayout bXV;
        Button bXW;

        private b() {
        }

        /* synthetic */ b(m mVar, b bVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView bXS;
        ProgressBar mProgress;

        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }
    }
}
