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
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View def;
    private TbImageView flb;
    private TbImageView flc;
    private TbImageView fld;
    private TbImageView fle;
    private TextView flf;
    private TextView flg;
    private String flh;
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
        this.def = View.inflate(this.mContext, d.h.pb_gift_list_item, this);
        this.flb = (TbImageView) this.def.findViewById(d.g.pb_gift_view1);
        this.flc = (TbImageView) this.def.findViewById(d.g.pb_gift_view2);
        this.fld = (TbImageView) this.def.findViewById(d.g.pb_gift_view3);
        this.fle = (TbImageView) this.def.findViewById(d.g.pb_gift_view4);
        this.flb.setDefaultBgResource(d.f.transparent_bg);
        this.flc.setDefaultBgResource(d.f.transparent_bg);
        this.fld.setDefaultBgResource(d.f.transparent_bg);
        this.fle.setDefaultBgResource(d.f.transparent_bg);
        this.flb.setDefaultResource(d.f.icon_gift_moren);
        this.flc.setDefaultResource(d.f.icon_gift_moren);
        this.fld.setDefaultResource(d.f.icon_gift_moren);
        this.fle.setDefaultResource(d.f.icon_gift_moren);
        this.flf = (TextView) this.def.findViewById(d.g.pb_gift_number_view);
        this.flg = (TextView) this.def.findViewById(d.g.pb_gift_send_view);
        this.flg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.i.Y(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.flh, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ax.aS(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(am amVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.flh = str2;
        this.postId = j3;
        this.threadId = j2;
        if (amVar == null || amVar.qx() == null || amVar.qx().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (amVar.qx().size() > 4 ? 4 : amVar.qx().size()) {
            case 1:
                this.flb.startLoad(amVar.qx().get(0).WS, 10, false);
                this.flb.setVisibility(0);
                this.flc.setVisibility(8);
                this.fld.setVisibility(8);
                this.fle.setVisibility(8);
                break;
            case 2:
                this.flb.startLoad(amVar.qx().get(0).WS, 10, false);
                this.flc.startLoad(amVar.qx().get(1).WS, 10, false);
                this.flb.setVisibility(0);
                this.flc.setVisibility(0);
                this.fld.setVisibility(8);
                this.fle.setVisibility(8);
                break;
            case 3:
                this.flb.startLoad(amVar.qx().get(0).WS, 10, false);
                this.flc.startLoad(amVar.qx().get(1).WS, 10, false);
                this.fld.startLoad(amVar.qx().get(2).WS, 10, false);
                this.flb.setVisibility(0);
                this.flc.setVisibility(0);
                this.fld.setVisibility(0);
                this.fle.setVisibility(8);
                break;
            case 4:
                this.flb.startLoad(amVar.qx().get(0).WS, 10, false);
                this.flc.startLoad(amVar.qx().get(1).WS, 10, false);
                this.fld.startLoad(amVar.qx().get(2).WS, 10, false);
                this.fle.startLoad(amVar.qx().get(3).WS, 10, false);
                this.flb.setVisibility(0);
                this.flc.setVisibility(0);
                this.fld.setVisibility(0);
                this.fle.setVisibility(0);
                break;
        }
        if (amVar.qw() > 0) {
            this.flf.setText(String.format(this.mContext.getResources().getString(d.j.gift_counts), Integer.valueOf(amVar.qw())));
            this.flf.setVisibility(0);
        } else {
            this.flf.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.flg.setVisibility(8);
        } else {
            this.flg.setVisibility(0);
        }
    }

    public void kw(boolean z) {
        if (z) {
            this.flg.setVisibility(0);
        } else {
            this.flg.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        aj.c(this.flf, d.C0096d.cp_cont_d, 1);
        aj.c(this.flg, d.C0096d.cp_link_tip_c, 1);
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
