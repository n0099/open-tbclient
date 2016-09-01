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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes.dex */
public class EcommCardView extends RelativeLayout {
    private TextView bdS;
    private TextView cUB;
    private TextView exT;
    private TextView gcA;
    private TbImageView gcz;

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
        View inflate = LayoutInflater.from(context).inflate(t.h.ecomm_card_layout, (ViewGroup) this, true);
        this.gcz = (TbImageView) inflate.findViewById(t.g.card_photo);
        this.cUB = (TextView) inflate.findViewById(t.g.card_description);
        this.bdS = (TextView) inflate.findViewById(t.g.card_price);
        this.gcA = (TextView) inflate.findViewById(t.g.card_fare);
        this.exT = (TextView) inflate.findViewById(t.g.card_address);
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
            this.gcz.c(str, 10, false);
            this.cUB.setText(dealInfoData.title);
            double d2 = dealInfoData.unitPrice;
            if ((d2 >= 0.0d ? d2 : 0.0d) > 9999999.0d) {
                this.bdS.setText("¥" + ba.D((long) d));
            } else {
                this.bdS.setText("¥" + String.format(Locale.getDefault(), "%.2f", Double.valueOf(d)));
            }
            float f = dealInfoData.shipFee;
            if (f < 0.0f) {
                f = 0.0f;
            }
            if (f > 9999999.0f) {
                format = ba.D(f);
            } else {
                format = String.format(Locale.getDefault(), "%.2f", Float.valueOf(f));
            }
            this.gcA.setText(getResources().getString(t.j.ecomm_shipfee, format));
            this.exT.setText(dealInfoData.sellerAddress);
        }
    }
}
