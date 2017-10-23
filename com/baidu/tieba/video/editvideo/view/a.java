package com.baidu.tieba.video.editvideo.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.VideoView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.MusicData;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c {
    private com.baidu.tbadk.core.dialog.a KB;
    private MediaPlayer aWg;
    public int adF;
    private FragmentTabWidget bqm;
    private Resources fEG;
    private boolean fZk;
    private VideoView gvS;
    private b gvT;
    private c gvU;
    private FrameLayout gvV;
    private com.baidu.tieba.video.editvideo.a gvk;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view) {
        super(eVar);
        this.adF = 0;
        this.gvk = aVar;
        this.mRootView = view;
        this.fEG = view.getResources();
        this.gvT = new b(this.mContext, this);
        this.gvU = new c(this.mContext, this);
        this.gvT.bJ(this.mRootView);
        this.gvU.bJ(this.mRootView);
        initView();
        bvR();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.navigation_bar);
        this.gvS = (VideoView) this.mRootView.findViewById(d.h.video_view);
        this.gvS.setZOrderMediaOverlay(true);
        this.gvV = (FrameLayout) this.mRootView.findViewById(d.h.edit_container);
        this.gvV.addView(this.gvT.getRootView());
        this.bqm = (FragmentTabWidget) this.mRootView.findViewById(d.h.tab_widget);
        aiw();
        Rn();
    }

    private void Rn() {
        String[] stringArray = this.fEG.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.e.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.fEG.getDimension(d.f.fontsize34));
            this.bqm.addView(fragmentTabIndicator, i);
        }
        this.bqm.setDiverColor(this.fEG.getColor(d.e.cp_cont_b));
        this.bqm.a(this.adF, true, false);
        this.bqm.setBackGroundDrawableResId(d.e.cp_bg_line_d);
        this.bqm.setDviderRectWidth(l.f(this.mContext.getPageActivity(), d.f.ds60));
        this.bqm.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void e(int i2, boolean z) {
                if (i2 != a.this.adF) {
                    a.this.gvV.removeAllViews();
                    switch (i2) {
                        case 0:
                            a.this.gvV.addView(a.this.gvT.getRootView());
                            a.this.gvT.nb(true);
                            a.this.gvU.nb(false);
                            break;
                        case 1:
                            a.this.gvV.addView(a.this.gvU.getRootView());
                            a.this.gvT.nb(false);
                            a.this.gvU.nb(true);
                            break;
                    }
                    a.this.adF = i2;
                    a.this.bqm.a(a.this.adF, true, true);
                    a.this.bvR();
                    a.this.bvS();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvR() {
        ak akVar = new ak("c12424");
        akVar.r("obj_locate", this.adF == 0 ? 1 : 3);
        TiebaStatic.log(akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvS() {
        if (this.adF == 0) {
            aik();
            bvV();
            return;
        }
        bvT();
    }

    public void bvT() {
        aik();
        this.gvS.start();
        this.gvS.seekTo(0);
    }

    public void na(boolean z) {
        if (this.aWg != null) {
            this.fZk = z;
            if (z) {
                this.aWg.setVolume(0.0f, 0.0f);
            } else {
                this.aWg.setVolume(1.0f, 1.0f);
            }
            bvT();
        }
    }

    public void onPause() {
        aik();
        this.gvT.onPause();
        this.gvU.onPause();
    }

    public void onResume() {
        if (this.adF != 0) {
            this.gvS.start();
            this.gvS.seekTo(0);
        }
        this.gvT.onResume();
        this.gvU.onResume();
    }

    public VideoView bvU() {
        return this.gvS;
    }

    public Bitmap j(Bitmap bitmap) {
        return this.gvT.j(bitmap);
    }

    public void dz(List<MusicData> list) {
        this.gvU.dz(list);
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.gvT.setData(str);
                this.gvS.setVideoPath(str);
                this.gvS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.aWg = mediaPlayer;
                        if (a.this.fZk) {
                            a.this.aWg.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.aWg.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.gvT.bwd();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.gvS.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.adF == 0) {
                                        a.this.gvS.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.gvS.seekTo(a.this.gvT.getCurrentPosition());
                    }
                });
                this.gvS.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.adF != 0) {
                            a.this.bvT();
                            a.this.gvU.bvT();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bvV() {
        this.gvS.seekTo(this.gvT.getCurrentPosition());
    }

    public void aik() {
        if (this.gvS.canPause()) {
            this.gvS.pause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.bqm.onChangeSkinType(i);
        this.bqm.setDiverColor(i == 1 ? this.fEG.getColor(d.e.cp_cont_b_1) : this.fEG.getColor(d.e.cp_cont_b));
        aj.k(this.mRootView, d.e.cp_bg_line_d);
        if (this.gvT != null) {
            this.gvT.onChangeSkinType(eVar, i);
        }
        if (this.gvU != null) {
            this.gvU.onChangeSkinType(eVar, i);
        }
    }

    private void aiw() {
        this.mNavigationBar.setCenterTextTitle(this.fEG.getString(d.l.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        aj.i(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fEG.getString(d.l.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gvT.beQ();
                if (a.this.gvk != null) {
                    a.this.gvk.bvC();
                }
            }
        }), d.e.cp_cont_f);
    }

    public String getText() {
        return this.gvT.getText();
    }

    public int getCurrentPosition() {
        if (this.gvS == null) {
            return 0;
        }
        return this.gvS.getCurrentPosition();
    }

    public void showDialog() {
        if (this.KB == null) {
            this.KB = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.KB.cL(getPageContext().getResources().getString(d.l.select_cover_save));
            this.KB.a(d.l.save, new a.b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (a.this.gvk != null) {
                        a.this.gvk.bvF();
                    }
                }
            });
            this.KB.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.video.editvideo.view.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (a.this.gvk != null) {
                        a.this.gvk.finishPage();
                    }
                }
            });
            this.KB.b(getPageContext());
        }
        this.KB.tb();
    }

    public void cj(String str, String str2) {
        this.gvU.cj(str, str2);
    }

    public void bvH() {
        if (this.gvk != null) {
            this.gvk.bvH();
        }
    }

    public void bvW() {
        this.gvT.bvW();
    }

    public String bvX() {
        return this.gvU.bvX();
    }

    public String bvY() {
        return this.gvU.bvY();
    }

    public boolean bvZ() {
        return this.fZk;
    }

    public boolean bwa() {
        return this.gvU.bwa();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.gvT != null) {
            this.gvT.release();
        }
        if (this.gvS != null) {
            this.gvS.stopPlayback();
        }
    }
}
