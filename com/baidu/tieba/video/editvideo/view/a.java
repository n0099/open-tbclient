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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.i.h;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c {
    private MediaPlayer bRl;
    private FragmentTabWidget cnr;
    private h gZD;
    private com.baidu.tieba.video.editvideo.a hpl;
    private c hqA;
    private FrameLayout hqB;
    private b.InterfaceC0073b hqC;
    private MaskVideoView hqw;
    private com.baidu.tbadk.core.dialog.b hqx;
    private b hqy;
    private d hqz;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.hqC = new b.InterfaceC0073b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.hpl != null) {
                            a.this.hpl.bAz();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.hpl != null) {
                            a.this.hpl.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.hpl = aVar;
        this.mRootView = view;
        this.gZD = hVar;
        this.mResources = view.getResources();
        this.hqy = new b(this.mContext, this);
        this.hqz = new d(this.mContext, this, this.gZD);
        this.hqA = new c(this.mContext, this);
        this.hqy.cT(this.mRootView);
        this.hqz.cT(this.mRootView);
        this.hqA.cT(this.mRootView);
        initView();
        bBl();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.hqw = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.hqw.setPreserveEGLContextOnPause(true);
        this.hqw.setZOrderMediaOverlay(true);
        this.hqw.setPostMonitorManager(this.gZD);
        this.hqB = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.hqB.addView(this.hqy.getRootView());
        this.cnr = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        avQ();
        aau();
        this.hqB.addView(this.hqz.getRootView());
        this.hqB.addView(this.hqA.getRootView());
        this.hqz.getRootView().setVisibility(8);
        this.hqA.getRootView().setVisibility(8);
    }

    private boolean bBk() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void aau() {
        String[] stringArray = this.mResources.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0108d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(d.e.fontsize34));
            this.cnr.addView(fragmentTabIndicator, i);
        }
        if (!bBk() && this.cnr.getChildAt(1) != null) {
            this.cnr.getChildAt(1).setVisibility(8);
        }
        this.cnr.setDiverColor(this.mResources.getColor(d.C0108d.cp_cont_b));
        this.cnr.a(this.mCurrentTabIndex, true, false);
        this.cnr.setBackGroundDrawableResId(d.C0108d.cp_bg_line_d);
        this.cnr.setDviderRectWidth(l.s(this.mContext.getPageActivity(), d.e.ds64));
        this.cnr.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void p(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.hqy.getRootView().setVisibility(0);
                            a.this.hqz.getRootView().setVisibility(8);
                            a.this.hqA.getRootView().setVisibility(8);
                            a.this.hqy.nd(true);
                            a.this.hqz.nd(false);
                            a.this.hqA.nd(false);
                            break;
                        case 1:
                            a.this.hqA.getRootView().setVisibility(0);
                            a.this.hqz.getRootView().setVisibility(8);
                            a.this.hqy.getRootView().setVisibility(8);
                            a.this.hqy.nd(false);
                            if (TextUtils.isEmpty(a.this.hqz.bBs())) {
                                a.this.hqz.nd(false);
                            } else {
                                a.this.hqz.nd(true);
                            }
                            a.this.hqA.nd(true);
                            break;
                        case 2:
                            a.this.hqz.getRootView().setVisibility(0);
                            a.this.hqy.getRootView().setVisibility(8);
                            a.this.hqA.getRootView().setVisibility(8);
                            a.this.hqy.nd(false);
                            a.this.hqz.nd(true);
                            a.this.hqA.nd(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.cnr.a(a.this.mCurrentTabIndex, true, true);
                    a.this.bBl();
                    a.this.bBm();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBl() {
        ak akVar = new ak("c12424");
        akVar.s("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBm() {
        if (this.mCurrentTabIndex == 0) {
            bBq();
            bBo();
            return;
        }
        replay();
    }

    public void replay() {
        bBq();
        this.hqw.start();
        this.hqw.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bRl != null) {
            this.mIsMute = z;
            if (z) {
                this.bRl.setVolume(0.0f, 0.0f);
            } else {
                this.bRl.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bBq();
        this.hqy.onPause();
        this.hqz.onPause();
        this.hqA.onPause();
    }

    public void onResume() {
        this.hqw.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.hqw.bBw();
        }
        this.hqy.onResume();
        this.hqz.onResume();
        this.hqA.onResume();
    }

    public MaskVideoView bBn() {
        return this.hqw;
    }

    public Bitmap m(Bitmap bitmap) {
        return this.hqy.m(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.hqz.setMusicData(list);
    }

    public void dC(List<PendantData> list) {
        this.hqy.dC(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.hqA != null) {
            this.hqA.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hqy.setData(str);
                this.hqw.setVideoPath(str);
                this.hqw.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bRl = mediaPlayer;
                        if (a.this.mIsMute) {
                            a.this.bRl.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bRl.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.hqy.bBz();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.hqw.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.hqw.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.hqw.seekTo(a.this.hqy.getCurrentPosition());
                    }
                });
                this.hqw.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.hqz.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bBo() {
        if (this.hqw != null) {
            this.hqw.seekTo(this.hqy.getCurrentPosition());
        }
    }

    public void bBp() {
        if (this.hqw != null) {
            this.hqw.wM(this.hqy.getCurrentPosition());
        }
    }

    public void bBq() {
        if (this.hqw != null) {
            this.hqw.bBv();
        }
    }

    public void bBr() {
        if (this.hqw != null) {
            this.hqw.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.cnr.onChangeSkinType(i);
        this.cnr.setDiverColor(i == 1 ? this.mResources.getColor(d.C0108d.cp_cont_b_1) : this.mResources.getColor(d.C0108d.cp_cont_b));
        aj.t(this.mRootView, d.C0108d.cp_bg_line_d);
        if (this.hqy != null) {
            this.hqy.onChangeSkinType(eVar, i);
        }
        if (this.hqz != null) {
            this.hqz.onChangeSkinType(eVar, i);
        }
    }

    private void avQ() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(d.j.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        aj.r(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(d.j.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hqy.blw();
                if (a.this.hpl != null) {
                    a.this.hpl.bAw();
                }
            }
        }), d.C0108d.cp_cont_f);
    }

    public String getText() {
        return this.hqy.getText();
    }

    public int getCurrentPosition() {
        if (this.hqw == null) {
            return 0;
        }
        return this.hqw.getCurrentPosition();
    }

    public void showDialog() {
        if (this.hqx == null) {
            String[] strArr = {getPageContext().getString(d.j.save), getPageContext().getString(d.j.not_save), getPageContext().getString(d.j.cancel)};
            this.hqx = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hqx.ff(b.a.aQn);
            this.hqx.fh(17);
            this.hqx.da(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title));
            this.hqx.a(strArr, this.hqC);
            this.hqx.d(getPageContext());
            TextView titleView = this.hqx.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(d.e.fontsize24));
                aj.r(titleView, d.C0108d.cp_cont_d);
            }
        }
        this.hqx.AE();
    }

    public void ci(String str, String str2) {
        this.hqz.ci(str, str2);
    }

    public void bAB() {
        if (this.hpl != null) {
            this.hpl.bAB();
        }
    }

    public String bBs() {
        return this.hqz.bBs();
    }

    public String bBt() {
        return this.hqz.bBt();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bBu() {
        return this.hqz.bBu();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.hqy != null) {
            this.hqy.release();
        }
        if (this.hqw != null) {
            this.hqw.stopPlayback();
        }
    }

    public void ad(Intent intent) {
        this.hqz.ad(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bBn() != null) {
            bBn().setGenMaskCoverListener(bVar);
        }
    }
}
