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
    public static int his = 31;
    private RelativeLayout bvv;
    private ScrollView cFC;
    private ImageView eva;
    private CustomVideoView gUO;
    private ImageView gUR;
    private int gUY;
    private LinearLayout hiA;
    private ListView hiB;
    private b hiC;
    private LinearLayout hiD;
    private TextView hiE;
    private TextView hiF;
    private boolean hiG = true;
    private WriteVideoActivity hit;
    private TextView hiu;
    private EditText hiv;
    private StateSwitchView hiw;
    private WriteLocationView hix;
    private TextView hiy;
    private com.baidu.tieba.write.b hiz;
    private NavigationBar mNavigationBar;

    public c(WriteVideoActivity writeVideoActivity) {
        this.hit = writeVideoActivity;
        this.hit.setContentView(d.h.write_video_activity);
        this.hiz = new com.baidu.tieba.write.b();
        this.hiz.vM(d.C0096d.cp_cont_i);
        this.hiz.vN(d.C0096d.cp_cont_h_alpha85);
        bHb();
        initView();
    }

    private void bHb() {
        this.bvv = (RelativeLayout) this.hit.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hit.findViewById(d.g.navigation_bar);
        this.hiv = (EditText) this.hit.findViewById(d.g.edit_content);
        this.hiy = (TextView) this.hit.findViewById(d.g.text_content_size);
        this.gUR = (ImageView) this.hit.findViewById(d.g.video_cover);
        this.hix = (WriteLocationView) this.hit.findViewById(d.g.location);
        this.gUO = (CustomVideoView) this.hit.findViewById(d.g.preview_videoview);
        this.cFC = (ScrollView) this.hit.findViewById(d.g.write_scrollview);
        this.gUO.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.c.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (c.this.gUO.getWidth() != c.this.gUR.getWidth() || c.this.gUO.getHeight() != c.this.gUR.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = c.this.gUR.getLayoutParams();
                    layoutParams.width = c.this.gUO.getWidth();
                    layoutParams.height = c.this.gUO.getHeight();
                    c.this.gUR.setLayoutParams(layoutParams);
                }
                c.this.gUR.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.gUO.start();
                        c.this.gUR.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.gUO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.c.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                c.this.cd(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hiA = (LinearLayout) this.hit.findViewById(d.g.video_activity_title_container);
        this.hiB = (ListView) this.hit.findViewById(d.g.video_activity_title_list);
        this.hiB.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.hiA.setVisibility(8);
                c.this.hiy.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    c.this.hiv.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    c.this.hiv.requestFocus();
                    if (!TextUtils.isEmpty(c.this.hiv.getText())) {
                        c.this.hiv.setSelection(c.this.hiv.getText().length());
                    }
                    l.b(c.this.hit, c.this.hiv);
                }
            }
        });
        this.hiD = (LinearLayout) this.hit.findViewById(d.g.save_video_wrapper);
        this.hiE = (TextView) this.hit.findViewById(d.g.save_video_ridiobutton);
        this.hiF = (TextView) this.hit.findViewById(d.g.save_video_ridiotext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ac(this.hit) / l.f(this.hit, d.e.ds440)) {
            i3 = l.ac(this.hit);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.hit, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.gUO.setVideoHeight(i4);
        this.gUO.setVideoWidth(i3);
        this.gUO.invalidate();
    }

    private void initView() {
        this.eva = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.hit);
        this.mNavigationBar.setCenterTextTitle(this.hit.getPageContext().getString(d.j.post_video_title));
        this.hiu = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.hit);
        this.hiu.setText(d.j.send_post);
        this.hiv.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.c.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hiv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.c.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && c.this.hiC != null && c.this.hiC.getCount() > 0) {
                    l.a(c.this.hit, c.this.hiv);
                    c.this.hiA.setVisibility(0);
                    c.this.hiy.setVisibility(8);
                }
                long bHc = c.his - c.this.bHc();
                if (bHc >= 0) {
                    aj.i(c.this.hiy, d.C0096d.cp_cont_e);
                    c.this.hiy.setText(String.valueOf(bHc));
                    return;
                }
                c.this.hiy.setText("0");
                c.this.hiv.setText(c.this.hiv.getText().toString().substring(0, c.his));
                c.this.hiv.setSelection(c.this.hiv.getText().length());
                c.this.hit.showToast(c.this.hit.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (c.this.hiz != null) {
                    if (!c.this.hiz.bFG()) {
                        c.this.ob(false);
                    }
                    c.this.hiz.nU(false);
                }
            }
        });
        this.hiC = new b();
        this.hiB.setAdapter((ListAdapter) this.hiC);
        this.hiG = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hiG) {
            aj.j(this.hiE, d.f.corner_bg_radio_selected);
        } else {
            aj.j(this.hiE, d.f.corner_bg_radio_unselected);
        }
        aj.i(this.hiF, d.C0096d.cp_cont_g);
        this.hiD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hiG) {
                    c.this.hiG = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    aj.j(c.this.hiE, d.f.corner_bg_radio_unselected);
                    c.this.hiE.invalidate();
                    return;
                }
                c.this.hiG = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                aj.j(c.this.hiE, d.f.corner_bg_radio_selected);
                c.this.hiE.invalidate();
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
            } else if (sp.getWidth() / sp.getHeight() > l.ac(this.hit) / l.f(this.hit, d.e.ds440)) {
                i = l.ac(this.hit);
                if (sp.getWidth() > 0) {
                    i2 = (int) ((i / sp.getWidth()) * sp.getHeight());
                }
            } else {
                int f = l.f(this.hit, d.e.ds440);
                if (sp.getWidth() > 0) {
                    i = (int) ((f / sp.getHeight()) * sp.getWidth());
                    i2 = f;
                } else {
                    i = 0;
                    i2 = f;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.gUR.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.gUR.setLayoutParams(layoutParams);
            this.gUR.setImageBitmap(sp);
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
        this.hit.getLayoutMode().ag(i == 1);
        this.hit.getLayoutMode().t(this.bvv);
        this.mNavigationBar.onChangeSkinType(this.hit.getPageContext(), i);
        aj.c(this.eva, d.f.icon_return_bg_s);
        aj.c(this.hiu, d.C0096d.cp_link_tip_a, 1);
        aj.j(this.hix, d.f.corner_bg);
        this.hiG = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hiG) {
            aj.j(this.hiE, d.f.corner_bg_radio_selected);
        } else {
            aj.j(this.hiE, d.f.corner_bg_radio_unselected);
        }
        if (this.hix != null) {
            this.hix.onChangeSkinType(i);
        }
        if (this.hiw != null) {
            this.hiw.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hiv.getText() == null) {
            return null;
        }
        return this.hiv.getText().toString();
    }

    public long bHc() {
        if (this.hiv.getText() == null || this.hiv.getText().toString() == null) {
            return 0L;
        }
        return this.hiv.getText().length();
    }

    public WriteLocationView bHd() {
        return this.hix;
    }

    public View bHe() {
        return this.hiu;
    }

    public View getBackButton() {
        return this.eva;
    }

    public EditText bHf() {
        return this.hiv;
    }

    public StateSwitchView bHg() {
        return this.hiw;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                uO(thumbPath);
                this.gUR.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.7
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.gUR.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.gUR.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.gUO.setVideoPath(videoPath);
                this.gUO.start();
            }
        }
        if (!v.w(list)) {
            this.hiC.dX(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hiv.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hiC.dX(arrayList);
            this.hiv.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bCN() {
        if (this.gUO != null) {
            this.gUO.resume();
            this.gUO.seekTo(this.gUY);
            this.gUO.start();
        }
    }

    public void amL() {
        this.gUY = this.gUO.getCurrentPosition();
        if (this.gUO != null) {
            this.gUO.stopPlayback();
        }
    }

    public void uP(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hit.getResources().getString(d.j.post_to_home_page));
            bHh();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hit.getResources().getString(d.j.post_to) + str);
        bHi();
    }

    private void bHh() {
        this.hiw = new StateSwitchView(this.hit);
        this.hiw.cq(this.hit.getString(d.j.public_to_all), this.hit.getString(d.j.public_to_me));
        this.hiw.setBackgroundId(d.f.state_switch_bg);
        this.hiw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hiw.bGL();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.f(this.hit, d.e.ds34), l.f(this.hit, d.e.ds16));
        this.bvv.addView(this.hiw, layoutParams);
    }

    private void bHi() {
        this.hiw = new StateSwitchView(this.hit);
        this.hiw.cq(this.hit.getString(d.j.display_to_home_page), this.hit.getString(d.j.display_to_home_page));
        this.hiw.ch(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.hiw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hiw.bGL();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.f(this.hit, d.e.ds34), l.f(this.hit, d.e.ds16));
        this.hiw.setTextSize(0, this.hit.getResources().getDimensionPixelSize(d.e.ds28));
        this.bvv.addView(this.hiw, layoutParams);
    }

    public void bHj() {
        this.hiz.aC(null);
        this.hiz.nT(false);
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hiz.aC(postWriteCallBackData.getSensitiveWords());
            this.hiz.uB(postWriteCallBackData.getErrorString());
            if (!v.w(this.hiz.bFD())) {
                ob(true);
            }
        }
    }

    public void ob(boolean z) {
        if (this.hiv.getText() != null) {
            int selectionEnd = this.hiv.getSelectionEnd();
            SpannableStringBuilder b = this.hiz.b(this.hiv.getText());
            if (b != null) {
                this.hiz.nU(true);
                this.hiv.setText(b);
                if (z && this.hiz.bFE() >= 0) {
                    this.hiv.requestFocus();
                    this.hiv.setSelection(this.hiz.bFE());
                } else {
                    this.hiv.setSelection(selectionEnd);
                }
                this.hiz.nT(this.hiz.bFE() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bHk() {
        return this.hiz;
    }

    public void oc(boolean z) {
        if (z) {
            this.hiA.setVisibility(8);
            this.hiy.setVisibility(0);
            this.cFC.smoothScrollTo(0, this.hiy.getBottom());
        }
    }
}
