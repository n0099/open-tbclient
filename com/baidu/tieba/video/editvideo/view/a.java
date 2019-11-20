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
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends com.baidu.adp.base.c {
    private MediaPlayer bSn;
    private k.c cfd;
    private i ipl;
    private h jiP;
    private com.baidu.tieba.video.editvideo.a jyN;
    private MaskVideoView jzU;
    private b jzV;
    private d jzW;
    private c jzX;
    private FrameLayout jzY;
    private FragmentTabWidget jzZ;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.cfd = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.jyN != null) {
                            a.this.jyN.cta();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.jyN != null) {
                            a.this.jyN.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.ipl != null && a.this.ipl.isShowing() && a.this.getPageContext() != null) {
                    a.this.ipl.dismiss();
                }
            }
        };
        this.jyN = aVar;
        this.mRootView = view;
        this.jiP = hVar;
        this.mResources = view.getResources();
        this.jzV = new b(this.mContext, this);
        this.jzW = new d(this.mContext, this, this.jiP);
        this.jzX = new c(this.mContext, this);
        this.jzV.cT(this.mRootView);
        this.jzW.cT(this.mRootView);
        this.jzX.cT(this.mRootView);
        initView();
        ctL();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.jzU = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.jzU.setPreserveEGLContextOnPause(true);
        this.jzU.setZOrderMediaOverlay(true);
        this.jzU.setPostMonitorManager(this.jiP);
        this.jzY = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.jzY.addView(this.jzV.getRootView());
        this.jzZ = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        aJv();
        ctK();
        this.jzY.addView(this.jzW.getRootView());
        this.jzY.addView(this.jzX.getRootView());
        this.jzW.getRootView().setVisibility(8);
        this.jzX.getRootView().setVisibility(8);
    }

    private boolean ctJ() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void ctK() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.jzZ.addView(fragmentTabIndicator, i);
        }
        if (!ctJ() && this.jzZ.getChildAt(1) != null) {
            this.jzZ.getChildAt(1).setVisibility(8);
        }
        this.jzZ.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.jzZ.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.jzZ.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.jzZ.setDviderRectWidth(l.getDimens(this.mContext.getPageActivity(), R.dimen.ds64));
        this.jzZ.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.jzV.getRootView().setVisibility(0);
                            a.this.jzW.getRootView().setVisibility(8);
                            a.this.jzX.getRootView().setVisibility(8);
                            a.this.jzV.rr(true);
                            a.this.jzW.rr(false);
                            a.this.jzX.rr(false);
                            break;
                        case 1:
                            a.this.jzX.getRootView().setVisibility(0);
                            a.this.jzW.getRootView().setVisibility(8);
                            a.this.jzV.getRootView().setVisibility(8);
                            a.this.jzV.rr(false);
                            if (TextUtils.isEmpty(a.this.jzW.ctS())) {
                                a.this.jzW.rr(false);
                            } else {
                                a.this.jzW.rr(true);
                            }
                            a.this.jzX.rr(true);
                            break;
                        case 2:
                            a.this.jzW.getRootView().setVisibility(0);
                            a.this.jzV.getRootView().setVisibility(8);
                            a.this.jzX.getRootView().setVisibility(8);
                            a.this.jzV.rr(false);
                            a.this.jzW.rr(true);
                            a.this.jzX.rr(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.jzZ.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.ctL();
                    a.this.ctM();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctL() {
        an anVar = new an("c12424");
        anVar.O("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctM() {
        if (this.mCurrentTabIndex == 0) {
            ctQ();
            ctO();
            return;
        }
        replay();
    }

    public void replay() {
        ctQ();
        this.jzU.start();
        this.jzU.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bSn != null) {
            this.mIsMute = z;
            if (z) {
                this.bSn.setVolume(0.0f, 0.0f);
            } else {
                this.bSn.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        ctQ();
        this.jzV.onPause();
        this.jzW.onPause();
        this.jzX.onPause();
    }

    public void onResume() {
        this.jzU.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.jzU.ctW();
        }
        this.jzV.onResume();
        this.jzW.onResume();
        this.jzX.onResume();
    }

    public MaskVideoView ctN() {
        return this.jzU;
    }

    public Bitmap z(Bitmap bitmap) {
        return this.jzV.z(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.jzW.setMusicData(list);
    }

    public void eB(List<PendantData> list) {
        this.jzV.eB(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.jzX != null) {
            this.jzX.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.jzV.setData(str);
                this.jzU.setVideoPath(str);
                this.jzU.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bSn = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.bSn.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bSn.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.jzV.ctZ();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.jzU.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.jzU.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.jzU.seekTo(a.this.jzV.getCurrentPosition());
                    }
                });
                this.jzU.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.jzW.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void ctO() {
        if (this.jzU != null) {
            this.jzU.seekTo(this.jzV.getCurrentPosition());
        }
    }

    public void ctP() {
        if (this.jzU != null) {
            this.jzU.AS(this.jzV.getCurrentPosition());
        }
    }

    public void ctQ() {
        if (this.jzU != null) {
            this.jzU.ctV();
        }
    }

    public void ctR() {
        if (this.jzU != null) {
            this.jzU.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.jzZ.onChangeSkinType(i);
        this.jzZ.setDiverColor(am.getColor(i, R.color.cp_cont_b));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.jzV != null) {
            this.jzV.onChangeSkinType(eVar, i);
        }
        if (this.jzW != null) {
            this.jzW.onChangeSkinType(eVar, i);
        }
    }

    private void aJv() {
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
                a.this.jzV.hideSoftKeyPad();
                if (a.this.jyN != null) {
                    a.this.jyN.tU();
                }
            }
        }), (int) R.color.cp_cont_f);
    }

    public String getText() {
        return this.jzV.getText();
    }

    public int getCurrentPosition() {
        if (this.jzU == null) {
            return 0;
        }
        return this.jzU.getCurrentPosition();
    }

    public void showDialog() {
        if (this.ipl == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.ipl = new i(getPageContext());
            this.ipl.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.ipl.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.cfd);
        }
        this.ipl.showDialog();
    }

    public void eg(String str, String str2) {
        this.jzW.eg(str, str2);
    }

    public void ctc() {
        if (this.jyN != null) {
            this.jyN.ctc();
        }
    }

    public String ctS() {
        return this.jzW.ctS();
    }

    public String ctT() {
        return this.jzW.ctT();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean ctU() {
        return this.jzW.ctU();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.jzV != null) {
            this.jzV.release();
        }
        if (this.jzU != null) {
            this.jzU.stopPlayback();
        }
    }

    public void aH(Intent intent) {
        this.jzW.aH(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && ctN() != null) {
            ctN().setGenMaskCoverListener(bVar);
        }
    }
}
