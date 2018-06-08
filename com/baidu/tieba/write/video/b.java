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
    public static int hrH = 31;
    private RelativeLayout bFc;
    private ScrollView dfE;
    private ImageView eTG;
    private CustomVideoView hbD;
    private ImageView hbG;
    private int hbN;
    private WriteVideoActivity hrI;
    private TextView hrJ;
    private EditText hrK;
    private StateSwitchView hrL;
    private WriteLocationView hrM;
    private TextView hrN;
    private com.baidu.tieba.write.b hrO;
    private LinearLayout hrP;
    private ListView hrQ;
    private a hrR;
    private LinearLayout hrS;
    private TextView hrT;
    private TextView hrU;
    private TextView hrV;
    private boolean hrW = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.hrI = writeVideoActivity;
        this.hrI.setContentView(d.i.write_video_activity);
        this.hrO = new com.baidu.tieba.write.b();
        this.hrO.va(d.C0141d.cp_cont_i);
        this.hrO.vb(d.C0141d.cp_cont_h_alpha85);
        bHy();
        initView();
    }

    private void bHy() {
        this.bFc = (RelativeLayout) this.hrI.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hrI.findViewById(d.g.navigation_bar);
        this.hrK = (EditText) this.hrI.findViewById(d.g.edit_content);
        this.hrN = (TextView) this.hrI.findViewById(d.g.text_content_size);
        this.hbG = (ImageView) this.hrI.findViewById(d.g.video_cover);
        this.hrM = (WriteLocationView) this.hrI.findViewById(d.g.location);
        this.hbD = (CustomVideoView) this.hrI.findViewById(d.g.preview_videoview);
        this.dfE = (ScrollView) this.hrI.findViewById(d.g.write_scrollview);
        this.hbD.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.hbD.getWidth() != b.this.hbG.getWidth() || b.this.hbD.getHeight() != b.this.hbG.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.hbG.getLayoutParams();
                    layoutParams.width = b.this.hbD.getWidth();
                    layoutParams.height = b.this.hbD.getHeight();
                    b.this.hbG.setLayoutParams(layoutParams);
                }
                b.this.hbG.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hbD.start();
                        b.this.hbG.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.hbD.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.bQ(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hrP = (LinearLayout) this.hrI.findViewById(d.g.video_activity_title_container);
        this.hrQ = (ListView) this.hrI.findViewById(d.g.video_activity_title_list);
        this.hrQ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.hrP.setVisibility(8);
                b.this.hrN.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.hrK.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.hrK.requestFocus();
                    if (!TextUtils.isEmpty(b.this.hrK.getText())) {
                        b.this.hrK.setSelection(b.this.hrK.getText().length());
                    }
                    l.c(b.this.hrI, b.this.hrK);
                }
            }
        });
        this.hrS = (LinearLayout) this.hrI.findViewById(d.g.save_video_wrapper);
        this.hrT = (TextView) this.hrI.findViewById(d.g.save_video_ridiobutton);
        this.hrU = (TextView) this.hrI.findViewById(d.g.save_video_ridiotext);
        this.hrV = (TextView) this.hrI.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ah(this.hrI) / l.e(this.hrI, d.e.ds440)) {
            i3 = l.ah(this.hrI);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int e = l.e(this.hrI, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((e / i2) * i);
                i4 = e;
            } else {
                i3 = 0;
                i4 = e;
            }
        }
        this.hbD.setVideoHeight(i4);
        this.hbD.setVideoWidth(i3);
        this.hbD.invalidate();
    }

    private void initView() {
        this.eTG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.nav_close_layout, this.hrI);
        this.mNavigationBar.setCenterTextTitle(this.hrI.getPageContext().getString(d.k.post_video_title));
        this.hrJ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.nav_text_send_layout, this.hrI);
        this.hrJ.setText(d.k.send_post);
        this.hrK.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hrK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.hrR != null && b.this.hrR.getCount() > 0) {
                    l.b(b.this.hrI, b.this.hrK);
                    b.this.hrP.setVisibility(0);
                    b.this.hrN.setVisibility(8);
                }
                long bHA = b.hrH - b.this.bHA();
                if (bHA >= 0) {
                    al.h(b.this.hrN, d.C0141d.cp_cont_e);
                    b.this.hrN.setText(String.valueOf(bHA));
                    return;
                }
                b.this.hrN.setText("0");
                b.this.hrK.setText(b.this.hrK.getText().toString().substring(0, b.hrH));
                b.this.hrK.setSelection(b.this.hrK.getText().length());
                b.this.hrI.showToast(b.this.hrI.getResources().getString(d.k.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.hrO != null) {
                    if (!b.this.hrO.bGb()) {
                        b.this.nB(false);
                    }
                    b.this.hrO.ns(false);
                }
            }
        });
        this.hrR = new a();
        this.hrQ.setAdapter((ListAdapter) this.hrR);
        this.hrW = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hrW) {
            al.i(this.hrT, d.f.corner_bg_radio_selected);
        } else {
            al.i(this.hrT, d.f.corner_bg_radio_unselected);
        }
        al.h(this.hrU, d.C0141d.cp_cont_g);
        this.hrS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hrW) {
                    b.this.hrW = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    al.i(b.this.hrT, d.f.corner_bg_radio_unselected);
                    b.this.hrT.invalidate();
                    return;
                }
                b.this.hrW = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                al.i(b.this.hrT, d.f.corner_bg_radio_selected);
                b.this.hrT.invalidate();
            }
        });
    }

    public void bHz() {
        if (this.hrV != null) {
            this.hrV.setVisibility(0);
        }
    }

    public void vO(String str) {
        int i;
        int i2 = 0;
        Bitmap tm = tm(str);
        if (tm != null && tm.getHeight() != 0) {
            if (tm.getHeight() <= 0) {
                i = 0;
            } else if (tm.getWidth() / tm.getHeight() > l.ah(this.hrI) / l.e(this.hrI, d.e.ds440)) {
                i = l.ah(this.hrI);
                if (tm.getWidth() > 0) {
                    i2 = (int) ((i / tm.getWidth()) * tm.getHeight());
                }
            } else {
                int e = l.e(this.hrI, d.e.ds440);
                if (tm.getWidth() > 0) {
                    i = (int) ((e / tm.getHeight()) * tm.getWidth());
                    i2 = e;
                } else {
                    i = 0;
                    i2 = e;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hbG.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hbG.setLayoutParams(layoutParams);
            this.hbG.setImageBitmap(tm);
        }
    }

    private Bitmap tm(String str) {
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
        this.hrI.getLayoutMode().setNightMode(i == 1);
        this.hrI.getLayoutMode().onModeChanged(this.bFc);
        this.mNavigationBar.onChangeSkinType(this.hrI.getPageContext(), i);
        al.c(this.eTG, d.f.icon_return_bg_s);
        al.c(this.hrJ, d.C0141d.cp_link_tip_a, 1);
        al.i(this.hrM, d.f.corner_bg);
        al.h(this.hrV, d.C0141d.cp_cont_e);
        this.hrW = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hrW) {
            al.i(this.hrT, d.f.corner_bg_radio_selected);
        } else {
            al.i(this.hrT, d.f.corner_bg_radio_unselected);
        }
        if (this.hrM != null) {
            this.hrM.onChangeSkinType(i);
        }
        if (this.hrL != null) {
            this.hrL.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hrK.getText() == null) {
            return null;
        }
        return this.hrK.getText().toString();
    }

    public long bHA() {
        if (this.hrK.getText() == null || this.hrK.getText().toString() == null) {
            return 0L;
        }
        return this.hrK.getText().length();
    }

    public WriteLocationView bHB() {
        return this.hrM;
    }

    public View bHC() {
        return this.hrJ;
    }

    public View getBackButton() {
        return this.eTG;
    }

    public EditText bHD() {
        return this.hrK;
    }

    public StateSwitchView bHE() {
        return this.hrL;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                vO(thumbPath);
                this.hbG.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hbG.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hbG.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.hbD.setVideoPath(videoPath);
                this.hbD.start();
            }
        }
        if (!w.z(list)) {
            this.hrR.dS(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hrK.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hrR.dS(arrayList);
            this.hrK.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bCH() {
        if (this.hbD != null) {
            this.hbD.resume();
            this.hbD.seekTo(this.hbN);
            this.hbD.start();
        }
    }

    public void auW() {
        this.hbN = this.hbD.getCurrentPosition();
        if (this.hbD != null) {
            this.hbD.stopPlayback();
        }
    }

    public void vP(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hrI.getResources().getString(d.k.post_to_home_page));
            bHF();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hrI.getResources().getString(d.k.post_to) + str);
        bHG();
    }

    private void bHF() {
        this.hrL = new StateSwitchView(this.hrI);
        this.hrL.setStateString(this.hrI.getString(d.k.public_to_all), this.hrI.getString(d.k.public_to_me));
        this.hrL.setBackgroundId(d.f.state_switch_bg);
        this.hrL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hrL.akO();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.e(this.hrI, d.e.ds34), l.e(this.hrI, d.e.ds16));
        this.bFc.addView(this.hrL, layoutParams);
    }

    private void bHG() {
        this.hrL = new StateSwitchView(this.hrI);
        this.hrL.setStateString(this.hrI.getString(d.k.display_to_home_page), this.hrI.getString(d.k.display_to_home_page));
        this.hrL.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.hrL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hrL.akO();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.e(this.hrI, d.e.ds34), l.e(this.hrI, d.e.ds16));
        this.hrL.setTextSize(0, this.hrI.getResources().getDimensionPixelSize(d.e.ds28));
        this.bFc.addView(this.hrL, layoutParams);
    }

    public void bHH() {
        this.hrO.ax(null);
        this.hrO.nr(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hrO.ax(postWriteCallBackData.getSensitiveWords());
            this.hrO.vy(postWriteCallBackData.getErrorString());
            if (!w.z(this.hrO.bFY())) {
                nB(true);
            }
        }
    }

    public void nB(boolean z) {
        if (this.hrK.getText() != null) {
            int selectionEnd = this.hrK.getSelectionEnd();
            SpannableStringBuilder b = this.hrO.b(this.hrK.getText());
            if (b != null) {
                this.hrO.ns(true);
                this.hrK.setText(b);
                if (z && this.hrO.bFZ() >= 0) {
                    this.hrK.requestFocus();
                    this.hrK.setSelection(this.hrO.bFZ());
                } else {
                    this.hrK.setSelection(selectionEnd);
                }
                this.hrO.nr(this.hrO.bFZ() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bHI() {
        return this.hrO;
    }

    public void nC(boolean z) {
        if (z) {
            this.hrP.setVisibility(8);
            this.hrN.setVisibility(0);
            this.dfE.smoothScrollTo(0, this.hrN.getBottom());
        }
    }
}
