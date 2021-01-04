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
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    private LinkedList<u> iFY = new LinkedList<>();
    private TbPageContext mPageContext;
    private LinkedList<com.baidu.tbadk.core.view.spanGroup.a> odH;
    private a odI;

    /* loaded from: classes8.dex */
    public interface a {
        void MK(int i);

        void gl(List<u> list);
    }

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iFY == null) {
            return 0;
        }
        return this.iFY.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iFY == null || this.iFY.size() <= i) {
            return null;
        }
        return this.iFY.get(i);
    }

    public LinkedList<u> dZr() {
        return this.iFY;
    }

    public com.baidu.tbadk.core.view.spanGroup.a MJ(int i) {
        long itemId = getItemId(i);
        if (itemId != 0 && this.odH != null) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.odH.iterator();
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
        if (this.iFY != null && this.iFY.size() > i && this.iFY.get(i) != null) {
            i2 = this.iFY.get(i).mId;
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
            bVar2.bVM = view.findViewById(R.id.commodity_main_view);
            bVar2.flJ = (TbImageView) view.findViewById(R.id.commodity_link_icon);
            bVar2.flJ.setConrers(15);
            bVar2.flJ.setRadius(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            bVar2.flJ.setPlaceHolderAutoChangeSkinType(1);
            bVar2.flJ.setGifIconSupport(false);
            bVar2.flJ.setLongIconSupport(false);
            bVar2.flJ.setDrawBorder(true);
            bVar2.flJ.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            bVar2.flJ.setBorderColor(ao.getColor(R.color.CAM_X0401));
            bVar2.mTitle = (TextView) view.findViewById(R.id.commodity_link_content);
            bVar2.odL = (ImageView) view.findViewById(R.id.commodity_link_close_button);
            bVar2.odK = view.findViewById(R.id.extra_info_container);
            bVar2.flL = (TextView) view.findViewById(R.id.commodity_price);
            bVar2.odM = (TextView) view.findViewById(R.id.commodity_extra_infos);
            bVar2.odN = view.findViewById(R.id.commodity_tail_text_mask);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.flJ.startLoad(uVar.mIcon, 10, false);
        if (TextUtils.isEmpty(uVar.mPrice)) {
            bVar.odK.setVisibility(8);
            bVar.mTitle.setMaxLines(2);
        } else {
            bVar.odK.setVisibility(0);
            bVar.mTitle.setMaxLines(1);
        }
        if (TextUtils.isEmpty(uVar.mPrice)) {
            bVar.flL.setVisibility(8);
        } else {
            bVar.flL.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), uVar.mPrice));
            bVar.flL.setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(uVar.ePp)) {
            spannableStringBuilder.append((CharSequence) uVar.ePp);
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i2 = R.color.CAM_X0305;
            int i3 = R.color.CAM_X0305;
            int dimens3 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X10);
            int dimens4 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int dimens5 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int dimens6 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
            com.baidu.tbadk.core.view.b bVar3 = new com.baidu.tbadk.core.view.b(dimens, -1, i2, dimens3, i3, dimens4, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38));
            bVar3.qN(dimens2);
            bVar3.qL(dimens5);
            bVar3.setMarginRight(dimens6);
            spannableStringBuilder.setSpan(bVar3, 0, uVar.ePp.length(), 17);
        }
        if (uVar.ePr || uVar.mType == 2 || uVar.ePm) {
            if (uVar.mTitle != null) {
                spannableStringBuilder.append((CharSequence) uVar.mTitle);
            }
        } else {
            if (uVar.ePk != null) {
                spannableStringBuilder.append((CharSequence) uVar.ePk);
            }
            bVar.mTitle.setMaxLines(1);
        }
        bVar.mTitle.setText(spannableStringBuilder);
        bVar.odL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.core.view.spanGroup.a MJ = d.this.MJ(i);
                if (MJ != null) {
                    if (d.this.odI != null) {
                        d.this.odI.MK(MJ.getId());
                    }
                    if (d.this.odI != null) {
                        d.this.odI.gl(d.this.iFY);
                    }
                }
            }
        });
        l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        ao.d(bVar.mRootView, 0, R.color.CAM_X0205, R.color.CAM_X0205);
        com.baidu.tbadk.core.elementsMaven.c.bv(bVar.bVM).pK(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        bVar.odL.setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        ao.setViewTextColor(bVar.mTitle, R.color.CAM_X0105);
        ao.setViewTextColor(bVar.flL, R.color.CAM_X0305);
        ao.setViewTextColor(bVar.odM, R.color.CAM_X0109);
        ao.a(bVar.odN, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
        return view;
    }

    public void h(LinkedList<com.baidu.tbadk.core.view.spanGroup.a> linkedList) {
        this.odH = linkedList;
    }

    public LinkedList<com.baidu.tbadk.core.view.spanGroup.a> dZs() {
        return this.odH;
    }

    public void refreshData() {
        dZu();
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dZt() {
        if (x.isEmpty(this.iFY)) {
            return true;
        }
        Iterator<u> it = this.iFY.iterator();
        while (it.hasNext()) {
            u next = it.next();
            if (next.mType == 2 || !next.ePm) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return true;
    }

    private void dZu() {
        this.iFY.clear();
        if (!x.isEmpty(this.odH)) {
            Iterator<com.baidu.tbadk.core.view.spanGroup.a> it = this.odH.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.view.spanGroup.a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.byO() != null) {
                        u byO = tbLinkSpanGroup.byO();
                        byO.ePt = tbLinkSpanGroup.getStart();
                        this.iFY.add(byO);
                    }
                }
            }
            Collections.sort(this.iFY);
        }
    }

    public void a(a aVar) {
        this.odI = aVar;
    }

    /* loaded from: classes8.dex */
    private class b {
        View bVM;
        TbImageView flJ;
        TextView flL;
        View mRootView;
        TextView mTitle;
        View odK;
        ImageView odL;
        TextView odM;
        View odN;

        private b() {
        }
    }
}
