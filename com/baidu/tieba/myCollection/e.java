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
/* loaded from: classes7.dex */
public class e extends BaseAdapter {
    private static final float lyS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float lyT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float lyU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int lyV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int lyW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private Runnable bNr;
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> eXu = new ArrayList<>();
    private boolean ghQ = false;
    private View.OnClickListener lyX = null;
    private View.OnClickListener lyY = null;
    private View.OnClickListener lyZ = null;
    private boolean lza = false;
    private boolean hasMore = true;
    private boolean lzb = true;
    private final View.OnClickListener alB = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.e.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = e.this.getItem(((Integer) view.getTag()).intValue());
            ar arVar = new ar("c12529");
            if (view instanceof CommonUserLikeButton) {
                arVar.aq("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                arVar.aq("obj_locate", 1);
            }
            arVar.dR("tid", item.getId());
            arVar.dR("obj_id", item.getUesrId());
            TiebaStatic.log(arVar);
            com.baidu.tieba.myCollection.c.A("c14064", item);
        }
    };
    private View.OnClickListener lzc = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.e.4
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
        this.lza = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.eXu.clear();
        if (arrayList != null) {
            this.eXu.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (!l.isMainThread()) {
            if (this.bNr == null) {
                this.bNr = new Runnable() { // from class: com.baidu.tieba.myCollection.e.1
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.notifyDataSetChanged();
                    }
                };
            }
            com.baidu.adp.lib.f.e.mA().post(this.bNr);
            return;
        }
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.eXu)) {
            return 0;
        }
        return this.lzb ? y.getCount(this.eXu) + 1 : y.getCount(this.eXu);
    }

    public void ug(boolean z) {
        this.lzb = z;
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
    /* renamed from: EQ */
    public MarkData getItem(int i) {
        return (MarkData) y.getItem(this.eXu, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (y.getCount(this.eXu) <= i) {
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
                    dVar.lze.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.lzi.getLayoutParams();
                    if (this.ghQ) {
                        dVar.lze.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        dVar.lze.setVisibility(8);
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
                    bVar2.lzl = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.lzl.setVisibility(0);
                if (this.lza) {
                    bVar.mProgress.setVisibility(0);
                    bVar.lzl.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.lzl, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.lzl.setText(this.mPageContext.getString(R.string.no_more_mark));
                    ap.setViewTextColor(bVar.lzl, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.lzl.setText(this.mPageContext.getString(R.string.loading));
                    ap.setViewTextColor(bVar.lzl, R.color.common_color_10039, 1);
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
                    cVar.lze.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.lzi.getLayoutParams();
                    if (this.ghQ) {
                        cVar.lze.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.lze.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.akm.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.e.2
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new ar("c12529").aq("obj_locate", 5));
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
        if (y.isEmpty(this.eXu) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void mc(boolean z) {
        this.ghQ = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.lzj.setOnClickListener(this.lyY);
        aVar.lzj.setTag(valueOf);
        aVar.jUu.setAfterClickListener(this.alB);
        aVar.jUu.setTag(valueOf);
        aVar.lzf.setAfterOnClickListener(this.alB);
        aVar.lzf.setAfterOnClickListener(this.lzc);
        aVar.lzf.setTag(valueOf);
        aVar.lzk.setOnClickListener(this.lyZ);
        aVar.lzk.setTag(valueOf);
        aVar.lze.setOnClickListener(this.lyX);
        aVar.lze.setFocusable(false);
        aVar.lze.setTag(valueOf);
    }

    public void P(View.OnClickListener onClickListener) {
        this.lyX = onClickListener;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.lyY = onClickListener;
    }

    public void R(View.OnClickListener onClickListener) {
        this.lyZ = onClickListener;
    }

    public void onDestroy() {
        if (this.bNr != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.bNr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c alS;
        View dCC;
        TextView eKp;
        ClickableHeaderImageView jUu;
        ImageButton lze;
        CommonUserLikeButton lzf;
        TextView lzg;
        ImageView lzh;
        LinearLayout lzi;
        LinearLayout lzj;
        LinearLayout lzk;
        TextView mTitle;

        private a() {
        }

        void d(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setPlaceHolder(1);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(e.this.alB);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.lyS);
                        ap.setViewTextColor(this.mTitle, R.color.CAM_X0110);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, e.lyT);
                        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.jUu.setData(markData.metaData);
                this.jUu.setShowV(markData.metaData.isBigV());
                this.alS.a(markData.metaData);
                this.lzf.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.lzf.setTextSize(0, e.lyU);
                if ((markData.metaData.getIsLike() || au.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.lzf.setVisibility(8);
                } else {
                    this.lzf.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.lzk.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.lzh.setVisibility(0);
                    } else {
                        this.lzh.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.lzg.setText(e.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.lzg.setText(markData.getmState());
                    }
                    ap.setViewTextColor(this.lzg, R.color.CAM_X0109);
                } else {
                    this.lzk.setVisibility(8);
                }
                ap.setBackgroundColor(this.dCC, R.color.CAM_X0204);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.eKp.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    ap.setViewTextColor(this.eKp, R.color.CAM_X0301);
                } else {
                    ap.setViewTextColor(this.eKp, R.color.CAM_X0106);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    private class d extends a {
        TbImageView iAU;
        LinearLayout lzm;

        public d(View view) {
            super();
            this.lzi = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.jUu = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.eKp = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.lzj = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.lzm = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.lzf = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.alS = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.lzf);
            this.iAU = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.lzg = (TextView) view.findViewById(R.id.markitem_state_text);
            this.lze = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.lzh = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.lzk = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.dCC = view.findViewById(R.id.text_divider);
            d(this.jUu);
            this.iAU.setPlaceHolder(1);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lzj.getLayoutParams();
            if (k.bkV().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.iAU.setVisibility(0);
                    this.iAU.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = e.lyV;
            } else {
                this.iAU.setVisibility(8);
                layoutParams.bottomMargin = e.lyW;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lzm.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) e.lyS;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    private class c extends a {
        OriginalThreadCardView akm;

        public c(View view) {
            super();
            this.lzi = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.lze = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.jUu = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.eKp = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.lzf = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.alS = new com.baidu.tbadk.core.view.userLike.c(e.this.mPageContext, this.lzf);
            this.lzj = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.akm = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.lzg = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.lzh = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.lzk = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.dCC = view.findViewById(R.id.share_text_divider);
            d(this.jUu);
        }

        @Override // com.baidu.tieba.myCollection.e.a
        void b(MarkData markData) {
            super.b(markData);
            this.akm.b(markData.getOriginalThreadInfo());
            this.akm.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.akm.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) e.lyS;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    private class b {
        TextView lzl;
        ProgressBar mProgress;

        private b() {
        }
    }
}
