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
    private LinkedList<u> itJ = new LinkedList<>();
    private TbPageContext mPageContext;
    private LinkedList<com.baidu.tbadk.core.view.spanGroup.a> obu;
    private a obv;

    /* loaded from: classes3.dex */
    public interface a {
        void MY(int i);

        void gs(List<u> list);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.itJ == null) {
            return 0;
        }
        return this.itJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.itJ == null || this.itJ.size() <= i) {
            return null;
        }
        return this.itJ.get(i);
    }

    public LinkedList<u> eah() {
        return this.itJ;
    }

    public com.baidu.tbadk.core.view.spanGroup.a MX(int i) {
        long itemId = getItemId(i);
        if (itemId != 0 && this.obu != null) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.obu.iterator();
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
        if (this.itJ != null && this.itJ.size() > i && this.itJ.get(i) != null) {
            i2 = this.itJ.get(i).mId;
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
            bVar2.kTF = view.findViewById(R.id.commodity_main_view);
            bVar2.fca = (TbImageView) view.findViewById(R.id.commodity_link_icon);
            bVar2.fca.setConrers(15);
            bVar2.fca.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            bVar2.fca.setPlaceHolderAutoChangeSkinType(1);
            bVar2.fca.setGifIconSupport(false);
            bVar2.fca.setLongIconSupport(false);
            bVar2.fca.setDrawBorder(true);
            bVar2.fca.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            bVar2.fca.setBorderColor(ap.getColor(R.color.CAM_X0401));
            bVar2.mTitle = (TextView) view.findViewById(R.id.commodity_link_content);
            bVar2.oby = (ImageView) view.findViewById(R.id.commodity_link_close_button);
            bVar2.obx = view.findViewById(R.id.extra_info_container);
            bVar2.fcc = (TextView) view.findViewById(R.id.commodity_price);
            bVar2.obz = (TextView) view.findViewById(R.id.commodity_extra_infos);
            bVar2.obA = view.findViewById(R.id.commodity_tail_text_mask);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.fca.startLoad(uVar.mIcon, 10, false);
        if (TextUtils.isEmpty(uVar.mPrice)) {
            bVar.obx.setVisibility(8);
            bVar.mTitle.setMaxLines(2);
        } else {
            bVar.obx.setVisibility(0);
            bVar.mTitle.setMaxLines(1);
        }
        if (TextUtils.isEmpty(uVar.mPrice)) {
            bVar.fcc.setVisibility(8);
        } else {
            bVar.fcc.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), uVar.mPrice));
            bVar.fcc.setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(uVar.eFz)) {
            spannableStringBuilder.append((CharSequence) uVar.eFz);
            int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i2 = R.color.CAM_X0305;
            int i3 = R.color.CAM_X0305;
            int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X10);
            int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int dimens5 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int dimens6 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
            com.baidu.tbadk.core.view.b bVar3 = new com.baidu.tbadk.core.view.b(dimens, -1, i2, dimens3, i3, dimens4, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
            bVar3.qC(dimens2);
            bVar3.qA(dimens5);
            bVar3.setMarginRight(dimens6);
            spannableStringBuilder.setSpan(bVar3, 0, uVar.eFz.length(), 17);
        }
        if (uVar.eFB || uVar.mType == 2 || uVar.eFw) {
            if (uVar.mTitle != null) {
                spannableStringBuilder.append((CharSequence) uVar.mTitle);
            }
        } else {
            if (uVar.eFu != null) {
                spannableStringBuilder.append((CharSequence) uVar.eFu);
            }
            bVar.mTitle.setMaxLines(1);
        }
        bVar.mTitle.setText(spannableStringBuilder);
        bVar.oby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.view.spanGroup.a MX = d.this.MX(i);
                if (MX != null) {
                    if (d.this.obv != null) {
                        d.this.obv.MY(MX.getId());
                    }
                    if (d.this.obv != null) {
                        d.this.obv.gs(d.this.itJ);
                    }
                }
            }
        });
        com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        ap.d(bVar.mRootView, 0, R.color.CAM_X0205, R.color.CAM_X0205);
        com.baidu.tbadk.core.elementsMaven.c.bm(bVar.kTF).pA(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        bVar.oby.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(bVar.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(bVar.fcc, R.color.CAM_X0305);
        ap.setViewTextColor(bVar.obz, R.color.CAM_X0109);
        ap.a(bVar.obA, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
        return view;
    }

    public void h(LinkedList<com.baidu.tbadk.core.view.spanGroup.a> linkedList) {
        this.obu = linkedList;
    }

    public LinkedList<com.baidu.tbadk.core.view.spanGroup.a> eai() {
        return this.obu;
    }

    public void refreshData() {
        eak();
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean eaj() {
        if (y.isEmpty(this.itJ)) {
            return true;
        }
        Iterator<u> it = this.itJ.iterator();
        while (it.hasNext()) {
            u next = it.next();
            if (next.mType == 2 || !next.eFw) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return true;
    }

    private void eak() {
        this.itJ.clear();
        if (!y.isEmpty(this.obu)) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.obu.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.view.spanGroup.a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.bwv() != null) {
                        u bwv = tbLinkSpanGroup.bwv();
                        bwv.eFD = tbLinkSpanGroup.getStart();
                        this.itJ.add(bwv);
                    }
                }
            }
            Collections.sort(this.itJ);
        }
    }

    public void a(a aVar) {
        this.obv = aVar;
    }

    /* loaded from: classes3.dex */
    private class b {
        TbImageView fca;
        TextView fcc;
        View kTF;
        View mRootView;
        TextView mTitle;
        View obA;
        View obx;
        ImageView oby;
        TextView obz;

        private b() {
        }
    }
}
