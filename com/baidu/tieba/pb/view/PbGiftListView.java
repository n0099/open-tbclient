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
    private View cTQ;
    private TbImageView fde;
    private TbImageView fdf;
    private TbImageView fdg;
    private TbImageView fdh;
    private TextView fdi;
    private TextView fdj;
    private String fdk;
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
        this.cTQ = View.inflate(this.mContext, d.h.pb_gift_list_item, this);
        this.fde = (TbImageView) this.cTQ.findViewById(d.g.pb_gift_view1);
        this.fdf = (TbImageView) this.cTQ.findViewById(d.g.pb_gift_view2);
        this.fdg = (TbImageView) this.cTQ.findViewById(d.g.pb_gift_view3);
        this.fdh = (TbImageView) this.cTQ.findViewById(d.g.pb_gift_view4);
        this.fde.setDefaultBgResource(d.f.transparent_bg);
        this.fdf.setDefaultBgResource(d.f.transparent_bg);
        this.fdg.setDefaultBgResource(d.f.transparent_bg);
        this.fdh.setDefaultBgResource(d.f.transparent_bg);
        this.fde.setDefaultResource(d.f.icon_gift_moren);
        this.fdf.setDefaultResource(d.f.icon_gift_moren);
        this.fdg.setDefaultResource(d.f.icon_gift_moren);
        this.fdh.setDefaultResource(d.f.icon_gift_moren);
        this.fdi = (TextView) this.cTQ.findViewById(d.g.pb_gift_number_view);
        this.fdj = (TextView) this.cTQ.findViewById(d.g.pb_gift_send_view);
        this.fdj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.i.Y(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.fdk, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
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
        this.fdk = str2;
        this.postId = j3;
        this.threadId = j2;
        if (aqVar == null || aqVar.qu() == null || aqVar.qu().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (aqVar.qu().size() > 4 ? 4 : aqVar.qu().size()) {
            case 1:
                this.fde.startLoad(aqVar.qu().get(0).WE, 10, false);
                this.fde.setVisibility(0);
                this.fdf.setVisibility(8);
                this.fdg.setVisibility(8);
                this.fdh.setVisibility(8);
                break;
            case 2:
                this.fde.startLoad(aqVar.qu().get(0).WE, 10, false);
                this.fdf.startLoad(aqVar.qu().get(1).WE, 10, false);
                this.fde.setVisibility(0);
                this.fdf.setVisibility(0);
                this.fdg.setVisibility(8);
                this.fdh.setVisibility(8);
                break;
            case 3:
                this.fde.startLoad(aqVar.qu().get(0).WE, 10, false);
                this.fdf.startLoad(aqVar.qu().get(1).WE, 10, false);
                this.fdg.startLoad(aqVar.qu().get(2).WE, 10, false);
                this.fde.setVisibility(0);
                this.fdf.setVisibility(0);
                this.fdg.setVisibility(0);
                this.fdh.setVisibility(8);
                break;
            case 4:
                this.fde.startLoad(aqVar.qu().get(0).WE, 10, false);
                this.fdf.startLoad(aqVar.qu().get(1).WE, 10, false);
                this.fdg.startLoad(aqVar.qu().get(2).WE, 10, false);
                this.fdh.startLoad(aqVar.qu().get(3).WE, 10, false);
                this.fde.setVisibility(0);
                this.fdf.setVisibility(0);
                this.fdg.setVisibility(0);
                this.fdh.setVisibility(0);
                break;
        }
        if (aqVar.qt() > 0) {
            this.fdi.setText(String.format(this.mContext.getResources().getString(d.j.gift_counts), Integer.valueOf(aqVar.qt())));
            this.fdi.setVisibility(0);
        } else {
            this.fdi.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.fdj.setVisibility(8);
        } else {
            this.fdj.setVisibility(0);
        }
    }

    public void jY(boolean z) {
        if (z) {
            this.fdj.setVisibility(0);
        } else {
            this.fdj.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        aj.c(this.fdi, d.C0080d.cp_cont_d, 1);
        aj.c(this.fdj, d.C0080d.cp_link_tip_c, 1);
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
