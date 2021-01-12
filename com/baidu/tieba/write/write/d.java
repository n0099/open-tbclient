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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class d extends BaseAdapter {
    private LinkedList<u> iBr = new LinkedList<>();
    private TbPageContext mPageContext;
    private LinkedList<com.baidu.tbadk.core.view.spanGroup.a> nYZ;
    private a nZa;

    /* loaded from: classes7.dex */
    public interface a {
        void Ld(int i);

        void gl(List<u> list);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iBr == null) {
            return 0;
        }
        return this.iBr.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iBr == null || this.iBr.size() <= i) {
            return null;
        }
        return this.iBr.get(i);
    }

    public LinkedList<u> dVA() {
        return this.iBr;
    }

    public com.baidu.tbadk.core.view.spanGroup.a Lc(int i) {
        long itemId = getItemId(i);
        if (itemId != 0 && this.nYZ != null) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.nYZ.iterator();
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
        if (this.iBr != null && this.iBr.size() > i && this.iBr.get(i) != null) {
            i2 = this.iBr.get(i).mId;
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
            bVar2.bRa = view.findViewById(R.id.commodity_main_view);
            bVar2.fgY = (TbImageView) view.findViewById(R.id.commodity_link_icon);
            bVar2.fgY.setConrers(15);
            bVar2.fgY.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            bVar2.fgY.setPlaceHolderAutoChangeSkinType(1);
            bVar2.fgY.setGifIconSupport(false);
            bVar2.fgY.setLongIconSupport(false);
            bVar2.fgY.setDrawBorder(true);
            bVar2.fgY.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            bVar2.fgY.setBorderColor(ao.getColor(R.color.CAM_X0401));
            bVar2.mTitle = (TextView) view.findViewById(R.id.commodity_link_content);
            bVar2.nZd = (ImageView) view.findViewById(R.id.commodity_link_close_button);
            bVar2.nZc = view.findViewById(R.id.extra_info_container);
            bVar2.fha = (TextView) view.findViewById(R.id.commodity_price);
            bVar2.nZe = (TextView) view.findViewById(R.id.commodity_extra_infos);
            bVar2.nZf = view.findViewById(R.id.commodity_tail_text_mask);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.fgY.startLoad(uVar.mIcon, 10, false);
        if (TextUtils.isEmpty(uVar.mPrice)) {
            bVar.nZc.setVisibility(8);
            bVar.mTitle.setMaxLines(2);
        } else {
            bVar.nZc.setVisibility(0);
            bVar.mTitle.setMaxLines(1);
        }
        if (TextUtils.isEmpty(uVar.mPrice)) {
            bVar.fha.setVisibility(8);
        } else {
            bVar.fha.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), uVar.mPrice));
            bVar.fha.setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(uVar.eKE)) {
            spannableStringBuilder.append((CharSequence) uVar.eKE);
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i2 = R.color.CAM_X0305;
            int i3 = R.color.CAM_X0305;
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X10);
            int dimens4 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int dimens5 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int dimens6 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
            com.baidu.tbadk.core.view.b bVar3 = new com.baidu.tbadk.core.view.b(dimens, -1, i2, dimens3, i3, dimens4, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
            bVar3.pg(dimens2);
            bVar3.pe(dimens5);
            bVar3.setMarginRight(dimens6);
            spannableStringBuilder.setSpan(bVar3, 0, uVar.eKE.length(), 17);
        }
        if (uVar.eKG || uVar.mType == 2 || uVar.eKB) {
            if (uVar.mTitle != null) {
                spannableStringBuilder.append((CharSequence) uVar.mTitle);
            }
        } else {
            if (uVar.eKz != null) {
                spannableStringBuilder.append((CharSequence) uVar.eKz);
            }
            bVar.mTitle.setMaxLines(1);
        }
        bVar.mTitle.setText(spannableStringBuilder);
        bVar.nZd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.view.spanGroup.a Lc = d.this.Lc(i);
                if (Lc != null) {
                    if (d.this.nZa != null) {
                        d.this.nZa.Ld(Lc.getId());
                    }
                    if (d.this.nZa != null) {
                        d.this.nZa.gl(d.this.iBr);
                    }
                }
            }
        });
        l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        ao.d(bVar.mRootView, 0, R.color.CAM_X0205, R.color.CAM_X0205);
        com.baidu.tbadk.core.elementsMaven.c.bv(bVar.bRa).od(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        bVar.nZd.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        ao.setViewTextColor(bVar.mTitle, R.color.CAM_X0105);
        ao.setViewTextColor(bVar.fha, R.color.CAM_X0305);
        ao.setViewTextColor(bVar.nZe, R.color.CAM_X0109);
        ao.a(bVar.nZf, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
        return view;
    }

    public void h(LinkedList<com.baidu.tbadk.core.view.spanGroup.a> linkedList) {
        this.nYZ = linkedList;
    }

    public LinkedList<com.baidu.tbadk.core.view.spanGroup.a> dVB() {
        return this.nYZ;
    }

    public void refreshData() {
        dVD();
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dVC() {
        if (x.isEmpty(this.iBr)) {
            return true;
        }
        Iterator<u> it = this.iBr.iterator();
        while (it.hasNext()) {
            u next = it.next();
            if (next.mType == 2 || !next.eKB) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return true;
    }

    private void dVD() {
        this.iBr.clear();
        if (!x.isEmpty(this.nYZ)) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.nYZ.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.view.spanGroup.a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.buV() != null) {
                        u buV = tbLinkSpanGroup.buV();
                        buV.eKI = tbLinkSpanGroup.getStart();
                        this.iBr.add(buV);
                    }
                }
            }
            Collections.sort(this.iBr);
        }
    }

    public void a(a aVar) {
        this.nZa = aVar;
    }

    /* loaded from: classes7.dex */
    private class b {
        View bRa;
        TbImageView fgY;
        TextView fha;
        View mRootView;
        TextView mTitle;
        View nZc;
        ImageView nZd;
        TextView nZe;
        View nZf;

        private b() {
        }
    }
}
