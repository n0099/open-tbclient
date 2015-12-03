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
    private View bwP;
    private TextView cIA;
    private TbImageView cIv;
    private TbImageView cIw;
    private TbImageView cIx;
    private TbImageView cIy;
    private TextView cIz;
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
        this.bwP = View.inflate(this.mContext, n.g.pb_gift_list_item, this);
        this.cIv = (TbImageView) this.bwP.findViewById(n.f.pb_gift_view1);
        this.cIw = (TbImageView) this.bwP.findViewById(n.f.pb_gift_view2);
        this.cIx = (TbImageView) this.bwP.findViewById(n.f.pb_gift_view3);
        this.cIy = (TbImageView) this.bwP.findViewById(n.f.pb_gift_view4);
        this.cIv.setDefaultBgResource(n.e.transparent_bg);
        this.cIw.setDefaultBgResource(n.e.transparent_bg);
        this.cIx.setDefaultBgResource(n.e.transparent_bg);
        this.cIy.setDefaultBgResource(n.e.transparent_bg);
        this.cIv.setDefaultResource(n.e.icon_gift_moren);
        this.cIw.setDefaultResource(n.e.icon_gift_moren);
        this.cIx.setDefaultResource(n.e.icon_gift_moren);
        this.cIy.setDefaultResource(n.e.icon_gift_moren);
        this.cIz = (TextView) this.bwP.findViewById(n.f.pb_gift_number_view);
        this.cIA = (TextView) this.bwP.findViewById(n.f.pb_gift_send_view);
        this.cIA.setOnClickListener(new d(this));
    }

    public void a(r rVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (rVar == null || rVar.si() == null || rVar.si().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (rVar.si().size() > 4 ? 4 : rVar.si().size()) {
            case 1:
                this.cIv.d(rVar.si().get(0).thumbnailUrl, 10, false);
                this.cIv.setVisibility(0);
                this.cIw.setVisibility(8);
                this.cIx.setVisibility(8);
                this.cIy.setVisibility(8);
                break;
            case 2:
                this.cIv.d(rVar.si().get(0).thumbnailUrl, 10, false);
                this.cIw.d(rVar.si().get(1).thumbnailUrl, 10, false);
                this.cIv.setVisibility(0);
                this.cIw.setVisibility(0);
                this.cIx.setVisibility(8);
                this.cIy.setVisibility(8);
                break;
            case 3:
                this.cIv.d(rVar.si().get(0).thumbnailUrl, 10, false);
                this.cIw.d(rVar.si().get(1).thumbnailUrl, 10, false);
                this.cIx.d(rVar.si().get(2).thumbnailUrl, 10, false);
                this.cIv.setVisibility(0);
                this.cIw.setVisibility(0);
                this.cIx.setVisibility(0);
                this.cIy.setVisibility(8);
                break;
            case 4:
                this.cIv.d(rVar.si().get(0).thumbnailUrl, 10, false);
                this.cIw.d(rVar.si().get(1).thumbnailUrl, 10, false);
                this.cIx.d(rVar.si().get(2).thumbnailUrl, 10, false);
                this.cIy.d(rVar.si().get(3).thumbnailUrl, 10, false);
                this.cIv.setVisibility(0);
                this.cIw.setVisibility(0);
                this.cIx.setVisibility(0);
                this.cIy.setVisibility(0);
                break;
        }
        if (rVar.sh() > 0) {
            this.cIz.setText(String.format(this.mContext.getResources().getString(n.i.gift_counts), Integer.valueOf(rVar.sh())));
            this.cIz.setVisibility(0);
        } else {
            this.cIz.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.cIA.setVisibility(8);
        } else {
            this.cIA.setVisibility(0);
        }
    }

    public void fB(boolean z) {
        if (z) {
            this.cIA.setVisibility(0);
        } else {
            this.cIA.setVisibility(8);
        }
    }

    public void tH() {
        as.b(this.cIz, n.c.cp_cont_d, 1);
        as.b(this.cIA, n.c.cp_link_tip_c, 1);
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
