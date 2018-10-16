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
    private View bNv;
    private String gdA;
    private TbImageView gdu;
    private TbImageView gdv;
    private TbImageView gdw;
    private TbImageView gdx;
    private TextView gdy;
    private TextView gdz;
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
        this.bNv = View.inflate(this.mContext, e.h.pb_gift_list_item, this);
        this.gdu = (TbImageView) this.bNv.findViewById(e.g.pb_gift_view1);
        this.gdv = (TbImageView) this.bNv.findViewById(e.g.pb_gift_view2);
        this.gdw = (TbImageView) this.bNv.findViewById(e.g.pb_gift_view3);
        this.gdx = (TbImageView) this.bNv.findViewById(e.g.pb_gift_view4);
        this.gdu.setDefaultBgResource(e.f.transparent_bg);
        this.gdv.setDefaultBgResource(e.f.transparent_bg);
        this.gdw.setDefaultBgResource(e.f.transparent_bg);
        this.gdx.setDefaultBgResource(e.f.transparent_bg);
        this.gdu.setDefaultResource(e.f.icon_gift_moren);
        this.gdv.setDefaultResource(e.f.icon_gift_moren);
        this.gdw.setDefaultResource(e.f.icon_gift_moren);
        this.gdx.setDefaultResource(e.f.icon_gift_moren);
        this.gdy = (TextView) this.bNv.findViewById(e.g.pb_gift_number_view);
        this.gdz = (TextView) this.bNv.findViewById(e.g.pb_gift_send_view);
        this.gdz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.aK(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.gdA, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ba.bI(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(am amVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.gdA = str2;
        this.postId = j3;
        this.threadId = j2;
        if (amVar == null || amVar.xG() == null || amVar.xG().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (amVar.xG().size() > 4 ? 4 : amVar.xG().size()) {
            case 1:
                this.gdu.startLoad(amVar.xG().get(0).thumbnailUrl, 10, false);
                this.gdu.setVisibility(0);
                this.gdv.setVisibility(8);
                this.gdw.setVisibility(8);
                this.gdx.setVisibility(8);
                break;
            case 2:
                this.gdu.startLoad(amVar.xG().get(0).thumbnailUrl, 10, false);
                this.gdv.startLoad(amVar.xG().get(1).thumbnailUrl, 10, false);
                this.gdu.setVisibility(0);
                this.gdv.setVisibility(0);
                this.gdw.setVisibility(8);
                this.gdx.setVisibility(8);
                break;
            case 3:
                this.gdu.startLoad(amVar.xG().get(0).thumbnailUrl, 10, false);
                this.gdv.startLoad(amVar.xG().get(1).thumbnailUrl, 10, false);
                this.gdw.startLoad(amVar.xG().get(2).thumbnailUrl, 10, false);
                this.gdu.setVisibility(0);
                this.gdv.setVisibility(0);
                this.gdw.setVisibility(0);
                this.gdx.setVisibility(8);
                break;
            case 4:
                this.gdu.startLoad(amVar.xG().get(0).thumbnailUrl, 10, false);
                this.gdv.startLoad(amVar.xG().get(1).thumbnailUrl, 10, false);
                this.gdw.startLoad(amVar.xG().get(2).thumbnailUrl, 10, false);
                this.gdx.startLoad(amVar.xG().get(3).thumbnailUrl, 10, false);
                this.gdu.setVisibility(0);
                this.gdv.setVisibility(0);
                this.gdw.setVisibility(0);
                this.gdx.setVisibility(0);
                break;
        }
        if (amVar.xF() > 0) {
            this.gdy.setText(String.format(this.mContext.getResources().getString(e.j.gift_counts), Integer.valueOf(amVar.xF())));
            this.gdy.setVisibility(0);
        } else {
            this.gdy.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.gdz.setVisibility(8);
        } else {
            this.gdz.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            al.c(this.gdy, e.d.cp_cont_d, 1);
            al.c(this.gdz, e.d.cp_link_tip_c, 1);
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
