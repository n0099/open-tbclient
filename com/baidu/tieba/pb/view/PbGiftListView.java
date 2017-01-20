package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View bYI;
    private TbImageView etX;
    private TbImageView etY;
    private TbImageView etZ;
    private TbImageView eua;
    private TextView eub;
    private TextView euc;
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
        this.bYI = View.inflate(this.mContext, r.j.pb_gift_list_item, this);
        this.etX = (TbImageView) this.bYI.findViewById(r.h.pb_gift_view1);
        this.etY = (TbImageView) this.bYI.findViewById(r.h.pb_gift_view2);
        this.etZ = (TbImageView) this.bYI.findViewById(r.h.pb_gift_view3);
        this.eua = (TbImageView) this.bYI.findViewById(r.h.pb_gift_view4);
        this.etX.setDefaultBgResource(r.g.transparent_bg);
        this.etY.setDefaultBgResource(r.g.transparent_bg);
        this.etZ.setDefaultBgResource(r.g.transparent_bg);
        this.eua.setDefaultBgResource(r.g.transparent_bg);
        this.etX.setDefaultResource(r.g.icon_gift_moren);
        this.etY.setDefaultResource(r.g.icon_gift_moren);
        this.etZ.setDefaultResource(r.g.icon_gift_moren);
        this.eua.setDefaultResource(r.g.icon_gift_moren);
        this.eub = (TextView) this.bYI.findViewById(r.h.pb_gift_number_view);
        this.euc = (TextView) this.bYI.findViewById(r.h.pb_gift_send_view);
        this.euc.setOnClickListener(new d(this));
    }

    public void a(ap apVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (apVar == null || apVar.qA() == null || apVar.qA().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (apVar.qA().size() > 4 ? 4 : apVar.qA().size()) {
            case 1:
                this.etX.c(apVar.qA().get(0).QC, 10, false);
                this.etX.setVisibility(0);
                this.etY.setVisibility(8);
                this.etZ.setVisibility(8);
                this.eua.setVisibility(8);
                break;
            case 2:
                this.etX.c(apVar.qA().get(0).QC, 10, false);
                this.etY.c(apVar.qA().get(1).QC, 10, false);
                this.etX.setVisibility(0);
                this.etY.setVisibility(0);
                this.etZ.setVisibility(8);
                this.eua.setVisibility(8);
                break;
            case 3:
                this.etX.c(apVar.qA().get(0).QC, 10, false);
                this.etY.c(apVar.qA().get(1).QC, 10, false);
                this.etZ.c(apVar.qA().get(2).QC, 10, false);
                this.etX.setVisibility(0);
                this.etY.setVisibility(0);
                this.etZ.setVisibility(0);
                this.eua.setVisibility(8);
                break;
            case 4:
                this.etX.c(apVar.qA().get(0).QC, 10, false);
                this.etY.c(apVar.qA().get(1).QC, 10, false);
                this.etZ.c(apVar.qA().get(2).QC, 10, false);
                this.eua.c(apVar.qA().get(3).QC, 10, false);
                this.etX.setVisibility(0);
                this.etY.setVisibility(0);
                this.etZ.setVisibility(0);
                this.eua.setVisibility(0);
                break;
        }
        if (apVar.qz() > 0) {
            this.eub.setText(String.format(this.mContext.getResources().getString(r.l.gift_counts), Integer.valueOf(apVar.qz())));
            this.eub.setVisibility(0);
        } else {
            this.eub.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.euc.setVisibility(8);
        } else {
            this.euc.setVisibility(0);
        }
    }

    public void ji(boolean z) {
        if (z) {
            this.euc.setVisibility(0);
        } else {
            this.euc.setVisibility(8);
        }
    }

    public void tg() {
        com.baidu.tbadk.core.util.ap.c(this.eub, r.e.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ap.c(this.euc, r.e.cp_link_tip_c, 1);
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
