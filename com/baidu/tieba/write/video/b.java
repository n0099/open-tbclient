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
    public static int jJK = 60;
    private ScrollView bbv;
    private RelativeLayout dBd;
    private WriteVideoActivity jJL;
    private TextView jJM;
    private EditText jJN;
    private StateSwitchView jJO;
    private WriteLocationView jJP;
    private TextView jJQ;
    private ImageView jJR;
    private com.baidu.tieba.write.b jJS;
    private LinearLayout jJT;
    private ListView jJU;
    private a jJV;
    private LinearLayout jJW;
    private TextView jJX;
    private TextView jJY;
    private TextView jJZ;
    private boolean jKa = true;
    private CustomVideoView jsB;
    private ImageView jsE;
    private int jsL;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.jJL = writeVideoActivity;
        this.jJL.setContentView(R.layout.write_video_activity);
        this.jJS = new com.baidu.tieba.write.b();
        this.jJS.Cb(R.color.cp_btn_a);
        this.jJS.Cc(R.color.cp_cont_h_alpha85);
        cxW();
        initView();
    }

    private void cxW() {
        this.dBd = (RelativeLayout) this.jJL.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.jJL.findViewById(R.id.navigation_bar);
        this.jJN = (EditText) this.jJL.findViewById(R.id.edit_content);
        this.jJQ = (TextView) this.jJL.findViewById(R.id.text_content_size);
        this.jsE = (ImageView) this.jJL.findViewById(R.id.video_cover);
        this.jJP = (WriteLocationView) this.jJL.findViewById(R.id.location);
        this.jsB = (CustomVideoView) this.jJL.findViewById(R.id.preview_videoview);
        this.bbv = (ScrollView) this.jJL.findViewById(R.id.write_scrollview);
        this.jsB.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.jsB.getWidth() != b.this.jsE.getWidth() || b.this.jsB.getHeight() != b.this.jsE.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.jsE.getLayoutParams();
                    layoutParams.width = b.this.jsB.getWidth();
                    layoutParams.height = b.this.jsB.getHeight();
                    b.this.jsE.setLayoutParams(layoutParams);
                }
                b.this.jsE.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jsB.start();
                        b.this.jsE.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.jsB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cB(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jJT = (LinearLayout) this.jJL.findViewById(R.id.video_activity_title_container);
        this.jJU = (ListView) this.jJL.findViewById(R.id.video_activity_title_list);
        this.jJU.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.jJT.setVisibility(8);
                b.this.jJQ.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.jJN.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.jJN.requestFocus();
                    if (!TextUtils.isEmpty(b.this.jJN.getText())) {
                        b.this.jJN.setSelection(b.this.jJN.getText().length());
                    }
                    l.c(b.this.jJL, b.this.jJN);
                }
            }
        });
        this.jJW = (LinearLayout) this.jJL.findViewById(R.id.save_video_wrapper);
        this.jJX = (TextView) this.jJL.findViewById(R.id.save_video_ridiobutton);
        this.jJY = (TextView) this.jJL.findViewById(R.id.save_video_ridiotext);
        this.jJZ = (TextView) this.jJL.findViewById(R.id.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.af(this.jJL) / l.g(this.jJL, R.dimen.ds440)) {
            i3 = l.af(this.jJL);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int g = l.g(this.jJL, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((g / i2) * i);
                i4 = g;
            } else {
                i3 = 0;
                i4 = g;
            }
        }
        this.jsB.setVideoHeight(i4);
        this.jsB.setVideoWidth(i3);
        this.jsB.invalidate();
    }

    private void initView() {
        this.jJR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.jJL);
        this.mNavigationBar.setCenterTextTitle(this.jJL.getPageContext().getString(R.string.post_video_title));
        this.jJM = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.jJL);
        this.jJM.setText(R.string.send_post);
        this.jJN.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.jJN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.jJV != null && b.this.jJV.getCount() > 0) {
                    l.b(b.this.jJL, b.this.jJN);
                    b.this.jJT.setVisibility(0);
                    b.this.jJQ.setVisibility(8);
                }
                long cxY = b.jJK - b.this.cxY();
                if (cxY >= 0) {
                    al.j(b.this.jJQ, R.color.cp_cont_e);
                    b.this.jJQ.setText(String.valueOf(cxY));
                    return;
                }
                b.this.jJQ.setText("0");
                b.this.jJN.setText(b.this.jJN.getText().toString().substring(0, b.jJK));
                b.this.jJN.setSelection(b.this.jJN.getText().length());
                b.this.jJL.showToast(b.this.jJL.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.jJS != null) {
                    if (!b.this.jJS.cwh()) {
                        b.this.rT(false);
                    }
                    b.this.jJS.rK(false);
                }
            }
        });
        this.jJV = new a();
        this.jJU.setAdapter((ListAdapter) this.jJV);
        this.jKa = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("write_video_activity_save_video", true);
        if (this.jKa) {
            al.k(this.jJX, R.drawable.corner_bg_radio_selected);
        } else {
            al.k(this.jJX, R.drawable.corner_bg_radio_unselected);
        }
        al.j(this.jJY, R.color.cp_cont_g);
        this.jJW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jKa) {
                    b.this.jKa = false;
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("write_video_activity_save_video", false);
                    al.k(b.this.jJX, R.drawable.corner_bg_radio_unselected);
                    b.this.jJX.invalidate();
                    return;
                }
                b.this.jKa = true;
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("write_video_activity_save_video", true);
                al.k(b.this.jJX, R.drawable.corner_bg_radio_selected);
                b.this.jJX.invalidate();
            }
        });
    }

    public void cxX() {
        if (this.jJZ != null) {
            this.jJZ.setVisibility(0);
        }
    }

    public void FW(String str) {
        int i;
        int i2 = 0;
        Bitmap Dv = Dv(str);
        if (Dv != null && Dv.getHeight() != 0) {
            if (Dv.getHeight() <= 0) {
                i = 0;
            } else if (Dv.getWidth() / Dv.getHeight() > l.af(this.jJL) / l.g(this.jJL, R.dimen.ds440)) {
                i = l.af(this.jJL);
                if (Dv.getWidth() > 0) {
                    i2 = (int) ((i / Dv.getWidth()) * Dv.getHeight());
                }
            } else {
                int g = l.g(this.jJL, R.dimen.ds440);
                if (Dv.getWidth() > 0) {
                    i = (int) ((g / Dv.getHeight()) * Dv.getWidth());
                    i2 = g;
                } else {
                    i = 0;
                    i2 = g;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jsE.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.jsE.setLayoutParams(layoutParams);
            this.jsE.setImageBitmap(Dv);
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
        this.jJL.getLayoutMode().setNightMode(i == 1);
        this.jJL.getLayoutMode().onModeChanged(this.dBd);
        this.mNavigationBar.onChangeSkinType(this.jJL.getPageContext(), i);
        al.c(this.jJR, (int) R.drawable.icon_return_bg_s);
        al.f(this.jJM, R.color.cp_link_tip_a, 1);
        al.k(this.jJP, R.drawable.corner_bg);
        al.j(this.jJZ, R.color.cp_cont_e);
        this.jKa = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("write_video_activity_save_video", true);
        if (this.jKa) {
            al.k(this.jJX, R.drawable.corner_bg_radio_selected);
        } else {
            al.k(this.jJX, R.drawable.corner_bg_radio_unselected);
        }
        if (this.jJP != null) {
            this.jJP.onChangeSkinType(i);
        }
        if (this.jJO != null) {
            this.jJO.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.jJN.getText() == null) {
            return null;
        }
        return this.jJN.getText().toString();
    }

    public long cxY() {
        if (this.jJN.getText() == null || this.jJN.getText().toString() == null) {
            return 0L;
        }
        return this.jJN.getText().length();
    }

    public WriteLocationView cxZ() {
        return this.jJP;
    }

    public View cya() {
        return this.jJM;
    }

    public View getBackButton() {
        return this.jJR;
    }

    public EditText cyb() {
        return this.jJN;
    }

    public StateSwitchView cyc() {
        return this.jJO;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                FW(thumbPath);
                this.jsE.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jsE.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.jsE.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.jsB.setVideoPath(videoPath);
                this.jsB.start();
            }
        }
        if (!v.aa(list)) {
            this.jJV.ew(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.jJN.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.jJV.ew(arrayList);
            this.jJN.setText("#" + videoTitleData.name + "#");
        }
    }

    public void csC() {
        if (this.jsB != null) {
            this.jsB.resume();
            this.jsB.seekTo(this.jsL);
            this.jsB.start();
        }
    }

    public void bmf() {
        this.jsL = this.jsB.getCurrentPosition();
        if (this.jsB != null) {
            this.jsB.stopPlayback();
        }
    }

    public void FX(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.jJL.getResources().getString(R.string.post_to_home_page));
            cyd();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.jJL.getResources().getString(R.string.post_to) + str);
        cye();
    }

    private void cyd() {
        this.jJO = new StateSwitchView(this.jJL);
        this.jJO.setStateString(this.jJL.getString(R.string.public_to_all), this.jJL.getString(R.string.public_to_me));
        this.jJO.setBackgroundId(R.drawable.state_switch_bg);
        this.jJO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jJO.aFu();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.g(this.jJL, R.dimen.ds34), l.g(this.jJL, R.dimen.ds16));
        this.dBd.addView(this.jJO, layoutParams);
    }

    private void cye() {
        this.jJO = new StateSwitchView(this.jJL);
        this.jJO.setStateString(this.jJL.getString(R.string.display_to_home_page), this.jJL.getString(R.string.display_to_home_page));
        this.jJO.setLeftStateDrawable(R.drawable.icon_share_home_select_ok, R.drawable.icon_share_home_select);
        this.jJO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jJO.aFu();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.g(this.jJL, R.dimen.ds34), l.g(this.jJL, R.dimen.ds16));
        this.jJO.setTextSize(0, this.jJL.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.dBd.addView(this.jJO, layoutParams);
    }

    public void cyf() {
        this.jJS.aI(null);
        this.jJS.rJ(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jJS.aI(postWriteCallBackData.getSensitiveWords());
            this.jJS.FE(postWriteCallBackData.getErrorString());
            if (!v.aa(this.jJS.cwe())) {
                rT(true);
            }
        }
    }

    public void rT(boolean z) {
        if (this.jJN.getText() != null) {
            int selectionEnd = this.jJN.getSelectionEnd();
            SpannableStringBuilder b = this.jJS.b(this.jJN.getText());
            if (b != null) {
                this.jJS.rK(true);
                this.jJN.setText(b);
                if (z && this.jJS.cwf() >= 0) {
                    this.jJN.requestFocus();
                    this.jJN.setSelection(this.jJS.cwf());
                } else {
                    this.jJN.setSelection(selectionEnd);
                }
                this.jJS.rJ(this.jJS.cwf() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b cyg() {
        return this.jJS;
    }

    public void rU(boolean z) {
        if (z) {
            this.jJT.setVisibility(8);
            this.jJQ.setVisibility(0);
            this.bbv.smoothScrollTo(0, this.jJQ.getBottom());
        }
    }
}
