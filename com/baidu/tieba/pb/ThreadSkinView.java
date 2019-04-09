package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.d.a;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ThreadSkinView extends TbImageView {
    private SkinInfo hhN;
    private a.C0390a hhO;
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

    public void setData(TbPageContext tbPageContext, SkinInfo skinInfo, a.C0390a c0390a) {
        if (tbPageContext == null || skinInfo == null || StringUtils.isNull(skinInfo.skin)) {
            setVisibility(8);
            return;
        }
        this.mTbPageContext = tbPageContext;
        if (this.hhN != skinInfo && c0390a != null) {
            this.hhO = c0390a;
            this.hhO.delete("action_type");
            this.hhO.dY(VideoPlayActivityConfig.OBJ_ID, skinInfo.obj_id);
            this.hhO.dY("obj_url", skinInfo.url);
            this.hhO.dY("obj_name", skinInfo.monitor_id);
            this.hhO.dY("action_type", "VIEW_TRUE");
            this.hhO.save();
        }
        this.hhN = skinInfo;
        int aO = l.aO(tbPageContext.getPageActivity());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = aO;
        if (!StringUtils.isNull(skinInfo.skin_size)) {
            String[] split = skinInfo.skin_size.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length > 1) {
                int l = com.baidu.adp.lib.g.b.l(split[0].trim(), -1);
                int l2 = com.baidu.adp.lib.g.b.l(split[1].trim(), -1);
                if (l > 0 && l2 > 0) {
                    layoutParams.height = (int) ((l2 / l) * layoutParams.width);
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
        if (this.hhN != null && !StringUtils.isNull(this.hhN.url)) {
            if (this.hhO != null) {
                this.hhO.delete("action_type");
                this.hhO.dY("action_type", "CLICK");
                this.hhO.save();
            }
            ba.adA().c(this.mTbPageContext, new String[]{this.hhN.url});
        }
    }
}
