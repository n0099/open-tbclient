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
    private TbImageView kJO;
    private TbImageView kJP;
    private TbImageView kJQ;
    private TbImageView kJR;
    private TextView kJS;
    private TextView kJT;
    private String kJU;
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
        this.kJO = (TbImageView) this.dpe.findViewById(R.id.pb_gift_view1);
        this.kJP = (TbImageView) this.dpe.findViewById(R.id.pb_gift_view2);
        this.kJQ = (TbImageView) this.dpe.findViewById(R.id.pb_gift_view3);
        this.kJR = (TbImageView) this.dpe.findViewById(R.id.pb_gift_view4);
        this.kJO.setDefaultBgResource(R.drawable.transparent_bg);
        this.kJP.setDefaultBgResource(R.drawable.transparent_bg);
        this.kJQ.setDefaultBgResource(R.drawable.transparent_bg);
        this.kJR.setDefaultBgResource(R.drawable.transparent_bg);
        this.kJO.setDefaultResource(R.drawable.icon_gift_moren);
        this.kJP.setDefaultResource(R.drawable.icon_gift_moren);
        this.kJQ.setDefaultResource(R.drawable.icon_gift_moren);
        this.kJR.setDefaultResource(R.drawable.icon_gift_moren);
        this.kJS = (TextView) this.dpe.findViewById(R.id.pb_gift_number_view);
        this.kJT = (TextView) this.dpe.findViewById(R.id.pb_gift_send_view);
        this.kJT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.G(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.kJU, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
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
        this.kJU = str2;
        this.postId = j3;
        this.threadId = j2;
        if (awVar == null || awVar.aVd() == null || awVar.aVd().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (awVar.aVd().size() > 4 ? 4 : awVar.aVd().size()) {
            case 1:
                this.kJO.startLoad(awVar.aVd().get(0).thumbnailUrl, 10, false);
                this.kJO.setVisibility(0);
                this.kJP.setVisibility(8);
                this.kJQ.setVisibility(8);
                this.kJR.setVisibility(8);
                break;
            case 2:
                this.kJO.startLoad(awVar.aVd().get(0).thumbnailUrl, 10, false);
                this.kJP.startLoad(awVar.aVd().get(1).thumbnailUrl, 10, false);
                this.kJO.setVisibility(0);
                this.kJP.setVisibility(0);
                this.kJQ.setVisibility(8);
                this.kJR.setVisibility(8);
                break;
            case 3:
                this.kJO.startLoad(awVar.aVd().get(0).thumbnailUrl, 10, false);
                this.kJP.startLoad(awVar.aVd().get(1).thumbnailUrl, 10, false);
                this.kJQ.startLoad(awVar.aVd().get(2).thumbnailUrl, 10, false);
                this.kJO.setVisibility(0);
                this.kJP.setVisibility(0);
                this.kJQ.setVisibility(0);
                this.kJR.setVisibility(8);
                break;
            case 4:
                this.kJO.startLoad(awVar.aVd().get(0).thumbnailUrl, 10, false);
                this.kJP.startLoad(awVar.aVd().get(1).thumbnailUrl, 10, false);
                this.kJQ.startLoad(awVar.aVd().get(2).thumbnailUrl, 10, false);
                this.kJR.startLoad(awVar.aVd().get(3).thumbnailUrl, 10, false);
                this.kJO.setVisibility(0);
                this.kJP.setVisibility(0);
                this.kJQ.setVisibility(0);
                this.kJR.setVisibility(0);
                break;
        }
        if (awVar.getTotal() > 0) {
            this.kJS.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(awVar.getTotal())));
            this.kJS.setVisibility(0);
        } else {
            this.kJS.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.kJT.setVisibility(8);
        } else {
            this.kJT.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ao.setViewTextColor(this.kJS, R.color.cp_cont_d, 1);
            ao.setViewTextColor(this.kJT, R.color.cp_link_tip_c, 1);
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
