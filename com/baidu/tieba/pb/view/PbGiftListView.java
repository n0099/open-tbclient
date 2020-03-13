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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PbGiftListView extends FrameLayout {
    private View cug;
    private TbImageView jcp;
    private TbImageView jcq;
    private TbImageView jcr;
    private TbImageView jcs;
    private TextView jct;
    private TextView jcu;
    private String jcv;
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
        this.cug = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.jcp = (TbImageView) this.cug.findViewById(R.id.pb_gift_view1);
        this.jcq = (TbImageView) this.cug.findViewById(R.id.pb_gift_view2);
        this.jcr = (TbImageView) this.cug.findViewById(R.id.pb_gift_view3);
        this.jcs = (TbImageView) this.cug.findViewById(R.id.pb_gift_view4);
        this.jcp.setDefaultBgResource(R.drawable.transparent_bg);
        this.jcq.setDefaultBgResource(R.drawable.transparent_bg);
        this.jcr.setDefaultBgResource(R.drawable.transparent_bg);
        this.jcs.setDefaultBgResource(R.drawable.transparent_bg);
        this.jcp.setDefaultResource(R.drawable.icon_gift_moren);
        this.jcq.setDefaultResource(R.drawable.icon_gift_moren);
        this.jcr.setDefaultResource(R.drawable.icon_gift_moren);
        this.jcs.setDefaultResource(R.drawable.icon_gift_moren);
        this.jct = (TextView) this.cug.findViewById(R.id.pb_gift_number_view);
        this.jcu = (TextView) this.cug.findViewById(R.id.pb_gift_send_view);
        this.jcu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.ab(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.jcv, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bc.checkUpIsLogin(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(ar arVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.jcv = str2;
        this.postId = j3;
        this.threadId = j2;
        if (arVar == null || arVar.aBm() == null || arVar.aBm().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (arVar.aBm().size() > 4 ? 4 : arVar.aBm().size()) {
            case 1:
                this.jcp.startLoad(arVar.aBm().get(0).thumbnailUrl, 10, false);
                this.jcp.setVisibility(0);
                this.jcq.setVisibility(8);
                this.jcr.setVisibility(8);
                this.jcs.setVisibility(8);
                break;
            case 2:
                this.jcp.startLoad(arVar.aBm().get(0).thumbnailUrl, 10, false);
                this.jcq.startLoad(arVar.aBm().get(1).thumbnailUrl, 10, false);
                this.jcp.setVisibility(0);
                this.jcq.setVisibility(0);
                this.jcr.setVisibility(8);
                this.jcs.setVisibility(8);
                break;
            case 3:
                this.jcp.startLoad(arVar.aBm().get(0).thumbnailUrl, 10, false);
                this.jcq.startLoad(arVar.aBm().get(1).thumbnailUrl, 10, false);
                this.jcr.startLoad(arVar.aBm().get(2).thumbnailUrl, 10, false);
                this.jcp.setVisibility(0);
                this.jcq.setVisibility(0);
                this.jcr.setVisibility(0);
                this.jcs.setVisibility(8);
                break;
            case 4:
                this.jcp.startLoad(arVar.aBm().get(0).thumbnailUrl, 10, false);
                this.jcq.startLoad(arVar.aBm().get(1).thumbnailUrl, 10, false);
                this.jcr.startLoad(arVar.aBm().get(2).thumbnailUrl, 10, false);
                this.jcs.startLoad(arVar.aBm().get(3).thumbnailUrl, 10, false);
                this.jcp.setVisibility(0);
                this.jcq.setVisibility(0);
                this.jcr.setVisibility(0);
                this.jcs.setVisibility(0);
                break;
        }
        if (arVar.getTotal() > 0) {
            this.jct.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(arVar.getTotal())));
            this.jct.setVisibility(0);
        } else {
            this.jct.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.jcu.setVisibility(8);
        } else {
            this.jcu.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.setViewTextColor(this.jct, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.jcu, R.color.cp_link_tip_c, 1);
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
