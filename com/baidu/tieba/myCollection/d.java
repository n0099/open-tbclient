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
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    private static final float imR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float imS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float imT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int imU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int imV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> cRE = new ArrayList<>();
    private boolean dTI = false;
    private View.OnClickListener imW = null;
    private View.OnClickListener imX = null;
    private View.OnClickListener imY = null;
    private boolean imZ = false;
    private boolean hasMore = true;
    private boolean ina = true;
    private final View.OnClickListener MT = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
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
        this.imZ = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.cRE.clear();
        if (arrayList != null) {
            this.cRE.addAll(arrayList);
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
        if (v.isEmpty(this.cRE)) {
            return 0;
        }
        return this.ina ? v.getCount(this.cRE) + 1 : v.getCount(this.cRE);
    }

    public void oJ(boolean z) {
        this.ina = z;
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
    /* renamed from: ya */
    public MarkData getItem(int i) {
        return (MarkData) v.getItem(this.cRE, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.getCount(this.cRE) <= i) {
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
        C0551d c0551d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0551d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0551d c0551d2 = new C0551d(view);
                    view.setTag(c0551d2);
                    c0551d = c0551d2;
                } else {
                    c0551d = (C0551d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0551d.inc.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0551d.ing.getLayoutParams();
                    if (this.dTI) {
                        c0551d.inc.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0551d.inc.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0551d.b(item);
                    a(i, c0551d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.inj = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.inj.setVisibility(0);
                if (this.imZ) {
                    bVar.mProgress.setVisibility(0);
                    bVar.inj.setText(this.mPageContext.getString(R.string.loading));
                    am.setViewTextColor(bVar.inj, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.inj.setText(this.mPageContext.getString(R.string.no_more_mark));
                    am.setViewTextColor(bVar.inj, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.inj.setText(this.mPageContext.getString(R.string.loading));
                    am.setViewTextColor(bVar.inj, R.color.common_color_10039, 1);
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
                    cVar.inc.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.ing.getLayoutParams();
                    if (this.dTI) {
                        cVar.inc.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.inc.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.LR.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
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
        if (v.isEmpty(this.cRE) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void hq(boolean z) {
        this.dTI = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.inh.setOnClickListener(this.imX);
        aVar.inh.setTag(valueOf);
        aVar.gLS.setAfterClickListener(this.MT);
        aVar.gLS.setTag(valueOf);
        aVar.ind.setAfterOnClickListener(this.MT);
        aVar.ind.setTag(valueOf);
        aVar.ini.setOnClickListener(this.imY);
        aVar.ini.setTag(valueOf);
        aVar.inc.setOnClickListener(this.imW);
        aVar.inc.setFocusable(false);
        aVar.inc.setTag(valueOf);
    }

    public void J(View.OnClickListener onClickListener) {
        this.imW = onClickListener;
    }

    public void K(View.OnClickListener onClickListener) {
        this.imX = onClickListener;
    }

    public void L(View.OnClickListener onClickListener) {
        this.imY = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c MX;
        TextView bXt;
        ClickableHeaderImageView gLS;
        ImageButton inc;
        CommonUserLikeButton ind;
        TextView ine;
        ImageView inf;
        LinearLayout ing;
        LinearLayout inh;
        LinearLayout ini;
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
                clickableHeaderImageView.setAfterClickListener(d.this.MT);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.imR);
                        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.imS);
                        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.gLS.setData(markData.metaData);
                this.gLS.setShowV(markData.metaData.isBigV());
                this.MX.a(markData.metaData);
                this.ind.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.ind.setTextSize(0, d.imT);
                if ((markData.metaData.getIsLike() || aq.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.ind.setVisibility(8);
                } else {
                    this.ind.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.ini.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.inf.setVisibility(0);
                    } else {
                        this.inf.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.ine.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.ine.setText(markData.getmState());
                    }
                    am.setViewTextColor(this.ine, (int) R.color.cp_cont_d);
                } else {
                    this.ini.setVisibility(8);
                }
                am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.bXt.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    am.setViewTextColor(this.bXt, (int) R.color.cp_cont_h);
                } else {
                    am.setViewTextColor(this.bXt, (int) R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0551d extends a {
        TbImageView fFX;
        LinearLayout ink;

        public C0551d(View view) {
            super();
            this.ing = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.gLS = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.bXt = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.inh = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.ink = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.ind = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.MX = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.ind);
            this.fFX = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.ine = (TextView) view.findViewById(R.id.markitem_state_text);
            this.inc = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.inf = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.ini = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.mDivider = view.findViewById(R.id.text_divider);
            d(this.gLS);
            this.fFX.setPlaceHolder(2);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inh.getLayoutParams();
            if (i.axf().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.fFX.setVisibility(0);
                    this.fFX.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.imU;
            } else {
                this.fFX.setVisibility(8);
                layoutParams.bottomMargin = d.imV;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ink.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.imR;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes8.dex */
    private class c extends a {
        OriginalThreadCardView LR;

        public c(View view) {
            super();
            this.ing = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.inc = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.gLS = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.bXt = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.ind = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.MX = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.ind);
            this.inh = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.LR = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.ine = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.inf = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.ini = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.mDivider = view.findViewById(R.id.share_text_divider);
            d(this.gLS);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.LR.b(markData.getOriginalThreadInfo());
            this.LR.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.LR.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.imR;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes8.dex */
    private class b {
        TextView inj;
        ProgressBar mProgress;

        private b() {
        }
    }
}
