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
    private TbImageView fxt;
    private TbImageView fxu;
    private TbImageView fxv;
    private TbImageView fxw;
    private TextView fxx;
    private TextView fxy;
    private String fxz;
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
        this.fxt = (TbImageView) this.root.findViewById(d.g.pb_gift_view1);
        this.fxu = (TbImageView) this.root.findViewById(d.g.pb_gift_view2);
        this.fxv = (TbImageView) this.root.findViewById(d.g.pb_gift_view3);
        this.fxw = (TbImageView) this.root.findViewById(d.g.pb_gift_view4);
        this.fxt.setDefaultBgResource(d.f.transparent_bg);
        this.fxu.setDefaultBgResource(d.f.transparent_bg);
        this.fxv.setDefaultBgResource(d.f.transparent_bg);
        this.fxw.setDefaultBgResource(d.f.transparent_bg);
        this.fxt.setDefaultResource(d.f.icon_gift_moren);
        this.fxu.setDefaultResource(d.f.icon_gift_moren);
        this.fxv.setDefaultResource(d.f.icon_gift_moren);
        this.fxw.setDefaultResource(d.f.icon_gift_moren);
        this.fxx = (TextView) this.root.findViewById(d.g.pb_gift_number_view);
        this.fxy = (TextView) this.root.findViewById(d.g.pb_gift_send_view);
        this.fxy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbPageContext tbPageContext = (TbPageContext) i.ab(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.fxz, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
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
        this.fxz = str2;
        this.postId = j3;
        this.threadId = j2;
        if (anVar == null || anVar.rf() == null || anVar.rf().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (anVar.rf().size() > 4 ? 4 : anVar.rf().size()) {
            case 1:
                this.fxt.startLoad(anVar.rf().get(0).thumbnailUrl, 10, false);
                this.fxt.setVisibility(0);
                this.fxu.setVisibility(8);
                this.fxv.setVisibility(8);
                this.fxw.setVisibility(8);
                break;
            case 2:
                this.fxt.startLoad(anVar.rf().get(0).thumbnailUrl, 10, false);
                this.fxu.startLoad(anVar.rf().get(1).thumbnailUrl, 10, false);
                this.fxt.setVisibility(0);
                this.fxu.setVisibility(0);
                this.fxv.setVisibility(8);
                this.fxw.setVisibility(8);
                break;
            case 3:
                this.fxt.startLoad(anVar.rf().get(0).thumbnailUrl, 10, false);
                this.fxu.startLoad(anVar.rf().get(1).thumbnailUrl, 10, false);
                this.fxv.startLoad(anVar.rf().get(2).thumbnailUrl, 10, false);
                this.fxt.setVisibility(0);
                this.fxu.setVisibility(0);
                this.fxv.setVisibility(0);
                this.fxw.setVisibility(8);
                break;
            case 4:
                this.fxt.startLoad(anVar.rf().get(0).thumbnailUrl, 10, false);
                this.fxu.startLoad(anVar.rf().get(1).thumbnailUrl, 10, false);
                this.fxv.startLoad(anVar.rf().get(2).thumbnailUrl, 10, false);
                this.fxw.startLoad(anVar.rf().get(3).thumbnailUrl, 10, false);
                this.fxt.setVisibility(0);
                this.fxu.setVisibility(0);
                this.fxv.setVisibility(0);
                this.fxw.setVisibility(0);
                break;
        }
        if (anVar.re() > 0) {
            this.fxx.setText(String.format(this.mContext.getResources().getString(d.k.gift_counts), Integer.valueOf(anVar.re())));
            this.fxx.setVisibility(0);
        } else {
            this.fxx.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.fxy.setVisibility(8);
        } else {
            this.fxy.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        ak.c(this.fxx, d.C0126d.cp_cont_d, 1);
        ak.c(this.fxy, d.C0126d.cp_link_tip_c, 1);
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
