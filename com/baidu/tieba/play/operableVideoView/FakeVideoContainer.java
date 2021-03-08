package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FakeVideoContainer extends RelativeLayout implements View.OnClickListener {
    protected View.OnClickListener ahC;
    protected View.OnClickListener alm;
    private TbImageView anK;
    private ImageView anM;
    private boolean anT;
    private cb eLr;
    private View mLv;
    private EMTextView mLw;

    public FakeVideoContainer(Context context) {
        super(context);
        this.alm = null;
        this.ahC = null;
        init();
    }

    public FakeVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alm = null;
        this.ahC = null;
        init();
    }

    public FakeVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alm = null;
        this.ahC = null;
        init();
    }

    protected void init() {
        inflate(getContext(), R.layout.fake_video_container, this);
        this.anK = (TbImageView) findViewById(R.id.video_thumbnail);
        this.mLv = findViewById(R.id.black_mask);
        this.anM = (ImageView) findViewById(R.id.video_play);
        this.mLw = (EMTextView) findViewById(R.id.fake_video_info);
        this.anM.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        com.baidu.tbadk.core.elementsMaven.c.br(this.mLw).nZ(R.color.CAM_X0101).ob(R.string.F_X01);
        this.anK.bGs();
        this.anK.setDrawCorner(false);
        this.anK.setPlaceHolder(3);
        setOnClickListener(this);
    }

    public void setData(cb cbVar) {
        if (cbVar != null && cbVar.boj() != null) {
            this.anT = cbVar.boj().is_vertical.intValue() == 1;
            this.eLr = cbVar;
            this.anK.setPlaceHolder(3);
            if (cbVar.boj().thumbnail_url.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || cbVar.boj().thumbnail_url.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
                this.anK.startLoad(cbVar.boj().thumbnail_url, 10, false);
            } else {
                this.anK.startLoad(cbVar.boj().thumbnail_url, 32, false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.b(getContext(), getContext().getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bqF();
    }
}
