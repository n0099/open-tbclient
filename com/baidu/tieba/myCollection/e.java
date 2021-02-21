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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class e extends BaseAdapter {
    private static final float lwP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float lwQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float lwR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int lwS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int lwT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private Runnable bLR;
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> eVV = new ArrayList<>();
    private boolean ggn = false;
    private View.OnClickListener lwU = null;
    private View.OnClickListener lwV = null;
    private View.OnClickListener lwW = null;
    private boolean lwX = false;
    private boolean hasMore = true;
    private boolean lwY = true;
    private final View.OnClickListener aki = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.e.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = e.this.getItem(((Integer) view.getTag()).intValue());
            ar arVar = new ar("c12529");
            if (view instanceof CommonUserLikeButton) {
                arVar.ap("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                arVar.ap("obj_locate", 1);
            }
            arVar.dR("tid", item.getId());
            arVar.dR("obj_id", item.getUesrId());
            TiebaStatic.log(arVar);
            com.baidu.tieba.myCollection.c.A("c14064", item);
        }
    };
    private View.OnClickListener lwZ = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.e.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.myCollection.c.A("c14065", e.this.getItem(((Integer) view.getTag()).intValue()));
        }
    };

    public e(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setRefreshing(boolean z) {
        this.lwX = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.eVV.clear();
        if (arrayList != null) {
            this.eVV.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (!l.isMainThread()) {
            if (this.bLR == null) {
                this.bLR = new Runnable() { // from class: com.baidu.tieba.myCollection.e.1
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.notifyDataSetChanged();
                    }
                };
            }
            com.baidu.adp.lib.f.e.mA().post(this.bLR);
            return;
        }
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.eVV)) {
            return 0;
        }
        return this.lwY ? y.getCount(this.eVV) + 1 : y.getCount(this.eVV);
    }

    public void ug(boolean z) {
        this.lwY = z;
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
    /* renamed from: EN */
    public MarkData getItem(int i) {
        return (MarkData) y.getItem(this.eVV, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (y.getCount(this.eVV) <= i) {
            return -1L;
        }
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01aa  */
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
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    d dVar2 = new d(view);
                    view.setTag(dVar2);
                    dVar = dVar2;
                } else {
                    dVar = (d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    dVar.lxb.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.lxf.getLayoutParams();
                    if (this.ggn) {
                        dVar.lxb.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        dVar.lxb.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    dVar.b(item);
                    a(i, dVar);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    com.baidu.tieba.myCollection.c.A("c14062", getItem(i));
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.lxi = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.lxi.setVisibility(0);
                if (this.lwX) {
                    bVar.mProgress.setVisibility(0);
                    bVar.lxi.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.lxi, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.lxi.setText(this.mPageContext.getString(R.string.no_more_mark));
                    ap.setViewTextColor(bVar.lxi, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.lxi.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.lxi, R.color.common_color_10039, 1);
                }
                this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                this.mPageContext.getLayoutMode().onModeChanged(view);
                com.baidu.tieba.myCollection.c.A("c14062", getItem(i));
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
                    cVar.lxb.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.lxf.getLayoutParams();
                    if (this.ggn) {
                        cVar.lxb.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.lxb.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.aiU.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.e.2
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new ar("c12529").ap("obj_locate", 5));
                        }
                    });
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    com.baidu.tieba.myCollection.c.A("c14062", getItem(i));
                    break;
                }
                break;
            default:
                this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                this.mPageContext.getLayoutMode().onModeChanged(view);
                com.baidu.tieba.myCollection.c.A("c14062", getItem(i));
                break;
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (y.isEmpty(this.eVV) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void mc(boolean z) {
        this.ggn = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.lxg.setOnClickListener(this.lwV);
        aVar.lxg.setTag(valueOf);
        aVar.jSL.setAfterClickListener(this.aki);
        aVar.jSL.setTag(valueOf);
        aVar.lxc.setAfterOnClickListener(this.aki);
        aVar.lxc.setAfterOnClickListener(this.lwZ);
        aVar.lxc.setTag(valueOf);
        aVar.lxh.setOnClickListener(this.lwW);
        aVar.lxh.setTag(valueOf);
        aVar.lxb.setOnClickListener(this.lwU);
        aVar.lxb.setFocusable(false);
        aVar.lxb.setTag(valueOf);
    }

    public void O(View.OnClickListener onClickListener) {
        this.lwU = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.lwV = onClickListener;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.lwW = onClickListener;
    }

    public void onDestroy() {
        if (this.bLR != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.bLR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c akz;
        View dBb;
        TextView eIO;
        ClickableHeaderImageView jSL;
        ImageButton lxb;
        CommonUserLikeButton lxc;
        TextView lxd;
        ImageView lxe;
        LinearLayout lxf;
        LinearLayout lxg;
        LinearLayout lxh;
        TextView mTitle;

        private a() {
        }

        void d(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setPlaceHolder(1);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(e.this.aki);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.lwP);
                        ap.setViewTextColor(this.mTitle, R.color.CAM_X0110);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.lwQ);
                        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.jSL.setData(markData.metaData);
                this.jSL.setShowV(markData.metaData.isBigV());
                this.akz.a(markData.metaData);
                this.lxc.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.lxc.setTextSize(0, e.lwR);
                if ((markData.metaData.getIsLike() || au.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.lxc.setVisibility(8);
                } else {
                    this.lxc.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.lxh.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.lxe.setVisibility(0);
                    } else {
                        this.lxe.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.lxd.setText(e.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.lxd.setText(markData.getmState());
                    }
                    ap.setViewTextColor(this.lxd, R.color.CAM_X0109);
                } else {
                    this.lxh.setVisibility(8);
                }
                ap.setBackgroundColor(this.dBb, R.color.CAM_X0204);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.eIO.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    ap.setViewTextColor(this.eIO, R.color.CAM_X0301);
                } else {
                    ap.setViewTextColor(this.eIO, R.color.CAM_X0106);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    private class d extends a {
        TbImageView izl;
        LinearLayout lxj;

        public d(View view) {
            super();
            this.lxf = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.jSL = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.eIO = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.lxg = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.lxj = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.lxc = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.akz = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.lxc);
            this.izl = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.lxd = (TextView) view.findViewById(R.id.markitem_state_text);
            this.lxb = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.lxe = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.lxh = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.dBb = view.findViewById(R.id.text_divider);
            d(this.jSL);
            this.izl.setPlaceHolder(1);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lxg.getLayoutParams();
            if (k.bkT().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.izl.setVisibility(0);
                    this.izl.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = e.lwS;
            } else {
                this.izl.setVisibility(8);
                layoutParams.bottomMargin = e.lwT;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lxj.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) e.lwP;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes8.dex */
    private class c extends a {
        OriginalThreadCardView aiU;

        public c(View view) {
            super();
            this.lxf = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.lxb = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.jSL = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.eIO = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.lxc = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.akz = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.lxc);
            this.lxg = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.aiU = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.lxd = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.lxe = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.lxh = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.dBb = view.findViewById(R.id.share_text_divider);
            d(this.jSL);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            this.aiU.b(markData.getOriginalThreadInfo());
            this.aiU.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aiU.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) e.lwP;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes8.dex */
    private class b {
        TextView lxi;
        ProgressBar mProgress;

        private b() {
        }
    }
}
