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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.editor.StateSwitchView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static int jJJ = 60;
    private ScrollView bbv;
    private RelativeLayout dBc;
    private WriteVideoActivity jJK;
    private TextView jJL;
    private EditText jJM;
    private StateSwitchView jJN;
    private WriteLocationView jJO;
    private TextView jJP;
    private ImageView jJQ;
    private com.baidu.tieba.write.b jJR;
    private LinearLayout jJS;
    private ListView jJT;
    private a jJU;
    private LinearLayout jJV;
    private TextView jJW;
    private TextView jJX;
    private TextView jJY;
    private boolean jJZ = true;
    private CustomVideoView jsA;
    private ImageView jsD;
    private int jsK;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.jJK = writeVideoActivity;
        this.jJK.setContentView(R.layout.write_video_activity);
        this.jJR = new com.baidu.tieba.write.b();
        this.jJR.Cb(R.color.cp_btn_a);
        this.jJR.Cc(R.color.cp_cont_h_alpha85);
        cxU();
        initView();
    }

    private void cxU() {
        this.dBc = (RelativeLayout) this.jJK.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.jJK.findViewById(R.id.navigation_bar);
        this.jJM = (EditText) this.jJK.findViewById(R.id.edit_content);
        this.jJP = (TextView) this.jJK.findViewById(R.id.text_content_size);
        this.jsD = (ImageView) this.jJK.findViewById(R.id.video_cover);
        this.jJO = (WriteLocationView) this.jJK.findViewById(R.id.location);
        this.jsA = (CustomVideoView) this.jJK.findViewById(R.id.preview_videoview);
        this.bbv = (ScrollView) this.jJK.findViewById(R.id.write_scrollview);
        this.jsA.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.jsA.getWidth() != b.this.jsD.getWidth() || b.this.jsA.getHeight() != b.this.jsD.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.jsD.getLayoutParams();
                    layoutParams.width = b.this.jsA.getWidth();
                    layoutParams.height = b.this.jsA.getHeight();
                    b.this.jsD.setLayoutParams(layoutParams);
                }
                b.this.jsD.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jsA.start();
                        b.this.jsD.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.jsA.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cB(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jJS = (LinearLayout) this.jJK.findViewById(R.id.video_activity_title_container);
        this.jJT = (ListView) this.jJK.findViewById(R.id.video_activity_title_list);
        this.jJT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.jJS.setVisibility(8);
                b.this.jJP.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.jJM.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.jJM.requestFocus();
                    if (!TextUtils.isEmpty(b.this.jJM.getText())) {
                        b.this.jJM.setSelection(b.this.jJM.getText().length());
                    }
                    l.c(b.this.jJK, b.this.jJM);
                }
            }
        });
        this.jJV = (LinearLayout) this.jJK.findViewById(R.id.save_video_wrapper);
        this.jJW = (TextView) this.jJK.findViewById(R.id.save_video_ridiobutton);
        this.jJX = (TextView) this.jJK.findViewById(R.id.save_video_ridiotext);
        this.jJY = (TextView) this.jJK.findViewById(R.id.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.af(this.jJK) / l.g(this.jJK, R.dimen.ds440)) {
            i3 = l.af(this.jJK);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int g = l.g(this.jJK, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((g / i2) * i);
                i4 = g;
            } else {
                i3 = 0;
                i4 = g;
            }
        }
        this.jsA.setVideoHeight(i4);
        this.jsA.setVideoWidth(i3);
        this.jsA.invalidate();
    }

    private void initView() {
        this.jJQ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.jJK);
        this.mNavigationBar.setCenterTextTitle(this.jJK.getPageContext().getString(R.string.post_video_title));
        this.jJL = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.jJK);
        this.jJL.setText(R.string.send_post);
        this.jJM.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.jJM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.jJU != null && b.this.jJU.getCount() > 0) {
                    l.b(b.this.jJK, b.this.jJM);
                    b.this.jJS.setVisibility(0);
                    b.this.jJP.setVisibility(8);
                }
                long cxW = b.jJJ - b.this.cxW();
                if (cxW >= 0) {
                    al.j(b.this.jJP, R.color.cp_cont_e);
                    b.this.jJP.setText(String.valueOf(cxW));
                    return;
                }
                b.this.jJP.setText("0");
                b.this.jJM.setText(b.this.jJM.getText().toString().substring(0, b.jJJ));
                b.this.jJM.setSelection(b.this.jJM.getText().length());
                b.this.jJK.showToast(b.this.jJK.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.jJR != null) {
                    if (!b.this.jJR.cwf()) {
                        b.this.rT(false);
                    }
                    b.this.jJR.rK(false);
                }
            }
        });
        this.jJU = new a();
        this.jJT.setAdapter((ListAdapter) this.jJU);
        this.jJZ = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("write_video_activity_save_video", true);
        if (this.jJZ) {
            al.k(this.jJW, R.drawable.corner_bg_radio_selected);
        } else {
            al.k(this.jJW, R.drawable.corner_bg_radio_unselected);
        }
        al.j(this.jJX, R.color.cp_cont_g);
        this.jJV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jJZ) {
                    b.this.jJZ = false;
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("write_video_activity_save_video", false);
                    al.k(b.this.jJW, R.drawable.corner_bg_radio_unselected);
                    b.this.jJW.invalidate();
                    return;
                }
                b.this.jJZ = true;
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("write_video_activity_save_video", true);
                al.k(b.this.jJW, R.drawable.corner_bg_radio_selected);
                b.this.jJW.invalidate();
            }
        });
    }

    public void cxV() {
        if (this.jJY != null) {
            this.jJY.setVisibility(0);
        }
    }

    public void FW(String str) {
        int i;
        int i2 = 0;
        Bitmap Dv = Dv(str);
        if (Dv != null && Dv.getHeight() != 0) {
            if (Dv.getHeight() <= 0) {
                i = 0;
            } else if (Dv.getWidth() / Dv.getHeight() > l.af(this.jJK) / l.g(this.jJK, R.dimen.ds440)) {
                i = l.af(this.jJK);
                if (Dv.getWidth() > 0) {
                    i2 = (int) ((i / Dv.getWidth()) * Dv.getHeight());
                }
            } else {
                int g = l.g(this.jJK, R.dimen.ds440);
                if (Dv.getWidth() > 0) {
                    i = (int) ((g / Dv.getHeight()) * Dv.getWidth());
                    i2 = g;
                } else {
                    i = 0;
                    i2 = g;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jsD.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.jsD.setLayoutParams(layoutParams);
            this.jsD.setImageBitmap(Dv);
        }
    }

    private Bitmap Dv(String str) {
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
        this.jJK.getLayoutMode().setNightMode(i == 1);
        this.jJK.getLayoutMode().onModeChanged(this.dBc);
        this.mNavigationBar.onChangeSkinType(this.jJK.getPageContext(), i);
        al.c(this.jJQ, (int) R.drawable.icon_return_bg_s);
        al.f(this.jJL, R.color.cp_link_tip_a, 1);
        al.k(this.jJO, R.drawable.corner_bg);
        al.j(this.jJY, R.color.cp_cont_e);
        this.jJZ = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("write_video_activity_save_video", true);
        if (this.jJZ) {
            al.k(this.jJW, R.drawable.corner_bg_radio_selected);
        } else {
            al.k(this.jJW, R.drawable.corner_bg_radio_unselected);
        }
        if (this.jJO != null) {
            this.jJO.onChangeSkinType(i);
        }
        if (this.jJN != null) {
            this.jJN.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.jJM.getText() == null) {
            return null;
        }
        return this.jJM.getText().toString();
    }

    public long cxW() {
        if (this.jJM.getText() == null || this.jJM.getText().toString() == null) {
            return 0L;
        }
        return this.jJM.getText().length();
    }

    public WriteLocationView cxX() {
        return this.jJO;
    }

    public View cxY() {
        return this.jJL;
    }

    public View getBackButton() {
        return this.jJQ;
    }

    public EditText cxZ() {
        return this.jJM;
    }

    public StateSwitchView cya() {
        return this.jJN;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                FW(thumbPath);
                this.jsD.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jsD.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.jsD.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.jsA.setVideoPath(videoPath);
                this.jsA.start();
            }
        }
        if (!v.aa(list)) {
            this.jJU.ew(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.jJM.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.jJU.ew(arrayList);
            this.jJM.setText("#" + videoTitleData.name + "#");
        }
    }

    public void csA() {
        if (this.jsA != null) {
            this.jsA.resume();
            this.jsA.seekTo(this.jsK);
            this.jsA.start();
        }
    }

    public void bmc() {
        this.jsK = this.jsA.getCurrentPosition();
        if (this.jsA != null) {
            this.jsA.stopPlayback();
        }
    }

    public void FX(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.jJK.getResources().getString(R.string.post_to_home_page));
            cyb();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.jJK.getResources().getString(R.string.post_to) + str);
        cyc();
    }

    private void cyb() {
        this.jJN = new StateSwitchView(this.jJK);
        this.jJN.setStateString(this.jJK.getString(R.string.public_to_all), this.jJK.getString(R.string.public_to_me));
        this.jJN.setBackgroundId(R.drawable.state_switch_bg);
        this.jJN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jJN.aFr();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.g(this.jJK, R.dimen.ds34), l.g(this.jJK, R.dimen.ds16));
        this.dBc.addView(this.jJN, layoutParams);
    }

    private void cyc() {
        this.jJN = new StateSwitchView(this.jJK);
        this.jJN.setStateString(this.jJK.getString(R.string.display_to_home_page), this.jJK.getString(R.string.display_to_home_page));
        this.jJN.setLeftStateDrawable(R.drawable.icon_share_home_select_ok, R.drawable.icon_share_home_select);
        this.jJN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jJN.aFr();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.g(this.jJK, R.dimen.ds34), l.g(this.jJK, R.dimen.ds16));
        this.jJN.setTextSize(0, this.jJK.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.dBc.addView(this.jJN, layoutParams);
    }

    public void cyd() {
        this.jJR.aI(null);
        this.jJR.rJ(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jJR.aI(postWriteCallBackData.getSensitiveWords());
            this.jJR.FE(postWriteCallBackData.getErrorString());
            if (!v.aa(this.jJR.cwc())) {
                rT(true);
            }
        }
    }

    public void rT(boolean z) {
        if (this.jJM.getText() != null) {
            int selectionEnd = this.jJM.getSelectionEnd();
            SpannableStringBuilder b = this.jJR.b(this.jJM.getText());
            if (b != null) {
                this.jJR.rK(true);
                this.jJM.setText(b);
                if (z && this.jJR.cwd() >= 0) {
                    this.jJM.requestFocus();
                    this.jJM.setSelection(this.jJR.cwd());
                } else {
                    this.jJM.setSelection(selectionEnd);
                }
                this.jJR.rJ(this.jJR.cwd() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b cye() {
        return this.jJR;
    }

    public void rU(boolean z) {
        if (z) {
            this.jJS.setVisibility(8);
            this.jJP.setVisibility(0);
            this.bbv.smoothScrollTo(0, this.jJP.getBottom());
        }
    }
}
