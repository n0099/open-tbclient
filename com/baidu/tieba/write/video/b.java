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
    public static int hMH = 60;
    private ScrollView bDf;
    private RelativeLayout bWd;
    private WriteVideoActivity hMI;
    private TextView hMJ;
    private EditText hMK;
    private StateSwitchView hML;
    private WriteLocationView hMM;
    private TextView hMN;
    private ImageView hMO;
    private com.baidu.tieba.write.b hMP;
    private LinearLayout hMQ;
    private ListView hMR;
    private a hMS;
    private LinearLayout hMT;
    private TextView hMU;
    private TextView hMV;
    private TextView hMW;
    private boolean hMX = true;
    private CustomVideoView hwd;
    private ImageView hwg;
    private int hwn;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.hMI = writeVideoActivity;
        this.hMI.setContentView(e.h.write_video_activity);
        this.hMP = new com.baidu.tieba.write.b();
        this.hMP.wf(e.d.cp_cont_i);
        this.hMP.wg(e.d.cp_cont_h_alpha85);
        bMR();
        initView();
    }

    private void bMR() {
        this.bWd = (RelativeLayout) this.hMI.findViewById(e.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hMI.findViewById(e.g.navigation_bar);
        this.hMK = (EditText) this.hMI.findViewById(e.g.edit_content);
        this.hMN = (TextView) this.hMI.findViewById(e.g.text_content_size);
        this.hwg = (ImageView) this.hMI.findViewById(e.g.video_cover);
        this.hMM = (WriteLocationView) this.hMI.findViewById(e.g.location);
        this.hwd = (CustomVideoView) this.hMI.findViewById(e.g.preview_videoview);
        this.bDf = (ScrollView) this.hMI.findViewById(e.g.write_scrollview);
        this.hwd.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.hwd.getWidth() != b.this.hwg.getWidth() || b.this.hwd.getHeight() != b.this.hwg.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.hwg.getLayoutParams();
                    layoutParams.width = b.this.hwd.getWidth();
                    layoutParams.height = b.this.hwd.getHeight();
                    b.this.hwg.setLayoutParams(layoutParams);
                }
                b.this.hwg.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hwd.start();
                        b.this.hwg.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.hwd.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.bU(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hMQ = (LinearLayout) this.hMI.findViewById(e.g.video_activity_title_container);
        this.hMR = (ListView) this.hMI.findViewById(e.g.video_activity_title_list);
        this.hMR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.hMQ.setVisibility(8);
                b.this.hMN.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.hMK.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.hMK.requestFocus();
                    if (!TextUtils.isEmpty(b.this.hMK.getText())) {
                        b.this.hMK.setSelection(b.this.hMK.getText().length());
                    }
                    l.b(b.this.hMI, b.this.hMK);
                }
            }
        });
        this.hMT = (LinearLayout) this.hMI.findViewById(e.g.save_video_wrapper);
        this.hMU = (TextView) this.hMI.findViewById(e.g.save_video_ridiobutton);
        this.hMV = (TextView) this.hMI.findViewById(e.g.save_video_ridiotext);
        this.hMW = (TextView) this.hMI.findViewById(e.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.hMI) / l.h(this.hMI, e.C0175e.ds440)) {
            i3 = l.aO(this.hMI);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.hMI, e.C0175e.ds440);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.hwd.setVideoHeight(i4);
        this.hwd.setVideoWidth(i3);
        this.hwd.invalidate();
    }

    private void initView() {
        this.hMO = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.nav_close_layout, this.hMI);
        this.mNavigationBar.setCenterTextTitle(this.hMI.getPageContext().getString(e.j.post_video_title));
        this.hMJ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.nav_text_send_layout, this.hMI);
        this.hMJ.setText(e.j.send_post);
        this.hMK.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hMK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.hMS != null && b.this.hMS.getCount() > 0) {
                    l.a(b.this.hMI, b.this.hMK);
                    b.this.hMQ.setVisibility(0);
                    b.this.hMN.setVisibility(8);
                }
                long bMT = b.hMH - b.this.bMT();
                if (bMT >= 0) {
                    al.h(b.this.hMN, e.d.cp_cont_e);
                    b.this.hMN.setText(String.valueOf(bMT));
                    return;
                }
                b.this.hMN.setText("0");
                b.this.hMK.setText(b.this.hMK.getText().toString().substring(0, b.hMH));
                b.this.hMK.setSelection(b.this.hMK.getText().length());
                b.this.hMI.showToast(b.this.hMI.getResources().getString(e.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.hMP != null) {
                    if (!b.this.hMP.bLt()) {
                        b.this.ok(false);
                    }
                    b.this.hMP.ob(false);
                }
            }
        });
        this.hMS = new a();
        this.hMR.setAdapter((ListAdapter) this.hMS);
        this.hMX = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hMX) {
            al.i(this.hMU, e.f.corner_bg_radio_selected);
        } else {
            al.i(this.hMU, e.f.corner_bg_radio_unselected);
        }
        al.h(this.hMV, e.d.cp_cont_g);
        this.hMT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hMX) {
                    b.this.hMX = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    al.i(b.this.hMU, e.f.corner_bg_radio_unselected);
                    b.this.hMU.invalidate();
                    return;
                }
                b.this.hMX = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                al.i(b.this.hMU, e.f.corner_bg_radio_selected);
                b.this.hMU.invalidate();
            }
        });
    }

    public void bMS() {
        if (this.hMW != null) {
            this.hMW.setVisibility(0);
        }
    }

    public void xb(String str) {
        int i;
        int i2 = 0;
        Bitmap uw = uw(str);
        if (uw != null && uw.getHeight() != 0) {
            if (uw.getHeight() <= 0) {
                i = 0;
            } else if (uw.getWidth() / uw.getHeight() > l.aO(this.hMI) / l.h(this.hMI, e.C0175e.ds440)) {
                i = l.aO(this.hMI);
                if (uw.getWidth() > 0) {
                    i2 = (int) ((i / uw.getWidth()) * uw.getHeight());
                }
            } else {
                int h = l.h(this.hMI, e.C0175e.ds440);
                if (uw.getWidth() > 0) {
                    i = (int) ((h / uw.getHeight()) * uw.getWidth());
                    i2 = h;
                } else {
                    i = 0;
                    i2 = h;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hwg.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hwg.setLayoutParams(layoutParams);
            this.hwg.setImageBitmap(uw);
        }
    }

    private Bitmap uw(String str) {
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
        this.hMI.getLayoutMode().setNightMode(i == 1);
        this.hMI.getLayoutMode().onModeChanged(this.bWd);
        this.mNavigationBar.onChangeSkinType(this.hMI.getPageContext(), i);
        al.c(this.hMO, e.f.icon_return_bg_s);
        al.c(this.hMJ, e.d.cp_link_tip_a, 1);
        al.i(this.hMM, e.f.corner_bg);
        al.h(this.hMW, e.d.cp_cont_e);
        this.hMX = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hMX) {
            al.i(this.hMU, e.f.corner_bg_radio_selected);
        } else {
            al.i(this.hMU, e.f.corner_bg_radio_unselected);
        }
        if (this.hMM != null) {
            this.hMM.onChangeSkinType(i);
        }
        if (this.hML != null) {
            this.hML.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hMK.getText() == null) {
            return null;
        }
        return this.hMK.getText().toString();
    }

    public long bMT() {
        if (this.hMK.getText() == null || this.hMK.getText().toString() == null) {
            return 0L;
        }
        return this.hMK.getText().length();
    }

    public WriteLocationView bMU() {
        return this.hMM;
    }

    public View bMV() {
        return this.hMJ;
    }

    public View getBackButton() {
        return this.hMO;
    }

    public EditText bMW() {
        return this.hMK;
    }

    public StateSwitchView bMX() {
        return this.hML;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                xb(thumbPath);
                this.hwg.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hwg.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hwg.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.hwd.setVideoPath(videoPath);
                this.hwd.start();
            }
        }
        if (!v.J(list)) {
            this.hMS.eg(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hMK.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hMS.eg(arrayList);
            this.hMK.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bHW() {
        if (this.hwd != null) {
            this.hwd.resume();
            this.hwd.seekTo(this.hwn);
            this.hwd.start();
        }
    }

    public void aBJ() {
        this.hwn = this.hwd.getCurrentPosition();
        if (this.hwd != null) {
            this.hwd.stopPlayback();
        }
    }

    public void xc(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hMI.getResources().getString(e.j.post_to_home_page));
            bMY();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hMI.getResources().getString(e.j.post_to) + str);
        bMZ();
    }

    private void bMY() {
        this.hML = new StateSwitchView(this.hMI);
        this.hML.setStateString(this.hMI.getString(e.j.public_to_all), this.hMI.getString(e.j.public_to_me));
        this.hML.setBackgroundId(e.f.state_switch_bg);
        this.hML.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hML.apT();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.hMI, e.C0175e.ds34), l.h(this.hMI, e.C0175e.ds16));
        this.bWd.addView(this.hML, layoutParams);
    }

    private void bMZ() {
        this.hML = new StateSwitchView(this.hMI);
        this.hML.setStateString(this.hMI.getString(e.j.display_to_home_page), this.hMI.getString(e.j.display_to_home_page));
        this.hML.setLeftStateDrawable(e.f.icon_share_home_select_ok, e.f.icon_share_home_select);
        this.hML.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hML.apT();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.hMI, e.C0175e.ds34), l.h(this.hMI, e.C0175e.ds16));
        this.hML.setTextSize(0, this.hMI.getResources().getDimensionPixelSize(e.C0175e.ds28));
        this.bWd.addView(this.hML, layoutParams);
    }

    public void bNa() {
        this.hMP.aA(null);
        this.hMP.oa(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hMP.aA(postWriteCallBackData.getSensitiveWords());
            this.hMP.wJ(postWriteCallBackData.getErrorString());
            if (!v.J(this.hMP.bLq())) {
                ok(true);
            }
        }
    }

    public void ok(boolean z) {
        if (this.hMK.getText() != null) {
            int selectionEnd = this.hMK.getSelectionEnd();
            SpannableStringBuilder b = this.hMP.b(this.hMK.getText());
            if (b != null) {
                this.hMP.ob(true);
                this.hMK.setText(b);
                if (z && this.hMP.bLr() >= 0) {
                    this.hMK.requestFocus();
                    this.hMK.setSelection(this.hMP.bLr());
                } else {
                    this.hMK.setSelection(selectionEnd);
                }
                this.hMP.oa(this.hMP.bLr() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bNb() {
        return this.hMP;
    }

    public void ol(boolean z) {
        if (z) {
            this.hMQ.setVisibility(8);
            this.hMN.setVisibility(0);
            this.bDf.smoothScrollTo(0, this.hMN.getBottom());
        }
    }
}
