package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View bSl;
    private TbImageView ekc;
    private TbImageView ekd;
    private TbImageView eke;
    private TbImageView ekf;
    private TextView ekg;
    private TextView ekh;
    private Context mContext;
    private long postId;
    private long threadId;
    private long toUserId;
    private String toUserName;

    public PbGiftListView(Context context) {
        super(context);
    }

    public PbGiftListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public PbGiftListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bSl = View.inflate(this.mContext, r.h.pb_gift_list_item, this);
        this.ekc = (TbImageView) this.bSl.findViewById(r.g.pb_gift_view1);
        this.ekd = (TbImageView) this.bSl.findViewById(r.g.pb_gift_view2);
        this.eke = (TbImageView) this.bSl.findViewById(r.g.pb_gift_view3);
        this.ekf = (TbImageView) this.bSl.findViewById(r.g.pb_gift_view4);
        this.ekc.setDefaultBgResource(r.f.transparent_bg);
        this.ekd.setDefaultBgResource(r.f.transparent_bg);
        this.eke.setDefaultBgResource(r.f.transparent_bg);
        this.ekf.setDefaultBgResource(r.f.transparent_bg);
        this.ekc.setDefaultResource(r.f.icon_gift_moren);
        this.ekd.setDefaultResource(r.f.icon_gift_moren);
        this.eke.setDefaultResource(r.f.icon_gift_moren);
        this.ekf.setDefaultResource(r.f.icon_gift_moren);
        this.ekg = (TextView) this.bSl.findViewById(r.g.pb_gift_number_view);
        this.ekh = (TextView) this.bSl.findViewById(r.g.pb_gift_send_view);
        this.ekh.setOnClickListener(new d(this));
    }

    public void a(ao aoVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (aoVar == null || aoVar.qH() == null || aoVar.qH().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (aoVar.qH().size() > 4 ? 4 : aoVar.qH().size()) {
            case 1:
                this.ekc.c(aoVar.qH().get(0).Rt, 10, false);
                this.ekc.setVisibility(0);
                this.ekd.setVisibility(8);
                this.eke.setVisibility(8);
                this.ekf.setVisibility(8);
                break;
            case 2:
                this.ekc.c(aoVar.qH().get(0).Rt, 10, false);
                this.ekd.c(aoVar.qH().get(1).Rt, 10, false);
                this.ekc.setVisibility(0);
                this.ekd.setVisibility(0);
                this.eke.setVisibility(8);
                this.ekf.setVisibility(8);
                break;
            case 3:
                this.ekc.c(aoVar.qH().get(0).Rt, 10, false);
                this.ekd.c(aoVar.qH().get(1).Rt, 10, false);
                this.eke.c(aoVar.qH().get(2).Rt, 10, false);
                this.ekc.setVisibility(0);
                this.ekd.setVisibility(0);
                this.eke.setVisibility(0);
                this.ekf.setVisibility(8);
                break;
            case 4:
                this.ekc.c(aoVar.qH().get(0).Rt, 10, false);
                this.ekd.c(aoVar.qH().get(1).Rt, 10, false);
                this.eke.c(aoVar.qH().get(2).Rt, 10, false);
                this.ekf.c(aoVar.qH().get(3).Rt, 10, false);
                this.ekc.setVisibility(0);
                this.ekd.setVisibility(0);
                this.eke.setVisibility(0);
                this.ekf.setVisibility(0);
                break;
        }
        if (aoVar.qG() > 0) {
            this.ekg.setText(String.format(this.mContext.getResources().getString(r.j.gift_counts), Integer.valueOf(aoVar.qG())));
            this.ekg.setVisibility(0);
        } else {
            this.ekg.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.ekh.setVisibility(8);
        } else {
            this.ekh.setVisibility(0);
        }
    }

    public void iW(boolean z) {
        if (z) {
            this.ekh.setVisibility(0);
        } else {
            this.ekh.setVisibility(8);
        }
    }

    public void tm() {
        ar.c(this.ekg, r.d.cp_cont_d, 1);
        ar.c(this.ekh, r.d.cp_link_tip_c, 1);
    }

    public long getThreadId() {
        return this.threadId;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public long getPostId() {
        return this.postId;
    }

    public void setPostId(long j) {
        this.postId = j;
    }
}
