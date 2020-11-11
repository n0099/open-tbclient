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
    private LinkedList<t> iic = new LinkedList<>();
    private TbPageContext mPageContext;
    private LinkedList<com.baidu.tbadk.core.view.spanGroup.a> nLB;
    private a nLC;

    /* loaded from: classes3.dex */
    public interface a {
        void LD(int i);

        void ge(List<t> list);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iic == null) {
            return 0;
        }
        return this.iic.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iic == null || this.iic.size() <= i) {
            return null;
        }
        return this.iic.get(i);
    }

    public LinkedList<t> dUM() {
        return this.iic;
    }

    public com.baidu.tbadk.core.view.spanGroup.a LC(int i) {
        long itemId = getItemId(i);
        if (itemId != 0 && this.nLB != null) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.nLB.iterator();
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
        if (this.iic != null && this.iic.size() > i && this.iic.get(i) != null) {
            i2 = this.iic.get(i).mId;
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
            bVar2.kFY = view.findViewById(R.id.commodity_main_view);
            bVar2.eVt = (TbImageView) view.findViewById(R.id.commodity_link_icon);
            bVar2.eVt.setConrers(15);
            bVar2.eVt.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            bVar2.eVt.setPlaceHolderAutoChangeSkinType(1);
            bVar2.eVt.setGifIconSupport(false);
            bVar2.eVt.setLongIconSupport(false);
            bVar2.eVt.setDrawBorder(true);
            bVar2.eVt.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            bVar2.eVt.setBorderColor(ap.getColor(R.color.cp_border_a));
            bVar2.mTitle = (TextView) view.findViewById(R.id.commodity_link_content);
            bVar2.nLF = (ImageView) view.findViewById(R.id.commodity_link_close_button);
            bVar2.nLE = view.findViewById(R.id.extra_info_container);
            bVar2.eVv = (TextView) view.findViewById(R.id.commodity_price);
            bVar2.nLG = (TextView) view.findViewById(R.id.commodity_extra_infos);
            bVar2.nLH = view.findViewById(R.id.commodity_tail_text_mask);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.eVt.startLoad(tVar.mIcon, 10, false);
        if (TextUtils.isEmpty(tVar.mPrice)) {
            bVar.nLE.setVisibility(8);
            bVar.mTitle.setMaxLines(2);
        } else {
            bVar.nLE.setVisibility(0);
            bVar.mTitle.setMaxLines(1);
        }
        if (TextUtils.isEmpty(tVar.mPrice)) {
            bVar.eVv.setVisibility(8);
        } else {
            bVar.eVv.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), tVar.mPrice));
            bVar.eVv.setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(tVar.eAj)) {
            spannableStringBuilder.append((CharSequence) tVar.eAj);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds3);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i2 = R.color.cp_link_tip_c;
            int i3 = R.color.cp_link_tip_c;
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbfontsize26);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
            com.baidu.tbadk.core.view.b bVar3 = new com.baidu.tbadk.core.view.b(dimens, dimens2, i2, dimens3, i3, dimens4, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
            bVar3.pD(dimens5);
            bVar3.setMarginRight(dimens6);
            spannableStringBuilder.setSpan(bVar3, 0, tVar.eAj.length(), 33);
        }
        if (tVar.eAl || tVar.mType == 2 || tVar.eAg) {
            if (tVar.mTitle != null) {
                spannableStringBuilder.append((CharSequence) tVar.mTitle);
            }
        } else {
            if (tVar.eAe != null) {
                spannableStringBuilder.append((CharSequence) tVar.eAe);
            }
            bVar.mTitle.setMaxLines(1);
        }
        bVar.mTitle.setText(spannableStringBuilder);
        bVar.nLF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.view.spanGroup.a LC = d.this.LC(i);
                if (LC != null) {
                    if (d.this.nLC != null) {
                        d.this.nLC.LD(LC.getId());
                    }
                    if (d.this.nLC != null) {
                        d.this.nLC.ge(d.this.iic);
                    }
                }
            }
        });
        int dimens7 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        ap.c(bVar.mRootView, 0, R.color.cp_bg_line_e, R.color.cp_bg_line_e);
        ap.c(bVar.kFY, dimens7, R.color.cp_bg_line_g, R.color.cp_bg_line_g);
        ap.setViewTextColor(bVar.mTitle, R.color.cp_cont_j);
        ap.setViewTextColor(bVar.eVv, R.color.cp_cont_h);
        ap.setViewTextColor(bVar.nLG, R.color.cp_cont_d);
        ap.a(bVar.nLH, R.color.cp_bg_line_g, GradientDrawable.Orientation.RIGHT_LEFT);
        return view;
    }

    public void h(LinkedList<com.baidu.tbadk.core.view.spanGroup.a> linkedList) {
        this.nLB = linkedList;
    }

    public LinkedList<com.baidu.tbadk.core.view.spanGroup.a> dUN() {
        return this.nLB;
    }

    public void refreshData() {
        dUP();
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dUO() {
        if (y.isEmpty(this.iic)) {
            return true;
        }
        Iterator<t> it = this.iic.iterator();
        while (it.hasNext()) {
            t next = it.next();
            if (next.mType == 2 || !next.eAg) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return true;
    }

    private void dUP() {
        this.iic.clear();
        if (!y.isEmpty(this.nLB)) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.nLB.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.view.spanGroup.a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.btF() != null) {
                        t btF = tbLinkSpanGroup.btF();
                        btF.eAn = tbLinkSpanGroup.getStart();
                        this.iic.add(btF);
                    }
                }
            }
            Collections.sort(this.iic);
        }
    }

    public void a(a aVar) {
        this.nLC = aVar;
    }

    /* loaded from: classes3.dex */
    private class b {
        TbImageView eVt;
        TextView eVv;
        View kFY;
        View mRootView;
        TextView mTitle;
        View nLE;
        ImageView nLF;
        TextView nLG;
        View nLH;

        private b() {
        }
    }
}
