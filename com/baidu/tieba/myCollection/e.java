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
    private static final float fyA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds32);
    private static final float fyB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds36);
    private static final float fyC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds26);
    private static final int fyD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds28);
    private static final int fyE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> aRZ = new ArrayList<>();
    private boolean bSk = false;
    private View.OnClickListener fyF = null;
    private View.OnClickListener fyG = null;
    private View.OnClickListener fyH = null;
    private boolean fyI = false;
    private boolean hasMore = true;
    private boolean fyJ = true;
    private final View.OnClickListener bdT = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.e.2
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
        this.fyI = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.aRZ.clear();
        if (arrayList != null) {
            this.aRZ.addAll(arrayList);
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
        if (v.E(this.aRZ)) {
            return 0;
        }
        return this.fyJ ? v.D(this.aRZ) + 1 : v.D(this.aRZ);
    }

    public void jw(boolean z) {
        this.fyJ = z;
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
    /* renamed from: sp */
    public MarkData getItem(int i) {
        return (MarkData) v.f(this.aRZ, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.D(this.aRZ) <= i) {
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
                    dVar.fyL.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.fyP.getLayoutParams();
                    if (this.bSk) {
                        dVar.fyL.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        dVar.fyL.setVisibility(8);
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
                    bVar2.fyS = (TextView) view.findViewById(d.g.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(d.g.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.fyS.setVisibility(0);
                if (this.fyI) {
                    bVar.mProgress.setVisibility(0);
                    bVar.fyS.setText(this.mPageContext.getString(d.j.loading));
                    aj.e(bVar.fyS, d.C0141d.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.fyS.setText(this.mPageContext.getString(d.j.no_more_mark));
                    aj.e(bVar.fyS, d.C0141d.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.fyS.setText(this.mPageContext.getString(d.j.loading));
                    aj.e(bVar.fyS, d.C0141d.common_color_10039, 1);
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
                    cVar.fyL.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.fyP.getLayoutParams();
                    if (this.bSk) {
                        cVar.fyL.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.fyL.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.fyT.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.e.1
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
        if (v.E(this.aRZ) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void cX(boolean z) {
        this.bSk = z;
    }

    public boolean Uo() {
        return this.bSk;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.fyQ.setOnClickListener(this.fyG);
        aVar.fyQ.setTag(valueOf);
        aVar.dZY.setAfterClickListener(this.bdT);
        aVar.dZY.setTag(valueOf);
        aVar.fyM.setAfterOnClickListener(this.bdT);
        aVar.fyM.setTag(valueOf);
        aVar.fyR.setOnClickListener(this.fyH);
        aVar.fyR.setTag(valueOf);
        aVar.fyL.setOnClickListener(this.fyF);
        aVar.fyL.setFocusable(false);
        aVar.fyL.setTag(valueOf);
    }

    public void y(View.OnClickListener onClickListener) {
        this.fyF = onClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.fyG = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.fyH = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView beW;
        com.baidu.tbadk.core.view.userLike.c cWa;
        View chO;
        ClickableHeaderImageView dZY;
        ImageButton fyL;
        CommonUserLikeButton fyM;
        TextView fyN;
        ImageView fyO;
        LinearLayout fyP;
        LinearLayout fyQ;
        LinearLayout fyR;
        TextView mTitle;

        private a() {
        }

        void c(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setDefaultErrorResource(d.f.icon_default_avatar100);
                clickableHeaderImageView.setDefaultBgResource(d.C0141d.cp_bg_line_e);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(e.this.bdT);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fyA);
                        aj.r(this.mTitle, d.C0141d.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fyB);
                        aj.r(this.mTitle, d.C0141d.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.dZY.setData(markData.metaData);
                this.dZY.setShowV(markData.metaData.isBigV());
                this.cWa.a(markData.metaData);
                this.fyM.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.fyM.setTextSize(0, e.fyC);
                if ((markData.metaData.getIsLike() || am.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.fyM.setVisibility(8);
                } else {
                    this.fyM.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.fyR.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.fyO.setVisibility(0);
                    } else {
                        this.fyO.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.fyN.setText(e.this.mPageContext.getString(d.j.mark_thread_deleted));
                    } else {
                        this.fyN.setText(markData.getmState());
                    }
                    aj.r(this.fyN, d.C0141d.cp_cont_d);
                } else {
                    this.fyR.setVisibility(8);
                }
                aj.t(this.chO, d.C0141d.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.beW.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    aj.r(this.beW, d.C0141d.cp_cont_h);
                } else {
                    aj.r(this.beW, d.C0141d.cp_cont_f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private class d extends a {
        TbImageView cXk;
        LinearLayout fyU;

        public d(View view) {
            super();
            this.fyP = (LinearLayout) view.findViewById(d.g.home_lv_markitem);
            this.dZY = (ClickableHeaderImageView) view.findViewById(d.g.mark_userinfo_header_view);
            this.beW = (TextView) view.findViewById(d.g.mark_userinfo_name);
            this.fyQ = (LinearLayout) view.findViewById(d.g.home_lv_markitem_userinfo);
            this.fyU = (LinearLayout) view.findViewById(d.g.home_lv_markitem_thread);
            this.fyM = (CommonUserLikeButton) view.findViewById(d.g.markitem_userinfo_like_btn);
            this.cWa = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fyM);
            this.cXk = (TbImageView) view.findViewById(d.g.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(d.g.markitem_thread_title);
            this.fyN = (TextView) view.findViewById(d.g.markitem_state_text);
            this.fyL = (ImageButton) view.findViewById(d.g.home_lv_markitem_delete);
            this.fyO = (ImageView) view.findViewById(d.g.new_mark_mention_redtip);
            this.fyR = (LinearLayout) view.findViewById(d.g.markitem_state);
            this.chO = view.findViewById(d.g.text_divider);
            c(this.dZY);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fyQ.getLayoutParams();
            if (i.xo().xu() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.cXk.setVisibility(0);
                    this.cXk.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = e.fyD;
            } else {
                this.cXk.setVisibility(8);
                layoutParams.bottomMargin = e.fyE;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fyU.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) e.fyA;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class c extends a {
        OriginalThreadCardView fyT;

        public c(View view) {
            super();
            this.fyP = (LinearLayout) view.findViewById(d.g.share_lv_markitem);
            this.fyL = (ImageButton) view.findViewById(d.g.share_lv_markitem_delete);
            this.dZY = (ClickableHeaderImageView) view.findViewById(d.g.share_mark_userinfo_header_view);
            this.beW = (TextView) view.findViewById(d.g.share_mark_userinfo_name);
            this.fyM = (CommonUserLikeButton) view.findViewById(d.g.share_mark_item_userinfo_like_btn);
            this.cWa = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fyM);
            this.fyQ = (LinearLayout) view.findViewById(d.g.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(d.g.share_thread_title);
            this.fyT = (OriginalThreadCardView) view.findViewById(d.g.share_original_thread_view);
            this.fyN = (TextView) view.findViewById(d.g.share_mark_item_state_text);
            this.fyO = (ImageView) view.findViewById(d.g.share_new_mark_mention_redtip);
            this.fyR = (LinearLayout) view.findViewById(d.g.share_mark_item_state);
            this.chO = view.findViewById(d.g.share_text_divider);
            c(this.dZY);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            this.fyT.b(markData.getOriginalThreadInfo());
            this.fyT.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fyT.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) e.fyA;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView fyS;
        ProgressBar mProgress;

        private b() {
        }
    }
}
