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
    public static int jRU = 60;
    private ScrollView bcg;
    private RelativeLayout dEG;
    private int jAd;
    private WriteVideoActivity jRV;
    private TextView jRW;
    private EditText jRX;
    private StateSwitchView jRY;
    private WriteLocationView jRZ;
    private TextView jSa;
    private ImageView jSb;
    private com.baidu.tieba.write.b jSc;
    private LinearLayout jSd;
    private ListView jSe;
    private a jSf;
    private LinearLayout jSg;
    private TextView jSh;
    private TextView jSi;
    private TextView jSj;
    private boolean jSk = true;
    private CustomVideoView jzT;
    private ImageView jzW;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.jRV = writeVideoActivity;
        this.jRV.setContentView(R.layout.write_video_activity);
        this.jSc = new com.baidu.tieba.write.b();
        this.jSc.CK(R.color.cp_btn_a);
        this.jSc.CL(R.color.cp_cont_h_alpha85);
        cBo();
        initView();
    }

    private void cBo() {
        this.dEG = (RelativeLayout) this.jRV.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.jRV.findViewById(R.id.navigation_bar);
        this.jRX = (EditText) this.jRV.findViewById(R.id.edit_content);
        this.jSa = (TextView) this.jRV.findViewById(R.id.text_content_size);
        this.jzW = (ImageView) this.jRV.findViewById(R.id.video_cover);
        this.jRZ = (WriteLocationView) this.jRV.findViewById(R.id.location);
        this.jzT = (CustomVideoView) this.jRV.findViewById(R.id.preview_videoview);
        this.bcg = (ScrollView) this.jRV.findViewById(R.id.write_scrollview);
        this.jzT.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.jzT.getWidth() != b.this.jzW.getWidth() || b.this.jzT.getHeight() != b.this.jzW.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.jzW.getLayoutParams();
                    layoutParams.width = b.this.jzT.getWidth();
                    layoutParams.height = b.this.jzT.getHeight();
                    b.this.jzW.setLayoutParams(layoutParams);
                }
                b.this.jzW.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jzT.start();
                        b.this.jzW.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.jzT.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cG(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jSd = (LinearLayout) this.jRV.findViewById(R.id.video_activity_title_container);
        this.jSe = (ListView) this.jRV.findViewById(R.id.video_activity_title_list);
        this.jSe.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.jSd.setVisibility(8);
                b.this.jSa.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.jRX.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.jRX.requestFocus();
                    if (!TextUtils.isEmpty(b.this.jRX.getText())) {
                        b.this.jRX.setSelection(b.this.jRX.getText().length());
                    }
                    l.c(b.this.jRV, b.this.jRX);
                }
            }
        });
        this.jSg = (LinearLayout) this.jRV.findViewById(R.id.save_video_wrapper);
        this.jSh = (TextView) this.jRV.findViewById(R.id.save_video_ridiobutton);
        this.jSi = (TextView) this.jRV.findViewById(R.id.save_video_ridiotext);
        this.jSj = (TextView) this.jRV.findViewById(R.id.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.af(this.jRV) / l.g(this.jRV, R.dimen.ds440)) {
            i3 = l.af(this.jRV);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int g = l.g(this.jRV, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((g / i2) * i);
                i4 = g;
            } else {
                i3 = 0;
                i4 = g;
            }
        }
        this.jzT.setVideoHeight(i4);
        this.jzT.setVideoWidth(i3);
        this.jzT.invalidate();
    }

    private void initView() {
        this.jSb = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.jRV);
        this.mNavigationBar.setCenterTextTitle(this.jRV.getPageContext().getString(R.string.post_video_title));
        this.jRW = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.jRV);
        this.jRW.setText(R.string.send_post);
        this.jRX.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.jRX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.jSf != null && b.this.jSf.getCount() > 0) {
                    l.b(b.this.jRV, b.this.jRX);
                    b.this.jSd.setVisibility(0);
                    b.this.jSa.setVisibility(8);
                }
                long cBq = b.jRU - b.this.cBq();
                if (cBq >= 0) {
                    am.j(b.this.jSa, R.color.cp_cont_e);
                    b.this.jSa.setText(String.valueOf(cBq));
                    return;
                }
                b.this.jSa.setText("0");
                b.this.jRX.setText(b.this.jRX.getText().toString().substring(0, b.jRU));
                b.this.jRX.setSelection(b.this.jRX.getText().length());
                b.this.jRV.showToast(b.this.jRV.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.jSc != null) {
                    if (!b.this.jSc.czC()) {
                        b.this.sk(false);
                    }
                    b.this.jSc.sb(false);
                }
            }
        });
        this.jSf = new a();
        this.jSe.setAdapter((ListAdapter) this.jSf);
        this.jSk = com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("write_video_activity_save_video", true);
        if (this.jSk) {
            am.k(this.jSh, R.drawable.corner_bg_radio_selected);
        } else {
            am.k(this.jSh, R.drawable.corner_bg_radio_unselected);
        }
        am.j(this.jSi, R.color.cp_cont_g);
        this.jSg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jSk) {
                    b.this.jSk = false;
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("write_video_activity_save_video", false);
                    am.k(b.this.jSh, R.drawable.corner_bg_radio_unselected);
                    b.this.jSh.invalidate();
                    return;
                }
                b.this.jSk = true;
                com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("write_video_activity_save_video", true);
                am.k(b.this.jSh, R.drawable.corner_bg_radio_selected);
                b.this.jSh.invalidate();
            }
        });
    }

    public void cBp() {
        if (this.jSj != null) {
            this.jSj.setVisibility(0);
        }
    }

    public void GT(String str) {
        int i;
        int i2 = 0;
        Bitmap El = El(str);
        if (El != null && El.getHeight() != 0) {
            if (El.getHeight() <= 0) {
                i = 0;
            } else if (El.getWidth() / El.getHeight() > l.af(this.jRV) / l.g(this.jRV, R.dimen.ds440)) {
                i = l.af(this.jRV);
                if (El.getWidth() > 0) {
                    i2 = (int) ((i / El.getWidth()) * El.getHeight());
                }
            } else {
                int g = l.g(this.jRV, R.dimen.ds440);
                if (El.getWidth() > 0) {
                    i = (int) ((g / El.getHeight()) * El.getWidth());
                    i2 = g;
                } else {
                    i = 0;
                    i2 = g;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jzW.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.jzW.setLayoutParams(layoutParams);
            this.jzW.setImageBitmap(El);
        }
    }

    private Bitmap El(String str) {
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
        this.jRV.getLayoutMode().setNightMode(i == 1);
        this.jRV.getLayoutMode().onModeChanged(this.dEG);
        this.mNavigationBar.onChangeSkinType(this.jRV.getPageContext(), i);
        am.c(this.jSb, (int) R.drawable.icon_return_bg_s);
        am.f(this.jRW, R.color.cp_link_tip_a, 1);
        am.k(this.jRZ, R.drawable.corner_bg);
        am.j(this.jSj, R.color.cp_cont_e);
        this.jSk = com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("write_video_activity_save_video", true);
        if (this.jSk) {
            am.k(this.jSh, R.drawable.corner_bg_radio_selected);
        } else {
            am.k(this.jSh, R.drawable.corner_bg_radio_unselected);
        }
        if (this.jRZ != null) {
            this.jRZ.onChangeSkinType(i);
        }
        if (this.jRY != null) {
            this.jRY.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.jRX.getText() == null) {
            return null;
        }
        return this.jRX.getText().toString();
    }

    public long cBq() {
        if (this.jRX.getText() == null || this.jRX.getText().toString() == null) {
            return 0L;
        }
        return this.jRX.getText().length();
    }

    public WriteLocationView cBr() {
        return this.jRZ;
    }

    public View cBs() {
        return this.jRW;
    }

    public View getBackButton() {
        return this.jSb;
    }

    public EditText cBt() {
        return this.jRX;
    }

    public StateSwitchView cBu() {
        return this.jRY;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                GT(thumbPath);
                this.jzW.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jzW.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.jzW.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.jzT.setVideoPath(videoPath);
                this.jzT.start();
            }
        }
        if (!v.aa(list)) {
            this.jSf.ey(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.jRX.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.jSf.ey(arrayList);
            this.jRX.setText("#" + videoTitleData.name + "#");
        }
    }

    public void cvK() {
        if (this.jzT != null) {
            this.jzT.resume();
            this.jzT.seekTo(this.jAd);
            this.jzT.start();
        }
    }

    public void bot() {
        this.jAd = this.jzT.getCurrentPosition();
        if (this.jzT != null) {
            this.jzT.stopPlayback();
        }
    }

    public void GU(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.jRV.getResources().getString(R.string.post_to_home_page));
            cBv();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.jRV.getResources().getString(R.string.post_to) + str);
        cBw();
    }

    private void cBv() {
        this.jRY = new StateSwitchView(this.jRV);
        this.jRY.setStateString(this.jRV.getString(R.string.public_to_all), this.jRV.getString(R.string.public_to_me));
        this.jRY.setBackgroundId(R.drawable.state_switch_bg);
        this.jRY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jRY.aGS();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.g(this.jRV, R.dimen.ds34), l.g(this.jRV, R.dimen.ds16));
        this.dEG.addView(this.jRY, layoutParams);
    }

    private void cBw() {
        this.jRY = new StateSwitchView(this.jRV);
        this.jRY.setStateString(this.jRV.getString(R.string.display_to_home_page), this.jRV.getString(R.string.display_to_home_page));
        this.jRY.setLeftStateDrawable(R.drawable.icon_share_home_select_ok, R.drawable.icon_share_home_select);
        this.jRY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jRY.aGS();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.g(this.jRV, R.dimen.ds34), l.g(this.jRV, R.dimen.ds16));
        this.jRY.setTextSize(0, this.jRV.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.dEG.addView(this.jRY, layoutParams);
    }

    public void cBx() {
        this.jSc.aI(null);
        this.jSc.sa(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jSc.aI(postWriteCallBackData.getSensitiveWords());
            this.jSc.GB(postWriteCallBackData.getErrorString());
            if (!v.aa(this.jSc.czz())) {
                sk(true);
            }
        }
    }

    public void sk(boolean z) {
        if (this.jRX.getText() != null) {
            int selectionEnd = this.jRX.getSelectionEnd();
            SpannableStringBuilder b = this.jSc.b(this.jRX.getText());
            if (b != null) {
                this.jSc.sb(true);
                this.jRX.setText(b);
                if (z && this.jSc.czA() >= 0) {
                    this.jRX.requestFocus();
                    this.jRX.setSelection(this.jSc.czA());
                } else {
                    this.jRX.setSelection(selectionEnd);
                }
                this.jSc.sa(this.jSc.czA() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b cBy() {
        return this.jSc;
    }

    public void sl(boolean z) {
        if (z) {
            this.jSd.setVisibility(8);
            this.jSa.setVisibility(0);
            this.bcg.smoothScrollTo(0, this.jSa.getBottom());
        }
    }
}
