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
    private MediaPlayer bAa;
    private k.c bOk;
    private FragmentTabWidget dPv;
    private i ioz;
    private h jgo;
    private com.baidu.tieba.video.editvideo.a jwj;
    private MaskVideoView jxr;
    private b jxs;
    private d jxt;
    private c jxu;
    private FrameLayout jxv;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.bOk = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.jwj != null) {
                            a.this.jwj.cue();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.jwj != null) {
                            a.this.jwj.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.ioz != null && a.this.ioz.isShowing() && a.this.getPageContext() != null) {
                    a.this.ioz.dismiss();
                }
            }
        };
        this.jwj = aVar;
        this.mRootView = view;
        this.jgo = hVar;
        this.mResources = view.getResources();
        this.jxs = new b(this.mContext, this);
        this.jxt = new d(this.mContext, this, this.jgo);
        this.jxu = new c(this.mContext, this);
        this.jxs.cV(this.mRootView);
        this.jxt.cV(this.mRootView);
        this.jxu.cV(this.mRootView);
        initView();
        cuP();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.jxr = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.jxr.setPreserveEGLContextOnPause(true);
        this.jxr.setZOrderMediaOverlay(true);
        this.jxr.setPostMonitorManager(this.jgo);
        this.jxv = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.jxv.addView(this.jxs.getRootView());
        this.dPv = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        aJr();
        aPr();
        this.jxv.addView(this.jxt.getRootView());
        this.jxv.addView(this.jxu.getRootView());
        this.jxt.getRootView().setVisibility(8);
        this.jxu.getRootView().setVisibility(8);
    }

    private boolean cuO() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void aPr() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.dPv.addView(fragmentTabIndicator, i);
        }
        if (!cuO() && this.dPv.getChildAt(1) != null) {
            this.dPv.getChildAt(1).setVisibility(8);
        }
        this.dPv.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.dPv.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.dPv.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.dPv.setDviderRectWidth(l.g(this.mContext.getPageActivity(), R.dimen.ds64));
        this.dPv.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.jxs.getRootView().setVisibility(0);
                            a.this.jxt.getRootView().setVisibility(8);
                            a.this.jxu.getRootView().setVisibility(8);
                            a.this.jxs.rE(true);
                            a.this.jxt.rE(false);
                            a.this.jxu.rE(false);
                            break;
                        case 1:
                            a.this.jxu.getRootView().setVisibility(0);
                            a.this.jxt.getRootView().setVisibility(8);
                            a.this.jxs.getRootView().setVisibility(8);
                            a.this.jxs.rE(false);
                            if (TextUtils.isEmpty(a.this.jxt.cuW())) {
                                a.this.jxt.rE(false);
                            } else {
                                a.this.jxt.rE(true);
                            }
                            a.this.jxu.rE(true);
                            break;
                        case 2:
                            a.this.jxt.getRootView().setVisibility(0);
                            a.this.jxs.getRootView().setVisibility(8);
                            a.this.jxu.getRootView().setVisibility(8);
                            a.this.jxs.rE(false);
                            a.this.jxt.rE(true);
                            a.this.jxu.rE(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.dPv.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.cuP();
                    a.this.cuQ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuP() {
        an anVar = new an("c12424");
        anVar.P("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuQ() {
        if (this.mCurrentTabIndex == 0) {
            cuU();
            cuS();
            return;
        }
        replay();
    }

    public void replay() {
        cuU();
        this.jxr.start();
        this.jxr.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bAa != null) {
            this.mIsMute = z;
            if (z) {
                this.bAa.setVolume(0.0f, 0.0f);
            } else {
                this.bAa.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        cuU();
        this.jxs.onPause();
        this.jxt.onPause();
        this.jxu.onPause();
    }

    public void onResume() {
        this.jxr.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.jxr.cva();
        }
        this.jxs.onResume();
        this.jxt.onResume();
        this.jxu.onResume();
    }

    public MaskVideoView cuR() {
        return this.jxr;
    }

    public Bitmap B(Bitmap bitmap) {
        return this.jxs.B(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.jxt.setMusicData(list);
    }

    public void ep(List<PendantData> list) {
        this.jxs.ep(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.jxu != null) {
            this.jxu.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.jxs.setData(str);
                this.jxr.setVideoPath(str);
                this.jxr.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bAa = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.bAa.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bAa.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.jxs.cvd();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.jxr.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.jxr.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.jxr.seekTo(a.this.jxs.getCurrentPosition());
                    }
                });
                this.jxr.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.jxt.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cuS() {
        if (this.jxr != null) {
            this.jxr.seekTo(this.jxs.getCurrentPosition());
        }
    }

    public void cuT() {
        if (this.jxr != null) {
            this.jxr.Ch(this.jxs.getCurrentPosition());
        }
    }

    public void cuU() {
        if (this.jxr != null) {
            this.jxr.cuZ();
        }
    }

    public void cuV() {
        if (this.jxr != null) {
            this.jxr.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.dPv.onChangeSkinType(i);
        this.dPv.setDiverColor(i == 1 ? this.mResources.getColor(R.color.cp_cont_b_1) : this.mResources.getColor(R.color.cp_cont_b));
        am.l(this.mRootView, R.color.cp_bg_line_d);
        if (this.jxs != null) {
            this.jxs.onChangeSkinType(eVar, i);
        }
        if (this.jxt != null) {
            this.jxt.onChangeSkinType(eVar, i);
        }
    }

    private void aJr() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        am.j(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jxs.cfS();
                if (a.this.jwj != null) {
                    a.this.jwj.cub();
                }
            }
        }), R.color.cp_cont_f);
    }

    public String getText() {
        return this.jxs.getText();
    }

    public int getCurrentPosition() {
        if (this.jxr == null) {
            return 0;
        }
        return this.jxr.getCurrentPosition();
    }

    public void showDialog() {
        if (this.ioz == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.ioz = new i(getPageContext());
            this.ioz.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.ioz.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.bOk);
        }
        this.ioz.showDialog();
    }

    public void et(String str, String str2) {
        this.jxt.et(str, str2);
    }

    public void cug() {
        if (this.jwj != null) {
            this.jwj.cug();
        }
    }

    public String cuW() {
        return this.jxt.cuW();
    }

    public String cuX() {
        return this.jxt.cuX();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean cuY() {
        return this.jxt.cuY();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.jxs != null) {
            this.jxs.release();
        }
        if (this.jxr != null) {
            this.jxr.ceg();
        }
    }

    public void ay(Intent intent) {
        this.jxt.ay(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && cuR() != null) {
            cuR().setGenMaskCoverListener(bVar);
        }
    }
}
