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
    private View bOg;
    private TbImageView geS;
    private TbImageView geT;
    private TbImageView geU;
    private TbImageView geV;
    private TextView geW;
    private TextView geX;
    private String geY;
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
        this.bOg = View.inflate(this.mContext, e.h.pb_gift_list_item, this);
        this.geS = (TbImageView) this.bOg.findViewById(e.g.pb_gift_view1);
        this.geT = (TbImageView) this.bOg.findViewById(e.g.pb_gift_view2);
        this.geU = (TbImageView) this.bOg.findViewById(e.g.pb_gift_view3);
        this.geV = (TbImageView) this.bOg.findViewById(e.g.pb_gift_view4);
        this.geS.setDefaultBgResource(e.f.transparent_bg);
        this.geT.setDefaultBgResource(e.f.transparent_bg);
        this.geU.setDefaultBgResource(e.f.transparent_bg);
        this.geV.setDefaultBgResource(e.f.transparent_bg);
        this.geS.setDefaultResource(e.f.icon_gift_moren);
        this.geT.setDefaultResource(e.f.icon_gift_moren);
        this.geU.setDefaultResource(e.f.icon_gift_moren);
        this.geV.setDefaultResource(e.f.icon_gift_moren);
        this.geW = (TextView) this.bOg.findViewById(e.g.pb_gift_number_view);
        this.geX = (TextView) this.bOg.findViewById(e.g.pb_gift_send_view);
        this.geX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.aK(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.geY, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ba.bG(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(am amVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.geY = str2;
        this.postId = j3;
        this.threadId = j2;
        if (amVar == null || amVar.xN() == null || amVar.xN().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (amVar.xN().size() > 4 ? 4 : amVar.xN().size()) {
            case 1:
                this.geS.startLoad(amVar.xN().get(0).thumbnailUrl, 10, false);
                this.geS.setVisibility(0);
                this.geT.setVisibility(8);
                this.geU.setVisibility(8);
                this.geV.setVisibility(8);
                break;
            case 2:
                this.geS.startLoad(amVar.xN().get(0).thumbnailUrl, 10, false);
                this.geT.startLoad(amVar.xN().get(1).thumbnailUrl, 10, false);
                this.geS.setVisibility(0);
                this.geT.setVisibility(0);
                this.geU.setVisibility(8);
                this.geV.setVisibility(8);
                break;
            case 3:
                this.geS.startLoad(amVar.xN().get(0).thumbnailUrl, 10, false);
                this.geT.startLoad(amVar.xN().get(1).thumbnailUrl, 10, false);
                this.geU.startLoad(amVar.xN().get(2).thumbnailUrl, 10, false);
                this.geS.setVisibility(0);
                this.geT.setVisibility(0);
                this.geU.setVisibility(0);
                this.geV.setVisibility(8);
                break;
            case 4:
                this.geS.startLoad(amVar.xN().get(0).thumbnailUrl, 10, false);
                this.geT.startLoad(amVar.xN().get(1).thumbnailUrl, 10, false);
                this.geU.startLoad(amVar.xN().get(2).thumbnailUrl, 10, false);
                this.geV.startLoad(amVar.xN().get(3).thumbnailUrl, 10, false);
                this.geS.setVisibility(0);
                this.geT.setVisibility(0);
                this.geU.setVisibility(0);
                this.geV.setVisibility(0);
                break;
        }
        if (amVar.getTotal() > 0) {
            this.geW.setText(String.format(this.mContext.getResources().getString(e.j.gift_counts), Integer.valueOf(amVar.getTotal())));
            this.geW.setVisibility(0);
        } else {
            this.geW.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.geX.setVisibility(8);
        } else {
            this.geX.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            al.c(this.geW, e.d.cp_cont_d, 1);
            al.c(this.geX, e.d.cp_link_tip_c, 1);
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
