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
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.util.WebPManager;
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
    private LinkedList<u> iiQ = new LinkedList<>();
    private TbPageContext mPageContext;
    private LinkedList<com.baidu.tbadk.core.view.spanGroup.a> nNc;
    private a nNd;

    /* loaded from: classes3.dex */
    public interface a {
        void Mg(int i);

        void ge(List<u> list);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iiQ == null) {
            return 0;
        }
        return this.iiQ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iiQ == null || this.iiQ.size() <= i) {
            return null;
        }
        return this.iiQ.get(i);
    }

    public LinkedList<u> dUL() {
        return this.iiQ;
    }

    public com.baidu.tbadk.core.view.spanGroup.a Mf(int i) {
        long itemId = getItemId(i);
        if (itemId != 0 && this.nNc != null) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.nNc.iterator();
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
        if (this.iiQ != null && this.iiQ.size() > i && this.iiQ.get(i) != null) {
            i2 = this.iiQ.get(i).mId;
        }
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        b bVar;
        u uVar = (u) getItem(i);
        if (uVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.item_commodity_link, (ViewGroup) null);
            b bVar2 = new b();
            bVar2.mRootView = view.findViewById(R.id.commodity_root_view);
            bVar2.kGn = view.findViewById(R.id.commodity_main_view);
            bVar2.eUE = (TbImageView) view.findViewById(R.id.commodity_link_icon);
            bVar2.eUE.setConrers(15);
            bVar2.eUE.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            bVar2.eUE.setPlaceHolderAutoChangeSkinType(1);
            bVar2.eUE.setGifIconSupport(false);
            bVar2.eUE.setLongIconSupport(false);
            bVar2.eUE.setDrawBorder(true);
            bVar2.eUE.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            bVar2.eUE.setBorderColor(ap.getColor(R.color.CAM_X0401));
            bVar2.mTitle = (TextView) view.findViewById(R.id.commodity_link_content);
            bVar2.nNg = (ImageView) view.findViewById(R.id.commodity_link_close_button);
            bVar2.nNf = view.findViewById(R.id.extra_info_container);
            bVar2.eUG = (TextView) view.findViewById(R.id.commodity_price);
            bVar2.nNh = (TextView) view.findViewById(R.id.commodity_extra_infos);
            bVar2.nNi = view.findViewById(R.id.commodity_tail_text_mask);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.eUE.startLoad(uVar.mIcon, 10, false);
        if (TextUtils.isEmpty(uVar.mPrice)) {
            bVar.nNf.setVisibility(8);
            bVar.mTitle.setMaxLines(2);
        } else {
            bVar.nNf.setVisibility(0);
            bVar.mTitle.setMaxLines(1);
        }
        if (TextUtils.isEmpty(uVar.mPrice)) {
            bVar.eUG.setVisibility(8);
        } else {
            bVar.eUG.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), uVar.mPrice));
            bVar.eUG.setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(uVar.eyA)) {
            spannableStringBuilder.append((CharSequence) uVar.eyA);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i2 = R.color.CAM_X0305;
            int i3 = R.color.CAM_X0305;
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X10);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
            com.baidu.tbadk.core.view.b bVar3 = new com.baidu.tbadk.core.view.b(dimens, -1, i2, dimens3, i3, dimens4, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
            bVar3.qb(dimens2);
            bVar3.qa(dimens5);
            bVar3.setMarginRight(dimens6);
            spannableStringBuilder.setSpan(bVar3, 0, uVar.eyA.length(), 17);
        }
        if (uVar.eyC || uVar.mType == 2 || uVar.eyx) {
            if (uVar.mTitle != null) {
                spannableStringBuilder.append((CharSequence) uVar.mTitle);
            }
        } else {
            if (uVar.eyv != null) {
                spannableStringBuilder.append((CharSequence) uVar.eyv);
            }
            bVar.mTitle.setMaxLines(1);
        }
        bVar.mTitle.setText(spannableStringBuilder);
        bVar.nNg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.view.spanGroup.a Mf = d.this.Mf(i);
                if (Mf != null) {
                    if (d.this.nNd != null) {
                        d.this.nNd.Mg(Mf.getId());
                    }
                    if (d.this.nNd != null) {
                        d.this.nNd.ge(d.this.iiQ);
                    }
                }
            }
        });
        com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        ap.c(bVar.mRootView, 0, R.color.CAM_X0205, R.color.CAM_X0205);
        com.baidu.tbadk.core.elementsMaven.c.bj(bVar.kGn).pb(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        bVar.nNg.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(bVar.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(bVar.eUG, R.color.CAM_X0305);
        ap.setViewTextColor(bVar.nNh, R.color.CAM_X0109);
        ap.a(bVar.nNi, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
        return view;
    }

    public void h(LinkedList<com.baidu.tbadk.core.view.spanGroup.a> linkedList) {
        this.nNc = linkedList;
    }

    public LinkedList<com.baidu.tbadk.core.view.spanGroup.a> dUM() {
        return this.nNc;
    }

    public void refreshData() {
        dUO();
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dUN() {
        if (y.isEmpty(this.iiQ)) {
            return true;
        }
        Iterator<u> it = this.iiQ.iterator();
        while (it.hasNext()) {
            u next = it.next();
            if (next.mType == 2 || !next.eyx) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return true;
    }

    private void dUO() {
        this.iiQ.clear();
        if (!y.isEmpty(this.nNc)) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.nNc.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.view.spanGroup.a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.bsV() != null) {
                        u bsV = tbLinkSpanGroup.bsV();
                        bsV.eyE = tbLinkSpanGroup.getStart();
                        this.iiQ.add(bsV);
                    }
                }
            }
            Collections.sort(this.iiQ);
        }
    }

    public void a(a aVar) {
        this.nNd = aVar;
    }

    /* loaded from: classes3.dex */
    private class b {
        TbImageView eUE;
        TextView eUG;
        View kGn;
        View mRootView;
        TextView mTitle;
        View nNf;
        ImageView nNg;
        TextView nNh;
        View nNi;

        private b() {
        }
    }
}
