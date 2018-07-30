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
    private MediaPlayer aXW;
    private FragmentTabWidget bTM;
    private h gOY;
    private com.baidu.tieba.video.editvideo.a heo;
    private com.baidu.tbadk.core.dialog.b hfA;
    private b hfB;
    private d hfC;
    private c hfD;
    private FrameLayout hfE;
    private b.InterfaceC0101b hfF;
    private MaskVideoView hfz;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.hfF = new b.InterfaceC0101b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.heo != null) {
                            a.this.heo.bAI();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.heo != null) {
                            a.this.heo.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.heo = aVar;
        this.mRootView = view;
        this.gOY = hVar;
        this.mResources = view.getResources();
        this.hfB = new b(this.mContext, this);
        this.hfC = new d(this.mContext, this, this.gOY);
        this.hfD = new c(this.mContext, this);
        this.hfB.bF(this.mRootView);
        this.hfC.bF(this.mRootView);
        this.hfD.bF(this.mRootView);
        initView();
        bBt();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.hfz = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.hfz.setPreserveEGLContextOnPause(true);
        this.hfz.setZOrderMediaOverlay(true);
        this.hfz.setPostMonitorManager(this.gOY);
        this.hfE = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.hfE.addView(this.hfB.getRootView());
        this.bTM = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        asl();
        ZZ();
        this.hfE.addView(this.hfC.getRootView());
        this.hfE.addView(this.hfD.getRootView());
        this.hfC.getRootView().setVisibility(8);
        this.hfD.getRootView().setVisibility(8);
    }

    private boolean bBs() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void ZZ() {
        String[] stringArray = this.mResources.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0140d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(d.e.fontsize34));
            this.bTM.addView(fragmentTabIndicator, i);
        }
        if (!bBs() && this.bTM.getChildAt(1) != null) {
            this.bTM.getChildAt(1).setVisibility(8);
        }
        this.bTM.setDiverColor(this.mResources.getColor(d.C0140d.cp_cont_b));
        this.bTM.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.bTM.setBackGroundDrawableResId(d.C0140d.cp_bg_line_d);
        this.bTM.setDviderRectWidth(l.f(this.mContext.getPageActivity(), d.e.ds64));
        this.bTM.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.hfB.getRootView().setVisibility(0);
                            a.this.hfC.getRootView().setVisibility(8);
                            a.this.hfD.getRootView().setVisibility(8);
                            a.this.hfB.mT(true);
                            a.this.hfC.mT(false);
                            a.this.hfD.mT(false);
                            break;
                        case 1:
                            a.this.hfD.getRootView().setVisibility(0);
                            a.this.hfC.getRootView().setVisibility(8);
                            a.this.hfB.getRootView().setVisibility(8);
                            a.this.hfB.mT(false);
                            if (TextUtils.isEmpty(a.this.hfC.bBA())) {
                                a.this.hfC.mT(false);
                            } else {
                                a.this.hfC.mT(true);
                            }
                            a.this.hfD.mT(true);
                            break;
                        case 2:
                            a.this.hfC.getRootView().setVisibility(0);
                            a.this.hfB.getRootView().setVisibility(8);
                            a.this.hfD.getRootView().setVisibility(8);
                            a.this.hfB.mT(false);
                            a.this.hfC.mT(true);
                            a.this.hfD.mT(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.bTM.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.bBt();
                    a.this.bBu();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBt() {
        an anVar = new an("c12424");
        anVar.r("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBu() {
        if (this.mCurrentTabIndex == 0) {
            bBy();
            bBw();
            return;
        }
        replay();
    }

    public void replay() {
        bBy();
        this.hfz.start();
        this.hfz.seekTo(0);
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
        bBy();
        this.hfB.onPause();
        this.hfC.onPause();
        this.hfD.onPause();
    }

    public void onResume() {
        this.hfz.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.hfz.bBE();
        }
        this.hfB.onResume();
        this.hfC.onResume();
        this.hfD.onResume();
    }

    public MaskVideoView bBv() {
        return this.hfz;
    }

    public Bitmap r(Bitmap bitmap) {
        return this.hfB.r(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.hfC.setMusicData(list);
    }

    public void dG(List<PendantData> list) {
        this.hfB.dG(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.hfD != null) {
            this.hfD.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hfB.setData(str);
                this.hfz.setVideoPath(str);
                this.hfz.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.hfB.bBH();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.hfz.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.hfz.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.hfz.seekTo(a.this.hfB.getCurrentPosition());
                    }
                });
                this.hfz.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.hfC.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bBw() {
        if (this.hfz != null) {
            this.hfz.seekTo(this.hfB.getCurrentPosition());
        }
    }

    public void bBx() {
        if (this.hfz != null) {
            this.hfz.uH(this.hfB.getCurrentPosition());
        }
    }

    public void bBy() {
        if (this.hfz != null) {
            this.hfz.bBD();
        }
    }

    public void bBz() {
        if (this.hfz != null) {
            this.hfz.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.bTM.onChangeSkinType(i);
        this.bTM.setDiverColor(i == 1 ? this.mResources.getColor(d.C0140d.cp_cont_b_1) : this.mResources.getColor(d.C0140d.cp_cont_b));
        am.j(this.mRootView, d.C0140d.cp_bg_line_d);
        if (this.hfB != null) {
            this.hfB.onChangeSkinType(eVar, i);
        }
        if (this.hfC != null) {
            this.hfC.onChangeSkinType(eVar, i);
        }
    }

    private void asl() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(d.j.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        am.h(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(d.j.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hfB.blK();
                if (a.this.heo != null) {
                    a.this.heo.bAF();
                }
            }
        }), d.C0140d.cp_cont_f);
    }

    public String getText() {
        return this.hfB.getText();
    }

    public int getCurrentPosition() {
        if (this.hfz == null) {
            return 0;
        }
        return this.hfz.getCurrentPosition();
    }

    public void showDialog() {
        if (this.hfA == null) {
            String[] strArr = {getPageContext().getString(d.j.save), getPageContext().getString(d.j.not_save), getPageContext().getString(d.j.cancel)};
            this.hfA = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hfA.cj(b.a.alb);
            this.hfA.cl(17);
            this.hfA.dC(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title));
            this.hfA.a(strArr, this.hfF);
            this.hfA.d(getPageContext());
            TextView titleView = this.hfA.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(d.e.fontsize24));
                am.h(titleView, d.C0140d.cp_cont_d);
            }
        }
        this.hfA.xi();
    }

    public void cs(String str, String str2) {
        this.hfC.cs(str, str2);
    }

    public void bAK() {
        if (this.heo != null) {
            this.heo.bAK();
        }
    }

    public String bBA() {
        return this.hfC.bBA();
    }

    public String bBB() {
        return this.hfC.bBB();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bBC() {
        return this.hfC.bBC();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.hfB != null) {
            this.hfB.release();
        }
        if (this.hfz != null) {
            this.hfz.stopPlayback();
        }
    }

    public void aa(Intent intent) {
        this.hfC.aa(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bBv() != null) {
            bBv().setGenMaskCoverListener(bVar);
        }
    }
}
