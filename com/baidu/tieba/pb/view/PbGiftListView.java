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
    private View cdR;
    private TbImageView etA;
    private TbImageView etB;
    private TbImageView etC;
    private TbImageView etD;
    private TextView etE;
    private TextView etF;
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
        this.cdR = View.inflate(this.mContext, w.j.pb_gift_list_item, this);
        this.etA = (TbImageView) this.cdR.findViewById(w.h.pb_gift_view1);
        this.etB = (TbImageView) this.cdR.findViewById(w.h.pb_gift_view2);
        this.etC = (TbImageView) this.cdR.findViewById(w.h.pb_gift_view3);
        this.etD = (TbImageView) this.cdR.findViewById(w.h.pb_gift_view4);
        this.etA.setDefaultBgResource(w.g.transparent_bg);
        this.etB.setDefaultBgResource(w.g.transparent_bg);
        this.etC.setDefaultBgResource(w.g.transparent_bg);
        this.etD.setDefaultBgResource(w.g.transparent_bg);
        this.etA.setDefaultResource(w.g.icon_gift_moren);
        this.etB.setDefaultResource(w.g.icon_gift_moren);
        this.etC.setDefaultResource(w.g.icon_gift_moren);
        this.etD.setDefaultResource(w.g.icon_gift_moren);
        this.etE = (TextView) this.cdR.findViewById(w.h.pb_gift_number_view);
        this.etF = (TextView) this.cdR.findViewById(w.h.pb_gift_send_view);
        this.etF.setOnClickListener(new d(this));
    }

    public void a(ar arVar, String str, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.postId = j3;
        this.threadId = j2;
        if (arVar == null || arVar.qA() == null || arVar.qA().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (arVar.qA().size() > 4 ? 4 : arVar.qA().size()) {
            case 1:
                this.etA.c(arVar.qA().get(0).Vz, 10, false);
                this.etA.setVisibility(0);
                this.etB.setVisibility(8);
                this.etC.setVisibility(8);
                this.etD.setVisibility(8);
                break;
            case 2:
                this.etA.c(arVar.qA().get(0).Vz, 10, false);
                this.etB.c(arVar.qA().get(1).Vz, 10, false);
                this.etA.setVisibility(0);
                this.etB.setVisibility(0);
                this.etC.setVisibility(8);
                this.etD.setVisibility(8);
                break;
            case 3:
                this.etA.c(arVar.qA().get(0).Vz, 10, false);
                this.etB.c(arVar.qA().get(1).Vz, 10, false);
                this.etC.c(arVar.qA().get(2).Vz, 10, false);
                this.etA.setVisibility(0);
                this.etB.setVisibility(0);
                this.etC.setVisibility(0);
                this.etD.setVisibility(8);
                break;
            case 4:
                this.etA.c(arVar.qA().get(0).Vz, 10, false);
                this.etB.c(arVar.qA().get(1).Vz, 10, false);
                this.etC.c(arVar.qA().get(2).Vz, 10, false);
                this.etD.c(arVar.qA().get(3).Vz, 10, false);
                this.etA.setVisibility(0);
                this.etB.setVisibility(0);
                this.etC.setVisibility(0);
                this.etD.setVisibility(0);
                break;
        }
        if (arVar.qz() > 0) {
            this.etE.setText(String.format(this.mContext.getResources().getString(w.l.gift_counts), Integer.valueOf(arVar.qz())));
            this.etE.setVisibility(0);
        } else {
            this.etE.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.etF.setVisibility(8);
        } else {
            this.etF.setVisibility(0);
        }
    }

    public void iT(boolean z) {
        if (z) {
            this.etF.setVisibility(0);
        } else {
            this.etF.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        aq.c(this.etE, w.e.cp_cont_d, 1);
        aq.c(this.etF, w.e.cp_link_tip_c, 1);
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
