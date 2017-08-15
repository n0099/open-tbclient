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
    private View cCx;
    private TbImageView faR;
    private TbImageView faS;
    private TbImageView faT;
    private TbImageView faU;
    private TextView faV;
    private TextView faW;
    private String faX;
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
        this.cCx = View.inflate(this.mContext, d.j.pb_gift_list_item, this);
        this.faR = (TbImageView) this.cCx.findViewById(d.h.pb_gift_view1);
        this.faS = (TbImageView) this.cCx.findViewById(d.h.pb_gift_view2);
        this.faT = (TbImageView) this.cCx.findViewById(d.h.pb_gift_view3);
        this.faU = (TbImageView) this.cCx.findViewById(d.h.pb_gift_view4);
        this.faR.setDefaultBgResource(d.g.transparent_bg);
        this.faS.setDefaultBgResource(d.g.transparent_bg);
        this.faT.setDefaultBgResource(d.g.transparent_bg);
        this.faU.setDefaultBgResource(d.g.transparent_bg);
        this.faR.setDefaultResource(d.g.icon_gift_moren);
        this.faS.setDefaultResource(d.g.icon_gift_moren);
        this.faT.setDefaultResource(d.g.icon_gift_moren);
        this.faU.setDefaultResource(d.g.icon_gift_moren);
        this.faV = (TextView) this.cCx.findViewById(d.h.pb_gift_number_view);
        this.faW = (TextView) this.cCx.findViewById(d.h.pb_gift_send_view);
        this.faW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.i.aa(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.faX, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
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
        this.faX = str2;
        this.postId = j3;
        this.threadId = j2;
        if (asVar == null || asVar.qG() == null || asVar.qG().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (asVar.qG().size() > 4 ? 4 : asVar.qG().size()) {
            case 1:
                this.faR.c(asVar.qG().get(0).Xa, 10, false);
                this.faR.setVisibility(0);
                this.faS.setVisibility(8);
                this.faT.setVisibility(8);
                this.faU.setVisibility(8);
                break;
            case 2:
                this.faR.c(asVar.qG().get(0).Xa, 10, false);
                this.faS.c(asVar.qG().get(1).Xa, 10, false);
                this.faR.setVisibility(0);
                this.faS.setVisibility(0);
                this.faT.setVisibility(8);
                this.faU.setVisibility(8);
                break;
            case 3:
                this.faR.c(asVar.qG().get(0).Xa, 10, false);
                this.faS.c(asVar.qG().get(1).Xa, 10, false);
                this.faT.c(asVar.qG().get(2).Xa, 10, false);
                this.faR.setVisibility(0);
                this.faS.setVisibility(0);
                this.faT.setVisibility(0);
                this.faU.setVisibility(8);
                break;
            case 4:
                this.faR.c(asVar.qG().get(0).Xa, 10, false);
                this.faS.c(asVar.qG().get(1).Xa, 10, false);
                this.faT.c(asVar.qG().get(2).Xa, 10, false);
                this.faU.c(asVar.qG().get(3).Xa, 10, false);
                this.faR.setVisibility(0);
                this.faS.setVisibility(0);
                this.faT.setVisibility(0);
                this.faU.setVisibility(0);
                break;
        }
        if (asVar.qF() > 0) {
            this.faV.setText(String.format(this.mContext.getResources().getString(d.l.gift_counts), Integer.valueOf(asVar.qF())));
            this.faV.setVisibility(0);
        } else {
            this.faV.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.faW.setVisibility(8);
        } else {
            this.faW.setVisibility(0);
        }
    }

    public void ki(boolean z) {
        if (z) {
            this.faW.setVisibility(0);
        } else {
            this.faW.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ai.c(this.faV, d.e.cp_cont_d, 1);
        ai.c(this.faW, d.e.cp_link_tip_c, 1);
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
