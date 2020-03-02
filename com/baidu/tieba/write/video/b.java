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
    public static int kQz = 60;
    private ScrollView bjx;
    private RelativeLayout eNk;
    private StateSwitchView kOg;
    private WriteVideoActivity kQA;
    private TextView kQB;
    private EditText kQC;
    private StateSwitchView kQD;
    private WriteLocationView kQE;
    private TextView kQF;
    private ImageView kQG;
    private c kQH;
    private LinearLayout kQI;
    private ListView kQJ;
    private a kQK;
    private LinearLayout kQL;
    private TextView kQM;
    private TextView kQN;
    private TextView kQO;
    private boolean kQP = true;
    private CustomVideoView kzM;
    private ImageView kzP;
    private int kzW;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.kQA = writeVideoActivity;
        this.kQA.setContentView(R.layout.write_video_activity);
        this.kQH = new c();
        this.kQH.DZ(R.color.cp_cont_a);
        this.kQH.Ea(R.color.cp_cont_h_alpha85);
        cVi();
        initView();
    }

    private void cVi() {
        this.eNk = (RelativeLayout) this.kQA.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.kQA.findViewById(R.id.navigation_bar);
        this.kQC = (EditText) this.kQA.findViewById(R.id.edit_content);
        this.kQF = (TextView) this.kQA.findViewById(R.id.text_content_size);
        this.kzP = (ImageView) this.kQA.findViewById(R.id.video_cover);
        this.kzM = (CustomVideoView) this.kQA.findViewById(R.id.preview_videoview);
        this.bjx = (ScrollView) this.kQA.findViewById(R.id.write_scrollview);
        this.kzM.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.kzM.getWidth() != b.this.kzP.getWidth() || b.this.kzM.getHeight() != b.this.kzP.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.kzP.getLayoutParams();
                    layoutParams.width = b.this.kzM.getWidth();
                    layoutParams.height = b.this.kzM.getHeight();
                    b.this.kzP.setLayoutParams(layoutParams);
                }
                b.this.kzP.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kzM.start();
                        b.this.kzP.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.kzM.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cQ(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.kQI = (LinearLayout) this.kQA.findViewById(R.id.video_activity_title_container);
        this.kQJ = (ListView) this.kQA.findViewById(R.id.video_activity_title_list);
        this.kQJ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.kQI.setVisibility(8);
                b.this.kQF.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.kQC.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.kQC.requestFocus();
                    if (!TextUtils.isEmpty(b.this.kQC.getText())) {
                        b.this.kQC.setSelection(b.this.kQC.getText().length());
                    }
                    l.showSoftKeyPad(b.this.kQA, b.this.kQC);
                }
            }
        });
        this.kQL = (LinearLayout) this.kQA.findViewById(R.id.save_video_wrapper);
        this.kQM = (TextView) this.kQA.findViewById(R.id.save_video_ridiobutton);
        this.kQN = (TextView) this.kQA.findViewById(R.id.save_video_ridiotext);
        this.kQO = (TextView) this.kQA.findViewById(R.id.display_in_nani_tip);
        this.kQE = (WriteLocationView) this.kQA.findViewById(R.id.location);
        this.kQD = (StateSwitchView) this.kQA.findViewById(R.id.view_privacy);
        this.kQD.setStateString(this.kQA.getString(R.string.display_on_my_home_page), this.kQA.getString(R.string.display_on_my_home_page));
        this.kQD.setLeftStateDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.e.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.kQD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kQD.baC();
            }
        });
        this.kQD.setTextSize(0, this.kQA.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public boolean isToDynamic() {
        return this.kOg != null && this.kOg.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.kQA) / l.getDimens(this.kQA, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.kQA);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.kQA, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.kzM.setVideoHeight(i4);
        this.kzM.setVideoWidth(i3);
        this.kzM.invalidate();
    }

    private void initView() {
        this.kQG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.kQA);
        this.mNavigationBar.setCenterTextTitle(this.kQA.getPageContext().getString(R.string.post_video_title));
        this.kQB = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.kQA);
        this.kQB.setText(R.string.send_post);
        this.kQC.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.kQC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.kQK != null && b.this.kQK.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.kQA, b.this.kQC);
                    b.this.kQI.setVisibility(0);
                    b.this.kQF.setVisibility(8);
                }
                long cVk = b.kQz - b.this.cVk();
                if (cVk >= 0) {
                    am.setViewTextColor(b.this.kQF, (int) R.color.cp_cont_e);
                    b.this.kQF.setText(String.valueOf(cVk));
                    return;
                }
                b.this.kQF.setText("0");
                b.this.kQC.setText(b.this.kQC.getText().toString().substring(0, b.kQz));
                b.this.kQC.setSelection(b.this.kQC.getText().length());
                b.this.kQA.showToast(b.this.kQA.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.kQH != null) {
                    if (!b.this.kQH.cUf()) {
                        b.this.tP(false);
                    }
                    b.this.kQH.tH(false);
                }
            }
        });
        this.kQK = new a();
        this.kQJ.setAdapter((ListAdapter) this.kQK);
        this.kQP = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.kQP) {
            am.setBackgroundResource(this.kQM, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.kQM, R.drawable.corner_bg_radio_unselected);
        }
        am.setViewTextColor(this.kQN, (int) R.color.cp_cont_g);
        this.kQL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.kQP) {
                    b.this.kQP = false;
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    am.setBackgroundResource(b.this.kQM, R.drawable.corner_bg_radio_unselected);
                    b.this.kQM.invalidate();
                    return;
                }
                b.this.kQP = true;
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                am.setBackgroundResource(b.this.kQM, R.drawable.corner_bg_radio_selected);
                b.this.kQM.invalidate();
            }
        });
    }

    public void cVj() {
        if (this.kQO != null) {
            this.kQO.setVisibility(0);
        }
    }

    public void KZ(String str) {
        int i;
        int i2 = 0;
        Bitmap IB = IB(str);
        if (IB != null && IB.getHeight() != 0) {
            if (IB.getHeight() <= 0) {
                i = 0;
            } else if (IB.getWidth() / IB.getHeight() > l.getEquipmentWidth(this.kQA) / l.getDimens(this.kQA, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.kQA);
                if (IB.getWidth() > 0) {
                    i2 = (int) ((i / IB.getWidth()) * IB.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.kQA, R.dimen.ds440);
                if (IB.getWidth() > 0) {
                    i = (int) ((dimens / IB.getHeight()) * IB.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.kzP.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.kzP.setLayoutParams(layoutParams);
            this.kzP.setImageBitmap(IB);
        }
    }

    private Bitmap IB(String str) {
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
        this.kQA.getLayoutMode().setNightMode(i == 1);
        this.kQA.getLayoutMode().onModeChanged(this.eNk);
        this.mNavigationBar.onChangeSkinType(this.kQA.getPageContext(), i);
        SvgManager.aGC().a(this.kQG, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.kQB, R.color.cp_link_tip_a, 1);
        am.c(this.kQE, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.setViewTextColor(this.kQO, (int) R.color.cp_cont_e);
        this.kQP = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.kQP) {
            am.setBackgroundResource(this.kQM, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.kQM, R.drawable.corner_bg_radio_unselected);
        }
        if (this.kQE != null) {
            this.kQE.onChangeSkinType(i);
        }
        if (this.kQD != null) {
            this.kQD.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.kQC.getText() == null) {
            return null;
        }
        return this.kQC.getText().toString();
    }

    public long cVk() {
        if (this.kQC.getText() == null || this.kQC.getText().toString() == null) {
            return 0L;
        }
        return this.kQC.getText().length();
    }

    public WriteLocationView cVl() {
        return this.kQE;
    }

    public View cVm() {
        return this.kQB;
    }

    public View getBackButton() {
        return this.kQG;
    }

    public EditText cVn() {
        return this.kQC;
    }

    public StateSwitchView cVo() {
        return this.kQD;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                KZ(thumbPath);
                this.kzP.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kzP.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.kzP.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.kzM.setVideoPath(videoPath);
                this.kzM.start();
            }
        }
        if (!v.isEmpty(list)) {
            this.kQK.ey(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.kQC.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.kQK.ey(arrayList);
            this.kQC.setText("#" + videoTitleData.name + "#");
        }
    }

    public void cQJ() {
        if (this.kzM != null) {
            this.kzM.resume();
            this.kzM.seekTo(this.kzW);
            this.kzM.start();
        }
    }

    public void bGk() {
        this.kzW = this.kzM.getCurrentPosition();
        if (this.kzM != null) {
            this.kzM.stopPlayback();
        }
    }

    public void La(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.kQA.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.kQA.getResources().getString(R.string.post_to) + str);
        }
    }

    public void cVp() {
        this.kQH.aU(null);
        this.kQH.tG(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kQH.aU(postWriteCallBackData.getSensitiveWords());
            this.kQH.KK(postWriteCallBackData.getErrorString());
            if (!v.isEmpty(this.kQH.cUc())) {
                tP(true);
            }
        }
    }

    public void tP(boolean z) {
        if (this.kQC.getText() != null) {
            int selectionEnd = this.kQC.getSelectionEnd();
            SpannableStringBuilder a = this.kQH.a(this.kQC.getText());
            if (a != null) {
                this.kQH.tH(true);
                this.kQC.setText(a);
                if (z && this.kQH.cUd() >= 0) {
                    this.kQC.requestFocus();
                    this.kQC.setSelection(this.kQH.cUd());
                } else {
                    this.kQC.setSelection(selectionEnd);
                }
                this.kQH.tG(this.kQH.cUd() >= 0);
            }
        }
    }

    public c cVq() {
        return this.kQH;
    }

    public void tQ(boolean z) {
        if (z) {
            this.kQI.setVisibility(8);
            this.kQF.setVisibility(0);
            this.bjx.smoothScrollTo(0, this.kQF.getBottom());
        }
    }
}
