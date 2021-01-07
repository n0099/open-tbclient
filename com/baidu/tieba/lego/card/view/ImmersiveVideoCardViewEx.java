package com.baidu.tieba.lego.card.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
/* loaded from: classes9.dex */
public class ImmersiveVideoCardViewEx extends BaseCardView<ImmersiveVideoCardEx> implements com.baidu.tieba.play.d, com.baidu.tieba.play.e {
    private o lar;
    private a las;
    private ViewGroup mRootView;

    public ImmersiveVideoCardViewEx(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddI() {
        this.mRootView = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.card_item_video_thread, (ViewGroup) null);
        this.lar = new o(this.eXu, this.mRootView.findViewById(R.id.layout_video_container));
        this.las = new a(this.eXu, this.mRootView);
        this.lar.d(this.las);
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
            this.lar.fL(immersiveVideoCardEx.getShowExtra(), LogConfig.KEY_FEED);
            this.lar.a(immersiveVideoCardEx.getVideoInfo(), immersiveVideoCardEx.getPage());
            boolean z = immersiveVideoCardEx.getVideoInfo().kYu;
            this.lar.tC(z);
            this.lar.tA(z);
            this.las.tA(z);
            setTag(this);
            ddT();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void ddR() {
        if (this.las != null) {
            this.las.ddR();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void csC() {
        if (this.las != null) {
            this.las.csC();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void ddS() {
        if (this.las != null) {
            this.las.ddS();
        }
    }

    public void ddT() {
        if (this.las != null) {
            this.las.ddT();
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.lar != null && this.lar.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return this.lar != null && this.lar.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.lar != null) {
            this.lar.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.lar != null) {
            this.lar.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.lar != null) {
            return this.lar.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.lar != null) {
            return this.lar.getPlayUrl();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.lar != null) {
            return this.lar.getCurrentPosition();
        }
        return 0;
    }
}
