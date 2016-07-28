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
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.u;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ThreadSkinView extends TbImageView {
    private SkinInfo dWa;
    private a.C0076a dWb;
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
        if (this.dWa != skinInfo && c0076a != null) {
            this.dWb = c0076a;
            this.dWb.dt("action_type");
            this.dWb.bR("obj_id", skinInfo.obj_id);
            this.dWb.bR("obj_url", skinInfo.url);
            this.dWb.bR("obj_name", skinInfo.monitor_id);
            this.dWb.bR("action_type", "VIEW_TRUE");
            this.dWb.save();
        }
        this.dWa = skinInfo;
        int A = k.A(tbPageContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = A;
        if (!StringUtils.isNull(skinInfo.skin_size)) {
            String[] split = skinInfo.skin_size.split(",");
            if (split.length > 1) {
                int g = com.baidu.adp.lib.h.b.g(split[0].trim(), -1);
                int g2 = com.baidu.adp.lib.h.b.g(split[1].trim(), -1);
                if (g > 0 && g2 > 0) {
                    layoutParams.height = (int) ((g2 / g) * layoutParams.width);
                } else {
                    layoutParams.height = (int) tbPageContext.getResources().getDimension(u.e.ds80);
                }
            }
        } else {
            layoutParams.height = (int) tbPageContext.getResources().getDimension(u.e.ds80);
        }
        setLayoutParams(layoutParams);
        c(skinInfo.skin, 10, false);
        setOnClickListener(this);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dWa != null && !StringUtils.isNull(this.dWa.url)) {
            if (this.dWb != null) {
                this.dWb.dt("action_type");
                this.dWb.bR("action_type", "CLICK");
                this.dWb.save();
            }
            bi.us().c(this.mTbPageContext, new String[]{this.dWa.url});
        }
    }
}
