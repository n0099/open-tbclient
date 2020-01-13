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
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends com.baidu.adp.base.c {
    private k.c cRL;
    private i jle;
    private h kgF;
    private com.baidu.tieba.video.editvideo.a kwi;
    private MaskVideoView kxo;
    private b kxp;
    private d kxq;
    private c kxr;
    private FrameLayout kxs;
    private FragmentTabWidget kxt;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.cRL = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.kwi != null) {
                            a.this.kwi.cOh();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.kwi != null) {
                            a.this.kwi.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.jle != null && a.this.jle.isShowing() && a.this.getPageContext() != null) {
                    a.this.jle.dismiss();
                }
            }
        };
        this.kwi = aVar;
        this.mRootView = view;
        this.kgF = hVar;
        this.mResources = view.getResources();
        this.kxp = new b(this.mContext, this);
        this.kxq = new d(this.mContext, this, this.kgF);
        this.kxr = new c(this.mContext, this);
        this.kxp.cU(this.mRootView);
        this.kxq.cU(this.mRootView);
        this.kxr.cU(this.mRootView);
        initView();
        cOP();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.kxo = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.kxo.setPreserveEGLContextOnPause(true);
        this.kxo.setZOrderMediaOverlay(true);
        this.kxo.setPostMonitorManager(this.kgF);
        this.kxs = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.kxs.addView(this.kxp.getRootView());
        this.kxt = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bas();
        cOO();
        this.kxs.addView(this.kxq.getRootView());
        this.kxs.addView(this.kxr.getRootView());
        this.kxq.getRootView().setVisibility(8);
        this.kxr.getRootView().setVisibility(8);
    }

    private boolean cON() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void cOO() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.kxt.addView(fragmentTabIndicator, i);
        }
        if (!cON() && this.kxt.getChildAt(1) != null) {
            this.kxt.getChildAt(1).setVisibility(8);
        }
        this.kxt.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.kxt.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.kxt.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.kxt.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.kxt.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.kxp.getRootView().setVisibility(0);
                            a.this.kxq.getRootView().setVisibility(8);
                            a.this.kxr.getRootView().setVisibility(8);
                            a.this.kxp.tk(true);
                            a.this.kxq.tk(false);
                            a.this.kxr.tk(false);
                            break;
                        case 1:
                            a.this.kxr.getRootView().setVisibility(0);
                            a.this.kxq.getRootView().setVisibility(8);
                            a.this.kxp.getRootView().setVisibility(8);
                            a.this.kxp.tk(false);
                            if (TextUtils.isEmpty(a.this.kxq.cOW())) {
                                a.this.kxq.tk(false);
                            } else {
                                a.this.kxq.tk(true);
                            }
                            a.this.kxr.tk(true);
                            break;
                        case 2:
                            a.this.kxq.getRootView().setVisibility(0);
                            a.this.kxp.getRootView().setVisibility(8);
                            a.this.kxr.getRootView().setVisibility(8);
                            a.this.kxp.tk(false);
                            a.this.kxq.tk(true);
                            a.this.kxr.tk(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.kxt.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.cOP();
                    a.this.cOQ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOP() {
        an anVar = new an("c12424");
        anVar.Z("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOQ() {
        if (this.mCurrentTabIndex == 0) {
            cOU();
            cOS();
            return;
        }
        replay();
    }

    public void replay() {
        cOU();
        this.kxo.start();
        this.kxo.seekTo(0);
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
        cOU();
        this.kxp.onPause();
        this.kxq.onPause();
        this.kxr.onPause();
    }

    public void onResume() {
        this.kxo.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.kxo.resumeMedia();
        }
        this.kxp.onResume();
        this.kxq.onResume();
        this.kxr.onResume();
    }

    public MaskVideoView cOR() {
        return this.kxo;
    }

    public Bitmap z(Bitmap bitmap) {
        return this.kxp.z(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.kxq.setMusicData(list);
    }

    public void et(List<PendantData> list) {
        this.kxp.et(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.kxr != null) {
            this.kxr.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.kxp.setData(str);
                this.kxo.setVideoPath(str);
                this.kxo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.kxp.cPc();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.kxo.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.kxo.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.kxo.seekTo(a.this.kxp.getCurrentPosition());
                    }
                });
                this.kxo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.kxq.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cOS() {
        if (this.kxo != null) {
            this.kxo.seekTo(this.kxp.getCurrentPosition());
        }
    }

    public void cOT() {
        if (this.kxo != null) {
            this.kxo.Dt(this.kxp.getCurrentPosition());
        }
    }

    public void cOU() {
        if (this.kxo != null) {
            this.kxo.cOZ();
        }
    }

    public void cOV() {
        if (this.kxo != null) {
            this.kxo.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.kxt.onChangeSkinType(i);
        this.kxt.setDiverColor(am.getColor(i, R.color.cp_cont_b));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.kxp != null) {
            this.kxp.onChangeSkinType(eVar, i);
        }
        if (this.kxq != null) {
            this.kxq.onChangeSkinType(eVar, i);
        }
    }

    private void bas() {
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
                a.this.kxp.hideSoftKeyPad();
                if (a.this.kwi != null) {
                    a.this.kwi.onNext();
                }
            }
        }), (int) R.color.cp_cont_f);
    }

    public String getText() {
        return this.kxp.getText();
    }

    public int getCurrentPosition() {
        if (this.kxo == null) {
            return 0;
        }
        return this.kxo.getCurrentPosition();
    }

    public void showDialog() {
        if (this.jle == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.jle = new i(getPageContext());
            this.jle.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.jle.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.cRL);
        }
        this.jle.showDialog();
    }

    public void eB(String str, String str2) {
        this.kxq.eB(str, str2);
    }

    public void cOj() {
        if (this.kwi != null) {
            this.kwi.cOj();
        }
    }

    public String cOW() {
        return this.kxq.cOW();
    }

    public String cOX() {
        return this.kxq.cOX();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean cOY() {
        return this.kxq.cOY();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.kxp != null) {
            this.kxp.release();
        }
        if (this.kxo != null) {
            this.kxo.stopPlayback();
        }
    }

    public void aA(Intent intent) {
        this.kxq.aA(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && cOR() != null) {
            cOR().setGenMaskCoverListener(bVar);
        }
    }
}
