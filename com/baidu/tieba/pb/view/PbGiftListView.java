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
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class PbGiftListView extends FrameLayout {
    private View dpe;
    private TbImageView kJM;
    private TbImageView kJN;
    private TbImageView kJO;
    private TbImageView kJP;
    private TextView kJQ;
    private TextView kJR;
    private String kJS;
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
        this.dpe = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.kJM = (TbImageView) this.dpe.findViewById(R.id.pb_gift_view1);
        this.kJN = (TbImageView) this.dpe.findViewById(R.id.pb_gift_view2);
        this.kJO = (TbImageView) this.dpe.findViewById(R.id.pb_gift_view3);
        this.kJP = (TbImageView) this.dpe.findViewById(R.id.pb_gift_view4);
        this.kJM.setDefaultBgResource(R.drawable.transparent_bg);
        this.kJN.setDefaultBgResource(R.drawable.transparent_bg);
        this.kJO.setDefaultBgResource(R.drawable.transparent_bg);
        this.kJP.setDefaultBgResource(R.drawable.transparent_bg);
        this.kJM.setDefaultResource(R.drawable.icon_gift_moren);
        this.kJN.setDefaultResource(R.drawable.icon_gift_moren);
        this.kJO.setDefaultResource(R.drawable.icon_gift_moren);
        this.kJP.setDefaultResource(R.drawable.icon_gift_moren);
        this.kJQ = (TextView) this.dpe.findViewById(R.id.pb_gift_number_view);
        this.kJR = (TextView) this.dpe.findViewById(R.id.pb_gift_send_view);
        this.kJR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.G(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.kJS, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bf.checkUpIsLogin(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(aw awVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.kJS = str2;
        this.postId = j3;
        this.threadId = j2;
        if (awVar == null || awVar.aVd() == null || awVar.aVd().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (awVar.aVd().size() > 4 ? 4 : awVar.aVd().size()) {
            case 1:
                this.kJM.startLoad(awVar.aVd().get(0).thumbnailUrl, 10, false);
                this.kJM.setVisibility(0);
                this.kJN.setVisibility(8);
                this.kJO.setVisibility(8);
                this.kJP.setVisibility(8);
                break;
            case 2:
                this.kJM.startLoad(awVar.aVd().get(0).thumbnailUrl, 10, false);
                this.kJN.startLoad(awVar.aVd().get(1).thumbnailUrl, 10, false);
                this.kJM.setVisibility(0);
                this.kJN.setVisibility(0);
                this.kJO.setVisibility(8);
                this.kJP.setVisibility(8);
                break;
            case 3:
                this.kJM.startLoad(awVar.aVd().get(0).thumbnailUrl, 10, false);
                this.kJN.startLoad(awVar.aVd().get(1).thumbnailUrl, 10, false);
                this.kJO.startLoad(awVar.aVd().get(2).thumbnailUrl, 10, false);
                this.kJM.setVisibility(0);
                this.kJN.setVisibility(0);
                this.kJO.setVisibility(0);
                this.kJP.setVisibility(8);
                break;
            case 4:
                this.kJM.startLoad(awVar.aVd().get(0).thumbnailUrl, 10, false);
                this.kJN.startLoad(awVar.aVd().get(1).thumbnailUrl, 10, false);
                this.kJO.startLoad(awVar.aVd().get(2).thumbnailUrl, 10, false);
                this.kJP.startLoad(awVar.aVd().get(3).thumbnailUrl, 10, false);
                this.kJM.setVisibility(0);
                this.kJN.setVisibility(0);
                this.kJO.setVisibility(0);
                this.kJP.setVisibility(0);
                break;
        }
        if (awVar.getTotal() > 0) {
            this.kJQ.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(awVar.getTotal())));
            this.kJQ.setVisibility(0);
        } else {
            this.kJQ.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.kJR.setVisibility(8);
        } else {
            this.kJR.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ao.setViewTextColor(this.kJQ, R.color.cp_cont_d, 1);
            ao.setViewTextColor(this.kJR, R.color.cp_link_tip_c, 1);
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
