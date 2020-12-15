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
    private static final float lnN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float lnO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float lnP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int lnQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int lnR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> eOt = new ArrayList<>();
    private boolean fYV = false;
    private View.OnClickListener lnS = null;
    private View.OnClickListener lnT = null;
    private View.OnClickListener lnU = null;
    private boolean lnV = false;
    private boolean hasMore = true;
    private boolean lnW = true;
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
        this.lnV = z;
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
        return this.lnW ? y.getCount(this.eOt) + 1 : y.getCount(this.eOt);
    }

    public void tW(boolean z) {
        this.lnW = z;
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
                    c0812d.lnY.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0812d.lod.getLayoutParams();
                    if (this.fYV) {
                        c0812d.lnY.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0812d.lnY.setVisibility(8);
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
                    bVar2.loh = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.loh.setVisibility(0);
                if (this.lnV) {
                    bVar.mProgress.setVisibility(0);
                    bVar.loh.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.loh, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.loh.setText(this.mPageContext.getString(R.string.no_more_mark));
                    ap.setViewTextColor(bVar.loh, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.loh.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.loh, R.color.common_color_10039, 1);
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
                    cVar.lnY.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.lod.getLayoutParams();
                    if (this.fYV) {
                        cVar.lnY.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.lnY.setVisibility(8);
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
        this.fYV = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.loe.setOnClickListener(this.lnT);
        aVar.loe.setTag(valueOf);
        aVar.jDE.setAfterClickListener(this.akI);
        aVar.jDE.setTag(valueOf);
        aVar.lnZ.setAfterOnClickListener(this.akI);
        aVar.lnZ.setTag(valueOf);
        aVar.lof.setOnClickListener(this.lnU);
        aVar.lof.setTag(valueOf);
        aVar.lnY.setOnClickListener(this.lnS);
        aVar.lnY.setFocusable(false);
        aVar.lnY.setTag(valueOf);
    }

    public void M(View.OnClickListener onClickListener) {
        this.lnS = onClickListener;
    }

    public void N(View.OnClickListener onClickListener) {
        this.lnT = onClickListener;
    }

    public void O(View.OnClickListener onClickListener) {
        this.lnU = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c akZ;
        TextView eBQ;
        ClickableHeaderImageView jDE;
        ImageButton lnY;
        CommonUserLikeButton lnZ;
        TextView loa;
        ImageView lob;
        LinearLayout lod;
        LinearLayout loe;
        LinearLayout lof;
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
                        this.mTitle.setTextSize(0, d.lnN);
                        ap.setViewTextColor(this.mTitle, R.color.CAM_X0110);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.lnO);
                        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.jDE.setData(markData.metaData);
                this.jDE.setShowV(markData.metaData.isBigV());
                this.akZ.a(markData.metaData);
                this.lnZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.lnZ.setTextSize(0, d.lnP);
                if ((markData.metaData.getIsLike() || au.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.lnZ.setVisibility(8);
                } else {
                    this.lnZ.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.lof.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.lob.setVisibility(0);
                    } else {
                        this.lob.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.loa.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.loa.setText(markData.getmState());
                    }
                    ap.setViewTextColor(this.loa, R.color.CAM_X0109);
                } else {
                    this.lof.setVisibility(8);
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
        TbImageView ilz;
        LinearLayout loi;

        public C0812d(View view) {
            super();
            this.lod = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.jDE = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.eBQ = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.loe = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.loi = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.lnZ = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.akZ = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.lnZ);
            this.ilz = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.loa = (TextView) view.findViewById(R.id.markitem_state_text);
            this.lnY = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.lob = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.lof = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.mDivider = view.findViewById(R.id.text_divider);
            d(this.jDE);
            this.ilz.setPlaceHolder(1);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.loe.getLayoutParams();
            if (k.blV().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.ilz.setVisibility(0);
                    this.ilz.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.lnQ;
            } else {
                this.ilz.setVisibility(8);
                layoutParams.bottomMargin = d.lnR;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.loi.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.lnN;
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
            this.lod = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.lnY = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.jDE = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.eBQ = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.lnZ = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.akZ = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.lnZ);
            this.loe = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.ajl = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.loa = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.lob = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.lof = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.mDivider = view.findViewById(R.id.share_text_divider);
            d(this.jDE);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.ajl.b(markData.getOriginalThreadInfo());
            this.ajl.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajl.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.lnN;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes24.dex */
    private class b {
        TextView loh;
        ProgressBar mProgress;

        private b() {
        }
    }
}
