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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.l.h;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes23.dex */
public class a extends com.baidu.adp.base.c {
    private k.c eOp;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;
    private i mph;
    private com.baidu.tieba.video.editvideo.a nDB;
    private MaskVideoView nEI;
    private c nEJ;
    private e nEK;
    private d nEL;
    private FrameLayout nEM;
    private FragmentTabWidget nEN;
    private h nnb;

    public a(com.baidu.adp.base.e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.eOp = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.nDB != null) {
                            a.this.nDB.bAB();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.nDB != null) {
                            a.this.nDB.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.mph != null && a.this.mph.isShowing() && a.this.getPageContext() != null) {
                    a.this.mph.dismiss();
                }
            }
        };
        this.nDB = aVar;
        this.mRootView = view;
        this.nnb = hVar;
        this.mResources = view.getResources();
        this.nEJ = new c(this.mContext, this);
        this.nEK = new e(this.mContext, this, this.nnb);
        this.nEL = new d(this.mContext, this);
        this.nEJ.ee(this.mRootView);
        this.nEK.ee(this.mRootView);
        this.nEL.ee(this.mRootView);
        initView();
        dUQ();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.nEI = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.nEI.setPreserveEGLContextOnPause(true);
        this.nEI.setZOrderMediaOverlay(true);
        this.nEI.setPostMonitorManager(this.nnb);
        this.nEM = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.nEM.addView(this.nEJ.getRootView());
        this.nEN = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bFP();
        dUP();
        this.nEM.addView(this.nEK.getRootView());
        this.nEM.addView(this.nEL.getRootView());
        this.nEK.getRootView().setVisibility(8);
        this.nEL.getRootView().setVisibility(8);
    }

    private boolean dUO() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dUP() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.nEN.addView(fragmentTabIndicator, i);
        }
        if (!dUO() && this.nEN.getChildAt(1) != null) {
            this.nEN.getChildAt(1).setVisibility(8);
        }
        this.nEN.setDiverColor(this.mResources.getColor(R.color.CAM_X0105));
        this.nEN.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.nEN.setBackGroundDrawableResId(R.color.CAM_X0201);
        this.nEN.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.nEN.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.nEJ.getRootView().setVisibility(0);
                            a.this.nEK.getRootView().setVisibility(8);
                            a.this.nEL.getRootView().setVisibility(8);
                            a.this.nEJ.yG(true);
                            a.this.nEK.yG(false);
                            a.this.nEL.yG(false);
                            break;
                        case 1:
                            a.this.nEL.getRootView().setVisibility(0);
                            a.this.nEK.getRootView().setVisibility(8);
                            a.this.nEJ.getRootView().setVisibility(8);
                            a.this.nEJ.yG(false);
                            if (TextUtils.isEmpty(a.this.nEK.dUX())) {
                                a.this.nEK.yG(false);
                            } else {
                                a.this.nEK.yG(true);
                            }
                            a.this.nEL.yG(true);
                            break;
                        case 2:
                            a.this.nEK.getRootView().setVisibility(0);
                            a.this.nEJ.getRootView().setVisibility(8);
                            a.this.nEL.getRootView().setVisibility(8);
                            a.this.nEJ.yG(false);
                            a.this.nEK.yG(true);
                            a.this.nEL.yG(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.nEN.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dUQ();
                    a.this.dUR();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUQ() {
        ar arVar = new ar("c12424");
        arVar.al("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUR() {
        if (this.mCurrentTabIndex == 0) {
            dUV();
            dUT();
            return;
        }
        replay();
    }

    public void replay() {
        dUV();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.nEI.start();
        this.nEI.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dUV();
        this.nEJ.onPause();
        this.nEK.onPause();
        this.nEL.onPause();
    }

    public void onResume() {
        this.nEI.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.nEI.resumeMedia();
        }
        this.nEJ.onResume();
        this.nEK.onResume();
        this.nEL.onResume();
    }

    public MaskVideoView dUS() {
        return this.nEI;
    }

    public Bitmap F(Bitmap bitmap) {
        return this.nEJ.F(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.nEK.setMusicData(list);
    }

    public void gf(List<PendantData> list) {
        this.nEJ.gf(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.nEL != null) {
            this.nEL.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a US(String str) {
        if (this.nEL == null || au.isEmpty(str)) {
            return null;
        }
        return this.nEL.UU(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.nEI != null) {
            this.nEI.setFilter(aVar);
        }
        if (this.nEL != null) {
            this.nEL.d(aVar);
        }
    }

    public void gD(String str, String str2) {
        if (this.nEK != null) {
            this.nEK.gF(str, str2);
        }
    }

    public void yH(boolean z) {
        if (this.nEK != null) {
            this.nEK.yI(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.nEJ.setData(str);
                this.nEI.setVideoPath(str);
                this.nEI.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.nEJ.dVe();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.nEI.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.nEI.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.nEI.seekTo(a.this.nEJ.getCurrentPosition());
                    }
                });
                this.nEI.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.nEK.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dUT() {
        if (this.nEI != null) {
            this.nEI.seekTo(this.nEJ.getCurrentPosition());
        }
    }

    public void dUU() {
        if (this.nEI != null) {
            this.nEI.Mc(this.nEJ.getCurrentPosition());
        }
    }

    public void dUV() {
        if (this.nEI != null) {
            this.nEI.dVa();
        }
    }

    public void dUW() {
        if (this.nEI != null) {
            this.nEI.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.nEN.onChangeSkinType(i);
        this.nEN.setDiverColor(ap.getColor(i, R.color.CAM_X0105));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.nEJ != null) {
            this.nEJ.onChangeSkinType(eVar, i);
        }
        if (this.nEK != null) {
            this.nEK.onChangeSkinType(eVar, i);
        }
    }

    private void bFP() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.RU();
            }
        });
        ap.setViewTextColor(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.nEJ.hideSoftKeyPad();
                if (a.this.nDB != null) {
                    a.this.nDB.onNext();
                }
            }
        }), R.color.CAM_X0106);
    }

    public String getText() {
        return this.nEJ.getText();
    }

    public int getCurrentPosition() {
        if (this.nEI == null) {
            return 0;
        }
        return this.nEI.getCurrentPosition();
    }

    public void RU() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && au.equals(((EditVideoActivity) this.mContext.getPageActivity()).boB(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.nDB.finishPage();
            return;
        }
        if (this.mph == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.mph = new i(getPageContext());
            this.mph.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.mph.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.eOp);
        }
        this.mph.RU();
    }

    public void gE(String str, String str2) {
        this.nEK.gE(str, str2);
    }

    public void dUk() {
        if (this.nDB != null) {
            this.nDB.dUk();
        }
    }

    public String dUX() {
        return this.nEK.dUX();
    }

    public String dUY() {
        return this.nEK.dUY();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean dUZ() {
        return this.nEK.dUZ();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.nEJ != null) {
            this.nEJ.release();
        }
        if (this.nEI != null) {
            this.nEI.stopPlayback();
        }
    }

    public void am(Intent intent) {
        this.nEK.am(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dUS() != null) {
            dUS().setGenMaskCoverListener(bVar);
        }
    }
}
