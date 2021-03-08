package com.baidu.tieba.video.editvideo.view;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.l.g;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.base.d {
    private k.c eXq;
    private i mBi;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;
    private g nAz;
    private com.baidu.tieba.video.editvideo.a nPs;
    private c nQA;
    private e nQB;
    private d nQC;
    private FrameLayout nQD;
    private FragmentTabWidget nQE;
    private MaskVideoView nQz;

    public a(f fVar, com.baidu.tieba.video.editvideo.a aVar, View view, g gVar) {
        super(fVar);
        this.mCurrentTabIndex = 0;
        this.eXq = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.nPs != null) {
                            a.this.nPs.bzx();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.nPs != null) {
                            a.this.nPs.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.mBi != null && a.this.mBi.isShowing() && a.this.getPageContext() != null) {
                    a.this.mBi.dismiss();
                }
            }
        };
        this.nPs = aVar;
        this.mRootView = view;
        this.nAz = gVar;
        this.mResources = view.getResources();
        this.nQA = new c(this.mContext, this);
        this.nQB = new e(this.mContext, this, this.nAz);
        this.nQC = new d(this.mContext, this);
        this.nQA.em(this.mRootView);
        this.nQB.em(this.mRootView);
        this.nQC.em(this.mRootView);
        initView();
        dTs();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.nQz = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.nQz.setPreserveEGLContextOnPause(true);
        this.nQz.setZOrderMediaOverlay(true);
        this.nQz.setPostMonitorManager(this.nAz);
        this.nQD = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.nQD.addView(this.nQA.getRootView());
        this.nQE = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bEP();
        dTr();
        this.nQD.addView(this.nQB.getRootView());
        this.nQD.addView(this.nQC.getRootView());
        this.nQB.getRootView().setVisibility(8);
        this.nQC.getRootView().setVisibility(8);
    }

    private boolean dTq() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dTr() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.nQE.addView(fragmentTabIndicator, i);
        }
        if (!dTq() && this.nQE.getChildAt(1) != null) {
            this.nQE.getChildAt(1).setVisibility(8);
        }
        this.nQE.setDiverColor(this.mResources.getColor(R.color.CAM_X0105));
        this.nQE.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.nQE.setBackGroundDrawableResId(R.color.CAM_X0201);
        this.nQE.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.nQE.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.nQA.getRootView().setVisibility(0);
                            a.this.nQB.getRootView().setVisibility(8);
                            a.this.nQC.getRootView().setVisibility(8);
                            a.this.nQA.yX(true);
                            a.this.nQB.yX(false);
                            a.this.nQC.yX(false);
                            break;
                        case 1:
                            a.this.nQC.getRootView().setVisibility(0);
                            a.this.nQB.getRootView().setVisibility(8);
                            a.this.nQA.getRootView().setVisibility(8);
                            a.this.nQA.yX(false);
                            if (TextUtils.isEmpty(a.this.nQB.dTz())) {
                                a.this.nQB.yX(false);
                            } else {
                                a.this.nQB.yX(true);
                            }
                            a.this.nQC.yX(true);
                            break;
                        case 2:
                            a.this.nQB.getRootView().setVisibility(0);
                            a.this.nQA.getRootView().setVisibility(8);
                            a.this.nQC.getRootView().setVisibility(8);
                            a.this.nQA.yX(false);
                            a.this.nQB.yX(true);
                            a.this.nQC.yX(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.nQE.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dTs();
                    a.this.dTt();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTs() {
        ar arVar = new ar("c12424");
        arVar.aq("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTt() {
        if (this.mCurrentTabIndex == 0) {
            dTx();
            dTv();
            return;
        }
        replay();
    }

    public void replay() {
        dTx();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.nQz.start();
        this.nQz.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dTx();
        this.nQA.onPause();
        this.nQB.onPause();
        this.nQC.onPause();
    }

    public void onResume() {
        this.nQz.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.nQz.resumeMedia();
        }
        this.nQA.onResume();
        this.nQB.onResume();
        this.nQC.onResume();
    }

    public MaskVideoView dTu() {
        return this.nQz;
    }

    public Bitmap F(Bitmap bitmap) {
        return this.nQA.F(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.nQB.setMusicData(list);
    }

    public void fY(List<PendantData> list) {
        this.nQA.fY(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.nQC != null) {
            this.nQC.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a UH(String str) {
        if (this.nQC == null || au.isEmpty(str)) {
            return null;
        }
        return this.nQC.UJ(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.nQz != null) {
            this.nQz.setFilter(aVar);
        }
        if (this.nQC != null) {
            this.nQC.d(aVar);
        }
    }

    public void gH(String str, String str2) {
        if (this.nQB != null) {
            this.nQB.gJ(str, str2);
        }
    }

    public void yY(boolean z) {
        if (this.nQB != null) {
            this.nQB.yZ(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.nQA.setData(str);
                this.nQz.setVideoPath(str);
                this.nQz.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.mMediaPlayer = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.mMediaPlayer.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.mMediaPlayer.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.nQA.dTF();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.nQz.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.nQz.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.nQz.seekTo(a.this.nQA.getCurrentPosition());
                    }
                });
                this.nQz.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.nQB.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dTv() {
        if (this.nQz != null) {
            this.nQz.seekTo(this.nQA.getCurrentPosition());
        }
    }

    public void dTw() {
        if (this.nQz != null) {
            this.nQz.KI(this.nQA.getCurrentPosition());
        }
    }

    public void dTx() {
        if (this.nQz != null) {
            this.nQz.dTB();
        }
    }

    public void dTy() {
        if (this.nQz != null) {
            this.nQz.onPause();
        }
    }

    public void onChangeSkinType(f fVar, int i) {
        this.mNavigationBar.onChangeSkinType(fVar, i);
        this.nQE.onChangeSkinType(i);
        this.nQE.setDiverColor(ap.getColor(i, R.color.CAM_X0105));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.nQA != null) {
            this.nQA.onChangeSkinType(fVar, i);
        }
        if (this.nQB != null) {
            this.nQB.onChangeSkinType(fVar, i);
        }
    }

    private void bEP() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.QH();
            }
        });
        ap.setViewTextColor(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.nQA.hideSoftKeyPad();
                if (a.this.nPs != null) {
                    a.this.nPs.onNext();
                }
            }
        }), R.color.CAM_X0106);
    }

    public String getText() {
        return this.nQA.getText();
    }

    public int getCurrentPosition() {
        if (this.nQz == null) {
            return 0;
        }
        return this.nQz.getCurrentPosition();
    }

    public void QH() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && au.equals(((EditVideoActivity) this.mContext.getPageActivity()).bnE(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.nPs.finishPage();
            return;
        }
        if (this.mBi == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.mBi = new i(getPageContext());
            this.mBi.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.mBi.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.eXq);
        }
        this.mBi.QH();
    }

    public void gI(String str, String str2) {
        this.nQB.gI(str, str2);
    }

    public void dSM() {
        if (this.nPs != null) {
            this.nPs.dSM();
        }
    }

    public String dTz() {
        return this.nQB.dTz();
    }

    public String dTA() {
        return this.nQB.dTA();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.nQA != null) {
            this.nQA.release();
        }
        if (this.nQz != null) {
            this.nQz.stopPlayback();
        }
    }

    public void am(Intent intent) {
        this.nQB.am(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dTu() != null) {
            dTu().setGenMaskCoverListener(bVar);
        }
    }
}
