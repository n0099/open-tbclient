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
    private MediaPlayer bTe;
    private k.c cfU;
    private i iqc;
    private MaskVideoView jAL;
    private b jAM;
    private d jAN;
    private c jAO;
    private FrameLayout jAP;
    private FragmentTabWidget jAQ;
    private h jjG;
    private com.baidu.tieba.video.editvideo.a jzE;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.cfU = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.jzE != null) {
                            a.this.jzE.ctc();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.jzE != null) {
                            a.this.jzE.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.iqc != null && a.this.iqc.isShowing() && a.this.getPageContext() != null) {
                    a.this.iqc.dismiss();
                }
            }
        };
        this.jzE = aVar;
        this.mRootView = view;
        this.jjG = hVar;
        this.mResources = view.getResources();
        this.jAM = new b(this.mContext, this);
        this.jAN = new d(this.mContext, this, this.jjG);
        this.jAO = new c(this.mContext, this);
        this.jAM.cT(this.mRootView);
        this.jAN.cT(this.mRootView);
        this.jAO.cT(this.mRootView);
        initView();
        ctN();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.jAL = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.jAL.setPreserveEGLContextOnPause(true);
        this.jAL.setZOrderMediaOverlay(true);
        this.jAL.setPostMonitorManager(this.jjG);
        this.jAP = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.jAP.addView(this.jAM.getRootView());
        this.jAQ = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        aJx();
        ctM();
        this.jAP.addView(this.jAN.getRootView());
        this.jAP.addView(this.jAO.getRootView());
        this.jAN.getRootView().setVisibility(8);
        this.jAO.getRootView().setVisibility(8);
    }

    private boolean ctL() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void ctM() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.jAQ.addView(fragmentTabIndicator, i);
        }
        if (!ctL() && this.jAQ.getChildAt(1) != null) {
            this.jAQ.getChildAt(1).setVisibility(8);
        }
        this.jAQ.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.jAQ.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.jAQ.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.jAQ.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.jAQ.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.jAM.getRootView().setVisibility(0);
                            a.this.jAN.getRootView().setVisibility(8);
                            a.this.jAO.getRootView().setVisibility(8);
                            a.this.jAM.rr(true);
                            a.this.jAN.rr(false);
                            a.this.jAO.rr(false);
                            break;
                        case 1:
                            a.this.jAO.getRootView().setVisibility(0);
                            a.this.jAN.getRootView().setVisibility(8);
                            a.this.jAM.getRootView().setVisibility(8);
                            a.this.jAM.rr(false);
                            if (TextUtils.isEmpty(a.this.jAN.ctU())) {
                                a.this.jAN.rr(false);
                            } else {
                                a.this.jAN.rr(true);
                            }
                            a.this.jAO.rr(true);
                            break;
                        case 2:
                            a.this.jAN.getRootView().setVisibility(0);
                            a.this.jAM.getRootView().setVisibility(8);
                            a.this.jAO.getRootView().setVisibility(8);
                            a.this.jAM.rr(false);
                            a.this.jAN.rr(true);
                            a.this.jAO.rr(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.jAQ.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.ctN();
                    a.this.ctO();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctN() {
        an anVar = new an("c12424");
        anVar.O("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctO() {
        if (this.mCurrentTabIndex == 0) {
            ctS();
            ctQ();
            return;
        }
        replay();
    }

    public void replay() {
        ctS();
        this.jAL.start();
        this.jAL.seekTo(0);
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
        ctS();
        this.jAM.onPause();
        this.jAN.onPause();
        this.jAO.onPause();
    }

    public void onResume() {
        this.jAL.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.jAL.ctY();
        }
        this.jAM.onResume();
        this.jAN.onResume();
        this.jAO.onResume();
    }

    public MaskVideoView ctP() {
        return this.jAL;
    }

    public Bitmap z(Bitmap bitmap) {
        return this.jAM.z(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.jAN.setMusicData(list);
    }

    public void eB(List<PendantData> list) {
        this.jAM.eB(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.jAO != null) {
            this.jAO.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.jAM.setData(str);
                this.jAL.setVideoPath(str);
                this.jAL.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bTe = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.bTe.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bTe.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.jAM.cub();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.jAL.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.jAL.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.jAL.seekTo(a.this.jAM.getCurrentPosition());
                    }
                });
                this.jAL.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.jAN.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void ctQ() {
        if (this.jAL != null) {
            this.jAL.seekTo(this.jAM.getCurrentPosition());
        }
    }

    public void ctR() {
        if (this.jAL != null) {
            this.jAL.AT(this.jAM.getCurrentPosition());
        }
    }

    public void ctS() {
        if (this.jAL != null) {
            this.jAL.ctX();
        }
    }

    public void ctT() {
        if (this.jAL != null) {
            this.jAL.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.jAQ.onChangeSkinType(i);
        this.jAQ.setDiverColor(am.getColor(i, R.color.cp_cont_b));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.jAM != null) {
            this.jAM.onChangeSkinType(eVar, i);
        }
        if (this.jAN != null) {
            this.jAN.onChangeSkinType(eVar, i);
        }
    }

    private void aJx() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        am.setViewTextColor(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jAM.hideSoftKeyPad();
                if (a.this.jzE != null) {
                    a.this.jzE.tT();
                }
            }
        }), (int) R.color.cp_cont_f);
    }

    public String getText() {
        return this.jAM.getText();
    }

    public int getCurrentPosition() {
        if (this.jAL == null) {
            return 0;
        }
        return this.jAL.getCurrentPosition();
    }

    public void showDialog() {
        if (this.iqc == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.iqc = new i(getPageContext());
            this.iqc.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.iqc.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.cfU);
        }
        this.iqc.showDialog();
    }

    public void eg(String str, String str2) {
        this.jAN.eg(str, str2);
    }

    public void cte() {
        if (this.jzE != null) {
            this.jzE.cte();
        }
    }

    public String ctU() {
        return this.jAN.ctU();
    }

    public String ctV() {
        return this.jAN.ctV();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean ctW() {
        return this.jAN.ctW();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.jAM != null) {
            this.jAM.release();
        }
        if (this.jAL != null) {
            this.jAL.stopPlayback();
        }
    }

    public void aH(Intent intent) {
        this.jAN.aH(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && ctP() != null) {
            ctP().setGenMaskCoverListener(bVar);
        }
    }
}
