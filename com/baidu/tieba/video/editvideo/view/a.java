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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c {
    private MediaPlayer aXQ;
    private FragmentTabWidget bSR;
    private h gOa;
    private com.baidu.tieba.video.editvideo.a hdc;
    private MaskVideoView hel;
    private com.baidu.tbadk.core.dialog.b hem;
    private b hen;
    private d heo;
    private c hep;
    private FrameLayout heq;
    private b.InterfaceC0104b her;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.her = new b.InterfaceC0104b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.hdc != null) {
                            a.this.hdc.bBX();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.hdc != null) {
                            a.this.hdc.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.hdc = aVar;
        this.mRootView = view;
        this.gOa = hVar;
        this.mResources = view.getResources();
        this.hen = new b(this.mContext, this);
        this.heo = new d(this.mContext, this, this.gOa);
        this.hep = new c(this.mContext, this);
        this.hen.bC(this.mRootView);
        this.heo.bC(this.mRootView);
        this.hep.bC(this.mRootView);
        initView();
        bCI();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.hel = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.hel.setPreserveEGLContextOnPause(true);
        this.hel.setZOrderMediaOverlay(true);
        this.hel.setPostMonitorManager(this.gOa);
        this.heq = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.heq.addView(this.hen.getRootView());
        this.bSR = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        arI();
        ZP();
        this.heq.addView(this.heo.getRootView());
        this.heq.addView(this.hep.getRootView());
        this.heo.getRootView().setVisibility(8);
        this.hep.getRootView().setVisibility(8);
    }

    private boolean bCH() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void ZP() {
        String[] stringArray = this.mResources.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0142d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(d.e.fontsize34));
            this.bSR.addView(fragmentTabIndicator, i);
        }
        if (!bCH() && this.bSR.getChildAt(1) != null) {
            this.bSR.getChildAt(1).setVisibility(8);
        }
        this.bSR.setDiverColor(this.mResources.getColor(d.C0142d.cp_cont_b));
        this.bSR.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.bSR.setBackGroundDrawableResId(d.C0142d.cp_bg_line_d);
        this.bSR.setDviderRectWidth(l.e(this.mContext.getPageActivity(), d.e.ds64));
        this.bSR.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.hen.getRootView().setVisibility(0);
                            a.this.heo.getRootView().setVisibility(8);
                            a.this.hep.getRootView().setVisibility(8);
                            a.this.hen.nh(true);
                            a.this.heo.nh(false);
                            a.this.hep.nh(false);
                            break;
                        case 1:
                            a.this.hep.getRootView().setVisibility(0);
                            a.this.heo.getRootView().setVisibility(8);
                            a.this.hen.getRootView().setVisibility(8);
                            a.this.hen.nh(false);
                            if (TextUtils.isEmpty(a.this.heo.bCP())) {
                                a.this.heo.nh(false);
                            } else {
                                a.this.heo.nh(true);
                            }
                            a.this.hep.nh(true);
                            break;
                        case 2:
                            a.this.heo.getRootView().setVisibility(0);
                            a.this.hen.getRootView().setVisibility(8);
                            a.this.hep.getRootView().setVisibility(8);
                            a.this.hen.nh(false);
                            a.this.heo.nh(true);
                            a.this.hep.nh(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.bSR.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.bCI();
                    a.this.bCJ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCI() {
        an anVar = new an("c12424");
        anVar.r("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCJ() {
        if (this.mCurrentTabIndex == 0) {
            bCN();
            bCL();
            return;
        }
        replay();
    }

    public void replay() {
        bCN();
        this.hel.start();
        this.hel.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.aXQ != null) {
            this.mIsMute = z;
            if (z) {
                this.aXQ.setVolume(0.0f, 0.0f);
            } else {
                this.aXQ.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bCN();
        this.hen.onPause();
        this.heo.onPause();
        this.hep.onPause();
    }

    public void onResume() {
        this.hel.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.hel.bCT();
        }
        this.hen.onResume();
        this.heo.onResume();
        this.hep.onResume();
    }

    public MaskVideoView bCK() {
        return this.hel;
    }

    public Bitmap s(Bitmap bitmap) {
        return this.hen.s(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.heo.setMusicData(list);
    }

    public void dK(List<PendantData> list) {
        this.hen.dK(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.hep != null) {
            this.hep.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hen.setData(str);
                this.hel.setVideoPath(str);
                this.hel.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.aXQ = mediaPlayer;
                        if (a.this.mIsMute) {
                            a.this.aXQ.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.aXQ.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.hen.bCW();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.hel.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.hel.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.hel.seekTo(a.this.hen.getCurrentPosition());
                    }
                });
                this.hel.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.heo.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bCL() {
        if (this.hel != null) {
            this.hel.seekTo(this.hen.getCurrentPosition());
        }
    }

    public void bCM() {
        if (this.hel != null) {
            this.hel.uI(this.hen.getCurrentPosition());
        }
    }

    public void bCN() {
        if (this.hel != null) {
            this.hel.bCS();
        }
    }

    public void bCO() {
        if (this.hel != null) {
            this.hel.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.bSR.onChangeSkinType(i);
        this.bSR.setDiverColor(i == 1 ? this.mResources.getColor(d.C0142d.cp_cont_b_1) : this.mResources.getColor(d.C0142d.cp_cont_b));
        am.j(this.mRootView, d.C0142d.cp_bg_line_d);
        if (this.hen != null) {
            this.hen.onChangeSkinType(eVar, i);
        }
        if (this.heo != null) {
            this.heo.onChangeSkinType(eVar, i);
        }
    }

    private void arI() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(d.k.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        am.h(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(d.k.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hen.bnr();
                if (a.this.hdc != null) {
                    a.this.hdc.bBU();
                }
            }
        }), d.C0142d.cp_cont_f);
    }

    public String getText() {
        return this.hen.getText();
    }

    public int getCurrentPosition() {
        if (this.hel == null) {
            return 0;
        }
        return this.hel.getCurrentPosition();
    }

    public void showDialog() {
        if (this.hem == null) {
            String[] strArr = {getPageContext().getString(d.k.save), getPageContext().getString(d.k.not_save), getPageContext().getString(d.k.cancel)};
            this.hem = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hem.ch(b.a.alC);
            this.hem.cj(17);
            this.hem.dF(TbadkCoreApplication.getInst().getResources().getString(d.k.save_video_title));
            this.hem.a(strArr, this.her);
            this.hem.d(getPageContext());
            TextView titleView = this.hem.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(d.e.fontsize24));
                am.h(titleView, d.C0142d.cp_cont_d);
            }
        }
        this.hem.xq();
    }

    public void cv(String str, String str2) {
        this.heo.cv(str, str2);
    }

    public void bBZ() {
        if (this.hdc != null) {
            this.hdc.bBZ();
        }
    }

    public String bCP() {
        return this.heo.bCP();
    }

    public String bCQ() {
        return this.heo.bCQ();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bCR() {
        return this.heo.bCR();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.hen != null) {
            this.hen.release();
        }
        if (this.hel != null) {
            this.hel.stopPlayback();
        }
    }

    public void aa(Intent intent) {
        this.heo.aa(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bCK() != null) {
            bCK().setGenMaskCoverListener(bVar);
        }
    }
}
