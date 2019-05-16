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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
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
    private k.c bNi;
    private MediaPlayer bzd;
    private FragmentTabWidget dLM;
    private h iZR;
    private i iid;
    private com.baidu.tieba.video.editvideo.a jpX;
    private MaskVideoView jrf;
    private b jrg;
    private d jrh;
    private c jri;
    private FrameLayout jrj;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.bNi = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.jpX != null) {
                            a.this.jpX.crq();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.jpX != null) {
                            a.this.jpX.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.iid != null && a.this.iid.isShowing() && a.this.getPageContext() != null) {
                    a.this.iid.dismiss();
                }
            }
        };
        this.jpX = aVar;
        this.mRootView = view;
        this.iZR = hVar;
        this.mResources = view.getResources();
        this.jrg = new b(this.mContext, this);
        this.jrh = new d(this.mContext, this, this.iZR);
        this.jri = new c(this.mContext, this);
        this.jrg.cS(this.mRootView);
        this.jrh.cS(this.mRootView);
        this.jri.cS(this.mRootView);
        initView();
        csb();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.jrf = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.jrf.setPreserveEGLContextOnPause(true);
        this.jrf.setZOrderMediaOverlay(true);
        this.jrf.setPostMonitorManager(this.iZR);
        this.jrj = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.jrj.addView(this.jrg.getRootView());
        this.dLM = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        aHO();
        aNC();
        this.jrj.addView(this.jrh.getRootView());
        this.jrj.addView(this.jri.getRootView());
        this.jrh.getRootView().setVisibility(8);
        this.jri.getRootView().setVisibility(8);
    }

    private boolean csa() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void aNC() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.dLM.addView(fragmentTabIndicator, i);
        }
        if (!csa() && this.dLM.getChildAt(1) != null) {
            this.dLM.getChildAt(1).setVisibility(8);
        }
        this.dLM.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.dLM.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.dLM.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.dLM.setDviderRectWidth(l.g(this.mContext.getPageActivity(), R.dimen.ds64));
        this.dLM.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.jrg.getRootView().setVisibility(0);
                            a.this.jrh.getRootView().setVisibility(8);
                            a.this.jri.getRootView().setVisibility(8);
                            a.this.jrg.rq(true);
                            a.this.jrh.rq(false);
                            a.this.jri.rq(false);
                            break;
                        case 1:
                            a.this.jri.getRootView().setVisibility(0);
                            a.this.jrh.getRootView().setVisibility(8);
                            a.this.jrg.getRootView().setVisibility(8);
                            a.this.jrg.rq(false);
                            if (TextUtils.isEmpty(a.this.jrh.csi())) {
                                a.this.jrh.rq(false);
                            } else {
                                a.this.jrh.rq(true);
                            }
                            a.this.jri.rq(true);
                            break;
                        case 2:
                            a.this.jrh.getRootView().setVisibility(0);
                            a.this.jrg.getRootView().setVisibility(8);
                            a.this.jri.getRootView().setVisibility(8);
                            a.this.jrg.rq(false);
                            a.this.jrh.rq(true);
                            a.this.jri.rq(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.dLM.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.csb();
                    a.this.csc();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csb() {
        am amVar = new am("c12424");
        amVar.P("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csc() {
        if (this.mCurrentTabIndex == 0) {
            csg();
            cse();
            return;
        }
        replay();
    }

    public void replay() {
        csg();
        this.jrf.start();
        this.jrf.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bzd != null) {
            this.mIsMute = z;
            if (z) {
                this.bzd.setVolume(0.0f, 0.0f);
            } else {
                this.bzd.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        csg();
        this.jrg.onPause();
        this.jrh.onPause();
        this.jri.onPause();
    }

    public void onResume() {
        this.jrf.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.jrf.csm();
        }
        this.jrg.onResume();
        this.jrh.onResume();
        this.jri.onResume();
    }

    public MaskVideoView csd() {
        return this.jrf;
    }

    public Bitmap B(Bitmap bitmap) {
        return this.jrg.B(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.jrh.setMusicData(list);
    }

    public void em(List<PendantData> list) {
        this.jrg.em(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.jri != null) {
            this.jri.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.jrg.setData(str);
                this.jrf.setVideoPath(str);
                this.jrf.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bzd = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.bzd.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bzd.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.jrg.csp();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.jrf.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.jrf.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.jrf.seekTo(a.this.jrg.getCurrentPosition());
                    }
                });
                this.jrf.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.jrh.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cse() {
        if (this.jrf != null) {
            this.jrf.seekTo(this.jrg.getCurrentPosition());
        }
    }

    public void csf() {
        if (this.jrf != null) {
            this.jrf.BA(this.jrg.getCurrentPosition());
        }
    }

    public void csg() {
        if (this.jrf != null) {
            this.jrf.csl();
        }
    }

    public void csh() {
        if (this.jrf != null) {
            this.jrf.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.dLM.onChangeSkinType(i);
        this.dLM.setDiverColor(i == 1 ? this.mResources.getColor(R.color.cp_cont_b_1) : this.mResources.getColor(R.color.cp_cont_b));
        al.l(this.mRootView, R.color.cp_bg_line_d);
        if (this.jrg != null) {
            this.jrg.onChangeSkinType(eVar, i);
        }
        if (this.jrh != null) {
            this.jrh.onChangeSkinType(eVar, i);
        }
    }

    private void aHO() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(R.string.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        al.j(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(R.string.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jrg.ccX();
                if (a.this.jpX != null) {
                    a.this.jpX.crn();
                }
            }
        }), R.color.cp_cont_f);
    }

    public String getText() {
        return this.jrg.getText();
    }

    public int getCurrentPosition() {
        if (this.jrf == null) {
            return 0;
        }
        return this.jrf.getCurrentPosition();
    }

    public void showDialog() {
        if (this.iid == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.iid = new i(getPageContext());
            this.iid.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.iid.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.bNi);
        }
        this.iid.showDialog();
    }

    public void es(String str, String str2) {
        this.jrh.es(str, str2);
    }

    public void crs() {
        if (this.jpX != null) {
            this.jpX.crs();
        }
    }

    public String csi() {
        return this.jrh.csi();
    }

    public String csj() {
        return this.jrh.csj();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean csk() {
        return this.jrh.csk();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.jrg != null) {
            this.jrg.release();
        }
        if (this.jrf != null) {
            this.jrf.stopPlayback();
        }
    }

    public void ay(Intent intent) {
        this.jrh.ay(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && csd() != null) {
            csd().setGenMaskCoverListener(bVar);
        }
    }
}
