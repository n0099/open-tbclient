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
    private LinkedList<t> hAJ = new LinkedList<>();
    private TbPageContext mPageContext;
    private LinkedList<com.baidu.tbadk.core.view.spanGroup.a> ndJ;
    private a ndK;

    /* loaded from: classes3.dex */
    public interface a {
        void Ks(int i);

        void fL(List<t> list);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hAJ == null) {
            return 0;
        }
        return this.hAJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hAJ == null || this.hAJ.size() <= i) {
            return null;
        }
        return this.hAJ.get(i);
    }

    public LinkedList<t> dLs() {
        return this.hAJ;
    }

    public com.baidu.tbadk.core.view.spanGroup.a Kr(int i) {
        long itemId = getItemId(i);
        if (itemId != 0 && this.ndJ != null) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.ndJ.iterator();
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
        if (this.hAJ != null && this.hAJ.size() > i && this.hAJ.get(i) != null) {
            i2 = this.hAJ.get(i).mId;
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
            bVar2.jYr = view.findViewById(R.id.commodity_main_view);
            bVar2.euY = (TbImageView) view.findViewById(R.id.commodity_link_icon);
            bVar2.euY.setConrers(15);
            bVar2.euY.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            bVar2.euY.setPlaceHolderAutoChangeSkinType(1);
            bVar2.euY.setGifIconSupport(false);
            bVar2.euY.setLongIconSupport(false);
            bVar2.euY.setDrawBorder(true);
            bVar2.euY.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            bVar2.euY.setBorderColor(ap.getColor(R.color.cp_border_a));
            bVar2.mTitle = (TextView) view.findViewById(R.id.commodity_link_content);
            bVar2.ndN = (ImageView) view.findViewById(R.id.commodity_link_close_button);
            bVar2.ndM = view.findViewById(R.id.extra_info_container);
            bVar2.eva = (TextView) view.findViewById(R.id.commodity_price);
            bVar2.ndO = (TextView) view.findViewById(R.id.commodity_extra_infos);
            bVar2.ndP = view.findViewById(R.id.commodity_tail_text_mask);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.euY.startLoad(tVar.mIcon, 10, false);
        if (TextUtils.isEmpty(tVar.mPrice)) {
            bVar.ndM.setVisibility(8);
            bVar.mTitle.setMaxLines(2);
        } else {
            bVar.ndM.setVisibility(0);
            bVar.mTitle.setMaxLines(1);
        }
        if (TextUtils.isEmpty(tVar.mPrice)) {
            bVar.eva.setVisibility(8);
        } else {
            bVar.eva.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), tVar.mPrice));
            bVar.eva.setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(tVar.dZO)) {
            spannableStringBuilder.append((CharSequence) tVar.dZO);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds3);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i2 = R.color.cp_link_tip_c;
            int i3 = R.color.cp_link_tip_c;
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbfontsize26);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
            com.baidu.tbadk.core.view.b bVar3 = new com.baidu.tbadk.core.view.b(dimens, dimens2, i2, dimens3, i3, dimens4, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
            bVar3.oJ(dimens5);
            bVar3.setMarginRight(dimens6);
            spannableStringBuilder.setSpan(bVar3, 0, tVar.dZO.length(), 33);
        }
        if (tVar.dZQ || tVar.mType == 2 || tVar.dZL) {
            if (tVar.mTitle != null) {
                spannableStringBuilder.append((CharSequence) tVar.mTitle);
            }
        } else {
            if (tVar.dZJ != null) {
                spannableStringBuilder.append((CharSequence) tVar.dZJ);
            }
            bVar.mTitle.setMaxLines(1);
        }
        bVar.mTitle.setText(spannableStringBuilder);
        bVar.ndN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.view.spanGroup.a Kr = d.this.Kr(i);
                if (Kr != null) {
                    if (d.this.ndK != null) {
                        d.this.ndK.Ks(Kr.getId());
                    }
                    if (d.this.ndK != null) {
                        d.this.ndK.fL(d.this.hAJ);
                    }
                }
            }
        });
        int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        ap.c(bVar.mRootView, 0, R.color.cp_bg_line_e, R.color.cp_bg_line_e);
        ap.c(bVar.jYr, dimens7, R.color.cp_bg_line_g, R.color.cp_bg_line_g);
        ap.setViewTextColor(bVar.mTitle, R.color.cp_cont_j);
        ap.setViewTextColor(bVar.eva, R.color.cp_cont_h);
        ap.setViewTextColor(bVar.ndO, R.color.cp_cont_d);
        ap.a(bVar.ndP, R.color.cp_bg_line_g, GradientDrawable.Orientation.RIGHT_LEFT);
        return view;
    }

    public void h(LinkedList<com.baidu.tbadk.core.view.spanGroup.a> linkedList) {
        this.ndJ = linkedList;
    }

    public LinkedList<com.baidu.tbadk.core.view.spanGroup.a> dLt() {
        return this.ndJ;
    }

    public void refreshData() {
        dLv();
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dLu() {
        if (y.isEmpty(this.hAJ)) {
            return true;
        }
        Iterator<t> it = this.hAJ.iterator();
        while (it.hasNext()) {
            t next = it.next();
            if (next.mType == 2 || !next.dZL) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return true;
    }

    private void dLv() {
        this.hAJ.clear();
        if (!y.isEmpty(this.ndJ)) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.ndJ.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.view.spanGroup.a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.bmC() != null) {
                        t bmC = tbLinkSpanGroup.bmC();
                        bmC.dZS = tbLinkSpanGroup.getStart();
                        this.hAJ.add(bmC);
                    }
                }
            }
            Collections.sort(this.hAJ);
        }
    }

    public void a(a aVar) {
        this.ndK = aVar;
    }

    /* loaded from: classes3.dex */
    private class b {
        TbImageView euY;
        TextView eva;
        View jYr;
        View mRootView;
        TextView mTitle;
        View ndM;
        ImageView ndN;
        TextView ndO;
        View ndP;

        private b() {
        }
    }
}
