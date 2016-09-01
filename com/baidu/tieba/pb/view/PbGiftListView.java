package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View chW;
    private TbImageView exs;
    private TbImageView exu;
    private TbImageView exv;
    private TbImageView exw;
    private TextView exx;
    private TextView exy;
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
        this.chW = View.inflate(this.mContext, t.h.pb_gift_list_item, this);
        this.exs = (TbImageView) this.chW.findViewById(t.g.pb_gift_view1);
        this.exu = (TbImageView) this.chW.findViewById(t.g.pb_gift_view2);
        this.exv = (TbImageView) this.chW.findViewById(t.g.pb_gift_view3);
        this.exw = (TbImageView) this.chW.findViewById(t.g.pb_gift_view4);
        this.exs.setDefaultBgResource(t.f.transparent_bg);
        this.exu.setDefaultBgResource(t.f.transparent_bg);
        this.exv.setDefaultBgResource(t.f.transparent_bg);
        this.exw.setDefaultBgResource(t.f.transparent_bg);
        this.exs.setDefaultResource(t.f.icon_gift_moren);
        this.exu.setDefaultResource(t.f.icon_gift_moren);
        this.exv.setDefaultResource(t.f.icon_gift_moren);
        this.exw.setDefaultResource(t.f.icon_gift_moren);
        this.exx = (TextView) this.chW.findViewById(t.g.pb_gift_number_view);
        this.exy = (TextView) this.chW.findViewById(t.g.pb_gift_send_view);
        this.exy.setOnClickListener(new m(this));
    }

    public void a(al alVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (alVar == null || alVar.qt() == null || alVar.qt().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (alVar.qt().size() > 4 ? 4 : alVar.qt().size()) {
            case 1:
                this.exs.c(alVar.qt().get(0).QV, 10, false);
                this.exs.setVisibility(0);
                this.exu.setVisibility(8);
                this.exv.setVisibility(8);
                this.exw.setVisibility(8);
                break;
            case 2:
                this.exs.c(alVar.qt().get(0).QV, 10, false);
                this.exu.c(alVar.qt().get(1).QV, 10, false);
                this.exs.setVisibility(0);
                this.exu.setVisibility(0);
                this.exv.setVisibility(8);
                this.exw.setVisibility(8);
                break;
            case 3:
                this.exs.c(alVar.qt().get(0).QV, 10, false);
                this.exu.c(alVar.qt().get(1).QV, 10, false);
                this.exv.c(alVar.qt().get(2).QV, 10, false);
                this.exs.setVisibility(0);
                this.exu.setVisibility(0);
                this.exv.setVisibility(0);
                this.exw.setVisibility(8);
                break;
            case 4:
                this.exs.c(alVar.qt().get(0).QV, 10, false);
                this.exu.c(alVar.qt().get(1).QV, 10, false);
                this.exv.c(alVar.qt().get(2).QV, 10, false);
                this.exw.c(alVar.qt().get(3).QV, 10, false);
                this.exs.setVisibility(0);
                this.exu.setVisibility(0);
                this.exv.setVisibility(0);
                this.exw.setVisibility(0);
                break;
        }
        if (alVar.qs() > 0) {
            this.exx.setText(String.format(this.mContext.getResources().getString(t.j.gift_counts), Integer.valueOf(alVar.qs())));
            this.exx.setVisibility(0);
        } else {
            this.exx.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.exy.setVisibility(8);
        } else {
            this.exy.setVisibility(0);
        }
    }

    public void iI(boolean z) {
        if (z) {
            this.exy.setVisibility(0);
        } else {
            this.exy.setVisibility(8);
        }
    }

    public void ti() {
        av.c(this.exx, t.d.cp_cont_d, 1);
        av.c(this.exy, t.d.cp_link_tip_c, 1);
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
