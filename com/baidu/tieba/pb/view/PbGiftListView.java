package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View cge;
    private TbImageView exu;
    private TbImageView exv;
    private TbImageView exw;
    private TbImageView exx;
    private TextView exy;
    private TextView exz;
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
        this.cge = View.inflate(this.mContext, w.j.pb_gift_list_item, this);
        this.exu = (TbImageView) this.cge.findViewById(w.h.pb_gift_view1);
        this.exv = (TbImageView) this.cge.findViewById(w.h.pb_gift_view2);
        this.exw = (TbImageView) this.cge.findViewById(w.h.pb_gift_view3);
        this.exx = (TbImageView) this.cge.findViewById(w.h.pb_gift_view4);
        this.exu.setDefaultBgResource(w.g.transparent_bg);
        this.exv.setDefaultBgResource(w.g.transparent_bg);
        this.exw.setDefaultBgResource(w.g.transparent_bg);
        this.exx.setDefaultBgResource(w.g.transparent_bg);
        this.exu.setDefaultResource(w.g.icon_gift_moren);
        this.exv.setDefaultResource(w.g.icon_gift_moren);
        this.exw.setDefaultResource(w.g.icon_gift_moren);
        this.exx.setDefaultResource(w.g.icon_gift_moren);
        this.exy = (TextView) this.cge.findViewById(w.h.pb_gift_number_view);
        this.exz = (TextView) this.cge.findViewById(w.h.pb_gift_send_view);
        this.exz.setOnClickListener(new d(this));
    }

    public void a(ar arVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (arVar == null || arVar.qT() == null || arVar.qT().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (arVar.qT().size() > 4 ? 4 : arVar.qT().size()) {
            case 1:
                this.exu.c(arVar.qT().get(0).VP, 10, false);
                this.exu.setVisibility(0);
                this.exv.setVisibility(8);
                this.exw.setVisibility(8);
                this.exx.setVisibility(8);
                break;
            case 2:
                this.exu.c(arVar.qT().get(0).VP, 10, false);
                this.exv.c(arVar.qT().get(1).VP, 10, false);
                this.exu.setVisibility(0);
                this.exv.setVisibility(0);
                this.exw.setVisibility(8);
                this.exx.setVisibility(8);
                break;
            case 3:
                this.exu.c(arVar.qT().get(0).VP, 10, false);
                this.exv.c(arVar.qT().get(1).VP, 10, false);
                this.exw.c(arVar.qT().get(2).VP, 10, false);
                this.exu.setVisibility(0);
                this.exv.setVisibility(0);
                this.exw.setVisibility(0);
                this.exx.setVisibility(8);
                break;
            case 4:
                this.exu.c(arVar.qT().get(0).VP, 10, false);
                this.exv.c(arVar.qT().get(1).VP, 10, false);
                this.exw.c(arVar.qT().get(2).VP, 10, false);
                this.exx.c(arVar.qT().get(3).VP, 10, false);
                this.exu.setVisibility(0);
                this.exv.setVisibility(0);
                this.exw.setVisibility(0);
                this.exx.setVisibility(0);
                break;
        }
        if (arVar.qS() > 0) {
            this.exy.setText(String.format(this.mContext.getResources().getString(w.l.gift_counts), Integer.valueOf(arVar.qS())));
            this.exy.setVisibility(0);
        } else {
            this.exy.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.exz.setVisibility(8);
        } else {
            this.exz.setVisibility(0);
        }
    }

    public void jf(boolean z) {
        if (z) {
            this.exz.setVisibility(0);
        } else {
            this.exz.setVisibility(8);
        }
    }

    public void tD() {
        aq.c(this.exy, w.e.cp_cont_d, 1);
        aq.c(this.exz, w.e.cp_link_tip_c, 1);
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
