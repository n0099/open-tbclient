package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View bUM;
    private TbImageView dYL;
    private TbImageView dYM;
    private TbImageView dYN;
    private TbImageView dYO;
    private TextView dYP;
    private TextView dYQ;
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
        this.bUM = View.inflate(this.mContext, u.h.pb_gift_list_item, this);
        this.dYL = (TbImageView) this.bUM.findViewById(u.g.pb_gift_view1);
        this.dYM = (TbImageView) this.bUM.findViewById(u.g.pb_gift_view2);
        this.dYN = (TbImageView) this.bUM.findViewById(u.g.pb_gift_view3);
        this.dYO = (TbImageView) this.bUM.findViewById(u.g.pb_gift_view4);
        this.dYL.setDefaultBgResource(u.f.transparent_bg);
        this.dYM.setDefaultBgResource(u.f.transparent_bg);
        this.dYN.setDefaultBgResource(u.f.transparent_bg);
        this.dYO.setDefaultBgResource(u.f.transparent_bg);
        this.dYL.setDefaultResource(u.f.icon_gift_moren);
        this.dYM.setDefaultResource(u.f.icon_gift_moren);
        this.dYN.setDefaultResource(u.f.icon_gift_moren);
        this.dYO.setDefaultResource(u.f.icon_gift_moren);
        this.dYP = (TextView) this.bUM.findViewById(u.g.pb_gift_number_view);
        this.dYQ = (TextView) this.bUM.findViewById(u.g.pb_gift_send_view);
        this.dYQ.setOnClickListener(new m(this));
    }

    public void a(ag agVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (agVar == null || agVar.pH() == null || agVar.pH().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (agVar.pH().size() > 4 ? 4 : agVar.pH().size()) {
            case 1:
                this.dYL.c(agVar.pH().get(0).thumbnailUrl, 10, false);
                this.dYL.setVisibility(0);
                this.dYM.setVisibility(8);
                this.dYN.setVisibility(8);
                this.dYO.setVisibility(8);
                break;
            case 2:
                this.dYL.c(agVar.pH().get(0).thumbnailUrl, 10, false);
                this.dYM.c(agVar.pH().get(1).thumbnailUrl, 10, false);
                this.dYL.setVisibility(0);
                this.dYM.setVisibility(0);
                this.dYN.setVisibility(8);
                this.dYO.setVisibility(8);
                break;
            case 3:
                this.dYL.c(agVar.pH().get(0).thumbnailUrl, 10, false);
                this.dYM.c(agVar.pH().get(1).thumbnailUrl, 10, false);
                this.dYN.c(agVar.pH().get(2).thumbnailUrl, 10, false);
                this.dYL.setVisibility(0);
                this.dYM.setVisibility(0);
                this.dYN.setVisibility(0);
                this.dYO.setVisibility(8);
                break;
            case 4:
                this.dYL.c(agVar.pH().get(0).thumbnailUrl, 10, false);
                this.dYM.c(agVar.pH().get(1).thumbnailUrl, 10, false);
                this.dYN.c(agVar.pH().get(2).thumbnailUrl, 10, false);
                this.dYO.c(agVar.pH().get(3).thumbnailUrl, 10, false);
                this.dYL.setVisibility(0);
                this.dYM.setVisibility(0);
                this.dYN.setVisibility(0);
                this.dYO.setVisibility(0);
                break;
        }
        if (agVar.pG() > 0) {
            this.dYP.setText(String.format(this.mContext.getResources().getString(u.j.gift_counts), Integer.valueOf(agVar.pG())));
            this.dYP.setVisibility(0);
        } else {
            this.dYP.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.dYQ.setVisibility(8);
        } else {
            this.dYQ.setVisibility(0);
        }
    }

    public void ib(boolean z) {
        if (z) {
            this.dYQ.setVisibility(0);
        } else {
            this.dYQ.setVisibility(8);
        }
    }

    public void se() {
        av.c(this.dYP, u.d.cp_cont_d, 1);
        av.c(this.dYQ, u.d.cp_link_tip_c, 1);
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
