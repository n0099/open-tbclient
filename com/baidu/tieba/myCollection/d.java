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
    private static final float hAW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float hAX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float hAY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int hAZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int hBa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> aIL = new ArrayList<>();
    private boolean cXs = false;
    private View.OnClickListener hBb = null;
    private View.OnClickListener hBc = null;
    private View.OnClickListener hBd = null;
    private boolean hBe = false;
    private boolean hasMore = true;
    private boolean hBf = true;
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
        this.hBe = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.aIL.clear();
        if (arrayList != null) {
            this.aIL.addAll(arrayList);
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
        if (v.aa(this.aIL)) {
            return 0;
        }
        return this.hBf ? v.Z(this.aIL) + 1 : v.Z(this.aIL);
    }

    public void nJ(boolean z) {
        this.hBf = z;
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
    /* renamed from: xu */
    public MarkData getItem(int i) {
        return (MarkData) v.c(this.aIL, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.Z(this.aIL) <= i) {
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
        C0376d c0376d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0376d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0376d c0376d2 = new C0376d(view);
                    view.setTag(c0376d2);
                    c0376d = c0376d2;
                } else {
                    c0376d = (C0376d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0376d.hBh.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0376d.hBl.getLayoutParams();
                    if (this.cXs) {
                        c0376d.hBh.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0376d.hBh.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0376d.b(item);
                    a(i, c0376d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.hBo = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.hBo.setVisibility(0);
                if (this.hBe) {
                    bVar.mProgress.setVisibility(0);
                    bVar.hBo.setText(this.mPageContext.getString(R.string.loading));
                    am.f(bVar.hBo, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.hBo.setText(this.mPageContext.getString(R.string.no_more_mark));
                    am.f(bVar.hBo, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.hBo.setText(this.mPageContext.getString(R.string.loading));
                    am.f(bVar.hBo, R.color.common_color_10039, 1);
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
                    cVar.hBh.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.hBl.getLayoutParams();
                    if (this.cXs) {
                        cVar.hBh.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.hBh.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.Xu.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
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
        if (v.aa(this.aIL) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void gn(boolean z) {
        this.cXs = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.hBm.setOnClickListener(this.hBc);
        aVar.hBm.setTag(valueOf);
        aVar.fYQ.setAfterClickListener(this.XU);
        aVar.fYQ.setTag(valueOf);
        aVar.hBi.setAfterOnClickListener(this.XU);
        aVar.hBi.setTag(valueOf);
        aVar.hBn.setOnClickListener(this.hBd);
        aVar.hBn.setTag(valueOf);
        aVar.hBh.setOnClickListener(this.hBb);
        aVar.hBh.setFocusable(false);
        aVar.hBh.setTag(valueOf);
    }

    public void H(View.OnClickListener onClickListener) {
        this.hBb = onClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.hBc = onClickListener;
    }

    public void J(View.OnClickListener onClickListener) {
        this.hBd = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a {
        View aOf;
        TextView cdZ;
        com.baidu.tbadk.core.view.userLike.c eDN;
        ClickableHeaderImageView fYQ;
        ImageButton hBh;
        CommonUserLikeButton hBi;
        TextView hBj;
        ImageView hBk;
        LinearLayout hBl;
        LinearLayout hBm;
        LinearLayout hBn;
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
                        this.mTitle.setTextSize(0, d.hAW);
                        am.j(this.mTitle, R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.hAX);
                        am.j(this.mTitle, R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.fYQ.setData(markData.metaData);
                this.fYQ.setShowV(markData.metaData.isBigV());
                this.eDN.a(markData.metaData);
                this.hBi.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.hBi.setTextSize(0, d.hAY);
                if ((markData.metaData.getIsLike() || aq.bV(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.hBi.setVisibility(8);
                } else {
                    this.hBi.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.hBn.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.hBk.setVisibility(0);
                    } else {
                        this.hBk.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.hBj.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.hBj.setText(markData.getmState());
                    }
                    am.j(this.hBj, R.color.cp_cont_d);
                } else {
                    this.hBn.setVisibility(8);
                }
                am.l(this.aOf, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.cdZ.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    am.j(this.cdZ, R.color.cp_cont_h);
                } else {
                    am.j(this.cdZ, R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0376d extends a {
        TbImageView eGu;
        LinearLayout hBp;

        public C0376d(View view) {
            super();
            this.hBl = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.fYQ = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.cdZ = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.hBm = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.hBp = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.hBi = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.eDN = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.hBi);
            this.eGu = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.hBj = (TextView) view.findViewById(R.id.markitem_state_text);
            this.hBh = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.hBk = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.hBn = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.aOf = view.findViewById(R.id.text_divider);
            d(this.fYQ);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hBm.getLayoutParams();
            if (i.ace().aci() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.eGu.setVisibility(0);
                    this.eGu.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.hAZ;
            } else {
                this.eGu.setVisibility(8);
                layoutParams.bottomMargin = d.hBa;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hBp.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.hAW;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
    private class c extends a {
        OriginalThreadCardView Xu;

        public c(View view) {
            super();
            this.hBl = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.hBh = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.fYQ = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.cdZ = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.hBi = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.eDN = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.hBi);
            this.hBm = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.Xu = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.hBj = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.hBk = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.hBn = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.aOf = view.findViewById(R.id.share_text_divider);
            d(this.fYQ);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.Xu.b(markData.getOriginalThreadInfo());
            this.Xu.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Xu.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.hAW;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
    private class b {
        TextView hBo;
        ProgressBar mProgress;

        private b() {
        }
    }
}
