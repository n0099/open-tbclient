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
    protected View.OnClickListener agk;
    protected View.OnClickListener ajT;
    private boolean amB;
    private TbImageView ams;
    private ImageView amu;
    private cb eJQ;
    private View mJe;
    private EMTextView mJf;

    public FakeVideoContainer(Context context) {
        super(context);
        this.ajT = null;
        this.agk = null;
        init();
    }

    public FakeVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajT = null;
        this.agk = null;
        init();
    }

    public FakeVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajT = null;
        this.agk = null;
        init();
    }

    protected void init() {
        inflate(getContext(), R.layout.fake_video_container, this);
        this.ams = (TbImageView) findViewById(R.id.video_thumbnail);
        this.mJe = findViewById(R.id.black_mask);
        this.amu = (ImageView) findViewById(R.id.video_play);
        this.mJf = (EMTextView) findViewById(R.id.fake_video_info);
        this.amu.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        com.baidu.tbadk.core.elementsMaven.c.br(this.mJf).nY(R.color.CAM_X0101).oa(R.string.F_X01);
        this.ams.bGo();
        this.ams.setDrawCorner(false);
        this.ams.setPlaceHolder(3);
        setOnClickListener(this);
    }

    public void setData(cb cbVar) {
        if (cbVar != null && cbVar.boh() != null) {
            this.amB = cbVar.boh().is_vertical.intValue() == 1;
            this.eJQ = cbVar;
            this.ams.setPlaceHolder(3);
            if (cbVar.boh().thumbnail_url.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || cbVar.boh().thumbnail_url.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
                this.ams.startLoad(cbVar.boh().thumbnail_url, 10, false);
            } else {
                this.ams.startLoad(cbVar.boh().thumbnail_url, 32, false);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.b(getContext(), getContext().getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bqD();
    }
}
