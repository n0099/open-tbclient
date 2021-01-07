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
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbGiftListView extends FrameLayout {
    private View epV;
    private Context mContext;
    private int mSkinType;
    private TbImageView mjT;
    private TbImageView mjU;
    private TbImageView mjV;
    private TbImageView mjW;
    private TextView mjX;
    private TextView mjY;
    private String mjZ;
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
        this.epV = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.mjT = (TbImageView) this.epV.findViewById(R.id.pb_gift_view1);
        this.mjU = (TbImageView) this.epV.findViewById(R.id.pb_gift_view2);
        this.mjV = (TbImageView) this.epV.findViewById(R.id.pb_gift_view3);
        this.mjW = (TbImageView) this.epV.findViewById(R.id.pb_gift_view4);
        this.mjT.setDefaultBgResource(R.drawable.transparent_bg);
        this.mjU.setDefaultBgResource(R.drawable.transparent_bg);
        this.mjV.setDefaultBgResource(R.drawable.transparent_bg);
        this.mjW.setDefaultBgResource(R.drawable.transparent_bg);
        this.mjT.setDefaultResource(R.drawable.icon_gift_moren);
        this.mjU.setDefaultResource(R.drawable.icon_gift_moren);
        this.mjV.setDefaultResource(R.drawable.icon_gift_moren);
        this.mjW.setDefaultResource(R.drawable.icon_gift_moren);
        this.mjX = (TextView) this.epV.findViewById(R.id.pb_gift_number_view);
        this.mjY = (TextView) this.epV.findViewById(R.id.pb_gift_send_view);
        this.mjY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) j.K(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.mjZ, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bg.checkUpIsLogin(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(az azVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.mjZ = str2;
        this.postId = j3;
        this.threadId = j2;
        if (azVar == null || azVar.bqi() == null || azVar.bqi().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (azVar.bqi().size() > 4 ? 4 : azVar.bqi().size()) {
            case 1:
                this.mjT.startLoad(azVar.bqi().get(0).thumbnailUrl, 10, false);
                this.mjT.setVisibility(0);
                this.mjU.setVisibility(8);
                this.mjV.setVisibility(8);
                this.mjW.setVisibility(8);
                break;
            case 2:
                this.mjT.startLoad(azVar.bqi().get(0).thumbnailUrl, 10, false);
                this.mjU.startLoad(azVar.bqi().get(1).thumbnailUrl, 10, false);
                this.mjT.setVisibility(0);
                this.mjU.setVisibility(0);
                this.mjV.setVisibility(8);
                this.mjW.setVisibility(8);
                break;
            case 3:
                this.mjT.startLoad(azVar.bqi().get(0).thumbnailUrl, 10, false);
                this.mjU.startLoad(azVar.bqi().get(1).thumbnailUrl, 10, false);
                this.mjV.startLoad(azVar.bqi().get(2).thumbnailUrl, 10, false);
                this.mjT.setVisibility(0);
                this.mjU.setVisibility(0);
                this.mjV.setVisibility(0);
                this.mjW.setVisibility(8);
                break;
            case 4:
                this.mjT.startLoad(azVar.bqi().get(0).thumbnailUrl, 10, false);
                this.mjU.startLoad(azVar.bqi().get(1).thumbnailUrl, 10, false);
                this.mjV.startLoad(azVar.bqi().get(2).thumbnailUrl, 10, false);
                this.mjW.startLoad(azVar.bqi().get(3).thumbnailUrl, 10, false);
                this.mjT.setVisibility(0);
                this.mjU.setVisibility(0);
                this.mjV.setVisibility(0);
                this.mjW.setVisibility(0);
                break;
        }
        if (azVar.getTotal() > 0) {
            this.mjX.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(azVar.getTotal())));
            this.mjX.setVisibility(0);
        } else {
            this.mjX.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.mjY.setVisibility(8);
        } else {
            this.mjY.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ao.setViewTextColor(this.mjX, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.mjY, R.color.CAM_X0304, 1);
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
