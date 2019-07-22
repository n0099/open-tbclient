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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PbGiftListView extends FrameLayout {
    private View bmR;
    private TbImageView idS;
    private TbImageView idT;
    private TbImageView idU;
    private TbImageView idV;
    private TextView idW;
    private TextView idX;
    private String idY;
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
        this.bmR = View.inflate(this.mContext, R.layout.pb_gift_list_item, this);
        this.idS = (TbImageView) this.bmR.findViewById(R.id.pb_gift_view1);
        this.idT = (TbImageView) this.bmR.findViewById(R.id.pb_gift_view2);
        this.idU = (TbImageView) this.bmR.findViewById(R.id.pb_gift_view3);
        this.idV = (TbImageView) this.bmR.findViewById(R.id.pb_gift_view4);
        this.idS.setDefaultBgResource(R.drawable.transparent_bg);
        this.idT.setDefaultBgResource(R.drawable.transparent_bg);
        this.idU.setDefaultBgResource(R.drawable.transparent_bg);
        this.idV.setDefaultBgResource(R.drawable.transparent_bg);
        this.idS.setDefaultResource(R.drawable.icon_gift_moren);
        this.idT.setDefaultResource(R.drawable.icon_gift_moren);
        this.idU.setDefaultResource(R.drawable.icon_gift_moren);
        this.idV.setDefaultResource(R.drawable.icon_gift_moren);
        this.idW = (TextView) this.bmR.findViewById(R.id.pb_gift_number_view);
        this.idX = (TextView) this.bmR.findViewById(R.id.pb_gift_send_view);
        this.idX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.ab(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.idY, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    bd.cF(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(ao aoVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.idY = str2;
        this.postId = j3;
        this.threadId = j2;
        if (aoVar == null || aoVar.adt() == null || aoVar.adt().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (aoVar.adt().size() > 4 ? 4 : aoVar.adt().size()) {
            case 1:
                this.idS.startLoad(aoVar.adt().get(0).thumbnailUrl, 10, false);
                this.idS.setVisibility(0);
                this.idT.setVisibility(8);
                this.idU.setVisibility(8);
                this.idV.setVisibility(8);
                break;
            case 2:
                this.idS.startLoad(aoVar.adt().get(0).thumbnailUrl, 10, false);
                this.idT.startLoad(aoVar.adt().get(1).thumbnailUrl, 10, false);
                this.idS.setVisibility(0);
                this.idT.setVisibility(0);
                this.idU.setVisibility(8);
                this.idV.setVisibility(8);
                break;
            case 3:
                this.idS.startLoad(aoVar.adt().get(0).thumbnailUrl, 10, false);
                this.idT.startLoad(aoVar.adt().get(1).thumbnailUrl, 10, false);
                this.idU.startLoad(aoVar.adt().get(2).thumbnailUrl, 10, false);
                this.idS.setVisibility(0);
                this.idT.setVisibility(0);
                this.idU.setVisibility(0);
                this.idV.setVisibility(8);
                break;
            case 4:
                this.idS.startLoad(aoVar.adt().get(0).thumbnailUrl, 10, false);
                this.idT.startLoad(aoVar.adt().get(1).thumbnailUrl, 10, false);
                this.idU.startLoad(aoVar.adt().get(2).thumbnailUrl, 10, false);
                this.idV.startLoad(aoVar.adt().get(3).thumbnailUrl, 10, false);
                this.idS.setVisibility(0);
                this.idT.setVisibility(0);
                this.idU.setVisibility(0);
                this.idV.setVisibility(0);
                break;
        }
        if (aoVar.getTotal() > 0) {
            this.idW.setText(String.format(this.mContext.getResources().getString(R.string.gift_counts), Integer.valueOf(aoVar.getTotal())));
            this.idW.setVisibility(0);
        } else {
            this.idW.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.idX.setVisibility(8);
        } else {
            this.idX.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            am.f(this.idW, R.color.cp_cont_d, 1);
            am.f(this.idX, R.color.cp_link_tip_c, 1);
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
