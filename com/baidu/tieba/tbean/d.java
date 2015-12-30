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
    private int cBp;
    private UserInfo dJO;
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
    /* renamed from: nj */
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(n.h.buy_tbean_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.mRoot = view.findViewById(n.g.item_root);
            aVar2.dJP = (TextView) view.findViewById(n.g.tbean_num_tv);
            aVar2.dJQ = (TextView) view.findViewById(n.g.tbean_member_tv);
            aVar2.dJS = (TextView) view.findViewById(n.g.name_tv);
            aVar2.dJR = (TbImageView) view.findViewById(n.g.icon_iv);
            aVar2.dJT = (TextView) view.findViewById(n.g.duration_tv);
            aVar2.dJU = (TextView) view.findViewById(n.g.tbean_price_tv);
            aVar2.cuU = (CheckBox) view.findViewById(n.g.tbean_cb);
            aVar2.aHp = view.findViewById(n.g.divider_line);
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
            if (iconInfo == null || this.dJO == null || iconInfo.discount == null || iconInfo.discount.isEmpty()) {
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
            aVar.dJQ.setText(bd(discount2.rebate.intValue() - 100, intValue - iconInfo.non_member_t.intValue()));
            if (this.dJO.is_mem.intValue() != 2) {
                intValue = iconInfo.non_member_t.intValue();
            }
            aVar.dJP.setText(nn(intValue));
            aVar.dJS.setText(iconInfo.name);
            aVar.dJR.d(iconInfo.picUrl, 10, false);
            aVar.dJT.setText(this.mPageContext.getPageActivity().getString(n.j.valid_day, new Object[]{Integer.valueOf(iconInfo.duration == null ? 0 : iconInfo.duration.intValue())}));
            aVar.dJU.setText(nm(nl(iconInfo.dubi.intValue())));
            aVar.cuU.setChecked(this.cBp == i);
        }
    }

    private void applyNightMode(View view) {
        com.baidu.tbadk.i.a.a(this.mPageContext, view);
    }

    public void nk(int i) {
        if (this.cBp != i) {
            this.cBp = i;
        }
    }

    public void a(List<IconInfo> list, UserInfo userInfo) {
        this.mData = list;
        this.dJO = userInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        View aHp;
        CheckBox cuU;
        TextView dJP;
        TextView dJQ;
        TbImageView dJR;
        TextView dJS;
        TextView dJT;
        TextView dJU;
        View mRoot;

        a() {
        }
    }

    public int nl(int i) {
        return (int) (i / 100.0f);
    }

    private SpannableString bd(int i, int i2) {
        if (this.mPageContext == null) {
            return null;
        }
        String np = q.np(i2);
        String str = String.valueOf("[member]") + this.mPageContext.getPageActivity().getString(n.j.super_mem_tbean_tip, new Object[]{Integer.valueOf(i)}) + "% [image]" + np;
        SpannableString spannableString = new SpannableString(str);
        Bitmap cx = as.cx(n.f.icon_huobi_huiyuan);
        if (cx != null) {
            int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds26);
            int width = (cx.getWidth() * dimensionPixelSize) / cx.getHeight();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(cx);
            bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
            spannableString.setSpan(new com.baidu.tbadk.widget.f(bitmapDrawable), 0, "[member]".length(), 33);
        }
        Bitmap cx2 = as.cx(n.f.icon_huobi_tdou);
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(cx2);
        bitmapDrawable2.setBounds(0, 0, cx2.getWidth(), cx2.getHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable2);
        fVar.eN(com.baidu.adp.lib.util.k.d(this.mPageContext.getPageActivity(), n.e.ds4));
        fVar.eO(com.baidu.adp.lib.util.k.d(this.mPageContext.getPageActivity(), n.e.ds4));
        q.setSpan(spannableString, str, String.valueOf(i) + "%", new ForegroundColorSpan(as.getColor(n.d.cp_link_tip_d)));
        q.setSpan(spannableString, str, "[image]", fVar);
        q.setSpan(spannableString, str, np, new ForegroundColorSpan(as.getColor(n.d.cp_link_tip_d)));
        return spannableString;
    }

    private SpannableString nm(int i) {
        if (this.mPageContext == null) {
            return null;
        }
        String valueOf = String.valueOf(i);
        String string = this.mPageContext.getPageActivity().getString(n.j.tbean_price, new Object[]{valueOf});
        SpannableString spannableString = new SpannableString(string);
        q.setSpan(spannableString, string, "¥" + valueOf, new ForegroundColorSpan(as.getColor(n.d.cp_link_tip_d)));
        q.setSpan(spannableString, string, valueOf, new RelativeSizeSpan(1.3f));
        return spannableString;
    }

    private SpannableString nn(int i) {
        if (this.mPageContext == null) {
            return null;
        }
        String np = q.np(i);
        String str = String.valueOf(this.mPageContext.getPageActivity().getString(n.j.tbean_give_num)) + "[image]" + np;
        Bitmap cx = as.cx(n.f.icon_huobi_tdou);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cx);
        bitmapDrawable.setBounds(0, 0, cx.getWidth(), cx.getHeight());
        com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable);
        fVar.eN(com.baidu.adp.lib.util.k.d(this.mPageContext.getPageActivity(), n.e.ds4));
        fVar.eO(com.baidu.adp.lib.util.k.d(this.mPageContext.getPageActivity(), n.e.ds4));
        SpannableString spannableString = new SpannableString(str);
        q.setSpan(spannableString, str, np, new ForegroundColorSpan(as.getColor(n.d.cp_link_tip_d)));
        q.setSpan(spannableString, str, "[image]", fVar);
        return spannableString;
    }
}
