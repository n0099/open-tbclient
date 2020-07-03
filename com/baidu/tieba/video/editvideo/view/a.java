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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.k.h;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends com.baidu.adp.base.c {
    private k.c dQc;
    private i kLf;
    private h lHf;
    private com.baidu.tieba.video.editvideo.a lWZ;
    private MaskVideoView lYi;
    private c lYj;
    private e lYk;
    private d lYl;
    private FrameLayout lYm;
    private FragmentTabWidget lYn;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(com.baidu.adp.base.e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.dQc = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.lWZ != null) {
                            a.this.lWZ.dmJ();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.lWZ != null) {
                            a.this.lWZ.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.kLf != null && a.this.kLf.isShowing() && a.this.getPageContext() != null) {
                    a.this.kLf.dismiss();
                }
            }
        };
        this.lWZ = aVar;
        this.mRootView = view;
        this.lHf = hVar;
        this.mResources = view.getResources();
        this.lYj = new c(this.mContext, this);
        this.lYk = new e(this.mContext, this, this.lHf);
        this.lYl = new d(this.mContext, this);
        this.lYj.dg(this.mRootView);
        this.lYk.dg(this.mRootView);
        this.lYl.dg(this.mRootView);
        initView();
        dno();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.lYi = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.lYi.setPreserveEGLContextOnPause(true);
        this.lYi.setZOrderMediaOverlay(true);
        this.lYi.setPostMonitorManager(this.lHf);
        this.lYm = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.lYm.addView(this.lYj.getRootView());
        this.lYn = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        biq();
        dnn();
        this.lYm.addView(this.lYk.getRootView());
        this.lYm.addView(this.lYl.getRootView());
        this.lYk.getRootView().setVisibility(8);
        this.lYl.getRootView().setVisibility(8);
    }

    private boolean dnm() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dnn() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.lYn.addView(fragmentTabIndicator, i);
        }
        if (!dnm() && this.lYn.getChildAt(1) != null) {
            this.lYn.getChildAt(1).setVisibility(8);
        }
        this.lYn.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.lYn.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.lYn.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.lYn.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.lYn.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.lYj.getRootView().setVisibility(0);
                            a.this.lYk.getRootView().setVisibility(8);
                            a.this.lYl.getRootView().setVisibility(8);
                            a.this.lYj.vj(true);
                            a.this.lYk.vj(false);
                            a.this.lYl.vj(false);
                            break;
                        case 1:
                            a.this.lYl.getRootView().setVisibility(0);
                            a.this.lYk.getRootView().setVisibility(8);
                            a.this.lYj.getRootView().setVisibility(8);
                            a.this.lYj.vj(false);
                            if (TextUtils.isEmpty(a.this.lYk.dnw())) {
                                a.this.lYk.vj(false);
                            } else {
                                a.this.lYk.vj(true);
                            }
                            a.this.lYl.vj(true);
                            break;
                        case 2:
                            a.this.lYk.getRootView().setVisibility(0);
                            a.this.lYj.getRootView().setVisibility(8);
                            a.this.lYl.getRootView().setVisibility(8);
                            a.this.lYj.vj(false);
                            a.this.lYk.vj(true);
                            a.this.lYl.vj(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.lYn.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dno();
                    a.this.dnp();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dno() {
        ao aoVar = new ao("c12424");
        aoVar.ag("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(aoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnp() {
        if (this.mCurrentTabIndex == 0) {
            dnu();
            dnr();
            return;
        }
        replay();
    }

    public void replay() {
        dnu();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.lYi.start();
        this.lYi.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dnu();
        this.lYj.onPause();
        this.lYk.onPause();
        this.lYl.onPause();
    }

    public void onResume() {
        this.lYi.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.lYi.resumeMedia();
        }
        this.lYj.onResume();
        this.lYk.onResume();
        this.lYl.onResume();
    }

    public MaskVideoView dnq() {
        return this.lYi;
    }

    public Bitmap D(Bitmap bitmap) {
        return this.lYj.D(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.lYk.setMusicData(list);
    }

    public void fa(List<PendantData> list) {
        this.lYj.fa(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.lYl != null) {
            this.lYl.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a Oh(String str) {
        if (this.lYl == null || ar.isEmpty(str)) {
            return null;
        }
        return this.lYl.Oj(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.lYi != null) {
            this.lYi.setFilter(aVar);
        }
        if (this.lYl != null) {
            this.lYl.d(aVar);
        }
    }

    public void fG(String str, String str2) {
        if (this.lYk != null) {
            this.lYk.fI(str, str2);
        }
    }

    public void vk(boolean z) {
        if (this.lYk != null) {
            this.lYk.vl(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.lYj.setData(str);
                this.lYi.setVideoPath(str);
                this.lYi.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.mMediaPlayer = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.mMediaPlayer.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.mMediaPlayer.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.lYj.dnD();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.lYi.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.lYi.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.lYi.seekTo(a.this.lYj.getCurrentPosition());
                    }
                });
                this.lYi.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.lYk.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dnr() {
        if (this.lYi != null) {
            this.lYi.seekTo(this.lYj.getCurrentPosition());
        }
    }

    public void dnt() {
        if (this.lYi != null) {
            this.lYi.Ga(this.lYj.getCurrentPosition());
        }
    }

    public void dnu() {
        if (this.lYi != null) {
            this.lYi.dnz();
        }
    }

    public void dnv() {
        if (this.lYi != null) {
            this.lYi.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.lYn.onChangeSkinType(i);
        this.lYn.setDiverColor(an.getColor(i, R.color.cp_cont_b));
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.lYj != null) {
            this.lYj.onChangeSkinType(eVar, i);
        }
        if (this.lYk != null) {
            this.lYk.onChangeSkinType(eVar, i);
        }
    }

    private void biq() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        an.setViewTextColor(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.lYj.hideSoftKeyPad();
                if (a.this.lWZ != null) {
                    a.this.lWZ.onNext();
                }
            }
        }), (int) R.color.cp_cont_f);
    }

    public String getText() {
        return this.lYj.getText();
    }

    public int getCurrentPosition() {
        if (this.lYi == null) {
            return 0;
        }
        return this.lYi.getCurrentPosition();
    }

    public void showDialog() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && ar.equals(((EditVideoActivity) this.mContext.getPageActivity()).aSb(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.lWZ.finishPage();
            return;
        }
        if (this.kLf == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.kLf = new i(getPageContext());
            this.kLf.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.kLf.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.dQc);
        }
        this.kLf.showDialog();
    }

    public void fH(String str, String str2) {
        this.lYk.fH(str, str2);
    }

    public void dmK() {
        if (this.lWZ != null) {
            this.lWZ.dmK();
        }
    }

    public String dnw() {
        return this.lYk.dnw();
    }

    public String dnx() {
        return this.lYk.dnx();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean dny() {
        return this.lYk.dny();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.lYj != null) {
            this.lYj.release();
        }
        if (this.lYi != null) {
            this.lYi.stopPlayback();
        }
    }

    public void am(Intent intent) {
        this.lYk.am(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dnq() != null) {
            dnq().setGenMaskCoverListener(bVar);
        }
    }
}
