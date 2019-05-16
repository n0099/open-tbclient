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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PbGiftListView extends FrameLayout {
    private View bmd;
    private TbImageView hXA;
    private TbImageView hXB;
    private TextView hXC;
    private TextView hXD;
    private String hXE;
    private TbImageView hXy;
    private TbImageView hXz;
    private Context mContext;
    private int mSkinType;
    private long postId;
    private long threadId;
    private long toUserId;
    private String toUserName;

    public PbGiftListView(Context context) {
        super(context);
        this.mSkinType = 3;
    }

    public PbGiftListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mContext = context;
        initView();
    }

    public PbGiftListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bmd = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.hXy = (TbImageView) this.bmd.findViewById(R.id.pb_gift_view1);
        this.hXz = (TbImageView) this.bmd.findViewById(R.id.pb_gift_view2);
        this.hXA = (TbImageView) this.bmd.findViewById(R.id.pb_gift_view3);
        this.hXB = (TbImageView) this.bmd.findViewById(R.id.pb_gift_view4);
        this.hXy.setDefaultBgResource(R.drawable.transparent_bg);
        this.hXz.setDefaultBgResource(R.drawable.transparent_bg);
        this.hXA.setDefaultBgResource(R.drawable.transparent_bg);
        this.hXB.setDefaultBgResource(R.drawable.transparent_bg);
        this.hXy.setDefaultResource(R.drawable.icon_gift_moren);
        this.hXz.setDefaultResource(R.drawable.icon_gift_moren);
        this.hXA.setDefaultResource(R.drawable.icon_gift_moren);
        this.hXB.setDefaultResource(R.drawable.icon_gift_moren);
        this.hXC = (TextView) this.bmd.findViewById(R.id.pb_gift_number_view);
        this.hXD = (TextView) this.bmd.findViewById(R.id.pb_gift_send_view);
        this.hXD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.ab(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.hXE, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bc.cE(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(ao aoVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.hXE = str2;
        this.postId = j3;
        this.threadId = j2;
        if (aoVar == null || aoVar.acr() == null || aoVar.acr().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (aoVar.acr().size() > 4 ? 4 : aoVar.acr().size()) {
            case 1:
                this.hXy.startLoad(aoVar.acr().get(0).thumbnailUrl, 10, false);
                this.hXy.setVisibility(0);
                this.hXz.setVisibility(8);
                this.hXA.setVisibility(8);
                this.hXB.setVisibility(8);
                break;
            case 2:
                this.hXy.startLoad(aoVar.acr().get(0).thumbnailUrl, 10, false);
                this.hXz.startLoad(aoVar.acr().get(1).thumbnailUrl, 10, false);
                this.hXy.setVisibility(0);
                this.hXz.setVisibility(0);
                this.hXA.setVisibility(8);
                this.hXB.setVisibility(8);
                break;
            case 3:
                this.hXy.startLoad(aoVar.acr().get(0).thumbnailUrl, 10, false);
                this.hXz.startLoad(aoVar.acr().get(1).thumbnailUrl, 10, false);
                this.hXA.startLoad(aoVar.acr().get(2).thumbnailUrl, 10, false);
                this.hXy.setVisibility(0);
                this.hXz.setVisibility(0);
                this.hXA.setVisibility(0);
                this.hXB.setVisibility(8);
                break;
            case 4:
                this.hXy.startLoad(aoVar.acr().get(0).thumbnailUrl, 10, false);
                this.hXz.startLoad(aoVar.acr().get(1).thumbnailUrl, 10, false);
                this.hXA.startLoad(aoVar.acr().get(2).thumbnailUrl, 10, false);
                this.hXB.startLoad(aoVar.acr().get(3).thumbnailUrl, 10, false);
                this.hXy.setVisibility(0);
                this.hXz.setVisibility(0);
                this.hXA.setVisibility(0);
                this.hXB.setVisibility(0);
                break;
        }
        if (aoVar.getTotal() > 0) {
            this.hXC.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(aoVar.getTotal())));
            this.hXC.setVisibility(0);
        } else {
            this.hXC.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.hXD.setVisibility(8);
        } else {
            this.hXD.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            al.f(this.hXC, R.color.cp_cont_d, 1);
            al.f(this.hXD, R.color.cp_link_tip_c, 1);
        }
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
