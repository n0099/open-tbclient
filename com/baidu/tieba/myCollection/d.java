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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class d extends BaseAdapter {
    private static final float kjR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float kjS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float kjT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int kjU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int kjV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> egb = new ArrayList<>();
    private boolean fny = false;
    private View.OnClickListener kjW = null;
    private View.OnClickListener kjX = null;
    private View.OnClickListener kjY = null;
    private boolean kjZ = false;
    private boolean hasMore = true;
    private boolean kka = true;
    private final View.OnClickListener aiT = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            aq aqVar = new aq("c12529");
            if (view instanceof CommonUserLikeButton) {
                aqVar.ai("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                aqVar.ai("obj_locate", 1);
            }
            aqVar.dD("tid", item.getId());
            aqVar.dD("obj_id", item.getUesrId());
            TiebaStatic.log(aqVar);
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setRefreshing(boolean z) {
        this.kjZ = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.egb.clear();
        if (arrayList != null) {
            this.egb.addAll(arrayList);
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
        if (y.isEmpty(this.egb)) {
            return 0;
        }
        return this.kka ? y.getCount(this.egb) + 1 : y.getCount(this.egb);
    }

    public void sc(boolean z) {
        this.kka = z;
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
    /* renamed from: Dj */
    public MarkData getItem(int i) {
        return (MarkData) y.getItem(this.egb, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (y.getCount(this.egb) <= i) {
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
        C0749d c0749d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0749d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0749d c0749d2 = new C0749d(view);
                    view.setTag(c0749d2);
                    c0749d = c0749d2;
                } else {
                    c0749d = (C0749d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0749d.kkc.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0749d.kkg.getLayoutParams();
                    if (this.fny) {
                        c0749d.kkc.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0749d.kkc.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0749d.b(item);
                    a(i, c0749d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.kkj = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.kkj.setVisibility(0);
                if (this.kjZ) {
                    bVar.mProgress.setVisibility(0);
                    bVar.kkj.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.kkj, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.kkj.setText(this.mPageContext.getString(R.string.no_more_mark));
                    ap.setViewTextColor(bVar.kkj, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.kkj.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.kkj, R.color.common_color_10039, 1);
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
                    cVar.kkc.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.kkg.getLayoutParams();
                    if (this.fny) {
                        cVar.kkc.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.kkc.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.ahw.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new aq("c12529").ai("obj_locate", 5));
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
        if (y.isEmpty(this.egb) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void ko(boolean z) {
        this.fny = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.kkh.setOnClickListener(this.kjX);
        aVar.kkh.setTag(valueOf);
        aVar.iAN.setAfterClickListener(this.aiT);
        aVar.iAN.setTag(valueOf);
        aVar.kkd.setAfterOnClickListener(this.aiT);
        aVar.kkd.setTag(valueOf);
        aVar.kki.setOnClickListener(this.kjY);
        aVar.kki.setTag(valueOf);
        aVar.kkc.setOnClickListener(this.kjW);
        aVar.kkc.setFocusable(false);
        aVar.kkc.setTag(valueOf);
    }

    public void M(View.OnClickListener onClickListener) {
        this.kjW = onClickListener;
    }

    public void N(View.OnClickListener onClickListener) {
        this.kjX = onClickListener;
    }

    public void O(View.OnClickListener onClickListener) {
        this.kjY = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c aje;
        TextView dTU;
        ClickableHeaderImageView iAN;
        ImageButton kkc;
        CommonUserLikeButton kkd;
        TextView kke;
        ImageView kkf;
        LinearLayout kkg;
        LinearLayout kkh;
        LinearLayout kki;
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
                clickableHeaderImageView.setAfterClickListener(d.this.aiT);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.kjR);
                        ap.setViewTextColor(this.mTitle, R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.kjS);
                        ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.iAN.setData(markData.metaData);
                this.iAN.setShowV(markData.metaData.isBigV());
                this.aje.a(markData.metaData);
                this.kkd.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.kkd.setTextSize(0, d.kjT);
                if ((markData.metaData.getIsLike() || at.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.kkd.setVisibility(8);
                } else {
                    this.kkd.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.kki.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.kkf.setVisibility(0);
                    } else {
                        this.kkf.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.kke.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.kke.setText(markData.getmState());
                    }
                    ap.setViewTextColor(this.kke, R.color.cp_cont_d);
                } else {
                    this.kki.setVisibility(8);
                }
                ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.dTU.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    ap.setViewTextColor(this.dTU, R.color.cp_cont_h);
                } else {
                    ap.setViewTextColor(this.dTU, R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private class C0749d extends a {
        TbImageView hlJ;
        LinearLayout kkk;

        public C0749d(View view) {
            super();
            this.kkg = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.iAN = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.dTU = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.kkh = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.kkk = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.kkd = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.aje = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.kkd);
            this.hlJ = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.kke = (TextView) view.findViewById(R.id.markitem_state_text);
            this.kkc = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.kkf = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.kki = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.mDivider = view.findViewById(R.id.text_divider);
            d(this.iAN);
            this.hlJ.setPlaceHolder(2);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kkh.getLayoutParams();
            if (k.bbM().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.hlJ.setVisibility(0);
                    this.hlJ.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.kjU;
            } else {
                this.hlJ.setVisibility(8);
                layoutParams.bottomMargin = d.kjV;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kkk.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.kjR;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes18.dex */
    private class c extends a {
        OriginalThreadCardView ahw;

        public c(View view) {
            super();
            this.kkg = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.kkc = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.iAN = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.dTU = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.kkd = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.aje = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.kkd);
            this.kkh = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.ahw = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.kke = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.kkf = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.kki = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.mDivider = view.findViewById(R.id.share_text_divider);
            d(this.iAN);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.ahw.b(markData.getOriginalThreadInfo());
            this.ahw.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahw.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.kjR;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes18.dex */
    private class b {
        TextView kkj;
        ProgressBar mProgress;

        private b() {
        }
    }
}
