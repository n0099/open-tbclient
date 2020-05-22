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
    private k.c dJm;
    private i kqb;
    private com.baidu.tieba.video.editvideo.a lCh;
    private MaskVideoView lDq;
    private b lDr;
    private d lDs;
    private c lDt;
    private FrameLayout lDu;
    private FragmentTabWidget lDv;
    private h lmg;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.dJm = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.lCh != null) {
                            a.this.lCh.dij();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.lCh != null) {
                            a.this.lCh.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.kqb != null && a.this.kqb.isShowing() && a.this.getPageContext() != null) {
                    a.this.kqb.dismiss();
                }
            }
        };
        this.lCh = aVar;
        this.mRootView = view;
        this.lmg = hVar;
        this.mResources = view.getResources();
        this.lDr = new b(this.mContext, this);
        this.lDs = new d(this.mContext, this, this.lmg);
        this.lDt = new c(this.mContext, this);
        this.lDr.df(this.mRootView);
        this.lDs.df(this.mRootView);
        this.lDt.df(this.mRootView);
        initView();
        diQ();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.lDq = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.lDq.setPreserveEGLContextOnPause(true);
        this.lDq.setZOrderMediaOverlay(true);
        this.lDq.setPostMonitorManager(this.lmg);
        this.lDu = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.lDu.addView(this.lDr.getRootView());
        this.lDv = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        brb();
        diP();
        this.lDu.addView(this.lDs.getRootView());
        this.lDu.addView(this.lDt.getRootView());
        this.lDs.getRootView().setVisibility(8);
        this.lDt.getRootView().setVisibility(8);
    }

    private boolean diO() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void diP() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.lDv.addView(fragmentTabIndicator, i);
        }
        if (!diO() && this.lDv.getChildAt(1) != null) {
            this.lDv.getChildAt(1).setVisibility(8);
        }
        this.lDv.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.lDv.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.lDv.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.lDv.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.lDv.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.lDr.getRootView().setVisibility(0);
                            a.this.lDs.getRootView().setVisibility(8);
                            a.this.lDt.getRootView().setVisibility(8);
                            a.this.lDr.uT(true);
                            a.this.lDs.uT(false);
                            a.this.lDt.uT(false);
                            break;
                        case 1:
                            a.this.lDt.getRootView().setVisibility(0);
                            a.this.lDs.getRootView().setVisibility(8);
                            a.this.lDr.getRootView().setVisibility(8);
                            a.this.lDr.uT(false);
                            if (TextUtils.isEmpty(a.this.lDs.diX())) {
                                a.this.lDs.uT(false);
                            } else {
                                a.this.lDs.uT(true);
                            }
                            a.this.lDt.uT(true);
                            break;
                        case 2:
                            a.this.lDs.getRootView().setVisibility(0);
                            a.this.lDr.getRootView().setVisibility(8);
                            a.this.lDt.getRootView().setVisibility(8);
                            a.this.lDr.uT(false);
                            a.this.lDs.uT(true);
                            a.this.lDt.uT(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.lDv.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.diQ();
                    a.this.diR();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diQ() {
        an anVar = new an("c12424");
        anVar.ag("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diR() {
        if (this.mCurrentTabIndex == 0) {
            diV();
            diT();
            return;
        }
        replay();
    }

    public void replay() {
        diV();
        this.lDq.start();
        this.lDq.seekTo(0);
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
        diV();
        this.lDr.onPause();
        this.lDs.onPause();
        this.lDt.onPause();
    }

    public void onResume() {
        this.lDq.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.lDq.resumeMedia();
        }
        this.lDr.onResume();
        this.lDs.onResume();
        this.lDt.onResume();
    }

    public MaskVideoView diS() {
        return this.lDq;
    }

    public Bitmap D(Bitmap bitmap) {
        return this.lDr.D(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.lDs.setMusicData(list);
    }

    public void eL(List<PendantData> list) {
        this.lDr.eL(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.lDt != null) {
            this.lDt.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.lDr.setData(str);
                this.lDq.setVideoPath(str);
                this.lDq.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.mMediaPlayer = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.mMediaPlayer.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.mMediaPlayer.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.lDr.djd();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.lDq.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.lDq.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.lDq.seekTo(a.this.lDr.getCurrentPosition());
                    }
                });
                this.lDq.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.lDs.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void diT() {
        if (this.lDq != null) {
            this.lDq.seekTo(this.lDr.getCurrentPosition());
        }
    }

    public void diU() {
        if (this.lDq != null) {
            this.lDq.EW(this.lDr.getCurrentPosition());
        }
    }

    public void diV() {
        if (this.lDq != null) {
            this.lDq.dja();
        }
    }

    public void diW() {
        if (this.lDq != null) {
            this.lDq.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.lDv.onChangeSkinType(i);
        this.lDv.setDiverColor(am.getColor(i, R.color.cp_cont_b));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.lDr != null) {
            this.lDr.onChangeSkinType(eVar, i);
        }
        if (this.lDs != null) {
            this.lDs.onChangeSkinType(eVar, i);
        }
    }

    private void brb() {
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
                a.this.lDr.hideSoftKeyPad();
                if (a.this.lCh != null) {
                    a.this.lCh.onNext();
                }
            }
        }), (int) R.color.cp_cont_f);
    }

    public String getText() {
        return this.lDr.getText();
    }

    public int getCurrentPosition() {
        if (this.lDq == null) {
            return 0;
        }
        return this.lDq.getCurrentPosition();
    }

    public void showDialog() {
        if (this.kqb == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.kqb = new i(getPageContext());
            this.kqb.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.kqb.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.dJm);
        }
        this.kqb.showDialog();
    }

    public void fy(String str, String str2) {
        this.lDs.fy(str, str2);
    }

    public void dil() {
        if (this.lCh != null) {
            this.lCh.dil();
        }
    }

    public String diX() {
        return this.lDs.diX();
    }

    public String diY() {
        return this.lDs.diY();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean diZ() {
        return this.lDs.diZ();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.lDr != null) {
            this.lDr.release();
        }
        if (this.lDq != null) {
            this.lDq.stopPlayback();
        }
    }

    public void ak(Intent intent) {
        this.lDs.ak(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && diS() != null) {
            diS().setGenMaskCoverListener(bVar);
        }
    }
}
