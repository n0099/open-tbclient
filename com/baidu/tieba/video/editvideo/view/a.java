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
    private FragmentTabWidget bHt;
    private com.baidu.tieba.video.editvideo.a gMv;
    private MaskVideoView gNE;
    private com.baidu.tbadk.core.dialog.b gNF;
    private b gNG;
    private d gNH;
    private c gNI;
    private FrameLayout gNJ;
    private b.InterfaceC0086b gNK;
    private h gxw;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view2, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.gNK = new b.InterfaceC0086b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view3) {
                switch (i) {
                    case 0:
                        if (a.this.gMv != null) {
                            a.this.gMv.bws();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.gMv != null) {
                            a.this.gMv.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.gMv = aVar;
        this.mRootView = view2;
        this.gxw = hVar;
        this.mResources = view2.getResources();
        this.gNG = new b(this.mContext, this);
        this.gNH = new d(this.mContext, this, this.gxw);
        this.gNI = new c(this.mContext, this);
        this.gNG.by(this.mRootView);
        this.gNH.by(this.mRootView);
        this.gNI.by(this.mRootView);
        initView();
        bxd();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.gNE = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.gNE.setPreserveEGLContextOnPause(true);
        this.gNE.setZOrderMediaOverlay(true);
        this.gNE.setPostMonitorManager(this.gxw);
        this.gNJ = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.gNJ.addView(this.gNG.getRootView());
        this.bHt = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        are();
        VI();
        this.gNJ.addView(this.gNH.getRootView());
        this.gNJ.addView(this.gNI.getRootView());
        this.gNH.getRootView().setVisibility(8);
        this.gNI.getRootView().setVisibility(8);
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
            this.bHt.addView(fragmentTabIndicator, i);
        }
        if (!bxc() && this.bHt.getChildAt(1) != null) {
            this.bHt.getChildAt(1).setVisibility(8);
        }
        this.bHt.setDiverColor(this.mResources.getColor(d.C0126d.cp_cont_b));
        this.bHt.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.bHt.setBackGroundDrawableResId(d.C0126d.cp_bg_line_d);
        this.bHt.setDviderRectWidth(l.e(this.mContext.getPageActivity(), d.e.ds64));
        this.bHt.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void i(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.gNG.getRootView().setVisibility(0);
                            a.this.gNH.getRootView().setVisibility(8);
                            a.this.gNI.getRootView().setVisibility(8);
                            a.this.gNG.mS(true);
                            a.this.gNH.mS(false);
                            a.this.gNI.mS(false);
                            break;
                        case 1:
                            a.this.gNI.getRootView().setVisibility(0);
                            a.this.gNH.getRootView().setVisibility(8);
                            a.this.gNG.getRootView().setVisibility(8);
                            a.this.gNG.mS(false);
                            if (TextUtils.isEmpty(a.this.gNH.bxk())) {
                                a.this.gNH.mS(false);
                            } else {
                                a.this.gNH.mS(true);
                            }
                            a.this.gNI.mS(true);
                            break;
                        case 2:
                            a.this.gNH.getRootView().setVisibility(0);
                            a.this.gNG.getRootView().setVisibility(8);
                            a.this.gNI.getRootView().setVisibility(8);
                            a.this.gNG.mS(false);
                            a.this.gNH.mS(true);
                            a.this.gNI.mS(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.bHt.setCurrentTab(a.this.mCurrentTabIndex, true, true);
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
        this.gNE.start();
        this.gNE.seekTo(0);
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
        this.gNG.onPause();
        this.gNH.onPause();
        this.gNI.onPause();
    }

    public void onResume() {
        this.gNE.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.gNE.bxo();
        }
        this.gNG.onResume();
        this.gNH.onResume();
        this.gNI.onResume();
    }

    public MaskVideoView bxf() {
        return this.gNE;
    }

    public Bitmap t(Bitmap bitmap) {
        return this.gNG.t(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.gNH.setMusicData(list);
    }

    public void dz(List<PendantData> list) {
        this.gNG.dz(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.gNI != null) {
            this.gNI.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.gNG.setData(str);
                this.gNE.setVideoPath(str);
                this.gNE.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.gNG.bxr();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.gNE.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.gNE.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.gNE.seekTo(a.this.gNG.getCurrentPosition());
                    }
                });
                this.gNE.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.gNH.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bxg() {
        if (this.gNE != null) {
            this.gNE.seekTo(this.gNG.getCurrentPosition());
        }
    }

    public void bxh() {
        if (this.gNE != null) {
            this.gNE.up(this.gNG.getCurrentPosition());
        }
    }

    public void bxi() {
        if (this.gNE != null) {
            this.gNE.bxn();
        }
    }

    public void bxj() {
        if (this.gNE != null) {
            this.gNE.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.bHt.onChangeSkinType(i);
        this.bHt.setDiverColor(i == 1 ? this.mResources.getColor(d.C0126d.cp_cont_b_1) : this.mResources.getColor(d.C0126d.cp_cont_b));
        ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
        if (this.gNG != null) {
            this.gNG.onChangeSkinType(eVar, i);
        }
        if (this.gNH != null) {
            this.gNH.onChangeSkinType(eVar, i);
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
                a.this.gNG.bhP();
                if (a.this.gMv != null) {
                    a.this.gMv.bwp();
                }
            }
        }), d.C0126d.cp_cont_f);
    }

    public String getText() {
        return this.gNG.getText();
    }

    public int getCurrentPosition() {
        if (this.gNE == null) {
            return 0;
        }
        return this.gNE.getCurrentPosition();
    }

    public void showDialog() {
        if (this.gNF == null) {
            String[] strArr = {getPageContext().getString(d.k.save), getPageContext().getString(d.k.not_save), getPageContext().getString(d.k.cancel)};
            this.gNF = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.gNF.ce(b.a.acX);
            this.gNF.cg(17);
            this.gNF.dd(TbadkCoreApplication.getInst().getResources().getString(d.k.save_video_title));
            this.gNF.a(strArr, this.gNK);
            this.gNF.d(getPageContext());
            TextView titleView = this.gNF.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(d.e.fontsize24));
                ak.h(titleView, d.C0126d.cp_cont_d);
            }
        }
        this.gNF.tG();
    }

    public void cj(String str, String str2) {
        this.gNH.cj(str, str2);
    }

    public void bwu() {
        if (this.gMv != null) {
            this.gMv.bwu();
        }
    }

    public String bxk() {
        return this.gNH.bxk();
    }

    public String bxl() {
        return this.gNH.bxl();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bxm() {
        return this.gNH.bxm();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.gNG != null) {
            this.gNG.release();
        }
        if (this.gNE != null) {
            this.gNE.stopPlayback();
        }
    }

    public void aa(Intent intent) {
        this.gNH.aa(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bxf() != null) {
            bxf().setGenMaskCoverListener(bVar);
        }
    }
}
