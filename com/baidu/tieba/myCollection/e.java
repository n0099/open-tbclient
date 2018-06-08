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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private static final float ffH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds32);
    private static final float ffI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds36);
    private static final float ffJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds26);
    private static final int ffK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds28);
    private static final int ffL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> alt = new ArrayList<>();
    private boolean bkz = false;
    private View.OnClickListener ffM = null;
    private View.OnClickListener ffN = null;
    private View.OnClickListener ffO = null;
    private boolean ffP = false;
    private boolean hasMore = true;
    private boolean ffQ = true;
    private final View.OnClickListener axr = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = e.this.getItem(((Integer) view.getTag()).intValue());
            am amVar = new am("c12529");
            if (view instanceof CommonUserLikeButton) {
                amVar.r("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                amVar.r("obj_locate", 1);
            }
            amVar.ah("tid", item.getId());
            amVar.ah(VideoPlayActivityConfig.OBJ_ID, item.getUesrId());
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
        this.ffP = z;
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
        if (l.jT()) {
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.z(this.alt)) {
            return 0;
        }
        return this.ffQ ? w.y(this.alt) + 1 : w.y(this.alt);
    }

    public void iZ(boolean z) {
        this.ffQ = z;
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
    /* renamed from: pU */
    public MarkData getItem(int i) {
        return (MarkData) w.c(this.alt, i);
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
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.home_mark_item, (ViewGroup) null);
                    d dVar2 = new d(view);
                    view.setTag(dVar2);
                    dVar = dVar2;
                } else {
                    dVar = (d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    dVar.ffS.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.ffW.getLayoutParams();
                    if (this.bkz) {
                        dVar.ffS.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        dVar.ffS.setVisibility(8);
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
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.ffZ = (TextView) view.findViewById(d.g.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(d.g.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.ffZ.setVisibility(0);
                if (this.ffP) {
                    bVar.mProgress.setVisibility(0);
                    bVar.ffZ.setText(this.mPageContext.getString(d.k.loading));
                    al.c(bVar.ffZ, d.C0141d.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.ffZ.setText(this.mPageContext.getString(d.k.no_more_mark));
                    al.c(bVar.ffZ, d.C0141d.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.ffZ.setText(this.mPageContext.getString(d.k.loading));
                    al.c(bVar.ffZ, d.C0141d.common_color_10039, 1);
                }
                this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                this.mPageContext.getLayoutMode().onModeChanged(view);
                break;
            case 2:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.cell_collect_share_view, (ViewGroup) null);
                    c cVar2 = new c(view);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                MarkData item2 = getItem(i);
                if (item2 == null) {
                    cVar.ffS.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.ffW.getLayoutParams();
                    if (this.bkz) {
                        cVar.ffS.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.ffS.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.fga.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.e.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new am("c12529").r("obj_locate", 5));
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

    public void ct(boolean z) {
        this.bkz = z;
    }

    public boolean Qm() {
        return this.bkz;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.ffX.setOnClickListener(this.ffN);
        aVar.ffX.setTag(valueOf);
        aVar.dFa.setAfterClickListener(this.axr);
        aVar.dFa.setTag(valueOf);
        aVar.ffT.setAfterOnClickListener(this.axr);
        aVar.ffT.setTag(valueOf);
        aVar.ffY.setOnClickListener(this.ffO);
        aVar.ffY.setTag(valueOf);
        aVar.ffS.setOnClickListener(this.ffM);
        aVar.ffS.setFocusable(false);
        aVar.ffS.setTag(valueOf);
    }

    public void z(View.OnClickListener onClickListener) {
        this.ffM = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.ffN = onClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.ffO = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView ayt;
        View bFh;
        com.baidu.tbadk.core.view.userLike.c cxK;
        ClickableHeaderImageView dFa;
        ImageButton ffS;
        CommonUserLikeButton ffT;
        TextView ffU;
        ImageView ffV;
        LinearLayout ffW;
        LinearLayout ffX;
        LinearLayout ffY;
        TextView mTitle;

        private a() {
        }

        void c(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setDefaultErrorResource(d.f.icon_default_avatar100);
                clickableHeaderImageView.setDefaultBgResource(d.C0141d.cp_bg_line_e);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(e.this.axr);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.ffH);
                        al.h(this.mTitle, d.C0141d.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.ffI);
                        al.h(this.mTitle, d.C0141d.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.dFa.setData(markData.metaData);
                this.dFa.setShowV(markData.metaData.isBigV());
                this.cxK.a(markData.metaData);
                this.ffT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.ffT.setTextSize(0, e.ffJ);
                if ((markData.metaData.getIsLike() || ao.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.ffT.setVisibility(8);
                } else {
                    this.ffT.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.ffY.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.ffV.setVisibility(0);
                    } else {
                        this.ffV.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.ffU.setText(e.this.mPageContext.getString(d.k.mark_thread_deleted));
                    } else {
                        this.ffU.setText(markData.getmState());
                    }
                    al.h(this.ffU, d.C0141d.cp_cont_d);
                } else {
                    this.ffY.setVisibility(8);
                }
                al.j(this.bFh, d.C0141d.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.ayt.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    al.h(this.ayt, d.C0141d.cp_cont_h);
                } else {
                    al.h(this.ayt, d.C0141d.cp_cont_f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private class d extends a {
        TbImageView cAA;
        LinearLayout fgb;

        public d(View view) {
            super();
            this.ffW = (LinearLayout) view.findViewById(d.g.home_lv_markitem);
            this.dFa = (ClickableHeaderImageView) view.findViewById(d.g.mark_userinfo_header_view);
            this.ayt = (TextView) view.findViewById(d.g.mark_userinfo_name);
            this.ffX = (LinearLayout) view.findViewById(d.g.home_lv_markitem_userinfo);
            this.fgb = (LinearLayout) view.findViewById(d.g.home_lv_markitem_thread);
            this.ffT = (CommonUserLikeButton) view.findViewById(d.g.markitem_userinfo_like_btn);
            this.cxK = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.ffT);
            this.cAA = (TbImageView) view.findViewById(d.g.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(d.g.markitem_thread_title);
            this.ffU = (TextView) view.findViewById(d.g.markitem_state_text);
            this.ffS = (ImageButton) view.findViewById(d.g.home_lv_markitem_delete);
            this.ffV = (ImageView) view.findViewById(d.g.new_mark_mention_redtip);
            this.ffY = (LinearLayout) view.findViewById(d.g.markitem_state);
            this.bFh = view.findViewById(d.g.text_divider);
            c(this.dFa);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ffX.getLayoutParams();
            if (i.tt().tz() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.cAA.setVisibility(0);
                    this.cAA.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = e.ffK;
            } else {
                this.cAA.setVisibility(8);
                layoutParams.bottomMargin = e.ffL;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fgb.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) e.ffH;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class c extends a {
        OriginalThreadCardView fga;

        public c(View view) {
            super();
            this.ffW = (LinearLayout) view.findViewById(d.g.share_lv_markitem);
            this.ffS = (ImageButton) view.findViewById(d.g.share_lv_markitem_delete);
            this.dFa = (ClickableHeaderImageView) view.findViewById(d.g.share_mark_userinfo_header_view);
            this.ayt = (TextView) view.findViewById(d.g.share_mark_userinfo_name);
            this.ffT = (CommonUserLikeButton) view.findViewById(d.g.share_mark_item_userinfo_like_btn);
            this.cxK = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.ffT);
            this.ffX = (LinearLayout) view.findViewById(d.g.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(d.g.share_thread_title);
            this.fga = (OriginalThreadCardView) view.findViewById(d.g.share_original_thread_view);
            this.ffU = (TextView) view.findViewById(d.g.share_mark_item_state_text);
            this.ffV = (ImageView) view.findViewById(d.g.share_new_mark_mention_redtip);
            this.ffY = (LinearLayout) view.findViewById(d.g.share_mark_item_state);
            this.bFh = view.findViewById(d.g.share_text_divider);
            c(this.dFa);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            this.fga.b(markData.getOriginalThreadInfo());
            this.fga.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fga.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) e.ffH;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView ffZ;
        ProgressBar mProgress;

        private b() {
        }
    }
}
