package com.baidu.tieba.lego.card.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
/* loaded from: classes8.dex */
public class ImmersiveVideoCardViewEx extends BaseCardView<ImmersiveVideoCardEx> implements com.baidu.tieba.play.d, com.baidu.tieba.play.e {
    private o kVM;
    private a kVN;
    private ViewGroup mRootView;

    public ImmersiveVideoCardViewEx(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZQ() {
        this.mRootView = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.card_item_video_thread, (ViewGroup) null);
        this.kVM = new o(this.eSJ, this.mRootView.findViewById(R.id.layout_video_container));
        this.kVN = new a(this.eSJ, this.mRootView);
        this.kVM.d(this.kVN);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(ImmersiveVideoCardEx immersiveVideoCardEx, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(ImmersiveVideoCardEx immersiveVideoCardEx) {
        if (immersiveVideoCardEx.getVideoInfo() != null) {
            this.kVM.fK(immersiveVideoCardEx.getShowExtra(), LogConfig.KEY_FEED);
            this.kVM.a(immersiveVideoCardEx.getVideoInfo(), immersiveVideoCardEx.getPage());
            boolean z = immersiveVideoCardEx.getVideoInfo().kTP;
            this.kVM.ty(z);
            this.kVM.tw(z);
            this.kVN.tw(z);
            setTag(this);
            dab();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cZZ() {
        if (this.kVN != null) {
            this.kVN.cZZ();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void coK() {
        if (this.kVN != null) {
            this.kVN.coK();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void daa() {
        if (this.kVN != null) {
            this.kVN.daa();
        }
    }

    public void dab() {
        if (this.kVN != null) {
            this.kVN.dab();
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.kVM != null && this.kVM.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return this.kVM != null && this.kVM.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.kVM != null) {
            this.kVM.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.kVM != null) {
            this.kVM.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.kVM != null) {
            return this.kVM.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.kVM != null) {
            return this.kVM.getPlayUrl();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.kVM != null) {
            return this.kVM.getCurrentPosition();
        }
        return 0;
    }
}
