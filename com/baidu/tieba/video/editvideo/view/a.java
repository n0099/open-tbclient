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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.e;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends com.baidu.adp.base.c {
    private MediaPlayer Wm;
    private FragmentTabWidget cna;
    private com.baidu.tieba.video.editvideo.a hGL;
    private MaskVideoView hHU;
    private com.baidu.tbadk.core.dialog.b hHV;
    private b hHW;
    private d hHX;
    private c hHY;
    private FrameLayout hHZ;
    private b.InterfaceC0158b hIa;
    private h hqM;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.hIa = new b.InterfaceC0158b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.hGL != null) {
                            a.this.hGL.bJP();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.hGL != null) {
                            a.this.hGL.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.hGL = aVar;
        this.mRootView = view;
        this.hqM = hVar;
        this.mResources = view.getResources();
        this.hHW = new b(this.mContext, this);
        this.hHX = new d(this.mContext, this, this.hqM);
        this.hHY = new c(this.mContext, this);
        this.hHW.bX(this.mRootView);
        this.hHX.bX(this.mRootView);
        this.hHY.bX(this.mRootView);
        initView();
        bKA();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.hHU = (MaskVideoView) this.mRootView.findViewById(e.g.video_view);
        this.hHU.setPreserveEGLContextOnPause(true);
        this.hHU.setZOrderMediaOverlay(true);
        this.hHU.setPostMonitorManager(this.hqM);
        this.hHZ = (FrameLayout) this.mRootView.findViewById(e.g.edit_container);
        this.hHZ.addView(this.hHW.getRootView());
        this.cna = (FragmentTabWidget) this.mRootView.findViewById(e.g.tab_widget);
        azR();
        agI();
        this.hHZ.addView(this.hHX.getRootView());
        this.hHZ.addView(this.hHY.getRootView());
        this.hHX.getRootView().setVisibility(8);
        this.hHY.getRootView().setVisibility(8);
    }

    private boolean bKz() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void agI() {
        String[] stringArray = this.mResources.getStringArray(e.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(e.d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(e.C0210e.fontsize34));
            this.cna.addView(fragmentTabIndicator, i);
        }
        if (!bKz() && this.cna.getChildAt(1) != null) {
            this.cna.getChildAt(1).setVisibility(8);
        }
        this.cna.setDiverColor(this.mResources.getColor(e.d.cp_cont_b));
        this.cna.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.cna.setBackGroundDrawableResId(e.d.cp_bg_line_d);
        this.cna.setDviderRectWidth(l.h(this.mContext.getPageActivity(), e.C0210e.ds64));
        this.cna.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.hHW.getRootView().setVisibility(0);
                            a.this.hHX.getRootView().setVisibility(8);
                            a.this.hHY.getRootView().setVisibility(8);
                            a.this.hHW.ob(true);
                            a.this.hHX.ob(false);
                            a.this.hHY.ob(false);
                            break;
                        case 1:
                            a.this.hHY.getRootView().setVisibility(0);
                            a.this.hHX.getRootView().setVisibility(8);
                            a.this.hHW.getRootView().setVisibility(8);
                            a.this.hHW.ob(false);
                            if (TextUtils.isEmpty(a.this.hHX.bKH())) {
                                a.this.hHX.ob(false);
                            } else {
                                a.this.hHX.ob(true);
                            }
                            a.this.hHY.ob(true);
                            break;
                        case 2:
                            a.this.hHX.getRootView().setVisibility(0);
                            a.this.hHW.getRootView().setVisibility(8);
                            a.this.hHY.getRootView().setVisibility(8);
                            a.this.hHW.ob(false);
                            a.this.hHX.ob(true);
                            a.this.hHY.ob(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.cna.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.bKA();
                    a.this.bKB();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKA() {
        am amVar = new am("c12424");
        amVar.y("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKB() {
        if (this.mCurrentTabIndex == 0) {
            bKF();
            bKD();
            return;
        }
        replay();
    }

    public void replay() {
        bKF();
        this.hHU.start();
        this.hHU.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.Wm != null) {
            this.mIsMute = z;
            if (z) {
                this.Wm.setVolume(0.0f, 0.0f);
            } else {
                this.Wm.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bKF();
        this.hHW.onPause();
        this.hHX.onPause();
        this.hHY.onPause();
    }

    public void onResume() {
        this.hHU.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.hHU.resumeMedia();
        }
        this.hHW.onResume();
        this.hHX.onResume();
        this.hHY.onResume();
    }

    public MaskVideoView bKC() {
        return this.hHU;
    }

    public Bitmap s(Bitmap bitmap) {
        return this.hHW.s(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.hHX.setMusicData(list);
    }

    public void dZ(List<PendantData> list) {
        this.hHW.dZ(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.hHY != null) {
            this.hHY.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hHW.setData(str);
                this.hHU.setVideoPath(str);
                this.hHU.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.Wm = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.Wm.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.Wm.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.hHW.bKN();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.hHU.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.hHU.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.hHU.seekTo(a.this.hHW.getCurrentPosition());
                    }
                });
                this.hHU.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.hHX.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bKD() {
        if (this.hHU != null) {
            this.hHU.seekTo(this.hHW.getCurrentPosition());
        }
    }

    public void bKE() {
        if (this.hHU != null) {
            this.hHU.wK(this.hHW.getCurrentPosition());
        }
    }

    public void bKF() {
        if (this.hHU != null) {
            this.hHU.bKK();
        }
    }

    public void bKG() {
        if (this.hHU != null) {
            this.hHU.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.cna.onChangeSkinType(i);
        this.cna.setDiverColor(i == 1 ? this.mResources.getColor(e.d.cp_cont_b_1) : this.mResources.getColor(e.d.cp_cont_b));
        al.j(this.mRootView, e.d.cp_bg_line_d);
        if (this.hHW != null) {
            this.hHW.onChangeSkinType(eVar, i);
        }
        if (this.hHX != null) {
            this.hHX.onChangeSkinType(eVar, i);
        }
    }

    private void azR() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(e.j.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        al.h(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(e.j.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hHW.bul();
                if (a.this.hGL != null) {
                    a.this.hGL.bJM();
                }
            }
        }), e.d.cp_cont_f);
    }

    public String getText() {
        return this.hHW.getText();
    }

    public int getCurrentPosition() {
        if (this.hHU == null) {
            return 0;
        }
        return this.hHU.getCurrentPosition();
    }

    public void showDialog() {
        if (this.hHV == null) {
            String[] strArr = {getPageContext().getString(e.j.save), getPageContext().getString(e.j.not_save), getPageContext().getString(e.j.cancel)};
            this.hHV = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hHV.df(b.a.axs);
            this.hHV.dh(17);
            this.hHV.eL(TbadkCoreApplication.getInst().getResources().getString(e.j.save_video_title));
            this.hHV.a(strArr, this.hIa);
            this.hHV.d(getPageContext());
            TextView titleView = this.hHV.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(e.C0210e.fontsize24));
                al.h(titleView, e.d.cp_cont_d);
            }
        }
        this.hHV.BV();
    }

    public void cU(String str, String str2) {
        this.hHX.cU(str, str2);
    }

    public void bJR() {
        if (this.hGL != null) {
            this.hGL.bJR();
        }
    }

    public String bKH() {
        return this.hHX.bKH();
    }

    public String bKI() {
        return this.hHX.bKI();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bKJ() {
        return this.hHX.bKJ();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.hHW != null) {
            this.hHW.release();
        }
        if (this.hHU != null) {
            this.hHU.stopPlayback();
        }
    }

    public void ae(Intent intent) {
        this.hHX.ae(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bKC() != null) {
            bKC().setGenMaskCoverListener(bVar);
        }
    }
}
