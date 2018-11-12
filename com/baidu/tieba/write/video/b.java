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
    public static int hOs = 60;
    private ScrollView bDR;
    private RelativeLayout bWP;
    private com.baidu.tieba.write.b hOA;
    private LinearLayout hOB;
    private ListView hOC;
    private a hOD;
    private LinearLayout hOE;
    private TextView hOF;
    private TextView hOG;
    private TextView hOH;
    private boolean hOI = true;
    private WriteVideoActivity hOt;
    private TextView hOu;
    private EditText hOv;
    private StateSwitchView hOw;
    private WriteLocationView hOx;
    private TextView hOy;
    private ImageView hOz;
    private CustomVideoView hxN;
    private ImageView hxQ;
    private int hxX;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.hOt = writeVideoActivity;
        this.hOt.setContentView(e.h.write_video_activity);
        this.hOA = new com.baidu.tieba.write.b();
        this.hOA.wy(e.d.cp_cont_i);
        this.hOA.wz(e.d.cp_cont_h_alpha85);
        bMq();
        initView();
    }

    private void bMq() {
        this.bWP = (RelativeLayout) this.hOt.findViewById(e.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hOt.findViewById(e.g.navigation_bar);
        this.hOv = (EditText) this.hOt.findViewById(e.g.edit_content);
        this.hOy = (TextView) this.hOt.findViewById(e.g.text_content_size);
        this.hxQ = (ImageView) this.hOt.findViewById(e.g.video_cover);
        this.hOx = (WriteLocationView) this.hOt.findViewById(e.g.location);
        this.hxN = (CustomVideoView) this.hOt.findViewById(e.g.preview_videoview);
        this.bDR = (ScrollView) this.hOt.findViewById(e.g.write_scrollview);
        this.hxN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.hxN.getWidth() != b.this.hxQ.getWidth() || b.this.hxN.getHeight() != b.this.hxQ.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.hxQ.getLayoutParams();
                    layoutParams.width = b.this.hxN.getWidth();
                    layoutParams.height = b.this.hxN.getHeight();
                    b.this.hxQ.setLayoutParams(layoutParams);
                }
                b.this.hxQ.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hxN.start();
                        b.this.hxQ.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.hxN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.bY(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hOB = (LinearLayout) this.hOt.findViewById(e.g.video_activity_title_container);
        this.hOC = (ListView) this.hOt.findViewById(e.g.video_activity_title_list);
        this.hOC.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.hOB.setVisibility(8);
                b.this.hOy.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.hOv.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.hOv.requestFocus();
                    if (!TextUtils.isEmpty(b.this.hOv.getText())) {
                        b.this.hOv.setSelection(b.this.hOv.getText().length());
                    }
                    l.c(b.this.hOt, b.this.hOv);
                }
            }
        });
        this.hOE = (LinearLayout) this.hOt.findViewById(e.g.save_video_wrapper);
        this.hOF = (TextView) this.hOt.findViewById(e.g.save_video_ridiobutton);
        this.hOG = (TextView) this.hOt.findViewById(e.g.save_video_ridiotext);
        this.hOH = (TextView) this.hOt.findViewById(e.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.hOt) / l.h(this.hOt, e.C0200e.ds440)) {
            i3 = l.aO(this.hOt);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.hOt, e.C0200e.ds440);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.hxN.setVideoHeight(i4);
        this.hxN.setVideoWidth(i3);
        this.hxN.invalidate();
    }

    private void initView() {
        this.hOz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.nav_close_layout, this.hOt);
        this.mNavigationBar.setCenterTextTitle(this.hOt.getPageContext().getString(e.j.post_video_title));
        this.hOu = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.nav_text_send_layout, this.hOt);
        this.hOu.setText(e.j.send_post);
        this.hOv.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hOv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.hOD != null && b.this.hOD.getCount() > 0) {
                    l.b(b.this.hOt, b.this.hOv);
                    b.this.hOB.setVisibility(0);
                    b.this.hOy.setVisibility(8);
                }
                long bMs = b.hOs - b.this.bMs();
                if (bMs >= 0) {
                    al.h(b.this.hOy, e.d.cp_cont_e);
                    b.this.hOy.setText(String.valueOf(bMs));
                    return;
                }
                b.this.hOy.setText("0");
                b.this.hOv.setText(b.this.hOv.getText().toString().substring(0, b.hOs));
                b.this.hOv.setSelection(b.this.hOv.getText().length());
                b.this.hOt.showToast(b.this.hOt.getResources().getString(e.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.hOA != null) {
                    if (!b.this.hOA.bKS()) {
                        b.this.oy(false);
                    }
                    b.this.hOA.op(false);
                }
            }
        });
        this.hOD = new a();
        this.hOC.setAdapter((ListAdapter) this.hOD);
        this.hOI = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hOI) {
            al.i(this.hOF, e.f.corner_bg_radio_selected);
        } else {
            al.i(this.hOF, e.f.corner_bg_radio_unselected);
        }
        al.h(this.hOG, e.d.cp_cont_g);
        this.hOE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hOI) {
                    b.this.hOI = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    al.i(b.this.hOF, e.f.corner_bg_radio_unselected);
                    b.this.hOF.invalidate();
                    return;
                }
                b.this.hOI = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                al.i(b.this.hOF, e.f.corner_bg_radio_selected);
                b.this.hOF.invalidate();
            }
        });
    }

    public void bMr() {
        if (this.hOH != null) {
            this.hOH.setVisibility(0);
        }
    }

    public void xg(String str) {
        int i;
        int i2 = 0;
        Bitmap uA = uA(str);
        if (uA != null && uA.getHeight() != 0) {
            if (uA.getHeight() <= 0) {
                i = 0;
            } else if (uA.getWidth() / uA.getHeight() > l.aO(this.hOt) / l.h(this.hOt, e.C0200e.ds440)) {
                i = l.aO(this.hOt);
                if (uA.getWidth() > 0) {
                    i2 = (int) ((i / uA.getWidth()) * uA.getHeight());
                }
            } else {
                int h = l.h(this.hOt, e.C0200e.ds440);
                if (uA.getWidth() > 0) {
                    i = (int) ((h / uA.getHeight()) * uA.getWidth());
                    i2 = h;
                } else {
                    i = 0;
                    i2 = h;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hxQ.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hxQ.setLayoutParams(layoutParams);
            this.hxQ.setImageBitmap(uA);
        }
    }

    private Bitmap uA(String str) {
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
        this.hOt.getLayoutMode().setNightMode(i == 1);
        this.hOt.getLayoutMode().onModeChanged(this.bWP);
        this.mNavigationBar.onChangeSkinType(this.hOt.getPageContext(), i);
        al.c(this.hOz, e.f.icon_return_bg_s);
        al.c(this.hOu, e.d.cp_link_tip_a, 1);
        al.i(this.hOx, e.f.corner_bg);
        al.h(this.hOH, e.d.cp_cont_e);
        this.hOI = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hOI) {
            al.i(this.hOF, e.f.corner_bg_radio_selected);
        } else {
            al.i(this.hOF, e.f.corner_bg_radio_unselected);
        }
        if (this.hOx != null) {
            this.hOx.onChangeSkinType(i);
        }
        if (this.hOw != null) {
            this.hOw.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hOv.getText() == null) {
            return null;
        }
        return this.hOv.getText().toString();
    }

    public long bMs() {
        if (this.hOv.getText() == null || this.hOv.getText().toString() == null) {
            return 0L;
        }
        return this.hOv.getText().length();
    }

    public WriteLocationView bMt() {
        return this.hOx;
    }

    public View bMu() {
        return this.hOu;
    }

    public View getBackButton() {
        return this.hOz;
    }

    public EditText bMv() {
        return this.hOv;
    }

    public StateSwitchView bMw() {
        return this.hOw;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                xg(thumbPath);
                this.hxQ.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hxQ.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hxQ.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.hxN.setVideoPath(videoPath);
                this.hxN.start();
            }
        }
        if (!v.I(list)) {
            this.hOD.ee(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hOv.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hOD.ee(arrayList);
            this.hOv.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bHv() {
        if (this.hxN != null) {
            this.hxN.resume();
            this.hxN.seekTo(this.hxX);
            this.hxN.start();
        }
    }

    public void aBh() {
        this.hxX = this.hxN.getCurrentPosition();
        if (this.hxN != null) {
            this.hxN.stopPlayback();
        }
    }

    public void xh(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hOt.getResources().getString(e.j.post_to_home_page));
            bMx();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hOt.getResources().getString(e.j.post_to) + str);
        bMy();
    }

    private void bMx() {
        this.hOw = new StateSwitchView(this.hOt);
        this.hOw.setStateString(this.hOt.getString(e.j.public_to_all), this.hOt.getString(e.j.public_to_me));
        this.hOw.setBackgroundId(e.f.state_switch_bg);
        this.hOw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hOw.apv();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.hOt, e.C0200e.ds34), l.h(this.hOt, e.C0200e.ds16));
        this.bWP.addView(this.hOw, layoutParams);
    }

    private void bMy() {
        this.hOw = new StateSwitchView(this.hOt);
        this.hOw.setStateString(this.hOt.getString(e.j.display_to_home_page), this.hOt.getString(e.j.display_to_home_page));
        this.hOw.setLeftStateDrawable(e.f.icon_share_home_select_ok, e.f.icon_share_home_select);
        this.hOw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hOw.apv();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.hOt, e.C0200e.ds34), l.h(this.hOt, e.C0200e.ds16));
        this.hOw.setTextSize(0, this.hOt.getResources().getDimensionPixelSize(e.C0200e.ds28));
        this.bWP.addView(this.hOw, layoutParams);
    }

    public void bMz() {
        this.hOA.az(null);
        this.hOA.oo(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hOA.az(postWriteCallBackData.getSensitiveWords());
            this.hOA.wO(postWriteCallBackData.getErrorString());
            if (!v.I(this.hOA.bKP())) {
                oy(true);
            }
        }
    }

    public void oy(boolean z) {
        if (this.hOv.getText() != null) {
            int selectionEnd = this.hOv.getSelectionEnd();
            SpannableStringBuilder b = this.hOA.b(this.hOv.getText());
            if (b != null) {
                this.hOA.op(true);
                this.hOv.setText(b);
                if (z && this.hOA.bKQ() >= 0) {
                    this.hOv.requestFocus();
                    this.hOv.setSelection(this.hOA.bKQ());
                } else {
                    this.hOv.setSelection(selectionEnd);
                }
                this.hOA.oo(this.hOA.bKQ() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bMA() {
        return this.hOA;
    }

    public void oz(boolean z) {
        if (z) {
            this.hOB.setVisibility(8);
            this.hOy.setVisibility(0);
            this.bDR.smoothScrollTo(0, this.hOy.getBottom());
        }
    }
}
