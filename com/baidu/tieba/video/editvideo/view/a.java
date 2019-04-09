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
    private i.c bFI;
    private MediaPlayer bsq;
    private FragmentTabWidget dBn;
    private h iGY;
    private com.baidu.tieba.video.editvideo.a iXb;
    private MaskVideoView iYj;
    private g iYk;
    private b iYl;
    private d iYm;
    private c iYn;
    private FrameLayout iYo;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.bFI = new i.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.iXb != null) {
                            a.this.iXb.cjn();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.iXb != null) {
                            a.this.iXb.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.iYk != null && a.this.iYk.isShowing() && a.this.getPageContext() != null) {
                    a.this.iYk.dismiss();
                }
            }
        };
        this.iXb = aVar;
        this.mRootView = view;
        this.iGY = hVar;
        this.mResources = view.getResources();
        this.iYl = new b(this.mContext, this);
        this.iYm = new d(this.mContext, this, this.iGY);
        this.iYn = new c(this.mContext, this);
        this.iYl.cK(this.mRootView);
        this.iYm.cK(this.mRootView);
        this.iYn.cK(this.mRootView);
        initView();
        cjY();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.iYj = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.iYj.setPreserveEGLContextOnPause(true);
        this.iYj.setZOrderMediaOverlay(true);
        this.iYj.setPostMonitorManager(this.iGY);
        this.iYo = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.iYo.addView(this.iYl.getRootView());
        this.dBn = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        aBy();
        aHs();
        this.iYo.addView(this.iYm.getRootView());
        this.iYo.addView(this.iYn.getRootView());
        this.iYm.getRootView().setVisibility(8);
        this.iYn.getRootView().setVisibility(8);
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
            this.dBn.addView(fragmentTabIndicator, i);
        }
        if (!cjX() && this.dBn.getChildAt(1) != null) {
            this.dBn.getChildAt(1).setVisibility(8);
        }
        this.dBn.setDiverColor(this.mResources.getColor(d.C0277d.cp_cont_b));
        this.dBn.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.dBn.setBackGroundDrawableResId(d.C0277d.cp_bg_line_d);
        this.dBn.setDviderRectWidth(l.h(this.mContext.getPageActivity(), d.e.ds64));
        this.dBn.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.iYl.getRootView().setVisibility(0);
                            a.this.iYm.getRootView().setVisibility(8);
                            a.this.iYn.getRootView().setVisibility(8);
                            a.this.iYl.qB(true);
                            a.this.iYm.qB(false);
                            a.this.iYn.qB(false);
                            break;
                        case 1:
                            a.this.iYn.getRootView().setVisibility(0);
                            a.this.iYm.getRootView().setVisibility(8);
                            a.this.iYl.getRootView().setVisibility(8);
                            a.this.iYl.qB(false);
                            if (TextUtils.isEmpty(a.this.iYm.ckf())) {
                                a.this.iYm.qB(false);
                            } else {
                                a.this.iYm.qB(true);
                            }
                            a.this.iYn.qB(true);
                            break;
                        case 2:
                            a.this.iYm.getRootView().setVisibility(0);
                            a.this.iYl.getRootView().setVisibility(8);
                            a.this.iYn.getRootView().setVisibility(8);
                            a.this.iYl.qB(false);
                            a.this.iYm.qB(true);
                            a.this.iYn.qB(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.dBn.setCurrentTab(a.this.mCurrentTabIndex, true, true);
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
        this.iYj.start();
        this.iYj.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bsq != null) {
            this.mIsMute = z;
            if (z) {
                this.bsq.setVolume(0.0f, 0.0f);
            } else {
                this.bsq.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        ckd();
        this.iYl.onPause();
        this.iYm.onPause();
        this.iYn.onPause();
    }

    public void onResume() {
        this.iYj.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.iYj.ckj();
        }
        this.iYl.onResume();
        this.iYm.onResume();
        this.iYn.onResume();
    }

    public MaskVideoView cka() {
        return this.iYj;
    }

    public Bitmap A(Bitmap bitmap) {
        return this.iYl.A(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.iYm.setMusicData(list);
    }

    public void ec(List<PendantData> list) {
        this.iYl.ec(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.iYn != null) {
            this.iYn.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.iYl.setData(str);
                this.iYj.setVideoPath(str);
                this.iYj.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bsq = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.bsq.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bsq.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.iYl.ckm();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.iYj.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.iYj.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.iYj.seekTo(a.this.iYl.getCurrentPosition());
                    }
                });
                this.iYj.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.iYm.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void ckb() {
        if (this.iYj != null) {
            this.iYj.seekTo(this.iYl.getCurrentPosition());
        }
    }

    public void ckc() {
        if (this.iYj != null) {
            this.iYj.As(this.iYl.getCurrentPosition());
        }
    }

    public void ckd() {
        if (this.iYj != null) {
            this.iYj.cki();
        }
    }

    public void cke() {
        if (this.iYj != null) {
            this.iYj.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.dBn.onChangeSkinType(i);
        this.dBn.setDiverColor(i == 1 ? this.mResources.getColor(d.C0277d.cp_cont_b_1) : this.mResources.getColor(d.C0277d.cp_cont_b));
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
        if (this.iYl != null) {
            this.iYl.onChangeSkinType(eVar, i);
        }
        if (this.iYm != null) {
            this.iYm.onChangeSkinType(eVar, i);
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
                a.this.iYl.bUW();
                if (a.this.iXb != null) {
                    a.this.iXb.cjk();
                }
            }
        }), d.C0277d.cp_cont_f);
    }

    public String getText() {
        return this.iYl.getText();
    }

    public int getCurrentPosition() {
        if (this.iYj == null) {
            return 0;
        }
        return this.iYj.getCurrentPosition();
    }

    public void showDialog() {
        if (this.iYk == null) {
            String[] strArr = {getPageContext().getString(d.j.save), getPageContext().getString(d.j.not_save)};
            this.iYk = new g(getPageContext());
            this.iYk.setTitle(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title));
            this.iYk.a(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title), strArr, this.bFI);
        }
        this.iYk.showDialog();
    }

    public void ef(String str, String str2) {
        this.iYm.ef(str, str2);
    }

    public void cjp() {
        if (this.iXb != null) {
            this.iXb.cjp();
        }
    }

    public String ckf() {
        return this.iYm.ckf();
    }

    public String ckg() {
        return this.iYm.ckg();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean ckh() {
        return this.iYm.ckh();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.iYl != null) {
            this.iYl.release();
        }
        if (this.iYj != null) {
            this.iYj.stopPlayback();
        }
    }

    public void av(Intent intent) {
        this.iYm.av(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && cka() != null) {
            cka().setGenMaskCoverListener(bVar);
        }
    }
}
