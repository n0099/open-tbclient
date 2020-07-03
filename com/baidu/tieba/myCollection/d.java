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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class d extends BaseAdapter {
    private static final float jLO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float jLP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float jLQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int jLR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int jLS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> dQf = new ArrayList<>();
    private boolean eXz = false;
    private View.OnClickListener jLT = null;
    private View.OnClickListener jLU = null;
    private View.OnClickListener jLV = null;
    private boolean jLW = false;
    private boolean hasMore = true;
    private boolean jLX = true;
    private final View.OnClickListener ahM = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            ao aoVar = new ao("c12529");
            if (view instanceof CommonUserLikeButton) {
                aoVar.ag("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                aoVar.ag("obj_locate", 1);
            }
            aoVar.dk("tid", item.getId());
            aoVar.dk("obj_id", item.getUesrId());
            TiebaStatic.log(aoVar);
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setRefreshing(boolean z) {
        this.jLW = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.dQf.clear();
        if (arrayList != null) {
            this.dQf.addAll(arrayList);
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
        if (w.isEmpty(this.dQf)) {
            return 0;
        }
        return this.jLX ? w.getCount(this.dQf) + 1 : w.getCount(this.dQf);
    }

    public void qP(boolean z) {
        this.jLX = z;
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
    /* renamed from: Ar */
    public MarkData getItem(int i) {
        return (MarkData) w.getItem(this.dQf, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (w.getCount(this.dQf) <= i) {
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
        C0687d c0687d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0687d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0687d c0687d2 = new C0687d(view);
                    view.setTag(c0687d2);
                    c0687d = c0687d2;
                } else {
                    c0687d = (C0687d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0687d.jLZ.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0687d.jMd.getLayoutParams();
                    if (this.eXz) {
                        c0687d.jLZ.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0687d.jLZ.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0687d.b(item);
                    a(i, c0687d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.jMg = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.jMg.setVisibility(0);
                if (this.jLW) {
                    bVar.mProgress.setVisibility(0);
                    bVar.jMg.setText(this.mPageContext.getString(R.string.loading));
                    an.setViewTextColor(bVar.jMg, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.jMg.setText(this.mPageContext.getString(R.string.no_more_mark));
                    an.setViewTextColor(bVar.jMg, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.jMg.setText(this.mPageContext.getString(R.string.loading));
                    an.setViewTextColor(bVar.jMg, R.color.common_color_10039, 1);
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
                    cVar.jLZ.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.jMd.getLayoutParams();
                    if (this.eXz) {
                        cVar.jLZ.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.jLZ.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.agv.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new ao("c12529").ag("obj_locate", 5));
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
        if (w.isEmpty(this.dQf) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void jk(boolean z) {
        this.eXz = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.jMe.setOnClickListener(this.jLU);
        aVar.jMe.setTag(valueOf);
        aVar.igx.setAfterClickListener(this.ahM);
        aVar.igx.setTag(valueOf);
        aVar.jMa.setAfterOnClickListener(this.ahM);
        aVar.jMa.setTag(valueOf);
        aVar.jMf.setOnClickListener(this.jLV);
        aVar.jMf.setTag(valueOf);
        aVar.jLZ.setOnClickListener(this.jLT);
        aVar.jLZ.setFocusable(false);
        aVar.jLZ.setTag(valueOf);
    }

    public void L(View.OnClickListener onClickListener) {
        this.jLT = onClickListener;
    }

    public void M(View.OnClickListener onClickListener) {
        this.jLU = onClickListener;
    }

    public void N(View.OnClickListener onClickListener) {
        this.jLV = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ahX;
        TextView dEL;
        ClickableHeaderImageView igx;
        ImageButton jLZ;
        CommonUserLikeButton jMa;
        TextView jMb;
        ImageView jMc;
        LinearLayout jMd;
        LinearLayout jMe;
        LinearLayout jMf;
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
                clickableHeaderImageView.setAfterClickListener(d.this.ahM);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.jLO);
                        an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.jLP);
                        an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.igx.setData(markData.metaData);
                this.igx.setShowV(markData.metaData.isBigV());
                this.ahX.a(markData.metaData);
                this.jMa.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.jMa.setTextSize(0, d.jLQ);
                if ((markData.metaData.getIsLike() || ar.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.jMa.setVisibility(8);
                } else {
                    this.jMa.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.jMf.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.jMc.setVisibility(0);
                    } else {
                        this.jMc.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.jMb.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.jMb.setText(markData.getmState());
                    }
                    an.setViewTextColor(this.jMb, (int) R.color.cp_cont_d);
                } else {
                    this.jMf.setVisibility(8);
                }
                an.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.dEL.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    an.setViewTextColor(this.dEL, (int) R.color.cp_cont_h);
                } else {
                    an.setViewTextColor(this.dEL, (int) R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0687d extends a {
        TbImageView gTh;
        LinearLayout jMh;

        public C0687d(View view) {
            super();
            this.jMd = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.igx = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.dEL = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.jMe = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.jMh = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.jMa = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.ahX = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.jMa);
            this.gTh = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.jMb = (TextView) view.findViewById(R.id.markitem_state_text);
            this.jLZ = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.jMc = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.jMf = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.mDivider = view.findViewById(R.id.text_divider);
            d(this.igx);
            this.gTh.setPlaceHolder(2);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jMe.getLayoutParams();
            if (k.aPA().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.gTh.setVisibility(0);
                    this.gTh.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.jLR;
            } else {
                this.gTh.setVisibility(8);
                layoutParams.bottomMargin = d.jLS;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jMh.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.jLO;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes11.dex */
    private class c extends a {
        OriginalThreadCardView agv;

        public c(View view) {
            super();
            this.jMd = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.jLZ = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.igx = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.dEL = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.jMa = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.ahX = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.jMa);
            this.jMe = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.agv = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.jMb = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.jMc = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.jMf = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.mDivider = view.findViewById(R.id.share_text_divider);
            d(this.igx);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.agv.b(markData.getOriginalThreadInfo());
            this.agv.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agv.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.jLO;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes11.dex */
    private class b {
        TextView jMg;
        ProgressBar mProgress;

        private b() {
        }
    }
}
