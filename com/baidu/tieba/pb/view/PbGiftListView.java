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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PbGiftListView extends FrameLayout {
    private View bzb;
    private TbImageView fOf;
    private TbImageView fOg;
    private TbImageView fOh;
    private TbImageView fOi;
    private TextView fOj;
    private TextView fOk;
    private String fOl;
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
        this.bzb = View.inflate(this.mContext, d.h.pb_gift_list_item, this);
        this.fOf = (TbImageView) this.bzb.findViewById(d.g.pb_gift_view1);
        this.fOg = (TbImageView) this.bzb.findViewById(d.g.pb_gift_view2);
        this.fOh = (TbImageView) this.bzb.findViewById(d.g.pb_gift_view3);
        this.fOi = (TbImageView) this.bzb.findViewById(d.g.pb_gift_view4);
        this.fOf.setDefaultBgResource(d.f.transparent_bg);
        this.fOg.setDefaultBgResource(d.f.transparent_bg);
        this.fOh.setDefaultBgResource(d.f.transparent_bg);
        this.fOi.setDefaultBgResource(d.f.transparent_bg);
        this.fOf.setDefaultResource(d.f.icon_gift_moren);
        this.fOg.setDefaultResource(d.f.icon_gift_moren);
        this.fOh.setDefaultResource(d.f.icon_gift_moren);
        this.fOi.setDefaultResource(d.f.icon_gift_moren);
        this.fOj = (TextView) this.bzb.findViewById(d.g.pb_gift_number_view);
        this.fOk = (TextView) this.bzb.findViewById(d.g.pb_gift_send_view);
        this.fOk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.ad(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.fOl, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ba.aV(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(am amVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.fOl = str2;
        this.postId = j3;
        this.threadId = j2;
        if (amVar == null || amVar.uv() == null || amVar.uv().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (amVar.uv().size() > 4 ? 4 : amVar.uv().size()) {
            case 1:
                this.fOf.startLoad(amVar.uv().get(0).thumbnailUrl, 10, false);
                this.fOf.setVisibility(0);
                this.fOg.setVisibility(8);
                this.fOh.setVisibility(8);
                this.fOi.setVisibility(8);
                break;
            case 2:
                this.fOf.startLoad(amVar.uv().get(0).thumbnailUrl, 10, false);
                this.fOg.startLoad(amVar.uv().get(1).thumbnailUrl, 10, false);
                this.fOf.setVisibility(0);
                this.fOg.setVisibility(0);
                this.fOh.setVisibility(8);
                this.fOi.setVisibility(8);
                break;
            case 3:
                this.fOf.startLoad(amVar.uv().get(0).thumbnailUrl, 10, false);
                this.fOg.startLoad(amVar.uv().get(1).thumbnailUrl, 10, false);
                this.fOh.startLoad(amVar.uv().get(2).thumbnailUrl, 10, false);
                this.fOf.setVisibility(0);
                this.fOg.setVisibility(0);
                this.fOh.setVisibility(0);
                this.fOi.setVisibility(8);
                break;
            case 4:
                this.fOf.startLoad(amVar.uv().get(0).thumbnailUrl, 10, false);
                this.fOg.startLoad(amVar.uv().get(1).thumbnailUrl, 10, false);
                this.fOh.startLoad(amVar.uv().get(2).thumbnailUrl, 10, false);
                this.fOi.startLoad(amVar.uv().get(3).thumbnailUrl, 10, false);
                this.fOf.setVisibility(0);
                this.fOg.setVisibility(0);
                this.fOh.setVisibility(0);
                this.fOi.setVisibility(0);
                break;
        }
        if (amVar.uu() > 0) {
            this.fOj.setText(String.format(this.mContext.getResources().getString(d.j.gift_counts), Integer.valueOf(amVar.uu())));
            this.fOj.setVisibility(0);
        } else {
            this.fOj.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.fOk.setVisibility(8);
        } else {
            this.fOk.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != skinType) {
            this.mSkinType = skinType;
            com.baidu.tbadk.core.util.am.c(this.fOj, d.C0140d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.c(this.fOk, d.C0140d.cp_link_tip_c, 1);
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
