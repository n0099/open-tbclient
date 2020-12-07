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
    private w aFN;
    private ViewGroup bNk;
    private boolean gEn = true;
    private ViewGroup.LayoutParams hin = new ViewGroup.LayoutParams(-2, -1);
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    protected c olA;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.bNk = viewGroup;
        bUj();
    }

    private void bUj() {
        this.mParentView = new FrameLayout(this.bNk.getContext());
        this.mParentView.setId(a.f.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.bNk.addView(this.mParentView, this.hin);
    }

    public void a(w wVar, b bVar) {
        if (wVar != null && wVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aFN = wVar;
            if (this.mParentView == null || this.bNk.indexOfChild(this.mParentView) < 0) {
                bUj();
                this.mParentView.setVisibility(this.gEn ? 0 : 8);
            }
            if (this.olA == null || (this.mParentView != null && this.mParentView.indexOfChild(this.olA.getView()) < 0)) {
                this.olA = new c(this.mTbPageContext);
                this.mParentView.addView(this.olA.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.olA.ccy().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.olA.ccx();
                        a.this.olA.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.e.back_to_come_logo);
            bVar2.wB(a.h.ala_back_to_come_title);
            this.olA.a(bVar2);
            this.olA.show();
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.gEn = true;
        lY(z);
    }

    private void lY(boolean z) {
        if (this.olA != null && this.olA.getView() != null && (this.olA.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.olA.getView().getParent()).removeView(this.olA.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
