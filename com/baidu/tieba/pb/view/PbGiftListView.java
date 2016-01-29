package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View bDS;
    private TbImageView cVm;
    private TbImageView cVn;
    private TbImageView cVo;
    private TbImageView cVp;
    private TextView cVq;
    private TextView cVr;
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
        this.bDS = View.inflate(this.mContext, t.h.pb_gift_list_item, this);
        this.cVm = (TbImageView) this.bDS.findViewById(t.g.pb_gift_view1);
        this.cVn = (TbImageView) this.bDS.findViewById(t.g.pb_gift_view2);
        this.cVo = (TbImageView) this.bDS.findViewById(t.g.pb_gift_view3);
        this.cVp = (TbImageView) this.bDS.findViewById(t.g.pb_gift_view4);
        this.cVm.setDefaultBgResource(t.f.transparent_bg);
        this.cVn.setDefaultBgResource(t.f.transparent_bg);
        this.cVo.setDefaultBgResource(t.f.transparent_bg);
        this.cVp.setDefaultBgResource(t.f.transparent_bg);
        this.cVm.setDefaultResource(t.f.icon_gift_moren);
        this.cVn.setDefaultResource(t.f.icon_gift_moren);
        this.cVo.setDefaultResource(t.f.icon_gift_moren);
        this.cVp.setDefaultResource(t.f.icon_gift_moren);
        this.cVq = (TextView) this.bDS.findViewById(t.g.pb_gift_number_view);
        this.cVr = (TextView) this.bDS.findViewById(t.g.pb_gift_send_view);
        this.cVr.setOnClickListener(new d(this));
    }

    public void a(v vVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (vVar == null || vVar.sy() == null || vVar.sy().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (vVar.sy().size() > 4 ? 4 : vVar.sy().size()) {
            case 1:
                this.cVm.d(vVar.sy().get(0).thumbnailUrl, 10, false);
                this.cVm.setVisibility(0);
                this.cVn.setVisibility(8);
                this.cVo.setVisibility(8);
                this.cVp.setVisibility(8);
                break;
            case 2:
                this.cVm.d(vVar.sy().get(0).thumbnailUrl, 10, false);
                this.cVn.d(vVar.sy().get(1).thumbnailUrl, 10, false);
                this.cVm.setVisibility(0);
                this.cVn.setVisibility(0);
                this.cVo.setVisibility(8);
                this.cVp.setVisibility(8);
                break;
            case 3:
                this.cVm.d(vVar.sy().get(0).thumbnailUrl, 10, false);
                this.cVn.d(vVar.sy().get(1).thumbnailUrl, 10, false);
                this.cVo.d(vVar.sy().get(2).thumbnailUrl, 10, false);
                this.cVm.setVisibility(0);
                this.cVn.setVisibility(0);
                this.cVo.setVisibility(0);
                this.cVp.setVisibility(8);
                break;
            case 4:
                this.cVm.d(vVar.sy().get(0).thumbnailUrl, 10, false);
                this.cVn.d(vVar.sy().get(1).thumbnailUrl, 10, false);
                this.cVo.d(vVar.sy().get(2).thumbnailUrl, 10, false);
                this.cVp.d(vVar.sy().get(3).thumbnailUrl, 10, false);
                this.cVm.setVisibility(0);
                this.cVn.setVisibility(0);
                this.cVo.setVisibility(0);
                this.cVp.setVisibility(0);
                break;
        }
        if (vVar.sx() > 0) {
            this.cVq.setText(String.format(this.mContext.getResources().getString(t.j.gift_counts), Integer.valueOf(vVar.sx())));
            this.cVq.setVisibility(0);
        } else {
            this.cVq.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.cVr.setVisibility(8);
        } else {
            this.cVr.setVisibility(0);
        }
    }

    public void fO(boolean z) {
        if (z) {
            this.cVr.setVisibility(0);
        } else {
            this.cVr.setVisibility(8);
        }
    }

    public void uv() {
        ar.b(this.cVq, t.d.cp_cont_d, 1);
        ar.b(this.cVr, t.d.cp_link_tip_c, 1);
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
