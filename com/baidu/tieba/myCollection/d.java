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
/* loaded from: classes11.dex */
public class d extends BaseAdapter {
    private static final float jeo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float jep = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float jeq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int jer = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int jes = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> dvu = new ArrayList<>();
    private boolean eyC = false;
    private View.OnClickListener jet = null;
    private View.OnClickListener jeu = null;
    private View.OnClickListener jev = null;
    private boolean jew = false;
    private boolean hasMore = true;
    private boolean jex = true;
    private final View.OnClickListener agl = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            an anVar = new an("c12529");
            if (view instanceof CommonUserLikeButton) {
                anVar.af("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                anVar.af("obj_locate", 1);
            }
            anVar.cI("tid", item.getId());
            anVar.cI("obj_id", item.getUesrId());
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
        this.jew = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.dvu.clear();
        if (arrayList != null) {
            this.dvu.addAll(arrayList);
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
        if (v.isEmpty(this.dvu)) {
            return 0;
        }
        return this.jex ? v.getCount(this.dvu) + 1 : v.getCount(this.dvu);
    }

    public void qi(boolean z) {
        this.jex = z;
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
    /* renamed from: yV */
    public MarkData getItem(int i) {
        return (MarkData) v.getItem(this.dvu, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.getCount(this.dvu) <= i) {
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
        C0623d c0623d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0623d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0623d c0623d2 = new C0623d(view);
                    view.setTag(c0623d2);
                    c0623d = c0623d2;
                } else {
                    c0623d = (C0623d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0623d.jez.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0623d.jeD.getLayoutParams();
                    if (this.eyC) {
                        c0623d.jez.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0623d.jez.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0623d.b(item);
                    a(i, c0623d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.jeG = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.jeG.setVisibility(0);
                if (this.jew) {
                    bVar.mProgress.setVisibility(0);
                    bVar.jeG.setText(this.mPageContext.getString(R.string.loading));
                    am.setViewTextColor(bVar.jeG, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.jeG.setText(this.mPageContext.getString(R.string.no_more_mark));
                    am.setViewTextColor(bVar.jeG, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.jeG.setText(this.mPageContext.getString(R.string.loading));
                    am.setViewTextColor(bVar.jeG, R.color.common_color_10039, 1);
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
                    cVar.jez.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.jeD.getLayoutParams();
                    if (this.eyC) {
                        cVar.jez.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.jez.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.afn.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new an("c12529").af("obj_locate", 5));
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
        if (v.isEmpty(this.dvu) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void iB(boolean z) {
        this.eyC = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.jeE.setOnClickListener(this.jeu);
        aVar.jeE.setTag(valueOf);
        aVar.hCD.setAfterClickListener(this.agl);
        aVar.hCD.setTag(valueOf);
        aVar.jeA.setAfterOnClickListener(this.agl);
        aVar.jeA.setTag(valueOf);
        aVar.jeF.setOnClickListener(this.jev);
        aVar.jeF.setTag(valueOf);
        aVar.jez.setOnClickListener(this.jet);
        aVar.jez.setFocusable(false);
        aVar.jez.setTag(valueOf);
    }

    public void K(View.OnClickListener onClickListener) {
        this.jet = onClickListener;
    }

    public void L(View.OnClickListener onClickListener) {
        this.jeu = onClickListener;
    }

    public void M(View.OnClickListener onClickListener) {
        this.jev = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c agp;
        TextView cBd;
        ClickableHeaderImageView hCD;
        CommonUserLikeButton jeA;
        TextView jeB;
        ImageView jeC;
        LinearLayout jeD;
        LinearLayout jeE;
        LinearLayout jeF;
        ImageButton jez;
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
                clickableHeaderImageView.setAfterClickListener(d.this.agl);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.jeo);
                        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.jep);
                        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.hCD.setData(markData.metaData);
                this.hCD.setShowV(markData.metaData.isBigV());
                this.agp.a(markData.metaData);
                this.jeA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.jeA.setTextSize(0, d.jeq);
                if ((markData.metaData.getIsLike() || aq.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.jeA.setVisibility(8);
                } else {
                    this.jeA.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.jeF.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.jeC.setVisibility(0);
                    } else {
                        this.jeC.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.jeB.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.jeB.setText(markData.getmState());
                    }
                    am.setViewTextColor(this.jeB, (int) R.color.cp_cont_d);
                } else {
                    this.jeF.setVisibility(8);
                }
                am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.cBd.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    am.setViewTextColor(this.cBd, (int) R.color.cp_cont_h);
                } else {
                    am.setViewTextColor(this.cBd, (int) R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0623d extends a {
        TbImageView gro;
        LinearLayout jeH;

        public C0623d(View view) {
            super();
            this.jeD = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.hCD = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.cBd = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.jeE = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.jeH = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.jeA = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.agp = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.jeA);
            this.gro = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.jeB = (TextView) view.findViewById(R.id.markitem_state_text);
            this.jez = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.jeC = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.jeF = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.mDivider = view.findViewById(R.id.text_divider);
            d(this.hCD);
            this.gro.setPlaceHolder(2);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jeE.getLayoutParams();
            if (i.aIc().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.gro.setVisibility(0);
                    this.gro.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.jer;
            } else {
                this.gro.setVisibility(8);
                layoutParams.bottomMargin = d.jes;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jeH.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.jeo;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes11.dex */
    private class c extends a {
        OriginalThreadCardView afn;

        public c(View view) {
            super();
            this.jeD = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.jez = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.hCD = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.cBd = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.jeA = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.agp = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.jeA);
            this.jeE = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.afn = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.jeB = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.jeC = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.jeF = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.mDivider = view.findViewById(R.id.share_text_divider);
            d(this.hCD);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.afn.b(markData.getOriginalThreadInfo());
            this.afn.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afn.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.jeo;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes11.dex */
    private class b {
        TextView jeG;
        ProgressBar mProgress;

        private b() {
        }
    }
}
