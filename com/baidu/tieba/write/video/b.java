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
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.f.d;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.editor.StateSwitchView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static int jRz = 60;
    private ScrollView buM;
    private RelativeLayout dSy;
    private int jBA;
    private CustomVideoView jBq;
    private ImageView jBt;
    private WriteVideoActivity jRA;
    private TextView jRB;
    private EditText jRC;
    private StateSwitchView jRD;
    private WriteLocationView jRE;
    private TextView jRF;
    private ImageView jRG;
    private com.baidu.tieba.write.b jRH;
    private LinearLayout jRI;
    private ListView jRJ;
    private a jRK;
    private LinearLayout jRL;
    private TextView jRM;
    private TextView jRN;
    private TextView jRO;
    private boolean jRP = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.jRA = writeVideoActivity;
        this.jRA.setContentView(R.layout.write_video_activity);
        this.jRH = new com.baidu.tieba.write.b();
        this.jRH.Br(R.color.cp_cont_a);
        this.jRH.Bs(R.color.cp_cont_h_alpha85);
        cyL();
        initView();
    }

    private void cyL() {
        this.dSy = (RelativeLayout) this.jRA.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.jRA.findViewById(R.id.navigation_bar);
        this.jRC = (EditText) this.jRA.findViewById(R.id.edit_content);
        this.jRF = (TextView) this.jRA.findViewById(R.id.text_content_size);
        this.jBt = (ImageView) this.jRA.findViewById(R.id.video_cover);
        this.jRE = (WriteLocationView) this.jRA.findViewById(R.id.location);
        this.jBq = (CustomVideoView) this.jRA.findViewById(R.id.preview_videoview);
        this.buM = (ScrollView) this.jRA.findViewById(R.id.write_scrollview);
        this.jBq.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.jBq.getWidth() != b.this.jBt.getWidth() || b.this.jBq.getHeight() != b.this.jBt.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.jBt.getLayoutParams();
                    layoutParams.width = b.this.jBq.getWidth();
                    layoutParams.height = b.this.jBq.getHeight();
                    b.this.jBt.setLayoutParams(layoutParams);
                }
                b.this.jBt.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jBq.start();
                        b.this.jBt.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.jBq.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cw(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jRI = (LinearLayout) this.jRA.findViewById(R.id.video_activity_title_container);
        this.jRJ = (ListView) this.jRA.findViewById(R.id.video_activity_title_list);
        this.jRJ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.jRI.setVisibility(8);
                b.this.jRF.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.jRC.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.jRC.requestFocus();
                    if (!TextUtils.isEmpty(b.this.jRC.getText())) {
                        b.this.jRC.setSelection(b.this.jRC.getText().length());
                    }
                    l.showSoftKeyPad(b.this.jRA, b.this.jRC);
                }
            }
        });
        this.jRL = (LinearLayout) this.jRA.findViewById(R.id.save_video_wrapper);
        this.jRM = (TextView) this.jRA.findViewById(R.id.save_video_ridiobutton);
        this.jRN = (TextView) this.jRA.findViewById(R.id.save_video_ridiotext);
        this.jRO = (TextView) this.jRA.findViewById(R.id.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.jRA) / l.getDimens(this.jRA, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.jRA);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.jRA, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.jBq.setVideoHeight(i4);
        this.jBq.setVideoWidth(i3);
        this.jBq.invalidate();
    }

    private void initView() {
        this.jRG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.jRA);
        this.mNavigationBar.setCenterTextTitle(this.jRA.getPageContext().getString(R.string.post_video_title));
        this.jRB = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.jRA);
        this.jRB.setText(R.string.send_post);
        this.jRC.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.jRC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.jRK != null && b.this.jRK.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.jRA, b.this.jRC);
                    b.this.jRI.setVisibility(0);
                    b.this.jRF.setVisibility(8);
                }
                long cyN = b.jRz - b.this.cyN();
                if (cyN >= 0) {
                    am.setViewTextColor(b.this.jRF, (int) R.color.cp_cont_e);
                    b.this.jRF.setText(String.valueOf(cyN));
                    return;
                }
                b.this.jRF.setText("0");
                b.this.jRC.setText(b.this.jRC.getText().toString().substring(0, b.jRz));
                b.this.jRC.setSelection(b.this.jRC.getText().length());
                b.this.jRA.showToast(b.this.jRA.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.jRH != null) {
                    if (!b.this.jRH.cxz()) {
                        b.this.rS(false);
                    }
                    b.this.jRH.rL(false);
                }
            }
        });
        this.jRK = new a();
        this.jRJ.setAdapter((ListAdapter) this.jRK);
        this.jRP = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.jRP) {
            am.setBackgroundResource(this.jRM, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.jRM, R.drawable.corner_bg_radio_unselected);
        }
        am.setViewTextColor(this.jRN, (int) R.color.cp_cont_g);
        this.jRL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jRP) {
                    b.this.jRP = false;
                    com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    am.setBackgroundResource(b.this.jRM, R.drawable.corner_bg_radio_unselected);
                    b.this.jRM.invalidate();
                    return;
                }
                b.this.jRP = true;
                com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                am.setBackgroundResource(b.this.jRM, R.drawable.corner_bg_radio_selected);
                b.this.jRM.invalidate();
            }
        });
    }

    public void cyM() {
        if (this.jRO != null) {
            this.jRO.setVisibility(0);
        }
    }

    public void FK(String str) {
        int i;
        int i2 = 0;
        Bitmap Dq = Dq(str);
        if (Dq != null && Dq.getHeight() != 0) {
            if (Dq.getHeight() <= 0) {
                i = 0;
            } else if (Dq.getWidth() / Dq.getHeight() > l.getEquipmentWidth(this.jRA) / l.getDimens(this.jRA, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.jRA);
                if (Dq.getWidth() > 0) {
                    i2 = (int) ((i / Dq.getWidth()) * Dq.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.jRA, R.dimen.ds440);
                if (Dq.getWidth() > 0) {
                    i = (int) ((dimens / Dq.getHeight()) * Dq.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jBt.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.jBt.setLayoutParams(layoutParams);
            this.jBt.setImageBitmap(Dq);
        }
    }

    private Bitmap Dq(String str) {
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

    public TextView getCenterTitleView() {
        return this.mNavigationBar.mCenterText;
    }

    public void onChangeSkinType(int i) {
        this.jRA.getLayoutMode().setNightMode(i == 1);
        this.jRA.getLayoutMode().onModeChanged(this.dSy);
        this.mNavigationBar.onChangeSkinType(this.jRA.getPageContext(), i);
        SvgManager.amL().a(this.jRG, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.jRB, R.color.cp_link_tip_a, 1);
        am.setBackgroundResource(this.jRE, R.drawable.corner_bg);
        am.setViewTextColor(this.jRO, (int) R.color.cp_cont_e);
        this.jRP = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.jRP) {
            am.setBackgroundResource(this.jRM, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.jRM, R.drawable.corner_bg_radio_unselected);
        }
        if (this.jRE != null) {
            this.jRE.onChangeSkinType(i);
        }
        if (this.jRD != null) {
            this.jRD.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.jRC.getText() == null) {
            return null;
        }
        return this.jRC.getText().toString();
    }

    public long cyN() {
        if (this.jRC.getText() == null || this.jRC.getText().toString() == null) {
            return 0L;
        }
        return this.jRC.getText().length();
    }

    public WriteLocationView cyO() {
        return this.jRE;
    }

    public View cyP() {
        return this.jRB;
    }

    public View getBackButton() {
        return this.jRG;
    }

    public EditText cyQ() {
        return this.jRC;
    }

    public StateSwitchView cyR() {
        return this.jRD;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                FK(thumbPath);
                this.jBt.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jBt.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.jBt.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.jBq.setVideoPath(videoPath);
                this.jBq.start();
            }
        }
        if (!v.isEmpty(list)) {
            this.jRK.eL(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.jRC.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.jRK.eL(arrayList);
            this.jRC.setText("#" + videoTitleData.name + "#");
        }
    }

    public void cuk() {
        if (this.jBq != null) {
            this.jBq.resume();
            this.jBq.seekTo(this.jBA);
            this.jBq.start();
        }
    }

    public void bmh() {
        this.jBA = this.jBq.getCurrentPosition();
        if (this.jBq != null) {
            this.jBq.stopPlayback();
        }
    }

    public void FL(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.jRA.getResources().getString(R.string.post_to_home_page));
            cyS();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.jRA.getResources().getString(R.string.post_to) + str);
        cyT();
    }

    private void cyS() {
        this.jRD = new StateSwitchView(this.jRA);
        this.jRD.setStateString(this.jRA.getString(R.string.public_to_all), this.jRA.getString(R.string.public_to_me));
        am.e(this.jRD, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.jRD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jRD.aHH();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.getDimens(this.jRA, R.dimen.ds34), l.getDimens(this.jRA, R.dimen.ds16));
        this.dSy.addView(this.jRD, layoutParams);
    }

    private void cyT() {
        this.jRD = new StateSwitchView(this.jRA);
        this.jRD.setStateString(this.jRA.getString(R.string.display_to_home_page), this.jRA.getString(R.string.display_to_home_page));
        this.jRD.setLeftStateDrawable(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_stroke1_blue_h_svg), new d(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.jRD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jRD.aHH();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.getDimens(this.jRA, R.dimen.ds34), l.getDimens(this.jRA, R.dimen.ds16));
        this.jRD.setTextSize(0, this.jRA.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.dSy.addView(this.jRD, layoutParams);
    }

    public void cyU() {
        this.jRH.aM(null);
        this.jRH.rK(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jRH.aM(postWriteCallBackData.getSensitiveWords());
            this.jRH.Fv(postWriteCallBackData.getErrorString());
            if (!v.isEmpty(this.jRH.cxw())) {
                rS(true);
            }
        }
    }

    public void rS(boolean z) {
        if (this.jRC.getText() != null) {
            int selectionEnd = this.jRC.getSelectionEnd();
            SpannableStringBuilder a = this.jRH.a(this.jRC.getText());
            if (a != null) {
                this.jRH.rL(true);
                this.jRC.setText(a);
                if (z && this.jRH.cxx() >= 0) {
                    this.jRC.requestFocus();
                    this.jRC.setSelection(this.jRH.cxx());
                } else {
                    this.jRC.setSelection(selectionEnd);
                }
                this.jRH.rK(this.jRH.cxx() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b cyV() {
        return this.jRH;
    }

    public void rT(boolean z) {
        if (z) {
            this.jRI.setVisibility(8);
            this.jRF.setVisibility(0);
            this.buM.smoothScrollTo(0, this.jRF.getBottom());
        }
    }
}
