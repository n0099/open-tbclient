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
    public static int hVC = 60;
    private ScrollView bHu;
    private RelativeLayout caH;
    private CustomVideoView hEZ;
    private ImageView hFc;
    private int hFj;
    private WriteVideoActivity hVD;
    private TextView hVE;
    private EditText hVF;
    private StateSwitchView hVG;
    private WriteLocationView hVH;
    private TextView hVI;
    private ImageView hVJ;
    private com.baidu.tieba.write.b hVK;
    private LinearLayout hVL;
    private ListView hVM;
    private a hVN;
    private LinearLayout hVO;
    private TextView hVP;
    private TextView hVQ;
    private TextView hVR;
    private boolean hVS = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.hVD = writeVideoActivity;
        this.hVD.setContentView(e.h.write_video_activity);
        this.hVK = new com.baidu.tieba.write.b();
        this.hVK.wV(e.d.cp_cont_i);
        this.hVK.wW(e.d.cp_cont_h_alpha85);
        bOv();
        initView();
    }

    private void bOv() {
        this.caH = (RelativeLayout) this.hVD.findViewById(e.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hVD.findViewById(e.g.navigation_bar);
        this.hVF = (EditText) this.hVD.findViewById(e.g.edit_content);
        this.hVI = (TextView) this.hVD.findViewById(e.g.text_content_size);
        this.hFc = (ImageView) this.hVD.findViewById(e.g.video_cover);
        this.hVH = (WriteLocationView) this.hVD.findViewById(e.g.location);
        this.hEZ = (CustomVideoView) this.hVD.findViewById(e.g.preview_videoview);
        this.bHu = (ScrollView) this.hVD.findViewById(e.g.write_scrollview);
        this.hEZ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.hEZ.getWidth() != b.this.hFc.getWidth() || b.this.hEZ.getHeight() != b.this.hFc.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.hFc.getLayoutParams();
                    layoutParams.width = b.this.hEZ.getWidth();
                    layoutParams.height = b.this.hEZ.getHeight();
                    b.this.hFc.setLayoutParams(layoutParams);
                }
                b.this.hFc.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hEZ.start();
                        b.this.hFc.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.hEZ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.bW(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hVL = (LinearLayout) this.hVD.findViewById(e.g.video_activity_title_container);
        this.hVM = (ListView) this.hVD.findViewById(e.g.video_activity_title_list);
        this.hVM.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.hVL.setVisibility(8);
                b.this.hVI.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.hVF.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.hVF.requestFocus();
                    if (!TextUtils.isEmpty(b.this.hVF.getText())) {
                        b.this.hVF.setSelection(b.this.hVF.getText().length());
                    }
                    l.c(b.this.hVD, b.this.hVF);
                }
            }
        });
        this.hVO = (LinearLayout) this.hVD.findViewById(e.g.save_video_wrapper);
        this.hVP = (TextView) this.hVD.findViewById(e.g.save_video_ridiobutton);
        this.hVQ = (TextView) this.hVD.findViewById(e.g.save_video_ridiotext);
        this.hVR = (TextView) this.hVD.findViewById(e.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.hVD) / l.h(this.hVD, e.C0210e.ds440)) {
            i3 = l.aO(this.hVD);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.hVD, e.C0210e.ds440);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.hEZ.setVideoHeight(i4);
        this.hEZ.setVideoWidth(i3);
        this.hEZ.invalidate();
    }

    private void initView() {
        this.hVJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.nav_close_layout, this.hVD);
        this.mNavigationBar.setCenterTextTitle(this.hVD.getPageContext().getString(e.j.post_video_title));
        this.hVE = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.nav_text_send_layout, this.hVD);
        this.hVE.setText(e.j.send_post);
        this.hVF.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hVF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.hVN != null && b.this.hVN.getCount() > 0) {
                    l.b(b.this.hVD, b.this.hVF);
                    b.this.hVL.setVisibility(0);
                    b.this.hVI.setVisibility(8);
                }
                long bOx = b.hVC - b.this.bOx();
                if (bOx >= 0) {
                    al.h(b.this.hVI, e.d.cp_cont_e);
                    b.this.hVI.setText(String.valueOf(bOx));
                    return;
                }
                b.this.hVI.setText("0");
                b.this.hVF.setText(b.this.hVF.getText().toString().substring(0, b.hVC));
                b.this.hVF.setSelection(b.this.hVF.getText().length());
                b.this.hVD.showToast(b.this.hVD.getResources().getString(e.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.hVK != null) {
                    if (!b.this.hVK.bMX()) {
                        b.this.oA(false);
                    }
                    b.this.hVK.or(false);
                }
            }
        });
        this.hVN = new a();
        this.hVM.setAdapter((ListAdapter) this.hVN);
        this.hVS = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hVS) {
            al.i(this.hVP, e.f.corner_bg_radio_selected);
        } else {
            al.i(this.hVP, e.f.corner_bg_radio_unselected);
        }
        al.h(this.hVQ, e.d.cp_cont_g);
        this.hVO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hVS) {
                    b.this.hVS = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    al.i(b.this.hVP, e.f.corner_bg_radio_unselected);
                    b.this.hVP.invalidate();
                    return;
                }
                b.this.hVS = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                al.i(b.this.hVP, e.f.corner_bg_radio_selected);
                b.this.hVP.invalidate();
            }
        });
    }

    public void bOw() {
        if (this.hVR != null) {
            this.hVR.setVisibility(0);
        }
    }

    public void xJ(String str) {
        int i;
        int i2 = 0;
        Bitmap vb = vb(str);
        if (vb != null && vb.getHeight() != 0) {
            if (vb.getHeight() <= 0) {
                i = 0;
            } else if (vb.getWidth() / vb.getHeight() > l.aO(this.hVD) / l.h(this.hVD, e.C0210e.ds440)) {
                i = l.aO(this.hVD);
                if (vb.getWidth() > 0) {
                    i2 = (int) ((i / vb.getWidth()) * vb.getHeight());
                }
            } else {
                int h = l.h(this.hVD, e.C0210e.ds440);
                if (vb.getWidth() > 0) {
                    i = (int) ((h / vb.getHeight()) * vb.getWidth());
                    i2 = h;
                } else {
                    i = 0;
                    i2 = h;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hFc.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hFc.setLayoutParams(layoutParams);
            this.hFc.setImageBitmap(vb);
        }
    }

    private Bitmap vb(String str) {
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
        this.hVD.getLayoutMode().setNightMode(i == 1);
        this.hVD.getLayoutMode().onModeChanged(this.caH);
        this.mNavigationBar.onChangeSkinType(this.hVD.getPageContext(), i);
        al.c(this.hVJ, e.f.icon_return_bg_s);
        al.c(this.hVE, e.d.cp_link_tip_a, 1);
        al.i(this.hVH, e.f.corner_bg);
        al.h(this.hVR, e.d.cp_cont_e);
        this.hVS = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hVS) {
            al.i(this.hVP, e.f.corner_bg_radio_selected);
        } else {
            al.i(this.hVP, e.f.corner_bg_radio_unselected);
        }
        if (this.hVH != null) {
            this.hVH.onChangeSkinType(i);
        }
        if (this.hVG != null) {
            this.hVG.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hVF.getText() == null) {
            return null;
        }
        return this.hVF.getText().toString();
    }

    public long bOx() {
        if (this.hVF.getText() == null || this.hVF.getText().toString() == null) {
            return 0L;
        }
        return this.hVF.getText().length();
    }

    public WriteLocationView bOy() {
        return this.hVH;
    }

    public View bOz() {
        return this.hVE;
    }

    public View getBackButton() {
        return this.hVJ;
    }

    public EditText bOA() {
        return this.hVF;
    }

    public StateSwitchView bOB() {
        return this.hVG;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                xJ(thumbPath);
                this.hFc.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hFc.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hFc.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.hEZ.setVideoPath(videoPath);
                this.hEZ.start();
            }
        }
        if (!v.I(list)) {
            this.hVN.ei(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hVF.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hVN.ei(arrayList);
            this.hVF.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bJz() {
        if (this.hEZ != null) {
            this.hEZ.resume();
            this.hEZ.seekTo(this.hFj);
            this.hEZ.start();
        }
    }

    public void aCR() {
        this.hFj = this.hEZ.getCurrentPosition();
        if (this.hEZ != null) {
            this.hEZ.stopPlayback();
        }
    }

    public void xK(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hVD.getResources().getString(e.j.post_to_home_page));
            bOC();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hVD.getResources().getString(e.j.post_to) + str);
        bOD();
    }

    private void bOC() {
        this.hVG = new StateSwitchView(this.hVD);
        this.hVG.setStateString(this.hVD.getString(e.j.public_to_all), this.hVD.getString(e.j.public_to_me));
        this.hVG.setBackgroundId(e.f.state_switch_bg);
        this.hVG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hVG.arh();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.hVD, e.C0210e.ds34), l.h(this.hVD, e.C0210e.ds16));
        this.caH.addView(this.hVG, layoutParams);
    }

    private void bOD() {
        this.hVG = new StateSwitchView(this.hVD);
        this.hVG.setStateString(this.hVD.getString(e.j.display_to_home_page), this.hVD.getString(e.j.display_to_home_page));
        this.hVG.setLeftStateDrawable(e.f.icon_share_home_select_ok, e.f.icon_share_home_select);
        this.hVG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hVG.arh();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.hVD, e.C0210e.ds34), l.h(this.hVD, e.C0210e.ds16));
        this.hVG.setTextSize(0, this.hVD.getResources().getDimensionPixelSize(e.C0210e.ds28));
        this.caH.addView(this.hVG, layoutParams);
    }

    public void bOE() {
        this.hVK.az(null);
        this.hVK.oq(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hVK.az(postWriteCallBackData.getSensitiveWords());
            this.hVK.xr(postWriteCallBackData.getErrorString());
            if (!v.I(this.hVK.bMU())) {
                oA(true);
            }
        }
    }

    public void oA(boolean z) {
        if (this.hVF.getText() != null) {
            int selectionEnd = this.hVF.getSelectionEnd();
            SpannableStringBuilder b = this.hVK.b(this.hVF.getText());
            if (b != null) {
                this.hVK.or(true);
                this.hVF.setText(b);
                if (z && this.hVK.bMV() >= 0) {
                    this.hVF.requestFocus();
                    this.hVF.setSelection(this.hVK.bMV());
                } else {
                    this.hVF.setSelection(selectionEnd);
                }
                this.hVK.oq(this.hVK.bMV() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bOF() {
        return this.hVK;
    }

    public void oB(boolean z) {
        if (z) {
            this.hVL.setVisibility(8);
            this.hVI.setVisibility(0);
            this.bHu.smoothScrollTo(0, this.hVI.getBottom());
        }
    }
}
