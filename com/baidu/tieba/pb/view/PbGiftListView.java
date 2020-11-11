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
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class PbGiftListView extends FrameLayout {
    private View ebB;
    private TbImageView lQm;
    private TbImageView lQn;
    private TbImageView lQo;
    private TbImageView lQp;
    private TextView lQq;
    private TextView lQr;
    private String lQs;
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
        this.ebB = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.lQm = (TbImageView) this.ebB.findViewById(R.id.pb_gift_view1);
        this.lQn = (TbImageView) this.ebB.findViewById(R.id.pb_gift_view2);
        this.lQo = (TbImageView) this.ebB.findViewById(R.id.pb_gift_view3);
        this.lQp = (TbImageView) this.ebB.findViewById(R.id.pb_gift_view4);
        this.lQm.setDefaultBgResource(R.drawable.transparent_bg);
        this.lQn.setDefaultBgResource(R.drawable.transparent_bg);
        this.lQo.setDefaultBgResource(R.drawable.transparent_bg);
        this.lQp.setDefaultBgResource(R.drawable.transparent_bg);
        this.lQm.setDefaultResource(R.drawable.icon_gift_moren);
        this.lQn.setDefaultResource(R.drawable.icon_gift_moren);
        this.lQo.setDefaultResource(R.drawable.icon_gift_moren);
        this.lQp.setDefaultResource(R.drawable.icon_gift_moren);
        this.lQq = (TextView) this.ebB.findViewById(R.id.pb_gift_number_view);
        this.lQr = (TextView) this.ebB.findViewById(R.id.pb_gift_send_view);
        this.lQr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.I(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.lQs, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bg.checkUpIsLogin(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(ax axVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.lQs = str2;
        this.postId = j3;
        this.threadId = j2;
        if (axVar == null || axVar.bls() == null || axVar.bls().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (axVar.bls().size() > 4 ? 4 : axVar.bls().size()) {
            case 1:
                this.lQm.startLoad(axVar.bls().get(0).thumbnailUrl, 10, false);
                this.lQm.setVisibility(0);
                this.lQn.setVisibility(8);
                this.lQo.setVisibility(8);
                this.lQp.setVisibility(8);
                break;
            case 2:
                this.lQm.startLoad(axVar.bls().get(0).thumbnailUrl, 10, false);
                this.lQn.startLoad(axVar.bls().get(1).thumbnailUrl, 10, false);
                this.lQm.setVisibility(0);
                this.lQn.setVisibility(0);
                this.lQo.setVisibility(8);
                this.lQp.setVisibility(8);
                break;
            case 3:
                this.lQm.startLoad(axVar.bls().get(0).thumbnailUrl, 10, false);
                this.lQn.startLoad(axVar.bls().get(1).thumbnailUrl, 10, false);
                this.lQo.startLoad(axVar.bls().get(2).thumbnailUrl, 10, false);
                this.lQm.setVisibility(0);
                this.lQn.setVisibility(0);
                this.lQo.setVisibility(0);
                this.lQp.setVisibility(8);
                break;
            case 4:
                this.lQm.startLoad(axVar.bls().get(0).thumbnailUrl, 10, false);
                this.lQn.startLoad(axVar.bls().get(1).thumbnailUrl, 10, false);
                this.lQo.startLoad(axVar.bls().get(2).thumbnailUrl, 10, false);
                this.lQp.startLoad(axVar.bls().get(3).thumbnailUrl, 10, false);
                this.lQm.setVisibility(0);
                this.lQn.setVisibility(0);
                this.lQo.setVisibility(0);
                this.lQp.setVisibility(0);
                break;
        }
        if (axVar.getTotal() > 0) {
            this.lQq.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(axVar.getTotal())));
            this.lQq.setVisibility(0);
        } else {
            this.lQq.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.lQr.setVisibility(8);
        } else {
            this.lQr.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ap.setViewTextColor(this.lQq, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.lQr, R.color.cp_link_tip_c, 1);
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
