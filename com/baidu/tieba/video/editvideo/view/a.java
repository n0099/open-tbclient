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
    private Resources fEU;
    private boolean fZy;
    private com.baidu.tieba.video.editvideo.a gvy;
    private VideoView gwg;
    private b gwh;
    private c gwi;
    private FrameLayout gwj;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view) {
        super(eVar);
        this.adR = 0;
        this.gvy = aVar;
        this.mRootView = view;
        this.fEU = view.getResources();
        this.gwh = new b(this.mContext, this);
        this.gwi = new c(this.mContext, this);
        this.gwh.bJ(this.mRootView);
        this.gwi.bJ(this.mRootView);
        initView();
        bvZ();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.navigation_bar);
        this.gwg = (VideoView) this.mRootView.findViewById(d.h.video_view);
        this.gwg.setZOrderMediaOverlay(true);
        this.gwj = (FrameLayout) this.mRootView.findViewById(d.h.edit_container);
        this.gwj.addView(this.gwh.getRootView());
        this.bqy = (FragmentTabWidget) this.mRootView.findViewById(d.h.tab_widget);
        aiB();
        Rr();
    }

    private void Rr() {
        String[] stringArray = this.fEU.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.e.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.fEU.getDimension(d.f.fontsize34));
            this.bqy.addView(fragmentTabIndicator, i);
        }
        this.bqy.setDiverColor(this.fEU.getColor(d.e.cp_cont_b));
        this.bqy.a(this.adR, true, false);
        this.bqy.setBackGroundDrawableResId(d.e.cp_bg_line_d);
        this.bqy.setDviderRectWidth(l.f(this.mContext.getPageActivity(), d.f.ds60));
        this.bqy.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void e(int i2, boolean z) {
                if (i2 != a.this.adR) {
                    a.this.gwj.removeAllViews();
                    switch (i2) {
                        case 0:
                            a.this.gwj.addView(a.this.gwh.getRootView());
                            a.this.gwh.nc(true);
                            a.this.gwi.nc(false);
                            break;
                        case 1:
                            a.this.gwj.addView(a.this.gwi.getRootView());
                            a.this.gwh.nc(false);
                            a.this.gwi.nc(true);
                            break;
                    }
                    a.this.adR = i2;
                    a.this.bqy.a(a.this.adR, true, true);
                    a.this.bvZ();
                    a.this.bwa();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvZ() {
        ak akVar = new ak("c12424");
        akVar.r("obj_locate", this.adR == 0 ? 1 : 3);
        TiebaStatic.log(akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwa() {
        if (this.adR == 0) {
            aip();
            bwd();
            return;
        }
        bwb();
    }

    public void bwb() {
        aip();
        this.gwg.start();
        this.gwg.seekTo(0);
    }

    public void nb(boolean z) {
        if (this.aWt != null) {
            this.fZy = z;
            if (z) {
                this.aWt.setVolume(0.0f, 0.0f);
            } else {
                this.aWt.setVolume(1.0f, 1.0f);
            }
            bwb();
        }
    }

    public void onPause() {
        aip();
        this.gwh.onPause();
        this.gwi.onPause();
    }

    public void onResume() {
        if (this.adR != 0) {
            this.gwg.start();
            this.gwg.seekTo(0);
        }
        this.gwh.onResume();
        this.gwi.onResume();
    }

    public VideoView bwc() {
        return this.gwg;
    }

    public Bitmap j(Bitmap bitmap) {
        return this.gwh.j(bitmap);
    }

    public void dz(List<MusicData> list) {
        this.gwi.dz(list);
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.gwh.setData(str);
                this.gwg.setVideoPath(str);
                this.gwg.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.aWt = mediaPlayer;
                        if (a.this.fZy) {
                            a.this.aWt.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.aWt.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.gwh.bwl();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.gwg.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.adR == 0) {
                                        a.this.gwg.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.gwg.seekTo(a.this.gwh.getCurrentPosition());
                    }
                });
                this.gwg.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.adR != 0) {
                            a.this.bwb();
                            a.this.gwi.bwb();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bwd() {
        this.gwg.seekTo(this.gwh.getCurrentPosition());
    }

    public void aip() {
        if (this.gwg.canPause()) {
            this.gwg.pause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.bqy.onChangeSkinType(i);
        this.bqy.setDiverColor(i == 1 ? this.fEU.getColor(d.e.cp_cont_b_1) : this.fEU.getColor(d.e.cp_cont_b));
        aj.k(this.mRootView, d.e.cp_bg_line_d);
        if (this.gwh != null) {
            this.gwh.onChangeSkinType(eVar, i);
        }
        if (this.gwi != null) {
            this.gwi.onChangeSkinType(eVar, i);
        }
    }

    private void aiB() {
        this.mNavigationBar.setCenterTextTitle(this.fEU.getString(d.l.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        aj.i(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fEU.getString(d.l.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gwh.beV();
                if (a.this.gvy != null) {
                    a.this.gvy.bvK();
                }
            }
        }), d.e.cp_cont_f);
    }

    public String getText() {
        return this.gwh.getText();
    }

    public int getCurrentPosition() {
        if (this.gwg == null) {
            return 0;
        }
        return this.gwg.getCurrentPosition();
    }

    public void showDialog() {
        if (this.KA == null) {
            this.KA = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.KA.cM(getPageContext().getResources().getString(d.l.select_cover_save));
            this.KA.a(d.l.save, new a.b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (a.this.gvy != null) {
                        a.this.gvy.bvN();
                    }
                }
            });
            this.KA.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.video.editvideo.view.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    if (a.this.gvy != null) {
                        a.this.gvy.finishPage();
                    }
                }
            });
            this.KA.b(getPageContext());
        }
        this.KA.ti();
    }

    public void ck(String str, String str2) {
        this.gwi.ck(str, str2);
    }

    public void bvP() {
        if (this.gvy != null) {
            this.gvy.bvP();
        }
    }

    public void bwe() {
        this.gwh.bwe();
    }

    public String bwf() {
        return this.gwi.bwf();
    }

    public String bwg() {
        return this.gwi.bwg();
    }

    public boolean bwh() {
        return this.fZy;
    }

    public boolean bwi() {
        return this.gwi.bwi();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.gwh != null) {
            this.gwh.release();
        }
        if (this.gwg != null) {
            this.gwg.stopPlayback();
        }
    }
}
