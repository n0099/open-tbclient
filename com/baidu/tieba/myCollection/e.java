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
    private static final float frh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds32);
    private static final float fri = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds36);
    private static final float frj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds26);
    private static final int frk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds28);
    private static final int frl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> anX = new ArrayList<>();
    private boolean bsw = false;
    private View.OnClickListener frm = null;
    private View.OnClickListener frn = null;
    private View.OnClickListener fro = null;
    private boolean frp = false;
    private boolean hasMore = true;
    private boolean frq = true;
    private final View.OnClickListener aBE = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = e.this.getItem(((Integer) view.getTag()).intValue());
            am amVar = new am("c12529");
            if (view instanceof CommonUserLikeButton) {
                amVar.w("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                amVar.w("obj_locate", 1);
            }
            amVar.al("tid", item.getId());
            amVar.al(VideoPlayActivityConfig.OBJ_ID, item.getUesrId());
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
        this.frp = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.anX.clear();
        if (arrayList != null) {
            this.anX.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (l.la()) {
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.z(this.anX)) {
            return 0;
        }
        return this.frq ? v.y(this.anX) + 1 : v.y(this.anX);
    }

    public void js(boolean z) {
        this.frq = z;
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
    /* renamed from: qC */
    public MarkData getItem(int i) {
        return (MarkData) v.d(this.anX, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.y(this.anX) <= i) {
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
                    dVar.frt.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.frx.getLayoutParams();
                    if (this.bsw) {
                        dVar.frt.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        dVar.frt.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0141e.ds34);
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
                    bVar2.frA = (TextView) view.findViewById(e.g.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(e.g.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.frA.setVisibility(0);
                if (this.frp) {
                    bVar.mProgress.setVisibility(0);
                    bVar.frA.setText(this.mPageContext.getString(e.j.loading));
                    al.c(bVar.frA, e.d.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.frA.setText(this.mPageContext.getString(e.j.no_more_mark));
                    al.c(bVar.frA, e.d.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.frA.setText(this.mPageContext.getString(e.j.loading));
                    al.c(bVar.frA, e.d.common_color_10039, 1);
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
                    cVar.frt.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.frx.getLayoutParams();
                    if (this.bsw) {
                        cVar.frt.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.frt.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0141e.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.frB.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.e.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new am("c12529").w("obj_locate", 5));
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
        if (v.z(this.anX) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void cP(boolean z) {
        this.bsw = z;
    }

    public boolean SJ() {
        return this.bsw;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.fry.setOnClickListener(this.frn);
        aVar.fry.setTag(valueOf);
        aVar.dSy.setAfterClickListener(this.aBE);
        aVar.dSy.setTag(valueOf);
        aVar.fru.setAfterOnClickListener(this.aBE);
        aVar.fru.setTag(valueOf);
        aVar.frz.setOnClickListener(this.fro);
        aVar.frz.setTag(valueOf);
        aVar.frt.setOnClickListener(this.frm);
        aVar.frt.setFocusable(false);
        aVar.frt.setTag(valueOf);
    }

    public void A(View.OnClickListener onClickListener) {
        this.frm = onClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.frn = onClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.fro = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView aBX;
        View bNG;
        com.baidu.tbadk.core.view.userLike.c cEg;
        ClickableHeaderImageView dSy;
        ImageButton frt;
        CommonUserLikeButton fru;
        TextView frv;
        ImageView frw;
        LinearLayout frx;
        LinearLayout fry;
        LinearLayout frz;
        TextView mTitle;

        private a() {
        }

        void c(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setDefaultErrorResource(e.f.icon_default_avatar100);
                clickableHeaderImageView.setDefaultBgResource(e.d.cp_bg_line_e);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(e.this.aBE);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.frh);
                        al.h(this.mTitle, e.d.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fri);
                        al.h(this.mTitle, e.d.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.dSy.setData(markData.metaData);
                this.dSy.setShowV(markData.metaData.isBigV());
                this.cEg.a(markData.metaData);
                this.fru.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.fru.setTextSize(0, e.frj);
                if ((markData.metaData.getIsLike() || ao.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.fru.setVisibility(8);
                } else {
                    this.fru.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.frz.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.frw.setVisibility(0);
                    } else {
                        this.frw.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.frv.setText(e.this.mPageContext.getString(e.j.mark_thread_deleted));
                    } else {
                        this.frv.setText(markData.getmState());
                    }
                    al.h(this.frv, e.d.cp_cont_d);
                } else {
                    this.frz.setVisibility(8);
                }
                al.j(this.bNG, e.d.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.aBX.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    al.h(this.aBX, e.d.cp_cont_h);
                } else {
                    al.h(this.aBX, e.d.cp_cont_f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private class d extends a {
        TbImageView cGM;
        LinearLayout frC;

        public d(View view) {
            super();
            this.frx = (LinearLayout) view.findViewById(e.g.home_lv_markitem);
            this.dSy = (ClickableHeaderImageView) view.findViewById(e.g.mark_userinfo_header_view);
            this.aBX = (TextView) view.findViewById(e.g.mark_userinfo_name);
            this.fry = (LinearLayout) view.findViewById(e.g.home_lv_markitem_userinfo);
            this.frC = (LinearLayout) view.findViewById(e.g.home_lv_markitem_thread);
            this.fru = (CommonUserLikeButton) view.findViewById(e.g.markitem_userinfo_like_btn);
            this.cEg = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fru);
            this.cGM = (TbImageView) view.findViewById(e.g.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(e.g.markitem_thread_title);
            this.frv = (TextView) view.findViewById(e.g.markitem_state_text);
            this.frt = (ImageButton) view.findViewById(e.g.home_lv_markitem_delete);
            this.frw = (ImageView) view.findViewById(e.g.new_mark_mention_redtip);
            this.frz = (LinearLayout) view.findViewById(e.g.markitem_state);
            this.bNG = view.findViewById(e.g.text_divider);
            c(this.dSy);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fry.getLayoutParams();
            if (i.uj().un() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.cGM.setVisibility(0);
                    this.cGM.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = e.frk;
            } else {
                this.cGM.setVisibility(8);
                layoutParams.bottomMargin = e.frl;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.frC.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) e.frh;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class c extends a {
        OriginalThreadCardView frB;

        public c(View view) {
            super();
            this.frx = (LinearLayout) view.findViewById(e.g.share_lv_markitem);
            this.frt = (ImageButton) view.findViewById(e.g.share_lv_markitem_delete);
            this.dSy = (ClickableHeaderImageView) view.findViewById(e.g.share_mark_userinfo_header_view);
            this.aBX = (TextView) view.findViewById(e.g.share_mark_userinfo_name);
            this.fru = (CommonUserLikeButton) view.findViewById(e.g.share_mark_item_userinfo_like_btn);
            this.cEg = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fru);
            this.fry = (LinearLayout) view.findViewById(e.g.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(e.g.share_thread_title);
            this.frB = (OriginalThreadCardView) view.findViewById(e.g.share_original_thread_view);
            this.frv = (TextView) view.findViewById(e.g.share_mark_item_state_text);
            this.frw = (ImageView) view.findViewById(e.g.share_new_mark_mention_redtip);
            this.frz = (LinearLayout) view.findViewById(e.g.share_mark_item_state);
            this.bNG = view.findViewById(e.g.share_text_divider);
            c(this.dSy);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            this.frB.b(markData.getOriginalThreadInfo());
            this.frB.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.frB.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) e.frh;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView frA;
        ProgressBar mProgress;

        private b() {
        }
    }
}
