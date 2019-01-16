package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.d.a;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ThreadSkinView extends TbImageView {
    private SkinInfo fRM;
    private a.C0316a fRN;
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

    public void setData(TbPageContext tbPageContext, SkinInfo skinInfo, a.C0316a c0316a) {
        if (tbPageContext == null || skinInfo == null || StringUtils.isNull(skinInfo.skin)) {
            setVisibility(8);
            return;
        }
        this.mTbPageContext = tbPageContext;
        if (this.fRM != skinInfo && c0316a != null) {
            this.fRN = c0316a;
            this.fRN.delete(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE);
            this.fRN.cO(VideoPlayActivityConfig.OBJ_ID, skinInfo.obj_id);
            this.fRN.cO("obj_url", skinInfo.url);
            this.fRN.cO("obj_name", skinInfo.monitor_id);
            this.fRN.cO(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "VIEW_TRUE");
            this.fRN.save();
        }
        this.fRM = skinInfo;
        int aO = l.aO(tbPageContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = aO;
        if (!StringUtils.isNull(skinInfo.skin_size)) {
            String[] split = skinInfo.skin_size.split(",");
            if (split.length > 1) {
                int l = com.baidu.adp.lib.g.b.l(split[0].trim(), -1);
                int l2 = com.baidu.adp.lib.g.b.l(split[1].trim(), -1);
                if (l > 0 && l2 > 0) {
                    layoutParams.height = (int) ((l2 / l) * layoutParams.width);
                } else {
                    layoutParams.height = (int) tbPageContext.getResources().getDimension(e.C0210e.ds80);
                }
            }
        } else {
            layoutParams.height = (int) tbPageContext.getResources().getDimension(e.C0210e.ds80);
        }
        setLayoutParams(layoutParams);
        startLoad(skinInfo.skin, 10, false);
        setOnClickListener(this);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fRM != null && !StringUtils.isNull(this.fRM.url)) {
            if (this.fRN != null) {
                this.fRN.delete(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE);
                this.fRN.cO(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "CLICK");
                this.fRN.save();
            }
            ay.Es().c(this.mTbPageContext, new String[]{this.fRM.url});
        }
    }
}
