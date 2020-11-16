package com.baidu.tieba.yuyinala.liveroom.d;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private w aDh;
    private ViewGroup bIc;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    protected c nWC;
    private boolean gvD = true;
    private ViewGroup.LayoutParams gYE = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.bIc = viewGroup;
        bQz();
    }

    private void bQz() {
        this.mParentView = new FrameLayout(this.bIc.getContext());
        this.mParentView.setId(a.f.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.bIc.addView(this.mParentView, this.gYE);
    }

    public void a(w wVar, b bVar) {
        if (wVar != null && wVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aDh = wVar;
            if (this.mParentView == null || this.bIc.indexOfChild(this.mParentView) < 0) {
                bQz();
                this.mParentView.setVisibility(this.gvD ? 0 : 8);
            }
            if (this.nWC == null || (this.mParentView != null && this.mParentView.indexOfChild(this.nWC.getView()) < 0)) {
                this.nWC = new c(this.mTbPageContext);
                this.mParentView.addView(this.nWC.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.nWC.bYD().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.nWC.bYC();
                        a.this.nWC.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.e.back_to_come_logo);
            bVar2.vW(a.h.ala_back_to_come_title);
            this.nWC.a(bVar2);
            this.nWC.show();
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.gvD = true;
        lD(z);
    }

    private void lD(boolean z) {
        if (this.nWC != null && this.nWC.getView() != null && (this.nWC.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.nWC.getView().getParent()).removeView(this.nWC.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
