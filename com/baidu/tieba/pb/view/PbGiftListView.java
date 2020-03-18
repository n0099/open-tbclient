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
    private View cus;
    private TbImageView jdO;
    private TbImageView jdP;
    private TbImageView jdQ;
    private TbImageView jdR;
    private TextView jdS;
    private TextView jdT;
    private String jdU;
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
        this.cus = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.jdO = (TbImageView) this.cus.findViewById(R.id.pb_gift_view1);
        this.jdP = (TbImageView) this.cus.findViewById(R.id.pb_gift_view2);
        this.jdQ = (TbImageView) this.cus.findViewById(R.id.pb_gift_view3);
        this.jdR = (TbImageView) this.cus.findViewById(R.id.pb_gift_view4);
        this.jdO.setDefaultBgResource(R.drawable.transparent_bg);
        this.jdP.setDefaultBgResource(R.drawable.transparent_bg);
        this.jdQ.setDefaultBgResource(R.drawable.transparent_bg);
        this.jdR.setDefaultBgResource(R.drawable.transparent_bg);
        this.jdO.setDefaultResource(R.drawable.icon_gift_moren);
        this.jdP.setDefaultResource(R.drawable.icon_gift_moren);
        this.jdQ.setDefaultResource(R.drawable.icon_gift_moren);
        this.jdR.setDefaultResource(R.drawable.icon_gift_moren);
        this.jdS = (TextView) this.cus.findViewById(R.id.pb_gift_number_view);
        this.jdT = (TextView) this.cus.findViewById(R.id.pb_gift_send_view);
        this.jdT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.ab(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.jdU, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
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
        this.jdU = str2;
        this.postId = j3;
        this.threadId = j2;
        if (arVar == null || arVar.aBp() == null || arVar.aBp().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (arVar.aBp().size() > 4 ? 4 : arVar.aBp().size()) {
            case 1:
                this.jdO.startLoad(arVar.aBp().get(0).thumbnailUrl, 10, false);
                this.jdO.setVisibility(0);
                this.jdP.setVisibility(8);
                this.jdQ.setVisibility(8);
                this.jdR.setVisibility(8);
                break;
            case 2:
                this.jdO.startLoad(arVar.aBp().get(0).thumbnailUrl, 10, false);
                this.jdP.startLoad(arVar.aBp().get(1).thumbnailUrl, 10, false);
                this.jdO.setVisibility(0);
                this.jdP.setVisibility(0);
                this.jdQ.setVisibility(8);
                this.jdR.setVisibility(8);
                break;
            case 3:
                this.jdO.startLoad(arVar.aBp().get(0).thumbnailUrl, 10, false);
                this.jdP.startLoad(arVar.aBp().get(1).thumbnailUrl, 10, false);
                this.jdQ.startLoad(arVar.aBp().get(2).thumbnailUrl, 10, false);
                this.jdO.setVisibility(0);
                this.jdP.setVisibility(0);
                this.jdQ.setVisibility(0);
                this.jdR.setVisibility(8);
                break;
            case 4:
                this.jdO.startLoad(arVar.aBp().get(0).thumbnailUrl, 10, false);
                this.jdP.startLoad(arVar.aBp().get(1).thumbnailUrl, 10, false);
                this.jdQ.startLoad(arVar.aBp().get(2).thumbnailUrl, 10, false);
                this.jdR.startLoad(arVar.aBp().get(3).thumbnailUrl, 10, false);
                this.jdO.setVisibility(0);
                this.jdP.setVisibility(0);
                this.jdQ.setVisibility(0);
                this.jdR.setVisibility(0);
                break;
        }
        if (arVar.getTotal() > 0) {
            this.jdS.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(arVar.getTotal())));
            this.jdS.setVisibility(0);
        } else {
            this.jdS.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.jdT.setVisibility(8);
        } else {
            this.jdT.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.setViewTextColor(this.jdS, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.jdT, R.color.cp_link_tip_c, 1);
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
