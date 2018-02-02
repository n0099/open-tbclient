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
    private View dVD;
    private TbImageView fZY;
    private TbImageView fZZ;
    private TbImageView gaa;
    private TbImageView gab;
    private TextView gac;
    private TextView gad;
    private String gae;
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
        this.dVD = View.inflate(this.mContext, d.h.pb_gift_list_item, this);
        this.fZY = (TbImageView) this.dVD.findViewById(d.g.pb_gift_view1);
        this.fZZ = (TbImageView) this.dVD.findViewById(d.g.pb_gift_view2);
        this.gaa = (TbImageView) this.dVD.findViewById(d.g.pb_gift_view3);
        this.gab = (TbImageView) this.dVD.findViewById(d.g.pb_gift_view4);
        this.fZY.setDefaultBgResource(d.f.transparent_bg);
        this.fZZ.setDefaultBgResource(d.f.transparent_bg);
        this.gaa.setDefaultBgResource(d.f.transparent_bg);
        this.gab.setDefaultBgResource(d.f.transparent_bg);
        this.fZY.setDefaultResource(d.f.icon_gift_moren);
        this.fZZ.setDefaultResource(d.f.icon_gift_moren);
        this.gaa.setDefaultResource(d.f.icon_gift_moren);
        this.gab.setDefaultResource(d.f.icon_gift_moren);
        this.gac = (TextView) this.dVD.findViewById(d.g.pb_gift_number_view);
        this.gad = (TextView) this.dVD.findViewById(d.g.pb_gift_send_view);
        this.gad.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.i.ak(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.gae, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ax.bb(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(am amVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.gae = str2;
        this.postId = j3;
        this.threadId = j2;
        if (amVar == null || amVar.xY() == null || amVar.xY().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (amVar.xY().size() > 4 ? 4 : amVar.xY().size()) {
            case 1:
                this.fZY.startLoad(amVar.xY().get(0).aLu, 10, false);
                this.fZY.setVisibility(0);
                this.fZZ.setVisibility(8);
                this.gaa.setVisibility(8);
                this.gab.setVisibility(8);
                break;
            case 2:
                this.fZY.startLoad(amVar.xY().get(0).aLu, 10, false);
                this.fZZ.startLoad(amVar.xY().get(1).aLu, 10, false);
                this.fZY.setVisibility(0);
                this.fZZ.setVisibility(0);
                this.gaa.setVisibility(8);
                this.gab.setVisibility(8);
                break;
            case 3:
                this.fZY.startLoad(amVar.xY().get(0).aLu, 10, false);
                this.fZZ.startLoad(amVar.xY().get(1).aLu, 10, false);
                this.gaa.startLoad(amVar.xY().get(2).aLu, 10, false);
                this.fZY.setVisibility(0);
                this.fZZ.setVisibility(0);
                this.gaa.setVisibility(0);
                this.gab.setVisibility(8);
                break;
            case 4:
                this.fZY.startLoad(amVar.xY().get(0).aLu, 10, false);
                this.fZZ.startLoad(amVar.xY().get(1).aLu, 10, false);
                this.gaa.startLoad(amVar.xY().get(2).aLu, 10, false);
                this.gab.startLoad(amVar.xY().get(3).aLu, 10, false);
                this.fZY.setVisibility(0);
                this.fZZ.setVisibility(0);
                this.gaa.setVisibility(0);
                this.gab.setVisibility(0);
                break;
        }
        if (amVar.xX() > 0) {
            this.gac.setText(String.format(this.mContext.getResources().getString(d.j.gift_counts), Integer.valueOf(amVar.xX())));
            this.gac.setVisibility(0);
        } else {
            this.gac.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.gad.setVisibility(8);
        } else {
            this.gad.setVisibility(0);
        }
    }

    public void le(boolean z) {
        if (z) {
            this.gad.setVisibility(0);
        } else {
            this.gad.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        aj.e(this.gac, d.C0108d.cp_cont_d, 1);
        aj.e(this.gad, d.C0108d.cp_link_tip_c, 1);
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
