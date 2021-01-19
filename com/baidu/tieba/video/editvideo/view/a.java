package com.baidu.tieba.video.editvideo.view;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.l.g;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.base.d {
    private k.c eTB;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;
    private i mpQ;
    private com.baidu.tieba.video.editvideo.a nDd;
    private MaskVideoView nEk;
    private c nEl;
    private e nEm;
    private d nEn;
    private FrameLayout nEo;
    private FragmentTabWidget nEp;
    private g noi;

    public a(f fVar, com.baidu.tieba.video.editvideo.a aVar, View view, g gVar) {
        super(fVar);
        this.mCurrentTabIndex = 0;
        this.eTB = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.nDd != null) {
                            a.this.nDd.bzc();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.nDd != null) {
                            a.this.nDd.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.mpQ != null && a.this.mpQ.isShowing() && a.this.getPageContext() != null) {
                    a.this.mpQ.dismiss();
                }
            }
        };
        this.nDd = aVar;
        this.mRootView = view;
        this.noi = gVar;
        this.mResources = view.getResources();
        this.nEl = new c(this.mContext, this);
        this.nEm = new e(this.mContext, this, this.noi);
        this.nEn = new d(this.mContext, this);
        this.nEl.eo(this.mRootView);
        this.nEm.eo(this.mRootView);
        this.nEn.eo(this.mRootView);
        initView();
        dQR();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.nEk = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.nEk.setPreserveEGLContextOnPause(true);
        this.nEk.setZOrderMediaOverlay(true);
        this.nEk.setPostMonitorManager(this.noi);
        this.nEo = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.nEo.addView(this.nEl.getRootView());
        this.nEp = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bEt();
        dQQ();
        this.nEo.addView(this.nEm.getRootView());
        this.nEo.addView(this.nEn.getRootView());
        this.nEm.getRootView().setVisibility(8);
        this.nEn.getRootView().setVisibility(8);
    }

    private boolean dQP() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dQQ() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.nEp.addView(fragmentTabIndicator, i);
        }
        if (!dQP() && this.nEp.getChildAt(1) != null) {
            this.nEp.getChildAt(1).setVisibility(8);
        }
        this.nEp.setDiverColor(this.mResources.getColor(R.color.CAM_X0105));
        this.nEp.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.nEp.setBackGroundDrawableResId(R.color.CAM_X0201);
        this.nEp.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.nEp.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.nEl.getRootView().setVisibility(0);
                            a.this.nEm.getRootView().setVisibility(8);
                            a.this.nEn.getRootView().setVisibility(8);
                            a.this.nEl.yF(true);
                            a.this.nEm.yF(false);
                            a.this.nEn.yF(false);
                            break;
                        case 1:
                            a.this.nEn.getRootView().setVisibility(0);
                            a.this.nEm.getRootView().setVisibility(8);
                            a.this.nEl.getRootView().setVisibility(8);
                            a.this.nEl.yF(false);
                            if (TextUtils.isEmpty(a.this.nEm.dQY())) {
                                a.this.nEm.yF(false);
                            } else {
                                a.this.nEm.yF(true);
                            }
                            a.this.nEn.yF(true);
                            break;
                        case 2:
                            a.this.nEm.getRootView().setVisibility(0);
                            a.this.nEl.getRootView().setVisibility(8);
                            a.this.nEn.getRootView().setVisibility(8);
                            a.this.nEl.yF(false);
                            a.this.nEm.yF(true);
                            a.this.nEn.yF(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.nEp.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dQR();
                    a.this.dQS();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQR() {
        aq aqVar = new aq("c12424");
        aqVar.an("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQS() {
        if (this.mCurrentTabIndex == 0) {
            dQW();
            dQU();
            return;
        }
        replay();
    }

    public void replay() {
        dQW();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.nEk.start();
        this.nEk.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dQW();
        this.nEl.onPause();
        this.nEm.onPause();
        this.nEn.onPause();
    }

    public void onResume() {
        this.nEk.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.nEk.resumeMedia();
        }
        this.nEl.onResume();
        this.nEm.onResume();
        this.nEn.onResume();
    }

    public MaskVideoView dQT() {
        return this.nEk;
    }

    public Bitmap G(Bitmap bitmap) {
        return this.nEl.G(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.nEm.setMusicData(list);
    }

    public void ga(List<PendantData> list) {
        this.nEl.ga(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.nEn != null) {
            this.nEn.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a Tr(String str) {
        if (this.nEn == null || at.isEmpty(str)) {
            return null;
        }
        return this.nEn.Tt(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.nEk != null) {
            this.nEk.setFilter(aVar);
        }
        if (this.nEn != null) {
            this.nEn.d(aVar);
        }
    }

    public void gz(String str, String str2) {
        if (this.nEm != null) {
            this.nEm.gB(str, str2);
        }
    }

    public void yG(boolean z) {
        if (this.nEm != null) {
            this.nEm.yH(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.nEl.setData(str);
                this.nEk.setVideoPath(str);
                this.nEk.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.mMediaPlayer = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.mMediaPlayer.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.mMediaPlayer.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.nEl.dRe();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.nEk.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.nEk.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.nEk.seekTo(a.this.nEl.getCurrentPosition());
                    }
                });
                this.nEk.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.nEm.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dQU() {
        if (this.nEk != null) {
            this.nEk.seekTo(this.nEl.getCurrentPosition());
        }
    }

    public void dQV() {
        if (this.nEk != null) {
            this.nEk.Kj(this.nEl.getCurrentPosition());
        }
    }

    public void dQW() {
        if (this.nEk != null) {
            this.nEk.dRa();
        }
    }

    public void dQX() {
        if (this.nEk != null) {
            this.nEk.onPause();
        }
    }

    public void onChangeSkinType(f fVar, int i) {
        this.mNavigationBar.onChangeSkinType(fVar, i);
        this.nEp.onChangeSkinType(i);
        this.nEp.setDiverColor(ao.getColor(i, R.color.CAM_X0105));
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.nEl != null) {
            this.nEl.onChangeSkinType(fVar, i);
        }
        if (this.nEm != null) {
            this.nEm.onChangeSkinType(fVar, i);
        }
    }

    private void bEt() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Pd();
            }
        });
        ao.setViewTextColor(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.nEl.hideSoftKeyPad();
                if (a.this.nDd != null) {
                    a.this.nDd.onNext();
                }
            }
        }), R.color.CAM_X0106);
    }

    public String getText() {
        return this.nEl.getText();
    }

    public int getCurrentPosition() {
        if (this.nEk == null) {
            return 0;
        }
        return this.nEk.getCurrentPosition();
    }

    public void Pd() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && at.equals(((EditVideoActivity) this.mContext.getPageActivity()).bnj(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.nDd.finishPage();
            return;
        }
        if (this.mpQ == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.mpQ = new i(getPageContext());
            this.mpQ.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.mpQ.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.eTB);
        }
        this.mpQ.Pd();
    }

    public void gA(String str, String str2) {
        this.nEm.gA(str, str2);
    }

    public void dQl() {
        if (this.nDd != null) {
            this.nDd.dQl();
        }
    }

    public String dQY() {
        return this.nEm.dQY();
    }

    public String dQZ() {
        return this.nEm.dQZ();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.nEl != null) {
            this.nEl.release();
        }
        if (this.nEk != null) {
            this.nEk.stopPlayback();
        }
    }

    public void am(Intent intent) {
        this.nEm.am(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dQT() != null) {
            dQT().setGenMaskCoverListener(bVar);
        }
    }
}
