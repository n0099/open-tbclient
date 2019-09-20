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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PbGiftListView extends FrameLayout {
    private View bnp;
    private TbImageView igT;
    private TbImageView igU;
    private TbImageView igV;
    private TbImageView igW;
    private TextView igX;
    private TextView igY;
    private String igZ;
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
        this.bnp = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.igT = (TbImageView) this.bnp.findViewById(R.id.pb_gift_view1);
        this.igU = (TbImageView) this.bnp.findViewById(R.id.pb_gift_view2);
        this.igV = (TbImageView) this.bnp.findViewById(R.id.pb_gift_view3);
        this.igW = (TbImageView) this.bnp.findViewById(R.id.pb_gift_view4);
        this.igT.setDefaultBgResource(R.drawable.transparent_bg);
        this.igU.setDefaultBgResource(R.drawable.transparent_bg);
        this.igV.setDefaultBgResource(R.drawable.transparent_bg);
        this.igW.setDefaultBgResource(R.drawable.transparent_bg);
        this.igT.setDefaultResource(R.drawable.icon_gift_moren);
        this.igU.setDefaultResource(R.drawable.icon_gift_moren);
        this.igV.setDefaultResource(R.drawable.icon_gift_moren);
        this.igW.setDefaultResource(R.drawable.icon_gift_moren);
        this.igX = (TextView) this.bnp.findViewById(R.id.pb_gift_number_view);
        this.igY = (TextView) this.bnp.findViewById(R.id.pb_gift_send_view);
        this.igY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.ab(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.igZ, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bc.cF(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(ao aoVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.igZ = str2;
        this.postId = j3;
        this.threadId = j2;
        if (aoVar == null || aoVar.ady() == null || aoVar.ady().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (aoVar.ady().size() > 4 ? 4 : aoVar.ady().size()) {
            case 1:
                this.igT.startLoad(aoVar.ady().get(0).thumbnailUrl, 10, false);
                this.igT.setVisibility(0);
                this.igU.setVisibility(8);
                this.igV.setVisibility(8);
                this.igW.setVisibility(8);
                break;
            case 2:
                this.igT.startLoad(aoVar.ady().get(0).thumbnailUrl, 10, false);
                this.igU.startLoad(aoVar.ady().get(1).thumbnailUrl, 10, false);
                this.igT.setVisibility(0);
                this.igU.setVisibility(0);
                this.igV.setVisibility(8);
                this.igW.setVisibility(8);
                break;
            case 3:
                this.igT.startLoad(aoVar.ady().get(0).thumbnailUrl, 10, false);
                this.igU.startLoad(aoVar.ady().get(1).thumbnailUrl, 10, false);
                this.igV.startLoad(aoVar.ady().get(2).thumbnailUrl, 10, false);
                this.igT.setVisibility(0);
                this.igU.setVisibility(0);
                this.igV.setVisibility(0);
                this.igW.setVisibility(8);
                break;
            case 4:
                this.igT.startLoad(aoVar.ady().get(0).thumbnailUrl, 10, false);
                this.igU.startLoad(aoVar.ady().get(1).thumbnailUrl, 10, false);
                this.igV.startLoad(aoVar.ady().get(2).thumbnailUrl, 10, false);
                this.igW.startLoad(aoVar.ady().get(3).thumbnailUrl, 10, false);
                this.igT.setVisibility(0);
                this.igU.setVisibility(0);
                this.igV.setVisibility(0);
                this.igW.setVisibility(0);
                break;
        }
        if (aoVar.getTotal() > 0) {
            this.igX.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(aoVar.getTotal())));
            this.igX.setVisibility(0);
        } else {
            this.igX.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.e(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.igY.setVisibility(8);
        } else {
            this.igY.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.f(this.igX, R.color.cp_cont_d, 1);
            am.f(this.igY, R.color.cp_link_tip_c, 1);
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
