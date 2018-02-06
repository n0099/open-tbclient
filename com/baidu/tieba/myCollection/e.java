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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private TbPageContext<?> mPageContext;
    private static final float fyw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds32);
    private static final float fyx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds36);
    private static final float fyy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds26);
    private static final int fyz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds28);
    private static final int fyA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds20);
    private final ArrayList<MarkData> aSi = new ArrayList<>();
    private boolean bSu = false;
    private View.OnClickListener fyB = null;
    private View.OnClickListener fyC = null;
    private View.OnClickListener fyD = null;
    private boolean fyE = false;
    private boolean hasMore = true;
    private boolean fyF = true;
    private final View.OnClickListener bec = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = e.this.getItem(((Integer) view.getTag()).intValue());
            ak akVar = new ak("c12529");
            if (view instanceof CommonUserLikeButton) {
                akVar.s("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                akVar.s("obj_locate", 1);
            }
            akVar.ab("tid", item.getId());
            akVar.ab("obj_id", item.getUesrId());
            TiebaStatic.log(akVar);
        }
    };

    public e(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setRefreshing(boolean z) {
        this.fyE = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.aSi.clear();
        if (arrayList != null) {
            this.aSi.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (l.oZ()) {
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.E(this.aSi)) {
            return 0;
        }
        return this.fyF ? v.D(this.aSi) + 1 : v.D(this.aSi);
    }

    public void jr(boolean z) {
        this.fyF = z;
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
    /* renamed from: so */
    public MarkData getItem(int i) {
        return (MarkData) v.f(this.aSi, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.D(this.aSi) <= i) {
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
                    dVar.fyH.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.fyL.getLayoutParams();
                    if (this.bSu) {
                        dVar.fyH.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        dVar.fyH.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds34);
                    }
                    dVar.b(item);
                    a(i, dVar);
                    this.mPageContext.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().aM(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.fyO = (TextView) view.findViewById(d.g.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(d.g.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.fyO.setVisibility(0);
                if (this.fyE) {
                    bVar.mProgress.setVisibility(0);
                    bVar.fyO.setText(this.mPageContext.getString(d.j.loading));
                    aj.e(bVar.fyO, d.C0140d.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.fyO.setText(this.mPageContext.getString(d.j.no_more_mark));
                    aj.e(bVar.fyO, d.C0140d.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.fyO.setText(this.mPageContext.getString(d.j.loading));
                    aj.e(bVar.fyO, d.C0140d.common_color_10039, 1);
                }
                this.mPageContext.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() != 1);
                this.mPageContext.getLayoutMode().aM(view);
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
                    cVar.fyH.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.fyL.getLayoutParams();
                    if (this.bSu) {
                        cVar.fyH.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.fyH.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.fyP.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.e.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new ak("c12529").s("obj_locate", 5));
                        }
                    });
                    this.mPageContext.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().aM(view);
                    break;
                }
                break;
            default:
                this.mPageContext.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() != 1);
                this.mPageContext.getLayoutMode().aM(view);
                break;
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (v.E(this.aSi) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void cX(boolean z) {
        this.bSu = z;
    }

    public boolean Uo() {
        return this.bSu;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.fyM.setOnClickListener(this.fyC);
        aVar.fyM.setTag(valueOf);
        aVar.dZU.setAfterClickListener(this.bec);
        aVar.dZU.setTag(valueOf);
        aVar.fyI.setAfterOnClickListener(this.bec);
        aVar.fyI.setTag(valueOf);
        aVar.fyN.setOnClickListener(this.fyD);
        aVar.fyN.setTag(valueOf);
        aVar.fyH.setOnClickListener(this.fyB);
        aVar.fyH.setFocusable(false);
        aVar.fyH.setTag(valueOf);
    }

    public void y(View.OnClickListener onClickListener) {
        this.fyB = onClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.fyC = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.fyD = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView bfg;
        com.baidu.tbadk.core.view.userLike.c cWj;
        View chX;
        ClickableHeaderImageView dZU;
        ImageButton fyH;
        CommonUserLikeButton fyI;
        TextView fyJ;
        ImageView fyK;
        LinearLayout fyL;
        LinearLayout fyM;
        LinearLayout fyN;
        TextView mTitle;

        private a() {
        }

        void c(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setDefaultErrorResource(d.f.icon_default_avatar100);
                clickableHeaderImageView.setDefaultBgResource(d.C0140d.cp_bg_line_e);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(e.this.bec);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fyw);
                        aj.r(this.mTitle, d.C0140d.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fyx);
                        aj.r(this.mTitle, d.C0140d.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.dZU.setData(markData.metaData);
                this.dZU.setShowV(markData.metaData.isBigV());
                this.cWj.a(markData.metaData);
                this.fyI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.fyI.setTextSize(0, e.fyy);
                if ((markData.metaData.getIsLike() || am.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.fyI.setVisibility(8);
                } else {
                    this.fyI.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.fyN.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.fyK.setVisibility(0);
                    } else {
                        this.fyK.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.fyJ.setText(e.this.mPageContext.getString(d.j.mark_thread_deleted));
                    } else {
                        this.fyJ.setText(markData.getmState());
                    }
                    aj.r(this.fyJ, d.C0140d.cp_cont_d);
                } else {
                    this.fyN.setVisibility(8);
                }
                aj.t(this.chX, d.C0140d.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.bfg.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    aj.r(this.bfg, d.C0140d.cp_cont_h);
                } else {
                    aj.r(this.bfg, d.C0140d.cp_cont_f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private class d extends a {
        TbImageView cXt;
        LinearLayout fyQ;

        public d(View view) {
            super();
            this.fyL = (LinearLayout) view.findViewById(d.g.home_lv_markitem);
            this.dZU = (ClickableHeaderImageView) view.findViewById(d.g.mark_userinfo_header_view);
            this.bfg = (TextView) view.findViewById(d.g.mark_userinfo_name);
            this.fyM = (LinearLayout) view.findViewById(d.g.home_lv_markitem_userinfo);
            this.fyQ = (LinearLayout) view.findViewById(d.g.home_lv_markitem_thread);
            this.fyI = (CommonUserLikeButton) view.findViewById(d.g.markitem_userinfo_like_btn);
            this.cWj = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fyI);
            this.cXt = (TbImageView) view.findViewById(d.g.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(d.g.markitem_thread_title);
            this.fyJ = (TextView) view.findViewById(d.g.markitem_state_text);
            this.fyH = (ImageButton) view.findViewById(d.g.home_lv_markitem_delete);
            this.fyK = (ImageView) view.findViewById(d.g.new_mark_mention_redtip);
            this.fyN = (LinearLayout) view.findViewById(d.g.markitem_state);
            this.chX = view.findViewById(d.g.text_divider);
            c(this.dZU);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fyM.getLayoutParams();
            if (i.xo().xu() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.cXt.setVisibility(0);
                    this.cXt.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = e.fyz;
            } else {
                this.cXt.setVisibility(8);
                layoutParams.bottomMargin = e.fyA;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fyQ.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) e.fyw;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class c extends a {
        OriginalThreadCardView fyP;

        public c(View view) {
            super();
            this.fyL = (LinearLayout) view.findViewById(d.g.share_lv_markitem);
            this.fyH = (ImageButton) view.findViewById(d.g.share_lv_markitem_delete);
            this.dZU = (ClickableHeaderImageView) view.findViewById(d.g.share_mark_userinfo_header_view);
            this.bfg = (TextView) view.findViewById(d.g.share_mark_userinfo_name);
            this.fyI = (CommonUserLikeButton) view.findViewById(d.g.share_mark_item_userinfo_like_btn);
            this.cWj = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fyI);
            this.fyM = (LinearLayout) view.findViewById(d.g.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(d.g.share_thread_title);
            this.fyP = (OriginalThreadCardView) view.findViewById(d.g.share_original_thread_view);
            this.fyJ = (TextView) view.findViewById(d.g.share_mark_item_state_text);
            this.fyK = (ImageView) view.findViewById(d.g.share_new_mark_mention_redtip);
            this.fyN = (LinearLayout) view.findViewById(d.g.share_mark_item_state);
            this.chX = view.findViewById(d.g.share_text_divider);
            c(this.dZU);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            this.fyP.b(markData.getOriginalThreadInfo());
            this.fyP.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fyP.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) e.fyw;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView fyO;
        ProgressBar mProgress;

        private b() {
        }
    }
}
