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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private static final float fjR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds32);
    private static final float fjS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds36);
    private static final float fjT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds26);
    private static final int fjU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds28);
    private static final int fjV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> alt = new ArrayList<>();
    private boolean bmE = false;
    private View.OnClickListener fjW = null;
    private View.OnClickListener fjX = null;
    private View.OnClickListener fjY = null;
    private boolean fjZ = false;
    private boolean hasMore = true;
    private boolean fka = true;
    private final View.OnClickListener axO = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = e.this.getItem(((Integer) view.getTag()).intValue());
            an anVar = new an("c12529");
            if (view instanceof CommonUserLikeButton) {
                anVar.r("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                anVar.r("obj_locate", 1);
            }
            anVar.af("tid", item.getId());
            anVar.af(VideoPlayActivityConfig.OBJ_ID, item.getUesrId());
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
        this.fjZ = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.alt.clear();
        if (arrayList != null) {
            this.alt.addAll(arrayList);
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
        if (w.z(this.alt)) {
            return 0;
        }
        return this.fka ? w.y(this.alt) + 1 : w.y(this.alt);
    }

    public void iU(boolean z) {
        this.fka = z;
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
        return (MarkData) w.d(this.alt, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (w.y(this.alt) <= i) {
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
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.home_mark_item, (ViewGroup) null);
                    d dVar2 = new d(view);
                    view.setTag(dVar2);
                    dVar = dVar2;
                } else {
                    dVar = (d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    dVar.fkc.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.fkg.getLayoutParams();
                    if (this.bmE) {
                        dVar.fkc.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        dVar.fkc.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds34);
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
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.fkj = (TextView) view.findViewById(d.g.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(d.g.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.fkj.setVisibility(0);
                if (this.fjZ) {
                    bVar.mProgress.setVisibility(0);
                    bVar.fkj.setText(this.mPageContext.getString(d.j.loading));
                    am.c(bVar.fkj, d.C0140d.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.fkj.setText(this.mPageContext.getString(d.j.no_more_mark));
                    am.c(bVar.fkj, d.C0140d.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.fkj.setText(this.mPageContext.getString(d.j.loading));
                    am.c(bVar.fkj, d.C0140d.common_color_10039, 1);
                }
                this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                this.mPageContext.getLayoutMode().onModeChanged(view);
                break;
            case 2:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.cell_collect_share_view, (ViewGroup) null);
                    c cVar2 = new c(view);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                MarkData item2 = getItem(i);
                if (item2 == null) {
                    cVar.fkc.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.fkg.getLayoutParams();
                    if (this.bmE) {
                        cVar.fkc.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.fkc.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.fkk.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.e.1
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
        if (w.z(this.alt) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void cx(boolean z) {
        this.bmE = z;
    }

    public boolean QQ() {
        return this.bmE;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.fkh.setOnClickListener(this.fjX);
        aVar.fkh.setTag(valueOf);
        aVar.dLk.setAfterClickListener(this.axO);
        aVar.dLk.setTag(valueOf);
        aVar.fkd.setAfterOnClickListener(this.axO);
        aVar.fkd.setTag(valueOf);
        aVar.fki.setOnClickListener(this.fjY);
        aVar.fki.setTag(valueOf);
        aVar.fkc.setOnClickListener(this.fjW);
        aVar.fkc.setFocusable(false);
        aVar.fkc.setTag(valueOf);
    }

    public void A(View.OnClickListener onClickListener) {
        this.fjW = onClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.fjX = onClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.fjY = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView ayY;
        View bHR;
        com.baidu.tbadk.core.view.userLike.c cyt;
        ClickableHeaderImageView dLk;
        ImageButton fkc;
        CommonUserLikeButton fkd;
        TextView fke;
        ImageView fkf;
        LinearLayout fkg;
        LinearLayout fkh;
        LinearLayout fki;
        TextView mTitle;

        private a() {
        }

        void c(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setDefaultErrorResource(d.f.icon_default_avatar100);
                clickableHeaderImageView.setDefaultBgResource(d.C0140d.cp_bg_line_e);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(e.this.axO);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fjR);
                        am.h(this.mTitle, d.C0140d.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fjS);
                        am.h(this.mTitle, d.C0140d.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.dLk.setData(markData.metaData);
                this.dLk.setShowV(markData.metaData.isBigV());
                this.cyt.a(markData.metaData);
                this.fkd.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.fkd.setTextSize(0, e.fjT);
                if ((markData.metaData.getIsLike() || ap.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.fkd.setVisibility(8);
                } else {
                    this.fkd.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.fki.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.fkf.setVisibility(0);
                    } else {
                        this.fkf.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.fke.setText(e.this.mPageContext.getString(d.j.mark_thread_deleted));
                    } else {
                        this.fke.setText(markData.getmState());
                    }
                    am.h(this.fke, d.C0140d.cp_cont_d);
                } else {
                    this.fki.setVisibility(8);
                }
                am.j(this.bHR, d.C0140d.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.ayY.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    am.h(this.ayY, d.C0140d.cp_cont_h);
                } else {
                    am.h(this.ayY, d.C0140d.cp_cont_f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private class d extends a {
        TbImageView cAX;
        LinearLayout fkl;

        public d(View view) {
            super();
            this.fkg = (LinearLayout) view.findViewById(d.g.home_lv_markitem);
            this.dLk = (ClickableHeaderImageView) view.findViewById(d.g.mark_userinfo_header_view);
            this.ayY = (TextView) view.findViewById(d.g.mark_userinfo_name);
            this.fkh = (LinearLayout) view.findViewById(d.g.home_lv_markitem_userinfo);
            this.fkl = (LinearLayout) view.findViewById(d.g.home_lv_markitem_thread);
            this.fkd = (CommonUserLikeButton) view.findViewById(d.g.markitem_userinfo_like_btn);
            this.cyt = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fkd);
            this.cAX = (TbImageView) view.findViewById(d.g.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(d.g.markitem_thread_title);
            this.fke = (TextView) view.findViewById(d.g.markitem_state_text);
            this.fkc = (ImageButton) view.findViewById(d.g.home_lv_markitem_delete);
            this.fkf = (ImageView) view.findViewById(d.g.new_mark_mention_redtip);
            this.fki = (LinearLayout) view.findViewById(d.g.markitem_state);
            this.bHR = view.findViewById(d.g.text_divider);
            c(this.dLk);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkh.getLayoutParams();
            if (i.te().tk() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.cAX.setVisibility(0);
                    this.cAX.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = e.fjU;
            } else {
                this.cAX.setVisibility(8);
                layoutParams.bottomMargin = e.fjV;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fkl.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) e.fjR;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class c extends a {
        OriginalThreadCardView fkk;

        public c(View view) {
            super();
            this.fkg = (LinearLayout) view.findViewById(d.g.share_lv_markitem);
            this.fkc = (ImageButton) view.findViewById(d.g.share_lv_markitem_delete);
            this.dLk = (ClickableHeaderImageView) view.findViewById(d.g.share_mark_userinfo_header_view);
            this.ayY = (TextView) view.findViewById(d.g.share_mark_userinfo_name);
            this.fkd = (CommonUserLikeButton) view.findViewById(d.g.share_mark_item_userinfo_like_btn);
            this.cyt = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fkd);
            this.fkh = (LinearLayout) view.findViewById(d.g.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(d.g.share_thread_title);
            this.fkk = (OriginalThreadCardView) view.findViewById(d.g.share_original_thread_view);
            this.fke = (TextView) view.findViewById(d.g.share_mark_item_state_text);
            this.fkf = (ImageView) view.findViewById(d.g.share_new_mark_mention_redtip);
            this.fki = (LinearLayout) view.findViewById(d.g.share_mark_item_state);
            this.bHR = view.findViewById(d.g.share_text_divider);
            c(this.dLk);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            this.fkk.b(markData.getOriginalThreadInfo());
            this.fkk.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkk.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) e.fjR;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView fkj;
        ProgressBar mProgress;

        private b() {
        }
    }
}
