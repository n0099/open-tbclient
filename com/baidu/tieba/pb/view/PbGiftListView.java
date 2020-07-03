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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PbGiftListView extends FrameLayout {
    private View djj;
    private TbImageView kAK;
    private TbImageView kAL;
    private TbImageView kAM;
    private TbImageView kAN;
    private TextView kAO;
    private TextView kAP;
    private String kAQ;
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
        this.djj = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.kAK = (TbImageView) this.djj.findViewById(R.id.pb_gift_view1);
        this.kAL = (TbImageView) this.djj.findViewById(R.id.pb_gift_view2);
        this.kAM = (TbImageView) this.djj.findViewById(R.id.pb_gift_view3);
        this.kAN = (TbImageView) this.djj.findViewById(R.id.pb_gift_view4);
        this.kAK.setDefaultBgResource(R.drawable.transparent_bg);
        this.kAL.setDefaultBgResource(R.drawable.transparent_bg);
        this.kAM.setDefaultBgResource(R.drawable.transparent_bg);
        this.kAN.setDefaultBgResource(R.drawable.transparent_bg);
        this.kAK.setDefaultResource(R.drawable.icon_gift_moren);
        this.kAL.setDefaultResource(R.drawable.icon_gift_moren);
        this.kAM.setDefaultResource(R.drawable.icon_gift_moren);
        this.kAN.setDefaultResource(R.drawable.icon_gift_moren);
        this.kAO = (TextView) this.djj.findViewById(R.id.pb_gift_number_view);
        this.kAP = (TextView) this.djj.findViewById(R.id.pb_gift_send_view);
        this.kAP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.G(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.kAQ, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    be.checkUpIsLogin(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(av avVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.kAQ = str2;
        this.postId = j3;
        this.threadId = j2;
        if (avVar == null || avVar.aRh() == null || avVar.aRh().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (avVar.aRh().size() > 4 ? 4 : avVar.aRh().size()) {
            case 1:
                this.kAK.startLoad(avVar.aRh().get(0).thumbnailUrl, 10, false);
                this.kAK.setVisibility(0);
                this.kAL.setVisibility(8);
                this.kAM.setVisibility(8);
                this.kAN.setVisibility(8);
                break;
            case 2:
                this.kAK.startLoad(avVar.aRh().get(0).thumbnailUrl, 10, false);
                this.kAL.startLoad(avVar.aRh().get(1).thumbnailUrl, 10, false);
                this.kAK.setVisibility(0);
                this.kAL.setVisibility(0);
                this.kAM.setVisibility(8);
                this.kAN.setVisibility(8);
                break;
            case 3:
                this.kAK.startLoad(avVar.aRh().get(0).thumbnailUrl, 10, false);
                this.kAL.startLoad(avVar.aRh().get(1).thumbnailUrl, 10, false);
                this.kAM.startLoad(avVar.aRh().get(2).thumbnailUrl, 10, false);
                this.kAK.setVisibility(0);
                this.kAL.setVisibility(0);
                this.kAM.setVisibility(0);
                this.kAN.setVisibility(8);
                break;
            case 4:
                this.kAK.startLoad(avVar.aRh().get(0).thumbnailUrl, 10, false);
                this.kAL.startLoad(avVar.aRh().get(1).thumbnailUrl, 10, false);
                this.kAM.startLoad(avVar.aRh().get(2).thumbnailUrl, 10, false);
                this.kAN.startLoad(avVar.aRh().get(3).thumbnailUrl, 10, false);
                this.kAK.setVisibility(0);
                this.kAL.setVisibility(0);
                this.kAM.setVisibility(0);
                this.kAN.setVisibility(0);
                break;
        }
        if (avVar.getTotal() > 0) {
            this.kAO.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(avVar.getTotal())));
            this.kAO.setVisibility(0);
        } else {
            this.kAO.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.kAP.setVisibility(8);
        } else {
            this.kAP.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            an.setViewTextColor(this.kAO, R.color.cp_cont_d, 1);
            an.setViewTextColor(this.kAP, R.color.cp_link_tip_c, 1);
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
