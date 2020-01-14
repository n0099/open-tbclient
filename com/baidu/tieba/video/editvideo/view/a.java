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
    private i jlj;
    private h kgK;
    private com.baidu.tieba.video.editvideo.a kwn;
    private MaskVideoView kxt;
    private b kxu;
    private d kxv;
    private c kxw;
    private FrameLayout kxx;
    private FragmentTabWidget kxy;
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
                        if (a.this.kwn != null) {
                            a.this.kwn.cOj();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.kwn != null) {
                            a.this.kwn.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.jlj != null && a.this.jlj.isShowing() && a.this.getPageContext() != null) {
                    a.this.jlj.dismiss();
                }
            }
        };
        this.kwn = aVar;
        this.mRootView = view;
        this.kgK = hVar;
        this.mResources = view.getResources();
        this.kxu = new b(this.mContext, this);
        this.kxv = new d(this.mContext, this, this.kgK);
        this.kxw = new c(this.mContext, this);
        this.kxu.cU(this.mRootView);
        this.kxv.cU(this.mRootView);
        this.kxw.cU(this.mRootView);
        initView();
        cOR();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.kxt = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.kxt.setPreserveEGLContextOnPause(true);
        this.kxt.setZOrderMediaOverlay(true);
        this.kxt.setPostMonitorManager(this.kgK);
        this.kxx = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.kxx.addView(this.kxu.getRootView());
        this.kxy = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bas();
        cOQ();
        this.kxx.addView(this.kxv.getRootView());
        this.kxx.addView(this.kxw.getRootView());
        this.kxv.getRootView().setVisibility(8);
        this.kxw.getRootView().setVisibility(8);
    }

    private boolean cOP() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void cOQ() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.kxy.addView(fragmentTabIndicator, i);
        }
        if (!cOP() && this.kxy.getChildAt(1) != null) {
            this.kxy.getChildAt(1).setVisibility(8);
        }
        this.kxy.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.kxy.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.kxy.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.kxy.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.kxy.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.kxu.getRootView().setVisibility(0);
                            a.this.kxv.getRootView().setVisibility(8);
                            a.this.kxw.getRootView().setVisibility(8);
                            a.this.kxu.tk(true);
                            a.this.kxv.tk(false);
                            a.this.kxw.tk(false);
                            break;
                        case 1:
                            a.this.kxw.getRootView().setVisibility(0);
                            a.this.kxv.getRootView().setVisibility(8);
                            a.this.kxu.getRootView().setVisibility(8);
                            a.this.kxu.tk(false);
                            if (TextUtils.isEmpty(a.this.kxv.cOY())) {
                                a.this.kxv.tk(false);
                            } else {
                                a.this.kxv.tk(true);
                            }
                            a.this.kxw.tk(true);
                            break;
                        case 2:
                            a.this.kxv.getRootView().setVisibility(0);
                            a.this.kxu.getRootView().setVisibility(8);
                            a.this.kxw.getRootView().setVisibility(8);
                            a.this.kxu.tk(false);
                            a.this.kxv.tk(true);
                            a.this.kxw.tk(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.kxy.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.cOR();
                    a.this.cOS();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOR() {
        an anVar = new an("c12424");
        anVar.Z("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOS() {
        if (this.mCurrentTabIndex == 0) {
            cOW();
            cOU();
            return;
        }
        replay();
    }

    public void replay() {
        cOW();
        this.kxt.start();
        this.kxt.seekTo(0);
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
        cOW();
        this.kxu.onPause();
        this.kxv.onPause();
        this.kxw.onPause();
    }

    public void onResume() {
        this.kxt.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.kxt.resumeMedia();
        }
        this.kxu.onResume();
        this.kxv.onResume();
        this.kxw.onResume();
    }

    public MaskVideoView cOT() {
        return this.kxt;
    }

    public Bitmap z(Bitmap bitmap) {
        return this.kxu.z(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.kxv.setMusicData(list);
    }

    public void et(List<PendantData> list) {
        this.kxu.et(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.kxw != null) {
            this.kxw.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.kxu.setData(str);
                this.kxt.setVideoPath(str);
                this.kxt.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.kxu.cPe();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.kxt.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.kxt.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.kxt.seekTo(a.this.kxu.getCurrentPosition());
                    }
                });
                this.kxt.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.kxv.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cOU() {
        if (this.kxt != null) {
            this.kxt.seekTo(this.kxu.getCurrentPosition());
        }
    }

    public void cOV() {
        if (this.kxt != null) {
            this.kxt.Dt(this.kxu.getCurrentPosition());
        }
    }

    public void cOW() {
        if (this.kxt != null) {
            this.kxt.cPb();
        }
    }

    public void cOX() {
        if (this.kxt != null) {
            this.kxt.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.kxy.onChangeSkinType(i);
        this.kxy.setDiverColor(am.getColor(i, R.color.cp_cont_b));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.kxu != null) {
            this.kxu.onChangeSkinType(eVar, i);
        }
        if (this.kxv != null) {
            this.kxv.onChangeSkinType(eVar, i);
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
                a.this.kxu.hideSoftKeyPad();
                if (a.this.kwn != null) {
                    a.this.kwn.onNext();
                }
            }
        }), (int) R.color.cp_cont_f);
    }

    public String getText() {
        return this.kxu.getText();
    }

    public int getCurrentPosition() {
        if (this.kxt == null) {
            return 0;
        }
        return this.kxt.getCurrentPosition();
    }

    public void showDialog() {
        if (this.jlj == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.jlj = new i(getPageContext());
            this.jlj.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.jlj.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.cRL);
        }
        this.jlj.showDialog();
    }

    public void eB(String str, String str2) {
        this.kxv.eB(str, str2);
    }

    public void cOl() {
        if (this.kwn != null) {
            this.kwn.cOl();
        }
    }

    public String cOY() {
        return this.kxv.cOY();
    }

    public String cOZ() {
        return this.kxv.cOZ();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean cPa() {
        return this.kxv.cPa();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.kxu != null) {
            this.kxu.release();
        }
        if (this.kxt != null) {
            this.kxt.stopPlayback();
        }
    }

    public void aA(Intent intent) {
        this.kxv.aA(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && cOT() != null) {
            cOT().setGenMaskCoverListener(bVar);
        }
    }
}
