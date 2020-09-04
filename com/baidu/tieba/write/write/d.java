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
    private LinkedList<t> htE = new LinkedList<>();
    private TbPageContext mPageContext;
    private LinkedList<com.baidu.tbadk.core.view.spanGroup.a> mTQ;
    private a mTR;

    /* loaded from: classes3.dex */
    public interface a {
        void JN(int i);

        void fC(List<t> list);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.htE == null) {
            return 0;
        }
        return this.htE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.htE == null || this.htE.size() <= i) {
            return null;
        }
        return this.htE.get(i);
    }

    public LinkedList<t> dHx() {
        return this.htE;
    }

    public com.baidu.tbadk.core.view.spanGroup.a JM(int i) {
        long itemId = getItemId(i);
        if (itemId != 0 && this.mTQ != null) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.mTQ.iterator();
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
        if (this.htE != null && this.htE.size() > i && this.htE.get(i) != null) {
            i2 = this.htE.get(i).mId;
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
            bVar2.jPO = view.findViewById(R.id.commodity_main_view);
            bVar2.esT = (TbImageView) view.findViewById(R.id.commodity_link_icon);
            bVar2.esT.setConrers(15);
            bVar2.esT.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            bVar2.esT.setPlaceHolderAutoChangeSkinType(1);
            bVar2.esT.setGifIconSupport(false);
            bVar2.esT.setLongIconSupport(false);
            bVar2.esT.setDrawBorder(true);
            bVar2.esT.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            bVar2.esT.setBorderColor(ap.getColor(R.color.cp_border_a));
            bVar2.mTitle = (TextView) view.findViewById(R.id.commodity_link_content);
            bVar2.mTU = (ImageView) view.findViewById(R.id.commodity_link_close_button);
            bVar2.mTT = view.findViewById(R.id.extra_info_container);
            bVar2.esV = (TextView) view.findViewById(R.id.commodity_price);
            bVar2.mTV = (TextView) view.findViewById(R.id.commodity_extra_infos);
            bVar2.mTW = view.findViewById(R.id.commodity_tail_text_mask);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.esT.startLoad(tVar.mIcon, 10, false);
        if (TextUtils.isEmpty(tVar.mPrice)) {
            bVar.mTT.setVisibility(8);
            bVar.mTitle.setMaxLines(2);
        } else {
            bVar.mTT.setVisibility(0);
            bVar.mTitle.setMaxLines(1);
        }
        if (TextUtils.isEmpty(tVar.mPrice)) {
            bVar.esV.setVisibility(8);
        } else {
            bVar.esV.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), tVar.mPrice));
            bVar.esV.setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(tVar.dXE)) {
            spannableStringBuilder.append((CharSequence) tVar.dXE);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds3);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i2 = R.color.cp_link_tip_c;
            int i3 = R.color.cp_link_tip_c;
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbfontsize26);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
            com.baidu.tbadk.core.view.b bVar3 = new com.baidu.tbadk.core.view.b(dimens, dimens2, i2, dimens3, i3, dimens4, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
            bVar3.ox(dimens5);
            bVar3.setMarginRight(dimens6);
            spannableStringBuilder.setSpan(bVar3, 0, tVar.dXE.length(), 33);
        }
        if (tVar.dXG || tVar.mType == 2 || tVar.dXB) {
            if (tVar.mTitle != null) {
                spannableStringBuilder.append((CharSequence) tVar.mTitle);
            }
        } else {
            if (tVar.dXz != null) {
                spannableStringBuilder.append((CharSequence) tVar.dXz);
            }
            bVar.mTitle.setMaxLines(1);
        }
        bVar.mTitle.setText(spannableStringBuilder);
        bVar.mTU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.view.spanGroup.a JM = d.this.JM(i);
                if (JM != null) {
                    if (d.this.mTR != null) {
                        d.this.mTR.JN(JM.getId());
                    }
                    if (d.this.mTR != null) {
                        d.this.mTR.fC(d.this.htE);
                    }
                }
            }
        });
        int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        ap.c(bVar.mRootView, 0, R.color.cp_bg_line_e, R.color.cp_bg_line_e);
        ap.c(bVar.jPO, dimens7, R.color.cp_bg_line_g, R.color.cp_bg_line_g);
        ap.setViewTextColor(bVar.mTitle, R.color.cp_cont_j);
        ap.setViewTextColor(bVar.esV, R.color.cp_cont_h);
        ap.setViewTextColor(bVar.mTV, R.color.cp_cont_d);
        ap.a(bVar.mTW, R.color.cp_bg_line_g, GradientDrawable.Orientation.RIGHT_LEFT);
        return view;
    }

    public void h(LinkedList<com.baidu.tbadk.core.view.spanGroup.a> linkedList) {
        this.mTQ = linkedList;
    }

    public LinkedList<com.baidu.tbadk.core.view.spanGroup.a> dHy() {
        return this.mTQ;
    }

    public void refreshData() {
        dHA();
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dHz() {
        if (y.isEmpty(this.htE)) {
            return true;
        }
        Iterator<t> it = this.htE.iterator();
        while (it.hasNext()) {
            t next = it.next();
            if (next.mType == 2 || !next.dXB) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return true;
    }

    private void dHA() {
        this.htE.clear();
        if (!y.isEmpty(this.mTQ)) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.mTQ.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.view.spanGroup.a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.blI() != null) {
                        t blI = tbLinkSpanGroup.blI();
                        blI.dXI = tbLinkSpanGroup.getStart();
                        this.htE.add(blI);
                    }
                }
            }
            Collections.sort(this.htE);
        }
    }

    public void a(a aVar) {
        this.mTR = aVar;
    }

    /* loaded from: classes3.dex */
    private class b {
        TbImageView esT;
        TextView esV;
        View jPO;
        View mRootView;
        View mTT;
        ImageView mTU;
        TextView mTV;
        View mTW;
        TextView mTitle;

        private b() {
        }
    }
}
