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
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbGiftListView extends FrameLayout {
    private View elg;
    private Context mContext;
    private int mSkinType;
    private TbImageView mfn;
    private TbImageView mfo;
    private TbImageView mfp;
    private TbImageView mfq;
    private TextView mfr;
    private TextView mfs;
    private String mft;
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
        this.elg = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.mfn = (TbImageView) this.elg.findViewById(R.id.pb_gift_view1);
        this.mfo = (TbImageView) this.elg.findViewById(R.id.pb_gift_view2);
        this.mfp = (TbImageView) this.elg.findViewById(R.id.pb_gift_view3);
        this.mfq = (TbImageView) this.elg.findViewById(R.id.pb_gift_view4);
        this.mfn.setDefaultBgResource(R.drawable.transparent_bg);
        this.mfo.setDefaultBgResource(R.drawable.transparent_bg);
        this.mfp.setDefaultBgResource(R.drawable.transparent_bg);
        this.mfq.setDefaultBgResource(R.drawable.transparent_bg);
        this.mfn.setDefaultResource(R.drawable.icon_gift_moren);
        this.mfo.setDefaultResource(R.drawable.icon_gift_moren);
        this.mfp.setDefaultResource(R.drawable.icon_gift_moren);
        this.mfq.setDefaultResource(R.drawable.icon_gift_moren);
        this.mfr = (TextView) this.elg.findViewById(R.id.pb_gift_number_view);
        this.mfs = (TextView) this.elg.findViewById(R.id.pb_gift_send_view);
        this.mfs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) j.K(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.mft, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bg.checkUpIsLogin(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(az azVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.mft = str2;
        this.postId = j3;
        this.threadId = j2;
        if (azVar == null || azVar.bmo() == null || azVar.bmo().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (azVar.bmo().size() > 4 ? 4 : azVar.bmo().size()) {
            case 1:
                this.mfn.startLoad(azVar.bmo().get(0).thumbnailUrl, 10, false);
                this.mfn.setVisibility(0);
                this.mfo.setVisibility(8);
                this.mfp.setVisibility(8);
                this.mfq.setVisibility(8);
                break;
            case 2:
                this.mfn.startLoad(azVar.bmo().get(0).thumbnailUrl, 10, false);
                this.mfo.startLoad(azVar.bmo().get(1).thumbnailUrl, 10, false);
                this.mfn.setVisibility(0);
                this.mfo.setVisibility(0);
                this.mfp.setVisibility(8);
                this.mfq.setVisibility(8);
                break;
            case 3:
                this.mfn.startLoad(azVar.bmo().get(0).thumbnailUrl, 10, false);
                this.mfo.startLoad(azVar.bmo().get(1).thumbnailUrl, 10, false);
                this.mfp.startLoad(azVar.bmo().get(2).thumbnailUrl, 10, false);
                this.mfn.setVisibility(0);
                this.mfo.setVisibility(0);
                this.mfp.setVisibility(0);
                this.mfq.setVisibility(8);
                break;
            case 4:
                this.mfn.startLoad(azVar.bmo().get(0).thumbnailUrl, 10, false);
                this.mfo.startLoad(azVar.bmo().get(1).thumbnailUrl, 10, false);
                this.mfp.startLoad(azVar.bmo().get(2).thumbnailUrl, 10, false);
                this.mfq.startLoad(azVar.bmo().get(3).thumbnailUrl, 10, false);
                this.mfn.setVisibility(0);
                this.mfo.setVisibility(0);
                this.mfp.setVisibility(0);
                this.mfq.setVisibility(0);
                break;
        }
        if (azVar.getTotal() > 0) {
            this.mfr.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(azVar.getTotal())));
            this.mfr.setVisibility(0);
        } else {
            this.mfr.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.mfs.setVisibility(8);
        } else {
            this.mfs.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ao.setViewTextColor(this.mfr, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.mfs, R.color.CAM_X0304, 1);
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
