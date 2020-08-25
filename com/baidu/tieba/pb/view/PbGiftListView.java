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
/* loaded from: classes16.dex */
public class PbGiftListView extends FrameLayout {
    private View dzg;
    private TbImageView kZC;
    private TbImageView kZD;
    private TbImageView kZE;
    private TbImageView kZF;
    private TextView kZG;
    private TextView kZH;
    private String kZI;
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
        this.dzg = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.kZC = (TbImageView) this.dzg.findViewById(R.id.pb_gift_view1);
        this.kZD = (TbImageView) this.dzg.findViewById(R.id.pb_gift_view2);
        this.kZE = (TbImageView) this.dzg.findViewById(R.id.pb_gift_view3);
        this.kZF = (TbImageView) this.dzg.findViewById(R.id.pb_gift_view4);
        this.kZC.setDefaultBgResource(R.drawable.transparent_bg);
        this.kZD.setDefaultBgResource(R.drawable.transparent_bg);
        this.kZE.setDefaultBgResource(R.drawable.transparent_bg);
        this.kZF.setDefaultBgResource(R.drawable.transparent_bg);
        this.kZC.setDefaultResource(R.drawable.icon_gift_moren);
        this.kZD.setDefaultResource(R.drawable.icon_gift_moren);
        this.kZE.setDefaultResource(R.drawable.icon_gift_moren);
        this.kZF.setDefaultResource(R.drawable.icon_gift_moren);
        this.kZG = (TextView) this.dzg.findViewById(R.id.pb_gift_number_view);
        this.kZH = (TextView) this.dzg.findViewById(R.id.pb_gift_send_view);
        this.kZH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.I(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.kZI, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
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
        this.kZI = str2;
        this.postId = j3;
        this.threadId = j2;
        if (axVar == null || axVar.bdw() == null || axVar.bdw().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (axVar.bdw().size() > 4 ? 4 : axVar.bdw().size()) {
            case 1:
                this.kZC.startLoad(axVar.bdw().get(0).thumbnailUrl, 10, false);
                this.kZC.setVisibility(0);
                this.kZD.setVisibility(8);
                this.kZE.setVisibility(8);
                this.kZF.setVisibility(8);
                break;
            case 2:
                this.kZC.startLoad(axVar.bdw().get(0).thumbnailUrl, 10, false);
                this.kZD.startLoad(axVar.bdw().get(1).thumbnailUrl, 10, false);
                this.kZC.setVisibility(0);
                this.kZD.setVisibility(0);
                this.kZE.setVisibility(8);
                this.kZF.setVisibility(8);
                break;
            case 3:
                this.kZC.startLoad(axVar.bdw().get(0).thumbnailUrl, 10, false);
                this.kZD.startLoad(axVar.bdw().get(1).thumbnailUrl, 10, false);
                this.kZE.startLoad(axVar.bdw().get(2).thumbnailUrl, 10, false);
                this.kZC.setVisibility(0);
                this.kZD.setVisibility(0);
                this.kZE.setVisibility(0);
                this.kZF.setVisibility(8);
                break;
            case 4:
                this.kZC.startLoad(axVar.bdw().get(0).thumbnailUrl, 10, false);
                this.kZD.startLoad(axVar.bdw().get(1).thumbnailUrl, 10, false);
                this.kZE.startLoad(axVar.bdw().get(2).thumbnailUrl, 10, false);
                this.kZF.startLoad(axVar.bdw().get(3).thumbnailUrl, 10, false);
                this.kZC.setVisibility(0);
                this.kZD.setVisibility(0);
                this.kZE.setVisibility(0);
                this.kZF.setVisibility(0);
                break;
        }
        if (axVar.getTotal() > 0) {
            this.kZG.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(axVar.getTotal())));
            this.kZG.setVisibility(0);
        } else {
            this.kZG.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.kZH.setVisibility(8);
        } else {
            this.kZH.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ap.setViewTextColor(this.kZG, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.kZH, R.color.cp_link_tip_c, 1);
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
