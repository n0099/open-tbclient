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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private static final float eUp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds32);
    private static final float eUq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds36);
    private static final float eUr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds26);
    private static final int eUs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds28);
    private static final int eUt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> adv = new ArrayList<>();
    private boolean bcp = false;
    private View.OnClickListener eUu = null;
    private View.OnClickListener eUv = null;
    private View.OnClickListener eUw = null;
    private boolean eUx = false;
    private boolean hasMore = true;
    private boolean eUy = true;
    private final View.OnClickListener apj = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            MarkData item = e.this.getItem(((Integer) view2.getTag()).intValue());
            al alVar = new al("c12529");
            if (view2 instanceof CommonUserLikeButton) {
                alVar.r("obj_locate", 4);
            } else if (view2 instanceof ClickableHeaderImageView) {
                alVar.r("obj_locate", 1);
            }
            alVar.ac("tid", item.getId());
            alVar.ac(VideoPlayActivityConfig.OBJ_ID, item.getUesrId());
            TiebaStatic.log(alVar);
        }
    };

    public e(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setRefreshing(boolean z) {
        this.eUx = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.adv.clear();
        if (arrayList != null) {
            this.adv.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (l.hf()) {
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.adv)) {
            return 0;
        }
        return this.eUy ? v.v(this.adv) + 1 : v.v(this.adv);
    }

    public void iT(boolean z) {
        this.eUy = z;
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
    /* renamed from: pI */
    public MarkData getItem(int i) {
        return (MarkData) v.c(this.adv, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.v(this.adv) <= i) {
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        b bVar;
        c cVar;
        d dVar;
        switch (getItemViewType(i)) {
            case 0:
                if (view2 == null || !(view2.getTag() instanceof d)) {
                    view2 = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.home_mark_item, (ViewGroup) null);
                    d dVar2 = new d(view2);
                    view2.setTag(dVar2);
                    dVar = dVar2;
                } else {
                    dVar = (d) view2.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    dVar.eUA.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.eUE.getLayoutParams();
                    if (this.bcp) {
                        dVar.eUA.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        dVar.eUA.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds34);
                    }
                    dVar.b(item);
                    a(i, dVar);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().u(view2);
                    break;
                }
                break;
            case 1:
                if (view2 == null || !(view2.getTag() instanceof b)) {
                    view2 = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.eUH = (TextView) view2.findViewById(d.g.page_text);
                    bVar2.mProgress = (ProgressBar) view2.findViewById(d.g.progress);
                    view2.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view2.getTag();
                }
                bVar.eUH.setVisibility(0);
                if (this.eUx) {
                    bVar.mProgress.setVisibility(0);
                    bVar.eUH.setText(this.mPageContext.getString(d.k.loading));
                    ak.c(bVar.eUH, d.C0126d.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.eUH.setText(this.mPageContext.getString(d.k.no_more_mark));
                    ak.c(bVar.eUH, d.C0126d.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.eUH.setText(this.mPageContext.getString(d.k.loading));
                    ak.c(bVar.eUH, d.C0126d.common_color_10039, 1);
                }
                this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                this.mPageContext.getLayoutMode().u(view2);
                break;
            case 2:
                if (view2 == null || !(view2.getTag() instanceof c)) {
                    view2 = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.cell_collect_share_view, (ViewGroup) null);
                    c cVar2 = new c(view2);
                    view2.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view2.getTag();
                }
                MarkData item2 = getItem(i);
                if (item2 == null) {
                    cVar.eUA.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.eUE.getLayoutParams();
                    if (this.bcp) {
                        cVar.eUA.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.eUA.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.eUI.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.e.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new al("c12529").r("obj_locate", 5));
                        }
                    });
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().u(view2);
                    break;
                }
                break;
            default:
                this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                this.mPageContext.getLayoutMode().u(view2);
                break;
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (v.w(this.adv) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void co(boolean z) {
        this.bcp = z;
    }

    public boolean MN() {
        return this.bcp;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.eUF.setOnClickListener(this.eUv);
        aVar.eUF.setTag(valueOf);
        aVar.dvN.setAfterClickListener(this.apj);
        aVar.dvN.setTag(valueOf);
        aVar.eUB.setAfterOnClickListener(this.apj);
        aVar.eUB.setTag(valueOf);
        aVar.eUG.setOnClickListener(this.eUw);
        aVar.eUG.setTag(valueOf);
        aVar.eUA.setOnClickListener(this.eUu);
        aVar.eUA.setFocusable(false);
        aVar.eUA.setTag(valueOf);
    }

    public void z(View.OnClickListener onClickListener) {
        this.eUu = onClickListener;
    }

    public void A(View.OnClickListener onClickListener) {
        this.eUv = onClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.eUw = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView aqm;
        View bxe;
        com.baidu.tbadk.core.view.userLike.c cpg;
        ClickableHeaderImageView dvN;
        ImageButton eUA;
        CommonUserLikeButton eUB;
        TextView eUC;
        ImageView eUD;
        LinearLayout eUE;
        LinearLayout eUF;
        LinearLayout eUG;
        TextView mTitle;

        private a() {
        }

        void c(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setDefaultErrorResource(d.f.icon_default_avatar100);
                clickableHeaderImageView.setDefaultBgResource(d.C0126d.cp_bg_line_e);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(e.this.apj);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.eUp);
                        ak.h(this.mTitle, d.C0126d.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.eUq);
                        ak.h(this.mTitle, d.C0126d.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.dvN.setData(markData.metaData);
                this.dvN.setShowV(markData.metaData.isBigV());
                this.cpg.a(markData.metaData);
                this.eUB.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.eUB.setTextSize(0, e.eUr);
                if ((markData.metaData.getIsLike() || an.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.eUB.setVisibility(8);
                } else {
                    this.eUB.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.eUG.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.eUD.setVisibility(0);
                    } else {
                        this.eUD.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.eUC.setText(e.this.mPageContext.getString(d.k.mark_thread_deleted));
                    } else {
                        this.eUC.setText(markData.getmState());
                    }
                    ak.h(this.eUC, d.C0126d.cp_cont_d);
                } else {
                    this.eUG.setVisibility(8);
                }
                ak.j(this.bxe, d.C0126d.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.aqm.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    ak.h(this.aqm, d.C0126d.cp_cont_h);
                } else {
                    ak.h(this.aqm, d.C0126d.cp_cont_f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private class d extends a {
        TbImageView crX;
        LinearLayout eUJ;

        public d(View view2) {
            super();
            this.eUE = (LinearLayout) view2.findViewById(d.g.home_lv_markitem);
            this.dvN = (ClickableHeaderImageView) view2.findViewById(d.g.mark_userinfo_header_view);
            this.aqm = (TextView) view2.findViewById(d.g.mark_userinfo_name);
            this.eUF = (LinearLayout) view2.findViewById(d.g.home_lv_markitem_userinfo);
            this.eUJ = (LinearLayout) view2.findViewById(d.g.home_lv_markitem_thread);
            this.eUB = (CommonUserLikeButton) view2.findViewById(d.g.markitem_userinfo_like_btn);
            this.cpg = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.eUB);
            this.crX = (TbImageView) view2.findViewById(d.g.markitem_thread_image);
            this.mTitle = (TextView) view2.findViewById(d.g.markitem_thread_title);
            this.eUC = (TextView) view2.findViewById(d.g.markitem_state_text);
            this.eUA = (ImageButton) view2.findViewById(d.g.home_lv_markitem_delete);
            this.eUD = (ImageView) view2.findViewById(d.g.new_mark_mention_redtip);
            this.eUG = (LinearLayout) view2.findViewById(d.g.markitem_state);
            this.bxe = view2.findViewById(d.g.text_divider);
            c(this.dvN);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eUF.getLayoutParams();
            if (i.pX().qd() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.crX.setVisibility(0);
                    this.crX.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = e.eUs;
            } else {
                this.crX.setVisibility(8);
                layoutParams.bottomMargin = e.eUt;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eUJ.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) e.eUp;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class c extends a {
        OriginalThreadCardView eUI;

        public c(View view2) {
            super();
            this.eUE = (LinearLayout) view2.findViewById(d.g.share_lv_markitem);
            this.eUA = (ImageButton) view2.findViewById(d.g.share_lv_markitem_delete);
            this.dvN = (ClickableHeaderImageView) view2.findViewById(d.g.share_mark_userinfo_header_view);
            this.aqm = (TextView) view2.findViewById(d.g.share_mark_userinfo_name);
            this.eUB = (CommonUserLikeButton) view2.findViewById(d.g.share_mark_item_userinfo_like_btn);
            this.cpg = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.eUB);
            this.eUF = (LinearLayout) view2.findViewById(d.g.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view2.findViewById(d.g.share_thread_title);
            this.eUI = (OriginalThreadCardView) view2.findViewById(d.g.share_original_thread_view);
            this.eUC = (TextView) view2.findViewById(d.g.share_mark_item_state_text);
            this.eUD = (ImageView) view2.findViewById(d.g.share_new_mark_mention_redtip);
            this.eUG = (LinearLayout) view2.findViewById(d.g.share_mark_item_state);
            this.bxe = view2.findViewById(d.g.share_text_divider);
            c(this.dvN);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            this.eUI.b(markData.getOriginalThreadInfo());
            this.eUI.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eUI.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) e.eUp;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView eUH;
        ProgressBar mProgress;

        private b() {
        }
    }
}
