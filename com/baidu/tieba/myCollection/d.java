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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class d extends BaseAdapter {
    private static final float hrW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float hrX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float hrY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int hrZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int hsa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private TbPageContext<?> mPageContext;
    private final ArrayList<MarkData> aHF = new ArrayList<>();
    private boolean cUW = false;
    private View.OnClickListener hsb = null;
    private View.OnClickListener hsc = null;
    private View.OnClickListener hsd = null;
    private boolean hse = false;
    private boolean hasMore = true;
    private boolean hsf = true;
    private final View.OnClickListener Xz = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            am amVar = new am("c12529");
            if (view instanceof CommonUserLikeButton) {
                amVar.P("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                amVar.P("obj_locate", 1);
            }
            amVar.bT("tid", item.getId());
            amVar.bT(VideoPlayActivityConfig.OBJ_ID, item.getUesrId());
            TiebaStatic.log(amVar);
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public void setRefreshing(boolean z) {
        this.hse = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.aHF.clear();
        if (arrayList != null) {
            this.aHF.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (l.kh()) {
            super.notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.aa(this.aHF)) {
            return 0;
        }
        return this.hsf ? v.Z(this.aHF) + 1 : v.Z(this.aHF);
    }

    public void nr(boolean z) {
        this.hsf = z;
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
    /* renamed from: wM */
    public MarkData getItem(int i) {
        return (MarkData) v.c(this.aHF, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.Z(this.aHF) <= i) {
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
        C0360d c0360d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0360d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0360d c0360d2 = new C0360d(view);
                    view.setTag(c0360d2);
                    c0360d = c0360d2;
                } else {
                    c0360d = (C0360d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0360d.hsh.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0360d.hsl.getLayoutParams();
                    if (this.cUW) {
                        c0360d.hsh.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0360d.hsh.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0360d.b(item);
                    a(i, c0360d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.hso = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.hso.setVisibility(0);
                if (this.hse) {
                    bVar.mProgress.setVisibility(0);
                    bVar.hso.setText(this.mPageContext.getString(R.string.loading));
                    al.f(bVar.hso, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.hso.setText(this.mPageContext.getString(R.string.no_more_mark));
                    al.f(bVar.hso, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.hso.setText(this.mPageContext.getString(R.string.loading));
                    al.f(bVar.hso, R.color.common_color_10039, 1);
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
                    cVar.hsh.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.hsl.getLayoutParams();
                    if (this.cUW) {
                        cVar.hsh.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.hsh.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.Xa.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.1
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new am("c12529").P("obj_locate", 5));
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
        if (v.aa(this.aHF) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void gg(boolean z) {
        this.cUW = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.hsm.setOnClickListener(this.hsc);
        aVar.hsm.setTag(valueOf);
        aVar.fRm.setAfterClickListener(this.Xz);
        aVar.fRm.setTag(valueOf);
        aVar.hsi.setAfterOnClickListener(this.Xz);
        aVar.hsi.setTag(valueOf);
        aVar.hsn.setOnClickListener(this.hsd);
        aVar.hsn.setTag(valueOf);
        aVar.hsh.setOnClickListener(this.hsb);
        aVar.hsh.setFocusable(false);
        aVar.hsh.setTag(valueOf);
    }

    public void F(View.OnClickListener onClickListener) {
        this.hsb = onClickListener;
    }

    public void G(View.OnClickListener onClickListener) {
        this.hsc = onClickListener;
    }

    public void H(View.OnClickListener onClickListener) {
        this.hsd = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a {
        View aMY;
        TextView cbW;
        com.baidu.tbadk.core.view.userLike.c ewY;
        ClickableHeaderImageView fRm;
        ImageButton hsh;
        CommonUserLikeButton hsi;
        TextView hsj;
        ImageView hsk;
        LinearLayout hsl;
        LinearLayout hsm;
        LinearLayout hsn;
        TextView mTitle;

        private a() {
        }

        void d(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                clickableHeaderImageView.setDefaultBgResource(R.color.cp_bg_line_e);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(d.this.Xz);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.hrW);
                        al.j(this.mTitle, R.color.cp_cont_e);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.hrX);
                        al.j(this.mTitle, R.color.cp_cont_b);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.fRm.setData(markData.metaData);
                this.fRm.setShowV(markData.metaData.isBigV());
                this.ewY.a(markData.metaData);
                this.hsi.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.hsi.setTextSize(0, d.hrY);
                if ((markData.metaData.getIsLike() || ap.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.hsi.setVisibility(8);
                } else {
                    this.hsi.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.hsn.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.hsk.setVisibility(0);
                    } else {
                        this.hsk.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.hsj.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.hsj.setText(markData.getmState());
                    }
                    al.j(this.hsj, R.color.cp_cont_d);
                } else {
                    this.hsn.setVisibility(8);
                }
                al.l(this.aMY, R.color.cp_bg_line_c);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.cbW.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    al.j(this.cbW, R.color.cp_cont_h);
                } else {
                    al.j(this.cbW, R.color.cp_cont_f);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0360d extends a {
        TbImageView ezI;
        LinearLayout hsp;

        public C0360d(View view) {
            super();
            this.hsl = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.fRm = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.cbW = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.hsm = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.hsp = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.hsi = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.ewY = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.hsi);
            this.ezI = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.hsj = (TextView) view.findViewById(R.id.markitem_state_text);
            this.hsh = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.hsk = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.hsn = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.aMY = view.findViewById(R.id.text_divider);
            d(this.fRm);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hsm.getLayoutParams();
            if (i.abb().abf() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.ezI.setVisibility(0);
                    this.ezI.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.hrZ;
            } else {
                this.ezI.setVisibility(8);
                layoutParams.bottomMargin = d.hsa;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hsp.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.hrW;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
    private class c extends a {
        OriginalThreadCardView Xa;

        public c(View view) {
            super();
            this.hsl = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.hsh = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.fRm = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.cbW = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.hsi = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.ewY = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.hsi);
            this.hsm = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.Xa = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.hsj = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.hsk = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.hsn = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.aMY = view.findViewById(R.id.share_text_divider);
            d(this.fRm);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.Xa.b(markData.getOriginalThreadInfo());
            this.Xa.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Xa.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.hrW;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
    private class b {
        TextView hso;
        ProgressBar mProgress;

        private b() {
        }
    }
}
