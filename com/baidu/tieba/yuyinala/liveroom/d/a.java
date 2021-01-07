package com.baidu.tieba.yuyinala.liveroom.d;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a {
    private x aGe;
    private ViewGroup bRX;
    private boolean gPZ = true;
    private ViewGroup.LayoutParams hul = new ViewGroup.LayoutParams(-2, -1);
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    protected c oov;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.bRX = viewGroup;
        bRj();
    }

    private void bRj() {
        this.mParentView = new FrameLayout(this.bRX.getContext());
        this.mParentView.setId(a.f.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.bRX.addView(this.mParentView, this.hul);
    }

    public void a(x xVar, b bVar) {
        if (xVar != null && xVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aGe = xVar;
            if (this.mParentView == null || this.bRX.indexOfChild(this.mParentView) < 0) {
                bRj();
                this.mParentView.setVisibility(this.gPZ ? 0 : 8);
            }
            if (this.oov == null || (this.mParentView != null && this.mParentView.indexOfChild(this.oov.getView()) < 0)) {
                this.oov = new c(this.mTbPageContext);
                this.mParentView.addView(this.oov.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.oov.cfq().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.oov.cfp();
                        a.this.oov.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.e.back_to_come_logo);
            bVar2.wM(a.h.ala_back_to_come_title);
            this.oov.a(bVar2);
            this.oov.show();
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.gPZ = true;
        mv(z);
    }

    private void mv(boolean z) {
        if (this.oov != null && this.oov.getView() != null && (this.oov.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.oov.getView().getParent()).removeView(this.oov.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
