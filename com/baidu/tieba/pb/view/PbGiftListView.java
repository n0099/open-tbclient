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
    private View czf;
    private TbImageView eXM;
    private TbImageView eXN;
    private TbImageView eXO;
    private TbImageView eXP;
    private TextView eXQ;
    private TextView eXR;
    private String eXS;
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
        this.czf = View.inflate(this.mContext, d.j.pb_gift_list_item, this);
        this.eXM = (TbImageView) this.czf.findViewById(d.h.pb_gift_view1);
        this.eXN = (TbImageView) this.czf.findViewById(d.h.pb_gift_view2);
        this.eXO = (TbImageView) this.czf.findViewById(d.h.pb_gift_view3);
        this.eXP = (TbImageView) this.czf.findViewById(d.h.pb_gift_view4);
        this.eXM.setDefaultBgResource(d.g.transparent_bg);
        this.eXN.setDefaultBgResource(d.g.transparent_bg);
        this.eXO.setDefaultBgResource(d.g.transparent_bg);
        this.eXP.setDefaultBgResource(d.g.transparent_bg);
        this.eXM.setDefaultResource(d.g.icon_gift_moren);
        this.eXN.setDefaultResource(d.g.icon_gift_moren);
        this.eXO.setDefaultResource(d.g.icon_gift_moren);
        this.eXP.setDefaultResource(d.g.icon_gift_moren);
        this.eXQ = (TextView) this.czf.findViewById(d.h.pb_gift_number_view);
        this.eXR = (TextView) this.czf.findViewById(d.h.pb_gift_send_view);
        this.eXR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.i.Z(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.eXS, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    aw.aN(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(as asVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.eXS = str2;
        this.postId = j3;
        this.threadId = j2;
        if (asVar == null || asVar.qw() == null || asVar.qw().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (asVar.qw().size() > 4 ? 4 : asVar.qw().size()) {
            case 1:
                this.eXM.c(asVar.qw().get(0).VC, 10, false);
                this.eXM.setVisibility(0);
                this.eXN.setVisibility(8);
                this.eXO.setVisibility(8);
                this.eXP.setVisibility(8);
                break;
            case 2:
                this.eXM.c(asVar.qw().get(0).VC, 10, false);
                this.eXN.c(asVar.qw().get(1).VC, 10, false);
                this.eXM.setVisibility(0);
                this.eXN.setVisibility(0);
                this.eXO.setVisibility(8);
                this.eXP.setVisibility(8);
                break;
            case 3:
                this.eXM.c(asVar.qw().get(0).VC, 10, false);
                this.eXN.c(asVar.qw().get(1).VC, 10, false);
                this.eXO.c(asVar.qw().get(2).VC, 10, false);
                this.eXM.setVisibility(0);
                this.eXN.setVisibility(0);
                this.eXO.setVisibility(0);
                this.eXP.setVisibility(8);
                break;
            case 4:
                this.eXM.c(asVar.qw().get(0).VC, 10, false);
                this.eXN.c(asVar.qw().get(1).VC, 10, false);
                this.eXO.c(asVar.qw().get(2).VC, 10, false);
                this.eXP.c(asVar.qw().get(3).VC, 10, false);
                this.eXM.setVisibility(0);
                this.eXN.setVisibility(0);
                this.eXO.setVisibility(0);
                this.eXP.setVisibility(0);
                break;
        }
        if (asVar.qv() > 0) {
            this.eXQ.setText(String.format(this.mContext.getResources().getString(d.l.gift_counts), Integer.valueOf(asVar.qv())));
            this.eXQ.setVisibility(0);
        } else {
            this.eXQ.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.eXR.setVisibility(8);
        } else {
            this.eXR.setVisibility(0);
        }
    }

    public void kf(boolean z) {
        if (z) {
            this.eXR.setVisibility(0);
        } else {
            this.eXR.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ai.c(this.eXQ, d.e.cp_cont_d, 1);
        ai.c(this.eXR, d.e.cp_link_tip_c, 1);
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
