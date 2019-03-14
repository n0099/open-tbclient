package com.baidu.tieba.video.editvideo.view;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends com.baidu.adp.base.c {
    private i.c bFF;
    private MediaPlayer bsm;
    private FragmentTabWidget dBW;
    private h iHn;
    private com.baidu.tieba.video.editvideo.a iXm;
    private MaskVideoView iYu;
    private g iYv;
    private b iYw;
    private d iYx;
    private c iYy;
    private FrameLayout iYz;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.bFF = new i.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.iXm != null) {
                            a.this.iXm.cjp();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.iXm != null) {
                            a.this.iXm.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.iYv != null && a.this.iYv.isShowing() && a.this.getPageContext() != null) {
                    a.this.iYv.dismiss();
                }
            }
        };
        this.iXm = aVar;
        this.mRootView = view;
        this.iHn = hVar;
        this.mResources = view.getResources();
        this.iYw = new b(this.mContext, this);
        this.iYx = new d(this.mContext, this, this.iHn);
        this.iYy = new c(this.mContext, this);
        this.iYw.cK(this.mRootView);
        this.iYx.cK(this.mRootView);
        this.iYy.cK(this.mRootView);
        initView();
        cka();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.iYu = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.iYu.setPreserveEGLContextOnPause(true);
        this.iYu.setZOrderMediaOverlay(true);
        this.iYu.setPostMonitorManager(this.iHn);
        this.iYz = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.iYz.addView(this.iYw.getRootView());
        this.dBW = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        aBB();
        aHD();
        this.iYz.addView(this.iYx.getRootView());
        this.iYz.addView(this.iYy.getRootView());
        this.iYx.getRootView().setVisibility(8);
        this.iYy.getRootView().setVisibility(8);
    }

    private boolean cjZ() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void aHD() {
        String[] stringArray = this.mResources.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0277d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(d.e.fontsize34));
            this.dBW.addView(fragmentTabIndicator, i);
        }
        if (!cjZ() && this.dBW.getChildAt(1) != null) {
            this.dBW.getChildAt(1).setVisibility(8);
        }
        this.dBW.setDiverColor(this.mResources.getColor(d.C0277d.cp_cont_b));
        this.dBW.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.dBW.setBackGroundDrawableResId(d.C0277d.cp_bg_line_d);
        this.dBW.setDviderRectWidth(l.h(this.mContext.getPageActivity(), d.e.ds64));
        this.dBW.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.iYw.getRootView().setVisibility(0);
                            a.this.iYx.getRootView().setVisibility(8);
                            a.this.iYy.getRootView().setVisibility(8);
                            a.this.iYw.qB(true);
                            a.this.iYx.qB(false);
                            a.this.iYy.qB(false);
                            break;
                        case 1:
                            a.this.iYy.getRootView().setVisibility(0);
                            a.this.iYx.getRootView().setVisibility(8);
                            a.this.iYw.getRootView().setVisibility(8);
                            a.this.iYw.qB(false);
                            if (TextUtils.isEmpty(a.this.iYx.ckh())) {
                                a.this.iYx.qB(false);
                            } else {
                                a.this.iYx.qB(true);
                            }
                            a.this.iYy.qB(true);
                            break;
                        case 2:
                            a.this.iYx.getRootView().setVisibility(0);
                            a.this.iYw.getRootView().setVisibility(8);
                            a.this.iYy.getRootView().setVisibility(8);
                            a.this.iYw.qB(false);
                            a.this.iYx.qB(true);
                            a.this.iYy.qB(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.dBW.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.cka();
                    a.this.ckb();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cka() {
        am amVar = new am("c12424");
        amVar.T("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckb() {
        if (this.mCurrentTabIndex == 0) {
            ckf();
            ckd();
            return;
        }
        replay();
    }

    public void replay() {
        ckf();
        this.iYu.start();
        this.iYu.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bsm != null) {
            this.mIsMute = z;
            if (z) {
                this.bsm.setVolume(0.0f, 0.0f);
            } else {
                this.bsm.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        ckf();
        this.iYw.onPause();
        this.iYx.onPause();
        this.iYy.onPause();
    }

    public void onResume() {
        this.iYu.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.iYu.ckl();
        }
        this.iYw.onResume();
        this.iYx.onResume();
        this.iYy.onResume();
    }

    public MaskVideoView ckc() {
        return this.iYu;
    }

    public Bitmap A(Bitmap bitmap) {
        return this.iYw.A(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.iYx.setMusicData(list);
    }

    public void ef(List<PendantData> list) {
        this.iYw.ef(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.iYy != null) {
            this.iYy.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.iYw.setData(str);
                this.iYu.setVideoPath(str);
                this.iYu.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bsm = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.bsm.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bsm.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.iYw.cko();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.iYu.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.iYu.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.iYu.seekTo(a.this.iYw.getCurrentPosition());
                    }
                });
                this.iYu.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.iYx.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void ckd() {
        if (this.iYu != null) {
            this.iYu.seekTo(this.iYw.getCurrentPosition());
        }
    }

    public void cke() {
        if (this.iYu != null) {
            this.iYu.Aw(this.iYw.getCurrentPosition());
        }
    }

    public void ckf() {
        if (this.iYu != null) {
            this.iYu.ckk();
        }
    }

    public void ckg() {
        if (this.iYu != null) {
            this.iYu.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.dBW.onChangeSkinType(i);
        this.dBW.setDiverColor(i == 1 ? this.mResources.getColor(d.C0277d.cp_cont_b_1) : this.mResources.getColor(d.C0277d.cp_cont_b));
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
        if (this.iYw != null) {
            this.iYw.onChangeSkinType(eVar, i);
        }
        if (this.iYx != null) {
            this.iYx.onChangeSkinType(eVar, i);
        }
    }

    private void aBB() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(d.j.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        al.j(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(d.j.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iYw.bVa();
                if (a.this.iXm != null) {
                    a.this.iXm.cjm();
                }
            }
        }), d.C0277d.cp_cont_f);
    }

    public String getText() {
        return this.iYw.getText();
    }

    public int getCurrentPosition() {
        if (this.iYu == null) {
            return 0;
        }
        return this.iYu.getCurrentPosition();
    }

    public void showDialog() {
        if (this.iYv == null) {
            String[] strArr = {getPageContext().getString(d.j.save), getPageContext().getString(d.j.not_save)};
            this.iYv = new g(getPageContext());
            this.iYv.setTitle(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title));
            this.iYv.a(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title), strArr, this.bFF);
        }
        this.iYv.showDialog();
    }

    public void ed(String str, String str2) {
        this.iYx.ed(str, str2);
    }

    public void cjr() {
        if (this.iXm != null) {
            this.iXm.cjr();
        }
    }

    public String ckh() {
        return this.iYx.ckh();
    }

    public String cki() {
        return this.iYx.cki();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean ckj() {
        return this.iYx.ckj();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.iYw != null) {
            this.iYw.release();
        }
        if (this.iYu != null) {
            this.iYu.stopPlayback();
        }
    }

    public void av(Intent intent) {
        this.iYx.av(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && ckc() != null) {
            ckc().setGenMaskCoverListener(bVar);
        }
    }
}
