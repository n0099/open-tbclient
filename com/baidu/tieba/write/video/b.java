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
/* loaded from: classes11.dex */
public class b {
    public static int kPR = 60;
    private ScrollView bfi;
    private RelativeLayout eJp;
    private StateSwitchView kNy;
    private WriteVideoActivity kPS;
    private TextView kPT;
    private EditText kPU;
    private StateSwitchView kPV;
    private WriteLocationView kPW;
    private TextView kPX;
    private ImageView kPY;
    private c kPZ;
    private LinearLayout kQa;
    private ListView kQb;
    private a kQc;
    private LinearLayout kQd;
    private TextView kQe;
    private TextView kQf;
    private TextView kQg;
    private boolean kQh = true;
    private CustomVideoView kyP;
    private ImageView kyS;
    private int kyZ;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.kPS = writeVideoActivity;
        this.kPS.setContentView(R.layout.write_video_activity);
        this.kPZ = new c();
        this.kPZ.DU(R.color.cp_cont_a);
        this.kPZ.DV(R.color.cp_cont_h_alpha85);
        cTS();
        initView();
    }

    private void cTS() {
        this.eJp = (RelativeLayout) this.kPS.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.kPS.findViewById(R.id.navigation_bar);
        this.kPU = (EditText) this.kPS.findViewById(R.id.edit_content);
        this.kPX = (TextView) this.kPS.findViewById(R.id.text_content_size);
        this.kyS = (ImageView) this.kPS.findViewById(R.id.video_cover);
        this.kyP = (CustomVideoView) this.kPS.findViewById(R.id.preview_videoview);
        this.bfi = (ScrollView) this.kPS.findViewById(R.id.write_scrollview);
        this.kyP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.kyP.getWidth() != b.this.kyS.getWidth() || b.this.kyP.getHeight() != b.this.kyS.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.kyS.getLayoutParams();
                    layoutParams.width = b.this.kyP.getWidth();
                    layoutParams.height = b.this.kyP.getHeight();
                    b.this.kyS.setLayoutParams(layoutParams);
                }
                b.this.kyS.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kyP.start();
                        b.this.kyS.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.kyP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cN(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.kQa = (LinearLayout) this.kPS.findViewById(R.id.video_activity_title_container);
        this.kQb = (ListView) this.kPS.findViewById(R.id.video_activity_title_list);
        this.kQb.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.kQa.setVisibility(8);
                b.this.kPX.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.kPU.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.kPU.requestFocus();
                    if (!TextUtils.isEmpty(b.this.kPU.getText())) {
                        b.this.kPU.setSelection(b.this.kPU.getText().length());
                    }
                    l.showSoftKeyPad(b.this.kPS, b.this.kPU);
                }
            }
        });
        this.kQd = (LinearLayout) this.kPS.findViewById(R.id.save_video_wrapper);
        this.kQe = (TextView) this.kPS.findViewById(R.id.save_video_ridiobutton);
        this.kQf = (TextView) this.kPS.findViewById(R.id.save_video_ridiotext);
        this.kQg = (TextView) this.kPS.findViewById(R.id.display_in_nani_tip);
        this.kPW = (WriteLocationView) this.kPS.findViewById(R.id.location);
        this.kPV = (StateSwitchView) this.kPS.findViewById(R.id.view_privacy);
        this.kPV.setStateString(this.kPS.getString(R.string.display_on_my_home_page), this.kPS.getString(R.string.display_on_my_home_page));
        this.kPV.setLeftStateDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.e.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.kPV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kPV.aYl();
            }
        });
        this.kPV.setTextSize(0, this.kPS.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public boolean isToDynamic() {
        return this.kNy != null && this.kNy.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.kPS) / l.getDimens(this.kPS, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.kPS);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.kPS, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.kyP.setVideoHeight(i4);
        this.kyP.setVideoWidth(i3);
        this.kyP.invalidate();
    }

    private void initView() {
        this.kPY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.kPS);
        this.mNavigationBar.setCenterTextTitle(this.kPS.getPageContext().getString(R.string.post_video_title));
        this.kPT = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.kPS);
        this.kPT.setText(R.string.send_post);
        this.kPU.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.kPU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.kQc != null && b.this.kQc.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.kPS, b.this.kPU);
                    b.this.kQa.setVisibility(0);
                    b.this.kPX.setVisibility(8);
                }
                long cTU = b.kPR - b.this.cTU();
                if (cTU >= 0) {
                    am.setViewTextColor(b.this.kPX, (int) R.color.cp_cont_e);
                    b.this.kPX.setText(String.valueOf(cTU));
                    return;
                }
                b.this.kPX.setText("0");
                b.this.kPU.setText(b.this.kPU.getText().toString().substring(0, b.kPR));
                b.this.kPU.setSelection(b.this.kPU.getText().length());
                b.this.kPS.showToast(b.this.kPS.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.kPZ != null) {
                    if (!b.this.kPZ.cSP()) {
                        b.this.tL(false);
                    }
                    b.this.kPZ.tD(false);
                }
            }
        });
        this.kQc = new a();
        this.kQb.setAdapter((ListAdapter) this.kQc);
        this.kQh = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.kQh) {
            am.setBackgroundResource(this.kQe, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.kQe, R.drawable.corner_bg_radio_unselected);
        }
        am.setViewTextColor(this.kQf, (int) R.color.cp_cont_g);
        this.kQd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.kQh) {
                    b.this.kQh = false;
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    am.setBackgroundResource(b.this.kQe, R.drawable.corner_bg_radio_unselected);
                    b.this.kQe.invalidate();
                    return;
                }
                b.this.kQh = true;
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                am.setBackgroundResource(b.this.kQe, R.drawable.corner_bg_radio_selected);
                b.this.kQe.invalidate();
            }
        });
    }

    public void cTT() {
        if (this.kQg != null) {
            this.kQg.setVisibility(0);
        }
    }

    public void KM(String str) {
        int i;
        int i2 = 0;
        Bitmap In = In(str);
        if (In != null && In.getHeight() != 0) {
            if (In.getHeight() <= 0) {
                i = 0;
            } else if (In.getWidth() / In.getHeight() > l.getEquipmentWidth(this.kPS) / l.getDimens(this.kPS, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.kPS);
                if (In.getWidth() > 0) {
                    i2 = (int) ((i / In.getWidth()) * In.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.kPS, R.dimen.ds440);
                if (In.getWidth() > 0) {
                    i = (int) ((dimens / In.getHeight()) * In.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.kyS.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.kyS.setLayoutParams(layoutParams);
            this.kyS.setImageBitmap(In);
        }
    }

    private Bitmap In(String str) {
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
        this.kPS.getLayoutMode().setNightMode(i == 1);
        this.kPS.getLayoutMode().onModeChanged(this.eJp);
        this.mNavigationBar.onChangeSkinType(this.kPS.getPageContext(), i);
        SvgManager.aEp().a(this.kPY, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.kPT, R.color.cp_link_tip_a, 1);
        am.c(this.kPW, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.setViewTextColor(this.kQg, (int) R.color.cp_cont_e);
        this.kQh = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.kQh) {
            am.setBackgroundResource(this.kQe, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.kQe, R.drawable.corner_bg_radio_unselected);
        }
        if (this.kPW != null) {
            this.kPW.onChangeSkinType(i);
        }
        if (this.kPV != null) {
            this.kPV.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.kPU.getText() == null) {
            return null;
        }
        return this.kPU.getText().toString();
    }

    public long cTU() {
        if (this.kPU.getText() == null || this.kPU.getText().toString() == null) {
            return 0L;
        }
        return this.kPU.getText().length();
    }

    public WriteLocationView cTV() {
        return this.kPW;
    }

    public View cTW() {
        return this.kPT;
    }

    public View getBackButton() {
        return this.kPY;
    }

    public EditText cTX() {
        return this.kPU;
    }

    public StateSwitchView cTY() {
        return this.kPV;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                KM(thumbPath);
                this.kyS.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kyS.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.kyS.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.kyP.setVideoPath(videoPath);
                this.kyP.start();
            }
        }
        if (!v.isEmpty(list)) {
            this.kQc.eD(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.kPU.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.kQc.eD(arrayList);
            this.kPU.setText("#" + videoTitleData.name + "#");
        }
    }

    public void cPo() {
        if (this.kyP != null) {
            this.kyP.resume();
            this.kyP.seekTo(this.kyZ);
            this.kyP.start();
        }
    }

    public void bEG() {
        this.kyZ = this.kyP.getCurrentPosition();
        if (this.kyP != null) {
            this.kyP.stopPlayback();
        }
    }

    public void KN(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.kPS.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.kPS.getResources().getString(R.string.post_to) + str);
        }
    }

    public void cTZ() {
        this.kPZ.aV(null);
        this.kPZ.tC(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kPZ.aV(postWriteCallBackData.getSensitiveWords());
            this.kPZ.Kx(postWriteCallBackData.getErrorString());
            if (!v.isEmpty(this.kPZ.cSM())) {
                tL(true);
            }
        }
    }

    public void tL(boolean z) {
        if (this.kPU.getText() != null) {
            int selectionEnd = this.kPU.getSelectionEnd();
            SpannableStringBuilder a = this.kPZ.a(this.kPU.getText());
            if (a != null) {
                this.kPZ.tD(true);
                this.kPU.setText(a);
                if (z && this.kPZ.cSN() >= 0) {
                    this.kPU.requestFocus();
                    this.kPU.setSelection(this.kPZ.cSN());
                } else {
                    this.kPU.setSelection(selectionEnd);
                }
                this.kPZ.tC(this.kPZ.cSN() >= 0);
            }
        }
    }

    public c cUa() {
        return this.kPZ;
    }

    public void tM(boolean z) {
        if (z) {
            this.kQa.setVisibility(8);
            this.kPX.setVisibility(0);
            this.bfi.smoothScrollTo(0, this.kPX.getBottom());
        }
    }
}
