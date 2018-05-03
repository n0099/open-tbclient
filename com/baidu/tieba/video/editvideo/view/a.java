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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
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
    private MediaPlayer aOY;
    private FragmentTabWidget bHs;
    private com.baidu.tieba.video.editvideo.a gMs;
    private MaskVideoView gNB;
    private com.baidu.tbadk.core.dialog.b gNC;
    private b gND;
    private d gNE;
    private c gNF;
    private FrameLayout gNG;
    private b.InterfaceC0086b gNH;
    private h gxt;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view2, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.gNH = new b.InterfaceC0086b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view3) {
                switch (i) {
                    case 0:
                        if (a.this.gMs != null) {
                            a.this.gMs.bws();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.gMs != null) {
                            a.this.gMs.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.gMs = aVar;
        this.mRootView = view2;
        this.gxt = hVar;
        this.mResources = view2.getResources();
        this.gND = new b(this.mContext, this);
        this.gNE = new d(this.mContext, this, this.gxt);
        this.gNF = new c(this.mContext, this);
        this.gND.by(this.mRootView);
        this.gNE.by(this.mRootView);
        this.gNF.by(this.mRootView);
        initView();
        bxd();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.gNB = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.gNB.setPreserveEGLContextOnPause(true);
        this.gNB.setZOrderMediaOverlay(true);
        this.gNB.setPostMonitorManager(this.gxt);
        this.gNG = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.gNG.addView(this.gND.getRootView());
        this.bHs = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        are();
        VI();
        this.gNG.addView(this.gNE.getRootView());
        this.gNG.addView(this.gNF.getRootView());
        this.gNE.getRootView().setVisibility(8);
        this.gNF.getRootView().setVisibility(8);
    }

    private boolean bxc() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void VI() {
        String[] stringArray = this.mResources.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0126d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(d.e.fontsize34));
            this.bHs.addView(fragmentTabIndicator, i);
        }
        if (!bxc() && this.bHs.getChildAt(1) != null) {
            this.bHs.getChildAt(1).setVisibility(8);
        }
        this.bHs.setDiverColor(this.mResources.getColor(d.C0126d.cp_cont_b));
        this.bHs.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.bHs.setBackGroundDrawableResId(d.C0126d.cp_bg_line_d);
        this.bHs.setDviderRectWidth(l.e(this.mContext.getPageActivity(), d.e.ds64));
        this.bHs.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void i(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.gND.getRootView().setVisibility(0);
                            a.this.gNE.getRootView().setVisibility(8);
                            a.this.gNF.getRootView().setVisibility(8);
                            a.this.gND.mS(true);
                            a.this.gNE.mS(false);
                            a.this.gNF.mS(false);
                            break;
                        case 1:
                            a.this.gNF.getRootView().setVisibility(0);
                            a.this.gNE.getRootView().setVisibility(8);
                            a.this.gND.getRootView().setVisibility(8);
                            a.this.gND.mS(false);
                            if (TextUtils.isEmpty(a.this.gNE.bxk())) {
                                a.this.gNE.mS(false);
                            } else {
                                a.this.gNE.mS(true);
                            }
                            a.this.gNF.mS(true);
                            break;
                        case 2:
                            a.this.gNE.getRootView().setVisibility(0);
                            a.this.gND.getRootView().setVisibility(8);
                            a.this.gNF.getRootView().setVisibility(8);
                            a.this.gND.mS(false);
                            a.this.gNE.mS(true);
                            a.this.gNF.mS(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.bHs.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.bxd();
                    a.this.bxe();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxd() {
        al alVar = new al("c12424");
        alVar.r("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(alVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxe() {
        if (this.mCurrentTabIndex == 0) {
            bxi();
            bxg();
            return;
        }
        replay();
    }

    public void replay() {
        bxi();
        this.gNB.start();
        this.gNB.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.aOY != null) {
            this.mIsMute = z;
            if (z) {
                this.aOY.setVolume(0.0f, 0.0f);
            } else {
                this.aOY.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bxi();
        this.gND.onPause();
        this.gNE.onPause();
        this.gNF.onPause();
    }

    public void onResume() {
        this.gNB.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.gNB.bxo();
        }
        this.gND.onResume();
        this.gNE.onResume();
        this.gNF.onResume();
    }

    public MaskVideoView bxf() {
        return this.gNB;
    }

    public Bitmap t(Bitmap bitmap) {
        return this.gND.t(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.gNE.setMusicData(list);
    }

    public void dz(List<PendantData> list) {
        this.gND.dz(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.gNF != null) {
            this.gNF.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.gND.setData(str);
                this.gNB.setVideoPath(str);
                this.gNB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.aOY = mediaPlayer;
                        if (a.this.mIsMute) {
                            a.this.aOY.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.aOY.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.gND.bxr();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.gNB.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.gNB.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.gNB.seekTo(a.this.gND.getCurrentPosition());
                    }
                });
                this.gNB.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.gNE.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bxg() {
        if (this.gNB != null) {
            this.gNB.seekTo(this.gND.getCurrentPosition());
        }
    }

    public void bxh() {
        if (this.gNB != null) {
            this.gNB.uo(this.gND.getCurrentPosition());
        }
    }

    public void bxi() {
        if (this.gNB != null) {
            this.gNB.bxn();
        }
    }

    public void bxj() {
        if (this.gNB != null) {
            this.gNB.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.bHs.onChangeSkinType(i);
        this.bHs.setDiverColor(i == 1 ? this.mResources.getColor(d.C0126d.cp_cont_b_1) : this.mResources.getColor(d.C0126d.cp_cont_b));
        ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
        if (this.gND != null) {
            this.gND.onChangeSkinType(eVar, i);
        }
        if (this.gNE != null) {
            this.gNE.onChangeSkinType(eVar, i);
        }
    }

    private void are() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(d.k.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.showDialog();
            }
        });
        ak.h(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(d.k.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.gND.bhP();
                if (a.this.gMs != null) {
                    a.this.gMs.bwp();
                }
            }
        }), d.C0126d.cp_cont_f);
    }

    public String getText() {
        return this.gND.getText();
    }

    public int getCurrentPosition() {
        if (this.gNB == null) {
            return 0;
        }
        return this.gNB.getCurrentPosition();
    }

    public void showDialog() {
        if (this.gNC == null) {
            String[] strArr = {getPageContext().getString(d.k.save), getPageContext().getString(d.k.not_save), getPageContext().getString(d.k.cancel)};
            this.gNC = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.gNC.cd(b.a.acX);
            this.gNC.cf(17);
            this.gNC.dd(TbadkCoreApplication.getInst().getResources().getString(d.k.save_video_title));
            this.gNC.a(strArr, this.gNH);
            this.gNC.d(getPageContext());
            TextView titleView = this.gNC.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(d.e.fontsize24));
                ak.h(titleView, d.C0126d.cp_cont_d);
            }
        }
        this.gNC.tG();
    }

    public void cj(String str, String str2) {
        this.gNE.cj(str, str2);
    }

    public void bwu() {
        if (this.gMs != null) {
            this.gMs.bwu();
        }
    }

    public String bxk() {
        return this.gNE.bxk();
    }

    public String bxl() {
        return this.gNE.bxl();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bxm() {
        return this.gNE.bxm();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.gND != null) {
            this.gND.release();
        }
        if (this.gNB != null) {
            this.gNB.stopPlayback();
        }
    }

    public void aa(Intent intent) {
        this.gNE.aa(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bxf() != null) {
            bxf().setGenMaskCoverListener(bVar);
        }
    }
}
