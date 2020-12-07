package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.d.a;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ThreadSkinView extends TbImageView {
    private SkinInfo lyL;
    private a.C0870a lyM;
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

    public void setData(TbPageContext tbPageContext, SkinInfo skinInfo, a.C0870a c0870a) {
        if (tbPageContext == null || skinInfo == null || StringUtils.isNull(skinInfo.skin)) {
            setVisibility(8);
            return;
        }
        this.mTbPageContext = tbPageContext;
        if (this.lyL != skinInfo && c0870a != null) {
            this.lyM = c0870a;
            this.lyM.delete(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE);
            this.lyM.gw("obj_id", skinInfo.obj_id);
            this.lyM.gw(TiebaInitialize.Params.OBJ_URL, skinInfo.url);
            this.lyM.gw("obj_name", skinInfo.monitor_id);
            this.lyM.gw(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "VIEW_TRUE");
            this.lyM.save();
        }
        this.lyL = skinInfo;
        int equipmentWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = equipmentWidth;
        if (!StringUtils.isNull(skinInfo.skin_size)) {
            String[] split = skinInfo.skin_size.split(",");
            if (split.length > 1) {
                int i = com.baidu.adp.lib.f.b.toInt(split[0].trim(), -1);
                int i2 = com.baidu.adp.lib.f.b.toInt(split[1].trim(), -1);
                if (i > 0 && i2 > 0) {
                    layoutParams.height = (int) ((i2 / i) * layoutParams.width);
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
        if (this.lyL != null && !StringUtils.isNull(this.lyL.url)) {
            if (this.lyM != null) {
                this.lyM.delete(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE);
                this.lyM.gw(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "CLICK");
                this.lyM.save();
            }
            bf.bua().b(this.mTbPageContext, new String[]{this.lyL.url});
        }
    }
}
