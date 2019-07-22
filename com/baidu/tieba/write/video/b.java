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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.editor.StateSwitchView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static int jQO = 60;
    private ScrollView bcg;
    private RelativeLayout dEz;
    private WriteVideoActivity jQP;
    private TextView jQQ;
    private EditText jQR;
    private StateSwitchView jQS;
    private WriteLocationView jQT;
    private TextView jQU;
    private ImageView jQV;
    private com.baidu.tieba.write.b jQW;
    private LinearLayout jQX;
    private ListView jQY;
    private a jQZ;
    private LinearLayout jRa;
    private TextView jRb;
    private TextView jRc;
    private TextView jRd;
    private boolean jRe = true;
    private CustomVideoView jyM;
    private ImageView jyP;
    private int jyW;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.jQP = writeVideoActivity;
        this.jQP.setContentView(R.layout.write_video_activity);
        this.jQW = new com.baidu.tieba.write.b();
        this.jQW.CI(R.color.cp_btn_a);
        this.jQW.CJ(R.color.cp_cont_h_alpha85);
        cAT();
        initView();
    }

    private void cAT() {
        this.dEz = (RelativeLayout) this.jQP.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.jQP.findViewById(R.id.navigation_bar);
        this.jQR = (EditText) this.jQP.findViewById(R.id.edit_content);
        this.jQU = (TextView) this.jQP.findViewById(R.id.text_content_size);
        this.jyP = (ImageView) this.jQP.findViewById(R.id.video_cover);
        this.jQT = (WriteLocationView) this.jQP.findViewById(R.id.location);
        this.jyM = (CustomVideoView) this.jQP.findViewById(R.id.preview_videoview);
        this.bcg = (ScrollView) this.jQP.findViewById(R.id.write_scrollview);
        this.jyM.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.jyM.getWidth() != b.this.jyP.getWidth() || b.this.jyM.getHeight() != b.this.jyP.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.jyP.getLayoutParams();
                    layoutParams.width = b.this.jyM.getWidth();
                    layoutParams.height = b.this.jyM.getHeight();
                    b.this.jyP.setLayoutParams(layoutParams);
                }
                b.this.jyP.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jyM.start();
                        b.this.jyP.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.jyM.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cG(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jQX = (LinearLayout) this.jQP.findViewById(R.id.video_activity_title_container);
        this.jQY = (ListView) this.jQP.findViewById(R.id.video_activity_title_list);
        this.jQY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.jQX.setVisibility(8);
                b.this.jQU.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.jQR.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.jQR.requestFocus();
                    if (!TextUtils.isEmpty(b.this.jQR.getText())) {
                        b.this.jQR.setSelection(b.this.jQR.getText().length());
                    }
                    l.c(b.this.jQP, b.this.jQR);
                }
            }
        });
        this.jRa = (LinearLayout) this.jQP.findViewById(R.id.save_video_wrapper);
        this.jRb = (TextView) this.jQP.findViewById(R.id.save_video_ridiobutton);
        this.jRc = (TextView) this.jQP.findViewById(R.id.save_video_ridiotext);
        this.jRd = (TextView) this.jQP.findViewById(R.id.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.af(this.jQP) / l.g(this.jQP, R.dimen.ds440)) {
            i3 = l.af(this.jQP);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int g = l.g(this.jQP, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((g / i2) * i);
                i4 = g;
            } else {
                i3 = 0;
                i4 = g;
            }
        }
        this.jyM.setVideoHeight(i4);
        this.jyM.setVideoWidth(i3);
        this.jyM.invalidate();
    }

    private void initView() {
        this.jQV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.jQP);
        this.mNavigationBar.setCenterTextTitle(this.jQP.getPageContext().getString(R.string.post_video_title));
        this.jQQ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.jQP);
        this.jQQ.setText(R.string.send_post);
        this.jQR.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.jQR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.jQZ != null && b.this.jQZ.getCount() > 0) {
                    l.b(b.this.jQP, b.this.jQR);
                    b.this.jQX.setVisibility(0);
                    b.this.jQU.setVisibility(8);
                }
                long cAV = b.jQO - b.this.cAV();
                if (cAV >= 0) {
                    am.j(b.this.jQU, R.color.cp_cont_e);
                    b.this.jQU.setText(String.valueOf(cAV));
                    return;
                }
                b.this.jQU.setText("0");
                b.this.jQR.setText(b.this.jQR.getText().toString().substring(0, b.jQO));
                b.this.jQR.setSelection(b.this.jQR.getText().length());
                b.this.jQP.showToast(b.this.jQP.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.jQW != null) {
                    if (!b.this.jQW.czh()) {
                        b.this.sj(false);
                    }
                    b.this.jQW.sa(false);
                }
            }
        });
        this.jQZ = new a();
        this.jQY.setAdapter((ListAdapter) this.jQZ);
        this.jRe = com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("write_video_activity_save_video", true);
        if (this.jRe) {
            am.k(this.jRb, R.drawable.corner_bg_radio_selected);
        } else {
            am.k(this.jRb, R.drawable.corner_bg_radio_unselected);
        }
        am.j(this.jRc, R.color.cp_cont_g);
        this.jRa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jRe) {
                    b.this.jRe = false;
                    com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("write_video_activity_save_video", false);
                    am.k(b.this.jRb, R.drawable.corner_bg_radio_unselected);
                    b.this.jRb.invalidate();
                    return;
                }
                b.this.jRe = true;
                com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("write_video_activity_save_video", true);
                am.k(b.this.jRb, R.drawable.corner_bg_radio_selected);
                b.this.jRb.invalidate();
            }
        });
    }

    public void cAU() {
        if (this.jRd != null) {
            this.jRd.setVisibility(0);
        }
    }

    public void GS(String str) {
        int i;
        int i2 = 0;
        Bitmap Ek = Ek(str);
        if (Ek != null && Ek.getHeight() != 0) {
            if (Ek.getHeight() <= 0) {
                i = 0;
            } else if (Ek.getWidth() / Ek.getHeight() > l.af(this.jQP) / l.g(this.jQP, R.dimen.ds440)) {
                i = l.af(this.jQP);
                if (Ek.getWidth() > 0) {
                    i2 = (int) ((i / Ek.getWidth()) * Ek.getHeight());
                }
            } else {
                int g = l.g(this.jQP, R.dimen.ds440);
                if (Ek.getWidth() > 0) {
                    i = (int) ((g / Ek.getHeight()) * Ek.getWidth());
                    i2 = g;
                } else {
                    i = 0;
                    i2 = g;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jyP.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.jyP.setLayoutParams(layoutParams);
            this.jyP.setImageBitmap(Ek);
        }
    }

    private Bitmap Ek(String str) {
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

    public TextView getCenterTitleView() {
        return this.mNavigationBar.mCenterText;
    }

    public void onChangeSkinType(int i) {
        this.jQP.getLayoutMode().setNightMode(i == 1);
        this.jQP.getLayoutMode().onModeChanged(this.dEz);
        this.mNavigationBar.onChangeSkinType(this.jQP.getPageContext(), i);
        am.c(this.jQV, (int) R.drawable.icon_return_bg_s);
        am.f(this.jQQ, R.color.cp_link_tip_a, 1);
        am.k(this.jQT, R.drawable.corner_bg);
        am.j(this.jRd, R.color.cp_cont_e);
        this.jRe = com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("write_video_activity_save_video", true);
        if (this.jRe) {
            am.k(this.jRb, R.drawable.corner_bg_radio_selected);
        } else {
            am.k(this.jRb, R.drawable.corner_bg_radio_unselected);
        }
        if (this.jQT != null) {
            this.jQT.onChangeSkinType(i);
        }
        if (this.jQS != null) {
            this.jQS.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.jQR.getText() == null) {
            return null;
        }
        return this.jQR.getText().toString();
    }

    public long cAV() {
        if (this.jQR.getText() == null || this.jQR.getText().toString() == null) {
            return 0L;
        }
        return this.jQR.getText().length();
    }

    public WriteLocationView cAW() {
        return this.jQT;
    }

    public View cAX() {
        return this.jQQ;
    }

    public View getBackButton() {
        return this.jQV;
    }

    public EditText cAY() {
        return this.jQR;
    }

    public StateSwitchView cAZ() {
        return this.jQS;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                GS(thumbPath);
                this.jyP.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jyP.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.jyP.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.jyM.setVideoPath(videoPath);
                this.jyM.start();
            }
        }
        if (!v.aa(list)) {
            this.jQZ.ez(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.jQR.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.jQZ.ez(arrayList);
            this.jQR.setText("#" + videoTitleData.name + "#");
        }
    }

    public void cvo() {
        if (this.jyM != null) {
            this.jyM.resume();
            this.jyM.seekTo(this.jyW);
            this.jyM.start();
        }
    }

    public void bog() {
        this.jyW = this.jyM.getCurrentPosition();
        if (this.jyM != null) {
            this.jyM.stopPlayback();
        }
    }

    public void GT(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.jQP.getResources().getString(R.string.post_to_home_page));
            cBa();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.jQP.getResources().getString(R.string.post_to) + str);
        cBb();
    }

    private void cBa() {
        this.jQS = new StateSwitchView(this.jQP);
        this.jQS.setStateString(this.jQP.getString(R.string.public_to_all), this.jQP.getString(R.string.public_to_me));
        this.jQS.setBackgroundId(R.drawable.state_switch_bg);
        this.jQS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jQS.aGQ();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.g(this.jQP, R.dimen.ds34), l.g(this.jQP, R.dimen.ds16));
        this.dEz.addView(this.jQS, layoutParams);
    }

    private void cBb() {
        this.jQS = new StateSwitchView(this.jQP);
        this.jQS.setStateString(this.jQP.getString(R.string.display_to_home_page), this.jQP.getString(R.string.display_to_home_page));
        this.jQS.setLeftStateDrawable(R.drawable.icon_share_home_select_ok, R.drawable.icon_share_home_select);
        this.jQS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jQS.aGQ();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.g(this.jQP, R.dimen.ds34), l.g(this.jQP, R.dimen.ds16));
        this.jQS.setTextSize(0, this.jQP.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.dEz.addView(this.jQS, layoutParams);
    }

    public void cBc() {
        this.jQW.aI(null);
        this.jQW.rZ(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jQW.aI(postWriteCallBackData.getSensitiveWords());
            this.jQW.GA(postWriteCallBackData.getErrorString());
            if (!v.aa(this.jQW.cze())) {
                sj(true);
            }
        }
    }

    public void sj(boolean z) {
        if (this.jQR.getText() != null) {
            int selectionEnd = this.jQR.getSelectionEnd();
            SpannableStringBuilder b = this.jQW.b(this.jQR.getText());
            if (b != null) {
                this.jQW.sa(true);
                this.jQR.setText(b);
                if (z && this.jQW.czf() >= 0) {
                    this.jQR.requestFocus();
                    this.jQR.setSelection(this.jQW.czf());
                } else {
                    this.jQR.setSelection(selectionEnd);
                }
                this.jQW.rZ(this.jQW.czf() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b cBd() {
        return this.jQW;
    }

    public void sk(boolean z) {
        if (z) {
            this.jQX.setVisibility(8);
            this.jQU.setVisibility(0);
            this.bcg.smoothScrollTo(0, this.jQU.getBottom());
        }
    }
}
