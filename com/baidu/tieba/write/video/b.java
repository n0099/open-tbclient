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
    public static int jqG = 60;
    private ScrollView aYG;
    private RelativeLayout dqw;
    private CustomVideoView iZE;
    private ImageView iZH;
    private int iZO;
    private WriteVideoActivity jqH;
    private TextView jqI;
    private EditText jqJ;
    private StateSwitchView jqK;
    private WriteLocationView jqL;
    private TextView jqM;
    private ImageView jqN;
    private com.baidu.tieba.write.b jqO;
    private LinearLayout jqP;
    private ListView jqQ;
    private a jqR;
    private LinearLayout jqS;
    private TextView jqT;
    private TextView jqU;
    private TextView jqV;
    private boolean jqW = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.jqH = writeVideoActivity;
        this.jqH.setContentView(d.h.write_video_activity);
        this.jqO = new com.baidu.tieba.write.b();
        this.jqO.AS(d.C0277d.cp_btn_a);
        this.jqO.AT(d.C0277d.cp_cont_h_alpha85);
        cpO();
        initView();
    }

    private void cpO() {
        this.dqw = (RelativeLayout) this.jqH.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.jqH.findViewById(d.g.navigation_bar);
        this.jqJ = (EditText) this.jqH.findViewById(d.g.edit_content);
        this.jqM = (TextView) this.jqH.findViewById(d.g.text_content_size);
        this.iZH = (ImageView) this.jqH.findViewById(d.g.video_cover);
        this.jqL = (WriteLocationView) this.jqH.findViewById(d.g.location);
        this.iZE = (CustomVideoView) this.jqH.findViewById(d.g.preview_videoview);
        this.aYG = (ScrollView) this.jqH.findViewById(d.g.write_scrollview);
        this.iZE.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.iZE.getWidth() != b.this.iZH.getWidth() || b.this.iZE.getHeight() != b.this.iZH.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.iZH.getLayoutParams();
                    layoutParams.width = b.this.iZE.getWidth();
                    layoutParams.height = b.this.iZE.getHeight();
                    b.this.iZH.setLayoutParams(layoutParams);
                }
                b.this.iZH.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.iZE.start();
                        b.this.iZH.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.iZE.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cu(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jqP = (LinearLayout) this.jqH.findViewById(d.g.video_activity_title_container);
        this.jqQ = (ListView) this.jqH.findViewById(d.g.video_activity_title_list);
        this.jqQ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.jqP.setVisibility(8);
                b.this.jqM.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.jqJ.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.jqJ.requestFocus();
                    if (!TextUtils.isEmpty(b.this.jqJ.getText())) {
                        b.this.jqJ.setSelection(b.this.jqJ.getText().length());
                    }
                    l.c(b.this.jqH, b.this.jqJ);
                }
            }
        });
        this.jqS = (LinearLayout) this.jqH.findViewById(d.g.save_video_wrapper);
        this.jqT = (TextView) this.jqH.findViewById(d.g.save_video_ridiobutton);
        this.jqU = (TextView) this.jqH.findViewById(d.g.save_video_ridiotext);
        this.jqV = (TextView) this.jqH.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.jqH) / l.h(this.jqH, d.e.ds440)) {
            i3 = l.aO(this.jqH);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.jqH, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.iZE.setVideoHeight(i4);
        this.iZE.setVideoWidth(i3);
        this.iZE.invalidate();
    }

    private void initView() {
        this.jqN = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.jqH);
        this.mNavigationBar.setCenterTextTitle(this.jqH.getPageContext().getString(d.j.post_video_title));
        this.jqI = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.jqH);
        this.jqI.setText(d.j.send_post);
        this.jqJ.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.jqJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.jqR != null && b.this.jqR.getCount() > 0) {
                    l.b(b.this.jqH, b.this.jqJ);
                    b.this.jqP.setVisibility(0);
                    b.this.jqM.setVisibility(8);
                }
                long cpR = b.jqG - b.this.cpR();
                if (cpR >= 0) {
                    al.j(b.this.jqM, d.C0277d.cp_cont_e);
                    b.this.jqM.setText(String.valueOf(cpR));
                    return;
                }
                b.this.jqM.setText("0");
                b.this.jqJ.setText(b.this.jqJ.getText().toString().substring(0, b.jqG));
                b.this.jqJ.setSelection(b.this.jqJ.getText().length());
                b.this.jqH.showToast(b.this.jqH.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.jqO != null) {
                    if (!b.this.jqO.cnZ()) {
                        b.this.re(false);
                    }
                    b.this.jqO.qV(false);
                }
            }
        });
        this.jqR = new a();
        this.jqQ.setAdapter((ListAdapter) this.jqR);
        this.jqW = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.jqW) {
            al.k(this.jqT, d.f.corner_bg_radio_selected);
        } else {
            al.k(this.jqT, d.f.corner_bg_radio_unselected);
        }
        al.j(this.jqU, d.C0277d.cp_cont_g);
        this.jqS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jqW) {
                    b.this.jqW = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    al.k(b.this.jqT, d.f.corner_bg_radio_unselected);
                    b.this.jqT.invalidate();
                    return;
                }
                b.this.jqW = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                al.k(b.this.jqT, d.f.corner_bg_radio_selected);
                b.this.jqT.invalidate();
            }
        });
    }

    public void cpP() {
        if (this.jqV != null) {
            this.jqV.setVisibility(0);
        }
    }

    public void EA(String str) {
        int i;
        int i2 = 0;
        Bitmap BZ = BZ(str);
        if (BZ != null && BZ.getHeight() != 0) {
            if (BZ.getHeight() <= 0) {
                i = 0;
            } else if (BZ.getWidth() / BZ.getHeight() > l.aO(this.jqH) / l.h(this.jqH, d.e.ds440)) {
                i = l.aO(this.jqH);
                if (BZ.getWidth() > 0) {
                    i2 = (int) ((i / BZ.getWidth()) * BZ.getHeight());
                }
            } else {
                int h = l.h(this.jqH, d.e.ds440);
                if (BZ.getWidth() > 0) {
                    i = (int) ((h / BZ.getHeight()) * BZ.getWidth());
                    i2 = h;
                } else {
                    i = 0;
                    i2 = h;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.iZH.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.iZH.setLayoutParams(layoutParams);
            this.iZH.setImageBitmap(BZ);
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
        this.jqH.getLayoutMode().setNightMode(i == 1);
        this.jqH.getLayoutMode().onModeChanged(this.dqw);
        this.mNavigationBar.onChangeSkinType(this.jqH.getPageContext(), i);
        al.c(this.jqN, d.f.icon_return_bg_s);
        al.d(this.jqI, d.C0277d.cp_link_tip_a, 1);
        al.k(this.jqL, d.f.corner_bg);
        al.j(this.jqV, d.C0277d.cp_cont_e);
        this.jqW = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.jqW) {
            al.k(this.jqT, d.f.corner_bg_radio_selected);
        } else {
            al.k(this.jqT, d.f.corner_bg_radio_unselected);
        }
        if (this.jqL != null) {
            this.jqL.onChangeSkinType(i);
        }
        if (this.jqK != null) {
            this.jqK.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.jqJ.getText() == null) {
            return null;
        }
        return this.jqJ.getText().toString();
    }

    public long cpR() {
        if (this.jqJ.getText() == null || this.jqJ.getText().toString() == null) {
            return 0L;
        }
        return this.jqJ.getText().length();
    }

    public WriteLocationView cpS() {
        return this.jqL;
    }

    public View cpT() {
        return this.jqI;
    }

    public View getBackButton() {
        return this.jqN;
    }

    public EditText cpU() {
        return this.jqJ;
    }

    public StateSwitchView cpV() {
        return this.jqK;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                EA(thumbPath);
                this.iZH.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.iZH.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.iZH.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.iZE.setVideoPath(videoPath);
                this.iZE.start();
            }
        }
        if (!v.T(list)) {
            this.jqR.em(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.jqJ.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.jqR.em(arrayList);
            this.jqJ.setText("#" + videoTitleData.name + "#");
        }
    }

    public void ckx() {
        if (this.iZE != null) {
            this.iZE.resume();
            this.iZE.seekTo(this.iZO);
            this.iZE.start();
        }
    }

    public void beK() {
        this.iZO = this.iZE.getCurrentPosition();
        if (this.iZE != null) {
            this.iZE.stopPlayback();
        }
    }

    public void EB(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.jqH.getResources().getString(d.j.post_to_home_page));
            cpW();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.jqH.getResources().getString(d.j.post_to) + str);
        cpX();
    }

    private void cpW() {
        this.jqK = new StateSwitchView(this.jqH);
        this.jqK.setStateString(this.jqH.getString(d.j.public_to_all), this.jqH.getString(d.j.public_to_me));
        this.jqK.setBackgroundId(d.f.state_switch_bg);
        this.jqK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jqK.aSk();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.jqH, d.e.ds34), l.h(this.jqH, d.e.ds16));
        this.dqw.addView(this.jqK, layoutParams);
    }

    private void cpX() {
        this.jqK = new StateSwitchView(this.jqH);
        this.jqK.setStateString(this.jqH.getString(d.j.display_to_home_page), this.jqH.getString(d.j.display_to_home_page));
        this.jqK.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.jqK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jqK.aSk();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.jqH, d.e.ds34), l.h(this.jqH, d.e.ds16));
        this.jqK.setTextSize(0, this.jqH.getResources().getDimensionPixelSize(d.e.ds28));
        this.dqw.addView(this.jqK, layoutParams);
    }

    public void cpY() {
        this.jqO.aE(null);
        this.jqO.qU(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jqO.aE(postWriteCallBackData.getSensitiveWords());
            this.jqO.Ei(postWriteCallBackData.getErrorString());
            if (!v.T(this.jqO.cnW())) {
                re(true);
            }
        }
    }

    public void re(boolean z) {
        if (this.jqJ.getText() != null) {
            int selectionEnd = this.jqJ.getSelectionEnd();
            SpannableStringBuilder b = this.jqO.b(this.jqJ.getText());
            if (b != null) {
                this.jqO.qV(true);
                this.jqJ.setText(b);
                if (z && this.jqO.cnX() >= 0) {
                    this.jqJ.requestFocus();
                    this.jqJ.setSelection(this.jqO.cnX());
                } else {
                    this.jqJ.setSelection(selectionEnd);
                }
                this.jqO.qU(this.jqO.cnX() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b cpZ() {
        return this.jqO;
    }

    public void rf(boolean z) {
        if (z) {
            this.jqP.setVisibility(8);
            this.jqM.setVisibility(0);
            this.aYG.smoothScrollTo(0, this.jqM.getBottom());
        }
    }
}
