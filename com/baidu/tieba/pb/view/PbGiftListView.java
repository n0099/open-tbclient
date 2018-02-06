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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PbGiftListView extends FrameLayout {
    private View ceJ;
    private TbImageView gdf;
    private TbImageView gdg;
    private TbImageView gdh;
    private TbImageView gdi;
    private TextView gdj;
    private TextView gdk;
    private String gdl;
    private Context mContext;
    private long postId;
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
        this.ceJ = View.inflate(this.mContext, d.h.pb_gift_list_item, this);
        this.gdf = (TbImageView) this.ceJ.findViewById(d.g.pb_gift_view1);
        this.gdg = (TbImageView) this.ceJ.findViewById(d.g.pb_gift_view2);
        this.gdh = (TbImageView) this.ceJ.findViewById(d.g.pb_gift_view3);
        this.gdi = (TbImageView) this.ceJ.findViewById(d.g.pb_gift_view4);
        this.gdf.setDefaultBgResource(d.f.transparent_bg);
        this.gdg.setDefaultBgResource(d.f.transparent_bg);
        this.gdh.setDefaultBgResource(d.f.transparent_bg);
        this.gdi.setDefaultBgResource(d.f.transparent_bg);
        this.gdf.setDefaultResource(d.f.icon_gift_moren);
        this.gdg.setDefaultResource(d.f.icon_gift_moren);
        this.gdh.setDefaultResource(d.f.icon_gift_moren);
        this.gdi.setDefaultResource(d.f.icon_gift_moren);
        this.gdj = (TextView) this.ceJ.findViewById(d.g.pb_gift_number_view);
        this.gdk = (TextView) this.ceJ.findViewById(d.g.pb_gift_send_view);
        this.gdk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbGiftListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TbPageContext tbPageContext = (TbPageContext) i.ak(PbGiftListView.this.mContext);
                if (tbPageContext != null) {
                    if (TbadkCoreApplication.isLogin()) {
                        if (!StringUtils.isNull(PbGiftListView.this.toUserName)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(tbPageContext.getPageActivity(), PbGiftListView.this.toUserId, PbGiftListView.this.toUserName, PbGiftListView.this.gdl, GiftTabActivityConfig.FROM_PB, PbGiftListView.this.threadId, PbGiftListView.this.postId)));
                            return;
                        }
                        return;
                    }
                    ay.ba(tbPageContext.getPageActivity());
                }
            }
        });
    }

    public void a(am amVar, String str, String str2, long j, long j2, long j3) {
        this.toUserId = j;
        this.toUserName = str;
        this.gdl = str2;
        this.postId = j3;
        this.threadId = j2;
        if (amVar == null || amVar.yz() == null || amVar.yz().size() <= 0) {
            setVisibility(8);
            return;
        }
        switch (amVar.yz().size() > 4 ? 4 : amVar.yz().size()) {
            case 1:
                this.gdf.startLoad(amVar.yz().get(0).thumbnailUrl, 10, false);
                this.gdf.setVisibility(0);
                this.gdg.setVisibility(8);
                this.gdh.setVisibility(8);
                this.gdi.setVisibility(8);
                break;
            case 2:
                this.gdf.startLoad(amVar.yz().get(0).thumbnailUrl, 10, false);
                this.gdg.startLoad(amVar.yz().get(1).thumbnailUrl, 10, false);
                this.gdf.setVisibility(0);
                this.gdg.setVisibility(0);
                this.gdh.setVisibility(8);
                this.gdi.setVisibility(8);
                break;
            case 3:
                this.gdf.startLoad(amVar.yz().get(0).thumbnailUrl, 10, false);
                this.gdg.startLoad(amVar.yz().get(1).thumbnailUrl, 10, false);
                this.gdh.startLoad(amVar.yz().get(2).thumbnailUrl, 10, false);
                this.gdf.setVisibility(0);
                this.gdg.setVisibility(0);
                this.gdh.setVisibility(0);
                this.gdi.setVisibility(8);
                break;
            case 4:
                this.gdf.startLoad(amVar.yz().get(0).thumbnailUrl, 10, false);
                this.gdg.startLoad(amVar.yz().get(1).thumbnailUrl, 10, false);
                this.gdh.startLoad(amVar.yz().get(2).thumbnailUrl, 10, false);
                this.gdi.startLoad(amVar.yz().get(3).thumbnailUrl, 10, false);
                this.gdf.setVisibility(0);
                this.gdg.setVisibility(0);
                this.gdh.setVisibility(0);
                this.gdi.setVisibility(0);
                break;
        }
        if (amVar.yy() > 0) {
            this.gdj.setText(String.format(this.mContext.getResources().getString(d.j.gift_counts), Integer.valueOf(amVar.yy())));
            this.gdj.setVisibility(0);
        } else {
            this.gdj.setVisibility(8);
        }
        if (j == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L)) {
            this.gdk.setVisibility(8);
        } else {
            this.gdk.setVisibility(0);
        }
    }

    public void onChangeSkinType() {
        aj.e(this.gdj, d.C0140d.cp_cont_d, 1);
        aj.e(this.gdk, d.C0140d.cp_link_tip_c, 1);
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
