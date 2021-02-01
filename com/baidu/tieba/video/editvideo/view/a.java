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
/* loaded from: classes8.dex */
public class a extends com.baidu.adp.base.d {
    private k.c eVR;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;
    private i myQ;
    private com.baidu.tieba.video.editvideo.a nMN;
    private MaskVideoView nNU;
    private c nNV;
    private e nNW;
    private d nNX;
    private FrameLayout nNY;
    private FragmentTabWidget nNZ;
    private g nxU;

    public a(f fVar, com.baidu.tieba.video.editvideo.a aVar, View view, g gVar) {
        super(fVar);
        this.mCurrentTabIndex = 0;
        this.eVR = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.nMN != null) {
                            a.this.nMN.bzu();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.nMN != null) {
                            a.this.nMN.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.myQ != null && a.this.myQ.isShowing() && a.this.getPageContext() != null) {
                    a.this.myQ.dismiss();
                }
            }
        };
        this.nMN = aVar;
        this.mRootView = view;
        this.nxU = gVar;
        this.mResources = view.getResources();
        this.nNV = new c(this.mContext, this);
        this.nNW = new e(this.mContext, this, this.nxU);
        this.nNX = new d(this.mContext, this);
        this.nNV.em(this.mRootView);
        this.nNW.em(this.mRootView);
        this.nNX.em(this.mRootView);
        initView();
        dTc();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.nNU = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.nNU.setPreserveEGLContextOnPause(true);
        this.nNU.setZOrderMediaOverlay(true);
        this.nNU.setPostMonitorManager(this.nxU);
        this.nNY = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.nNY.addView(this.nNV.getRootView());
        this.nNZ = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bEL();
        dTb();
        this.nNY.addView(this.nNW.getRootView());
        this.nNY.addView(this.nNX.getRootView());
        this.nNW.getRootView().setVisibility(8);
        this.nNX.getRootView().setVisibility(8);
    }

    private boolean dTa() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dTb() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.nNZ.addView(fragmentTabIndicator, i);
        }
        if (!dTa() && this.nNZ.getChildAt(1) != null) {
            this.nNZ.getChildAt(1).setVisibility(8);
        }
        this.nNZ.setDiverColor(this.mResources.getColor(R.color.CAM_X0105));
        this.nNZ.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.nNZ.setBackGroundDrawableResId(R.color.CAM_X0201);
        this.nNZ.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.nNZ.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.nNV.getRootView().setVisibility(0);
                            a.this.nNW.getRootView().setVisibility(8);
                            a.this.nNX.getRootView().setVisibility(8);
                            a.this.nNV.yY(true);
                            a.this.nNW.yY(false);
                            a.this.nNX.yY(false);
                            break;
                        case 1:
                            a.this.nNX.getRootView().setVisibility(0);
                            a.this.nNW.getRootView().setVisibility(8);
                            a.this.nNV.getRootView().setVisibility(8);
                            a.this.nNV.yY(false);
                            if (TextUtils.isEmpty(a.this.nNW.dTj())) {
                                a.this.nNW.yY(false);
                            } else {
                                a.this.nNW.yY(true);
                            }
                            a.this.nNX.yY(true);
                            break;
                        case 2:
                            a.this.nNW.getRootView().setVisibility(0);
                            a.this.nNV.getRootView().setVisibility(8);
                            a.this.nNX.getRootView().setVisibility(8);
                            a.this.nNV.yY(false);
                            a.this.nNW.yY(true);
                            a.this.nNX.yY(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.nNZ.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dTc();
                    a.this.dTd();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTc() {
        ar arVar = new ar("c12424");
        arVar.ap("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTd() {
        if (this.mCurrentTabIndex == 0) {
            dTh();
            dTf();
            return;
        }
        replay();
    }

    public void replay() {
        dTh();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.nNU.start();
        this.nNU.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dTh();
        this.nNV.onPause();
        this.nNW.onPause();
        this.nNX.onPause();
    }

    public void onResume() {
        this.nNU.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.nNU.resumeMedia();
        }
        this.nNV.onResume();
        this.nNW.onResume();
        this.nNX.onResume();
    }

    public MaskVideoView dTe() {
        return this.nNU;
    }

    public Bitmap F(Bitmap bitmap) {
        return this.nNV.F(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.nNW.setMusicData(list);
    }

    public void fY(List<PendantData> list) {
        this.nNV.fY(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.nNX != null) {
            this.nNX.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a Uo(String str) {
        if (this.nNX == null || au.isEmpty(str)) {
            return null;
        }
        return this.nNX.Uq(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.nNU != null) {
            this.nNU.setFilter(aVar);
        }
        if (this.nNX != null) {
            this.nNX.d(aVar);
        }
    }

    public void gF(String str, String str2) {
        if (this.nNW != null) {
            this.nNW.gH(str, str2);
        }
    }

    public void yZ(boolean z) {
        if (this.nNW != null) {
            this.nNW.za(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.nNV.setData(str);
                this.nNU.setVideoPath(str);
                this.nNU.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.nNV.dTp();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.nNU.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.nNU.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.nNU.seekTo(a.this.nNV.getCurrentPosition());
                    }
                });
                this.nNU.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.nNW.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dTf() {
        if (this.nNU != null) {
            this.nNU.seekTo(this.nNV.getCurrentPosition());
        }
    }

    public void dTg() {
        if (this.nNU != null) {
            this.nNU.KD(this.nNV.getCurrentPosition());
        }
    }

    public void dTh() {
        if (this.nNU != null) {
            this.nNU.dTl();
        }
    }

    public void dTi() {
        if (this.nNU != null) {
            this.nNU.onPause();
        }
    }

    public void onChangeSkinType(f fVar, int i) {
        this.mNavigationBar.onChangeSkinType(fVar, i);
        this.nNZ.onChangeSkinType(i);
        this.nNZ.setDiverColor(ap.getColor(i, R.color.CAM_X0105));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.nNV != null) {
            this.nNV.onChangeSkinType(fVar, i);
        }
        if (this.nNW != null) {
            this.nNW.onChangeSkinType(fVar, i);
        }
    }

    private void bEL() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.QE();
            }
        });
        ap.setViewTextColor(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.nNV.hideSoftKeyPad();
                if (a.this.nMN != null) {
                    a.this.nMN.onNext();
                }
            }
        }), R.color.CAM_X0106);
    }

    public String getText() {
        return this.nNV.getText();
    }

    public int getCurrentPosition() {
        if (this.nNU == null) {
            return 0;
        }
        return this.nNU.getCurrentPosition();
    }

    public void QE() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && au.equals(((EditVideoActivity) this.mContext.getPageActivity()).bnC(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.nMN.finishPage();
            return;
        }
        if (this.myQ == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.myQ = new i(getPageContext());
            this.myQ.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.myQ.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.eVR);
        }
        this.myQ.QE();
    }

    public void gG(String str, String str2) {
        this.nNW.gG(str, str2);
    }

    public void dSw() {
        if (this.nMN != null) {
            this.nMN.dSw();
        }
    }

    public String dTj() {
        return this.nNW.dTj();
    }

    public String dTk() {
        return this.nNW.dTk();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.nNV != null) {
            this.nNV.release();
        }
        if (this.nNU != null) {
            this.nNU.stopPlayback();
        }
    }

    public void am(Intent intent) {
        this.nNW.am(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dTe() != null) {
            dTe().setGenMaskCoverListener(bVar);
        }
    }
}
