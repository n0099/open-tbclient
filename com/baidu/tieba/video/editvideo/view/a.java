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
    private i mzf;
    private com.baidu.tieba.video.editvideo.a nNn;
    private MaskVideoView nOu;
    private c nOv;
    private e nOw;
    private d nOx;
    private FrameLayout nOy;
    private FragmentTabWidget nOz;
    private g nyu;

    public a(f fVar, com.baidu.tieba.video.editvideo.a aVar, View view, g gVar) {
        super(fVar);
        this.mCurrentTabIndex = 0;
        this.eVR = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.nNn != null) {
                            a.this.nNn.bzu();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.nNn != null) {
                            a.this.nNn.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.mzf != null && a.this.mzf.isShowing() && a.this.getPageContext() != null) {
                    a.this.mzf.dismiss();
                }
            }
        };
        this.nNn = aVar;
        this.mRootView = view;
        this.nyu = gVar;
        this.mResources = view.getResources();
        this.nOv = new c(this.mContext, this);
        this.nOw = new e(this.mContext, this, this.nyu);
        this.nOx = new d(this.mContext, this);
        this.nOv.em(this.mRootView);
        this.nOw.em(this.mRootView);
        this.nOx.em(this.mRootView);
        initView();
        dTk();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.nOu = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.nOu.setPreserveEGLContextOnPause(true);
        this.nOu.setZOrderMediaOverlay(true);
        this.nOu.setPostMonitorManager(this.nyu);
        this.nOy = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.nOy.addView(this.nOv.getRootView());
        this.nOz = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bEL();
        dTj();
        this.nOy.addView(this.nOw.getRootView());
        this.nOy.addView(this.nOx.getRootView());
        this.nOw.getRootView().setVisibility(8);
        this.nOx.getRootView().setVisibility(8);
    }

    private boolean dTi() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dTj() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.nOz.addView(fragmentTabIndicator, i);
        }
        if (!dTi() && this.nOz.getChildAt(1) != null) {
            this.nOz.getChildAt(1).setVisibility(8);
        }
        this.nOz.setDiverColor(this.mResources.getColor(R.color.CAM_X0105));
        this.nOz.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.nOz.setBackGroundDrawableResId(R.color.CAM_X0201);
        this.nOz.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.nOz.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.nOv.getRootView().setVisibility(0);
                            a.this.nOw.getRootView().setVisibility(8);
                            a.this.nOx.getRootView().setVisibility(8);
                            a.this.nOv.yY(true);
                            a.this.nOw.yY(false);
                            a.this.nOx.yY(false);
                            break;
                        case 1:
                            a.this.nOx.getRootView().setVisibility(0);
                            a.this.nOw.getRootView().setVisibility(8);
                            a.this.nOv.getRootView().setVisibility(8);
                            a.this.nOv.yY(false);
                            if (TextUtils.isEmpty(a.this.nOw.dTr())) {
                                a.this.nOw.yY(false);
                            } else {
                                a.this.nOw.yY(true);
                            }
                            a.this.nOx.yY(true);
                            break;
                        case 2:
                            a.this.nOw.getRootView().setVisibility(0);
                            a.this.nOv.getRootView().setVisibility(8);
                            a.this.nOx.getRootView().setVisibility(8);
                            a.this.nOv.yY(false);
                            a.this.nOw.yY(true);
                            a.this.nOx.yY(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.nOz.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dTk();
                    a.this.dTl();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTk() {
        ar arVar = new ar("c12424");
        arVar.ap("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTl() {
        if (this.mCurrentTabIndex == 0) {
            dTp();
            dTn();
            return;
        }
        replay();
    }

    public void replay() {
        dTp();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.nOu.start();
        this.nOu.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dTp();
        this.nOv.onPause();
        this.nOw.onPause();
        this.nOx.onPause();
    }

    public void onResume() {
        this.nOu.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.nOu.resumeMedia();
        }
        this.nOv.onResume();
        this.nOw.onResume();
        this.nOx.onResume();
    }

    public MaskVideoView dTm() {
        return this.nOu;
    }

    public Bitmap F(Bitmap bitmap) {
        return this.nOv.F(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.nOw.setMusicData(list);
    }

    public void fY(List<PendantData> list) {
        this.nOv.fY(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.nOx != null) {
            this.nOx.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a UA(String str) {
        if (this.nOx == null || au.isEmpty(str)) {
            return null;
        }
        return this.nOx.UC(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.nOu != null) {
            this.nOu.setFilter(aVar);
        }
        if (this.nOx != null) {
            this.nOx.d(aVar);
        }
    }

    public void gH(String str, String str2) {
        if (this.nOw != null) {
            this.nOw.gJ(str, str2);
        }
    }

    public void yZ(boolean z) {
        if (this.nOw != null) {
            this.nOw.za(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.nOv.setData(str);
                this.nOu.setVideoPath(str);
                this.nOu.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.nOv.dTx();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.nOu.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.nOu.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.nOu.seekTo(a.this.nOv.getCurrentPosition());
                    }
                });
                this.nOu.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.nOw.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dTn() {
        if (this.nOu != null) {
            this.nOu.seekTo(this.nOv.getCurrentPosition());
        }
    }

    public void dTo() {
        if (this.nOu != null) {
            this.nOu.KD(this.nOv.getCurrentPosition());
        }
    }

    public void dTp() {
        if (this.nOu != null) {
            this.nOu.dTt();
        }
    }

    public void dTq() {
        if (this.nOu != null) {
            this.nOu.onPause();
        }
    }

    public void onChangeSkinType(f fVar, int i) {
        this.mNavigationBar.onChangeSkinType(fVar, i);
        this.nOz.onChangeSkinType(i);
        this.nOz.setDiverColor(ap.getColor(i, R.color.CAM_X0105));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.nOv != null) {
            this.nOv.onChangeSkinType(fVar, i);
        }
        if (this.nOw != null) {
            this.nOw.onChangeSkinType(fVar, i);
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
                a.this.nOv.hideSoftKeyPad();
                if (a.this.nNn != null) {
                    a.this.nNn.onNext();
                }
            }
        }), R.color.CAM_X0106);
    }

    public String getText() {
        return this.nOv.getText();
    }

    public int getCurrentPosition() {
        if (this.nOu == null) {
            return 0;
        }
        return this.nOu.getCurrentPosition();
    }

    public void QE() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && au.equals(((EditVideoActivity) this.mContext.getPageActivity()).bnC(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.nNn.finishPage();
            return;
        }
        if (this.mzf == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.mzf = new i(getPageContext());
            this.mzf.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.mzf.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.eVR);
        }
        this.mzf.QE();
    }

    public void gI(String str, String str2) {
        this.nOw.gI(str, str2);
    }

    public void dSE() {
        if (this.nNn != null) {
            this.nNn.dSE();
        }
    }

    public String dTr() {
        return this.nOw.dTr();
    }

    public String dTs() {
        return this.nOw.dTs();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.nOv != null) {
            this.nOv.release();
        }
        if (this.nOu != null) {
            this.nOu.stopPlayback();
        }
    }

    public void am(Intent intent) {
        this.nOw.am(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dTm() != null) {
            dTm().setGenMaskCoverListener(bVar);
        }
    }
}
