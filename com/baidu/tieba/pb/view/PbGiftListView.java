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
    private TbImageView moq;
    private TbImageView mor;
    private TbImageView mos;
    private TbImageView mot;
    private TextView mou;
    private TextView mov;
    private String mow;
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
        this.moq = (TbImageView) this.eno.findViewById(R.id.pb_gift_view1);
        this.mor = (TbImageView) this.eno.findViewById(R.id.pb_gift_view2);
        this.mos = (TbImageView) this.eno.findViewById(R.id.pb_gift_view3);
        this.mot = (TbImageView) this.eno.findViewById(R.id.pb_gift_view4);
        this.moq.setDefaultBgResource(R.drawable.transparent_bg);
        this.mor.setDefaultBgResource(R.drawable.transparent_bg);
        this.mos.setDefaultBgResource(R.drawable.transparent_bg);
        this.mot.setDefaultBgResource(R.drawable.transparent_bg);
        this.moq.setDefaultResource(R.drawable.icon_gift_moren);
        this.mor.setDefaultResource(R.drawable.icon_gift_moren);
        this.mos.setDefaultResource(R.drawable.icon_gift_moren);
        this.mot.setDefaultResource(R.drawable.icon_gift_moren);
        this.mou = (TextView) this.eno.findViewById(R.id.pb_gift_number_view);
        this.mov = (TextView) this.eno.findViewById(R.id.pb_gift_send_view);
        this.mov.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) j.K(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.mow, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
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
        this.mow = str2;
        this.postId = j3;
        this.threadId = j2;
        if (bbVar == null || bbVar.bmH() == null || bbVar.bmH().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (bbVar.bmH().size() > 4 ? 4 : bbVar.bmH().size()) {
            case 1:
                this.moq.startLoad(bbVar.bmH().get(0).thumbnailUrl, 10, false);
                this.moq.setVisibility(0);
                this.mor.setVisibility(8);
                this.mos.setVisibility(8);
                this.mot.setVisibility(8);
                break;
            case 2:
                this.moq.startLoad(bbVar.bmH().get(0).thumbnailUrl, 10, false);
                this.mor.startLoad(bbVar.bmH().get(1).thumbnailUrl, 10, false);
                this.moq.setVisibility(0);
                this.mor.setVisibility(0);
                this.mos.setVisibility(8);
                this.mot.setVisibility(8);
                break;
            case 3:
                this.moq.startLoad(bbVar.bmH().get(0).thumbnailUrl, 10, false);
                this.mor.startLoad(bbVar.bmH().get(1).thumbnailUrl, 10, false);
                this.mos.startLoad(bbVar.bmH().get(2).thumbnailUrl, 10, false);
                this.moq.setVisibility(0);
                this.mor.setVisibility(0);
                this.mos.setVisibility(0);
                this.mot.setVisibility(8);
                break;
            case 4:
                this.moq.startLoad(bbVar.bmH().get(0).thumbnailUrl, 10, false);
                this.mor.startLoad(bbVar.bmH().get(1).thumbnailUrl, 10, false);
                this.mos.startLoad(bbVar.bmH().get(2).thumbnailUrl, 10, false);
                this.mot.startLoad(bbVar.bmH().get(3).thumbnailUrl, 10, false);
                this.moq.setVisibility(0);
                this.mor.setVisibility(0);
                this.mos.setVisibility(0);
                this.mot.setVisibility(0);
                break;
        }
        if (bbVar.getTotal() > 0) {
            this.mou.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(bbVar.getTotal())));
            this.mou.setVisibility(0);
        } else {
            this.mou.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.mov.setVisibility(8);
        } else {
            this.mov.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            ap.setViewTextColor(this.mou, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.mov, R.color.CAM_X0304, 1);
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
