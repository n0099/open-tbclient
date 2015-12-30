package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View bAG;
    private TbImageView cMA;
    private TbImageView cMB;
    private TextView cMC;
    private TextView cMD;
    private TbImageView cMy;
    private TbImageView cMz;
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
        this.bAG = View.inflate(this.mContext, n.h.pb_gift_list_item, this);
        this.cMy = (TbImageView) this.bAG.findViewById(n.g.pb_gift_view1);
        this.cMz = (TbImageView) this.bAG.findViewById(n.g.pb_gift_view2);
        this.cMA = (TbImageView) this.bAG.findViewById(n.g.pb_gift_view3);
        this.cMB = (TbImageView) this.bAG.findViewById(n.g.pb_gift_view4);
        this.cMy.setDefaultBgResource(n.f.transparent_bg);
        this.cMz.setDefaultBgResource(n.f.transparent_bg);
        this.cMA.setDefaultBgResource(n.f.transparent_bg);
        this.cMB.setDefaultBgResource(n.f.transparent_bg);
        this.cMy.setDefaultResource(n.f.icon_gift_moren);
        this.cMz.setDefaultResource(n.f.icon_gift_moren);
        this.cMA.setDefaultResource(n.f.icon_gift_moren);
        this.cMB.setDefaultResource(n.f.icon_gift_moren);
        this.cMC = (TextView) this.bAG.findViewById(n.g.pb_gift_number_view);
        this.cMD = (TextView) this.bAG.findViewById(n.g.pb_gift_send_view);
        this.cMD.setOnClickListener(new d(this));
    }

    public void a(r rVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (rVar == null || rVar.rR() == null || rVar.rR().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (rVar.rR().size() > 4 ? 4 : rVar.rR().size()) {
            case 1:
                this.cMy.d(rVar.rR().get(0).thumbnailUrl, 10, false);
                this.cMy.setVisibility(0);
                this.cMz.setVisibility(8);
                this.cMA.setVisibility(8);
                this.cMB.setVisibility(8);
                break;
            case 2:
                this.cMy.d(rVar.rR().get(0).thumbnailUrl, 10, false);
                this.cMz.d(rVar.rR().get(1).thumbnailUrl, 10, false);
                this.cMy.setVisibility(0);
                this.cMz.setVisibility(0);
                this.cMA.setVisibility(8);
                this.cMB.setVisibility(8);
                break;
            case 3:
                this.cMy.d(rVar.rR().get(0).thumbnailUrl, 10, false);
                this.cMz.d(rVar.rR().get(1).thumbnailUrl, 10, false);
                this.cMA.d(rVar.rR().get(2).thumbnailUrl, 10, false);
                this.cMy.setVisibility(0);
                this.cMz.setVisibility(0);
                this.cMA.setVisibility(0);
                this.cMB.setVisibility(8);
                break;
            case 4:
                this.cMy.d(rVar.rR().get(0).thumbnailUrl, 10, false);
                this.cMz.d(rVar.rR().get(1).thumbnailUrl, 10, false);
                this.cMA.d(rVar.rR().get(2).thumbnailUrl, 10, false);
                this.cMB.d(rVar.rR().get(3).thumbnailUrl, 10, false);
                this.cMy.setVisibility(0);
                this.cMz.setVisibility(0);
                this.cMA.setVisibility(0);
                this.cMB.setVisibility(0);
                break;
        }
        if (rVar.rQ() > 0) {
            this.cMC.setText(String.format(this.mContext.getResources().getString(n.j.gift_counts), Integer.valueOf(rVar.rQ())));
            this.cMC.setVisibility(0);
        } else {
            this.cMC.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.cMD.setVisibility(8);
        } else {
            this.cMD.setVisibility(0);
        }
    }

    public void fA(boolean z) {
        if (z) {
            this.cMD.setVisibility(0);
        } else {
            this.cMD.setVisibility(8);
        }
    }

    public void tr() {
        as.b(this.cMC, n.d.cp_cont_d, 1);
        as.b(this.cMD, n.d.cp_link_tip_c, 1);
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
