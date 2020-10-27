package com.baidu.tieba.write.write;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    private LinkedList<t> icb = new LinkedList<>();
    private TbPageContext mPageContext;
    private LinkedList<com.baidu.tbadk.core.view.spanGroup.a> nFH;
    private a nFI;

    /* loaded from: classes3.dex */
    public interface a {
        void Lq(int i);

        void fW(List<t> list);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.icb == null) {
            return 0;
        }
        return this.icb.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.icb == null || this.icb.size() <= i) {
            return null;
        }
        return this.icb.get(i);
    }

    public LinkedList<t> dSm() {
        return this.icb;
    }

    public com.baidu.tbadk.core.view.spanGroup.a Lp(int i) {
        long itemId = getItemId(i);
        if (itemId != 0 && this.nFH != null) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.nFH.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.view.spanGroup.a next = it.next();
                if (next.getId() == itemId) {
                    return next;
                }
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2 = 0;
        if (this.icb != null && this.icb.size() > i && this.icb.get(i) != null) {
            i2 = this.icb.get(i).mId;
        }
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        b bVar;
        t tVar = (t) getItem(i);
        if (tVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.item_commodity_link, (ViewGroup) null);
            b bVar2 = new b();
            bVar2.mRootView = view.findViewById(R.id.commodity_root_view);
            bVar2.kAe = view.findViewById(R.id.commodity_main_view);
            bVar2.ePE = (TbImageView) view.findViewById(R.id.commodity_link_icon);
            bVar2.ePE.setConrers(15);
            bVar2.ePE.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            bVar2.ePE.setPlaceHolderAutoChangeSkinType(1);
            bVar2.ePE.setGifIconSupport(false);
            bVar2.ePE.setLongIconSupport(false);
            bVar2.ePE.setDrawBorder(true);
            bVar2.ePE.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            bVar2.ePE.setBorderColor(ap.getColor(R.color.cp_border_a));
            bVar2.mTitle = (TextView) view.findViewById(R.id.commodity_link_content);
            bVar2.nFL = (ImageView) view.findViewById(R.id.commodity_link_close_button);
            bVar2.nFK = view.findViewById(R.id.extra_info_container);
            bVar2.ePG = (TextView) view.findViewById(R.id.commodity_price);
            bVar2.nFM = (TextView) view.findViewById(R.id.commodity_extra_infos);
            bVar2.nFN = view.findViewById(R.id.commodity_tail_text_mask);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.ePE.startLoad(tVar.mIcon, 10, false);
        if (TextUtils.isEmpty(tVar.mPrice)) {
            bVar.nFK.setVisibility(8);
            bVar.mTitle.setMaxLines(2);
        } else {
            bVar.nFK.setVisibility(0);
            bVar.mTitle.setMaxLines(1);
        }
        if (TextUtils.isEmpty(tVar.mPrice)) {
            bVar.ePG.setVisibility(8);
        } else {
            bVar.ePG.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), tVar.mPrice));
            bVar.ePG.setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(tVar.euq)) {
            spannableStringBuilder.append((CharSequence) tVar.euq);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds3);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i2 = R.color.cp_link_tip_c;
            int i3 = R.color.cp_link_tip_c;
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbfontsize26);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
            com.baidu.tbadk.core.view.b bVar3 = new com.baidu.tbadk.core.view.b(dimens, dimens2, i2, dimens3, i3, dimens4, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
            bVar3.pt(dimens5);
            bVar3.setMarginRight(dimens6);
            spannableStringBuilder.setSpan(bVar3, 0, tVar.euq.length(), 33);
        }
        if (tVar.eus || tVar.mType == 2 || tVar.eun) {
            if (tVar.mTitle != null) {
                spannableStringBuilder.append((CharSequence) tVar.mTitle);
            }
        } else {
            if (tVar.eul != null) {
                spannableStringBuilder.append((CharSequence) tVar.eul);
            }
            bVar.mTitle.setMaxLines(1);
        }
        bVar.mTitle.setText(spannableStringBuilder);
        bVar.nFL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.view.spanGroup.a Lp = d.this.Lp(i);
                if (Lp != null) {
                    if (d.this.nFI != null) {
                        d.this.nFI.Lq(Lp.getId());
                    }
                    if (d.this.nFI != null) {
                        d.this.nFI.fW(d.this.icb);
                    }
                }
            }
        });
        int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        ap.c(bVar.mRootView, 0, R.color.cp_bg_line_e, R.color.cp_bg_line_e);
        ap.c(bVar.kAe, dimens7, R.color.cp_bg_line_g, R.color.cp_bg_line_g);
        ap.setViewTextColor(bVar.mTitle, R.color.cp_cont_j);
        ap.setViewTextColor(bVar.ePG, R.color.cp_cont_h);
        ap.setViewTextColor(bVar.nFM, R.color.cp_cont_d);
        ap.a(bVar.nFN, R.color.cp_bg_line_g, GradientDrawable.Orientation.RIGHT_LEFT);
        return view;
    }

    public void h(LinkedList<com.baidu.tbadk.core.view.spanGroup.a> linkedList) {
        this.nFH = linkedList;
    }

    public LinkedList<com.baidu.tbadk.core.view.spanGroup.a> dSn() {
        return this.nFH;
    }

    public void refreshData() {
        dSp();
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dSo() {
        if (y.isEmpty(this.icb)) {
            return true;
        }
        Iterator<t> it = this.icb.iterator();
        while (it.hasNext()) {
            t next = it.next();
            if (next.mType == 2 || !next.eun) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return true;
    }

    private void dSp() {
        this.icb.clear();
        if (!y.isEmpty(this.nFH)) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.nFH.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.view.spanGroup.a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.brf() != null) {
                        t brf = tbLinkSpanGroup.brf();
                        brf.euu = tbLinkSpanGroup.getStart();
                        this.icb.add(brf);
                    }
                }
            }
            Collections.sort(this.icb);
        }
    }

    public void a(a aVar) {
        this.nFI = aVar;
    }

    /* loaded from: classes3.dex */
    private class b {
        TbImageView ePE;
        TextView ePG;
        View kAe;
        View mRootView;
        TextView mTitle;
        View nFK;
        ImageView nFL;
        TextView nFM;
        View nFN;

        private b() {
        }
    }
}
