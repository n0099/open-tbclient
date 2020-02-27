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
import com.baidu.tieba.k.h;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends com.baidu.adp.base.c {
    private k.c cVN;
    private i jmc;
    private h khL;
    private com.baidu.tieba.video.editvideo.a kxi;
    private MaskVideoView kyo;
    private b kyp;
    private d kyq;
    private c kyr;
    private FrameLayout kys;
    private FragmentTabWidget kyt;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.cVN = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.kxi != null) {
                            a.this.kxi.cPE();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.kxi != null) {
                            a.this.kxi.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.jmc != null && a.this.jmc.isShowing() && a.this.getPageContext() != null) {
                    a.this.jmc.dismiss();
                }
            }
        };
        this.kxi = aVar;
        this.mRootView = view;
        this.khL = hVar;
        this.mResources = view.getResources();
        this.kyp = new b(this.mContext, this);
        this.kyq = new d(this.mContext, this, this.khL);
        this.kyr = new c(this.mContext, this);
        this.kyp.cW(this.mRootView);
        this.kyq.cW(this.mRootView);
        this.kyr.cW(this.mRootView);
        initView();
        cQk();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.kyo = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.kyo.setPreserveEGLContextOnPause(true);
        this.kyo.setZOrderMediaOverlay(true);
        this.kyo.setPostMonitorManager(this.khL);
        this.kys = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.kys.addView(this.kyp.getRootView());
        this.kyt = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bcH();
        cQj();
        this.kys.addView(this.kyq.getRootView());
        this.kys.addView(this.kyr.getRootView());
        this.kyq.getRootView().setVisibility(8);
        this.kyr.getRootView().setVisibility(8);
    }

    private boolean cQi() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void cQj() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.kyt.addView(fragmentTabIndicator, i);
        }
        if (!cQi() && this.kyt.getChildAt(1) != null) {
            this.kyt.getChildAt(1).setVisibility(8);
        }
        this.kyt.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.kyt.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.kyt.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.kyt.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.kyt.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.kyp.getRootView().setVisibility(0);
                            a.this.kyq.getRootView().setVisibility(8);
                            a.this.kyr.getRootView().setVisibility(8);
                            a.this.kyp.to(true);
                            a.this.kyq.to(false);
                            a.this.kyr.to(false);
                            break;
                        case 1:
                            a.this.kyr.getRootView().setVisibility(0);
                            a.this.kyq.getRootView().setVisibility(8);
                            a.this.kyp.getRootView().setVisibility(8);
                            a.this.kyp.to(false);
                            if (TextUtils.isEmpty(a.this.kyq.cQr())) {
                                a.this.kyq.to(false);
                            } else {
                                a.this.kyq.to(true);
                            }
                            a.this.kyr.to(true);
                            break;
                        case 2:
                            a.this.kyq.getRootView().setVisibility(0);
                            a.this.kyp.getRootView().setVisibility(8);
                            a.this.kyr.getRootView().setVisibility(8);
                            a.this.kyp.to(false);
                            a.this.kyq.to(true);
                            a.this.kyr.to(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.kyt.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.cQk();
                    a.this.cQl();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQk() {
        an anVar = new an("c12424");
        anVar.X("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQl() {
        if (this.mCurrentTabIndex == 0) {
            cQp();
            cQn();
            return;
        }
        replay();
    }

    public void replay() {
        cQp();
        this.kyo.start();
        this.kyo.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.mMediaPlayer != null) {
            this.mIsMute = z;
            if (z) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        cQp();
        this.kyp.onPause();
        this.kyq.onPause();
        this.kyr.onPause();
    }

    public void onResume() {
        this.kyo.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.kyo.resumeMedia();
        }
        this.kyp.onResume();
        this.kyq.onResume();
        this.kyr.onResume();
    }

    public MaskVideoView cQm() {
        return this.kyo;
    }

    public Bitmap z(Bitmap bitmap) {
        return this.kyp.z(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.kyq.setMusicData(list);
    }

    public void ep(List<PendantData> list) {
        this.kyp.ep(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.kyr != null) {
            this.kyr.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.kyp.setData(str);
                this.kyo.setVideoPath(str);
                this.kyo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.mMediaPlayer = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.mMediaPlayer.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.mMediaPlayer.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.kyp.cQx();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.kyo.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.kyo.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.kyo.seekTo(a.this.kyp.getCurrentPosition());
                    }
                });
                this.kyo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.kyq.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cQn() {
        if (this.kyo != null) {
            this.kyo.seekTo(this.kyp.getCurrentPosition());
        }
    }

    public void cQo() {
        if (this.kyo != null) {
            this.kyo.Dz(this.kyp.getCurrentPosition());
        }
    }

    public void cQp() {
        if (this.kyo != null) {
            this.kyo.cQu();
        }
    }

    public void cQq() {
        if (this.kyo != null) {
            this.kyo.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.kyt.onChangeSkinType(i);
        this.kyt.setDiverColor(am.getColor(i, R.color.cp_cont_b));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.kyp != null) {
            this.kyp.onChangeSkinType(eVar, i);
        }
        if (this.kyq != null) {
            this.kyq.onChangeSkinType(eVar, i);
        }
    }

    private void bcH() {
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
                a.this.kyp.hideSoftKeyPad();
                if (a.this.kxi != null) {
                    a.this.kxi.onNext();
                }
            }
        }), (int) R.color.cp_cont_f);
    }

    public String getText() {
        return this.kyp.getText();
    }

    public int getCurrentPosition() {
        if (this.kyo == null) {
            return 0;
        }
        return this.kyo.getCurrentPosition();
    }

    public void showDialog() {
        if (this.jmc == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.jmc = new i(getPageContext());
            this.jmc.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.jmc.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.cVN);
        }
        this.jmc.showDialog();
    }

    public void eK(String str, String str2) {
        this.kyq.eK(str, str2);
    }

    public void cPG() {
        if (this.kxi != null) {
            this.kxi.cPG();
        }
    }

    public String cQr() {
        return this.kyq.cQr();
    }

    public String cQs() {
        return this.kyq.cQs();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean cQt() {
        return this.kyq.cQt();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.kyp != null) {
            this.kyp.release();
        }
        if (this.kyo != null) {
            this.kyo.stopPlayback();
        }
    }

    public void aA(Intent intent) {
        this.kyq.aA(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && cQm() != null) {
            cQm().setGenMaskCoverListener(bVar);
        }
    }
}
