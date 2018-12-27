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
    private MediaPlayer Wd;
    private FragmentTabWidget cmo;
    private com.baidu.tieba.video.editvideo.a hFD;
    private MaskVideoView hGM;
    private com.baidu.tbadk.core.dialog.b hGN;
    private b hGO;
    private d hGP;
    private c hGQ;
    private FrameLayout hGR;
    private b.InterfaceC0158b hGS;
    private h hpD;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.hGS = new b.InterfaceC0158b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.hFD != null) {
                            a.this.hFD.bJg();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.hFD != null) {
                            a.this.hFD.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.hFD = aVar;
        this.mRootView = view;
        this.hpD = hVar;
        this.mResources = view.getResources();
        this.hGO = new b(this.mContext, this);
        this.hGP = new d(this.mContext, this, this.hpD);
        this.hGQ = new c(this.mContext, this);
        this.hGO.bX(this.mRootView);
        this.hGP.bX(this.mRootView);
        this.hGQ.bX(this.mRootView);
        initView();
        bJR();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.hGM = (MaskVideoView) this.mRootView.findViewById(e.g.video_view);
        this.hGM.setPreserveEGLContextOnPause(true);
        this.hGM.setZOrderMediaOverlay(true);
        this.hGM.setPostMonitorManager(this.hpD);
        this.hGR = (FrameLayout) this.mRootView.findViewById(e.g.edit_container);
        this.hGR.addView(this.hGO.getRootView());
        this.cmo = (FragmentTabWidget) this.mRootView.findViewById(e.g.tab_widget);
        azu();
        agl();
        this.hGR.addView(this.hGP.getRootView());
        this.hGR.addView(this.hGQ.getRootView());
        this.hGP.getRootView().setVisibility(8);
        this.hGQ.getRootView().setVisibility(8);
    }

    private boolean bJQ() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void agl() {
        String[] stringArray = this.mResources.getStringArray(e.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(e.d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(e.C0210e.fontsize34));
            this.cmo.addView(fragmentTabIndicator, i);
        }
        if (!bJQ() && this.cmo.getChildAt(1) != null) {
            this.cmo.getChildAt(1).setVisibility(8);
        }
        this.cmo.setDiverColor(this.mResources.getColor(e.d.cp_cont_b));
        this.cmo.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.cmo.setBackGroundDrawableResId(e.d.cp_bg_line_d);
        this.cmo.setDviderRectWidth(l.h(this.mContext.getPageActivity(), e.C0210e.ds64));
        this.cmo.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.hGO.getRootView().setVisibility(0);
                            a.this.hGP.getRootView().setVisibility(8);
                            a.this.hGQ.getRootView().setVisibility(8);
                            a.this.hGO.oa(true);
                            a.this.hGP.oa(false);
                            a.this.hGQ.oa(false);
                            break;
                        case 1:
                            a.this.hGQ.getRootView().setVisibility(0);
                            a.this.hGP.getRootView().setVisibility(8);
                            a.this.hGO.getRootView().setVisibility(8);
                            a.this.hGO.oa(false);
                            if (TextUtils.isEmpty(a.this.hGP.bJY())) {
                                a.this.hGP.oa(false);
                            } else {
                                a.this.hGP.oa(true);
                            }
                            a.this.hGQ.oa(true);
                            break;
                        case 2:
                            a.this.hGP.getRootView().setVisibility(0);
                            a.this.hGO.getRootView().setVisibility(8);
                            a.this.hGQ.getRootView().setVisibility(8);
                            a.this.hGO.oa(false);
                            a.this.hGP.oa(true);
                            a.this.hGQ.oa(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.cmo.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.bJR();
                    a.this.bJS();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJR() {
        am amVar = new am("c12424");
        amVar.x("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJS() {
        if (this.mCurrentTabIndex == 0) {
            bJW();
            bJU();
            return;
        }
        replay();
    }

    public void replay() {
        bJW();
        this.hGM.start();
        this.hGM.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.Wd != null) {
            this.mIsMute = z;
            if (z) {
                this.Wd.setVolume(0.0f, 0.0f);
            } else {
                this.Wd.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bJW();
        this.hGO.onPause();
        this.hGP.onPause();
        this.hGQ.onPause();
    }

    public void onResume() {
        this.hGM.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.hGM.resumeMedia();
        }
        this.hGO.onResume();
        this.hGP.onResume();
        this.hGQ.onResume();
    }

    public MaskVideoView bJT() {
        return this.hGM;
    }

    public Bitmap s(Bitmap bitmap) {
        return this.hGO.s(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.hGP.setMusicData(list);
    }

    public void dY(List<PendantData> list) {
        this.hGO.dY(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.hGQ != null) {
            this.hGQ.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hGO.setData(str);
                this.hGM.setVideoPath(str);
                this.hGM.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.Wd = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.Wd.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.Wd.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.hGO.bKe();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.hGM.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.hGM.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.hGM.seekTo(a.this.hGO.getCurrentPosition());
                    }
                });
                this.hGM.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.hGP.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bJU() {
        if (this.hGM != null) {
            this.hGM.seekTo(this.hGO.getCurrentPosition());
        }
    }

    public void bJV() {
        if (this.hGM != null) {
            this.hGM.wH(this.hGO.getCurrentPosition());
        }
    }

    public void bJW() {
        if (this.hGM != null) {
            this.hGM.bKb();
        }
    }

    public void bJX() {
        if (this.hGM != null) {
            this.hGM.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.cmo.onChangeSkinType(i);
        this.cmo.setDiverColor(i == 1 ? this.mResources.getColor(e.d.cp_cont_b_1) : this.mResources.getColor(e.d.cp_cont_b));
        al.j(this.mRootView, e.d.cp_bg_line_d);
        if (this.hGO != null) {
            this.hGO.onChangeSkinType(eVar, i);
        }
        if (this.hGP != null) {
            this.hGP.onChangeSkinType(eVar, i);
        }
    }

    private void azu() {
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
                a.this.hGO.btC();
                if (a.this.hFD != null) {
                    a.this.hFD.bJd();
                }
            }
        }), e.d.cp_cont_f);
    }

    public String getText() {
        return this.hGO.getText();
    }

    public int getCurrentPosition() {
        if (this.hGM == null) {
            return 0;
        }
        return this.hGM.getCurrentPosition();
    }

    public void showDialog() {
        if (this.hGN == null) {
            String[] strArr = {getPageContext().getString(e.j.save), getPageContext().getString(e.j.not_save), getPageContext().getString(e.j.cancel)};
            this.hGN = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hGN.df(b.a.awP);
            this.hGN.dh(17);
            this.hGN.eC(TbadkCoreApplication.getInst().getResources().getString(e.j.save_video_title));
            this.hGN.a(strArr, this.hGS);
            this.hGN.d(getPageContext());
            TextView titleView = this.hGN.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(e.C0210e.fontsize24));
                al.h(titleView, e.d.cp_cont_d);
            }
        }
        this.hGN.BI();
    }

    public void cS(String str, String str2) {
        this.hGP.cS(str, str2);
    }

    public void bJi() {
        if (this.hFD != null) {
            this.hFD.bJi();
        }
    }

    public String bJY() {
        return this.hGP.bJY();
    }

    public String bJZ() {
        return this.hGP.bJZ();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bKa() {
        return this.hGP.bKa();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.hGO != null) {
            this.hGO.release();
        }
        if (this.hGM != null) {
            this.hGM.stopPlayback();
        }
    }

    public void ae(Intent intent) {
        this.hGP.ae(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bJT() != null) {
            bJT().setGenMaskCoverListener(bVar);
        }
    }
}
