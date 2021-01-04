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
    protected View.OnClickListener ahj;
    protected View.OnClickListener akV;
    private boolean anC;
    private TbImageView ant;
    private ImageView anv;
    private bz eMv;
    private View mED;
    private EMTextView mEE;

    public FakeVideoContainer(Context context) {
        super(context);
        this.akV = null;
        this.ahj = null;
        init();
    }

    public FakeVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akV = null;
        this.ahj = null;
        init();
    }

    public FakeVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akV = null;
        this.ahj = null;
        init();
    }

    protected void init() {
        inflate(getContext(), R.layout.fake_video_container, this);
        this.ant = (TbImageView) findViewById(R.id.video_thumbnail);
        this.mED = findViewById(R.id.black_mask);
        this.anv = (ImageView) findViewById(R.id.video_play);
        this.mEE = (EMTextView) findViewById(R.id.fake_video_info);
        this.anv.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ao.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        com.baidu.tbadk.core.elementsMaven.c.bv(this.mEE).pC(R.color.CAM_X0101).pE(R.string.F_X01);
        this.ant.bJL();
        this.ant.setDrawCorner(false);
        this.ant.setPlaceHolder(3);
        setOnClickListener(this);
    }

    public void setData(bz bzVar) {
        if (bzVar != null && bzVar.brH() != null) {
            this.anC = bzVar.brH().is_vertical.intValue() == 1;
            this.eMv = bzVar;
            this.ant.setPlaceHolder(3);
            if (bzVar.brH().thumbnail_url.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || bzVar.brH().thumbnail_url.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
                this.ant.startLoad(bzVar.brH().thumbnail_url, 10, false);
            } else {
                this.ant.startLoad(bzVar.brH().thumbnail_url, 32, false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.b(getContext(), getContext().getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bud();
    }
}
