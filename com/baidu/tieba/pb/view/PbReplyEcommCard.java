package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.data.DealMediaData;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes.dex */
public class PbReplyEcommCard extends RelativeLayout {
    private String TY;
    private TextView bhl;
    private TbImageView dbF;
    private TextView dbG;
    private TextView dbH;
    private TextView eGJ;
    private DealInfoData eGK;

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
        this.dbF = (TbImageView) inflate.findViewById(r.g.card_photo);
        this.dbG = (TextView) inflate.findViewById(r.g.card_description);
        this.bhl = (TextView) inflate.findViewById(r.g.card_price);
        this.dbH = (TextView) inflate.findViewById(r.g.card_shipfee);
        this.eGJ = (TextView) inflate.findViewById(r.g.card_address);
        setOnClickListener(new r(this));
    }

    public void a(DealInfoData dealInfoData, String str) {
        if (dealInfoData != null) {
            this.eGK = dealInfoData;
            this.TY = str;
            ArrayList<DealMediaData> arrayList = dealInfoData.media;
            if (arrayList != null && arrayList.size() > 0) {
                this.dbF.c(arrayList.get(0).smallPic, 10, true);
            }
            this.dbG.setText(dealInfoData.title);
            double d = dealInfoData.unitPrice;
            if (d < 0.0d) {
                d = 0.0d;
            }
            if (d > 9999999.0d) {
                this.bhl.setText("¥" + ax.D((long) d));
            } else {
                this.bhl.setText("¥" + String.format(Locale.getDefault(), "%.2f", Double.valueOf(d)));
            }
            this.dbH.setText(getResources().getString(r.j.ecomm_card_shipfee, an(dealInfoData.shipFee)));
            this.eGJ.setText(dealInfoData.sellerAddress);
        }
    }

    private String an(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        return f > 9999999.0f ? ax.D(f) : String.format(Locale.getDefault(), "%.2f", Float.valueOf(f));
    }

    public void aTX() {
        com.baidu.tbadk.i.a.a((TbPageContext) com.baidu.adp.base.l.C(getContext()), this);
        at.k(this, r.f.pb_reply_ecomm_selector);
    }
}
