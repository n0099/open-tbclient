package com.baidu.tieba.video.editvideo.view;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.k.h;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes23.dex */
public class a extends com.baidu.adp.base.c {
    private k.c eIJ;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;
    private h mYk;
    private i maJ;
    private com.baidu.tieba.video.editvideo.a nor;
    private MaskVideoView npA;
    private c npB;
    private e npC;
    private d npD;
    private FrameLayout npE;
    private FragmentTabWidget npF;

    public a(com.baidu.adp.base.e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.eIJ = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.nor != null) {
                            a.this.nor.bxL();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.nor != null) {
                            a.this.nor.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.maJ != null && a.this.maJ.isShowing() && a.this.getPageContext() != null) {
                    a.this.maJ.dismiss();
                }
            }
        };
        this.nor = aVar;
        this.mRootView = view;
        this.mYk = hVar;
        this.mResources = view.getResources();
        this.npB = new c(this.mContext, this);
        this.npC = new e(this.mContext, this, this.mYk);
        this.npD = new d(this.mContext, this);
        this.npB.dM(this.mRootView);
        this.npC.dM(this.mRootView);
        this.npD.dM(this.mRootView);
        initView();
        dPx();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.npA = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.npA.setPreserveEGLContextOnPause(true);
        this.npA.setZOrderMediaOverlay(true);
        this.npA.setPostMonitorManager(this.mYk);
        this.npE = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.npE.addView(this.npB.getRootView());
        this.npF = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bCV();
        dPw();
        this.npE.addView(this.npC.getRootView());
        this.npE.addView(this.npD.getRootView());
        this.npC.getRootView().setVisibility(8);
        this.npD.getRootView().setVisibility(8);
    }

    private boolean dPv() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dPw() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.npF.addView(fragmentTabIndicator, i);
        }
        if (!dPv() && this.npF.getChildAt(1) != null) {
            this.npF.getChildAt(1).setVisibility(8);
        }
        this.npF.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.npF.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.npF.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.npF.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.npF.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.npB.getRootView().setVisibility(0);
                            a.this.npC.getRootView().setVisibility(8);
                            a.this.npD.getRootView().setVisibility(8);
                            a.this.npB.xU(true);
                            a.this.npC.xU(false);
                            a.this.npD.xU(false);
                            break;
                        case 1:
                            a.this.npD.getRootView().setVisibility(0);
                            a.this.npC.getRootView().setVisibility(8);
                            a.this.npB.getRootView().setVisibility(8);
                            a.this.npB.xU(false);
                            if (TextUtils.isEmpty(a.this.npC.dPE())) {
                                a.this.npC.xU(false);
                            } else {
                                a.this.npC.xU(true);
                            }
                            a.this.npD.xU(true);
                            break;
                        case 2:
                            a.this.npC.getRootView().setVisibility(0);
                            a.this.npB.getRootView().setVisibility(8);
                            a.this.npD.getRootView().setVisibility(8);
                            a.this.npB.xU(false);
                            a.this.npC.xU(true);
                            a.this.npD.xU(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.npF.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dPx();
                    a.this.dPy();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPx() {
        aq aqVar = new aq("c12424");
        aqVar.al("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPy() {
        if (this.mCurrentTabIndex == 0) {
            dPC();
            dPA();
            return;
        }
        replay();
    }

    public void replay() {
        dPC();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.npA.start();
        this.npA.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dPC();
        this.npB.onPause();
        this.npC.onPause();
        this.npD.onPause();
    }

    public void onResume() {
        this.npA.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.npA.resumeMedia();
        }
        this.npB.onResume();
        this.npC.onResume();
        this.npD.onResume();
    }

    public MaskVideoView dPz() {
        return this.npA;
    }

    public Bitmap F(Bitmap bitmap) {
        return this.npB.F(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.npC.setMusicData(list);
    }

    public void fR(List<PendantData> list) {
        this.npB.fR(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.npD != null) {
            this.npD.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a TS(String str) {
        if (this.npD == null || at.isEmpty(str)) {
            return null;
        }
        return this.npD.TU(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.npA != null) {
            this.npA.setFilter(aVar);
        }
        if (this.npD != null) {
            this.npD.d(aVar);
        }
    }

    public void gy(String str, String str2) {
        if (this.npC != null) {
            this.npC.gA(str, str2);
        }
    }

    public void xV(boolean z) {
        if (this.npC != null) {
            this.npC.xW(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.npB.setData(str);
                this.npA.setVideoPath(str);
                this.npA.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.mMediaPlayer = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.mMediaPlayer.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.mMediaPlayer.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.npB.dPL();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.npA.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.npA.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.npA.seekTo(a.this.npB.getCurrentPosition());
                    }
                });
                this.npA.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.npC.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dPA() {
        if (this.npA != null) {
            this.npA.seekTo(this.npB.getCurrentPosition());
        }
    }

    public void dPB() {
        if (this.npA != null) {
            this.npA.KH(this.npB.getCurrentPosition());
        }
    }

    public void dPC() {
        if (this.npA != null) {
            this.npA.dPH();
        }
    }

    public void dPD() {
        if (this.npA != null) {
            this.npA.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.npF.onChangeSkinType(i);
        this.npF.setDiverColor(ap.getColor(i, R.color.cp_cont_b));
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.npB != null) {
            this.npB.onChangeSkinType(eVar, i);
        }
        if (this.npC != null) {
            this.npC.onChangeSkinType(eVar, i);
        }
    }

    private void bCV() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Qj();
            }
        });
        ap.setViewTextColor(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.npB.hideSoftKeyPad();
                if (a.this.nor != null) {
                    a.this.nor.onNext();
                }
            }
        }), R.color.cp_cont_f);
    }

    public String getText() {
        return this.npB.getText();
    }

    public int getCurrentPosition() {
        if (this.npA == null) {
            return 0;
        }
        return this.npA.getCurrentPosition();
    }

    public void Qj() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && at.equals(((EditVideoActivity) this.mContext.getPageActivity()).bmm(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.nor.finishPage();
            return;
        }
        if (this.maJ == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.maJ = new i(getPageContext());
            this.maJ.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.maJ.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.eIJ);
        }
        this.maJ.Qj();
    }

    public void gz(String str, String str2) {
        this.npC.gz(str, str2);
    }

    public void dOT() {
        if (this.nor != null) {
            this.nor.dOT();
        }
    }

    public String dPE() {
        return this.npC.dPE();
    }

    public String dPF() {
        return this.npC.dPF();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean dPG() {
        return this.npC.dPG();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.npB != null) {
            this.npB.release();
        }
        if (this.npA != null) {
            this.npA.stopPlayback();
        }
    }

    public void am(Intent intent) {
        this.npC.am(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dPz() != null) {
            dPz().setGenMaskCoverListener(bVar);
        }
    }
}
