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
/* loaded from: classes7.dex */
public class PbGiftListView extends FrameLayout {
    private View cqd;
    private TextView jaA;
    private String jaB;
    private TbImageView jav;
    private TbImageView jaw;
    private TbImageView jax;
    private TbImageView jay;
    private TextView jaz;
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
        this.cqd = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.jav = (TbImageView) this.cqd.findViewById(R.id.pb_gift_view1);
        this.jaw = (TbImageView) this.cqd.findViewById(R.id.pb_gift_view2);
        this.jax = (TbImageView) this.cqd.findViewById(R.id.pb_gift_view3);
        this.jay = (TbImageView) this.cqd.findViewById(R.id.pb_gift_view4);
        this.jav.setDefaultBgResource(R.drawable.transparent_bg);
        this.jaw.setDefaultBgResource(R.drawable.transparent_bg);
        this.jax.setDefaultBgResource(R.drawable.transparent_bg);
        this.jay.setDefaultBgResource(R.drawable.transparent_bg);
        this.jav.setDefaultResource(R.drawable.icon_gift_moren);
        this.jaw.setDefaultResource(R.drawable.icon_gift_moren);
        this.jax.setDefaultResource(R.drawable.icon_gift_moren);
        this.jay.setDefaultResource(R.drawable.icon_gift_moren);
        this.jaz = (TextView) this.cqd.findViewById(R.id.pb_gift_number_view);
        this.jaA = (TextView) this.cqd.findViewById(R.id.pb_gift_send_view);
        this.jaA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.ab(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.jaB, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
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
        this.jaB = str2;
        this.postId = j3;
        this.threadId = j2;
        if (arVar == null || arVar.ayT() == null || arVar.ayT().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (arVar.ayT().size() > 4 ? 4 : arVar.ayT().size()) {
            case 1:
                this.jav.startLoad(arVar.ayT().get(0).thumbnailUrl, 10, false);
                this.jav.setVisibility(0);
                this.jaw.setVisibility(8);
                this.jax.setVisibility(8);
                this.jay.setVisibility(8);
                break;
            case 2:
                this.jav.startLoad(arVar.ayT().get(0).thumbnailUrl, 10, false);
                this.jaw.startLoad(arVar.ayT().get(1).thumbnailUrl, 10, false);
                this.jav.setVisibility(0);
                this.jaw.setVisibility(0);
                this.jax.setVisibility(8);
                this.jay.setVisibility(8);
                break;
            case 3:
                this.jav.startLoad(arVar.ayT().get(0).thumbnailUrl, 10, false);
                this.jaw.startLoad(arVar.ayT().get(1).thumbnailUrl, 10, false);
                this.jax.startLoad(arVar.ayT().get(2).thumbnailUrl, 10, false);
                this.jav.setVisibility(0);
                this.jaw.setVisibility(0);
                this.jax.setVisibility(0);
                this.jay.setVisibility(8);
                break;
            case 4:
                this.jav.startLoad(arVar.ayT().get(0).thumbnailUrl, 10, false);
                this.jaw.startLoad(arVar.ayT().get(1).thumbnailUrl, 10, false);
                this.jax.startLoad(arVar.ayT().get(2).thumbnailUrl, 10, false);
                this.jay.startLoad(arVar.ayT().get(3).thumbnailUrl, 10, false);
                this.jav.setVisibility(0);
                this.jaw.setVisibility(0);
                this.jax.setVisibility(0);
                this.jay.setVisibility(0);
                break;
        }
        if (arVar.getTotal() > 0) {
            this.jaz.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(arVar.getTotal())));
            this.jaz.setVisibility(0);
        } else {
            this.jaz.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.jaA.setVisibility(8);
        } else {
            this.jaA.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.setViewTextColor(this.jaz, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.jaA, R.color.cp_link_tip_c, 1);
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
