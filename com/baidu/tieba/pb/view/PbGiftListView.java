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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PbGiftListView extends FrameLayout {
    private View dex;
    private TbImageView kfR;
    private TbImageView kfS;
    private TbImageView kfT;
    private TbImageView kfU;
    private TextView kfV;
    private TextView kfW;
    private String kfX;
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
        this.dex = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.kfR = (TbImageView) this.dex.findViewById(R.id.pb_gift_view1);
        this.kfS = (TbImageView) this.dex.findViewById(R.id.pb_gift_view2);
        this.kfT = (TbImageView) this.dex.findViewById(R.id.pb_gift_view3);
        this.kfU = (TbImageView) this.dex.findViewById(R.id.pb_gift_view4);
        this.kfR.setDefaultBgResource(R.drawable.transparent_bg);
        this.kfS.setDefaultBgResource(R.drawable.transparent_bg);
        this.kfT.setDefaultBgResource(R.drawable.transparent_bg);
        this.kfU.setDefaultBgResource(R.drawable.transparent_bg);
        this.kfR.setDefaultResource(R.drawable.icon_gift_moren);
        this.kfS.setDefaultResource(R.drawable.icon_gift_moren);
        this.kfT.setDefaultResource(R.drawable.icon_gift_moren);
        this.kfU.setDefaultResource(R.drawable.icon_gift_moren);
        this.kfV = (TextView) this.dex.findViewById(R.id.pb_gift_number_view);
        this.kfW = (TextView) this.dex.findViewById(R.id.pb_gift_send_view);
        this.kfW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.G(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.kfX, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bc.checkUpIsLogin(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(aq aqVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.kfX = str2;
        this.postId = j3;
        this.threadId = j2;
        if (aqVar == null || aqVar.aPv() == null || aqVar.aPv().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (aqVar.aPv().size() > 4 ? 4 : aqVar.aPv().size()) {
            case 1:
                this.kfR.startLoad(aqVar.aPv().get(0).thumbnailUrl, 10, false);
                this.kfR.setVisibility(0);
                this.kfS.setVisibility(8);
                this.kfT.setVisibility(8);
                this.kfU.setVisibility(8);
                break;
            case 2:
                this.kfR.startLoad(aqVar.aPv().get(0).thumbnailUrl, 10, false);
                this.kfS.startLoad(aqVar.aPv().get(1).thumbnailUrl, 10, false);
                this.kfR.setVisibility(0);
                this.kfS.setVisibility(0);
                this.kfT.setVisibility(8);
                this.kfU.setVisibility(8);
                break;
            case 3:
                this.kfR.startLoad(aqVar.aPv().get(0).thumbnailUrl, 10, false);
                this.kfS.startLoad(aqVar.aPv().get(1).thumbnailUrl, 10, false);
                this.kfT.startLoad(aqVar.aPv().get(2).thumbnailUrl, 10, false);
                this.kfR.setVisibility(0);
                this.kfS.setVisibility(0);
                this.kfT.setVisibility(0);
                this.kfU.setVisibility(8);
                break;
            case 4:
                this.kfR.startLoad(aqVar.aPv().get(0).thumbnailUrl, 10, false);
                this.kfS.startLoad(aqVar.aPv().get(1).thumbnailUrl, 10, false);
                this.kfT.startLoad(aqVar.aPv().get(2).thumbnailUrl, 10, false);
                this.kfU.startLoad(aqVar.aPv().get(3).thumbnailUrl, 10, false);
                this.kfR.setVisibility(0);
                this.kfS.setVisibility(0);
                this.kfT.setVisibility(0);
                this.kfU.setVisibility(0);
                break;
        }
        if (aqVar.getTotal() > 0) {
            this.kfV.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(aqVar.getTotal())));
            this.kfV.setVisibility(0);
        } else {
            this.kfV.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.kfW.setVisibility(8);
        } else {
            this.kfW.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.setViewTextColor(this.kfV, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.kfW, R.color.cp_link_tip_c, 1);
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
