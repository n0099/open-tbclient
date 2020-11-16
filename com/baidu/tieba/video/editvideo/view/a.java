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
/* loaded from: classes22.dex */
public class a extends com.baidu.adp.base.c {
    private k.c eHg;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;
    private h mZc;
    private i mbb;
    private com.baidu.tieba.video.editvideo.a npA;
    private MaskVideoView nqH;
    private c nqI;
    private e nqJ;
    private d nqK;
    private FrameLayout nqL;
    private FragmentTabWidget nqM;

    public a(com.baidu.adp.base.e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.eHg = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.npA != null) {
                            a.this.npA.bxb();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.npA != null) {
                            a.this.npA.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.mbb != null && a.this.mbb.isShowing() && a.this.getPageContext() != null) {
                    a.this.mbb.dismiss();
                }
            }
        };
        this.npA = aVar;
        this.mRootView = view;
        this.mZc = hVar;
        this.mResources = view.getResources();
        this.nqI = new c(this.mContext, this);
        this.nqJ = new e(this.mContext, this, this.mZc);
        this.nqK = new d(this.mContext, this);
        this.nqI.dT(this.mRootView);
        this.nqJ.dT(this.mRootView);
        this.nqK.dT(this.mRootView);
        initView();
        dPw();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.nqH = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.nqH.setPreserveEGLContextOnPause(true);
        this.nqH.setZOrderMediaOverlay(true);
        this.nqH.setPostMonitorManager(this.mZc);
        this.nqL = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.nqL.addView(this.nqI.getRootView());
        this.nqM = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bCo();
        dPv();
        this.nqL.addView(this.nqJ.getRootView());
        this.nqL.addView(this.nqK.getRootView());
        this.nqJ.getRootView().setVisibility(8);
        this.nqK.getRootView().setVisibility(8);
    }

    private boolean dPu() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dPv() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.nqM.addView(fragmentTabIndicator, i);
        }
        if (!dPu() && this.nqM.getChildAt(1) != null) {
            this.nqM.getChildAt(1).setVisibility(8);
        }
        this.nqM.setDiverColor(this.mResources.getColor(R.color.CAM_X0105));
        this.nqM.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.nqM.setBackGroundDrawableResId(R.color.CAM_X0201);
        this.nqM.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.nqM.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.nqI.getRootView().setVisibility(0);
                            a.this.nqJ.getRootView().setVisibility(8);
                            a.this.nqK.getRootView().setVisibility(8);
                            a.this.nqI.yb(true);
                            a.this.nqJ.yb(false);
                            a.this.nqK.yb(false);
                            break;
                        case 1:
                            a.this.nqK.getRootView().setVisibility(0);
                            a.this.nqJ.getRootView().setVisibility(8);
                            a.this.nqI.getRootView().setVisibility(8);
                            a.this.nqI.yb(false);
                            if (TextUtils.isEmpty(a.this.nqJ.dPD())) {
                                a.this.nqJ.yb(false);
                            } else {
                                a.this.nqJ.yb(true);
                            }
                            a.this.nqK.yb(true);
                            break;
                        case 2:
                            a.this.nqJ.getRootView().setVisibility(0);
                            a.this.nqI.getRootView().setVisibility(8);
                            a.this.nqK.getRootView().setVisibility(8);
                            a.this.nqI.yb(false);
                            a.this.nqJ.yb(true);
                            a.this.nqK.yb(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.nqM.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dPw();
                    a.this.dPx();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPw() {
        ar arVar = new ar("c12424");
        arVar.ak("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPx() {
        if (this.mCurrentTabIndex == 0) {
            dPB();
            dPz();
            return;
        }
        replay();
    }

    public void replay() {
        dPB();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.nqH.start();
        this.nqH.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dPB();
        this.nqI.onPause();
        this.nqJ.onPause();
        this.nqK.onPause();
    }

    public void onResume() {
        this.nqH.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.nqH.resumeMedia();
        }
        this.nqI.onResume();
        this.nqJ.onResume();
        this.nqK.onResume();
    }

    public MaskVideoView dPy() {
        return this.nqH;
    }

    public Bitmap F(Bitmap bitmap) {
        return this.nqI.F(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.nqJ.setMusicData(list);
    }

    public void fR(List<PendantData> list) {
        this.nqI.fR(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.nqK != null) {
            this.nqK.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a TD(String str) {
        if (this.nqK == null || au.isEmpty(str)) {
            return null;
        }
        return this.nqK.TF(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.nqH != null) {
            this.nqH.setFilter(aVar);
        }
        if (this.nqK != null) {
            this.nqK.d(aVar);
        }
    }

    public void gy(String str, String str2) {
        if (this.nqJ != null) {
            this.nqJ.gA(str, str2);
        }
    }

    public void yc(boolean z) {
        if (this.nqJ != null) {
            this.nqJ.yd(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.nqI.setData(str);
                this.nqH.setVideoPath(str);
                this.nqH.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.nqI.dPK();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.nqH.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.nqH.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.nqH.seekTo(a.this.nqI.getCurrentPosition());
                    }
                });
                this.nqH.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.nqJ.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dPz() {
        if (this.nqH != null) {
            this.nqH.seekTo(this.nqI.getCurrentPosition());
        }
    }

    public void dPA() {
        if (this.nqH != null) {
            this.nqH.Lk(this.nqI.getCurrentPosition());
        }
    }

    public void dPB() {
        if (this.nqH != null) {
            this.nqH.dPG();
        }
    }

    public void dPC() {
        if (this.nqH != null) {
            this.nqH.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.nqM.onChangeSkinType(i);
        this.nqM.setDiverColor(ap.getColor(i, R.color.CAM_X0105));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.nqI != null) {
            this.nqI.onChangeSkinType(eVar, i);
        }
        if (this.nqJ != null) {
            this.nqJ.onChangeSkinType(eVar, i);
        }
    }

    private void bCo() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.PA();
            }
        });
        ap.setViewTextColor(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.nqI.hideSoftKeyPad();
                if (a.this.npA != null) {
                    a.this.npA.onNext();
                }
            }
        }), R.color.CAM_X0106);
    }

    public String getText() {
        return this.nqI.getText();
    }

    public int getCurrentPosition() {
        if (this.nqH == null) {
            return 0;
        }
        return this.nqH.getCurrentPosition();
    }

    public void PA() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && au.equals(((EditVideoActivity) this.mContext.getPageActivity()).blo(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.npA.finishPage();
            return;
        }
        if (this.mbb == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.mbb = new i(getPageContext());
            this.mbb.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.mbb.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.eHg);
        }
        this.mbb.PA();
    }

    public void gz(String str, String str2) {
        this.nqJ.gz(str, str2);
    }

    public void dOS() {
        if (this.npA != null) {
            this.npA.dOS();
        }
    }

    public String dPD() {
        return this.nqJ.dPD();
    }

    public String dPE() {
        return this.nqJ.dPE();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean dPF() {
        return this.nqJ.dPF();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.nqI != null) {
            this.nqI.release();
        }
        if (this.nqH != null) {
            this.nqH.stopPlayback();
        }
    }

    public void am(Intent intent) {
        this.nqJ.am(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dPy() != null) {
            dPy().setGenMaskCoverListener(bVar);
        }
    }
}
