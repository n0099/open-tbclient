package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.base.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbGiftListView extends FrameLayout {
    private View eoR;
    private Context mContext;
    private int mSkinType;
    private TbImageView mqH;
    private TbImageView mqI;
    private TbImageView mqJ;
    private TbImageView mqK;
    private TextView mqL;
    private TextView mqM;
    private String mqN;
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
        this.eoR = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.mqH = (TbImageView) this.eoR.findViewById(R.id.pb_gift_view1);
        this.mqI = (TbImageView) this.eoR.findViewById(R.id.pb_gift_view2);
        this.mqJ = (TbImageView) this.eoR.findViewById(R.id.pb_gift_view3);
        this.mqK = (TbImageView) this.eoR.findViewById(R.id.pb_gift_view4);
        this.mqH.setDefaultBgResource(R.drawable.transparent_bg);
        this.mqI.setDefaultBgResource(R.drawable.transparent_bg);
        this.mqJ.setDefaultBgResource(R.drawable.transparent_bg);
        this.mqK.setDefaultBgResource(R.drawable.transparent_bg);
        this.mqH.setDefaultResource(R.drawable.icon_gift_moren);
        this.mqI.setDefaultResource(R.drawable.icon_gift_moren);
        this.mqJ.setDefaultResource(R.drawable.icon_gift_moren);
        this.mqK.setDefaultResource(R.drawable.icon_gift_moren);
        this.mqL = (TextView) this.eoR.findViewById(R.id.pb_gift_number_view);
        this.mqM = (TextView) this.eoR.findViewById(R.id.pb_gift_send_view);
        this.mqM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) j.J(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.mqN, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bh.checkUpIsLogin(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(bb bbVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.mqN = str2;
        this.postId = j3;
        this.threadId = j2;
        if (bbVar == null || bbVar.bmJ() == null || bbVar.bmJ().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (bbVar.bmJ().size() > 4 ? 4 : bbVar.bmJ().size()) {
            case 1:
                this.mqH.startLoad(bbVar.bmJ().get(0).thumbnailUrl, 10, false);
                this.mqH.setVisibility(0);
                this.mqI.setVisibility(8);
                this.mqJ.setVisibility(8);
                this.mqK.setVisibility(8);
                break;
            case 2:
                this.mqH.startLoad(bbVar.bmJ().get(0).thumbnailUrl, 10, false);
                this.mqI.startLoad(bbVar.bmJ().get(1).thumbnailUrl, 10, false);
                this.mqH.setVisibility(0);
                this.mqI.setVisibility(0);
                this.mqJ.setVisibility(8);
                this.mqK.setVisibility(8);
                break;
            case 3:
                this.mqH.startLoad(bbVar.bmJ().get(0).thumbnailUrl, 10, false);
                this.mqI.startLoad(bbVar.bmJ().get(1).thumbnailUrl, 10, false);
                this.mqJ.startLoad(bbVar.bmJ().get(2).thumbnailUrl, 10, false);
                this.mqH.setVisibility(0);
                this.mqI.setVisibility(0);
                this.mqJ.setVisibility(0);
                this.mqK.setVisibility(8);
                break;
            case 4:
                this.mqH.startLoad(bbVar.bmJ().get(0).thumbnailUrl, 10, false);
                this.mqI.startLoad(bbVar.bmJ().get(1).thumbnailUrl, 10, false);
                this.mqJ.startLoad(bbVar.bmJ().get(2).thumbnailUrl, 10, false);
                this.mqK.startLoad(bbVar.bmJ().get(3).thumbnailUrl, 10, false);
                this.mqH.setVisibility(0);
                this.mqI.setVisibility(0);
                this.mqJ.setVisibility(0);
                this.mqK.setVisibility(0);
                break;
        }
        if (bbVar.getTotal() > 0) {
            this.mqL.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(bbVar.getTotal())));
            this.mqL.setVisibility(0);
        } else {
            this.mqL.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.mqM.setVisibility(8);
        } else {
            this.mqM.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ap.setViewTextColor(this.mqL, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.mqM, R.color.CAM_X0304, 1);
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
