package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bo extends com.baidu.adp.base.f<PbActivity> {
    private View ccA;
    private PbActivity ccB;
    private TextView ccu;
    private TextView ccv;
    private View ccw;
    private TextView ccx;
    private TextView ccy;
    private TextView ccz;
    private View.OnClickListener mClickListener;
    private View mView;

    public bo(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.ccu = null;
        this.ccv = null;
        this.ccw = null;
        this.ccx = null;
        this.ccy = null;
        this.ccz = null;
        this.ccA = null;
        this.ccB = null;
        this.mClickListener = null;
        this.ccB = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView adM() {
        return this.ccu;
    }

    public TextView adN() {
        return this.ccv;
    }

    public View adO() {
        return this.ccw;
    }

    public TextView adP() {
        return this.ccx;
    }

    public TextView adQ() {
        return this.ccy;
    }

    public TextView adR() {
        return this.ccz;
    }

    public void eo(boolean z) {
        if (z) {
            this.ccz.setVisibility(8);
            this.ccA.setVisibility(8);
            return;
        }
        this.ccz.setVisibility(0);
        this.ccA.setVisibility(0);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.ccB.getPageContext().getPageActivity()).inflate(i.g.pb_more_view, (ViewGroup) null);
        this.ccu = (TextView) this.mView.findViewById(i.f.pb_more_view_item_mark);
        this.ccu.setOnClickListener(this.mClickListener);
        this.ccv = (TextView) this.mView.findViewById(i.f.pb_more_view_item_share);
        this.ccw = this.mView.findViewById(i.f.pb_more_view_item_line_share);
        this.ccv.setOnClickListener(this.mClickListener);
        this.ccx = (TextView) this.mView.findViewById(i.f.pb_more_view_item_jump);
        this.ccx.setOnClickListener(this.mClickListener);
        this.ccy = (TextView) this.mView.findViewById(i.f.pb_more_view_item_see);
        this.ccy.setOnClickListener(this.mClickListener);
        this.ccz = (TextView) this.mView.findViewById(i.f.pb_more_view_item_report);
        this.ccz.setOnClickListener(this.mClickListener);
        this.ccA = this.mView.findViewById(i.f.pb_more_view_item_report_line);
    }
}
