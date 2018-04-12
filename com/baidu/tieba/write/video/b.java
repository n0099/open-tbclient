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
    public static int heL = 31;
    private RelativeLayout bwi;
    private ScrollView cVn;
    private ImageView eHi;
    private CustomVideoView gPb;
    private ImageView gPe;
    private int gPl;
    private WriteVideoActivity heM;
    private TextView heN;
    private EditText heO;
    private StateSwitchView heP;
    private WriteLocationView heQ;
    private TextView heR;
    private com.baidu.tieba.write.b heS;
    private LinearLayout heT;
    private ListView heU;
    private a heV;
    private LinearLayout heW;
    private TextView heX;
    private TextView heY;
    private TextView heZ;
    private boolean hfa = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.heM = writeVideoActivity;
        this.heM.setContentView(d.i.write_video_activity);
        this.heS = new com.baidu.tieba.write.b();
        this.heS.uL(d.C0126d.cp_cont_i);
        this.heS.uM(d.C0126d.cp_cont_h_alpha85);
        bCv();
        initView();
    }

    private void bCv() {
        this.bwi = (RelativeLayout) this.heM.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.heM.findViewById(d.g.navigation_bar);
        this.heO = (EditText) this.heM.findViewById(d.g.edit_content);
        this.heR = (TextView) this.heM.findViewById(d.g.text_content_size);
        this.gPe = (ImageView) this.heM.findViewById(d.g.video_cover);
        this.heQ = (WriteLocationView) this.heM.findViewById(d.g.location);
        this.gPb = (CustomVideoView) this.heM.findViewById(d.g.preview_videoview);
        this.cVn = (ScrollView) this.heM.findViewById(d.g.write_scrollview);
        this.gPb.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.gPb.getWidth() != b.this.gPe.getWidth() || b.this.gPb.getHeight() != b.this.gPe.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.gPe.getLayoutParams();
                    layoutParams.width = b.this.gPb.getWidth();
                    layoutParams.height = b.this.gPb.getHeight();
                    b.this.gPe.setLayoutParams(layoutParams);
                }
                b.this.gPe.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.gPb.start();
                        b.this.gPe.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.gPb.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.bP(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.heT = (LinearLayout) this.heM.findViewById(d.g.video_activity_title_container);
        this.heU = (ListView) this.heM.findViewById(d.g.video_activity_title_list);
        this.heU.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                b.this.heT.setVisibility(8);
                b.this.heR.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.heO.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.heO.requestFocus();
                    if (!TextUtils.isEmpty(b.this.heO.getText())) {
                        b.this.heO.setSelection(b.this.heO.getText().length());
                    }
                    l.c(b.this.heM, b.this.heO);
                }
            }
        });
        this.heW = (LinearLayout) this.heM.findViewById(d.g.save_video_wrapper);
        this.heX = (TextView) this.heM.findViewById(d.g.save_video_ridiobutton);
        this.heY = (TextView) this.heM.findViewById(d.g.save_video_ridiotext);
        this.heZ = (TextView) this.heM.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.af(this.heM) / l.e(this.heM, d.e.ds440)) {
            i3 = l.af(this.heM);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int e = l.e(this.heM, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((e / i2) * i);
                i4 = e;
            } else {
                i3 = 0;
                i4 = e;
            }
        }
        this.gPb.setVideoHeight(i4);
        this.gPb.setVideoWidth(i3);
        this.gPb.invalidate();
    }

    private void initView() {
        this.eHi = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.nav_close_layout, this.heM);
        this.mNavigationBar.setCenterTextTitle(this.heM.getPageContext().getString(d.k.post_video_title));
        this.heN = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.nav_text_send_layout, this.heM);
        this.heN.setText(d.k.send_post);
        this.heO.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view2, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.heO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.heV != null && b.this.heV.getCount() > 0) {
                    l.b(b.this.heM, b.this.heO);
                    b.this.heT.setVisibility(0);
                    b.this.heR.setVisibility(8);
                }
                long bCx = b.heL - b.this.bCx();
                if (bCx >= 0) {
                    ak.h(b.this.heR, d.C0126d.cp_cont_e);
                    b.this.heR.setText(String.valueOf(bCx));
                    return;
                }
                b.this.heR.setText("0");
                b.this.heO.setText(b.this.heO.getText().toString().substring(0, b.heL));
                b.this.heO.setSelection(b.this.heO.getText().length());
                b.this.heM.showToast(b.this.heM.getResources().getString(d.k.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.heS != null) {
                    if (!b.this.heS.bAX()) {
                        b.this.ns(false);
                    }
                    b.this.heS.nj(false);
                }
            }
        });
        this.heV = new a();
        this.heU.setAdapter((ListAdapter) this.heV);
        this.hfa = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hfa) {
            ak.i(this.heX, d.f.corner_bg_radio_selected);
        } else {
            ak.i(this.heX, d.f.corner_bg_radio_unselected);
        }
        ak.h(this.heY, d.C0126d.cp_cont_g);
        this.heW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.hfa) {
                    b.this.hfa = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    ak.i(b.this.heX, d.f.corner_bg_radio_unselected);
                    b.this.heX.invalidate();
                    return;
                }
                b.this.hfa = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                ak.i(b.this.heX, d.f.corner_bg_radio_selected);
                b.this.heX.invalidate();
            }
        });
    }

    public void bCw() {
        if (this.heZ != null) {
            this.heZ.setVisibility(0);
        }
    }

    public void uR(String str) {
        int i;
        int i2 = 0;
        Bitmap ss = ss(str);
        if (ss != null && ss.getHeight() != 0) {
            if (ss.getHeight() <= 0) {
                i = 0;
            } else if (ss.getWidth() / ss.getHeight() > l.af(this.heM) / l.e(this.heM, d.e.ds440)) {
                i = l.af(this.heM);
                if (ss.getWidth() > 0) {
                    i2 = (int) ((i / ss.getWidth()) * ss.getHeight());
                }
            } else {
                int e = l.e(this.heM, d.e.ds440);
                if (ss.getWidth() > 0) {
                    i = (int) ((e / ss.getHeight()) * ss.getWidth());
                    i2 = e;
                } else {
                    i = 0;
                    i2 = e;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.gPe.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.gPe.setLayoutParams(layoutParams);
            this.gPe.setImageBitmap(ss);
        }
    }

    private Bitmap ss(String str) {
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
        this.heM.getLayoutMode().setNightMode(i == 1);
        this.heM.getLayoutMode().u(this.bwi);
        this.mNavigationBar.onChangeSkinType(this.heM.getPageContext(), i);
        ak.c(this.eHi, d.f.icon_return_bg_s);
        ak.c(this.heN, d.C0126d.cp_link_tip_a, 1);
        ak.i(this.heQ, d.f.corner_bg);
        ak.h(this.heZ, d.C0126d.cp_cont_e);
        this.hfa = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hfa) {
            ak.i(this.heX, d.f.corner_bg_radio_selected);
        } else {
            ak.i(this.heX, d.f.corner_bg_radio_unselected);
        }
        if (this.heQ != null) {
            this.heQ.onChangeSkinType(i);
        }
        if (this.heP != null) {
            this.heP.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.heO.getText() == null) {
            return null;
        }
        return this.heO.getText().toString();
    }

    public long bCx() {
        if (this.heO.getText() == null || this.heO.getText().toString() == null) {
            return 0L;
        }
        return this.heO.getText().length();
    }

    public WriteLocationView bCy() {
        return this.heQ;
    }

    public View bCz() {
        return this.heN;
    }

    public View getBackButton() {
        return this.eHi;
    }

    public EditText bCA() {
        return this.heO;
    }

    public StateSwitchView bCB() {
        return this.heP;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                uR(thumbPath);
                this.gPe.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.gPe.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.gPe.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.gPb.setVideoPath(videoPath);
                this.gPb.start();
            }
        }
        if (!v.w(list)) {
            this.heV.dJ(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.heO.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.heV.dJ(arrayList);
            this.heO.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bxC() {
        if (this.gPb != null) {
            this.gPb.resume();
            this.gPb.seekTo(this.gPl);
            this.gPb.start();
        }
    }

    public void aqS() {
        this.gPl = this.gPb.getCurrentPosition();
        if (this.gPb != null) {
            this.gPb.stopPlayback();
        }
    }

    public void uS(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.heM.getResources().getString(d.k.post_to_home_page));
            bCC();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.heM.getResources().getString(d.k.post_to) + str);
        bCD();
    }

    private void bCC() {
        this.heP = new StateSwitchView(this.heM);
        this.heP.setStateString(this.heM.getString(d.k.public_to_all), this.heM.getString(d.k.public_to_me));
        this.heP.setBackgroundId(d.f.state_switch_bg);
        this.heP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.heP.bCf();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.e(this.heM, d.e.ds34), l.e(this.heM, d.e.ds16));
        this.bwi.addView(this.heP, layoutParams);
    }

    private void bCD() {
        this.heP = new StateSwitchView(this.heM);
        this.heP.setStateString(this.heM.getString(d.k.display_to_home_page), this.heM.getString(d.k.display_to_home_page));
        this.heP.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.heP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.heP.bCf();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.e(this.heM, d.e.ds34), l.e(this.heM, d.e.ds16));
        this.heP.setTextSize(0, this.heM.getResources().getDimensionPixelSize(d.e.ds28));
        this.bwi.addView(this.heP, layoutParams);
    }

    public void bCE() {
        this.heS.ax(null);
        this.heS.ni(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.heS.ax(postWriteCallBackData.getSensitiveWords());
            this.heS.uB(postWriteCallBackData.getErrorString());
            if (!v.w(this.heS.bAU())) {
                ns(true);
            }
        }
    }

    public void ns(boolean z) {
        if (this.heO.getText() != null) {
            int selectionEnd = this.heO.getSelectionEnd();
            SpannableStringBuilder b = this.heS.b(this.heO.getText());
            if (b != null) {
                this.heS.nj(true);
                this.heO.setText(b);
                if (z && this.heS.bAV() >= 0) {
                    this.heO.requestFocus();
                    this.heO.setSelection(this.heS.bAV());
                } else {
                    this.heO.setSelection(selectionEnd);
                }
                this.heS.ni(this.heS.bAV() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bCF() {
        return this.heS;
    }

    public void nt(boolean z) {
        if (z) {
            this.heT.setVisibility(8);
            this.heR.setVisibility(0);
            this.cVn.smoothScrollTo(0, this.heR.getBottom());
        }
    }
}
