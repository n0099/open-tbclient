package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PbGiftListView extends FrameLayout {
    private View cex;
    private TbImageView gcU;
    private TbImageView gcV;
    private TbImageView gcW;
    private TbImageView gcX;
    private TextView gcY;
    private TextView gcZ;
    private String gda;
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
        this.cex = View.inflate(this.mContext, d.h.pb_gift_list_item, this);
        this.gcU = (TbImageView) this.cex.findViewById(d.g.pb_gift_view1);
        this.gcV = (TbImageView) this.cex.findViewById(d.g.pb_gift_view2);
        this.gcW = (TbImageView) this.cex.findViewById(d.g.pb_gift_view3);
        this.gcX = (TbImageView) this.cex.findViewById(d.g.pb_gift_view4);
        this.gcU.setDefaultBgResource(d.f.transparent_bg);
        this.gcV.setDefaultBgResource(d.f.transparent_bg);
        this.gcW.setDefaultBgResource(d.f.transparent_bg);
        this.gcX.setDefaultBgResource(d.f.transparent_bg);
        this.gcU.setDefaultResource(d.f.icon_gift_moren);
        this.gcV.setDefaultResource(d.f.icon_gift_moren);
        this.gcW.setDefaultResource(d.f.icon_gift_moren);
        this.gcX.setDefaultResource(d.f.icon_gift_moren);
        this.gcY = (TextView) this.cex.findViewById(d.g.pb_gift_number_view);
        this.gcZ = (TextView) this.cex.findViewById(d.g.pb_gift_send_view);
        this.gcZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.ak(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.gda, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ay.ba(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(am amVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.gda = str2;
        this.postId = j3;
        this.threadId = j2;
        if (amVar == null || amVar.yz() == null || amVar.yz().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (amVar.yz().size() > 4 ? 4 : amVar.yz().size()) {
            case 1:
                this.gcU.startLoad(amVar.yz().get(0).thumbnailUrl, 10, false);
                this.gcU.setVisibility(0);
                this.gcV.setVisibility(8);
                this.gcW.setVisibility(8);
                this.gcX.setVisibility(8);
                break;
            case 2:
                this.gcU.startLoad(amVar.yz().get(0).thumbnailUrl, 10, false);
                this.gcV.startLoad(amVar.yz().get(1).thumbnailUrl, 10, false);
                this.gcU.setVisibility(0);
                this.gcV.setVisibility(0);
                this.gcW.setVisibility(8);
                this.gcX.setVisibility(8);
                break;
            case 3:
                this.gcU.startLoad(amVar.yz().get(0).thumbnailUrl, 10, false);
                this.gcV.startLoad(amVar.yz().get(1).thumbnailUrl, 10, false);
                this.gcW.startLoad(amVar.yz().get(2).thumbnailUrl, 10, false);
                this.gcU.setVisibility(0);
                this.gcV.setVisibility(0);
                this.gcW.setVisibility(0);
                this.gcX.setVisibility(8);
                break;
            case 4:
                this.gcU.startLoad(amVar.yz().get(0).thumbnailUrl, 10, false);
                this.gcV.startLoad(amVar.yz().get(1).thumbnailUrl, 10, false);
                this.gcW.startLoad(amVar.yz().get(2).thumbnailUrl, 10, false);
                this.gcX.startLoad(amVar.yz().get(3).thumbnailUrl, 10, false);
                this.gcU.setVisibility(0);
                this.gcV.setVisibility(0);
                this.gcW.setVisibility(0);
                this.gcX.setVisibility(0);
                break;
        }
        if (amVar.yy() > 0) {
            this.gcY.setText(String.format(this.mContext.getResources().getString(d.j.gift_counts), Integer.valueOf(amVar.yy())));
            this.gcY.setVisibility(0);
        } else {
            this.gcY.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.gcZ.setVisibility(8);
        } else {
            this.gcZ.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        aj.e(this.gcY, d.C0141d.cp_cont_d, 1);
        aj.e(this.gcZ, d.C0141d.cp_link_tip_c, 1);
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
