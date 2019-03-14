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
    public static int jqQ = 60;
    private ScrollView aYD;
    private RelativeLayout dqt;
    private CustomVideoView iZQ;
    private ImageView iZT;
    private int jaa;
    private WriteVideoActivity jqR;
    private TextView jqS;
    private EditText jqT;
    private StateSwitchView jqU;
    private WriteLocationView jqV;
    private TextView jqW;
    private ImageView jqX;
    private com.baidu.tieba.write.b jqY;
    private LinearLayout jqZ;
    private ListView jra;
    private a jrb;
    private LinearLayout jrc;
    private TextView jrd;
    private TextView jre;
    private TextView jrf;
    private boolean jrg = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.jqR = writeVideoActivity;
        this.jqR.setContentView(d.h.write_video_activity);
        this.jqY = new com.baidu.tieba.write.b();
        this.jqY.AW(d.C0277d.cp_btn_a);
        this.jqY.AX(d.C0277d.cp_cont_h_alpha85);
        cpQ();
        initView();
    }

    private void cpQ() {
        this.dqt = (RelativeLayout) this.jqR.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.jqR.findViewById(d.g.navigation_bar);
        this.jqT = (EditText) this.jqR.findViewById(d.g.edit_content);
        this.jqW = (TextView) this.jqR.findViewById(d.g.text_content_size);
        this.iZT = (ImageView) this.jqR.findViewById(d.g.video_cover);
        this.jqV = (WriteLocationView) this.jqR.findViewById(d.g.location);
        this.iZQ = (CustomVideoView) this.jqR.findViewById(d.g.preview_videoview);
        this.aYD = (ScrollView) this.jqR.findViewById(d.g.write_scrollview);
        this.iZQ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.iZQ.getWidth() != b.this.iZT.getWidth() || b.this.iZQ.getHeight() != b.this.iZT.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.iZT.getLayoutParams();
                    layoutParams.width = b.this.iZQ.getWidth();
                    layoutParams.height = b.this.iZQ.getHeight();
                    b.this.iZT.setLayoutParams(layoutParams);
                }
                b.this.iZT.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.iZQ.start();
                        b.this.iZT.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.iZQ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cu(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jqZ = (LinearLayout) this.jqR.findViewById(d.g.video_activity_title_container);
        this.jra = (ListView) this.jqR.findViewById(d.g.video_activity_title_list);
        this.jra.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.jqZ.setVisibility(8);
                b.this.jqW.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.jqT.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.jqT.requestFocus();
                    if (!TextUtils.isEmpty(b.this.jqT.getText())) {
                        b.this.jqT.setSelection(b.this.jqT.getText().length());
                    }
                    l.c(b.this.jqR, b.this.jqT);
                }
            }
        });
        this.jrc = (LinearLayout) this.jqR.findViewById(d.g.save_video_wrapper);
        this.jrd = (TextView) this.jqR.findViewById(d.g.save_video_ridiobutton);
        this.jre = (TextView) this.jqR.findViewById(d.g.save_video_ridiotext);
        this.jrf = (TextView) this.jqR.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.aO(this.jqR) / l.h(this.jqR, d.e.ds440)) {
            i3 = l.aO(this.jqR);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int h = l.h(this.jqR, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((h / i2) * i);
                i4 = h;
            } else {
                i3 = 0;
                i4 = h;
            }
        }
        this.iZQ.setVideoHeight(i4);
        this.iZQ.setVideoWidth(i3);
        this.iZQ.invalidate();
    }

    private void initView() {
        this.jqX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.jqR);
        this.mNavigationBar.setCenterTextTitle(this.jqR.getPageContext().getString(d.j.post_video_title));
        this.jqS = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.jqR);
        this.jqS.setText(d.j.send_post);
        this.jqT.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.jqT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.jrb != null && b.this.jrb.getCount() > 0) {
                    l.b(b.this.jqR, b.this.jqT);
                    b.this.jqZ.setVisibility(0);
                    b.this.jqW.setVisibility(8);
                }
                long cpT = b.jqQ - b.this.cpT();
                if (cpT >= 0) {
                    al.j(b.this.jqW, d.C0277d.cp_cont_e);
                    b.this.jqW.setText(String.valueOf(cpT));
                    return;
                }
                b.this.jqW.setText("0");
                b.this.jqT.setText(b.this.jqT.getText().toString().substring(0, b.jqQ));
                b.this.jqT.setSelection(b.this.jqT.getText().length());
                b.this.jqR.showToast(b.this.jqR.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.jqY != null) {
                    if (!b.this.jqY.cob()) {
                        b.this.re(false);
                    }
                    b.this.jqY.qV(false);
                }
            }
        });
        this.jrb = new a();
        this.jra.setAdapter((ListAdapter) this.jrb);
        this.jrg = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.jrg) {
            al.k(this.jrd, d.f.corner_bg_radio_selected);
        } else {
            al.k(this.jrd, d.f.corner_bg_radio_unselected);
        }
        al.j(this.jre, d.C0277d.cp_cont_g);
        this.jrc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jrg) {
                    b.this.jrg = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    al.k(b.this.jrd, d.f.corner_bg_radio_unselected);
                    b.this.jrd.invalidate();
                    return;
                }
                b.this.jrg = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                al.k(b.this.jrd, d.f.corner_bg_radio_selected);
                b.this.jrd.invalidate();
            }
        });
    }

    public void cpR() {
        if (this.jrf != null) {
            this.jrf.setVisibility(0);
        }
    }

    public void EB(String str) {
        int i;
        int i2 = 0;
        Bitmap Ca = Ca(str);
        if (Ca != null && Ca.getHeight() != 0) {
            if (Ca.getHeight() <= 0) {
                i = 0;
            } else if (Ca.getWidth() / Ca.getHeight() > l.aO(this.jqR) / l.h(this.jqR, d.e.ds440)) {
                i = l.aO(this.jqR);
                if (Ca.getWidth() > 0) {
                    i2 = (int) ((i / Ca.getWidth()) * Ca.getHeight());
                }
            } else {
                int h = l.h(this.jqR, d.e.ds440);
                if (Ca.getWidth() > 0) {
                    i = (int) ((h / Ca.getHeight()) * Ca.getWidth());
                    i2 = h;
                } else {
                    i = 0;
                    i2 = h;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.iZT.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.iZT.setLayoutParams(layoutParams);
            this.iZT.setImageBitmap(Ca);
        }
    }

    private Bitmap Ca(String str) {
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

    public TextView cpS() {
        return this.mNavigationBar.mCenterText;
    }

    public void onChangeSkinType(int i) {
        this.jqR.getLayoutMode().setNightMode(i == 1);
        this.jqR.getLayoutMode().onModeChanged(this.dqt);
        this.mNavigationBar.onChangeSkinType(this.jqR.getPageContext(), i);
        al.c(this.jqX, d.f.icon_return_bg_s);
        al.d(this.jqS, d.C0277d.cp_link_tip_a, 1);
        al.k(this.jqV, d.f.corner_bg);
        al.j(this.jrf, d.C0277d.cp_cont_e);
        this.jrg = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.jrg) {
            al.k(this.jrd, d.f.corner_bg_radio_selected);
        } else {
            al.k(this.jrd, d.f.corner_bg_radio_unselected);
        }
        if (this.jqV != null) {
            this.jqV.onChangeSkinType(i);
        }
        if (this.jqU != null) {
            this.jqU.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.jqT.getText() == null) {
            return null;
        }
        return this.jqT.getText().toString();
    }

    public long cpT() {
        if (this.jqT.getText() == null || this.jqT.getText().toString() == null) {
            return 0L;
        }
        return this.jqT.getText().length();
    }

    public WriteLocationView cpU() {
        return this.jqV;
    }

    public View cpV() {
        return this.jqS;
    }

    public View getBackButton() {
        return this.jqX;
    }

    public EditText cpW() {
        return this.jqT;
    }

    public StateSwitchView cpX() {
        return this.jqU;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                EB(thumbPath);
                this.iZT.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.iZT.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.iZT.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.iZQ.setVideoPath(videoPath);
                this.iZQ.start();
            }
        }
        if (!v.T(list)) {
            this.jrb.ep(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.jqT.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.jrb.ep(arrayList);
            this.jqT.setText("#" + videoTitleData.name + "#");
        }
    }

    public void ckz() {
        if (this.iZQ != null) {
            this.iZQ.resume();
            this.iZQ.seekTo(this.jaa);
            this.iZQ.start();
        }
    }

    public void beM() {
        this.jaa = this.iZQ.getCurrentPosition();
        if (this.iZQ != null) {
            this.iZQ.stopPlayback();
        }
    }

    public void EC(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.jqR.getResources().getString(d.j.post_to_home_page));
            cpY();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.jqR.getResources().getString(d.j.post_to) + str);
        cpZ();
    }

    private void cpY() {
        this.jqU = new StateSwitchView(this.jqR);
        this.jqU.setStateString(this.jqR.getString(d.j.public_to_all), this.jqR.getString(d.j.public_to_me));
        this.jqU.setBackgroundId(d.f.state_switch_bg);
        this.jqU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jqU.aSm();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.jqR, d.e.ds34), l.h(this.jqR, d.e.ds16));
        this.dqt.addView(this.jqU, layoutParams);
    }

    private void cpZ() {
        this.jqU = new StateSwitchView(this.jqR);
        this.jqU.setStateString(this.jqR.getString(d.j.display_to_home_page), this.jqR.getString(d.j.display_to_home_page));
        this.jqU.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.jqU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jqU.aSm();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.h(this.jqR, d.e.ds34), l.h(this.jqR, d.e.ds16));
        this.jqU.setTextSize(0, this.jqR.getResources().getDimensionPixelSize(d.e.ds28));
        this.dqt.addView(this.jqU, layoutParams);
    }

    public void cqa() {
        this.jqY.aE(null);
        this.jqY.qU(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jqY.aE(postWriteCallBackData.getSensitiveWords());
            this.jqY.Ej(postWriteCallBackData.getErrorString());
            if (!v.T(this.jqY.cnY())) {
                re(true);
            }
        }
    }

    public void re(boolean z) {
        if (this.jqT.getText() != null) {
            int selectionEnd = this.jqT.getSelectionEnd();
            SpannableStringBuilder b = this.jqY.b(this.jqT.getText());
            if (b != null) {
                this.jqY.qV(true);
                this.jqT.setText(b);
                if (z && this.jqY.cnZ() >= 0) {
                    this.jqT.requestFocus();
                    this.jqT.setSelection(this.jqY.cnZ());
                } else {
                    this.jqT.setSelection(selectionEnd);
                }
                this.jqY.qU(this.jqY.cnZ() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b cqb() {
        return this.jqY;
    }

    public void rf(boolean z) {
        if (z) {
            this.jqZ.setVisibility(8);
            this.jqW.setVisibility(0);
            this.aYD.smoothScrollTo(0, this.jqW.getBottom());
        }
    }
}
