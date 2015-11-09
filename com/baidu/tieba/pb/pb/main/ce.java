package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ce extends com.baidu.adp.base.f<PbActivity> {
    private TextView cld;
    private TextView cle;
    private View clf;
    private TextView clg;
    private TextView clh;
    private TextView cli;
    private View clj;
    private PbActivity clk;
    private View.OnClickListener mClickListener;
    private View mView;

    public ce(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.cld = null;
        this.cle = null;
        this.clf = null;
        this.clg = null;
        this.clh = null;
        this.cli = null;
        this.clj = null;
        this.clk = null;
        this.mClickListener = null;
        this.clk = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView agz() {
        return this.cld;
    }

    public TextView agA() {
        return this.cle;
    }

    public View agB() {
        return this.clf;
    }

    public TextView agC() {
        return this.clg;
    }

    public TextView agD() {
        return this.clh;
    }

    public TextView agE() {
        return this.cli;
    }

    public void eE(boolean z) {
        if (z) {
            this.cli.setVisibility(8);
            this.clj.setVisibility(8);
            return;
        }
        this.cli.setVisibility(0);
        this.clj.setVisibility(0);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.clk.getPageContext().getPageActivity()).inflate(i.g.pb_more_view, (ViewGroup) null);
        this.cld = (TextView) this.mView.findViewById(i.f.pb_more_view_item_mark);
        this.cld.setOnClickListener(this.mClickListener);
        this.cle = (TextView) this.mView.findViewById(i.f.pb_more_view_item_share);
        this.clf = this.mView.findViewById(i.f.pb_more_view_item_line_share);
        this.cle.setOnClickListener(this.mClickListener);
        this.clg = (TextView) this.mView.findViewById(i.f.pb_more_view_item_jump);
        this.clg.setOnClickListener(this.mClickListener);
        this.clh = (TextView) this.mView.findViewById(i.f.pb_more_view_item_see);
        this.clh.setOnClickListener(this.mClickListener);
        this.cli = (TextView) this.mView.findViewById(i.f.pb_more_view_item_report);
        this.cli.setOnClickListener(this.mClickListener);
        this.clj = this.mView.findViewById(i.f.pb_more_view_item_report_line);
    }
}
