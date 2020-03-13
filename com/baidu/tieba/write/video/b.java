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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.c;
import com.baidu.tieba.write.editor.StateSwitchView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class b {
    public static int kQL = 60;
    private ScrollView bjy;
    private RelativeLayout eNx;
    private ImageView kAb;
    private int kAi;
    private StateSwitchView kOs;
    private WriteVideoActivity kQM;
    private TextView kQN;
    private EditText kQO;
    private StateSwitchView kQP;
    private WriteLocationView kQQ;
    private TextView kQR;
    private ImageView kQS;
    private c kQT;
    private LinearLayout kQU;
    private ListView kQV;
    private a kQW;
    private LinearLayout kQX;
    private TextView kQY;
    private TextView kQZ;
    private TextView kRa;
    private boolean kRb = true;
    private CustomVideoView kzY;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.kQM = writeVideoActivity;
        this.kQM.setContentView(R.layout.write_video_activity);
        this.kQT = new c();
        this.kQT.DZ(R.color.cp_cont_a);
        this.kQT.Ea(R.color.cp_cont_h_alpha85);
        cVj();
        initView();
    }

    private void cVj() {
        this.eNx = (RelativeLayout) this.kQM.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.kQM.findViewById(R.id.navigation_bar);
        this.kQO = (EditText) this.kQM.findViewById(R.id.edit_content);
        this.kQR = (TextView) this.kQM.findViewById(R.id.text_content_size);
        this.kAb = (ImageView) this.kQM.findViewById(R.id.video_cover);
        this.kzY = (CustomVideoView) this.kQM.findViewById(R.id.preview_videoview);
        this.bjy = (ScrollView) this.kQM.findViewById(R.id.write_scrollview);
        this.kzY.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.kzY.getWidth() != b.this.kAb.getWidth() || b.this.kzY.getHeight() != b.this.kAb.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.kAb.getLayoutParams();
                    layoutParams.width = b.this.kzY.getWidth();
                    layoutParams.height = b.this.kzY.getHeight();
                    b.this.kAb.setLayoutParams(layoutParams);
                }
                b.this.kAb.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kzY.start();
                        b.this.kAb.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.kzY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cQ(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.kQU = (LinearLayout) this.kQM.findViewById(R.id.video_activity_title_container);
        this.kQV = (ListView) this.kQM.findViewById(R.id.video_activity_title_list);
        this.kQV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.kQU.setVisibility(8);
                b.this.kQR.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.kQO.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.kQO.requestFocus();
                    if (!TextUtils.isEmpty(b.this.kQO.getText())) {
                        b.this.kQO.setSelection(b.this.kQO.getText().length());
                    }
                    l.showSoftKeyPad(b.this.kQM, b.this.kQO);
                }
            }
        });
        this.kQX = (LinearLayout) this.kQM.findViewById(R.id.save_video_wrapper);
        this.kQY = (TextView) this.kQM.findViewById(R.id.save_video_ridiobutton);
        this.kQZ = (TextView) this.kQM.findViewById(R.id.save_video_ridiotext);
        this.kRa = (TextView) this.kQM.findViewById(R.id.display_in_nani_tip);
        this.kQQ = (WriteLocationView) this.kQM.findViewById(R.id.location);
        this.kQP = (StateSwitchView) this.kQM.findViewById(R.id.view_privacy);
        this.kQP.setStateString(this.kQM.getString(R.string.display_on_my_home_page), this.kQM.getString(R.string.display_on_my_home_page));
        this.kQP.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.kQP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kQP.baD();
            }
        });
        this.kQP.setTextSize(0, this.kQM.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public boolean isToDynamic() {
        return this.kOs != null && this.kOs.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.kQM) / l.getDimens(this.kQM, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.kQM);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.kQM, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.kzY.setVideoHeight(i4);
        this.kzY.setVideoWidth(i3);
        this.kzY.invalidate();
    }

    private void initView() {
        this.kQS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.kQM);
        this.mNavigationBar.setCenterTextTitle(this.kQM.getPageContext().getString(R.string.post_video_title));
        this.kQN = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.kQM);
        this.kQN.setText(R.string.send_post);
        this.kQO.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.kQO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.kQW != null && b.this.kQW.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.kQM, b.this.kQO);
                    b.this.kQU.setVisibility(0);
                    b.this.kQR.setVisibility(8);
                }
                long cVl = b.kQL - b.this.cVl();
                if (cVl >= 0) {
                    am.setViewTextColor(b.this.kQR, (int) R.color.cp_cont_e);
                    b.this.kQR.setText(String.valueOf(cVl));
                    return;
                }
                b.this.kQR.setText("0");
                b.this.kQO.setText(b.this.kQO.getText().toString().substring(0, b.kQL));
                b.this.kQO.setSelection(b.this.kQO.getText().length());
                b.this.kQM.showToast(b.this.kQM.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.kQT != null) {
                    if (!b.this.kQT.cUg()) {
                        b.this.tP(false);
                    }
                    b.this.kQT.tH(false);
                }
            }
        });
        this.kQW = new a();
        this.kQV.setAdapter((ListAdapter) this.kQW);
        this.kRb = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.kRb) {
            am.setBackgroundResource(this.kQY, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.kQY, R.drawable.corner_bg_radio_unselected);
        }
        am.setViewTextColor(this.kQZ, (int) R.color.cp_cont_g);
        this.kQX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.kRb) {
                    b.this.kRb = false;
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    am.setBackgroundResource(b.this.kQY, R.drawable.corner_bg_radio_unselected);
                    b.this.kQY.invalidate();
                    return;
                }
                b.this.kRb = true;
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                am.setBackgroundResource(b.this.kQY, R.drawable.corner_bg_radio_selected);
                b.this.kQY.invalidate();
            }
        });
    }

    public void cVk() {
        if (this.kRa != null) {
            this.kRa.setVisibility(0);
        }
    }

    public void La(String str) {
        int i;
        int i2 = 0;
        Bitmap IC = IC(str);
        if (IC != null && IC.getHeight() != 0) {
            if (IC.getHeight() <= 0) {
                i = 0;
            } else if (IC.getWidth() / IC.getHeight() > l.getEquipmentWidth(this.kQM) / l.getDimens(this.kQM, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.kQM);
                if (IC.getWidth() > 0) {
                    i2 = (int) ((i / IC.getWidth()) * IC.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.kQM, R.dimen.ds440);
                if (IC.getWidth() > 0) {
                    i = (int) ((dimens / IC.getHeight()) * IC.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.kAb.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.kAb.setLayoutParams(layoutParams);
            this.kAb.setImageBitmap(IC);
        }
    }

    private Bitmap IC(String str) {
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
        this.kQM.getLayoutMode().setNightMode(i == 1);
        this.kQM.getLayoutMode().onModeChanged(this.eNx);
        this.mNavigationBar.onChangeSkinType(this.kQM.getPageContext(), i);
        SvgManager.aGC().a(this.kQS, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.kQN, R.color.cp_link_tip_a, 1);
        am.c(this.kQQ, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.setViewTextColor(this.kRa, (int) R.color.cp_cont_e);
        this.kRb = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.kRb) {
            am.setBackgroundResource(this.kQY, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.kQY, R.drawable.corner_bg_radio_unselected);
        }
        if (this.kQQ != null) {
            this.kQQ.onChangeSkinType(i);
        }
        if (this.kQP != null) {
            this.kQP.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.kQO.getText() == null) {
            return null;
        }
        return this.kQO.getText().toString();
    }

    public long cVl() {
        if (this.kQO.getText() == null || this.kQO.getText().toString() == null) {
            return 0L;
        }
        return this.kQO.getText().length();
    }

    public WriteLocationView cVm() {
        return this.kQQ;
    }

    public View cVn() {
        return this.kQN;
    }

    public View getBackButton() {
        return this.kQS;
    }

    public EditText cVo() {
        return this.kQO;
    }

    public StateSwitchView cVp() {
        return this.kQP;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                La(thumbPath);
                this.kAb.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kAb.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.kAb.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.kzY.setVideoPath(videoPath);
                this.kzY.start();
            }
        }
        if (!v.isEmpty(list)) {
            this.kQW.ey(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.kQO.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.kQW.ey(arrayList);
            this.kQO.setText("#" + videoTitleData.name + "#");
        }
    }

    public void cQK() {
        if (this.kzY != null) {
            this.kzY.resume();
            this.kzY.seekTo(this.kAi);
            this.kzY.start();
        }
    }

    public void bGl() {
        this.kAi = this.kzY.getCurrentPosition();
        if (this.kzY != null) {
            this.kzY.stopPlayback();
        }
    }

    public void Lb(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.kQM.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.kQM.getResources().getString(R.string.post_to) + str);
        }
    }

    public void cVq() {
        this.kQT.aU(null);
        this.kQT.tG(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kQT.aU(postWriteCallBackData.getSensitiveWords());
            this.kQT.KL(postWriteCallBackData.getErrorString());
            if (!v.isEmpty(this.kQT.cUd())) {
                tP(true);
            }
        }
    }

    public void tP(boolean z) {
        if (this.kQO.getText() != null) {
            int selectionEnd = this.kQO.getSelectionEnd();
            SpannableStringBuilder a = this.kQT.a(this.kQO.getText());
            if (a != null) {
                this.kQT.tH(true);
                this.kQO.setText(a);
                if (z && this.kQT.cUe() >= 0) {
                    this.kQO.requestFocus();
                    this.kQO.setSelection(this.kQT.cUe());
                } else {
                    this.kQO.setSelection(selectionEnd);
                }
                this.kQT.tG(this.kQT.cUe() >= 0);
            }
        }
    }

    public c cVr() {
        return this.kQT;
    }

    public void tQ(boolean z) {
        if (z) {
            this.kQU.setVisibility(8);
            this.kQR.setVisibility(0);
            this.bjy.smoothScrollTo(0, this.kQR.getBottom());
        }
    }
}
