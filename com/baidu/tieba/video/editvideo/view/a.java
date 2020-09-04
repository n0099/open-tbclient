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
/* loaded from: classes17.dex */
public class a extends com.baidu.adp.base.c {
    private k.c efY;
    private i lkf;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;
    private h mgu;
    private com.baidu.tieba.video.editvideo.a mwx;
    private MaskVideoView mxG;
    private c mxH;
    private e mxI;
    private d mxJ;
    private FrameLayout mxK;
    private FragmentTabWidget mxL;

    public a(com.baidu.adp.base.e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.efY = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.mwx != null) {
                            a.this.mwx.bpP();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.mwx != null) {
                            a.this.mwx.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.lkf != null && a.this.lkf.isShowing() && a.this.getPageContext() != null) {
                    a.this.lkf.dismiss();
                }
            }
        };
        this.mwx = aVar;
        this.mRootView = view;
        this.mgu = hVar;
        this.mResources = view.getResources();
        this.mxH = new c(this.mContext, this);
        this.mxI = new e(this.mContext, this, this.mgu);
        this.mxJ = new d(this.mContext, this);
        this.mxH.dq(this.mRootView);
        this.mxI.dq(this.mRootView);
        this.mxJ.dq(this.mRootView);
        initView();
        dCh();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mxG = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.mxG.setPreserveEGLContextOnPause(true);
        this.mxG.setZOrderMediaOverlay(true);
        this.mxG.setPostMonitorManager(this.mgu);
        this.mxK = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.mxK.addView(this.mxH.getRootView());
        this.mxL = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        buP();
        dCg();
        this.mxK.addView(this.mxI.getRootView());
        this.mxK.addView(this.mxJ.getRootView());
        this.mxI.getRootView().setVisibility(8);
        this.mxJ.getRootView().setVisibility(8);
    }

    private boolean dCf() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dCg() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.mxL.addView(fragmentTabIndicator, i);
        }
        if (!dCf() && this.mxL.getChildAt(1) != null) {
            this.mxL.getChildAt(1).setVisibility(8);
        }
        this.mxL.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.mxL.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.mxL.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.mxL.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.mxL.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.mxH.getRootView().setVisibility(0);
                            a.this.mxI.getRootView().setVisibility(8);
                            a.this.mxJ.getRootView().setVisibility(8);
                            a.this.mxH.wE(true);
                            a.this.mxI.wE(false);
                            a.this.mxJ.wE(false);
                            break;
                        case 1:
                            a.this.mxJ.getRootView().setVisibility(0);
                            a.this.mxI.getRootView().setVisibility(8);
                            a.this.mxH.getRootView().setVisibility(8);
                            a.this.mxH.wE(false);
                            if (TextUtils.isEmpty(a.this.mxI.dCo())) {
                                a.this.mxI.wE(false);
                            } else {
                                a.this.mxI.wE(true);
                            }
                            a.this.mxJ.wE(true);
                            break;
                        case 2:
                            a.this.mxI.getRootView().setVisibility(0);
                            a.this.mxH.getRootView().setVisibility(8);
                            a.this.mxJ.getRootView().setVisibility(8);
                            a.this.mxH.wE(false);
                            a.this.mxI.wE(true);
                            a.this.mxJ.wE(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.mxL.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dCh();
                    a.this.dCi();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCh() {
        aq aqVar = new aq("c12424");
        aqVar.ai("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCi() {
        if (this.mCurrentTabIndex == 0) {
            dCm();
            dCk();
            return;
        }
        replay();
    }

    public void replay() {
        dCm();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.mxG.start();
        this.mxG.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dCm();
        this.mxH.onPause();
        this.mxI.onPause();
        this.mxJ.onPause();
    }

    public void onResume() {
        this.mxG.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.mxG.resumeMedia();
        }
        this.mxH.onResume();
        this.mxI.onResume();
        this.mxJ.onResume();
    }

    public MaskVideoView dCj() {
        return this.mxG;
    }

    public Bitmap G(Bitmap bitmap) {
        return this.mxH.G(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.mxI.setMusicData(list);
    }

    public void fo(List<PendantData> list) {
        this.mxH.fo(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.mxJ != null) {
            this.mxJ.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a RO(String str) {
        if (this.mxJ == null || at.isEmpty(str)) {
            return null;
        }
        return this.mxJ.RQ(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.mxG != null) {
            this.mxG.setFilter(aVar);
        }
        if (this.mxJ != null) {
            this.mxJ.d(aVar);
        }
    }

    public void ga(String str, String str2) {
        if (this.mxI != null) {
            this.mxI.gc(str, str2);
        }
    }

    public void wF(boolean z) {
        if (this.mxI != null) {
            this.mxI.wG(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.mxH.setData(str);
                this.mxG.setVideoPath(str);
                this.mxG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.mMediaPlayer = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.mMediaPlayer.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.mMediaPlayer.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.mxH.dCv();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.mxG.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.mxG.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.mxG.seekTo(a.this.mxH.getCurrentPosition());
                    }
                });
                this.mxG.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.mxI.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dCk() {
        if (this.mxG != null) {
            this.mxG.seekTo(this.mxH.getCurrentPosition());
        }
    }

    public void dCl() {
        if (this.mxG != null) {
            this.mxG.IS(this.mxH.getCurrentPosition());
        }
    }

    public void dCm() {
        if (this.mxG != null) {
            this.mxG.dCr();
        }
    }

    public void dCn() {
        if (this.mxG != null) {
            this.mxG.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.mxL.onChangeSkinType(i);
        this.mxL.setDiverColor(ap.getColor(i, R.color.cp_cont_b));
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.mxH != null) {
            this.mxH.onChangeSkinType(eVar, i);
        }
        if (this.mxI != null) {
            this.mxI.onChangeSkinType(eVar, i);
        }
    }

    private void buP() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Nv();
            }
        });
        ap.setViewTextColor(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.mxH.hideSoftKeyPad();
                if (a.this.mwx != null) {
                    a.this.mwx.onNext();
                }
            }
        }), R.color.cp_cont_f);
    }

    public String getText() {
        return this.mxH.getText();
    }

    public int getCurrentPosition() {
        if (this.mxG == null) {
            return 0;
        }
        return this.mxG.getCurrentPosition();
    }

    public void Nv() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && at.equals(((EditVideoActivity) this.mContext.getPageActivity()).beq(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.mwx.finishPage();
            return;
        }
        if (this.lkf == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.lkf = new i(getPageContext());
            this.lkf.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.lkf.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.efY);
        }
        this.lkf.Nv();
    }

    public void gb(String str, String str2) {
        this.mxI.gb(str, str2);
    }

    public void dBD() {
        if (this.mwx != null) {
            this.mwx.dBD();
        }
    }

    public String dCo() {
        return this.mxI.dCo();
    }

    public String dCp() {
        return this.mxI.dCp();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean dCq() {
        return this.mxI.dCq();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.mxH != null) {
            this.mxH.release();
        }
        if (this.mxG != null) {
            this.mxG.stopPlayback();
        }
    }

    public void ap(Intent intent) {
        this.mxI.ap(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dCj() != null) {
            dCj().setGenMaskCoverListener(bVar);
        }
    }
}
