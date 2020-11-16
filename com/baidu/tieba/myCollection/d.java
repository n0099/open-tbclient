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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class d extends BaseAdapter {
    private static final float lao = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float lap = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float laq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int lar = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int las = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> eHj = new ArrayList<>();
    private boolean fQK = false;
    private View.OnClickListener lau = null;
    private View.OnClickListener lav = null;
    private View.OnClickListener law = null;
    private boolean lax = false;
    private boolean hasMore = true;
    private boolean lay = true;
    private final View.OnClickListener ajJ = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            ar arVar = new ar("c12529");
            if (view instanceof CommonUserLikeButton) {
                arVar.ak("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                arVar.ak("obj_locate", 1);
            }
            arVar.dR("tid", item.getId());
            arVar.dR("obj_id", item.getUesrId());
            TiebaStatic.log(arVar);
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setRefreshing(boolean z) {
        this.lax = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.eHj.clear();
        if (arrayList != null) {
            this.eHj.addAll(arrayList);
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
        if (y.isEmpty(this.eHj)) {
            return 0;
        }
        return this.lay ? y.getCount(this.eHj) + 1 : y.getCount(this.eHj);
    }

    public void tu(boolean z) {
        this.lay = z;
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
    /* renamed from: Fu */
    public MarkData getItem(int i) {
        return (MarkData) y.getItem(this.eHj, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (y.getCount(this.eHj) <= i) {
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
                    c0796d.laA.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0796d.laE.getLayoutParams();
                    if (this.fQK) {
                        c0796d.laA.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0796d.laA.setVisibility(8);
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
                    bVar2.laH = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.laH.setVisibility(0);
                if (this.lax) {
                    bVar.mProgress.setVisibility(0);
                    bVar.laH.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.laH, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.laH.setText(this.mPageContext.getString(R.string.no_more_mark));
                    ap.setViewTextColor(bVar.laH, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.laH.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.laH, R.color.common_color_10039, 1);
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
                    cVar.laA.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.laE.getLayoutParams();
                    if (this.fQK) {
                        cVar.laA.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.laA.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.aim.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new ar("c12529").ak("obj_locate", 5));
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
        if (y.isEmpty(this.eHj) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void lk(boolean z) {
        this.fQK = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.laF.setOnClickListener(this.lav);
        aVar.laF.setTag(valueOf);
        aVar.jqc.setAfterClickListener(this.ajJ);
        aVar.jqc.setTag(valueOf);
        aVar.laB.setAfterOnClickListener(this.ajJ);
        aVar.laB.setTag(valueOf);
        aVar.laG.setOnClickListener(this.law);
        aVar.laG.setTag(valueOf);
        aVar.laA.setOnClickListener(this.lau);
        aVar.laA.setFocusable(false);
        aVar.laA.setTag(valueOf);
    }

    public void M(View.OnClickListener onClickListener) {
        this.lau = onClickListener;
    }

    public void N(View.OnClickListener onClickListener) {
        this.lav = onClickListener;
    }

    public void O(View.OnClickListener onClickListener) {
        this.law = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajZ;
        TextView euO;
        ClickableHeaderImageView jqc;
        ImageButton laA;
        CommonUserLikeButton laB;
        TextView laC;
        ImageView laD;
        LinearLayout laE;
        LinearLayout laF;
        LinearLayout laG;
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
                clickableHeaderImageView.setAfterClickListener(d.this.ajJ);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.lao);
                        ap.setViewTextColor(this.mTitle, R.color.CAM_X0110);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.lap);
                        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.jqc.setData(markData.metaData);
                this.jqc.setShowV(markData.metaData.isBigV());
                this.ajZ.a(markData.metaData);
                this.laB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.laB.setTextSize(0, d.laq);
                if ((markData.metaData.getIsLike() || au.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.laB.setVisibility(8);
                } else {
                    this.laB.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.laG.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.laD.setVisibility(0);
                    } else {
                        this.laD.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.laC.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.laC.setText(markData.getmState());
                    }
                    ap.setViewTextColor(this.laC, R.color.CAM_X0109);
                } else {
                    this.laG.setVisibility(8);
                }
                ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.euO.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    ap.setViewTextColor(this.euO, R.color.CAM_X0301);
                } else {
                    ap.setViewTextColor(this.euO, R.color.CAM_X0106);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private class C0796d extends a {
        TbImageView iaB;
        LinearLayout laI;

        public C0796d(View view) {
            super();
            this.laE = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.jqc = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.euO = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.laF = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.laI = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.laB = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.ajZ = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.laB);
            this.iaB = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.laC = (TextView) view.findViewById(R.id.markitem_state_text);
            this.laA = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.laD = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.laG = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.mDivider = view.findViewById(R.id.text_divider);
            d(this.jqc);
            this.iaB.setPlaceHolder(1);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.laF.getLayoutParams();
            if (k.biL().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.iaB.setVisibility(0);
                    this.iaB.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.lar;
            } else {
                this.iaB.setVisibility(8);
                layoutParams.bottomMargin = d.las;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.laI.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.lao;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes23.dex */
    private class c extends a {
        OriginalThreadCardView aim;

        public c(View view) {
            super();
            this.laE = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.laA = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.jqc = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.euO = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.laB = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.ajZ = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.laB);
            this.laF = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.aim = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.laC = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.laD = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.laG = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.mDivider = view.findViewById(R.id.share_text_divider);
            d(this.jqc);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.aim.b(markData.getOriginalThreadInfo());
            this.aim.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aim.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.lao;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes23.dex */
    private class b {
        TextView laH;
        ProgressBar mProgress;

        private b() {
        }
    }
}
