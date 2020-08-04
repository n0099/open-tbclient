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
    private i kUi;
    private h lOv;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;
    private com.baidu.tieba.video.editvideo.a mev;
    private MaskVideoView mfE;
    private c mfF;
    private e mfG;
    private d mfH;
    private FrameLayout mfI;
    private FragmentTabWidget mfJ;

    public a(com.baidu.adp.base.e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.dWu = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.mev != null) {
                            a.this.mev.bhc();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.mev != null) {
                            a.this.mev.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.kUi != null && a.this.kUi.isShowing() && a.this.getPageContext() != null) {
                    a.this.kUi.dismiss();
                }
            }
        };
        this.mev = aVar;
        this.mRootView = view;
        this.lOv = hVar;
        this.mResources = view.getResources();
        this.mfF = new c(this.mContext, this);
        this.mfG = new e(this.mContext, this, this.lOv);
        this.mfH = new d(this.mContext, this);
        this.mfF.dm(this.mRootView);
        this.mfG.dm(this.mRootView);
        this.mfH.dm(this.mRootView);
        initView();
        dqD();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mfE = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.mfE.setPreserveEGLContextOnPause(true);
        this.mfE.setZOrderMediaOverlay(true);
        this.mfE.setPostMonitorManager(this.lOv);
        this.mfI = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.mfI.addView(this.mfF.getRootView());
        this.mfJ = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        bmb();
        dqC();
        this.mfI.addView(this.mfG.getRootView());
        this.mfI.addView(this.mfH.getRootView());
        this.mfG.getRootView().setVisibility(8);
        this.mfH.getRootView().setVisibility(8);
    }

    private boolean dqB() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dqC() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.mfJ.addView(fragmentTabIndicator, i);
        }
        if (!dqB() && this.mfJ.getChildAt(1) != null) {
            this.mfJ.getChildAt(1).setVisibility(8);
        }
        this.mfJ.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.mfJ.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.mfJ.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.mfJ.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.mfJ.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.mfF.getRootView().setVisibility(0);
                            a.this.mfG.getRootView().setVisibility(8);
                            a.this.mfH.getRootView().setVisibility(8);
                            a.this.mfF.vN(true);
                            a.this.mfG.vN(false);
                            a.this.mfH.vN(false);
                            break;
                        case 1:
                            a.this.mfH.getRootView().setVisibility(0);
                            a.this.mfG.getRootView().setVisibility(8);
                            a.this.mfF.getRootView().setVisibility(8);
                            a.this.mfF.vN(false);
                            if (TextUtils.isEmpty(a.this.mfG.dqK())) {
                                a.this.mfG.vN(false);
                            } else {
                                a.this.mfG.vN(true);
                            }
                            a.this.mfH.vN(true);
                            break;
                        case 2:
                            a.this.mfG.getRootView().setVisibility(0);
                            a.this.mfF.getRootView().setVisibility(8);
                            a.this.mfH.getRootView().setVisibility(8);
                            a.this.mfF.vN(false);
                            a.this.mfG.vN(true);
                            a.this.mfH.vN(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.mfJ.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dqD();
                    a.this.dqE();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqD() {
        ap apVar = new ap("c12424");
        apVar.ah("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(apVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqE() {
        if (this.mCurrentTabIndex == 0) {
            dqI();
            dqG();
            return;
        }
        replay();
    }

    public void replay() {
        dqI();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.mfE.start();
        this.mfE.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dqI();
        this.mfF.onPause();
        this.mfG.onPause();
        this.mfH.onPause();
    }

    public void onResume() {
        this.mfE.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.mfE.resumeMedia();
        }
        this.mfF.onResume();
        this.mfG.onResume();
        this.mfH.onResume();
    }

    public MaskVideoView dqF() {
        return this.mfE;
    }

    public Bitmap G(Bitmap bitmap) {
        return this.mfF.G(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.mfG.setMusicData(list);
    }

    public void fg(List<PendantData> list) {
        this.mfF.fg(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.mfH != null) {
            this.mfH.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a OQ(String str) {
        if (this.mfH == null || as.isEmpty(str)) {
            return null;
        }
        return this.mfH.OS(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.mfE != null) {
            this.mfE.setFilter(aVar);
        }
        if (this.mfH != null) {
            this.mfH.d(aVar);
        }
    }

    public void fI(String str, String str2) {
        if (this.mfG != null) {
            this.mfG.fK(str, str2);
        }
    }

    public void vO(boolean z) {
        if (this.mfG != null) {
            this.mfG.vP(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.mfF.setData(str);
                this.mfE.setVideoPath(str);
                this.mfE.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.mfF.dqR();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.mfE.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.mfE.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.mfE.seekTo(a.this.mfF.getCurrentPosition());
                    }
                });
                this.mfE.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.mfG.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dqG() {
        if (this.mfE != null) {
            this.mfE.seekTo(this.mfF.getCurrentPosition());
        }
    }

    public void dqH() {
        if (this.mfE != null) {
            this.mfE.Gw(this.mfF.getCurrentPosition());
        }
    }

    public void dqI() {
        if (this.mfE != null) {
            this.mfE.dqN();
        }
    }

    public void dqJ() {
        if (this.mfE != null) {
            this.mfE.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.mfJ.onChangeSkinType(i);
        this.mfJ.setDiverColor(ao.getColor(i, R.color.cp_cont_b));
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.mfF != null) {
            this.mfF.onChangeSkinType(eVar, i);
        }
        if (this.mfG != null) {
            this.mfG.onChangeSkinType(eVar, i);
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
                a.this.mfF.hideSoftKeyPad();
                if (a.this.mev != null) {
                    a.this.mev.onNext();
                }
            }
        }), R.color.cp_cont_f);
    }

    public String getText() {
        return this.mfF.getText();
    }

    public int getCurrentPosition() {
        if (this.mfE == null) {
            return 0;
        }
        return this.mfE.getCurrentPosition();
    }

    public void showDialog() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && as.equals(((EditVideoActivity) this.mContext.getPageActivity()).aVX(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.mev.finishPage();
            return;
        }
        if (this.kUi == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.kUi = new i(getPageContext());
            this.kUi.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.kUi.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.dWu);
        }
        this.kUi.showDialog();
    }

    public void fJ(String str, String str2) {
        this.mfG.fJ(str, str2);
    }

    public void dpZ() {
        if (this.mev != null) {
            this.mev.dpZ();
        }
    }

    public String dqK() {
        return this.mfG.dqK();
    }

    public String dqL() {
        return this.mfG.dqL();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean dqM() {
        return this.mfG.dqM();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.mfF != null) {
            this.mfF.release();
        }
        if (this.mfE != null) {
            this.mfE.stopPlayback();
        }
    }

    public void an(Intent intent) {
        this.mfG.an(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dqF() != null) {
            dqF().setGenMaskCoverListener(bVar);
        }
    }
}
