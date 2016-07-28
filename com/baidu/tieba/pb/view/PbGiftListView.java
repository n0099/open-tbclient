package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View bWM;
    private TbImageView eln;
    private TbImageView elo;
    private TbImageView elp;
    private TbImageView elq;
    private TextView elr;
    private TextView els;
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
        this.bWM = View.inflate(this.mContext, u.h.pb_gift_list_item, this);
        this.eln = (TbImageView) this.bWM.findViewById(u.g.pb_gift_view1);
        this.elo = (TbImageView) this.bWM.findViewById(u.g.pb_gift_view2);
        this.elp = (TbImageView) this.bWM.findViewById(u.g.pb_gift_view3);
        this.elq = (TbImageView) this.bWM.findViewById(u.g.pb_gift_view4);
        this.eln.setDefaultBgResource(u.f.transparent_bg);
        this.elo.setDefaultBgResource(u.f.transparent_bg);
        this.elp.setDefaultBgResource(u.f.transparent_bg);
        this.elq.setDefaultBgResource(u.f.transparent_bg);
        this.eln.setDefaultResource(u.f.icon_gift_moren);
        this.elo.setDefaultResource(u.f.icon_gift_moren);
        this.elp.setDefaultResource(u.f.icon_gift_moren);
        this.elq.setDefaultResource(u.f.icon_gift_moren);
        this.elr = (TextView) this.bWM.findViewById(u.g.pb_gift_number_view);
        this.els = (TextView) this.bWM.findViewById(u.g.pb_gift_send_view);
        this.els.setOnClickListener(new m(this));
    }

    public void a(ak akVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (akVar == null || akVar.pq() == null || akVar.pq().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (akVar.pq().size() > 4 ? 4 : akVar.pq().size()) {
            case 1:
                this.eln.c(akVar.pq().get(0).thumbnailUrl, 10, false);
                this.eln.setVisibility(0);
                this.elo.setVisibility(8);
                this.elp.setVisibility(8);
                this.elq.setVisibility(8);
                break;
            case 2:
                this.eln.c(akVar.pq().get(0).thumbnailUrl, 10, false);
                this.elo.c(akVar.pq().get(1).thumbnailUrl, 10, false);
                this.eln.setVisibility(0);
                this.elo.setVisibility(0);
                this.elp.setVisibility(8);
                this.elq.setVisibility(8);
                break;
            case 3:
                this.eln.c(akVar.pq().get(0).thumbnailUrl, 10, false);
                this.elo.c(akVar.pq().get(1).thumbnailUrl, 10, false);
                this.elp.c(akVar.pq().get(2).thumbnailUrl, 10, false);
                this.eln.setVisibility(0);
                this.elo.setVisibility(0);
                this.elp.setVisibility(0);
                this.elq.setVisibility(8);
                break;
            case 4:
                this.eln.c(akVar.pq().get(0).thumbnailUrl, 10, false);
                this.elo.c(akVar.pq().get(1).thumbnailUrl, 10, false);
                this.elp.c(akVar.pq().get(2).thumbnailUrl, 10, false);
                this.elq.c(akVar.pq().get(3).thumbnailUrl, 10, false);
                this.eln.setVisibility(0);
                this.elo.setVisibility(0);
                this.elp.setVisibility(0);
                this.elq.setVisibility(0);
                break;
        }
        if (akVar.pp() > 0) {
            this.elr.setText(String.format(this.mContext.getResources().getString(u.j.gift_counts), Integer.valueOf(akVar.pp())));
            this.elr.setVisibility(0);
        } else {
            this.elr.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.els.setVisibility(8);
        } else {
            this.els.setVisibility(0);
        }
    }

    public void in(boolean z) {
        if (z) {
            this.els.setVisibility(0);
        } else {
            this.els.setVisibility(8);
        }
    }

    public void sd() {
        av.c(this.elr, u.d.cp_cont_d, 1);
        av.c(this.els, u.d.cp_link_tip_c, 1);
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
