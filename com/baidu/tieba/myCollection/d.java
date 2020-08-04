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
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class d extends BaseAdapter {
    private static final float jUo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float jUp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float jUq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int jUr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int jUs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> dWx = new ArrayList<>();
    private boolean fca = false;
    private View.OnClickListener jUt = null;
    private View.OnClickListener jUu = null;
    private View.OnClickListener jUv = null;
    private boolean jUw = false;
    private boolean hasMore = true;
    private boolean jUx = true;
    private final View.OnClickListener ahD = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            ap apVar = new ap("c12529");
            if (view instanceof CommonUserLikeButton) {
                apVar.ah("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                apVar.ah("obj_locate", 1);
            }
            apVar.dn("tid", item.getId());
            apVar.dn("obj_id", item.getUesrId());
            TiebaStatic.log(apVar);
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setRefreshing(boolean z) {
        this.jUw = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.dWx.clear();
        if (arrayList != null) {
            this.dWx.addAll(arrayList);
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
        if (x.isEmpty(this.dWx)) {
            return 0;
        }
        return this.jUx ? x.getCount(this.dWx) + 1 : x.getCount(this.dWx);
    }

    public void ru(boolean z) {
        this.jUx = z;
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
    /* renamed from: AQ */
    public MarkData getItem(int i) {
        return (MarkData) x.getItem(this.dWx, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (x.getCount(this.dWx) <= i) {
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
        C0698d c0698d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0698d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0698d c0698d2 = new C0698d(view);
                    view.setTag(c0698d2);
                    c0698d = c0698d2;
                } else {
                    c0698d = (C0698d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0698d.jUz.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0698d.jUD.getLayoutParams();
                    if (this.fca) {
                        c0698d.jUz.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0698d.jUz.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0698d.b(item);
                    a(i, c0698d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.jUG = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.jUG.setVisibility(0);
                if (this.jUw) {
                    bVar.mProgress.setVisibility(0);
                    bVar.jUG.setText(this.mPageContext.getString(R.string.loading));
                    ao.setViewTextColor(bVar.jUG, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.jUG.setText(this.mPageContext.getString(R.string.no_more_mark));
                    ao.setViewTextColor(bVar.jUG, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.jUG.setText(this.mPageContext.getString(R.string.loading));
                    ao.setViewTextColor(bVar.jUG, R.color.common_color_10039, 1);
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
                    cVar.jUz.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.jUD.getLayoutParams();
                    if (this.fca) {
                        cVar.jUz.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.jUz.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.agm.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new ap("c12529").ah("obj_locate", 5));
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
        if (x.isEmpty(this.dWx) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void jO(boolean z) {
        this.fca = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.jUE.setOnClickListener(this.jUu);
        aVar.jUE.setTag(valueOf);
        aVar.imD.setAfterClickListener(this.ahD);
        aVar.imD.setTag(valueOf);
        aVar.jUA.setAfterOnClickListener(this.ahD);
        aVar.jUA.setTag(valueOf);
        aVar.jUF.setOnClickListener(this.jUv);
        aVar.jUF.setTag(valueOf);
        aVar.jUz.setOnClickListener(this.jUt);
        aVar.jUz.setFocusable(false);
        aVar.jUz.setTag(valueOf);
    }

    public void L(View.OnClickListener onClickListener) {
        this.jUt = onClickListener;
    }

    public void M(View.OnClickListener onClickListener) {
        this.jUu = onClickListener;
    }

    public void N(View.OnClickListener onClickListener) {
        this.jUv = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c ahO;
        TextView dKI;
        ClickableHeaderImageView imD;
        CommonUserLikeButton jUA;
        TextView jUB;
        ImageView jUC;
        LinearLayout jUD;
        LinearLayout jUE;
        LinearLayout jUF;
        ImageButton jUz;
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
                clickableHeaderImageView.setAfterClickListener(d.this.ahD);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.jUo);
                        ao.setViewTextColor(this.mTitle, R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.jUp);
                        ao.setViewTextColor(this.mTitle, R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.imD.setData(markData.metaData);
                this.imD.setShowV(markData.metaData.isBigV());
                this.ahO.a(markData.metaData);
                this.jUA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.jUA.setTextSize(0, d.jUq);
                if ((markData.metaData.getIsLike() || as.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.jUA.setVisibility(8);
                } else {
                    this.jUA.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.jUF.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.jUC.setVisibility(0);
                    } else {
                        this.jUC.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.jUB.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.jUB.setText(markData.getmState());
                    }
                    ao.setViewTextColor(this.jUB, R.color.cp_cont_d);
                } else {
                    this.jUF.setVisibility(8);
                }
                ao.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.dKI.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    ao.setViewTextColor(this.dKI, R.color.cp_cont_h);
                } else {
                    ao.setViewTextColor(this.dKI, R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private class C0698d extends a {
        TbImageView gYM;
        LinearLayout jUH;

        public C0698d(View view) {
            super();
            this.jUD = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.imD = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.dKI = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.jUE = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.jUH = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.jUA = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.ahO = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.jUA);
            this.gYM = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.jUB = (TextView) view.findViewById(R.id.markitem_state_text);
            this.jUz = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.jUC = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.jUF = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.mDivider = view.findViewById(R.id.text_divider);
            d(this.imD);
            this.gYM.setPlaceHolder(2);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jUE.getLayoutParams();
            if (k.aTv().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.gYM.setVisibility(0);
                    this.gYM.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.jUr;
            } else {
                this.gYM.setVisibility(8);
                layoutParams.bottomMargin = d.jUs;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jUH.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.jUo;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes18.dex */
    private class c extends a {
        OriginalThreadCardView agm;

        public c(View view) {
            super();
            this.jUD = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.jUz = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.imD = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.dKI = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.jUA = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.ahO = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.jUA);
            this.jUE = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.agm = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.jUB = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.jUC = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.jUF = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.mDivider = view.findViewById(R.id.share_text_divider);
            d(this.imD);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.agm.b(markData.getOriginalThreadInfo());
            this.agm.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.agm.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.jUo;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes18.dex */
    private class b {
        TextView jUG;
        ProgressBar mProgress;

        private b() {
        }
    }
}
