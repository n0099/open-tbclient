package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View cAA;
    private TbImageView eYY;
    private TbImageView eYZ;
    private TbImageView eZa;
    private TbImageView eZb;
    private TextView eZc;
    private TextView eZd;
    private String eZe;
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
        this.cAA = View.inflate(this.mContext, d.j.pb_gift_list_item, this);
        this.eYY = (TbImageView) this.cAA.findViewById(d.h.pb_gift_view1);
        this.eYZ = (TbImageView) this.cAA.findViewById(d.h.pb_gift_view2);
        this.eZa = (TbImageView) this.cAA.findViewById(d.h.pb_gift_view3);
        this.eZb = (TbImageView) this.cAA.findViewById(d.h.pb_gift_view4);
        this.eYY.setDefaultBgResource(d.g.transparent_bg);
        this.eYZ.setDefaultBgResource(d.g.transparent_bg);
        this.eZa.setDefaultBgResource(d.g.transparent_bg);
        this.eZb.setDefaultBgResource(d.g.transparent_bg);
        this.eYY.setDefaultResource(d.g.icon_gift_moren);
        this.eYZ.setDefaultResource(d.g.icon_gift_moren);
        this.eZa.setDefaultResource(d.g.icon_gift_moren);
        this.eZb.setDefaultResource(d.g.icon_gift_moren);
        this.eZc = (TextView) this.cAA.findViewById(d.h.pb_gift_number_view);
        this.eZd = (TextView) this.cAA.findViewById(d.h.pb_gift_send_view);
        this.eZd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.i.aa(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.eZe, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    aw.aO(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(as asVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.eZe = str2;
        this.postId = j3;
        this.threadId = j2;
        if (asVar == null || asVar.qG() == null || asVar.qG().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (asVar.qG().size() > 4 ? 4 : asVar.qG().size()) {
            case 1:
                this.eYY.c(asVar.qG().get(0).WY, 10, false);
                this.eYY.setVisibility(0);
                this.eYZ.setVisibility(8);
                this.eZa.setVisibility(8);
                this.eZb.setVisibility(8);
                break;
            case 2:
                this.eYY.c(asVar.qG().get(0).WY, 10, false);
                this.eYZ.c(asVar.qG().get(1).WY, 10, false);
                this.eYY.setVisibility(0);
                this.eYZ.setVisibility(0);
                this.eZa.setVisibility(8);
                this.eZb.setVisibility(8);
                break;
            case 3:
                this.eYY.c(asVar.qG().get(0).WY, 10, false);
                this.eYZ.c(asVar.qG().get(1).WY, 10, false);
                this.eZa.c(asVar.qG().get(2).WY, 10, false);
                this.eYY.setVisibility(0);
                this.eYZ.setVisibility(0);
                this.eZa.setVisibility(0);
                this.eZb.setVisibility(8);
                break;
            case 4:
                this.eYY.c(asVar.qG().get(0).WY, 10, false);
                this.eYZ.c(asVar.qG().get(1).WY, 10, false);
                this.eZa.c(asVar.qG().get(2).WY, 10, false);
                this.eZb.c(asVar.qG().get(3).WY, 10, false);
                this.eYY.setVisibility(0);
                this.eYZ.setVisibility(0);
                this.eZa.setVisibility(0);
                this.eZb.setVisibility(0);
                break;
        }
        if (asVar.qF() > 0) {
            this.eZc.setText(String.format(this.mContext.getResources().getString(d.l.gift_counts), Integer.valueOf(asVar.qF())));
            this.eZc.setVisibility(0);
        } else {
            this.eZc.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.eZd.setVisibility(8);
        } else {
            this.eZd.setVisibility(0);
        }
    }

    public void kf(boolean z) {
        if (z) {
            this.eZd.setVisibility(0);
        } else {
            this.eZd.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ai.c(this.eZc, d.e.cp_cont_d, 1);
        ai.c(this.eZd, d.e.cp_link_tip_c, 1);
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
