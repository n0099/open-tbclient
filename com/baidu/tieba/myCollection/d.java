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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class d extends BaseAdapter {
    private static final float haN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds32);
    private static final float haO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds36);
    private static final float haP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds26);
    private static final int haQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds28);
    private static final int haR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> aFI = new ArrayList<>();
    private boolean cMG = false;
    private View.OnClickListener haS = null;
    private View.OnClickListener haT = null;
    private View.OnClickListener haU = null;
    private boolean haV = false;
    private boolean hasMore = true;
    private boolean haW = true;
    private final View.OnClickListener ZG = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            am amVar = new am("c12529");
            if (view instanceof CommonUserLikeButton) {
                amVar.T("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                amVar.T("obj_locate", 1);
            }
            amVar.bJ("tid", item.getId());
            amVar.bJ(VideoPlayActivityConfig.OBJ_ID, item.getUesrId());
            TiebaStatic.log(amVar);
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setRefreshing(boolean z) {
        this.haV = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.aFI.clear();
        if (arrayList != null) {
            this.aFI.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (l.ln()) {
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.T(this.aFI)) {
            return 0;
        }
        return this.haW ? v.S(this.aFI) + 1 : v.S(this.aFI);
    }

    public void mB(boolean z) {
        this.haW = z;
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
    /* renamed from: vL */
    public MarkData getItem(int i) {
        return (MarkData) v.c(this.aFI, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.S(this.aFI) <= i) {
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
        C0342d c0342d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0342d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.home_mark_item, (ViewGroup) null);
                    C0342d c0342d2 = new C0342d(view);
                    view.setTag(c0342d2);
                    c0342d = c0342d2;
                } else {
                    c0342d = (C0342d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0342d.haY.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0342d.hbc.getLayoutParams();
                    if (this.cMG) {
                        c0342d.haY.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0342d.haY.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds34);
                    }
                    c0342d.b(item);
                    a(i, c0342d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.hbf = (TextView) view.findViewById(d.g.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(d.g.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.hbf.setVisibility(0);
                if (this.haV) {
                    bVar.mProgress.setVisibility(0);
                    bVar.hbf.setText(this.mPageContext.getString(d.j.loading));
                    al.d(bVar.hbf, d.C0277d.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.hbf.setText(this.mPageContext.getString(d.j.no_more_mark));
                    al.d(bVar.hbf, d.C0277d.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.hbf.setText(this.mPageContext.getString(d.j.loading));
                    al.d(bVar.hbf, d.C0277d.common_color_10039, 1);
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
                    cVar.haY.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.hbc.getLayoutParams();
                    if (this.cMG) {
                        cVar.haY.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.haY.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.Zi.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new am("c12529").T("obj_locate", 5));
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
        if (v.T(this.aFI) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void fJ(boolean z) {
        this.cMG = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.hbd.setOnClickListener(this.haT);
        aVar.hbd.setTag(valueOf);
        aVar.fAy.setAfterClickListener(this.ZG);
        aVar.fAy.setTag(valueOf);
        aVar.haZ.setAfterOnClickListener(this.ZG);
        aVar.haZ.setTag(valueOf);
        aVar.hbe.setOnClickListener(this.haU);
        aVar.hbe.setTag(valueOf);
        aVar.haY.setOnClickListener(this.haS);
        aVar.haY.setFocusable(false);
        aVar.haY.setTag(valueOf);
    }

    public void D(View.OnClickListener onClickListener) {
        this.haS = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.haT = onClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.haU = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a {
        View aLb;
        TextView bTY;
        com.baidu.tbadk.core.view.userLike.c ehx;
        ClickableHeaderImageView fAy;
        ImageButton haY;
        CommonUserLikeButton haZ;
        TextView hba;
        ImageView hbb;
        LinearLayout hbc;
        LinearLayout hbd;
        LinearLayout hbe;
        TextView mTitle;

        private a() {
        }

        void d(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setDefaultErrorResource(d.f.icon_default_avatar100);
                clickableHeaderImageView.setDefaultBgResource(d.C0277d.cp_bg_line_e);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(d.this.ZG);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.haN);
                        al.j(this.mTitle, d.C0277d.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.haO);
                        al.j(this.mTitle, d.C0277d.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.fAy.setData(markData.metaData);
                this.fAy.setShowV(markData.metaData.isBigV());
                this.ehx.a(markData.metaData);
                this.haZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.haZ.setTextSize(0, d.haP);
                if ((markData.metaData.getIsLike() || ap.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.haZ.setVisibility(8);
                } else {
                    this.haZ.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.hbe.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.hbb.setVisibility(0);
                    } else {
                        this.hbb.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.hba.setText(d.this.mPageContext.getString(d.j.mark_thread_deleted));
                    } else {
                        this.hba.setText(markData.getmState());
                    }
                    al.j(this.hba, d.C0277d.cp_cont_d);
                } else {
                    this.hbe.setVisibility(8);
                }
                al.l(this.aLb, d.C0277d.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.bTY.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    al.j(this.bTY, d.C0277d.cp_cont_h);
                } else {
                    al.j(this.bTY, d.C0277d.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0342d extends a {
        TbImageView ekg;
        LinearLayout hbg;

        public C0342d(View view) {
            super();
            this.hbc = (LinearLayout) view.findViewById(d.g.home_lv_markitem);
            this.fAy = (ClickableHeaderImageView) view.findViewById(d.g.mark_userinfo_header_view);
            this.bTY = (TextView) view.findViewById(d.g.mark_userinfo_name);
            this.hbd = (LinearLayout) view.findViewById(d.g.home_lv_markitem_userinfo);
            this.hbg = (LinearLayout) view.findViewById(d.g.home_lv_markitem_thread);
            this.haZ = (CommonUserLikeButton) view.findViewById(d.g.markitem_userinfo_like_btn);
            this.ehx = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.haZ);
            this.ekg = (TbImageView) view.findViewById(d.g.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(d.g.markitem_thread_title);
            this.hba = (TextView) view.findViewById(d.g.markitem_state_text);
            this.haY = (ImageButton) view.findViewById(d.g.home_lv_markitem_delete);
            this.hbb = (ImageView) view.findViewById(d.g.new_mark_mention_redtip);
            this.hbe = (LinearLayout) view.findViewById(d.g.markitem_state);
            this.aLb = view.findViewById(d.g.text_divider);
            d(this.fAy);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hbd.getLayoutParams();
            if (i.Wy().WC() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.ekg.setVisibility(0);
                    this.ekg.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.haQ;
            } else {
                this.ekg.setVisibility(8);
                layoutParams.bottomMargin = d.haR;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hbg.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.haN;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
    private class c extends a {
        OriginalThreadCardView Zi;

        public c(View view) {
            super();
            this.hbc = (LinearLayout) view.findViewById(d.g.share_lv_markitem);
            this.haY = (ImageButton) view.findViewById(d.g.share_lv_markitem_delete);
            this.fAy = (ClickableHeaderImageView) view.findViewById(d.g.share_mark_userinfo_header_view);
            this.bTY = (TextView) view.findViewById(d.g.share_mark_userinfo_name);
            this.haZ = (CommonUserLikeButton) view.findViewById(d.g.share_mark_item_userinfo_like_btn);
            this.ehx = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.haZ);
            this.hbd = (LinearLayout) view.findViewById(d.g.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(d.g.share_thread_title);
            this.Zi = (OriginalThreadCardView) view.findViewById(d.g.share_original_thread_view);
            this.hba = (TextView) view.findViewById(d.g.share_mark_item_state_text);
            this.hbb = (ImageView) view.findViewById(d.g.share_new_mark_mention_redtip);
            this.hbe = (LinearLayout) view.findViewById(d.g.share_mark_item_state);
            this.aLb = view.findViewById(d.g.share_text_divider);
            d(this.fAy);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.Zi.b(markData.getOriginalThreadInfo());
            this.Zi.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Zi.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.haN;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
    private class b {
        TextView hbf;
        ProgressBar mProgress;

        private b() {
        }
    }
}
