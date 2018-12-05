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
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class PbGiftListView extends FrameLayout {
    private View bRX;
    private TbImageView glJ;
    private TbImageView glK;
    private TbImageView glL;
    private TbImageView glM;
    private TextView glN;
    private TextView glO;
    private String glP;
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
        this.bRX = View.inflate(this.mContext, e.h.pb_gift_list_item, this);
        this.glJ = (TbImageView) this.bRX.findViewById(e.g.pb_gift_view1);
        this.glK = (TbImageView) this.bRX.findViewById(e.g.pb_gift_view2);
        this.glL = (TbImageView) this.bRX.findViewById(e.g.pb_gift_view3);
        this.glM = (TbImageView) this.bRX.findViewById(e.g.pb_gift_view4);
        this.glJ.setDefaultBgResource(e.f.transparent_bg);
        this.glK.setDefaultBgResource(e.f.transparent_bg);
        this.glL.setDefaultBgResource(e.f.transparent_bg);
        this.glM.setDefaultBgResource(e.f.transparent_bg);
        this.glJ.setDefaultResource(e.f.icon_gift_moren);
        this.glK.setDefaultResource(e.f.icon_gift_moren);
        this.glL.setDefaultResource(e.f.icon_gift_moren);
        this.glM.setDefaultResource(e.f.icon_gift_moren);
        this.glN = (TextView) this.bRX.findViewById(e.g.pb_gift_number_view);
        this.glO = (TextView) this.bRX.findViewById(e.g.pb_gift_send_view);
        this.glO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.aK(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.glP, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ba.bJ(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(am amVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.glP = str2;
        this.postId = j3;
        this.threadId = j2;
        if (amVar == null || amVar.yR() == null || amVar.yR().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (amVar.yR().size() > 4 ? 4 : amVar.yR().size()) {
            case 1:
                this.glJ.startLoad(amVar.yR().get(0).thumbnailUrl, 10, false);
                this.glJ.setVisibility(0);
                this.glK.setVisibility(8);
                this.glL.setVisibility(8);
                this.glM.setVisibility(8);
                break;
            case 2:
                this.glJ.startLoad(amVar.yR().get(0).thumbnailUrl, 10, false);
                this.glK.startLoad(amVar.yR().get(1).thumbnailUrl, 10, false);
                this.glJ.setVisibility(0);
                this.glK.setVisibility(0);
                this.glL.setVisibility(8);
                this.glM.setVisibility(8);
                break;
            case 3:
                this.glJ.startLoad(amVar.yR().get(0).thumbnailUrl, 10, false);
                this.glK.startLoad(amVar.yR().get(1).thumbnailUrl, 10, false);
                this.glL.startLoad(amVar.yR().get(2).thumbnailUrl, 10, false);
                this.glJ.setVisibility(0);
                this.glK.setVisibility(0);
                this.glL.setVisibility(0);
                this.glM.setVisibility(8);
                break;
            case 4:
                this.glJ.startLoad(amVar.yR().get(0).thumbnailUrl, 10, false);
                this.glK.startLoad(amVar.yR().get(1).thumbnailUrl, 10, false);
                this.glL.startLoad(amVar.yR().get(2).thumbnailUrl, 10, false);
                this.glM.startLoad(amVar.yR().get(3).thumbnailUrl, 10, false);
                this.glJ.setVisibility(0);
                this.glK.setVisibility(0);
                this.glL.setVisibility(0);
                this.glM.setVisibility(0);
                break;
        }
        if (amVar.getTotal() > 0) {
            this.glN.setText(String.format(this.mContext.getResources().getString(e.j.gift_counts), Integer.valueOf(amVar.getTotal())));
            this.glN.setVisibility(0);
        } else {
            this.glN.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.glO.setVisibility(8);
        } else {
            this.glO.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            al.c(this.glN, e.d.cp_cont_d, 1);
            al.c(this.glO, e.d.cp_link_tip_c, 1);
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
