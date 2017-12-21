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
    private MediaPlayer bdk;
    private FragmentTabWidget byX;
    private h gCU;
    private com.baidu.tieba.video.editvideo.a gSm;
    private c gTA;
    private FrameLayout gTB;
    private b.InterfaceC0060b gTC;
    private MaskVideoView gTw;
    private com.baidu.tbadk.core.dialog.b gTx;
    private b gTy;
    private d gTz;
    private Resources gan;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.gTC = new b.InterfaceC0060b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0060b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.gSm != null) {
                            a.this.gSm.bBD();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.gSm != null) {
                            a.this.gSm.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.gSm = aVar;
        this.mRootView = view;
        this.gCU = hVar;
        this.gan = view.getResources();
        this.gTy = new b(this.mContext, this);
        this.gTz = new d(this.mContext, this, this.gCU);
        this.gTA = new c(this.mContext, this);
        this.gTy.bM(this.mRootView);
        this.gTz.bM(this.mRootView);
        this.gTA.bM(this.mRootView);
        initView();
        bCp();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.gTw = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.gTw.setPreserveEGLContextOnPause(true);
        this.gTw.setZOrderMediaOverlay(true);
        this.gTw.setPostMonitorManager(this.gCU);
        this.gTB = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.gTB.addView(this.gTy.getRootView());
        this.byX = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        anb();
        SZ();
        this.gTB.addView(this.gTz.getRootView());
        this.gTB.addView(this.gTA.getRootView());
        this.gTz.getRootView().setVisibility(8);
        this.gTA.getRootView().setVisibility(8);
    }

    private boolean bCo() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void SZ() {
        String[] stringArray = this.gan.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0095d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.gan.getDimension(d.e.fontsize34));
            this.byX.addView(fragmentTabIndicator, i);
        }
        if (!bCo() && this.byX.getChildAt(1) != null) {
            this.byX.getChildAt(1).setVisibility(8);
        }
        this.byX.setDiverColor(this.gan.getColor(d.C0095d.cp_cont_b));
        this.byX.a(this.mCurrentTabIndex, true, false);
        this.byX.setBackGroundDrawableResId(d.C0095d.cp_bg_line_d);
        this.byX.setDviderRectWidth(l.f(this.mContext.getPageActivity(), d.e.ds64));
        this.byX.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void e(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.gTy.getRootView().setVisibility(0);
                            a.this.gTz.getRootView().setVisibility(8);
                            a.this.gTA.getRootView().setVisibility(8);
                            a.this.gTy.nF(true);
                            a.this.gTz.nF(false);
                            a.this.gTA.nF(false);
                            break;
                        case 1:
                            a.this.gTA.getRootView().setVisibility(0);
                            a.this.gTz.getRootView().setVisibility(8);
                            a.this.gTy.getRootView().setVisibility(8);
                            a.this.gTy.nF(false);
                            a.this.gTz.nF(false);
                            a.this.gTA.nF(true);
                            break;
                        case 2:
                            a.this.gTz.getRootView().setVisibility(0);
                            a.this.gTy.getRootView().setVisibility(8);
                            a.this.gTA.getRootView().setVisibility(8);
                            a.this.gTy.nF(false);
                            a.this.gTz.nF(true);
                            a.this.gTA.nF(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.byX.a(a.this.mCurrentTabIndex, true, true);
                    a.this.bCp();
                    a.this.bCq();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCp() {
        ak akVar = new ak("c12424");
        akVar.r("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCq() {
        if (this.mCurrentTabIndex == 0) {
            bCu();
            bCs();
            return;
        }
        replay();
    }

    public void replay() {
        bCu();
        this.gTw.start();
        this.gTw.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bdk != null) {
            this.mIsMute = z;
            if (z) {
                this.bdk.setVolume(0.0f, 0.0f);
            } else {
                this.bdk.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bCu();
        this.gTy.onPause();
        this.gTz.onPause();
        this.gTA.onPause();
    }

    public void onResume() {
        this.gTw.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.gTw.bCA();
        }
        this.gTy.onResume();
        this.gTz.onResume();
        this.gTA.onResume();
    }

    public MaskVideoView bCr() {
        return this.gTw;
    }

    public Bitmap j(Bitmap bitmap) {
        return this.gTy.j(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.gTz.setMusicData(list);
    }

    public void dN(List<PendantData> list) {
        this.gTy.dN(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.gTA != null) {
            this.gTA.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.gTy.setData(str);
                this.gTw.setVideoPath(str);
                this.gTw.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bdk = mediaPlayer;
                        if (a.this.mIsMute) {
                            a.this.bdk.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bdk.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.gTy.bCD();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.gTw.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.gTw.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.gTw.seekTo(a.this.gTy.getCurrentPosition());
                    }
                });
                this.gTw.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.gTz.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bCs() {
        if (this.gTw != null) {
            this.gTw.seekTo(this.gTy.getCurrentPosition());
        }
    }

    public void bCt() {
        if (this.gTw != null) {
            this.gTw.vu(this.gTy.getCurrentPosition());
        }
    }

    public void bCu() {
        if (this.gTw != null) {
            this.gTw.bCz();
        }
    }

    public void bCv() {
        if (this.gTw != null) {
            this.gTw.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.byX.onChangeSkinType(i);
        this.byX.setDiverColor(i == 1 ? this.gan.getColor(d.C0095d.cp_cont_b_1) : this.gan.getColor(d.C0095d.cp_cont_b));
        aj.k(this.mRootView, d.C0095d.cp_bg_line_d);
        if (this.gTy != null) {
            this.gTy.onChangeSkinType(eVar, i);
        }
        if (this.gTz != null) {
            this.gTz.onChangeSkinType(eVar, i);
        }
    }

    private void anb() {
        this.mNavigationBar.setCenterTextTitle(this.gan.getString(d.j.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        aj.i(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gan.getString(d.j.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gTy.bkv();
                if (a.this.gSm != null) {
                    a.this.gSm.bBA();
                }
            }
        }), d.C0095d.cp_cont_f);
    }

    public String getText() {
        return this.gTy.getText();
    }

    public int getCurrentPosition() {
        if (this.gTw == null) {
            return 0;
        }
        return this.gTw.getCurrentPosition();
    }

    public void showDialog() {
        if (this.gTx == null) {
            String[] strArr = {getPageContext().getString(d.j.save), getPageContext().getString(d.j.not_save), getPageContext().getString(d.j.cancel)};
            this.gTx = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.gTx.ch(b.a.abS);
            this.gTx.cj(17);
            this.gTx.cT(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title));
            this.gTx.a(strArr, this.gTC);
            this.gTx.d(getPageContext());
            TextView tk = this.gTx.tk();
            if (tk != null) {
                tk.setGravity(17);
                tk.setTextSize(0, this.gan.getDimensionPixelSize(d.e.fontsize24));
                aj.i(tk, d.C0095d.cp_cont_d);
            }
        }
        this.gTx.tl();
    }

    public void co(String str, String str2) {
        this.gTz.co(str, str2);
    }

    public void bBF() {
        if (this.gSm != null) {
            this.gSm.bBF();
        }
    }

    public String bCw() {
        return this.gTz.bCw();
    }

    public String bCx() {
        return this.gTz.bCx();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bCy() {
        return this.gTz.bCy();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.gTy != null) {
            this.gTy.release();
        }
        if (this.gTw != null) {
            this.gTw.stopPlayback();
        }
    }

    public void ad(Intent intent) {
        this.gTz.ad(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bCr() != null) {
            bCr().setGenMaskCoverListener(bVar);
        }
    }
}
