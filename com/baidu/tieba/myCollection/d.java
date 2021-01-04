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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    private static final float lte = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float ltf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float ltg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int lth = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int lti = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> eYq = new ArrayList<>();
    private boolean giC = false;
    private View.OnClickListener ltj = null;
    private View.OnClickListener ltk = null;
    private View.OnClickListener ltl = null;
    private boolean ltm = false;
    private boolean hasMore = true;
    private boolean ltn = true;
    private final View.OnClickListener alk = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            aq aqVar = new aq("c12529");
            if (view instanceof CommonUserLikeButton) {
                aqVar.an("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                aqVar.an("obj_locate", 1);
            }
            aqVar.dX("tid", item.getId());
            aqVar.dX("obj_id", item.getUesrId());
            TiebaStatic.log(aqVar);
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setRefreshing(boolean z) {
        this.ltm = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.eYq.clear();
        if (arrayList != null) {
            this.eYq.addAll(arrayList);
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
        if (x.isEmpty(this.eYq)) {
            return 0;
        }
        return this.ltn ? x.getCount(this.eYq) + 1 : x.getCount(this.eYq);
    }

    public void tX(boolean z) {
        this.ltn = z;
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
    /* renamed from: Gb */
    public MarkData getItem(int i) {
        return (MarkData) x.getItem(this.eYq, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (x.getCount(this.eYq) <= i) {
            return -1L;
        }
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001c  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        c cVar;
        C0796d c0796d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0796d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0796d c0796d2 = new C0796d(view);
                    view.setTag(c0796d2);
                    c0796d = c0796d2;
                } else {
                    c0796d = (C0796d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0796d.ltp.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0796d.ltu.getLayoutParams();
                    if (this.giC) {
                        c0796d.ltp.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0796d.ltp.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0796d.b(item);
                    a(i, c0796d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.ltx = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.ltx.setVisibility(0);
                if (this.ltm) {
                    bVar.mProgress.setVisibility(0);
                    bVar.ltx.setText(this.mPageContext.getString(R.string.loading));
                    ao.setViewTextColor(bVar.ltx, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.ltx.setText(this.mPageContext.getString(R.string.no_more_mark));
                    ao.setViewTextColor(bVar.ltx, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.ltx.setText(this.mPageContext.getString(R.string.loading));
                    ao.setViewTextColor(bVar.ltx, R.color.common_color_10039, 1);
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
                    cVar.ltp.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.ltu.getLayoutParams();
                    if (this.giC) {
                        cVar.ltp.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.ltp.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.ajX.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new aq("c12529").an("obj_locate", 5));
                        }
                    });
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            default:
                this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                this.mPageContext.getLayoutMode().onModeChanged(view);
                break;
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (x.isEmpty(this.eYq) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void mc(boolean z) {
        this.giC = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.ltv.setOnClickListener(this.ltk);
        aVar.ltv.setTag(valueOf);
        aVar.jQg.setAfterClickListener(this.alk);
        aVar.jQg.setTag(valueOf);
        aVar.ltq.setAfterOnClickListener(this.alk);
        aVar.ltq.setTag(valueOf);
        aVar.ltw.setOnClickListener(this.ltl);
        aVar.ltw.setTag(valueOf);
        aVar.ltp.setOnClickListener(this.ltj);
        aVar.ltp.setFocusable(false);
        aVar.ltp.setTag(valueOf);
    }

    public void O(View.OnClickListener onClickListener) {
        this.ltj = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.ltk = onClickListener;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.ltl = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c alC;
        View dDI;
        TextView eLt;
        ClickableHeaderImageView jQg;
        ImageButton ltp;
        CommonUserLikeButton ltq;
        TextView lts;
        ImageView ltt;
        LinearLayout ltu;
        LinearLayout ltv;
        LinearLayout ltw;
        TextView mTitle;

        private a() {
        }

        void d(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setPlaceHolder(1);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(d.this.alk);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.lte);
                        ao.setViewTextColor(this.mTitle, R.color.CAM_X0110);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.ltf);
                        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.jQg.setData(markData.metaData);
                this.jQg.setShowV(markData.metaData.isBigV());
                this.alC.a(markData.metaData);
                this.ltq.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.ltq.setTextSize(0, d.ltg);
                if ((markData.metaData.getIsLike() || at.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.ltq.setVisibility(8);
                } else {
                    this.ltq.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.ltw.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.ltt.setVisibility(0);
                    } else {
                        this.ltt.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.lts.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.lts.setText(markData.getmState());
                    }
                    ao.setViewTextColor(this.lts, R.color.CAM_X0109);
                } else {
                    this.ltw.setVisibility(8);
                }
                ao.setBackgroundColor(this.dDI, R.color.CAM_X0204);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.eLt.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    ao.setViewTextColor(this.eLt, R.color.CAM_X0301);
                } else {
                    ao.setViewTextColor(this.eLt, R.color.CAM_X0106);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0796d extends a {
        TbImageView ixU;
        LinearLayout lty;

        public C0796d(View view) {
            super();
            this.ltu = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.jQg = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.eLt = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.ltv = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.lty = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.ltq = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.alC = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.ltq);
            this.ixU = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.lts = (TextView) view.findViewById(R.id.markitem_state_text);
            this.ltp = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.ltt = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.ltw = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.dDI = view.findViewById(R.id.text_divider);
            d(this.jQg);
            this.ixU.setPlaceHolder(1);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ltv.getLayoutParams();
            if (k.bou().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.ixU.setVisibility(0);
                    this.ixU.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.lth;
            } else {
                this.ixU.setVisibility(8);
                layoutParams.bottomMargin = d.lti;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lty.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.lte;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes8.dex */
    private class c extends a {
        OriginalThreadCardView ajX;

        public c(View view) {
            super();
            this.ltu = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.ltp = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.jQg = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.eLt = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.ltq = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.alC = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.ltq);
            this.ltv = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.ajX = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.lts = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.ltt = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.ltw = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.dDI = view.findViewById(R.id.share_text_divider);
            d(this.jQg);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.ajX.b(markData.getOriginalThreadInfo());
            this.ajX.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajX.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.lte;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes8.dex */
    private class b {
        TextView ltx;
        ProgressBar mProgress;

        private b() {
        }
    }
}
