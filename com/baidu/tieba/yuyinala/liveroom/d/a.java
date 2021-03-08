package com.baidu.tieba.yuyinala.liveroom.d;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a {
    private ab aED;
    private ViewGroup bSB;
    private boolean gPW = true;
    private ViewGroup.LayoutParams hvN = new ViewGroup.LayoutParams(-2, -1);
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    protected c owo;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.bSB = viewGroup;
        bOf();
    }

    private void bOf() {
        this.mParentView = new FrameLayout(this.bSB.getContext());
        this.mParentView.setId(a.f.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.bSB.addView(this.mParentView, this.hvN);
    }

    public void a(ab abVar, b bVar) {
        if (abVar != null && abVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aED = abVar;
            if (this.mParentView == null || this.bSB.indexOfChild(this.mParentView) < 0) {
                bOf();
                this.mParentView.setVisibility(this.gPW ? 0 : 8);
            }
            if (this.owo == null || (this.mParentView != null && this.mParentView.indexOfChild(this.owo.getView()) < 0)) {
                this.owo = new c(this.mTbPageContext);
                this.mParentView.addView(this.owo.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.owo.ccG().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.owo.ccF();
                        a.this.owo.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.e.back_to_come_logo);
            bVar2.vt(a.h.ala_back_to_come_title);
            this.owo.a(bVar2);
            this.owo.show();
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.gPW = true;
        mv(z);
    }

    private void mv(boolean z) {
        if (this.owo != null && this.owo.getView() != null && (this.owo.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.owo.getView().getParent()).removeView(this.owo.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
