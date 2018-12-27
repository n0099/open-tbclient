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
    private static final float fJS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds32);
    private static final float fJT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds36);
    private static final float fJU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds26);
    private static final int fJV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds28);
    private static final int fJW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> mData = new ArrayList<>();
    private boolean bAO = false;
    private View.OnClickListener fJX = null;
    private View.OnClickListener fJY = null;
    private View.OnClickListener fJZ = null;
    private boolean fKa = false;
    private boolean hasMore = true;
    private boolean fKb = true;
    private final View.OnClickListener aKC = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = e.this.getItem(((Integer) view.getTag()).intValue());
            am amVar = new am("c12529");
            if (view instanceof CommonUserLikeButton) {
                amVar.x("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                amVar.x("obj_locate", 1);
            }
            amVar.aA("tid", item.getId());
            amVar.aA(VideoPlayActivityConfig.OBJ_ID, item.getUesrId());
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
        this.fKa = z;
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
        if (l.lk()) {
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.I(this.mData)) {
            return 0;
        }
        return this.fKb ? v.H(this.mData) + 1 : v.H(this.mData);
    }

    public void ka(boolean z) {
        this.fKb = z;
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
    /* renamed from: sa */
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
                    dVar.fKd.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.fKh.getLayoutParams();
                    if (this.bAO) {
                        dVar.fKd.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        dVar.fKd.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0210e.ds34);
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
                    bVar2.fKk = (TextView) view.findViewById(e.g.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(e.g.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.fKk.setVisibility(0);
                if (this.fKa) {
                    bVar.mProgress.setVisibility(0);
                    bVar.fKk.setText(this.mPageContext.getString(e.j.loading));
                    al.c(bVar.fKk, e.d.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.fKk.setText(this.mPageContext.getString(e.j.no_more_mark));
                    al.c(bVar.fKk, e.d.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.fKk.setText(this.mPageContext.getString(e.j.loading));
                    al.c(bVar.fKk, e.d.common_color_10039, 1);
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
                    cVar.fKd.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.fKh.getLayoutParams();
                    if (this.bAO) {
                        cVar.fKd.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.fKd.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(e.C0210e.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.fKl.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.e.1
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

    public void dq(boolean z) {
        this.bAO = z;
    }

    public boolean VW() {
        return this.bAO;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.fKi.setOnClickListener(this.fJY);
        aVar.fKi.setTag(valueOf);
        aVar.elg.setAfterClickListener(this.aKC);
        aVar.elg.setTag(valueOf);
        aVar.fKe.setAfterOnClickListener(this.aKC);
        aVar.fKe.setTag(valueOf);
        aVar.fKj.setOnClickListener(this.fJZ);
        aVar.fKj.setTag(valueOf);
        aVar.fKd.setOnClickListener(this.fJX);
        aVar.fKd.setFocusable(false);
        aVar.fKd.setTag(valueOf);
    }

    public void C(View.OnClickListener onClickListener) {
        this.fJX = onClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.fJY = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fJZ = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView aKV;
        com.baidu.tbadk.core.view.userLike.c cXd;
        ClickableHeaderImageView elg;
        ImageButton fKd;
        CommonUserLikeButton fKe;
        TextView fKf;
        ImageView fKg;
        LinearLayout fKh;
        LinearLayout fKi;
        LinearLayout fKj;
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
                clickableHeaderImageView.setAfterClickListener(e.this.aKC);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fJS);
                        al.h(this.mTitle, e.d.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fJT);
                        al.h(this.mTitle, e.d.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.elg.setData(markData.metaData);
                this.elg.setShowV(markData.metaData.isBigV());
                this.cXd.a(markData.metaData);
                this.fKe.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.fKe.setTextSize(0, e.fJU);
                if ((markData.metaData.getIsLike() || ao.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.fKe.setVisibility(8);
                } else {
                    this.fKe.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.fKj.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.fKg.setVisibility(0);
                    } else {
                        this.fKg.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.fKf.setText(e.this.mPageContext.getString(e.j.mark_thread_deleted));
                    } else {
                        this.fKf.setText(markData.getmState());
                    }
                    al.h(this.fKf, e.d.cp_cont_d);
                } else {
                    this.fKj.setVisibility(8);
                }
                al.j(this.mDivider, e.d.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.aKV.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    al.h(this.aKV, e.d.cp_cont_h);
                } else {
                    al.h(this.aKV, e.d.cp_cont_f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private class d extends a {
        TbImageView cZJ;
        LinearLayout fKm;

        public d(View view) {
            super();
            this.fKh = (LinearLayout) view.findViewById(e.g.home_lv_markitem);
            this.elg = (ClickableHeaderImageView) view.findViewById(e.g.mark_userinfo_header_view);
            this.aKV = (TextView) view.findViewById(e.g.mark_userinfo_name);
            this.fKi = (LinearLayout) view.findViewById(e.g.home_lv_markitem_userinfo);
            this.fKm = (LinearLayout) view.findViewById(e.g.home_lv_markitem_thread);
            this.fKe = (CommonUserLikeButton) view.findViewById(e.g.markitem_userinfo_like_btn);
            this.cXd = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fKe);
            this.cZJ = (TbImageView) view.findViewById(e.g.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(e.g.markitem_thread_title);
            this.fKf = (TextView) view.findViewById(e.g.markitem_state_text);
            this.fKd = (ImageButton) view.findViewById(e.g.home_lv_markitem_delete);
            this.fKg = (ImageView) view.findViewById(e.g.new_mark_mention_redtip);
            this.fKj = (LinearLayout) view.findViewById(e.g.markitem_state);
            this.mDivider = view.findViewById(e.g.text_divider);
            c(this.elg);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fKi.getLayoutParams();
            if (i.xE().xI() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.cZJ.setVisibility(0);
                    this.cZJ.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = e.fJV;
            } else {
                this.cZJ.setVisibility(8);
                layoutParams.bottomMargin = e.fJW;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fKm.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) e.fJS;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class c extends a {
        OriginalThreadCardView fKl;

        public c(View view) {
            super();
            this.fKh = (LinearLayout) view.findViewById(e.g.share_lv_markitem);
            this.fKd = (ImageButton) view.findViewById(e.g.share_lv_markitem_delete);
            this.elg = (ClickableHeaderImageView) view.findViewById(e.g.share_mark_userinfo_header_view);
            this.aKV = (TextView) view.findViewById(e.g.share_mark_userinfo_name);
            this.fKe = (CommonUserLikeButton) view.findViewById(e.g.share_mark_item_userinfo_like_btn);
            this.cXd = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fKe);
            this.fKi = (LinearLayout) view.findViewById(e.g.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(e.g.share_thread_title);
            this.fKl = (OriginalThreadCardView) view.findViewById(e.g.share_original_thread_view);
            this.fKf = (TextView) view.findViewById(e.g.share_mark_item_state_text);
            this.fKg = (ImageView) view.findViewById(e.g.share_new_mark_mention_redtip);
            this.fKj = (LinearLayout) view.findViewById(e.g.share_mark_item_state);
            this.mDivider = view.findViewById(e.g.share_text_divider);
            c(this.elg);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            this.fKl.b(markData.getOriginalThreadInfo());
            this.fKl.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fKl.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) e.fJS;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView fKk;
        ProgressBar mProgress;

        private b() {
        }
    }
}
