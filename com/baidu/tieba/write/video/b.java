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
    public static int hYN = 60;
    private ScrollView bHx;
    private RelativeLayout caK;
    private CustomVideoView hIk;
    private ImageView hIn;
    private int hIu;
    private WriteVideoActivity hYO;
    private TextView hYP;
    private EditText hYQ;
    private StateSwitchView hYR;
    private WriteLocationView hYS;
    private TextView hYT;
    private ImageView hYU;
    private com.baidu.tieba.write.b hYV;
    private LinearLayout hYW;
    private ListView hYX;
    private a hYY;
    private LinearLayout hYZ;
    private TextView hZa;
    private TextView hZb;
    private TextView hZc;
    private boolean hZd = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.hYO = writeVideoActivity;
        this.hYO.setContentView(e.h.write_video_activity);
        this.hYV = new com.baidu.tieba.write.b();
        this.hYV.xi(e.d.cp_cont_i);
        this.hYV.xj(e.d.cp_cont_h_alpha85);
        bPm();
        initView();
    }

    private void bPm() {
        this.caK = (RelativeLayout) this.hYO.findViewById(e.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hYO.findViewById(e.g.navigation_bar);
        this.hYQ = (EditText) this.hYO.findViewById(e.g.edit_content);
        this.hYT = (TextView) this.hYO.findViewById(e.g.text_content_size);
        this.hIn = (ImageView) this.hYO.findViewById(e.g.video_cover);
        this.hYS = (WriteLocationView) this.hYO.findViewById(e.g.location);
        this.hIk = (CustomVideoView) this.hYO.findViewById(e.g.preview_videoview);
        this.bHx = (ScrollView) this.hYO.findViewById(e.g.write_scrollview);
        this.hIk.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.hIk.getWidth() != b.this.hIn.getWidth() || b.this.hIk.getHeight() != b.this.hIn.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.hIn.getLayoutParams();
                    layoutParams.width = b.this.hIk.getWidth();
                    layoutParams.height = b.this.hIk.getHeight();
                    b.this.hIn.setLayoutParams(layoutParams);
                }
                b.this.hIn.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hIk.start();
                        b.this.hIn.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.hIk.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.bX(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hYW = (LinearLayout) this.hYO.findViewById(e.g.video_activity_title_container);
        this.hYX = (ListView) this.hYO.findViewById(e.g.video_activity_title_list);
        this.hYX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.hYW.setVisibility(8);
                b.this.hYT.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.hYQ.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.hYQ.requestFocus();
                    if (!TextUtils.isEmpty(b.this.hYQ.getText())) {
                        b.this.hYQ.setSelection(b.this.hYQ.getText().length());
                    }
                    l.c(b.this.hYO, b.this.hYQ);
                }
            }
        });
        this.hYZ = (LinearLayout) this.hYO.findViewById(e.g.save_video_wrapper);
        this.hZa = (TextView) this.hYO.findViewById(e.g.save_video_ridiobutton);
        this.hZb = (TextView) this.hYO.findViewById(e.g.save_video_ridiotext);
        this.hZc = (TextView) this.hYO.findViewById(e.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.hYO) / l.h(this.hYO, e.C0210e.ds440)) {
            i3 = l.aO(this.hYO);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.hYO, e.C0210e.ds440);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.hIk.setVideoHeight(i4);
        this.hIk.setVideoWidth(i3);
        this.hIk.invalidate();
    }

    private void initView() {
        this.hYU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.nav_close_layout, this.hYO);
        this.mNavigationBar.setCenterTextTitle(this.hYO.getPageContext().getString(e.j.post_video_title));
        this.hYP = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.nav_text_send_layout, this.hYO);
        this.hYP.setText(e.j.send_post);
        this.hYQ.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hYQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.hYY != null && b.this.hYY.getCount() > 0) {
                    l.b(b.this.hYO, b.this.hYQ);
                    b.this.hYW.setVisibility(0);
                    b.this.hYT.setVisibility(8);
                }
                long bPo = b.hYN - b.this.bPo();
                if (bPo >= 0) {
                    al.h(b.this.hYT, e.d.cp_cont_e);
                    b.this.hYT.setText(String.valueOf(bPo));
                    return;
                }
                b.this.hYT.setText("0");
                b.this.hYQ.setText(b.this.hYQ.getText().toString().substring(0, b.hYN));
                b.this.hYQ.setSelection(b.this.hYQ.getText().length());
                b.this.hYO.showToast(b.this.hYO.getResources().getString(e.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.hYV != null) {
                    if (!b.this.hYV.bNO()) {
                        b.this.oD(false);
                    }
                    b.this.hYV.ou(false);
                }
            }
        });
        this.hYY = new a();
        this.hYX.setAdapter((ListAdapter) this.hYY);
        this.hZd = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hZd) {
            al.i(this.hZa, e.f.corner_bg_radio_selected);
        } else {
            al.i(this.hZa, e.f.corner_bg_radio_unselected);
        }
        al.h(this.hZb, e.d.cp_cont_g);
        this.hYZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hZd) {
                    b.this.hZd = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    al.i(b.this.hZa, e.f.corner_bg_radio_unselected);
                    b.this.hZa.invalidate();
                    return;
                }
                b.this.hZd = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                al.i(b.this.hZa, e.f.corner_bg_radio_selected);
                b.this.hZa.invalidate();
            }
        });
    }

    public void bPn() {
        if (this.hZc != null) {
            this.hZc.setVisibility(0);
        }
    }

    public void xM(String str) {
        int i;
        int i2 = 0;
        Bitmap ve = ve(str);
        if (ve != null && ve.getHeight() != 0) {
            if (ve.getHeight() <= 0) {
                i = 0;
            } else if (ve.getWidth() / ve.getHeight() > l.aO(this.hYO) / l.h(this.hYO, e.C0210e.ds440)) {
                i = l.aO(this.hYO);
                if (ve.getWidth() > 0) {
                    i2 = (int) ((i / ve.getWidth()) * ve.getHeight());
                }
            } else {
                int h = l.h(this.hYO, e.C0210e.ds440);
                if (ve.getWidth() > 0) {
                    i = (int) ((h / ve.getHeight()) * ve.getWidth());
                    i2 = h;
                } else {
                    i = 0;
                    i2 = h;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hIn.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hIn.setLayoutParams(layoutParams);
            this.hIn.setImageBitmap(ve);
        }
    }

    private Bitmap ve(String str) {
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
        this.hYO.getLayoutMode().setNightMode(i == 1);
        this.hYO.getLayoutMode().onModeChanged(this.caK);
        this.mNavigationBar.onChangeSkinType(this.hYO.getPageContext(), i);
        al.c(this.hYU, e.f.icon_return_bg_s);
        al.c(this.hYP, e.d.cp_link_tip_a, 1);
        al.i(this.hYS, e.f.corner_bg);
        al.h(this.hZc, e.d.cp_cont_e);
        this.hZd = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hZd) {
            al.i(this.hZa, e.f.corner_bg_radio_selected);
        } else {
            al.i(this.hZa, e.f.corner_bg_radio_unselected);
        }
        if (this.hYS != null) {
            this.hYS.onChangeSkinType(i);
        }
        if (this.hYR != null) {
            this.hYR.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hYQ.getText() == null) {
            return null;
        }
        return this.hYQ.getText().toString();
    }

    public long bPo() {
        if (this.hYQ.getText() == null || this.hYQ.getText().toString() == null) {
            return 0L;
        }
        return this.hYQ.getText().length();
    }

    public WriteLocationView bPp() {
        return this.hYS;
    }

    public View bPq() {
        return this.hYP;
    }

    public View getBackButton() {
        return this.hYU;
    }

    public EditText bPr() {
        return this.hYQ;
    }

    public StateSwitchView bPs() {
        return this.hYR;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                xM(thumbPath);
                this.hIn.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hIn.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hIn.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.hIk.setVideoPath(videoPath);
                this.hIk.start();
            }
        }
        if (!v.I(list)) {
            this.hYY.ej(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hYQ.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hYY.ej(arrayList);
            this.hYQ.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bKp() {
        if (this.hIk != null) {
            this.hIk.resume();
            this.hIk.seekTo(this.hIu);
            this.hIk.start();
        }
    }

    public void aDG() {
        this.hIu = this.hIk.getCurrentPosition();
        if (this.hIk != null) {
            this.hIk.stopPlayback();
        }
    }

    public void xN(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hYO.getResources().getString(e.j.post_to_home_page));
            bPt();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hYO.getResources().getString(e.j.post_to) + str);
        bPu();
    }

    private void bPt() {
        this.hYR = new StateSwitchView(this.hYO);
        this.hYR.setStateString(this.hYO.getString(e.j.public_to_all), this.hYO.getString(e.j.public_to_me));
        this.hYR.setBackgroundId(e.f.state_switch_bg);
        this.hYR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hYR.arW();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.hYO, e.C0210e.ds34), l.h(this.hYO, e.C0210e.ds16));
        this.caK.addView(this.hYR, layoutParams);
    }

    private void bPu() {
        this.hYR = new StateSwitchView(this.hYO);
        this.hYR.setStateString(this.hYO.getString(e.j.display_to_home_page), this.hYO.getString(e.j.display_to_home_page));
        this.hYR.setLeftStateDrawable(e.f.icon_share_home_select_ok, e.f.icon_share_home_select);
        this.hYR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hYR.arW();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.hYO, e.C0210e.ds34), l.h(this.hYO, e.C0210e.ds16));
        this.hYR.setTextSize(0, this.hYO.getResources().getDimensionPixelSize(e.C0210e.ds28));
        this.caK.addView(this.hYR, layoutParams);
    }

    public void bPv() {
        this.hYV.aA(null);
        this.hYV.ot(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hYV.aA(postWriteCallBackData.getSensitiveWords());
            this.hYV.xu(postWriteCallBackData.getErrorString());
            if (!v.I(this.hYV.bNL())) {
                oD(true);
            }
        }
    }

    public void oD(boolean z) {
        if (this.hYQ.getText() != null) {
            int selectionEnd = this.hYQ.getSelectionEnd();
            SpannableStringBuilder b = this.hYV.b(this.hYQ.getText());
            if (b != null) {
                this.hYV.ou(true);
                this.hYQ.setText(b);
                if (z && this.hYV.bNM() >= 0) {
                    this.hYQ.requestFocus();
                    this.hYQ.setSelection(this.hYV.bNM());
                } else {
                    this.hYQ.setSelection(selectionEnd);
                }
                this.hYV.ot(this.hYV.bNM() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bPw() {
        return this.hYV;
    }

    public void oE(boolean z) {
        if (z) {
            this.hYW.setVisibility(8);
            this.hYT.setVisibility(0);
            this.bHx.smoothScrollTo(0, this.hYT.getBottom());
        }
    }
}
