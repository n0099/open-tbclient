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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private static final float fjL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds32);
    private static final float fjM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds36);
    private static final float fjN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds26);
    private static final int fjO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds28);
    private static final int fjP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> als = new ArrayList<>();
    private boolean bmI = false;
    private View.OnClickListener fjQ = null;
    private View.OnClickListener fjR = null;
    private View.OnClickListener fjS = null;
    private boolean fjT = false;
    private boolean hasMore = true;
    private boolean fjU = true;
    private final View.OnClickListener axL = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = e.this.getItem(((Integer) view.getTag()).intValue());
            an anVar = new an("c12529");
            if (view instanceof CommonUserLikeButton) {
                anVar.r("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                anVar.r("obj_locate", 1);
            }
            anVar.ae("tid", item.getId());
            anVar.ae(VideoPlayActivityConfig.OBJ_ID, item.getUesrId());
            TiebaStatic.log(anVar);
        }
    };

    public e(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setRefreshing(boolean z) {
        this.fjT = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.als.clear();
        if (arrayList != null) {
            this.als.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (l.jU()) {
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.z(this.als)) {
            return 0;
        }
        return this.fjU ? w.y(this.als) + 1 : w.y(this.als);
    }

    public void iU(boolean z) {
        this.fjU = z;
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
    /* renamed from: pY */
    public MarkData getItem(int i) {
        return (MarkData) w.d(this.als, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (w.y(this.als) <= i) {
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
        d dVar;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(f.h.home_mark_item, (ViewGroup) null);
                    d dVar2 = new d(view);
                    view.setTag(dVar2);
                    dVar = dVar2;
                } else {
                    dVar = (d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    dVar.fjW.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.fka.getLayoutParams();
                    if (this.bmI) {
                        dVar.fjW.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        dVar.fjW.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(f.e.ds34);
                    }
                    dVar.b(item);
                    a(i, dVar);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(f.h.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.fkd = (TextView) view.findViewById(f.g.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(f.g.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.fkd.setVisibility(0);
                if (this.fjT) {
                    bVar.mProgress.setVisibility(0);
                    bVar.fkd.setText(this.mPageContext.getString(f.j.loading));
                    am.c(bVar.fkd, f.d.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.fkd.setText(this.mPageContext.getString(f.j.no_more_mark));
                    am.c(bVar.fkd, f.d.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.fkd.setText(this.mPageContext.getString(f.j.loading));
                    am.c(bVar.fkd, f.d.common_color_10039, 1);
                }
                this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                this.mPageContext.getLayoutMode().onModeChanged(view);
                break;
            case 2:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(f.h.cell_collect_share_view, (ViewGroup) null);
                    c cVar2 = new c(view);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                MarkData item2 = getItem(i);
                if (item2 == null) {
                    cVar.fjW.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.fka.getLayoutParams();
                    if (this.bmI) {
                        cVar.fjW.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.fjW.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(f.e.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.fke.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.e.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new an("c12529").r("obj_locate", 5));
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
        if (w.z(this.als) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void cy(boolean z) {
        this.bmI = z;
    }

    public boolean QV() {
        return this.bmI;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.fkb.setOnClickListener(this.fjR);
        aVar.fkb.setTag(valueOf);
        aVar.dLg.setAfterClickListener(this.axL);
        aVar.dLg.setTag(valueOf);
        aVar.fjX.setAfterOnClickListener(this.axL);
        aVar.fjX.setTag(valueOf);
        aVar.fkc.setOnClickListener(this.fjS);
        aVar.fkc.setTag(valueOf);
        aVar.fjW.setOnClickListener(this.fjQ);
        aVar.fjW.setFocusable(false);
        aVar.fjW.setTag(valueOf);
    }

    public void A(View.OnClickListener onClickListener) {
        this.fjQ = onClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.fjR = onClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.fjS = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView ayV;
        View bHR;
        com.baidu.tbadk.core.view.userLike.c cyq;
        ClickableHeaderImageView dLg;
        ImageButton fjW;
        CommonUserLikeButton fjX;
        TextView fjY;
        ImageView fjZ;
        LinearLayout fka;
        LinearLayout fkb;
        LinearLayout fkc;
        TextView mTitle;

        private a() {
        }

        void c(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
                clickableHeaderImageView.setDefaultBgResource(f.d.cp_bg_line_e);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(e.this.axL);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fjL);
                        am.h(this.mTitle, f.d.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fjM);
                        am.h(this.mTitle, f.d.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.dLg.setData(markData.metaData);
                this.dLg.setShowV(markData.metaData.isBigV());
                this.cyq.a(markData.metaData);
                this.fjX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.fjX.setTextSize(0, e.fjN);
                if ((markData.metaData.getIsLike() || ap.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.fjX.setVisibility(8);
                } else {
                    this.fjX.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.fkc.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.fjZ.setVisibility(0);
                    } else {
                        this.fjZ.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.fjY.setText(e.this.mPageContext.getString(f.j.mark_thread_deleted));
                    } else {
                        this.fjY.setText(markData.getmState());
                    }
                    am.h(this.fjY, f.d.cp_cont_d);
                } else {
                    this.fkc.setVisibility(8);
                }
                am.j(this.bHR, f.d.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.ayV.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    am.h(this.ayV, f.d.cp_cont_h);
                } else {
                    am.h(this.ayV, f.d.cp_cont_f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private class d extends a {
        TbImageView cAU;
        LinearLayout fkf;

        public d(View view) {
            super();
            this.fka = (LinearLayout) view.findViewById(f.g.home_lv_markitem);
            this.dLg = (ClickableHeaderImageView) view.findViewById(f.g.mark_userinfo_header_view);
            this.ayV = (TextView) view.findViewById(f.g.mark_userinfo_name);
            this.fkb = (LinearLayout) view.findViewById(f.g.home_lv_markitem_userinfo);
            this.fkf = (LinearLayout) view.findViewById(f.g.home_lv_markitem_thread);
            this.fjX = (CommonUserLikeButton) view.findViewById(f.g.markitem_userinfo_like_btn);
            this.cyq = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fjX);
            this.cAU = (TbImageView) view.findViewById(f.g.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(f.g.markitem_thread_title);
            this.fjY = (TextView) view.findViewById(f.g.markitem_state_text);
            this.fjW = (ImageButton) view.findViewById(f.g.home_lv_markitem_delete);
            this.fjZ = (ImageView) view.findViewById(f.g.new_mark_mention_redtip);
            this.fkc = (LinearLayout) view.findViewById(f.g.markitem_state);
            this.bHR = view.findViewById(f.g.text_divider);
            c(this.dLg);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkb.getLayoutParams();
            if (i.td().tj() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.cAU.setVisibility(0);
                    this.cAU.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = e.fjO;
            } else {
                this.cAU.setVisibility(8);
                layoutParams.bottomMargin = e.fjP;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fkf.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) e.fjL;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class c extends a {
        OriginalThreadCardView fke;

        public c(View view) {
            super();
            this.fka = (LinearLayout) view.findViewById(f.g.share_lv_markitem);
            this.fjW = (ImageButton) view.findViewById(f.g.share_lv_markitem_delete);
            this.dLg = (ClickableHeaderImageView) view.findViewById(f.g.share_mark_userinfo_header_view);
            this.ayV = (TextView) view.findViewById(f.g.share_mark_userinfo_name);
            this.fjX = (CommonUserLikeButton) view.findViewById(f.g.share_mark_item_userinfo_like_btn);
            this.cyq = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fjX);
            this.fkb = (LinearLayout) view.findViewById(f.g.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(f.g.share_thread_title);
            this.fke = (OriginalThreadCardView) view.findViewById(f.g.share_original_thread_view);
            this.fjY = (TextView) view.findViewById(f.g.share_mark_item_state_text);
            this.fjZ = (ImageView) view.findViewById(f.g.share_new_mark_mention_redtip);
            this.fkc = (LinearLayout) view.findViewById(f.g.share_mark_item_state);
            this.bHR = view.findViewById(f.g.share_text_divider);
            c(this.dLg);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            this.fke.b(markData.getOriginalThreadInfo());
            this.fke.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fke.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) e.fjL;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView fkd;
        ProgressBar mProgress;

        private b() {
        }
    }
}
