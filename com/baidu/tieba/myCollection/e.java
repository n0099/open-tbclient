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
    private static final float fyk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds32);
    private static final float fyl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds36);
    private static final float fym = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds26);
    private static final int fyn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds28);
    private static final int fyo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> aRX = new ArrayList<>();
    private boolean bSh = false;
    private View.OnClickListener fyp = null;
    private View.OnClickListener fyq = null;
    private View.OnClickListener fyr = null;
    private boolean fys = false;
    private boolean hasMore = true;
    private boolean fyt = true;
    private final View.OnClickListener bdQ = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.e.2
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
        this.fys = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.aRX.clear();
        if (arrayList != null) {
            this.aRX.addAll(arrayList);
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
        if (v.E(this.aRX)) {
            return 0;
        }
        return this.fyt ? v.D(this.aRX) + 1 : v.D(this.aRX);
    }

    public void jr(boolean z) {
        this.fyt = z;
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
        return (MarkData) v.f(this.aRX, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.D(this.aRX) <= i) {
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
                    dVar.fyv.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.fyz.getLayoutParams();
                    if (this.bSh) {
                        dVar.fyv.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        dVar.fyv.setVisibility(8);
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
                    bVar2.fyC = (TextView) view.findViewById(d.g.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(d.g.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.fyC.setVisibility(0);
                if (this.fys) {
                    bVar.mProgress.setVisibility(0);
                    bVar.fyC.setText(this.mPageContext.getString(d.j.loading));
                    aj.e(bVar.fyC, d.C0141d.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.fyC.setText(this.mPageContext.getString(d.j.no_more_mark));
                    aj.e(bVar.fyC, d.C0141d.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.fyC.setText(this.mPageContext.getString(d.j.loading));
                    aj.e(bVar.fyC, d.C0141d.common_color_10039, 1);
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
                    cVar.fyv.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.fyz.getLayoutParams();
                    if (this.bSh) {
                        cVar.fyv.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.fyv.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.fyD.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.e.1
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
        if (v.E(this.aRX) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void cX(boolean z) {
        this.bSh = z;
    }

    public boolean Un() {
        return this.bSh;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.fyA.setOnClickListener(this.fyq);
        aVar.fyA.setTag(valueOf);
        aVar.dZI.setAfterClickListener(this.bdQ);
        aVar.dZI.setTag(valueOf);
        aVar.fyw.setAfterOnClickListener(this.bdQ);
        aVar.fyw.setTag(valueOf);
        aVar.fyB.setOnClickListener(this.fyr);
        aVar.fyB.setTag(valueOf);
        aVar.fyv.setOnClickListener(this.fyp);
        aVar.fyv.setFocusable(false);
        aVar.fyv.setTag(valueOf);
    }

    public void y(View.OnClickListener onClickListener) {
        this.fyp = onClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.fyq = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.fyr = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView beT;
        com.baidu.tbadk.core.view.userLike.c cVX;
        View chL;
        ClickableHeaderImageView dZI;
        LinearLayout fyA;
        LinearLayout fyB;
        ImageButton fyv;
        CommonUserLikeButton fyw;
        TextView fyx;
        ImageView fyy;
        LinearLayout fyz;
        TextView mTitle;

        private a() {
        }

        void c(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setDefaultErrorResource(d.f.icon_default_avatar100);
                clickableHeaderImageView.setDefaultBgResource(d.C0141d.cp_bg_line_e);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(e.this.bdQ);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fyk);
                        aj.r(this.mTitle, d.C0141d.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fyl);
                        aj.r(this.mTitle, d.C0141d.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.dZI.setData(markData.metaData);
                this.dZI.setShowV(markData.metaData.isBigV());
                this.cVX.a(markData.metaData);
                this.fyw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.fyw.setTextSize(0, e.fym);
                if ((markData.metaData.getIsLike() || am.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.fyw.setVisibility(8);
                } else {
                    this.fyw.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.fyB.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.fyy.setVisibility(0);
                    } else {
                        this.fyy.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.fyx.setText(e.this.mPageContext.getString(d.j.mark_thread_deleted));
                    } else {
                        this.fyx.setText(markData.getmState());
                    }
                    aj.r(this.fyx, d.C0141d.cp_cont_d);
                } else {
                    this.fyB.setVisibility(8);
                }
                aj.t(this.chL, d.C0141d.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.beT.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    aj.r(this.beT, d.C0141d.cp_cont_h);
                } else {
                    aj.r(this.beT, d.C0141d.cp_cont_f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private class d extends a {
        TbImageView cXh;
        LinearLayout fyE;

        public d(View view) {
            super();
            this.fyz = (LinearLayout) view.findViewById(d.g.home_lv_markitem);
            this.dZI = (ClickableHeaderImageView) view.findViewById(d.g.mark_userinfo_header_view);
            this.beT = (TextView) view.findViewById(d.g.mark_userinfo_name);
            this.fyA = (LinearLayout) view.findViewById(d.g.home_lv_markitem_userinfo);
            this.fyE = (LinearLayout) view.findViewById(d.g.home_lv_markitem_thread);
            this.fyw = (CommonUserLikeButton) view.findViewById(d.g.markitem_userinfo_like_btn);
            this.cVX = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fyw);
            this.cXh = (TbImageView) view.findViewById(d.g.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(d.g.markitem_thread_title);
            this.fyx = (TextView) view.findViewById(d.g.markitem_state_text);
            this.fyv = (ImageButton) view.findViewById(d.g.home_lv_markitem_delete);
            this.fyy = (ImageView) view.findViewById(d.g.new_mark_mention_redtip);
            this.fyB = (LinearLayout) view.findViewById(d.g.markitem_state);
            this.chL = view.findViewById(d.g.text_divider);
            c(this.dZI);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fyA.getLayoutParams();
            if (i.xo().xu() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.cXh.setVisibility(0);
                    this.cXh.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = e.fyn;
            } else {
                this.cXh.setVisibility(8);
                layoutParams.bottomMargin = e.fyo;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fyE.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) e.fyk;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class c extends a {
        OriginalThreadCardView fyD;

        public c(View view) {
            super();
            this.fyz = (LinearLayout) view.findViewById(d.g.share_lv_markitem);
            this.fyv = (ImageButton) view.findViewById(d.g.share_lv_markitem_delete);
            this.dZI = (ClickableHeaderImageView) view.findViewById(d.g.share_mark_userinfo_header_view);
            this.beT = (TextView) view.findViewById(d.g.share_mark_userinfo_name);
            this.fyw = (CommonUserLikeButton) view.findViewById(d.g.share_mark_item_userinfo_like_btn);
            this.cVX = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fyw);
            this.fyA = (LinearLayout) view.findViewById(d.g.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(d.g.share_thread_title);
            this.fyD = (OriginalThreadCardView) view.findViewById(d.g.share_original_thread_view);
            this.fyx = (TextView) view.findViewById(d.g.share_mark_item_state_text);
            this.fyy = (ImageView) view.findViewById(d.g.share_new_mark_mention_redtip);
            this.fyB = (LinearLayout) view.findViewById(d.g.share_mark_item_state);
            this.chL = view.findViewById(d.g.share_text_divider);
            c(this.dZI);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            this.fyD.b(markData.getOriginalThreadInfo());
            this.fyD.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fyD.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) e.fyk;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView fyC;
        ProgressBar mProgress;

        private b() {
        }
    }
}
