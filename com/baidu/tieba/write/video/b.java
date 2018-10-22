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
    public static int hMI = 60;
    private ScrollView bDf;
    private RelativeLayout bWd;
    private WriteVideoActivity hMJ;
    private TextView hMK;
    private EditText hML;
    private StateSwitchView hMM;
    private WriteLocationView hMN;
    private TextView hMO;
    private ImageView hMP;
    private com.baidu.tieba.write.b hMQ;
    private LinearLayout hMR;
    private ListView hMS;
    private a hMT;
    private LinearLayout hMU;
    private TextView hMV;
    private TextView hMW;
    private TextView hMX;
    private boolean hMY = true;
    private CustomVideoView hwe;
    private ImageView hwh;
    private int hwo;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.hMJ = writeVideoActivity;
        this.hMJ.setContentView(e.h.write_video_activity);
        this.hMQ = new com.baidu.tieba.write.b();
        this.hMQ.wf(e.d.cp_cont_i);
        this.hMQ.wg(e.d.cp_cont_h_alpha85);
        bMR();
        initView();
    }

    private void bMR() {
        this.bWd = (RelativeLayout) this.hMJ.findViewById(e.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hMJ.findViewById(e.g.navigation_bar);
        this.hML = (EditText) this.hMJ.findViewById(e.g.edit_content);
        this.hMO = (TextView) this.hMJ.findViewById(e.g.text_content_size);
        this.hwh = (ImageView) this.hMJ.findViewById(e.g.video_cover);
        this.hMN = (WriteLocationView) this.hMJ.findViewById(e.g.location);
        this.hwe = (CustomVideoView) this.hMJ.findViewById(e.g.preview_videoview);
        this.bDf = (ScrollView) this.hMJ.findViewById(e.g.write_scrollview);
        this.hwe.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.hwe.getWidth() != b.this.hwh.getWidth() || b.this.hwe.getHeight() != b.this.hwh.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.hwh.getLayoutParams();
                    layoutParams.width = b.this.hwe.getWidth();
                    layoutParams.height = b.this.hwe.getHeight();
                    b.this.hwh.setLayoutParams(layoutParams);
                }
                b.this.hwh.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hwe.start();
                        b.this.hwh.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.hwe.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.bU(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hMR = (LinearLayout) this.hMJ.findViewById(e.g.video_activity_title_container);
        this.hMS = (ListView) this.hMJ.findViewById(e.g.video_activity_title_list);
        this.hMS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.hMR.setVisibility(8);
                b.this.hMO.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.hML.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.hML.requestFocus();
                    if (!TextUtils.isEmpty(b.this.hML.getText())) {
                        b.this.hML.setSelection(b.this.hML.getText().length());
                    }
                    l.b(b.this.hMJ, b.this.hML);
                }
            }
        });
        this.hMU = (LinearLayout) this.hMJ.findViewById(e.g.save_video_wrapper);
        this.hMV = (TextView) this.hMJ.findViewById(e.g.save_video_ridiobutton);
        this.hMW = (TextView) this.hMJ.findViewById(e.g.save_video_ridiotext);
        this.hMX = (TextView) this.hMJ.findViewById(e.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.hMJ) / l.h(this.hMJ, e.C0175e.ds440)) {
            i3 = l.aO(this.hMJ);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.hMJ, e.C0175e.ds440);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.hwe.setVideoHeight(i4);
        this.hwe.setVideoWidth(i3);
        this.hwe.invalidate();
    }

    private void initView() {
        this.hMP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.nav_close_layout, this.hMJ);
        this.mNavigationBar.setCenterTextTitle(this.hMJ.getPageContext().getString(e.j.post_video_title));
        this.hMK = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.nav_text_send_layout, this.hMJ);
        this.hMK.setText(e.j.send_post);
        this.hML.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hML.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.hMT != null && b.this.hMT.getCount() > 0) {
                    l.a(b.this.hMJ, b.this.hML);
                    b.this.hMR.setVisibility(0);
                    b.this.hMO.setVisibility(8);
                }
                long bMT = b.hMI - b.this.bMT();
                if (bMT >= 0) {
                    al.h(b.this.hMO, e.d.cp_cont_e);
                    b.this.hMO.setText(String.valueOf(bMT));
                    return;
                }
                b.this.hMO.setText("0");
                b.this.hML.setText(b.this.hML.getText().toString().substring(0, b.hMI));
                b.this.hML.setSelection(b.this.hML.getText().length());
                b.this.hMJ.showToast(b.this.hMJ.getResources().getString(e.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.hMQ != null) {
                    if (!b.this.hMQ.bLt()) {
                        b.this.ok(false);
                    }
                    b.this.hMQ.ob(false);
                }
            }
        });
        this.hMT = new a();
        this.hMS.setAdapter((ListAdapter) this.hMT);
        this.hMY = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hMY) {
            al.i(this.hMV, e.f.corner_bg_radio_selected);
        } else {
            al.i(this.hMV, e.f.corner_bg_radio_unselected);
        }
        al.h(this.hMW, e.d.cp_cont_g);
        this.hMU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hMY) {
                    b.this.hMY = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    al.i(b.this.hMV, e.f.corner_bg_radio_unselected);
                    b.this.hMV.invalidate();
                    return;
                }
                b.this.hMY = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                al.i(b.this.hMV, e.f.corner_bg_radio_selected);
                b.this.hMV.invalidate();
            }
        });
    }

    public void bMS() {
        if (this.hMX != null) {
            this.hMX.setVisibility(0);
        }
    }

    public void xb(String str) {
        int i;
        int i2 = 0;
        Bitmap uw = uw(str);
        if (uw != null && uw.getHeight() != 0) {
            if (uw.getHeight() <= 0) {
                i = 0;
            } else if (uw.getWidth() / uw.getHeight() > l.aO(this.hMJ) / l.h(this.hMJ, e.C0175e.ds440)) {
                i = l.aO(this.hMJ);
                if (uw.getWidth() > 0) {
                    i2 = (int) ((i / uw.getWidth()) * uw.getHeight());
                }
            } else {
                int h = l.h(this.hMJ, e.C0175e.ds440);
                if (uw.getWidth() > 0) {
                    i = (int) ((h / uw.getHeight()) * uw.getWidth());
                    i2 = h;
                } else {
                    i = 0;
                    i2 = h;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hwh.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hwh.setLayoutParams(layoutParams);
            this.hwh.setImageBitmap(uw);
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
        this.hMJ.getLayoutMode().setNightMode(i == 1);
        this.hMJ.getLayoutMode().onModeChanged(this.bWd);
        this.mNavigationBar.onChangeSkinType(this.hMJ.getPageContext(), i);
        al.c(this.hMP, e.f.icon_return_bg_s);
        al.c(this.hMK, e.d.cp_link_tip_a, 1);
        al.i(this.hMN, e.f.corner_bg);
        al.h(this.hMX, e.d.cp_cont_e);
        this.hMY = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hMY) {
            al.i(this.hMV, e.f.corner_bg_radio_selected);
        } else {
            al.i(this.hMV, e.f.corner_bg_radio_unselected);
        }
        if (this.hMN != null) {
            this.hMN.onChangeSkinType(i);
        }
        if (this.hMM != null) {
            this.hMM.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hML.getText() == null) {
            return null;
        }
        return this.hML.getText().toString();
    }

    public long bMT() {
        if (this.hML.getText() == null || this.hML.getText().toString() == null) {
            return 0L;
        }
        return this.hML.getText().length();
    }

    public WriteLocationView bMU() {
        return this.hMN;
    }

    public View bMV() {
        return this.hMK;
    }

    public View getBackButton() {
        return this.hMP;
    }

    public EditText bMW() {
        return this.hML;
    }

    public StateSwitchView bMX() {
        return this.hMM;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                xb(thumbPath);
                this.hwh.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hwh.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hwh.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.hwe.setVideoPath(videoPath);
                this.hwe.start();
            }
        }
        if (!v.J(list)) {
            this.hMT.eg(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hML.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hMT.eg(arrayList);
            this.hML.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bHW() {
        if (this.hwe != null) {
            this.hwe.resume();
            this.hwe.seekTo(this.hwo);
            this.hwe.start();
        }
    }

    public void aBK() {
        this.hwo = this.hwe.getCurrentPosition();
        if (this.hwe != null) {
            this.hwe.stopPlayback();
        }
    }

    public void xc(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hMJ.getResources().getString(e.j.post_to_home_page));
            bMY();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hMJ.getResources().getString(e.j.post_to) + str);
        bMZ();
    }

    private void bMY() {
        this.hMM = new StateSwitchView(this.hMJ);
        this.hMM.setStateString(this.hMJ.getString(e.j.public_to_all), this.hMJ.getString(e.j.public_to_me));
        this.hMM.setBackgroundId(e.f.state_switch_bg);
        this.hMM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hMM.apU();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.hMJ, e.C0175e.ds34), l.h(this.hMJ, e.C0175e.ds16));
        this.bWd.addView(this.hMM, layoutParams);
    }

    private void bMZ() {
        this.hMM = new StateSwitchView(this.hMJ);
        this.hMM.setStateString(this.hMJ.getString(e.j.display_to_home_page), this.hMJ.getString(e.j.display_to_home_page));
        this.hMM.setLeftStateDrawable(e.f.icon_share_home_select_ok, e.f.icon_share_home_select);
        this.hMM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hMM.apU();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.hMJ, e.C0175e.ds34), l.h(this.hMJ, e.C0175e.ds16));
        this.hMM.setTextSize(0, this.hMJ.getResources().getDimensionPixelSize(e.C0175e.ds28));
        this.bWd.addView(this.hMM, layoutParams);
    }

    public void bNa() {
        this.hMQ.aA(null);
        this.hMQ.oa(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hMQ.aA(postWriteCallBackData.getSensitiveWords());
            this.hMQ.wJ(postWriteCallBackData.getErrorString());
            if (!v.J(this.hMQ.bLq())) {
                ok(true);
            }
        }
    }

    public void ok(boolean z) {
        if (this.hML.getText() != null) {
            int selectionEnd = this.hML.getSelectionEnd();
            SpannableStringBuilder b = this.hMQ.b(this.hML.getText());
            if (b != null) {
                this.hMQ.ob(true);
                this.hML.setText(b);
                if (z && this.hMQ.bLr() >= 0) {
                    this.hML.requestFocus();
                    this.hML.setSelection(this.hMQ.bLr());
                } else {
                    this.hML.setSelection(selectionEnd);
                }
                this.hMQ.oa(this.hMQ.bLr() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bNb() {
        return this.hMQ;
    }

    public void ol(boolean z) {
        if (z) {
            this.hMR.setVisibility(8);
            this.hMO.setVisibility(0);
            this.bDf.smoothScrollTo(0, this.hMO.getBottom());
        }
    }
}
