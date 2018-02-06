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
    public static int hHW = 31;
    private RelativeLayout cmi;
    private ScrollView dCK;
    private ImageView fmB;
    private WriteVideoActivity hHX;
    private TextView hHY;
    private EditText hHZ;
    private StateSwitchView hIa;
    private WriteLocationView hIb;
    private TextView hIc;
    private com.baidu.tieba.write.b hId;
    private LinearLayout hIe;
    private ListView hIf;
    private b hIg;
    private LinearLayout hIh;
    private TextView hIi;
    private TextView hIj;
    private TextView hIk;
    private boolean hIl = true;
    private CustomVideoView htk;
    private ImageView htn;
    private int htu;
    private NavigationBar mNavigationBar;

    public c(WriteVideoActivity writeVideoActivity) {
        this.hHX = writeVideoActivity;
        this.hHX.setContentView(d.h.write_video_activity);
        this.hId = new com.baidu.tieba.write.b();
        this.hId.xf(d.C0140d.cp_cont_i);
        this.hId.xg(d.C0140d.cp_cont_h_alpha85);
        bHf();
        initView();
    }

    private void bHf() {
        this.cmi = (RelativeLayout) this.hHX.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hHX.findViewById(d.g.navigation_bar);
        this.hHZ = (EditText) this.hHX.findViewById(d.g.edit_content);
        this.hIc = (TextView) this.hHX.findViewById(d.g.text_content_size);
        this.htn = (ImageView) this.hHX.findViewById(d.g.video_cover);
        this.hIb = (WriteLocationView) this.hHX.findViewById(d.g.location);
        this.htk = (CustomVideoView) this.hHX.findViewById(d.g.preview_videoview);
        this.dCK = (ScrollView) this.hHX.findViewById(d.g.write_scrollview);
        this.htk.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.c.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (c.this.htk.getWidth() != c.this.htn.getWidth() || c.this.htk.getHeight() != c.this.htn.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = c.this.htn.getLayoutParams();
                    layoutParams.width = c.this.htk.getWidth();
                    layoutParams.height = c.this.htk.getHeight();
                    c.this.htn.setLayoutParams(layoutParams);
                }
                c.this.htn.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.htk.start();
                        c.this.htn.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.htk.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.c.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                c.this.cO(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hIe = (LinearLayout) this.hHX.findViewById(d.g.video_activity_title_container);
        this.hIf = (ListView) this.hHX.findViewById(d.g.video_activity_title_list);
        this.hIf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.hIe.setVisibility(8);
                c.this.hIc.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    c.this.hHZ.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    c.this.hHZ.requestFocus();
                    if (!TextUtils.isEmpty(c.this.hHZ.getText())) {
                        c.this.hHZ.setSelection(c.this.hHZ.getText().length());
                    }
                    l.b(c.this.hHX, c.this.hHZ);
                }
            }
        });
        this.hIh = (LinearLayout) this.hHX.findViewById(d.g.save_video_wrapper);
        this.hIi = (TextView) this.hHX.findViewById(d.g.save_video_ridiobutton);
        this.hIj = (TextView) this.hHX.findViewById(d.g.save_video_ridiotext);
        this.hIk = (TextView) this.hHX.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cO(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ao(this.hHX) / l.t(this.hHX, d.e.ds440)) {
            i3 = l.ao(this.hHX);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int t = l.t(this.hHX, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((t / i2) * i);
                i4 = t;
            } else {
                i3 = 0;
                i4 = t;
            }
        }
        this.htk.setVideoHeight(i4);
        this.htk.setVideoWidth(i3);
        this.htk.invalidate();
    }

    private void initView() {
        this.fmB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.hHX);
        this.mNavigationBar.setCenterTextTitle(this.hHX.getPageContext().getString(d.j.post_video_title));
        this.hHY = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.hHX);
        this.hHY.setText(d.j.send_post);
        this.hHZ.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.c.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hHZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.c.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && c.this.hIg != null && c.this.hIg.getCount() > 0) {
                    l.a(c.this.hHX, c.this.hHZ);
                    c.this.hIe.setVisibility(0);
                    c.this.hIc.setVisibility(8);
                }
                long bHh = c.hHW - c.this.bHh();
                if (bHh >= 0) {
                    aj.r(c.this.hIc, d.C0140d.cp_cont_e);
                    c.this.hIc.setText(String.valueOf(bHh));
                    return;
                }
                c.this.hIc.setText("0");
                c.this.hHZ.setText(c.this.hHZ.getText().toString().substring(0, c.hHW));
                c.this.hHZ.setSelection(c.this.hHZ.getText().length());
                c.this.hHX.showToast(c.this.hHX.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (c.this.hId != null) {
                    if (!c.this.hId.bFF()) {
                        c.this.nJ(false);
                    }
                    c.this.hId.nB(false);
                }
            }
        });
        this.hIg = new b();
        this.hIf.setAdapter((ListAdapter) this.hIg);
        this.hIl = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hIl) {
            aj.s(this.hIi, d.f.corner_bg_radio_selected);
        } else {
            aj.s(this.hIi, d.f.corner_bg_radio_unselected);
        }
        aj.r(this.hIj, d.C0140d.cp_cont_g);
        this.hIh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hIl) {
                    c.this.hIl = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    aj.s(c.this.hIi, d.f.corner_bg_radio_unselected);
                    c.this.hIi.invalidate();
                    return;
                }
                c.this.hIl = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                aj.s(c.this.hIi, d.f.corner_bg_radio_selected);
                c.this.hIi.invalidate();
            }
        });
    }

    public void bHg() {
        if (this.hIk != null) {
            this.hIk.setVisibility(0);
        }
    }

    public void uB(String str) {
        int i;
        int i2 = 0;
        Bitmap sk = sk(str);
        if (sk != null && sk.getHeight() != 0) {
            if (sk.getHeight() <= 0) {
                i = 0;
            } else if (sk.getWidth() / sk.getHeight() > l.ao(this.hHX) / l.t(this.hHX, d.e.ds440)) {
                i = l.ao(this.hHX);
                if (sk.getWidth() > 0) {
                    i2 = (int) ((i / sk.getWidth()) * sk.getHeight());
                }
            } else {
                int t = l.t(this.hHX, d.e.ds440);
                if (sk.getWidth() > 0) {
                    i = (int) ((t / sk.getHeight()) * sk.getWidth());
                    i2 = t;
                } else {
                    i = 0;
                    i2 = t;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.htn.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.htn.setLayoutParams(layoutParams);
            this.htn.setImageBitmap(sk);
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
        this.hHX.getLayoutMode().aQ(i == 1);
        this.hHX.getLayoutMode().aM(this.cmi);
        this.mNavigationBar.onChangeSkinType(this.hHX.getPageContext(), i);
        aj.c(this.fmB, d.f.icon_return_bg_s);
        aj.e(this.hHY, d.C0140d.cp_link_tip_a, 1);
        aj.s(this.hIb, d.f.corner_bg);
        aj.r(this.hIk, d.C0140d.cp_cont_e);
        this.hIl = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hIl) {
            aj.s(this.hIi, d.f.corner_bg_radio_selected);
        } else {
            aj.s(this.hIi, d.f.corner_bg_radio_unselected);
        }
        if (this.hIb != null) {
            this.hIb.onChangeSkinType(i);
        }
        if (this.hIa != null) {
            this.hIa.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hHZ.getText() == null) {
            return null;
        }
        return this.hHZ.getText().toString();
    }

    public long bHh() {
        if (this.hHZ.getText() == null || this.hHZ.getText().toString() == null) {
            return 0L;
        }
        return this.hHZ.getText().length();
    }

    public WriteLocationView bHi() {
        return this.hIb;
    }

    public View bHj() {
        return this.hHY;
    }

    public View getBackButton() {
        return this.fmB;
    }

    public EditText bHk() {
        return this.hHZ;
    }

    public StateSwitchView bHl() {
        return this.hIa;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                uB(thumbPath);
                this.htn.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.7
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.htn.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.htn.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.htk.setVideoPath(videoPath);
                this.htk.start();
            }
        }
        if (!v.E(list)) {
            this.hIg.dS(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hHZ.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hIg.dS(arrayList);
            this.hHZ.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bCt() {
        if (this.htk != null) {
            this.htk.resume();
            this.htk.seekTo(this.htu);
            this.htk.start();
        }
    }

    public void awy() {
        this.htu = this.htk.getCurrentPosition();
        if (this.htk != null) {
            this.htk.stopPlayback();
        }
    }

    public void uC(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hHX.getResources().getString(d.j.post_to_home_page));
            bHm();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hHX.getResources().getString(d.j.post_to) + str);
        bHn();
    }

    private void bHm() {
        this.hIa = new StateSwitchView(this.hHX);
        this.hIa.cm(this.hHX.getString(d.j.public_to_all), this.hHX.getString(d.j.public_to_me));
        this.hIa.setBackgroundId(d.f.state_switch_bg);
        this.hIa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hIa.bGP();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.t(this.hHX, d.e.ds34), l.t(this.hHX, d.e.ds16));
        this.cmi.addView(this.hIa, layoutParams);
    }

    private void bHn() {
        this.hIa = new StateSwitchView(this.hHX);
        this.hIa.cm(this.hHX.getString(d.j.display_to_home_page), this.hHX.getString(d.j.display_to_home_page));
        this.hIa.cS(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.hIa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hIa.bGP();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.t(this.hHX, d.e.ds34), l.t(this.hHX, d.e.ds16));
        this.hIa.setTextSize(0, this.hHX.getResources().getDimensionPixelSize(d.e.ds28));
        this.cmi.addView(this.hIa, layoutParams);
    }

    public void bHo() {
        this.hId.aw(null);
        this.hId.nA(false);
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hId.aw(postWriteCallBackData.getSensitiveWords());
            this.hId.un(postWriteCallBackData.getErrorString());
            if (!v.E(this.hId.bFC())) {
                nJ(true);
            }
        }
    }

    public void nJ(boolean z) {
        if (this.hHZ.getText() != null) {
            int selectionEnd = this.hHZ.getSelectionEnd();
            SpannableStringBuilder b = this.hId.b(this.hHZ.getText());
            if (b != null) {
                this.hId.nB(true);
                this.hHZ.setText(b);
                if (z && this.hId.bFD() >= 0) {
                    this.hHZ.requestFocus();
                    this.hHZ.setSelection(this.hId.bFD());
                } else {
                    this.hHZ.setSelection(selectionEnd);
                }
                this.hId.nA(this.hId.bFD() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bHp() {
        return this.hId;
    }

    public void nK(boolean z) {
        if (z) {
            this.hIe.setVisibility(8);
            this.hIc.setVisibility(0);
            this.dCK.smoothScrollTo(0, this.hIc.getBottom());
        }
    }
}
