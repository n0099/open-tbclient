package com.baidu.tieba.video.editvideo.view;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.k.h;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends com.baidu.adp.base.c {
    private k.c dvr;
    private i jYi;
    private h kTM;
    private com.baidu.tieba.video.editvideo.a ljw;
    private MaskVideoView lkF;
    private b lkG;
    private d lkH;
    private c lkI;
    private FrameLayout lkJ;
    private FragmentTabWidget lkK;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.dvr = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.ljw != null) {
                            a.this.ljw.daV();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.ljw != null) {
                            a.this.ljw.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.jYi != null && a.this.jYi.isShowing() && a.this.getPageContext() != null) {
                    a.this.jYi.dismiss();
                }
            }
        };
        this.ljw = aVar;
        this.mRootView = view;
        this.kTM = hVar;
        this.mResources = view.getResources();
        this.lkG = new b(this.mContext, this);
        this.lkH = new d(this.mContext, this, this.kTM);
        this.lkI = new c(this.mContext, this);
        this.lkG.de(this.mRootView);
        this.lkH.de(this.mRootView);
        this.lkI.de(this.mRootView);
        initView();
        dbC();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.lkF = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.lkF.setPreserveEGLContextOnPause(true);
        this.lkF.setZOrderMediaOverlay(true);
        this.lkF.setPostMonitorManager(this.kTM);
        this.lkJ = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.lkJ.addView(this.lkG.getRootView());
        this.lkK = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        blD();
        dbB();
        this.lkJ.addView(this.lkH.getRootView());
        this.lkJ.addView(this.lkI.getRootView());
        this.lkH.getRootView().setVisibility(8);
        this.lkI.getRootView().setVisibility(8);
    }

    private boolean dbA() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dbB() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.lkK.addView(fragmentTabIndicator, i);
        }
        if (!dbA() && this.lkK.getChildAt(1) != null) {
            this.lkK.getChildAt(1).setVisibility(8);
        }
        this.lkK.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.lkK.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.lkK.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.lkK.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.lkK.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.lkG.getRootView().setVisibility(0);
                            a.this.lkH.getRootView().setVisibility(8);
                            a.this.lkI.getRootView().setVisibility(8);
                            a.this.lkG.uv(true);
                            a.this.lkH.uv(false);
                            a.this.lkI.uv(false);
                            break;
                        case 1:
                            a.this.lkI.getRootView().setVisibility(0);
                            a.this.lkH.getRootView().setVisibility(8);
                            a.this.lkG.getRootView().setVisibility(8);
                            a.this.lkG.uv(false);
                            if (TextUtils.isEmpty(a.this.lkH.dbJ())) {
                                a.this.lkH.uv(false);
                            } else {
                                a.this.lkH.uv(true);
                            }
                            a.this.lkI.uv(true);
                            break;
                        case 2:
                            a.this.lkH.getRootView().setVisibility(0);
                            a.this.lkG.getRootView().setVisibility(8);
                            a.this.lkI.getRootView().setVisibility(8);
                            a.this.lkG.uv(false);
                            a.this.lkH.uv(true);
                            a.this.lkI.uv(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.lkK.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dbC();
                    a.this.dbD();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbC() {
        an anVar = new an("c12424");
        anVar.af("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbD() {
        if (this.mCurrentTabIndex == 0) {
            dbH();
            dbF();
            return;
        }
        replay();
    }

    public void replay() {
        dbH();
        this.lkF.start();
        this.lkF.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.mMediaPlayer != null) {
            this.mIsMute = z;
            if (z) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        dbH();
        this.lkG.onPause();
        this.lkH.onPause();
        this.lkI.onPause();
    }

    public void onResume() {
        this.lkF.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.lkF.resumeMedia();
        }
        this.lkG.onResume();
        this.lkH.onResume();
        this.lkI.onResume();
    }

    public MaskVideoView dbE() {
        return this.lkF;
    }

    public Bitmap B(Bitmap bitmap) {
        return this.lkG.B(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.lkH.setMusicData(list);
    }

    public void eE(List<PendantData> list) {
        this.lkG.eE(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.lkI != null) {
            this.lkI.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.lkG.setData(str);
                this.lkF.setVideoPath(str);
                this.lkF.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.mMediaPlayer = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.mMediaPlayer.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.mMediaPlayer.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.lkG.dbP();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.lkF.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.lkF.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.lkF.seekTo(a.this.lkG.getCurrentPosition());
                    }
                });
                this.lkF.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.lkH.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dbF() {
        if (this.lkF != null) {
            this.lkF.seekTo(this.lkG.getCurrentPosition());
        }
    }

    public void dbG() {
        if (this.lkF != null) {
            this.lkF.El(this.lkG.getCurrentPosition());
        }
    }

    public void dbH() {
        if (this.lkF != null) {
            this.lkF.dbM();
        }
    }

    public void dbI() {
        if (this.lkF != null) {
            this.lkF.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.lkK.onChangeSkinType(i);
        this.lkK.setDiverColor(am.getColor(i, R.color.cp_cont_b));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.lkG != null) {
            this.lkG.onChangeSkinType(eVar, i);
        }
        if (this.lkH != null) {
            this.lkH.onChangeSkinType(eVar, i);
        }
    }

    private void blD() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        am.setViewTextColor(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.lkG.hideSoftKeyPad();
                if (a.this.ljw != null) {
                    a.this.ljw.onNext();
                }
            }
        }), (int) R.color.cp_cont_f);
    }

    public String getText() {
        return this.lkG.getText();
    }

    public int getCurrentPosition() {
        if (this.lkF == null) {
            return 0;
        }
        return this.lkF.getCurrentPosition();
    }

    public void showDialog() {
        if (this.jYi == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.jYi = new i(getPageContext());
            this.jYi.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.jYi.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.dvr);
        }
        this.jYi.showDialog();
    }

    public void eX(String str, String str2) {
        this.lkH.eX(str, str2);
    }

    public void daX() {
        if (this.ljw != null) {
            this.ljw.daX();
        }
    }

    public String dbJ() {
        return this.lkH.dbJ();
    }

    public String dbK() {
        return this.lkH.dbK();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean dbL() {
        return this.lkH.dbL();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.lkG != null) {
            this.lkG.release();
        }
        if (this.lkF != null) {
            this.lkF.stopPlayback();
        }
    }

    public void am(Intent intent) {
        this.lkH.am(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dbE() != null) {
            dbE().setGenMaskCoverListener(bVar);
        }
    }
}
