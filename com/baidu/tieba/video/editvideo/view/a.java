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
    private k.c bNj;
    private MediaPlayer bzd;
    private FragmentTabWidget dLN;
    private h iZX;
    private i iih;
    private com.baidu.tieba.video.editvideo.a jqb;
    private MaskVideoView jrj;
    private b jrk;
    private d jrl;
    private c jrm;
    private FrameLayout jrn;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.bNj = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.jqb != null) {
                            a.this.jqb.crt();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.jqb != null) {
                            a.this.jqb.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.iih != null && a.this.iih.isShowing() && a.this.getPageContext() != null) {
                    a.this.iih.dismiss();
                }
            }
        };
        this.jqb = aVar;
        this.mRootView = view;
        this.iZX = hVar;
        this.mResources = view.getResources();
        this.jrk = new b(this.mContext, this);
        this.jrl = new d(this.mContext, this, this.iZX);
        this.jrm = new c(this.mContext, this);
        this.jrk.cS(this.mRootView);
        this.jrl.cS(this.mRootView);
        this.jrm.cS(this.mRootView);
        initView();
        csc();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.jrj = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.jrj.setPreserveEGLContextOnPause(true);
        this.jrj.setZOrderMediaOverlay(true);
        this.jrj.setPostMonitorManager(this.iZX);
        this.jrn = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.jrn.addView(this.jrk.getRootView());
        this.dLN = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        aHR();
        aNF();
        this.jrn.addView(this.jrl.getRootView());
        this.jrn.addView(this.jrm.getRootView());
        this.jrl.getRootView().setVisibility(8);
        this.jrm.getRootView().setVisibility(8);
    }

    private boolean csb() {
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
        if (!csb() && this.dLN.getChildAt(1) != null) {
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
                            a.this.jrk.getRootView().setVisibility(0);
                            a.this.jrl.getRootView().setVisibility(8);
                            a.this.jrm.getRootView().setVisibility(8);
                            a.this.jrk.rr(true);
                            a.this.jrl.rr(false);
                            a.this.jrm.rr(false);
                            break;
                        case 1:
                            a.this.jrm.getRootView().setVisibility(0);
                            a.this.jrl.getRootView().setVisibility(8);
                            a.this.jrk.getRootView().setVisibility(8);
                            a.this.jrk.rr(false);
                            if (TextUtils.isEmpty(a.this.jrl.csj())) {
                                a.this.jrl.rr(false);
                            } else {
                                a.this.jrl.rr(true);
                            }
                            a.this.jrm.rr(true);
                            break;
                        case 2:
                            a.this.jrl.getRootView().setVisibility(0);
                            a.this.jrk.getRootView().setVisibility(8);
                            a.this.jrm.getRootView().setVisibility(8);
                            a.this.jrk.rr(false);
                            a.this.jrl.rr(true);
                            a.this.jrm.rr(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.dLN.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.csc();
                    a.this.csd();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csc() {
        am amVar = new am("c12424");
        amVar.P("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csd() {
        if (this.mCurrentTabIndex == 0) {
            csh();
            csf();
            return;
        }
        replay();
    }

    public void replay() {
        csh();
        this.jrj.start();
        this.jrj.seekTo(0);
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
        csh();
        this.jrk.onPause();
        this.jrl.onPause();
        this.jrm.onPause();
    }

    public void onResume() {
        this.jrj.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.jrj.csn();
        }
        this.jrk.onResume();
        this.jrl.onResume();
        this.jrm.onResume();
    }

    public MaskVideoView cse() {
        return this.jrj;
    }

    public Bitmap B(Bitmap bitmap) {
        return this.jrk.B(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.jrl.setMusicData(list);
    }

    public void em(List<PendantData> list) {
        this.jrk.em(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.jrm != null) {
            this.jrm.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.jrk.setData(str);
                this.jrj.setVideoPath(str);
                this.jrj.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.jrk.csq();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.jrj.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.jrj.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.jrj.seekTo(a.this.jrk.getCurrentPosition());
                    }
                });
                this.jrj.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.jrl.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void csf() {
        if (this.jrj != null) {
            this.jrj.seekTo(this.jrk.getCurrentPosition());
        }
    }

    public void csg() {
        if (this.jrj != null) {
            this.jrj.BA(this.jrk.getCurrentPosition());
        }
    }

    public void csh() {
        if (this.jrj != null) {
            this.jrj.csm();
        }
    }

    public void csi() {
        if (this.jrj != null) {
            this.jrj.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.dLN.onChangeSkinType(i);
        this.dLN.setDiverColor(i == 1 ? this.mResources.getColor(R.color.cp_cont_b_1) : this.mResources.getColor(R.color.cp_cont_b));
        al.l(this.mRootView, R.color.cp_bg_line_d);
        if (this.jrk != null) {
            this.jrk.onChangeSkinType(eVar, i);
        }
        if (this.jrl != null) {
            this.jrl.onChangeSkinType(eVar, i);
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
                a.this.jrk.cdb();
                if (a.this.jqb != null) {
                    a.this.jqb.crq();
                }
            }
        }), R.color.cp_cont_f);
    }

    public String getText() {
        return this.jrk.getText();
    }

    public int getCurrentPosition() {
        if (this.jrj == null) {
            return 0;
        }
        return this.jrj.getCurrentPosition();
    }

    public void showDialog() {
        if (this.iih == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.iih = new i(getPageContext());
            this.iih.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.iih.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.bNj);
        }
        this.iih.showDialog();
    }

    public void es(String str, String str2) {
        this.jrl.es(str, str2);
    }

    public void crv() {
        if (this.jqb != null) {
            this.jqb.crv();
        }
    }

    public String csj() {
        return this.jrl.csj();
    }

    public String csk() {
        return this.jrl.csk();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean csl() {
        return this.jrl.csl();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.jrk != null) {
            this.jrk.release();
        }
        if (this.jrj != null) {
            this.jrj.stopPlayback();
        }
    }

    public void ay(Intent intent) {
        this.jrl.ay(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && cse() != null) {
            cse().setGenMaskCoverListener(bVar);
        }
    }
}
