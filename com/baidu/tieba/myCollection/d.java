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
/* loaded from: classes24.dex */
public class d extends BaseAdapter {
    private static final float lnL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float lnM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float lnN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int lnO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int lnP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> eOt = new ArrayList<>();
    private boolean fYT = false;
    private View.OnClickListener lnQ = null;
    private View.OnClickListener lnR = null;
    private View.OnClickListener lnS = null;
    private boolean lnT = false;
    private boolean hasMore = true;
    private boolean lnU = true;
    private final View.OnClickListener akI = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            ar arVar = new ar("c12529");
            if (view instanceof CommonUserLikeButton) {
                arVar.al("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                arVar.al("obj_locate", 1);
            }
            arVar.dY("tid", item.getId());
            arVar.dY("obj_id", item.getUesrId());
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
        this.lnT = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.eOt.clear();
        if (arrayList != null) {
            this.eOt.addAll(arrayList);
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
        if (y.isEmpty(this.eOt)) {
            return 0;
        }
        return this.lnU ? y.getCount(this.eOt) + 1 : y.getCount(this.eOt);
    }

    public void tW(boolean z) {
        this.lnU = z;
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
    /* renamed from: Gj */
    public MarkData getItem(int i) {
        return (MarkData) y.getItem(this.eOt, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (y.getCount(this.eOt) <= i) {
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
        C0812d c0812d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0812d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0812d c0812d2 = new C0812d(view);
                    view.setTag(c0812d2);
                    c0812d = c0812d2;
                } else {
                    c0812d = (C0812d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0812d.lnW.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0812d.loa.getLayoutParams();
                    if (this.fYT) {
                        c0812d.lnW.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0812d.lnW.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0812d.b(item);
                    a(i, c0812d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.loe = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.loe.setVisibility(0);
                if (this.lnT) {
                    bVar.mProgress.setVisibility(0);
                    bVar.loe.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.loe, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.loe.setText(this.mPageContext.getString(R.string.no_more_mark));
                    ap.setViewTextColor(bVar.loe, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.loe.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.loe, R.color.common_color_10039, 1);
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
                    cVar.lnW.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.loa.getLayoutParams();
                    if (this.fYT) {
                        cVar.lnW.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.lnW.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.ajl.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new ar("c12529").al("obj_locate", 5));
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
        if (y.isEmpty(this.eOt) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void lF(boolean z) {
        this.fYT = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.lob.setOnClickListener(this.lnR);
        aVar.lob.setTag(valueOf);
        aVar.jDC.setAfterClickListener(this.akI);
        aVar.jDC.setTag(valueOf);
        aVar.lnX.setAfterOnClickListener(this.akI);
        aVar.lnX.setTag(valueOf);
        aVar.lod.setOnClickListener(this.lnS);
        aVar.lod.setTag(valueOf);
        aVar.lnW.setOnClickListener(this.lnQ);
        aVar.lnW.setFocusable(false);
        aVar.lnW.setTag(valueOf);
    }

    public void M(View.OnClickListener onClickListener) {
        this.lnQ = onClickListener;
    }

    public void N(View.OnClickListener onClickListener) {
        this.lnR = onClickListener;
    }

    public void O(View.OnClickListener onClickListener) {
        this.lnS = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c akZ;
        TextView eBQ;
        ClickableHeaderImageView jDC;
        ImageButton lnW;
        CommonUserLikeButton lnX;
        TextView lnY;
        ImageView lnZ;
        LinearLayout loa;
        LinearLayout lob;
        LinearLayout lod;
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
                clickableHeaderImageView.setAfterClickListener(d.this.akI);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.lnL);
                        ap.setViewTextColor(this.mTitle, R.color.CAM_X0110);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.lnM);
                        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.jDC.setData(markData.metaData);
                this.jDC.setShowV(markData.metaData.isBigV());
                this.akZ.a(markData.metaData);
                this.lnX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.lnX.setTextSize(0, d.lnN);
                if ((markData.metaData.getIsLike() || au.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.lnX.setVisibility(8);
                } else {
                    this.lnX.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.lod.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.lnZ.setVisibility(0);
                    } else {
                        this.lnZ.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.lnY.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.lnY.setText(markData.getmState());
                    }
                    ap.setViewTextColor(this.lnY, R.color.CAM_X0109);
                } else {
                    this.lod.setVisibility(8);
                }
                ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.eBQ.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    ap.setViewTextColor(this.eBQ, R.color.CAM_X0301);
                } else {
                    ap.setViewTextColor(this.eBQ, R.color.CAM_X0106);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private class C0812d extends a {
        TbImageView ilx;
        LinearLayout lof;

        public C0812d(View view) {
            super();
            this.loa = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.jDC = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.eBQ = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.lob = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.lof = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.lnX = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.akZ = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.lnX);
            this.ilx = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.lnY = (TextView) view.findViewById(R.id.markitem_state_text);
            this.lnW = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.lnZ = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.lod = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.mDivider = view.findViewById(R.id.text_divider);
            d(this.jDC);
            this.ilx.setPlaceHolder(1);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lob.getLayoutParams();
            if (k.blV().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.ilx.setVisibility(0);
                    this.ilx.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.lnO;
            } else {
                this.ilx.setVisibility(8);
                layoutParams.bottomMargin = d.lnP;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lof.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.lnL;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes24.dex */
    private class c extends a {
        OriginalThreadCardView ajl;

        public c(View view) {
            super();
            this.loa = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.lnW = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.jDC = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.eBQ = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.lnX = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.akZ = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.lnX);
            this.lob = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.ajl = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.lnY = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.lnZ = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.lod = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.mDivider = view.findViewById(R.id.share_text_divider);
            d(this.jDC);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.ajl.b(markData.getOriginalThreadInfo());
            this.ajl.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajl.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.lnL;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes24.dex */
    private class b {
        TextView loe;
        ProgressBar mProgress;

        private b() {
        }
    }
}
