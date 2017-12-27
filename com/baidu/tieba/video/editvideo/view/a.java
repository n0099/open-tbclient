package com.baidu.tieba.video.editvideo.view;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.i.h;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c {
    private MediaPlayer bQW;
    private FragmentTabWidget cna;
    private com.baidu.tbadk.core.dialog.b hAA;
    private b hAB;
    private d hAC;
    private c hAD;
    private FrameLayout hAE;
    private b.InterfaceC0074b hAF;
    private MaskVideoView hAz;
    private h hjJ;
    private com.baidu.tieba.video.editvideo.a hzo;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.hAF = new b.InterfaceC0074b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0074b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.hzo != null) {
                            a.this.hzo.bHa();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.hzo != null) {
                            a.this.hzo.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.hzo = aVar;
        this.mRootView = view;
        this.hjJ = hVar;
        this.mResources = view.getResources();
        this.hAB = new b(this.mContext, this);
        this.hAC = new d(this.mContext, this, this.hjJ);
        this.hAD = new c(this.mContext, this);
        this.hAB.cX(this.mRootView);
        this.hAC.cX(this.mRootView);
        this.hAD.cX(this.mRootView);
        initView();
        bHM();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.hAz = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.hAz.setPreserveEGLContextOnPause(true);
        this.hAz.setZOrderMediaOverlay(true);
        this.hAz.setPostMonitorManager(this.hjJ);
        this.hAE = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.hAE.addView(this.hAB.getRootView());
        this.cna = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        auI();
        aaE();
        this.hAE.addView(this.hAC.getRootView());
        this.hAE.addView(this.hAD.getRootView());
        this.hAC.getRootView().setVisibility(8);
        this.hAD.getRootView().setVisibility(8);
    }

    private boolean bHL() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void aaE() {
        String[] stringArray = this.mResources.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0108d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(d.e.fontsize34));
            this.cna.addView(fragmentTabIndicator, i);
        }
        if (!bHL() && this.cna.getChildAt(1) != null) {
            this.cna.getChildAt(1).setVisibility(8);
        }
        this.cna.setDiverColor(this.mResources.getColor(d.C0108d.cp_cont_b));
        this.cna.a(this.mCurrentTabIndex, true, false);
        this.cna.setBackGroundDrawableResId(d.C0108d.cp_bg_line_d);
        this.cna.setDviderRectWidth(l.s(this.mContext.getPageActivity(), d.e.ds64));
        this.cna.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void p(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.hAB.getRootView().setVisibility(0);
                            a.this.hAC.getRootView().setVisibility(8);
                            a.this.hAD.getRootView().setVisibility(8);
                            a.this.hAB.nZ(true);
                            a.this.hAC.nZ(false);
                            a.this.hAD.nZ(false);
                            break;
                        case 1:
                            a.this.hAD.getRootView().setVisibility(0);
                            a.this.hAC.getRootView().setVisibility(8);
                            a.this.hAB.getRootView().setVisibility(8);
                            a.this.hAB.nZ(false);
                            if (TextUtils.isEmpty(a.this.hAC.bHT())) {
                                a.this.hAC.nZ(false);
                            } else {
                                a.this.hAC.nZ(true);
                            }
                            a.this.hAD.nZ(true);
                            break;
                        case 2:
                            a.this.hAC.getRootView().setVisibility(0);
                            a.this.hAB.getRootView().setVisibility(8);
                            a.this.hAD.getRootView().setVisibility(8);
                            a.this.hAB.nZ(false);
                            a.this.hAC.nZ(true);
                            a.this.hAD.nZ(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.cna.a(a.this.mCurrentTabIndex, true, true);
                    a.this.bHM();
                    a.this.bHN();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHM() {
        ak akVar = new ak("c12424");
        akVar.s("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHN() {
        if (this.mCurrentTabIndex == 0) {
            bHR();
            bHP();
            return;
        }
        replay();
    }

    public void replay() {
        bHR();
        this.hAz.start();
        this.hAz.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bQW != null) {
            this.mIsMute = z;
            if (z) {
                this.bQW.setVolume(0.0f, 0.0f);
            } else {
                this.bQW.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bHR();
        this.hAB.onPause();
        this.hAC.onPause();
        this.hAD.onPause();
    }

    public void onResume() {
        this.hAz.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.hAz.bHX();
        }
        this.hAB.onResume();
        this.hAC.onResume();
        this.hAD.onResume();
    }

    public MaskVideoView bHO() {
        return this.hAz;
    }

    public Bitmap m(Bitmap bitmap) {
        return this.hAB.m(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.hAC.setMusicData(list);
    }

    public void dT(List<PendantData> list) {
        this.hAB.dT(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.hAD != null) {
            this.hAD.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hAB.setData(str);
                this.hAz.setVideoPath(str);
                this.hAz.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bQW = mediaPlayer;
                        if (a.this.mIsMute) {
                            a.this.bQW.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bQW.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.hAB.bIa();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.hAz.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.hAz.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.hAz.seekTo(a.this.hAB.getCurrentPosition());
                    }
                });
                this.hAz.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.hAC.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bHP() {
        if (this.hAz != null) {
            this.hAz.seekTo(this.hAB.getCurrentPosition());
        }
    }

    public void bHQ() {
        if (this.hAz != null) {
            this.hAz.yk(this.hAB.getCurrentPosition());
        }
    }

    public void bHR() {
        if (this.hAz != null) {
            this.hAz.bHW();
        }
    }

    public void bHS() {
        if (this.hAz != null) {
            this.hAz.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.cna.onChangeSkinType(i);
        this.cna.setDiverColor(i == 1 ? this.mResources.getColor(d.C0108d.cp_cont_b_1) : this.mResources.getColor(d.C0108d.cp_cont_b));
        aj.t(this.mRootView, d.C0108d.cp_bg_line_d);
        if (this.hAB != null) {
            this.hAB.onChangeSkinType(eVar, i);
        }
        if (this.hAC != null) {
            this.hAC.onChangeSkinType(eVar, i);
        }
    }

    private void auI() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(d.j.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        aj.r(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(d.j.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hAB.bsc();
                if (a.this.hzo != null) {
                    a.this.hzo.bGX();
                }
            }
        }), d.C0108d.cp_cont_f);
    }

    public String getText() {
        return this.hAB.getText();
    }

    public int getCurrentPosition() {
        if (this.hAz == null) {
            return 0;
        }
        return this.hAz.getCurrentPosition();
    }

    public void showDialog() {
        if (this.hAA == null) {
            String[] strArr = {getPageContext().getString(d.j.save), getPageContext().getString(d.j.not_save), getPageContext().getString(d.j.cancel)};
            this.hAA = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hAA.fh(b.a.aQl);
            this.hAA.fj(17);
            this.hAA.da(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title));
            this.hAA.a(strArr, this.hAF);
            this.hAA.d(getPageContext());
            TextView titleView = this.hAA.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(d.e.fontsize24));
                aj.r(titleView, d.C0108d.cp_cont_d);
            }
        }
        this.hAA.AL();
    }

    public void cp(String str, String str2) {
        this.hAC.cp(str, str2);
    }

    public void bHc() {
        if (this.hzo != null) {
            this.hzo.bHc();
        }
    }

    public String bHT() {
        return this.hAC.bHT();
    }

    public String bHU() {
        return this.hAC.bHU();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bHV() {
        return this.hAC.bHV();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.hAB != null) {
            this.hAB.release();
        }
        if (this.hAz != null) {
            this.hAz.stopPlayback();
        }
    }

    public void ae(Intent intent) {
        this.hAC.ae(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bHO() != null) {
            bHO().setGenMaskCoverListener(bVar);
        }
    }
}
