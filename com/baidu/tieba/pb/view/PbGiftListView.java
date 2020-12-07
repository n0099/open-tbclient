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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class PbGiftListView extends FrameLayout {
    private View egT;
    private Context mContext;
    private int mSkinType;
    private TbImageView meF;
    private TbImageView meG;
    private TbImageView meH;
    private TbImageView meI;
    private TextView meJ;
    private TextView meK;
    private String meL;
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
        this.egT = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.meF = (TbImageView) this.egT.findViewById(R.id.pb_gift_view1);
        this.meG = (TbImageView) this.egT.findViewById(R.id.pb_gift_view2);
        this.meH = (TbImageView) this.egT.findViewById(R.id.pb_gift_view3);
        this.meI = (TbImageView) this.egT.findViewById(R.id.pb_gift_view4);
        this.meF.setDefaultBgResource(R.drawable.transparent_bg);
        this.meG.setDefaultBgResource(R.drawable.transparent_bg);
        this.meH.setDefaultBgResource(R.drawable.transparent_bg);
        this.meI.setDefaultBgResource(R.drawable.transparent_bg);
        this.meF.setDefaultResource(R.drawable.icon_gift_moren);
        this.meG.setDefaultResource(R.drawable.icon_gift_moren);
        this.meH.setDefaultResource(R.drawable.icon_gift_moren);
        this.meI.setDefaultResource(R.drawable.icon_gift_moren);
        this.meJ = (TextView) this.egT.findViewById(R.id.pb_gift_number_view);
        this.meK = (TextView) this.egT.findViewById(R.id.pb_gift_send_view);
        this.meK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.J(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.meL, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bh.checkUpIsLogin(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(az azVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.meL = str2;
        this.postId = j3;
        this.threadId = j2;
        if (azVar == null || azVar.bnH() == null || azVar.bnH().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (azVar.bnH().size() > 4 ? 4 : azVar.bnH().size()) {
            case 1:
                this.meF.startLoad(azVar.bnH().get(0).thumbnailUrl, 10, false);
                this.meF.setVisibility(0);
                this.meG.setVisibility(8);
                this.meH.setVisibility(8);
                this.meI.setVisibility(8);
                break;
            case 2:
                this.meF.startLoad(azVar.bnH().get(0).thumbnailUrl, 10, false);
                this.meG.startLoad(azVar.bnH().get(1).thumbnailUrl, 10, false);
                this.meF.setVisibility(0);
                this.meG.setVisibility(0);
                this.meH.setVisibility(8);
                this.meI.setVisibility(8);
                break;
            case 3:
                this.meF.startLoad(azVar.bnH().get(0).thumbnailUrl, 10, false);
                this.meG.startLoad(azVar.bnH().get(1).thumbnailUrl, 10, false);
                this.meH.startLoad(azVar.bnH().get(2).thumbnailUrl, 10, false);
                this.meF.setVisibility(0);
                this.meG.setVisibility(0);
                this.meH.setVisibility(0);
                this.meI.setVisibility(8);
                break;
            case 4:
                this.meF.startLoad(azVar.bnH().get(0).thumbnailUrl, 10, false);
                this.meG.startLoad(azVar.bnH().get(1).thumbnailUrl, 10, false);
                this.meH.startLoad(azVar.bnH().get(2).thumbnailUrl, 10, false);
                this.meI.startLoad(azVar.bnH().get(3).thumbnailUrl, 10, false);
                this.meF.setVisibility(0);
                this.meG.setVisibility(0);
                this.meH.setVisibility(0);
                this.meI.setVisibility(0);
                break;
        }
        if (azVar.getTotal() > 0) {
            this.meJ.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(azVar.getTotal())));
            this.meJ.setVisibility(0);
        } else {
            this.meJ.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.meK.setVisibility(8);
        } else {
            this.meK.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ap.setViewTextColor(this.meJ, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.meK, R.color.CAM_X0304, 1);
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
