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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PbGiftListView extends FrameLayout {
    private TbImageView fJU;
    private TbImageView fJV;
    private TbImageView fJW;
    private TbImageView fJX;
    private TextView fJY;
    private TextView fJZ;
    private String fKa;
    private Context mContext;
    private long postId;
    private View root;
    private long threadId;
    private long toUserId;
    private String toUserName;

    public PbGiftListView(Context context) {
        super(context);
    }

    public PbGiftListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public PbGiftListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.root = View.inflate(this.mContext, d.i.pb_gift_list_item, this);
        this.fJU = (TbImageView) this.root.findViewById(d.g.pb_gift_view1);
        this.fJV = (TbImageView) this.root.findViewById(d.g.pb_gift_view2);
        this.fJW = (TbImageView) this.root.findViewById(d.g.pb_gift_view3);
        this.fJX = (TbImageView) this.root.findViewById(d.g.pb_gift_view4);
        this.fJU.setDefaultBgResource(d.f.transparent_bg);
        this.fJV.setDefaultBgResource(d.f.transparent_bg);
        this.fJW.setDefaultBgResource(d.f.transparent_bg);
        this.fJX.setDefaultBgResource(d.f.transparent_bg);
        this.fJU.setDefaultResource(d.f.icon_gift_moren);
        this.fJV.setDefaultResource(d.f.icon_gift_moren);
        this.fJW.setDefaultResource(d.f.icon_gift_moren);
        this.fJX.setDefaultResource(d.f.icon_gift_moren);
        this.fJY = (TextView) this.root.findViewById(d.g.pb_gift_number_view);
        this.fJZ = (TextView) this.root.findViewById(d.g.pb_gift_send_view);
        this.fJZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.ad(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.fKa, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ba.aU(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(an anVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.fKa = str2;
        this.postId = j3;
        this.threadId = j2;
        if (anVar == null || anVar.uA() == null || anVar.uA().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (anVar.uA().size() > 4 ? 4 : anVar.uA().size()) {
            case 1:
                this.fJU.startLoad(anVar.uA().get(0).thumbnailUrl, 10, false);
                this.fJU.setVisibility(0);
                this.fJV.setVisibility(8);
                this.fJW.setVisibility(8);
                this.fJX.setVisibility(8);
                break;
            case 2:
                this.fJU.startLoad(anVar.uA().get(0).thumbnailUrl, 10, false);
                this.fJV.startLoad(anVar.uA().get(1).thumbnailUrl, 10, false);
                this.fJU.setVisibility(0);
                this.fJV.setVisibility(0);
                this.fJW.setVisibility(8);
                this.fJX.setVisibility(8);
                break;
            case 3:
                this.fJU.startLoad(anVar.uA().get(0).thumbnailUrl, 10, false);
                this.fJV.startLoad(anVar.uA().get(1).thumbnailUrl, 10, false);
                this.fJW.startLoad(anVar.uA().get(2).thumbnailUrl, 10, false);
                this.fJU.setVisibility(0);
                this.fJV.setVisibility(0);
                this.fJW.setVisibility(0);
                this.fJX.setVisibility(8);
                break;
            case 4:
                this.fJU.startLoad(anVar.uA().get(0).thumbnailUrl, 10, false);
                this.fJV.startLoad(anVar.uA().get(1).thumbnailUrl, 10, false);
                this.fJW.startLoad(anVar.uA().get(2).thumbnailUrl, 10, false);
                this.fJX.startLoad(anVar.uA().get(3).thumbnailUrl, 10, false);
                this.fJU.setVisibility(0);
                this.fJV.setVisibility(0);
                this.fJW.setVisibility(0);
                this.fJX.setVisibility(0);
                break;
        }
        if (anVar.uz() > 0) {
            this.fJY.setText(String.format(this.mContext.getResources().getString(d.k.gift_counts), Integer.valueOf(anVar.uz())));
            this.fJY.setVisibility(0);
        } else {
            this.fJY.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.fJZ.setVisibility(8);
        } else {
            this.fJZ.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        al.c(this.fJY, d.C0141d.cp_cont_d, 1);
        al.c(this.fJZ, d.C0141d.cp_link_tip_c, 1);
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
