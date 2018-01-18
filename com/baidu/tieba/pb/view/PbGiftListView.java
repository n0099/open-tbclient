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
/* loaded from: classes2.dex */
public class PbGiftListView extends FrameLayout {
    private View dVi;
    private TbImageView fZD;
    private TbImageView fZE;
    private TbImageView fZF;
    private TbImageView fZG;
    private TextView fZH;
    private TextView fZI;
    private String fZJ;
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
        this.dVi = View.inflate(this.mContext, d.h.pb_gift_list_item, this);
        this.fZD = (TbImageView) this.dVi.findViewById(d.g.pb_gift_view1);
        this.fZE = (TbImageView) this.dVi.findViewById(d.g.pb_gift_view2);
        this.fZF = (TbImageView) this.dVi.findViewById(d.g.pb_gift_view3);
        this.fZG = (TbImageView) this.dVi.findViewById(d.g.pb_gift_view4);
        this.fZD.setDefaultBgResource(d.f.transparent_bg);
        this.fZE.setDefaultBgResource(d.f.transparent_bg);
        this.fZF.setDefaultBgResource(d.f.transparent_bg);
        this.fZG.setDefaultBgResource(d.f.transparent_bg);
        this.fZD.setDefaultResource(d.f.icon_gift_moren);
        this.fZE.setDefaultResource(d.f.icon_gift_moren);
        this.fZF.setDefaultResource(d.f.icon_gift_moren);
        this.fZG.setDefaultResource(d.f.icon_gift_moren);
        this.fZH = (TextView) this.dVi.findViewById(d.g.pb_gift_number_view);
        this.fZI = (TextView) this.dVi.findViewById(d.g.pb_gift_send_view);
        this.fZI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.i.ak(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.fZJ, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ax.be(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(am amVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.fZJ = str2;
        this.postId = j3;
        this.threadId = j2;
        if (amVar == null || amVar.xX() == null || amVar.xX().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (amVar.xX().size() > 4 ? 4 : amVar.xX().size()) {
            case 1:
                this.fZD.startLoad(amVar.xX().get(0).aLr, 10, false);
                this.fZD.setVisibility(0);
                this.fZE.setVisibility(8);
                this.fZF.setVisibility(8);
                this.fZG.setVisibility(8);
                break;
            case 2:
                this.fZD.startLoad(amVar.xX().get(0).aLr, 10, false);
                this.fZE.startLoad(amVar.xX().get(1).aLr, 10, false);
                this.fZD.setVisibility(0);
                this.fZE.setVisibility(0);
                this.fZF.setVisibility(8);
                this.fZG.setVisibility(8);
                break;
            case 3:
                this.fZD.startLoad(amVar.xX().get(0).aLr, 10, false);
                this.fZE.startLoad(amVar.xX().get(1).aLr, 10, false);
                this.fZF.startLoad(amVar.xX().get(2).aLr, 10, false);
                this.fZD.setVisibility(0);
                this.fZE.setVisibility(0);
                this.fZF.setVisibility(0);
                this.fZG.setVisibility(8);
                break;
            case 4:
                this.fZD.startLoad(amVar.xX().get(0).aLr, 10, false);
                this.fZE.startLoad(amVar.xX().get(1).aLr, 10, false);
                this.fZF.startLoad(amVar.xX().get(2).aLr, 10, false);
                this.fZG.startLoad(amVar.xX().get(3).aLr, 10, false);
                this.fZD.setVisibility(0);
                this.fZE.setVisibility(0);
                this.fZF.setVisibility(0);
                this.fZG.setVisibility(0);
                break;
        }
        if (amVar.xW() > 0) {
            this.fZH.setText(String.format(this.mContext.getResources().getString(d.j.gift_counts), Integer.valueOf(amVar.xW())));
            this.fZH.setVisibility(0);
        } else {
            this.fZH.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.fZI.setVisibility(8);
        } else {
            this.fZI.setVisibility(0);
        }
    }

    public void lb(boolean z) {
        if (z) {
            this.fZI.setVisibility(0);
        } else {
            this.fZI.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        aj.e(this.fZH, d.C0107d.cp_cont_d, 1);
        aj.e(this.fZI, d.C0107d.cp_link_tip_c, 1);
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
