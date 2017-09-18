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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbGiftListView extends FrameLayout {
    private View cJH;
    private TextView faA;
    private String faB;
    private TbImageView fav;
    private TbImageView faw;
    private TbImageView fax;
    private TbImageView fay;
    private TextView faz;
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
        this.cJH = View.inflate(this.mContext, d.j.pb_gift_list_item, this);
        this.fav = (TbImageView) this.cJH.findViewById(d.h.pb_gift_view1);
        this.faw = (TbImageView) this.cJH.findViewById(d.h.pb_gift_view2);
        this.fax = (TbImageView) this.cJH.findViewById(d.h.pb_gift_view3);
        this.fay = (TbImageView) this.cJH.findViewById(d.h.pb_gift_view4);
        this.fav.setDefaultBgResource(d.g.transparent_bg);
        this.faw.setDefaultBgResource(d.g.transparent_bg);
        this.fax.setDefaultBgResource(d.g.transparent_bg);
        this.fay.setDefaultBgResource(d.g.transparent_bg);
        this.fav.setDefaultResource(d.g.icon_gift_moren);
        this.faw.setDefaultResource(d.g.icon_gift_moren);
        this.fax.setDefaultResource(d.g.icon_gift_moren);
        this.fay.setDefaultResource(d.g.icon_gift_moren);
        this.faz = (TextView) this.cJH.findViewById(d.h.pb_gift_number_view);
        this.faA = (TextView) this.cJH.findViewById(d.h.pb_gift_send_view);
        this.faA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.i.Y(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.faB, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ax.aU(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(as asVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.faB = str2;
        this.postId = j3;
        this.threadId = j2;
        if (asVar == null || asVar.qC() == null || asVar.qC().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (asVar.qC().size() > 4 ? 4 : asVar.qC().size()) {
            case 1:
                this.fav.c(asVar.qC().get(0).Wk, 10, false);
                this.fav.setVisibility(0);
                this.faw.setVisibility(8);
                this.fax.setVisibility(8);
                this.fay.setVisibility(8);
                break;
            case 2:
                this.fav.c(asVar.qC().get(0).Wk, 10, false);
                this.faw.c(asVar.qC().get(1).Wk, 10, false);
                this.fav.setVisibility(0);
                this.faw.setVisibility(0);
                this.fax.setVisibility(8);
                this.fay.setVisibility(8);
                break;
            case 3:
                this.fav.c(asVar.qC().get(0).Wk, 10, false);
                this.faw.c(asVar.qC().get(1).Wk, 10, false);
                this.fax.c(asVar.qC().get(2).Wk, 10, false);
                this.fav.setVisibility(0);
                this.faw.setVisibility(0);
                this.fax.setVisibility(0);
                this.fay.setVisibility(8);
                break;
            case 4:
                this.fav.c(asVar.qC().get(0).Wk, 10, false);
                this.faw.c(asVar.qC().get(1).Wk, 10, false);
                this.fax.c(asVar.qC().get(2).Wk, 10, false);
                this.fay.c(asVar.qC().get(3).Wk, 10, false);
                this.fav.setVisibility(0);
                this.faw.setVisibility(0);
                this.fax.setVisibility(0);
                this.fay.setVisibility(0);
                break;
        }
        if (asVar.qB() > 0) {
            this.faz.setText(String.format(this.mContext.getResources().getString(d.l.gift_counts), Integer.valueOf(asVar.qB())));
            this.faz.setVisibility(0);
        } else {
            this.faz.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.faA.setVisibility(8);
        } else {
            this.faA.setVisibility(0);
        }
    }

    public void kk(boolean z) {
        if (z) {
            this.faA.setVisibility(0);
        } else {
            this.faA.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        aj.c(this.faz, d.e.cp_cont_d, 1);
        aj.c(this.faA, d.e.cp_link_tip_c, 1);
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
