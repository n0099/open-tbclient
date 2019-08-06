package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.d.a;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ThreadSkinView extends TbImageView {
    private SkinInfo hGp;
    private a.C0414a hGq;
    private TbPageContext mTbPageContext;

    public ThreadSkinView(Context context) {
        super(context);
        init();
    }

    public ThreadSkinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public ThreadSkinView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setVisibility(8);
    }

    public void setData(TbPageContext tbPageContext, SkinInfo skinInfo, a.C0414a c0414a) {
        if (tbPageContext == null || skinInfo == null || StringUtils.isNull(skinInfo.skin)) {
            setVisibility(8);
            return;
        }
        this.mTbPageContext = tbPageContext;
        if (this.hGp != skinInfo && c0414a != null) {
            this.hGq = c0414a;
            this.hGq.nV("action_type");
            this.hGq.en(VideoPlayActivityConfig.OBJ_ID, skinInfo.obj_id);
            this.hGq.en("obj_url", skinInfo.url);
            this.hGq.en("obj_name", skinInfo.monitor_id);
            this.hGq.en("action_type", "VIEW_TRUE");
            this.hGq.save();
        }
        this.hGp = skinInfo;
        int af = l.af(tbPageContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = af;
        if (!StringUtils.isNull(skinInfo.skin_size)) {
            String[] split = skinInfo.skin_size.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length > 1) {
                int f = com.baidu.adp.lib.g.b.f(split[0].trim(), -1);
                int f2 = com.baidu.adp.lib.g.b.f(split[1].trim(), -1);
                if (f > 0 && f2 > 0) {
                    layoutParams.height = (int) ((f2 / f) * layoutParams.width);
                } else {
                    layoutParams.height = (int) tbPageContext.getResources().getDimension(R.dimen.ds80);
                }
            }
        } else {
            layoutParams.height = (int) tbPageContext.getResources().getDimension(R.dimen.ds80);
        }
        setLayoutParams(layoutParams);
        startLoad(skinInfo.skin, 10, false);
        setOnClickListener(this);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hGp != null && !StringUtils.isNull(this.hGp.url)) {
            if (this.hGq != null) {
                this.hGq.nV("action_type");
                this.hGq.en("action_type", "CLICK");
                this.hGq.save();
            }
            bb.ajE().c(this.mTbPageContext, new String[]{this.hGp.url});
        }
    }
}
