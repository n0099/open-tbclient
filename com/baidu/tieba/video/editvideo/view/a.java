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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
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
    private k.c dWu;
    private i kUg;
    private h lOt;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;
    private com.baidu.tieba.video.editvideo.a met;
    private MaskVideoView mfC;
    private c mfD;
    private e mfE;
    private d mfF;
    private FrameLayout mfG;
    private FragmentTabWidget mfH;

    public a(com.baidu.adp.base.e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.dWu = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.met != null) {
                            a.this.met.bhc();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.met != null) {
                            a.this.met.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.kUg != null && a.this.kUg.isShowing() && a.this.getPageContext() != null) {
                    a.this.kUg.dismiss();
                }
            }
        };
        this.met = aVar;
        this.mRootView = view;
        this.lOt = hVar;
        this.mResources = view.getResources();
        this.mfD = new c(this.mContext, this);
        this.mfE = new e(this.mContext, this, this.lOt);
        this.mfF = new d(this.mContext, this);
        this.mfD.dm(this.mRootView);
        this.mfE.dm(this.mRootView);
        this.mfF.dm(this.mRootView);
        initView();
        dqC();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mfC = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.mfC.setPreserveEGLContextOnPause(true);
        this.mfC.setZOrderMediaOverlay(true);
        this.mfC.setPostMonitorManager(this.lOt);
        this.mfG = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.mfG.addView(this.mfD.getRootView());
        this.mfH = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bmb();
        dqB();
        this.mfG.addView(this.mfE.getRootView());
        this.mfG.addView(this.mfF.getRootView());
        this.mfE.getRootView().setVisibility(8);
        this.mfF.getRootView().setVisibility(8);
    }

    private boolean dqA() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dqB() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.mfH.addView(fragmentTabIndicator, i);
        }
        if (!dqA() && this.mfH.getChildAt(1) != null) {
            this.mfH.getChildAt(1).setVisibility(8);
        }
        this.mfH.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.mfH.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.mfH.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.mfH.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.mfH.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.mfD.getRootView().setVisibility(0);
                            a.this.mfE.getRootView().setVisibility(8);
                            a.this.mfF.getRootView().setVisibility(8);
                            a.this.mfD.vN(true);
                            a.this.mfE.vN(false);
                            a.this.mfF.vN(false);
                            break;
                        case 1:
                            a.this.mfF.getRootView().setVisibility(0);
                            a.this.mfE.getRootView().setVisibility(8);
                            a.this.mfD.getRootView().setVisibility(8);
                            a.this.mfD.vN(false);
                            if (TextUtils.isEmpty(a.this.mfE.dqJ())) {
                                a.this.mfE.vN(false);
                            } else {
                                a.this.mfE.vN(true);
                            }
                            a.this.mfF.vN(true);
                            break;
                        case 2:
                            a.this.mfE.getRootView().setVisibility(0);
                            a.this.mfD.getRootView().setVisibility(8);
                            a.this.mfF.getRootView().setVisibility(8);
                            a.this.mfD.vN(false);
                            a.this.mfE.vN(true);
                            a.this.mfF.vN(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.mfH.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dqC();
                    a.this.dqD();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqC() {
        ap apVar = new ap("c12424");
        apVar.ah("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(apVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqD() {
        if (this.mCurrentTabIndex == 0) {
            dqH();
            dqF();
            return;
        }
        replay();
    }

    public void replay() {
        dqH();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.mfC.start();
        this.mfC.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dqH();
        this.mfD.onPause();
        this.mfE.onPause();
        this.mfF.onPause();
    }

    public void onResume() {
        this.mfC.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.mfC.resumeMedia();
        }
        this.mfD.onResume();
        this.mfE.onResume();
        this.mfF.onResume();
    }

    public MaskVideoView dqE() {
        return this.mfC;
    }

    public Bitmap G(Bitmap bitmap) {
        return this.mfD.G(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.mfE.setMusicData(list);
    }

    public void fg(List<PendantData> list) {
        this.mfD.fg(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.mfF != null) {
            this.mfF.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a OQ(String str) {
        if (this.mfF == null || as.isEmpty(str)) {
            return null;
        }
        return this.mfF.OS(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.mfC != null) {
            this.mfC.setFilter(aVar);
        }
        if (this.mfF != null) {
            this.mfF.d(aVar);
        }
    }

    public void fI(String str, String str2) {
        if (this.mfE != null) {
            this.mfE.fK(str, str2);
        }
    }

    public void vO(boolean z) {
        if (this.mfE != null) {
            this.mfE.vP(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.mfD.setData(str);
                this.mfC.setVideoPath(str);
                this.mfC.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.mfD.dqQ();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.mfC.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.mfC.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.mfC.seekTo(a.this.mfD.getCurrentPosition());
                    }
                });
                this.mfC.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.mfE.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dqF() {
        if (this.mfC != null) {
            this.mfC.seekTo(this.mfD.getCurrentPosition());
        }
    }

    public void dqG() {
        if (this.mfC != null) {
            this.mfC.Gw(this.mfD.getCurrentPosition());
        }
    }

    public void dqH() {
        if (this.mfC != null) {
            this.mfC.dqM();
        }
    }

    public void dqI() {
        if (this.mfC != null) {
            this.mfC.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.mfH.onChangeSkinType(i);
        this.mfH.setDiverColor(ao.getColor(i, R.color.cp_cont_b));
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.mfD != null) {
            this.mfD.onChangeSkinType(eVar, i);
        }
        if (this.mfE != null) {
            this.mfE.onChangeSkinType(eVar, i);
        }
    }

    private void bmb() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        ao.setViewTextColor(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.mfD.hideSoftKeyPad();
                if (a.this.met != null) {
                    a.this.met.onNext();
                }
            }
        }), R.color.cp_cont_f);
    }

    public String getText() {
        return this.mfD.getText();
    }

    public int getCurrentPosition() {
        if (this.mfC == null) {
            return 0;
        }
        return this.mfC.getCurrentPosition();
    }

    public void showDialog() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && as.equals(((EditVideoActivity) this.mContext.getPageActivity()).aVX(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.met.finishPage();
            return;
        }
        if (this.kUg == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.kUg = new i(getPageContext());
            this.kUg.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.kUg.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.dWu);
        }
        this.kUg.showDialog();
    }

    public void fJ(String str, String str2) {
        this.mfE.fJ(str, str2);
    }

    public void dpY() {
        if (this.met != null) {
            this.met.dpY();
        }
    }

    public String dqJ() {
        return this.mfE.dqJ();
    }

    public String dqK() {
        return this.mfE.dqK();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean dqL() {
        return this.mfE.dqL();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.mfD != null) {
            this.mfD.release();
        }
        if (this.mfC != null) {
            this.mfC.stopPlayback();
        }
    }

    public void an(Intent intent) {
        this.mfE.an(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dqE() != null) {
            dqE().setGenMaskCoverListener(bVar);
        }
    }
}
