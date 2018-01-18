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
    private MediaPlayer bRd;
    private FragmentTabWidget cnj;
    private h gZj;
    private com.baidu.tieba.video.editvideo.a hoR;
    private MaskVideoView hqc;
    private com.baidu.tbadk.core.dialog.b hqd;
    private b hqe;
    private d hqf;
    private c hqg;
    private FrameLayout hqh;
    private b.InterfaceC0073b hqi;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.hqi = new b.InterfaceC0073b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.hoR != null) {
                            a.this.hoR.bAx();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.hoR != null) {
                            a.this.hoR.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.hoR = aVar;
        this.mRootView = view;
        this.gZj = hVar;
        this.mResources = view.getResources();
        this.hqe = new b(this.mContext, this);
        this.hqf = new d(this.mContext, this, this.gZj);
        this.hqg = new c(this.mContext, this);
        this.hqe.cT(this.mRootView);
        this.hqf.cT(this.mRootView);
        this.hqg.cT(this.mRootView);
        initView();
        bBj();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.hqc = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.hqc.setPreserveEGLContextOnPause(true);
        this.hqc.setZOrderMediaOverlay(true);
        this.hqc.setPostMonitorManager(this.gZj);
        this.hqh = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.hqh.addView(this.hqe.getRootView());
        this.cnj = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        avL();
        aas();
        this.hqh.addView(this.hqf.getRootView());
        this.hqh.addView(this.hqg.getRootView());
        this.hqf.getRootView().setVisibility(8);
        this.hqg.getRootView().setVisibility(8);
    }

    private boolean bBi() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void aas() {
        String[] stringArray = this.mResources.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0107d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(d.e.fontsize34));
            this.cnj.addView(fragmentTabIndicator, i);
        }
        if (!bBi() && this.cnj.getChildAt(1) != null) {
            this.cnj.getChildAt(1).setVisibility(8);
        }
        this.cnj.setDiverColor(this.mResources.getColor(d.C0107d.cp_cont_b));
        this.cnj.a(this.mCurrentTabIndex, true, false);
        this.cnj.setBackGroundDrawableResId(d.C0107d.cp_bg_line_d);
        this.cnj.setDviderRectWidth(l.s(this.mContext.getPageActivity(), d.e.ds64));
        this.cnj.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void p(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.hqe.getRootView().setVisibility(0);
                            a.this.hqf.getRootView().setVisibility(8);
                            a.this.hqg.getRootView().setVisibility(8);
                            a.this.hqe.nb(true);
                            a.this.hqf.nb(false);
                            a.this.hqg.nb(false);
                            break;
                        case 1:
                            a.this.hqg.getRootView().setVisibility(0);
                            a.this.hqf.getRootView().setVisibility(8);
                            a.this.hqe.getRootView().setVisibility(8);
                            a.this.hqe.nb(false);
                            if (TextUtils.isEmpty(a.this.hqf.bBq())) {
                                a.this.hqf.nb(false);
                            } else {
                                a.this.hqf.nb(true);
                            }
                            a.this.hqg.nb(true);
                            break;
                        case 2:
                            a.this.hqf.getRootView().setVisibility(0);
                            a.this.hqe.getRootView().setVisibility(8);
                            a.this.hqg.getRootView().setVisibility(8);
                            a.this.hqe.nb(false);
                            a.this.hqf.nb(true);
                            a.this.hqg.nb(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.cnj.a(a.this.mCurrentTabIndex, true, true);
                    a.this.bBj();
                    a.this.bBk();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBj() {
        ak akVar = new ak("c12424");
        akVar.s("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBk() {
        if (this.mCurrentTabIndex == 0) {
            bBo();
            bBm();
            return;
        }
        replay();
    }

    public void replay() {
        bBo();
        this.hqc.start();
        this.hqc.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bRd != null) {
            this.mIsMute = z;
            if (z) {
                this.bRd.setVolume(0.0f, 0.0f);
            } else {
                this.bRd.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bBo();
        this.hqe.onPause();
        this.hqf.onPause();
        this.hqg.onPause();
    }

    public void onResume() {
        this.hqc.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.hqc.bBu();
        }
        this.hqe.onResume();
        this.hqf.onResume();
        this.hqg.onResume();
    }

    public MaskVideoView bBl() {
        return this.hqc;
    }

    public Bitmap m(Bitmap bitmap) {
        return this.hqe.m(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.hqf.setMusicData(list);
    }

    public void dC(List<PendantData> list) {
        this.hqe.dC(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.hqg != null) {
            this.hqg.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hqe.setData(str);
                this.hqc.setVideoPath(str);
                this.hqc.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bRd = mediaPlayer;
                        if (a.this.mIsMute) {
                            a.this.bRd.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bRd.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.hqe.bBx();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.hqc.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.hqc.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.hqc.seekTo(a.this.hqe.getCurrentPosition());
                    }
                });
                this.hqc.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.hqf.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bBm() {
        if (this.hqc != null) {
            this.hqc.seekTo(this.hqe.getCurrentPosition());
        }
    }

    public void bBn() {
        if (this.hqc != null) {
            this.hqc.wM(this.hqe.getCurrentPosition());
        }
    }

    public void bBo() {
        if (this.hqc != null) {
            this.hqc.bBt();
        }
    }

    public void bBp() {
        if (this.hqc != null) {
            this.hqc.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.cnj.onChangeSkinType(i);
        this.cnj.setDiverColor(i == 1 ? this.mResources.getColor(d.C0107d.cp_cont_b_1) : this.mResources.getColor(d.C0107d.cp_cont_b));
        aj.t(this.mRootView, d.C0107d.cp_bg_line_d);
        if (this.hqe != null) {
            this.hqe.onChangeSkinType(eVar, i);
        }
        if (this.hqf != null) {
            this.hqf.onChangeSkinType(eVar, i);
        }
    }

    private void avL() {
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
                a.this.hqe.blv();
                if (a.this.hoR != null) {
                    a.this.hoR.bAu();
                }
            }
        }), d.C0107d.cp_cont_f);
    }

    public String getText() {
        return this.hqe.getText();
    }

    public int getCurrentPosition() {
        if (this.hqc == null) {
            return 0;
        }
        return this.hqc.getCurrentPosition();
    }

    public void showDialog() {
        if (this.hqd == null) {
            String[] strArr = {getPageContext().getString(d.j.save), getPageContext().getString(d.j.not_save), getPageContext().getString(d.j.cancel)};
            this.hqd = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hqd.ff(b.a.aQk);
            this.hqd.fh(17);
            this.hqd.da(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title));
            this.hqd.a(strArr, this.hqi);
            this.hqd.d(getPageContext());
            TextView titleView = this.hqd.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(d.e.fontsize24));
                aj.r(titleView, d.C0107d.cp_cont_d);
            }
        }
        this.hqd.AD();
    }

    public void cj(String str, String str2) {
        this.hqf.cj(str, str2);
    }

    public void bAz() {
        if (this.hoR != null) {
            this.hoR.bAz();
        }
    }

    public String bBq() {
        return this.hqf.bBq();
    }

    public String bBr() {
        return this.hqf.bBr();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bBs() {
        return this.hqf.bBs();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.hqe != null) {
            this.hqe.release();
        }
        if (this.hqc != null) {
            this.hqc.stopPlayback();
        }
    }

    public void ad(Intent intent) {
        this.hqf.ad(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bBl() != null) {
            bBl().setGenMaskCoverListener(bVar);
        }
    }
}
