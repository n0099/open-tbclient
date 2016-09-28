package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.DealMediaData;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes.dex */
public class EcommCardView extends RelativeLayout {
    private TextView bel;
    private TextView cVV;
    private TextView eAa;
    private TbImageView geJ;
    private TextView geK;

    public EcommCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public EcommCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public EcommCardView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(r.h.ecomm_card_layout, (ViewGroup) this, true);
        this.geJ = (TbImageView) inflate.findViewById(r.g.card_photo);
        this.cVV = (TextView) inflate.findViewById(r.g.card_description);
        this.bel = (TextView) inflate.findViewById(r.g.card_price);
        this.geK = (TextView) inflate.findViewById(r.g.card_fare);
        this.eAa = (TextView) inflate.findViewById(r.g.card_address);
    }

    public void setData(DealInfoData dealInfoData) {
        double d;
        String format;
        if (dealInfoData != null) {
            String str = null;
            ArrayList<DealMediaData> arrayList = dealInfoData.media;
            if (arrayList != null && arrayList.size() > 0) {
                str = arrayList.get(0).smallPic;
            }
            this.geJ.c(str, 10, false);
            this.cVV.setText(dealInfoData.title);
            double d2 = dealInfoData.unitPrice;
            if ((d2 >= 0.0d ? d2 : 0.0d) > 9999999.0d) {
                this.bel.setText("¥" + az.E((long) d));
            } else {
                this.bel.setText("¥" + String.format(Locale.getDefault(), "%.2f", Double.valueOf(d)));
            }
            float f = dealInfoData.shipFee;
            if (f < 0.0f) {
                f = 0.0f;
            }
            if (f > 9999999.0f) {
                format = az.E(f);
            } else {
                format = String.format(Locale.getDefault(), "%.2f", Float.valueOf(f));
            }
            this.geK.setText(getResources().getString(r.j.ecomm_shipfee, format));
            this.eAa.setText(dealInfoData.sellerAddress);
        }
    }
}
