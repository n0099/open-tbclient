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
import com.baidu.tbadk.core.data.v;
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
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    private LinkedList<v> iHb = new LinkedList<>();
    private TbPageContext mPageContext;
    private LinkedList<com.baidu.tbadk.core.view.spanGroup.a> oiV;
    private a oiW;

    /* loaded from: classes8.dex */
    public interface a {
        void Lx(int i);

        void gj(List<v> list);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iHb == null) {
            return 0;
        }
        return this.iHb.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iHb == null || this.iHb.size() <= i) {
            return null;
        }
        return this.iHb.get(i);
    }

    public LinkedList<v> dXL() {
        return this.iHb;
    }

    public com.baidu.tbadk.core.view.spanGroup.a Lw(int i) {
        long itemId = getItemId(i);
        if (itemId != 0 && this.oiV != null) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.oiV.iterator();
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
        if (this.iHb != null && this.iHb.size() > i && this.iHb.get(i) != null) {
            i2 = this.iHb.get(i).mId;
        }
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        b bVar;
        v vVar = (v) getItem(i);
        if (vVar == null) {
            return null;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.item_commodity_link, (ViewGroup) null);
            b bVar2 = new b();
            bVar2.mRootView = view.findViewById(R.id.commodity_root_view);
            bVar2.bUP = view.findViewById(R.id.commodity_main_view);
            bVar2.fjr = (TbImageView) view.findViewById(R.id.commodity_link_icon);
            bVar2.fjr.setConrers(15);
            bVar2.fjr.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            bVar2.fjr.setPlaceHolderAutoChangeSkinType(1);
            bVar2.fjr.setGifIconSupport(false);
            bVar2.fjr.setLongIconSupport(false);
            bVar2.fjr.setDrawBorder(true);
            bVar2.fjr.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            bVar2.fjr.setBorderColor(ap.getColor(R.color.CAM_X0401));
            bVar2.mTitle = (TextView) view.findViewById(R.id.commodity_link_content);
            bVar2.oiZ = (ImageView) view.findViewById(R.id.commodity_link_close_button);
            bVar2.oiY = view.findViewById(R.id.extra_info_container);
            bVar2.fjt = (TextView) view.findViewById(R.id.commodity_price);
            bVar2.oja = (TextView) view.findViewById(R.id.commodity_extra_infos);
            bVar2.ojb = view.findViewById(R.id.commodity_tail_text_mask);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.fjr.startLoad(vVar.mIcon, 10, false);
        if (TextUtils.isEmpty(vVar.mPrice)) {
            bVar.oiY.setVisibility(8);
            bVar.mTitle.setMaxLines(2);
        } else {
            bVar.oiY.setVisibility(0);
            bVar.mTitle.setMaxLines(1);
        }
        if (TextUtils.isEmpty(vVar.mPrice)) {
            bVar.fjt.setVisibility(8);
        } else {
            bVar.fjt.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), vVar.mPrice));
            bVar.fjt.setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(vVar.eMQ)) {
            spannableStringBuilder.append((CharSequence) vVar.eMQ);
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i2 = R.color.CAM_X0305;
            int i3 = R.color.CAM_X0305;
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X10);
            int dimens4 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int dimens5 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int dimens6 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
            com.baidu.tbadk.core.view.b bVar3 = new com.baidu.tbadk.core.view.b(dimens, -1, i2, dimens3, i3, dimens4, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
            bVar3.pl(dimens2);
            bVar3.pj(dimens5);
            bVar3.setMarginRight(dimens6);
            spannableStringBuilder.setSpan(bVar3, 0, vVar.eMQ.length(), 17);
        }
        if (vVar.eMS || vVar.mType == 2 || vVar.eMN) {
            if (vVar.mTitle != null) {
                spannableStringBuilder.append((CharSequence) vVar.mTitle);
            }
        } else {
            if (vVar.eML != null) {
                spannableStringBuilder.append((CharSequence) vVar.eML);
            }
            bVar.mTitle.setMaxLines(1);
        }
        bVar.mTitle.setText(spannableStringBuilder);
        bVar.oiZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.view.spanGroup.a Lw = d.this.Lw(i);
                if (Lw != null) {
                    if (d.this.oiW != null) {
                        d.this.oiW.Lx(Lw.getId());
                    }
                    if (d.this.oiW != null) {
                        d.this.oiW.gj(d.this.iHb);
                    }
                }
            }
        });
        l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        ap.d(bVar.mRootView, 0, R.color.CAM_X0205, R.color.CAM_X0205);
        com.baidu.tbadk.core.elementsMaven.c.br(bVar.bUP).og(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        bVar.oiZ.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(bVar.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(bVar.fjt, R.color.CAM_X0305);
        ap.setViewTextColor(bVar.oja, R.color.CAM_X0109);
        ap.a(bVar.ojb, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
        return view;
    }

    public void h(LinkedList<com.baidu.tbadk.core.view.spanGroup.a> linkedList) {
        this.oiV = linkedList;
    }

    public LinkedList<com.baidu.tbadk.core.view.spanGroup.a> dXM() {
        return this.oiV;
    }

    public void refreshData() {
        dXO();
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dXN() {
        if (y.isEmpty(this.iHb)) {
            return true;
        }
        Iterator<v> it = this.iHb.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next.mType == 2 || !next.eMN) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return true;
    }

    private void dXO() {
        this.iHb.clear();
        if (!y.isEmpty(this.oiV)) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.oiV.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.view.spanGroup.a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.bvp() != null) {
                        v bvp = tbLinkSpanGroup.bvp();
                        bvp.eMU = tbLinkSpanGroup.getStart();
                        this.iHb.add(bvp);
                    }
                }
            }
            Collections.sort(this.iHb);
        }
    }

    public void a(a aVar) {
        this.oiW = aVar;
    }

    /* loaded from: classes8.dex */
    private class b {
        View bUP;
        TbImageView fjr;
        TextView fjt;
        View mRootView;
        TextView mTitle;
        View oiY;
        ImageView oiZ;
        TextView oja;
        View ojb;

        private b() {
        }
    }
}
