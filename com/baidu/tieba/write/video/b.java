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
import com.baidu.tbadk.core.util.ak;
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
    public static int hfM = 31;
    private RelativeLayout bwZ;
    private ScrollView cWr;
    private ImageView eIn;
    private CustomVideoView gQb;
    private ImageView gQe;
    private int gQl;
    private WriteVideoActivity hfN;
    private TextView hfO;
    private EditText hfP;
    private StateSwitchView hfQ;
    private WriteLocationView hfR;
    private TextView hfS;
    private com.baidu.tieba.write.b hfT;
    private LinearLayout hfU;
    private ListView hfV;
    private a hfW;
    private LinearLayout hfX;
    private TextView hfY;
    private TextView hfZ;
    private TextView hga;
    private boolean hgb = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.hfN = writeVideoActivity;
        this.hfN.setContentView(d.i.write_video_activity);
        this.hfT = new com.baidu.tieba.write.b();
        this.hfT.uJ(d.C0126d.cp_cont_i);
        this.hfT.uK(d.C0126d.cp_cont_h_alpha85);
        bCt();
        initView();
    }

    private void bCt() {
        this.bwZ = (RelativeLayout) this.hfN.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hfN.findViewById(d.g.navigation_bar);
        this.hfP = (EditText) this.hfN.findViewById(d.g.edit_content);
        this.hfS = (TextView) this.hfN.findViewById(d.g.text_content_size);
        this.gQe = (ImageView) this.hfN.findViewById(d.g.video_cover);
        this.hfR = (WriteLocationView) this.hfN.findViewById(d.g.location);
        this.gQb = (CustomVideoView) this.hfN.findViewById(d.g.preview_videoview);
        this.cWr = (ScrollView) this.hfN.findViewById(d.g.write_scrollview);
        this.gQb.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.gQb.getWidth() != b.this.gQe.getWidth() || b.this.gQb.getHeight() != b.this.gQe.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.gQe.getLayoutParams();
                    layoutParams.width = b.this.gQb.getWidth();
                    layoutParams.height = b.this.gQb.getHeight();
                    b.this.gQe.setLayoutParams(layoutParams);
                }
                b.this.gQe.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.gQb.start();
                        b.this.gQe.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.gQb.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.bO(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hfU = (LinearLayout) this.hfN.findViewById(d.g.video_activity_title_container);
        this.hfV = (ListView) this.hfN.findViewById(d.g.video_activity_title_list);
        this.hfV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                b.this.hfU.setVisibility(8);
                b.this.hfS.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.hfP.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.hfP.requestFocus();
                    if (!TextUtils.isEmpty(b.this.hfP.getText())) {
                        b.this.hfP.setSelection(b.this.hfP.getText().length());
                    }
                    l.c(b.this.hfN, b.this.hfP);
                }
            }
        });
        this.hfX = (LinearLayout) this.hfN.findViewById(d.g.save_video_wrapper);
        this.hfY = (TextView) this.hfN.findViewById(d.g.save_video_ridiobutton);
        this.hfZ = (TextView) this.hfN.findViewById(d.g.save_video_ridiotext);
        this.hga = (TextView) this.hfN.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.af(this.hfN) / l.e(this.hfN, d.e.ds440)) {
            i3 = l.af(this.hfN);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int e = l.e(this.hfN, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((e / i2) * i);
                i4 = e;
            } else {
                i3 = 0;
                i4 = e;
            }
        }
        this.gQb.setVideoHeight(i4);
        this.gQb.setVideoWidth(i3);
        this.gQb.invalidate();
    }

    private void initView() {
        this.eIn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.nav_close_layout, this.hfN);
        this.mNavigationBar.setCenterTextTitle(this.hfN.getPageContext().getString(d.k.post_video_title));
        this.hfO = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.nav_text_send_layout, this.hfN);
        this.hfO.setText(d.k.send_post);
        this.hfP.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view2, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hfP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.hfW != null && b.this.hfW.getCount() > 0) {
                    l.b(b.this.hfN, b.this.hfP);
                    b.this.hfU.setVisibility(0);
                    b.this.hfS.setVisibility(8);
                }
                long bCv = b.hfM - b.this.bCv();
                if (bCv >= 0) {
                    ak.h(b.this.hfS, d.C0126d.cp_cont_e);
                    b.this.hfS.setText(String.valueOf(bCv));
                    return;
                }
                b.this.hfS.setText("0");
                b.this.hfP.setText(b.this.hfP.getText().toString().substring(0, b.hfM));
                b.this.hfP.setSelection(b.this.hfP.getText().length());
                b.this.hfN.showToast(b.this.hfN.getResources().getString(d.k.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.hfT != null) {
                    if (!b.this.hfT.bAV()) {
                        b.this.nt(false);
                    }
                    b.this.hfT.nk(false);
                }
            }
        });
        this.hfW = new a();
        this.hfV.setAdapter((ListAdapter) this.hfW);
        this.hgb = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hgb) {
            ak.i(this.hfY, d.f.corner_bg_radio_selected);
        } else {
            ak.i(this.hfY, d.f.corner_bg_radio_unselected);
        }
        ak.h(this.hfZ, d.C0126d.cp_cont_g);
        this.hfX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.hgb) {
                    b.this.hgb = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    ak.i(b.this.hfY, d.f.corner_bg_radio_unselected);
                    b.this.hfY.invalidate();
                    return;
                }
                b.this.hgb = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                ak.i(b.this.hfY, d.f.corner_bg_radio_selected);
                b.this.hfY.invalidate();
            }
        });
    }

    public void bCu() {
        if (this.hga != null) {
            this.hga.setVisibility(0);
        }
    }

    public void uU(String str) {
        int i;
        int i2 = 0;
        Bitmap sv = sv(str);
        if (sv != null && sv.getHeight() != 0) {
            if (sv.getHeight() <= 0) {
                i = 0;
            } else if (sv.getWidth() / sv.getHeight() > l.af(this.hfN) / l.e(this.hfN, d.e.ds440)) {
                i = l.af(this.hfN);
                if (sv.getWidth() > 0) {
                    i2 = (int) ((i / sv.getWidth()) * sv.getHeight());
                }
            } else {
                int e = l.e(this.hfN, d.e.ds440);
                if (sv.getWidth() > 0) {
                    i = (int) ((e / sv.getHeight()) * sv.getWidth());
                    i2 = e;
                } else {
                    i = 0;
                    i2 = e;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.gQe.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.gQe.setLayoutParams(layoutParams);
            this.gQe.setImageBitmap(sv);
        }
    }

    private Bitmap sv(String str) {
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
        this.hfN.getLayoutMode().setNightMode(i == 1);
        this.hfN.getLayoutMode().u(this.bwZ);
        this.mNavigationBar.onChangeSkinType(this.hfN.getPageContext(), i);
        ak.c(this.eIn, d.f.icon_return_bg_s);
        ak.c(this.hfO, d.C0126d.cp_link_tip_a, 1);
        ak.i(this.hfR, d.f.corner_bg);
        ak.h(this.hga, d.C0126d.cp_cont_e);
        this.hgb = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hgb) {
            ak.i(this.hfY, d.f.corner_bg_radio_selected);
        } else {
            ak.i(this.hfY, d.f.corner_bg_radio_unselected);
        }
        if (this.hfR != null) {
            this.hfR.onChangeSkinType(i);
        }
        if (this.hfQ != null) {
            this.hfQ.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hfP.getText() == null) {
            return null;
        }
        return this.hfP.getText().toString();
    }

    public long bCv() {
        if (this.hfP.getText() == null || this.hfP.getText().toString() == null) {
            return 0L;
        }
        return this.hfP.getText().length();
    }

    public WriteLocationView bCw() {
        return this.hfR;
    }

    public View bCx() {
        return this.hfO;
    }

    public View getBackButton() {
        return this.eIn;
    }

    public EditText bCy() {
        return this.hfP;
    }

    public StateSwitchView bCz() {
        return this.hfQ;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                uU(thumbPath);
                this.gQe.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.gQe.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.gQe.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.gQb.setVideoPath(videoPath);
                this.gQb.start();
            }
        }
        if (!v.w(list)) {
            this.hfW.dM(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hfP.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hfW.dM(arrayList);
            this.hfP.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bxA() {
        if (this.gQb != null) {
            this.gQb.resume();
            this.gQb.seekTo(this.gQl);
            this.gQb.start();
        }
    }

    public void aqR() {
        this.gQl = this.gQb.getCurrentPosition();
        if (this.gQb != null) {
            this.gQb.stopPlayback();
        }
    }

    public void uV(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hfN.getResources().getString(d.k.post_to_home_page));
            bCA();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hfN.getResources().getString(d.k.post_to) + str);
        bCB();
    }

    private void bCA() {
        this.hfQ = new StateSwitchView(this.hfN);
        this.hfQ.setStateString(this.hfN.getString(d.k.public_to_all), this.hfN.getString(d.k.public_to_me));
        this.hfQ.setBackgroundId(d.f.state_switch_bg);
        this.hfQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.hfQ.bCd();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.e(this.hfN, d.e.ds34), l.e(this.hfN, d.e.ds16));
        this.bwZ.addView(this.hfQ, layoutParams);
    }

    private void bCB() {
        this.hfQ = new StateSwitchView(this.hfN);
        this.hfQ.setStateString(this.hfN.getString(d.k.display_to_home_page), this.hfN.getString(d.k.display_to_home_page));
        this.hfQ.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.hfQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.hfQ.bCd();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.e(this.hfN, d.e.ds34), l.e(this.hfN, d.e.ds16));
        this.hfQ.setTextSize(0, this.hfN.getResources().getDimensionPixelSize(d.e.ds28));
        this.bwZ.addView(this.hfQ, layoutParams);
    }

    public void bCC() {
        this.hfT.ax(null);
        this.hfT.nj(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hfT.ax(postWriteCallBackData.getSensitiveWords());
            this.hfT.uE(postWriteCallBackData.getErrorString());
            if (!v.w(this.hfT.bAS())) {
                nt(true);
            }
        }
    }

    public void nt(boolean z) {
        if (this.hfP.getText() != null) {
            int selectionEnd = this.hfP.getSelectionEnd();
            SpannableStringBuilder b = this.hfT.b(this.hfP.getText());
            if (b != null) {
                this.hfT.nk(true);
                this.hfP.setText(b);
                if (z && this.hfT.bAT() >= 0) {
                    this.hfP.requestFocus();
                    this.hfP.setSelection(this.hfT.bAT());
                } else {
                    this.hfP.setSelection(selectionEnd);
                }
                this.hfT.nj(this.hfT.bAT() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bCD() {
        return this.hfT;
    }

    public void nu(boolean z) {
        if (z) {
            this.hfU.setVisibility(8);
            this.hfS.setVisibility(0);
            this.cWr.smoothScrollTo(0, this.hfS.getBottom());
        }
    }
}
