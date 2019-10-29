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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PbGiftListView extends FrameLayout {
    private View bGb;
    private TbImageView ifD;
    private TbImageView ifE;
    private TbImageView ifF;
    private TbImageView ifG;
    private TextView ifH;
    private TextView ifI;
    private String ifJ;
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
        this.bGb = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.ifD = (TbImageView) this.bGb.findViewById(R.id.pb_gift_view1);
        this.ifE = (TbImageView) this.bGb.findViewById(R.id.pb_gift_view2);
        this.ifF = (TbImageView) this.bGb.findViewById(R.id.pb_gift_view3);
        this.ifG = (TbImageView) this.bGb.findViewById(R.id.pb_gift_view4);
        this.ifD.setDefaultBgResource(R.drawable.transparent_bg);
        this.ifE.setDefaultBgResource(R.drawable.transparent_bg);
        this.ifF.setDefaultBgResource(R.drawable.transparent_bg);
        this.ifG.setDefaultBgResource(R.drawable.transparent_bg);
        this.ifD.setDefaultResource(R.drawable.icon_gift_moren);
        this.ifE.setDefaultResource(R.drawable.icon_gift_moren);
        this.ifF.setDefaultResource(R.drawable.icon_gift_moren);
        this.ifG.setDefaultResource(R.drawable.icon_gift_moren);
        this.ifH = (TextView) this.bGb.findViewById(R.id.pb_gift_number_view);
        this.ifI = (TextView) this.bGb.findViewById(R.id.pb_gift_send_view);
        this.ifI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.ab(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.ifJ, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bc.checkUpIsLogin(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(ao aoVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.ifJ = str2;
        this.postId = j3;
        this.threadId = j2;
        if (aoVar == null || aoVar.ahC() == null || aoVar.ahC().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (aoVar.ahC().size() > 4 ? 4 : aoVar.ahC().size()) {
            case 1:
                this.ifD.startLoad(aoVar.ahC().get(0).thumbnailUrl, 10, false);
                this.ifD.setVisibility(0);
                this.ifE.setVisibility(8);
                this.ifF.setVisibility(8);
                this.ifG.setVisibility(8);
                break;
            case 2:
                this.ifD.startLoad(aoVar.ahC().get(0).thumbnailUrl, 10, false);
                this.ifE.startLoad(aoVar.ahC().get(1).thumbnailUrl, 10, false);
                this.ifD.setVisibility(0);
                this.ifE.setVisibility(0);
                this.ifF.setVisibility(8);
                this.ifG.setVisibility(8);
                break;
            case 3:
                this.ifD.startLoad(aoVar.ahC().get(0).thumbnailUrl, 10, false);
                this.ifE.startLoad(aoVar.ahC().get(1).thumbnailUrl, 10, false);
                this.ifF.startLoad(aoVar.ahC().get(2).thumbnailUrl, 10, false);
                this.ifD.setVisibility(0);
                this.ifE.setVisibility(0);
                this.ifF.setVisibility(0);
                this.ifG.setVisibility(8);
                break;
            case 4:
                this.ifD.startLoad(aoVar.ahC().get(0).thumbnailUrl, 10, false);
                this.ifE.startLoad(aoVar.ahC().get(1).thumbnailUrl, 10, false);
                this.ifF.startLoad(aoVar.ahC().get(2).thumbnailUrl, 10, false);
                this.ifG.startLoad(aoVar.ahC().get(3).thumbnailUrl, 10, false);
                this.ifD.setVisibility(0);
                this.ifE.setVisibility(0);
                this.ifF.setVisibility(0);
                this.ifG.setVisibility(0);
                break;
        }
        if (aoVar.getTotal() > 0) {
            this.ifH.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(aoVar.getTotal())));
            this.ifH.setVisibility(0);
        } else {
            this.ifH.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.ifI.setVisibility(8);
        } else {
            this.ifI.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.setViewTextColor(this.ifH, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.ifI, R.color.cp_link_tip_c, 1);
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
