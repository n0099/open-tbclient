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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbGiftListView extends FrameLayout {
    private View eno;
    private Context mContext;
    private int mSkinType;
    private TbImageView moF;
    private TbImageView moG;
    private TbImageView moH;
    private TbImageView moI;
    private TextView moJ;
    private TextView moK;
    private String moL;
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
        this.eno = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.moF = (TbImageView) this.eno.findViewById(R.id.pb_gift_view1);
        this.moG = (TbImageView) this.eno.findViewById(R.id.pb_gift_view2);
        this.moH = (TbImageView) this.eno.findViewById(R.id.pb_gift_view3);
        this.moI = (TbImageView) this.eno.findViewById(R.id.pb_gift_view4);
        this.moF.setDefaultBgResource(R.drawable.transparent_bg);
        this.moG.setDefaultBgResource(R.drawable.transparent_bg);
        this.moH.setDefaultBgResource(R.drawable.transparent_bg);
        this.moI.setDefaultBgResource(R.drawable.transparent_bg);
        this.moF.setDefaultResource(R.drawable.icon_gift_moren);
        this.moG.setDefaultResource(R.drawable.icon_gift_moren);
        this.moH.setDefaultResource(R.drawable.icon_gift_moren);
        this.moI.setDefaultResource(R.drawable.icon_gift_moren);
        this.moJ = (TextView) this.eno.findViewById(R.id.pb_gift_number_view);
        this.moK = (TextView) this.eno.findViewById(R.id.pb_gift_send_view);
        this.moK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) j.K(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.moL, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bh.checkUpIsLogin(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(bb bbVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.moL = str2;
        this.postId = j3;
        this.threadId = j2;
        if (bbVar == null || bbVar.bmH() == null || bbVar.bmH().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (bbVar.bmH().size() > 4 ? 4 : bbVar.bmH().size()) {
            case 1:
                this.moF.startLoad(bbVar.bmH().get(0).thumbnailUrl, 10, false);
                this.moF.setVisibility(0);
                this.moG.setVisibility(8);
                this.moH.setVisibility(8);
                this.moI.setVisibility(8);
                break;
            case 2:
                this.moF.startLoad(bbVar.bmH().get(0).thumbnailUrl, 10, false);
                this.moG.startLoad(bbVar.bmH().get(1).thumbnailUrl, 10, false);
                this.moF.setVisibility(0);
                this.moG.setVisibility(0);
                this.moH.setVisibility(8);
                this.moI.setVisibility(8);
                break;
            case 3:
                this.moF.startLoad(bbVar.bmH().get(0).thumbnailUrl, 10, false);
                this.moG.startLoad(bbVar.bmH().get(1).thumbnailUrl, 10, false);
                this.moH.startLoad(bbVar.bmH().get(2).thumbnailUrl, 10, false);
                this.moF.setVisibility(0);
                this.moG.setVisibility(0);
                this.moH.setVisibility(0);
                this.moI.setVisibility(8);
                break;
            case 4:
                this.moF.startLoad(bbVar.bmH().get(0).thumbnailUrl, 10, false);
                this.moG.startLoad(bbVar.bmH().get(1).thumbnailUrl, 10, false);
                this.moH.startLoad(bbVar.bmH().get(2).thumbnailUrl, 10, false);
                this.moI.startLoad(bbVar.bmH().get(3).thumbnailUrl, 10, false);
                this.moF.setVisibility(0);
                this.moG.setVisibility(0);
                this.moH.setVisibility(0);
                this.moI.setVisibility(0);
                break;
        }
        if (bbVar.getTotal() > 0) {
            this.moJ.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(bbVar.getTotal())));
            this.moJ.setVisibility(0);
        } else {
            this.moJ.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.moK.setVisibility(8);
        } else {
            this.moK.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ap.setViewTextColor(this.moJ, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.moK, R.color.CAM_X0304, 1);
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
