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
import com.baidu.tieba.d;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c {
    private MediaPlayer aWV;
    private FragmentTabWidget bQI;
    private h gJZ;
    private com.baidu.tieba.video.editvideo.a gYX;
    private MaskVideoView hag;
    private com.baidu.tbadk.core.dialog.b hah;
    private b hai;
    private d haj;
    private c hak;
    private FrameLayout hal;
    private b.InterfaceC0103b ham;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.ham = new b.InterfaceC0103b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.gYX != null) {
                            a.this.gYX.bBx();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.gYX != null) {
                            a.this.gYX.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.gYX = aVar;
        this.mRootView = view;
        this.gJZ = hVar;
        this.mResources = view.getResources();
        this.hai = new b(this.mContext, this);
        this.haj = new d(this.mContext, this, this.gJZ);
        this.hak = new c(this.mContext, this);
        this.hai.bB(this.mRootView);
        this.haj.bB(this.mRootView);
        this.hak.bB(this.mRootView);
        initView();
        bCi();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.hag = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.hag.setPreserveEGLContextOnPause(true);
        this.hag.setZOrderMediaOverlay(true);
        this.hag.setPostMonitorManager(this.gJZ);
        this.hal = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.hal.addView(this.hai.getRootView());
        this.bQI = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        avi();
        Zm();
        this.hal.addView(this.haj.getRootView());
        this.hal.addView(this.hak.getRootView());
        this.haj.getRootView().setVisibility(8);
        this.hak.getRootView().setVisibility(8);
    }

    private boolean bCh() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void Zm() {
        String[] stringArray = this.mResources.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0141d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(d.e.fontsize34));
            this.bQI.addView(fragmentTabIndicator, i);
        }
        if (!bCh() && this.bQI.getChildAt(1) != null) {
            this.bQI.getChildAt(1).setVisibility(8);
        }
        this.bQI.setDiverColor(this.mResources.getColor(d.C0141d.cp_cont_b));
        this.bQI.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.bQI.setBackGroundDrawableResId(d.C0141d.cp_bg_line_d);
        this.bQI.setDviderRectWidth(l.e(this.mContext.getPageActivity(), d.e.ds64));
        this.bQI.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void i(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.hai.getRootView().setVisibility(0);
                            a.this.haj.getRootView().setVisibility(8);
                            a.this.hak.getRootView().setVisibility(8);
                            a.this.hai.mZ(true);
                            a.this.haj.mZ(false);
                            a.this.hak.mZ(false);
                            break;
                        case 1:
                            a.this.hak.getRootView().setVisibility(0);
                            a.this.haj.getRootView().setVisibility(8);
                            a.this.hai.getRootView().setVisibility(8);
                            a.this.hai.mZ(false);
                            if (TextUtils.isEmpty(a.this.haj.bCp())) {
                                a.this.haj.mZ(false);
                            } else {
                                a.this.haj.mZ(true);
                            }
                            a.this.hak.mZ(true);
                            break;
                        case 2:
                            a.this.haj.getRootView().setVisibility(0);
                            a.this.hai.getRootView().setVisibility(8);
                            a.this.hak.getRootView().setVisibility(8);
                            a.this.hai.mZ(false);
                            a.this.haj.mZ(true);
                            a.this.hak.mZ(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.bQI.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.bCi();
                    a.this.bCj();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCi() {
        am amVar = new am("c12424");
        amVar.r("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCj() {
        if (this.mCurrentTabIndex == 0) {
            bCn();
            bCl();
            return;
        }
        replay();
    }

    public void replay() {
        bCn();
        this.hag.start();
        this.hag.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.aWV != null) {
            this.mIsMute = z;
            if (z) {
                this.aWV.setVolume(0.0f, 0.0f);
            } else {
                this.aWV.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bCn();
        this.hai.onPause();
        this.haj.onPause();
        this.hak.onPause();
    }

    public void onResume() {
        this.hag.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.hag.bCt();
        }
        this.hai.onResume();
        this.haj.onResume();
        this.hak.onResume();
    }

    public MaskVideoView bCk() {
        return this.hag;
    }

    public Bitmap s(Bitmap bitmap) {
        return this.hai.s(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.haj.setMusicData(list);
    }

    public void dH(List<PendantData> list) {
        this.hai.dH(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.hak != null) {
            this.hak.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hai.setData(str);
                this.hag.setVideoPath(str);
                this.hag.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.aWV = mediaPlayer;
                        if (a.this.mIsMute) {
                            a.this.aWV.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.aWV.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.hai.bCw();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.hag.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.hag.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.hag.seekTo(a.this.hai.getCurrentPosition());
                    }
                });
                this.hag.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.haj.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bCl() {
        if (this.hag != null) {
            this.hag.seekTo(this.hai.getCurrentPosition());
        }
    }

    public void bCm() {
        if (this.hag != null) {
            this.hag.uA(this.hai.getCurrentPosition());
        }
    }

    public void bCn() {
        if (this.hag != null) {
            this.hag.bCs();
        }
    }

    public void bCo() {
        if (this.hag != null) {
            this.hag.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.bQI.onChangeSkinType(i);
        this.bQI.setDiverColor(i == 1 ? this.mResources.getColor(d.C0141d.cp_cont_b_1) : this.mResources.getColor(d.C0141d.cp_cont_b));
        al.j(this.mRootView, d.C0141d.cp_bg_line_d);
        if (this.hai != null) {
            this.hai.onChangeSkinType(eVar, i);
        }
        if (this.haj != null) {
            this.haj.onChangeSkinType(eVar, i);
        }
    }

    private void avi() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(d.k.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        al.h(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(d.k.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hai.bmN();
                if (a.this.gYX != null) {
                    a.this.gYX.bBu();
                }
            }
        }), d.C0141d.cp_cont_f);
    }

    public String getText() {
        return this.hai.getText();
    }

    public int getCurrentPosition() {
        if (this.hag == null) {
            return 0;
        }
        return this.hag.getCurrentPosition();
    }

    public void showDialog() {
        if (this.hah == null) {
            String[] strArr = {getPageContext().getString(d.k.save), getPageContext().getString(d.k.not_save), getPageContext().getString(d.k.cancel)};
            this.hah = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hah.cg(b.a.alc);
            this.hah.ci(17);
            this.hah.dC(TbadkCoreApplication.getInst().getResources().getString(d.k.save_video_title));
            this.hah.a(strArr, this.ham);
            this.hah.d(getPageContext());
            TextView titleView = this.hah.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(d.e.fontsize24));
                al.h(titleView, d.C0141d.cp_cont_d);
            }
        }
        this.hah.xd();
    }

    public void cr(String str, String str2) {
        this.haj.cr(str, str2);
    }

    public void bBz() {
        if (this.gYX != null) {
            this.gYX.bBz();
        }
    }

    public String bCp() {
        return this.haj.bCp();
    }

    public String bCq() {
        return this.haj.bCq();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bCr() {
        return this.haj.bCr();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.hai != null) {
            this.hai.release();
        }
        if (this.hag != null) {
            this.hag.stopPlayback();
        }
    }

    public void aa(Intent intent) {
        this.haj.aa(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bCk() != null) {
            bCk().setGenMaskCoverListener(bVar);
        }
    }
}
