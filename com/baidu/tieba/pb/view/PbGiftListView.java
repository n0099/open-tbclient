package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View ckf;
    private TbImageView eBO;
    private TbImageView eBP;
    private TbImageView eBQ;
    private TbImageView eBR;
    private TextView eBS;
    private TextView eBT;
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
        this.ckf = View.inflate(this.mContext, w.j.pb_gift_list_item, this);
        this.eBO = (TbImageView) this.ckf.findViewById(w.h.pb_gift_view1);
        this.eBP = (TbImageView) this.ckf.findViewById(w.h.pb_gift_view2);
        this.eBQ = (TbImageView) this.ckf.findViewById(w.h.pb_gift_view3);
        this.eBR = (TbImageView) this.ckf.findViewById(w.h.pb_gift_view4);
        this.eBO.setDefaultBgResource(w.g.transparent_bg);
        this.eBP.setDefaultBgResource(w.g.transparent_bg);
        this.eBQ.setDefaultBgResource(w.g.transparent_bg);
        this.eBR.setDefaultBgResource(w.g.transparent_bg);
        this.eBO.setDefaultResource(w.g.icon_gift_moren);
        this.eBP.setDefaultResource(w.g.icon_gift_moren);
        this.eBQ.setDefaultResource(w.g.icon_gift_moren);
        this.eBR.setDefaultResource(w.g.icon_gift_moren);
        this.eBS = (TextView) this.ckf.findViewById(w.h.pb_gift_number_view);
        this.eBT = (TextView) this.ckf.findViewById(w.h.pb_gift_send_view);
        this.eBT.setOnClickListener(new f(this));
    }

    public void a(as asVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (asVar == null || asVar.qw() == null || asVar.qw().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (asVar.qw().size() > 4 ? 4 : asVar.qw().size()) {
            case 1:
                this.eBO.c(asVar.qw().get(0).Vm, 10, false);
                this.eBO.setVisibility(0);
                this.eBP.setVisibility(8);
                this.eBQ.setVisibility(8);
                this.eBR.setVisibility(8);
                break;
            case 2:
                this.eBO.c(asVar.qw().get(0).Vm, 10, false);
                this.eBP.c(asVar.qw().get(1).Vm, 10, false);
                this.eBO.setVisibility(0);
                this.eBP.setVisibility(0);
                this.eBQ.setVisibility(8);
                this.eBR.setVisibility(8);
                break;
            case 3:
                this.eBO.c(asVar.qw().get(0).Vm, 10, false);
                this.eBP.c(asVar.qw().get(1).Vm, 10, false);
                this.eBQ.c(asVar.qw().get(2).Vm, 10, false);
                this.eBO.setVisibility(0);
                this.eBP.setVisibility(0);
                this.eBQ.setVisibility(0);
                this.eBR.setVisibility(8);
                break;
            case 4:
                this.eBO.c(asVar.qw().get(0).Vm, 10, false);
                this.eBP.c(asVar.qw().get(1).Vm, 10, false);
                this.eBQ.c(asVar.qw().get(2).Vm, 10, false);
                this.eBR.c(asVar.qw().get(3).Vm, 10, false);
                this.eBO.setVisibility(0);
                this.eBP.setVisibility(0);
                this.eBQ.setVisibility(0);
                this.eBR.setVisibility(0);
                break;
        }
        if (asVar.qv() > 0) {
            this.eBS.setText(String.format(this.mContext.getResources().getString(w.l.gift_counts), Integer.valueOf(asVar.qv())));
            this.eBS.setVisibility(0);
        } else {
            this.eBS.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.eBT.setVisibility(8);
        } else {
            this.eBT.setVisibility(0);
        }
    }

    public void jm(boolean z) {
        if (z) {
            this.eBT.setVisibility(0);
        } else {
            this.eBT.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        aq.c(this.eBS, w.e.cp_cont_d, 1);
        aq.c(this.eBT, w.e.cp_link_tip_c, 1);
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
