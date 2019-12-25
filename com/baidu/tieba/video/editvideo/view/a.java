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
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.base.c {
    private k.c cRB;
    private i jhC;
    private h kdc;
    private com.baidu.tieba.video.editvideo.a ksF;
    private MaskVideoView ktL;
    private b ktM;
    private d ktN;
    private c ktO;
    private FrameLayout ktP;
    private FragmentTabWidget ktQ;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.cRB = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.ksF != null) {
                            a.this.ksF.cNc();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.ksF != null) {
                            a.this.ksF.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.jhC != null && a.this.jhC.isShowing() && a.this.getPageContext() != null) {
                    a.this.jhC.dismiss();
                }
            }
        };
        this.ksF = aVar;
        this.mRootView = view;
        this.kdc = hVar;
        this.mResources = view.getResources();
        this.ktM = new b(this.mContext, this);
        this.ktN = new d(this.mContext, this, this.kdc);
        this.ktO = new c(this.mContext, this);
        this.ktM.cO(this.mRootView);
        this.ktN.cO(this.mRootView);
        this.ktO.cO(this.mRootView);
        initView();
        cNM();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.ktL = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.ktL.setPreserveEGLContextOnPause(true);
        this.ktL.setZOrderMediaOverlay(true);
        this.ktL.setPostMonitorManager(this.kdc);
        this.ktP = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.ktP.addView(this.ktM.getRootView());
        this.ktQ = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        aZT();
        cNL();
        this.ktP.addView(this.ktN.getRootView());
        this.ktP.addView(this.ktO.getRootView());
        this.ktN.getRootView().setVisibility(8);
        this.ktO.getRootView().setVisibility(8);
    }

    private boolean cNK() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void cNL() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.ktQ.addView(fragmentTabIndicator, i);
        }
        if (!cNK() && this.ktQ.getChildAt(1) != null) {
            this.ktQ.getChildAt(1).setVisibility(8);
        }
        this.ktQ.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.ktQ.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.ktQ.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.ktQ.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.ktQ.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.ktM.getRootView().setVisibility(0);
                            a.this.ktN.getRootView().setVisibility(8);
                            a.this.ktO.getRootView().setVisibility(8);
                            a.this.ktM.sY(true);
                            a.this.ktN.sY(false);
                            a.this.ktO.sY(false);
                            break;
                        case 1:
                            a.this.ktO.getRootView().setVisibility(0);
                            a.this.ktN.getRootView().setVisibility(8);
                            a.this.ktM.getRootView().setVisibility(8);
                            a.this.ktM.sY(false);
                            if (TextUtils.isEmpty(a.this.ktN.cNT())) {
                                a.this.ktN.sY(false);
                            } else {
                                a.this.ktN.sY(true);
                            }
                            a.this.ktO.sY(true);
                            break;
                        case 2:
                            a.this.ktN.getRootView().setVisibility(0);
                            a.this.ktM.getRootView().setVisibility(8);
                            a.this.ktO.getRootView().setVisibility(8);
                            a.this.ktM.sY(false);
                            a.this.ktN.sY(true);
                            a.this.ktO.sY(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.ktQ.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.cNM();
                    a.this.cNN();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNM() {
        an anVar = new an("c12424");
        anVar.Z("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNN() {
        if (this.mCurrentTabIndex == 0) {
            cNR();
            cNP();
            return;
        }
        replay();
    }

    public void replay() {
        cNR();
        this.ktL.start();
        this.ktL.seekTo(0);
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
        cNR();
        this.ktM.onPause();
        this.ktN.onPause();
        this.ktO.onPause();
    }

    public void onResume() {
        this.ktL.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.ktL.resumeMedia();
        }
        this.ktM.onResume();
        this.ktN.onResume();
        this.ktO.onResume();
    }

    public MaskVideoView cNO() {
        return this.ktL;
    }

    public Bitmap z(Bitmap bitmap) {
        return this.ktM.z(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.ktN.setMusicData(list);
    }

    public void et(List<PendantData> list) {
        this.ktM.et(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.ktO != null) {
            this.ktO.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.ktM.setData(str);
                this.ktL.setVideoPath(str);
                this.ktL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.mMediaPlayer = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.mMediaPlayer.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.mMediaPlayer.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.ktM.cNZ();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.ktL.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.ktL.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.ktL.seekTo(a.this.ktM.getCurrentPosition());
                    }
                });
                this.ktL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.ktN.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cNP() {
        if (this.ktL != null) {
            this.ktL.seekTo(this.ktM.getCurrentPosition());
        }
    }

    public void cNQ() {
        if (this.ktL != null) {
            this.ktL.Dn(this.ktM.getCurrentPosition());
        }
    }

    public void cNR() {
        if (this.ktL != null) {
            this.ktL.cNW();
        }
    }

    public void cNS() {
        if (this.ktL != null) {
            this.ktL.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.ktQ.onChangeSkinType(i);
        this.ktQ.setDiverColor(am.getColor(i, R.color.cp_cont_b));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.ktM != null) {
            this.ktM.onChangeSkinType(eVar, i);
        }
        if (this.ktN != null) {
            this.ktN.onChangeSkinType(eVar, i);
        }
    }

    private void aZT() {
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
                a.this.ktM.hideSoftKeyPad();
                if (a.this.ksF != null) {
                    a.this.ksF.onNext();
                }
            }
        }), (int) R.color.cp_cont_f);
    }

    public String getText() {
        return this.ktM.getText();
    }

    public int getCurrentPosition() {
        if (this.ktL == null) {
            return 0;
        }
        return this.ktL.getCurrentPosition();
    }

    public void showDialog() {
        if (this.jhC == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.jhC = new i(getPageContext());
            this.jhC.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.jhC.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.cRB);
        }
        this.jhC.showDialog();
    }

    public void ez(String str, String str2) {
        this.ktN.ez(str, str2);
    }

    public void cNe() {
        if (this.ksF != null) {
            this.ksF.cNe();
        }
    }

    public String cNT() {
        return this.ktN.cNT();
    }

    public String cNU() {
        return this.ktN.cNU();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean cNV() {
        return this.ktN.cNV();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.ktM != null) {
            this.ktM.release();
        }
        if (this.ktL != null) {
            this.ktL.stopPlayback();
        }
    }

    public void aA(Intent intent) {
        this.ktN.aA(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && cNO() != null) {
            cNO().setGenMaskCoverListener(bVar);
        }
    }
}
