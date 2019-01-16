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
    private FragmentTabWidget cmZ;
    private com.baidu.tieba.video.editvideo.a hGK;
    private MaskVideoView hHT;
    private com.baidu.tbadk.core.dialog.b hHU;
    private b hHV;
    private d hHW;
    private c hHX;
    private FrameLayout hHY;
    private b.InterfaceC0158b hHZ;
    private h hqL;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.hHZ = new b.InterfaceC0158b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.hGK != null) {
                            a.this.hGK.bJP();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.hGK != null) {
                            a.this.hGK.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.hGK = aVar;
        this.mRootView = view;
        this.hqL = hVar;
        this.mResources = view.getResources();
        this.hHV = new b(this.mContext, this);
        this.hHW = new d(this.mContext, this, this.hqL);
        this.hHX = new c(this.mContext, this);
        this.hHV.bX(this.mRootView);
        this.hHW.bX(this.mRootView);
        this.hHX.bX(this.mRootView);
        initView();
        bKA();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.hHT = (MaskVideoView) this.mRootView.findViewById(e.g.video_view);
        this.hHT.setPreserveEGLContextOnPause(true);
        this.hHT.setZOrderMediaOverlay(true);
        this.hHT.setPostMonitorManager(this.hqL);
        this.hHY = (FrameLayout) this.mRootView.findViewById(e.g.edit_container);
        this.hHY.addView(this.hHV.getRootView());
        this.cmZ = (FragmentTabWidget) this.mRootView.findViewById(e.g.tab_widget);
        azR();
        agI();
        this.hHY.addView(this.hHW.getRootView());
        this.hHY.addView(this.hHX.getRootView());
        this.hHW.getRootView().setVisibility(8);
        this.hHX.getRootView().setVisibility(8);
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
            this.cmZ.addView(fragmentTabIndicator, i);
        }
        if (!bKz() && this.cmZ.getChildAt(1) != null) {
            this.cmZ.getChildAt(1).setVisibility(8);
        }
        this.cmZ.setDiverColor(this.mResources.getColor(e.d.cp_cont_b));
        this.cmZ.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.cmZ.setBackGroundDrawableResId(e.d.cp_bg_line_d);
        this.cmZ.setDviderRectWidth(l.h(this.mContext.getPageActivity(), e.C0210e.ds64));
        this.cmZ.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.hHV.getRootView().setVisibility(0);
                            a.this.hHW.getRootView().setVisibility(8);
                            a.this.hHX.getRootView().setVisibility(8);
                            a.this.hHV.ob(true);
                            a.this.hHW.ob(false);
                            a.this.hHX.ob(false);
                            break;
                        case 1:
                            a.this.hHX.getRootView().setVisibility(0);
                            a.this.hHW.getRootView().setVisibility(8);
                            a.this.hHV.getRootView().setVisibility(8);
                            a.this.hHV.ob(false);
                            if (TextUtils.isEmpty(a.this.hHW.bKH())) {
                                a.this.hHW.ob(false);
                            } else {
                                a.this.hHW.ob(true);
                            }
                            a.this.hHX.ob(true);
                            break;
                        case 2:
                            a.this.hHW.getRootView().setVisibility(0);
                            a.this.hHV.getRootView().setVisibility(8);
                            a.this.hHX.getRootView().setVisibility(8);
                            a.this.hHV.ob(false);
                            a.this.hHW.ob(true);
                            a.this.hHX.ob(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.cmZ.setCurrentTab(a.this.mCurrentTabIndex, true, true);
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
        this.hHT.start();
        this.hHT.seekTo(0);
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
        this.hHV.onPause();
        this.hHW.onPause();
        this.hHX.onPause();
    }

    public void onResume() {
        this.hHT.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.hHT.resumeMedia();
        }
        this.hHV.onResume();
        this.hHW.onResume();
        this.hHX.onResume();
    }

    public MaskVideoView bKC() {
        return this.hHT;
    }

    public Bitmap s(Bitmap bitmap) {
        return this.hHV.s(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.hHW.setMusicData(list);
    }

    public void dZ(List<PendantData> list) {
        this.hHV.dZ(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.hHX != null) {
            this.hHX.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hHV.setData(str);
                this.hHT.setVideoPath(str);
                this.hHT.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.hHV.bKN();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.hHT.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.hHT.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.hHT.seekTo(a.this.hHV.getCurrentPosition());
                    }
                });
                this.hHT.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.hHW.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bKD() {
        if (this.hHT != null) {
            this.hHT.seekTo(this.hHV.getCurrentPosition());
        }
    }

    public void bKE() {
        if (this.hHT != null) {
            this.hHT.wK(this.hHV.getCurrentPosition());
        }
    }

    public void bKF() {
        if (this.hHT != null) {
            this.hHT.bKK();
        }
    }

    public void bKG() {
        if (this.hHT != null) {
            this.hHT.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.cmZ.onChangeSkinType(i);
        this.cmZ.setDiverColor(i == 1 ? this.mResources.getColor(e.d.cp_cont_b_1) : this.mResources.getColor(e.d.cp_cont_b));
        al.j(this.mRootView, e.d.cp_bg_line_d);
        if (this.hHV != null) {
            this.hHV.onChangeSkinType(eVar, i);
        }
        if (this.hHW != null) {
            this.hHW.onChangeSkinType(eVar, i);
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
                a.this.hHV.bul();
                if (a.this.hGK != null) {
                    a.this.hGK.bJM();
                }
            }
        }), e.d.cp_cont_f);
    }

    public String getText() {
        return this.hHV.getText();
    }

    public int getCurrentPosition() {
        if (this.hHT == null) {
            return 0;
        }
        return this.hHT.getCurrentPosition();
    }

    public void showDialog() {
        if (this.hHU == null) {
            String[] strArr = {getPageContext().getString(e.j.save), getPageContext().getString(e.j.not_save), getPageContext().getString(e.j.cancel)};
            this.hHU = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hHU.df(b.a.axr);
            this.hHU.dh(17);
            this.hHU.eL(TbadkCoreApplication.getInst().getResources().getString(e.j.save_video_title));
            this.hHU.a(strArr, this.hHZ);
            this.hHU.d(getPageContext());
            TextView titleView = this.hHU.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(e.C0210e.fontsize24));
                al.h(titleView, e.d.cp_cont_d);
            }
        }
        this.hHU.BV();
    }

    public void cU(String str, String str2) {
        this.hHW.cU(str, str2);
    }

    public void bJR() {
        if (this.hGK != null) {
            this.hGK.bJR();
        }
    }

    public String bKH() {
        return this.hHW.bKH();
    }

    public String bKI() {
        return this.hHW.bKI();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bKJ() {
        return this.hHW.bKJ();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.hHV != null) {
            this.hHV.release();
        }
        if (this.hHT != null) {
            this.hHT.stopPlayback();
        }
    }

    public void ae(Intent intent) {
        this.hHW.ae(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bKC() != null) {
            bKC().setGenMaskCoverListener(bVar);
        }
    }
}
