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
    private View dej;
    private TbImageView flg;
    private TbImageView flh;
    private TbImageView fli;
    private TbImageView flj;
    private TextView flk;
    private TextView fll;
    private String flm;
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
        this.dej = View.inflate(this.mContext, d.h.pb_gift_list_item, this);
        this.flg = (TbImageView) this.dej.findViewById(d.g.pb_gift_view1);
        this.flh = (TbImageView) this.dej.findViewById(d.g.pb_gift_view2);
        this.fli = (TbImageView) this.dej.findViewById(d.g.pb_gift_view3);
        this.flj = (TbImageView) this.dej.findViewById(d.g.pb_gift_view4);
        this.flg.setDefaultBgResource(d.f.transparent_bg);
        this.flh.setDefaultBgResource(d.f.transparent_bg);
        this.fli.setDefaultBgResource(d.f.transparent_bg);
        this.flj.setDefaultBgResource(d.f.transparent_bg);
        this.flg.setDefaultResource(d.f.icon_gift_moren);
        this.flh.setDefaultResource(d.f.icon_gift_moren);
        this.fli.setDefaultResource(d.f.icon_gift_moren);
        this.flj.setDefaultResource(d.f.icon_gift_moren);
        this.flk = (TextView) this.dej.findViewById(d.g.pb_gift_number_view);
        this.fll = (TextView) this.dej.findViewById(d.g.pb_gift_send_view);
        this.fll.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) com.baidu.adp.base.i.Y(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.flm, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
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
        this.flm = str2;
        this.postId = j3;
        this.threadId = j2;
        if (amVar == null || amVar.qx() == null || amVar.qx().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (amVar.qx().size() > 4 ? 4 : amVar.qx().size()) {
            case 1:
                this.flg.startLoad(amVar.qx().get(0).WV, 10, false);
                this.flg.setVisibility(0);
                this.flh.setVisibility(8);
                this.fli.setVisibility(8);
                this.flj.setVisibility(8);
                break;
            case 2:
                this.flg.startLoad(amVar.qx().get(0).WV, 10, false);
                this.flh.startLoad(amVar.qx().get(1).WV, 10, false);
                this.flg.setVisibility(0);
                this.flh.setVisibility(0);
                this.fli.setVisibility(8);
                this.flj.setVisibility(8);
                break;
            case 3:
                this.flg.startLoad(amVar.qx().get(0).WV, 10, false);
                this.flh.startLoad(amVar.qx().get(1).WV, 10, false);
                this.fli.startLoad(amVar.qx().get(2).WV, 10, false);
                this.flg.setVisibility(0);
                this.flh.setVisibility(0);
                this.fli.setVisibility(0);
                this.flj.setVisibility(8);
                break;
            case 4:
                this.flg.startLoad(amVar.qx().get(0).WV, 10, false);
                this.flh.startLoad(amVar.qx().get(1).WV, 10, false);
                this.fli.startLoad(amVar.qx().get(2).WV, 10, false);
                this.flj.startLoad(amVar.qx().get(3).WV, 10, false);
                this.flg.setVisibility(0);
                this.flh.setVisibility(0);
                this.fli.setVisibility(0);
                this.flj.setVisibility(0);
                break;
        }
        if (amVar.qw() > 0) {
            this.flk.setText(String.format(this.mContext.getResources().getString(d.j.gift_counts), Integer.valueOf(amVar.qw())));
            this.flk.setVisibility(0);
        } else {
            this.flk.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.fll.setVisibility(8);
        } else {
            this.fll.setVisibility(0);
        }
    }

    public void kw(boolean z) {
        if (z) {
            this.fll.setVisibility(0);
        } else {
            this.fll.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        aj.c(this.flk, d.C0095d.cp_cont_d, 1);
        aj.c(this.fll, d.C0095d.cp_link_tip_c, 1);
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
