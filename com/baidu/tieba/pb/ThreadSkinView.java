package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.m.b;
import d.a.c.e.p.l;
import d.a.k0.d3.j0.a;
import tbclient.SkinInfo;
/* loaded from: classes4.dex */
public class ThreadSkinView extends TbImageView {
    public TbPageContext w0;
    public SkinInfo x0;
    public a.b y0;

    public ThreadSkinView(Context context) {
        super(context);
        G();
    }

    public final void G() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        SkinInfo skinInfo = this.x0;
        if (skinInfo == null || StringUtils.isNull(skinInfo.url)) {
            return;
        }
        a.b bVar = this.y0;
        if (bVar != null) {
            bVar.c(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE);
            this.y0.e(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "CLICK");
            this.y0.f();
        }
        UrlManager.getInstance().dealOneLink(this.w0, new String[]{this.x0.url});
    }

    public void setData(TbPageContext tbPageContext, SkinInfo skinInfo, a.b bVar) {
        if (tbPageContext != null && skinInfo != null && !StringUtils.isNull(skinInfo.skin)) {
            this.w0 = tbPageContext;
            if (this.x0 != skinInfo && bVar != null) {
                this.y0 = bVar;
                bVar.c(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE);
                this.y0.e("obj_id", skinInfo.obj_id);
                this.y0.e(TiebaStatic.Params.OBJ_URL, skinInfo.url);
                this.y0.e("obj_name", skinInfo.monitor_id);
                this.y0.e(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "VIEW_TRUE");
                this.y0.f();
            }
            this.x0 = skinInfo;
            int k = l.k(tbPageContext.getPageActivity());
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = k;
            if (!StringUtils.isNull(skinInfo.skin_size)) {
                String[] split = skinInfo.skin_size.split(",");
                if (split.length > 1) {
                    int d2 = b.d(split[0].trim(), -1);
                    int d3 = b.d(split[1].trim(), -1);
                    if (d2 > 0 && d3 > 0) {
                        layoutParams.height = (int) (layoutParams.width * (d3 / d2));
                    } else {
                        layoutParams.height = (int) tbPageContext.getResources().getDimension(R.dimen.ds80);
                    }
                }
            } else {
                layoutParams.height = (int) tbPageContext.getResources().getDimension(R.dimen.ds80);
            }
            setLayoutParams(layoutParams);
            V(skinInfo.skin, 10, false);
            setOnClickListener(this);
            setScaleType(ImageView.ScaleType.CENTER_CROP);
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    public ThreadSkinView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        G();
    }

    public ThreadSkinView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        G();
    }
}
