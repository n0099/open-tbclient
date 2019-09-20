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
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends com.baidu.adp.base.c {
    private MediaPlayer bAy;
    private k.c bOQ;
    private FragmentTabWidget dRn;
    private i irC;
    private MaskVideoView jAU;
    private b jAV;
    private d jAW;
    private c jAX;
    private FrameLayout jAY;
    private h jjR;
    private com.baidu.tieba.video.editvideo.a jzM;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.bOQ = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.jzM != null) {
                            a.this.jzM.cvo();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.jzM != null) {
                            a.this.jzM.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.irC != null && a.this.irC.isShowing() && a.this.getPageContext() != null) {
                    a.this.irC.dismiss();
                }
            }
        };
        this.jzM = aVar;
        this.mRootView = view;
        this.jjR = hVar;
        this.mResources = view.getResources();
        this.jAV = new b(this.mContext, this);
        this.jAW = new d(this.mContext, this, this.jjR);
        this.jAX = new c(this.mContext, this);
        this.jAV.cX(this.mRootView);
        this.jAW.cX(this.mRootView);
        this.jAX.cX(this.mRootView);
        initView();
        cvZ();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.jAU = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.jAU.setPreserveEGLContextOnPause(true);
        this.jAU.setZOrderMediaOverlay(true);
        this.jAU.setPostMonitorManager(this.jjR);
        this.jAY = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.jAY.addView(this.jAV.getRootView());
        this.dRn = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        aJX();
        aPX();
        this.jAY.addView(this.jAW.getRootView());
        this.jAY.addView(this.jAX.getRootView());
        this.jAW.getRootView().setVisibility(8);
        this.jAX.getRootView().setVisibility(8);
    }

    private boolean cvY() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void aPX() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.dRn.addView(fragmentTabIndicator, i);
        }
        if (!cvY() && this.dRn.getChildAt(1) != null) {
            this.dRn.getChildAt(1).setVisibility(8);
        }
        this.dRn.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.dRn.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.dRn.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.dRn.setDviderRectWidth(l.g(this.mContext.getPageActivity(), R.dimen.ds64));
        this.dRn.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.jAV.getRootView().setVisibility(0);
                            a.this.jAW.getRootView().setVisibility(8);
                            a.this.jAX.getRootView().setVisibility(8);
                            a.this.jAV.rI(true);
                            a.this.jAW.rI(false);
                            a.this.jAX.rI(false);
                            break;
                        case 1:
                            a.this.jAX.getRootView().setVisibility(0);
                            a.this.jAW.getRootView().setVisibility(8);
                            a.this.jAV.getRootView().setVisibility(8);
                            a.this.jAV.rI(false);
                            if (TextUtils.isEmpty(a.this.jAW.cwg())) {
                                a.this.jAW.rI(false);
                            } else {
                                a.this.jAW.rI(true);
                            }
                            a.this.jAX.rI(true);
                            break;
                        case 2:
                            a.this.jAW.getRootView().setVisibility(0);
                            a.this.jAV.getRootView().setVisibility(8);
                            a.this.jAX.getRootView().setVisibility(8);
                            a.this.jAV.rI(false);
                            a.this.jAW.rI(true);
                            a.this.jAX.rI(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.dRn.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.cvZ();
                    a.this.cwa();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvZ() {
        an anVar = new an("c12424");
        anVar.P("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwa() {
        if (this.mCurrentTabIndex == 0) {
            cwe();
            cwc();
            return;
        }
        replay();
    }

    public void replay() {
        cwe();
        this.jAU.start();
        this.jAU.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bAy != null) {
            this.mIsMute = z;
            if (z) {
                this.bAy.setVolume(0.0f, 0.0f);
            } else {
                this.bAy.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        cwe();
        this.jAV.onPause();
        this.jAW.onPause();
        this.jAX.onPause();
    }

    public void onResume() {
        this.jAU.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.jAU.cwk();
        }
        this.jAV.onResume();
        this.jAW.onResume();
        this.jAX.onResume();
    }

    public MaskVideoView cwb() {
        return this.jAU;
    }

    public Bitmap B(Bitmap bitmap) {
        return this.jAV.B(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.jAW.setMusicData(list);
    }

    public void eo(List<PendantData> list) {
        this.jAV.eo(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.jAX != null) {
            this.jAX.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.jAV.setData(str);
                this.jAU.setVideoPath(str);
                this.jAU.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bAy = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.bAy.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bAy.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.jAV.cwn();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.jAU.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.jAU.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.jAU.seekTo(a.this.jAV.getCurrentPosition());
                    }
                });
                this.jAU.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.jAW.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cwc() {
        if (this.jAU != null) {
            this.jAU.seekTo(this.jAV.getCurrentPosition());
        }
    }

    public void cwd() {
        if (this.jAU != null) {
            this.jAU.Cn(this.jAV.getCurrentPosition());
        }
    }

    public void cwe() {
        if (this.jAU != null) {
            this.jAU.cwj();
        }
    }

    public void cwf() {
        if (this.jAU != null) {
            this.jAU.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.dRn.onChangeSkinType(i);
        this.dRn.setDiverColor(am.getColor(i, R.color.cp_cont_b));
        am.l(this.mRootView, R.color.cp_bg_line_d);
        if (this.jAV != null) {
            this.jAV.onChangeSkinType(eVar, i);
        }
        if (this.jAW != null) {
            this.jAW.onChangeSkinType(eVar, i);
        }
    }

    private void aJX() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        am.j(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jAV.cgY();
                if (a.this.jzM != null) {
                    a.this.jzM.cvl();
                }
            }
        }), R.color.cp_cont_f);
    }

    public String getText() {
        return this.jAV.getText();
    }

    public int getCurrentPosition() {
        if (this.jAU == null) {
            return 0;
        }
        return this.jAU.getCurrentPosition();
    }

    public void showDialog() {
        if (this.irC == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.irC = new i(getPageContext());
            this.irC.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.irC.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.bOQ);
        }
        this.irC.showDialog();
    }

    public void eu(String str, String str2) {
        this.jAW.eu(str, str2);
    }

    public void cvq() {
        if (this.jzM != null) {
            this.jzM.cvq();
        }
    }

    public String cwg() {
        return this.jAW.cwg();
    }

    public String cwh() {
        return this.jAW.cwh();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean cwi() {
        return this.jAW.cwi();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.jAV != null) {
            this.jAV.release();
        }
        if (this.jAU != null) {
            this.jAU.stopPlayback();
        }
    }

    public void aA(Intent intent) {
        this.jAW.aA(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && cwb() != null) {
            cwb().setGenMaskCoverListener(bVar);
        }
    }
}
