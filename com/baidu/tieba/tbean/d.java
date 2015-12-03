package com.baidu.tieba.tbean;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.util.List;
import tbclient.GetIconList.Discount;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private int cxI;
    private UserInfo dCm;
    private List<IconInfo> mData;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mH */
    public IconInfo getItem(int i) {
        if (this.mData == null) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.mData == null || this.mPageContext == null) {
            return null;
        }
        IconInfo iconInfo = this.mData.get(i);
        if (iconInfo == null) {
            return null;
        }
        if (view == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(n.g.buy_tbean_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.mRoot = view.findViewById(n.f.item_root);
            aVar2.dCn = (TextView) view.findViewById(n.f.tbean_num_tv);
            aVar2.dCo = (TextView) view.findViewById(n.f.tbean_member_tv);
            aVar2.dCq = (TextView) view.findViewById(n.f.name_tv);
            aVar2.dCp = (TbImageView) view.findViewById(n.f.icon_iv);
            aVar2.dCr = (TextView) view.findViewById(n.f.duration_tv);
            aVar2.dCs = (TextView) view.findViewById(n.f.tbean_price_tv);
            aVar2.cqR = (CheckBox) view.findViewById(n.f.tbean_cb);
            aVar2.aFP = view.findViewById(n.f.divider_line);
            view.setTag(aVar2);
            applyNightMode(view);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, iconInfo, i);
        return view;
    }

    private void a(a aVar, IconInfo iconInfo, int i) {
        if (aVar != null) {
            if (iconInfo == null || this.dCm == null || iconInfo.discount == null || iconInfo.discount.isEmpty()) {
                aVar.mRoot.setVisibility(8);
                return;
            }
            if (aVar.mRoot.getVisibility() != 0) {
                aVar.mRoot.setVisibility(0);
            }
            List<Discount> list = iconInfo.discount;
            int size = list.size();
            int i2 = size - 1;
            int i3 = 0;
            while (i2 < size) {
                Discount discount = list.get(i2);
                if (discount != null && iconInfo.non_member_t != null && discount.recharge != null && iconInfo.non_member_t.intValue() <= discount.recharge.intValue()) {
                    break;
                }
                i2++;
                i3++;
            }
            Discount discount2 = list.get(i3 > size + (-1) ? size - 1 : i3);
            if (discount2 == null) {
                aVar.mRoot.setVisibility(8);
                return;
            }
            int intValue = (discount2.rebate.intValue() * iconInfo.non_member_t.intValue()) / 100;
            aVar.dCo.setText(aO(discount2.rebate.intValue() - 100, intValue - iconInfo.non_member_t.intValue()));
            if (this.dCm.is_mem.intValue() != 2) {
                intValue = iconInfo.non_member_t.intValue();
            }
            aVar.dCn.setText(mL(intValue));
            aVar.dCq.setText(iconInfo.name);
            aVar.dCp.d(iconInfo.picUrl, 10, false);
            aVar.dCr.setText(this.mPageContext.getPageActivity().getString(n.i.valid_day, new Object[]{Integer.valueOf(iconInfo.duration == null ? 0 : iconInfo.duration.intValue())}));
            aVar.dCs.setText(mK(mJ(iconInfo.dubi.intValue())));
            aVar.cqR.setChecked(this.cxI == i);
        }
    }

    private void applyNightMode(View view) {
        com.baidu.tbadk.i.a.a(this.mPageContext, view);
    }

    public void mI(int i) {
        if (this.cxI != i) {
            this.cxI = i;
        }
    }

    public void a(List<IconInfo> list, UserInfo userInfo) {
        this.mData = list;
        this.dCm = userInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        View aFP;
        CheckBox cqR;
        TextView dCn;
        TextView dCo;
        TbImageView dCp;
        TextView dCq;
        TextView dCr;
        TextView dCs;
        View mRoot;

        a() {
        }
    }

    public int mJ(int i) {
        return (int) (i / 100.0f);
    }

    private SpannableString aO(int i, int i2) {
        if (this.mPageContext == null) {
            return null;
        }
        String mN = q.mN(i2);
        String str = String.valueOf("[member]") + this.mPageContext.getPageActivity().getString(n.i.super_mem_tbean_tip, new Object[]{Integer.valueOf(i)}) + "% [image]" + mN;
        SpannableString spannableString = new SpannableString(str);
        Bitmap cE = as.cE(n.e.icon_huobi_huiyuan);
        if (cE != null) {
            int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds26);
            int width = (cE.getWidth() * dimensionPixelSize) / cE.getHeight();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(cE);
            bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
            spannableString.setSpan(new com.baidu.tbadk.widget.f(bitmapDrawable), 0, "[member]".length(), 33);
        }
        Bitmap cE2 = as.cE(n.e.icon_huobi_tdou);
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(cE2);
        bitmapDrawable2.setBounds(0, 0, cE2.getWidth(), cE2.getHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable2);
        fVar.eT(com.baidu.adp.lib.util.k.d(this.mPageContext.getPageActivity(), n.d.ds4));
        fVar.eU(com.baidu.adp.lib.util.k.d(this.mPageContext.getPageActivity(), n.d.ds4));
        q.setSpan(spannableString, str, String.valueOf(i) + "%", new ForegroundColorSpan(as.getColor(n.c.cp_link_tip_d)));
        q.setSpan(spannableString, str, "[image]", fVar);
        q.setSpan(spannableString, str, mN, new ForegroundColorSpan(as.getColor(n.c.cp_link_tip_d)));
        return spannableString;
    }

    private SpannableString mK(int i) {
        if (this.mPageContext == null) {
            return null;
        }
        String valueOf = String.valueOf(i);
        String string = this.mPageContext.getPageActivity().getString(n.i.tbean_price, new Object[]{valueOf});
        SpannableString spannableString = new SpannableString(string);
        q.setSpan(spannableString, string, "¥" + valueOf, new ForegroundColorSpan(as.getColor(n.c.cp_link_tip_d)));
        q.setSpan(spannableString, string, valueOf, new RelativeSizeSpan(1.3f));
        return spannableString;
    }

    private SpannableString mL(int i) {
        if (this.mPageContext == null) {
            return null;
        }
        String mN = q.mN(i);
        String str = String.valueOf(this.mPageContext.getPageActivity().getString(n.i.tbean_give_num)) + "[image]" + mN;
        Bitmap cE = as.cE(n.e.icon_huobi_tdou);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cE);
        bitmapDrawable.setBounds(0, 0, cE.getWidth(), cE.getHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable);
        fVar.eT(com.baidu.adp.lib.util.k.d(this.mPageContext.getPageActivity(), n.d.ds4));
        fVar.eU(com.baidu.adp.lib.util.k.d(this.mPageContext.getPageActivity(), n.d.ds4));
        SpannableString spannableString = new SpannableString(str);
        q.setSpan(spannableString, str, mN, new ForegroundColorSpan(as.getColor(n.c.cp_link_tip_d)));
        q.setSpan(spannableString, str, "[image]", fVar);
        return spannableString;
    }
}
