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
    private FragmentTabWidget dLN;
    private h iZT;
    private i iig;
    private com.baidu.tieba.video.editvideo.a jpY;
    private MaskVideoView jrg;
    private b jrh;
    private d jri;
    private c jrj;
    private FrameLayout jrk;
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
                        if (a.this.jpY != null) {
                            a.this.jpY.crs();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.jpY != null) {
                            a.this.jpY.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.iig != null && a.this.iig.isShowing() && a.this.getPageContext() != null) {
                    a.this.iig.dismiss();
                }
            }
        };
        this.jpY = aVar;
        this.mRootView = view;
        this.iZT = hVar;
        this.mResources = view.getResources();
        this.jrh = new b(this.mContext, this);
        this.jri = new d(this.mContext, this, this.iZT);
        this.jrj = new c(this.mContext, this);
        this.jrh.cS(this.mRootView);
        this.jri.cS(this.mRootView);
        this.jrj.cS(this.mRootView);
        initView();
        csd();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.jrg = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.jrg.setPreserveEGLContextOnPause(true);
        this.jrg.setZOrderMediaOverlay(true);
        this.jrg.setPostMonitorManager(this.iZT);
        this.jrk = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.jrk.addView(this.jrh.getRootView());
        this.dLN = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        aHR();
        aNF();
        this.jrk.addView(this.jri.getRootView());
        this.jrk.addView(this.jrj.getRootView());
        this.jri.getRootView().setVisibility(8);
        this.jrj.getRootView().setVisibility(8);
    }

    private boolean csc() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void aNF() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.dLN.addView(fragmentTabIndicator, i);
        }
        if (!csc() && this.dLN.getChildAt(1) != null) {
            this.dLN.getChildAt(1).setVisibility(8);
        }
        this.dLN.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.dLN.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.dLN.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.dLN.setDviderRectWidth(l.g(this.mContext.getPageActivity(), R.dimen.ds64));
        this.dLN.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.jrh.getRootView().setVisibility(0);
                            a.this.jri.getRootView().setVisibility(8);
                            a.this.jrj.getRootView().setVisibility(8);
                            a.this.jrh.rq(true);
                            a.this.jri.rq(false);
                            a.this.jrj.rq(false);
                            break;
                        case 1:
                            a.this.jrj.getRootView().setVisibility(0);
                            a.this.jri.getRootView().setVisibility(8);
                            a.this.jrh.getRootView().setVisibility(8);
                            a.this.jrh.rq(false);
                            if (TextUtils.isEmpty(a.this.jri.csk())) {
                                a.this.jri.rq(false);
                            } else {
                                a.this.jri.rq(true);
                            }
                            a.this.jrj.rq(true);
                            break;
                        case 2:
                            a.this.jri.getRootView().setVisibility(0);
                            a.this.jrh.getRootView().setVisibility(8);
                            a.this.jrj.getRootView().setVisibility(8);
                            a.this.jrh.rq(false);
                            a.this.jri.rq(true);
                            a.this.jrj.rq(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.dLN.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.csd();
                    a.this.cse();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csd() {
        am amVar = new am("c12424");
        amVar.P("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cse() {
        if (this.mCurrentTabIndex == 0) {
            csi();
            csg();
            return;
        }
        replay();
    }

    public void replay() {
        csi();
        this.jrg.start();
        this.jrg.seekTo(0);
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
        csi();
        this.jrh.onPause();
        this.jri.onPause();
        this.jrj.onPause();
    }

    public void onResume() {
        this.jrg.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.jrg.cso();
        }
        this.jrh.onResume();
        this.jri.onResume();
        this.jrj.onResume();
    }

    public MaskVideoView csf() {
        return this.jrg;
    }

    public Bitmap B(Bitmap bitmap) {
        return this.jrh.B(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.jri.setMusicData(list);
    }

    public void em(List<PendantData> list) {
        this.jrh.em(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.jrj != null) {
            this.jrj.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.jrh.setData(str);
                this.jrg.setVideoPath(str);
                this.jrg.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.jrh.csr();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.jrg.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.jrg.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.jrg.seekTo(a.this.jrh.getCurrentPosition());
                    }
                });
                this.jrg.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.jri.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void csg() {
        if (this.jrg != null) {
            this.jrg.seekTo(this.jrh.getCurrentPosition());
        }
    }

    public void csh() {
        if (this.jrg != null) {
            this.jrg.BA(this.jrh.getCurrentPosition());
        }
    }

    public void csi() {
        if (this.jrg != null) {
            this.jrg.csn();
        }
    }

    public void csj() {
        if (this.jrg != null) {
            this.jrg.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.dLN.onChangeSkinType(i);
        this.dLN.setDiverColor(i == 1 ? this.mResources.getColor(R.color.cp_cont_b_1) : this.mResources.getColor(R.color.cp_cont_b));
        al.l(this.mRootView, R.color.cp_bg_line_d);
        if (this.jrh != null) {
            this.jrh.onChangeSkinType(eVar, i);
        }
        if (this.jri != null) {
            this.jri.onChangeSkinType(eVar, i);
        }
    }

    private void aHR() {
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
                a.this.jrh.cda();
                if (a.this.jpY != null) {
                    a.this.jpY.crp();
                }
            }
        }), R.color.cp_cont_f);
    }

    public String getText() {
        return this.jrh.getText();
    }

    public int getCurrentPosition() {
        if (this.jrg == null) {
            return 0;
        }
        return this.jrg.getCurrentPosition();
    }

    public void showDialog() {
        if (this.iig == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.iig = new i(getPageContext());
            this.iig.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.iig.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.bNi);
        }
        this.iig.showDialog();
    }

    public void es(String str, String str2) {
        this.jri.es(str, str2);
    }

    public void cru() {
        if (this.jpY != null) {
            this.jpY.cru();
        }
    }

    public String csk() {
        return this.jri.csk();
    }

    public String csl() {
        return this.jri.csl();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean csm() {
        return this.jri.csm();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.jrh != null) {
            this.jrh.release();
        }
        if (this.jrg != null) {
            this.jrg.stopPlayback();
        }
    }

    public void ay(Intent intent) {
        this.jri.ay(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && csf() != null) {
            csf().setGenMaskCoverListener(bVar);
        }
    }
}
