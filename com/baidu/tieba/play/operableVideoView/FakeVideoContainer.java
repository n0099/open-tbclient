package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FakeVideoContainer extends RelativeLayout implements View.OnClickListener {
    protected View.OnClickListener ags;
    protected View.OnClickListener ake;
    private TbImageView amC;
    private ImageView amE;
    private boolean amL;
    private bz eHK;
    private View mzT;
    private EMTextView mzU;

    public FakeVideoContainer(Context context) {
        super(context);
        this.ake = null;
        this.ags = null;
        init();
    }

    public FakeVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ake = null;
        this.ags = null;
        init();
    }

    public FakeVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ake = null;
        this.ags = null;
        init();
    }

    protected void init() {
        inflate(getContext(), R.layout.fake_video_container, this);
        this.amC = (TbImageView) findViewById(R.id.video_thumbnail);
        this.mzT = findViewById(R.id.black_mask);
        this.amE = (ImageView) findViewById(R.id.video_play);
        this.mzU = (EMTextView) findViewById(R.id.fake_video_info);
        this.amE.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ao.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        com.baidu.tbadk.core.elementsMaven.c.bv(this.mzU).nV(R.color.CAM_X0101).nX(R.string.F_X01);
        this.amC.bFU();
        this.amC.setDrawCorner(false);
        this.amC.setPlaceHolder(3);
        setOnClickListener(this);
    }

    public void setData(bz bzVar) {
        if (bzVar != null && bzVar.bnO() != null) {
            this.amL = bzVar.bnO().is_vertical.intValue() == 1;
            this.eHK = bzVar;
            this.amC.setPlaceHolder(3);
            if (bzVar.bnO().thumbnail_url.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || bzVar.bnO().thumbnail_url.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
                this.amC.startLoad(bzVar.bnO().thumbnail_url, 10, false);
            } else {
                this.amC.startLoad(bzVar.bnO().thumbnail_url, 32, false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.b(getContext(), getContext().getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bqk();
    }
}
