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
    private i.c bFH;
    private MediaPlayer bsp;
    private FragmentTabWidget dBm;
    private h iGX;
    private com.baidu.tieba.video.editvideo.a iXa;
    private MaskVideoView iYi;
    private g iYj;
    private b iYk;
    private d iYl;
    private c iYm;
    private FrameLayout iYn;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.bFH = new i.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.iXa != null) {
                            a.this.iXa.cjn();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.iXa != null) {
                            a.this.iXa.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.iYj != null && a.this.iYj.isShowing() && a.this.getPageContext() != null) {
                    a.this.iYj.dismiss();
                }
            }
        };
        this.iXa = aVar;
        this.mRootView = view;
        this.iGX = hVar;
        this.mResources = view.getResources();
        this.iYk = new b(this.mContext, this);
        this.iYl = new d(this.mContext, this, this.iGX);
        this.iYm = new c(this.mContext, this);
        this.iYk.cK(this.mRootView);
        this.iYl.cK(this.mRootView);
        this.iYm.cK(this.mRootView);
        initView();
        cjY();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.iYi = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.iYi.setPreserveEGLContextOnPause(true);
        this.iYi.setZOrderMediaOverlay(true);
        this.iYi.setPostMonitorManager(this.iGX);
        this.iYn = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.iYn.addView(this.iYk.getRootView());
        this.dBm = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        aBy();
        aHs();
        this.iYn.addView(this.iYl.getRootView());
        this.iYn.addView(this.iYm.getRootView());
        this.iYl.getRootView().setVisibility(8);
        this.iYm.getRootView().setVisibility(8);
    }

    private boolean cjX() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void aHs() {
        String[] stringArray = this.mResources.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0277d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(d.e.fontsize34));
            this.dBm.addView(fragmentTabIndicator, i);
        }
        if (!cjX() && this.dBm.getChildAt(1) != null) {
            this.dBm.getChildAt(1).setVisibility(8);
        }
        this.dBm.setDiverColor(this.mResources.getColor(d.C0277d.cp_cont_b));
        this.dBm.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.dBm.setBackGroundDrawableResId(d.C0277d.cp_bg_line_d);
        this.dBm.setDviderRectWidth(l.h(this.mContext.getPageActivity(), d.e.ds64));
        this.dBm.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.iYk.getRootView().setVisibility(0);
                            a.this.iYl.getRootView().setVisibility(8);
                            a.this.iYm.getRootView().setVisibility(8);
                            a.this.iYk.qB(true);
                            a.this.iYl.qB(false);
                            a.this.iYm.qB(false);
                            break;
                        case 1:
                            a.this.iYm.getRootView().setVisibility(0);
                            a.this.iYl.getRootView().setVisibility(8);
                            a.this.iYk.getRootView().setVisibility(8);
                            a.this.iYk.qB(false);
                            if (TextUtils.isEmpty(a.this.iYl.ckf())) {
                                a.this.iYl.qB(false);
                            } else {
                                a.this.iYl.qB(true);
                            }
                            a.this.iYm.qB(true);
                            break;
                        case 2:
                            a.this.iYl.getRootView().setVisibility(0);
                            a.this.iYk.getRootView().setVisibility(8);
                            a.this.iYm.getRootView().setVisibility(8);
                            a.this.iYk.qB(false);
                            a.this.iYl.qB(true);
                            a.this.iYm.qB(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.dBm.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.cjY();
                    a.this.cjZ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjY() {
        am amVar = new am("c12424");
        amVar.T("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjZ() {
        if (this.mCurrentTabIndex == 0) {
            ckd();
            ckb();
            return;
        }
        replay();
    }

    public void replay() {
        ckd();
        this.iYi.start();
        this.iYi.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bsp != null) {
            this.mIsMute = z;
            if (z) {
                this.bsp.setVolume(0.0f, 0.0f);
            } else {
                this.bsp.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        ckd();
        this.iYk.onPause();
        this.iYl.onPause();
        this.iYm.onPause();
    }

    public void onResume() {
        this.iYi.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.iYi.ckj();
        }
        this.iYk.onResume();
        this.iYl.onResume();
        this.iYm.onResume();
    }

    public MaskVideoView cka() {
        return this.iYi;
    }

    public Bitmap A(Bitmap bitmap) {
        return this.iYk.A(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.iYl.setMusicData(list);
    }

    public void ec(List<PendantData> list) {
        this.iYk.ec(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.iYm != null) {
            this.iYm.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.iYk.setData(str);
                this.iYi.setVideoPath(str);
                this.iYi.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bsp = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.bsp.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bsp.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.iYk.ckm();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.iYi.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.iYi.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.iYi.seekTo(a.this.iYk.getCurrentPosition());
                    }
                });
                this.iYi.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.iYl.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void ckb() {
        if (this.iYi != null) {
            this.iYi.seekTo(this.iYk.getCurrentPosition());
        }
    }

    public void ckc() {
        if (this.iYi != null) {
            this.iYi.As(this.iYk.getCurrentPosition());
        }
    }

    public void ckd() {
        if (this.iYi != null) {
            this.iYi.cki();
        }
    }

    public void cke() {
        if (this.iYi != null) {
            this.iYi.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.dBm.onChangeSkinType(i);
        this.dBm.setDiverColor(i == 1 ? this.mResources.getColor(d.C0277d.cp_cont_b_1) : this.mResources.getColor(d.C0277d.cp_cont_b));
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
        if (this.iYk != null) {
            this.iYk.onChangeSkinType(eVar, i);
        }
        if (this.iYl != null) {
            this.iYl.onChangeSkinType(eVar, i);
        }
    }

    private void aBy() {
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
                a.this.iYk.bUW();
                if (a.this.iXa != null) {
                    a.this.iXa.cjk();
                }
            }
        }), d.C0277d.cp_cont_f);
    }

    public String getText() {
        return this.iYk.getText();
    }

    public int getCurrentPosition() {
        if (this.iYi == null) {
            return 0;
        }
        return this.iYi.getCurrentPosition();
    }

    public void showDialog() {
        if (this.iYj == null) {
            String[] strArr = {getPageContext().getString(d.j.save), getPageContext().getString(d.j.not_save)};
            this.iYj = new g(getPageContext());
            this.iYj.setTitle(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title));
            this.iYj.a(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title), strArr, this.bFH);
        }
        this.iYj.showDialog();
    }

    public void ef(String str, String str2) {
        this.iYl.ef(str, str2);
    }

    public void cjp() {
        if (this.iXa != null) {
            this.iXa.cjp();
        }
    }

    public String ckf() {
        return this.iYl.ckf();
    }

    public String ckg() {
        return this.iYl.ckg();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean ckh() {
        return this.iYl.ckh();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.iYk != null) {
            this.iYk.release();
        }
        if (this.iYi != null) {
            this.iYi.stopPlayback();
        }
    }

    public void av(Intent intent) {
        this.iYl.av(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && cka() != null) {
            cka().setGenMaskCoverListener(bVar);
        }
    }
}
