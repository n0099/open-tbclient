package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.w;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ThreadSkinView extends TbImageView {
    private SkinInfo egy;
    private a.C0082a egz;
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

    public void a(TbPageContext tbPageContext, SkinInfo skinInfo, a.C0082a c0082a) {
        if (tbPageContext == null || skinInfo == null || StringUtils.isNull(skinInfo.skin)) {
            setVisibility(8);
            return;
        }
        this.mTbPageContext = tbPageContext;
        if (this.egy != skinInfo && c0082a != null) {
            this.egz = c0082a;
            this.egz.delete("action_type");
            this.egz.cb("obj_id", skinInfo.obj_id);
            this.egz.cb("obj_url", skinInfo.url);
            this.egz.cb("obj_name", skinInfo.monitor_id);
            this.egz.cb("action_type", "VIEW_TRUE");
            this.egz.save();
        }
        this.egy = skinInfo;
        int af = k.af(tbPageContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = af;
        if (!StringUtils.isNull(skinInfo.skin_size)) {
            String[] split = skinInfo.skin_size.split(",");
            if (split.length > 1) {
                int g = com.baidu.adp.lib.g.b.g(split[0].trim(), -1);
                int g2 = com.baidu.adp.lib.g.b.g(split[1].trim(), -1);
                if (g > 0 && g2 > 0) {
                    layoutParams.height = (int) ((g2 / g) * layoutParams.width);
                } else {
                    layoutParams.height = (int) tbPageContext.getResources().getDimension(w.f.ds80);
                }
            }
        } else {
            layoutParams.height = (int) tbPageContext.getResources().getDimension(w.f.ds80);
        }
        setLayoutParams(layoutParams);
        c(skinInfo.skin, 10, false);
        setOnClickListener(this);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.egy != null && !StringUtils.isNull(this.egy.url)) {
            if (this.egz != null) {
                this.egz.delete("action_type");
                this.egz.cb("action_type", "CLICK");
                this.egz.save();
            }
            bb.vy().c(this.mTbPageContext, new String[]{this.egy.url});
        }
    }
}
