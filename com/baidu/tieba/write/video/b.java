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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.editor.StateSwitchView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static int hwY = 31;
    private RelativeLayout bHM;
    private ScrollView dki;
    private CustomVideoView hgY;
    private ImageView hhb;
    private int hhi;
    private WriteVideoActivity hwZ;
    private TextView hxa;
    private EditText hxb;
    private StateSwitchView hxc;
    private WriteLocationView hxd;
    private TextView hxe;
    private ImageView hxf;
    private com.baidu.tieba.write.b hxg;
    private LinearLayout hxh;
    private ListView hxi;
    private a hxj;
    private LinearLayout hxk;
    private TextView hxl;
    private TextView hxm;
    private TextView hxn;
    private boolean hxo = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.hwZ = writeVideoActivity;
        this.hwZ.setContentView(f.h.write_video_activity);
        this.hxg = new com.baidu.tieba.write.b();
        this.hxg.vi(f.d.cp_cont_i);
        this.hxg.vj(f.d.cp_cont_h_alpha85);
        bGO();
        initView();
    }

    private void bGO() {
        this.bHM = (RelativeLayout) this.hwZ.findViewById(f.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hwZ.findViewById(f.g.navigation_bar);
        this.hxb = (EditText) this.hwZ.findViewById(f.g.edit_content);
        this.hxe = (TextView) this.hwZ.findViewById(f.g.text_content_size);
        this.hhb = (ImageView) this.hwZ.findViewById(f.g.video_cover);
        this.hxd = (WriteLocationView) this.hwZ.findViewById(f.g.location);
        this.hgY = (CustomVideoView) this.hwZ.findViewById(f.g.preview_videoview);
        this.dki = (ScrollView) this.hwZ.findViewById(f.g.write_scrollview);
        this.hgY.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.hgY.getWidth() != b.this.hhb.getWidth() || b.this.hgY.getHeight() != b.this.hhb.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.hhb.getLayoutParams();
                    layoutParams.width = b.this.hgY.getWidth();
                    layoutParams.height = b.this.hgY.getHeight();
                    b.this.hhb.setLayoutParams(layoutParams);
                }
                b.this.hhb.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hgY.start();
                        b.this.hhb.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.hgY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.bP(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hxh = (LinearLayout) this.hwZ.findViewById(f.g.video_activity_title_container);
        this.hxi = (ListView) this.hwZ.findViewById(f.g.video_activity_title_list);
        this.hxi.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.hxh.setVisibility(8);
                b.this.hxe.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.hxb.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.hxb.requestFocus();
                    if (!TextUtils.isEmpty(b.this.hxb.getText())) {
                        b.this.hxb.setSelection(b.this.hxb.getText().length());
                    }
                    l.b(b.this.hwZ, b.this.hxb);
                }
            }
        });
        this.hxk = (LinearLayout) this.hwZ.findViewById(f.g.save_video_wrapper);
        this.hxl = (TextView) this.hwZ.findViewById(f.g.save_video_ridiobutton);
        this.hxm = (TextView) this.hwZ.findViewById(f.g.save_video_ridiotext);
        this.hxn = (TextView) this.hwZ.findViewById(f.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ah(this.hwZ) / l.f(this.hwZ, f.e.ds440)) {
            i3 = l.ah(this.hwZ);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.hwZ, f.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.hgY.setVideoHeight(i4);
        this.hgY.setVideoWidth(i3);
        this.hgY.invalidate();
    }

    private void initView() {
        this.hxf = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, f.h.nav_close_layout, this.hwZ);
        this.mNavigationBar.setCenterTextTitle(this.hwZ.getPageContext().getString(f.j.post_video_title));
        this.hxa = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.nav_text_send_layout, this.hwZ);
        this.hxa.setText(f.j.send_post);
        this.hxb.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hxb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.hxj != null && b.this.hxj.getCount() > 0) {
                    l.a(b.this.hwZ, b.this.hxb);
                    b.this.hxh.setVisibility(0);
                    b.this.hxe.setVisibility(8);
                }
                long bGQ = b.hwY - b.this.bGQ();
                if (bGQ >= 0) {
                    am.h(b.this.hxe, f.d.cp_cont_e);
                    b.this.hxe.setText(String.valueOf(bGQ));
                    return;
                }
                b.this.hxe.setText("0");
                b.this.hxb.setText(b.this.hxb.getText().toString().substring(0, b.hwY));
                b.this.hxb.setSelection(b.this.hxb.getText().length());
                b.this.hwZ.showToast(b.this.hwZ.getResources().getString(f.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.hxg != null) {
                    if (!b.this.hxg.bFq()) {
                        b.this.nx(false);
                    }
                    b.this.hxg.no(false);
                }
            }
        });
        this.hxj = new a();
        this.hxi.setAdapter((ListAdapter) this.hxj);
        this.hxo = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hxo) {
            am.i(this.hxl, f.C0146f.corner_bg_radio_selected);
        } else {
            am.i(this.hxl, f.C0146f.corner_bg_radio_unselected);
        }
        am.h(this.hxm, f.d.cp_cont_g);
        this.hxk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hxo) {
                    b.this.hxo = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    am.i(b.this.hxl, f.C0146f.corner_bg_radio_unselected);
                    b.this.hxl.invalidate();
                    return;
                }
                b.this.hxo = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                am.i(b.this.hxl, f.C0146f.corner_bg_radio_selected);
                b.this.hxl.invalidate();
            }
        });
    }

    public void bGP() {
        if (this.hxn != null) {
            this.hxn.setVisibility(0);
        }
    }

    public void vP(String str) {
        int i;
        int i2 = 0;
        Bitmap tn = tn(str);
        if (tn != null && tn.getHeight() != 0) {
            if (tn.getHeight() <= 0) {
                i = 0;
            } else if (tn.getWidth() / tn.getHeight() > l.ah(this.hwZ) / l.f(this.hwZ, f.e.ds440)) {
                i = l.ah(this.hwZ);
                if (tn.getWidth() > 0) {
                    i2 = (int) ((i / tn.getWidth()) * tn.getHeight());
                }
            } else {
                int f = l.f(this.hwZ, f.e.ds440);
                if (tn.getWidth() > 0) {
                    i = (int) ((f / tn.getHeight()) * tn.getWidth());
                    i2 = f;
                } else {
                    i = 0;
                    i2 = f;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hhb.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hhb.setLayoutParams(layoutParams);
            this.hhb.setImageBitmap(tn);
        }
    }

    private Bitmap tn(String str) {
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
        this.hwZ.getLayoutMode().setNightMode(i == 1);
        this.hwZ.getLayoutMode().onModeChanged(this.bHM);
        this.mNavigationBar.onChangeSkinType(this.hwZ.getPageContext(), i);
        am.c(this.hxf, f.C0146f.icon_return_bg_s);
        am.c(this.hxa, f.d.cp_link_tip_a, 1);
        am.i(this.hxd, f.C0146f.corner_bg);
        am.h(this.hxn, f.d.cp_cont_e);
        this.hxo = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hxo) {
            am.i(this.hxl, f.C0146f.corner_bg_radio_selected);
        } else {
            am.i(this.hxl, f.C0146f.corner_bg_radio_unselected);
        }
        if (this.hxd != null) {
            this.hxd.onChangeSkinType(i);
        }
        if (this.hxc != null) {
            this.hxc.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hxb.getText() == null) {
            return null;
        }
        return this.hxb.getText().toString();
    }

    public long bGQ() {
        if (this.hxb.getText() == null || this.hxb.getText().toString() == null) {
            return 0L;
        }
        return this.hxb.getText().length();
    }

    public WriteLocationView bGR() {
        return this.hxd;
    }

    public View bGS() {
        return this.hxa;
    }

    public View getBackButton() {
        return this.hxf;
    }

    public EditText bGT() {
        return this.hxb;
    }

    public StateSwitchView bGU() {
        return this.hxc;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                vP(thumbPath);
                this.hhb.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hhb.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hhb.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.hgY.setVideoPath(videoPath);
                this.hgY.start();
            }
        }
        if (!w.z(list)) {
            this.hxj.dR(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hxb.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hxj.dR(arrayList);
            this.hxb.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bBU() {
        if (this.hgY != null) {
            this.hgY.resume();
            this.hgY.seekTo(this.hhi);
            this.hgY.start();
        }
    }

    public void awe() {
        this.hhi = this.hgY.getCurrentPosition();
        if (this.hgY != null) {
            this.hgY.stopPlayback();
        }
    }

    public void vQ(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hwZ.getResources().getString(f.j.post_to_home_page));
            bGV();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hwZ.getResources().getString(f.j.post_to) + str);
        bGW();
    }

    private void bGV() {
        this.hxc = new StateSwitchView(this.hwZ);
        this.hxc.setStateString(this.hwZ.getString(f.j.public_to_all), this.hwZ.getString(f.j.public_to_me));
        this.hxc.setBackgroundId(f.C0146f.state_switch_bg);
        this.hxc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hxc.akJ();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.f(this.hwZ, f.e.ds34), l.f(this.hwZ, f.e.ds16));
        this.bHM.addView(this.hxc, layoutParams);
    }

    private void bGW() {
        this.hxc = new StateSwitchView(this.hwZ);
        this.hxc.setStateString(this.hwZ.getString(f.j.display_to_home_page), this.hwZ.getString(f.j.display_to_home_page));
        this.hxc.setLeftStateDrawable(f.C0146f.icon_share_home_select_ok, f.C0146f.icon_share_home_select);
        this.hxc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hxc.akJ();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.f(this.hwZ, f.e.ds34), l.f(this.hwZ, f.e.ds16));
        this.hxc.setTextSize(0, this.hwZ.getResources().getDimensionPixelSize(f.e.ds28));
        this.bHM.addView(this.hxc, layoutParams);
    }

    public void bGX() {
        this.hxg.az(null);
        this.hxg.nn(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hxg.az(postWriteCallBackData.getSensitiveWords());
            this.hxg.vz(postWriteCallBackData.getErrorString());
            if (!w.z(this.hxg.bFn())) {
                nx(true);
            }
        }
    }

    public void nx(boolean z) {
        if (this.hxb.getText() != null) {
            int selectionEnd = this.hxb.getSelectionEnd();
            SpannableStringBuilder b = this.hxg.b(this.hxb.getText());
            if (b != null) {
                this.hxg.no(true);
                this.hxb.setText(b);
                if (z && this.hxg.bFo() >= 0) {
                    this.hxb.requestFocus();
                    this.hxb.setSelection(this.hxg.bFo());
                } else {
                    this.hxb.setSelection(selectionEnd);
                }
                this.hxg.nn(this.hxg.bFo() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bGY() {
        return this.hxg;
    }

    public void ny(boolean z) {
        if (z) {
            this.hxh.setVisibility(8);
            this.hxe.setVisibility(0);
            this.dki.smoothScrollTo(0, this.hxe.getBottom());
        }
    }
}
