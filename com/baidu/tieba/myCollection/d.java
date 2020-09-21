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
/* loaded from: classes23.dex */
public class d extends BaseAdapter {
    private static final float ksq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float ksr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float kss = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int kst = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int ksu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> eiq = new ArrayList<>();
    private boolean fqD = false;
    private View.OnClickListener ksv = null;
    private View.OnClickListener ksw = null;
    private View.OnClickListener ksx = null;
    private boolean ksy = false;
    private boolean hasMore = true;
    private boolean ksz = true;
    private final View.OnClickListener ajn = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            aq aqVar = new aq("c12529");
            if (view instanceof CommonUserLikeButton) {
                aqVar.ai("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                aqVar.ai("obj_locate", 1);
            }
            aqVar.dF("tid", item.getId());
            aqVar.dF("obj_id", item.getUesrId());
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
        this.ksy = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.eiq.clear();
        if (arrayList != null) {
            this.eiq.addAll(arrayList);
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
        if (y.isEmpty(this.eiq)) {
            return 0;
        }
        return this.ksz ? y.getCount(this.eiq) + 1 : y.getCount(this.eiq);
    }

    public void sk(boolean z) {
        this.ksz = z;
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
    /* renamed from: DK */
    public MarkData getItem(int i) {
        return (MarkData) y.getItem(this.eiq, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (y.getCount(this.eiq) <= i) {
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
        C0746d c0746d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0746d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0746d c0746d2 = new C0746d(view);
                    view.setTag(c0746d2);
                    c0746d = c0746d2;
                } else {
                    c0746d = (C0746d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0746d.ksB.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0746d.ksF.getLayoutParams();
                    if (this.fqD) {
                        c0746d.ksB.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0746d.ksB.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0746d.b(item);
                    a(i, c0746d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.ksI = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.ksI.setVisibility(0);
                if (this.ksy) {
                    bVar.mProgress.setVisibility(0);
                    bVar.ksI.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.ksI, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.ksI.setText(this.mPageContext.getString(R.string.no_more_mark));
                    ap.setViewTextColor(bVar.ksI, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.ksI.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.ksI, R.color.common_color_10039, 1);
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
                    cVar.ksB.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.ksF.getLayoutParams();
                    if (this.fqD) {
                        cVar.ksB.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.ksB.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.ahQ.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
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
        if (y.isEmpty(this.eiq) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void kp(boolean z) {
        this.fqD = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.ksG.setOnClickListener(this.ksw);
        aVar.ksG.setTag(valueOf);
        aVar.iIi.setAfterClickListener(this.ajn);
        aVar.iIi.setTag(valueOf);
        aVar.ksC.setAfterOnClickListener(this.ajn);
        aVar.ksC.setTag(valueOf);
        aVar.ksH.setOnClickListener(this.ksx);
        aVar.ksH.setTag(valueOf);
        aVar.ksB.setOnClickListener(this.ksv);
        aVar.ksB.setFocusable(false);
        aVar.ksB.setTag(valueOf);
    }

    public void M(View.OnClickListener onClickListener) {
        this.ksv = onClickListener;
    }

    public void N(View.OnClickListener onClickListener) {
        this.ksw = onClickListener;
    }

    public void O(View.OnClickListener onClickListener) {
        this.ksx = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ajD;
        TextView dWe;
        ClickableHeaderImageView iIi;
        ImageButton ksB;
        CommonUserLikeButton ksC;
        TextView ksD;
        ImageView ksE;
        LinearLayout ksF;
        LinearLayout ksG;
        LinearLayout ksH;
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
                clickableHeaderImageView.setAfterClickListener(d.this.ajn);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.ksq);
                        ap.setViewTextColor(this.mTitle, R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.ksr);
                        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.iIi.setData(markData.metaData);
                this.iIi.setShowV(markData.metaData.isBigV());
                this.ajD.a(markData.metaData);
                this.ksC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.ksC.setTextSize(0, d.kss);
                if ((markData.metaData.getIsLike() || at.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.ksC.setVisibility(8);
                } else {
                    this.ksC.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.ksH.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.ksE.setVisibility(0);
                    } else {
                        this.ksE.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.ksD.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.ksD.setText(markData.getmState());
                    }
                    ap.setViewTextColor(this.ksD, R.color.cp_cont_d);
                } else {
                    this.ksH.setVisibility(8);
                }
                ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.dWe.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    ap.setViewTextColor(this.dWe, R.color.cp_cont_h);
                } else {
                    ap.setViewTextColor(this.dWe, R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    private class C0746d extends a {
        TbImageView hsM;
        LinearLayout ksJ;

        public C0746d(View view) {
            super();
            this.ksF = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.iIi = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.dWe = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.ksG = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.ksJ = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.ksC = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.ajD = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.ksC);
            this.hsM = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.ksD = (TextView) view.findViewById(R.id.markitem_state_text);
            this.ksB = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.ksE = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.ksH = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.mDivider = view.findViewById(R.id.text_divider);
            d(this.iIi);
            this.hsM.setPlaceHolder(2);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ksG.getLayoutParams();
            if (k.bcG().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.hsM.setVisibility(0);
                    this.hsM.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.kst;
            } else {
                this.hsM.setVisibility(8);
                layoutParams.bottomMargin = d.ksu;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ksJ.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.ksq;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes23.dex */
    private class c extends a {
        OriginalThreadCardView ahQ;

        public c(View view) {
            super();
            this.ksF = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.ksB = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.iIi = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.dWe = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.ksC = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.ajD = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.ksC);
            this.ksG = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.ahQ = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.ksD = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.ksE = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.ksH = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.mDivider = view.findViewById(R.id.share_text_divider);
            d(this.iIi);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.ahQ.b(markData.getOriginalThreadInfo());
            this.ahQ.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahQ.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.ksq;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes23.dex */
    private class b {
        TextView ksI;
        ProgressBar mProgress;

        private b() {
        }
    }
}
