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
    private i muw;
    private com.baidu.tieba.video.editvideo.a nHI;
    private MaskVideoView nIP;
    private c nIQ;
    private e nIR;
    private d nIS;
    private FrameLayout nIT;
    private FragmentTabWidget nIU;
    private g nsP;

    public a(f fVar, com.baidu.tieba.video.editvideo.a aVar, View view, g gVar) {
        super(fVar);
        this.mCurrentTabIndex = 0;
        this.eYm = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.nHI != null) {
                            a.this.nHI.bCV();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.nHI != null) {
                            a.this.nHI.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.muw != null && a.this.muw.isShowing() && a.this.getPageContext() != null) {
                    a.this.muw.dismiss();
                }
            }
        };
        this.nHI = aVar;
        this.mRootView = view;
        this.nsP = gVar;
        this.mResources = view.getResources();
        this.nIQ = new c(this.mContext, this);
        this.nIR = new e(this.mContext, this, this.nsP);
        this.nIS = new d(this.mContext, this);
        this.nIQ.eo(this.mRootView);
        this.nIR.eo(this.mRootView);
        this.nIS.eo(this.mRootView);
        initView();
        dUI();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.nIP = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.nIP.setPreserveEGLContextOnPause(true);
        this.nIP.setZOrderMediaOverlay(true);
        this.nIP.setPostMonitorManager(this.nsP);
        this.nIT = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.nIT.addView(this.nIQ.getRootView());
        this.nIU = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bIk();
        dUH();
        this.nIT.addView(this.nIR.getRootView());
        this.nIT.addView(this.nIS.getRootView());
        this.nIR.getRootView().setVisibility(8);
        this.nIS.getRootView().setVisibility(8);
    }

    private boolean dUG() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dUH() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.nIU.addView(fragmentTabIndicator, i);
        }
        if (!dUG() && this.nIU.getChildAt(1) != null) {
            this.nIU.getChildAt(1).setVisibility(8);
        }
        this.nIU.setDiverColor(this.mResources.getColor(R.color.CAM_X0105));
        this.nIU.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.nIU.setBackGroundDrawableResId(R.color.CAM_X0201);
        this.nIU.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.nIU.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.nIQ.getRootView().setVisibility(0);
                            a.this.nIR.getRootView().setVisibility(8);
                            a.this.nIS.getRootView().setVisibility(8);
                            a.this.nIQ.yJ(true);
                            a.this.nIR.yJ(false);
                            a.this.nIS.yJ(false);
                            break;
                        case 1:
                            a.this.nIS.getRootView().setVisibility(0);
                            a.this.nIR.getRootView().setVisibility(8);
                            a.this.nIQ.getRootView().setVisibility(8);
                            a.this.nIQ.yJ(false);
                            if (TextUtils.isEmpty(a.this.nIR.dUP())) {
                                a.this.nIR.yJ(false);
                            } else {
                                a.this.nIR.yJ(true);
                            }
                            a.this.nIS.yJ(true);
                            break;
                        case 2:
                            a.this.nIR.getRootView().setVisibility(0);
                            a.this.nIQ.getRootView().setVisibility(8);
                            a.this.nIS.getRootView().setVisibility(8);
                            a.this.nIQ.yJ(false);
                            a.this.nIR.yJ(true);
                            a.this.nIS.yJ(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.nIU.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dUI();
                    a.this.dUJ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUI() {
        aq aqVar = new aq("c12424");
        aqVar.an("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUJ() {
        if (this.mCurrentTabIndex == 0) {
            dUN();
            dUL();
            return;
        }
        replay();
    }

    public void replay() {
        dUN();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.nIP.start();
        this.nIP.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dUN();
        this.nIQ.onPause();
        this.nIR.onPause();
        this.nIS.onPause();
    }

    public void onResume() {
        this.nIP.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.nIP.resumeMedia();
        }
        this.nIQ.onResume();
        this.nIR.onResume();
        this.nIS.onResume();
    }

    public MaskVideoView dUK() {
        return this.nIP;
    }

    public Bitmap G(Bitmap bitmap) {
        return this.nIQ.G(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.nIR.setMusicData(list);
    }

    public void ga(List<PendantData> list) {
        this.nIQ.ga(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.nIS != null) {
            this.nIS.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a Uz(String str) {
        if (this.nIS == null || at.isEmpty(str)) {
            return null;
        }
        return this.nIS.UB(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.nIP != null) {
            this.nIP.setFilter(aVar);
        }
        if (this.nIS != null) {
            this.nIS.d(aVar);
        }
    }

    public void gA(String str, String str2) {
        if (this.nIR != null) {
            this.nIR.gC(str, str2);
        }
    }

    public void yK(boolean z) {
        if (this.nIR != null) {
            this.nIR.yL(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.nIQ.setData(str);
                this.nIP.setVideoPath(str);
                this.nIP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.nIQ.dUV();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.nIP.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.nIP.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.nIP.seekTo(a.this.nIQ.getCurrentPosition());
                    }
                });
                this.nIP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.nIR.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dUL() {
        if (this.nIP != null) {
            this.nIP.seekTo(this.nIQ.getCurrentPosition());
        }
    }

    public void dUM() {
        if (this.nIP != null) {
            this.nIP.LQ(this.nIQ.getCurrentPosition());
        }
    }

    public void dUN() {
        if (this.nIP != null) {
            this.nIP.dUR();
        }
    }

    public void dUO() {
        if (this.nIP != null) {
            this.nIP.onPause();
        }
    }

    public void onChangeSkinType(f fVar, int i) {
        this.mNavigationBar.onChangeSkinType(fVar, i);
        this.nIU.onChangeSkinType(i);
        this.nIU.setDiverColor(ao.getColor(i, R.color.CAM_X0105));
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.nIQ != null) {
            this.nIQ.onChangeSkinType(fVar, i);
        }
        if (this.nIR != null) {
            this.nIR.onChangeSkinType(fVar, i);
        }
    }

    private void bIk() {
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
                a.this.nIQ.hideSoftKeyPad();
                if (a.this.nHI != null) {
                    a.this.nHI.onNext();
                }
            }
        }), R.color.CAM_X0106);
    }

    public String getText() {
        return this.nIQ.getText();
    }

    public int getCurrentPosition() {
        if (this.nIP == null) {
            return 0;
        }
        return this.nIP.getCurrentPosition();
    }

    public void SY() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && at.equals(((EditVideoActivity) this.mContext.getPageActivity()).brc(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.nHI.finishPage();
            return;
        }
        if (this.muw == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.muw = new i(getPageContext());
            this.muw.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.muw.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.eYm);
        }
        this.muw.SY();
    }

    public void gB(String str, String str2) {
        this.nIR.gB(str, str2);
    }

    public void dUc() {
        if (this.nHI != null) {
            this.nHI.dUc();
        }
    }

    public String dUP() {
        return this.nIR.dUP();
    }

    public String dUQ() {
        return this.nIR.dUQ();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.nIQ != null) {
            this.nIQ.release();
        }
        if (this.nIP != null) {
            this.nIP.stopPlayback();
        }
    }

    public void am(Intent intent) {
        this.nIR.am(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dUK() != null) {
            dUK().setGenMaskCoverListener(bVar);
        }
    }
}
