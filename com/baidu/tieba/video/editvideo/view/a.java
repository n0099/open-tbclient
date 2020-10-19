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
    private k.c euv;
    private i lIo;
    public int mCurrentTabIndex;
    private h mFB;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;
    private com.baidu.tieba.video.editvideo.a mVV;
    private MaskVideoView mXd;
    private c mXe;
    private e mXf;
    private d mXg;
    private FrameLayout mXh;
    private FragmentTabWidget mXi;

    public a(com.baidu.adp.base.e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.euv = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.mVV != null) {
                            a.this.mVV.btt();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.mVV != null) {
                            a.this.mVV.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.lIo != null && a.this.lIo.isShowing() && a.this.getPageContext() != null) {
                    a.this.lIo.dismiss();
                }
            }
        };
        this.mVV = aVar;
        this.mRootView = view;
        this.mFB = hVar;
        this.mResources = view.getResources();
        this.mXe = new c(this.mContext, this);
        this.mXf = new e(this.mContext, this, this.mFB);
        this.mXg = new d(this.mContext, this);
        this.mXe.dD(this.mRootView);
        this.mXf.dD(this.mRootView);
        this.mXg.dD(this.mRootView);
        initView();
        dJN();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mXd = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.mXd.setPreserveEGLContextOnPause(true);
        this.mXd.setZOrderMediaOverlay(true);
        this.mXd.setPostMonitorManager(this.mFB);
        this.mXh = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.mXh.addView(this.mXe.getRootView());
        this.mXi = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        byD();
        dJM();
        this.mXh.addView(this.mXf.getRootView());
        this.mXh.addView(this.mXg.getRootView());
        this.mXf.getRootView().setVisibility(8);
        this.mXg.getRootView().setVisibility(8);
    }

    private boolean dJL() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dJM() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.mXi.addView(fragmentTabIndicator, i);
        }
        if (!dJL() && this.mXi.getChildAt(1) != null) {
            this.mXi.getChildAt(1).setVisibility(8);
        }
        this.mXi.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.mXi.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.mXi.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.mXi.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.mXi.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.mXe.getRootView().setVisibility(0);
                            a.this.mXf.getRootView().setVisibility(8);
                            a.this.mXg.getRootView().setVisibility(8);
                            a.this.mXe.xu(true);
                            a.this.mXf.xu(false);
                            a.this.mXg.xu(false);
                            break;
                        case 1:
                            a.this.mXg.getRootView().setVisibility(0);
                            a.this.mXf.getRootView().setVisibility(8);
                            a.this.mXe.getRootView().setVisibility(8);
                            a.this.mXe.xu(false);
                            if (TextUtils.isEmpty(a.this.mXf.dJU())) {
                                a.this.mXf.xu(false);
                            } else {
                                a.this.mXf.xu(true);
                            }
                            a.this.mXg.xu(true);
                            break;
                        case 2:
                            a.this.mXf.getRootView().setVisibility(0);
                            a.this.mXe.getRootView().setVisibility(8);
                            a.this.mXg.getRootView().setVisibility(8);
                            a.this.mXe.xu(false);
                            a.this.mXf.xu(true);
                            a.this.mXg.xu(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.mXi.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dJN();
                    a.this.dJO();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJN() {
        aq aqVar = new aq("c12424");
        aqVar.aj("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJO() {
        if (this.mCurrentTabIndex == 0) {
            dJS();
            dJQ();
            return;
        }
        replay();
    }

    public void replay() {
        dJS();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.mXd.start();
        this.mXd.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dJS();
        this.mXe.onPause();
        this.mXf.onPause();
        this.mXg.onPause();
    }

    public void onResume() {
        this.mXd.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.mXd.resumeMedia();
        }
        this.mXe.onResume();
        this.mXf.onResume();
        this.mXg.onResume();
    }

    public MaskVideoView dJP() {
        return this.mXd;
    }

    public Bitmap F(Bitmap bitmap) {
        return this.mXe.F(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.mXf.setMusicData(list);
    }

    public void fA(List<PendantData> list) {
        this.mXe.fA(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.mXg != null) {
            this.mXg.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a Tc(String str) {
        if (this.mXg == null || at.isEmpty(str)) {
            return null;
        }
        return this.mXg.Te(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.mXd != null) {
            this.mXd.setFilter(aVar);
        }
        if (this.mXg != null) {
            this.mXg.d(aVar);
        }
    }

    public void gt(String str, String str2) {
        if (this.mXf != null) {
            this.mXf.gv(str, str2);
        }
    }

    public void xv(boolean z) {
        if (this.mXf != null) {
            this.mXf.xw(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.mXe.setData(str);
                this.mXd.setVideoPath(str);
                this.mXd.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.mXe.dKb();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.mXd.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.mXd.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.mXd.seekTo(a.this.mXe.getCurrentPosition());
                    }
                });
                this.mXd.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.mXf.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dJQ() {
        if (this.mXd != null) {
            this.mXd.seekTo(this.mXe.getCurrentPosition());
        }
    }

    public void dJR() {
        if (this.mXd != null) {
            this.mXd.Kc(this.mXe.getCurrentPosition());
        }
    }

    public void dJS() {
        if (this.mXd != null) {
            this.mXd.dJX();
        }
    }

    public void dJT() {
        if (this.mXd != null) {
            this.mXd.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.mXi.onChangeSkinType(i);
        this.mXi.setDiverColor(ap.getColor(i, R.color.cp_cont_b));
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.mXe != null) {
            this.mXe.onChangeSkinType(eVar, i);
        }
        if (this.mXf != null) {
            this.mXf.onChangeSkinType(eVar, i);
        }
    }

    private void byD() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Pd();
            }
        });
        ap.setViewTextColor(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.mXe.hideSoftKeyPad();
                if (a.this.mVV != null) {
                    a.this.mVV.onNext();
                }
            }
        }), R.color.cp_cont_f);
    }

    public String getText() {
        return this.mXe.getText();
    }

    public int getCurrentPosition() {
        if (this.mXd == null) {
            return 0;
        }
        return this.mXd.getCurrentPosition();
    }

    public void Pd() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && at.equals(((EditVideoActivity) this.mContext.getPageActivity()).bhT(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.mVV.finishPage();
            return;
        }
        if (this.lIo == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.lIo = new i(getPageContext());
            this.lIo.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.lIo.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.euv);
        }
        this.lIo.Pd();
    }

    public void gu(String str, String str2) {
        this.mXf.gu(str, str2);
    }

    public void dJj() {
        if (this.mVV != null) {
            this.mVV.dJj();
        }
    }

    public String dJU() {
        return this.mXf.dJU();
    }

    public String dJV() {
        return this.mXf.dJV();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean dJW() {
        return this.mXf.dJW();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.mXe != null) {
            this.mXe.release();
        }
        if (this.mXd != null) {
            this.mXd.stopPlayback();
        }
    }

    public void am(Intent intent) {
        this.mXf.am(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dJP() != null) {
            dJP().setGenMaskCoverListener(bVar);
        }
    }
}
