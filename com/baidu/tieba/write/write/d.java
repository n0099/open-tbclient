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
    private LinkedList<t> hPE = new LinkedList<>();
    private TbPageContext mPageContext;
    private LinkedList<com.baidu.tbadk.core.view.spanGroup.a> nti;
    private a ntj;

    /* loaded from: classes3.dex */
    public interface a {
        void KY(int i);

        void fO(List<t> list);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hPE == null) {
            return 0;
        }
        return this.hPE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hPE == null || this.hPE.size() <= i) {
            return null;
        }
        return this.hPE.get(i);
    }

    public LinkedList<t> dPe() {
        return this.hPE;
    }

    public com.baidu.tbadk.core.view.spanGroup.a KX(int i) {
        long itemId = getItemId(i);
        if (itemId != 0 && this.nti != null) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.nti.iterator();
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
        if (this.hPE != null && this.hPE.size() > i && this.hPE.get(i) != null) {
            i2 = this.hPE.get(i).mId;
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
            bVar2.knH = view.findViewById(R.id.commodity_main_view);
            bVar2.eHi = (TbImageView) view.findViewById(R.id.commodity_link_icon);
            bVar2.eHi.setConrers(15);
            bVar2.eHi.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            bVar2.eHi.setPlaceHolderAutoChangeSkinType(1);
            bVar2.eHi.setGifIconSupport(false);
            bVar2.eHi.setLongIconSupport(false);
            bVar2.eHi.setDrawBorder(true);
            bVar2.eHi.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            bVar2.eHi.setBorderColor(ap.getColor(R.color.cp_border_a));
            bVar2.mTitle = (TextView) view.findViewById(R.id.commodity_link_content);
            bVar2.ntm = (ImageView) view.findViewById(R.id.commodity_link_close_button);
            bVar2.ntl = view.findViewById(R.id.extra_info_container);
            bVar2.eHk = (TextView) view.findViewById(R.id.commodity_price);
            bVar2.ntn = (TextView) view.findViewById(R.id.commodity_extra_infos);
            bVar2.nto = view.findViewById(R.id.commodity_tail_text_mask);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.eHi.startLoad(tVar.mIcon, 10, false);
        if (TextUtils.isEmpty(tVar.mPrice)) {
            bVar.ntl.setVisibility(8);
            bVar.mTitle.setMaxLines(2);
        } else {
            bVar.ntl.setVisibility(0);
            bVar.mTitle.setMaxLines(1);
        }
        if (TextUtils.isEmpty(tVar.mPrice)) {
            bVar.eHk.setVisibility(8);
        } else {
            bVar.eHk.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), tVar.mPrice));
            bVar.eHk.setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(tVar.elQ)) {
            spannableStringBuilder.append((CharSequence) tVar.elQ);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds3);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i2 = R.color.cp_link_tip_c;
            int i3 = R.color.cp_link_tip_c;
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbfontsize26);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
            com.baidu.tbadk.core.view.b bVar3 = new com.baidu.tbadk.core.view.b(dimens, dimens2, i2, dimens3, i3, dimens4, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
            bVar3.ph(dimens5);
            bVar3.setMarginRight(dimens6);
            spannableStringBuilder.setSpan(bVar3, 0, tVar.elQ.length(), 33);
        }
        if (tVar.elS || tVar.mType == 2 || tVar.elN) {
            if (tVar.mTitle != null) {
                spannableStringBuilder.append((CharSequence) tVar.mTitle);
            }
        } else {
            if (tVar.elL != null) {
                spannableStringBuilder.append((CharSequence) tVar.elL);
            }
            bVar.mTitle.setMaxLines(1);
        }
        bVar.mTitle.setText(spannableStringBuilder);
        bVar.ntm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.view.spanGroup.a KX = d.this.KX(i);
                if (KX != null) {
                    if (d.this.ntj != null) {
                        d.this.ntj.KY(KX.getId());
                    }
                    if (d.this.ntj != null) {
                        d.this.ntj.fO(d.this.hPE);
                    }
                }
            }
        });
        int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        ap.c(bVar.mRootView, 0, R.color.cp_bg_line_e, R.color.cp_bg_line_e);
        ap.c(bVar.knH, dimens7, R.color.cp_bg_line_g, R.color.cp_bg_line_g);
        ap.setViewTextColor(bVar.mTitle, R.color.cp_cont_j);
        ap.setViewTextColor(bVar.eHk, R.color.cp_cont_h);
        ap.setViewTextColor(bVar.ntn, R.color.cp_cont_d);
        ap.a(bVar.nto, R.color.cp_bg_line_g, GradientDrawable.Orientation.RIGHT_LEFT);
        return view;
    }

    public void h(LinkedList<com.baidu.tbadk.core.view.spanGroup.a> linkedList) {
        this.nti = linkedList;
    }

    public LinkedList<com.baidu.tbadk.core.view.spanGroup.a> dPf() {
        return this.nti;
    }

    public void refreshData() {
        dPh();
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dPg() {
        if (y.isEmpty(this.hPE)) {
            return true;
        }
        Iterator<t> it = this.hPE.iterator();
        while (it.hasNext()) {
            t next = it.next();
            if (next.mType == 2 || !next.elN) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return true;
    }

    private void dPh() {
        this.hPE.clear();
        if (!y.isEmpty(this.nti)) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.nti.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.view.spanGroup.a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.bpm() != null) {
                        t bpm = tbLinkSpanGroup.bpm();
                        bpm.elU = tbLinkSpanGroup.getStart();
                        this.hPE.add(bpm);
                    }
                }
            }
            Collections.sort(this.hPE);
        }
    }

    public void a(a aVar) {
        this.ntj = aVar;
    }

    /* loaded from: classes3.dex */
    private class b {
        TbImageView eHi;
        TextView eHk;
        View knH;
        View mRootView;
        TextView mTitle;
        View ntl;
        ImageView ntm;
        TextView ntn;
        View nto;

        private b() {
        }
    }
}
