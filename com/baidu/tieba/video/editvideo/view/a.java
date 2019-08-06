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
    private k.c bOp;
    private FragmentTabWidget dPC;
    private i ipD;
    private h jhv;
    private com.baidu.tieba.video.editvideo.a jxq;
    private d jyA;
    private c jyB;
    private FrameLayout jyC;
    private MaskVideoView jyy;
    private b jyz;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private Resources mResources;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view, h hVar) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.bOp = new k.c() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.jxq != null) {
                            a.this.jxq.cuA();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.jxq != null) {
                            a.this.jxq.finishPage();
                            break;
                        }
                        break;
                }
                if (a.this.ipD != null && a.this.ipD.isShowing() && a.this.getPageContext() != null) {
                    a.this.ipD.dismiss();
                }
            }
        };
        this.jxq = aVar;
        this.mRootView = view;
        this.jhv = hVar;
        this.mResources = view.getResources();
        this.jyz = new b(this.mContext, this);
        this.jyA = new d(this.mContext, this, this.jhv);
        this.jyB = new c(this.mContext, this);
        this.jyz.cX(this.mRootView);
        this.jyA.cX(this.mRootView);
        this.jyB.cX(this.mRootView);
        initView();
        cvl();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigation_bar);
        this.jyy = (MaskVideoView) this.mRootView.findViewById(R.id.video_view);
        this.jyy.setPreserveEGLContextOnPause(true);
        this.jyy.setZOrderMediaOverlay(true);
        this.jyy.setPostMonitorManager(this.jhv);
        this.jyC = (FrameLayout) this.mRootView.findViewById(R.id.edit_container);
        this.jyC.addView(this.jyz.getRootView());
        this.dPC = (FragmentTabWidget) this.mRootView.findViewById(R.id.tab_widget);
        aJt();
        aPt();
        this.jyC.addView(this.jyA.getRootView());
        this.jyC.addView(this.jyB.getRootView());
        this.jyA.getRootView().setVisibility(8);
        this.jyB.getRootView().setVisibility(8);
    }

    private boolean cvk() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void aPt() {
        String[] stringArray = this.mResources.getStringArray(R.array.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.mResources.getDimension(R.dimen.fontsize34));
            this.dPC.addView(fragmentTabIndicator, i);
        }
        if (!cvk() && this.dPC.getChildAt(1) != null) {
            this.dPC.getChildAt(1).setVisibility(8);
        }
        this.dPC.setDiverColor(this.mResources.getColor(R.color.cp_cont_b));
        this.dPC.setCurrentTab(this.mCurrentTabIndex, true, false);
        this.dPC.setBackGroundDrawableResId(R.color.cp_bg_line_d);
        this.dPC.setDviderRectWidth(l.g(this.mContext.getPageActivity(), R.dimen.ds64));
        this.dPC.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void onTabSelectionChanged(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.jyz.getRootView().setVisibility(0);
                            a.this.jyA.getRootView().setVisibility(8);
                            a.this.jyB.getRootView().setVisibility(8);
                            a.this.jyz.rF(true);
                            a.this.jyA.rF(false);
                            a.this.jyB.rF(false);
                            break;
                        case 1:
                            a.this.jyB.getRootView().setVisibility(0);
                            a.this.jyA.getRootView().setVisibility(8);
                            a.this.jyz.getRootView().setVisibility(8);
                            a.this.jyz.rF(false);
                            if (TextUtils.isEmpty(a.this.jyA.cvs())) {
                                a.this.jyA.rF(false);
                            } else {
                                a.this.jyA.rF(true);
                            }
                            a.this.jyB.rF(true);
                            break;
                        case 2:
                            a.this.jyA.getRootView().setVisibility(0);
                            a.this.jyz.getRootView().setVisibility(8);
                            a.this.jyB.getRootView().setVisibility(8);
                            a.this.jyz.rF(false);
                            a.this.jyA.rF(true);
                            a.this.jyB.rF(false);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.dPC.setCurrentTab(a.this.mCurrentTabIndex, true, true);
                    a.this.cvl();
                    a.this.cvm();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvl() {
        an anVar = new an("c12424");
        anVar.P("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvm() {
        if (this.mCurrentTabIndex == 0) {
            cvq();
            cvo();
            return;
        }
        replay();
    }

    public void replay() {
        cvq();
        this.jyy.start();
        this.jyy.seekTo(0);
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
        cvq();
        this.jyz.onPause();
        this.jyA.onPause();
        this.jyB.onPause();
    }

    public void onResume() {
        this.jyy.onResume();
        if (this.mCurrentTabIndex != 0) {
            this.jyy.cvw();
        }
        this.jyz.onResume();
        this.jyA.onResume();
        this.jyB.onResume();
    }

    public MaskVideoView cvn() {
        return this.jyy;
    }

    public Bitmap B(Bitmap bitmap) {
        return this.jyz.B(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.jyA.setMusicData(list);
    }

    public void eo(List<PendantData> list) {
        this.jyz.eo(list);
    }

    public void a(com.baidu.tieba.video.editvideo.b.a aVar) {
        if (this.jyB != null) {
            this.jyB.a(aVar);
        }
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.jyz.setData(str);
                this.jyy.setVideoPath(str);
                this.jyy.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
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
                                a.this.jyz.cvz();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.jyy.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.jyy.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.jyy.seekTo(a.this.jyz.getCurrentPosition());
                    }
                });
                this.jyy.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.replay();
                            a.this.jyA.replay();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cvo() {
        if (this.jyy != null) {
            this.jyy.seekTo(this.jyz.getCurrentPosition());
        }
    }

    public void cvp() {
        if (this.jyy != null) {
            this.jyy.Cj(this.jyz.getCurrentPosition());
        }
    }

    public void cvq() {
        if (this.jyy != null) {
            this.jyy.cvv();
        }
    }

    public void cvr() {
        if (this.jyy != null) {
            this.jyy.onPause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.dPC.onChangeSkinType(i);
        this.dPC.setDiverColor(i == 1 ? this.mResources.getColor(R.color.cp_cont_b_1) : this.mResources.getColor(R.color.cp_cont_b));
        am.l(this.mRootView, R.color.cp_bg_line_d);
        if (this.jyz != null) {
            this.jyz.onChangeSkinType(eVar, i);
        }
        if (this.jyA != null) {
            this.jyA.onChangeSkinType(eVar, i);
        }
    }

    private void aJt() {
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
                a.this.jyz.cgk();
                if (a.this.jxq != null) {
                    a.this.jxq.cux();
                }
            }
        }), R.color.cp_cont_f);
    }

    public String getText() {
        return this.jyz.getText();
    }

    public int getCurrentPosition() {
        if (this.jyy == null) {
            return 0;
        }
        return this.jyy.getCurrentPosition();
    }

    public void showDialog() {
        if (this.ipD == null) {
            String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
            this.ipD = new i(getPageContext());
            this.ipD.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
            this.ipD.a(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.bOp);
        }
        this.ipD.showDialog();
    }

    public void et(String str, String str2) {
        this.jyA.et(str, str2);
    }

    public void cuC() {
        if (this.jxq != null) {
            this.jxq.cuC();
        }
    }

    public String cvs() {
        return this.jyA.cvs();
    }

    public String cvt() {
        return this.jyA.cvt();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean cvu() {
        return this.jyA.cvu();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.jyz != null) {
            this.jyz.release();
        }
        if (this.jyy != null) {
            this.jyy.cey();
        }
    }

    public void aA(Intent intent) {
        this.jyA.aA(intent);
    }

    public void setGenMaskCoverListener(MaskVideoView.b bVar) {
        if (bVar != null && cvn() != null) {
            cvn().setGenMaskCoverListener(bVar);
        }
    }
}
