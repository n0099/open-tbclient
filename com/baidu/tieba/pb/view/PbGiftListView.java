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
    private View dcL;
    private TbImageView hFL;
    private TbImageView hFM;
    private TbImageView hFN;
    private TbImageView hFO;
    private TextView hFP;
    private TextView hFQ;
    private String hFR;
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
        this.dcL = View.inflate(this.mContext, d.h.pb_gift_list_item, this);
        this.hFL = (TbImageView) this.dcL.findViewById(d.g.pb_gift_view1);
        this.hFM = (TbImageView) this.dcL.findViewById(d.g.pb_gift_view2);
        this.hFN = (TbImageView) this.dcL.findViewById(d.g.pb_gift_view3);
        this.hFO = (TbImageView) this.dcL.findViewById(d.g.pb_gift_view4);
        this.hFL.setDefaultBgResource(d.f.transparent_bg);
        this.hFM.setDefaultBgResource(d.f.transparent_bg);
        this.hFN.setDefaultBgResource(d.f.transparent_bg);
        this.hFO.setDefaultBgResource(d.f.transparent_bg);
        this.hFL.setDefaultResource(d.f.icon_gift_moren);
        this.hFM.setDefaultResource(d.f.icon_gift_moren);
        this.hFN.setDefaultResource(d.f.icon_gift_moren);
        this.hFO.setDefaultResource(d.f.icon_gift_moren);
        this.hFP = (TextView) this.dcL.findViewById(d.g.pb_gift_number_view);
        this.hFQ = (TextView) this.dcL.findViewById(d.g.pb_gift_send_view);
        this.hFQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.aK(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.hFR, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
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
        this.hFR = str2;
        this.postId = j3;
        this.threadId = j2;
        if (aoVar == null || aoVar.XM() == null || aoVar.XM().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (aoVar.XM().size() > 4 ? 4 : aoVar.XM().size()) {
            case 1:
                this.hFL.startLoad(aoVar.XM().get(0).thumbnailUrl, 10, false);
                this.hFL.setVisibility(0);
                this.hFM.setVisibility(8);
                this.hFN.setVisibility(8);
                this.hFO.setVisibility(8);
                break;
            case 2:
                this.hFL.startLoad(aoVar.XM().get(0).thumbnailUrl, 10, false);
                this.hFM.startLoad(aoVar.XM().get(1).thumbnailUrl, 10, false);
                this.hFL.setVisibility(0);
                this.hFM.setVisibility(0);
                this.hFN.setVisibility(8);
                this.hFO.setVisibility(8);
                break;
            case 3:
                this.hFL.startLoad(aoVar.XM().get(0).thumbnailUrl, 10, false);
                this.hFM.startLoad(aoVar.XM().get(1).thumbnailUrl, 10, false);
                this.hFN.startLoad(aoVar.XM().get(2).thumbnailUrl, 10, false);
                this.hFL.setVisibility(0);
                this.hFM.setVisibility(0);
                this.hFN.setVisibility(0);
                this.hFO.setVisibility(8);
                break;
            case 4:
                this.hFL.startLoad(aoVar.XM().get(0).thumbnailUrl, 10, false);
                this.hFM.startLoad(aoVar.XM().get(1).thumbnailUrl, 10, false);
                this.hFN.startLoad(aoVar.XM().get(2).thumbnailUrl, 10, false);
                this.hFO.startLoad(aoVar.XM().get(3).thumbnailUrl, 10, false);
                this.hFL.setVisibility(0);
                this.hFM.setVisibility(0);
                this.hFN.setVisibility(0);
                this.hFO.setVisibility(0);
                break;
        }
        if (aoVar.getTotal() > 0) {
            this.hFP.setText(String.format(this.mContext.getResources().getString(d.j.gift_counts), Integer.valueOf(aoVar.getTotal())));
            this.hFP.setVisibility(0);
        } else {
            this.hFP.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.hFQ.setVisibility(8);
        } else {
            this.hFQ.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            al.d(this.hFP, d.C0277d.cp_cont_d, 1);
            al.d(this.hFQ, d.C0277d.cp_link_tip_c, 1);
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
