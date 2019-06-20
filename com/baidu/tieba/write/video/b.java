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
    public static int jJN = 60;
    private ScrollView bbv;
    private RelativeLayout dBd;
    private WriteVideoActivity jJO;
    private TextView jJP;
    private EditText jJQ;
    private StateSwitchView jJR;
    private WriteLocationView jJS;
    private TextView jJT;
    private ImageView jJU;
    private com.baidu.tieba.write.b jJV;
    private LinearLayout jJW;
    private ListView jJX;
    private a jJY;
    private LinearLayout jJZ;
    private TextView jKa;
    private TextView jKb;
    private TextView jKc;
    private boolean jKd = true;
    private CustomVideoView jsE;
    private ImageView jsH;
    private int jsO;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.jJO = writeVideoActivity;
        this.jJO.setContentView(R.layout.write_video_activity);
        this.jJV = new com.baidu.tieba.write.b();
        this.jJV.Cb(R.color.cp_btn_a);
        this.jJV.Cc(R.color.cp_cont_h_alpha85);
        cxV();
        initView();
    }

    private void cxV() {
        this.dBd = (RelativeLayout) this.jJO.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.jJO.findViewById(R.id.navigation_bar);
        this.jJQ = (EditText) this.jJO.findViewById(R.id.edit_content);
        this.jJT = (TextView) this.jJO.findViewById(R.id.text_content_size);
        this.jsH = (ImageView) this.jJO.findViewById(R.id.video_cover);
        this.jJS = (WriteLocationView) this.jJO.findViewById(R.id.location);
        this.jsE = (CustomVideoView) this.jJO.findViewById(R.id.preview_videoview);
        this.bbv = (ScrollView) this.jJO.findViewById(R.id.write_scrollview);
        this.jsE.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.jsE.getWidth() != b.this.jsH.getWidth() || b.this.jsE.getHeight() != b.this.jsH.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.jsH.getLayoutParams();
                    layoutParams.width = b.this.jsE.getWidth();
                    layoutParams.height = b.this.jsE.getHeight();
                    b.this.jsH.setLayoutParams(layoutParams);
                }
                b.this.jsH.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jsE.start();
                        b.this.jsH.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.jsE.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cB(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jJW = (LinearLayout) this.jJO.findViewById(R.id.video_activity_title_container);
        this.jJX = (ListView) this.jJO.findViewById(R.id.video_activity_title_list);
        this.jJX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.jJW.setVisibility(8);
                b.this.jJT.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.jJQ.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.jJQ.requestFocus();
                    if (!TextUtils.isEmpty(b.this.jJQ.getText())) {
                        b.this.jJQ.setSelection(b.this.jJQ.getText().length());
                    }
                    l.c(b.this.jJO, b.this.jJQ);
                }
            }
        });
        this.jJZ = (LinearLayout) this.jJO.findViewById(R.id.save_video_wrapper);
        this.jKa = (TextView) this.jJO.findViewById(R.id.save_video_ridiobutton);
        this.jKb = (TextView) this.jJO.findViewById(R.id.save_video_ridiotext);
        this.jKc = (TextView) this.jJO.findViewById(R.id.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.af(this.jJO) / l.g(this.jJO, R.dimen.ds440)) {
            i3 = l.af(this.jJO);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int g = l.g(this.jJO, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((g / i2) * i);
                i4 = g;
            } else {
                i3 = 0;
                i4 = g;
            }
        }
        this.jsE.setVideoHeight(i4);
        this.jsE.setVideoWidth(i3);
        this.jsE.invalidate();
    }

    private void initView() {
        this.jJU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.jJO);
        this.mNavigationBar.setCenterTextTitle(this.jJO.getPageContext().getString(R.string.post_video_title));
        this.jJP = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.jJO);
        this.jJP.setText(R.string.send_post);
        this.jJQ.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.jJQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.jJY != null && b.this.jJY.getCount() > 0) {
                    l.b(b.this.jJO, b.this.jJQ);
                    b.this.jJW.setVisibility(0);
                    b.this.jJT.setVisibility(8);
                }
                long cxX = b.jJN - b.this.cxX();
                if (cxX >= 0) {
                    al.j(b.this.jJT, R.color.cp_cont_e);
                    b.this.jJT.setText(String.valueOf(cxX));
                    return;
                }
                b.this.jJT.setText("0");
                b.this.jJQ.setText(b.this.jJQ.getText().toString().substring(0, b.jJN));
                b.this.jJQ.setSelection(b.this.jJQ.getText().length());
                b.this.jJO.showToast(b.this.jJO.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.jJV != null) {
                    if (!b.this.jJV.cwg()) {
                        b.this.rU(false);
                    }
                    b.this.jJV.rL(false);
                }
            }
        });
        this.jJY = new a();
        this.jJX.setAdapter((ListAdapter) this.jJY);
        this.jKd = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("write_video_activity_save_video", true);
        if (this.jKd) {
            al.k(this.jKa, R.drawable.corner_bg_radio_selected);
        } else {
            al.k(this.jKa, R.drawable.corner_bg_radio_unselected);
        }
        al.j(this.jKb, R.color.cp_cont_g);
        this.jJZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jKd) {
                    b.this.jKd = false;
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("write_video_activity_save_video", false);
                    al.k(b.this.jKa, R.drawable.corner_bg_radio_unselected);
                    b.this.jKa.invalidate();
                    return;
                }
                b.this.jKd = true;
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("write_video_activity_save_video", true);
                al.k(b.this.jKa, R.drawable.corner_bg_radio_selected);
                b.this.jKa.invalidate();
            }
        });
    }

    public void cxW() {
        if (this.jKc != null) {
            this.jKc.setVisibility(0);
        }
    }

    public void FY(String str) {
        int i;
        int i2 = 0;
        Bitmap Dx = Dx(str);
        if (Dx != null && Dx.getHeight() != 0) {
            if (Dx.getHeight() <= 0) {
                i = 0;
            } else if (Dx.getWidth() / Dx.getHeight() > l.af(this.jJO) / l.g(this.jJO, R.dimen.ds440)) {
                i = l.af(this.jJO);
                if (Dx.getWidth() > 0) {
                    i2 = (int) ((i / Dx.getWidth()) * Dx.getHeight());
                }
            } else {
                int g = l.g(this.jJO, R.dimen.ds440);
                if (Dx.getWidth() > 0) {
                    i = (int) ((g / Dx.getHeight()) * Dx.getWidth());
                    i2 = g;
                } else {
                    i = 0;
                    i2 = g;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jsH.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.jsH.setLayoutParams(layoutParams);
            this.jsH.setImageBitmap(Dx);
        }
    }

    private Bitmap Dx(String str) {
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
        this.jJO.getLayoutMode().setNightMode(i == 1);
        this.jJO.getLayoutMode().onModeChanged(this.dBd);
        this.mNavigationBar.onChangeSkinType(this.jJO.getPageContext(), i);
        al.c(this.jJU, (int) R.drawable.icon_return_bg_s);
        al.f(this.jJP, R.color.cp_link_tip_a, 1);
        al.k(this.jJS, R.drawable.corner_bg);
        al.j(this.jKc, R.color.cp_cont_e);
        this.jKd = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("write_video_activity_save_video", true);
        if (this.jKd) {
            al.k(this.jKa, R.drawable.corner_bg_radio_selected);
        } else {
            al.k(this.jKa, R.drawable.corner_bg_radio_unselected);
        }
        if (this.jJS != null) {
            this.jJS.onChangeSkinType(i);
        }
        if (this.jJR != null) {
            this.jJR.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.jJQ.getText() == null) {
            return null;
        }
        return this.jJQ.getText().toString();
    }

    public long cxX() {
        if (this.jJQ.getText() == null || this.jJQ.getText().toString() == null) {
            return 0L;
        }
        return this.jJQ.getText().length();
    }

    public WriteLocationView cxY() {
        return this.jJS;
    }

    public View cxZ() {
        return this.jJP;
    }

    public View getBackButton() {
        return this.jJU;
    }

    public EditText cya() {
        return this.jJQ;
    }

    public StateSwitchView cyb() {
        return this.jJR;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                FY(thumbPath);
                this.jsH.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jsH.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.jsH.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.jsE.setVideoPath(videoPath);
                this.jsE.start();
            }
        }
        if (!v.aa(list)) {
            this.jJY.ew(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.jJQ.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.jJY.ew(arrayList);
            this.jJQ.setText("#" + videoTitleData.name + "#");
        }
    }

    public void csB() {
        if (this.jsE != null) {
            this.jsE.resume();
            this.jsE.seekTo(this.jsO);
            this.jsE.start();
        }
    }

    public void bmf() {
        this.jsO = this.jsE.getCurrentPosition();
        if (this.jsE != null) {
            this.jsE.stopPlayback();
        }
    }

    public void FZ(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.jJO.getResources().getString(R.string.post_to_home_page));
            cyc();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.jJO.getResources().getString(R.string.post_to) + str);
        cyd();
    }

    private void cyc() {
        this.jJR = new StateSwitchView(this.jJO);
        this.jJR.setStateString(this.jJO.getString(R.string.public_to_all), this.jJO.getString(R.string.public_to_me));
        this.jJR.setBackgroundId(R.drawable.state_switch_bg);
        this.jJR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jJR.aFu();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.g(this.jJO, R.dimen.ds34), l.g(this.jJO, R.dimen.ds16));
        this.dBd.addView(this.jJR, layoutParams);
    }

    private void cyd() {
        this.jJR = new StateSwitchView(this.jJO);
        this.jJR.setStateString(this.jJO.getString(R.string.display_to_home_page), this.jJO.getString(R.string.display_to_home_page));
        this.jJR.setLeftStateDrawable(R.drawable.icon_share_home_select_ok, R.drawable.icon_share_home_select);
        this.jJR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jJR.aFu();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.g(this.jJO, R.dimen.ds34), l.g(this.jJO, R.dimen.ds16));
        this.jJR.setTextSize(0, this.jJO.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.dBd.addView(this.jJR, layoutParams);
    }

    public void cye() {
        this.jJV.aI(null);
        this.jJV.rK(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jJV.aI(postWriteCallBackData.getSensitiveWords());
            this.jJV.FG(postWriteCallBackData.getErrorString());
            if (!v.aa(this.jJV.cwd())) {
                rU(true);
            }
        }
    }

    public void rU(boolean z) {
        if (this.jJQ.getText() != null) {
            int selectionEnd = this.jJQ.getSelectionEnd();
            SpannableStringBuilder b = this.jJV.b(this.jJQ.getText());
            if (b != null) {
                this.jJV.rL(true);
                this.jJQ.setText(b);
                if (z && this.jJV.cwe() >= 0) {
                    this.jJQ.requestFocus();
                    this.jJQ.setSelection(this.jJV.cwe());
                } else {
                    this.jJQ.setSelection(selectionEnd);
                }
                this.jJV.rK(this.jJV.cwe() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b cyf() {
        return this.jJV;
    }

    public void rV(boolean z) {
        if (z) {
            this.jJW.setVisibility(8);
            this.jJT.setVisibility(0);
            this.bbv.smoothScrollTo(0, this.jJT.getBottom());
        }
    }
}
