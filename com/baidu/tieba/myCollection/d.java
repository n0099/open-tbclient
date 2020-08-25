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
/* loaded from: classes18.dex */
public class d extends BaseAdapter {
    private static final float kjK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float kjL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float kjM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int kjN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int kjO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> efX = new ArrayList<>();
    private boolean fnu = false;
    private View.OnClickListener kjP = null;
    private View.OnClickListener kjQ = null;
    private View.OnClickListener kjR = null;
    private boolean kjS = false;
    private boolean hasMore = true;
    private boolean kjT = true;
    private final View.OnClickListener aiR = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            aq aqVar = new aq("c12529");
            if (view instanceof CommonUserLikeButton) {
                aqVar.ai("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                aqVar.ai("obj_locate", 1);
            }
            aqVar.dD("tid", item.getId());
            aqVar.dD("obj_id", item.getUesrId());
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
        this.kjS = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.efX.clear();
        if (arrayList != null) {
            this.efX.addAll(arrayList);
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
        if (y.isEmpty(this.efX)) {
            return 0;
        }
        return this.kjT ? y.getCount(this.efX) + 1 : y.getCount(this.efX);
    }

    public void sa(boolean z) {
        this.kjT = z;
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
    /* renamed from: Dj */
    public MarkData getItem(int i) {
        return (MarkData) y.getItem(this.efX, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (y.getCount(this.efX) <= i) {
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
        C0749d c0749d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0749d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0749d c0749d2 = new C0749d(view);
                    view.setTag(c0749d2);
                    c0749d = c0749d2;
                } else {
                    c0749d = (C0749d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0749d.kjV.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0749d.kjZ.getLayoutParams();
                    if (this.fnu) {
                        c0749d.kjV.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0749d.kjV.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0749d.b(item);
                    a(i, c0749d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.kkc = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.kkc.setVisibility(0);
                if (this.kjS) {
                    bVar.mProgress.setVisibility(0);
                    bVar.kkc.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.kkc, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.kkc.setText(this.mPageContext.getString(R.string.no_more_mark));
                    ap.setViewTextColor(bVar.kkc, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.kkc.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.kkc, R.color.common_color_10039, 1);
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
                    cVar.kjV.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.kjZ.getLayoutParams();
                    if (this.fnu) {
                        cVar.kjV.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.kjV.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.ahu.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new aq("c12529").ai("obj_locate", 5));
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
        if (y.isEmpty(this.efX) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void km(boolean z) {
        this.fnu = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.kka.setOnClickListener(this.kjQ);
        aVar.kka.setTag(valueOf);
        aVar.iAH.setAfterClickListener(this.aiR);
        aVar.iAH.setTag(valueOf);
        aVar.kjW.setAfterOnClickListener(this.aiR);
        aVar.kjW.setTag(valueOf);
        aVar.kkb.setOnClickListener(this.kjR);
        aVar.kkb.setTag(valueOf);
        aVar.kjV.setOnClickListener(this.kjP);
        aVar.kjV.setFocusable(false);
        aVar.kjV.setTag(valueOf);
    }

    public void M(View.OnClickListener onClickListener) {
        this.kjP = onClickListener;
    }

    public void N(View.OnClickListener onClickListener) {
        this.kjQ = onClickListener;
    }

    public void O(View.OnClickListener onClickListener) {
        this.kjR = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajc;
        TextView dTQ;
        ClickableHeaderImageView iAH;
        ImageButton kjV;
        CommonUserLikeButton kjW;
        TextView kjX;
        ImageView kjY;
        LinearLayout kjZ;
        LinearLayout kka;
        LinearLayout kkb;
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
                clickableHeaderImageView.setAfterClickListener(d.this.aiR);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.kjK);
                        ap.setViewTextColor(this.mTitle, R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.kjL);
                        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.iAH.setData(markData.metaData);
                this.iAH.setShowV(markData.metaData.isBigV());
                this.ajc.a(markData.metaData);
                this.kjW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.kjW.setTextSize(0, d.kjM);
                if ((markData.metaData.getIsLike() || at.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.kjW.setVisibility(8);
                } else {
                    this.kjW.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.kkb.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.kjY.setVisibility(0);
                    } else {
                        this.kjY.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.kjX.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.kjX.setText(markData.getmState());
                    }
                    ap.setViewTextColor(this.kjX, R.color.cp_cont_d);
                } else {
                    this.kkb.setVisibility(8);
                }
                ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.dTQ.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    ap.setViewTextColor(this.dTQ, R.color.cp_cont_h);
                } else {
                    ap.setViewTextColor(this.dTQ, R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private class C0749d extends a {
        TbImageView hlF;
        LinearLayout kkd;

        public C0749d(View view) {
            super();
            this.kjZ = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.iAH = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.dTQ = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.kka = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.kkd = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.kjW = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.ajc = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.kjW);
            this.hlF = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.kjX = (TextView) view.findViewById(R.id.markitem_state_text);
            this.kjV = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.kjY = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.kkb = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.mDivider = view.findViewById(R.id.text_divider);
            d(this.iAH);
            this.hlF.setPlaceHolder(2);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kka.getLayoutParams();
            if (k.bbM().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.hlF.setVisibility(0);
                    this.hlF.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.kjN;
            } else {
                this.hlF.setVisibility(8);
                layoutParams.bottomMargin = d.kjO;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kkd.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.kjK;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes18.dex */
    private class c extends a {
        OriginalThreadCardView ahu;

        public c(View view) {
            super();
            this.kjZ = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.kjV = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.iAH = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.dTQ = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.kjW = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.ajc = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.kjW);
            this.kka = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.ahu = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.kjX = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.kjY = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.kkb = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.mDivider = view.findViewById(R.id.share_text_divider);
            d(this.iAH);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.ahu.b(markData.getOriginalThreadInfo());
            this.ahu.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahu.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.kjK;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes18.dex */
    private class b {
        TextView kkc;
        ProgressBar mProgress;

        private b() {
        }
    }
}
