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
    public static int gJM = 31;
    private static int gJN = -100;
    private View bKr;
    private ImageView egH;
    private WriteVideoActivity gJO;
    private TextView gJP;
    private EditText gJQ;
    private TextView gJR;
    private WriteLocationView gJS;
    private TextView gJT;
    private CustomVideoView gxe;
    private ImageView gxh;
    private int gxo;
    private NavigationBar mNavigationBar;

    public a(WriteVideoActivity writeVideoActivity) {
        this.gJO = writeVideoActivity;
        this.gJO.setContentView(d.j.write_video_activity);
        bAh();
        initView();
    }

    private void bAh() {
        this.bKr = this.gJO.findViewById(d.h.layout_root);
        this.mNavigationBar = (NavigationBar) this.gJO.findViewById(d.h.navigation_bar);
        this.gJQ = (EditText) this.gJO.findViewById(d.h.edit_content);
        this.gJT = (TextView) this.gJO.findViewById(d.h.text_content_size);
        this.gJR = (TextView) this.gJO.findViewById(d.h.select_forum_btn);
        this.gxh = (ImageView) this.gJO.findViewById(d.h.video_cover);
        this.gJS = (WriteLocationView) this.gJO.findViewById(d.h.location);
        this.gxe = (CustomVideoView) this.gJO.findViewById(d.h.preview_videoview);
        this.gJR.setOnClickListener(this.gJO);
        this.gxe.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.a.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.gxe.getWidth() != a.this.gxh.getWidth() || a.this.gxe.getHeight() != a.this.gxh.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = a.this.gxh.getLayoutParams();
                    layoutParams.width = a.this.gxe.getWidth();
                    layoutParams.height = a.this.gxe.getHeight();
                    a.this.gxh.setLayoutParams(layoutParams);
                }
                a.this.gxh.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gxe.start();
                        a.this.gxh.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.gxe.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.a.2
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
        } else if (i / i2 > l.ad(this.gJO) / l.f(this.gJO, d.f.ds440)) {
            i3 = l.ad(this.gJO);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.gJO, d.f.ds440);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.gxe.setVideoHeight(i4);
        this.gxe.setVideoWidth(i3);
        this.gxe.invalidate();
    }

    private void initView() {
        this.egH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.nav_close_layout, this.gJO);
        this.mNavigationBar.setCenterTextTitle(this.gJO.getPageContext().getString(d.l.post_video_title));
        this.gJP = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nav_text_send_layout, this.gJO);
        this.gJP.setText(d.l.send_post);
        this.gJQ.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.a.3
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.gJQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.a.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                long bAi = a.gJM - a.this.bAi();
                if (bAi >= 0) {
                    aj.i(a.this.gJT, d.e.cp_cont_e);
                } else {
                    aj.i(a.this.gJT, d.e.cp_cont_h);
                }
                if (bAi <= a.gJN) {
                    a.this.gJT.setText(am.vr());
                } else {
                    a.this.gJT.setText(String.valueOf(bAi));
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
            } else if (rc.getWidth() / rc.getHeight() > l.ad(this.gJO) / l.f(this.gJO, d.f.ds440)) {
                i = l.ad(this.gJO);
                if (rc.getWidth() > 0) {
                    i2 = (int) ((i / rc.getWidth()) * rc.getHeight());
                }
            } else {
                int f = l.f(this.gJO, d.f.ds440);
                if (rc.getWidth() > 0) {
                    i = (int) ((f / rc.getHeight()) * rc.getWidth());
                    i2 = f;
                } else {
                    i = 0;
                    i2 = f;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.gxh.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.gxh.setLayoutParams(layoutParams);
            this.gxh.setImageBitmap(rc);
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
        this.gJO.getLayoutMode().ai(i == 1);
        this.gJO.getLayoutMode().t(this.bKr);
        this.mNavigationBar.onChangeSkinType(this.gJO.getPageContext(), i);
        aj.c(this.egH, d.g.icon_return_bg_s);
        aj.c(this.gJP, d.e.cp_link_tip_a, 1);
        aj.j(this.gJS, d.g.corner_bg);
        if (this.gJS != null) {
            this.gJS.wB();
        }
    }

    public String getContent() {
        if (this.gJQ.getText() == null) {
            return null;
        }
        return this.gJQ.getText().toString();
    }

    public long bAi() {
        if (this.gJQ.getText() == null || this.gJQ.getText().toString() == null) {
            return 0L;
        }
        return g(this.gJQ.getText().toString().trim());
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

    public WriteLocationView bAj() {
        return this.gJS;
    }

    public View bAk() {
        return this.gJP;
    }

    public View getBackButton() {
        return this.egH;
    }

    public View bAl() {
        return this.gJQ;
    }

    public void tj(String str) {
        this.gJQ.setText(str);
    }

    public TextView bAm() {
        return this.gJR;
    }

    public void a(VideoInfo videoInfo) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                ti(thumbPath);
                this.gxh.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gxh.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.gxh.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.gxe.setVideoPath(videoPath);
                this.gxe.start();
            }
        }
    }

    public void bwu() {
        if (this.gxe != null) {
            this.gxe.resume();
            this.gxe.seekTo(this.gxo);
            this.gxe.start();
        }
    }

    public void aiq() {
        this.gxo = this.gxe.getCurrentPosition();
        if (this.gxe != null) {
            this.gxe.stopPlayback();
        }
    }

    public void tk(String str) {
        if (StringUtils.isNull(str)) {
            this.gJR.setText(d.l.select_forum);
        } else {
            this.gJR.setText(str);
        }
    }
}
