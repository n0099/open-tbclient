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
    private FragmentTabWidget cil;
    private h hfy;
    private com.baidu.tieba.video.editvideo.a hvg;
    private MaskVideoView hwp;
    private com.baidu.tbadk.core.dialog.b hwq;
    private b hwr;
    private d hws;
    private c hwt;
    private FrameLayout hwu;
    private b.InterfaceC0148b hwv;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.hwv = new b.InterfaceC0148b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.hvg != null) {
                            a.this.hvg.bGm();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.hvg != null) {
                            a.this.hvg.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.hvg = aVar;
        this.mRootView = view;
        this.hfy = hVar;
        this.mResources = view.getResources();
        this.hwr = new b(this.mContext, this);
        this.hws = new d(this.mContext, this, this.hfy);
        this.hwt = new c(this.mContext, this);
        this.hwr.bU(this.mRootView);
        this.hws.bU(this.mRootView);
        this.hwt.bU(this.mRootView);
        initView();
        bGX();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.hwp = (MaskVideoView) this.mRootView.findViewById(e.g.video_view);
        this.hwp.setPreserveEGLContextOnPause(true);
        this.hwp.setZOrderMediaOverlay(true);
        this.hwp.setPostMonitorManager(this.hfy);
        this.hwu = (FrameLayout) this.mRootView.findViewById(e.g.edit_container);
        this.hwu.addView(this.hwr.getRootView());
        this.cil = (FragmentTabWidget) this.mRootView.findViewById(e.g.tab_widget);
        awU();
        aeV();
        this.hwu.addView(this.hws.getRootView());
        this.hwu.addView(this.hwt.getRootView());
        this.hws.getRootView().setVisibility(8);
        this.hwt.getRootView().setVisibility(8);
    }

    private boolean bGW() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void aeV() {
        String[] stringArray = this.mResources.getStringArray(e.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(e.d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(e.C0200e.fontsize34));
            this.cil.addView(fragmentTabIndicator, i);
        }
        if (!bGW() && this.cil.getChildAt(1) != null) {
            this.cil.getChildAt(1).setVisibility(8);
        }
        this.cil.setDiverColor(this.mResources.getColor(e.d.cp_cont_b));
        this.cil.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.cil.setBackGroundDrawableResId(e.d.cp_bg_line_d);
        this.cil.setDviderRectWidth(l.h(this.mContext.getPageActivity(), e.C0200e.ds64));
        this.cil.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.hwr.getRootView().setVisibility(0);
                            a.this.hws.getRootView().setVisibility(8);
                            a.this.hwt.getRootView().setVisibility(8);
                            a.this.hwr.nV(true);
                            a.this.hws.nV(false);
                            a.this.hwt.nV(false);
                            break;
                        case 1:
                            a.this.hwt.getRootView().setVisibility(0);
                            a.this.hws.getRootView().setVisibility(8);
                            a.this.hwr.getRootView().setVisibility(8);
                            a.this.hwr.nV(false);
                            if (TextUtils.isEmpty(a.this.hws.bHe())) {
                                a.this.hws.nV(false);
                            } else {
                                a.this.hws.nV(true);
                            }
                            a.this.hwt.nV(true);
                            break;
                        case 2:
                            a.this.hws.getRootView().setVisibility(0);
                            a.this.hwr.getRootView().setVisibility(8);
                            a.this.hwt.getRootView().setVisibility(8);
                            a.this.hwr.nV(false);
                            a.this.hws.nV(true);
                            a.this.hwt.nV(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.cil.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.bGX();
                    a.this.bGY();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGX() {
        am amVar = new am("c12424");
        amVar.x("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGY() {
        if (this.mCurrentTabIndex == 0) {
            bHc();
            bHa();
            return;
        }
        replay();
    }

    public void replay() {
        bHc();
        this.hwp.start();
        this.hwp.seekTo(0);
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
        bHc();
        this.hwr.onPause();
        this.hws.onPause();
        this.hwt.onPause();
    }

    public void onResume() {
        this.hwp.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.hwp.resumeMedia();
        }
        this.hwr.onResume();
        this.hws.onResume();
        this.hwt.onResume();
    }

    public MaskVideoView bGZ() {
        return this.hwp;
    }

    public Bitmap s(Bitmap bitmap) {
        return this.hwr.s(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.hws.setMusicData(list);
    }

    public void dT(List<PendantData> list) {
        this.hwr.dT(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.hwt != null) {
            this.hwt.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hwr.setData(str);
                this.hwp.setVideoPath(str);
                this.hwp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.hwr.bHk();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.hwp.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.hwp.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.hwp.seekTo(a.this.hwr.getCurrentPosition());
                    }
                });
                this.hwp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.hws.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bHa() {
        if (this.hwp != null) {
            this.hwp.seekTo(this.hwr.getCurrentPosition());
        }
    }

    public void bHb() {
        if (this.hwp != null) {
            this.hwp.vX(this.hwr.getCurrentPosition());
        }
    }

    public void bHc() {
        if (this.hwp != null) {
            this.hwp.bHh();
        }
    }

    public void bHd() {
        if (this.hwp != null) {
            this.hwp.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.cil.onChangeSkinType(i);
        this.cil.setDiverColor(i == 1 ? this.mResources.getColor(e.d.cp_cont_b_1) : this.mResources.getColor(e.d.cp_cont_b));
        al.j(this.mRootView, e.d.cp_bg_line_d);
        if (this.hwr != null) {
            this.hwr.onChangeSkinType(eVar, i);
        }
        if (this.hws != null) {
            this.hws.onChangeSkinType(eVar, i);
        }
    }

    private void awU() {
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
                a.this.hwr.bqY();
                if (a.this.hvg != null) {
                    a.this.hvg.bGj();
                }
            }
        }), e.d.cp_cont_f);
    }

    public String getText() {
        return this.hwr.getText();
    }

    public int getCurrentPosition() {
        if (this.hwp == null) {
            return 0;
        }
        return this.hwp.getCurrentPosition();
    }

    public void showDialog() {
        if (this.hwq == null) {
            String[] strArr = {getPageContext().getString(e.j.save), getPageContext().getString(e.j.not_save), getPageContext().getString(e.j.cancel)};
            this.hwq = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hwq.cR(b.a.ato);
            this.hwq.cT(17);
            this.hwq.ek(TbadkCoreApplication.getInst().getResources().getString(e.j.save_video_title));
            this.hwq.a(strArr, this.hwv);
            this.hwq.d(getPageContext());
            TextView titleView = this.hwq.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(e.C0200e.fontsize24));
                al.h(titleView, e.d.cp_cont_d);
            }
        }
        this.hwq.AE();
    }

    public void cN(String str, String str2) {
        this.hws.cN(str, str2);
    }

    public void bGo() {
        if (this.hvg != null) {
            this.hvg.bGo();
        }
    }

    public String bHe() {
        return this.hws.bHe();
    }

    public String bHf() {
        return this.hws.bHf();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bHg() {
        return this.hws.bHg();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.hwr != null) {
            this.hwr.release();
        }
        if (this.hwp != null) {
            this.hwp.stopPlayback();
        }
    }

    public void ae(Intent intent) {
        this.hws.ae(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bGZ() != null) {
            bGZ().setGenMaskCoverListener(bVar);
        }
    }
}
