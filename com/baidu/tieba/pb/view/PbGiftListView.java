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
    private View cue;
    private TbImageView jcb;
    private TbImageView jcc;
    private TbImageView jcd;
    private TbImageView jce;
    private TextView jcf;
    private TextView jcg;
    private String jch;
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
        this.cue = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.jcb = (TbImageView) this.cue.findViewById(R.id.pb_gift_view1);
        this.jcc = (TbImageView) this.cue.findViewById(R.id.pb_gift_view2);
        this.jcd = (TbImageView) this.cue.findViewById(R.id.pb_gift_view3);
        this.jce = (TbImageView) this.cue.findViewById(R.id.pb_gift_view4);
        this.jcb.setDefaultBgResource(R.drawable.transparent_bg);
        this.jcc.setDefaultBgResource(R.drawable.transparent_bg);
        this.jcd.setDefaultBgResource(R.drawable.transparent_bg);
        this.jce.setDefaultBgResource(R.drawable.transparent_bg);
        this.jcb.setDefaultResource(R.drawable.icon_gift_moren);
        this.jcc.setDefaultResource(R.drawable.icon_gift_moren);
        this.jcd.setDefaultResource(R.drawable.icon_gift_moren);
        this.jce.setDefaultResource(R.drawable.icon_gift_moren);
        this.jcf = (TextView) this.cue.findViewById(R.id.pb_gift_number_view);
        this.jcg = (TextView) this.cue.findViewById(R.id.pb_gift_send_view);
        this.jcg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.ab(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.jch, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
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
        this.jch = str2;
        this.postId = j3;
        this.threadId = j2;
        if (arVar == null || arVar.aBk() == null || arVar.aBk().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (arVar.aBk().size() > 4 ? 4 : arVar.aBk().size()) {
            case 1:
                this.jcb.startLoad(arVar.aBk().get(0).thumbnailUrl, 10, false);
                this.jcb.setVisibility(0);
                this.jcc.setVisibility(8);
                this.jcd.setVisibility(8);
                this.jce.setVisibility(8);
                break;
            case 2:
                this.jcb.startLoad(arVar.aBk().get(0).thumbnailUrl, 10, false);
                this.jcc.startLoad(arVar.aBk().get(1).thumbnailUrl, 10, false);
                this.jcb.setVisibility(0);
                this.jcc.setVisibility(0);
                this.jcd.setVisibility(8);
                this.jce.setVisibility(8);
                break;
            case 3:
                this.jcb.startLoad(arVar.aBk().get(0).thumbnailUrl, 10, false);
                this.jcc.startLoad(arVar.aBk().get(1).thumbnailUrl, 10, false);
                this.jcd.startLoad(arVar.aBk().get(2).thumbnailUrl, 10, false);
                this.jcb.setVisibility(0);
                this.jcc.setVisibility(0);
                this.jcd.setVisibility(0);
                this.jce.setVisibility(8);
                break;
            case 4:
                this.jcb.startLoad(arVar.aBk().get(0).thumbnailUrl, 10, false);
                this.jcc.startLoad(arVar.aBk().get(1).thumbnailUrl, 10, false);
                this.jcd.startLoad(arVar.aBk().get(2).thumbnailUrl, 10, false);
                this.jce.startLoad(arVar.aBk().get(3).thumbnailUrl, 10, false);
                this.jcb.setVisibility(0);
                this.jcc.setVisibility(0);
                this.jcd.setVisibility(0);
                this.jce.setVisibility(0);
                break;
        }
        if (arVar.getTotal() > 0) {
            this.jcf.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(arVar.getTotal())));
            this.jcf.setVisibility(0);
        } else {
            this.jcf.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.jcg.setVisibility(8);
        } else {
            this.jcg.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.setViewTextColor(this.jcf, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.jcg, R.color.cp_link_tip_c, 1);
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
