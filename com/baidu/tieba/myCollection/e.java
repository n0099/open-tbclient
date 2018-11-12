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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private static final float fAk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds32);
    private static final float fAl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds36);
    private static final float fAm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds26);
    private static final int fAn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds28);
    private static final int fAo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> mData = new ArrayList<>();
    private boolean bxo = false;
    private View.OnClickListener fAp = null;
    private View.OnClickListener fAq = null;
    private View.OnClickListener fAr = null;
    private boolean fAs = false;
    private boolean hasMore = true;
    private boolean fAt = true;
    private final View.OnClickListener aHa = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = e.this.getItem(((Integer) view.getTag()).intValue());
            am amVar = new am("c12529");
            if (view instanceof CommonUserLikeButton) {
                amVar.x("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                amVar.x("obj_locate", 1);
            }
            amVar.ax("tid", item.getId());
            amVar.ax(VideoPlayActivityConfig.OBJ_ID, item.getUesrId());
            TiebaStatic.log(amVar);
        }
    };

    public e(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setRefreshing(boolean z) {
        this.fAs = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.mData.clear();
        if (arrayList != null) {
            this.mData.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (l.ll()) {
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.I(this.mData)) {
            return 0;
        }
        return this.fAt ? v.H(this.mData) + 1 : v.H(this.mData);
    }

    public void jU(boolean z) {
        this.fAt = z;
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
    /* renamed from: rt */
    public MarkData getItem(int i) {
        return (MarkData) v.d(this.mData, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.H(this.mData) <= i) {
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
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.home_mark_item, (ViewGroup) null);
                    d dVar2 = new d(view);
                    view.setTag(dVar2);
                    dVar = dVar2;
                } else {
                    dVar = (d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    dVar.fAv.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.fAz.getLayoutParams();
                    if (this.bxo) {
                        dVar.fAv.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        dVar.fAv.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0200e.ds34);
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
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.fAC = (TextView) view.findViewById(e.g.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(e.g.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.fAC.setVisibility(0);
                if (this.fAs) {
                    bVar.mProgress.setVisibility(0);
                    bVar.fAC.setText(this.mPageContext.getString(e.j.loading));
                    al.c(bVar.fAC, e.d.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.fAC.setText(this.mPageContext.getString(e.j.no_more_mark));
                    al.c(bVar.fAC, e.d.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.fAC.setText(this.mPageContext.getString(e.j.loading));
                    al.c(bVar.fAC, e.d.common_color_10039, 1);
                }
                this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                this.mPageContext.getLayoutMode().onModeChanged(view);
                break;
            case 2:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.cell_collect_share_view, (ViewGroup) null);
                    c cVar2 = new c(view);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                MarkData item2 = getItem(i);
                if (item2 == null) {
                    cVar.fAv.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.fAz.getLayoutParams();
                    if (this.bxo) {
                        cVar.fAv.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.fAv.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0200e.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.fAD.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.e.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new am("c12529").x("obj_locate", 5));
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
        if (v.I(this.mData) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void dp(boolean z) {
        this.bxo = z;
    }

    public boolean UO() {
        return this.bxo;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.fAA.setOnClickListener(this.fAq);
        aVar.fAA.setTag(valueOf);
        aVar.ebN.setAfterClickListener(this.aHa);
        aVar.ebN.setTag(valueOf);
        aVar.fAw.setAfterOnClickListener(this.aHa);
        aVar.fAw.setTag(valueOf);
        aVar.fAB.setOnClickListener(this.fAr);
        aVar.fAB.setTag(valueOf);
        aVar.fAv.setOnClickListener(this.fAp);
        aVar.fAv.setFocusable(false);
        aVar.fAv.setTag(valueOf);
    }

    public void C(View.OnClickListener onClickListener) {
        this.fAp = onClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.fAq = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fAr = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView aHt;
        com.baidu.tbadk.core.view.userLike.c cNG;
        ClickableHeaderImageView ebN;
        LinearLayout fAA;
        LinearLayout fAB;
        ImageButton fAv;
        CommonUserLikeButton fAw;
        TextView fAx;
        ImageView fAy;
        LinearLayout fAz;
        View mDivider;
        TextView mTitle;

        private a() {
        }

        void c(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setDefaultErrorResource(e.f.icon_default_avatar100);
                clickableHeaderImageView.setDefaultBgResource(e.d.cp_bg_line_e);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(e.this.aHa);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fAk);
                        al.h(this.mTitle, e.d.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fAl);
                        al.h(this.mTitle, e.d.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.ebN.setData(markData.metaData);
                this.ebN.setShowV(markData.metaData.isBigV());
                this.cNG.a(markData.metaData);
                this.fAw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.fAw.setTextSize(0, e.fAm);
                if ((markData.metaData.getIsLike() || ao.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.fAw.setVisibility(8);
                } else {
                    this.fAw.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.fAB.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.fAy.setVisibility(0);
                    } else {
                        this.fAy.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.fAx.setText(e.this.mPageContext.getString(e.j.mark_thread_deleted));
                    } else {
                        this.fAx.setText(markData.getmState());
                    }
                    al.h(this.fAx, e.d.cp_cont_d);
                } else {
                    this.fAB.setVisibility(8);
                }
                al.j(this.mDivider, e.d.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.aHt.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    al.h(this.aHt, e.d.cp_cont_h);
                } else {
                    al.h(this.aHt, e.d.cp_cont_f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private class d extends a {
        TbImageView cQm;
        LinearLayout fAE;

        public d(View view) {
            super();
            this.fAz = (LinearLayout) view.findViewById(e.g.home_lv_markitem);
            this.ebN = (ClickableHeaderImageView) view.findViewById(e.g.mark_userinfo_header_view);
            this.aHt = (TextView) view.findViewById(e.g.mark_userinfo_name);
            this.fAA = (LinearLayout) view.findViewById(e.g.home_lv_markitem_userinfo);
            this.fAE = (LinearLayout) view.findViewById(e.g.home_lv_markitem_thread);
            this.fAw = (CommonUserLikeButton) view.findViewById(e.g.markitem_userinfo_like_btn);
            this.cNG = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fAw);
            this.cQm = (TbImageView) view.findViewById(e.g.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(e.g.markitem_thread_title);
            this.fAx = (TextView) view.findViewById(e.g.markitem_state_text);
            this.fAv = (ImageButton) view.findViewById(e.g.home_lv_markitem_delete);
            this.fAy = (ImageView) view.findViewById(e.g.new_mark_mention_redtip);
            this.fAB = (LinearLayout) view.findViewById(e.g.markitem_state);
            this.mDivider = view.findViewById(e.g.text_divider);
            c(this.ebN);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fAA.getLayoutParams();
            if (i.wA().wE() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.cQm.setVisibility(0);
                    this.cQm.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = e.fAn;
            } else {
                this.cQm.setVisibility(8);
                layoutParams.bottomMargin = e.fAo;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fAE.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) e.fAk;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class c extends a {
        OriginalThreadCardView fAD;

        public c(View view) {
            super();
            this.fAz = (LinearLayout) view.findViewById(e.g.share_lv_markitem);
            this.fAv = (ImageButton) view.findViewById(e.g.share_lv_markitem_delete);
            this.ebN = (ClickableHeaderImageView) view.findViewById(e.g.share_mark_userinfo_header_view);
            this.aHt = (TextView) view.findViewById(e.g.share_mark_userinfo_name);
            this.fAw = (CommonUserLikeButton) view.findViewById(e.g.share_mark_item_userinfo_like_btn);
            this.cNG = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fAw);
            this.fAA = (LinearLayout) view.findViewById(e.g.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(e.g.share_thread_title);
            this.fAD = (OriginalThreadCardView) view.findViewById(e.g.share_original_thread_view);
            this.fAx = (TextView) view.findViewById(e.g.share_mark_item_state_text);
            this.fAy = (ImageView) view.findViewById(e.g.share_new_mark_mention_redtip);
            this.fAB = (LinearLayout) view.findViewById(e.g.share_mark_item_state);
            this.mDivider = view.findViewById(e.g.share_text_divider);
            c(this.ebN);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            this.fAD.b(markData.getOriginalThreadInfo());
            this.fAD.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fAD.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) e.fAk;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView fAC;
        ProgressBar mProgress;

        private b() {
        }
    }
}
