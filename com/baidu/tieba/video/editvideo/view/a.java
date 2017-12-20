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
    private MediaPlayer bdg;
    private FragmentTabWidget byT;
    private h gCP;
    private com.baidu.tieba.video.editvideo.a gSh;
    private MaskVideoView gTr;
    private com.baidu.tbadk.core.dialog.b gTs;
    private b gTt;
    private d gTu;
    private c gTv;
    private FrameLayout gTw;
    private b.InterfaceC0061b gTx;
    private Resources gai;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.gTx = new b.InterfaceC0061b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.gSh != null) {
                            a.this.gSh.bBC();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.gSh != null) {
                            a.this.gSh.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.gSh = aVar;
        this.mRootView = view;
        this.gCP = hVar;
        this.gai = view.getResources();
        this.gTt = new b(this.mContext, this);
        this.gTu = new d(this.mContext, this, this.gCP);
        this.gTv = new c(this.mContext, this);
        this.gTt.bM(this.mRootView);
        this.gTu.bM(this.mRootView);
        this.gTv.bM(this.mRootView);
        initView();
        bCo();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.gTr = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.gTr.setPreserveEGLContextOnPause(true);
        this.gTr.setZOrderMediaOverlay(true);
        this.gTr.setPostMonitorManager(this.gCP);
        this.gTw = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.gTw.addView(this.gTt.getRootView());
        this.byT = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        ana();
        SZ();
        this.gTw.addView(this.gTu.getRootView());
        this.gTw.addView(this.gTv.getRootView());
        this.gTu.getRootView().setVisibility(8);
        this.gTv.getRootView().setVisibility(8);
    }

    private boolean bCn() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void SZ() {
        String[] stringArray = this.gai.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0096d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.gai.getDimension(d.e.fontsize34));
            this.byT.addView(fragmentTabIndicator, i);
        }
        if (!bCn() && this.byT.getChildAt(1) != null) {
            this.byT.getChildAt(1).setVisibility(8);
        }
        this.byT.setDiverColor(this.gai.getColor(d.C0096d.cp_cont_b));
        this.byT.a(this.mCurrentTabIndex, true, false);
        this.byT.setBackGroundDrawableResId(d.C0096d.cp_bg_line_d);
        this.byT.setDviderRectWidth(l.f(this.mContext.getPageActivity(), d.e.ds64));
        this.byT.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void e(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.gTt.getRootView().setVisibility(0);
                            a.this.gTu.getRootView().setVisibility(8);
                            a.this.gTv.getRootView().setVisibility(8);
                            a.this.gTt.nF(true);
                            a.this.gTu.nF(false);
                            a.this.gTv.nF(false);
                            break;
                        case 1:
                            a.this.gTv.getRootView().setVisibility(0);
                            a.this.gTu.getRootView().setVisibility(8);
                            a.this.gTt.getRootView().setVisibility(8);
                            a.this.gTt.nF(false);
                            a.this.gTu.nF(false);
                            a.this.gTv.nF(true);
                            break;
                        case 2:
                            a.this.gTu.getRootView().setVisibility(0);
                            a.this.gTt.getRootView().setVisibility(8);
                            a.this.gTv.getRootView().setVisibility(8);
                            a.this.gTt.nF(false);
                            a.this.gTu.nF(true);
                            a.this.gTv.nF(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.byT.a(a.this.mCurrentTabIndex, true, true);
                    a.this.bCo();
                    a.this.bCp();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCo() {
        ak akVar = new ak("c12424");
        akVar.r("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCp() {
        if (this.mCurrentTabIndex == 0) {
            bCt();
            bCr();
            return;
        }
        replay();
    }

    public void replay() {
        bCt();
        this.gTr.start();
        this.gTr.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bdg != null) {
            this.mIsMute = z;
            if (z) {
                this.bdg.setVolume(0.0f, 0.0f);
            } else {
                this.bdg.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bCt();
        this.gTt.onPause();
        this.gTu.onPause();
        this.gTv.onPause();
    }

    public void onResume() {
        this.gTr.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.gTr.bCz();
        }
        this.gTt.onResume();
        this.gTu.onResume();
        this.gTv.onResume();
    }

    public MaskVideoView bCq() {
        return this.gTr;
    }

    public Bitmap j(Bitmap bitmap) {
        return this.gTt.j(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.gTu.setMusicData(list);
    }

    public void dN(List<PendantData> list) {
        this.gTt.dN(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.gTv != null) {
            this.gTv.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.gTt.setData(str);
                this.gTr.setVideoPath(str);
                this.gTr.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bdg = mediaPlayer;
                        if (a.this.mIsMute) {
                            a.this.bdg.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bdg.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.gTt.bCC();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.gTr.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.gTr.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.gTr.seekTo(a.this.gTt.getCurrentPosition());
                    }
                });
                this.gTr.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.gTu.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bCr() {
        if (this.gTr != null) {
            this.gTr.seekTo(this.gTt.getCurrentPosition());
        }
    }

    public void bCs() {
        if (this.gTr != null) {
            this.gTr.vu(this.gTt.getCurrentPosition());
        }
    }

    public void bCt() {
        if (this.gTr != null) {
            this.gTr.bCy();
        }
    }

    public void bCu() {
        if (this.gTr != null) {
            this.gTr.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.byT.onChangeSkinType(i);
        this.byT.setDiverColor(i == 1 ? this.gai.getColor(d.C0096d.cp_cont_b_1) : this.gai.getColor(d.C0096d.cp_cont_b));
        aj.k(this.mRootView, d.C0096d.cp_bg_line_d);
        if (this.gTt != null) {
            this.gTt.onChangeSkinType(eVar, i);
        }
        if (this.gTu != null) {
            this.gTu.onChangeSkinType(eVar, i);
        }
    }

    private void ana() {
        this.mNavigationBar.setCenterTextTitle(this.gai.getString(d.j.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        aj.i(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gai.getString(d.j.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gTt.bku();
                if (a.this.gSh != null) {
                    a.this.gSh.bBz();
                }
            }
        }), d.C0096d.cp_cont_f);
    }

    public String getText() {
        return this.gTt.getText();
    }

    public int getCurrentPosition() {
        if (this.gTr == null) {
            return 0;
        }
        return this.gTr.getCurrentPosition();
    }

    public void showDialog() {
        if (this.gTs == null) {
            String[] strArr = {getPageContext().getString(d.j.save), getPageContext().getString(d.j.not_save), getPageContext().getString(d.j.cancel)};
            this.gTs = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.gTs.ch(b.a.abP);
            this.gTs.cj(17);
            this.gTs.cT(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title));
            this.gTs.a(strArr, this.gTx);
            this.gTs.d(getPageContext());
            TextView tk = this.gTs.tk();
            if (tk != null) {
                tk.setGravity(17);
                tk.setTextSize(0, this.gai.getDimensionPixelSize(d.e.fontsize24));
                aj.i(tk, d.C0096d.cp_cont_d);
            }
        }
        this.gTs.tl();
    }

    public void co(String str, String str2) {
        this.gTu.co(str, str2);
    }

    public void bBE() {
        if (this.gSh != null) {
            this.gSh.bBE();
        }
    }

    public String bCv() {
        return this.gTu.bCv();
    }

    public String bCw() {
        return this.gTu.bCw();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bCx() {
        return this.gTu.bCx();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.gTt != null) {
            this.gTt.release();
        }
        if (this.gTr != null) {
            this.gTr.stopPlayback();
        }
    }

    public void ad(Intent intent) {
        this.gTu.ad(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bCq() != null) {
            bCq().setGenMaskCoverListener(bVar);
        }
    }
}
