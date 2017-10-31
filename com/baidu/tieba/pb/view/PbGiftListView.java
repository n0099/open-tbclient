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
    private View cTw;
    private TbImageView fcI;
    private TbImageView fcJ;
    private TbImageView fcK;
    private TbImageView fcL;
    private TextView fcM;
    private TextView fcN;
    private String fcO;
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
        this.cTw = View.inflate(this.mContext, d.h.pb_gift_list_item, this);
        this.fcI = (TbImageView) this.cTw.findViewById(d.g.pb_gift_view1);
        this.fcJ = (TbImageView) this.cTw.findViewById(d.g.pb_gift_view2);
        this.fcK = (TbImageView) this.cTw.findViewById(d.g.pb_gift_view3);
        this.fcL = (TbImageView) this.cTw.findViewById(d.g.pb_gift_view4);
        this.fcI.setDefaultBgResource(d.f.transparent_bg);
        this.fcJ.setDefaultBgResource(d.f.transparent_bg);
        this.fcK.setDefaultBgResource(d.f.transparent_bg);
        this.fcL.setDefaultBgResource(d.f.transparent_bg);
        this.fcI.setDefaultResource(d.f.icon_gift_moren);
        this.fcJ.setDefaultResource(d.f.icon_gift_moren);
        this.fcK.setDefaultResource(d.f.icon_gift_moren);
        this.fcL.setDefaultResource(d.f.icon_gift_moren);
        this.fcM = (TextView) this.cTw.findViewById(d.g.pb_gift_number_view);
        this.fcN = (TextView) this.cTw.findViewById(d.g.pb_gift_send_view);
        this.fcN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.i.Y(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.fcO, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
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
        this.fcO = str2;
        this.postId = j3;
        this.threadId = j2;
        if (aqVar == null || aqVar.qu() == null || aqVar.qu().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (aqVar.qu().size() > 4 ? 4 : aqVar.qu().size()) {
            case 1:
                this.fcI.startLoad(aqVar.qu().get(0).WE, 10, false);
                this.fcI.setVisibility(0);
                this.fcJ.setVisibility(8);
                this.fcK.setVisibility(8);
                this.fcL.setVisibility(8);
                break;
            case 2:
                this.fcI.startLoad(aqVar.qu().get(0).WE, 10, false);
                this.fcJ.startLoad(aqVar.qu().get(1).WE, 10, false);
                this.fcI.setVisibility(0);
                this.fcJ.setVisibility(0);
                this.fcK.setVisibility(8);
                this.fcL.setVisibility(8);
                break;
            case 3:
                this.fcI.startLoad(aqVar.qu().get(0).WE, 10, false);
                this.fcJ.startLoad(aqVar.qu().get(1).WE, 10, false);
                this.fcK.startLoad(aqVar.qu().get(2).WE, 10, false);
                this.fcI.setVisibility(0);
                this.fcJ.setVisibility(0);
                this.fcK.setVisibility(0);
                this.fcL.setVisibility(8);
                break;
            case 4:
                this.fcI.startLoad(aqVar.qu().get(0).WE, 10, false);
                this.fcJ.startLoad(aqVar.qu().get(1).WE, 10, false);
                this.fcK.startLoad(aqVar.qu().get(2).WE, 10, false);
                this.fcL.startLoad(aqVar.qu().get(3).WE, 10, false);
                this.fcI.setVisibility(0);
                this.fcJ.setVisibility(0);
                this.fcK.setVisibility(0);
                this.fcL.setVisibility(0);
                break;
        }
        if (aqVar.qt() > 0) {
            this.fcM.setText(String.format(this.mContext.getResources().getString(d.j.gift_counts), Integer.valueOf(aqVar.qt())));
            this.fcM.setVisibility(0);
        } else {
            this.fcM.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.fcN.setVisibility(8);
        } else {
            this.fcN.setVisibility(0);
        }
    }

    public void jS(boolean z) {
        if (z) {
            this.fcN.setVisibility(0);
        } else {
            this.fcN.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        aj.c(this.fcM, d.C0080d.cp_cont_d, 1);
        aj.c(this.fcN, d.C0080d.cp_link_tip_c, 1);
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
