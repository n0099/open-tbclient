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
    public static int hFv = 60;
    private RelativeLayout bNB;
    private ScrollView dqb;
    private WriteLocationView hFA;
    private TextView hFB;
    private ImageView hFC;
    private com.baidu.tieba.write.b hFD;
    private LinearLayout hFE;
    private ListView hFF;
    private a hFG;
    private LinearLayout hFH;
    private TextView hFI;
    private TextView hFJ;
    private TextView hFK;
    private boolean hFL = true;
    private WriteVideoActivity hFw;
    private TextView hFx;
    private EditText hFy;
    private StateSwitchView hFz;
    private CustomVideoView hoO;
    private ImageView hoR;
    private int hoY;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.hFw = writeVideoActivity;
        this.hFw.setContentView(e.h.write_video_activity);
        this.hFD = new com.baidu.tieba.write.b();
        this.hFD.vI(e.d.cp_cont_i);
        this.hFD.vJ(e.d.cp_cont_h_alpha85);
        bJF();
        initView();
    }

    private void bJF() {
        this.bNB = (RelativeLayout) this.hFw.findViewById(e.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hFw.findViewById(e.g.navigation_bar);
        this.hFy = (EditText) this.hFw.findViewById(e.g.edit_content);
        this.hFB = (TextView) this.hFw.findViewById(e.g.text_content_size);
        this.hoR = (ImageView) this.hFw.findViewById(e.g.video_cover);
        this.hFA = (WriteLocationView) this.hFw.findViewById(e.g.location);
        this.hoO = (CustomVideoView) this.hFw.findViewById(e.g.preview_videoview);
        this.dqb = (ScrollView) this.hFw.findViewById(e.g.write_scrollview);
        this.hoO.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.hoO.getWidth() != b.this.hoR.getWidth() || b.this.hoO.getHeight() != b.this.hoR.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.hoR.getLayoutParams();
                    layoutParams.width = b.this.hoO.getWidth();
                    layoutParams.height = b.this.hoO.getHeight();
                    b.this.hoR.setLayoutParams(layoutParams);
                }
                b.this.hoR.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hoO.start();
                        b.this.hoR.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.hoO.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.bR(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hFE = (LinearLayout) this.hFw.findViewById(e.g.video_activity_title_container);
        this.hFF = (ListView) this.hFw.findViewById(e.g.video_activity_title_list);
        this.hFF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.hFE.setVisibility(8);
                b.this.hFB.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.hFy.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.hFy.requestFocus();
                    if (!TextUtils.isEmpty(b.this.hFy.getText())) {
                        b.this.hFy.setSelection(b.this.hFy.getText().length());
                    }
                    l.b(b.this.hFw, b.this.hFy);
                }
            }
        });
        this.hFH = (LinearLayout) this.hFw.findViewById(e.g.save_video_wrapper);
        this.hFI = (TextView) this.hFw.findViewById(e.g.save_video_ridiobutton);
        this.hFJ = (TextView) this.hFw.findViewById(e.g.save_video_ridiotext);
        this.hFK = (TextView) this.hFw.findViewById(e.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.hFw) / l.h(this.hFw, e.C0141e.ds440)) {
            i3 = l.aO(this.hFw);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.hFw, e.C0141e.ds440);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.hoO.setVideoHeight(i4);
        this.hoO.setVideoWidth(i3);
        this.hoO.invalidate();
    }

    private void initView() {
        this.hFC = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.nav_close_layout, this.hFw);
        this.mNavigationBar.setCenterTextTitle(this.hFw.getPageContext().getString(e.j.post_video_title));
        this.hFx = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.nav_text_send_layout, this.hFw);
        this.hFx.setText(e.j.send_post);
        this.hFy.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hFy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.hFG != null && b.this.hFG.getCount() > 0) {
                    l.a(b.this.hFw, b.this.hFy);
                    b.this.hFE.setVisibility(0);
                    b.this.hFB.setVisibility(8);
                }
                long bJH = b.hFv - b.this.bJH();
                if (bJH >= 0) {
                    al.h(b.this.hFB, e.d.cp_cont_e);
                    b.this.hFB.setText(String.valueOf(bJH));
                    return;
                }
                b.this.hFB.setText("0");
                b.this.hFy.setText(b.this.hFy.getText().toString().substring(0, b.hFv));
                b.this.hFy.setSelection(b.this.hFy.getText().length());
                b.this.hFw.showToast(b.this.hFw.getResources().getString(e.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.hFD != null) {
                    if (!b.this.hFD.bIh()) {
                        b.this.nU(false);
                    }
                    b.this.hFD.nL(false);
                }
            }
        });
        this.hFG = new a();
        this.hFF.setAdapter((ListAdapter) this.hFG);
        this.hFL = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hFL) {
            al.i(this.hFI, e.f.corner_bg_radio_selected);
        } else {
            al.i(this.hFI, e.f.corner_bg_radio_unselected);
        }
        al.h(this.hFJ, e.d.cp_cont_g);
        this.hFH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hFL) {
                    b.this.hFL = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    al.i(b.this.hFI, e.f.corner_bg_radio_unselected);
                    b.this.hFI.invalidate();
                    return;
                }
                b.this.hFL = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                al.i(b.this.hFI, e.f.corner_bg_radio_selected);
                b.this.hFI.invalidate();
            }
        });
    }

    public void bJG() {
        if (this.hFK != null) {
            this.hFK.setVisibility(0);
        }
    }

    public void wA(String str) {
        int i;
        int i2 = 0;
        Bitmap tU = tU(str);
        if (tU != null && tU.getHeight() != 0) {
            if (tU.getHeight() <= 0) {
                i = 0;
            } else if (tU.getWidth() / tU.getHeight() > l.aO(this.hFw) / l.h(this.hFw, e.C0141e.ds440)) {
                i = l.aO(this.hFw);
                if (tU.getWidth() > 0) {
                    i2 = (int) ((i / tU.getWidth()) * tU.getHeight());
                }
            } else {
                int h = l.h(this.hFw, e.C0141e.ds440);
                if (tU.getWidth() > 0) {
                    i = (int) ((h / tU.getHeight()) * tU.getWidth());
                    i2 = h;
                } else {
                    i = 0;
                    i2 = h;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hoR.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hoR.setLayoutParams(layoutParams);
            this.hoR.setImageBitmap(tU);
        }
    }

    private Bitmap tU(String str) {
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
        this.hFw.getLayoutMode().setNightMode(i == 1);
        this.hFw.getLayoutMode().onModeChanged(this.bNB);
        this.mNavigationBar.onChangeSkinType(this.hFw.getPageContext(), i);
        al.c(this.hFC, e.f.icon_return_bg_s);
        al.c(this.hFx, e.d.cp_link_tip_a, 1);
        al.i(this.hFA, e.f.corner_bg);
        al.h(this.hFK, e.d.cp_cont_e);
        this.hFL = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hFL) {
            al.i(this.hFI, e.f.corner_bg_radio_selected);
        } else {
            al.i(this.hFI, e.f.corner_bg_radio_unselected);
        }
        if (this.hFA != null) {
            this.hFA.onChangeSkinType(i);
        }
        if (this.hFz != null) {
            this.hFz.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hFy.getText() == null) {
            return null;
        }
        return this.hFy.getText().toString();
    }

    public long bJH() {
        if (this.hFy.getText() == null || this.hFy.getText().toString() == null) {
            return 0L;
        }
        return this.hFy.getText().length();
    }

    public WriteLocationView bJI() {
        return this.hFA;
    }

    public View bJJ() {
        return this.hFx;
    }

    public View getBackButton() {
        return this.hFC;
    }

    public EditText bJK() {
        return this.hFy;
    }

    public StateSwitchView bJL() {
        return this.hFz;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                wA(thumbPath);
                this.hoR.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hoR.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hoR.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.hoO.setVideoPath(videoPath);
                this.hoO.start();
            }
        }
        if (!v.z(list)) {
            this.hFG.dS(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hFy.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hFG.dS(arrayList);
            this.hFy.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bEJ() {
        if (this.hoO != null) {
            this.hoO.resume();
            this.hoO.seekTo(this.hoY);
            this.hoO.start();
        }
    }

    public void ayo() {
        this.hoY = this.hoO.getCurrentPosition();
        if (this.hoO != null) {
            this.hoO.stopPlayback();
        }
    }

    public void wB(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hFw.getResources().getString(e.j.post_to_home_page));
            bJM();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hFw.getResources().getString(e.j.post_to) + str);
        bJN();
    }

    private void bJM() {
        this.hFz = new StateSwitchView(this.hFw);
        this.hFz.setStateString(this.hFw.getString(e.j.public_to_all), this.hFw.getString(e.j.public_to_me));
        this.hFz.setBackgroundId(e.f.state_switch_bg);
        this.hFz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hFz.amu();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.hFw, e.C0141e.ds34), l.h(this.hFw, e.C0141e.ds16));
        this.bNB.addView(this.hFz, layoutParams);
    }

    private void bJN() {
        this.hFz = new StateSwitchView(this.hFw);
        this.hFz.setStateString(this.hFw.getString(e.j.display_to_home_page), this.hFw.getString(e.j.display_to_home_page));
        this.hFz.setLeftStateDrawable(e.f.icon_share_home_select_ok, e.f.icon_share_home_select);
        this.hFz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hFz.amu();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.hFw, e.C0141e.ds34), l.h(this.hFw, e.C0141e.ds16));
        this.hFz.setTextSize(0, this.hFw.getResources().getDimensionPixelSize(e.C0141e.ds28));
        this.bNB.addView(this.hFz, layoutParams);
    }

    public void bJO() {
        this.hFD.aA(null);
        this.hFD.nK(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hFD.aA(postWriteCallBackData.getSensitiveWords());
            this.hFD.wi(postWriteCallBackData.getErrorString());
            if (!v.z(this.hFD.bIe())) {
                nU(true);
            }
        }
    }

    public void nU(boolean z) {
        if (this.hFy.getText() != null) {
            int selectionEnd = this.hFy.getSelectionEnd();
            SpannableStringBuilder b = this.hFD.b(this.hFy.getText());
            if (b != null) {
                this.hFD.nL(true);
                this.hFy.setText(b);
                if (z && this.hFD.bIf() >= 0) {
                    this.hFy.requestFocus();
                    this.hFy.setSelection(this.hFD.bIf());
                } else {
                    this.hFy.setSelection(selectionEnd);
                }
                this.hFD.nK(this.hFD.bIf() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bJP() {
        return this.hFD;
    }

    public void nV(boolean z) {
        if (z) {
            this.hFE.setVisibility(8);
            this.hFB.setVisibility(0);
            this.dqb.smoothScrollTo(0, this.hFB.getBottom());
        }
    }
}
