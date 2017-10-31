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
import android.widget.VideoView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c {
    private MediaPlayer aZK;
    private FragmentTabWidget bsb;
    private Resources fNu;
    private com.baidu.tieba.video.editvideo.a gEn;
    private FrameLayout gFA;
    private b.InterfaceC0047b gFB;
    private VideoView gFw;
    private com.baidu.tbadk.core.dialog.b gFx;
    private b gFy;
    private c gFz;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.gFB = new b.InterfaceC0047b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.gEn != null) {
                            a.this.gEn.byK();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.gEn != null) {
                            a.this.gEn.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.gEn = aVar;
        this.mRootView = view;
        this.fNu = view.getResources();
        this.gFy = new b(this.mContext, this);
        this.gFz = new c(this.mContext, this);
        this.gFy.bL(this.mRootView);
        this.gFz.bL(this.mRootView);
        initView();
        bzf();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.gFw = (VideoView) this.mRootView.findViewById(d.g.video_view);
        this.gFw.setZOrderMediaOverlay(true);
        this.gFA = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.gFA.addView(this.gFy.getRootView());
        this.bsb = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        akI();
        RG();
        this.gFA.addView(this.gFz.getRootView());
        this.gFz.getRootView().setVisibility(8);
    }

    private void RG() {
        String[] stringArray = this.fNu.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0080d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.fNu.getDimension(d.e.fontsize34));
            this.bsb.addView(fragmentTabIndicator, i);
        }
        this.bsb.setDiverColor(this.fNu.getColor(d.C0080d.cp_cont_b));
        this.bsb.a(this.mCurrentTabIndex, true, false);
        this.bsb.setBackGroundDrawableResId(d.C0080d.cp_bg_line_d);
        this.bsb.setDviderRectWidth(l.f(this.mContext.getPageActivity(), d.e.ds64));
        this.bsb.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void e(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.gFy.getRootView().setVisibility(0);
                            a.this.gFz.getRootView().setVisibility(8);
                            a.this.gFy.mW(true);
                            a.this.gFz.mW(false);
                            break;
                        case 1:
                            a.this.gFz.getRootView().setVisibility(0);
                            a.this.gFy.getRootView().setVisibility(8);
                            a.this.gFy.mW(false);
                            a.this.gFz.mW(true);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.bsb.a(a.this.mCurrentTabIndex, true, true);
                    a.this.bzf();
                    a.this.bzg();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzf() {
        ak akVar = new ak("c12424");
        akVar.r("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzg() {
        if (this.mCurrentTabIndex == 0) {
            aks();
            bzj();
            return;
        }
        bzh();
    }

    public void bzh() {
        aks();
        this.gFw.start();
        this.gFw.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.aZK != null) {
            this.mIsMute = z;
            if (z) {
                this.aZK.setVolume(0.0f, 0.0f);
            } else {
                this.aZK.setVolume(1.0f, 1.0f);
            }
            bzh();
        }
    }

    public void onPause() {
        aks();
        this.gFy.onPause();
        this.gFz.onPause();
    }

    public void onResume() {
        if (this.mCurrentTabIndex != 0) {
            this.gFw.start();
            this.gFw.seekTo(0);
        }
        this.gFy.onResume();
        this.gFz.onResume();
    }

    public VideoView bzi() {
        return this.gFw;
    }

    public Bitmap j(Bitmap bitmap) {
        return this.gFy.j(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.gFz.setMusicData(list);
    }

    public void dB(List<PendantData> list) {
        this.gFy.dB(list);
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.gFy.setData(str);
                this.gFw.setVideoPath(str);
                this.gFw.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.aZK = mediaPlayer;
                        if (a.this.mIsMute) {
                            a.this.aZK.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.aZK.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.gFy.bzp();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.gFw.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.gFw.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.gFw.seekTo(a.this.gFy.getCurrentPosition());
                    }
                });
                this.gFw.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.bzh();
                            a.this.gFz.bzh();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bzj() {
        this.gFw.seekTo(this.gFy.getCurrentPosition());
    }

    public void aks() {
        if (this.gFw.canPause()) {
            this.gFw.pause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.bsb.onChangeSkinType(i);
        this.bsb.setDiverColor(i == 1 ? this.fNu.getColor(d.C0080d.cp_cont_b_1) : this.fNu.getColor(d.C0080d.cp_cont_b));
        aj.k(this.mRootView, d.C0080d.cp_bg_line_d);
        if (this.gFy != null) {
            this.gFy.onChangeSkinType(eVar, i);
        }
        if (this.gFz != null) {
            this.gFz.onChangeSkinType(eVar, i);
        }
    }

    private void akI() {
        this.mNavigationBar.setCenterTextTitle(this.fNu.getString(d.j.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        aj.i(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fNu.getString(d.j.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gFy.bic();
                if (a.this.gEn != null) {
                    a.this.gEn.byH();
                }
            }
        }), d.C0080d.cp_cont_f);
    }

    public String getText() {
        return this.gFy.getText();
    }

    public int getCurrentPosition() {
        if (this.gFw == null) {
            return 0;
        }
        return this.gFw.getCurrentPosition();
    }

    public void showDialog() {
        if (this.gFx == null) {
            String[] strArr = {getPageContext().getString(d.j.save), getPageContext().getString(d.j.not_save), getPageContext().getString(d.j.cancel)};
            this.gFx = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.gFx.cg(b.a.abA);
            this.gFx.ci(17);
            this.gFx.cT(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title));
            this.gFx.a(strArr, this.gFB);
            this.gFx.d(getPageContext());
            TextView tk = this.gFx.tk();
            if (tk != null) {
                tk.setGravity(17);
                tk.setTextSize(0, this.fNu.getDimensionPixelSize(d.e.fontsize24));
                aj.i(tk, d.C0080d.cp_cont_d);
            }
        }
        this.gFx.tl();
    }

    public void cg(String str, String str2) {
        this.gFz.cg(str, str2);
    }

    public void byM() {
        if (this.gEn != null) {
            this.gEn.byM();
        }
    }

    public void bzk() {
        this.gFy.bzk();
    }

    public String bzl() {
        return this.gFz.bzl();
    }

    public String bzm() {
        return this.gFz.bzm();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bzn() {
        return this.gFz.bzn();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.gFy != null) {
            this.gFy.release();
        }
        if (this.gFw != null) {
            this.gFw.stopPlayback();
        }
    }

    public void Z(Intent intent) {
        this.gFz.Z(intent);
    }
}
