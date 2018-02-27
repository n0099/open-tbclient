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
    public static int hHJ = 31;
    private RelativeLayout clV;
    private ScrollView dCy;
    private ImageView fmp;
    private WriteVideoActivity hHK;
    private TextView hHL;
    private EditText hHM;
    private StateSwitchView hHN;
    private WriteLocationView hHO;
    private TextView hHP;
    private com.baidu.tieba.write.b hHQ;
    private LinearLayout hHR;
    private ListView hHS;
    private b hHT;
    private LinearLayout hHU;
    private TextView hHV;
    private TextView hHW;
    private TextView hHX;
    private boolean hHY = true;
    private CustomVideoView hsX;
    private ImageView hta;
    private int hth;
    private NavigationBar mNavigationBar;

    public c(WriteVideoActivity writeVideoActivity) {
        this.hHK = writeVideoActivity;
        this.hHK.setContentView(d.h.write_video_activity);
        this.hHQ = new com.baidu.tieba.write.b();
        this.hHQ.xg(d.C0141d.cp_cont_i);
        this.hHQ.xh(d.C0141d.cp_cont_h_alpha85);
        bHe();
        initView();
    }

    private void bHe() {
        this.clV = (RelativeLayout) this.hHK.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hHK.findViewById(d.g.navigation_bar);
        this.hHM = (EditText) this.hHK.findViewById(d.g.edit_content);
        this.hHP = (TextView) this.hHK.findViewById(d.g.text_content_size);
        this.hta = (ImageView) this.hHK.findViewById(d.g.video_cover);
        this.hHO = (WriteLocationView) this.hHK.findViewById(d.g.location);
        this.hsX = (CustomVideoView) this.hHK.findViewById(d.g.preview_videoview);
        this.dCy = (ScrollView) this.hHK.findViewById(d.g.write_scrollview);
        this.hsX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.c.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (c.this.hsX.getWidth() != c.this.hta.getWidth() || c.this.hsX.getHeight() != c.this.hta.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = c.this.hta.getLayoutParams();
                    layoutParams.width = c.this.hsX.getWidth();
                    layoutParams.height = c.this.hsX.getHeight();
                    c.this.hta.setLayoutParams(layoutParams);
                }
                c.this.hta.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.hsX.start();
                        c.this.hta.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.hsX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.c.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                c.this.cO(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hHR = (LinearLayout) this.hHK.findViewById(d.g.video_activity_title_container);
        this.hHS = (ListView) this.hHK.findViewById(d.g.video_activity_title_list);
        this.hHS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.hHR.setVisibility(8);
                c.this.hHP.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    c.this.hHM.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    c.this.hHM.requestFocus();
                    if (!TextUtils.isEmpty(c.this.hHM.getText())) {
                        c.this.hHM.setSelection(c.this.hHM.getText().length());
                    }
                    l.b(c.this.hHK, c.this.hHM);
                }
            }
        });
        this.hHU = (LinearLayout) this.hHK.findViewById(d.g.save_video_wrapper);
        this.hHV = (TextView) this.hHK.findViewById(d.g.save_video_ridiobutton);
        this.hHW = (TextView) this.hHK.findViewById(d.g.save_video_ridiotext);
        this.hHX = (TextView) this.hHK.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cO(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ao(this.hHK) / l.t(this.hHK, d.e.ds440)) {
            i3 = l.ao(this.hHK);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int t = l.t(this.hHK, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((t / i2) * i);
                i4 = t;
            } else {
                i3 = 0;
                i4 = t;
            }
        }
        this.hsX.setVideoHeight(i4);
        this.hsX.setVideoWidth(i3);
        this.hsX.invalidate();
    }

    private void initView() {
        this.fmp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.hHK);
        this.mNavigationBar.setCenterTextTitle(this.hHK.getPageContext().getString(d.j.post_video_title));
        this.hHL = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.hHK);
        this.hHL.setText(d.j.send_post);
        this.hHM.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.c.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hHM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.c.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && c.this.hHT != null && c.this.hHT.getCount() > 0) {
                    l.a(c.this.hHK, c.this.hHM);
                    c.this.hHR.setVisibility(0);
                    c.this.hHP.setVisibility(8);
                }
                long bHg = c.hHJ - c.this.bHg();
                if (bHg >= 0) {
                    aj.r(c.this.hHP, d.C0141d.cp_cont_e);
                    c.this.hHP.setText(String.valueOf(bHg));
                    return;
                }
                c.this.hHP.setText("0");
                c.this.hHM.setText(c.this.hHM.getText().toString().substring(0, c.hHJ));
                c.this.hHM.setSelection(c.this.hHM.getText().length());
                c.this.hHK.showToast(c.this.hHK.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (c.this.hHQ != null) {
                    if (!c.this.hHQ.bFE()) {
                        c.this.nJ(false);
                    }
                    c.this.hHQ.nB(false);
                }
            }
        });
        this.hHT = new b();
        this.hHS.setAdapter((ListAdapter) this.hHT);
        this.hHY = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hHY) {
            aj.s(this.hHV, d.f.corner_bg_radio_selected);
        } else {
            aj.s(this.hHV, d.f.corner_bg_radio_unselected);
        }
        aj.r(this.hHW, d.C0141d.cp_cont_g);
        this.hHU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hHY) {
                    c.this.hHY = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    aj.s(c.this.hHV, d.f.corner_bg_radio_unselected);
                    c.this.hHV.invalidate();
                    return;
                }
                c.this.hHY = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                aj.s(c.this.hHV, d.f.corner_bg_radio_selected);
                c.this.hHV.invalidate();
            }
        });
    }

    public void bHf() {
        if (this.hHX != null) {
            this.hHX.setVisibility(0);
        }
    }

    public void uB(String str) {
        int i;
        int i2 = 0;
        Bitmap sk = sk(str);
        if (sk != null && sk.getHeight() != 0) {
            if (sk.getHeight() <= 0) {
                i = 0;
            } else if (sk.getWidth() / sk.getHeight() > l.ao(this.hHK) / l.t(this.hHK, d.e.ds440)) {
                i = l.ao(this.hHK);
                if (sk.getWidth() > 0) {
                    i2 = (int) ((i / sk.getWidth()) * sk.getHeight());
                }
            } else {
                int t = l.t(this.hHK, d.e.ds440);
                if (sk.getWidth() > 0) {
                    i = (int) ((t / sk.getHeight()) * sk.getWidth());
                    i2 = t;
                } else {
                    i = 0;
                    i2 = t;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hta.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hta.setLayoutParams(layoutParams);
            this.hta.setImageBitmap(sk);
        }
    }

    private Bitmap sk(String str) {
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
        this.hHK.getLayoutMode().aQ(i == 1);
        this.hHK.getLayoutMode().aM(this.clV);
        this.mNavigationBar.onChangeSkinType(this.hHK.getPageContext(), i);
        aj.c(this.fmp, d.f.icon_return_bg_s);
        aj.e(this.hHL, d.C0141d.cp_link_tip_a, 1);
        aj.s(this.hHO, d.f.corner_bg);
        aj.r(this.hHX, d.C0141d.cp_cont_e);
        this.hHY = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hHY) {
            aj.s(this.hHV, d.f.corner_bg_radio_selected);
        } else {
            aj.s(this.hHV, d.f.corner_bg_radio_unselected);
        }
        if (this.hHO != null) {
            this.hHO.onChangeSkinType(i);
        }
        if (this.hHN != null) {
            this.hHN.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hHM.getText() == null) {
            return null;
        }
        return this.hHM.getText().toString();
    }

    public long bHg() {
        if (this.hHM.getText() == null || this.hHM.getText().toString() == null) {
            return 0L;
        }
        return this.hHM.getText().length();
    }

    public WriteLocationView bHh() {
        return this.hHO;
    }

    public View bHi() {
        return this.hHL;
    }

    public View getBackButton() {
        return this.fmp;
    }

    public EditText bHj() {
        return this.hHM;
    }

    public StateSwitchView bHk() {
        return this.hHN;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                uB(thumbPath);
                this.hta.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.7
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.hta.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hta.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.hsX.setVideoPath(videoPath);
                this.hsX.start();
            }
        }
        if (!v.E(list)) {
            this.hHT.dS(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hHM.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hHT.dS(arrayList);
            this.hHM.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bCs() {
        if (this.hsX != null) {
            this.hsX.resume();
            this.hsX.seekTo(this.hth);
            this.hsX.start();
        }
    }

    public void awx() {
        this.hth = this.hsX.getCurrentPosition();
        if (this.hsX != null) {
            this.hsX.stopPlayback();
        }
    }

    public void uC(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hHK.getResources().getString(d.j.post_to_home_page));
            bHl();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hHK.getResources().getString(d.j.post_to) + str);
        bHm();
    }

    private void bHl() {
        this.hHN = new StateSwitchView(this.hHK);
        this.hHN.cm(this.hHK.getString(d.j.public_to_all), this.hHK.getString(d.j.public_to_me));
        this.hHN.setBackgroundId(d.f.state_switch_bg);
        this.hHN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hHN.bGO();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.t(this.hHK, d.e.ds34), l.t(this.hHK, d.e.ds16));
        this.clV.addView(this.hHN, layoutParams);
    }

    private void bHm() {
        this.hHN = new StateSwitchView(this.hHK);
        this.hHN.cm(this.hHK.getString(d.j.display_to_home_page), this.hHK.getString(d.j.display_to_home_page));
        this.hHN.cS(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.hHN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hHN.bGO();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.t(this.hHK, d.e.ds34), l.t(this.hHK, d.e.ds16));
        this.hHN.setTextSize(0, this.hHK.getResources().getDimensionPixelSize(d.e.ds28));
        this.clV.addView(this.hHN, layoutParams);
    }

    public void bHn() {
        this.hHQ.aw(null);
        this.hHQ.nA(false);
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hHQ.aw(postWriteCallBackData.getSensitiveWords());
            this.hHQ.un(postWriteCallBackData.getErrorString());
            if (!v.E(this.hHQ.bFB())) {
                nJ(true);
            }
        }
    }

    public void nJ(boolean z) {
        if (this.hHM.getText() != null) {
            int selectionEnd = this.hHM.getSelectionEnd();
            SpannableStringBuilder b = this.hHQ.b(this.hHM.getText());
            if (b != null) {
                this.hHQ.nB(true);
                this.hHM.setText(b);
                if (z && this.hHQ.bFC() >= 0) {
                    this.hHM.requestFocus();
                    this.hHM.setSelection(this.hHQ.bFC());
                } else {
                    this.hHM.setSelection(selectionEnd);
                }
                this.hHQ.nA(this.hHQ.bFC() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bHo() {
        return this.hHQ;
    }

    public void nK(boolean z) {
        if (z) {
            this.hHR.setVisibility(8);
            this.hHP.setVisibility(0);
            this.dCy.smoothScrollTo(0, this.hHP.getBottom());
        }
    }
}
