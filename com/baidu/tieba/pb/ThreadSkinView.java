package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.d.a;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ThreadSkinView extends TbImageView {
    private SkinInfo eif;
    private a.C0076a eig;
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

    public void a(TbPageContext tbPageContext, SkinInfo skinInfo, a.C0076a c0076a) {
        if (tbPageContext == null || skinInfo == null || StringUtils.isNull(skinInfo.skin)) {
            setVisibility(8);
            return;
        }
        this.mTbPageContext = tbPageContext;
        if (this.eif != skinInfo && c0076a != null) {
            this.eig = c0076a;
            this.eig.dw("action_type");
            this.eig.bS("obj_id", skinInfo.obj_id);
            this.eig.bS("obj_url", skinInfo.url);
            this.eig.bS("obj_name", skinInfo.monitor_id);
            this.eig.bS("action_type", "VIEW_TRUE");
            this.eig.save();
        }
        this.eif = skinInfo;
        int K = k.K(tbPageContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = K;
        if (!StringUtils.isNull(skinInfo.skin_size)) {
            String[] split = skinInfo.skin_size.split(",");
            if (split.length > 1) {
                int g = com.baidu.adp.lib.h.b.g(split[0].trim(), -1);
                int g2 = com.baidu.adp.lib.h.b.g(split[1].trim(), -1);
                if (g > 0 && g2 > 0) {
                    layoutParams.height = (int) ((g2 / g) * layoutParams.width);
                } else {
                    layoutParams.height = (int) tbPageContext.getResources().getDimension(t.e.ds80);
                }
            }
        } else {
            layoutParams.height = (int) tbPageContext.getResources().getDimension(t.e.ds80);
        }
        setLayoutParams(layoutParams);
        c(skinInfo.skin, 10, false);
        setOnClickListener(this);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eif != null && !StringUtils.isNull(this.eif.url)) {
            if (this.eig != null) {
                this.eig.dw("action_type");
                this.eig.bS("action_type", "CLICK");
                this.eig.save();
            }
            bi.vx().c(this.mTbPageContext, new String[]{this.eif.url});
        }
    }
}
