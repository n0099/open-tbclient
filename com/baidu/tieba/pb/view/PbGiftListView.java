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
    private View bFk;
    private TbImageView ieM;
    private TbImageView ieN;
    private TbImageView ieO;
    private TbImageView ieP;
    private TextView ieQ;
    private TextView ieR;
    private String ieS;
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
        this.bFk = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.ieM = (TbImageView) this.bFk.findViewById(R.id.pb_gift_view1);
        this.ieN = (TbImageView) this.bFk.findViewById(R.id.pb_gift_view2);
        this.ieO = (TbImageView) this.bFk.findViewById(R.id.pb_gift_view3);
        this.ieP = (TbImageView) this.bFk.findViewById(R.id.pb_gift_view4);
        this.ieM.setDefaultBgResource(R.drawable.transparent_bg);
        this.ieN.setDefaultBgResource(R.drawable.transparent_bg);
        this.ieO.setDefaultBgResource(R.drawable.transparent_bg);
        this.ieP.setDefaultBgResource(R.drawable.transparent_bg);
        this.ieM.setDefaultResource(R.drawable.icon_gift_moren);
        this.ieN.setDefaultResource(R.drawable.icon_gift_moren);
        this.ieO.setDefaultResource(R.drawable.icon_gift_moren);
        this.ieP.setDefaultResource(R.drawable.icon_gift_moren);
        this.ieQ = (TextView) this.bFk.findViewById(R.id.pb_gift_number_view);
        this.ieR = (TextView) this.bFk.findViewById(R.id.pb_gift_send_view);
        this.ieR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.ab(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.ieS, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
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
        this.ieS = str2;
        this.postId = j3;
        this.threadId = j2;
        if (aoVar == null || aoVar.ahA() == null || aoVar.ahA().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (aoVar.ahA().size() > 4 ? 4 : aoVar.ahA().size()) {
            case 1:
                this.ieM.startLoad(aoVar.ahA().get(0).thumbnailUrl, 10, false);
                this.ieM.setVisibility(0);
                this.ieN.setVisibility(8);
                this.ieO.setVisibility(8);
                this.ieP.setVisibility(8);
                break;
            case 2:
                this.ieM.startLoad(aoVar.ahA().get(0).thumbnailUrl, 10, false);
                this.ieN.startLoad(aoVar.ahA().get(1).thumbnailUrl, 10, false);
                this.ieM.setVisibility(0);
                this.ieN.setVisibility(0);
                this.ieO.setVisibility(8);
                this.ieP.setVisibility(8);
                break;
            case 3:
                this.ieM.startLoad(aoVar.ahA().get(0).thumbnailUrl, 10, false);
                this.ieN.startLoad(aoVar.ahA().get(1).thumbnailUrl, 10, false);
                this.ieO.startLoad(aoVar.ahA().get(2).thumbnailUrl, 10, false);
                this.ieM.setVisibility(0);
                this.ieN.setVisibility(0);
                this.ieO.setVisibility(0);
                this.ieP.setVisibility(8);
                break;
            case 4:
                this.ieM.startLoad(aoVar.ahA().get(0).thumbnailUrl, 10, false);
                this.ieN.startLoad(aoVar.ahA().get(1).thumbnailUrl, 10, false);
                this.ieO.startLoad(aoVar.ahA().get(2).thumbnailUrl, 10, false);
                this.ieP.startLoad(aoVar.ahA().get(3).thumbnailUrl, 10, false);
                this.ieM.setVisibility(0);
                this.ieN.setVisibility(0);
                this.ieO.setVisibility(0);
                this.ieP.setVisibility(0);
                break;
        }
        if (aoVar.getTotal() > 0) {
            this.ieQ.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(aoVar.getTotal())));
            this.ieQ.setVisibility(0);
        } else {
            this.ieQ.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.ieR.setVisibility(8);
        } else {
            this.ieR.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.setViewTextColor(this.ieQ, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.ieR, R.color.cp_link_tip_c, 1);
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
