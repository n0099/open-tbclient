package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.base.f<PbActivity> {
    private TextView cjF;
    private TextView cjG;
    private View cjH;
    private TextView cjI;
    private TextView cjJ;
    private TextView cjK;
    private View cjL;
    private PbActivity cjM;
    private View.OnClickListener mClickListener;
    private View mView;

    public bp(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.cjF = null;
        this.cjG = null;
        this.cjH = null;
        this.cjI = null;
        this.cjJ = null;
        this.cjK = null;
        this.cjL = null;
        this.cjM = null;
        this.mClickListener = null;
        this.cjM = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView afY() {
        return this.cjF;
    }

    public TextView afZ() {
        return this.cjG;
    }

    public View aga() {
        return this.cjH;
    }

    public TextView agb() {
        return this.cjI;
    }

    public TextView agc() {
        return this.cjJ;
    }

    public TextView agd() {
        return this.cjK;
    }

    public void eB(boolean z) {
        if (z) {
            this.cjK.setVisibility(8);
            this.cjL.setVisibility(8);
            return;
        }
        this.cjK.setVisibility(0);
        this.cjL.setVisibility(0);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.cjM.getPageContext().getPageActivity()).inflate(i.g.pb_more_view, (ViewGroup) null);
        this.cjF = (TextView) this.mView.findViewById(i.f.pb_more_view_item_mark);
        this.cjF.setOnClickListener(this.mClickListener);
        this.cjG = (TextView) this.mView.findViewById(i.f.pb_more_view_item_share);
        this.cjH = this.mView.findViewById(i.f.pb_more_view_item_line_share);
        this.cjG.setOnClickListener(this.mClickListener);
        this.cjI = (TextView) this.mView.findViewById(i.f.pb_more_view_item_jump);
        this.cjI.setOnClickListener(this.mClickListener);
        this.cjJ = (TextView) this.mView.findViewById(i.f.pb_more_view_item_see);
        this.cjJ.setOnClickListener(this.mClickListener);
        this.cjK = (TextView) this.mView.findViewById(i.f.pb_more_view_item_report);
        this.cjK.setOnClickListener(this.mClickListener);
        this.cjL = this.mView.findViewById(i.f.pb_more_view_item_report_line);
    }
}
