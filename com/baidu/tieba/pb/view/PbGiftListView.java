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
    private View dcY;
    private TbImageView fkd;
    private TbImageView fke;
    private TbImageView fkf;
    private TbImageView fkg;
    private TextView fkh;
    private TextView fki;
    private String fkj;
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
        this.dcY = View.inflate(this.mContext, d.h.pb_gift_list_item, this);
        this.fkd = (TbImageView) this.dcY.findViewById(d.g.pb_gift_view1);
        this.fke = (TbImageView) this.dcY.findViewById(d.g.pb_gift_view2);
        this.fkf = (TbImageView) this.dcY.findViewById(d.g.pb_gift_view3);
        this.fkg = (TbImageView) this.dcY.findViewById(d.g.pb_gift_view4);
        this.fkd.setDefaultBgResource(d.f.transparent_bg);
        this.fke.setDefaultBgResource(d.f.transparent_bg);
        this.fkf.setDefaultBgResource(d.f.transparent_bg);
        this.fkg.setDefaultBgResource(d.f.transparent_bg);
        this.fkd.setDefaultResource(d.f.icon_gift_moren);
        this.fke.setDefaultResource(d.f.icon_gift_moren);
        this.fkf.setDefaultResource(d.f.icon_gift_moren);
        this.fkg.setDefaultResource(d.f.icon_gift_moren);
        this.fkh = (TextView) this.dcY.findViewById(d.g.pb_gift_number_view);
        this.fki = (TextView) this.dcY.findViewById(d.g.pb_gift_send_view);
        this.fki.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.i.Y(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.fkj, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ax.aV(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(am amVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.fkj = str2;
        this.postId = j3;
        this.threadId = j2;
        if (amVar == null || amVar.qz() == null || amVar.qz().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (amVar.qz().size() > 4 ? 4 : amVar.qz().size()) {
            case 1:
                this.fkd.startLoad(amVar.qz().get(0).WY, 10, false);
                this.fkd.setVisibility(0);
                this.fke.setVisibility(8);
                this.fkf.setVisibility(8);
                this.fkg.setVisibility(8);
                break;
            case 2:
                this.fkd.startLoad(amVar.qz().get(0).WY, 10, false);
                this.fke.startLoad(amVar.qz().get(1).WY, 10, false);
                this.fkd.setVisibility(0);
                this.fke.setVisibility(0);
                this.fkf.setVisibility(8);
                this.fkg.setVisibility(8);
                break;
            case 3:
                this.fkd.startLoad(amVar.qz().get(0).WY, 10, false);
                this.fke.startLoad(amVar.qz().get(1).WY, 10, false);
                this.fkf.startLoad(amVar.qz().get(2).WY, 10, false);
                this.fkd.setVisibility(0);
                this.fke.setVisibility(0);
                this.fkf.setVisibility(0);
                this.fkg.setVisibility(8);
                break;
            case 4:
                this.fkd.startLoad(amVar.qz().get(0).WY, 10, false);
                this.fke.startLoad(amVar.qz().get(1).WY, 10, false);
                this.fkf.startLoad(amVar.qz().get(2).WY, 10, false);
                this.fkg.startLoad(amVar.qz().get(3).WY, 10, false);
                this.fkd.setVisibility(0);
                this.fke.setVisibility(0);
                this.fkf.setVisibility(0);
                this.fkg.setVisibility(0);
                break;
        }
        if (amVar.qy() > 0) {
            this.fkh.setText(String.format(this.mContext.getResources().getString(d.j.gift_counts), Integer.valueOf(amVar.qy())));
            this.fkh.setVisibility(0);
        } else {
            this.fkh.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.fki.setVisibility(8);
        } else {
            this.fki.setVisibility(0);
        }
    }

    public void kv(boolean z) {
        if (z) {
            this.fki.setVisibility(0);
        } else {
            this.fki.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        aj.c(this.fkh, d.C0082d.cp_cont_d, 1);
        aj.c(this.fki, d.C0082d.cp_link_tip_c, 1);
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
