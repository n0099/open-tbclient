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
    private i krh;
    private com.baidu.tieba.video.editvideo.a lDq;
    private b lEA;
    private d lEB;
    private c lEC;
    private FrameLayout lED;
    private FragmentTabWidget lEE;
    private MaskVideoView lEz;
    private h lnq;
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
                        if (a.this.lDq != null) {
                            a.this.lDq.diy();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.lDq != null) {
                            a.this.lDq.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.krh != null && a.this.krh.isShowing() && a.this.getPageContext() != null) {
                    a.this.krh.dismiss();
                }
            }
        };
        this.lDq = aVar;
        this.mRootView = view;
        this.lnq = hVar;
        this.mResources = view.getResources();
        this.lEA = new b(this.mContext, this);
        this.lEB = new d(this.mContext, this, this.lnq);
        this.lEC = new c(this.mContext, this);
        this.lEA.df(this.mRootView);
        this.lEB.df(this.mRootView);
        this.lEC.df(this.mRootView);
        initView();
        djf();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.lEz = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.lEz.setPreserveEGLContextOnPause(true);
        this.lEz.setZOrderMediaOverlay(true);
        this.lEz.setPostMonitorManager(this.lnq);
        this.lED = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.lED.addView(this.lEA.getRootView());
        this.lEE = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        brd();
        dje();
        this.lED.addView(this.lEB.getRootView());
        this.lED.addView(this.lEC.getRootView());
        this.lEB.getRootView().setVisibility(8);
        this.lEC.getRootView().setVisibility(8);
    }

    private boolean djd() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dje() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.lEE.addView(fragmentTabIndicator, i);
        }
        if (!djd() && this.lEE.getChildAt(1) != null) {
            this.lEE.getChildAt(1).setVisibility(8);
        }
        this.lEE.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.lEE.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.lEE.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.lEE.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.lEE.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.lEA.getRootView().setVisibility(0);
                            a.this.lEB.getRootView().setVisibility(8);
                            a.this.lEC.getRootView().setVisibility(8);
                            a.this.lEA.uT(true);
                            a.this.lEB.uT(false);
                            a.this.lEC.uT(false);
                            break;
                        case 1:
                            a.this.lEC.getRootView().setVisibility(0);
                            a.this.lEB.getRootView().setVisibility(8);
                            a.this.lEA.getRootView().setVisibility(8);
                            a.this.lEA.uT(false);
                            if (TextUtils.isEmpty(a.this.lEB.djm())) {
                                a.this.lEB.uT(false);
                            } else {
                                a.this.lEB.uT(true);
                            }
                            a.this.lEC.uT(true);
                            break;
                        case 2:
                            a.this.lEB.getRootView().setVisibility(0);
                            a.this.lEA.getRootView().setVisibility(8);
                            a.this.lEC.getRootView().setVisibility(8);
                            a.this.lEA.uT(false);
                            a.this.lEB.uT(true);
                            a.this.lEC.uT(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.lEE.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.djf();
                    a.this.djg();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djf() {
        an anVar = new an("c12424");
        anVar.ag("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djg() {
        if (this.mCurrentTabIndex == 0) {
            djk();
            dji();
            return;
        }
        replay();
    }

    public void replay() {
        djk();
        this.lEz.start();
        this.lEz.seekTo(0);
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
        djk();
        this.lEA.onPause();
        this.lEB.onPause();
        this.lEC.onPause();
    }

    public void onResume() {
        this.lEz.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.lEz.resumeMedia();
        }
        this.lEA.onResume();
        this.lEB.onResume();
        this.lEC.onResume();
    }

    public MaskVideoView djh() {
        return this.lEz;
    }

    public Bitmap D(Bitmap bitmap) {
        return this.lEA.D(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.lEB.setMusicData(list);
    }

    public void eN(List<PendantData> list) {
        this.lEA.eN(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.lEC != null) {
            this.lEC.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.lEA.setData(str);
                this.lEz.setVideoPath(str);
                this.lEz.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.lEA.djs();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.lEz.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.lEz.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.lEz.seekTo(a.this.lEA.getCurrentPosition());
                    }
                });
                this.lEz.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.lEB.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dji() {
        if (this.lEz != null) {
            this.lEz.seekTo(this.lEA.getCurrentPosition());
        }
    }

    public void djj() {
        if (this.lEz != null) {
            this.lEz.EY(this.lEA.getCurrentPosition());
        }
    }

    public void djk() {
        if (this.lEz != null) {
            this.lEz.djp();
        }
    }

    public void djl() {
        if (this.lEz != null) {
            this.lEz.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.lEE.onChangeSkinType(i);
        this.lEE.setDiverColor(am.getColor(i, R.color.cp_cont_b));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.lEA != null) {
            this.lEA.onChangeSkinType(eVar, i);
        }
        if (this.lEB != null) {
            this.lEB.onChangeSkinType(eVar, i);
        }
    }

    private void brd() {
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
                a.this.lEA.hideSoftKeyPad();
                if (a.this.lDq != null) {
                    a.this.lDq.onNext();
                }
            }
        }), (int) R.color.cp_cont_f);
    }

    public String getText() {
        return this.lEA.getText();
    }

    public int getCurrentPosition() {
        if (this.lEz == null) {
            return 0;
        }
        return this.lEz.getCurrentPosition();
    }

    public void showDialog() {
        if (this.krh == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.krh = new i(getPageContext());
            this.krh.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.krh.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.dJm);
        }
        this.krh.showDialog();
    }

    public void fy(String str, String str2) {
        this.lEB.fy(str, str2);
    }

    public void diA() {
        if (this.lDq != null) {
            this.lDq.diA();
        }
    }

    public String djm() {
        return this.lEB.djm();
    }

    public String djn() {
        return this.lEB.djn();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean djo() {
        return this.lEB.djo();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.lEA != null) {
            this.lEA.release();
        }
        if (this.lEz != null) {
            this.lEz.stopPlayback();
        }
    }

    public void al(Intent intent) {
        this.lEB.al(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && djh() != null) {
            djh().setGenMaskCoverListener(bVar);
        }
    }
}
