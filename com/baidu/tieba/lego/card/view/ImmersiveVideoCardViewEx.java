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
    private o ldP;
    private a ldQ;
    private ViewGroup mRootView;

    public ImmersiveVideoCardViewEx(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbO() {
        this.mRootView = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.card_item_video_thread, (ViewGroup) null);
        this.ldP = new o(this.eUY, this.mRootView.findViewById(R.id.layout_video_container));
        this.ldQ = new a(this.eUY, this.mRootView);
        this.ldP.d(this.ldQ);
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
            this.ldP.fK(immersiveVideoCardEx.getShowExtra(), LogConfig.KEY_FEED);
            this.ldP.a(immersiveVideoCardEx.getVideoInfo(), immersiveVideoCardEx.getPage());
            boolean z = immersiveVideoCardEx.getVideoInfo().lbS;
            this.ldP.tL(z);
            this.ldP.tJ(z);
            this.ldQ.tJ(z);
            setTag(this);
            dbZ();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void dbX() {
        if (this.ldQ != null) {
            this.ldQ.dbX();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void cpP() {
        if (this.ldQ != null) {
            this.ldQ.cpP();
        }
    }

    @Override // com.baidu.tieba.play.d
    public void dbY() {
        if (this.ldQ != null) {
            this.ldQ.dbY();
        }
    }

    public void dbZ() {
        if (this.ldQ != null) {
            this.ldQ.dbZ();
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.ldP != null && this.ldP.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return this.ldP != null && this.ldP.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.ldP != null) {
            this.ldP.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.ldP != null) {
            this.ldP.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.ldP != null) {
            return this.ldP.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.ldP != null) {
            return this.ldP.getPlayUrl();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.ldP != null) {
            return this.ldP.getCurrentPosition();
        }
        return 0;
    }
}
