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
    private View bSL;
    private TbImageView gpE;
    private TbImageView gpF;
    private TbImageView gpG;
    private TbImageView gpH;
    private TextView gpI;
    private TextView gpJ;
    private String gpK;
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
        this.bSL = View.inflate(this.mContext, e.h.pb_gift_list_item, this);
        this.gpE = (TbImageView) this.bSL.findViewById(e.g.pb_gift_view1);
        this.gpF = (TbImageView) this.bSL.findViewById(e.g.pb_gift_view2);
        this.gpG = (TbImageView) this.bSL.findViewById(e.g.pb_gift_view3);
        this.gpH = (TbImageView) this.bSL.findViewById(e.g.pb_gift_view4);
        this.gpE.setDefaultBgResource(e.f.transparent_bg);
        this.gpF.setDefaultBgResource(e.f.transparent_bg);
        this.gpG.setDefaultBgResource(e.f.transparent_bg);
        this.gpH.setDefaultBgResource(e.f.transparent_bg);
        this.gpE.setDefaultResource(e.f.icon_gift_moren);
        this.gpF.setDefaultResource(e.f.icon_gift_moren);
        this.gpG.setDefaultResource(e.f.icon_gift_moren);
        this.gpH.setDefaultResource(e.f.icon_gift_moren);
        this.gpI = (TextView) this.bSL.findViewById(e.g.pb_gift_number_view);
        this.gpJ = (TextView) this.bSL.findViewById(e.g.pb_gift_send_view);
        this.gpJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.aK(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.gpK, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
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
        this.gpK = str2;
        this.postId = j3;
        this.threadId = j2;
        if (amVar == null || amVar.ze() == null || amVar.ze().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (amVar.ze().size() > 4 ? 4 : amVar.ze().size()) {
            case 1:
                this.gpE.startLoad(amVar.ze().get(0).thumbnailUrl, 10, false);
                this.gpE.setVisibility(0);
                this.gpF.setVisibility(8);
                this.gpG.setVisibility(8);
                this.gpH.setVisibility(8);
                break;
            case 2:
                this.gpE.startLoad(amVar.ze().get(0).thumbnailUrl, 10, false);
                this.gpF.startLoad(amVar.ze().get(1).thumbnailUrl, 10, false);
                this.gpE.setVisibility(0);
                this.gpF.setVisibility(0);
                this.gpG.setVisibility(8);
                this.gpH.setVisibility(8);
                break;
            case 3:
                this.gpE.startLoad(amVar.ze().get(0).thumbnailUrl, 10, false);
                this.gpF.startLoad(amVar.ze().get(1).thumbnailUrl, 10, false);
                this.gpG.startLoad(amVar.ze().get(2).thumbnailUrl, 10, false);
                this.gpE.setVisibility(0);
                this.gpF.setVisibility(0);
                this.gpG.setVisibility(0);
                this.gpH.setVisibility(8);
                break;
            case 4:
                this.gpE.startLoad(amVar.ze().get(0).thumbnailUrl, 10, false);
                this.gpF.startLoad(amVar.ze().get(1).thumbnailUrl, 10, false);
                this.gpG.startLoad(amVar.ze().get(2).thumbnailUrl, 10, false);
                this.gpH.startLoad(amVar.ze().get(3).thumbnailUrl, 10, false);
                this.gpE.setVisibility(0);
                this.gpF.setVisibility(0);
                this.gpG.setVisibility(0);
                this.gpH.setVisibility(0);
                break;
        }
        if (amVar.getTotal() > 0) {
            this.gpI.setText(String.format(this.mContext.getResources().getString(e.j.gift_counts), Integer.valueOf(amVar.getTotal())));
            this.gpI.setVisibility(0);
        } else {
            this.gpI.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.gpJ.setVisibility(8);
        } else {
            this.gpJ.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            al.c(this.gpI, e.d.cp_cont_d, 1);
            al.c(this.gpJ, e.d.cp_link_tip_c, 1);
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
