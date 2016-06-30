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
    private SkinInfo dJR;
    private a.C0077a dJS;
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

    public void a(TbPageContext tbPageContext, SkinInfo skinInfo, a.C0077a c0077a) {
        if (tbPageContext == null || skinInfo == null || StringUtils.isNull(skinInfo.skin)) {
            setVisibility(8);
            return;
        }
        this.mTbPageContext = tbPageContext;
        if (this.dJR != skinInfo && c0077a != null) {
            this.dJS = c0077a;
            this.dJS.du("action_type");
            this.dJS.bM("obj_id", skinInfo.obj_id);
            this.dJS.bM("obj_url", skinInfo.url);
            this.dJS.bM("obj_name", skinInfo.monitor_id);
            this.dJS.bM("action_type", "VIEW_TRUE");
            this.dJS.save();
        }
        this.dJR = skinInfo;
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
        if (this.dJR != null && !StringUtils.isNull(this.dJR.url)) {
            if (this.dJS != null) {
                this.dJS.du("action_type");
                this.dJS.bM("action_type", "CLICK");
                this.dJS.save();
            }
            bi.us().c(this.mTbPageContext, new String[]{this.dJR.url});
        }
    }
}
