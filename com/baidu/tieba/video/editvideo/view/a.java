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
    private MediaPlayer bTq;
    private FragmentTabWidget crt;
    private h hbR;
    private com.baidu.tieba.video.editvideo.a hqA;
    private MaskVideoView hrL;
    private com.baidu.tbadk.core.dialog.b hrM;
    private b hrN;
    private d hrO;
    private c hrP;
    private FrameLayout hrQ;
    private b.InterfaceC0096b hrR;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.hrR = new b.InterfaceC0096b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.hqA != null) {
                            a.this.hqA.bBj();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.hqA != null) {
                            a.this.hqA.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.hqA = aVar;
        this.mRootView = view;
        this.hbR = hVar;
        this.mResources = view.getResources();
        this.hrN = new b(this.mContext, this);
        this.hrO = new d(this.mContext, this, this.hbR);
        this.hrP = new c(this.mContext, this);
        this.hrN.cS(this.mRootView);
        this.hrO.cS(this.mRootView);
        this.hrP.cS(this.mRootView);
        initView();
        bBU();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.hrL = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.hrL.setPreserveEGLContextOnPause(true);
        this.hrL.setZOrderMediaOverlay(true);
        this.hrL.setPostMonitorManager(this.hbR);
        this.hrQ = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.hrQ.addView(this.hrN.getRootView());
        this.crt = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        awN();
        abD();
        this.hrQ.addView(this.hrO.getRootView());
        this.hrQ.addView(this.hrP.getRootView());
        this.hrO.getRootView().setVisibility(8);
        this.hrP.getRootView().setVisibility(8);
    }

    private boolean bBT() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void abD() {
        String[] stringArray = this.mResources.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0140d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(d.e.fontsize34));
            this.crt.addView(fragmentTabIndicator, i);
        }
        if (!bBT() && this.crt.getChildAt(1) != null) {
            this.crt.getChildAt(1).setVisibility(8);
        }
        this.crt.setDiverColor(this.mResources.getColor(d.C0140d.cp_cont_b));
        this.crt.a(this.mCurrentTabIndex, true, false);
        this.crt.setBackGroundDrawableResId(d.C0140d.cp_bg_line_d);
        this.crt.setDviderRectWidth(l.t(this.mContext.getPageActivity(), d.e.ds64));
        this.crt.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void u(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.hrN.getRootView().setVisibility(0);
                            a.this.hrO.getRootView().setVisibility(8);
                            a.this.hrP.getRootView().setVisibility(8);
                            a.this.hrN.nl(true);
                            a.this.hrO.nl(false);
                            a.this.hrP.nl(false);
                            break;
                        case 1:
                            a.this.hrP.getRootView().setVisibility(0);
                            a.this.hrO.getRootView().setVisibility(8);
                            a.this.hrN.getRootView().setVisibility(8);
                            a.this.hrN.nl(false);
                            if (TextUtils.isEmpty(a.this.hrO.bCb())) {
                                a.this.hrO.nl(false);
                            } else {
                                a.this.hrO.nl(true);
                            }
                            a.this.hrP.nl(true);
                            break;
                        case 2:
                            a.this.hrO.getRootView().setVisibility(0);
                            a.this.hrN.getRootView().setVisibility(8);
                            a.this.hrP.getRootView().setVisibility(8);
                            a.this.hrN.nl(false);
                            a.this.hrO.nl(true);
                            a.this.hrP.nl(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.crt.a(a.this.mCurrentTabIndex, true, true);
                    a.this.bBU();
                    a.this.bBV();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBU() {
        ak akVar = new ak("c12424");
        akVar.s("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBV() {
        if (this.mCurrentTabIndex == 0) {
            bBZ();
            bBX();
            return;
        }
        replay();
    }

    public void replay() {
        bBZ();
        this.hrL.start();
        this.hrL.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bTq != null) {
            this.mIsMute = z;
            if (z) {
                this.bTq.setVolume(0.0f, 0.0f);
            } else {
                this.bTq.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bBZ();
        this.hrN.onPause();
        this.hrO.onPause();
        this.hrP.onPause();
    }

    public void onResume() {
        this.hrL.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.hrL.bCf();
        }
        this.hrN.onResume();
        this.hrO.onResume();
        this.hrP.onResume();
    }

    public MaskVideoView bBW() {
        return this.hrL;
    }

    public Bitmap p(Bitmap bitmap) {
        return this.hrN.p(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.hrO.setMusicData(list);
    }

    public void dI(List<PendantData> list) {
        this.hrN.dI(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.hrP != null) {
            this.hrP.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hrN.setData(str);
                this.hrL.setVideoPath(str);
                this.hrL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bTq = mediaPlayer;
                        if (a.this.mIsMute) {
                            a.this.bTq.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bTq.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.hrN.bCi();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.hrL.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.hrL.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.hrL.seekTo(a.this.hrN.getCurrentPosition());
                    }
                });
                this.hrL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.hrO.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bBX() {
        if (this.hrL != null) {
            this.hrL.seekTo(this.hrN.getCurrentPosition());
        }
    }

    public void bBY() {
        if (this.hrL != null) {
            this.hrL.wL(this.hrN.getCurrentPosition());
        }
    }

    public void bBZ() {
        if (this.hrL != null) {
            this.hrL.bCe();
        }
    }

    public void bCa() {
        if (this.hrL != null) {
            this.hrL.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.crt.onChangeSkinType(i);
        this.crt.setDiverColor(i == 1 ? this.mResources.getColor(d.C0140d.cp_cont_b_1) : this.mResources.getColor(d.C0140d.cp_cont_b));
        aj.t(this.mRootView, d.C0140d.cp_bg_line_d);
        if (this.hrN != null) {
            this.hrN.onChangeSkinType(eVar, i);
        }
        if (this.hrO != null) {
            this.hrO.onChangeSkinType(eVar, i);
        }
    }

    private void awN() {
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
                a.this.hrN.bmJ();
                if (a.this.hqA != null) {
                    a.this.hqA.bBg();
                }
            }
        }), d.C0140d.cp_cont_f);
    }

    public String getText() {
        return this.hrN.getText();
    }

    public int getCurrentPosition() {
        if (this.hrL == null) {
            return 0;
        }
        return this.hrL.getCurrentPosition();
    }

    public void showDialog() {
        if (this.hrM == null) {
            String[] strArr = {getPageContext().getString(d.j.save), getPageContext().getString(d.j.not_save), getPageContext().getString(d.j.cancel)};
            this.hrM = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hrM.ff(b.a.aRK);
            this.hrM.fh(17);
            this.hrM.dl(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title));
            this.hrM.a(strArr, this.hrR);
            this.hrM.d(getPageContext());
            TextView titleView = this.hrM.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(d.e.fontsize24));
                aj.r(titleView, d.C0140d.cp_cont_d);
            }
        }
        this.hrM.AX();
    }

    public void ck(String str, String str2) {
        this.hrO.ck(str, str2);
    }

    public void bBl() {
        if (this.hqA != null) {
            this.hqA.bBl();
        }
    }

    public String bCb() {
        return this.hrO.bCb();
    }

    public String bCc() {
        return this.hrO.bCc();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bCd() {
        return this.hrO.bCd();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.hrN != null) {
            this.hrN.release();
        }
        if (this.hrL != null) {
            this.hrL.stopPlayback();
        }
    }

    public void ab(Intent intent) {
        this.hrO.ab(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bBW() != null) {
            bBW().setGenMaskCoverListener(bVar);
        }
    }
}
