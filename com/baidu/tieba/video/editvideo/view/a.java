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
    private k.c cVO;
    private i jme;
    private h khN;
    private com.baidu.tieba.video.editvideo.a kxk;
    private MaskVideoView kyq;
    private b kyr;
    private d kys;
    private c kyt;
    private FrameLayout kyu;
    private FragmentTabWidget kyv;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.cVO = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.kxk != null) {
                            a.this.kxk.cPG();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.kxk != null) {
                            a.this.kxk.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.jme != null && a.this.jme.isShowing() && a.this.getPageContext() != null) {
                    a.this.jme.dismiss();
                }
            }
        };
        this.kxk = aVar;
        this.mRootView = view;
        this.khN = hVar;
        this.mResources = view.getResources();
        this.kyr = new b(this.mContext, this);
        this.kys = new d(this.mContext, this, this.khN);
        this.kyt = new c(this.mContext, this);
        this.kyr.cW(this.mRootView);
        this.kys.cW(this.mRootView);
        this.kyt.cW(this.mRootView);
        initView();
        cQm();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.kyq = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.kyq.setPreserveEGLContextOnPause(true);
        this.kyq.setZOrderMediaOverlay(true);
        this.kyq.setPostMonitorManager(this.khN);
        this.kyu = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.kyu.addView(this.kyr.getRootView());
        this.kyv = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bcJ();
        cQl();
        this.kyu.addView(this.kys.getRootView());
        this.kyu.addView(this.kyt.getRootView());
        this.kys.getRootView().setVisibility(8);
        this.kyt.getRootView().setVisibility(8);
    }

    private boolean cQk() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void cQl() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.kyv.addView(fragmentTabIndicator, i);
        }
        if (!cQk() && this.kyv.getChildAt(1) != null) {
            this.kyv.getChildAt(1).setVisibility(8);
        }
        this.kyv.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.kyv.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.kyv.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.kyv.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.kyv.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.kyr.getRootView().setVisibility(0);
                            a.this.kys.getRootView().setVisibility(8);
                            a.this.kyt.getRootView().setVisibility(8);
                            a.this.kyr.to(true);
                            a.this.kys.to(false);
                            a.this.kyt.to(false);
                            break;
                        case 1:
                            a.this.kyt.getRootView().setVisibility(0);
                            a.this.kys.getRootView().setVisibility(8);
                            a.this.kyr.getRootView().setVisibility(8);
                            a.this.kyr.to(false);
                            if (TextUtils.isEmpty(a.this.kys.cQt())) {
                                a.this.kys.to(false);
                            } else {
                                a.this.kys.to(true);
                            }
                            a.this.kyt.to(true);
                            break;
                        case 2:
                            a.this.kys.getRootView().setVisibility(0);
                            a.this.kyr.getRootView().setVisibility(8);
                            a.this.kyt.getRootView().setVisibility(8);
                            a.this.kyr.to(false);
                            a.this.kys.to(true);
                            a.this.kyt.to(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.kyv.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.cQm();
                    a.this.cQn();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQm() {
        an anVar = new an("c12424");
        anVar.X("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQn() {
        if (this.mCurrentTabIndex == 0) {
            cQr();
            cQp();
            return;
        }
        replay();
    }

    public void replay() {
        cQr();
        this.kyq.start();
        this.kyq.seekTo(0);
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
        cQr();
        this.kyr.onPause();
        this.kys.onPause();
        this.kyt.onPause();
    }

    public void onResume() {
        this.kyq.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.kyq.resumeMedia();
        }
        this.kyr.onResume();
        this.kys.onResume();
        this.kyt.onResume();
    }

    public MaskVideoView cQo() {
        return this.kyq;
    }

    public Bitmap z(Bitmap bitmap) {
        return this.kyr.z(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.kys.setMusicData(list);
    }

    public void ep(List<PendantData> list) {
        this.kyr.ep(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.kyt != null) {
            this.kyt.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.kyr.setData(str);
                this.kyq.setVideoPath(str);
                this.kyq.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.kyr.cQz();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.kyq.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.kyq.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.kyq.seekTo(a.this.kyr.getCurrentPosition());
                    }
                });
                this.kyq.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.kys.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cQp() {
        if (this.kyq != null) {
            this.kyq.seekTo(this.kyr.getCurrentPosition());
        }
    }

    public void cQq() {
        if (this.kyq != null) {
            this.kyq.Dz(this.kyr.getCurrentPosition());
        }
    }

    public void cQr() {
        if (this.kyq != null) {
            this.kyq.cQw();
        }
    }

    public void cQs() {
        if (this.kyq != null) {
            this.kyq.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.kyv.onChangeSkinType(i);
        this.kyv.setDiverColor(am.getColor(i, R.color.cp_cont_b));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.kyr != null) {
            this.kyr.onChangeSkinType(eVar, i);
        }
        if (this.kys != null) {
            this.kys.onChangeSkinType(eVar, i);
        }
    }

    private void bcJ() {
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
                a.this.kyr.hideSoftKeyPad();
                if (a.this.kxk != null) {
                    a.this.kxk.onNext();
                }
            }
        }), (int) R.color.cp_cont_f);
    }

    public String getText() {
        return this.kyr.getText();
    }

    public int getCurrentPosition() {
        if (this.kyq == null) {
            return 0;
        }
        return this.kyq.getCurrentPosition();
    }

    public void showDialog() {
        if (this.jme == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.jme = new i(getPageContext());
            this.jme.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.jme.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.cVO);
        }
        this.jme.showDialog();
    }

    public void eK(String str, String str2) {
        this.kys.eK(str, str2);
    }

    public void cPI() {
        if (this.kxk != null) {
            this.kxk.cPI();
        }
    }

    public String cQt() {
        return this.kys.cQt();
    }

    public String cQu() {
        return this.kys.cQu();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean cQv() {
        return this.kys.cQv();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.kyr != null) {
            this.kyr.release();
        }
        if (this.kyq != null) {
            this.kyq.stopPlayback();
        }
    }

    public void aA(Intent intent) {
        this.kys.aA(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && cQo() != null) {
            cQo().setGenMaskCoverListener(bVar);
        }
    }
}
