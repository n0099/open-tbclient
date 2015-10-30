package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.base.f<PbActivity> {
    private TextView cjQ;
    private TextView cjR;
    private View cjS;
    private TextView cjT;
    private TextView cjU;
    private TextView cjV;
    private View cjW;
    private PbActivity cjX;
    private View.OnClickListener mClickListener;
    private View mView;

    public bp(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.cjQ = null;
        this.cjR = null;
        this.cjS = null;
        this.cjT = null;
        this.cjU = null;
        this.cjV = null;
        this.cjW = null;
        this.cjX = null;
        this.mClickListener = null;
        this.cjX = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView afU() {
        return this.cjQ;
    }

    public TextView afV() {
        return this.cjR;
    }

    public View afW() {
        return this.cjS;
    }

    public TextView afX() {
        return this.cjT;
    }

    public TextView afY() {
        return this.cjU;
    }

    public TextView afZ() {
        return this.cjV;
    }

    public void eB(boolean z) {
        if (z) {
            this.cjV.setVisibility(8);
            this.cjW.setVisibility(8);
            return;
        }
        this.cjV.setVisibility(0);
        this.cjW.setVisibility(0);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.cjX.getPageContext().getPageActivity()).inflate(i.g.pb_more_view, (ViewGroup) null);
        this.cjQ = (TextView) this.mView.findViewById(i.f.pb_more_view_item_mark);
        this.cjQ.setOnClickListener(this.mClickListener);
        this.cjR = (TextView) this.mView.findViewById(i.f.pb_more_view_item_share);
        this.cjS = this.mView.findViewById(i.f.pb_more_view_item_line_share);
        this.cjR.setOnClickListener(this.mClickListener);
        this.cjT = (TextView) this.mView.findViewById(i.f.pb_more_view_item_jump);
        this.cjT.setOnClickListener(this.mClickListener);
        this.cjU = (TextView) this.mView.findViewById(i.f.pb_more_view_item_see);
        this.cjU.setOnClickListener(this.mClickListener);
        this.cjV = (TextView) this.mView.findViewById(i.f.pb_more_view_item_report);
        this.cjV.setOnClickListener(this.mClickListener);
        this.cjW = this.mView.findViewById(i.f.pb_more_view_item_report_line);
    }
}
