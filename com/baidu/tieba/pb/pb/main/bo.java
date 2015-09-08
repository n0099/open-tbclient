package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bo extends com.baidu.adp.base.f<PbActivity> {
    private TextView cdr;
    private TextView cds;
    private View cdt;
    private TextView cdu;
    private TextView cdv;
    private TextView cdw;
    private View cdx;
    private PbActivity cdy;
    private View.OnClickListener mClickListener;
    private View mView;

    public bo(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.cdr = null;
        this.cds = null;
        this.cdt = null;
        this.cdu = null;
        this.cdv = null;
        this.cdw = null;
        this.cdx = null;
        this.cdy = null;
        this.mClickListener = null;
        this.cdy = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aea() {
        return this.cdr;
    }

    public TextView aeb() {
        return this.cds;
    }

    public View aec() {
        return this.cdt;
    }

    public TextView aed() {
        return this.cdu;
    }

    public TextView aee() {
        return this.cdv;
    }

    public TextView aef() {
        return this.cdw;
    }

    public void ew(boolean z) {
        if (z) {
            this.cdw.setVisibility(8);
            this.cdx.setVisibility(8);
            return;
        }
        this.cdw.setVisibility(0);
        this.cdx.setVisibility(0);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.cdy.getPageContext().getPageActivity()).inflate(i.g.pb_more_view, (ViewGroup) null);
        this.cdr = (TextView) this.mView.findViewById(i.f.pb_more_view_item_mark);
        this.cdr.setOnClickListener(this.mClickListener);
        this.cds = (TextView) this.mView.findViewById(i.f.pb_more_view_item_share);
        this.cdt = this.mView.findViewById(i.f.pb_more_view_item_line_share);
        this.cds.setOnClickListener(this.mClickListener);
        this.cdu = (TextView) this.mView.findViewById(i.f.pb_more_view_item_jump);
        this.cdu.setOnClickListener(this.mClickListener);
        this.cdv = (TextView) this.mView.findViewById(i.f.pb_more_view_item_see);
        this.cdv.setOnClickListener(this.mClickListener);
        this.cdw = (TextView) this.mView.findViewById(i.f.pb_more_view_item_report);
        this.cdw.setOnClickListener(this.mClickListener);
        this.cdx = this.mView.findViewById(i.f.pb_more_view_item_report_line);
    }
}
