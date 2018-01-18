package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.d.a;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ThreadSkinView extends TbImageView {
    private SkinInfo fBu;
    private a.C0154a fBv;
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

    public void a(TbPageContext tbPageContext, SkinInfo skinInfo, a.C0154a c0154a) {
        if (tbPageContext == null || skinInfo == null || StringUtils.isNull(skinInfo.skin)) {
            setVisibility(8);
            return;
        }
        this.mTbPageContext = tbPageContext;
        if (this.fBu != skinInfo && c0154a != null) {
            this.fBv = c0154a;
            this.fBv.dV("action_type");
            this.fBv.cd("obj_id", skinInfo.obj_id);
            this.fBv.cd("obj_url", skinInfo.url);
            this.fBv.cd("obj_name", skinInfo.monitor_id);
            this.fBv.cd("action_type", "VIEW_TRUE");
            this.fBv.save();
        }
        this.fBu = skinInfo;
        int ao = l.ao(tbPageContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = ao;
        if (!StringUtils.isNull(skinInfo.skin_size)) {
            String[] split = skinInfo.skin_size.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length > 1) {
                int h = com.baidu.adp.lib.g.b.h(split[0].trim(), -1);
                int h2 = com.baidu.adp.lib.g.b.h(split[1].trim(), -1);
                if (h > 0 && h2 > 0) {
                    layoutParams.height = (int) ((h2 / h) * layoutParams.width);
                } else {
                    layoutParams.height = (int) tbPageContext.getResources().getDimension(d.e.ds80);
                }
            }
        } else {
            layoutParams.height = (int) tbPageContext.getResources().getDimension(d.e.ds80);
        }
        setLayoutParams(layoutParams);
        startLoad(skinInfo.skin, 10, false);
        setOnClickListener(this);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fBu != null && !StringUtils.isNull(this.fBu.url)) {
            if (this.fBv != null) {
                this.fBv.dV("action_type");
                this.fBv.cd("action_type", "CLICK");
                this.fBv.save();
            }
            av.CZ().c(this.mTbPageContext, new String[]{this.fBu.url});
        }
    }
}
