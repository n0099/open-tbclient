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
import com.baidu.tieba.f;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c {
    private MediaPlayer aXW;
    private FragmentTabWidget bTL;
    private h gPa;
    private com.baidu.tieba.video.editvideo.a hep;
    private MaskVideoView hfA;
    private com.baidu.tbadk.core.dialog.b hfB;
    private b hfC;
    private d hfD;
    private c hfE;
    private FrameLayout hfF;
    private b.InterfaceC0101b hfG;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.hfG = new b.InterfaceC0101b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.hep != null) {
                            a.this.hep.bAK();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.hep != null) {
                            a.this.hep.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.hep = aVar;
        this.mRootView = view;
        this.gPa = hVar;
        this.mResources = view.getResources();
        this.hfC = new b(this.mContext, this);
        this.hfD = new d(this.mContext, this, this.gPa);
        this.hfE = new c(this.mContext, this);
        this.hfC.bF(this.mRootView);
        this.hfD.bF(this.mRootView);
        this.hfE.bF(this.mRootView);
        initView();
        bBv();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(f.g.navigation_bar);
        this.hfA = (MaskVideoView) this.mRootView.findViewById(f.g.video_view);
        this.hfA.setPreserveEGLContextOnPause(true);
        this.hfA.setZOrderMediaOverlay(true);
        this.hfA.setPostMonitorManager(this.gPa);
        this.hfF = (FrameLayout) this.mRootView.findViewById(f.g.edit_container);
        this.hfF.addView(this.hfC.getRootView());
        this.bTL = (FragmentTabWidget) this.mRootView.findViewById(f.g.tab_widget);
        asl();
        aab();
        this.hfF.addView(this.hfD.getRootView());
        this.hfF.addView(this.hfE.getRootView());
        this.hfD.getRootView().setVisibility(8);
        this.hfE.getRootView().setVisibility(8);
    }

    private boolean bBu() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void aab() {
        String[] stringArray = this.mResources.getStringArray(f.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(f.d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(f.e.fontsize34));
            this.bTL.addView(fragmentTabIndicator, i);
        }
        if (!bBu() && this.bTL.getChildAt(1) != null) {
            this.bTL.getChildAt(1).setVisibility(8);
        }
        this.bTL.setDiverColor(this.mResources.getColor(f.d.cp_cont_b));
        this.bTL.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.bTL.setBackGroundDrawableResId(f.d.cp_bg_line_d);
        this.bTL.setDviderRectWidth(l.f(this.mContext.getPageActivity(), f.e.ds64));
        this.bTL.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.hfC.getRootView().setVisibility(0);
                            a.this.hfD.getRootView().setVisibility(8);
                            a.this.hfE.getRootView().setVisibility(8);
                            a.this.hfC.mT(true);
                            a.this.hfD.mT(false);
                            a.this.hfE.mT(false);
                            break;
                        case 1:
                            a.this.hfE.getRootView().setVisibility(0);
                            a.this.hfD.getRootView().setVisibility(8);
                            a.this.hfC.getRootView().setVisibility(8);
                            a.this.hfC.mT(false);
                            if (TextUtils.isEmpty(a.this.hfD.bBC())) {
                                a.this.hfD.mT(false);
                            } else {
                                a.this.hfD.mT(true);
                            }
                            a.this.hfE.mT(true);
                            break;
                        case 2:
                            a.this.hfD.getRootView().setVisibility(0);
                            a.this.hfC.getRootView().setVisibility(8);
                            a.this.hfE.getRootView().setVisibility(8);
                            a.this.hfC.mT(false);
                            a.this.hfD.mT(true);
                            a.this.hfE.mT(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.bTL.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.bBv();
                    a.this.bBw();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBv() {
        an anVar = new an("c12424");
        anVar.r("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBw() {
        if (this.mCurrentTabIndex == 0) {
            bBA();
            bBy();
            return;
        }
        replay();
    }

    public void replay() {
        bBA();
        this.hfA.start();
        this.hfA.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.aXW != null) {
            this.mIsMute = z;
            if (z) {
                this.aXW.setVolume(0.0f, 0.0f);
            } else {
                this.aXW.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bBA();
        this.hfC.onPause();
        this.hfD.onPause();
        this.hfE.onPause();
    }

    public void onResume() {
        this.hfA.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.hfA.bBG();
        }
        this.hfC.onResume();
        this.hfD.onResume();
        this.hfE.onResume();
    }

    public MaskVideoView bBx() {
        return this.hfA;
    }

    public Bitmap r(Bitmap bitmap) {
        return this.hfC.r(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.hfD.setMusicData(list);
    }

    public void dG(List<PendantData> list) {
        this.hfC.dG(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.hfE != null) {
            this.hfE.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hfC.setData(str);
                this.hfA.setVideoPath(str);
                this.hfA.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.aXW = mediaPlayer;
                        if (a.this.mIsMute) {
                            a.this.aXW.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.aXW.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.hfC.bBJ();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.hfA.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.hfA.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.hfA.seekTo(a.this.hfC.getCurrentPosition());
                    }
                });
                this.hfA.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.hfD.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bBy() {
        if (this.hfA != null) {
            this.hfA.seekTo(this.hfC.getCurrentPosition());
        }
    }

    public void bBz() {
        if (this.hfA != null) {
            this.hfA.uH(this.hfC.getCurrentPosition());
        }
    }

    public void bBA() {
        if (this.hfA != null) {
            this.hfA.bBF();
        }
    }

    public void bBB() {
        if (this.hfA != null) {
            this.hfA.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.bTL.onChangeSkinType(i);
        this.bTL.setDiverColor(i == 1 ? this.mResources.getColor(f.d.cp_cont_b_1) : this.mResources.getColor(f.d.cp_cont_b));
        am.j(this.mRootView, f.d.cp_bg_line_d);
        if (this.hfC != null) {
            this.hfC.onChangeSkinType(eVar, i);
        }
        if (this.hfD != null) {
            this.hfD.onChangeSkinType(eVar, i);
        }
    }

    private void asl() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(f.j.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        am.h(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(f.j.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hfC.blH();
                if (a.this.hep != null) {
                    a.this.hep.bAH();
                }
            }
        }), f.d.cp_cont_f);
    }

    public String getText() {
        return this.hfC.getText();
    }

    public int getCurrentPosition() {
        if (this.hfA == null) {
            return 0;
        }
        return this.hfA.getCurrentPosition();
    }

    public void showDialog() {
        if (this.hfB == null) {
            String[] strArr = {getPageContext().getString(f.j.save), getPageContext().getString(f.j.not_save), getPageContext().getString(f.j.cancel)};
            this.hfB = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hfB.cj(b.a.alb);
            this.hfB.cl(17);
            this.hfB.dC(TbadkCoreApplication.getInst().getResources().getString(f.j.save_video_title));
            this.hfB.a(strArr, this.hfG);
            this.hfB.d(getPageContext());
            TextView titleView = this.hfB.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(f.e.fontsize24));
                am.h(titleView, f.d.cp_cont_d);
            }
        }
        this.hfB.xh();
    }

    public void cs(String str, String str2) {
        this.hfD.cs(str, str2);
    }

    public void bAM() {
        if (this.hep != null) {
            this.hep.bAM();
        }
    }

    public String bBC() {
        return this.hfD.bBC();
    }

    public String bBD() {
        return this.hfD.bBD();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bBE() {
        return this.hfD.bBE();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.hfC != null) {
            this.hfC.release();
        }
        if (this.hfA != null) {
            this.hfA.stopPlayback();
        }
    }

    public void aa(Intent intent) {
        this.hfD.aa(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bBx() != null) {
            bBx().setGenMaskCoverListener(bVar);
        }
    }
}
