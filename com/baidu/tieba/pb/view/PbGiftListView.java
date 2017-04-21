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
    private View cgV;
    private TbImageView exQ;
    private TbImageView exR;
    private TbImageView exS;
    private TbImageView exT;
    private TextView exU;
    private TextView exV;
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
        this.cgV = View.inflate(this.mContext, w.j.pb_gift_list_item, this);
        this.exQ = (TbImageView) this.cgV.findViewById(w.h.pb_gift_view1);
        this.exR = (TbImageView) this.cgV.findViewById(w.h.pb_gift_view2);
        this.exS = (TbImageView) this.cgV.findViewById(w.h.pb_gift_view3);
        this.exT = (TbImageView) this.cgV.findViewById(w.h.pb_gift_view4);
        this.exQ.setDefaultBgResource(w.g.transparent_bg);
        this.exR.setDefaultBgResource(w.g.transparent_bg);
        this.exS.setDefaultBgResource(w.g.transparent_bg);
        this.exT.setDefaultBgResource(w.g.transparent_bg);
        this.exQ.setDefaultResource(w.g.icon_gift_moren);
        this.exR.setDefaultResource(w.g.icon_gift_moren);
        this.exS.setDefaultResource(w.g.icon_gift_moren);
        this.exT.setDefaultResource(w.g.icon_gift_moren);
        this.exU = (TextView) this.cgV.findViewById(w.h.pb_gift_number_view);
        this.exV = (TextView) this.cgV.findViewById(w.h.pb_gift_send_view);
        this.exV.setOnClickListener(new d(this));
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
                this.exQ.c(aqVar.rq().get(0).Wg, 10, false);
                this.exQ.setVisibility(0);
                this.exR.setVisibility(8);
                this.exS.setVisibility(8);
                this.exT.setVisibility(8);
                break;
            case 2:
                this.exQ.c(aqVar.rq().get(0).Wg, 10, false);
                this.exR.c(aqVar.rq().get(1).Wg, 10, false);
                this.exQ.setVisibility(0);
                this.exR.setVisibility(0);
                this.exS.setVisibility(8);
                this.exT.setVisibility(8);
                break;
            case 3:
                this.exQ.c(aqVar.rq().get(0).Wg, 10, false);
                this.exR.c(aqVar.rq().get(1).Wg, 10, false);
                this.exS.c(aqVar.rq().get(2).Wg, 10, false);
                this.exQ.setVisibility(0);
                this.exR.setVisibility(0);
                this.exS.setVisibility(0);
                this.exT.setVisibility(8);
                break;
            case 4:
                this.exQ.c(aqVar.rq().get(0).Wg, 10, false);
                this.exR.c(aqVar.rq().get(1).Wg, 10, false);
                this.exS.c(aqVar.rq().get(2).Wg, 10, false);
                this.exT.c(aqVar.rq().get(3).Wg, 10, false);
                this.exQ.setVisibility(0);
                this.exR.setVisibility(0);
                this.exS.setVisibility(0);
                this.exT.setVisibility(0);
                break;
        }
        if (aqVar.rp() > 0) {
            this.exU.setText(String.format(this.mContext.getResources().getString(w.l.gift_counts), Integer.valueOf(aqVar.rp())));
            this.exU.setVisibility(0);
        } else {
            this.exU.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.exV.setVisibility(8);
        } else {
            this.exV.setVisibility(0);
        }
    }

    public void jo(boolean z) {
        if (z) {
            this.exV.setVisibility(0);
        } else {
            this.exV.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.aq.c(this.exU, w.e.cp_cont_d, 1);
        com.baidu.tbadk.core.util.aq.c(this.exV, w.e.cp_link_tip_c, 1);
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
