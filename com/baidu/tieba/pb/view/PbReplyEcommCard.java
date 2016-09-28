package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.DealMediaData;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes.dex */
public class PbReplyEcommCard extends RelativeLayout {
    private String TB;
    private TextView bel;
    private TbImageView cVU;
    private TextView cVV;
    private TextView cVW;
    private TextView eAa;
    private DealInfoData eAb;

    public PbReplyEcommCard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public PbReplyEcommCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PbReplyEcommCard(Context context) {
        super(context);
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(r.h.pb_reply_ecomm_card, (ViewGroup) this, true);
        this.cVU = (TbImageView) inflate.findViewById(r.g.card_photo);
        this.cVV = (TextView) inflate.findViewById(r.g.card_description);
        this.bel = (TextView) inflate.findViewById(r.g.card_price);
        this.cVW = (TextView) inflate.findViewById(r.g.card_shipfee);
        this.eAa = (TextView) inflate.findViewById(r.g.card_address);
        setOnClickListener(new t(this));
    }

    public void a(DealInfoData dealInfoData, String str) {
        if (dealInfoData != null) {
            this.eAb = dealInfoData;
            this.TB = str;
            ArrayList<DealMediaData> arrayList = dealInfoData.media;
            if (arrayList != null && arrayList.size() > 0) {
                this.cVU.c(arrayList.get(0).smallPic, 10, true);
            }
            this.cVV.setText(dealInfoData.title);
            double d = dealInfoData.unitPrice;
            if (d < 0.0d) {
                d = 0.0d;
            }
            if (d > 9999999.0d) {
                this.bel.setText("¥" + az.E((long) d));
            } else {
                this.bel.setText("¥" + String.format(Locale.getDefault(), "%.2f", Double.valueOf(d)));
            }
            this.cVW.setText(getResources().getString(r.j.ecomm_card_shipfee, am(dealInfoData.shipFee)));
            this.eAa.setText(dealInfoData.sellerAddress);
        }
    }

    private String am(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        return f > 9999999.0f ? az.E(f) : String.format(Locale.getDefault(), "%.2f", Float.valueOf(f));
    }

    public void aRQ() {
        com.baidu.tbadk.i.a.a((TbPageContext) l.C(getContext()), this);
        av.k(this, r.f.pb_reply_ecomm_selector);
    }
}
