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
    private com.baidu.tbadk.core.dialog.a KA;
    private MediaPlayer aWt;
    public int adR;
    private FragmentTabWidget bqy;
    private Resources fEV;
    private boolean fZz;
    private com.baidu.tieba.video.editvideo.a gvz;
    private VideoView gwh;
    private b gwi;
    private c gwj;
    private FrameLayout gwk;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view) {
        super(eVar);
        this.adR = 0;
        this.gvz = aVar;
        this.mRootView = view;
        this.fEV = view.getResources();
        this.gwi = new b(this.mContext, this);
        this.gwj = new c(this.mContext, this);
        this.gwi.bJ(this.mRootView);
        this.gwj.bJ(this.mRootView);
        initView();
        bwa();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.navigation_bar);
        this.gwh = (VideoView) this.mRootView.findViewById(d.h.video_view);
        this.gwh.setZOrderMediaOverlay(true);
        this.gwk = (FrameLayout) this.mRootView.findViewById(d.h.edit_container);
        this.gwk.addView(this.gwi.getRootView());
        this.bqy = (FragmentTabWidget) this.mRootView.findViewById(d.h.tab_widget);
        aiB();
        Rr();
    }

    private void Rr() {
        String[] stringArray = this.fEV.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.e.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.fEV.getDimension(d.f.fontsize34));
            this.bqy.addView(fragmentTabIndicator, i);
        }
        this.bqy.setDiverColor(this.fEV.getColor(d.e.cp_cont_b));
        this.bqy.a(this.adR, true, false);
        this.bqy.setBackGroundDrawableResId(d.e.cp_bg_line_d);
        this.bqy.setDviderRectWidth(l.f(this.mContext.getPageActivity(), d.f.ds60));
        this.bqy.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void e(int i2, boolean z) {
                if (i2 != a.this.adR) {
                    a.this.gwk.removeAllViews();
                    switch (i2) {
                        case 0:
                            a.this.gwk.addView(a.this.gwi.getRootView());
                            a.this.gwi.nc(true);
                            a.this.gwj.nc(false);
                            break;
                        case 1:
                            a.this.gwk.addView(a.this.gwj.getRootView());
                            a.this.gwi.nc(false);
                            a.this.gwj.nc(true);
                            break;
                    }
                    a.this.adR = i2;
                    a.this.bqy.a(a.this.adR, true, true);
                    a.this.bwa();
                    a.this.bwb();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwa() {
        ak akVar = new ak("c12424");
        akVar.r("obj_locate", this.adR == 0 ? 1 : 3);
        TiebaStatic.log(akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwb() {
        if (this.adR == 0) {
            aip();
            bwe();
            return;
        }
        bwc();
    }

    public void bwc() {
        aip();
        this.gwh.start();
        this.gwh.seekTo(0);
    }

    public void nb(boolean z) {
        if (this.aWt != null) {
            this.fZz = z;
            if (z) {
                this.aWt.setVolume(0.0f, 0.0f);
            } else {
                this.aWt.setVolume(1.0f, 1.0f);
            }
            bwc();
        }
    }

    public void onPause() {
        aip();
        this.gwi.onPause();
        this.gwj.onPause();
    }

    public void onResume() {
        if (this.adR != 0) {
            this.gwh.start();
            this.gwh.seekTo(0);
        }
        this.gwi.onResume();
        this.gwj.onResume();
    }

    public VideoView bwd() {
        return this.gwh;
    }

    public Bitmap j(Bitmap bitmap) {
        return this.gwi.j(bitmap);
    }

    public void dz(List<MusicData> list) {
        this.gwj.dz(list);
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.gwi.setData(str);
                this.gwh.setVideoPath(str);
                this.gwh.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.aWt = mediaPlayer;
                        if (a.this.fZz) {
                            a.this.aWt.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.aWt.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.gwi.bwm();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.gwh.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.adR == 0) {
                                        a.this.gwh.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.gwh.seekTo(a.this.gwi.getCurrentPosition());
                    }
                });
                this.gwh.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.adR != 0) {
                            a.this.bwc();
                            a.this.gwj.bwc();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bwe() {
        this.gwh.seekTo(this.gwi.getCurrentPosition());
    }

    public void aip() {
        if (this.gwh.canPause()) {
            this.gwh.pause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.bqy.onChangeSkinType(i);
        this.bqy.setDiverColor(i == 1 ? this.fEV.getColor(d.e.cp_cont_b_1) : this.fEV.getColor(d.e.cp_cont_b));
        aj.k(this.mRootView, d.e.cp_bg_line_d);
        if (this.gwi != null) {
            this.gwi.onChangeSkinType(eVar, i);
        }
        if (this.gwj != null) {
            this.gwj.onChangeSkinType(eVar, i);
        }
    }

    private void aiB() {
        this.mNavigationBar.setCenterTextTitle(this.fEV.getString(d.l.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        aj.i(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fEV.getString(d.l.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gwi.beW();
                if (a.this.gvz != null) {
                    a.this.gvz.bvL();
                }
            }
        }), d.e.cp_cont_f);
    }

    public String getText() {
        return this.gwi.getText();
    }

    public int getCurrentPosition() {
        if (this.gwh == null) {
            return 0;
        }
        return this.gwh.getCurrentPosition();
    }

    public void showDialog() {
        if (this.KA == null) {
            this.KA = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.KA.cM(getPageContext().getResources().getString(d.l.select_cover_save));
            this.KA.a(d.l.save, new a.b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (a.this.gvz != null) {
                        a.this.gvz.bvO();
                    }
                }
            });
            this.KA.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.video.editvideo.view.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (a.this.gvz != null) {
                        a.this.gvz.finishPage();
                    }
                }
            });
            this.KA.b(getPageContext());
        }
        this.KA.ti();
    }

    public void ck(String str, String str2) {
        this.gwj.ck(str, str2);
    }

    public void bvQ() {
        if (this.gvz != null) {
            this.gvz.bvQ();
        }
    }

    public void bwf() {
        this.gwi.bwf();
    }

    public String bwg() {
        return this.gwj.bwg();
    }

    public String bwh() {
        return this.gwj.bwh();
    }

    public boolean bwi() {
        return this.fZz;
    }

    public boolean bwj() {
        return this.gwj.bwj();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.gwi != null) {
            this.gwi.release();
        }
        if (this.gwh != null) {
            this.gwh.stopPlayback();
        }
    }
}
