package com.baidu.tieba.video.editvideo.view;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
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
import com.baidu.tieba.l.h;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes23.dex */
public class a extends com.baidu.adp.base.c {
    private k.c eOp;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;
    private i mpj;
    private com.baidu.tieba.video.editvideo.a nDD;
    private MaskVideoView nEK;
    private c nEL;
    private e nEM;
    private d nEN;
    private FrameLayout nEO;
    private FragmentTabWidget nEP;
    private h nnd;

    public a(com.baidu.adp.base.e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.eOp = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.nDD != null) {
                            a.this.nDD.bAB();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.nDD != null) {
                            a.this.nDD.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.mpj != null && a.this.mpj.isShowing() && a.this.getPageContext() != null) {
                    a.this.mpj.dismiss();
                }
            }
        };
        this.nDD = aVar;
        this.mRootView = view;
        this.nnd = hVar;
        this.mResources = view.getResources();
        this.nEL = new c(this.mContext, this);
        this.nEM = new e(this.mContext, this, this.nnd);
        this.nEN = new d(this.mContext, this);
        this.nEL.ee(this.mRootView);
        this.nEM.ee(this.mRootView);
        this.nEN.ee(this.mRootView);
        initView();
        dUR();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.nEK = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.nEK.setPreserveEGLContextOnPause(true);
        this.nEK.setZOrderMediaOverlay(true);
        this.nEK.setPostMonitorManager(this.nnd);
        this.nEO = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.nEO.addView(this.nEL.getRootView());
        this.nEP = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bFP();
        dUQ();
        this.nEO.addView(this.nEM.getRootView());
        this.nEO.addView(this.nEN.getRootView());
        this.nEM.getRootView().setVisibility(8);
        this.nEN.getRootView().setVisibility(8);
    }

    private boolean dUP() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dUQ() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.nEP.addView(fragmentTabIndicator, i);
        }
        if (!dUP() && this.nEP.getChildAt(1) != null) {
            this.nEP.getChildAt(1).setVisibility(8);
        }
        this.nEP.setDiverColor(this.mResources.getColor(R.color.CAM_X0105));
        this.nEP.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.nEP.setBackGroundDrawableResId(R.color.CAM_X0201);
        this.nEP.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.nEP.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.nEL.getRootView().setVisibility(0);
                            a.this.nEM.getRootView().setVisibility(8);
                            a.this.nEN.getRootView().setVisibility(8);
                            a.this.nEL.yG(true);
                            a.this.nEM.yG(false);
                            a.this.nEN.yG(false);
                            break;
                        case 1:
                            a.this.nEN.getRootView().setVisibility(0);
                            a.this.nEM.getRootView().setVisibility(8);
                            a.this.nEL.getRootView().setVisibility(8);
                            a.this.nEL.yG(false);
                            if (TextUtils.isEmpty(a.this.nEM.dUY())) {
                                a.this.nEM.yG(false);
                            } else {
                                a.this.nEM.yG(true);
                            }
                            a.this.nEN.yG(true);
                            break;
                        case 2:
                            a.this.nEM.getRootView().setVisibility(0);
                            a.this.nEL.getRootView().setVisibility(8);
                            a.this.nEN.getRootView().setVisibility(8);
                            a.this.nEL.yG(false);
                            a.this.nEM.yG(true);
                            a.this.nEN.yG(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.nEP.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dUR();
                    a.this.dUS();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUR() {
        ar arVar = new ar("c12424");
        arVar.al("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUS() {
        if (this.mCurrentTabIndex == 0) {
            dUW();
            dUU();
            return;
        }
        replay();
    }

    public void replay() {
        dUW();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.nEK.start();
        this.nEK.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dUW();
        this.nEL.onPause();
        this.nEM.onPause();
        this.nEN.onPause();
    }

    public void onResume() {
        this.nEK.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.nEK.resumeMedia();
        }
        this.nEL.onResume();
        this.nEM.onResume();
        this.nEN.onResume();
    }

    public MaskVideoView dUT() {
        return this.nEK;
    }

    public Bitmap F(Bitmap bitmap) {
        return this.nEL.F(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.nEM.setMusicData(list);
    }

    public void gf(List<PendantData> list) {
        this.nEL.gf(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.nEN != null) {
            this.nEN.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a US(String str) {
        if (this.nEN == null || au.isEmpty(str)) {
            return null;
        }
        return this.nEN.UU(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.nEK != null) {
            this.nEK.setFilter(aVar);
        }
        if (this.nEN != null) {
            this.nEN.d(aVar);
        }
    }

    public void gD(String str, String str2) {
        if (this.nEM != null) {
            this.nEM.gF(str, str2);
        }
    }

    public void yH(boolean z) {
        if (this.nEM != null) {
            this.nEM.yI(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.nEL.setData(str);
                this.nEK.setVideoPath(str);
                this.nEK.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.mMediaPlayer = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.mMediaPlayer.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.mMediaPlayer.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.nEL.dVf();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.nEK.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.nEK.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.nEK.seekTo(a.this.nEL.getCurrentPosition());
                    }
                });
                this.nEK.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.nEM.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dUU() {
        if (this.nEK != null) {
            this.nEK.seekTo(this.nEL.getCurrentPosition());
        }
    }

    public void dUV() {
        if (this.nEK != null) {
            this.nEK.Mc(this.nEL.getCurrentPosition());
        }
    }

    public void dUW() {
        if (this.nEK != null) {
            this.nEK.dVb();
        }
    }

    public void dUX() {
        if (this.nEK != null) {
            this.nEK.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.nEP.onChangeSkinType(i);
        this.nEP.setDiverColor(ap.getColor(i, R.color.CAM_X0105));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.nEL != null) {
            this.nEL.onChangeSkinType(eVar, i);
        }
        if (this.nEM != null) {
            this.nEM.onChangeSkinType(eVar, i);
        }
    }

    private void bFP() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.RU();
            }
        });
        ap.setViewTextColor(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.nEL.hideSoftKeyPad();
                if (a.this.nDD != null) {
                    a.this.nDD.onNext();
                }
            }
        }), R.color.CAM_X0106);
    }

    public String getText() {
        return this.nEL.getText();
    }

    public int getCurrentPosition() {
        if (this.nEK == null) {
            return 0;
        }
        return this.nEK.getCurrentPosition();
    }

    public void RU() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && au.equals(((EditVideoActivity) this.mContext.getPageActivity()).boB(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.nDD.finishPage();
            return;
        }
        if (this.mpj == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.mpj = new i(getPageContext());
            this.mpj.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.mpj.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.eOp);
        }
        this.mpj.RU();
    }

    public void gE(String str, String str2) {
        this.nEM.gE(str, str2);
    }

    public void dUl() {
        if (this.nDD != null) {
            this.nDD.dUl();
        }
    }

    public String dUY() {
        return this.nEM.dUY();
    }

    public String dUZ() {
        return this.nEM.dUZ();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean dVa() {
        return this.nEM.dVa();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.nEL != null) {
            this.nEL.release();
        }
        if (this.nEK != null) {
            this.nEK.stopPlayback();
        }
    }

    public void am(Intent intent) {
        this.nEM.am(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dUT() != null) {
            dUT().setGenMaskCoverListener(bVar);
        }
    }
}
