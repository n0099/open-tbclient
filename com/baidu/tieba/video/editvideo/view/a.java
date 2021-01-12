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
    private com.baidu.tieba.video.editvideo.a nDc;
    private MaskVideoView nEj;
    private c nEk;
    private e nEl;
    private d nEm;
    private FrameLayout nEn;
    private FragmentTabWidget nEo;
    private g noh;

    public a(f fVar, com.baidu.tieba.video.editvideo.a aVar, View view, g gVar) {
        super(fVar);
        this.mCurrentTabIndex = 0;
        this.eTB = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.nDc != null) {
                            a.this.nDc.bzc();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.nDc != null) {
                            a.this.nDc.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.mpQ != null && a.this.mpQ.isShowing() && a.this.getPageContext() != null) {
                    a.this.mpQ.dismiss();
                }
            }
        };
        this.nDc = aVar;
        this.mRootView = view;
        this.noh = gVar;
        this.mResources = view.getResources();
        this.nEk = new c(this.mContext, this);
        this.nEl = new e(this.mContext, this, this.noh);
        this.nEm = new d(this.mContext, this);
        this.nEk.eo(this.mRootView);
        this.nEl.eo(this.mRootView);
        this.nEm.eo(this.mRootView);
        initView();
        dQR();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.nEj = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.nEj.setPreserveEGLContextOnPause(true);
        this.nEj.setZOrderMediaOverlay(true);
        this.nEj.setPostMonitorManager(this.noh);
        this.nEn = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.nEn.addView(this.nEk.getRootView());
        this.nEo = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bEt();
        dQQ();
        this.nEn.addView(this.nEl.getRootView());
        this.nEn.addView(this.nEm.getRootView());
        this.nEl.getRootView().setVisibility(8);
        this.nEm.getRootView().setVisibility(8);
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
            this.nEo.addView(fragmentTabIndicator, i);
        }
        if (!dQP() && this.nEo.getChildAt(1) != null) {
            this.nEo.getChildAt(1).setVisibility(8);
        }
        this.nEo.setDiverColor(this.mResources.getColor(R.color.CAM_X0105));
        this.nEo.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.nEo.setBackGroundDrawableResId(R.color.CAM_X0201);
        this.nEo.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.nEo.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.nEk.getRootView().setVisibility(0);
                            a.this.nEl.getRootView().setVisibility(8);
                            a.this.nEm.getRootView().setVisibility(8);
                            a.this.nEk.yF(true);
                            a.this.nEl.yF(false);
                            a.this.nEm.yF(false);
                            break;
                        case 1:
                            a.this.nEm.getRootView().setVisibility(0);
                            a.this.nEl.getRootView().setVisibility(8);
                            a.this.nEk.getRootView().setVisibility(8);
                            a.this.nEk.yF(false);
                            if (TextUtils.isEmpty(a.this.nEl.dQY())) {
                                a.this.nEl.yF(false);
                            } else {
                                a.this.nEl.yF(true);
                            }
                            a.this.nEm.yF(true);
                            break;
                        case 2:
                            a.this.nEl.getRootView().setVisibility(0);
                            a.this.nEk.getRootView().setVisibility(8);
                            a.this.nEm.getRootView().setVisibility(8);
                            a.this.nEk.yF(false);
                            a.this.nEl.yF(true);
                            a.this.nEm.yF(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.nEo.setCurrentTab(a.this.mCurrentTabIndex, true, true);
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
        this.nEj.start();
        this.nEj.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dQW();
        this.nEk.onPause();
        this.nEl.onPause();
        this.nEm.onPause();
    }

    public void onResume() {
        this.nEj.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.nEj.resumeMedia();
        }
        this.nEk.onResume();
        this.nEl.onResume();
        this.nEm.onResume();
    }

    public MaskVideoView dQT() {
        return this.nEj;
    }

    public Bitmap G(Bitmap bitmap) {
        return this.nEk.G(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.nEl.setMusicData(list);
    }

    public void ga(List<PendantData> list) {
        this.nEk.ga(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.nEm != null) {
            this.nEm.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a Tq(String str) {
        if (this.nEm == null || at.isEmpty(str)) {
            return null;
        }
        return this.nEm.Ts(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.nEj != null) {
            this.nEj.setFilter(aVar);
        }
        if (this.nEm != null) {
            this.nEm.d(aVar);
        }
    }

    public void gz(String str, String str2) {
        if (this.nEl != null) {
            this.nEl.gB(str, str2);
        }
    }

    public void yG(boolean z) {
        if (this.nEl != null) {
            this.nEl.yH(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.nEk.setData(str);
                this.nEj.setVideoPath(str);
                this.nEj.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.nEk.dRe();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.nEj.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.nEj.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.nEj.seekTo(a.this.nEk.getCurrentPosition());
                    }
                });
                this.nEj.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.nEl.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dQU() {
        if (this.nEj != null) {
            this.nEj.seekTo(this.nEk.getCurrentPosition());
        }
    }

    public void dQV() {
        if (this.nEj != null) {
            this.nEj.Kj(this.nEk.getCurrentPosition());
        }
    }

    public void dQW() {
        if (this.nEj != null) {
            this.nEj.dRa();
        }
    }

    public void dQX() {
        if (this.nEj != null) {
            this.nEj.onPause();
        }
    }

    public void onChangeSkinType(f fVar, int i) {
        this.mNavigationBar.onChangeSkinType(fVar, i);
        this.nEo.onChangeSkinType(i);
        this.nEo.setDiverColor(ao.getColor(i, R.color.CAM_X0105));
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.nEk != null) {
            this.nEk.onChangeSkinType(fVar, i);
        }
        if (this.nEl != null) {
            this.nEl.onChangeSkinType(fVar, i);
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
                a.this.nEk.hideSoftKeyPad();
                if (a.this.nDc != null) {
                    a.this.nDc.onNext();
                }
            }
        }), R.color.CAM_X0106);
    }

    public String getText() {
        return this.nEk.getText();
    }

    public int getCurrentPosition() {
        if (this.nEj == null) {
            return 0;
        }
        return this.nEj.getCurrentPosition();
    }

    public void Pd() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && at.equals(((EditVideoActivity) this.mContext.getPageActivity()).bnj(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.nDc.finishPage();
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
        this.nEl.gA(str, str2);
    }

    public void dQl() {
        if (this.nDc != null) {
            this.nDc.dQl();
        }
    }

    public String dQY() {
        return this.nEl.dQY();
    }

    public String dQZ() {
        return this.nEl.dQZ();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.nEk != null) {
            this.nEk.release();
        }
        if (this.nEj != null) {
            this.nEj.stopPlayback();
        }
    }

    public void am(Intent intent) {
        this.nEl.am(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dQT() != null) {
            dQT().setGenMaskCoverListener(bVar);
        }
    }
}
