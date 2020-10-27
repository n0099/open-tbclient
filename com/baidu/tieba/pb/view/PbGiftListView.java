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
    private View dVJ;
    private TbImageView lKq;
    private TbImageView lKr;
    private TbImageView lKs;
    private TbImageView lKt;
    private TextView lKu;
    private TextView lKv;
    private String lKw;
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
        this.dVJ = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.lKq = (TbImageView) this.dVJ.findViewById(R.id.pb_gift_view1);
        this.lKr = (TbImageView) this.dVJ.findViewById(R.id.pb_gift_view2);
        this.lKs = (TbImageView) this.dVJ.findViewById(R.id.pb_gift_view3);
        this.lKt = (TbImageView) this.dVJ.findViewById(R.id.pb_gift_view4);
        this.lKq.setDefaultBgResource(R.drawable.transparent_bg);
        this.lKr.setDefaultBgResource(R.drawable.transparent_bg);
        this.lKs.setDefaultBgResource(R.drawable.transparent_bg);
        this.lKt.setDefaultBgResource(R.drawable.transparent_bg);
        this.lKq.setDefaultResource(R.drawable.icon_gift_moren);
        this.lKr.setDefaultResource(R.drawable.icon_gift_moren);
        this.lKs.setDefaultResource(R.drawable.icon_gift_moren);
        this.lKt.setDefaultResource(R.drawable.icon_gift_moren);
        this.lKu = (TextView) this.dVJ.findViewById(R.id.pb_gift_number_view);
        this.lKv = (TextView) this.dVJ.findViewById(R.id.pb_gift_send_view);
        this.lKv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.I(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.lKw, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
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
        this.lKw = str2;
        this.postId = j3;
        this.threadId = j2;
        if (axVar == null || axVar.biS() == null || axVar.biS().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (axVar.biS().size() > 4 ? 4 : axVar.biS().size()) {
            case 1:
                this.lKq.startLoad(axVar.biS().get(0).thumbnailUrl, 10, false);
                this.lKq.setVisibility(0);
                this.lKr.setVisibility(8);
                this.lKs.setVisibility(8);
                this.lKt.setVisibility(8);
                break;
            case 2:
                this.lKq.startLoad(axVar.biS().get(0).thumbnailUrl, 10, false);
                this.lKr.startLoad(axVar.biS().get(1).thumbnailUrl, 10, false);
                this.lKq.setVisibility(0);
                this.lKr.setVisibility(0);
                this.lKs.setVisibility(8);
                this.lKt.setVisibility(8);
                break;
            case 3:
                this.lKq.startLoad(axVar.biS().get(0).thumbnailUrl, 10, false);
                this.lKr.startLoad(axVar.biS().get(1).thumbnailUrl, 10, false);
                this.lKs.startLoad(axVar.biS().get(2).thumbnailUrl, 10, false);
                this.lKq.setVisibility(0);
                this.lKr.setVisibility(0);
                this.lKs.setVisibility(0);
                this.lKt.setVisibility(8);
                break;
            case 4:
                this.lKq.startLoad(axVar.biS().get(0).thumbnailUrl, 10, false);
                this.lKr.startLoad(axVar.biS().get(1).thumbnailUrl, 10, false);
                this.lKs.startLoad(axVar.biS().get(2).thumbnailUrl, 10, false);
                this.lKt.startLoad(axVar.biS().get(3).thumbnailUrl, 10, false);
                this.lKq.setVisibility(0);
                this.lKr.setVisibility(0);
                this.lKs.setVisibility(0);
                this.lKt.setVisibility(0);
                break;
        }
        if (axVar.getTotal() > 0) {
            this.lKu.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(axVar.getTotal())));
            this.lKu.setVisibility(0);
        } else {
            this.lKu.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.lKv.setVisibility(8);
        } else {
            this.lKv.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ap.setViewTextColor(this.lKu, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.lKv, R.color.cp_link_tip_c, 1);
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
