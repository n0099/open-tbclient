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
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PbGiftListView extends FrameLayout {
    private TbImageView fNV;
    private TbImageView fNW;
    private TbImageView fNX;
    private TbImageView fNY;
    private TextView fNZ;
    private TextView fOa;
    private String fOb;
    private Context mContext;
    private int mSkinType;
    private long postId;
    private View root;
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
        this.root = View.inflate(this.mContext, d.i.pb_gift_list_item, this);
        this.fNV = (TbImageView) this.root.findViewById(d.g.pb_gift_view1);
        this.fNW = (TbImageView) this.root.findViewById(d.g.pb_gift_view2);
        this.fNX = (TbImageView) this.root.findViewById(d.g.pb_gift_view3);
        this.fNY = (TbImageView) this.root.findViewById(d.g.pb_gift_view4);
        this.fNV.setDefaultBgResource(d.f.transparent_bg);
        this.fNW.setDefaultBgResource(d.f.transparent_bg);
        this.fNX.setDefaultBgResource(d.f.transparent_bg);
        this.fNY.setDefaultBgResource(d.f.transparent_bg);
        this.fNV.setDefaultResource(d.f.icon_gift_moren);
        this.fNW.setDefaultResource(d.f.icon_gift_moren);
        this.fNX.setDefaultResource(d.f.icon_gift_moren);
        this.fNY.setDefaultResource(d.f.icon_gift_moren);
        this.fNZ = (TextView) this.root.findViewById(d.g.pb_gift_number_view);
        this.fOa = (TextView) this.root.findViewById(d.g.pb_gift_send_view);
        this.fOa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.ad(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.fOb, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bb.aU(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(an anVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.fOb = str2;
        this.postId = j3;
        this.threadId = j2;
        if (anVar == null || anVar.uI() == null || anVar.uI().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (anVar.uI().size() > 4 ? 4 : anVar.uI().size()) {
            case 1:
                this.fNV.startLoad(anVar.uI().get(0).thumbnailUrl, 10, false);
                this.fNV.setVisibility(0);
                this.fNW.setVisibility(8);
                this.fNX.setVisibility(8);
                this.fNY.setVisibility(8);
                break;
            case 2:
                this.fNV.startLoad(anVar.uI().get(0).thumbnailUrl, 10, false);
                this.fNW.startLoad(anVar.uI().get(1).thumbnailUrl, 10, false);
                this.fNV.setVisibility(0);
                this.fNW.setVisibility(0);
                this.fNX.setVisibility(8);
                this.fNY.setVisibility(8);
                break;
            case 3:
                this.fNV.startLoad(anVar.uI().get(0).thumbnailUrl, 10, false);
                this.fNW.startLoad(anVar.uI().get(1).thumbnailUrl, 10, false);
                this.fNX.startLoad(anVar.uI().get(2).thumbnailUrl, 10, false);
                this.fNV.setVisibility(0);
                this.fNW.setVisibility(0);
                this.fNX.setVisibility(0);
                this.fNY.setVisibility(8);
                break;
            case 4:
                this.fNV.startLoad(anVar.uI().get(0).thumbnailUrl, 10, false);
                this.fNW.startLoad(anVar.uI().get(1).thumbnailUrl, 10, false);
                this.fNX.startLoad(anVar.uI().get(2).thumbnailUrl, 10, false);
                this.fNY.startLoad(anVar.uI().get(3).thumbnailUrl, 10, false);
                this.fNV.setVisibility(0);
                this.fNW.setVisibility(0);
                this.fNX.setVisibility(0);
                this.fNY.setVisibility(0);
                break;
        }
        if (anVar.uH() > 0) {
            this.fNZ.setText(String.format(this.mContext.getResources().getString(d.k.gift_counts), Integer.valueOf(anVar.uH())));
            this.fNZ.setVisibility(0);
        } else {
            this.fNZ.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.fOa.setVisibility(8);
        } else {
            this.fOa.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.c(this.fNZ, d.C0142d.cp_cont_d, 1);
            am.c(this.fOa, d.C0142d.cp_link_tip_c, 1);
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
