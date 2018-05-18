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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PbGiftListView extends FrameLayout {
    private TbImageView fyA;
    private TbImageView fyB;
    private TbImageView fyC;
    private TextView fyD;
    private TextView fyE;
    private String fyF;
    private TbImageView fyz;
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
        this.fyz = (TbImageView) this.root.findViewById(d.g.pb_gift_view1);
        this.fyA = (TbImageView) this.root.findViewById(d.g.pb_gift_view2);
        this.fyB = (TbImageView) this.root.findViewById(d.g.pb_gift_view3);
        this.fyC = (TbImageView) this.root.findViewById(d.g.pb_gift_view4);
        this.fyz.setDefaultBgResource(d.f.transparent_bg);
        this.fyA.setDefaultBgResource(d.f.transparent_bg);
        this.fyB.setDefaultBgResource(d.f.transparent_bg);
        this.fyC.setDefaultBgResource(d.f.transparent_bg);
        this.fyz.setDefaultResource(d.f.icon_gift_moren);
        this.fyA.setDefaultResource(d.f.icon_gift_moren);
        this.fyB.setDefaultResource(d.f.icon_gift_moren);
        this.fyC.setDefaultResource(d.f.icon_gift_moren);
        this.fyD = (TextView) this.root.findViewById(d.g.pb_gift_number_view);
        this.fyE = (TextView) this.root.findViewById(d.g.pb_gift_send_view);
        this.fyE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbPageContext tbPageContext = (TbPageContext) i.ab(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.fyF, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    az.aK(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(an anVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.fyF = str2;
        this.postId = j3;
        this.threadId = j2;
        if (anVar == null || anVar.re() == null || anVar.re().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (anVar.re().size() > 4 ? 4 : anVar.re().size()) {
            case 1:
                this.fyz.startLoad(anVar.re().get(0).thumbnailUrl, 10, false);
                this.fyz.setVisibility(0);
                this.fyA.setVisibility(8);
                this.fyB.setVisibility(8);
                this.fyC.setVisibility(8);
                break;
            case 2:
                this.fyz.startLoad(anVar.re().get(0).thumbnailUrl, 10, false);
                this.fyA.startLoad(anVar.re().get(1).thumbnailUrl, 10, false);
                this.fyz.setVisibility(0);
                this.fyA.setVisibility(0);
                this.fyB.setVisibility(8);
                this.fyC.setVisibility(8);
                break;
            case 3:
                this.fyz.startLoad(anVar.re().get(0).thumbnailUrl, 10, false);
                this.fyA.startLoad(anVar.re().get(1).thumbnailUrl, 10, false);
                this.fyB.startLoad(anVar.re().get(2).thumbnailUrl, 10, false);
                this.fyz.setVisibility(0);
                this.fyA.setVisibility(0);
                this.fyB.setVisibility(0);
                this.fyC.setVisibility(8);
                break;
            case 4:
                this.fyz.startLoad(anVar.re().get(0).thumbnailUrl, 10, false);
                this.fyA.startLoad(anVar.re().get(1).thumbnailUrl, 10, false);
                this.fyB.startLoad(anVar.re().get(2).thumbnailUrl, 10, false);
                this.fyC.startLoad(anVar.re().get(3).thumbnailUrl, 10, false);
                this.fyz.setVisibility(0);
                this.fyA.setVisibility(0);
                this.fyB.setVisibility(0);
                this.fyC.setVisibility(0);
                break;
        }
        if (anVar.rd() > 0) {
            this.fyD.setText(String.format(this.mContext.getResources().getString(d.k.gift_counts), Integer.valueOf(anVar.rd())));
            this.fyD.setVisibility(0);
        } else {
            this.fyD.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.fyE.setVisibility(8);
        } else {
            this.fyE.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        ak.c(this.fyD, d.C0126d.cp_cont_d, 1);
        ak.c(this.fyE, d.C0126d.cp_link_tip_c, 1);
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
