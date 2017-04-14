package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View ceE;
    private TbImageView evA;
    private TbImageView evB;
    private TbImageView evC;
    private TextView evD;
    private TextView evE;
    private TbImageView evz;
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
        this.ceE = View.inflate(this.mContext, w.j.pb_gift_list_item, this);
        this.evz = (TbImageView) this.ceE.findViewById(w.h.pb_gift_view1);
        this.evA = (TbImageView) this.ceE.findViewById(w.h.pb_gift_view2);
        this.evB = (TbImageView) this.ceE.findViewById(w.h.pb_gift_view3);
        this.evC = (TbImageView) this.ceE.findViewById(w.h.pb_gift_view4);
        this.evz.setDefaultBgResource(w.g.transparent_bg);
        this.evA.setDefaultBgResource(w.g.transparent_bg);
        this.evB.setDefaultBgResource(w.g.transparent_bg);
        this.evC.setDefaultBgResource(w.g.transparent_bg);
        this.evz.setDefaultResource(w.g.icon_gift_moren);
        this.evA.setDefaultResource(w.g.icon_gift_moren);
        this.evB.setDefaultResource(w.g.icon_gift_moren);
        this.evC.setDefaultResource(w.g.icon_gift_moren);
        this.evD = (TextView) this.ceE.findViewById(w.h.pb_gift_number_view);
        this.evE = (TextView) this.ceE.findViewById(w.h.pb_gift_send_view);
        this.evE.setOnClickListener(new d(this));
    }

    public void a(aq aqVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (aqVar == null || aqVar.rq() == null || aqVar.rq().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (aqVar.rq().size() > 4 ? 4 : aqVar.rq().size()) {
            case 1:
                this.evz.c(aqVar.rq().get(0).We, 10, false);
                this.evz.setVisibility(0);
                this.evA.setVisibility(8);
                this.evB.setVisibility(8);
                this.evC.setVisibility(8);
                break;
            case 2:
                this.evz.c(aqVar.rq().get(0).We, 10, false);
                this.evA.c(aqVar.rq().get(1).We, 10, false);
                this.evz.setVisibility(0);
                this.evA.setVisibility(0);
                this.evB.setVisibility(8);
                this.evC.setVisibility(8);
                break;
            case 3:
                this.evz.c(aqVar.rq().get(0).We, 10, false);
                this.evA.c(aqVar.rq().get(1).We, 10, false);
                this.evB.c(aqVar.rq().get(2).We, 10, false);
                this.evz.setVisibility(0);
                this.evA.setVisibility(0);
                this.evB.setVisibility(0);
                this.evC.setVisibility(8);
                break;
            case 4:
                this.evz.c(aqVar.rq().get(0).We, 10, false);
                this.evA.c(aqVar.rq().get(1).We, 10, false);
                this.evB.c(aqVar.rq().get(2).We, 10, false);
                this.evC.c(aqVar.rq().get(3).We, 10, false);
                this.evz.setVisibility(0);
                this.evA.setVisibility(0);
                this.evB.setVisibility(0);
                this.evC.setVisibility(0);
                break;
        }
        if (aqVar.rp() > 0) {
            this.evD.setText(String.format(this.mContext.getResources().getString(w.l.gift_counts), Integer.valueOf(aqVar.rp())));
            this.evD.setVisibility(0);
        } else {
            this.evD.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.evE.setVisibility(8);
        } else {
            this.evE.setVisibility(0);
        }
    }

    public void je(boolean z) {
        if (z) {
            this.evE.setVisibility(0);
        } else {
            this.evE.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.aq.c(this.evD, w.e.cp_cont_d, 1);
        com.baidu.tbadk.core.util.aq.c(this.evE, w.e.cp_link_tip_c, 1);
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
