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
    public static int hIh = 31;
    private RelativeLayout clY;
    private ScrollView dCB;
    private ImageView fmF;
    private WriteVideoActivity hIi;
    private TextView hIj;
    private EditText hIk;
    private StateSwitchView hIl;
    private WriteLocationView hIm;
    private TextView hIn;
    private com.baidu.tieba.write.b hIo;
    private LinearLayout hIp;
    private ListView hIq;
    private b hIr;
    private LinearLayout hIs;
    private TextView hIt;
    private TextView hIu;
    private TextView hIv;
    private boolean hIw = true;
    private int htF;
    private CustomVideoView htv;
    private ImageView hty;
    private NavigationBar mNavigationBar;

    public c(WriteVideoActivity writeVideoActivity) {
        this.hIi = writeVideoActivity;
        this.hIi.setContentView(d.h.write_video_activity);
        this.hIo = new com.baidu.tieba.write.b();
        this.hIo.xg(d.C0141d.cp_cont_i);
        this.hIo.xh(d.C0141d.cp_cont_h_alpha85);
        bHj();
        initView();
    }

    private void bHj() {
        this.clY = (RelativeLayout) this.hIi.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hIi.findViewById(d.g.navigation_bar);
        this.hIk = (EditText) this.hIi.findViewById(d.g.edit_content);
        this.hIn = (TextView) this.hIi.findViewById(d.g.text_content_size);
        this.hty = (ImageView) this.hIi.findViewById(d.g.video_cover);
        this.hIm = (WriteLocationView) this.hIi.findViewById(d.g.location);
        this.htv = (CustomVideoView) this.hIi.findViewById(d.g.preview_videoview);
        this.dCB = (ScrollView) this.hIi.findViewById(d.g.write_scrollview);
        this.htv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.c.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (c.this.htv.getWidth() != c.this.hty.getWidth() || c.this.htv.getHeight() != c.this.hty.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = c.this.hty.getLayoutParams();
                    layoutParams.width = c.this.htv.getWidth();
                    layoutParams.height = c.this.htv.getHeight();
                    c.this.hty.setLayoutParams(layoutParams);
                }
                c.this.hty.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.htv.start();
                        c.this.hty.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.htv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.c.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                c.this.cO(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hIp = (LinearLayout) this.hIi.findViewById(d.g.video_activity_title_container);
        this.hIq = (ListView) this.hIi.findViewById(d.g.video_activity_title_list);
        this.hIq.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.hIp.setVisibility(8);
                c.this.hIn.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    c.this.hIk.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    c.this.hIk.requestFocus();
                    if (!TextUtils.isEmpty(c.this.hIk.getText())) {
                        c.this.hIk.setSelection(c.this.hIk.getText().length());
                    }
                    l.b(c.this.hIi, c.this.hIk);
                }
            }
        });
        this.hIs = (LinearLayout) this.hIi.findViewById(d.g.save_video_wrapper);
        this.hIt = (TextView) this.hIi.findViewById(d.g.save_video_ridiobutton);
        this.hIu = (TextView) this.hIi.findViewById(d.g.save_video_ridiotext);
        this.hIv = (TextView) this.hIi.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cO(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ao(this.hIi) / l.t(this.hIi, d.e.ds440)) {
            i3 = l.ao(this.hIi);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int t = l.t(this.hIi, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((t / i2) * i);
                i4 = t;
            } else {
                i3 = 0;
                i4 = t;
            }
        }
        this.htv.setVideoHeight(i4);
        this.htv.setVideoWidth(i3);
        this.htv.invalidate();
    }

    private void initView() {
        this.fmF = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.hIi);
        this.mNavigationBar.setCenterTextTitle(this.hIi.getPageContext().getString(d.j.post_video_title));
        this.hIj = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.hIi);
        this.hIj.setText(d.j.send_post);
        this.hIk.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.c.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hIk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.c.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && c.this.hIr != null && c.this.hIr.getCount() > 0) {
                    l.a(c.this.hIi, c.this.hIk);
                    c.this.hIp.setVisibility(0);
                    c.this.hIn.setVisibility(8);
                }
                long bHl = c.hIh - c.this.bHl();
                if (bHl >= 0) {
                    aj.r(c.this.hIn, d.C0141d.cp_cont_e);
                    c.this.hIn.setText(String.valueOf(bHl));
                    return;
                }
                c.this.hIn.setText("0");
                c.this.hIk.setText(c.this.hIk.getText().toString().substring(0, c.hIh));
                c.this.hIk.setSelection(c.this.hIk.getText().length());
                c.this.hIi.showToast(c.this.hIi.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (c.this.hIo != null) {
                    if (!c.this.hIo.bFJ()) {
                        c.this.nO(false);
                    }
                    c.this.hIo.nG(false);
                }
            }
        });
        this.hIr = new b();
        this.hIq.setAdapter((ListAdapter) this.hIr);
        this.hIw = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hIw) {
            aj.s(this.hIt, d.f.corner_bg_radio_selected);
        } else {
            aj.s(this.hIt, d.f.corner_bg_radio_unselected);
        }
        aj.r(this.hIu, d.C0141d.cp_cont_g);
        this.hIs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hIw) {
                    c.this.hIw = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    aj.s(c.this.hIt, d.f.corner_bg_radio_unselected);
                    c.this.hIt.invalidate();
                    return;
                }
                c.this.hIw = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                aj.s(c.this.hIt, d.f.corner_bg_radio_selected);
                c.this.hIt.invalidate();
            }
        });
    }

    public void bHk() {
        if (this.hIv != null) {
            this.hIv.setVisibility(0);
        }
    }

    public void uB(String str) {
        int i;
        int i2 = 0;
        Bitmap sk = sk(str);
        if (sk != null && sk.getHeight() != 0) {
            if (sk.getHeight() <= 0) {
                i = 0;
            } else if (sk.getWidth() / sk.getHeight() > l.ao(this.hIi) / l.t(this.hIi, d.e.ds440)) {
                i = l.ao(this.hIi);
                if (sk.getWidth() > 0) {
                    i2 = (int) ((i / sk.getWidth()) * sk.getHeight());
                }
            } else {
                int t = l.t(this.hIi, d.e.ds440);
                if (sk.getWidth() > 0) {
                    i = (int) ((t / sk.getHeight()) * sk.getWidth());
                    i2 = t;
                } else {
                    i = 0;
                    i2 = t;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hty.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hty.setLayoutParams(layoutParams);
            this.hty.setImageBitmap(sk);
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
        this.hIi.getLayoutMode().aQ(i == 1);
        this.hIi.getLayoutMode().aM(this.clY);
        this.mNavigationBar.onChangeSkinType(this.hIi.getPageContext(), i);
        aj.c(this.fmF, d.f.icon_return_bg_s);
        aj.e(this.hIj, d.C0141d.cp_link_tip_a, 1);
        aj.s(this.hIm, d.f.corner_bg);
        aj.r(this.hIv, d.C0141d.cp_cont_e);
        this.hIw = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hIw) {
            aj.s(this.hIt, d.f.corner_bg_radio_selected);
        } else {
            aj.s(this.hIt, d.f.corner_bg_radio_unselected);
        }
        if (this.hIm != null) {
            this.hIm.onChangeSkinType(i);
        }
        if (this.hIl != null) {
            this.hIl.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hIk.getText() == null) {
            return null;
        }
        return this.hIk.getText().toString();
    }

    public long bHl() {
        if (this.hIk.getText() == null || this.hIk.getText().toString() == null) {
            return 0L;
        }
        return this.hIk.getText().length();
    }

    public WriteLocationView bHm() {
        return this.hIm;
    }

    public View bHn() {
        return this.hIj;
    }

    public View getBackButton() {
        return this.fmF;
    }

    public EditText bHo() {
        return this.hIk;
    }

    public StateSwitchView bHp() {
        return this.hIl;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                uB(thumbPath);
                this.hty.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.7
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.hty.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hty.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.htv.setVideoPath(videoPath);
                this.htv.start();
            }
        }
        if (!v.E(list)) {
            this.hIr.dS(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hIk.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hIr.dS(arrayList);
            this.hIk.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bCx() {
        if (this.htv != null) {
            this.htv.resume();
            this.htv.seekTo(this.htF);
            this.htv.start();
        }
    }

    public void awz() {
        this.htF = this.htv.getCurrentPosition();
        if (this.htv != null) {
            this.htv.stopPlayback();
        }
    }

    public void uC(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hIi.getResources().getString(d.j.post_to_home_page));
            bHq();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hIi.getResources().getString(d.j.post_to) + str);
        bHr();
    }

    private void bHq() {
        this.hIl = new StateSwitchView(this.hIi);
        this.hIl.cm(this.hIi.getString(d.j.public_to_all), this.hIi.getString(d.j.public_to_me));
        this.hIl.setBackgroundId(d.f.state_switch_bg);
        this.hIl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hIl.bGT();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.t(this.hIi, d.e.ds34), l.t(this.hIi, d.e.ds16));
        this.clY.addView(this.hIl, layoutParams);
    }

    private void bHr() {
        this.hIl = new StateSwitchView(this.hIi);
        this.hIl.cm(this.hIi.getString(d.j.display_to_home_page), this.hIi.getString(d.j.display_to_home_page));
        this.hIl.cS(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.hIl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hIl.bGT();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.t(this.hIi, d.e.ds34), l.t(this.hIi, d.e.ds16));
        this.hIl.setTextSize(0, this.hIi.getResources().getDimensionPixelSize(d.e.ds28));
        this.clY.addView(this.hIl, layoutParams);
    }

    public void bHs() {
        this.hIo.aw(null);
        this.hIo.nF(false);
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hIo.aw(postWriteCallBackData.getSensitiveWords());
            this.hIo.un(postWriteCallBackData.getErrorString());
            if (!v.E(this.hIo.bFG())) {
                nO(true);
            }
        }
    }

    public void nO(boolean z) {
        if (this.hIk.getText() != null) {
            int selectionEnd = this.hIk.getSelectionEnd();
            SpannableStringBuilder b = this.hIo.b(this.hIk.getText());
            if (b != null) {
                this.hIo.nG(true);
                this.hIk.setText(b);
                if (z && this.hIo.bFH() >= 0) {
                    this.hIk.requestFocus();
                    this.hIk.setSelection(this.hIo.bFH());
                } else {
                    this.hIk.setSelection(selectionEnd);
                }
                this.hIo.nF(this.hIo.bFH() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bHt() {
        return this.hIo;
    }

    public void nP(boolean z) {
        if (z) {
            this.hIp.setVisibility(8);
            this.hIn.setVisibility(0);
            this.dCB.smoothScrollTo(0, this.hIn.getBottom());
        }
    }
}
