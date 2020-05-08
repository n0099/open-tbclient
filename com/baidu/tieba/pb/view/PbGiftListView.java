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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PbGiftListView extends FrameLayout {
    private View cTu;
    private TbImageView jNZ;
    private TbImageView jOa;
    private TbImageView jOb;
    private TbImageView jOc;
    private TextView jOd;
    private TextView jOe;
    private String jOf;
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
        this.cTu = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.jNZ = (TbImageView) this.cTu.findViewById(R.id.pb_gift_view1);
        this.jOa = (TbImageView) this.cTu.findViewById(R.id.pb_gift_view2);
        this.jOb = (TbImageView) this.cTu.findViewById(R.id.pb_gift_view3);
        this.jOc = (TbImageView) this.cTu.findViewById(R.id.pb_gift_view4);
        this.jNZ.setDefaultBgResource(R.drawable.transparent_bg);
        this.jOa.setDefaultBgResource(R.drawable.transparent_bg);
        this.jOb.setDefaultBgResource(R.drawable.transparent_bg);
        this.jOc.setDefaultBgResource(R.drawable.transparent_bg);
        this.jNZ.setDefaultResource(R.drawable.icon_gift_moren);
        this.jOa.setDefaultResource(R.drawable.icon_gift_moren);
        this.jOb.setDefaultResource(R.drawable.icon_gift_moren);
        this.jOc.setDefaultResource(R.drawable.icon_gift_moren);
        this.jOd = (TextView) this.cTu.findViewById(R.id.pb_gift_number_view);
        this.jOe = (TextView) this.cTu.findViewById(R.id.pb_gift_send_view);
        this.jOe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.G(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.jOf, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bc.checkUpIsLogin(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(ar arVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.jOf = str2;
        this.postId = j3;
        this.threadId = j2;
        if (arVar == null || arVar.aJA() == null || arVar.aJA().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (arVar.aJA().size() > 4 ? 4 : arVar.aJA().size()) {
            case 1:
                this.jNZ.startLoad(arVar.aJA().get(0).thumbnailUrl, 10, false);
                this.jNZ.setVisibility(0);
                this.jOa.setVisibility(8);
                this.jOb.setVisibility(8);
                this.jOc.setVisibility(8);
                break;
            case 2:
                this.jNZ.startLoad(arVar.aJA().get(0).thumbnailUrl, 10, false);
                this.jOa.startLoad(arVar.aJA().get(1).thumbnailUrl, 10, false);
                this.jNZ.setVisibility(0);
                this.jOa.setVisibility(0);
                this.jOb.setVisibility(8);
                this.jOc.setVisibility(8);
                break;
            case 3:
                this.jNZ.startLoad(arVar.aJA().get(0).thumbnailUrl, 10, false);
                this.jOa.startLoad(arVar.aJA().get(1).thumbnailUrl, 10, false);
                this.jOb.startLoad(arVar.aJA().get(2).thumbnailUrl, 10, false);
                this.jNZ.setVisibility(0);
                this.jOa.setVisibility(0);
                this.jOb.setVisibility(0);
                this.jOc.setVisibility(8);
                break;
            case 4:
                this.jNZ.startLoad(arVar.aJA().get(0).thumbnailUrl, 10, false);
                this.jOa.startLoad(arVar.aJA().get(1).thumbnailUrl, 10, false);
                this.jOb.startLoad(arVar.aJA().get(2).thumbnailUrl, 10, false);
                this.jOc.startLoad(arVar.aJA().get(3).thumbnailUrl, 10, false);
                this.jNZ.setVisibility(0);
                this.jOa.setVisibility(0);
                this.jOb.setVisibility(0);
                this.jOc.setVisibility(0);
                break;
        }
        if (arVar.getTotal() > 0) {
            this.jOd.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(arVar.getTotal())));
            this.jOd.setVisibility(0);
        } else {
            this.jOd.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.jOe.setVisibility(8);
        } else {
            this.jOe.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.setViewTextColor(this.jOd, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.jOe, R.color.cp_link_tip_c, 1);
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
