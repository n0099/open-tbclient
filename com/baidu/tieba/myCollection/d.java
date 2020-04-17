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
    private static final float jek = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float jel = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float jem = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int jen = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int jeo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> dvq = new ArrayList<>();
    private boolean eyx = false;
    private View.OnClickListener jep = null;
    private View.OnClickListener jeq = null;
    private View.OnClickListener jer = null;
    private boolean jes = false;
    private boolean hasMore = true;
    private boolean jet = true;
    private final View.OnClickListener agi = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            an anVar = new an("c12529");
            if (view instanceof CommonUserLikeButton) {
                anVar.af("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                anVar.af("obj_locate", 1);
            }
            anVar.cI("tid", item.getId());
            anVar.cI("obj_id", item.getUesrId());
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
        this.jes = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.dvq.clear();
        if (arrayList != null) {
            this.dvq.addAll(arrayList);
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
        if (v.isEmpty(this.dvq)) {
            return 0;
        }
        return this.jet ? v.getCount(this.dvq) + 1 : v.getCount(this.dvq);
    }

    public void qi(boolean z) {
        this.jet = z;
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
    /* renamed from: yV */
    public MarkData getItem(int i) {
        return (MarkData) v.getItem(this.dvq, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.getCount(this.dvq) <= i) {
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
        C0602d c0602d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0602d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0602d c0602d2 = new C0602d(view);
                    view.setTag(c0602d2);
                    c0602d = c0602d2;
                } else {
                    c0602d = (C0602d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0602d.jev.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0602d.jez.getLayoutParams();
                    if (this.eyx) {
                        c0602d.jev.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0602d.jev.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0602d.b(item);
                    a(i, c0602d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.jeC = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.jeC.setVisibility(0);
                if (this.jes) {
                    bVar.mProgress.setVisibility(0);
                    bVar.jeC.setText(this.mPageContext.getString(R.string.loading));
                    am.setViewTextColor(bVar.jeC, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.jeC.setText(this.mPageContext.getString(R.string.no_more_mark));
                    am.setViewTextColor(bVar.jeC, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.jeC.setText(this.mPageContext.getString(R.string.loading));
                    am.setViewTextColor(bVar.jeC, R.color.common_color_10039, 1);
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
                    cVar.jev.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.jez.getLayoutParams();
                    if (this.eyx) {
                        cVar.jev.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.jev.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.afk.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new an("c12529").af("obj_locate", 5));
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
        if (v.isEmpty(this.dvq) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void iB(boolean z) {
        this.eyx = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.jeA.setOnClickListener(this.jeq);
        aVar.jeA.setTag(valueOf);
        aVar.hCx.setAfterClickListener(this.agi);
        aVar.hCx.setTag(valueOf);
        aVar.jew.setAfterOnClickListener(this.agi);
        aVar.jew.setTag(valueOf);
        aVar.jeB.setOnClickListener(this.jer);
        aVar.jeB.setTag(valueOf);
        aVar.jev.setOnClickListener(this.jep);
        aVar.jev.setFocusable(false);
        aVar.jev.setTag(valueOf);
    }

    public void K(View.OnClickListener onClickListener) {
        this.jep = onClickListener;
    }

    public void L(View.OnClickListener onClickListener) {
        this.jeq = onClickListener;
    }

    public void M(View.OnClickListener onClickListener) {
        this.jer = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c agm;
        TextView cAX;
        ClickableHeaderImageView hCx;
        LinearLayout jeA;
        LinearLayout jeB;
        ImageButton jev;
        CommonUserLikeButton jew;
        TextView jex;
        ImageView jey;
        LinearLayout jez;
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
                clickableHeaderImageView.setAfterClickListener(d.this.agi);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.jek);
                        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.jel);
                        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.hCx.setData(markData.metaData);
                this.hCx.setShowV(markData.metaData.isBigV());
                this.agm.a(markData.metaData);
                this.jew.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.jew.setTextSize(0, d.jem);
                if ((markData.metaData.getIsLike() || aq.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.jew.setVisibility(8);
                } else {
                    this.jew.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.jeB.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.jey.setVisibility(0);
                    } else {
                        this.jey.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.jex.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.jex.setText(markData.getmState());
                    }
                    am.setViewTextColor(this.jex, (int) R.color.cp_cont_d);
                } else {
                    this.jeB.setVisibility(8);
                }
                am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.cAX.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    am.setViewTextColor(this.cAX, (int) R.color.cp_cont_h);
                } else {
                    am.setViewTextColor(this.cAX, (int) R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0602d extends a {
        TbImageView gri;
        LinearLayout jeD;

        public C0602d(View view) {
            super();
            this.jez = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.hCx = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.cAX = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.jeA = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.jeD = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.jew = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.agm = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.jew);
            this.gri = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.jex = (TextView) view.findViewById(R.id.markitem_state_text);
            this.jev = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.jey = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.jeB = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.mDivider = view.findViewById(R.id.text_divider);
            d(this.hCx);
            this.gri.setPlaceHolder(2);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jeA.getLayoutParams();
            if (i.aIe().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.gri.setVisibility(0);
                    this.gri.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.jen;
            } else {
                this.gri.setVisibility(8);
                layoutParams.bottomMargin = d.jeo;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jeD.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.jek;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes11.dex */
    private class c extends a {
        OriginalThreadCardView afk;

        public c(View view) {
            super();
            this.jez = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.jev = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.hCx = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.cAX = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.jew = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.agm = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.jew);
            this.jeA = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.afk = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.jex = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.jey = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.jeB = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.mDivider = view.findViewById(R.id.share_text_divider);
            d(this.hCx);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.afk.b(markData.getOriginalThreadInfo());
            this.afk.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afk.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.jek;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes11.dex */
    private class b {
        TextView jeC;
        ProgressBar mProgress;

        private b() {
        }
    }
}
