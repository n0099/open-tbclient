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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private static final float fjF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds32);
    private static final float fjG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds36);
    private static final float fjH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds26);
    private static final int fjI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds28);
    private static final int fjJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> alT = new ArrayList<>();
    private boolean blY = false;
    private View.OnClickListener fjK = null;
    private View.OnClickListener fjL = null;
    private View.OnClickListener fjM = null;
    private boolean fjN = false;
    private boolean hasMore = true;
    private boolean fjO = true;
    private final View.OnClickListener ayi = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = e.this.getItem(((Integer) view.getTag()).intValue());
            an anVar = new an("c12529");
            if (view instanceof CommonUserLikeButton) {
                anVar.r("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                anVar.r("obj_locate", 1);
            }
            anVar.ah("tid", item.getId());
            anVar.ah(VideoPlayActivityConfig.OBJ_ID, item.getUesrId());
            TiebaStatic.log(anVar);
        }
    };

    public e(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setRefreshing(boolean z) {
        this.fjN = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.alT.clear();
        if (arrayList != null) {
            this.alT.addAll(arrayList);
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
        if (w.A(this.alT)) {
            return 0;
        }
        return this.fjO ? w.z(this.alT) + 1 : w.z(this.alT);
    }

    public void ji(boolean z) {
        this.fjO = z;
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
    /* renamed from: qb */
    public MarkData getItem(int i) {
        return (MarkData) w.d(this.alT, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (w.z(this.alT) <= i) {
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
                    dVar.fjQ.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.fjU.getLayoutParams();
                    if (this.blY) {
                        dVar.fjQ.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        dVar.fjQ.setVisibility(8);
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
                    bVar2.fjX = (TextView) view.findViewById(d.g.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(d.g.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.fjX.setVisibility(0);
                if (this.fjN) {
                    bVar.mProgress.setVisibility(0);
                    bVar.fjX.setText(this.mPageContext.getString(d.k.loading));
                    am.c(bVar.fjX, d.C0142d.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.fjX.setText(this.mPageContext.getString(d.k.no_more_mark));
                    am.c(bVar.fjX, d.C0142d.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.fjX.setText(this.mPageContext.getString(d.k.loading));
                    am.c(bVar.fjX, d.C0142d.common_color_10039, 1);
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
                    cVar.fjQ.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.fjU.getLayoutParams();
                    if (this.blY) {
                        cVar.fjQ.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.fjQ.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.fjY.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.e.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new an("c12529").r("obj_locate", 5));
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
        if (w.A(this.alT) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void cx(boolean z) {
        this.blY = z;
    }

    public boolean QJ() {
        return this.blY;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.fjV.setOnClickListener(this.fjL);
        aVar.fjV.setTag(valueOf);
        aVar.dIv.setAfterClickListener(this.ayi);
        aVar.dIv.setTag(valueOf);
        aVar.fjR.setAfterOnClickListener(this.ayi);
        aVar.fjR.setTag(valueOf);
        aVar.fjW.setOnClickListener(this.fjM);
        aVar.fjW.setTag(valueOf);
        aVar.fjQ.setOnClickListener(this.fjK);
        aVar.fjQ.setFocusable(false);
        aVar.fjQ.setTag(valueOf);
    }

    public void C(View.OnClickListener onClickListener) {
        this.fjK = onClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.fjL = onClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fjM = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView azm;
        View bHc;
        com.baidu.tbadk.core.view.userLike.c cvR;
        ClickableHeaderImageView dIv;
        ImageButton fjQ;
        CommonUserLikeButton fjR;
        TextView fjS;
        ImageView fjT;
        LinearLayout fjU;
        LinearLayout fjV;
        LinearLayout fjW;
        TextView mTitle;

        private a() {
        }

        void c(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setDefaultErrorResource(d.f.icon_default_avatar100);
                clickableHeaderImageView.setDefaultBgResource(d.C0142d.cp_bg_line_e);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(e.this.ayi);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fjF);
                        am.h(this.mTitle, d.C0142d.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.fjG);
                        am.h(this.mTitle, d.C0142d.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.dIv.setData(markData.metaData);
                this.dIv.setShowV(markData.metaData.isBigV());
                this.cvR.a(markData.metaData);
                this.fjR.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.fjR.setTextSize(0, e.fjH);
                if ((markData.metaData.getIsLike() || ap.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.fjR.setVisibility(8);
                } else {
                    this.fjR.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.fjW.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.fjT.setVisibility(0);
                    } else {
                        this.fjT.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.fjS.setText(e.this.mPageContext.getString(d.k.mark_thread_deleted));
                    } else {
                        this.fjS.setText(markData.getmState());
                    }
                    am.h(this.fjS, d.C0142d.cp_cont_d);
                } else {
                    this.fjW.setVisibility(8);
                }
                am.j(this.bHc, d.C0142d.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.azm.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    am.h(this.azm, d.C0142d.cp_cont_h);
                } else {
                    am.h(this.azm, d.C0142d.cp_cont_f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private class d extends a {
        TbImageView cyu;
        LinearLayout fjZ;

        public d(View view) {
            super();
            this.fjU = (LinearLayout) view.findViewById(d.g.home_lv_markitem);
            this.dIv = (ClickableHeaderImageView) view.findViewById(d.g.mark_userinfo_header_view);
            this.azm = (TextView) view.findViewById(d.g.mark_userinfo_name);
            this.fjV = (LinearLayout) view.findViewById(d.g.home_lv_markitem_userinfo);
            this.fjZ = (LinearLayout) view.findViewById(d.g.home_lv_markitem_thread);
            this.fjR = (CommonUserLikeButton) view.findViewById(d.g.markitem_userinfo_like_btn);
            this.cvR = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fjR);
            this.cyu = (TbImageView) view.findViewById(d.g.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(d.g.markitem_thread_title);
            this.fjS = (TextView) view.findViewById(d.g.markitem_state_text);
            this.fjQ = (ImageButton) view.findViewById(d.g.home_lv_markitem_delete);
            this.fjT = (ImageView) view.findViewById(d.g.new_mark_mention_redtip);
            this.fjW = (LinearLayout) view.findViewById(d.g.markitem_state);
            this.bHc = view.findViewById(d.g.text_divider);
            c(this.dIv);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjV.getLayoutParams();
            if (i.tt().tz() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.cyu.setVisibility(0);
                    this.cyu.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = e.fjI;
            } else {
                this.cyu.setVisibility(8);
                layoutParams.bottomMargin = e.fjJ;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fjZ.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) e.fjF;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class c extends a {
        OriginalThreadCardView fjY;

        public c(View view) {
            super();
            this.fjU = (LinearLayout) view.findViewById(d.g.share_lv_markitem);
            this.fjQ = (ImageButton) view.findViewById(d.g.share_lv_markitem_delete);
            this.dIv = (ClickableHeaderImageView) view.findViewById(d.g.share_mark_userinfo_header_view);
            this.azm = (TextView) view.findViewById(d.g.share_mark_userinfo_name);
            this.fjR = (CommonUserLikeButton) view.findViewById(d.g.share_mark_item_userinfo_like_btn);
            this.cvR = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.fjR);
            this.fjV = (LinearLayout) view.findViewById(d.g.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(d.g.share_thread_title);
            this.fjY = (OriginalThreadCardView) view.findViewById(d.g.share_original_thread_view);
            this.fjS = (TextView) view.findViewById(d.g.share_mark_item_state_text);
            this.fjT = (ImageView) view.findViewById(d.g.share_new_mark_mention_redtip);
            this.fjW = (LinearLayout) view.findViewById(d.g.share_mark_item_state);
            this.bHc = view.findViewById(d.g.share_text_divider);
            c(this.dIv);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            this.fjY.b(markData.getOriginalThreadInfo());
            this.fjY.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjY.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) e.fjF;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView fjX;
        ProgressBar mProgress;

        private b() {
        }
    }
}
