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
    private static final float fyN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds32);
    private static final float fyO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds36);
    private static final float fyP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds26);
    private static final int fyQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds28);
    private static final int fyR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> mData = new ArrayList<>();
    private boolean bwD = false;
    private View.OnClickListener fyS = null;
    private View.OnClickListener fyT = null;
    private View.OnClickListener fyU = null;
    private boolean fyV = false;
    private boolean hasMore = true;
    private boolean fyW = true;
    private final View.OnClickListener aGk = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.e.2
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
        this.fyV = z;
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
        if (l.ln()) {
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.J(this.mData)) {
            return 0;
        }
        return this.fyW ? v.I(this.mData) + 1 : v.I(this.mData);
    }

    public void jK(boolean z) {
        this.fyW = z;
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
    /* renamed from: ra */
    public MarkData getItem(int i) {
        return (MarkData) v.d(this.mData, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.I(this.mData) <= i) {
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
                    dVar.fyY.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.fzc.getLayoutParams();
                    if (this.bwD) {
                        dVar.fyY.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        dVar.fyY.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0175e.ds34);
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
                    bVar2.fzf = (TextView) view.findViewById(e.g.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(e.g.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.fzf.setVisibility(0);
                if (this.fyV) {
                    bVar.mProgress.setVisibility(0);
                    bVar.fzf.setText(this.mPageContext.getString(e.j.loading));
                    al.c(bVar.fzf, e.d.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.fzf.setText(this.mPageContext.getString(e.j.no_more_mark));
                    al.c(bVar.fzf, e.d.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.fzf.setText(this.mPageContext.getString(e.j.loading));
                    al.c(bVar.fzf, e.d.common_color_10039, 1);
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
                    cVar.fyY.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.fzc.getLayoutParams();
                    if (this.bwD) {
                        cVar.fyY.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.fyY.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0175e.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.fzg.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.e.1
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
        if (v.J(this.mData) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void cY(boolean z) {
        this.bwD = z;
    }

    public boolean UF() {
        return this.bwD;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.fzd.setOnClickListener(this.fyT);
        aVar.fzd.setTag(valueOf);
        aVar.eat.setAfterClickListener(this.aGk);
        aVar.eat.setTag(valueOf);
        aVar.fyZ.setAfterOnClickListener(this.aGk);
        aVar.fyZ.setTag(valueOf);
        aVar.fze.setOnClickListener(this.fyU);
        aVar.fze.setTag(valueOf);
        aVar.fyY.setOnClickListener(this.fyS);
        aVar.fyY.setFocusable(false);
        aVar.fyY.setTag(valueOf);
    }

    public void A(View.OnClickListener onClickListener) {
        this.fyS = onClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.fyT = onClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.fyU = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView aGD;
        com.baidu.tbadk.core.view.userLike.c cMA;
        ClickableHeaderImageView eat;
        ImageButton fyY;
        CommonUserLikeButton fyZ;
        TextView fza;
        ImageView fzb;
        LinearLayout fzc;
        LinearLayout fzd;
        LinearLayout fze;
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
                clickableHeaderImageView.setAfterClickListener(e.this.aGk);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fyN);
                        al.h(this.mTitle, e.d.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fyO);
                        al.h(this.mTitle, e.d.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.eat.setData(markData.metaData);
                this.eat.setShowV(markData.metaData.isBigV());
                this.cMA.a(markData.metaData);
                this.fyZ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.fyZ.setTextSize(0, e.fyP);
                if ((markData.metaData.getIsLike() || ao.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.fyZ.setVisibility(8);
                } else {
                    this.fyZ.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.fze.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.fzb.setVisibility(0);
                    } else {
                        this.fzb.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.fza.setText(e.this.mPageContext.getString(e.j.mark_thread_deleted));
                    } else {
                        this.fza.setText(markData.getmState());
                    }
                    al.h(this.fza, e.d.cp_cont_d);
                } else {
                    this.fze.setVisibility(8);
                }
                al.j(this.mDivider, e.d.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.aGD.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    al.h(this.aGD, e.d.cp_cont_h);
                } else {
                    al.h(this.aGD, e.d.cp_cont_f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private class d extends a {
        TbImageView cPg;
        LinearLayout fzh;

        public d(View view) {
            super();
            this.fzc = (LinearLayout) view.findViewById(e.g.home_lv_markitem);
            this.eat = (ClickableHeaderImageView) view.findViewById(e.g.mark_userinfo_header_view);
            this.aGD = (TextView) view.findViewById(e.g.mark_userinfo_name);
            this.fzd = (LinearLayout) view.findViewById(e.g.home_lv_markitem_userinfo);
            this.fzh = (LinearLayout) view.findViewById(e.g.home_lv_markitem_thread);
            this.fyZ = (CommonUserLikeButton) view.findViewById(e.g.markitem_userinfo_like_btn);
            this.cMA = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fyZ);
            this.cPg = (TbImageView) view.findViewById(e.g.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(e.g.markitem_thread_title);
            this.fza = (TextView) view.findViewById(e.g.markitem_state_text);
            this.fyY = (ImageButton) view.findViewById(e.g.home_lv_markitem_delete);
            this.fzb = (ImageView) view.findViewById(e.g.new_mark_mention_redtip);
            this.fze = (LinearLayout) view.findViewById(e.g.markitem_state);
            this.mDivider = view.findViewById(e.g.text_divider);
            c(this.eat);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fzd.getLayoutParams();
            if (i.ws().ww() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.cPg.setVisibility(0);
                    this.cPg.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = e.fyQ;
            } else {
                this.cPg.setVisibility(8);
                layoutParams.bottomMargin = e.fyR;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fzh.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) e.fyN;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class c extends a {
        OriginalThreadCardView fzg;

        public c(View view) {
            super();
            this.fzc = (LinearLayout) view.findViewById(e.g.share_lv_markitem);
            this.fyY = (ImageButton) view.findViewById(e.g.share_lv_markitem_delete);
            this.eat = (ClickableHeaderImageView) view.findViewById(e.g.share_mark_userinfo_header_view);
            this.aGD = (TextView) view.findViewById(e.g.share_mark_userinfo_name);
            this.fyZ = (CommonUserLikeButton) view.findViewById(e.g.share_mark_item_userinfo_like_btn);
            this.cMA = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fyZ);
            this.fzd = (LinearLayout) view.findViewById(e.g.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(e.g.share_thread_title);
            this.fzg = (OriginalThreadCardView) view.findViewById(e.g.share_original_thread_view);
            this.fza = (TextView) view.findViewById(e.g.share_mark_item_state_text);
            this.fzb = (ImageView) view.findViewById(e.g.share_new_mark_mention_redtip);
            this.fze = (LinearLayout) view.findViewById(e.g.share_mark_item_state);
            this.mDivider = view.findViewById(e.g.share_text_divider);
            c(this.eat);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            this.fzg.b(markData.getOriginalThreadInfo());
            this.fzg.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fzg.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) e.fyN;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView fzf;
        ProgressBar mProgress;

        private b() {
        }
    }
}
