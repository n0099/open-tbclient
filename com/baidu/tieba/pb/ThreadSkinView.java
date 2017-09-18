package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.d.a;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ThreadSkinView extends TbImageView {
    private SkinInfo eDa;
    private a.C0123a eDb;
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

    public void a(TbPageContext tbPageContext, SkinInfo skinInfo, a.C0123a c0123a) {
        if (tbPageContext == null || skinInfo == null || StringUtils.isNull(skinInfo.skin)) {
            setVisibility(8);
            return;
        }
        this.mTbPageContext = tbPageContext;
        if (this.eDa != skinInfo && c0123a != null) {
            this.eDb = c0123a;
            this.eDb.dO("action_type");
            this.eDb.cj("obj_id", skinInfo.obj_id);
            this.eDb.cj("obj_url", skinInfo.url);
            this.eDb.cj("obj_name", skinInfo.monitor_id);
            this.eDb.cj("action_type", "VIEW_TRUE");
            this.eDb.save();
        }
        this.eDa = skinInfo;
        int ae = k.ae(tbPageContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = ae;
        if (!StringUtils.isNull(skinInfo.skin_size)) {
            String[] split = skinInfo.skin_size.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length > 1) {
                int g = com.baidu.adp.lib.g.b.g(split[0].trim(), -1);
                int g2 = com.baidu.adp.lib.g.b.g(split[1].trim(), -1);
                if (g > 0 && g2 > 0) {
                    layoutParams.height = (int) ((g2 / g) * layoutParams.width);
                } else {
                    layoutParams.height = (int) tbPageContext.getResources().getDimension(d.f.ds80);
                }
            }
        } else {
            layoutParams.height = (int) tbPageContext.getResources().getDimension(d.f.ds80);
        }
        setLayoutParams(layoutParams);
        c(skinInfo.skin, 10, false);
        setOnClickListener(this);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eDa != null && !StringUtils.isNull(this.eDa.url)) {
            if (this.eDb != null) {
                this.eDb.dO("action_type");
                this.eDb.cj("action_type", "CLICK");
                this.eDb.save();
            }
            au.wd().c(this.mTbPageContext, new String[]{this.eDa.url});
        }
    }
}
