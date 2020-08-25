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
    private k.c efU;
    private i ljY;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private MediaPlayer mMediaPlayer;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;
    private h mgf;
    private com.baidu.tieba.video.editvideo.a mwf;
    private MaskVideoView mxo;
    private c mxp;
    private e mxq;
    private d mxr;
    private FrameLayout mxs;
    private FragmentTabWidget mxt;

    public a(com.baidu.adp.base.e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.efU = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.mwf != null) {
                            a.this.mwf.bpO();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.mwf != null) {
                            a.this.mwf.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.ljY != null && a.this.ljY.isShowing() && a.this.getPageContext() != null) {
                    a.this.ljY.dismiss();
                }
            }
        };
        this.mwf = aVar;
        this.mRootView = view;
        this.mgf = hVar;
        this.mResources = view.getResources();
        this.mxp = new c(this.mContext, this);
        this.mxq = new e(this.mContext, this, this.mgf);
        this.mxr = new d(this.mContext, this);
        this.mxp.dq(this.mRootView);
        this.mxq.dq(this.mRootView);
        this.mxr.dq(this.mRootView);
        initView();
        dBY();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.mxo = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.mxo.setPreserveEGLContextOnPause(true);
        this.mxo.setZOrderMediaOverlay(true);
        this.mxo.setPostMonitorManager(this.mgf);
        this.mxs = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.mxs.addView(this.mxp.getRootView());
        this.mxt = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        buO();
        dBX();
        this.mxs.addView(this.mxq.getRootView());
        this.mxs.addView(this.mxr.getRootView());
        this.mxq.getRootView().setVisibility(8);
        this.mxr.getRootView().setVisibility(8);
    }

    private boolean dBW() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void dBX() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.mxt.addView(fragmentTabIndicator, i);
        }
        if (!dBW() && this.mxt.getChildAt(1) != null) {
            this.mxt.getChildAt(1).setVisibility(8);
        }
        this.mxt.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.mxt.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.mxt.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.mxt.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.mxt.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.mxp.getRootView().setVisibility(0);
                            a.this.mxq.getRootView().setVisibility(8);
                            a.this.mxr.getRootView().setVisibility(8);
                            a.this.mxp.wC(true);
                            a.this.mxq.wC(false);
                            a.this.mxr.wC(false);
                            break;
                        case 1:
                            a.this.mxr.getRootView().setVisibility(0);
                            a.this.mxq.getRootView().setVisibility(8);
                            a.this.mxp.getRootView().setVisibility(8);
                            a.this.mxp.wC(false);
                            if (TextUtils.isEmpty(a.this.mxq.dCf())) {
                                a.this.mxq.wC(false);
                            } else {
                                a.this.mxq.wC(true);
                            }
                            a.this.mxr.wC(true);
                            break;
                        case 2:
                            a.this.mxq.getRootView().setVisibility(0);
                            a.this.mxp.getRootView().setVisibility(8);
                            a.this.mxr.getRootView().setVisibility(8);
                            a.this.mxp.wC(false);
                            a.this.mxq.wC(true);
                            a.this.mxr.wC(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.mxt.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.dBY();
                    a.this.dBZ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBY() {
        aq aqVar = new aq("c12424");
        aqVar.ai("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBZ() {
        if (this.mCurrentTabIndex == 0) {
            dCd();
            dCb();
            return;
        }
        replay();
    }

    public void replay() {
        dCd();
        if (this.mMediaPlayer != null) {
            if (this.mIsMute) {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
        this.mxo.start();
        this.mxo.seekTo(0);
    }

    public void setMute(boolean z) {
        this.mIsMute = z;
        if (this.mMediaPlayer != null) {
            replay();
        }
    }

    public void onPause() {
        dCd();
        this.mxp.onPause();
        this.mxq.onPause();
        this.mxr.onPause();
    }

    public void onResume() {
        this.mxo.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.mxo.resumeMedia();
        }
        this.mxp.onResume();
        this.mxq.onResume();
        this.mxr.onResume();
    }

    public MaskVideoView dCa() {
        return this.mxo;
    }

    public Bitmap G(Bitmap bitmap) {
        return this.mxp.G(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.mxq.setMusicData(list);
    }

    public void fo(List<PendantData> list) {
        this.mxp.fo(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.mxr != null) {
            this.mxr.a(aVar);
        }
    }

    public com.baidu.tieba.video.editvideo.data.a RO(String str) {
        if (this.mxr == null || at.isEmpty(str)) {
            return null;
        }
        return this.mxr.RQ(str);
    }

    public void c(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.mxo != null) {
            this.mxo.setFilter(aVar);
        }
        if (this.mxr != null) {
            this.mxr.d(aVar);
        }
    }

    public void fZ(String str, String str2) {
        if (this.mxq != null) {
            this.mxq.gb(str, str2);
        }
    }

    public void wD(boolean z) {
        if (this.mxq != null) {
            this.mxq.wE(z);
            setMute(!z);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.mxp.setData(str);
                this.mxo.setVideoPath(str);
                this.mxo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.mxp.dCm();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.mxo.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.mxo.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.mxo.seekTo(a.this.mxp.getCurrentPosition());
                    }
                });
                this.mxo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.mxq.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dCb() {
        if (this.mxo != null) {
            this.mxo.seekTo(this.mxp.getCurrentPosition());
        }
    }

    public void dCc() {
        if (this.mxo != null) {
            this.mxo.IS(this.mxp.getCurrentPosition());
        }
    }

    public void dCd() {
        if (this.mxo != null) {
            this.mxo.dCi();
        }
    }

    public void dCe() {
        if (this.mxo != null) {
            this.mxo.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.mxt.onChangeSkinType(i);
        this.mxt.setDiverColor(ap.getColor(i, R.color.cp_cont_b));
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.mxp != null) {
            this.mxp.onChangeSkinType(eVar, i);
        }
        if (this.mxq != null) {
            this.mxq.onChangeSkinType(eVar, i);
        }
    }

    private void buO() {
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
                a.this.mxp.hideSoftKeyPad();
                if (a.this.mwf != null) {
                    a.this.mwf.onNext();
                }
            }
        }), R.color.cp_cont_f);
    }

    public String getText() {
        return this.mxp.getText();
    }

    public int getCurrentPosition() {
        if (this.mxo == null) {
            return 0;
        }
        return this.mxo.getCurrentPosition();
    }

    public void Nv() {
        if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && at.equals(((EditVideoActivity) this.mContext.getPageActivity()).beq(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
            this.mwf.finishPage();
            return;
        }
        if (this.ljY == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.ljY = new i(getPageContext());
            this.ljY.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.ljY.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.efU);
        }
        this.ljY.Nv();
    }

    public void ga(String str, String str2) {
        this.mxq.ga(str, str2);
    }

    public void dBu() {
        if (this.mwf != null) {
            this.mwf.dBu();
        }
    }

    public String dCf() {
        return this.mxq.dCf();
    }

    public String dCg() {
        return this.mxq.dCg();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean dCh() {
        return this.mxq.dCh();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.mxp != null) {
            this.mxp.release();
        }
        if (this.mxo != null) {
            this.mxo.stopPlayback();
        }
    }

    public void ap(Intent intent) {
        this.mxq.ap(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && dCa() != null) {
            dCa().setGenMaskCoverListener(bVar);
        }
    }
}
