package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View bJp;
    private TbImageView dqh;
    private TbImageView dqi;
    private TbImageView dqj;
    private TbImageView dqk;
    private TextView dql;
    private TextView dqm;
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
        this.bJp = View.inflate(this.mContext, t.h.pb_gift_list_item, this);
        this.dqh = (TbImageView) this.bJp.findViewById(t.g.pb_gift_view1);
        this.dqi = (TbImageView) this.bJp.findViewById(t.g.pb_gift_view2);
        this.dqj = (TbImageView) this.bJp.findViewById(t.g.pb_gift_view3);
        this.dqk = (TbImageView) this.bJp.findViewById(t.g.pb_gift_view4);
        this.dqh.setDefaultBgResource(t.f.transparent_bg);
        this.dqi.setDefaultBgResource(t.f.transparent_bg);
        this.dqj.setDefaultBgResource(t.f.transparent_bg);
        this.dqk.setDefaultBgResource(t.f.transparent_bg);
        this.dqh.setDefaultResource(t.f.icon_gift_moren);
        this.dqi.setDefaultResource(t.f.icon_gift_moren);
        this.dqj.setDefaultResource(t.f.icon_gift_moren);
        this.dqk.setDefaultResource(t.f.icon_gift_moren);
        this.dql = (TextView) this.bJp.findViewById(t.g.pb_gift_number_view);
        this.dqm = (TextView) this.bJp.findViewById(t.g.pb_gift_send_view);
        this.dqm.setOnClickListener(new d(this));
    }

    public void a(ad adVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (adVar == null || adVar.st() == null || adVar.st().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (adVar.st().size() > 4 ? 4 : adVar.st().size()) {
            case 1:
                this.dqh.c(adVar.st().get(0).thumbnailUrl, 10, false);
                this.dqh.setVisibility(0);
                this.dqi.setVisibility(8);
                this.dqj.setVisibility(8);
                this.dqk.setVisibility(8);
                break;
            case 2:
                this.dqh.c(adVar.st().get(0).thumbnailUrl, 10, false);
                this.dqi.c(adVar.st().get(1).thumbnailUrl, 10, false);
                this.dqh.setVisibility(0);
                this.dqi.setVisibility(0);
                this.dqj.setVisibility(8);
                this.dqk.setVisibility(8);
                break;
            case 3:
                this.dqh.c(adVar.st().get(0).thumbnailUrl, 10, false);
                this.dqi.c(adVar.st().get(1).thumbnailUrl, 10, false);
                this.dqj.c(adVar.st().get(2).thumbnailUrl, 10, false);
                this.dqh.setVisibility(0);
                this.dqi.setVisibility(0);
                this.dqj.setVisibility(0);
                this.dqk.setVisibility(8);
                break;
            case 4:
                this.dqh.c(adVar.st().get(0).thumbnailUrl, 10, false);
                this.dqi.c(adVar.st().get(1).thumbnailUrl, 10, false);
                this.dqj.c(adVar.st().get(2).thumbnailUrl, 10, false);
                this.dqk.c(adVar.st().get(3).thumbnailUrl, 10, false);
                this.dqh.setVisibility(0);
                this.dqi.setVisibility(0);
                this.dqj.setVisibility(0);
                this.dqk.setVisibility(0);
                break;
        }
        if (adVar.ss() > 0) {
            this.dql.setText(String.format(this.mContext.getResources().getString(t.j.gift_counts), Integer.valueOf(adVar.ss())));
            this.dql.setVisibility(0);
        } else {
            this.dql.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.dqm.setVisibility(8);
        } else {
            this.dqm.setVisibility(0);
        }
    }

    public void gC(boolean z) {
        if (z) {
            this.dqm.setVisibility(0);
        } else {
            this.dqm.setVisibility(8);
        }
    }

    public void uA() {
        at.b(this.dql, t.d.cp_cont_d, 1);
        at.b(this.dqm, t.d.cp_link_tip_c, 1);
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
