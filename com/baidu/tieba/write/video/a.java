package com.baidu.tieba.write.video;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.video.CustomVideoView;
/* loaded from: classes2.dex */
public class a {
    public static int gJL = 31;
    private static int gJM = -100;
    private View bKr;
    private ImageView egH;
    private WriteVideoActivity gJN;
    private TextView gJO;
    private EditText gJP;
    private TextView gJQ;
    private WriteLocationView gJR;
    private TextView gJS;
    private CustomVideoView gxd;
    private ImageView gxg;
    private int gxn;
    private NavigationBar mNavigationBar;

    public a(WriteVideoActivity writeVideoActivity) {
        this.gJN = writeVideoActivity;
        this.gJN.setContentView(d.j.write_video_activity);
        bAg();
        initView();
    }

    private void bAg() {
        this.bKr = this.gJN.findViewById(d.h.layout_root);
        this.mNavigationBar = (NavigationBar) this.gJN.findViewById(d.h.navigation_bar);
        this.gJP = (EditText) this.gJN.findViewById(d.h.edit_content);
        this.gJS = (TextView) this.gJN.findViewById(d.h.text_content_size);
        this.gJQ = (TextView) this.gJN.findViewById(d.h.select_forum_btn);
        this.gxg = (ImageView) this.gJN.findViewById(d.h.video_cover);
        this.gJR = (WriteLocationView) this.gJN.findViewById(d.h.location);
        this.gxd = (CustomVideoView) this.gJN.findViewById(d.h.preview_videoview);
        this.gJQ.setOnClickListener(this.gJN);
        this.gxd.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.a.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.gxd.getWidth() != a.this.gxg.getWidth() || a.this.gxd.getHeight() != a.this.gxg.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = a.this.gxg.getLayoutParams();
                    layoutParams.width = a.this.gxd.getWidth();
                    layoutParams.height = a.this.gxd.getHeight();
                    a.this.gxg.setLayoutParams(layoutParams);
                }
                a.this.gxg.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gxd.start();
                        a.this.gxg.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.gxd.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.a.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                a.this.ca(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ad(this.gJN) / l.f(this.gJN, d.f.ds440)) {
            i3 = l.ad(this.gJN);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.gJN, d.f.ds440);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.gxd.setVideoHeight(i4);
        this.gxd.setVideoWidth(i3);
        this.gxd.invalidate();
    }

    private void initView() {
        this.egH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.nav_close_layout, this.gJN);
        this.mNavigationBar.setCenterTextTitle(this.gJN.getPageContext().getString(d.l.post_video_title));
        this.gJO = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nav_text_send_layout, this.gJN);
        this.gJO.setText(d.l.send_post);
        this.gJP.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.a.3
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.gJP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.a.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                long bAh = a.gJL - a.this.bAh();
                if (bAh >= 0) {
                    aj.i(a.this.gJS, d.e.cp_cont_e);
                } else {
                    aj.i(a.this.gJS, d.e.cp_cont_h);
                }
                if (bAh <= a.gJM) {
                    a.this.gJS.setText(am.vr());
                } else {
                    a.this.gJS.setText(String.valueOf(bAh));
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void ti(String str) {
        int i;
        int i2 = 0;
        Bitmap rc = rc(str);
        if (rc != null && rc.getHeight() != 0) {
            if (rc.getHeight() <= 0) {
                i = 0;
            } else if (rc.getWidth() / rc.getHeight() > l.ad(this.gJN) / l.f(this.gJN, d.f.ds440)) {
                i = l.ad(this.gJN);
                if (rc.getWidth() > 0) {
                    i2 = (int) ((i / rc.getWidth()) * rc.getHeight());
                }
            } else {
                int f = l.f(this.gJN, d.f.ds440);
                if (rc.getWidth() > 0) {
                    i = (int) ((f / rc.getHeight()) * rc.getWidth());
                    i2 = f;
                } else {
                    i = 0;
                    i2 = f;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.gxg.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.gxg.setLayoutParams(layoutParams);
            this.gxg.setImageBitmap(rc);
        }
    }

    private Bitmap rc(String str) {
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
        this.gJN.getLayoutMode().ai(i == 1);
        this.gJN.getLayoutMode().t(this.bKr);
        this.mNavigationBar.onChangeSkinType(this.gJN.getPageContext(), i);
        aj.c(this.egH, d.g.icon_return_bg_s);
        aj.c(this.gJO, d.e.cp_link_tip_a, 1);
        aj.j(this.gJR, d.g.corner_bg);
        if (this.gJR != null) {
            this.gJR.wB();
        }
    }

    public String getContent() {
        if (this.gJP.getText() == null) {
            return null;
        }
        return this.gJP.getText().toString();
    }

    public long bAh() {
        if (this.gJP.getText() == null || this.gJP.getText().toString() == null) {
            return 0L;
        }
        return g(this.gJP.getText().toString().trim());
    }

    public static long g(CharSequence charSequence) {
        if (charSequence == null) {
            return 0L;
        }
        double d = 0.0d;
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) > ' ') {
                d += 1.0d;
            }
        }
        return Math.round(d);
    }

    public WriteLocationView bAi() {
        return this.gJR;
    }

    public View bAj() {
        return this.gJO;
    }

    public View getBackButton() {
        return this.egH;
    }

    public View bAk() {
        return this.gJP;
    }

    public void tj(String str) {
        this.gJP.setText(str);
    }

    public TextView bAl() {
        return this.gJQ;
    }

    public void a(VideoInfo videoInfo) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                ti(thumbPath);
                this.gxg.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gxg.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.gxg.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.gxd.setVideoPath(videoPath);
                this.gxd.start();
            }
        }
    }

    public void bwt() {
        if (this.gxd != null) {
            this.gxd.resume();
            this.gxd.seekTo(this.gxn);
            this.gxd.start();
        }
    }

    public void aiq() {
        this.gxn = this.gxd.getCurrentPosition();
        if (this.gxd != null) {
            this.gxd.stopPlayback();
        }
    }

    public void tk(String str) {
        if (StringUtils.isNull(str)) {
            this.gJQ.setText(d.l.select_forum);
        } else {
            this.gJQ.setText(str);
        }
    }
}
