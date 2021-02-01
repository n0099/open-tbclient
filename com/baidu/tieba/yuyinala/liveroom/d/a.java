package com.baidu.tieba.yuyinala.liveroom.d;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a {
    private ab aDd;
    private ViewGroup bRb;
    private boolean gNZ = true;
    private ViewGroup.LayoutParams htQ = new ViewGroup.LayoutParams(-2, -1);
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    protected c otI;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.bRb = viewGroup;
        bNS();
    }

    private void bNS() {
        this.mParentView = new FrameLayout(this.bRb.getContext());
        this.mParentView.setId(a.f.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.bRb.addView(this.mParentView, this.htQ);
    }

    public void a(ab abVar, b bVar) {
        if (abVar != null && abVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aDd = abVar;
            if (this.mParentView == null || this.bRb.indexOfChild(this.mParentView) < 0) {
                bNS();
                this.mParentView.setVisibility(this.gNZ ? 0 : 8);
            }
            if (this.otI == null || (this.mParentView != null && this.mParentView.indexOfChild(this.otI.getView()) < 0)) {
                this.otI = new c(this.mTbPageContext);
                this.mParentView.addView(this.otI.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.otI.cct().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.otI.ccs();
                        a.this.otI.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.e.back_to_come_logo);
            bVar2.vr(a.h.ala_back_to_come_title);
            this.otI.a(bVar2);
            this.otI.show();
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.gNZ = true;
        mv(z);
    }

    private void mv(boolean z) {
        if (this.otI != null && this.otI.getView() != null && (this.otI.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.otI.getView().getParent()).removeView(this.otI.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
