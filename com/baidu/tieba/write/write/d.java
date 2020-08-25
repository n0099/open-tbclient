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
    private LinkedList<t> hty = new LinkedList<>();
    private TbPageContext mPageContext;
    private LinkedList<com.baidu.tbadk.core.view.spanGroup.a> mTy;
    private a mTz;

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
        if (this.hty == null) {
            return 0;
        }
        return this.hty.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hty == null || this.hty.size() <= i) {
            return null;
        }
        return this.hty.get(i);
    }

    public LinkedList<t> dHo() {
        return this.hty;
    }

    public com.baidu.tbadk.core.view.spanGroup.a JM(int i) {
        long itemId = getItemId(i);
        if (itemId != 0 && this.mTy != null) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.mTy.iterator();
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
        if (this.hty != null && this.hty.size() > i && this.hty.get(i) != null) {
            i2 = this.hty.get(i).mId;
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
            bVar2.jPI = view.findViewById(R.id.commodity_main_view);
            bVar2.esP = (TbImageView) view.findViewById(R.id.commodity_link_icon);
            bVar2.esP.setConrers(15);
            bVar2.esP.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            bVar2.esP.setPlaceHolderAutoChangeSkinType(1);
            bVar2.esP.setGifIconSupport(false);
            bVar2.esP.setLongIconSupport(false);
            bVar2.esP.setDrawBorder(true);
            bVar2.esP.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            bVar2.esP.setBorderColor(ap.getColor(R.color.cp_border_a));
            bVar2.mTitle = (TextView) view.findViewById(R.id.commodity_link_content);
            bVar2.mTC = (ImageView) view.findViewById(R.id.commodity_link_close_button);
            bVar2.mTB = view.findViewById(R.id.extra_info_container);
            bVar2.esR = (TextView) view.findViewById(R.id.commodity_price);
            bVar2.mTD = (TextView) view.findViewById(R.id.commodity_extra_infos);
            bVar2.mTE = view.findViewById(R.id.commodity_tail_text_mask);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.esP.startLoad(tVar.mIcon, 10, false);
        if (TextUtils.isEmpty(tVar.mPrice)) {
            bVar.mTB.setVisibility(8);
            bVar.mTitle.setMaxLines(2);
        } else {
            bVar.mTB.setVisibility(0);
            bVar.mTitle.setMaxLines(1);
        }
        if (TextUtils.isEmpty(tVar.mPrice)) {
            bVar.esR.setVisibility(8);
        } else {
            bVar.esR.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), tVar.mPrice));
            bVar.esR.setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(tVar.dXA)) {
            spannableStringBuilder.append((CharSequence) tVar.dXA);
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
            spannableStringBuilder.setSpan(bVar3, 0, tVar.dXA.length(), 33);
        }
        if (tVar.dXC || tVar.mType == 2 || tVar.dXx) {
            if (tVar.mTitle != null) {
                spannableStringBuilder.append((CharSequence) tVar.mTitle);
            }
        } else {
            if (tVar.dXv != null) {
                spannableStringBuilder.append((CharSequence) tVar.dXv);
            }
            bVar.mTitle.setMaxLines(1);
        }
        bVar.mTitle.setText(spannableStringBuilder);
        bVar.mTC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.view.spanGroup.a JM = d.this.JM(i);
                if (JM != null) {
                    if (d.this.mTz != null) {
                        d.this.mTz.JN(JM.getId());
                    }
                    if (d.this.mTz != null) {
                        d.this.mTz.fC(d.this.hty);
                    }
                }
            }
        });
        int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        ap.c(bVar.mRootView, 0, R.color.cp_bg_line_e, R.color.cp_bg_line_e);
        ap.c(bVar.jPI, dimens7, R.color.cp_bg_line_g, R.color.cp_bg_line_g);
        ap.setViewTextColor(bVar.mTitle, R.color.cp_cont_j);
        ap.setViewTextColor(bVar.esR, R.color.cp_cont_h);
        ap.setViewTextColor(bVar.mTD, R.color.cp_cont_d);
        ap.a(bVar.mTE, R.color.cp_bg_line_g, GradientDrawable.Orientation.RIGHT_LEFT);
        return view;
    }

    public void h(LinkedList<com.baidu.tbadk.core.view.spanGroup.a> linkedList) {
        this.mTy = linkedList;
    }

    public LinkedList<com.baidu.tbadk.core.view.spanGroup.a> dHp() {
        return this.mTy;
    }

    public void refreshData() {
        dHr();
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dHq() {
        if (y.isEmpty(this.hty)) {
            return true;
        }
        Iterator<t> it = this.hty.iterator();
        while (it.hasNext()) {
            t next = it.next();
            if (next.mType == 2 || !next.dXx) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return true;
    }

    private void dHr() {
        this.hty.clear();
        if (!y.isEmpty(this.mTy)) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.mTy.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.view.spanGroup.a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.blI() != null) {
                        t blI = tbLinkSpanGroup.blI();
                        blI.dXE = tbLinkSpanGroup.getStart();
                        this.hty.add(blI);
                    }
                }
            }
            Collections.sort(this.hty);
        }
    }

    public void a(a aVar) {
        this.mTz = aVar;
    }

    /* loaded from: classes3.dex */
    private class b {
        TbImageView esP;
        TextView esR;
        View jPI;
        View mRootView;
        View mTB;
        ImageView mTC;
        TextView mTD;
        View mTE;
        TextView mTitle;

        private b() {
        }
    }
}
