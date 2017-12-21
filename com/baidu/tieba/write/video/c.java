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
import com.baidu.tbadk.core.util.aj;
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
/* loaded from: classes2.dex */
public class c {
    public static int hix = 31;
    private RelativeLayout bvz;
    private ScrollView cFG;
    private ImageView eve;
    private CustomVideoView gUT;
    private ImageView gUW;
    private int gVd;
    private EditText hiA;
    private StateSwitchView hiB;
    private WriteLocationView hiC;
    private TextView hiD;
    private com.baidu.tieba.write.b hiE;
    private LinearLayout hiF;
    private ListView hiG;
    private b hiH;
    private LinearLayout hiI;
    private TextView hiJ;
    private TextView hiK;
    private boolean hiL = true;
    private WriteVideoActivity hiy;
    private TextView hiz;
    private NavigationBar mNavigationBar;

    public c(WriteVideoActivity writeVideoActivity) {
        this.hiy = writeVideoActivity;
        this.hiy.setContentView(d.h.write_video_activity);
        this.hiE = new com.baidu.tieba.write.b();
        this.hiE.vM(d.C0095d.cp_cont_i);
        this.hiE.vN(d.C0095d.cp_cont_h_alpha85);
        bHc();
        initView();
    }

    private void bHc() {
        this.bvz = (RelativeLayout) this.hiy.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hiy.findViewById(d.g.navigation_bar);
        this.hiA = (EditText) this.hiy.findViewById(d.g.edit_content);
        this.hiD = (TextView) this.hiy.findViewById(d.g.text_content_size);
        this.gUW = (ImageView) this.hiy.findViewById(d.g.video_cover);
        this.hiC = (WriteLocationView) this.hiy.findViewById(d.g.location);
        this.gUT = (CustomVideoView) this.hiy.findViewById(d.g.preview_videoview);
        this.cFG = (ScrollView) this.hiy.findViewById(d.g.write_scrollview);
        this.gUT.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.c.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (c.this.gUT.getWidth() != c.this.gUW.getWidth() || c.this.gUT.getHeight() != c.this.gUW.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = c.this.gUW.getLayoutParams();
                    layoutParams.width = c.this.gUT.getWidth();
                    layoutParams.height = c.this.gUT.getHeight();
                    c.this.gUW.setLayoutParams(layoutParams);
                }
                c.this.gUW.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.gUT.start();
                        c.this.gUW.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.gUT.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.c.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                c.this.cd(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hiF = (LinearLayout) this.hiy.findViewById(d.g.video_activity_title_container);
        this.hiG = (ListView) this.hiy.findViewById(d.g.video_activity_title_list);
        this.hiG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.hiF.setVisibility(8);
                c.this.hiD.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    c.this.hiA.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    c.this.hiA.requestFocus();
                    if (!TextUtils.isEmpty(c.this.hiA.getText())) {
                        c.this.hiA.setSelection(c.this.hiA.getText().length());
                    }
                    l.b(c.this.hiy, c.this.hiA);
                }
            }
        });
        this.hiI = (LinearLayout) this.hiy.findViewById(d.g.save_video_wrapper);
        this.hiJ = (TextView) this.hiy.findViewById(d.g.save_video_ridiobutton);
        this.hiK = (TextView) this.hiy.findViewById(d.g.save_video_ridiotext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ac(this.hiy) / l.f(this.hiy, d.e.ds440)) {
            i3 = l.ac(this.hiy);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.hiy, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.gUT.setVideoHeight(i4);
        this.gUT.setVideoWidth(i3);
        this.gUT.invalidate();
    }

    private void initView() {
        this.eve = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.hiy);
        this.mNavigationBar.setCenterTextTitle(this.hiy.getPageContext().getString(d.j.post_video_title));
        this.hiz = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.hiy);
        this.hiz.setText(d.j.send_post);
        this.hiA.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.c.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hiA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.c.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && c.this.hiH != null && c.this.hiH.getCount() > 0) {
                    l.a(c.this.hiy, c.this.hiA);
                    c.this.hiF.setVisibility(0);
                    c.this.hiD.setVisibility(8);
                }
                long bHd = c.hix - c.this.bHd();
                if (bHd >= 0) {
                    aj.i(c.this.hiD, d.C0095d.cp_cont_e);
                    c.this.hiD.setText(String.valueOf(bHd));
                    return;
                }
                c.this.hiD.setText("0");
                c.this.hiA.setText(c.this.hiA.getText().toString().substring(0, c.hix));
                c.this.hiA.setSelection(c.this.hiA.getText().length());
                c.this.hiy.showToast(c.this.hiy.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (c.this.hiE != null) {
                    if (!c.this.hiE.bFH()) {
                        c.this.ob(false);
                    }
                    c.this.hiE.nU(false);
                }
            }
        });
        this.hiH = new b();
        this.hiG.setAdapter((ListAdapter) this.hiH);
        this.hiL = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hiL) {
            aj.j(this.hiJ, d.f.corner_bg_radio_selected);
        } else {
            aj.j(this.hiJ, d.f.corner_bg_radio_unselected);
        }
        aj.i(this.hiK, d.C0095d.cp_cont_g);
        this.hiI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hiL) {
                    c.this.hiL = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    aj.j(c.this.hiJ, d.f.corner_bg_radio_unselected);
                    c.this.hiJ.invalidate();
                    return;
                }
                c.this.hiL = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                aj.j(c.this.hiJ, d.f.corner_bg_radio_selected);
                c.this.hiJ.invalidate();
            }
        });
    }

    public void uO(String str) {
        int i;
        int i2 = 0;
        Bitmap sp = sp(str);
        if (sp != null && sp.getHeight() != 0) {
            if (sp.getHeight() <= 0) {
                i = 0;
            } else if (sp.getWidth() / sp.getHeight() > l.ac(this.hiy) / l.f(this.hiy, d.e.ds440)) {
                i = l.ac(this.hiy);
                if (sp.getWidth() > 0) {
                    i2 = (int) ((i / sp.getWidth()) * sp.getHeight());
                }
            } else {
                int f = l.f(this.hiy, d.e.ds440);
                if (sp.getWidth() > 0) {
                    i = (int) ((f / sp.getHeight()) * sp.getWidth());
                    i2 = f;
                } else {
                    i = 0;
                    i2 = f;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.gUW.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.gUW.setLayoutParams(layoutParams);
            this.gUW.setImageBitmap(sp);
        }
    }

    private Bitmap sp(String str) {
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
        this.hiy.getLayoutMode().ag(i == 1);
        this.hiy.getLayoutMode().t(this.bvz);
        this.mNavigationBar.onChangeSkinType(this.hiy.getPageContext(), i);
        aj.c(this.eve, d.f.icon_return_bg_s);
        aj.c(this.hiz, d.C0095d.cp_link_tip_a, 1);
        aj.j(this.hiC, d.f.corner_bg);
        this.hiL = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hiL) {
            aj.j(this.hiJ, d.f.corner_bg_radio_selected);
        } else {
            aj.j(this.hiJ, d.f.corner_bg_radio_unselected);
        }
        if (this.hiC != null) {
            this.hiC.onChangeSkinType(i);
        }
        if (this.hiB != null) {
            this.hiB.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hiA.getText() == null) {
            return null;
        }
        return this.hiA.getText().toString();
    }

    public long bHd() {
        if (this.hiA.getText() == null || this.hiA.getText().toString() == null) {
            return 0L;
        }
        return this.hiA.getText().length();
    }

    public WriteLocationView bHe() {
        return this.hiC;
    }

    public View bHf() {
        return this.hiz;
    }

    public View getBackButton() {
        return this.eve;
    }

    public EditText bHg() {
        return this.hiA;
    }

    public StateSwitchView bHh() {
        return this.hiB;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                uO(thumbPath);
                this.gUW.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.7
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.gUW.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.gUW.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.gUT.setVideoPath(videoPath);
                this.gUT.start();
            }
        }
        if (!v.w(list)) {
            this.hiH.dX(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hiA.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hiH.dX(arrayList);
            this.hiA.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bCO() {
        if (this.gUT != null) {
            this.gUT.resume();
            this.gUT.seekTo(this.gVd);
            this.gUT.start();
        }
    }

    public void amM() {
        this.gVd = this.gUT.getCurrentPosition();
        if (this.gUT != null) {
            this.gUT.stopPlayback();
        }
    }

    public void uP(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hiy.getResources().getString(d.j.post_to_home_page));
            bHi();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hiy.getResources().getString(d.j.post_to) + str);
        bHj();
    }

    private void bHi() {
        this.hiB = new StateSwitchView(this.hiy);
        this.hiB.cq(this.hiy.getString(d.j.public_to_all), this.hiy.getString(d.j.public_to_me));
        this.hiB.setBackgroundId(d.f.state_switch_bg);
        this.hiB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hiB.bGM();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.f(this.hiy, d.e.ds34), l.f(this.hiy, d.e.ds16));
        this.bvz.addView(this.hiB, layoutParams);
    }

    private void bHj() {
        this.hiB = new StateSwitchView(this.hiy);
        this.hiB.cq(this.hiy.getString(d.j.display_to_home_page), this.hiy.getString(d.j.display_to_home_page));
        this.hiB.ch(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.hiB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hiB.bGM();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.f(this.hiy, d.e.ds34), l.f(this.hiy, d.e.ds16));
        this.hiB.setTextSize(0, this.hiy.getResources().getDimensionPixelSize(d.e.ds28));
        this.bvz.addView(this.hiB, layoutParams);
    }

    public void bHk() {
        this.hiE.aC(null);
        this.hiE.nT(false);
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hiE.aC(postWriteCallBackData.getSensitiveWords());
            this.hiE.uB(postWriteCallBackData.getErrorString());
            if (!v.w(this.hiE.bFE())) {
                ob(true);
            }
        }
    }

    public void ob(boolean z) {
        if (this.hiA.getText() != null) {
            int selectionEnd = this.hiA.getSelectionEnd();
            SpannableStringBuilder b = this.hiE.b(this.hiA.getText());
            if (b != null) {
                this.hiE.nU(true);
                this.hiA.setText(b);
                if (z && this.hiE.bFF() >= 0) {
                    this.hiA.requestFocus();
                    this.hiA.setSelection(this.hiE.bFF());
                } else {
                    this.hiA.setSelection(selectionEnd);
                }
                this.hiE.nT(this.hiE.bFF() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bHl() {
        return this.hiE;
    }

    public void oc(boolean z) {
        if (z) {
            this.hiF.setVisibility(8);
            this.hiD.setVisibility(0);
            this.cFG.smoothScrollTo(0, this.hiD.getBottom());
        }
    }
}
