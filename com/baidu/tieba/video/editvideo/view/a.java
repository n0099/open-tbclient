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
    private k.c cVP;
    private i jmr;
    private h khZ;
    private com.baidu.tieba.video.editvideo.a kxw;
    private MaskVideoView kyC;
    private b kyD;
    private d kyE;
    private c kyF;
    private FrameLayout kyG;
    private FragmentTabWidget kyH;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.cVP = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.kxw != null) {
                            a.this.kxw.cPH();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.kxw != null) {
                            a.this.kxw.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.jmr != null && a.this.jmr.isShowing() && a.this.getPageContext() != null) {
                    a.this.jmr.dismiss();
                }
            }
        };
        this.kxw = aVar;
        this.mRootView = view;
        this.khZ = hVar;
        this.mResources = view.getResources();
        this.kyD = new b(this.mContext, this);
        this.kyE = new d(this.mContext, this, this.khZ);
        this.kyF = new c(this.mContext, this);
        this.kyD.cW(this.mRootView);
        this.kyE.cW(this.mRootView);
        this.kyF.cW(this.mRootView);
        initView();
        cQn();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.kyC = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.kyC.setPreserveEGLContextOnPause(true);
        this.kyC.setZOrderMediaOverlay(true);
        this.kyC.setPostMonitorManager(this.khZ);
        this.kyG = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.kyG.addView(this.kyD.getRootView());
        this.kyH = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bcK();
        cQm();
        this.kyG.addView(this.kyE.getRootView());
        this.kyG.addView(this.kyF.getRootView());
        this.kyE.getRootView().setVisibility(8);
        this.kyF.getRootView().setVisibility(8);
    }

    private boolean cQl() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void cQm() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.kyH.addView(fragmentTabIndicator, i);
        }
        if (!cQl() && this.kyH.getChildAt(1) != null) {
            this.kyH.getChildAt(1).setVisibility(8);
        }
        this.kyH.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.kyH.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.kyH.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.kyH.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.kyH.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.kyD.getRootView().setVisibility(0);
                            a.this.kyE.getRootView().setVisibility(8);
                            a.this.kyF.getRootView().setVisibility(8);
                            a.this.kyD.to(true);
                            a.this.kyE.to(false);
                            a.this.kyF.to(false);
                            break;
                        case 1:
                            a.this.kyF.getRootView().setVisibility(0);
                            a.this.kyE.getRootView().setVisibility(8);
                            a.this.kyD.getRootView().setVisibility(8);
                            a.this.kyD.to(false);
                            if (TextUtils.isEmpty(a.this.kyE.cQu())) {
                                a.this.kyE.to(false);
                            } else {
                                a.this.kyE.to(true);
                            }
                            a.this.kyF.to(true);
                            break;
                        case 2:
                            a.this.kyE.getRootView().setVisibility(0);
                            a.this.kyD.getRootView().setVisibility(8);
                            a.this.kyF.getRootView().setVisibility(8);
                            a.this.kyD.to(false);
                            a.this.kyE.to(true);
                            a.this.kyF.to(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.kyH.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.cQn();
                    a.this.cQo();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQn() {
        an anVar = new an("c12424");
        anVar.X("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQo() {
        if (this.mCurrentTabIndex == 0) {
            cQs();
            cQq();
            return;
        }
        replay();
    }

    public void replay() {
        cQs();
        this.kyC.start();
        this.kyC.seekTo(0);
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
        cQs();
        this.kyD.onPause();
        this.kyE.onPause();
        this.kyF.onPause();
    }

    public void onResume() {
        this.kyC.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.kyC.resumeMedia();
        }
        this.kyD.onResume();
        this.kyE.onResume();
        this.kyF.onResume();
    }

    public MaskVideoView cQp() {
        return this.kyC;
    }

    public Bitmap z(Bitmap bitmap) {
        return this.kyD.z(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.kyE.setMusicData(list);
    }

    public void ep(List<PendantData> list) {
        this.kyD.ep(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.kyF != null) {
            this.kyF.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.kyD.setData(str);
                this.kyC.setVideoPath(str);
                this.kyC.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.kyD.cQA();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.kyC.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.kyC.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.kyC.seekTo(a.this.kyD.getCurrentPosition());
                    }
                });
                this.kyC.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.kyE.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cQq() {
        if (this.kyC != null) {
            this.kyC.seekTo(this.kyD.getCurrentPosition());
        }
    }

    public void cQr() {
        if (this.kyC != null) {
            this.kyC.Dz(this.kyD.getCurrentPosition());
        }
    }

    public void cQs() {
        if (this.kyC != null) {
            this.kyC.cQx();
        }
    }

    public void cQt() {
        if (this.kyC != null) {
            this.kyC.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.kyH.onChangeSkinType(i);
        this.kyH.setDiverColor(am.getColor(i, R.color.cp_cont_b));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.kyD != null) {
            this.kyD.onChangeSkinType(eVar, i);
        }
        if (this.kyE != null) {
            this.kyE.onChangeSkinType(eVar, i);
        }
    }

    private void bcK() {
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
                a.this.kyD.hideSoftKeyPad();
                if (a.this.kxw != null) {
                    a.this.kxw.onNext();
                }
            }
        }), (int) R.color.cp_cont_f);
    }

    public String getText() {
        return this.kyD.getText();
    }

    public int getCurrentPosition() {
        if (this.kyC == null) {
            return 0;
        }
        return this.kyC.getCurrentPosition();
    }

    public void showDialog() {
        if (this.jmr == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.jmr = new i(getPageContext());
            this.jmr.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.jmr.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.cVP);
        }
        this.jmr.showDialog();
    }

    public void eK(String str, String str2) {
        this.kyE.eK(str, str2);
    }

    public void cPJ() {
        if (this.kxw != null) {
            this.kxw.cPJ();
        }
    }

    public String cQu() {
        return this.kyE.cQu();
    }

    public String cQv() {
        return this.kyE.cQv();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean cQw() {
        return this.kyE.cQw();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.kyD != null) {
            this.kyD.release();
        }
        if (this.kyC != null) {
            this.kyC.stopPlayback();
        }
    }

    public void aA(Intent intent) {
        this.kyE.aA(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && cQp() != null) {
            cQp().setGenMaskCoverListener(bVar);
        }
    }
}
