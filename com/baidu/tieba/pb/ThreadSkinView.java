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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.d.a;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ThreadSkinView extends TbImageView {
    private SkinInfo hIl;
    private a.C0425a hIm;
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

    public void setData(TbPageContext tbPageContext, SkinInfo skinInfo, a.C0425a c0425a) {
        if (tbPageContext == null || skinInfo == null || StringUtils.isNull(skinInfo.skin)) {
            setVisibility(8);
            return;
        }
        this.mTbPageContext = tbPageContext;
        if (this.hIl != skinInfo && c0425a != null) {
            this.hIm = c0425a;
            this.hIm.nX("action_type");
            this.hIm.eo(VideoPlayActivityConfig.OBJ_ID, skinInfo.obj_id);
            this.hIm.eo("obj_url", skinInfo.url);
            this.hIm.eo("obj_name", skinInfo.monitor_id);
            this.hIm.eo("action_type", "VIEW_TRUE");
            this.hIm.save();
        }
        this.hIl = skinInfo;
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
        if (this.hIl != null && !StringUtils.isNull(this.hIl.url)) {
            if (this.hIm != null) {
                this.hIm.nX("action_type");
                this.hIm.eo("action_type", "CLICK");
                this.hIm.save();
            }
            ba.ajK().c(this.mTbPageContext, new String[]{this.hIl.url});
        }
    }
}
