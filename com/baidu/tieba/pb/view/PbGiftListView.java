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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View cIN;
    private TbImageView eZB;
    private TbImageView eZC;
    private TbImageView eZD;
    private TbImageView eZE;
    private TextView eZF;
    private TextView eZG;
    private String eZH;
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
        this.cIN = View.inflate(this.mContext, d.j.pb_gift_list_item, this);
        this.eZB = (TbImageView) this.cIN.findViewById(d.h.pb_gift_view1);
        this.eZC = (TbImageView) this.cIN.findViewById(d.h.pb_gift_view2);
        this.eZD = (TbImageView) this.cIN.findViewById(d.h.pb_gift_view3);
        this.eZE = (TbImageView) this.cIN.findViewById(d.h.pb_gift_view4);
        this.eZB.setDefaultBgResource(d.g.transparent_bg);
        this.eZC.setDefaultBgResource(d.g.transparent_bg);
        this.eZD.setDefaultBgResource(d.g.transparent_bg);
        this.eZE.setDefaultBgResource(d.g.transparent_bg);
        this.eZB.setDefaultResource(d.g.icon_gift_moren);
        this.eZC.setDefaultResource(d.g.icon_gift_moren);
        this.eZD.setDefaultResource(d.g.icon_gift_moren);
        this.eZE.setDefaultResource(d.g.icon_gift_moren);
        this.eZF = (TextView) this.cIN.findViewById(d.h.pb_gift_number_view);
        this.eZG = (TextView) this.cIN.findViewById(d.h.pb_gift_send_view);
        this.eZG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.i.X(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.eZH, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ax.aT(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(as asVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.eZH = str2;
        this.postId = j3;
        this.threadId = j2;
        if (asVar == null || asVar.qC() == null || asVar.qC().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (asVar.qC().size() > 4 ? 4 : asVar.qC().size()) {
            case 1:
                this.eZB.c(asVar.qC().get(0).Wk, 10, false);
                this.eZB.setVisibility(0);
                this.eZC.setVisibility(8);
                this.eZD.setVisibility(8);
                this.eZE.setVisibility(8);
                break;
            case 2:
                this.eZB.c(asVar.qC().get(0).Wk, 10, false);
                this.eZC.c(asVar.qC().get(1).Wk, 10, false);
                this.eZB.setVisibility(0);
                this.eZC.setVisibility(0);
                this.eZD.setVisibility(8);
                this.eZE.setVisibility(8);
                break;
            case 3:
                this.eZB.c(asVar.qC().get(0).Wk, 10, false);
                this.eZC.c(asVar.qC().get(1).Wk, 10, false);
                this.eZD.c(asVar.qC().get(2).Wk, 10, false);
                this.eZB.setVisibility(0);
                this.eZC.setVisibility(0);
                this.eZD.setVisibility(0);
                this.eZE.setVisibility(8);
                break;
            case 4:
                this.eZB.c(asVar.qC().get(0).Wk, 10, false);
                this.eZC.c(asVar.qC().get(1).Wk, 10, false);
                this.eZD.c(asVar.qC().get(2).Wk, 10, false);
                this.eZE.c(asVar.qC().get(3).Wk, 10, false);
                this.eZB.setVisibility(0);
                this.eZC.setVisibility(0);
                this.eZD.setVisibility(0);
                this.eZE.setVisibility(0);
                break;
        }
        if (asVar.qB() > 0) {
            this.eZF.setText(String.format(this.mContext.getResources().getString(d.l.gift_counts), Integer.valueOf(asVar.qB())));
            this.eZF.setVisibility(0);
        } else {
            this.eZF.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.eZG.setVisibility(8);
        } else {
            this.eZG.setVisibility(0);
        }
    }

    public void kj(boolean z) {
        if (z) {
            this.eZG.setVisibility(0);
        } else {
            this.eZG.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        aj.c(this.eZF, d.e.cp_cont_d, 1);
        aj.c(this.eZG, d.e.cp_link_tip_c, 1);
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
