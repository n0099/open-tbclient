package com.baidu.tieba.video.editvideo.view;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.e;
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c {
    private FragmentTabWidget bZA;
    private MediaPlayer bbp;
    private h gWF;
    private com.baidu.tieba.video.editvideo.a hmh;
    private MaskVideoView hnq;
    private com.baidu.tbadk.core.dialog.b hnr;
    private b hns;
    private d hnt;
    private c hnu;
    private FrameLayout hnv;
    private b.InterfaceC0100b hnw;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.hnw = new b.InterfaceC0100b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.hmh != null) {
                            a.this.hmh.bDz();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.hmh != null) {
                            a.this.hmh.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.hmh = aVar;
        this.mRootView = view;
        this.gWF = hVar;
        this.mResources = view.getResources();
        this.hns = new b(this.mContext, this);
        this.hnt = new d(this.mContext, this, this.gWF);
        this.hnu = new c(this.mContext, this);
        this.hns.bS(this.mRootView);
        this.hnt.bS(this.mRootView);
        this.hnu.bS(this.mRootView);
        initView();
        bEk();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.navigation_bar);
        this.hnq = (MaskVideoView) this.mRootView.findViewById(e.g.video_view);
        this.hnq.setPreserveEGLContextOnPause(true);
        this.hnq.setZOrderMediaOverlay(true);
        this.hnq.setPostMonitorManager(this.gWF);
        this.hnv = (FrameLayout) this.mRootView.findViewById(e.g.edit_container);
        this.hnv.addView(this.hns.getRootView());
        this.bZA = (FragmentTabWidget) this.mRootView.findViewById(e.g.tab_widget);
        atZ();
        abN();
        this.hnv.addView(this.hnt.getRootView());
        this.hnv.addView(this.hnu.getRootView());
        this.hnt.getRootView().setVisibility(8);
        this.hnu.getRootView().setVisibility(8);
    }

    private boolean bEj() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void abN() {
        String[] stringArray = this.mResources.getStringArray(e.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(e.d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(e.C0141e.fontsize34));
            this.bZA.addView(fragmentTabIndicator, i);
        }
        if (!bEj() && this.bZA.getChildAt(1) != null) {
            this.bZA.getChildAt(1).setVisibility(8);
        }
        this.bZA.setDiverColor(this.mResources.getColor(e.d.cp_cont_b));
        this.bZA.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.bZA.setBackGroundDrawableResId(e.d.cp_bg_line_d);
        this.bZA.setDviderRectWidth(l.h(this.mContext.getPageActivity(), e.C0141e.ds64));
        this.bZA.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.hns.getRootView().setVisibility(0);
                            a.this.hnt.getRootView().setVisibility(8);
                            a.this.hnu.getRootView().setVisibility(8);
                            a.this.hns.nq(true);
                            a.this.hnt.nq(false);
                            a.this.hnu.nq(false);
                            break;
                        case 1:
                            a.this.hnu.getRootView().setVisibility(0);
                            a.this.hnt.getRootView().setVisibility(8);
                            a.this.hns.getRootView().setVisibility(8);
                            a.this.hns.nq(false);
                            if (TextUtils.isEmpty(a.this.hnt.bEr())) {
                                a.this.hnt.nq(false);
                            } else {
                                a.this.hnt.nq(true);
                            }
                            a.this.hnu.nq(true);
                            break;
                        case 2:
                            a.this.hnt.getRootView().setVisibility(0);
                            a.this.hns.getRootView().setVisibility(8);
                            a.this.hnu.getRootView().setVisibility(8);
                            a.this.hns.nq(false);
                            a.this.hnt.nq(true);
                            a.this.hnu.nq(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.bZA.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.bEk();
                    a.this.bEl();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEk() {
        am amVar = new am("c12424");
        amVar.w("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEl() {
        if (this.mCurrentTabIndex == 0) {
            bEp();
            bEn();
            return;
        }
        replay();
    }

    public void replay() {
        bEp();
        this.hnq.start();
        this.hnq.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.bbp != null) {
            this.mIsMute = z;
            if (z) {
                this.bbp.setVolume(0.0f, 0.0f);
            } else {
                this.bbp.setVolume(1.0f, 1.0f);
            }
            replay();
        }
    }

    public void onPause() {
        bEp();
        this.hns.onPause();
        this.hnt.onPause();
        this.hnu.onPause();
    }

    public void onResume() {
        this.hnq.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.hnq.bEv();
        }
        this.hns.onResume();
        this.hnt.onResume();
        this.hnu.onResume();
    }

    public MaskVideoView bEm() {
        return this.hnq;
    }

    public Bitmap s(Bitmap bitmap) {
        return this.hns.s(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.hnt.setMusicData(list);
    }

    public void dH(List<PendantData> list) {
        this.hns.dH(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.hnu != null) {
            this.hnu.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hns.setData(str);
                this.hnq.setVideoPath(str);
                this.hnq.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.bbp = mediaPlayer;
                        if (a.this.mIsMute || a.this.mCurrentTabIndex == 0) {
                            a.this.bbp.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.bbp.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.hns.bEy();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.hnq.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.hnq.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.hnq.seekTo(a.this.hns.getCurrentPosition());
                    }
                });
                this.hnq.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.hnt.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bEn() {
        if (this.hnq != null) {
            this.hnq.seekTo(this.hns.getCurrentPosition());
        }
    }

    public void bEo() {
        if (this.hnq != null) {
            this.hnq.vh(this.hns.getCurrentPosition());
        }
    }

    public void bEp() {
        if (this.hnq != null) {
            this.hnq.bEu();
        }
    }

    public void bEq() {
        if (this.hnq != null) {
            this.hnq.onPause();
        }
    }

    public void onChangeSkinType(com.baidu.adp.base.e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.bZA.onChangeSkinType(i);
        this.bZA.setDiverColor(i == 1 ? this.mResources.getColor(e.d.cp_cont_b_1) : this.mResources.getColor(e.d.cp_cont_b));
        al.j(this.mRootView, e.d.cp_bg_line_d);
        if (this.hns != null) {
            this.hns.onChangeSkinType(eVar, i);
        }
        if (this.hnt != null) {
            this.hnt.onChangeSkinType(eVar, i);
        }
    }

    private void atZ() {
        this.mNavigationBar.setCenterTextTitle(this.mResources.getString(e.j.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        al.h(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mResources.getString(e.j.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hns.bon();
                if (a.this.hmh != null) {
                    a.this.hmh.bDw();
                }
            }
        }), e.d.cp_cont_f);
    }

    public String getText() {
        return this.hns.getText();
    }

    public int getCurrentPosition() {
        if (this.hnq == null) {
            return 0;
        }
        return this.hnq.getCurrentPosition();
    }

    public void showDialog() {
        if (this.hnr == null) {
            String[] strArr = {getPageContext().getString(e.j.save), getPageContext().getString(e.j.not_save), getPageContext().getString(e.j.cancel)};
            this.hnr = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.hnr.ct(b.a.anH);
            this.hnr.cv(17);
            this.hnr.dU(TbadkCoreApplication.getInst().getResources().getString(e.j.save_video_title));
            this.hnr.a(strArr, this.hnw);
            this.hnr.d(getPageContext());
            TextView titleView = this.hnr.getTitleView();
            if (titleView != null) {
                titleView.setGravity(17);
                titleView.setTextSize(0, this.mResources.getDimensionPixelSize(e.C0141e.fontsize24));
                al.h(titleView, e.d.cp_cont_d);
            }
        }
        this.hnr.yo();
    }

    public void cC(String str, String str2) {
        this.hnt.cC(str, str2);
    }

    public void bDB() {
        if (this.hmh != null) {
            this.hmh.bDB();
        }
    }

    public String bEr() {
        return this.hnt.bEr();
    }

    public String bEs() {
        return this.hnt.bEs();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bEt() {
        return this.hnt.bEt();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.hns != null) {
            this.hns.release();
        }
        if (this.hnq != null) {
            this.hnq.stopPlayback();
        }
    }

    public void aa(Intent intent) {
        this.hnt.aa(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && bEm() != null) {
            bEm().setGenMaskCoverListener(bVar);
        }
    }
}
