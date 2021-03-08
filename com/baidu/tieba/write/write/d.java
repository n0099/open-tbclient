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
/* loaded from: classes7.dex */
public class d extends BaseAdapter {
    private LinkedList<v> iIY = new LinkedList<>();
    private TbPageContext mPageContext;
    private LinkedList<com.baidu.tbadk.core.view.spanGroup.a> olA;
    private a olB;

    /* loaded from: classes7.dex */
    public interface a {
        void LC(int i);

        void gj(List<v> list);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iIY == null) {
            return 0;
        }
        return this.iIY.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iIY == null || this.iIY.size() <= i) {
            return null;
        }
        return this.iIY.get(i);
    }

    public LinkedList<v> dYb() {
        return this.iIY;
    }

    public com.baidu.tbadk.core.view.spanGroup.a LB(int i) {
        long itemId = getItemId(i);
        if (itemId != 0 && this.olA != null) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.olA.iterator();
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
        if (this.iIY != null && this.iIY.size() > i && this.iIY.get(i) != null) {
            i2 = this.iIY.get(i).mId;
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
            bVar2.bWp = view.findViewById(R.id.commodity_main_view);
            bVar2.fkQ = (TbImageView) view.findViewById(R.id.commodity_link_icon);
            bVar2.fkQ.setConrers(15);
            bVar2.fkQ.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            bVar2.fkQ.setPlaceHolderAutoChangeSkinType(1);
            bVar2.fkQ.setGifIconSupport(false);
            bVar2.fkQ.setLongIconSupport(false);
            bVar2.fkQ.setDrawBorder(true);
            bVar2.fkQ.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            bVar2.fkQ.setBorderColor(ap.getColor(R.color.CAM_X0401));
            bVar2.mTitle = (TextView) view.findViewById(R.id.commodity_link_content);
            bVar2.olE = (ImageView) view.findViewById(R.id.commodity_link_close_button);
            bVar2.olD = view.findViewById(R.id.extra_info_container);
            bVar2.fkS = (TextView) view.findViewById(R.id.commodity_price);
            bVar2.olF = (TextView) view.findViewById(R.id.commodity_extra_infos);
            bVar2.olG = view.findViewById(R.id.commodity_tail_text_mask);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.fkQ.startLoad(vVar.mIcon, 10, false);
        if (TextUtils.isEmpty(vVar.mPrice)) {
            bVar.olD.setVisibility(8);
            bVar.mTitle.setMaxLines(2);
        } else {
            bVar.olD.setVisibility(0);
            bVar.mTitle.setMaxLines(1);
        }
        if (TextUtils.isEmpty(vVar.mPrice)) {
            bVar.fkS.setVisibility(8);
        } else {
            bVar.fkS.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), vVar.mPrice));
            bVar.fkS.setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(vVar.eOr)) {
            spannableStringBuilder.append((CharSequence) vVar.eOr);
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i2 = R.color.CAM_X0305;
            int i3 = R.color.CAM_X0305;
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X10);
            int dimens4 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int dimens5 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int dimens6 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
            com.baidu.tbadk.core.view.b bVar3 = new com.baidu.tbadk.core.view.b(dimens, -1, i2, dimens3, i3, dimens4, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
            bVar3.pm(dimens2);
            bVar3.pk(dimens5);
            bVar3.setMarginRight(dimens6);
            spannableStringBuilder.setSpan(bVar3, 0, vVar.eOr.length(), 17);
        }
        if (vVar.eOt || vVar.mType == 2 || vVar.eOo) {
            if (vVar.mTitle != null) {
                spannableStringBuilder.append((CharSequence) vVar.mTitle);
            }
        } else {
            if (vVar.eOm != null) {
                spannableStringBuilder.append((CharSequence) vVar.eOm);
            }
            bVar.mTitle.setMaxLines(1);
        }
        bVar.mTitle.setText(spannableStringBuilder);
        bVar.olE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.view.spanGroup.a LB = d.this.LB(i);
                if (LB != null) {
                    if (d.this.olB != null) {
                        d.this.olB.LC(LB.getId());
                    }
                    if (d.this.olB != null) {
                        d.this.olB.gj(d.this.iIY);
                    }
                }
            }
        });
        l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        ap.d(bVar.mRootView, 0, R.color.CAM_X0205, R.color.CAM_X0205);
        com.baidu.tbadk.core.elementsMaven.c.br(bVar.bWp).oh(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        bVar.olE.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(bVar.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(bVar.fkS, R.color.CAM_X0305);
        ap.setViewTextColor(bVar.olF, R.color.CAM_X0109);
        ap.a(bVar.olG, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
        return view;
    }

    public void h(LinkedList<com.baidu.tbadk.core.view.spanGroup.a> linkedList) {
        this.olA = linkedList;
    }

    public LinkedList<com.baidu.tbadk.core.view.spanGroup.a> dYc() {
        return this.olA;
    }

    public void refreshData() {
        dYe();
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dYd() {
        if (y.isEmpty(this.iIY)) {
            return true;
        }
        Iterator<v> it = this.iIY.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next.mType == 2 || !next.eOo) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return true;
    }

    private void dYe() {
        this.iIY.clear();
        if (!y.isEmpty(this.olA)) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.olA.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.view.spanGroup.a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.bvs() != null) {
                        v bvs = tbLinkSpanGroup.bvs();
                        bvs.eOv = tbLinkSpanGroup.getStart();
                        this.iIY.add(bvs);
                    }
                }
            }
            Collections.sort(this.iIY);
        }
    }

    public void a(a aVar) {
        this.olB = aVar;
    }

    /* loaded from: classes7.dex */
    private class b {
        View bWp;
        TbImageView fkQ;
        TextView fkS;
        View mRootView;
        TextView mTitle;
        View olD;
        ImageView olE;
        TextView olF;
        View olG;

        private b() {
        }
    }
}
