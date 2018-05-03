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
    public static int heI = 31;
    private RelativeLayout bwi;
    private ScrollView cVk;
    private ImageView eHf;
    private CustomVideoView gOY;
    private ImageView gPb;
    private int gPi;
    private WriteVideoActivity heJ;
    private TextView heK;
    private EditText heL;
    private StateSwitchView heM;
    private WriteLocationView heN;
    private TextView heO;
    private com.baidu.tieba.write.b heP;
    private LinearLayout heQ;
    private ListView heR;
    private a heS;
    private LinearLayout heT;
    private TextView heU;
    private TextView heV;
    private TextView heW;
    private boolean heX = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.heJ = writeVideoActivity;
        this.heJ.setContentView(d.i.write_video_activity);
        this.heP = new com.baidu.tieba.write.b();
        this.heP.uK(d.C0126d.cp_cont_i);
        this.heP.uL(d.C0126d.cp_cont_h_alpha85);
        bCv();
        initView();
    }

    private void bCv() {
        this.bwi = (RelativeLayout) this.heJ.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.heJ.findViewById(d.g.navigation_bar);
        this.heL = (EditText) this.heJ.findViewById(d.g.edit_content);
        this.heO = (TextView) this.heJ.findViewById(d.g.text_content_size);
        this.gPb = (ImageView) this.heJ.findViewById(d.g.video_cover);
        this.heN = (WriteLocationView) this.heJ.findViewById(d.g.location);
        this.gOY = (CustomVideoView) this.heJ.findViewById(d.g.preview_videoview);
        this.cVk = (ScrollView) this.heJ.findViewById(d.g.write_scrollview);
        this.gOY.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.gOY.getWidth() != b.this.gPb.getWidth() || b.this.gOY.getHeight() != b.this.gPb.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.gPb.getLayoutParams();
                    layoutParams.width = b.this.gOY.getWidth();
                    layoutParams.height = b.this.gOY.getHeight();
                    b.this.gPb.setLayoutParams(layoutParams);
                }
                b.this.gPb.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.gOY.start();
                        b.this.gPb.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.gOY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.bO(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.heQ = (LinearLayout) this.heJ.findViewById(d.g.video_activity_title_container);
        this.heR = (ListView) this.heJ.findViewById(d.g.video_activity_title_list);
        this.heR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                b.this.heQ.setVisibility(8);
                b.this.heO.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.heL.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.heL.requestFocus();
                    if (!TextUtils.isEmpty(b.this.heL.getText())) {
                        b.this.heL.setSelection(b.this.heL.getText().length());
                    }
                    l.c(b.this.heJ, b.this.heL);
                }
            }
        });
        this.heT = (LinearLayout) this.heJ.findViewById(d.g.save_video_wrapper);
        this.heU = (TextView) this.heJ.findViewById(d.g.save_video_ridiobutton);
        this.heV = (TextView) this.heJ.findViewById(d.g.save_video_ridiotext);
        this.heW = (TextView) this.heJ.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.af(this.heJ) / l.e(this.heJ, d.e.ds440)) {
            i3 = l.af(this.heJ);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int e = l.e(this.heJ, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((e / i2) * i);
                i4 = e;
            } else {
                i3 = 0;
                i4 = e;
            }
        }
        this.gOY.setVideoHeight(i4);
        this.gOY.setVideoWidth(i3);
        this.gOY.invalidate();
    }

    private void initView() {
        this.eHf = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.nav_close_layout, this.heJ);
        this.mNavigationBar.setCenterTextTitle(this.heJ.getPageContext().getString(d.k.post_video_title));
        this.heK = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.nav_text_send_layout, this.heJ);
        this.heK.setText(d.k.send_post);
        this.heL.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view2, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.heL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.heS != null && b.this.heS.getCount() > 0) {
                    l.b(b.this.heJ, b.this.heL);
                    b.this.heQ.setVisibility(0);
                    b.this.heO.setVisibility(8);
                }
                long bCx = b.heI - b.this.bCx();
                if (bCx >= 0) {
                    ak.h(b.this.heO, d.C0126d.cp_cont_e);
                    b.this.heO.setText(String.valueOf(bCx));
                    return;
                }
                b.this.heO.setText("0");
                b.this.heL.setText(b.this.heL.getText().toString().substring(0, b.heI));
                b.this.heL.setSelection(b.this.heL.getText().length());
                b.this.heJ.showToast(b.this.heJ.getResources().getString(d.k.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.heP != null) {
                    if (!b.this.heP.bAX()) {
                        b.this.ns(false);
                    }
                    b.this.heP.nj(false);
                }
            }
        });
        this.heS = new a();
        this.heR.setAdapter((ListAdapter) this.heS);
        this.heX = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.heX) {
            ak.i(this.heU, d.f.corner_bg_radio_selected);
        } else {
            ak.i(this.heU, d.f.corner_bg_radio_unselected);
        }
        ak.h(this.heV, d.C0126d.cp_cont_g);
        this.heT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.heX) {
                    b.this.heX = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    ak.i(b.this.heU, d.f.corner_bg_radio_unselected);
                    b.this.heU.invalidate();
                    return;
                }
                b.this.heX = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                ak.i(b.this.heU, d.f.corner_bg_radio_selected);
                b.this.heU.invalidate();
            }
        });
    }

    public void bCw() {
        if (this.heW != null) {
            this.heW.setVisibility(0);
        }
    }

    public void uR(String str) {
        int i;
        int i2 = 0;
        Bitmap ss = ss(str);
        if (ss != null && ss.getHeight() != 0) {
            if (ss.getHeight() <= 0) {
                i = 0;
            } else if (ss.getWidth() / ss.getHeight() > l.af(this.heJ) / l.e(this.heJ, d.e.ds440)) {
                i = l.af(this.heJ);
                if (ss.getWidth() > 0) {
                    i2 = (int) ((i / ss.getWidth()) * ss.getHeight());
                }
            } else {
                int e = l.e(this.heJ, d.e.ds440);
                if (ss.getWidth() > 0) {
                    i = (int) ((e / ss.getHeight()) * ss.getWidth());
                    i2 = e;
                } else {
                    i = 0;
                    i2 = e;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.gPb.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.gPb.setLayoutParams(layoutParams);
            this.gPb.setImageBitmap(ss);
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
        this.heJ.getLayoutMode().setNightMode(i == 1);
        this.heJ.getLayoutMode().u(this.bwi);
        this.mNavigationBar.onChangeSkinType(this.heJ.getPageContext(), i);
        ak.c(this.eHf, d.f.icon_return_bg_s);
        ak.c(this.heK, d.C0126d.cp_link_tip_a, 1);
        ak.i(this.heN, d.f.corner_bg);
        ak.h(this.heW, d.C0126d.cp_cont_e);
        this.heX = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.heX) {
            ak.i(this.heU, d.f.corner_bg_radio_selected);
        } else {
            ak.i(this.heU, d.f.corner_bg_radio_unselected);
        }
        if (this.heN != null) {
            this.heN.onChangeSkinType(i);
        }
        if (this.heM != null) {
            this.heM.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.heL.getText() == null) {
            return null;
        }
        return this.heL.getText().toString();
    }

    public long bCx() {
        if (this.heL.getText() == null || this.heL.getText().toString() == null) {
            return 0L;
        }
        return this.heL.getText().length();
    }

    public WriteLocationView bCy() {
        return this.heN;
    }

    public View bCz() {
        return this.heK;
    }

    public View getBackButton() {
        return this.eHf;
    }

    public EditText bCA() {
        return this.heL;
    }

    public StateSwitchView bCB() {
        return this.heM;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                uR(thumbPath);
                this.gPb.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.gPb.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.gPb.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.gOY.setVideoPath(videoPath);
                this.gOY.start();
            }
        }
        if (!v.w(list)) {
            this.heS.dJ(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.heL.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.heS.dJ(arrayList);
            this.heL.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bxC() {
        if (this.gOY != null) {
            this.gOY.resume();
            this.gOY.seekTo(this.gPi);
            this.gOY.start();
        }
    }

    public void aqS() {
        this.gPi = this.gOY.getCurrentPosition();
        if (this.gOY != null) {
            this.gOY.stopPlayback();
        }
    }

    public void uS(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.heJ.getResources().getString(d.k.post_to_home_page));
            bCC();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.heJ.getResources().getString(d.k.post_to) + str);
        bCD();
    }

    private void bCC() {
        this.heM = new StateSwitchView(this.heJ);
        this.heM.setStateString(this.heJ.getString(d.k.public_to_all), this.heJ.getString(d.k.public_to_me));
        this.heM.setBackgroundId(d.f.state_switch_bg);
        this.heM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.heM.bCf();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.e(this.heJ, d.e.ds34), l.e(this.heJ, d.e.ds16));
        this.bwi.addView(this.heM, layoutParams);
    }

    private void bCD() {
        this.heM = new StateSwitchView(this.heJ);
        this.heM.setStateString(this.heJ.getString(d.k.display_to_home_page), this.heJ.getString(d.k.display_to_home_page));
        this.heM.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.heM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.heM.bCf();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.e(this.heJ, d.e.ds34), l.e(this.heJ, d.e.ds16));
        this.heM.setTextSize(0, this.heJ.getResources().getDimensionPixelSize(d.e.ds28));
        this.bwi.addView(this.heM, layoutParams);
    }

    public void bCE() {
        this.heP.ax(null);
        this.heP.ni(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.heP.ax(postWriteCallBackData.getSensitiveWords());
            this.heP.uB(postWriteCallBackData.getErrorString());
            if (!v.w(this.heP.bAU())) {
                ns(true);
            }
        }
    }

    public void ns(boolean z) {
        if (this.heL.getText() != null) {
            int selectionEnd = this.heL.getSelectionEnd();
            SpannableStringBuilder b = this.heP.b(this.heL.getText());
            if (b != null) {
                this.heP.nj(true);
                this.heL.setText(b);
                if (z && this.heP.bAV() >= 0) {
                    this.heL.requestFocus();
                    this.heL.setSelection(this.heP.bAV());
                } else {
                    this.heL.setSelection(selectionEnd);
                }
                this.heP.ni(this.heP.bAV() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bCF() {
        return this.heP;
    }

    public void nt(boolean z) {
        if (z) {
            this.heQ.setVisibility(8);
            this.heO.setVisibility(0);
            this.cVk.smoothScrollTo(0, this.heO.getBottom());
        }
    }
}
