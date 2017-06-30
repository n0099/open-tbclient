package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View crW;
    private TbImageView eLl;
    private TbImageView eLm;
    private TbImageView eLn;
    private TbImageView eLo;
    private TextView eLp;
    private TextView eLq;
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
        this.crW = View.inflate(this.mContext, w.j.pb_gift_list_item, this);
        this.eLl = (TbImageView) this.crW.findViewById(w.h.pb_gift_view1);
        this.eLm = (TbImageView) this.crW.findViewById(w.h.pb_gift_view2);
        this.eLn = (TbImageView) this.crW.findViewById(w.h.pb_gift_view3);
        this.eLo = (TbImageView) this.crW.findViewById(w.h.pb_gift_view4);
        this.eLl.setDefaultBgResource(w.g.transparent_bg);
        this.eLm.setDefaultBgResource(w.g.transparent_bg);
        this.eLn.setDefaultBgResource(w.g.transparent_bg);
        this.eLo.setDefaultBgResource(w.g.transparent_bg);
        this.eLl.setDefaultResource(w.g.icon_gift_moren);
        this.eLm.setDefaultResource(w.g.icon_gift_moren);
        this.eLn.setDefaultResource(w.g.icon_gift_moren);
        this.eLo.setDefaultResource(w.g.icon_gift_moren);
        this.eLp = (TextView) this.crW.findViewById(w.h.pb_gift_number_view);
        this.eLq = (TextView) this.crW.findViewById(w.h.pb_gift_send_view);
        this.eLq.setOnClickListener(new f(this));
    }

    public void a(at atVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (atVar == null || atVar.qt() == null || atVar.qt().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (atVar.qt().size() > 4 ? 4 : atVar.qt().size()) {
            case 1:
                this.eLl.c(atVar.qt().get(0).Vm, 10, false);
                this.eLl.setVisibility(0);
                this.eLm.setVisibility(8);
                this.eLn.setVisibility(8);
                this.eLo.setVisibility(8);
                break;
            case 2:
                this.eLl.c(atVar.qt().get(0).Vm, 10, false);
                this.eLm.c(atVar.qt().get(1).Vm, 10, false);
                this.eLl.setVisibility(0);
                this.eLm.setVisibility(0);
                this.eLn.setVisibility(8);
                this.eLo.setVisibility(8);
                break;
            case 3:
                this.eLl.c(atVar.qt().get(0).Vm, 10, false);
                this.eLm.c(atVar.qt().get(1).Vm, 10, false);
                this.eLn.c(atVar.qt().get(2).Vm, 10, false);
                this.eLl.setVisibility(0);
                this.eLm.setVisibility(0);
                this.eLn.setVisibility(0);
                this.eLo.setVisibility(8);
                break;
            case 4:
                this.eLl.c(atVar.qt().get(0).Vm, 10, false);
                this.eLm.c(atVar.qt().get(1).Vm, 10, false);
                this.eLn.c(atVar.qt().get(2).Vm, 10, false);
                this.eLo.c(atVar.qt().get(3).Vm, 10, false);
                this.eLl.setVisibility(0);
                this.eLm.setVisibility(0);
                this.eLn.setVisibility(0);
                this.eLo.setVisibility(0);
                break;
        }
        if (atVar.qs() > 0) {
            this.eLp.setText(String.format(this.mContext.getResources().getString(w.l.gift_counts), Integer.valueOf(atVar.qs())));
            this.eLp.setVisibility(0);
        } else {
            this.eLp.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.eLq.setVisibility(8);
        } else {
            this.eLq.setVisibility(0);
        }
    }

    public void jK(boolean z) {
        if (z) {
            this.eLq.setVisibility(0);
        } else {
            this.eLq.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        as.c(this.eLp, w.e.cp_cont_d, 1);
        as.c(this.eLq, w.e.cp_link_tip_c, 1);
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
