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
    private k.c cWc;
    private i jnQ;
    private MaskVideoView kAj;
    private b kAk;
    private d kAl;
    private c kAm;
    private FrameLayout kAn;
    private FragmentTabWidget kAo;
    private h kjC;
    private com.baidu.tieba.video.editvideo.a kzb;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.cWc = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.kzb != null) {
                            a.this.kzb.cQb();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.kzb != null) {
                            a.this.kzb.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.jnQ != null && a.this.jnQ.isShowing() && a.this.getPageContext() != null) {
                    a.this.jnQ.dismiss();
                }
            }
        };
        this.kzb = aVar;
        this.mRootView = view;
        this.kjC = hVar;
        this.mResources = view.getResources();
        this.kAk = new b(this.mContext, this);
        this.kAl = new d(this.mContext, this, this.kjC);
        this.kAm = new c(this.mContext, this);
        this.kAk.cW(this.mRootView);
        this.kAl.cW(this.mRootView);
        this.kAm.cW(this.mRootView);
        initView();
        cQH();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.kAj = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.kAj.setPreserveEGLContextOnPause(true);
        this.kAj.setZOrderMediaOverlay(true);
        this.kAj.setPostMonitorManager(this.kjC);
        this.kAn = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.kAn.addView(this.kAk.getRootView());
        this.kAo = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bcO();
        cQG();
        this.kAn.addView(this.kAl.getRootView());
        this.kAn.addView(this.kAm.getRootView());
        this.kAl.getRootView().setVisibility(8);
        this.kAm.getRootView().setVisibility(8);
    }

    private boolean cQF() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void cQG() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.kAo.addView(fragmentTabIndicator, i);
        }
        if (!cQF() && this.kAo.getChildAt(1) != null) {
            this.kAo.getChildAt(1).setVisibility(8);
        }
        this.kAo.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.kAo.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.kAo.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.kAo.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.kAo.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.kAk.getRootView().setVisibility(0);
                            a.this.kAl.getRootView().setVisibility(8);
                            a.this.kAm.getRootView().setVisibility(8);
                            a.this.kAk.tu(true);
                            a.this.kAl.tu(false);
                            a.this.kAm.tu(false);
                            break;
                        case 1:
                            a.this.kAm.getRootView().setVisibility(0);
                            a.this.kAl.getRootView().setVisibility(8);
                            a.this.kAk.getRootView().setVisibility(8);
                            a.this.kAk.tu(false);
                            if (TextUtils.isEmpty(a.this.kAl.cQO())) {
                                a.this.kAl.tu(false);
                            } else {
                                a.this.kAl.tu(true);
                            }
                            a.this.kAm.tu(true);
                            break;
                        case 2:
                            a.this.kAl.getRootView().setVisibility(0);
                            a.this.kAk.getRootView().setVisibility(8);
                            a.this.kAm.getRootView().setVisibility(8);
                            a.this.kAk.tu(false);
                            a.this.kAl.tu(true);
                            a.this.kAm.tu(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.kAo.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.cQH();
                    a.this.cQI();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQH() {
        an anVar = new an("c12424");
        anVar.X("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQI() {
        if (this.mCurrentTabIndex == 0) {
            cQM();
            cQK();
            return;
        }
        replay();
    }

    public void replay() {
        cQM();
        this.kAj.start();
        this.kAj.seekTo(0);
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
        cQM();
        this.kAk.onPause();
        this.kAl.onPause();
        this.kAm.onPause();
    }

    public void onResume() {
        this.kAj.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.kAj.resumeMedia();
        }
        this.kAk.onResume();
        this.kAl.onResume();
        this.kAm.onResume();
    }

    public MaskVideoView cQJ() {
        return this.kAj;
    }

    public Bitmap z(Bitmap bitmap) {
        return this.kAk.z(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.kAl.setMusicData(list);
    }

    public void ep(List<PendantData> list) {
        this.kAk.ep(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.kAm != null) {
            this.kAm.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.kAk.setData(str);
                this.kAj.setVideoPath(str);
                this.kAj.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.mMediaPlayer = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.mMediaPlayer.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.mMediaPlayer.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.kAk.cQU();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.kAj.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.kAj.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.kAj.seekTo(a.this.kAk.getCurrentPosition());
                    }
                });
                this.kAj.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.kAl.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cQK() {
        if (this.kAj != null) {
            this.kAj.seekTo(this.kAk.getCurrentPosition());
        }
    }

    public void cQL() {
        if (this.kAj != null) {
            this.kAj.DH(this.kAk.getCurrentPosition());
        }
    }

    public void cQM() {
        if (this.kAj != null) {
            this.kAj.cQR();
        }
    }

    public void cQN() {
        if (this.kAj != null) {
            this.kAj.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.kAo.onChangeSkinType(i);
        this.kAo.setDiverColor(am.getColor(i, R.color.cp_cont_b));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.kAk != null) {
            this.kAk.onChangeSkinType(eVar, i);
        }
        if (this.kAl != null) {
            this.kAl.onChangeSkinType(eVar, i);
        }
    }

    private void bcO() {
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
                a.this.kAk.hideSoftKeyPad();
                if (a.this.kzb != null) {
                    a.this.kzb.onNext();
                }
            }
        }), (int) R.color.cp_cont_f);
    }

    public String getText() {
        return this.kAk.getText();
    }

    public int getCurrentPosition() {
        if (this.kAj == null) {
            return 0;
        }
        return this.kAj.getCurrentPosition();
    }

    public void showDialog() {
        if (this.jnQ == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.jnQ = new i(getPageContext());
            this.jnQ.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.jnQ.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.cWc);
        }
        this.jnQ.showDialog();
    }

    public void eI(String str, String str2) {
        this.kAl.eI(str, str2);
    }

    public void cQd() {
        if (this.kzb != null) {
            this.kzb.cQd();
        }
    }

    public String cQO() {
        return this.kAl.cQO();
    }

    public String cQP() {
        return this.kAl.cQP();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean cQQ() {
        return this.kAl.cQQ();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.kAk != null) {
            this.kAk.release();
        }
        if (this.kAj != null) {
            this.kAj.stopPlayback();
        }
    }

    public void aA(Intent intent) {
        this.kAl.aA(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && cQJ() != null) {
            cQJ().setGenMaskCoverListener(bVar);
        }
    }
}
