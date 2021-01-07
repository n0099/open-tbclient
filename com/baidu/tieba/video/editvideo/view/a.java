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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
    private k.c eYm;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;
    private i muv;
    private com.baidu.tieba.video.editvideo.a nHH;
    private MaskVideoView nIO;
    private c nIP;
    private e nIQ;
    private d nIR;
    private FrameLayout nIS;
    private FragmentTabWidget nIT;
    private g nsO;

    public a(f fVar, com.baidu.tieba.video.editvideo.a aVar, View view, g gVar) {
        super(fVar);
        this.mCurrentTabIndex = 0;
        this.eYm = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.nHH != null) {
                            a.this.nHH.bCW();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.nHH != null) {
                            a.this.nHH.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.muv != null && a.this.muv.isShowing() && a.this.getPageContext() != null) {
                    a.this.muv.dismiss();
                }
            }
        };
        this.nHH = aVar;
        this.mRootView = view;
        this.nsO = gVar;
        this.mResources = view.getResources();
        this.nIP = new c(this.mContext, this);
        this.nIQ = new e(this.mContext, this, this.nsO);
        this.nIR = new d(this.mContext, this);
        this.nIP.eo(this.mRootView);
        this.nIQ.eo(this.mRootView);
        this.nIR.eo(this.mRootView);
        initView();
        dUJ();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.nIO = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.nIO.setPreserveEGLContextOnPause(true);
        this.nIO.setZOrderMediaOverlay(true);
        this.nIO.setPostMonitorManager(this.nsO);
        this.nIS = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.nIS.addView(this.nIP.getRootView());
        this.nIT = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bIl();
        dUI();
        this.nIS.addView(this.nIQ.getRootView());
        this.nIS.addView(this.nIR.getRootView());
        this.nIQ.getRootView().setVisibility(8);
        this.nIR.getRootView().setVisibility(8);
    }

    private boolean dUH() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dUI() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.nIT.addView(fragmentTabIndicator, i);
        }
        if (!dUH() && this.nIT.getChildAt(1) != null) {
            this.nIT.getChildAt(1).setVisibility(8);
        }
        this.nIT.setDiverColor(this.mResources.getColor(R.color.CAM_X0105));
        this.nIT.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.nIT.setBackGroundDrawableResId(R.color.CAM_X0201);
        this.nIT.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.nIT.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.nIP.getRootView().setVisibility(0);
                            a.this.nIQ.getRootView().setVisibility(8);
                            a.this.nIR.getRootView().setVisibility(8);
                            a.this.nIP.yJ(true);
                            a.this.nIQ.yJ(false);
                            a.this.nIR.yJ(false);
                            break;
                        case 1:
                            a.this.nIR.getRootView().setVisibility(0);
                            a.this.nIQ.getRootView().setVisibility(8);
                            a.this.nIP.getRootView().setVisibility(8);
                            a.this.nIP.yJ(false);
                            if (TextUtils.isEmpty(a.this.nIQ.dUQ())) {
                                a.this.nIQ.yJ(false);
                            } else {
                                a.this.nIQ.yJ(true);
                            }
                            a.this.nIR.yJ(true);
                            break;
                        case 2:
                            a.this.nIQ.getRootView().setVisibility(0);
                            a.this.nIP.getRootView().setVisibility(8);
                            a.this.nIR.getRootView().setVisibility(8);
                            a.this.nIP.yJ(false);
                            a.this.nIQ.yJ(true);
                            a.this.nIR.yJ(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.nIT.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dUJ();
                    a.this.dUK();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUJ() {
        aq aqVar = new aq("c12424");
        aqVar.an("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUK() {
        if (this.mCurrentTabIndex == 0) {
            dUO();
            dUM();
            return;
        }
        replay();
    }

    public void replay() {
        dUO();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.nIO.start();
        this.nIO.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dUO();
        this.nIP.onPause();
        this.nIQ.onPause();
        this.nIR.onPause();
    }

    public void onResume() {
        this.nIO.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.nIO.resumeMedia();
        }
        this.nIP.onResume();
        this.nIQ.onResume();
        this.nIR.onResume();
    }

    public MaskVideoView dUL() {
        return this.nIO;
    }

    public Bitmap G(Bitmap bitmap) {
        return this.nIP.G(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.nIQ.setMusicData(list);
    }

    public void ga(List<PendantData> list) {
        this.nIP.ga(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.nIR != null) {
            this.nIR.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a Uy(String str) {
        if (this.nIR == null || at.isEmpty(str)) {
            return null;
        }
        return this.nIR.UA(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.nIO != null) {
            this.nIO.setFilter(aVar);
        }
        if (this.nIR != null) {
            this.nIR.d(aVar);
        }
    }

    public void gA(String str, String str2) {
        if (this.nIQ != null) {
            this.nIQ.gC(str, str2);
        }
    }

    public void yK(boolean z) {
        if (this.nIQ != null) {
            this.nIQ.yL(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.nIP.setData(str);
                this.nIO.setVideoPath(str);
                this.nIO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.mMediaPlayer = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.mMediaPlayer.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.mMediaPlayer.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.nIP.dUW();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.nIO.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.nIO.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.nIO.seekTo(a.this.nIP.getCurrentPosition());
                    }
                });
                this.nIO.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.nIQ.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dUM() {
        if (this.nIO != null) {
            this.nIO.seekTo(this.nIP.getCurrentPosition());
        }
    }

    public void dUN() {
        if (this.nIO != null) {
            this.nIO.LQ(this.nIP.getCurrentPosition());
        }
    }

    public void dUO() {
        if (this.nIO != null) {
            this.nIO.dUS();
        }
    }

    public void dUP() {
        if (this.nIO != null) {
            this.nIO.onPause();
        }
    }

    public void onChangeSkinType(f fVar, int i) {
        this.mNavigationBar.onChangeSkinType(fVar, i);
        this.nIT.onChangeSkinType(i);
        this.nIT.setDiverColor(ao.getColor(i, R.color.CAM_X0105));
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.nIP != null) {
            this.nIP.onChangeSkinType(fVar, i);
        }
        if (this.nIQ != null) {
            this.nIQ.onChangeSkinType(fVar, i);
        }
    }

    private void bIl() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.SY();
            }
        });
        ao.setViewTextColor(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.nIP.hideSoftKeyPad();
                if (a.this.nHH != null) {
                    a.this.nHH.onNext();
                }
            }
        }), R.color.CAM_X0106);
    }

    public String getText() {
        return this.nIP.getText();
    }

    public int getCurrentPosition() {
        if (this.nIO == null) {
            return 0;
        }
        return this.nIO.getCurrentPosition();
    }

    public void SY() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && at.equals(((EditVideoActivity) this.mContext.getPageActivity()).brd(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.nHH.finishPage();
            return;
        }
        if (this.muv == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.muv = new i(getPageContext());
            this.muv.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.muv.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.eYm);
        }
        this.muv.SY();
    }

    public void gB(String str, String str2) {
        this.nIQ.gB(str, str2);
    }

    public void dUd() {
        if (this.nHH != null) {
            this.nHH.dUd();
        }
    }

    public String dUQ() {
        return this.nIQ.dUQ();
    }

    public String dUR() {
        return this.nIQ.dUR();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.nIP != null) {
            this.nIP.release();
        }
        if (this.nIO != null) {
            this.nIO.stopPlayback();
        }
    }

    public void am(Intent intent) {
        this.nIQ.am(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dUL() != null) {
            dUL().setGenMaskCoverListener(bVar);
        }
    }
}
