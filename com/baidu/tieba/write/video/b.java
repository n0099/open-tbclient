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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.editor.StateSwitchView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static int hZV = 60;
    private ScrollView bIl;
    private RelativeLayout cbw;
    private int hJC;
    private CustomVideoView hJs;
    private ImageView hJv;
    private WriteVideoActivity hZW;
    private TextView hZX;
    private EditText hZY;
    private StateSwitchView hZZ;
    private WriteLocationView iaa;
    private TextView iab;
    private ImageView iac;
    private com.baidu.tieba.write.b iad;
    private LinearLayout iae;
    private ListView iaf;
    private a iag;
    private LinearLayout iah;
    private TextView iai;
    private TextView iaj;
    private TextView iak;
    private boolean ial = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.hZW = writeVideoActivity;
        this.hZW.setContentView(e.h.write_video_activity);
        this.iad = new com.baidu.tieba.write.b();
        this.iad.xk(e.d.cp_cont_i);
        this.iad.xl(e.d.cp_cont_h_alpha85);
        bPU();
        initView();
    }

    private void bPU() {
        this.cbw = (RelativeLayout) this.hZW.findViewById(e.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hZW.findViewById(e.g.navigation_bar);
        this.hZY = (EditText) this.hZW.findViewById(e.g.edit_content);
        this.iab = (TextView) this.hZW.findViewById(e.g.text_content_size);
        this.hJv = (ImageView) this.hZW.findViewById(e.g.video_cover);
        this.iaa = (WriteLocationView) this.hZW.findViewById(e.g.location);
        this.hJs = (CustomVideoView) this.hZW.findViewById(e.g.preview_videoview);
        this.bIl = (ScrollView) this.hZW.findViewById(e.g.write_scrollview);
        this.hJs.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.hJs.getWidth() != b.this.hJv.getWidth() || b.this.hJs.getHeight() != b.this.hJv.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.hJv.getLayoutParams();
                    layoutParams.width = b.this.hJs.getWidth();
                    layoutParams.height = b.this.hJs.getHeight();
                    b.this.hJv.setLayoutParams(layoutParams);
                }
                b.this.hJv.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hJs.start();
                        b.this.hJv.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.hJs.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.bX(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.iae = (LinearLayout) this.hZW.findViewById(e.g.video_activity_title_container);
        this.iaf = (ListView) this.hZW.findViewById(e.g.video_activity_title_list);
        this.iaf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.iae.setVisibility(8);
                b.this.iab.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.hZY.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.hZY.requestFocus();
                    if (!TextUtils.isEmpty(b.this.hZY.getText())) {
                        b.this.hZY.setSelection(b.this.hZY.getText().length());
                    }
                    l.c(b.this.hZW, b.this.hZY);
                }
            }
        });
        this.iah = (LinearLayout) this.hZW.findViewById(e.g.save_video_wrapper);
        this.iai = (TextView) this.hZW.findViewById(e.g.save_video_ridiobutton);
        this.iaj = (TextView) this.hZW.findViewById(e.g.save_video_ridiotext);
        this.iak = (TextView) this.hZW.findViewById(e.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.hZW) / l.h(this.hZW, e.C0210e.ds440)) {
            i3 = l.aO(this.hZW);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.hZW, e.C0210e.ds440);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.hJs.setVideoHeight(i4);
        this.hJs.setVideoWidth(i3);
        this.hJs.invalidate();
    }

    private void initView() {
        this.iac = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.nav_close_layout, this.hZW);
        this.mNavigationBar.setCenterTextTitle(this.hZW.getPageContext().getString(e.j.post_video_title));
        this.hZX = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.nav_text_send_layout, this.hZW);
        this.hZX.setText(e.j.send_post);
        this.hZY.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hZY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.iag != null && b.this.iag.getCount() > 0) {
                    l.b(b.this.hZW, b.this.hZY);
                    b.this.iae.setVisibility(0);
                    b.this.iab.setVisibility(8);
                }
                long bPW = b.hZV - b.this.bPW();
                if (bPW >= 0) {
                    al.h(b.this.iab, e.d.cp_cont_e);
                    b.this.iab.setText(String.valueOf(bPW));
                    return;
                }
                b.this.iab.setText("0");
                b.this.hZY.setText(b.this.hZY.getText().toString().substring(0, b.hZV));
                b.this.hZY.setSelection(b.this.hZY.getText().length());
                b.this.hZW.showToast(b.this.hZW.getResources().getString(e.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.iad != null) {
                    if (!b.this.iad.bOw()) {
                        b.this.oE(false);
                    }
                    b.this.iad.ov(false);
                }
            }
        });
        this.iag = new a();
        this.iaf.setAdapter((ListAdapter) this.iag);
        this.ial = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.ial) {
            al.i(this.iai, e.f.corner_bg_radio_selected);
        } else {
            al.i(this.iai, e.f.corner_bg_radio_unselected);
        }
        al.h(this.iaj, e.d.cp_cont_g);
        this.iah.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ial) {
                    b.this.ial = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    al.i(b.this.iai, e.f.corner_bg_radio_unselected);
                    b.this.iai.invalidate();
                    return;
                }
                b.this.ial = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                al.i(b.this.iai, e.f.corner_bg_radio_selected);
                b.this.iai.invalidate();
            }
        });
    }

    public void bPV() {
        if (this.iak != null) {
            this.iak.setVisibility(0);
        }
    }

    public void yc(String str) {
        int i;
        int i2 = 0;
        Bitmap vu = vu(str);
        if (vu != null && vu.getHeight() != 0) {
            if (vu.getHeight() <= 0) {
                i = 0;
            } else if (vu.getWidth() / vu.getHeight() > l.aO(this.hZW) / l.h(this.hZW, e.C0210e.ds440)) {
                i = l.aO(this.hZW);
                if (vu.getWidth() > 0) {
                    i2 = (int) ((i / vu.getWidth()) * vu.getHeight());
                }
            } else {
                int h = l.h(this.hZW, e.C0210e.ds440);
                if (vu.getWidth() > 0) {
                    i = (int) ((h / vu.getHeight()) * vu.getWidth());
                    i2 = h;
                } else {
                    i = 0;
                    i2 = h;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hJv.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hJv.setLayoutParams(layoutParams);
            this.hJv.setImageBitmap(vu);
        }
    }

    private Bitmap vu(String str) {
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
        this.hZW.getLayoutMode().setNightMode(i == 1);
        this.hZW.getLayoutMode().onModeChanged(this.cbw);
        this.mNavigationBar.onChangeSkinType(this.hZW.getPageContext(), i);
        al.c(this.iac, e.f.icon_return_bg_s);
        al.c(this.hZX, e.d.cp_link_tip_a, 1);
        al.i(this.iaa, e.f.corner_bg);
        al.h(this.iak, e.d.cp_cont_e);
        this.ial = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.ial) {
            al.i(this.iai, e.f.corner_bg_radio_selected);
        } else {
            al.i(this.iai, e.f.corner_bg_radio_unselected);
        }
        if (this.iaa != null) {
            this.iaa.onChangeSkinType(i);
        }
        if (this.hZZ != null) {
            this.hZZ.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hZY.getText() == null) {
            return null;
        }
        return this.hZY.getText().toString();
    }

    public long bPW() {
        if (this.hZY.getText() == null || this.hZY.getText().toString() == null) {
            return 0L;
        }
        return this.hZY.getText().length();
    }

    public WriteLocationView bPX() {
        return this.iaa;
    }

    public View bPY() {
        return this.hZX;
    }

    public View getBackButton() {
        return this.iac;
    }

    public EditText bPZ() {
        return this.hZY;
    }

    public StateSwitchView bQa() {
        return this.hZZ;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                yc(thumbPath);
                this.hJv.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hJv.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hJv.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.hJs.setVideoPath(videoPath);
                this.hJs.start();
            }
        }
        if (!v.I(list)) {
            this.iag.ek(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hZY.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.iag.ek(arrayList);
            this.hZY.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bKY() {
        if (this.hJs != null) {
            this.hJs.resume();
            this.hJs.seekTo(this.hJC);
            this.hJs.start();
        }
    }

    public void aEd() {
        this.hJC = this.hJs.getCurrentPosition();
        if (this.hJs != null) {
            this.hJs.stopPlayback();
        }
    }

    public void yd(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hZW.getResources().getString(e.j.post_to_home_page));
            bQb();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hZW.getResources().getString(e.j.post_to) + str);
        bQc();
    }

    private void bQb() {
        this.hZZ = new StateSwitchView(this.hZW);
        this.hZZ.setStateString(this.hZW.getString(e.j.public_to_all), this.hZW.getString(e.j.public_to_me));
        this.hZZ.setBackgroundId(e.f.state_switch_bg);
        this.hZZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hZZ.asu();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.hZW, e.C0210e.ds34), l.h(this.hZW, e.C0210e.ds16));
        this.cbw.addView(this.hZZ, layoutParams);
    }

    private void bQc() {
        this.hZZ = new StateSwitchView(this.hZW);
        this.hZZ.setStateString(this.hZW.getString(e.j.display_to_home_page), this.hZW.getString(e.j.display_to_home_page));
        this.hZZ.setLeftStateDrawable(e.f.icon_share_home_select_ok, e.f.icon_share_home_select);
        this.hZZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hZZ.asu();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.hZW, e.C0210e.ds34), l.h(this.hZW, e.C0210e.ds16));
        this.hZZ.setTextSize(0, this.hZW.getResources().getDimensionPixelSize(e.C0210e.ds28));
        this.cbw.addView(this.hZZ, layoutParams);
    }

    public void bQd() {
        this.iad.aA(null);
        this.iad.ou(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iad.aA(postWriteCallBackData.getSensitiveWords());
            this.iad.xK(postWriteCallBackData.getErrorString());
            if (!v.I(this.iad.bOt())) {
                oE(true);
            }
        }
    }

    public void oE(boolean z) {
        if (this.hZY.getText() != null) {
            int selectionEnd = this.hZY.getSelectionEnd();
            SpannableStringBuilder b = this.iad.b(this.hZY.getText());
            if (b != null) {
                this.iad.ov(true);
                this.hZY.setText(b);
                if (z && this.iad.bOu() >= 0) {
                    this.hZY.requestFocus();
                    this.hZY.setSelection(this.iad.bOu());
                } else {
                    this.hZY.setSelection(selectionEnd);
                }
                this.iad.ou(this.iad.bOu() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bQe() {
        return this.iad;
    }

    public void oF(boolean z) {
        if (z) {
            this.iae.setVisibility(8);
            this.iab.setVisibility(0);
            this.bIl.smoothScrollTo(0, this.iab.getBottom());
        }
    }
}
