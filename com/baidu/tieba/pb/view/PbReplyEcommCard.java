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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes.dex */
public class PbReplyEcommCard extends RelativeLayout {
    private TextView bdS;
    private TbImageView cUA;
    private TextView cUB;
    private TextView cUC;
    private TextView exT;
    private DealInfoData exU;

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
        View inflate = LayoutInflater.from(getContext()).inflate(t.h.pb_reply_ecomm_card, (ViewGroup) this, true);
        this.cUA = (TbImageView) inflate.findViewById(t.g.card_photo);
        this.cUB = (TextView) inflate.findViewById(t.g.card_description);
        this.bdS = (TextView) inflate.findViewById(t.g.card_price);
        this.cUC = (TextView) inflate.findViewById(t.g.card_shipfee);
        this.exT = (TextView) inflate.findViewById(t.g.card_address);
        setOnClickListener(new t(this));
    }

    public void setData(DealInfoData dealInfoData) {
        if (dealInfoData != null) {
            this.exU = dealInfoData;
            ArrayList<DealMediaData> arrayList = dealInfoData.media;
            if (arrayList != null && arrayList.size() > 0) {
                this.cUA.c(arrayList.get(0).smallPic, 10, true);
            }
            this.cUB.setText(dealInfoData.title);
            double d = dealInfoData.unitPrice;
            if (d < 0.0d) {
                d = 0.0d;
            }
            if (d > 9999999.0d) {
                this.bdS.setText("¥" + ba.D((long) d));
            } else {
                this.bdS.setText("¥" + String.format(Locale.getDefault(), "%.2f", Double.valueOf(d)));
            }
            this.cUC.setText(getResources().getString(t.j.ecomm_card_shipfee, am(dealInfoData.shipFee)));
            this.exT.setText(dealInfoData.sellerAddress);
        }
    }

    private String am(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        return f > 9999999.0f ? ba.D(f) : String.format(Locale.getDefault(), "%.2f", Float.valueOf(f));
    }

    public void aRi() {
        com.baidu.tbadk.j.a.a((TbPageContext) l.C(getContext()), this);
        av.k(this, t.f.pb_reply_ecomm_selector);
    }
}
