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
    public static int kQx = 60;
    private ScrollView bjw;
    private RelativeLayout eNj;
    private StateSwitchView kOe;
    private EditText kQA;
    private StateSwitchView kQB;
    private WriteLocationView kQC;
    private TextView kQD;
    private ImageView kQE;
    private c kQF;
    private LinearLayout kQG;
    private ListView kQH;
    private a kQI;
    private LinearLayout kQJ;
    private TextView kQK;
    private TextView kQL;
    private TextView kQM;
    private boolean kQN = true;
    private WriteVideoActivity kQy;
    private TextView kQz;
    private CustomVideoView kzK;
    private ImageView kzN;
    private int kzU;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.kQy = writeVideoActivity;
        this.kQy.setContentView(R.layout.write_video_activity);
        this.kQF = new c();
        this.kQF.DZ(R.color.cp_cont_a);
        this.kQF.Ea(R.color.cp_cont_h_alpha85);
        cVg();
        initView();
    }

    private void cVg() {
        this.eNj = (RelativeLayout) this.kQy.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.kQy.findViewById(R.id.navigation_bar);
        this.kQA = (EditText) this.kQy.findViewById(R.id.edit_content);
        this.kQD = (TextView) this.kQy.findViewById(R.id.text_content_size);
        this.kzN = (ImageView) this.kQy.findViewById(R.id.video_cover);
        this.kzK = (CustomVideoView) this.kQy.findViewById(R.id.preview_videoview);
        this.bjw = (ScrollView) this.kQy.findViewById(R.id.write_scrollview);
        this.kzK.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.kzK.getWidth() != b.this.kzN.getWidth() || b.this.kzK.getHeight() != b.this.kzN.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.kzN.getLayoutParams();
                    layoutParams.width = b.this.kzK.getWidth();
                    layoutParams.height = b.this.kzK.getHeight();
                    b.this.kzN.setLayoutParams(layoutParams);
                }
                b.this.kzN.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kzK.start();
                        b.this.kzN.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.kzK.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cQ(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.kQG = (LinearLayout) this.kQy.findViewById(R.id.video_activity_title_container);
        this.kQH = (ListView) this.kQy.findViewById(R.id.video_activity_title_list);
        this.kQH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.kQG.setVisibility(8);
                b.this.kQD.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.kQA.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.kQA.requestFocus();
                    if (!TextUtils.isEmpty(b.this.kQA.getText())) {
                        b.this.kQA.setSelection(b.this.kQA.getText().length());
                    }
                    l.showSoftKeyPad(b.this.kQy, b.this.kQA);
                }
            }
        });
        this.kQJ = (LinearLayout) this.kQy.findViewById(R.id.save_video_wrapper);
        this.kQK = (TextView) this.kQy.findViewById(R.id.save_video_ridiobutton);
        this.kQL = (TextView) this.kQy.findViewById(R.id.save_video_ridiotext);
        this.kQM = (TextView) this.kQy.findViewById(R.id.display_in_nani_tip);
        this.kQC = (WriteLocationView) this.kQy.findViewById(R.id.location);
        this.kQB = (StateSwitchView) this.kQy.findViewById(R.id.view_privacy);
        this.kQB.setStateString(this.kQy.getString(R.string.display_on_my_home_page), this.kQy.getString(R.string.display_on_my_home_page));
        this.kQB.setLeftStateDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.e.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.kQB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kQB.baA();
            }
        });
        this.kQB.setTextSize(0, this.kQy.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public boolean isToDynamic() {
        return this.kOe != null && this.kOe.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.kQy) / l.getDimens(this.kQy, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.kQy);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.kQy, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.kzK.setVideoHeight(i4);
        this.kzK.setVideoWidth(i3);
        this.kzK.invalidate();
    }

    private void initView() {
        this.kQE = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.kQy);
        this.mNavigationBar.setCenterTextTitle(this.kQy.getPageContext().getString(R.string.post_video_title));
        this.kQz = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.kQy);
        this.kQz.setText(R.string.send_post);
        this.kQA.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.kQA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.kQI != null && b.this.kQI.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.kQy, b.this.kQA);
                    b.this.kQG.setVisibility(0);
                    b.this.kQD.setVisibility(8);
                }
                long cVi = b.kQx - b.this.cVi();
                if (cVi >= 0) {
                    am.setViewTextColor(b.this.kQD, (int) R.color.cp_cont_e);
                    b.this.kQD.setText(String.valueOf(cVi));
                    return;
                }
                b.this.kQD.setText("0");
                b.this.kQA.setText(b.this.kQA.getText().toString().substring(0, b.kQx));
                b.this.kQA.setSelection(b.this.kQA.getText().length());
                b.this.kQy.showToast(b.this.kQy.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.kQF != null) {
                    if (!b.this.kQF.cUd()) {
                        b.this.tP(false);
                    }
                    b.this.kQF.tH(false);
                }
            }
        });
        this.kQI = new a();
        this.kQH.setAdapter((ListAdapter) this.kQI);
        this.kQN = com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.kQN) {
            am.setBackgroundResource(this.kQK, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.kQK, R.drawable.corner_bg_radio_unselected);
        }
        am.setViewTextColor(this.kQL, (int) R.color.cp_cont_g);
        this.kQJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.kQN) {
                    b.this.kQN = false;
                    com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    am.setBackgroundResource(b.this.kQK, R.drawable.corner_bg_radio_unselected);
                    b.this.kQK.invalidate();
                    return;
                }
                b.this.kQN = true;
                com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                am.setBackgroundResource(b.this.kQK, R.drawable.corner_bg_radio_selected);
                b.this.kQK.invalidate();
            }
        });
    }

    public void cVh() {
        if (this.kQM != null) {
            this.kQM.setVisibility(0);
        }
    }

    public void KZ(String str) {
        int i;
        int i2 = 0;
        Bitmap IB = IB(str);
        if (IB != null && IB.getHeight() != 0) {
            if (IB.getHeight() <= 0) {
                i = 0;
            } else if (IB.getWidth() / IB.getHeight() > l.getEquipmentWidth(this.kQy) / l.getDimens(this.kQy, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.kQy);
                if (IB.getWidth() > 0) {
                    i2 = (int) ((i / IB.getWidth()) * IB.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.kQy, R.dimen.ds440);
                if (IB.getWidth() > 0) {
                    i = (int) ((dimens / IB.getHeight()) * IB.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.kzN.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.kzN.setLayoutParams(layoutParams);
            this.kzN.setImageBitmap(IB);
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
        this.kQy.getLayoutMode().setNightMode(i == 1);
        this.kQy.getLayoutMode().onModeChanged(this.eNj);
        this.mNavigationBar.onChangeSkinType(this.kQy.getPageContext(), i);
        SvgManager.aGA().a(this.kQE, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.kQz, R.color.cp_link_tip_a, 1);
        am.c(this.kQC, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.setViewTextColor(this.kQM, (int) R.color.cp_cont_e);
        this.kQN = com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.kQN) {
            am.setBackgroundResource(this.kQK, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.kQK, R.drawable.corner_bg_radio_unselected);
        }
        if (this.kQC != null) {
            this.kQC.onChangeSkinType(i);
        }
        if (this.kQB != null) {
            this.kQB.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.kQA.getText() == null) {
            return null;
        }
        return this.kQA.getText().toString();
    }

    public long cVi() {
        if (this.kQA.getText() == null || this.kQA.getText().toString() == null) {
            return 0L;
        }
        return this.kQA.getText().length();
    }

    public WriteLocationView cVj() {
        return this.kQC;
    }

    public View cVk() {
        return this.kQz;
    }

    public View getBackButton() {
        return this.kQE;
    }

    public EditText cVl() {
        return this.kQA;
    }

    public StateSwitchView cVm() {
        return this.kQB;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                KZ(thumbPath);
                this.kzN.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kzN.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.kzN.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.kzK.setVideoPath(videoPath);
                this.kzK.start();
            }
        }
        if (!v.isEmpty(list)) {
            this.kQI.ey(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.kQA.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.kQI.ey(arrayList);
            this.kQA.setText("#" + videoTitleData.name + "#");
        }
    }

    public void cQH() {
        if (this.kzK != null) {
            this.kzK.resume();
            this.kzK.seekTo(this.kzU);
            this.kzK.start();
        }
    }

    public void bGi() {
        this.kzU = this.kzK.getCurrentPosition();
        if (this.kzK != null) {
            this.kzK.stopPlayback();
        }
    }

    public void La(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.kQy.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.kQy.getResources().getString(R.string.post_to) + str);
        }
    }

    public void cVn() {
        this.kQF.aU(null);
        this.kQF.tG(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kQF.aU(postWriteCallBackData.getSensitiveWords());
            this.kQF.KK(postWriteCallBackData.getErrorString());
            if (!v.isEmpty(this.kQF.cUa())) {
                tP(true);
            }
        }
    }

    public void tP(boolean z) {
        if (this.kQA.getText() != null) {
            int selectionEnd = this.kQA.getSelectionEnd();
            SpannableStringBuilder a = this.kQF.a(this.kQA.getText());
            if (a != null) {
                this.kQF.tH(true);
                this.kQA.setText(a);
                if (z && this.kQF.cUb() >= 0) {
                    this.kQA.requestFocus();
                    this.kQA.setSelection(this.kQF.cUb());
                } else {
                    this.kQA.setSelection(selectionEnd);
                }
                this.kQF.tG(this.kQF.cUb() >= 0);
            }
        }
    }

    public c cVo() {
        return this.kQF;
    }

    public void tQ(boolean z) {
        if (z) {
            this.kQG.setVisibility(8);
            this.kQD.setVisibility(0);
            this.bjw.smoothScrollTo(0, this.kQD.getBottom());
        }
    }
}
