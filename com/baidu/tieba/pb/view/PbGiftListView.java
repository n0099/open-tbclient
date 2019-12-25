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
/* loaded from: classes6.dex */
public class PbGiftListView extends FrameLayout {
    private View cpR;
    private TbImageView iWS;
    private TbImageView iWT;
    private TbImageView iWU;
    private TbImageView iWV;
    private TextView iWW;
    private TextView iWX;
    private String iWY;
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
        this.cpR = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.iWS = (TbImageView) this.cpR.findViewById(R.id.pb_gift_view1);
        this.iWT = (TbImageView) this.cpR.findViewById(R.id.pb_gift_view2);
        this.iWU = (TbImageView) this.cpR.findViewById(R.id.pb_gift_view3);
        this.iWV = (TbImageView) this.cpR.findViewById(R.id.pb_gift_view4);
        this.iWS.setDefaultBgResource(R.drawable.transparent_bg);
        this.iWT.setDefaultBgResource(R.drawable.transparent_bg);
        this.iWU.setDefaultBgResource(R.drawable.transparent_bg);
        this.iWV.setDefaultBgResource(R.drawable.transparent_bg);
        this.iWS.setDefaultResource(R.drawable.icon_gift_moren);
        this.iWT.setDefaultResource(R.drawable.icon_gift_moren);
        this.iWU.setDefaultResource(R.drawable.icon_gift_moren);
        this.iWV.setDefaultResource(R.drawable.icon_gift_moren);
        this.iWW = (TextView) this.cpR.findViewById(R.id.pb_gift_number_view);
        this.iWX = (TextView) this.cpR.findViewById(R.id.pb_gift_send_view);
        this.iWX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.ab(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.iWY, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
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
        this.iWY = str2;
        this.postId = j3;
        this.threadId = j2;
        if (arVar == null || arVar.ayA() == null || arVar.ayA().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (arVar.ayA().size() > 4 ? 4 : arVar.ayA().size()) {
            case 1:
                this.iWS.startLoad(arVar.ayA().get(0).thumbnailUrl, 10, false);
                this.iWS.setVisibility(0);
                this.iWT.setVisibility(8);
                this.iWU.setVisibility(8);
                this.iWV.setVisibility(8);
                break;
            case 2:
                this.iWS.startLoad(arVar.ayA().get(0).thumbnailUrl, 10, false);
                this.iWT.startLoad(arVar.ayA().get(1).thumbnailUrl, 10, false);
                this.iWS.setVisibility(0);
                this.iWT.setVisibility(0);
                this.iWU.setVisibility(8);
                this.iWV.setVisibility(8);
                break;
            case 3:
                this.iWS.startLoad(arVar.ayA().get(0).thumbnailUrl, 10, false);
                this.iWT.startLoad(arVar.ayA().get(1).thumbnailUrl, 10, false);
                this.iWU.startLoad(arVar.ayA().get(2).thumbnailUrl, 10, false);
                this.iWS.setVisibility(0);
                this.iWT.setVisibility(0);
                this.iWU.setVisibility(0);
                this.iWV.setVisibility(8);
                break;
            case 4:
                this.iWS.startLoad(arVar.ayA().get(0).thumbnailUrl, 10, false);
                this.iWT.startLoad(arVar.ayA().get(1).thumbnailUrl, 10, false);
                this.iWU.startLoad(arVar.ayA().get(2).thumbnailUrl, 10, false);
                this.iWV.startLoad(arVar.ayA().get(3).thumbnailUrl, 10, false);
                this.iWS.setVisibility(0);
                this.iWT.setVisibility(0);
                this.iWU.setVisibility(0);
                this.iWV.setVisibility(0);
                break;
        }
        if (arVar.getTotal() > 0) {
            this.iWW.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(arVar.getTotal())));
            this.iWW.setVisibility(0);
        } else {
            this.iWW.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.iWX.setVisibility(8);
        } else {
            this.iWX.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.setViewTextColor(this.iWW, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.iWX, R.color.cp_link_tip_c, 1);
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
