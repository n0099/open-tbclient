package com.baidu.tieba.yuyinala.liveroom.d;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a {
    private x aBr;
    private ViewGroup bNl;
    private boolean gLt = true;
    private ViewGroup.LayoutParams hpF = new ViewGroup.LayoutParams(-2, -1);
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    protected c ojP;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.bNl = viewGroup;
        bNr();
    }

    private void bNr() {
        this.mParentView = new FrameLayout(this.bNl.getContext());
        this.mParentView.setId(a.f.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.bNl.addView(this.mParentView, this.hpF);
    }

    public void a(x xVar, b bVar) {
        if (xVar != null && xVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aBr = xVar;
            if (this.mParentView == null || this.bNl.indexOfChild(this.mParentView) < 0) {
                bNr();
                this.mParentView.setVisibility(this.gLt ? 0 : 8);
            }
            if (this.ojP == null || (this.mParentView != null && this.mParentView.indexOfChild(this.ojP.getView()) < 0)) {
                this.ojP = new c(this.mTbPageContext);
                this.mParentView.addView(this.ojP.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.ojP.cby().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.ojP.cbx();
                        a.this.ojP.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.e.back_to_come_logo);
            bVar2.vg(a.h.ala_back_to_come_title);
            this.ojP.a(bVar2);
            this.ojP.show();
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.gLt = true;
        mr(z);
    }

    private void mr(boolean z) {
        if (this.ojP != null && this.ojP.getView() != null && (this.ojP.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ojP.getView().getParent()).removeView(this.ojP.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
