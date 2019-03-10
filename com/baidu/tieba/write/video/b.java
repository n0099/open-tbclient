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
    public static int jqY = 60;
    private ScrollView aYC;
    private RelativeLayout dqx;
    private CustomVideoView iZY;
    private ImageView jab;
    private int jai;
    private WriteVideoActivity jqZ;
    private TextView jra;
    private EditText jrb;
    private StateSwitchView jrc;
    private WriteLocationView jrd;
    private TextView jre;
    private ImageView jrf;
    private com.baidu.tieba.write.b jrg;
    private LinearLayout jrh;
    private ListView jri;
    private a jrj;
    private LinearLayout jrk;
    private TextView jrl;
    private TextView jrm;
    private TextView jrn;
    private boolean jro = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.jqZ = writeVideoActivity;
        this.jqZ.setContentView(d.h.write_video_activity);
        this.jrg = new com.baidu.tieba.write.b();
        this.jrg.AW(d.C0236d.cp_btn_a);
        this.jrg.AX(d.C0236d.cp_cont_h_alpha85);
        cpN();
        initView();
    }

    private void cpN() {
        this.dqx = (RelativeLayout) this.jqZ.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.jqZ.findViewById(d.g.navigation_bar);
        this.jrb = (EditText) this.jqZ.findViewById(d.g.edit_content);
        this.jre = (TextView) this.jqZ.findViewById(d.g.text_content_size);
        this.jab = (ImageView) this.jqZ.findViewById(d.g.video_cover);
        this.jrd = (WriteLocationView) this.jqZ.findViewById(d.g.location);
        this.iZY = (CustomVideoView) this.jqZ.findViewById(d.g.preview_videoview);
        this.aYC = (ScrollView) this.jqZ.findViewById(d.g.write_scrollview);
        this.iZY.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.iZY.getWidth() != b.this.jab.getWidth() || b.this.iZY.getHeight() != b.this.jab.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.jab.getLayoutParams();
                    layoutParams.width = b.this.iZY.getWidth();
                    layoutParams.height = b.this.iZY.getHeight();
                    b.this.jab.setLayoutParams(layoutParams);
                }
                b.this.jab.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.iZY.start();
                        b.this.jab.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.iZY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cu(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jrh = (LinearLayout) this.jqZ.findViewById(d.g.video_activity_title_container);
        this.jri = (ListView) this.jqZ.findViewById(d.g.video_activity_title_list);
        this.jri.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.jrh.setVisibility(8);
                b.this.jre.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.jrb.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.jrb.requestFocus();
                    if (!TextUtils.isEmpty(b.this.jrb.getText())) {
                        b.this.jrb.setSelection(b.this.jrb.getText().length());
                    }
                    l.c(b.this.jqZ, b.this.jrb);
                }
            }
        });
        this.jrk = (LinearLayout) this.jqZ.findViewById(d.g.save_video_wrapper);
        this.jrl = (TextView) this.jqZ.findViewById(d.g.save_video_ridiobutton);
        this.jrm = (TextView) this.jqZ.findViewById(d.g.save_video_ridiotext);
        this.jrn = (TextView) this.jqZ.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.jqZ) / l.h(this.jqZ, d.e.ds440)) {
            i3 = l.aO(this.jqZ);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.jqZ, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.iZY.setVideoHeight(i4);
        this.iZY.setVideoWidth(i3);
        this.iZY.invalidate();
    }

    private void initView() {
        this.jrf = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.jqZ);
        this.mNavigationBar.setCenterTextTitle(this.jqZ.getPageContext().getString(d.j.post_video_title));
        this.jra = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.jqZ);
        this.jra.setText(d.j.send_post);
        this.jrb.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.jrb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.jrj != null && b.this.jrj.getCount() > 0) {
                    l.b(b.this.jqZ, b.this.jrb);
                    b.this.jrh.setVisibility(0);
                    b.this.jre.setVisibility(8);
                }
                long cpQ = b.jqY - b.this.cpQ();
                if (cpQ >= 0) {
                    al.j(b.this.jre, d.C0236d.cp_cont_e);
                    b.this.jre.setText(String.valueOf(cpQ));
                    return;
                }
                b.this.jre.setText("0");
                b.this.jrb.setText(b.this.jrb.getText().toString().substring(0, b.jqY));
                b.this.jrb.setSelection(b.this.jrb.getText().length());
                b.this.jqZ.showToast(b.this.jqZ.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.jrg != null) {
                    if (!b.this.jrg.cnY()) {
                        b.this.re(false);
                    }
                    b.this.jrg.qV(false);
                }
            }
        });
        this.jrj = new a();
        this.jri.setAdapter((ListAdapter) this.jrj);
        this.jro = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.jro) {
            al.k(this.jrl, d.f.corner_bg_radio_selected);
        } else {
            al.k(this.jrl, d.f.corner_bg_radio_unselected);
        }
        al.j(this.jrm, d.C0236d.cp_cont_g);
        this.jrk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jro) {
                    b.this.jro = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    al.k(b.this.jrl, d.f.corner_bg_radio_unselected);
                    b.this.jrl.invalidate();
                    return;
                }
                b.this.jro = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                al.k(b.this.jrl, d.f.corner_bg_radio_selected);
                b.this.jrl.invalidate();
            }
        });
    }

    public void cpO() {
        if (this.jrn != null) {
            this.jrn.setVisibility(0);
        }
    }

    public void ED(String str) {
        int i;
        int i2 = 0;
        Bitmap Cc = Cc(str);
        if (Cc != null && Cc.getHeight() != 0) {
            if (Cc.getHeight() <= 0) {
                i = 0;
            } else if (Cc.getWidth() / Cc.getHeight() > l.aO(this.jqZ) / l.h(this.jqZ, d.e.ds440)) {
                i = l.aO(this.jqZ);
                if (Cc.getWidth() > 0) {
                    i2 = (int) ((i / Cc.getWidth()) * Cc.getHeight());
                }
            } else {
                int h = l.h(this.jqZ, d.e.ds440);
                if (Cc.getWidth() > 0) {
                    i = (int) ((h / Cc.getHeight()) * Cc.getWidth());
                    i2 = h;
                } else {
                    i = 0;
                    i2 = h;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jab.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.jab.setLayoutParams(layoutParams);
            this.jab.setImageBitmap(Cc);
        }
    }

    private Bitmap Cc(String str) {
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

    public TextView cpP() {
        return this.mNavigationBar.mCenterText;
    }

    public void onChangeSkinType(int i) {
        this.jqZ.getLayoutMode().setNightMode(i == 1);
        this.jqZ.getLayoutMode().onModeChanged(this.dqx);
        this.mNavigationBar.onChangeSkinType(this.jqZ.getPageContext(), i);
        al.c(this.jrf, d.f.icon_return_bg_s);
        al.d(this.jra, d.C0236d.cp_link_tip_a, 1);
        al.k(this.jrd, d.f.corner_bg);
        al.j(this.jrn, d.C0236d.cp_cont_e);
        this.jro = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.jro) {
            al.k(this.jrl, d.f.corner_bg_radio_selected);
        } else {
            al.k(this.jrl, d.f.corner_bg_radio_unselected);
        }
        if (this.jrd != null) {
            this.jrd.onChangeSkinType(i);
        }
        if (this.jrc != null) {
            this.jrc.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.jrb.getText() == null) {
            return null;
        }
        return this.jrb.getText().toString();
    }

    public long cpQ() {
        if (this.jrb.getText() == null || this.jrb.getText().toString() == null) {
            return 0L;
        }
        return this.jrb.getText().length();
    }

    public WriteLocationView cpR() {
        return this.jrd;
    }

    public View cpS() {
        return this.jra;
    }

    public View getBackButton() {
        return this.jrf;
    }

    public EditText cpT() {
        return this.jrb;
    }

    public StateSwitchView cpU() {
        return this.jrc;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                ED(thumbPath);
                this.jab.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jab.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.jab.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.iZY.setVideoPath(videoPath);
                this.iZY.start();
            }
        }
        if (!v.T(list)) {
            this.jrj.ep(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.jrb.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.jrj.ep(arrayList);
            this.jrb.setText("#" + videoTitleData.name + "#");
        }
    }

    public void ckw() {
        if (this.iZY != null) {
            this.iZY.resume();
            this.iZY.seekTo(this.jai);
            this.iZY.start();
        }
    }

    public void beN() {
        this.jai = this.iZY.getCurrentPosition();
        if (this.iZY != null) {
            this.iZY.stopPlayback();
        }
    }

    public void EE(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.jqZ.getResources().getString(d.j.post_to_home_page));
            cpV();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.jqZ.getResources().getString(d.j.post_to) + str);
        cpW();
    }

    private void cpV() {
        this.jrc = new StateSwitchView(this.jqZ);
        this.jrc.setStateString(this.jqZ.getString(d.j.public_to_all), this.jqZ.getString(d.j.public_to_me));
        this.jrc.setBackgroundId(d.f.state_switch_bg);
        this.jrc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jrc.aSn();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.jqZ, d.e.ds34), l.h(this.jqZ, d.e.ds16));
        this.dqx.addView(this.jrc, layoutParams);
    }

    private void cpW() {
        this.jrc = new StateSwitchView(this.jqZ);
        this.jrc.setStateString(this.jqZ.getString(d.j.display_to_home_page), this.jqZ.getString(d.j.display_to_home_page));
        this.jrc.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.jrc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jrc.aSn();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.jqZ, d.e.ds34), l.h(this.jqZ, d.e.ds16));
        this.jrc.setTextSize(0, this.jqZ.getResources().getDimensionPixelSize(d.e.ds28));
        this.dqx.addView(this.jrc, layoutParams);
    }

    public void cpX() {
        this.jrg.aE(null);
        this.jrg.qU(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jrg.aE(postWriteCallBackData.getSensitiveWords());
            this.jrg.El(postWriteCallBackData.getErrorString());
            if (!v.T(this.jrg.cnV())) {
                re(true);
            }
        }
    }

    public void re(boolean z) {
        if (this.jrb.getText() != null) {
            int selectionEnd = this.jrb.getSelectionEnd();
            SpannableStringBuilder b = this.jrg.b(this.jrb.getText());
            if (b != null) {
                this.jrg.qV(true);
                this.jrb.setText(b);
                if (z && this.jrg.cnW() >= 0) {
                    this.jrb.requestFocus();
                    this.jrb.setSelection(this.jrg.cnW());
                } else {
                    this.jrb.setSelection(selectionEnd);
                }
                this.jrg.qU(this.jrg.cnW() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b cpY() {
        return this.jrg;
    }

    public void rf(boolean z) {
        if (z) {
            this.jrh.setVisibility(8);
            this.jre.setVisibility(0);
            this.aYC.smoothScrollTo(0, this.jre.getBottom());
        }
    }
}
