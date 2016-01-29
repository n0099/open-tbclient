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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.GetIconList.Discount;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private TbPageContext<?> Nw;
    private List<IconInfo> aIY;
    private int cHV;
    private UserInfo dZT;

    public d(TbPageContext<?> tbPageContext) {
        this.Nw = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIY == null) {
            return 0;
        }
        return this.aIY.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ox */
    public IconInfo getItem(int i) {
        if (this.aIY == null) {
            return null;
        }
        return this.aIY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.aIY == null || this.Nw == null) {
            return null;
        }
        IconInfo iconInfo = this.aIY.get(i);
        if (iconInfo == null) {
            return null;
        }
        if (view == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(t.h.buy_tbean_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.Sn = view.findViewById(t.g.item_root);
            aVar2.dZU = (TextView) view.findViewById(t.g.tbean_num_tv);
            aVar2.dZV = (TextView) view.findViewById(t.g.tbean_member_tv);
            aVar2.dZX = (TextView) view.findViewById(t.g.name_tv);
            aVar2.dZW = (TbImageView) view.findViewById(t.g.icon_iv);
            aVar2.dZY = (TextView) view.findViewById(t.g.duration_tv);
            aVar2.dZZ = (TextView) view.findViewById(t.g.tbean_price_tv);
            aVar2.cBA = (CheckBox) view.findViewById(t.g.tbean_cb);
            aVar2.aIr = view.findViewById(t.g.divider_line);
            view.setTag(aVar2);
            u(view);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, iconInfo, i);
        return view;
    }

    private void a(a aVar, IconInfo iconInfo, int i) {
        if (aVar != null) {
            if (iconInfo == null || this.dZT == null || iconInfo.discount == null || iconInfo.discount.isEmpty()) {
                aVar.Sn.setVisibility(8);
                return;
            }
            if (aVar.Sn.getVisibility() != 0) {
                aVar.Sn.setVisibility(0);
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
                aVar.Sn.setVisibility(8);
                return;
            }
            int intValue = (discount2.rebate.intValue() * iconInfo.non_member_t.intValue()) / 100;
            aVar.dZV.setText(bg(discount2.rebate.intValue() - 100, intValue - iconInfo.non_member_t.intValue()));
            if (this.dZT.is_mem.intValue() != 2) {
                intValue = iconInfo.non_member_t.intValue();
            }
            aVar.dZU.setText(oB(intValue));
            aVar.dZX.setText(iconInfo.name);
            aVar.dZW.d(iconInfo.picUrl, 10, false);
            aVar.dZY.setText(this.Nw.getPageActivity().getString(t.j.valid_day, new Object[]{Integer.valueOf(iconInfo.duration == null ? 0 : iconInfo.duration.intValue())}));
            aVar.dZZ.setText(oA(oz(iconInfo.dubi.intValue())));
            aVar.cBA.setChecked(this.cHV == i);
        }
    }

    private void u(View view) {
        com.baidu.tbadk.i.a.a(this.Nw, view);
    }

    public void oy(int i) {
        if (this.cHV != i) {
            this.cHV = i;
        }
    }

    public void a(List<IconInfo> list, UserInfo userInfo) {
        this.aIY = list;
        this.dZT = userInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        View Sn;
        View aIr;
        CheckBox cBA;
        TextView dZU;
        TextView dZV;
        TbImageView dZW;
        TextView dZX;
        TextView dZY;
        TextView dZZ;

        a() {
        }
    }

    public int oz(int i) {
        return (int) (i / 100.0f);
    }

    private SpannableString bg(int i, int i2) {
        if (this.Nw == null) {
            return null;
        }
        String oD = q.oD(i2);
        String str = String.valueOf("[member]") + this.Nw.getPageActivity().getString(t.j.super_mem_tbean_tip, new Object[]{Integer.valueOf(i)}) + "% [image]" + oD;
        SpannableString spannableString = new SpannableString(str);
        Bitmap cO = ar.cO(t.f.icon_huobi_huiyuan);
        if (cO != null) {
            int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds26);
            int width = (cO.getWidth() * dimensionPixelSize) / cO.getHeight();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
            bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
            spannableString.setSpan(new com.baidu.tbadk.widget.f(bitmapDrawable), 0, "[member]".length(), 33);
        }
        Bitmap cO2 = ar.cO(t.f.icon_huobi_tdou);
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(cO2);
        bitmapDrawable2.setBounds(0, 0, cO2.getWidth(), cO2.getHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable2);
        fVar.fi(com.baidu.adp.lib.util.k.c(this.Nw.getPageActivity(), t.e.ds4));
        fVar.fj(com.baidu.adp.lib.util.k.c(this.Nw.getPageActivity(), t.e.ds4));
        q.setSpan(spannableString, str, String.valueOf(i) + "%", new ForegroundColorSpan(ar.getColor(t.d.cp_link_tip_d)));
        q.setSpan(spannableString, str, "[image]", fVar);
        q.setSpan(spannableString, str, oD, new ForegroundColorSpan(ar.getColor(t.d.cp_link_tip_d)));
        return spannableString;
    }

    private SpannableString oA(int i) {
        if (this.Nw == null) {
            return null;
        }
        String valueOf = String.valueOf(i);
        String string = this.Nw.getPageActivity().getString(t.j.tbean_price, new Object[]{valueOf});
        SpannableString spannableString = new SpannableString(string);
        q.setSpan(spannableString, string, "¥" + valueOf, new ForegroundColorSpan(ar.getColor(t.d.cp_link_tip_d)));
        q.setSpan(spannableString, string, valueOf, new RelativeSizeSpan(1.3f));
        return spannableString;
    }

    private SpannableString oB(int i) {
        if (this.Nw == null) {
            return null;
        }
        String oD = q.oD(i);
        String str = String.valueOf(this.Nw.getPageActivity().getString(t.j.tbean_give_num)) + "[image]" + oD;
        Bitmap cO = ar.cO(t.f.icon_huobi_tdou);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
        bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable);
        fVar.fi(com.baidu.adp.lib.util.k.c(this.Nw.getPageActivity(), t.e.ds4));
        fVar.fj(com.baidu.adp.lib.util.k.c(this.Nw.getPageActivity(), t.e.ds4));
        SpannableString spannableString = new SpannableString(str);
        q.setSpan(spannableString, str, oD, new ForegroundColorSpan(ar.getColor(t.d.cp_link_tip_d)));
        q.setSpan(spannableString, str, "[image]", fVar);
        return spannableString;
    }
}
