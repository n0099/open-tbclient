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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.k.h;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes23.dex */
public class a extends com.baidu.adp.base.c {
    private k.c eCU;
    private i lUK;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;
    private h mSh;
    private com.baidu.tieba.video.editvideo.a niw;
    private MaskVideoView njD;
    private c njE;
    private e njF;
    private d njG;
    private FrameLayout njH;
    private FragmentTabWidget njI;

    public a(com.baidu.adp.base.e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.eCU = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.niw != null) {
                            a.this.niw.bvm();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.niw != null) {
                            a.this.niw.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.lUK != null && a.this.lUK.isShowing() && a.this.getPageContext() != null) {
                    a.this.lUK.dismiss();
                }
            }
        };
        this.niw = aVar;
        this.mRootView = view;
        this.mSh = hVar;
        this.mResources = view.getResources();
        this.njE = new c(this.mContext, this);
        this.njF = new e(this.mContext, this, this.mSh);
        this.njG = new d(this.mContext, this);
        this.njE.dH(this.mRootView);
        this.njF.dH(this.mRootView);
        this.njG.dH(this.mRootView);
        initView();
        dMV();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.njD = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.njD.setPreserveEGLContextOnPause(true);
        this.njD.setZOrderMediaOverlay(true);
        this.njD.setPostMonitorManager(this.mSh);
        this.njH = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.njH.addView(this.njE.getRootView());
        this.njI = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bAw();
        dMU();
        this.njH.addView(this.njF.getRootView());
        this.njH.addView(this.njG.getRootView());
        this.njF.getRootView().setVisibility(8);
        this.njG.getRootView().setVisibility(8);
    }

    private boolean dMT() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dMU() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.njI.addView(fragmentTabIndicator, i);
        }
        if (!dMT() && this.njI.getChildAt(1) != null) {
            this.njI.getChildAt(1).setVisibility(8);
        }
        this.njI.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.njI.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.njI.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.njI.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.njI.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.njE.getRootView().setVisibility(0);
                            a.this.njF.getRootView().setVisibility(8);
                            a.this.njG.getRootView().setVisibility(8);
                            a.this.njE.xL(true);
                            a.this.njF.xL(false);
                            a.this.njG.xL(false);
                            break;
                        case 1:
                            a.this.njG.getRootView().setVisibility(0);
                            a.this.njF.getRootView().setVisibility(8);
                            a.this.njE.getRootView().setVisibility(8);
                            a.this.njE.xL(false);
                            if (TextUtils.isEmpty(a.this.njF.dNc())) {
                                a.this.njF.xL(false);
                            } else {
                                a.this.njF.xL(true);
                            }
                            a.this.njG.xL(true);
                            break;
                        case 2:
                            a.this.njF.getRootView().setVisibility(0);
                            a.this.njE.getRootView().setVisibility(8);
                            a.this.njG.getRootView().setVisibility(8);
                            a.this.njE.xL(false);
                            a.this.njF.xL(true);
                            a.this.njG.xL(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.njI.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dMV();
                    a.this.dMW();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMV() {
        aq aqVar = new aq("c12424");
        aqVar.aj("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMW() {
        if (this.mCurrentTabIndex == 0) {
            dNa();
            dMY();
            return;
        }
        replay();
    }

    public void replay() {
        dNa();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.njD.start();
        this.njD.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dNa();
        this.njE.onPause();
        this.njF.onPause();
        this.njG.onPause();
    }

    public void onResume() {
        this.njD.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.njD.resumeMedia();
        }
        this.njE.onResume();
        this.njF.onResume();
        this.njG.onResume();
    }

    public MaskVideoView dMX() {
        return this.njD;
    }

    public Bitmap F(Bitmap bitmap) {
        return this.njE.F(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.njF.setMusicData(list);
    }

    public void fJ(List<PendantData> list) {
        this.njE.fJ(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.njG != null) {
            this.njG.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a TB(String str) {
        if (this.njG == null || at.isEmpty(str)) {
            return null;
        }
        return this.njG.TD(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.njD != null) {
            this.njD.setFilter(aVar);
        }
        if (this.njG != null) {
            this.njG.d(aVar);
        }
    }

    public void gy(String str, String str2) {
        if (this.njF != null) {
            this.njF.gA(str, str2);
        }
    }

    public void xM(boolean z) {
        if (this.njF != null) {
            this.njF.xN(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.njE.setData(str);
                this.njD.setVideoPath(str);
                this.njD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.njE.dNj();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.njD.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.njD.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.njD.seekTo(a.this.njE.getCurrentPosition());
                    }
                });
                this.njD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.njF.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dMY() {
        if (this.njD != null) {
            this.njD.seekTo(this.njE.getCurrentPosition());
        }
    }

    public void dMZ() {
        if (this.njD != null) {
            this.njD.Ku(this.njE.getCurrentPosition());
        }
    }

    public void dNa() {
        if (this.njD != null) {
            this.njD.dNf();
        }
    }

    public void dNb() {
        if (this.njD != null) {
            this.njD.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.njI.onChangeSkinType(i);
        this.njI.setDiverColor(ap.getColor(i, R.color.cp_cont_b));
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.njE != null) {
            this.njE.onChangeSkinType(eVar, i);
        }
        if (this.njF != null) {
            this.njF.onChangeSkinType(eVar, i);
        }
    }

    private void bAw() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.PJ();
            }
        });
        ap.setViewTextColor(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.njE.hideSoftKeyPad();
                if (a.this.niw != null) {
                    a.this.niw.onNext();
                }
            }
        }), R.color.cp_cont_f);
    }

    public String getText() {
        return this.njE.getText();
    }

    public int getCurrentPosition() {
        if (this.njD == null) {
            return 0;
        }
        return this.njD.getCurrentPosition();
    }

    public void PJ() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && at.equals(((EditVideoActivity) this.mContext.getPageActivity()).bjM(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.niw.finishPage();
            return;
        }
        if (this.lUK == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.lUK = new i(getPageContext());
            this.lUK.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.lUK.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.eCU);
        }
        this.lUK.PJ();
    }

    public void gz(String str, String str2) {
        this.njF.gz(str, str2);
    }

    public void dMr() {
        if (this.niw != null) {
            this.niw.dMr();
        }
    }

    public String dNc() {
        return this.njF.dNc();
    }

    public String dNd() {
        return this.njF.dNd();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean dNe() {
        return this.njF.dNe();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.njE != null) {
            this.njE.release();
        }
        if (this.njD != null) {
            this.njD.stopPlayback();
        }
    }

    public void am(Intent intent) {
        this.njF.am(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dMX() != null) {
            dMX().setGenMaskCoverListener(bVar);
        }
    }
}
