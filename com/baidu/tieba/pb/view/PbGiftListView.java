package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View cnb;
    private TbImageView eGj;
    private TbImageView eGk;
    private TbImageView eGl;
    private TbImageView eGm;
    private TextView eGn;
    private TextView eGo;
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
        this.cnb = View.inflate(this.mContext, r.h.pb_gift_list_item, this);
        this.eGj = (TbImageView) this.cnb.findViewById(r.g.pb_gift_view1);
        this.eGk = (TbImageView) this.cnb.findViewById(r.g.pb_gift_view2);
        this.eGl = (TbImageView) this.cnb.findViewById(r.g.pb_gift_view3);
        this.eGm = (TbImageView) this.cnb.findViewById(r.g.pb_gift_view4);
        this.eGj.setDefaultBgResource(r.f.transparent_bg);
        this.eGk.setDefaultBgResource(r.f.transparent_bg);
        this.eGl.setDefaultBgResource(r.f.transparent_bg);
        this.eGm.setDefaultBgResource(r.f.transparent_bg);
        this.eGj.setDefaultResource(r.f.icon_gift_moren);
        this.eGk.setDefaultResource(r.f.icon_gift_moren);
        this.eGl.setDefaultResource(r.f.icon_gift_moren);
        this.eGm.setDefaultResource(r.f.icon_gift_moren);
        this.eGn = (TextView) this.cnb.findViewById(r.g.pb_gift_number_view);
        this.eGo = (TextView) this.cnb.findViewById(r.g.pb_gift_send_view);
        this.eGo.setOnClickListener(new k(this));
    }

    public void a(ap apVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (apVar == null || apVar.qG() == null || apVar.qG().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (apVar.qG().size() > 4 ? 4 : apVar.qG().size()) {
            case 1:
                this.eGj.c(apVar.qG().get(0).Rw, 10, false);
                this.eGj.setVisibility(0);
                this.eGk.setVisibility(8);
                this.eGl.setVisibility(8);
                this.eGm.setVisibility(8);
                break;
            case 2:
                this.eGj.c(apVar.qG().get(0).Rw, 10, false);
                this.eGk.c(apVar.qG().get(1).Rw, 10, false);
                this.eGj.setVisibility(0);
                this.eGk.setVisibility(0);
                this.eGl.setVisibility(8);
                this.eGm.setVisibility(8);
                break;
            case 3:
                this.eGj.c(apVar.qG().get(0).Rw, 10, false);
                this.eGk.c(apVar.qG().get(1).Rw, 10, false);
                this.eGl.c(apVar.qG().get(2).Rw, 10, false);
                this.eGj.setVisibility(0);
                this.eGk.setVisibility(0);
                this.eGl.setVisibility(0);
                this.eGm.setVisibility(8);
                break;
            case 4:
                this.eGj.c(apVar.qG().get(0).Rw, 10, false);
                this.eGk.c(apVar.qG().get(1).Rw, 10, false);
                this.eGl.c(apVar.qG().get(2).Rw, 10, false);
                this.eGm.c(apVar.qG().get(3).Rw, 10, false);
                this.eGj.setVisibility(0);
                this.eGk.setVisibility(0);
                this.eGl.setVisibility(0);
                this.eGm.setVisibility(0);
                break;
        }
        if (apVar.qF() > 0) {
            this.eGn.setText(String.format(this.mContext.getResources().getString(r.j.gift_counts), Integer.valueOf(apVar.qF())));
            this.eGn.setVisibility(0);
        } else {
            this.eGn.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.eGo.setVisibility(8);
        } else {
            this.eGo.setVisibility(0);
        }
    }

    public void jl(boolean z) {
        if (z) {
            this.eGo.setVisibility(0);
        } else {
            this.eGo.setVisibility(8);
        }
    }

    public void tB() {
        at.c(this.eGn, r.d.cp_cont_d, 1);
        at.c(this.eGo, r.d.cp_link_tip_c, 1);
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
