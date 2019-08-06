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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
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
/* loaded from: classes6.dex */
public class d extends BaseAdapter {
    private static final float hza = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float hzb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float hzc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int hzd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int hze = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> aIn = new ArrayList<>();
    private boolean cWz = false;
    private View.OnClickListener hzf = null;
    private View.OnClickListener hzg = null;
    private View.OnClickListener hzh = null;
    private boolean hzi = false;
    private boolean hasMore = true;
    private boolean hzj = true;
    private final View.OnClickListener XU = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            an anVar = new an("c12529");
            if (view instanceof CommonUserLikeButton) {
                anVar.P("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                anVar.P("obj_locate", 1);
            }
            anVar.bT("tid", item.getId());
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, item.getUesrId());
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
        this.hzi = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.aIn.clear();
        if (arrayList != null) {
            this.aIn.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (l.ks()) {
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.aa(this.aIn)) {
            return 0;
        }
        return this.hzj ? v.Z(this.aIn) + 1 : v.Z(this.aIn);
    }

    public void nF(boolean z) {
        this.hzj = z;
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
    /* renamed from: xr */
    public MarkData getItem(int i) {
        return (MarkData) v.c(this.aIn, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.Z(this.aIn) <= i) {
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
        C0365d c0365d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0365d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0365d c0365d2 = new C0365d(view);
                    view.setTag(c0365d2);
                    c0365d = c0365d2;
                } else {
                    c0365d = (C0365d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0365d.hzl.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0365d.hzp.getLayoutParams();
                    if (this.cWz) {
                        c0365d.hzl.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0365d.hzl.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0365d.b(item);
                    a(i, c0365d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.hzs = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.hzs.setVisibility(0);
                if (this.hzi) {
                    bVar.mProgress.setVisibility(0);
                    bVar.hzs.setText(this.mPageContext.getString(R.string.loading));
                    am.f(bVar.hzs, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.hzs.setText(this.mPageContext.getString(R.string.no_more_mark));
                    am.f(bVar.hzs, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.hzs.setText(this.mPageContext.getString(R.string.loading));
                    am.f(bVar.hzs, R.color.common_color_10039, 1);
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
                    cVar.hzl.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.hzp.getLayoutParams();
                    if (this.cWz) {
                        cVar.hzl.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.hzl.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.Xv.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new an("c12529").P("obj_locate", 5));
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
        if (v.aa(this.aIn) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void gk(boolean z) {
        this.cWz = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.hzq.setOnClickListener(this.hzg);
        aVar.hzq.setTag(valueOf);
        aVar.fWZ.setAfterClickListener(this.XU);
        aVar.fWZ.setTag(valueOf);
        aVar.hzm.setAfterOnClickListener(this.XU);
        aVar.hzm.setTag(valueOf);
        aVar.hzr.setOnClickListener(this.hzh);
        aVar.hzr.setTag(valueOf);
        aVar.hzl.setOnClickListener(this.hzf);
        aVar.hzl.setFocusable(false);
        aVar.hzl.setTag(valueOf);
    }

    public void H(View.OnClickListener onClickListener) {
        this.hzf = onClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.hzg = onClickListener;
    }

    public void J(View.OnClickListener onClickListener) {
        this.hzh = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a {
        View aNH;
        TextView cdg;
        com.baidu.tbadk.core.view.userLike.c eCe;
        ClickableHeaderImageView fWZ;
        ImageButton hzl;
        CommonUserLikeButton hzm;
        TextView hzn;
        ImageView hzo;
        LinearLayout hzp;
        LinearLayout hzq;
        LinearLayout hzr;
        TextView mTitle;

        private a() {
        }

        void d(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                clickableHeaderImageView.setDefaultBgResource(R.color.cp_bg_line_e);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(d.this.XU);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.hza);
                        am.j(this.mTitle, R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.hzb);
                        am.j(this.mTitle, R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.fWZ.setData(markData.metaData);
                this.fWZ.setShowV(markData.metaData.isBigV());
                this.eCe.a(markData.metaData);
                this.hzm.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.hzm.setTextSize(0, d.hzc);
                if ((markData.metaData.getIsLike() || aq.bV(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.hzm.setVisibility(8);
                } else {
                    this.hzm.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.hzr.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.hzo.setVisibility(0);
                    } else {
                        this.hzo.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.hzn.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.hzn.setText(markData.getmState());
                    }
                    am.j(this.hzn, R.color.cp_cont_d);
                } else {
                    this.hzr.setVisibility(8);
                }
                am.l(this.aNH, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.cdg.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    am.j(this.cdg, R.color.cp_cont_h);
                } else {
                    am.j(this.cdg, R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0365d extends a {
        TbImageView eEL;
        LinearLayout hzt;

        public C0365d(View view) {
            super();
            this.hzp = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.fWZ = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.cdg = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.hzq = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.hzt = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.hzm = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.eCe = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.hzm);
            this.eEL = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.hzn = (TextView) view.findViewById(R.id.markitem_state_text);
            this.hzl = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.hzo = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.hzr = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.aNH = view.findViewById(R.id.text_divider);
            d(this.fWZ);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hzq.getLayoutParams();
            if (i.aca().ace() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.eEL.setVisibility(0);
                    this.eEL.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.hzd;
            } else {
                this.eEL.setVisibility(8);
                layoutParams.bottomMargin = d.hze;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hzt.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.hza;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
    private class c extends a {
        OriginalThreadCardView Xv;

        public c(View view) {
            super();
            this.hzp = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.hzl = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.fWZ = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.cdg = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.hzm = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.eCe = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.hzm);
            this.hzq = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.Xv = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.hzn = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.hzo = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.hzr = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.aNH = view.findViewById(R.id.share_text_divider);
            d(this.fWZ);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.Xv.b(markData.getOriginalThreadInfo());
            this.Xv.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Xv.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.hza;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
    private class b {
        TextView hzs;
        ProgressBar mProgress;

        private b() {
        }
    }
}
