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
    public static int hZU = 60;
    private ScrollView bIk;
    private RelativeLayout cbv;
    private int hJB;
    private CustomVideoView hJr;
    private ImageView hJu;
    private WriteVideoActivity hZV;
    private TextView hZW;
    private EditText hZX;
    private StateSwitchView hZY;
    private WriteLocationView hZZ;
    private TextView iaa;
    private ImageView iab;
    private com.baidu.tieba.write.b iac;
    private LinearLayout iad;
    private ListView iae;
    private a iaf;
    private LinearLayout iag;
    private TextView iah;
    private TextView iai;
    private TextView iaj;
    private boolean iak = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.hZV = writeVideoActivity;
        this.hZV.setContentView(e.h.write_video_activity);
        this.iac = new com.baidu.tieba.write.b();
        this.iac.xk(e.d.cp_cont_i);
        this.iac.xl(e.d.cp_cont_h_alpha85);
        bPU();
        initView();
    }

    private void bPU() {
        this.cbv = (RelativeLayout) this.hZV.findViewById(e.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hZV.findViewById(e.g.navigation_bar);
        this.hZX = (EditText) this.hZV.findViewById(e.g.edit_content);
        this.iaa = (TextView) this.hZV.findViewById(e.g.text_content_size);
        this.hJu = (ImageView) this.hZV.findViewById(e.g.video_cover);
        this.hZZ = (WriteLocationView) this.hZV.findViewById(e.g.location);
        this.hJr = (CustomVideoView) this.hZV.findViewById(e.g.preview_videoview);
        this.bIk = (ScrollView) this.hZV.findViewById(e.g.write_scrollview);
        this.hJr.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.hJr.getWidth() != b.this.hJu.getWidth() || b.this.hJr.getHeight() != b.this.hJu.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.hJu.getLayoutParams();
                    layoutParams.width = b.this.hJr.getWidth();
                    layoutParams.height = b.this.hJr.getHeight();
                    b.this.hJu.setLayoutParams(layoutParams);
                }
                b.this.hJu.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hJr.start();
                        b.this.hJu.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.hJr.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.bX(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.iad = (LinearLayout) this.hZV.findViewById(e.g.video_activity_title_container);
        this.iae = (ListView) this.hZV.findViewById(e.g.video_activity_title_list);
        this.iae.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.iad.setVisibility(8);
                b.this.iaa.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.hZX.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.hZX.requestFocus();
                    if (!TextUtils.isEmpty(b.this.hZX.getText())) {
                        b.this.hZX.setSelection(b.this.hZX.getText().length());
                    }
                    l.c(b.this.hZV, b.this.hZX);
                }
            }
        });
        this.iag = (LinearLayout) this.hZV.findViewById(e.g.save_video_wrapper);
        this.iah = (TextView) this.hZV.findViewById(e.g.save_video_ridiobutton);
        this.iai = (TextView) this.hZV.findViewById(e.g.save_video_ridiotext);
        this.iaj = (TextView) this.hZV.findViewById(e.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.hZV) / l.h(this.hZV, e.C0210e.ds440)) {
            i3 = l.aO(this.hZV);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.hZV, e.C0210e.ds440);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.hJr.setVideoHeight(i4);
        this.hJr.setVideoWidth(i3);
        this.hJr.invalidate();
    }

    private void initView() {
        this.iab = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.nav_close_layout, this.hZV);
        this.mNavigationBar.setCenterTextTitle(this.hZV.getPageContext().getString(e.j.post_video_title));
        this.hZW = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.nav_text_send_layout, this.hZV);
        this.hZW.setText(e.j.send_post);
        this.hZX.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hZX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.iaf != null && b.this.iaf.getCount() > 0) {
                    l.b(b.this.hZV, b.this.hZX);
                    b.this.iad.setVisibility(0);
                    b.this.iaa.setVisibility(8);
                }
                long bPW = b.hZU - b.this.bPW();
                if (bPW >= 0) {
                    al.h(b.this.iaa, e.d.cp_cont_e);
                    b.this.iaa.setText(String.valueOf(bPW));
                    return;
                }
                b.this.iaa.setText("0");
                b.this.hZX.setText(b.this.hZX.getText().toString().substring(0, b.hZU));
                b.this.hZX.setSelection(b.this.hZX.getText().length());
                b.this.hZV.showToast(b.this.hZV.getResources().getString(e.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.iac != null) {
                    if (!b.this.iac.bOw()) {
                        b.this.oE(false);
                    }
                    b.this.iac.ov(false);
                }
            }
        });
        this.iaf = new a();
        this.iae.setAdapter((ListAdapter) this.iaf);
        this.iak = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.iak) {
            al.i(this.iah, e.f.corner_bg_radio_selected);
        } else {
            al.i(this.iah, e.f.corner_bg_radio_unselected);
        }
        al.h(this.iai, e.d.cp_cont_g);
        this.iag.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.iak) {
                    b.this.iak = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    al.i(b.this.iah, e.f.corner_bg_radio_unselected);
                    b.this.iah.invalidate();
                    return;
                }
                b.this.iak = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                al.i(b.this.iah, e.f.corner_bg_radio_selected);
                b.this.iah.invalidate();
            }
        });
    }

    public void bPV() {
        if (this.iaj != null) {
            this.iaj.setVisibility(0);
        }
    }

    public void yc(String str) {
        int i;
        int i2 = 0;
        Bitmap vu = vu(str);
        if (vu != null && vu.getHeight() != 0) {
            if (vu.getHeight() <= 0) {
                i = 0;
            } else if (vu.getWidth() / vu.getHeight() > l.aO(this.hZV) / l.h(this.hZV, e.C0210e.ds440)) {
                i = l.aO(this.hZV);
                if (vu.getWidth() > 0) {
                    i2 = (int) ((i / vu.getWidth()) * vu.getHeight());
                }
            } else {
                int h = l.h(this.hZV, e.C0210e.ds440);
                if (vu.getWidth() > 0) {
                    i = (int) ((h / vu.getHeight()) * vu.getWidth());
                    i2 = h;
                } else {
                    i = 0;
                    i2 = h;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hJu.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hJu.setLayoutParams(layoutParams);
            this.hJu.setImageBitmap(vu);
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
        this.hZV.getLayoutMode().setNightMode(i == 1);
        this.hZV.getLayoutMode().onModeChanged(this.cbv);
        this.mNavigationBar.onChangeSkinType(this.hZV.getPageContext(), i);
        al.c(this.iab, e.f.icon_return_bg_s);
        al.c(this.hZW, e.d.cp_link_tip_a, 1);
        al.i(this.hZZ, e.f.corner_bg);
        al.h(this.iaj, e.d.cp_cont_e);
        this.iak = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.iak) {
            al.i(this.iah, e.f.corner_bg_radio_selected);
        } else {
            al.i(this.iah, e.f.corner_bg_radio_unselected);
        }
        if (this.hZZ != null) {
            this.hZZ.onChangeSkinType(i);
        }
        if (this.hZY != null) {
            this.hZY.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hZX.getText() == null) {
            return null;
        }
        return this.hZX.getText().toString();
    }

    public long bPW() {
        if (this.hZX.getText() == null || this.hZX.getText().toString() == null) {
            return 0L;
        }
        return this.hZX.getText().length();
    }

    public WriteLocationView bPX() {
        return this.hZZ;
    }

    public View bPY() {
        return this.hZW;
    }

    public View getBackButton() {
        return this.iab;
    }

    public EditText bPZ() {
        return this.hZX;
    }

    public StateSwitchView bQa() {
        return this.hZY;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                yc(thumbPath);
                this.hJu.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hJu.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hJu.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.hJr.setVideoPath(videoPath);
                this.hJr.start();
            }
        }
        if (!v.I(list)) {
            this.iaf.ek(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hZX.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.iaf.ek(arrayList);
            this.hZX.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bKY() {
        if (this.hJr != null) {
            this.hJr.resume();
            this.hJr.seekTo(this.hJB);
            this.hJr.start();
        }
    }

    public void aEd() {
        this.hJB = this.hJr.getCurrentPosition();
        if (this.hJr != null) {
            this.hJr.stopPlayback();
        }
    }

    public void yd(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hZV.getResources().getString(e.j.post_to_home_page));
            bQb();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hZV.getResources().getString(e.j.post_to) + str);
        bQc();
    }

    private void bQb() {
        this.hZY = new StateSwitchView(this.hZV);
        this.hZY.setStateString(this.hZV.getString(e.j.public_to_all), this.hZV.getString(e.j.public_to_me));
        this.hZY.setBackgroundId(e.f.state_switch_bg);
        this.hZY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hZY.asu();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.hZV, e.C0210e.ds34), l.h(this.hZV, e.C0210e.ds16));
        this.cbv.addView(this.hZY, layoutParams);
    }

    private void bQc() {
        this.hZY = new StateSwitchView(this.hZV);
        this.hZY.setStateString(this.hZV.getString(e.j.display_to_home_page), this.hZV.getString(e.j.display_to_home_page));
        this.hZY.setLeftStateDrawable(e.f.icon_share_home_select_ok, e.f.icon_share_home_select);
        this.hZY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hZY.asu();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.hZV, e.C0210e.ds34), l.h(this.hZV, e.C0210e.ds16));
        this.hZY.setTextSize(0, this.hZV.getResources().getDimensionPixelSize(e.C0210e.ds28));
        this.cbv.addView(this.hZY, layoutParams);
    }

    public void bQd() {
        this.iac.aA(null);
        this.iac.ou(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iac.aA(postWriteCallBackData.getSensitiveWords());
            this.iac.xK(postWriteCallBackData.getErrorString());
            if (!v.I(this.iac.bOt())) {
                oE(true);
            }
        }
    }

    public void oE(boolean z) {
        if (this.hZX.getText() != null) {
            int selectionEnd = this.hZX.getSelectionEnd();
            SpannableStringBuilder b = this.iac.b(this.hZX.getText());
            if (b != null) {
                this.iac.ov(true);
                this.hZX.setText(b);
                if (z && this.iac.bOu() >= 0) {
                    this.hZX.requestFocus();
                    this.hZX.setSelection(this.iac.bOu());
                } else {
                    this.hZX.setSelection(selectionEnd);
                }
                this.iac.ou(this.iac.bOu() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bQe() {
        return this.iac;
    }

    public void oF(boolean z) {
        if (z) {
            this.iad.setVisibility(8);
            this.iaa.setVisibility(0);
            this.bIk.smoothScrollTo(0, this.iaa.getBottom());
        }
    }
}
