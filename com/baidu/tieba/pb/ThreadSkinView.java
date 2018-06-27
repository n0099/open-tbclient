package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.d.a;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ThreadSkinView extends TbImageView {
    private SkinInfo fqs;
    private a.C0236a fqt;
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

    public void setData(TbPageContext tbPageContext, SkinInfo skinInfo, a.C0236a c0236a) {
        if (tbPageContext == null || skinInfo == null || StringUtils.isNull(skinInfo.skin)) {
            setVisibility(8);
            return;
        }
        this.mTbPageContext = tbPageContext;
        if (this.fqs != skinInfo && c0236a != null) {
            this.fqt = c0236a;
            this.fqt.delete(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE);
            this.fqt.cp(VideoPlayActivityConfig.OBJ_ID, skinInfo.obj_id);
            this.fqt.cp("obj_url", skinInfo.url);
            this.fqt.cp("obj_name", skinInfo.monitor_id);
            this.fqt.cp(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "VIEW_TRUE");
            this.fqt.save();
        }
        this.fqs = skinInfo;
        int ah = l.ah(tbPageContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = ah;
        if (!StringUtils.isNull(skinInfo.skin_size)) {
            String[] split = skinInfo.skin_size.split(",");
            if (split.length > 1) {
                int g = com.baidu.adp.lib.g.b.g(split[0].trim(), -1);
                int g2 = com.baidu.adp.lib.g.b.g(split[1].trim(), -1);
                if (g > 0 && g2 > 0) {
                    layoutParams.height = (int) ((g2 / g) * layoutParams.width);
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
        if (this.fqs != null && !StringUtils.isNull(this.fqs.url)) {
            if (this.fqt != null) {
                this.fqt.delete(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE);
                this.fqt.cp(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "CLICK");
                this.fqt.save();
            }
            az.zV().c(this.mTbPageContext, new String[]{this.fqs.url});
        }
    }
}
