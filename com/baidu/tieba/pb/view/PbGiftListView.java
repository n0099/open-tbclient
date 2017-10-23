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
    private View cKl;
    private TbImageView eUr;
    private TbImageView eUs;
    private TbImageView eUt;
    private TbImageView eUu;
    private TextView eUv;
    private TextView eUw;
    private String eUx;
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
        this.cKl = View.inflate(this.mContext, d.j.pb_gift_list_item, this);
        this.eUr = (TbImageView) this.cKl.findViewById(d.h.pb_gift_view1);
        this.eUs = (TbImageView) this.cKl.findViewById(d.h.pb_gift_view2);
        this.eUt = (TbImageView) this.cKl.findViewById(d.h.pb_gift_view3);
        this.eUu = (TbImageView) this.cKl.findViewById(d.h.pb_gift_view4);
        this.eUr.setDefaultBgResource(d.g.transparent_bg);
        this.eUs.setDefaultBgResource(d.g.transparent_bg);
        this.eUt.setDefaultBgResource(d.g.transparent_bg);
        this.eUu.setDefaultBgResource(d.g.transparent_bg);
        this.eUr.setDefaultResource(d.g.icon_gift_moren);
        this.eUs.setDefaultResource(d.g.icon_gift_moren);
        this.eUt.setDefaultResource(d.g.icon_gift_moren);
        this.eUu.setDefaultResource(d.g.icon_gift_moren);
        this.eUv = (TextView) this.cKl.findViewById(d.h.pb_gift_number_view);
        this.eUw = (TextView) this.cKl.findViewById(d.h.pb_gift_send_view);
        this.eUw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.i.Y(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.eUx, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ax.aT(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(aq aqVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.eUx = str2;
        this.postId = j3;
        this.threadId = j2;
        if (aqVar == null || aqVar.qp() == null || aqVar.qp().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (aqVar.qp().size() > 4 ? 4 : aqVar.qp().size()) {
            case 1:
                this.eUr.c(aqVar.qp().get(0).Wm, 10, false);
                this.eUr.setVisibility(0);
                this.eUs.setVisibility(8);
                this.eUt.setVisibility(8);
                this.eUu.setVisibility(8);
                break;
            case 2:
                this.eUr.c(aqVar.qp().get(0).Wm, 10, false);
                this.eUs.c(aqVar.qp().get(1).Wm, 10, false);
                this.eUr.setVisibility(0);
                this.eUs.setVisibility(0);
                this.eUt.setVisibility(8);
                this.eUu.setVisibility(8);
                break;
            case 3:
                this.eUr.c(aqVar.qp().get(0).Wm, 10, false);
                this.eUs.c(aqVar.qp().get(1).Wm, 10, false);
                this.eUt.c(aqVar.qp().get(2).Wm, 10, false);
                this.eUr.setVisibility(0);
                this.eUs.setVisibility(0);
                this.eUt.setVisibility(0);
                this.eUu.setVisibility(8);
                break;
            case 4:
                this.eUr.c(aqVar.qp().get(0).Wm, 10, false);
                this.eUs.c(aqVar.qp().get(1).Wm, 10, false);
                this.eUt.c(aqVar.qp().get(2).Wm, 10, false);
                this.eUu.c(aqVar.qp().get(3).Wm, 10, false);
                this.eUr.setVisibility(0);
                this.eUs.setVisibility(0);
                this.eUt.setVisibility(0);
                this.eUu.setVisibility(0);
                break;
        }
        if (aqVar.qo() > 0) {
            this.eUv.setText(String.format(this.mContext.getResources().getString(d.l.gift_counts), Integer.valueOf(aqVar.qo())));
            this.eUv.setVisibility(0);
        } else {
            this.eUv.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.eUw.setVisibility(8);
        } else {
            this.eUw.setVisibility(0);
        }
    }

    public void jY(boolean z) {
        if (z) {
            this.eUw.setVisibility(0);
        } else {
            this.eUw.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        aj.c(this.eUv, d.e.cp_cont_d, 1);
        aj.c(this.eUw, d.e.cp_link_tip_c, 1);
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
