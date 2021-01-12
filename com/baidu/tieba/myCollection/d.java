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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class d extends BaseAdapter {
    private Runnable bIh;
    private TbPageContext<?> mPageContext;
    private static final float loz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32);
    private static final float loA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds36);
    private static final float loB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds26);
    private static final int loC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds28);
    private static final int loD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds20);
    private final ArrayList<MarkData> eTF = new ArrayList<>();
    private boolean gdT = false;
    private View.OnClickListener loE = null;
    private View.OnClickListener loF = null;
    private View.OnClickListener loG = null;
    private boolean loH = false;
    private boolean hasMore = true;
    private boolean loI = true;
    private final View.OnClickListener akt = new View.OnClickListener() { // from class: com.baidu.tieba.myCollection.d.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MarkData item = d.this.getItem(((Integer) view.getTag()).intValue());
            aq aqVar = new aq("c12529");
            if (view instanceof CommonUserLikeButton) {
                aqVar.an("obj_locate", 4);
            } else if (view instanceof ClickableHeaderImageView) {
                aqVar.an("obj_locate", 1);
            }
            aqVar.dW("tid", item.getId());
            aqVar.dW("obj_id", item.getUesrId());
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
        this.loH = z;
    }

    public void setData(ArrayList<MarkData> arrayList) {
        this.eTF.clear();
        if (arrayList != null) {
            this.eTF.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        if (!l.isMainThread()) {
            if (this.bIh == null) {
                this.bIh = new Runnable() { // from class: com.baidu.tieba.myCollection.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.notifyDataSetChanged();
                    }
                };
            }
            com.baidu.adp.lib.f.e.mB().post(this.bIh);
            return;
        }
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.eTF)) {
            return 0;
        }
        return this.loI ? x.getCount(this.eTF) + 1 : x.getCount(this.eTF);
    }

    public void tT(boolean z) {
        this.loI = z;
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
    /* renamed from: Ev */
    public MarkData getItem(int i) {
        return (MarkData) x.getItem(this.eTF, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (x.getCount(this.eTF) <= i) {
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
        C0798d c0798d;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || !(view.getTag() instanceof C0798d)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.home_mark_item, (ViewGroup) null);
                    C0798d c0798d2 = new C0798d(view);
                    view.setTag(c0798d2);
                    c0798d = c0798d2;
                } else {
                    c0798d = (C0798d) view.getTag();
                }
                MarkData item = getItem(i);
                if (item == null) {
                    c0798d.loK.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0798d.loO.getLayoutParams();
                    if (this.gdT) {
                        c0798d.loK.setVisibility(0);
                        layoutParams.leftMargin = 0;
                    } else {
                        c0798d.loK.setVisibility(8);
                        layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    c0798d.b(item);
                    a(i, c0798d);
                    this.mPageContext.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() != 1);
                    this.mPageContext.getLayoutMode().onModeChanged(view);
                    break;
                }
                break;
            case 1:
                if (view == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.page_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.loR = (TextView) view.findViewById(R.id.page_text);
                    bVar2.mProgress = (ProgressBar) view.findViewById(R.id.progress);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                bVar.loR.setVisibility(0);
                if (this.loH) {
                    bVar.mProgress.setVisibility(0);
                    bVar.loR.setText(this.mPageContext.getString(R.string.loading));
                    ao.setViewTextColor(bVar.loR, R.color.common_color_10039, 1);
                } else if (!this.hasMore) {
                    bVar.mProgress.setVisibility(8);
                    bVar.loR.setText(this.mPageContext.getString(R.string.no_more_mark));
                    ao.setViewTextColor(bVar.loR, R.color.common_color_10005, 1);
                } else {
                    bVar.mProgress.setVisibility(8);
                    bVar.loR.setText(this.mPageContext.getString(R.string.loading));
                    ao.setViewTextColor(bVar.loR, R.color.common_color_10039, 1);
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
                    cVar.loK.setVisibility(8);
                    break;
                } else {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.loO.getLayoutParams();
                    if (this.gdT) {
                        cVar.loK.setVisibility(0);
                        layoutParams2.leftMargin = 0;
                    } else {
                        cVar.loK.setVisibility(8);
                        layoutParams2.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.ds34);
                    }
                    cVar.b(item2);
                    a(i, cVar);
                    cVar.ajg.setSubClickListener(new OriginalThreadCardView.a() { // from class: com.baidu.tieba.myCollection.d.2
                        @Override // com.baidu.tieba.card.OriginalThreadCardView.a
                        public void a(OriginalThreadInfo originalThreadInfo) {
                            TiebaStatic.log(new aq("c12529").an("obj_locate", 5));
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
        if (x.isEmpty(this.eTF) || (!this.hasMore && getItemViewType(i) == 1)) {
            return false;
        }
        return super.isEnabled(i);
    }

    public void lY(boolean z) {
        this.gdT = z;
    }

    private void a(int i, a aVar) {
        Integer valueOf = Integer.valueOf(i);
        aVar.loP.setOnClickListener(this.loF);
        aVar.loP.setTag(valueOf);
        aVar.jLA.setAfterClickListener(this.akt);
        aVar.jLA.setTag(valueOf);
        aVar.loL.setAfterOnClickListener(this.akt);
        aVar.loL.setTag(valueOf);
        aVar.loQ.setOnClickListener(this.loG);
        aVar.loQ.setTag(valueOf);
        aVar.loK.setOnClickListener(this.loE);
        aVar.loK.setFocusable(false);
        aVar.loK.setTag(valueOf);
    }

    public void O(View.OnClickListener onClickListener) {
        this.loE = onClickListener;
    }

    public void P(View.OnClickListener onClickListener) {
        this.loF = onClickListener;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.loG = onClickListener;
    }

    public void onDestroy() {
        if (this.bIh != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.bIh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        com.baidu.tbadk.core.view.userLike.c akK;
        View dyW;
        TextView eGI;
        ClickableHeaderImageView jLA;
        ImageButton loK;
        CommonUserLikeButton loL;
        TextView loM;
        ImageView loN;
        LinearLayout loO;
        LinearLayout loP;
        LinearLayout loQ;
        TextView mTitle;

        private a() {
        }

        void d(ClickableHeaderImageView clickableHeaderImageView) {
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setDefaultResource(17170445);
                clickableHeaderImageView.setPlaceHolder(1);
                clickableHeaderImageView.setIsRound(true);
                clickableHeaderImageView.setAfterClickListener(d.this.akt);
            }
        }

        void b(MarkData markData) {
            if (markData != null) {
                String title = markData.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (markData.is_deleted()) {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.loz);
                        ao.setViewTextColor(this.mTitle, R.color.CAM_X0110);
                    } else {
                        this.mTitle.setText(title);
                        this.mTitle.setTextSize(0, d.loA);
                        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
                    }
                } else {
                    this.mTitle.setText("");
                }
                c(markData);
                this.jLA.setData(markData.metaData);
                this.jLA.setShowV(markData.metaData.isBigV());
                this.akK.a(markData.metaData);
                this.loL.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.loL.setTextSize(0, d.loB);
                if ((markData.metaData.getIsLike() || at.equals(TbadkCoreApplication.getCurrentAccount(), markData.getUesrId())) && !markData.isLikeInPage()) {
                    this.loL.setVisibility(8);
                } else {
                    this.loL.setVisibility(0);
                }
                if ((!StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) || markData.is_deleted()) {
                    this.loQ.setVisibility(0);
                    if (markData.isRedTipShow() && !markData.is_deleted()) {
                        this.loN.setVisibility(0);
                    } else {
                        this.loN.setVisibility(8);
                    }
                    if (markData.is_deleted()) {
                        this.loM.setText(d.this.mPageContext.getString(R.string.mark_thread_deleted));
                    } else {
                        this.loM.setText(markData.getmState());
                    }
                    ao.setViewTextColor(this.loM, R.color.CAM_X0109);
                } else {
                    this.loQ.setVisibility(8);
                }
                ao.setBackgroundColor(this.dyW, R.color.CAM_X0204);
            }
        }

        private void c(MarkData markData) {
            if (markData != null) {
                this.eGI.setText(markData.getAuthorName());
                if (markData.metaData.isBigV()) {
                    ao.setViewTextColor(this.eGI, R.color.CAM_X0301);
                } else {
                    ao.setViewTextColor(this.eGI, R.color.CAM_X0106);
                }
            }
        }
    }

    /* renamed from: com.baidu.tieba.myCollection.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0798d extends a {
        TbImageView itn;
        LinearLayout loS;

        public C0798d(View view) {
            super();
            this.loO = (LinearLayout) view.findViewById(R.id.home_lv_markitem);
            this.jLA = (ClickableHeaderImageView) view.findViewById(R.id.mark_userinfo_header_view);
            this.eGI = (TextView) view.findViewById(R.id.mark_userinfo_name);
            this.loP = (LinearLayout) view.findViewById(R.id.home_lv_markitem_userinfo);
            this.loS = (LinearLayout) view.findViewById(R.id.home_lv_markitem_thread);
            this.loL = (CommonUserLikeButton) view.findViewById(R.id.markitem_userinfo_like_btn);
            this.akK = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.loL);
            this.itn = (TbImageView) view.findViewById(R.id.markitem_thread_image);
            this.mTitle = (TextView) view.findViewById(R.id.markitem_thread_title);
            this.loM = (TextView) view.findViewById(R.id.markitem_state_text);
            this.loK = (ImageButton) view.findViewById(R.id.home_lv_markitem_delete);
            this.loN = (ImageView) view.findViewById(R.id.new_mark_mention_redtip);
            this.loQ = (LinearLayout) view.findViewById(R.id.markitem_state);
            this.dyW = view.findViewById(R.id.text_divider);
            d(this.jLA);
            this.itn.setPlaceHolder(1);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.loP.getLayoutParams();
            if (k.bkB().isShowImages() && !StringUtils.isNull(markData.getPic_url())) {
                String pic_url = markData.getPic_url();
                if (!StringUtils.isNull(pic_url)) {
                    this.itn.setVisibility(0);
                    this.itn.startLoad(pic_url, 10, false);
                }
                layoutParams.bottomMargin = d.loC;
            } else {
                this.itn.setVisibility(8);
                layoutParams.bottomMargin = d.loD;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.loS.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams2.bottomMargin = (int) d.loz;
            } else {
                layoutParams2.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    private class c extends a {
        OriginalThreadCardView ajg;

        public c(View view) {
            super();
            this.loO = (LinearLayout) view.findViewById(R.id.share_lv_markitem);
            this.loK = (ImageButton) view.findViewById(R.id.share_lv_markitem_delete);
            this.jLA = (ClickableHeaderImageView) view.findViewById(R.id.share_mark_userinfo_header_view);
            this.eGI = (TextView) view.findViewById(R.id.share_mark_userinfo_name);
            this.loL = (CommonUserLikeButton) view.findViewById(R.id.share_mark_item_userinfo_like_btn);
            this.akK = new com.baidu.tbadk.core.view.userLike.c(d.this.mPageContext, this.loL);
            this.loP = (LinearLayout) view.findViewById(R.id.share_lv_markitem_userinfo);
            this.mTitle = (TextView) view.findViewById(R.id.share_thread_title);
            this.ajg = (OriginalThreadCardView) view.findViewById(R.id.share_original_thread_view);
            this.loM = (TextView) view.findViewById(R.id.share_mark_item_state_text);
            this.loN = (ImageView) view.findViewById(R.id.share_new_mark_mention_redtip);
            this.loQ = (LinearLayout) view.findViewById(R.id.share_mark_item_state);
            this.dyW = view.findViewById(R.id.share_text_divider);
            d(this.jLA);
        }

        @Override // com.baidu.tieba.myCollection.d.a
        void b(MarkData markData) {
            super.b(markData);
            this.ajg.b(markData.getOriginalThreadInfo());
            this.ajg.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajg.getLayoutParams();
            if ((StringUtils.isNull(markData.getmState()) || markData.getNewCounts() <= 0) && !markData.is_deleted()) {
                layoutParams.bottomMargin = (int) d.loz;
            } else {
                layoutParams.bottomMargin = 0;
            }
        }
    }

    /* loaded from: classes7.dex */
    private class b {
        TextView loR;
        ProgressBar mProgress;

        private b() {
        }
    }
}
