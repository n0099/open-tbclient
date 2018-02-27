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
    private MediaPlayer bTe;
    private FragmentTabWidget crh;
    private h hbC;
    private com.baidu.tieba.video.editvideo.a hqn;
    private b hrA;
    private d hrB;
    private c hrC;
    private FrameLayout hrD;
    private b.InterfaceC0097b hrE;
    private MaskVideoView hry;
    private com.baidu.tbadk.core.dialog.b hrz;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.hrE = new b.InterfaceC0097b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.hqn != null) {
                            a.this.hqn.bBi();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.hqn != null) {
                            a.this.hqn.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.hqn = aVar;
        this.mRootView = view;
        this.hbC = hVar;
        this.mResources = view.getResources();
        this.hrA = new b(this.mContext, this);
        this.hrB = new d(this.mContext, this, this.hbC);
        this.hrC = new c(this.mContext, this);
        this.hrA.cS(this.mRootView);
        this.hrB.cS(this.mRootView);
        this.hrC.cS(this.mRootView);
        initView();
        bBT();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.hry = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.hry.setPreserveEGLContextOnPause(true);
        this.hry.setZOrderMediaOverlay(true);
        this.hry.setPostMonitorManager(this.hbC);
        this.hrD = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.hrD.addView(this.hrA.getRootView());
        this.crh = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        awM();
        abC();
        this.hrD.addView(this.hrB.getRootView());
        this.hrD.addView(this.hrC.getRootView());
        this.hrB.getRootView().setVisibility(8);
        this.hrC.getRootView().setVisibility(8);
    }

    private boolean bBS() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void abC() {
        String[] stringArray = this.mResources.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0141d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(d.e.fontsize34));
            this.crh.addView(fragmentTabIndicator, i);
        }
        if (!bBS() && this.crh.getChildAt(1) != null) {
            this.crh.getChildAt(1).setVisibility(8);
        }
        this.crh.setDiverColor(this.mResources.getColor(d.C0141d.cp_cont_b));
        this.crh.a(this.mCurrentTabIndex, true, false);
        this.crh.setBackGroundDrawableResId(d.C0141d.cp_bg_line_d);
        this.crh.setDviderRectWidth(l.t(this.mContext.getPageActivity(), d.e.ds64));
        this.crh.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void u(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.hrA.getRootView().setVisibility(0);
                            a.this.hrB.getRootView().setVisibility(8);
                            a.this.hrC.getRootView().setVisibility(8);
                            a.this.hrA.nl(true);
                            a.this.hrB.nl(false);
                            a.this.hrC.nl(false);
                            break;
                        case 1:
                            a.this.hrC.getRootView().setVisibility(0);
                            a.this.hrB.getRootView().setVisibility(8);
                            a.this.hrA.getRootView().setVisibility(8);
                            a.this.hrA.nl(false);
                            if (TextUtils.isEmpty(a.this.hrB.bCa())) {
                                a.this.hrB.nl(false);
                            } else {
                                a.this.hrB.nl(true);
                            }
                            a.this.hrC.nl(true);
                            break;
                        case 2:
                            a.this.hrB.getRootView().setVisibility(0);
                            a.this.hrA.getRootView().setVisibility(8);
                            a.this.hrC.getRootView().setVisibility(8);
                            a.this.hrA.nl(false);
                            a.this.hrB.nl(true);
                            a.this.hrC.nl(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.crh.a(a.this.mCurrentTabIndex, true, true);
                    a.this.bBT();
                    a.this.bBU();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBT() {
        ak akVar = new ak("c12424");
        akVar.s("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBU() {
        if (this.mCurrentTabIndex == 0) {
            bBY();
            bBW();
            return;
        }
        replay();
    }

    public void replay() {
        bBY();
        this.hry.start();
        this.hry.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bTe != null) {
            this.mIsMute = z;
            if (z) {
                this.bTe.setVolume(0.0f, 0.0f);
            } else {
                this.bTe.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bBY();
        this.hrA.onPause();
        this.hrB.onPause();
        this.hrC.onPause();
    }

    public void onResume() {
        this.hry.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.hry.bCe();
        }
        this.hrA.onResume();
        this.hrB.onResume();
        this.hrC.onResume();
    }

    public MaskVideoView bBV() {
        return this.hry;
    }

    public Bitmap p(Bitmap bitmap) {
        return this.hrA.p(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.hrB.setMusicData(list);
    }

    public void dI(List<PendantData> list) {
        this.hrA.dI(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.hrC != null) {
            this.hrC.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hrA.setData(str);
                this.hry.setVideoPath(str);
                this.hry.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bTe = mediaPlayer;
                        if (a.this.mIsMute) {
                            a.this.bTe.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bTe.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.hrA.bCh();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.hry.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.hry.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.hry.seekTo(a.this.hrA.getCurrentPosition());
                    }
                });
                this.hry.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.hrB.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bBW() {
        if (this.hry != null) {
            this.hry.seekTo(this.hrA.getCurrentPosition());
        }
    }

    public void bBX() {
        if (this.hry != null) {
            this.hry.wM(this.hrA.getCurrentPosition());
        }
    }

    public void bBY() {
        if (this.hry != null) {
            this.hry.bCd();
        }
    }

    public void bBZ() {
        if (this.hry != null) {
            this.hry.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.crh.onChangeSkinType(i);
        this.crh.setDiverColor(i == 1 ? this.mResources.getColor(d.C0141d.cp_cont_b_1) : this.mResources.getColor(d.C0141d.cp_cont_b));
        aj.t(this.mRootView, d.C0141d.cp_bg_line_d);
        if (this.hrA != null) {
            this.hrA.onChangeSkinType(eVar, i);
        }
        if (this.hrB != null) {
            this.hrB.onChangeSkinType(eVar, i);
        }
    }

    private void awM() {
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
                a.this.hrA.bmI();
                if (a.this.hqn != null) {
                    a.this.hqn.bBf();
                }
            }
        }), d.C0141d.cp_cont_f);
    }

    public String getText() {
        return this.hrA.getText();
    }

    public int getCurrentPosition() {
        if (this.hry == null) {
            return 0;
        }
        return this.hry.getCurrentPosition();
    }

    public void showDialog() {
        if (this.hrz == null) {
            String[] strArr = {getPageContext().getString(d.j.save), getPageContext().getString(d.j.not_save), getPageContext().getString(d.j.cancel)};
            this.hrz = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hrz.ff(b.a.aRz);
            this.hrz.fh(17);
            this.hrz.dl(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title));
            this.hrz.a(strArr, this.hrE);
            this.hrz.d(getPageContext());
            TextView titleView = this.hrz.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(d.e.fontsize24));
                aj.r(titleView, d.C0141d.cp_cont_d);
            }
        }
        this.hrz.AX();
    }

    public void ck(String str, String str2) {
        this.hrB.ck(str, str2);
    }

    public void bBk() {
        if (this.hqn != null) {
            this.hqn.bBk();
        }
    }

    public String bCa() {
        return this.hrB.bCa();
    }

    public String bCb() {
        return this.hrB.bCb();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bCc() {
        return this.hrB.bCc();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.hrA != null) {
            this.hrA.release();
        }
        if (this.hry != null) {
            this.hry.stopPlayback();
        }
    }

    public void ab(Intent intent) {
        this.hrB.ab(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bBV() != null) {
            bBV().setGenMaskCoverListener(bVar);
        }
    }
}
