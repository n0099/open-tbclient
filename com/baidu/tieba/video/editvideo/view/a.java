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
    private MediaPlayer bTh;
    private FragmentTabWidget crk;
    private h hca;
    private com.baidu.tieba.video.editvideo.a hqL;
    private MaskVideoView hrW;
    private com.baidu.tbadk.core.dialog.b hrX;
    private b hrY;
    private d hrZ;
    private c hsa;
    private FrameLayout hsb;
    private b.InterfaceC0097b hsc;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.hsc = new b.InterfaceC0097b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.hqL != null) {
                            a.this.hqL.bBn();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.hqL != null) {
                            a.this.hqL.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.hqL = aVar;
        this.mRootView = view;
        this.hca = hVar;
        this.mResources = view.getResources();
        this.hrY = new b(this.mContext, this);
        this.hrZ = new d(this.mContext, this, this.hca);
        this.hsa = new c(this.mContext, this);
        this.hrY.cS(this.mRootView);
        this.hrZ.cS(this.mRootView);
        this.hsa.cS(this.mRootView);
        initView();
        bBY();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.hrW = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.hrW.setPreserveEGLContextOnPause(true);
        this.hrW.setZOrderMediaOverlay(true);
        this.hrW.setPostMonitorManager(this.hca);
        this.hsb = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.hsb.addView(this.hrY.getRootView());
        this.crk = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        awO();
        abD();
        this.hsb.addView(this.hrZ.getRootView());
        this.hsb.addView(this.hsa.getRootView());
        this.hrZ.getRootView().setVisibility(8);
        this.hsa.getRootView().setVisibility(8);
    }

    private boolean bBX() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void abD() {
        String[] stringArray = this.mResources.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0141d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(d.e.fontsize34));
            this.crk.addView(fragmentTabIndicator, i);
        }
        if (!bBX() && this.crk.getChildAt(1) != null) {
            this.crk.getChildAt(1).setVisibility(8);
        }
        this.crk.setDiverColor(this.mResources.getColor(d.C0141d.cp_cont_b));
        this.crk.a(this.mCurrentTabIndex, true, false);
        this.crk.setBackGroundDrawableResId(d.C0141d.cp_bg_line_d);
        this.crk.setDviderRectWidth(l.t(this.mContext.getPageActivity(), d.e.ds64));
        this.crk.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void u(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.hrY.getRootView().setVisibility(0);
                            a.this.hrZ.getRootView().setVisibility(8);
                            a.this.hsa.getRootView().setVisibility(8);
                            a.this.hrY.nq(true);
                            a.this.hrZ.nq(false);
                            a.this.hsa.nq(false);
                            break;
                        case 1:
                            a.this.hsa.getRootView().setVisibility(0);
                            a.this.hrZ.getRootView().setVisibility(8);
                            a.this.hrY.getRootView().setVisibility(8);
                            a.this.hrY.nq(false);
                            if (TextUtils.isEmpty(a.this.hrZ.bCf())) {
                                a.this.hrZ.nq(false);
                            } else {
                                a.this.hrZ.nq(true);
                            }
                            a.this.hsa.nq(true);
                            break;
                        case 2:
                            a.this.hrZ.getRootView().setVisibility(0);
                            a.this.hrY.getRootView().setVisibility(8);
                            a.this.hsa.getRootView().setVisibility(8);
                            a.this.hrY.nq(false);
                            a.this.hrZ.nq(true);
                            a.this.hsa.nq(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.crk.a(a.this.mCurrentTabIndex, true, true);
                    a.this.bBY();
                    a.this.bBZ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBY() {
        ak akVar = new ak("c12424");
        akVar.s("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBZ() {
        if (this.mCurrentTabIndex == 0) {
            bCd();
            bCb();
            return;
        }
        replay();
    }

    public void replay() {
        bCd();
        this.hrW.start();
        this.hrW.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bTh != null) {
            this.mIsMute = z;
            if (z) {
                this.bTh.setVolume(0.0f, 0.0f);
            } else {
                this.bTh.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bCd();
        this.hrY.onPause();
        this.hrZ.onPause();
        this.hsa.onPause();
    }

    public void onResume() {
        this.hrW.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.hrW.bCj();
        }
        this.hrY.onResume();
        this.hrZ.onResume();
        this.hsa.onResume();
    }

    public MaskVideoView bCa() {
        return this.hrW;
    }

    public Bitmap p(Bitmap bitmap) {
        return this.hrY.p(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.hrZ.setMusicData(list);
    }

    public void dI(List<PendantData> list) {
        this.hrY.dI(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.hsa != null) {
            this.hsa.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hrY.setData(str);
                this.hrW.setVideoPath(str);
                this.hrW.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bTh = mediaPlayer;
                        if (a.this.mIsMute) {
                            a.this.bTh.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bTh.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.hrY.bCm();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.hrW.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.hrW.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.hrW.seekTo(a.this.hrY.getCurrentPosition());
                    }
                });
                this.hrW.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.hrZ.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bCb() {
        if (this.hrW != null) {
            this.hrW.seekTo(this.hrY.getCurrentPosition());
        }
    }

    public void bCc() {
        if (this.hrW != null) {
            this.hrW.wM(this.hrY.getCurrentPosition());
        }
    }

    public void bCd() {
        if (this.hrW != null) {
            this.hrW.bCi();
        }
    }

    public void bCe() {
        if (this.hrW != null) {
            this.hrW.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.crk.onChangeSkinType(i);
        this.crk.setDiverColor(i == 1 ? this.mResources.getColor(d.C0141d.cp_cont_b_1) : this.mResources.getColor(d.C0141d.cp_cont_b));
        aj.t(this.mRootView, d.C0141d.cp_bg_line_d);
        if (this.hrY != null) {
            this.hrY.onChangeSkinType(eVar, i);
        }
        if (this.hrZ != null) {
            this.hrZ.onChangeSkinType(eVar, i);
        }
    }

    private void awO() {
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
                a.this.hrY.bmJ();
                if (a.this.hqL != null) {
                    a.this.hqL.bBk();
                }
            }
        }), d.C0141d.cp_cont_f);
    }

    public String getText() {
        return this.hrY.getText();
    }

    public int getCurrentPosition() {
        if (this.hrW == null) {
            return 0;
        }
        return this.hrW.getCurrentPosition();
    }

    public void showDialog() {
        if (this.hrX == null) {
            String[] strArr = {getPageContext().getString(d.j.save), getPageContext().getString(d.j.not_save), getPageContext().getString(d.j.cancel)};
            this.hrX = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hrX.ff(b.a.aRB);
            this.hrX.fh(17);
            this.hrX.dl(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title));
            this.hrX.a(strArr, this.hsc);
            this.hrX.d(getPageContext());
            TextView titleView = this.hrX.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(d.e.fontsize24));
                aj.r(titleView, d.C0141d.cp_cont_d);
            }
        }
        this.hrX.AY();
    }

    public void ck(String str, String str2) {
        this.hrZ.ck(str, str2);
    }

    public void bBp() {
        if (this.hqL != null) {
            this.hqL.bBp();
        }
    }

    public String bCf() {
        return this.hrZ.bCf();
    }

    public String bCg() {
        return this.hrZ.bCg();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bCh() {
        return this.hrZ.bCh();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.hrY != null) {
            this.hrY.release();
        }
        if (this.hrW != null) {
            this.hrW.stopPlayback();
        }
    }

    public void ab(Intent intent) {
        this.hrZ.ab(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bCa() != null) {
            bCa().setGenMaskCoverListener(bVar);
        }
    }
}
