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
    private FragmentTabWidget cmc;
    private com.baidu.tieba.video.editvideo.a hCs;
    private MaskVideoView hDB;
    private com.baidu.tbadk.core.dialog.b hDC;
    private b hDD;
    private d hDE;
    private c hDF;
    private FrameLayout hDG;
    private b.InterfaceC0158b hDH;
    private h hms;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.hDH = new b.InterfaceC0158b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.hCs != null) {
                            a.this.hCs.bIr();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.hCs != null) {
                            a.this.hCs.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.hCs = aVar;
        this.mRootView = view;
        this.hms = hVar;
        this.mResources = view.getResources();
        this.hDD = new b(this.mContext, this);
        this.hDE = new d(this.mContext, this, this.hms);
        this.hDF = new c(this.mContext, this);
        this.hDD.bU(this.mRootView);
        this.hDE.bU(this.mRootView);
        this.hDF.bU(this.mRootView);
        initView();
        bJc();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.hDB = (MaskVideoView) this.mRootView.findViewById(e.g.video_view);
        this.hDB.setPreserveEGLContextOnPause(true);
        this.hDB.setZOrderMediaOverlay(true);
        this.hDB.setPostMonitorManager(this.hms);
        this.hDG = (FrameLayout) this.mRootView.findViewById(e.g.edit_container);
        this.hDG.addView(this.hDD.getRootView());
        this.cmc = (FragmentTabWidget) this.mRootView.findViewById(e.g.tab_widget);
        ayF();
        agb();
        this.hDG.addView(this.hDE.getRootView());
        this.hDG.addView(this.hDF.getRootView());
        this.hDE.getRootView().setVisibility(8);
        this.hDF.getRootView().setVisibility(8);
    }

    private boolean bJb() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void agb() {
        String[] stringArray = this.mResources.getStringArray(e.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(e.d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(e.C0210e.fontsize34));
            this.cmc.addView(fragmentTabIndicator, i);
        }
        if (!bJb() && this.cmc.getChildAt(1) != null) {
            this.cmc.getChildAt(1).setVisibility(8);
        }
        this.cmc.setDiverColor(this.mResources.getColor(e.d.cp_cont_b));
        this.cmc.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.cmc.setBackGroundDrawableResId(e.d.cp_bg_line_d);
        this.cmc.setDviderRectWidth(l.h(this.mContext.getPageActivity(), e.C0210e.ds64));
        this.cmc.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.hDD.getRootView().setVisibility(0);
                            a.this.hDE.getRootView().setVisibility(8);
                            a.this.hDF.getRootView().setVisibility(8);
                            a.this.hDD.nX(true);
                            a.this.hDE.nX(false);
                            a.this.hDF.nX(false);
                            break;
                        case 1:
                            a.this.hDF.getRootView().setVisibility(0);
                            a.this.hDE.getRootView().setVisibility(8);
                            a.this.hDD.getRootView().setVisibility(8);
                            a.this.hDD.nX(false);
                            if (TextUtils.isEmpty(a.this.hDE.bJj())) {
                                a.this.hDE.nX(false);
                            } else {
                                a.this.hDE.nX(true);
                            }
                            a.this.hDF.nX(true);
                            break;
                        case 2:
                            a.this.hDE.getRootView().setVisibility(0);
                            a.this.hDD.getRootView().setVisibility(8);
                            a.this.hDF.getRootView().setVisibility(8);
                            a.this.hDD.nX(false);
                            a.this.hDE.nX(true);
                            a.this.hDF.nX(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.cmc.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.bJc();
                    a.this.bJd();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJc() {
        am amVar = new am("c12424");
        amVar.x("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJd() {
        if (this.mCurrentTabIndex == 0) {
            bJh();
            bJf();
            return;
        }
        replay();
    }

    public void replay() {
        bJh();
        this.hDB.start();
        this.hDB.seekTo(0);
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
        bJh();
        this.hDD.onPause();
        this.hDE.onPause();
        this.hDF.onPause();
    }

    public void onResume() {
        this.hDB.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.hDB.resumeMedia();
        }
        this.hDD.onResume();
        this.hDE.onResume();
        this.hDF.onResume();
    }

    public MaskVideoView bJe() {
        return this.hDB;
    }

    public Bitmap s(Bitmap bitmap) {
        return this.hDD.s(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.hDE.setMusicData(list);
    }

    public void dX(List<PendantData> list) {
        this.hDD.dX(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.hDF != null) {
            this.hDF.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hDD.setData(str);
                this.hDB.setVideoPath(str);
                this.hDB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.hDD.bJp();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.hDB.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.hDB.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.hDB.seekTo(a.this.hDD.getCurrentPosition());
                    }
                });
                this.hDB.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.hDE.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bJf() {
        if (this.hDB != null) {
            this.hDB.seekTo(this.hDD.getCurrentPosition());
        }
    }

    public void bJg() {
        if (this.hDB != null) {
            this.hDB.wu(this.hDD.getCurrentPosition());
        }
    }

    public void bJh() {
        if (this.hDB != null) {
            this.hDB.bJm();
        }
    }

    public void bJi() {
        if (this.hDB != null) {
            this.hDB.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.cmc.onChangeSkinType(i);
        this.cmc.setDiverColor(i == 1 ? this.mResources.getColor(e.d.cp_cont_b_1) : this.mResources.getColor(e.d.cp_cont_b));
        al.j(this.mRootView, e.d.cp_bg_line_d);
        if (this.hDD != null) {
            this.hDD.onChangeSkinType(eVar, i);
        }
        if (this.hDE != null) {
            this.hDE.onChangeSkinType(eVar, i);
        }
    }

    private void ayF() {
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
                a.this.hDD.bsR();
                if (a.this.hCs != null) {
                    a.this.hCs.bIo();
                }
            }
        }), e.d.cp_cont_f);
    }

    public String getText() {
        return this.hDD.getText();
    }

    public int getCurrentPosition() {
        if (this.hDB == null) {
            return 0;
        }
        return this.hDB.getCurrentPosition();
    }

    public void showDialog() {
        if (this.hDC == null) {
            String[] strArr = {getPageContext().getString(e.j.save), getPageContext().getString(e.j.not_save), getPageContext().getString(e.j.cancel)};
            this.hDC = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hDC.df(b.a.awO);
            this.hDC.dh(17);
            this.hDC.eC(TbadkCoreApplication.getInst().getResources().getString(e.j.save_video_title));
            this.hDC.a(strArr, this.hDH);
            this.hDC.d(getPageContext());
            TextView titleView = this.hDC.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(e.C0210e.fontsize24));
                al.h(titleView, e.d.cp_cont_d);
            }
        }
        this.hDC.BI();
    }

    public void cS(String str, String str2) {
        this.hDE.cS(str, str2);
    }

    public void bIt() {
        if (this.hCs != null) {
            this.hCs.bIt();
        }
    }

    public String bJj() {
        return this.hDE.bJj();
    }

    public String bJk() {
        return this.hDE.bJk();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bJl() {
        return this.hDE.bJl();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.hDD != null) {
            this.hDD.release();
        }
        if (this.hDB != null) {
            this.hDB.stopPlayback();
        }
    }

    public void ae(Intent intent) {
        this.hDE.ae(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bJe() != null) {
            bJe().setGenMaskCoverListener(bVar);
        }
    }
}
