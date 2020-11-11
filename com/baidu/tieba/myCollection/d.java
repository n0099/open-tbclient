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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class d extends BaseAdapter {
    private static final float kZV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float kZW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float kZX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int kZY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int kZZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> eIM = new ArrayList<>();
    private boolean fRb = false;
    private View.OnClickListener laa = null;
    private View.OnClickListener lab = null;
    private View.OnClickListener lac = null;
    private boolean lad = false;
    private boolean hasMore = true;
    private boolean lae = true;
    private final View.OnClickListener ajG = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            aq aqVar = new aq("c12529");
            if (view instanceof CommonUserLikeButton) {
                aqVar.al("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                aqVar.al("obj_locate", 1);
            }
            aqVar.dR("tid", item.getId());
            aqVar.dR("obj_id", item.getUesrId());
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
        this.lad = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.eIM.clear();
        if (arrayList != null) {
            this.eIM.addAll(arrayList);
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
        if (y.isEmpty(this.eIM)) {
            return 0;
        }
        return this.lae ? y.getCount(this.eIM) + 1 : y.getCount(this.eIM);
    }

    public void tr(boolean z) {
        this.lae = z;
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
    /* renamed from: EW */
    public MarkData getItem(int i) {
        return (MarkData) y.getItem(this.eIM, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (y.getCount(this.eIM) <= i) {
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
        C0794d c0794d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0794d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0794d c0794d2 = new C0794d(view);
                    view.setTag(c0794d2);
                    c0794d = c0794d2;
                } else {
                    c0794d = (C0794d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0794d.lag.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0794d.lak.getLayoutParams();
                    if (this.fRb) {
                        c0794d.lag.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0794d.lag.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0794d.b(item);
                    a(i, c0794d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.lan = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.lan.setVisibility(0);
                if (this.lad) {
                    bVar.mProgress.setVisibility(0);
                    bVar.lan.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.lan, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.lan.setText(this.mPageContext.getString(R.string.no_more_mark));
                    ap.setViewTextColor(bVar.lan, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.lan.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.lan, R.color.common_color_10039, 1);
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
                    cVar.lag.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.lak.getLayoutParams();
                    if (this.fRb) {
                        cVar.lag.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.lag.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.aij.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new aq("c12529").al("obj_locate", 5));
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
        if (y.isEmpty(this.eIM) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void lj(boolean z) {
        this.fRb = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.lal.setOnClickListener(this.lab);
        aVar.lal.setTag(valueOf);
        aVar.jpv.setAfterClickListener(this.ajG);
        aVar.jpv.setTag(valueOf);
        aVar.lah.setAfterOnClickListener(this.ajG);
        aVar.lah.setTag(valueOf);
        aVar.lam.setOnClickListener(this.lac);
        aVar.lam.setTag(valueOf);
        aVar.lag.setOnClickListener(this.laa);
        aVar.lag.setFocusable(false);
        aVar.lag.setTag(valueOf);
    }

    public void N(View.OnClickListener onClickListener) {
        this.laa = onClickListener;
    }

    public void O(View.OnClickListener onClickListener) {
        this.lab = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.lac = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajW;
        TextView ewx;
        ClickableHeaderImageView jpv;
        ImageButton lag;
        CommonUserLikeButton lah;
        TextView lai;
        ImageView laj;
        LinearLayout lak;
        LinearLayout lal;
        LinearLayout lam;
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
                clickableHeaderImageView.setAfterClickListener(d.this.ajG);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.kZV);
                        ap.setViewTextColor(this.mTitle, R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.kZW);
                        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.jpv.setData(markData.metaData);
                this.jpv.setShowV(markData.metaData.isBigV());
                this.ajW.a(markData.metaData);
                this.lah.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.lah.setTextSize(0, d.kZX);
                if ((markData.metaData.getIsLike() || at.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.lah.setVisibility(8);
                } else {
                    this.lah.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.lam.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.laj.setVisibility(0);
                    } else {
                        this.laj.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.lai.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.lai.setText(markData.getmState());
                    }
                    ap.setViewTextColor(this.lai, R.color.cp_cont_d);
                } else {
                    this.lam.setVisibility(8);
                }
                ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.ewx.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    ap.setViewTextColor(this.ewx, R.color.cp_cont_h);
                } else {
                    ap.setViewTextColor(this.ewx, R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private class C0794d extends a {
        TbImageView iaa;
        LinearLayout lao;

        public C0794d(View view) {
            super();
            this.lak = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.jpv = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.ewx = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.lal = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.lao = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.lah = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.ajW = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.lah);
            this.iaa = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.lai = (TextView) view.findViewById(R.id.markitem_state_text);
            this.lag = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.laj = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.lam = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.mDivider = view.findViewById(R.id.text_divider);
            d(this.jpv);
            this.iaa.setPlaceHolder(2);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lal.getLayoutParams();
            if (k.bjH().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.iaa.setVisibility(0);
                    this.iaa.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.kZY;
            } else {
                this.iaa.setVisibility(8);
                layoutParams.bottomMargin = d.kZZ;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lao.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.kZV;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes24.dex */
    private class c extends a {
        OriginalThreadCardView aij;

        public c(View view) {
            super();
            this.lak = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.lag = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.jpv = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.ewx = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.lah = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.ajW = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.lah);
            this.lal = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.aij = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.lai = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.laj = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.lam = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.mDivider = view.findViewById(R.id.share_text_divider);
            d(this.jpv);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.aij.b(markData.getOriginalThreadInfo());
            this.aij.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aij.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.kZV;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes24.dex */
    private class b {
        TextView lan;
        ProgressBar mProgress;

        private b() {
        }
    }
}
