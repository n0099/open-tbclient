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
import com.baidu.tbadk.core.i;
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
/* loaded from: classes6.dex */
public class d extends BaseAdapter {
    private static final float hzF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float hzG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float hzH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int hzI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int hzJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> bbZ = new ArrayList<>();
    private boolean dgN = false;
    private View.OnClickListener hzK = null;
    private View.OnClickListener hzL = null;
    private View.OnClickListener hzM = null;
    private boolean hzN = false;
    private boolean hasMore = true;
    private boolean hzO = true;
    private final View.OnClickListener HO = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            an anVar = new an("c12529");
            if (view instanceof CommonUserLikeButton) {
                anVar.O("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                anVar.O("obj_locate", 1);
            }
            anVar.bS("tid", item.getId());
            anVar.bS("obj_id", item.getUesrId());
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
        this.hzN = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.bbZ.clear();
        if (arrayList != null) {
            this.bbZ.addAll(arrayList);
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
        if (v.isEmpty(this.bbZ)) {
            return 0;
        }
        return this.hzO ? v.getCount(this.bbZ) + 1 : v.getCount(this.bbZ);
    }

    public void nu(boolean z) {
        this.hzO = z;
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
    /* renamed from: wa */
    public MarkData getItem(int i) {
        return (MarkData) v.getItem(this.bbZ, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.getCount(this.bbZ) <= i) {
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
        C0470d c0470d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0470d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0470d c0470d2 = new C0470d(view);
                    view.setTag(c0470d2);
                    c0470d = c0470d2;
                } else {
                    c0470d = (C0470d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0470d.hzQ.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0470d.hzU.getLayoutParams();
                    if (this.dgN) {
                        c0470d.hzQ.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0470d.hzQ.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0470d.b(item);
                    a(i, c0470d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.hzX = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.hzX.setVisibility(0);
                if (this.hzN) {
                    bVar.mProgress.setVisibility(0);
                    bVar.hzX.setText(this.mPageContext.getString(R.string.loading));
                    am.setViewTextColor(bVar.hzX, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.hzX.setText(this.mPageContext.getString(R.string.no_more_mark));
                    am.setViewTextColor(bVar.hzX, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.hzX.setText(this.mPageContext.getString(R.string.loading));
                    am.setViewTextColor(bVar.hzX, R.color.common_color_10039, 1);
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
                    cVar.hzQ.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.hzU.getLayoutParams();
                    if (this.dgN) {
                        cVar.hzQ.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.hzQ.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.Hn.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new an("c12529").O("obj_locate", 5));
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
        if (v.isEmpty(this.bbZ) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void gc(boolean z) {
        this.dgN = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.hzV.setOnClickListener(this.hzL);
        aVar.hzV.setTag(valueOf);
        aVar.fYl.setAfterClickListener(this.HO);
        aVar.fYl.setTag(valueOf);
        aVar.hzR.setAfterOnClickListener(this.HO);
        aVar.hzR.setTag(valueOf);
        aVar.hzW.setOnClickListener(this.hzM);
        aVar.hzW.setTag(valueOf);
        aVar.hzQ.setOnClickListener(this.hzK);
        aVar.hzQ.setFocusable(false);
        aVar.hzQ.setTag(valueOf);
    }

    public void I(View.OnClickListener onClickListener) {
        this.hzK = onClickListener;
    }

    public void J(View.OnClickListener onClickListener) {
        this.hzL = onClickListener;
    }

    public void K(View.OnClickListener onClickListener) {
        this.hzM = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a {
        View bhm;
        TextView csn;
        com.baidu.tbadk.core.view.userLike.c eMu;
        ClickableHeaderImageView fYl;
        ImageButton hzQ;
        CommonUserLikeButton hzR;
        TextView hzS;
        ImageView hzT;
        LinearLayout hzU;
        LinearLayout hzV;
        LinearLayout hzW;
        TextView mTitle;

        private a() {
        }

        void d(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                clickableHeaderImageView.setDefaultBgResource(R.color.cp_bg_line_e);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(d.this.HO);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.hzF);
                        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.hzG);
                        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.fYl.setData(markData.metaData);
                this.fYl.setShowV(markData.metaData.isBigV());
                this.eMu.a(markData.metaData);
                this.hzR.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.hzR.setTextSize(0, d.hzH);
                if ((markData.metaData.getIsLike() || aq.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.hzR.setVisibility(8);
                } else {
                    this.hzR.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.hzW.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.hzT.setVisibility(0);
                    } else {
                        this.hzT.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.hzS.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.hzS.setText(markData.getmState());
                    }
                    am.setViewTextColor(this.hzS, (int) R.color.cp_cont_d);
                } else {
                    this.hzW.setVisibility(8);
                }
                am.setBackgroundColor(this.bhm, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.csn.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    am.setViewTextColor(this.csn, (int) R.color.cp_cont_h);
                } else {
                    am.setViewTextColor(this.csn, (int) R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0470d extends a {
        TbImageView ePb;
        LinearLayout hzY;

        public C0470d(View view) {
            super();
            this.hzU = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.fYl = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.csn = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.hzV = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.hzY = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.hzR = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.eMu = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.hzR);
            this.ePb = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.hzS = (TextView) view.findViewById(R.id.markitem_state_text);
            this.hzQ = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.hzT = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.hzW = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.bhm = view.findViewById(R.id.text_divider);
            d(this.fYl);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hzV.getLayoutParams();
            if (i.agq().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.ePb.setVisibility(0);
                    this.ePb.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.hzI;
            } else {
                this.ePb.setVisibility(8);
                layoutParams.bottomMargin = d.hzJ;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hzY.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.hzF;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
    private class c extends a {
        OriginalThreadCardView Hn;

        public c(View view) {
            super();
            this.hzU = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.hzQ = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.fYl = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.csn = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.hzR = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.eMu = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.hzR);
            this.hzV = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.Hn = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.hzS = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.hzT = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.hzW = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.bhm = view.findViewById(R.id.share_text_divider);
            d(this.fYl);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.Hn.b(markData.getOriginalThreadInfo());
            this.Hn.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Hn.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.hzF;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
    private class b {
        TextView hzX;
        ProgressBar mProgress;

        private b() {
        }
    }
}
