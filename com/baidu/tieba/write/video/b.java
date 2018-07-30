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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
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
    public static int hwW = 31;
    private RelativeLayout bHM;
    private ScrollView dkk;
    private CustomVideoView hgX;
    private ImageView hha;
    private int hhh;
    private WriteVideoActivity hwX;
    private TextView hwY;
    private EditText hwZ;
    private StateSwitchView hxa;
    private WriteLocationView hxb;
    private TextView hxc;
    private ImageView hxd;
    private com.baidu.tieba.write.b hxe;
    private LinearLayout hxf;
    private ListView hxg;
    private a hxh;
    private LinearLayout hxi;
    private TextView hxj;
    private TextView hxk;
    private TextView hxl;
    private boolean hxm = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.hwX = writeVideoActivity;
        this.hwX.setContentView(d.h.write_video_activity);
        this.hxe = new com.baidu.tieba.write.b();
        this.hxe.vi(d.C0140d.cp_cont_i);
        this.hxe.vj(d.C0140d.cp_cont_h_alpha85);
        bGK();
        initView();
    }

    private void bGK() {
        this.bHM = (RelativeLayout) this.hwX.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hwX.findViewById(d.g.navigation_bar);
        this.hwZ = (EditText) this.hwX.findViewById(d.g.edit_content);
        this.hxc = (TextView) this.hwX.findViewById(d.g.text_content_size);
        this.hha = (ImageView) this.hwX.findViewById(d.g.video_cover);
        this.hxb = (WriteLocationView) this.hwX.findViewById(d.g.location);
        this.hgX = (CustomVideoView) this.hwX.findViewById(d.g.preview_videoview);
        this.dkk = (ScrollView) this.hwX.findViewById(d.g.write_scrollview);
        this.hgX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.hgX.getWidth() != b.this.hha.getWidth() || b.this.hgX.getHeight() != b.this.hha.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.hha.getLayoutParams();
                    layoutParams.width = b.this.hgX.getWidth();
                    layoutParams.height = b.this.hgX.getHeight();
                    b.this.hha.setLayoutParams(layoutParams);
                }
                b.this.hha.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hgX.start();
                        b.this.hha.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.hgX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.bP(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hxf = (LinearLayout) this.hwX.findViewById(d.g.video_activity_title_container);
        this.hxg = (ListView) this.hwX.findViewById(d.g.video_activity_title_list);
        this.hxg.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.hxf.setVisibility(8);
                b.this.hxc.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.hwZ.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.hwZ.requestFocus();
                    if (!TextUtils.isEmpty(b.this.hwZ.getText())) {
                        b.this.hwZ.setSelection(b.this.hwZ.getText().length());
                    }
                    l.b(b.this.hwX, b.this.hwZ);
                }
            }
        });
        this.hxi = (LinearLayout) this.hwX.findViewById(d.g.save_video_wrapper);
        this.hxj = (TextView) this.hwX.findViewById(d.g.save_video_ridiobutton);
        this.hxk = (TextView) this.hwX.findViewById(d.g.save_video_ridiotext);
        this.hxl = (TextView) this.hwX.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ah(this.hwX) / l.f(this.hwX, d.e.ds440)) {
            i3 = l.ah(this.hwX);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.hwX, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.hgX.setVideoHeight(i4);
        this.hgX.setVideoWidth(i3);
        this.hgX.invalidate();
    }

    private void initView() {
        this.hxd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.hwX);
        this.mNavigationBar.setCenterTextTitle(this.hwX.getPageContext().getString(d.j.post_video_title));
        this.hwY = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.hwX);
        this.hwY.setText(d.j.send_post);
        this.hwZ.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hwZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.hxh != null && b.this.hxh.getCount() > 0) {
                    l.a(b.this.hwX, b.this.hwZ);
                    b.this.hxf.setVisibility(0);
                    b.this.hxc.setVisibility(8);
                }
                long bGM = b.hwW - b.this.bGM();
                if (bGM >= 0) {
                    am.h(b.this.hxc, d.C0140d.cp_cont_e);
                    b.this.hxc.setText(String.valueOf(bGM));
                    return;
                }
                b.this.hxc.setText("0");
                b.this.hwZ.setText(b.this.hwZ.getText().toString().substring(0, b.hwW));
                b.this.hwZ.setSelection(b.this.hwZ.getText().length());
                b.this.hwX.showToast(b.this.hwX.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.hxe != null) {
                    if (!b.this.hxe.bFm()) {
                        b.this.nx(false);
                    }
                    b.this.hxe.no(false);
                }
            }
        });
        this.hxh = new a();
        this.hxg.setAdapter((ListAdapter) this.hxh);
        this.hxm = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hxm) {
            am.i(this.hxj, d.f.corner_bg_radio_selected);
        } else {
            am.i(this.hxj, d.f.corner_bg_radio_unselected);
        }
        am.h(this.hxk, d.C0140d.cp_cont_g);
        this.hxi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hxm) {
                    b.this.hxm = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    am.i(b.this.hxj, d.f.corner_bg_radio_unselected);
                    b.this.hxj.invalidate();
                    return;
                }
                b.this.hxm = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                am.i(b.this.hxj, d.f.corner_bg_radio_selected);
                b.this.hxj.invalidate();
            }
        });
    }

    public void bGL() {
        if (this.hxl != null) {
            this.hxl.setVisibility(0);
        }
    }

    public void vL(String str) {
        int i;
        int i2 = 0;
        Bitmap tj = tj(str);
        if (tj != null && tj.getHeight() != 0) {
            if (tj.getHeight() <= 0) {
                i = 0;
            } else if (tj.getWidth() / tj.getHeight() > l.ah(this.hwX) / l.f(this.hwX, d.e.ds440)) {
                i = l.ah(this.hwX);
                if (tj.getWidth() > 0) {
                    i2 = (int) ((i / tj.getWidth()) * tj.getHeight());
                }
            } else {
                int f = l.f(this.hwX, d.e.ds440);
                if (tj.getWidth() > 0) {
                    i = (int) ((f / tj.getHeight()) * tj.getWidth());
                    i2 = f;
                } else {
                    i = 0;
                    i2 = f;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hha.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hha.setLayoutParams(layoutParams);
            this.hha.setImageBitmap(tj);
        }
    }

    private Bitmap tj(String str) {
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
        this.hwX.getLayoutMode().setNightMode(i == 1);
        this.hwX.getLayoutMode().onModeChanged(this.bHM);
        this.mNavigationBar.onChangeSkinType(this.hwX.getPageContext(), i);
        am.c(this.hxd, d.f.icon_return_bg_s);
        am.c(this.hwY, d.C0140d.cp_link_tip_a, 1);
        am.i(this.hxb, d.f.corner_bg);
        am.h(this.hxl, d.C0140d.cp_cont_e);
        this.hxm = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hxm) {
            am.i(this.hxj, d.f.corner_bg_radio_selected);
        } else {
            am.i(this.hxj, d.f.corner_bg_radio_unselected);
        }
        if (this.hxb != null) {
            this.hxb.onChangeSkinType(i);
        }
        if (this.hxa != null) {
            this.hxa.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hwZ.getText() == null) {
            return null;
        }
        return this.hwZ.getText().toString();
    }

    public long bGM() {
        if (this.hwZ.getText() == null || this.hwZ.getText().toString() == null) {
            return 0L;
        }
        return this.hwZ.getText().length();
    }

    public WriteLocationView bGN() {
        return this.hxb;
    }

    public View bGO() {
        return this.hwY;
    }

    public View getBackButton() {
        return this.hxd;
    }

    public EditText bGP() {
        return this.hwZ;
    }

    public StateSwitchView bGQ() {
        return this.hxa;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                vL(thumbPath);
                this.hha.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hha.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hha.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.hgX.setVideoPath(videoPath);
                this.hgX.start();
            }
        }
        if (!w.z(list)) {
            this.hxh.dR(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hwZ.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hxh.dR(arrayList);
            this.hwZ.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bBS() {
        if (this.hgX != null) {
            this.hgX.resume();
            this.hgX.seekTo(this.hhh);
            this.hgX.start();
        }
    }

    public void awf() {
        this.hhh = this.hgX.getCurrentPosition();
        if (this.hgX != null) {
            this.hgX.stopPlayback();
        }
    }

    public void vM(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hwX.getResources().getString(d.j.post_to_home_page));
            bGR();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hwX.getResources().getString(d.j.post_to) + str);
        bGS();
    }

    private void bGR() {
        this.hxa = new StateSwitchView(this.hwX);
        this.hxa.setStateString(this.hwX.getString(d.j.public_to_all), this.hwX.getString(d.j.public_to_me));
        this.hxa.setBackgroundId(d.f.state_switch_bg);
        this.hxa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hxa.akH();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.f(this.hwX, d.e.ds34), l.f(this.hwX, d.e.ds16));
        this.bHM.addView(this.hxa, layoutParams);
    }

    private void bGS() {
        this.hxa = new StateSwitchView(this.hwX);
        this.hxa.setStateString(this.hwX.getString(d.j.display_to_home_page), this.hwX.getString(d.j.display_to_home_page));
        this.hxa.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.hxa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hxa.akH();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.f(this.hwX, d.e.ds34), l.f(this.hwX, d.e.ds16));
        this.hxa.setTextSize(0, this.hwX.getResources().getDimensionPixelSize(d.e.ds28));
        this.bHM.addView(this.hxa, layoutParams);
    }

    public void bGT() {
        this.hxe.az(null);
        this.hxe.nn(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hxe.az(postWriteCallBackData.getSensitiveWords());
            this.hxe.vv(postWriteCallBackData.getErrorString());
            if (!w.z(this.hxe.bFj())) {
                nx(true);
            }
        }
    }

    public void nx(boolean z) {
        if (this.hwZ.getText() != null) {
            int selectionEnd = this.hwZ.getSelectionEnd();
            SpannableStringBuilder b = this.hxe.b(this.hwZ.getText());
            if (b != null) {
                this.hxe.no(true);
                this.hwZ.setText(b);
                if (z && this.hxe.bFk() >= 0) {
                    this.hwZ.requestFocus();
                    this.hwZ.setSelection(this.hxe.bFk());
                } else {
                    this.hwZ.setSelection(selectionEnd);
                }
                this.hxe.nn(this.hxe.bFk() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bGU() {
        return this.hxe;
    }

    public void ny(boolean z) {
        if (z) {
            this.hxf.setVisibility(8);
            this.hxc.setVisibility(0);
            this.dkk.smoothScrollTo(0, this.hxc.getBottom());
        }
    }
}
