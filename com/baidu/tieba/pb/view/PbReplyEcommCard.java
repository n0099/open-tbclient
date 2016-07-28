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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes.dex */
public class PbReplyEcommCard extends RelativeLayout {
    private TextView aXZ;
    private TbImageView cIV;
    private TextView cIW;
    private TextView cIX;
    private TextView elN;
    private DealInfoData elO;

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
        View inflate = LayoutInflater.from(getContext()).inflate(u.h.pb_reply_ecomm_card, (ViewGroup) this, true);
        this.cIV = (TbImageView) inflate.findViewById(u.g.card_photo);
        this.cIW = (TextView) inflate.findViewById(u.g.card_description);
        this.aXZ = (TextView) inflate.findViewById(u.g.card_price);
        this.cIX = (TextView) inflate.findViewById(u.g.card_shipfee);
        this.elN = (TextView) inflate.findViewById(u.g.card_address);
        setOnClickListener(new t(this));
    }

    public void setData(DealInfoData dealInfoData) {
        if (dealInfoData != null) {
            this.elO = dealInfoData;
            ArrayList<DealMediaData> arrayList = dealInfoData.media;
            if (arrayList != null && arrayList.size() > 0) {
                this.cIV.c(arrayList.get(0).smallPic, 10, true);
            }
            this.cIW.setText(dealInfoData.title);
            double d = dealInfoData.unitPrice;
            if (d < 0.0d) {
                d = 0.0d;
            }
            if (d > 9999999.0d) {
                this.aXZ.setText("¥" + ba.C((long) d));
            } else {
                this.aXZ.setText("¥" + String.format(Locale.getDefault(), "%.2f", Double.valueOf(d)));
            }
            this.cIX.setText(getResources().getString(u.j.ecomm_card_shipfee, S(dealInfoData.shipFee)));
            this.elN.setText(dealInfoData.sellerAddress);
        }
    }

    private String S(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        return f > 9999999.0f ? ba.C(f) : String.format(Locale.getDefault(), "%.2f", Float.valueOf(f));
    }

    public void aMt() {
        com.baidu.tbadk.j.a.a((TbPageContext) l.s(getContext()), this);
        av.k(this, u.f.pb_reply_ecomm_selector);
    }
}
