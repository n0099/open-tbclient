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
    public static int jqF = 60;
    private ScrollView aYC;
    private RelativeLayout dqx;
    private CustomVideoView iZE;
    private ImageView iZH;
    private int iZO;
    private WriteVideoActivity jqG;
    private TextView jqH;
    private EditText jqI;
    private StateSwitchView jqJ;
    private WriteLocationView jqK;
    private TextView jqL;
    private ImageView jqM;
    private com.baidu.tieba.write.b jqN;
    private LinearLayout jqO;
    private ListView jqP;
    private a jqQ;
    private LinearLayout jqR;
    private TextView jqS;
    private TextView jqT;
    private TextView jqU;
    private boolean jqV = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.jqG = writeVideoActivity;
        this.jqG.setContentView(d.h.write_video_activity);
        this.jqN = new com.baidu.tieba.write.b();
        this.jqN.AV(d.C0236d.cp_btn_a);
        this.jqN.AW(d.C0236d.cp_cont_h_alpha85);
        cpD();
        initView();
    }

    private void cpD() {
        this.dqx = (RelativeLayout) this.jqG.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.jqG.findViewById(d.g.navigation_bar);
        this.jqI = (EditText) this.jqG.findViewById(d.g.edit_content);
        this.jqL = (TextView) this.jqG.findViewById(d.g.text_content_size);
        this.iZH = (ImageView) this.jqG.findViewById(d.g.video_cover);
        this.jqK = (WriteLocationView) this.jqG.findViewById(d.g.location);
        this.iZE = (CustomVideoView) this.jqG.findViewById(d.g.preview_videoview);
        this.aYC = (ScrollView) this.jqG.findViewById(d.g.write_scrollview);
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
        this.jqO = (LinearLayout) this.jqG.findViewById(d.g.video_activity_title_container);
        this.jqP = (ListView) this.jqG.findViewById(d.g.video_activity_title_list);
        this.jqP.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.jqO.setVisibility(8);
                b.this.jqL.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.jqI.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.jqI.requestFocus();
                    if (!TextUtils.isEmpty(b.this.jqI.getText())) {
                        b.this.jqI.setSelection(b.this.jqI.getText().length());
                    }
                    l.c(b.this.jqG, b.this.jqI);
                }
            }
        });
        this.jqR = (LinearLayout) this.jqG.findViewById(d.g.save_video_wrapper);
        this.jqS = (TextView) this.jqG.findViewById(d.g.save_video_ridiobutton);
        this.jqT = (TextView) this.jqG.findViewById(d.g.save_video_ridiotext);
        this.jqU = (TextView) this.jqG.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.jqG) / l.h(this.jqG, d.e.ds440)) {
            i3 = l.aO(this.jqG);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.jqG, d.e.ds440);
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
        this.jqM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.jqG);
        this.mNavigationBar.setCenterTextTitle(this.jqG.getPageContext().getString(d.j.post_video_title));
        this.jqH = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.jqG);
        this.jqH.setText(d.j.send_post);
        this.jqI.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.jqI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.jqQ != null && b.this.jqQ.getCount() > 0) {
                    l.b(b.this.jqG, b.this.jqI);
                    b.this.jqO.setVisibility(0);
                    b.this.jqL.setVisibility(8);
                }
                long cpG = b.jqF - b.this.cpG();
                if (cpG >= 0) {
                    al.j(b.this.jqL, d.C0236d.cp_cont_e);
                    b.this.jqL.setText(String.valueOf(cpG));
                    return;
                }
                b.this.jqL.setText("0");
                b.this.jqI.setText(b.this.jqI.getText().toString().substring(0, b.jqF));
                b.this.jqI.setSelection(b.this.jqI.getText().length());
                b.this.jqG.showToast(b.this.jqG.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.jqN != null) {
                    if (!b.this.jqN.cnO()) {
                        b.this.re(false);
                    }
                    b.this.jqN.qV(false);
                }
            }
        });
        this.jqQ = new a();
        this.jqP.setAdapter((ListAdapter) this.jqQ);
        this.jqV = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.jqV) {
            al.k(this.jqS, d.f.corner_bg_radio_selected);
        } else {
            al.k(this.jqS, d.f.corner_bg_radio_unselected);
        }
        al.j(this.jqT, d.C0236d.cp_cont_g);
        this.jqR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jqV) {
                    b.this.jqV = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    al.k(b.this.jqS, d.f.corner_bg_radio_unselected);
                    b.this.jqS.invalidate();
                    return;
                }
                b.this.jqV = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                al.k(b.this.jqS, d.f.corner_bg_radio_selected);
                b.this.jqS.invalidate();
            }
        });
    }

    public void cpE() {
        if (this.jqU != null) {
            this.jqU.setVisibility(0);
        }
    }

    public void EA(String str) {
        int i;
        int i2 = 0;
        Bitmap Cb = Cb(str);
        if (Cb != null && Cb.getHeight() != 0) {
            if (Cb.getHeight() <= 0) {
                i = 0;
            } else if (Cb.getWidth() / Cb.getHeight() > l.aO(this.jqG) / l.h(this.jqG, d.e.ds440)) {
                i = l.aO(this.jqG);
                if (Cb.getWidth() > 0) {
                    i2 = (int) ((i / Cb.getWidth()) * Cb.getHeight());
                }
            } else {
                int h = l.h(this.jqG, d.e.ds440);
                if (Cb.getWidth() > 0) {
                    i = (int) ((h / Cb.getHeight()) * Cb.getWidth());
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
            this.iZH.setImageBitmap(Cb);
        }
    }

    private Bitmap Cb(String str) {
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

    public TextView cpF() {
        return this.mNavigationBar.mCenterText;
    }

    public void onChangeSkinType(int i) {
        this.jqG.getLayoutMode().setNightMode(i == 1);
        this.jqG.getLayoutMode().onModeChanged(this.dqx);
        this.mNavigationBar.onChangeSkinType(this.jqG.getPageContext(), i);
        al.c(this.jqM, d.f.icon_return_bg_s);
        al.d(this.jqH, d.C0236d.cp_link_tip_a, 1);
        al.k(this.jqK, d.f.corner_bg);
        al.j(this.jqU, d.C0236d.cp_cont_e);
        this.jqV = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.jqV) {
            al.k(this.jqS, d.f.corner_bg_radio_selected);
        } else {
            al.k(this.jqS, d.f.corner_bg_radio_unselected);
        }
        if (this.jqK != null) {
            this.jqK.onChangeSkinType(i);
        }
        if (this.jqJ != null) {
            this.jqJ.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.jqI.getText() == null) {
            return null;
        }
        return this.jqI.getText().toString();
    }

    public long cpG() {
        if (this.jqI.getText() == null || this.jqI.getText().toString() == null) {
            return 0L;
        }
        return this.jqI.getText().length();
    }

    public WriteLocationView cpH() {
        return this.jqK;
    }

    public View cpI() {
        return this.jqH;
    }

    public View getBackButton() {
        return this.jqM;
    }

    public EditText cpJ() {
        return this.jqI;
    }

    public StateSwitchView cpK() {
        return this.jqJ;
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
            this.jqQ.ep(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.jqI.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.jqQ.ep(arrayList);
            this.jqI.setText("#" + videoTitleData.name + "#");
        }
    }

    public void ckm() {
        if (this.iZE != null) {
            this.iZE.resume();
            this.iZE.seekTo(this.iZO);
            this.iZE.start();
        }
    }

    public void beM() {
        this.iZO = this.iZE.getCurrentPosition();
        if (this.iZE != null) {
            this.iZE.stopPlayback();
        }
    }

    public void EB(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.jqG.getResources().getString(d.j.post_to_home_page));
            cpL();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.jqG.getResources().getString(d.j.post_to) + str);
        cpM();
    }

    private void cpL() {
        this.jqJ = new StateSwitchView(this.jqG);
        this.jqJ.setStateString(this.jqG.getString(d.j.public_to_all), this.jqG.getString(d.j.public_to_me));
        this.jqJ.setBackgroundId(d.f.state_switch_bg);
        this.jqJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jqJ.aSm();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.jqG, d.e.ds34), l.h(this.jqG, d.e.ds16));
        this.dqx.addView(this.jqJ, layoutParams);
    }

    private void cpM() {
        this.jqJ = new StateSwitchView(this.jqG);
        this.jqJ.setStateString(this.jqG.getString(d.j.display_to_home_page), this.jqG.getString(d.j.display_to_home_page));
        this.jqJ.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.jqJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jqJ.aSm();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.jqG, d.e.ds34), l.h(this.jqG, d.e.ds16));
        this.jqJ.setTextSize(0, this.jqG.getResources().getDimensionPixelSize(d.e.ds28));
        this.dqx.addView(this.jqJ, layoutParams);
    }

    public void cpN() {
        this.jqN.aE(null);
        this.jqN.qU(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jqN.aE(postWriteCallBackData.getSensitiveWords());
            this.jqN.Ei(postWriteCallBackData.getErrorString());
            if (!v.T(this.jqN.cnL())) {
                re(true);
            }
        }
    }

    public void re(boolean z) {
        if (this.jqI.getText() != null) {
            int selectionEnd = this.jqI.getSelectionEnd();
            SpannableStringBuilder b = this.jqN.b(this.jqI.getText());
            if (b != null) {
                this.jqN.qV(true);
                this.jqI.setText(b);
                if (z && this.jqN.cnM() >= 0) {
                    this.jqI.requestFocus();
                    this.jqI.setSelection(this.jqN.cnM());
                } else {
                    this.jqI.setSelection(selectionEnd);
                }
                this.jqN.qU(this.jqN.cnM() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b cpO() {
        return this.jqN;
    }

    public void rf(boolean z) {
        if (z) {
            this.jqO.setVisibility(8);
            this.jqL.setVisibility(0);
            this.aYC.smoothScrollTo(0, this.jqL.getBottom());
        }
    }
}
