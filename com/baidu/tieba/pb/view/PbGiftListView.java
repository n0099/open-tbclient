package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View bxh;
    private TbImageView drT;
    private TbImageView drU;
    private TbImageView drV;
    private TbImageView drW;
    private TextView drX;
    private TextView drY;
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
        this.bxh = View.inflate(this.mContext, t.h.pb_gift_list_item, this);
        this.drT = (TbImageView) this.bxh.findViewById(t.g.pb_gift_view1);
        this.drU = (TbImageView) this.bxh.findViewById(t.g.pb_gift_view2);
        this.drV = (TbImageView) this.bxh.findViewById(t.g.pb_gift_view3);
        this.drW = (TbImageView) this.bxh.findViewById(t.g.pb_gift_view4);
        this.drT.setDefaultBgResource(t.f.transparent_bg);
        this.drU.setDefaultBgResource(t.f.transparent_bg);
        this.drV.setDefaultBgResource(t.f.transparent_bg);
        this.drW.setDefaultBgResource(t.f.transparent_bg);
        this.drT.setDefaultResource(t.f.icon_gift_moren);
        this.drU.setDefaultResource(t.f.icon_gift_moren);
        this.drV.setDefaultResource(t.f.icon_gift_moren);
        this.drW.setDefaultResource(t.f.icon_gift_moren);
        this.drX = (TextView) this.bxh.findViewById(t.g.pb_gift_number_view);
        this.drY = (TextView) this.bxh.findViewById(t.g.pb_gift_send_view);
        this.drY.setOnClickListener(new d(this));
    }

    public void a(ae aeVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (aeVar == null || aeVar.pN() == null || aeVar.pN().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (aeVar.pN().size() > 4 ? 4 : aeVar.pN().size()) {
            case 1:
                this.drT.c(aeVar.pN().get(0).thumbnailUrl, 10, false);
                this.drT.setVisibility(0);
                this.drU.setVisibility(8);
                this.drV.setVisibility(8);
                this.drW.setVisibility(8);
                break;
            case 2:
                this.drT.c(aeVar.pN().get(0).thumbnailUrl, 10, false);
                this.drU.c(aeVar.pN().get(1).thumbnailUrl, 10, false);
                this.drT.setVisibility(0);
                this.drU.setVisibility(0);
                this.drV.setVisibility(8);
                this.drW.setVisibility(8);
                break;
            case 3:
                this.drT.c(aeVar.pN().get(0).thumbnailUrl, 10, false);
                this.drU.c(aeVar.pN().get(1).thumbnailUrl, 10, false);
                this.drV.c(aeVar.pN().get(2).thumbnailUrl, 10, false);
                this.drT.setVisibility(0);
                this.drU.setVisibility(0);
                this.drV.setVisibility(0);
                this.drW.setVisibility(8);
                break;
            case 4:
                this.drT.c(aeVar.pN().get(0).thumbnailUrl, 10, false);
                this.drU.c(aeVar.pN().get(1).thumbnailUrl, 10, false);
                this.drV.c(aeVar.pN().get(2).thumbnailUrl, 10, false);
                this.drW.c(aeVar.pN().get(3).thumbnailUrl, 10, false);
                this.drT.setVisibility(0);
                this.drU.setVisibility(0);
                this.drV.setVisibility(0);
                this.drW.setVisibility(0);
                break;
        }
        if (aeVar.pM() > 0) {
            this.drX.setText(String.format(this.mContext.getResources().getString(t.j.gift_counts), Integer.valueOf(aeVar.pM())));
            this.drX.setVisibility(0);
        } else {
            this.drX.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.drY.setVisibility(8);
        } else {
            this.drY.setVisibility(0);
        }
    }

    public void hh(boolean z) {
        if (z) {
            this.drY.setVisibility(0);
        } else {
            this.drY.setVisibility(8);
        }
    }

    public void sf() {
        at.c(this.drX, t.d.cp_cont_d, 1);
        at.c(this.drY, t.d.cp_link_tip_c, 1);
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
