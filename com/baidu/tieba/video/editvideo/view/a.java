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
    private com.baidu.tieba.video.editvideo.a lXc;
    private MaskVideoView lYl;
    private c lYm;
    private e lYn;
    private d lYo;
    private FrameLayout lYp;
    private FragmentTabWidget lYq;
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
                        if (a.this.lXc != null) {
                            a.this.lXc.dmN();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.lXc != null) {
                            a.this.lXc.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.kLf != null && a.this.kLf.isShowing() && a.this.getPageContext() != null) {
                    a.this.kLf.dismiss();
                }
            }
        };
        this.lXc = aVar;
        this.mRootView = view;
        this.lHf = hVar;
        this.mResources = view.getResources();
        this.lYm = new c(this.mContext, this);
        this.lYn = new e(this.mContext, this, this.lHf);
        this.lYo = new d(this.mContext, this);
        this.lYm.dg(this.mRootView);
        this.lYn.dg(this.mRootView);
        this.lYo.dg(this.mRootView);
        initView();
        dnt();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.lYl = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.lYl.setPreserveEGLContextOnPause(true);
        this.lYl.setZOrderMediaOverlay(true);
        this.lYl.setPostMonitorManager(this.lHf);
        this.lYp = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.lYp.addView(this.lYm.getRootView());
        this.lYq = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        biq();
        dnr();
        this.lYp.addView(this.lYn.getRootView());
        this.lYp.addView(this.lYo.getRootView());
        this.lYn.getRootView().setVisibility(8);
        this.lYo.getRootView().setVisibility(8);
    }

    private boolean dnq() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dnr() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.lYq.addView(fragmentTabIndicator, i);
        }
        if (!dnq() && this.lYq.getChildAt(1) != null) {
            this.lYq.getChildAt(1).setVisibility(8);
        }
        this.lYq.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.lYq.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.lYq.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.lYq.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.lYq.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.lYm.getRootView().setVisibility(0);
                            a.this.lYn.getRootView().setVisibility(8);
                            a.this.lYo.getRootView().setVisibility(8);
                            a.this.lYm.vj(true);
                            a.this.lYn.vj(false);
                            a.this.lYo.vj(false);
                            break;
                        case 1:
                            a.this.lYo.getRootView().setVisibility(0);
                            a.this.lYn.getRootView().setVisibility(8);
                            a.this.lYm.getRootView().setVisibility(8);
                            a.this.lYm.vj(false);
                            if (TextUtils.isEmpty(a.this.lYn.dnA())) {
                                a.this.lYn.vj(false);
                            } else {
                                a.this.lYn.vj(true);
                            }
                            a.this.lYo.vj(true);
                            break;
                        case 2:
                            a.this.lYn.getRootView().setVisibility(0);
                            a.this.lYm.getRootView().setVisibility(8);
                            a.this.lYo.getRootView().setVisibility(8);
                            a.this.lYm.vj(false);
                            a.this.lYn.vj(true);
                            a.this.lYo.vj(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.lYq.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dnt();
                    a.this.dnu();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnt() {
        ao aoVar = new ao("c12424");
        aoVar.ag("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(aoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnu() {
        if (this.mCurrentTabIndex == 0) {
            dny();
            dnw();
            return;
        }
        replay();
    }

    public void replay() {
        dny();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.lYl.start();
        this.lYl.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dny();
        this.lYm.onPause();
        this.lYn.onPause();
        this.lYo.onPause();
    }

    public void onResume() {
        this.lYl.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.lYl.resumeMedia();
        }
        this.lYm.onResume();
        this.lYn.onResume();
        this.lYo.onResume();
    }

    public MaskVideoView dnv() {
        return this.lYl;
    }

    public Bitmap D(Bitmap bitmap) {
        return this.lYm.D(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.lYn.setMusicData(list);
    }

    public void fa(List<PendantData> list) {
        this.lYm.fa(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.lYo != null) {
            this.lYo.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a Oi(String str) {
        if (this.lYo == null || ar.isEmpty(str)) {
            return null;
        }
        return this.lYo.Ok(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.lYl != null) {
            this.lYl.setFilter(aVar);
        }
        if (this.lYo != null) {
            this.lYo.d(aVar);
        }
    }

    public void fG(String str, String str2) {
        if (this.lYn != null) {
            this.lYn.fI(str, str2);
        }
    }

    public void vk(boolean z) {
        if (this.lYn != null) {
            this.lYn.vl(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.lYm.setData(str);
                this.lYl.setVideoPath(str);
                this.lYl.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.lYm.dnH();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.lYl.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.lYl.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.lYl.seekTo(a.this.lYm.getCurrentPosition());
                    }
                });
                this.lYl.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.lYn.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dnw() {
        if (this.lYl != null) {
            this.lYl.seekTo(this.lYm.getCurrentPosition());
        }
    }

    public void dnx() {
        if (this.lYl != null) {
            this.lYl.Ga(this.lYm.getCurrentPosition());
        }
    }

    public void dny() {
        if (this.lYl != null) {
            this.lYl.dnD();
        }
    }

    public void dnz() {
        if (this.lYl != null) {
            this.lYl.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.lYq.onChangeSkinType(i);
        this.lYq.setDiverColor(an.getColor(i, R.color.cp_cont_b));
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.lYm != null) {
            this.lYm.onChangeSkinType(eVar, i);
        }
        if (this.lYn != null) {
            this.lYn.onChangeSkinType(eVar, i);
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
                a.this.lYm.hideSoftKeyPad();
                if (a.this.lXc != null) {
                    a.this.lXc.onNext();
                }
            }
        }), (int) R.color.cp_cont_f);
    }

    public String getText() {
        return this.lYm.getText();
    }

    public int getCurrentPosition() {
        if (this.lYl == null) {
            return 0;
        }
        return this.lYl.getCurrentPosition();
    }

    public void showDialog() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && ar.equals(((EditVideoActivity) this.mContext.getPageActivity()).aSb(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.lXc.finishPage();
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
        this.lYn.fH(str, str2);
    }

    public void dmO() {
        if (this.lXc != null) {
            this.lXc.dmO();
        }
    }

    public String dnA() {
        return this.lYn.dnA();
    }

    public String dnB() {
        return this.lYn.dnB();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean dnC() {
        return this.lYn.dnC();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.lYm != null) {
            this.lYm.release();
        }
        if (this.lYl != null) {
            this.lYl.stopPlayback();
        }
    }

    public void am(Intent intent) {
        this.lYn.am(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dnv() != null) {
            dnv().setGenMaskCoverListener(bVar);
        }
    }
}
