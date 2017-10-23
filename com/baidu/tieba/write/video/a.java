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
    public static int gJw = 31;
    private static int gJx = -100;
    private View bKf;
    private ImageView egt;
    private EditText gJA;
    private TextView gJB;
    private WriteLocationView gJC;
    private TextView gJD;
    private WriteVideoActivity gJy;
    private TextView gJz;
    private CustomVideoView gwP;
    private ImageView gwS;
    private int gwZ;
    private NavigationBar mNavigationBar;

    public a(WriteVideoActivity writeVideoActivity) {
        this.gJy = writeVideoActivity;
        this.gJy.setContentView(d.j.write_video_activity);
        bAa();
        initView();
    }

    private void bAa() {
        this.bKf = this.gJy.findViewById(d.h.layout_root);
        this.mNavigationBar = (NavigationBar) this.gJy.findViewById(d.h.navigation_bar);
        this.gJA = (EditText) this.gJy.findViewById(d.h.edit_content);
        this.gJD = (TextView) this.gJy.findViewById(d.h.text_content_size);
        this.gJB = (TextView) this.gJy.findViewById(d.h.select_forum_btn);
        this.gwS = (ImageView) this.gJy.findViewById(d.h.video_cover);
        this.gJC = (WriteLocationView) this.gJy.findViewById(d.h.location);
        this.gwP = (CustomVideoView) this.gJy.findViewById(d.h.preview_videoview);
        this.gJB.setOnClickListener(this.gJy);
        this.gwP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.a.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.gwP.getWidth() != a.this.gwS.getWidth() || a.this.gwP.getHeight() != a.this.gwS.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = a.this.gwS.getLayoutParams();
                    layoutParams.width = a.this.gwP.getWidth();
                    layoutParams.height = a.this.gwP.getHeight();
                    a.this.gwS.setLayoutParams(layoutParams);
                }
                a.this.gwS.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gwP.start();
                        a.this.gwS.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.gwP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.a.2
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
        } else if (i / i2 > l.ad(this.gJy) / l.f(this.gJy, d.f.ds440)) {
            i3 = l.ad(this.gJy);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.gJy, d.f.ds440);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.gwP.setVideoHeight(i4);
        this.gwP.setVideoWidth(i3);
        this.gwP.invalidate();
    }

    private void initView() {
        this.egt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.nav_close_layout, this.gJy);
        this.mNavigationBar.setCenterTextTitle(this.gJy.getPageContext().getString(d.l.post_video_title));
        this.gJz = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nav_text_send_layout, this.gJy);
        this.gJz.setText(d.l.send_post);
        this.gJA.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.a.3
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.gJA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.a.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                long bAb = a.gJw - a.this.bAb();
                if (bAb >= 0) {
                    aj.i(a.this.gJD, d.e.cp_cont_e);
                } else {
                    aj.i(a.this.gJD, d.e.cp_cont_h);
                }
                if (bAb <= a.gJx) {
                    a.this.gJD.setText(am.vk());
                } else {
                    a.this.gJD.setText(String.valueOf(bAb));
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void th(String str) {
        int i;
        int i2 = 0;
        Bitmap rb = rb(str);
        if (rb != null && rb.getHeight() != 0) {
            if (rb.getHeight() <= 0) {
                i = 0;
            } else if (rb.getWidth() / rb.getHeight() > l.ad(this.gJy) / l.f(this.gJy, d.f.ds440)) {
                i = l.ad(this.gJy);
                if (rb.getWidth() > 0) {
                    i2 = (int) ((i / rb.getWidth()) * rb.getHeight());
                }
            } else {
                int f = l.f(this.gJy, d.f.ds440);
                if (rb.getWidth() > 0) {
                    i = (int) ((f / rb.getHeight()) * rb.getWidth());
                    i2 = f;
                } else {
                    i = 0;
                    i2 = f;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.gwS.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.gwS.setLayoutParams(layoutParams);
            this.gwS.setImageBitmap(rb);
        }
    }

    private Bitmap rb(String str) {
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
        this.gJy.getLayoutMode().ah(i == 1);
        this.gJy.getLayoutMode().t(this.bKf);
        this.mNavigationBar.onChangeSkinType(this.gJy.getPageContext(), i);
        aj.c(this.egt, d.g.icon_return_bg_s);
        aj.c(this.gJz, d.e.cp_link_tip_a, 1);
        aj.j(this.gJC, d.g.corner_bg);
        if (this.gJC != null) {
            this.gJC.wu();
        }
    }

    public String getContent() {
        if (this.gJA.getText() == null) {
            return null;
        }
        return this.gJA.getText().toString();
    }

    public long bAb() {
        if (this.gJA.getText() == null || this.gJA.getText().toString() == null) {
            return 0L;
        }
        return g(this.gJA.getText().toString().trim());
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

    public WriteLocationView bAc() {
        return this.gJC;
    }

    public View bAd() {
        return this.gJz;
    }

    public View getBackButton() {
        return this.egt;
    }

    public View bAe() {
        return this.gJA;
    }

    public void ti(String str) {
        this.gJA.setText(str);
    }

    public TextView bAf() {
        return this.gJB;
    }

    public void a(VideoInfo videoInfo) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                th(thumbPath);
                this.gwS.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gwS.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.gwS.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.gwP.setVideoPath(videoPath);
                this.gwP.start();
            }
        }
    }

    public void bwl() {
        if (this.gwP != null) {
            this.gwP.resume();
            this.gwP.seekTo(this.gwZ);
            this.gwP.start();
        }
    }

    public void ail() {
        this.gwZ = this.gwP.getCurrentPosition();
        if (this.gwP != null) {
            this.gwP.stopPlayback();
        }
    }

    public void tj(String str) {
        if (StringUtils.isNull(str)) {
            this.gJB.setText(d.l.select_forum);
        } else {
            this.gJB.setText(str);
        }
    }
}
