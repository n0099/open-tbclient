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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.editor.StateSwitchView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static int jqH = 60;
    private ScrollView aYH;
    private RelativeLayout dqx;
    private CustomVideoView iZF;
    private ImageView iZI;
    private int iZP;
    private WriteVideoActivity jqI;
    private TextView jqJ;
    private EditText jqK;
    private StateSwitchView jqL;
    private WriteLocationView jqM;
    private TextView jqN;
    private ImageView jqO;
    private com.baidu.tieba.write.b jqP;
    private LinearLayout jqQ;
    private ListView jqR;
    private a jqS;
    private LinearLayout jqT;
    private TextView jqU;
    private TextView jqV;
    private TextView jqW;
    private boolean jqX = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.jqI = writeVideoActivity;
        this.jqI.setContentView(d.h.write_video_activity);
        this.jqP = new com.baidu.tieba.write.b();
        this.jqP.AS(d.C0277d.cp_btn_a);
        this.jqP.AT(d.C0277d.cp_cont_h_alpha85);
        cpO();
        initView();
    }

    private void cpO() {
        this.dqx = (RelativeLayout) this.jqI.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.jqI.findViewById(d.g.navigation_bar);
        this.jqK = (EditText) this.jqI.findViewById(d.g.edit_content);
        this.jqN = (TextView) this.jqI.findViewById(d.g.text_content_size);
        this.iZI = (ImageView) this.jqI.findViewById(d.g.video_cover);
        this.jqM = (WriteLocationView) this.jqI.findViewById(d.g.location);
        this.iZF = (CustomVideoView) this.jqI.findViewById(d.g.preview_videoview);
        this.aYH = (ScrollView) this.jqI.findViewById(d.g.write_scrollview);
        this.iZF.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.iZF.getWidth() != b.this.iZI.getWidth() || b.this.iZF.getHeight() != b.this.iZI.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.iZI.getLayoutParams();
                    layoutParams.width = b.this.iZF.getWidth();
                    layoutParams.height = b.this.iZF.getHeight();
                    b.this.iZI.setLayoutParams(layoutParams);
                }
                b.this.iZI.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.iZF.start();
                        b.this.iZI.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.iZF.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cu(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jqQ = (LinearLayout) this.jqI.findViewById(d.g.video_activity_title_container);
        this.jqR = (ListView) this.jqI.findViewById(d.g.video_activity_title_list);
        this.jqR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.jqQ.setVisibility(8);
                b.this.jqN.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.jqK.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.jqK.requestFocus();
                    if (!TextUtils.isEmpty(b.this.jqK.getText())) {
                        b.this.jqK.setSelection(b.this.jqK.getText().length());
                    }
                    l.c(b.this.jqI, b.this.jqK);
                }
            }
        });
        this.jqT = (LinearLayout) this.jqI.findViewById(d.g.save_video_wrapper);
        this.jqU = (TextView) this.jqI.findViewById(d.g.save_video_ridiobutton);
        this.jqV = (TextView) this.jqI.findViewById(d.g.save_video_ridiotext);
        this.jqW = (TextView) this.jqI.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.jqI) / l.h(this.jqI, d.e.ds440)) {
            i3 = l.aO(this.jqI);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.jqI, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.iZF.setVideoHeight(i4);
        this.iZF.setVideoWidth(i3);
        this.iZF.invalidate();
    }

    private void initView() {
        this.jqO = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.jqI);
        this.mNavigationBar.setCenterTextTitle(this.jqI.getPageContext().getString(d.j.post_video_title));
        this.jqJ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.jqI);
        this.jqJ.setText(d.j.send_post);
        this.jqK.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.jqK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.jqS != null && b.this.jqS.getCount() > 0) {
                    l.b(b.this.jqI, b.this.jqK);
                    b.this.jqQ.setVisibility(0);
                    b.this.jqN.setVisibility(8);
                }
                long cpR = b.jqH - b.this.cpR();
                if (cpR >= 0) {
                    al.j(b.this.jqN, d.C0277d.cp_cont_e);
                    b.this.jqN.setText(String.valueOf(cpR));
                    return;
                }
                b.this.jqN.setText("0");
                b.this.jqK.setText(b.this.jqK.getText().toString().substring(0, b.jqH));
                b.this.jqK.setSelection(b.this.jqK.getText().length());
                b.this.jqI.showToast(b.this.jqI.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.jqP != null) {
                    if (!b.this.jqP.cnZ()) {
                        b.this.re(false);
                    }
                    b.this.jqP.qV(false);
                }
            }
        });
        this.jqS = new a();
        this.jqR.setAdapter((ListAdapter) this.jqS);
        this.jqX = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.jqX) {
            al.k(this.jqU, d.f.corner_bg_radio_selected);
        } else {
            al.k(this.jqU, d.f.corner_bg_radio_unselected);
        }
        al.j(this.jqV, d.C0277d.cp_cont_g);
        this.jqT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jqX) {
                    b.this.jqX = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    al.k(b.this.jqU, d.f.corner_bg_radio_unselected);
                    b.this.jqU.invalidate();
                    return;
                }
                b.this.jqX = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                al.k(b.this.jqU, d.f.corner_bg_radio_selected);
                b.this.jqU.invalidate();
            }
        });
    }

    public void cpP() {
        if (this.jqW != null) {
            this.jqW.setVisibility(0);
        }
    }

    public void EA(String str) {
        int i;
        int i2 = 0;
        Bitmap BZ = BZ(str);
        if (BZ != null && BZ.getHeight() != 0) {
            if (BZ.getHeight() <= 0) {
                i = 0;
            } else if (BZ.getWidth() / BZ.getHeight() > l.aO(this.jqI) / l.h(this.jqI, d.e.ds440)) {
                i = l.aO(this.jqI);
                if (BZ.getWidth() > 0) {
                    i2 = (int) ((i / BZ.getWidth()) * BZ.getHeight());
                }
            } else {
                int h = l.h(this.jqI, d.e.ds440);
                if (BZ.getWidth() > 0) {
                    i = (int) ((h / BZ.getHeight()) * BZ.getWidth());
                    i2 = h;
                } else {
                    i = 0;
                    i2 = h;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.iZI.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.iZI.setLayoutParams(layoutParams);
            this.iZI.setImageBitmap(BZ);
        }
    }

    private Bitmap BZ(String str) {
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

    public TextView cpQ() {
        return this.mNavigationBar.mCenterText;
    }

    public void onChangeSkinType(int i) {
        this.jqI.getLayoutMode().setNightMode(i == 1);
        this.jqI.getLayoutMode().onModeChanged(this.dqx);
        this.mNavigationBar.onChangeSkinType(this.jqI.getPageContext(), i);
        al.c(this.jqO, d.f.icon_return_bg_s);
        al.d(this.jqJ, d.C0277d.cp_link_tip_a, 1);
        al.k(this.jqM, d.f.corner_bg);
        al.j(this.jqW, d.C0277d.cp_cont_e);
        this.jqX = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.jqX) {
            al.k(this.jqU, d.f.corner_bg_radio_selected);
        } else {
            al.k(this.jqU, d.f.corner_bg_radio_unselected);
        }
        if (this.jqM != null) {
            this.jqM.onChangeSkinType(i);
        }
        if (this.jqL != null) {
            this.jqL.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.jqK.getText() == null) {
            return null;
        }
        return this.jqK.getText().toString();
    }

    public long cpR() {
        if (this.jqK.getText() == null || this.jqK.getText().toString() == null) {
            return 0L;
        }
        return this.jqK.getText().length();
    }

    public WriteLocationView cpS() {
        return this.jqM;
    }

    public View cpT() {
        return this.jqJ;
    }

    public View getBackButton() {
        return this.jqO;
    }

    public EditText cpU() {
        return this.jqK;
    }

    public StateSwitchView cpV() {
        return this.jqL;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                EA(thumbPath);
                this.iZI.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.iZI.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.iZI.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.iZF.setVideoPath(videoPath);
                this.iZF.start();
            }
        }
        if (!v.T(list)) {
            this.jqS.em(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.jqK.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.jqS.em(arrayList);
            this.jqK.setText("#" + videoTitleData.name + "#");
        }
    }

    public void ckx() {
        if (this.iZF != null) {
            this.iZF.resume();
            this.iZF.seekTo(this.iZP);
            this.iZF.start();
        }
    }

    public void beK() {
        this.iZP = this.iZF.getCurrentPosition();
        if (this.iZF != null) {
            this.iZF.stopPlayback();
        }
    }

    public void EB(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.jqI.getResources().getString(d.j.post_to_home_page));
            cpW();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.jqI.getResources().getString(d.j.post_to) + str);
        cpX();
    }

    private void cpW() {
        this.jqL = new StateSwitchView(this.jqI);
        this.jqL.setStateString(this.jqI.getString(d.j.public_to_all), this.jqI.getString(d.j.public_to_me));
        this.jqL.setBackgroundId(d.f.state_switch_bg);
        this.jqL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jqL.aSk();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.jqI, d.e.ds34), l.h(this.jqI, d.e.ds16));
        this.dqx.addView(this.jqL, layoutParams);
    }

    private void cpX() {
        this.jqL = new StateSwitchView(this.jqI);
        this.jqL.setStateString(this.jqI.getString(d.j.display_to_home_page), this.jqI.getString(d.j.display_to_home_page));
        this.jqL.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.jqL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jqL.aSk();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.jqI, d.e.ds34), l.h(this.jqI, d.e.ds16));
        this.jqL.setTextSize(0, this.jqI.getResources().getDimensionPixelSize(d.e.ds28));
        this.dqx.addView(this.jqL, layoutParams);
    }

    public void cpY() {
        this.jqP.aE(null);
        this.jqP.qU(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jqP.aE(postWriteCallBackData.getSensitiveWords());
            this.jqP.Ei(postWriteCallBackData.getErrorString());
            if (!v.T(this.jqP.cnW())) {
                re(true);
            }
        }
    }

    public void re(boolean z) {
        if (this.jqK.getText() != null) {
            int selectionEnd = this.jqK.getSelectionEnd();
            SpannableStringBuilder b = this.jqP.b(this.jqK.getText());
            if (b != null) {
                this.jqP.qV(true);
                this.jqK.setText(b);
                if (z && this.jqP.cnX() >= 0) {
                    this.jqK.requestFocus();
                    this.jqK.setSelection(this.jqP.cnX());
                } else {
                    this.jqK.setSelection(selectionEnd);
                }
                this.jqP.qU(this.jqP.cnX() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b cpZ() {
        return this.jqP;
    }

    public void rf(boolean z) {
        if (z) {
            this.jqQ.setVisibility(8);
            this.jqN.setVisibility(0);
            this.aYH.smoothScrollTo(0, this.jqN.getBottom());
        }
    }
}
