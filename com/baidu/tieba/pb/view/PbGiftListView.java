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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class PbGiftListView extends FrameLayout {
    private View dcP;
    private TbImageView hFQ;
    private TbImageView hFR;
    private TbImageView hFS;
    private TbImageView hFT;
    private TextView hFU;
    private TextView hFV;
    private String hFW;
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
        this.dcP = View.inflate(this.mContext, d.h.pb_gift_list_item, this);
        this.hFQ = (TbImageView) this.dcP.findViewById(d.g.pb_gift_view1);
        this.hFR = (TbImageView) this.dcP.findViewById(d.g.pb_gift_view2);
        this.hFS = (TbImageView) this.dcP.findViewById(d.g.pb_gift_view3);
        this.hFT = (TbImageView) this.dcP.findViewById(d.g.pb_gift_view4);
        this.hFQ.setDefaultBgResource(d.f.transparent_bg);
        this.hFR.setDefaultBgResource(d.f.transparent_bg);
        this.hFS.setDefaultBgResource(d.f.transparent_bg);
        this.hFT.setDefaultBgResource(d.f.transparent_bg);
        this.hFQ.setDefaultResource(d.f.icon_gift_moren);
        this.hFR.setDefaultResource(d.f.icon_gift_moren);
        this.hFS.setDefaultResource(d.f.icon_gift_moren);
        this.hFT.setDefaultResource(d.f.icon_gift_moren);
        this.hFU = (TextView) this.dcP.findViewById(d.g.pb_gift_number_view);
        this.hFV = (TextView) this.dcP.findViewById(d.g.pb_gift_send_view);
        this.hFV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.aK(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.hFW, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bc.cZ(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(ao aoVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.hFW = str2;
        this.postId = j3;
        this.threadId = j2;
        if (aoVar == null || aoVar.XM() == null || aoVar.XM().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (aoVar.XM().size() > 4 ? 4 : aoVar.XM().size()) {
            case 1:
                this.hFQ.startLoad(aoVar.XM().get(0).thumbnailUrl, 10, false);
                this.hFQ.setVisibility(0);
                this.hFR.setVisibility(8);
                this.hFS.setVisibility(8);
                this.hFT.setVisibility(8);
                break;
            case 2:
                this.hFQ.startLoad(aoVar.XM().get(0).thumbnailUrl, 10, false);
                this.hFR.startLoad(aoVar.XM().get(1).thumbnailUrl, 10, false);
                this.hFQ.setVisibility(0);
                this.hFR.setVisibility(0);
                this.hFS.setVisibility(8);
                this.hFT.setVisibility(8);
                break;
            case 3:
                this.hFQ.startLoad(aoVar.XM().get(0).thumbnailUrl, 10, false);
                this.hFR.startLoad(aoVar.XM().get(1).thumbnailUrl, 10, false);
                this.hFS.startLoad(aoVar.XM().get(2).thumbnailUrl, 10, false);
                this.hFQ.setVisibility(0);
                this.hFR.setVisibility(0);
                this.hFS.setVisibility(0);
                this.hFT.setVisibility(8);
                break;
            case 4:
                this.hFQ.startLoad(aoVar.XM().get(0).thumbnailUrl, 10, false);
                this.hFR.startLoad(aoVar.XM().get(1).thumbnailUrl, 10, false);
                this.hFS.startLoad(aoVar.XM().get(2).thumbnailUrl, 10, false);
                this.hFT.startLoad(aoVar.XM().get(3).thumbnailUrl, 10, false);
                this.hFQ.setVisibility(0);
                this.hFR.setVisibility(0);
                this.hFS.setVisibility(0);
                this.hFT.setVisibility(0);
                break;
        }
        if (aoVar.getTotal() > 0) {
            this.hFU.setText(String.format(this.mContext.getResources().getString(d.j.gift_counts), Integer.valueOf(aoVar.getTotal())));
            this.hFU.setVisibility(0);
        } else {
            this.hFU.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.hFV.setVisibility(8);
        } else {
            this.hFV.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            al.d(this.hFU, d.C0236d.cp_cont_d, 1);
            al.d(this.hFV, d.C0236d.cp_link_tip_c, 1);
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
