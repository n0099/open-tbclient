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
/* loaded from: classes9.dex */
public class d extends BaseAdapter {
    private TbPageContext<?> mPageContext;
    private static final float iqw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float iqx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float iqy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int iqz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int iqA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private final ArrayList<MarkData> cRO = new ArrayList<>();
    private boolean dTR = false;
    private View.OnClickListener iqB = null;
    private View.OnClickListener iqC = null;
    private View.OnClickListener iqD = null;
    private boolean iqE = false;
    private boolean hasMore = true;
    private boolean iqF = true;
    private final View.OnClickListener MX = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            an anVar = new an("c12529");
            if (view instanceof CommonUserLikeButton) {
                anVar.Z("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                anVar.Z("obj_locate", 1);
            }
            anVar.cp("tid", item.getId());
            anVar.cp("obj_id", item.getUesrId());
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
        this.iqE = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.cRO.clear();
        if (arrayList != null) {
            this.cRO.addAll(arrayList);
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
        if (v.isEmpty(this.cRO)) {
            return 0;
        }
        return this.iqF ? v.getCount(this.cRO) + 1 : v.getCount(this.cRO);
    }

    public void oV(boolean z) {
        this.iqF = z;
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
    /* renamed from: yf */
    public MarkData getItem(int i) {
        return (MarkData) v.getItem(this.cRO, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.getCount(this.cRO) <= i) {
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
        C0556d c0556d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0556d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0556d c0556d2 = new C0556d(view);
                    view.setTag(c0556d2);
                    c0556d = c0556d2;
                } else {
                    c0556d = (C0556d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0556d.iqH.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0556d.iqL.getLayoutParams();
                    if (this.dTR) {
                        c0556d.iqH.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0556d.iqH.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0556d.b(item);
                    a(i, c0556d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.iqO = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.iqO.setVisibility(0);
                if (this.iqE) {
                    bVar.mProgress.setVisibility(0);
                    bVar.iqO.setText(this.mPageContext.getString(R.string.loading));
                    am.setViewTextColor(bVar.iqO, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.iqO.setText(this.mPageContext.getString(R.string.no_more_mark));
                    am.setViewTextColor(bVar.iqO, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.iqO.setText(this.mPageContext.getString(R.string.loading));
                    am.setViewTextColor(bVar.iqO, R.color.common_color_10039, 1);
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
                    cVar.iqH.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.iqL.getLayoutParams();
                    if (this.dTR) {
                        cVar.iqH.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.iqH.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.LX.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new an("c12529").Z("obj_locate", 5));
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
        if (v.isEmpty(this.cRO) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void hv(boolean z) {
        this.dTR = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.iqM.setOnClickListener(this.iqC);
        aVar.iqM.setTag(valueOf);
        aVar.gPn.setAfterClickListener(this.MX);
        aVar.gPn.setTag(valueOf);
        aVar.iqI.setAfterOnClickListener(this.MX);
        aVar.iqI.setTag(valueOf);
        aVar.iqN.setOnClickListener(this.iqD);
        aVar.iqN.setTag(valueOf);
        aVar.iqH.setOnClickListener(this.iqB);
        aVar.iqH.setFocusable(false);
        aVar.iqH.setTag(valueOf);
    }

    public void I(View.OnClickListener onClickListener) {
        this.iqB = onClickListener;
    }

    public void J(View.OnClickListener onClickListener) {
        this.iqC = onClickListener;
    }

    public void K(View.OnClickListener onClickListener) {
        this.iqD = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c Nb;
        TextView bXF;
        ClickableHeaderImageView gPn;
        ImageButton iqH;
        CommonUserLikeButton iqI;
        TextView iqJ;
        ImageView iqK;
        LinearLayout iqL;
        LinearLayout iqM;
        LinearLayout iqN;
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
                clickableHeaderImageView.setAfterClickListener(d.this.MX);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.iqw);
                        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.iqx);
                        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.gPn.setData(markData.metaData);
                this.gPn.setShowV(markData.metaData.isBigV());
                this.Nb.a(markData.metaData);
                this.iqI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.iqI.setTextSize(0, d.iqy);
                if ((markData.metaData.getIsLike() || aq.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.iqI.setVisibility(8);
                } else {
                    this.iqI.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.iqN.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.iqK.setVisibility(0);
                    } else {
                        this.iqK.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.iqJ.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.iqJ.setText(markData.getmState());
                    }
                    am.setViewTextColor(this.iqJ, (int) R.color.cp_cont_d);
                } else {
                    this.iqN.setVisibility(8);
                }
                am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.bXF.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    am.setViewTextColor(this.bXF, (int) R.color.cp_cont_h);
                } else {
                    am.setViewTextColor(this.bXF, (int) R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private class C0556d extends a {
        TbImageView fJh;
        LinearLayout iqP;

        public C0556d(View view) {
            super();
            this.iqL = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.gPn = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.bXF = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.iqM = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.iqP = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.iqI = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.Nb = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.iqI);
            this.fJh = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.iqJ = (TextView) view.findViewById(R.id.markitem_state_text);
            this.iqH = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.iqK = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.iqN = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.mDivider = view.findViewById(R.id.text_divider);
            d(this.gPn);
            this.fJh.setPlaceHolder(2);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iqM.getLayoutParams();
            if (i.axy().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.fJh.setVisibility(0);
                    this.fJh.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.iqz;
            } else {
                this.fJh.setVisibility(8);
                layoutParams.bottomMargin = d.iqA;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iqP.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.iqw;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes9.dex */
    private class c extends a {
        OriginalThreadCardView LX;

        public c(View view) {
            super();
            this.iqL = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.iqH = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.gPn = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.bXF = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.iqI = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.Nb = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.iqI);
            this.iqM = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.LX = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.iqJ = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.iqK = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.iqN = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.mDivider = view.findViewById(R.id.share_text_divider);
            d(this.gPn);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.LX.b(markData.getOriginalThreadInfo());
            this.LX.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.LX.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.iqw;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes9.dex */
    private class b {
        TextView iqO;
        ProgressBar mProgress;

        private b() {
        }
    }
}
