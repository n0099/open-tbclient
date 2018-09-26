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
/* loaded from: classes2.dex */
public class PbGiftListView extends FrameLayout {
    private View bES;
    private TbImageView fVU;
    private TbImageView fVV;
    private TbImageView fVW;
    private TbImageView fVX;
    private TextView fVY;
    private TextView fVZ;
    private String fWa;
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
        this.bES = View.inflate(this.mContext, e.h.pb_gift_list_item, this);
        this.fVU = (TbImageView) this.bES.findViewById(e.g.pb_gift_view1);
        this.fVV = (TbImageView) this.bES.findViewById(e.g.pb_gift_view2);
        this.fVW = (TbImageView) this.bES.findViewById(e.g.pb_gift_view3);
        this.fVX = (TbImageView) this.bES.findViewById(e.g.pb_gift_view4);
        this.fVU.setDefaultBgResource(e.f.transparent_bg);
        this.fVV.setDefaultBgResource(e.f.transparent_bg);
        this.fVW.setDefaultBgResource(e.f.transparent_bg);
        this.fVX.setDefaultBgResource(e.f.transparent_bg);
        this.fVU.setDefaultResource(e.f.icon_gift_moren);
        this.fVV.setDefaultResource(e.f.icon_gift_moren);
        this.fVW.setDefaultResource(e.f.icon_gift_moren);
        this.fVX.setDefaultResource(e.f.icon_gift_moren);
        this.fVY = (TextView) this.bES.findViewById(e.g.pb_gift_number_view);
        this.fVZ = (TextView) this.bES.findViewById(e.g.pb_gift_send_view);
        this.fVZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.aK(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.fWa, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ba.bA(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(am amVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.fWa = str2;
        this.postId = j3;
        this.threadId = j2;
        if (amVar == null || amVar.vx() == null || amVar.vx().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (amVar.vx().size() > 4 ? 4 : amVar.vx().size()) {
            case 1:
                this.fVU.startLoad(amVar.vx().get(0).thumbnailUrl, 10, false);
                this.fVU.setVisibility(0);
                this.fVV.setVisibility(8);
                this.fVW.setVisibility(8);
                this.fVX.setVisibility(8);
                break;
            case 2:
                this.fVU.startLoad(amVar.vx().get(0).thumbnailUrl, 10, false);
                this.fVV.startLoad(amVar.vx().get(1).thumbnailUrl, 10, false);
                this.fVU.setVisibility(0);
                this.fVV.setVisibility(0);
                this.fVW.setVisibility(8);
                this.fVX.setVisibility(8);
                break;
            case 3:
                this.fVU.startLoad(amVar.vx().get(0).thumbnailUrl, 10, false);
                this.fVV.startLoad(amVar.vx().get(1).thumbnailUrl, 10, false);
                this.fVW.startLoad(amVar.vx().get(2).thumbnailUrl, 10, false);
                this.fVU.setVisibility(0);
                this.fVV.setVisibility(0);
                this.fVW.setVisibility(0);
                this.fVX.setVisibility(8);
                break;
            case 4:
                this.fVU.startLoad(amVar.vx().get(0).thumbnailUrl, 10, false);
                this.fVV.startLoad(amVar.vx().get(1).thumbnailUrl, 10, false);
                this.fVW.startLoad(amVar.vx().get(2).thumbnailUrl, 10, false);
                this.fVX.startLoad(amVar.vx().get(3).thumbnailUrl, 10, false);
                this.fVU.setVisibility(0);
                this.fVV.setVisibility(0);
                this.fVW.setVisibility(0);
                this.fVX.setVisibility(0);
                break;
        }
        if (amVar.vw() > 0) {
            this.fVY.setText(String.format(this.mContext.getResources().getString(e.j.gift_counts), Integer.valueOf(amVar.vw())));
            this.fVY.setVisibility(0);
        } else {
            this.fVY.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.fVZ.setVisibility(8);
        } else {
            this.fVZ.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            al.c(this.fVY, e.d.cp_cont_d, 1);
            al.c(this.fVZ, e.d.cp_link_tip_c, 1);
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
