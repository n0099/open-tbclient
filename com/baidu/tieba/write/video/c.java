package com.baidu.tieba.write.video;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.editor.StateSwitchView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    public static int hGA = 31;
    private RelativeLayout ciR;
    private ScrollView dzR;
    private ImageView fja;
    private WriteVideoActivity hGB;
    private TextView hGC;
    private EditText hGD;
    private StateSwitchView hGE;
    private WriteLocationView hGF;
    private TextView hGG;
    private com.baidu.tieba.write.b hGH;
    private LinearLayout hGI;
    private ListView hGJ;
    private b hGK;
    private LinearLayout hGL;
    private TextView hGM;
    private TextView hGN;
    private TextView hGO;
    private boolean hGP = true;
    private CustomVideoView hrU;
    private ImageView hrX;
    private int hse;
    private NavigationBar mNavigationBar;

    public c(WriteVideoActivity writeVideoActivity) {
        this.hGB = writeVideoActivity;
        this.hGB.setContentView(d.h.write_video_activity);
        this.hGH = new com.baidu.tieba.write.b();
        this.hGH.xg(d.C0108d.cp_cont_i);
        this.hGH.xh(d.C0108d.cp_cont_h_alpha85);
        bGr();
        initView();
    }

    private void bGr() {
        this.ciR = (RelativeLayout) this.hGB.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hGB.findViewById(d.g.navigation_bar);
        this.hGD = (EditText) this.hGB.findViewById(d.g.edit_content);
        this.hGG = (TextView) this.hGB.findViewById(d.g.text_content_size);
        this.hrX = (ImageView) this.hGB.findViewById(d.g.video_cover);
        this.hGF = (WriteLocationView) this.hGB.findViewById(d.g.location);
        this.hrU = (CustomVideoView) this.hGB.findViewById(d.g.preview_videoview);
        this.dzR = (ScrollView) this.hGB.findViewById(d.g.write_scrollview);
        this.hrU.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.c.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (c.this.hrU.getWidth() != c.this.hrX.getWidth() || c.this.hrU.getHeight() != c.this.hrX.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = c.this.hrX.getLayoutParams();
                    layoutParams.width = c.this.hrU.getWidth();
                    layoutParams.height = c.this.hrU.getHeight();
                    c.this.hrX.setLayoutParams(layoutParams);
                }
                c.this.hrX.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.hrU.start();
                        c.this.hrX.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.hrU.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.c.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                c.this.cT(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hGI = (LinearLayout) this.hGB.findViewById(d.g.video_activity_title_container);
        this.hGJ = (ListView) this.hGB.findViewById(d.g.video_activity_title_list);
        this.hGJ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.hGI.setVisibility(8);
                c.this.hGG.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    c.this.hGD.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    c.this.hGD.requestFocus();
                    if (!TextUtils.isEmpty(c.this.hGD.getText())) {
                        c.this.hGD.setSelection(c.this.hGD.getText().length());
                    }
                    l.b(c.this.hGB, c.this.hGD);
                }
            }
        });
        this.hGL = (LinearLayout) this.hGB.findViewById(d.g.save_video_wrapper);
        this.hGM = (TextView) this.hGB.findViewById(d.g.save_video_ridiobutton);
        this.hGN = (TextView) this.hGB.findViewById(d.g.save_video_ridiotext);
        this.hGO = (TextView) this.hGB.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ao(this.hGB) / l.s(this.hGB, d.e.ds440)) {
            i3 = l.ao(this.hGB);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int s = l.s(this.hGB, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((s / i2) * i);
                i4 = s;
            } else {
                i3 = 0;
                i4 = s;
            }
        }
        this.hrU.setVideoHeight(i4);
        this.hrU.setVideoWidth(i3);
        this.hrU.invalidate();
    }

    private void initView() {
        this.fja = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.hGB);
        this.mNavigationBar.setCenterTextTitle(this.hGB.getPageContext().getString(d.j.post_video_title));
        this.hGC = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.hGB);
        this.hGC.setText(d.j.send_post);
        this.hGD.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.c.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hGD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.c.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && c.this.hGK != null && c.this.hGK.getCount() > 0) {
                    l.a(c.this.hGB, c.this.hGD);
                    c.this.hGI.setVisibility(0);
                    c.this.hGG.setVisibility(8);
                }
                long bGt = c.hGA - c.this.bGt();
                if (bGt >= 0) {
                    aj.r(c.this.hGG, d.C0108d.cp_cont_e);
                    c.this.hGG.setText(String.valueOf(bGt));
                    return;
                }
                c.this.hGG.setText("0");
                c.this.hGD.setText(c.this.hGD.getText().toString().substring(0, c.hGA));
                c.this.hGD.setSelection(c.this.hGD.getText().length());
                c.this.hGB.showToast(c.this.hGB.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (c.this.hGH != null) {
                    if (!c.this.hGH.bER()) {
                        c.this.nC(false);
                    }
                    c.this.hGH.nu(false);
                }
            }
        });
        this.hGK = new b();
        this.hGJ.setAdapter((ListAdapter) this.hGK);
        this.hGP = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hGP) {
            aj.s(this.hGM, d.f.corner_bg_radio_selected);
        } else {
            aj.s(this.hGM, d.f.corner_bg_radio_unselected);
        }
        aj.r(this.hGN, d.C0108d.cp_cont_g);
        this.hGL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hGP) {
                    c.this.hGP = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    aj.s(c.this.hGM, d.f.corner_bg_radio_unselected);
                    c.this.hGM.invalidate();
                    return;
                }
                c.this.hGP = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                aj.s(c.this.hGM, d.f.corner_bg_radio_selected);
                c.this.hGM.invalidate();
            }
        });
    }

    public void bGs() {
        if (this.hGO != null) {
            this.hGO.setVisibility(0);
        }
    }

    public void ux(String str) {
        int i;
        int i2 = 0;
        Bitmap sd = sd(str);
        if (sd != null && sd.getHeight() != 0) {
            if (sd.getHeight() <= 0) {
                i = 0;
            } else if (sd.getWidth() / sd.getHeight() > l.ao(this.hGB) / l.s(this.hGB, d.e.ds440)) {
                i = l.ao(this.hGB);
                if (sd.getWidth() > 0) {
                    i2 = (int) ((i / sd.getWidth()) * sd.getHeight());
                }
            } else {
                int s = l.s(this.hGB, d.e.ds440);
                if (sd.getWidth() > 0) {
                    i = (int) ((s / sd.getHeight()) * sd.getWidth());
                    i2 = s;
                } else {
                    i = 0;
                    i2 = s;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hrX.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hrX.setLayoutParams(layoutParams);
            this.hrX.setImageBitmap(sd);
        }
    }

    private Bitmap sd(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            System.gc();
            try {
                return BitmapFactory.decodeFile(str);
            } catch (OutOfMemoryError e2) {
                return null;
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.hGB.getLayoutMode().aN(i == 1);
        this.hGB.getLayoutMode().aM(this.ciR);
        this.mNavigationBar.onChangeSkinType(this.hGB.getPageContext(), i);
        aj.c(this.fja, d.f.icon_return_bg_s);
        aj.e(this.hGC, d.C0108d.cp_link_tip_a, 1);
        aj.s(this.hGF, d.f.corner_bg);
        aj.r(this.hGO, d.C0108d.cp_cont_e);
        this.hGP = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hGP) {
            aj.s(this.hGM, d.f.corner_bg_radio_selected);
        } else {
            aj.s(this.hGM, d.f.corner_bg_radio_unselected);
        }
        if (this.hGF != null) {
            this.hGF.onChangeSkinType(i);
        }
        if (this.hGE != null) {
            this.hGE.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hGD.getText() == null) {
            return null;
        }
        return this.hGD.getText().toString();
    }

    public long bGt() {
        if (this.hGD.getText() == null || this.hGD.getText().toString() == null) {
            return 0L;
        }
        return this.hGD.getText().length();
    }

    public WriteLocationView bGu() {
        return this.hGF;
    }

    public View bGv() {
        return this.hGC;
    }

    public View getBackButton() {
        return this.fja;
    }

    public EditText bGw() {
        return this.hGD;
    }

    public StateSwitchView bGx() {
        return this.hGE;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                ux(thumbPath);
                this.hrX.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.7
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.hrX.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hrX.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.hrU.setVideoPath(videoPath);
                this.hrU.start();
            }
        }
        if (!v.E(list)) {
            this.hGK.dM(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hGD.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hGK.dM(arrayList);
            this.hGD.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bBK() {
        if (this.hrU != null) {
            this.hrU.resume();
            this.hrU.seekTo(this.hse);
            this.hrU.start();
        }
    }

    public void avB() {
        this.hse = this.hrU.getCurrentPosition();
        if (this.hrU != null) {
            this.hrU.stopPlayback();
        }
    }

    public void uy(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hGB.getResources().getString(d.j.post_to_home_page));
            bGy();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hGB.getResources().getString(d.j.post_to) + str);
        bGz();
    }

    private void bGy() {
        this.hGE = new StateSwitchView(this.hGB);
        this.hGE.ck(this.hGB.getString(d.j.public_to_all), this.hGB.getString(d.j.public_to_me));
        this.hGE.setBackgroundId(d.f.state_switch_bg);
        this.hGE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hGE.bGb();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.s(this.hGB, d.e.ds34), l.s(this.hGB, d.e.ds16));
        this.ciR.addView(this.hGE, layoutParams);
    }

    private void bGz() {
        this.hGE = new StateSwitchView(this.hGB);
        this.hGE.ck(this.hGB.getString(d.j.display_to_home_page), this.hGB.getString(d.j.display_to_home_page));
        this.hGE.cX(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.hGE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hGE.bGb();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.s(this.hGB, d.e.ds34), l.s(this.hGB, d.e.ds16));
        this.hGE.setTextSize(0, this.hGB.getResources().getDimensionPixelSize(d.e.ds28));
        this.ciR.addView(this.hGE, layoutParams);
    }

    public void bGA() {
        this.hGH.av(null);
        this.hGH.nt(false);
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hGH.av(postWriteCallBackData.getSensitiveWords());
            this.hGH.uh(postWriteCallBackData.getErrorString());
            if (!v.E(this.hGH.bEO())) {
                nC(true);
            }
        }
    }

    public void nC(boolean z) {
        if (this.hGD.getText() != null) {
            int selectionEnd = this.hGD.getSelectionEnd();
            SpannableStringBuilder b = this.hGH.b(this.hGD.getText());
            if (b != null) {
                this.hGH.nu(true);
                this.hGD.setText(b);
                if (z && this.hGH.bEP() >= 0) {
                    this.hGD.requestFocus();
                    this.hGD.setSelection(this.hGH.bEP());
                } else {
                    this.hGD.setSelection(selectionEnd);
                }
                this.hGH.nt(this.hGH.bEP() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bGB() {
        return this.hGH;
    }

    public void nD(boolean z) {
        if (z) {
            this.hGI.setVisibility(8);
            this.hGG.setVisibility(0);
            this.dzR.smoothScrollTo(0, this.hGG.getBottom());
        }
    }
}
