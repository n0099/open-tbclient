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
    private k.c dvn;
    private i jYe;
    private h kTI;
    private com.baidu.tieba.video.editvideo.a ljs;
    private MaskVideoView lkB;
    private b lkC;
    private d lkD;
    private c lkE;
    private FrameLayout lkF;
    private FragmentTabWidget lkG;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.dvn = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.ljs != null) {
                            a.this.ljs.daX();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.ljs != null) {
                            a.this.ljs.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.jYe != null && a.this.jYe.isShowing() && a.this.getPageContext() != null) {
                    a.this.jYe.dismiss();
                }
            }
        };
        this.ljs = aVar;
        this.mRootView = view;
        this.kTI = hVar;
        this.mResources = view.getResources();
        this.lkC = new b(this.mContext, this);
        this.lkD = new d(this.mContext, this, this.kTI);
        this.lkE = new c(this.mContext, this);
        this.lkC.de(this.mRootView);
        this.lkD.de(this.mRootView);
        this.lkE.de(this.mRootView);
        initView();
        dbE();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.lkB = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.lkB.setPreserveEGLContextOnPause(true);
        this.lkB.setZOrderMediaOverlay(true);
        this.lkB.setPostMonitorManager(this.kTI);
        this.lkF = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.lkF.addView(this.lkC.getRootView());
        this.lkG = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        blF();
        dbD();
        this.lkF.addView(this.lkD.getRootView());
        this.lkF.addView(this.lkE.getRootView());
        this.lkD.getRootView().setVisibility(8);
        this.lkE.getRootView().setVisibility(8);
    }

    private boolean dbC() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dbD() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.lkG.addView(fragmentTabIndicator, i);
        }
        if (!dbC() && this.lkG.getChildAt(1) != null) {
            this.lkG.getChildAt(1).setVisibility(8);
        }
        this.lkG.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.lkG.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.lkG.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.lkG.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.lkG.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.lkC.getRootView().setVisibility(0);
                            a.this.lkD.getRootView().setVisibility(8);
                            a.this.lkE.getRootView().setVisibility(8);
                            a.this.lkC.uv(true);
                            a.this.lkD.uv(false);
                            a.this.lkE.uv(false);
                            break;
                        case 1:
                            a.this.lkE.getRootView().setVisibility(0);
                            a.this.lkD.getRootView().setVisibility(8);
                            a.this.lkC.getRootView().setVisibility(8);
                            a.this.lkC.uv(false);
                            if (TextUtils.isEmpty(a.this.lkD.dbL())) {
                                a.this.lkD.uv(false);
                            } else {
                                a.this.lkD.uv(true);
                            }
                            a.this.lkE.uv(true);
                            break;
                        case 2:
                            a.this.lkD.getRootView().setVisibility(0);
                            a.this.lkC.getRootView().setVisibility(8);
                            a.this.lkE.getRootView().setVisibility(8);
                            a.this.lkC.uv(false);
                            a.this.lkD.uv(true);
                            a.this.lkE.uv(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.lkG.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dbE();
                    a.this.dbF();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbE() {
        an anVar = new an("c12424");
        anVar.af("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbF() {
        if (this.mCurrentTabIndex == 0) {
            dbJ();
            dbH();
            return;
        }
        replay();
    }

    public void replay() {
        dbJ();
        this.lkB.start();
        this.lkB.seekTo(0);
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
        dbJ();
        this.lkC.onPause();
        this.lkD.onPause();
        this.lkE.onPause();
    }

    public void onResume() {
        this.lkB.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.lkB.resumeMedia();
        }
        this.lkC.onResume();
        this.lkD.onResume();
        this.lkE.onResume();
    }

    public MaskVideoView dbG() {
        return this.lkB;
    }

    public Bitmap B(Bitmap bitmap) {
        return this.lkC.B(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.lkD.setMusicData(list);
    }

    public void eE(List<PendantData> list) {
        this.lkC.eE(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.lkE != null) {
            this.lkE.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.lkC.setData(str);
                this.lkB.setVideoPath(str);
                this.lkB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.lkC.dbR();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.lkB.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.lkB.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.lkB.seekTo(a.this.lkC.getCurrentPosition());
                    }
                });
                this.lkB.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.lkD.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dbH() {
        if (this.lkB != null) {
            this.lkB.seekTo(this.lkC.getCurrentPosition());
        }
    }

    public void dbI() {
        if (this.lkB != null) {
            this.lkB.El(this.lkC.getCurrentPosition());
        }
    }

    public void dbJ() {
        if (this.lkB != null) {
            this.lkB.dbO();
        }
    }

    public void dbK() {
        if (this.lkB != null) {
            this.lkB.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.lkG.onChangeSkinType(i);
        this.lkG.setDiverColor(am.getColor(i, R.color.cp_cont_b));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.lkC != null) {
            this.lkC.onChangeSkinType(eVar, i);
        }
        if (this.lkD != null) {
            this.lkD.onChangeSkinType(eVar, i);
        }
    }

    private void blF() {
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
                a.this.lkC.hideSoftKeyPad();
                if (a.this.ljs != null) {
                    a.this.ljs.onNext();
                }
            }
        }), (int) R.color.cp_cont_f);
    }

    public String getText() {
        return this.lkC.getText();
    }

    public int getCurrentPosition() {
        if (this.lkB == null) {
            return 0;
        }
        return this.lkB.getCurrentPosition();
    }

    public void showDialog() {
        if (this.jYe == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.jYe = new i(getPageContext());
            this.jYe.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.jYe.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.dvn);
        }
        this.jYe.showDialog();
    }

    public void eX(String str, String str2) {
        this.lkD.eX(str, str2);
    }

    public void daZ() {
        if (this.ljs != null) {
            this.ljs.daZ();
        }
    }

    public String dbL() {
        return this.lkD.dbL();
    }

    public String dbM() {
        return this.lkD.dbM();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean dbN() {
        return this.lkD.dbN();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.lkC != null) {
            this.lkC.release();
        }
        if (this.lkB != null) {
            this.lkB.stopPlayback();
        }
    }

    public void az(Intent intent) {
        this.lkD.az(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dbG() != null) {
            dbG().setGenMaskCoverListener(bVar);
        }
    }
}
