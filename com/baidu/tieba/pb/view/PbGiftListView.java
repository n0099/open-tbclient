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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View cKx;
    private TbImageView eUF;
    private TbImageView eUG;
    private TbImageView eUH;
    private TbImageView eUI;
    private TextView eUJ;
    private TextView eUK;
    private String eUL;
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
        this.cKx = View.inflate(this.mContext, d.j.pb_gift_list_item, this);
        this.eUF = (TbImageView) this.cKx.findViewById(d.h.pb_gift_view1);
        this.eUG = (TbImageView) this.cKx.findViewById(d.h.pb_gift_view2);
        this.eUH = (TbImageView) this.cKx.findViewById(d.h.pb_gift_view3);
        this.eUI = (TbImageView) this.cKx.findViewById(d.h.pb_gift_view4);
        this.eUF.setDefaultBgResource(d.g.transparent_bg);
        this.eUG.setDefaultBgResource(d.g.transparent_bg);
        this.eUH.setDefaultBgResource(d.g.transparent_bg);
        this.eUI.setDefaultBgResource(d.g.transparent_bg);
        this.eUF.setDefaultResource(d.g.icon_gift_moren);
        this.eUG.setDefaultResource(d.g.icon_gift_moren);
        this.eUH.setDefaultResource(d.g.icon_gift_moren);
        this.eUI.setDefaultResource(d.g.icon_gift_moren);
        this.eUJ = (TextView) this.cKx.findViewById(d.h.pb_gift_number_view);
        this.eUK = (TextView) this.cKx.findViewById(d.h.pb_gift_send_view);
        this.eUK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.i.Y(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.eUL, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ax.aU(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(aq aqVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.eUL = str2;
        this.postId = j3;
        this.threadId = j2;
        if (aqVar == null || aqVar.qw() == null || aqVar.qw().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (aqVar.qw().size() > 4 ? 4 : aqVar.qw().size()) {
            case 1:
                this.eUF.c(aqVar.qw().get(0).Wy, 10, false);
                this.eUF.setVisibility(0);
                this.eUG.setVisibility(8);
                this.eUH.setVisibility(8);
                this.eUI.setVisibility(8);
                break;
            case 2:
                this.eUF.c(aqVar.qw().get(0).Wy, 10, false);
                this.eUG.c(aqVar.qw().get(1).Wy, 10, false);
                this.eUF.setVisibility(0);
                this.eUG.setVisibility(0);
                this.eUH.setVisibility(8);
                this.eUI.setVisibility(8);
                break;
            case 3:
                this.eUF.c(aqVar.qw().get(0).Wy, 10, false);
                this.eUG.c(aqVar.qw().get(1).Wy, 10, false);
                this.eUH.c(aqVar.qw().get(2).Wy, 10, false);
                this.eUF.setVisibility(0);
                this.eUG.setVisibility(0);
                this.eUH.setVisibility(0);
                this.eUI.setVisibility(8);
                break;
            case 4:
                this.eUF.c(aqVar.qw().get(0).Wy, 10, false);
                this.eUG.c(aqVar.qw().get(1).Wy, 10, false);
                this.eUH.c(aqVar.qw().get(2).Wy, 10, false);
                this.eUI.c(aqVar.qw().get(3).Wy, 10, false);
                this.eUF.setVisibility(0);
                this.eUG.setVisibility(0);
                this.eUH.setVisibility(0);
                this.eUI.setVisibility(0);
                break;
        }
        if (aqVar.qv() > 0) {
            this.eUJ.setText(String.format(this.mContext.getResources().getString(d.l.gift_counts), Integer.valueOf(aqVar.qv())));
            this.eUJ.setVisibility(0);
        } else {
            this.eUJ.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.eUK.setVisibility(8);
        } else {
            this.eUK.setVisibility(0);
        }
    }

    public void jZ(boolean z) {
        if (z) {
            this.eUK.setVisibility(0);
        } else {
            this.eUK.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        aj.c(this.eUJ, d.e.cp_cont_d, 1);
        aj.c(this.eUK, d.e.cp_link_tip_c, 1);
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
