package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View chU;
    private TbImageView ezA;
    private TbImageView ezB;
    private TbImageView ezC;
    private TbImageView ezD;
    private TextView ezE;
    private TextView ezF;
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
        this.chU = View.inflate(this.mContext, r.h.pb_gift_list_item, this);
        this.ezA = (TbImageView) this.chU.findViewById(r.g.pb_gift_view1);
        this.ezB = (TbImageView) this.chU.findViewById(r.g.pb_gift_view2);
        this.ezC = (TbImageView) this.chU.findViewById(r.g.pb_gift_view3);
        this.ezD = (TbImageView) this.chU.findViewById(r.g.pb_gift_view4);
        this.ezA.setDefaultBgResource(r.f.transparent_bg);
        this.ezB.setDefaultBgResource(r.f.transparent_bg);
        this.ezC.setDefaultBgResource(r.f.transparent_bg);
        this.ezD.setDefaultBgResource(r.f.transparent_bg);
        this.ezA.setDefaultResource(r.f.icon_gift_moren);
        this.ezB.setDefaultResource(r.f.icon_gift_moren);
        this.ezC.setDefaultResource(r.f.icon_gift_moren);
        this.ezD.setDefaultResource(r.f.icon_gift_moren);
        this.ezE = (TextView) this.chU.findViewById(r.g.pb_gift_number_view);
        this.ezF = (TextView) this.chU.findViewById(r.g.pb_gift_send_view);
        this.ezF.setOnClickListener(new m(this));
    }

    public void a(an anVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (anVar == null || anVar.qE() == null || anVar.qE().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (anVar.qE().size() > 4 ? 4 : anVar.qE().size()) {
            case 1:
                this.ezA.c(anVar.qE().get(0).Rb, 10, false);
                this.ezA.setVisibility(0);
                this.ezB.setVisibility(8);
                this.ezC.setVisibility(8);
                this.ezD.setVisibility(8);
                break;
            case 2:
                this.ezA.c(anVar.qE().get(0).Rb, 10, false);
                this.ezB.c(anVar.qE().get(1).Rb, 10, false);
                this.ezA.setVisibility(0);
                this.ezB.setVisibility(0);
                this.ezC.setVisibility(8);
                this.ezD.setVisibility(8);
                break;
            case 3:
                this.ezA.c(anVar.qE().get(0).Rb, 10, false);
                this.ezB.c(anVar.qE().get(1).Rb, 10, false);
                this.ezC.c(anVar.qE().get(2).Rb, 10, false);
                this.ezA.setVisibility(0);
                this.ezB.setVisibility(0);
                this.ezC.setVisibility(0);
                this.ezD.setVisibility(8);
                break;
            case 4:
                this.ezA.c(anVar.qE().get(0).Rb, 10, false);
                this.ezB.c(anVar.qE().get(1).Rb, 10, false);
                this.ezC.c(anVar.qE().get(2).Rb, 10, false);
                this.ezD.c(anVar.qE().get(3).Rb, 10, false);
                this.ezA.setVisibility(0);
                this.ezB.setVisibility(0);
                this.ezC.setVisibility(0);
                this.ezD.setVisibility(0);
                break;
        }
        if (anVar.qD() > 0) {
            this.ezE.setText(String.format(this.mContext.getResources().getString(r.j.gift_counts), Integer.valueOf(anVar.qD())));
            this.ezE.setVisibility(0);
        } else {
            this.ezE.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.ezF.setVisibility(8);
        } else {
            this.ezF.setVisibility(0);
        }
    }

    public void iL(boolean z) {
        if (z) {
            this.ezF.setVisibility(0);
        } else {
            this.ezF.setVisibility(8);
        }
    }

    public void tx() {
        av.c(this.ezE, r.d.cp_cont_d, 1);
        av.c(this.ezF, r.d.cp_link_tip_c, 1);
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
