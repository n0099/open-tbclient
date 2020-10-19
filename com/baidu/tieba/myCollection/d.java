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
    private static final float kHC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float kHD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float kHE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int kHF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int kHG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> euy = new ArrayList<>();
    private boolean fCQ = false;
    private View.OnClickListener kHH = null;
    private View.OnClickListener kHI = null;
    private View.OnClickListener kHJ = null;
    private boolean kHK = false;
    private boolean hasMore = true;
    private boolean kHL = true;
    private final View.OnClickListener ajF = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            aq aqVar = new aq("c12529");
            if (view instanceof CommonUserLikeButton) {
                aqVar.aj("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                aqVar.aj("obj_locate", 1);
            }
            aqVar.dK("tid", item.getId());
            aqVar.dK("obj_id", item.getUesrId());
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
        this.kHK = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.euy.clear();
        if (arrayList != null) {
            this.euy.addAll(arrayList);
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
        if (y.isEmpty(this.euy)) {
            return 0;
        }
        return this.kHL ? y.getCount(this.euy) + 1 : y.getCount(this.euy);
    }

    public void sR(boolean z) {
        this.kHL = z;
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
    /* renamed from: Eq */
    public MarkData getItem(int i) {
        return (MarkData) y.getItem(this.euy, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (y.getCount(this.euy) <= i) {
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
        C0764d c0764d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0764d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0764d c0764d2 = new C0764d(view);
                    view.setTag(c0764d2);
                    c0764d = c0764d2;
                } else {
                    c0764d = (C0764d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0764d.kHN.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0764d.kHR.getLayoutParams();
                    if (this.fCQ) {
                        c0764d.kHN.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0764d.kHN.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0764d.b(item);
                    a(i, c0764d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.kHU = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.kHU.setVisibility(0);
                if (this.kHK) {
                    bVar.mProgress.setVisibility(0);
                    bVar.kHU.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.kHU, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.kHU.setText(this.mPageContext.getString(R.string.no_more_mark));
                    ap.setViewTextColor(bVar.kHU, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.kHU.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.kHU, R.color.common_color_10039, 1);
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
                    cVar.kHN.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.kHR.getLayoutParams();
                    if (this.fCQ) {
                        cVar.kHN.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.kHN.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.aii.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new aq("c12529").aj("obj_locate", 5));
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
        if (y.isEmpty(this.euy) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void kN(boolean z) {
        this.fCQ = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.kHS.setOnClickListener(this.kHI);
        aVar.kHS.setTag(valueOf);
        aVar.iXa.setAfterClickListener(this.ajF);
        aVar.iXa.setTag(valueOf);
        aVar.kHO.setAfterOnClickListener(this.ajF);
        aVar.kHO.setTag(valueOf);
        aVar.kHT.setOnClickListener(this.kHJ);
        aVar.kHT.setTag(valueOf);
        aVar.kHN.setOnClickListener(this.kHH);
        aVar.kHN.setFocusable(false);
        aVar.kHN.setTag(valueOf);
    }

    public void M(View.OnClickListener onClickListener) {
        this.kHH = onClickListener;
    }

    public void N(View.OnClickListener onClickListener) {
        this.kHI = onClickListener;
    }

    public void O(View.OnClickListener onClickListener) {
        this.kHJ = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajV;
        TextView eig;
        ClickableHeaderImageView iXa;
        ImageButton kHN;
        CommonUserLikeButton kHO;
        TextView kHP;
        ImageView kHQ;
        LinearLayout kHR;
        LinearLayout kHS;
        LinearLayout kHT;
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
                clickableHeaderImageView.setAfterClickListener(d.this.ajF);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.kHC);
                        ap.setViewTextColor(this.mTitle, R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.kHD);
                        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.iXa.setData(markData.metaData);
                this.iXa.setShowV(markData.metaData.isBigV());
                this.ajV.a(markData.metaData);
                this.kHO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.kHO.setTextSize(0, d.kHE);
                if ((markData.metaData.getIsLike() || at.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.kHO.setVisibility(8);
                } else {
                    this.kHO.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.kHT.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.kHQ.setVisibility(0);
                    } else {
                        this.kHQ.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.kHP.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.kHP.setText(markData.getmState());
                    }
                    ap.setViewTextColor(this.kHP, R.color.cp_cont_d);
                } else {
                    this.kHT.setVisibility(8);
                }
                ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.eig.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    ap.setViewTextColor(this.eig, R.color.cp_cont_h);
                } else {
                    ap.setViewTextColor(this.eig, R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private class C0764d extends a {
        TbImageView hHG;
        LinearLayout kHV;

        public C0764d(View view) {
            super();
            this.kHR = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.iXa = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.eig = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.kHS = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.kHV = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.kHO = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.ajV = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.kHO);
            this.hHG = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.kHP = (TextView) view.findViewById(R.id.markitem_state_text);
            this.kHN = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.kHQ = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.kHT = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.mDivider = view.findViewById(R.id.text_divider);
            d(this.iXa);
            this.hHG.setPlaceHolder(2);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kHS.getLayoutParams();
            if (k.bfo().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.hHG.setVisibility(0);
                    this.hHG.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.kHF;
            } else {
                this.hHG.setVisibility(8);
                layoutParams.bottomMargin = d.kHG;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kHV.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.kHC;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes24.dex */
    private class c extends a {
        OriginalThreadCardView aii;

        public c(View view) {
            super();
            this.kHR = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.kHN = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.iXa = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.eig = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.kHO = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.ajV = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.kHO);
            this.kHS = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.aii = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.kHP = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.kHQ = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.kHT = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.mDivider = view.findViewById(R.id.share_text_divider);
            d(this.iXa);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.aii.b(markData.getOriginalThreadInfo());
            this.aii.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aii.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.kHC;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes24.dex */
    private class b {
        TextView kHU;
        ProgressBar mProgress;

        private b() {
        }
    }
}
