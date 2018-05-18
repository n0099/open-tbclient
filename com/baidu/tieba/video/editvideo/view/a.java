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
    private MediaPlayer aOZ;
    private FragmentTabWidget bIH;
    private com.baidu.tieba.video.editvideo.a gNv;
    private MaskVideoView gOE;
    private com.baidu.tbadk.core.dialog.b gOF;
    private b gOG;
    private d gOH;
    private c gOI;
    private FrameLayout gOJ;
    private b.InterfaceC0086b gOK;
    private h gyx;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view2, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.gOK = new b.InterfaceC0086b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view3) {
                switch (i) {
                    case 0:
                        if (a.this.gNv != null) {
                            a.this.gNv.bwq();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.gNv != null) {
                            a.this.gNv.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.gNv = aVar;
        this.mRootView = view2;
        this.gyx = hVar;
        this.mResources = view2.getResources();
        this.gOG = new b(this.mContext, this);
        this.gOH = new d(this.mContext, this, this.gyx);
        this.gOI = new c(this.mContext, this);
        this.gOG.by(this.mRootView);
        this.gOH.by(this.mRootView);
        this.gOI.by(this.mRootView);
        initView();
        bxb();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.gOE = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.gOE.setPreserveEGLContextOnPause(true);
        this.gOE.setZOrderMediaOverlay(true);
        this.gOE.setPostMonitorManager(this.gyx);
        this.gOJ = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.gOJ.addView(this.gOG.getRootView());
        this.bIH = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        ard();
        VN();
        this.gOJ.addView(this.gOH.getRootView());
        this.gOJ.addView(this.gOI.getRootView());
        this.gOH.getRootView().setVisibility(8);
        this.gOI.getRootView().setVisibility(8);
    }

    private boolean bxa() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void VN() {
        String[] stringArray = this.mResources.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0126d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(d.e.fontsize34));
            this.bIH.addView(fragmentTabIndicator, i);
        }
        if (!bxa() && this.bIH.getChildAt(1) != null) {
            this.bIH.getChildAt(1).setVisibility(8);
        }
        this.bIH.setDiverColor(this.mResources.getColor(d.C0126d.cp_cont_b));
        this.bIH.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.bIH.setBackGroundDrawableResId(d.C0126d.cp_bg_line_d);
        this.bIH.setDviderRectWidth(l.e(this.mContext.getPageActivity(), d.e.ds64));
        this.bIH.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void i(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.gOG.getRootView().setVisibility(0);
                            a.this.gOH.getRootView().setVisibility(8);
                            a.this.gOI.getRootView().setVisibility(8);
                            a.this.gOG.mT(true);
                            a.this.gOH.mT(false);
                            a.this.gOI.mT(false);
                            break;
                        case 1:
                            a.this.gOI.getRootView().setVisibility(0);
                            a.this.gOH.getRootView().setVisibility(8);
                            a.this.gOG.getRootView().setVisibility(8);
                            a.this.gOG.mT(false);
                            if (TextUtils.isEmpty(a.this.gOH.bxi())) {
                                a.this.gOH.mT(false);
                            } else {
                                a.this.gOH.mT(true);
                            }
                            a.this.gOI.mT(true);
                            break;
                        case 2:
                            a.this.gOH.getRootView().setVisibility(0);
                            a.this.gOG.getRootView().setVisibility(8);
                            a.this.gOI.getRootView().setVisibility(8);
                            a.this.gOG.mT(false);
                            a.this.gOH.mT(true);
                            a.this.gOI.mT(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.bIH.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.bxb();
                    a.this.bxc();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxb() {
        al alVar = new al("c12424");
        alVar.r("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(alVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxc() {
        if (this.mCurrentTabIndex == 0) {
            bxg();
            bxe();
            return;
        }
        replay();
    }

    public void replay() {
        bxg();
        this.gOE.start();
        this.gOE.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.aOZ != null) {
            this.mIsMute = z;
            if (z) {
                this.aOZ.setVolume(0.0f, 0.0f);
            } else {
                this.aOZ.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bxg();
        this.gOG.onPause();
        this.gOH.onPause();
        this.gOI.onPause();
    }

    public void onResume() {
        this.gOE.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.gOE.bxm();
        }
        this.gOG.onResume();
        this.gOH.onResume();
        this.gOI.onResume();
    }

    public MaskVideoView bxd() {
        return this.gOE;
    }

    public Bitmap t(Bitmap bitmap) {
        return this.gOG.t(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.gOH.setMusicData(list);
    }

    public void dC(List<PendantData> list) {
        this.gOG.dC(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.gOI != null) {
            this.gOI.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.gOG.setData(str);
                this.gOE.setVideoPath(str);
                this.gOE.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.aOZ = mediaPlayer;
                        if (a.this.mIsMute) {
                            a.this.aOZ.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.aOZ.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.gOG.bxp();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.gOE.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.gOE.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.gOE.seekTo(a.this.gOG.getCurrentPosition());
                    }
                });
                this.gOE.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.gOH.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bxe() {
        if (this.gOE != null) {
            this.gOE.seekTo(this.gOG.getCurrentPosition());
        }
    }

    public void bxf() {
        if (this.gOE != null) {
            this.gOE.un(this.gOG.getCurrentPosition());
        }
    }

    public void bxg() {
        if (this.gOE != null) {
            this.gOE.bxl();
        }
    }

    public void bxh() {
        if (this.gOE != null) {
            this.gOE.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.bIH.onChangeSkinType(i);
        this.bIH.setDiverColor(i == 1 ? this.mResources.getColor(d.C0126d.cp_cont_b_1) : this.mResources.getColor(d.C0126d.cp_cont_b));
        ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
        if (this.gOG != null) {
            this.gOG.onChangeSkinType(eVar, i);
        }
        if (this.gOH != null) {
            this.gOH.onChangeSkinType(eVar, i);
        }
    }

    private void ard() {
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
                a.this.gOG.bhP();
                if (a.this.gNv != null) {
                    a.this.gNv.bwn();
                }
            }
        }), d.C0126d.cp_cont_f);
    }

    public String getText() {
        return this.gOG.getText();
    }

    public int getCurrentPosition() {
        if (this.gOE == null) {
            return 0;
        }
        return this.gOE.getCurrentPosition();
    }

    public void showDialog() {
        if (this.gOF == null) {
            String[] strArr = {getPageContext().getString(d.k.save), getPageContext().getString(d.k.not_save), getPageContext().getString(d.k.cancel)};
            this.gOF = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.gOF.ce(b.a.acY);
            this.gOF.cg(17);
            this.gOF.dd(TbadkCoreApplication.getInst().getResources().getString(d.k.save_video_title));
            this.gOF.a(strArr, this.gOK);
            this.gOF.d(getPageContext());
            TextView titleView = this.gOF.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(d.e.fontsize24));
                ak.h(titleView, d.C0126d.cp_cont_d);
            }
        }
        this.gOF.tF();
    }

    public void cj(String str, String str2) {
        this.gOH.cj(str, str2);
    }

    public void bws() {
        if (this.gNv != null) {
            this.gNv.bws();
        }
    }

    public String bxi() {
        return this.gOH.bxi();
    }

    public String bxj() {
        return this.gOH.bxj();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bxk() {
        return this.gOH.bxk();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.gOG != null) {
            this.gOG.release();
        }
        if (this.gOE != null) {
            this.gOE.stopPlayback();
        }
    }

    public void aa(Intent intent) {
        this.gOH.aa(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bxd() != null) {
            bxd().setGenMaskCoverListener(bVar);
        }
    }
}
