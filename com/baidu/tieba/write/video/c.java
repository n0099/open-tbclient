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
    public static int hQy = 31;
    private RelativeLayout ciC;
    private ScrollView duV;
    private ImageView fhe;
    private CustomVideoView hBX;
    private ImageView hCa;
    private int hCh;
    private TextView hQA;
    private EditText hQB;
    private StateSwitchView hQC;
    private WriteLocationView hQD;
    private TextView hQE;
    private com.baidu.tieba.write.b hQF;
    private LinearLayout hQG;
    private ListView hQH;
    private b hQI;
    private LinearLayout hQJ;
    private TextView hQK;
    private TextView hQL;
    private TextView hQM;
    private boolean hQN = true;
    private WriteVideoActivity hQz;
    private NavigationBar mNavigationBar;

    public c(WriteVideoActivity writeVideoActivity) {
        this.hQz = writeVideoActivity;
        this.hQz.setContentView(d.h.write_video_activity);
        this.hQF = new com.baidu.tieba.write.b();
        this.hQF.yD(d.C0108d.cp_cont_i);
        this.hQF.yE(d.C0108d.cp_cont_h_alpha85);
        bMP();
        initView();
    }

    private void bMP() {
        this.ciC = (RelativeLayout) this.hQz.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hQz.findViewById(d.g.navigation_bar);
        this.hQB = (EditText) this.hQz.findViewById(d.g.edit_content);
        this.hQE = (TextView) this.hQz.findViewById(d.g.text_content_size);
        this.hCa = (ImageView) this.hQz.findViewById(d.g.video_cover);
        this.hQD = (WriteLocationView) this.hQz.findViewById(d.g.location);
        this.hBX = (CustomVideoView) this.hQz.findViewById(d.g.preview_videoview);
        this.duV = (ScrollView) this.hQz.findViewById(d.g.write_scrollview);
        this.hBX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.c.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (c.this.hBX.getWidth() != c.this.hCa.getWidth() || c.this.hBX.getHeight() != c.this.hCa.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = c.this.hCa.getLayoutParams();
                    layoutParams.width = c.this.hBX.getWidth();
                    layoutParams.height = c.this.hBX.getHeight();
                    c.this.hCa.setLayoutParams(layoutParams);
                }
                c.this.hCa.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.hBX.start();
                        c.this.hCa.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.hBX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.c.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                c.this.da(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hQG = (LinearLayout) this.hQz.findViewById(d.g.video_activity_title_container);
        this.hQH = (ListView) this.hQz.findViewById(d.g.video_activity_title_list);
        this.hQH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.hQG.setVisibility(8);
                c.this.hQE.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    c.this.hQB.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    c.this.hQB.requestFocus();
                    if (!TextUtils.isEmpty(c.this.hQB.getText())) {
                        c.this.hQB.setSelection(c.this.hQB.getText().length());
                    }
                    l.b(c.this.hQz, c.this.hQB);
                }
            }
        });
        this.hQJ = (LinearLayout) this.hQz.findViewById(d.g.save_video_wrapper);
        this.hQK = (TextView) this.hQz.findViewById(d.g.save_video_ridiobutton);
        this.hQL = (TextView) this.hQz.findViewById(d.g.save_video_ridiotext);
        this.hQM = (TextView) this.hQz.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ao(this.hQz) / l.s(this.hQz, d.e.ds440)) {
            i3 = l.ao(this.hQz);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int s = l.s(this.hQz, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((s / i2) * i);
                i4 = s;
            } else {
                i3 = 0;
                i4 = s;
            }
        }
        this.hBX.setVideoHeight(i4);
        this.hBX.setVideoWidth(i3);
        this.hBX.invalidate();
    }

    private void initView() {
        this.fhe = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.hQz);
        this.mNavigationBar.setCenterTextTitle(this.hQz.getPageContext().getString(d.j.post_video_title));
        this.hQA = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.hQz);
        this.hQA.setText(d.j.send_post);
        this.hQB.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.c.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hQB.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.c.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && c.this.hQI != null && c.this.hQI.getCount() > 0) {
                    l.a(c.this.hQz, c.this.hQB);
                    c.this.hQG.setVisibility(0);
                    c.this.hQE.setVisibility(8);
                }
                long bMR = c.hQy - c.this.bMR();
                if (bMR >= 0) {
                    aj.r(c.this.hQE, d.C0108d.cp_cont_e);
                    c.this.hQE.setText(String.valueOf(bMR));
                    return;
                }
                c.this.hQE.setText("0");
                c.this.hQB.setText(c.this.hQB.getText().toString().substring(0, c.hQy));
                c.this.hQB.setSelection(c.this.hQB.getText().length());
                c.this.hQz.showToast(c.this.hQz.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (c.this.hQF != null) {
                    if (!c.this.hQF.bLp()) {
                        c.this.ow(false);
                    }
                    c.this.hQF.oo(false);
                }
            }
        });
        this.hQI = new b();
        this.hQH.setAdapter((ListAdapter) this.hQI);
        this.hQN = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hQN) {
            aj.s(this.hQK, d.f.corner_bg_radio_selected);
        } else {
            aj.s(this.hQK, d.f.corner_bg_radio_unselected);
        }
        aj.r(this.hQL, d.C0108d.cp_cont_g);
        this.hQJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hQN) {
                    c.this.hQN = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    aj.s(c.this.hQK, d.f.corner_bg_radio_unselected);
                    c.this.hQK.invalidate();
                    return;
                }
                c.this.hQN = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                aj.s(c.this.hQK, d.f.corner_bg_radio_selected);
                c.this.hQK.invalidate();
            }
        });
    }

    public void bMQ() {
        if (this.hQM != null) {
            this.hQM.setVisibility(0);
        }
    }

    public void uU(String str) {
        int i;
        int i2 = 0;
        Bitmap sC = sC(str);
        if (sC != null && sC.getHeight() != 0) {
            if (sC.getHeight() <= 0) {
                i = 0;
            } else if (sC.getWidth() / sC.getHeight() > l.ao(this.hQz) / l.s(this.hQz, d.e.ds440)) {
                i = l.ao(this.hQz);
                if (sC.getWidth() > 0) {
                    i2 = (int) ((i / sC.getWidth()) * sC.getHeight());
                }
            } else {
                int s = l.s(this.hQz, d.e.ds440);
                if (sC.getWidth() > 0) {
                    i = (int) ((s / sC.getHeight()) * sC.getWidth());
                    i2 = s;
                } else {
                    i = 0;
                    i2 = s;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hCa.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hCa.setLayoutParams(layoutParams);
            this.hCa.setImageBitmap(sC);
        }
    }

    private Bitmap sC(String str) {
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
        this.hQz.getLayoutMode().aM(i == 1);
        this.hQz.getLayoutMode().aM(this.ciC);
        this.mNavigationBar.onChangeSkinType(this.hQz.getPageContext(), i);
        aj.c(this.fhe, d.f.icon_return_bg_s);
        aj.e(this.hQA, d.C0108d.cp_link_tip_a, 1);
        aj.s(this.hQD, d.f.corner_bg);
        aj.r(this.hQM, d.C0108d.cp_cont_e);
        this.hQN = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hQN) {
            aj.s(this.hQK, d.f.corner_bg_radio_selected);
        } else {
            aj.s(this.hQK, d.f.corner_bg_radio_unselected);
        }
        if (this.hQD != null) {
            this.hQD.onChangeSkinType(i);
        }
        if (this.hQC != null) {
            this.hQC.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hQB.getText() == null) {
            return null;
        }
        return this.hQB.getText().toString();
    }

    public long bMR() {
        if (this.hQB.getText() == null || this.hQB.getText().toString() == null) {
            return 0L;
        }
        return this.hQB.getText().length();
    }

    public WriteLocationView bMS() {
        return this.hQD;
    }

    public View bMT() {
        return this.hQA;
    }

    public View getBackButton() {
        return this.fhe;
    }

    public EditText bMU() {
        return this.hQB;
    }

    public StateSwitchView bMV() {
        return this.hQC;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                uU(thumbPath);
                this.hCa.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.7
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.hCa.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hCa.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.hBX.setVideoPath(videoPath);
                this.hBX.start();
            }
        }
        if (!v.G(list)) {
            this.hQI.ed(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hQB.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hQI.ed(arrayList);
            this.hQB.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bIl() {
        if (this.hBX != null) {
            this.hBX.resume();
            this.hBX.seekTo(this.hCh);
            this.hBX.start();
        }
    }

    public void aut() {
        this.hCh = this.hBX.getCurrentPosition();
        if (this.hBX != null) {
            this.hBX.stopPlayback();
        }
    }

    public void uV(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hQz.getResources().getString(d.j.post_to_home_page));
            bMW();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hQz.getResources().getString(d.j.post_to) + str);
        bMX();
    }

    private void bMW() {
        this.hQC = new StateSwitchView(this.hQz);
        this.hQC.cr(this.hQz.getString(d.j.public_to_all), this.hQz.getString(d.j.public_to_me));
        this.hQC.setBackgroundId(d.f.state_switch_bg);
        this.hQC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hQC.bMz();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.s(this.hQz, d.e.ds34), l.s(this.hQz, d.e.ds16));
        this.ciC.addView(this.hQC, layoutParams);
    }

    private void bMX() {
        this.hQC = new StateSwitchView(this.hQz);
        this.hQC.cr(this.hQz.getString(d.j.display_to_home_page), this.hQz.getString(d.j.display_to_home_page));
        this.hQC.de(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.hQC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hQC.bMz();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.s(this.hQz, d.e.ds34), l.s(this.hQz, d.e.ds16));
        this.hQC.setTextSize(0, this.hQz.getResources().getDimensionPixelSize(d.e.ds28));
        this.ciC.addView(this.hQC, layoutParams);
    }

    public void bMY() {
        this.hQF.aB(null);
        this.hQF.on(false);
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hQF.aB(postWriteCallBackData.getSensitiveWords());
            this.hQF.uE(postWriteCallBackData.getErrorString());
            if (!v.G(this.hQF.bLm())) {
                ow(true);
            }
        }
    }

    public void ow(boolean z) {
        if (this.hQB.getText() != null) {
            int selectionEnd = this.hQB.getSelectionEnd();
            SpannableStringBuilder b = this.hQF.b(this.hQB.getText());
            if (b != null) {
                this.hQF.oo(true);
                this.hQB.setText(b);
                if (z && this.hQF.bLn() >= 0) {
                    this.hQB.requestFocus();
                    this.hQB.setSelection(this.hQF.bLn());
                } else {
                    this.hQB.setSelection(selectionEnd);
                }
                this.hQF.on(this.hQF.bLn() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bMZ() {
        return this.hQF;
    }

    public void ox(boolean z) {
        if (z) {
            this.hQG.setVisibility(8);
            this.hQE.setVisibility(0);
            this.duV.smoothScrollTo(0, this.hQE.getBottom());
        }
    }
}
