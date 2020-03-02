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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class d extends BaseAdapter {
    private static final float ist = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float isu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float isv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int isw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int isx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> cVR = new ArrayList<>();
    private boolean dXX = false;
    private View.OnClickListener isy = null;
    private View.OnClickListener isz = null;
    private View.OnClickListener isA = null;
    private boolean isB = false;
    private boolean hasMore = true;
    private boolean isC = true;
    private final View.OnClickListener Nw = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            an anVar = new an("c12529");
            if (view instanceof CommonUserLikeButton) {
                anVar.X("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                anVar.X("obj_locate", 1);
            }
            anVar.cy("tid", item.getId());
            anVar.cy("obj_id", item.getUesrId());
            TiebaStatic.log(anVar);
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setRefreshing(boolean z) {
        this.isB = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.cVR.clear();
        if (arrayList != null) {
            this.cVR.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (l.isMainThread()) {
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.cVR)) {
            return 0;
        }
        return this.isC ? v.getCount(this.cVR) + 1 : v.getCount(this.cVR);
    }

    public void oY(boolean z) {
        this.isC = z;
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
    /* renamed from: ym */
    public MarkData getItem(int i) {
        return (MarkData) v.getItem(this.cVR, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.getCount(this.cVR) <= i) {
            return -1L;
        }
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001f  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        c cVar;
        C0563d c0563d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0563d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0563d c0563d2 = new C0563d(view);
                    view.setTag(c0563d2);
                    c0563d = c0563d2;
                } else {
                    c0563d = (C0563d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0563d.isE.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0563d.isI.getLayoutParams();
                    if (this.dXX) {
                        c0563d.isE.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0563d.isE.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0563d.b(item);
                    a(i, c0563d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.isL = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.isL.setVisibility(0);
                if (this.isB) {
                    bVar.mProgress.setVisibility(0);
                    bVar.isL.setText(this.mPageContext.getString(R.string.loading));
                    am.setViewTextColor(bVar.isL, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.isL.setText(this.mPageContext.getString(R.string.no_more_mark));
                    am.setViewTextColor(bVar.isL, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.isL.setText(this.mPageContext.getString(R.string.loading));
                    am.setViewTextColor(bVar.isL, R.color.common_color_10039, 1);
                }
                this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                this.mPageContext.getLayoutMode().onModeChanged(view);
                break;
            case 2:
                if (view == null || !(view.getTag() instanceof c)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.cell_collect_share_view, (ViewGroup) null);
                    c cVar2 = new c(view);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                MarkData item2 = getItem(i);
                if (item2 == null) {
                    cVar.isE.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.isI.getLayoutParams();
                    if (this.dXX) {
                        cVar.isE.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.isE.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.Mv.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new an("c12529").X("obj_locate", 5));
                        }
                    });
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
            default:
                this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                this.mPageContext.getLayoutMode().onModeChanged(view);
                break;
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (v.isEmpty(this.cVR) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void hC(boolean z) {
        this.dXX = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.isJ.setOnClickListener(this.isz);
        aVar.isJ.setTag(valueOf);
        aVar.gRp.setAfterClickListener(this.Nw);
        aVar.gRp.setTag(valueOf);
        aVar.isF.setAfterOnClickListener(this.Nw);
        aVar.isF.setTag(valueOf);
        aVar.isK.setOnClickListener(this.isA);
        aVar.isK.setTag(valueOf);
        aVar.isE.setOnClickListener(this.isy);
        aVar.isE.setFocusable(false);
        aVar.isE.setTag(valueOf);
    }

    public void J(View.OnClickListener onClickListener) {
        this.isy = onClickListener;
    }

    public void K(View.OnClickListener onClickListener) {
        this.isz = onClickListener;
    }

    public void L(View.OnClickListener onClickListener) {
        this.isA = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c NB;
        TextView cbK;
        ClickableHeaderImageView gRp;
        ImageButton isE;
        CommonUserLikeButton isF;
        TextView isG;
        ImageView isH;
        LinearLayout isI;
        LinearLayout isJ;
        LinearLayout isK;
        View mDivider;
        TextView mTitle;

        private a() {
        }

        void d(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                clickableHeaderImageView.setPlaceHolder(1);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(d.this.Nw);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.ist);
                        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.isu);
                        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.gRp.setData(markData.metaData);
                this.gRp.setShowV(markData.metaData.isBigV());
                this.NB.a(markData.metaData);
                this.isF.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.isF.setTextSize(0, d.isv);
                if ((markData.metaData.getIsLike() || aq.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.isF.setVisibility(8);
                } else {
                    this.isF.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.isK.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.isH.setVisibility(0);
                    } else {
                        this.isH.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.isG.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.isG.setText(markData.getmState());
                    }
                    am.setViewTextColor(this.isG, (int) R.color.cp_cont_d);
                } else {
                    this.isK.setVisibility(8);
                }
                am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.cbK.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    am.setViewTextColor(this.cbK, (int) R.color.cp_cont_h);
                } else {
                    am.setViewTextColor(this.cbK, (int) R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0563d extends a {
        TbImageView fLG;
        LinearLayout isM;

        public C0563d(View view) {
            super();
            this.isI = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.gRp = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.cbK = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.isJ = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.isM = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.isF = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.NB = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.isF);
            this.fLG = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.isG = (TextView) view.findViewById(R.id.markitem_state_text);
            this.isE = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.isH = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.isK = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.mDivider = view.findViewById(R.id.text_divider);
            d(this.gRp);
            this.fLG.setPlaceHolder(2);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.isJ.getLayoutParams();
            if (i.azO().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.fLG.setVisibility(0);
                    this.fLG.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.isw;
            } else {
                this.fLG.setVisibility(8);
                layoutParams.bottomMargin = d.isx;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.isM.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.ist;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes11.dex */
    private class c extends a {
        OriginalThreadCardView Mv;

        public c(View view) {
            super();
            this.isI = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.isE = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.gRp = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.cbK = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.isF = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.NB = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.isF);
            this.isJ = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.Mv = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.isG = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.isH = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.isK = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.mDivider = view.findViewById(R.id.share_text_divider);
            d(this.gRp);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.Mv.b(markData.getOriginalThreadInfo());
            this.Mv.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Mv.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.ist;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes11.dex */
    private class b {
        TextView isL;
        ProgressBar mProgress;

        private b() {
        }
    }
}
