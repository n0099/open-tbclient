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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class PbGiftListView extends FrameLayout {
    private View bzd;
    private TbImageView fNY;
    private TbImageView fNZ;
    private TbImageView fOa;
    private TbImageView fOb;
    private TextView fOc;
    private TextView fOd;
    private String fOe;
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
        this.bzd = View.inflate(this.mContext, f.h.pb_gift_list_item, this);
        this.fNY = (TbImageView) this.bzd.findViewById(f.g.pb_gift_view1);
        this.fNZ = (TbImageView) this.bzd.findViewById(f.g.pb_gift_view2);
        this.fOa = (TbImageView) this.bzd.findViewById(f.g.pb_gift_view3);
        this.fOb = (TbImageView) this.bzd.findViewById(f.g.pb_gift_view4);
        this.fNY.setDefaultBgResource(f.C0146f.transparent_bg);
        this.fNZ.setDefaultBgResource(f.C0146f.transparent_bg);
        this.fOa.setDefaultBgResource(f.C0146f.transparent_bg);
        this.fOb.setDefaultBgResource(f.C0146f.transparent_bg);
        this.fNY.setDefaultResource(f.C0146f.icon_gift_moren);
        this.fNZ.setDefaultResource(f.C0146f.icon_gift_moren);
        this.fOa.setDefaultResource(f.C0146f.icon_gift_moren);
        this.fOb.setDefaultResource(f.C0146f.icon_gift_moren);
        this.fOc = (TextView) this.bzd.findViewById(f.g.pb_gift_number_view);
        this.fOd = (TextView) this.bzd.findViewById(f.g.pb_gift_send_view);
        this.fOd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.ad(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.fOe, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bb.aU(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(am amVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.fOe = str2;
        this.postId = j3;
        this.threadId = j2;
        if (amVar == null || amVar.uu() == null || amVar.uu().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (amVar.uu().size() > 4 ? 4 : amVar.uu().size()) {
            case 1:
                this.fNY.startLoad(amVar.uu().get(0).thumbnailUrl, 10, false);
                this.fNY.setVisibility(0);
                this.fNZ.setVisibility(8);
                this.fOa.setVisibility(8);
                this.fOb.setVisibility(8);
                break;
            case 2:
                this.fNY.startLoad(amVar.uu().get(0).thumbnailUrl, 10, false);
                this.fNZ.startLoad(amVar.uu().get(1).thumbnailUrl, 10, false);
                this.fNY.setVisibility(0);
                this.fNZ.setVisibility(0);
                this.fOa.setVisibility(8);
                this.fOb.setVisibility(8);
                break;
            case 3:
                this.fNY.startLoad(amVar.uu().get(0).thumbnailUrl, 10, false);
                this.fNZ.startLoad(amVar.uu().get(1).thumbnailUrl, 10, false);
                this.fOa.startLoad(amVar.uu().get(2).thumbnailUrl, 10, false);
                this.fNY.setVisibility(0);
                this.fNZ.setVisibility(0);
                this.fOa.setVisibility(0);
                this.fOb.setVisibility(8);
                break;
            case 4:
                this.fNY.startLoad(amVar.uu().get(0).thumbnailUrl, 10, false);
                this.fNZ.startLoad(amVar.uu().get(1).thumbnailUrl, 10, false);
                this.fOa.startLoad(amVar.uu().get(2).thumbnailUrl, 10, false);
                this.fOb.startLoad(amVar.uu().get(3).thumbnailUrl, 10, false);
                this.fNY.setVisibility(0);
                this.fNZ.setVisibility(0);
                this.fOa.setVisibility(0);
                this.fOb.setVisibility(0);
                break;
        }
        if (amVar.ut() > 0) {
            this.fOc.setText(String.format(this.mContext.getResources().getString(f.j.gift_counts), Integer.valueOf(amVar.ut())));
            this.fOc.setVisibility(0);
        } else {
            this.fOc.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.fOd.setVisibility(8);
        } else {
            this.fOd.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            com.baidu.tbadk.core.util.am.c(this.fOc, f.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.c(this.fOd, f.d.cp_link_tip_c, 1);
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
