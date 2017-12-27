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
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PbGiftListView extends FrameLayout {
    private View dQu;
    private TbImageView fYc;
    private TbImageView fYd;
    private TbImageView fYe;
    private TbImageView fYf;
    private TextView fYg;
    private TextView fYh;
    private String fYi;
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
        this.dQu = View.inflate(this.mContext, d.h.pb_gift_list_item, this);
        this.fYc = (TbImageView) this.dQu.findViewById(d.g.pb_gift_view1);
        this.fYd = (TbImageView) this.dQu.findViewById(d.g.pb_gift_view2);
        this.fYe = (TbImageView) this.dQu.findViewById(d.g.pb_gift_view3);
        this.fYf = (TbImageView) this.dQu.findViewById(d.g.pb_gift_view4);
        this.fYc.setDefaultBgResource(d.f.transparent_bg);
        this.fYd.setDefaultBgResource(d.f.transparent_bg);
        this.fYe.setDefaultBgResource(d.f.transparent_bg);
        this.fYf.setDefaultBgResource(d.f.transparent_bg);
        this.fYc.setDefaultResource(d.f.icon_gift_moren);
        this.fYd.setDefaultResource(d.f.icon_gift_moren);
        this.fYe.setDefaultResource(d.f.icon_gift_moren);
        this.fYf.setDefaultResource(d.f.icon_gift_moren);
        this.fYg = (TextView) this.dQu.findViewById(d.g.pb_gift_number_view);
        this.fYh = (TextView) this.dQu.findViewById(d.g.pb_gift_send_view);
        this.fYh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.i.ak(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.fYi, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ax.be(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(an anVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.fYi = str2;
        this.postId = j3;
        this.threadId = j2;
        if (anVar == null || anVar.ya() == null || anVar.ya().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (anVar.ya().size() > 4 ? 4 : anVar.ya().size()) {
            case 1:
                this.fYc.startLoad(anVar.ya().get(0).aLt, 10, false);
                this.fYc.setVisibility(0);
                this.fYd.setVisibility(8);
                this.fYe.setVisibility(8);
                this.fYf.setVisibility(8);
                break;
            case 2:
                this.fYc.startLoad(anVar.ya().get(0).aLt, 10, false);
                this.fYd.startLoad(anVar.ya().get(1).aLt, 10, false);
                this.fYc.setVisibility(0);
                this.fYd.setVisibility(0);
                this.fYe.setVisibility(8);
                this.fYf.setVisibility(8);
                break;
            case 3:
                this.fYc.startLoad(anVar.ya().get(0).aLt, 10, false);
                this.fYd.startLoad(anVar.ya().get(1).aLt, 10, false);
                this.fYe.startLoad(anVar.ya().get(2).aLt, 10, false);
                this.fYc.setVisibility(0);
                this.fYd.setVisibility(0);
                this.fYe.setVisibility(0);
                this.fYf.setVisibility(8);
                break;
            case 4:
                this.fYc.startLoad(anVar.ya().get(0).aLt, 10, false);
                this.fYd.startLoad(anVar.ya().get(1).aLt, 10, false);
                this.fYe.startLoad(anVar.ya().get(2).aLt, 10, false);
                this.fYf.startLoad(anVar.ya().get(3).aLt, 10, false);
                this.fYc.setVisibility(0);
                this.fYd.setVisibility(0);
                this.fYe.setVisibility(0);
                this.fYf.setVisibility(0);
                break;
        }
        if (anVar.xZ() > 0) {
            this.fYg.setText(String.format(this.mContext.getResources().getString(d.j.gift_counts), Integer.valueOf(anVar.xZ())));
            this.fYg.setVisibility(0);
        } else {
            this.fYg.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.fYh.setVisibility(8);
        } else {
            this.fYh.setVisibility(0);
        }
    }

    public void kZ(boolean z) {
        if (z) {
            this.fYh.setVisibility(0);
        } else {
            this.fYh.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        aj.e(this.fYg, d.C0108d.cp_cont_d, 1);
        aj.e(this.fYh, d.C0108d.cp_link_tip_c, 1);
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
