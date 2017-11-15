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
    private MediaPlayer aZT;
    private FragmentTabWidget bsl;
    private Resources fOt;
    private com.baidu.tieba.video.editvideo.a gFv;
    private VideoView gGE;
    private com.baidu.tbadk.core.dialog.b gGF;
    private b gGG;
    private c gGH;
    private FrameLayout gGI;
    private b.InterfaceC0047b gGJ;
    public int mCurrentTabIndex;
    private boolean mIsMute;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public a(e eVar, com.baidu.tieba.video.editvideo.a aVar, View view) {
        super(eVar);
        this.mCurrentTabIndex = 0;
        this.gGJ = new b.InterfaceC0047b() { // from class: com.baidu.tieba.video.editvideo.view.a.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                switch (i) {
                    case 0:
                        if (a.this.gFv != null) {
                            a.this.gFv.byW();
                            break;
                        }
                        break;
                    case 1:
                        if (a.this.gFv != null) {
                            a.this.gFv.finishPage();
                            break;
                        }
                        break;
                }
                bVar.dismiss();
            }
        };
        this.gFv = aVar;
        this.mRootView = view;
        this.fOt = view.getResources();
        this.gGG = new b(this.mContext, this);
        this.gGH = new c(this.mContext, this);
        this.gGG.bM(this.mRootView);
        this.gGH.bM(this.mRootView);
        initView();
        bzr();
    }

    private void initView() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.navigation_bar);
        this.gGE = (VideoView) this.mRootView.findViewById(d.g.video_view);
        this.gGE.setZOrderMediaOverlay(true);
        this.gGI = (FrameLayout) this.mRootView.findViewById(d.g.edit_container);
        this.gGI.addView(this.gGG.getRootView());
        this.bsl = (FragmentTabWidget) this.mRootView.findViewById(d.g.tab_widget);
        akW();
        RP();
        this.gGI.addView(this.gGH.getRootView());
        this.gGH.getRootView().setVisibility(8);
    }

    private void RP() {
        String[] stringArray = this.fOt.getStringArray(d.b.edit_video_tab);
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(d.C0080d.edit_video_tab_title_color);
            fragmentTabIndicator.setTextSize(0, this.fOt.getDimension(d.e.fontsize34));
            this.bsl.addView(fragmentTabIndicator, i);
        }
        this.bsl.setDiverColor(this.fOt.getColor(d.C0080d.cp_cont_b));
        this.bsl.a(this.mCurrentTabIndex, true, false);
        this.bsl.setBackGroundDrawableResId(d.C0080d.cp_bg_line_d);
        this.bsl.setDviderRectWidth(l.f(this.mContext.getPageActivity(), d.e.ds64));
        this.bsl.setTabSelectionListener(new FragmentTabWidget.a() { // from class: com.baidu.tieba.video.editvideo.view.a.1
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
            public void e(int i2, boolean z) {
                if (i2 != a.this.mCurrentTabIndex) {
                    switch (i2) {
                        case 0:
                            a.this.gGG.getRootView().setVisibility(0);
                            a.this.gGH.getRootView().setVisibility(8);
                            a.this.gGG.ne(true);
                            a.this.gGH.ne(false);
                            break;
                        case 1:
                            a.this.gGH.getRootView().setVisibility(0);
                            a.this.gGG.getRootView().setVisibility(8);
                            a.this.gGG.ne(false);
                            a.this.gGH.ne(true);
                            break;
                    }
                    a.this.mCurrentTabIndex = i2;
                    a.this.bsl.a(a.this.mCurrentTabIndex, true, true);
                    a.this.bzr();
                    a.this.bzs();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzr() {
        ak akVar = new ak("c12424");
        akVar.r("obj_locate", this.mCurrentTabIndex == 0 ? 1 : 3);
        TiebaStatic.log(akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzs() {
        if (this.mCurrentTabIndex == 0) {
            akG();
            bzv();
            return;
        }
        bzt();
    }

    public void bzt() {
        akG();
        this.gGE.start();
        this.gGE.seekTo(0);
    }

    public void setMute(boolean z) {
        if (this.aZT != null) {
            this.mIsMute = z;
            if (z) {
                this.aZT.setVolume(0.0f, 0.0f);
            } else {
                this.aZT.setVolume(1.0f, 1.0f);
            }
            bzt();
        }
    }

    public void onPause() {
        akG();
        this.gGG.onPause();
        this.gGH.onPause();
    }

    public void onResume() {
        if (this.mCurrentTabIndex != 0) {
            this.gGE.start();
            this.gGE.seekTo(0);
        }
        this.gGG.onResume();
        this.gGH.onResume();
    }

    public VideoView bzu() {
        return this.gGE;
    }

    public Bitmap j(Bitmap bitmap) {
        return this.gGG.j(bitmap);
    }

    public void setMusicData(List<MusicData> list) {
        this.gGH.setMusicData(list);
    }

    public void dC(List<PendantData> list) {
        this.gGG.dC(list);
    }

    public void setData(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.gGG.setData(str);
                this.gGE.setVideoPath(str);
                this.gGE.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        a.this.aZT = mediaPlayer;
                        if (a.this.mIsMute) {
                            a.this.aZT.setVolume(0.0f, 0.0f);
                        } else {
                            a.this.aZT.setVolume(1.0f, 1.0f);
                        }
                        com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.gGG.bzB();
                            }
                        }, 200L);
                        if (Build.VERSION.SDK_INT >= 17) {
                            a.this.gGE.start();
                            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.video.editvideo.view.a.2.2
                                @Override // android.media.MediaPlayer.OnInfoListener
                                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                                    if (i == 3 && a.this.mCurrentTabIndex == 0) {
                                        a.this.gGE.pause();
                                        return true;
                                    }
                                    return true;
                                }
                            });
                            return;
                        }
                        a.this.gGE.seekTo(a.this.gGG.getCurrentPosition());
                    }
                });
                this.gGE.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.video.editvideo.view.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (a.this.mCurrentTabIndex != 0) {
                            a.this.bzt();
                            a.this.gGH.bzt();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bzv() {
        this.gGE.seekTo(this.gGG.getCurrentPosition());
    }

    public void akG() {
        if (this.gGE.canPause()) {
            this.gGE.pause();
        }
    }

    public void onChangeSkinType(e eVar, int i) {
        this.mNavigationBar.onChangeSkinType(eVar, i);
        this.bsl.onChangeSkinType(i);
        this.bsl.setDiverColor(i == 1 ? this.fOt.getColor(d.C0080d.cp_cont_b_1) : this.fOt.getColor(d.C0080d.cp_cont_b));
        aj.k(this.mRootView, d.C0080d.cp_bg_line_d);
        if (this.gGG != null) {
            this.gGG.onChangeSkinType(eVar, i);
        }
        if (this.gGH != null) {
            this.gGH.onChangeSkinType(eVar, i);
        }
    }

    private void akW() {
        this.mNavigationBar.setCenterTextTitle(this.fOt.getString(d.j.select_cover));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.showDialog();
            }
        });
        aj.i(this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fOt.getString(d.j.select_cover_next), new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gGG.bin();
                if (a.this.gFv != null) {
                    a.this.gFv.byT();
                }
            }
        }), d.C0080d.cp_cont_f);
    }

    public String getText() {
        return this.gGG.getText();
    }

    public int getCurrentPosition() {
        if (this.gGE == null) {
            return 0;
        }
        return this.gGE.getCurrentPosition();
    }

    public void showDialog() {
        if (this.gGF == null) {
            String[] strArr = {getPageContext().getString(d.j.save), getPageContext().getString(d.j.not_save), getPageContext().getString(d.j.cancel)};
            this.gGF = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            this.gGF.cg(b.a.abA);
            this.gGF.ci(17);
            this.gGF.cT(TbadkCoreApplication.getInst().getResources().getString(d.j.save_video_title));
            this.gGF.a(strArr, this.gGJ);
            this.gGF.d(getPageContext());
            TextView tk = this.gGF.tk();
            if (tk != null) {
                tk.setGravity(17);
                tk.setTextSize(0, this.fOt.getDimensionPixelSize(d.e.fontsize24));
                aj.i(tk, d.C0080d.cp_cont_d);
            }
        }
        this.gGF.tl();
    }

    public void ck(String str, String str2) {
        this.gGH.ck(str, str2);
    }

    public void byY() {
        if (this.gFv != null) {
            this.gFv.byY();
        }
    }

    public void bzw() {
        this.gGG.bzw();
    }

    public String bzx() {
        return this.gGH.bzx();
    }

    public String bzy() {
        return this.gGH.bzy();
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public boolean bzz() {
        return this.gGH.bzz();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void release() {
        if (this.gGG != null) {
            this.gGG.release();
        }
        if (this.gGE != null) {
            this.gGE.stopPlayback();
        }
    }

    public void Z(Intent intent) {
        this.gGH.Z(intent);
    }
}
