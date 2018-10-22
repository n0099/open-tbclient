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
    private MediaPlayer Wb;
    private FragmentTabWidget cia;
    private h heb;
    private com.baidu.tieba.video.editvideo.a htx;
    private MaskVideoView huG;
    private com.baidu.tbadk.core.dialog.b huH;
    private b huI;
    private d huJ;
    private c huK;
    private FrameLayout huL;
    private b.InterfaceC0124b huM;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.huM = new b.InterfaceC0124b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.htx != null) {
                            a.this.htx.bGN();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.htx != null) {
                            a.this.htx.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.htx = aVar;
        this.mRootView = view;
        this.heb = hVar;
        this.mResources = view.getResources();
        this.huI = new b(this.mContext, this);
        this.huJ = new d(this.mContext, this, this.heb);
        this.huK = new c(this.mContext, this);
        this.huI.bS(this.mRootView);
        this.huJ.bS(this.mRootView);
        this.huK.bS(this.mRootView);
        initView();
        bHy();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.huG = (MaskVideoView) this.mRootView.findViewById(e.g.video_view);
        this.huG.setPreserveEGLContextOnPause(true);
        this.huG.setZOrderMediaOverlay(true);
        this.huG.setPostMonitorManager(this.heb);
        this.huL = (FrameLayout) this.mRootView.findViewById(e.g.edit_container);
        this.huL.addView(this.huI.getRootView());
        this.cia = (FragmentTabWidget) this.mRootView.findViewById(e.g.tab_widget);
        axw();
        afv();
        this.huL.addView(this.huJ.getRootView());
        this.huL.addView(this.huK.getRootView());
        this.huJ.getRootView().setVisibility(8);
        this.huK.getRootView().setVisibility(8);
    }

    private boolean bHx() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void afv() {
        String[] stringArray = this.mResources.getStringArray(e.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(e.d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(e.C0175e.fontsize34));
            this.cia.addView(fragmentTabIndicator, i);
        }
        if (!bHx() && this.cia.getChildAt(1) != null) {
            this.cia.getChildAt(1).setVisibility(8);
        }
        this.cia.setDiverColor(this.mResources.getColor(e.d.cp_cont_b));
        this.cia.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.cia.setBackGroundDrawableResId(e.d.cp_bg_line_d);
        this.cia.setDviderRectWidth(l.h(this.mContext.getPageActivity(), e.C0175e.ds64));
        this.cia.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.huI.getRootView().setVisibility(0);
                            a.this.huJ.getRootView().setVisibility(8);
                            a.this.huK.getRootView().setVisibility(8);
                            a.this.huI.nH(true);
                            a.this.huJ.nH(false);
                            a.this.huK.nH(false);
                            break;
                        case 1:
                            a.this.huK.getRootView().setVisibility(0);
                            a.this.huJ.getRootView().setVisibility(8);
                            a.this.huI.getRootView().setVisibility(8);
                            a.this.huI.nH(false);
                            if (TextUtils.isEmpty(a.this.huJ.bHF())) {
                                a.this.huJ.nH(false);
                            } else {
                                a.this.huJ.nH(true);
                            }
                            a.this.huK.nH(true);
                            break;
                        case 2:
                            a.this.huJ.getRootView().setVisibility(0);
                            a.this.huI.getRootView().setVisibility(8);
                            a.this.huK.getRootView().setVisibility(8);
                            a.this.huI.nH(false);
                            a.this.huJ.nH(true);
                            a.this.huK.nH(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.cia.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.bHy();
                    a.this.bHz();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHy() {
        am amVar = new am("c12424");
        amVar.x("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHz() {
        if (this.mCurrentTabIndex == 0) {
            bHD();
            bHB();
            return;
        }
        replay();
    }

    public void replay() {
        bHD();
        this.huG.start();
        this.huG.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.Wb != null) {
            this.mIsMute = z;
            if (z) {
                this.Wb.setVolume(0.0f, 0.0f);
            } else {
                this.Wb.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bHD();
        this.huI.onPause();
        this.huJ.onPause();
        this.huK.onPause();
    }

    public void onResume() {
        this.huG.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.huG.resumeMedia();
        }
        this.huI.onResume();
        this.huJ.onResume();
        this.huK.onResume();
    }

    public MaskVideoView bHA() {
        return this.huG;
    }

    public Bitmap s(Bitmap bitmap) {
        return this.huI.s(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.huJ.setMusicData(list);
    }

    public void dV(List<PendantData> list) {
        this.huI.dV(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.huK != null) {
            this.huK.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.huI.setData(str);
                this.huG.setVideoPath(str);
                this.huG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.Wb = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.Wb.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.Wb.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.huI.bHL();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.huG.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.huG.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.huG.seekTo(a.this.huI.getCurrentPosition());
                    }
                });
                this.huG.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.huJ.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bHB() {
        if (this.huG != null) {
            this.huG.seekTo(this.huI.getCurrentPosition());
        }
    }

    public void bHC() {
        if (this.huG != null) {
            this.huG.vE(this.huI.getCurrentPosition());
        }
    }

    public void bHD() {
        if (this.huG != null) {
            this.huG.bHI();
        }
    }

    public void bHE() {
        if (this.huG != null) {
            this.huG.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.cia.onChangeSkinType(i);
        this.cia.setDiverColor(i == 1 ? this.mResources.getColor(e.d.cp_cont_b_1) : this.mResources.getColor(e.d.cp_cont_b));
        al.j(this.mRootView, e.d.cp_bg_line_d);
        if (this.huI != null) {
            this.huI.onChangeSkinType(eVar, i);
        }
        if (this.huJ != null) {
            this.huJ.onChangeSkinType(eVar, i);
        }
    }

    private void axw() {
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
                a.this.huI.brC();
                if (a.this.htx != null) {
                    a.this.htx.bGK();
                }
            }
        }), e.d.cp_cont_f);
    }

    public String getText() {
        return this.huI.getText();
    }

    public int getCurrentPosition() {
        if (this.huG == null) {
            return 0;
        }
        return this.huG.getCurrentPosition();
    }

    public void showDialog() {
        if (this.huH == null) {
            String[] strArr = {getPageContext().getString(e.j.save), getPageContext().getString(e.j.not_save), getPageContext().getString(e.j.cancel)};
            this.huH = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.huH.cD(b.a.asB);
            this.huH.cF(17);
            this.huH.ek(TbadkCoreApplication.getInst().getResources().getString(e.j.save_video_title));
            this.huH.a(strArr, this.huM);
            this.huH.d(getPageContext());
            TextView titleView = this.huH.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(e.C0175e.fontsize24));
                al.h(titleView, e.d.cp_cont_d);
            }
        }
        this.huH.Ax();
    }

    public void cN(String str, String str2) {
        this.huJ.cN(str, str2);
    }

    public void bGP() {
        if (this.htx != null) {
            this.htx.bGP();
        }
    }

    public String bHF() {
        return this.huJ.bHF();
    }

    public String bHG() {
        return this.huJ.bHG();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bHH() {
        return this.huJ.bHH();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.huI != null) {
            this.huI.release();
        }
        if (this.huG != null) {
            this.huG.stopPlayback();
        }
    }

    public void ae(Intent intent) {
        this.huJ.ae(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bHA() != null) {
            bHA().setGenMaskCoverListener(bVar);
        }
    }
}
