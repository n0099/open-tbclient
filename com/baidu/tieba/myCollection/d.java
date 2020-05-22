package com.baidu.tieba.myCollection;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class d extends BaseAdapter {
    private static final float jtr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float jts = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float jtt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int jtu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int jtv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> dJp = new ArrayList<>();
    private boolean eNc = false;
    private View.OnClickListener jtw = null;
    private View.OnClickListener jtx = null;
    private View.OnClickListener jty = null;
    private boolean jtz = false;
    private boolean hasMore = true;
    private boolean jtA = true;
    private final View.OnClickListener agI = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            an anVar = new an("c12529");
            if (view instanceof CommonUserLikeButton) {
                anVar.ag("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                anVar.ag("obj_locate", 1);
            }
            anVar.dh("tid", item.getId());
            anVar.dh("obj_id", item.getUesrId());
            TiebaStatic.log(anVar);
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setRefreshing(boolean z) {
        this.jtz = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.dJp.clear();
        if (arrayList != null) {
            this.dJp.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (l.isMainThread()) {
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.dJp)) {
            return 0;
        }
        return this.jtA ? v.getCount(this.dJp) + 1 : v.getCount(this.dJp);
    }

    public void qF(boolean z) {
        this.jtA = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        MarkData item = getItem(i);
        if (item == null) {
            return 1;
        }
        if (item.isShareThread()) {
            return 2;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: zD */
    public MarkData getItem(int i) {
        return (MarkData) v.getItem(this.dJp, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.getCount(this.dJp) <= i) {
            return -1L;
        }
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001f  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        c cVar;
        C0673d c0673d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0673d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0673d c0673d2 = new C0673d(view);
                    view.setTag(c0673d2);
                    c0673d = c0673d2;
                } else {
                    c0673d = (C0673d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0673d.jtC.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0673d.jtG.getLayoutParams();
                    if (this.eNc) {
                        c0673d.jtC.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0673d.jtC.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0673d.b(item);
                    a(i, c0673d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.jtJ = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.jtJ.setVisibility(0);
                if (this.jtz) {
                    bVar.mProgress.setVisibility(0);
                    bVar.jtJ.setText(this.mPageContext.getString(R.string.loading));
                    am.setViewTextColor(bVar.jtJ, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.jtJ.setText(this.mPageContext.getString(R.string.no_more_mark));
                    am.setViewTextColor(bVar.jtJ, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.jtJ.setText(this.mPageContext.getString(R.string.loading));
                    am.setViewTextColor(bVar.jtJ, R.color.common_color_10039, 1);
                }
                this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                this.mPageContext.getLayoutMode().onModeChanged(view);
                break;
            case 2:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.cell_collect_share_view, (ViewGroup) null);
                    c cVar2 = new c(view);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                MarkData item2 = getItem(i);
                if (item2 == null) {
                    cVar.jtC.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.jtG.getLayoutParams();
                    if (this.eNc) {
                        cVar.jtC.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.jtC.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.afK.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new an("c12529").ag("obj_locate", 5));
                        }
                    });
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
            default:
                this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                this.mPageContext.getLayoutMode().onModeChanged(view);
                break;
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (v.isEmpty(this.dJp) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void iY(boolean z) {
        this.eNc = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.jtH.setOnClickListener(this.jtx);
        aVar.jtH.setTag(valueOf);
        aVar.hRq.setAfterClickListener(this.agI);
        aVar.hRq.setTag(valueOf);
        aVar.jtD.setAfterOnClickListener(this.agI);
        aVar.jtD.setTag(valueOf);
        aVar.jtI.setOnClickListener(this.jty);
        aVar.jtI.setTag(valueOf);
        aVar.jtC.setOnClickListener(this.jtw);
        aVar.jtC.setFocusable(false);
        aVar.jtC.setTag(valueOf);
    }

    public void K(View.OnClickListener onClickListener) {
        this.jtw = onClickListener;
    }

    public void L(View.OnClickListener onClickListener) {
        this.jtx = onClickListener;
    }

    public void M(View.OnClickListener onClickListener) {
        this.jty = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c agS;
        TextView dXU;
        ClickableHeaderImageView hRq;
        ImageButton jtC;
        CommonUserLikeButton jtD;
        TextView jtE;
        ImageView jtF;
        LinearLayout jtG;
        LinearLayout jtH;
        LinearLayout jtI;
        View mDivider;
        TextView mTitle;

        private a() {
        }

        void d(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                clickableHeaderImageView.setPlaceHolder(1);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(d.this.agI);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.jtr);
                        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.jts);
                        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.hRq.setData(markData.metaData);
                this.hRq.setShowV(markData.metaData.isBigV());
                this.agS.a(markData.metaData);
                this.jtD.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.jtD.setTextSize(0, d.jtt);
                if ((markData.metaData.getIsLike() || aq.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.jtD.setVisibility(8);
                } else {
                    this.jtD.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.jtI.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.jtF.setVisibility(0);
                    } else {
                        this.jtF.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.jtE.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.jtE.setText(markData.getmState());
                    }
                    am.setViewTextColor(this.jtE, (int) R.color.cp_cont_d);
                } else {
                    this.jtI.setVisibility(8);
                }
                am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.dXU.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    am.setViewTextColor(this.dXU, (int) R.color.cp_cont_h);
                } else {
                    am.setViewTextColor(this.dXU, (int) R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0673d extends a {
        TbImageView gGd;
        LinearLayout jtK;

        public C0673d(View view) {
            super();
            this.jtG = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.hRq = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.dXU = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.jtH = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.jtK = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.jtD = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.agS = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.jtD);
            this.gGd = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.jtE = (TextView) view.findViewById(R.id.markitem_state_text);
            this.jtC = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.jtF = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.jtI = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.mDivider = view.findViewById(R.id.text_divider);
            d(this.hRq);
            this.gGd.setPlaceHolder(2);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jtH.getLayoutParams();
            if (k.aNQ().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.gGd.setVisibility(0);
                    this.gGd.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.jtu;
            } else {
                this.gGd.setVisibility(8);
                layoutParams.bottomMargin = d.jtv;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jtK.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.jtr;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes11.dex */
    private class c extends a {
        OriginalThreadCardView afK;

        public c(View view) {
            super();
            this.jtG = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.jtC = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.hRq = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.dXU = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.jtD = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.agS = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.jtD);
            this.jtH = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.afK = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.jtE = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.jtF = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.jtI = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.mDivider = view.findViewById(R.id.share_text_divider);
            d(this.hRq);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.afK.b(markData.getOriginalThreadInfo());
            this.afK.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afK.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.jtr;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes11.dex */
    private class b {
        TextView jtJ;
        ProgressBar mProgress;

        private b() {
        }
    }
}
