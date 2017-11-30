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
    private MediaPlayer bdf;
    private FragmentTabWidget byR;
    private Resources fXC;
    private h gAg;
    private com.baidu.tieba.video.editvideo.a gPy;
    private MaskVideoView gQI;
    private com.baidu.tbadk.core.dialog.b gQJ;
    private b gQK;
    private d gQL;
    private c gQM;
    private FrameLayout gQN;
    private b.InterfaceC0047b gQO;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.gQO = new b.InterfaceC0047b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.gPy != null) {
                            a.this.gPy.bAW();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.gPy != null) {
                            a.this.gPy.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.gPy = aVar;
        this.mRootView = view;
        this.gAg = hVar;
        this.fXC = view.getResources();
        this.gQK = new b(this.mContext, this);
        this.gQL = new d(this.mContext, this, this.gAg);
        this.gQM = new c(this.mContext, this);
        this.gQK.bI(this.mRootView);
        this.gQL.bI(this.mRootView);
        this.gQM.bI(this.mRootView);
        initView();
        bBI();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.gQI = (MaskVideoView) this.mRootView.findViewById(d.g.video_view);
        this.gQI.setPreserveEGLContextOnPause(true);
        this.gQI.setZOrderMediaOverlay(true);
        this.gQI.setPostMonitorManager(this.gAg);
        this.gQN = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.gQN.addView(this.gQK.getRootView());
        this.byR = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        amS();
        SZ();
        this.gQN.addView(this.gQL.getRootView());
        this.gQN.addView(this.gQM.getRootView());
        this.gQL.getRootView().setVisibility(8);
        this.gQM.getRootView().setVisibility(8);
    }

    private boolean bBH() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void SZ() {
        String[] stringArray = this.fXC.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0082d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.fXC.getDimension(d.e.fontsize34));
            this.byR.addView(fragmentTabIndicator, i);
        }
        if (!bBH() && this.byR.getChildAt(1) != null) {
            this.byR.getChildAt(1).setVisibility(8);
        }
        this.byR.setDiverColor(this.fXC.getColor(d.C0082d.cp_cont_b));
        this.byR.a(this.mCurrentTabIndex, true, false);
        this.byR.setBackGroundDrawableResId(d.C0082d.cp_bg_line_d);
        this.byR.setDviderRectWidth(l.f(this.mContext.getPageActivity(), d.e.ds64));
        this.byR.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void e(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.gQK.getRootView().setVisibility(0);
                            a.this.gQL.getRootView().setVisibility(8);
                            a.this.gQM.getRootView().setVisibility(8);
                            a.this.gQK.nD(true);
                            a.this.gQL.nD(false);
                            a.this.gQM.nD(false);
                            break;
                        case 1:
                            a.this.gQM.getRootView().setVisibility(0);
                            a.this.gQL.getRootView().setVisibility(8);
                            a.this.gQK.getRootView().setVisibility(8);
                            a.this.gQK.nD(false);
                            a.this.gQL.nD(false);
                            a.this.gQM.nD(true);
                            break;
                        case 2:
                            a.this.gQL.getRootView().setVisibility(0);
                            a.this.gQK.getRootView().setVisibility(8);
                            a.this.gQM.getRootView().setVisibility(8);
                            a.this.gQK.nD(false);
                            a.this.gQL.nD(true);
                            a.this.gQM.nD(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.byR.a(a.this.mCurrentTabIndex, true, true);
                    a.this.bBI();
                    a.this.bBJ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBI() {
        ak akVar = new ak("c12424");
        akVar.r("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBJ() {
        if (this.mCurrentTabIndex == 0) {
            bBO();
            bBM();
            return;
        }
        bBK();
    }

    public void bBK() {
        bBO();
        this.gQI.start();
        this.gQI.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bdf != null) {
            this.mIsMute = z;
            if (z) {
                this.bdf.setVolume(0.0f, 0.0f);
            } else {
                this.bdf.setVolume(1.0f, 1.0f);
            }
            bBK();
        }
    }

    public void onPause() {
        bBO();
        this.gQK.onPause();
        this.gQL.onPause();
        this.gQM.onPause();
    }

    public void onResume() {
        this.gQI.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.gQI.bBU();
        }
        this.gQK.onResume();
        this.gQL.onResume();
        this.gQM.onResume();
    }

    public MaskVideoView bBL() {
        return this.gQI;
    }

    public Bitmap j(Bitmap bitmap) {
        return this.gQK.j(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.gQL.setMusicData(list);
    }

    public void dO(List<PendantData> list) {
        this.gQK.dO(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.gQM != null) {
            this.gQM.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.gQK.setData(str);
                this.gQI.setVideoPath(str);
                this.gQI.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bdf = mediaPlayer;
                        if (a.this.mIsMute) {
                            a.this.bdf.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bdf.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.gQK.bBX();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.gQI.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.gQI.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.gQI.seekTo(a.this.gQK.getCurrentPosition());
                    }
                });
                this.gQI.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.bBK();
                            a.this.gQL.bBK();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bBM() {
        if (this.gQI != null) {
            this.gQI.seekTo(this.gQK.getCurrentPosition());
        }
    }

    public void bBN() {
        if (this.gQI != null) {
            this.gQI.vj(this.gQK.getCurrentPosition());
        }
    }

    public void bBO() {
        if (this.gQI != null) {
            this.gQI.bBT();
        }
    }

    public void bBP() {
        if (this.gQI != null) {
            this.gQI.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.byR.onChangeSkinType(i);
        this.byR.setDiverColor(i == 1 ? this.fXC.getColor(d.C0082d.cp_cont_b_1) : this.fXC.getColor(d.C0082d.cp_cont_b));
        aj.k(this.mRootView, d.C0082d.cp_bg_line_d);
        if (this.gQK != null) {
            this.gQK.onChangeSkinType(eVar, i);
        }
        if (this.gQL != null) {
            this.gQL.onChangeSkinType(eVar, i);
        }
    }

    private void amS() {
        this.mNavigationBar.setCenterTextTitle(this.fXC.getString(d.j.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        aj.i(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fXC.getString(d.j.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gQK.bkn();
                if (a.this.gPy != null) {
                    a.this.gPy.bAT();
                }
            }
        }), d.C0082d.cp_cont_f);
    }

    public String getText() {
        return this.gQK.getText();
    }

    public int getCurrentPosition() {
        if (this.gQI == null) {
            return 0;
        }
        return this.gQI.getCurrentPosition();
    }

    public void showDialog() {
        if (this.gQJ == null) {
            String[] strArr = {getPageContext().getString(d.j.save), getPageContext().getString(d.j.not_save), getPageContext().getString(d.j.cancel)};
            this.gQJ = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.gQJ.ch(b.a.abV);
            this.gQJ.cj(17);
            this.gQJ.cT(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title));
            this.gQJ.a(strArr, this.gQO);
            this.gQJ.d(getPageContext());
            TextView tn = this.gQJ.tn();
            if (tn != null) {
                tn.setGravity(17);
                tn.setTextSize(0, this.fXC.getDimensionPixelSize(d.e.fontsize24));
                aj.i(tn, d.C0082d.cp_cont_d);
            }
        }
        this.gQJ.to();
    }

    public void cn(String str, String str2) {
        this.gQL.cn(str, str2);
    }

    public void bAY() {
        if (this.gPy != null) {
            this.gPy.bAY();
        }
    }

    public String bBQ() {
        return this.gQL.bBQ();
    }

    public String bBR() {
        return this.gQL.bBR();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bBS() {
        return this.gQL.bBS();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.gQK != null) {
            this.gQK.release();
        }
        if (this.gQI != null) {
            this.gQI.stopPlayback();
        }
    }

    public void ad(Intent intent) {
        this.gQL.ad(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bBL() != null) {
            bBL().setGenMaskCoverListener(bVar);
        }
    }
}
