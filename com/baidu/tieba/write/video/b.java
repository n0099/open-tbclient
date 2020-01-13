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
    public static int kPM = 60;
    private ScrollView bfi;
    private RelativeLayout eJp;
    private StateSwitchView kNt;
    private WriteVideoActivity kPN;
    private TextView kPO;
    private EditText kPP;
    private StateSwitchView kPQ;
    private WriteLocationView kPR;
    private TextView kPS;
    private ImageView kPT;
    private c kPU;
    private LinearLayout kPV;
    private ListView kPW;
    private a kPX;
    private LinearLayout kPY;
    private TextView kPZ;
    private TextView kQa;
    private TextView kQb;
    private boolean kQc = true;
    private CustomVideoView kyK;
    private ImageView kyN;
    private int kyU;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.kPN = writeVideoActivity;
        this.kPN.setContentView(R.layout.write_video_activity);
        this.kPU = new c();
        this.kPU.DU(R.color.cp_cont_a);
        this.kPU.DV(R.color.cp_cont_h_alpha85);
        cTQ();
        initView();
    }

    private void cTQ() {
        this.eJp = (RelativeLayout) this.kPN.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.kPN.findViewById(R.id.navigation_bar);
        this.kPP = (EditText) this.kPN.findViewById(R.id.edit_content);
        this.kPS = (TextView) this.kPN.findViewById(R.id.text_content_size);
        this.kyN = (ImageView) this.kPN.findViewById(R.id.video_cover);
        this.kyK = (CustomVideoView) this.kPN.findViewById(R.id.preview_videoview);
        this.bfi = (ScrollView) this.kPN.findViewById(R.id.write_scrollview);
        this.kyK.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.kyK.getWidth() != b.this.kyN.getWidth() || b.this.kyK.getHeight() != b.this.kyN.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.kyN.getLayoutParams();
                    layoutParams.width = b.this.kyK.getWidth();
                    layoutParams.height = b.this.kyK.getHeight();
                    b.this.kyN.setLayoutParams(layoutParams);
                }
                b.this.kyN.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kyK.start();
                        b.this.kyN.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.kyK.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cN(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.kPV = (LinearLayout) this.kPN.findViewById(R.id.video_activity_title_container);
        this.kPW = (ListView) this.kPN.findViewById(R.id.video_activity_title_list);
        this.kPW.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.kPV.setVisibility(8);
                b.this.kPS.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.kPP.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.kPP.requestFocus();
                    if (!TextUtils.isEmpty(b.this.kPP.getText())) {
                        b.this.kPP.setSelection(b.this.kPP.getText().length());
                    }
                    l.showSoftKeyPad(b.this.kPN, b.this.kPP);
                }
            }
        });
        this.kPY = (LinearLayout) this.kPN.findViewById(R.id.save_video_wrapper);
        this.kPZ = (TextView) this.kPN.findViewById(R.id.save_video_ridiobutton);
        this.kQa = (TextView) this.kPN.findViewById(R.id.save_video_ridiotext);
        this.kQb = (TextView) this.kPN.findViewById(R.id.display_in_nani_tip);
        this.kPR = (WriteLocationView) this.kPN.findViewById(R.id.location);
        this.kPQ = (StateSwitchView) this.kPN.findViewById(R.id.view_privacy);
        this.kPQ.setStateString(this.kPN.getString(R.string.display_on_my_home_page), this.kPN.getString(R.string.display_on_my_home_page));
        this.kPQ.setLeftStateDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.e.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.kPQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kPQ.aYl();
            }
        });
        this.kPQ.setTextSize(0, this.kPN.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public boolean isToDynamic() {
        return this.kNt != null && this.kNt.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.kPN) / l.getDimens(this.kPN, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.kPN);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.kPN, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.kyK.setVideoHeight(i4);
        this.kyK.setVideoWidth(i3);
        this.kyK.invalidate();
    }

    private void initView() {
        this.kPT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.kPN);
        this.mNavigationBar.setCenterTextTitle(this.kPN.getPageContext().getString(R.string.post_video_title));
        this.kPO = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.kPN);
        this.kPO.setText(R.string.send_post);
        this.kPP.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.kPP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.kPX != null && b.this.kPX.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.kPN, b.this.kPP);
                    b.this.kPV.setVisibility(0);
                    b.this.kPS.setVisibility(8);
                }
                long cTS = b.kPM - b.this.cTS();
                if (cTS >= 0) {
                    am.setViewTextColor(b.this.kPS, (int) R.color.cp_cont_e);
                    b.this.kPS.setText(String.valueOf(cTS));
                    return;
                }
                b.this.kPS.setText("0");
                b.this.kPP.setText(b.this.kPP.getText().toString().substring(0, b.kPM));
                b.this.kPP.setSelection(b.this.kPP.getText().length());
                b.this.kPN.showToast(b.this.kPN.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.kPU != null) {
                    if (!b.this.kPU.cSN()) {
                        b.this.tL(false);
                    }
                    b.this.kPU.tD(false);
                }
            }
        });
        this.kPX = new a();
        this.kPW.setAdapter((ListAdapter) this.kPX);
        this.kQc = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.kQc) {
            am.setBackgroundResource(this.kPZ, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.kPZ, R.drawable.corner_bg_radio_unselected);
        }
        am.setViewTextColor(this.kQa, (int) R.color.cp_cont_g);
        this.kPY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.kQc) {
                    b.this.kQc = false;
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    am.setBackgroundResource(b.this.kPZ, R.drawable.corner_bg_radio_unselected);
                    b.this.kPZ.invalidate();
                    return;
                }
                b.this.kQc = true;
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                am.setBackgroundResource(b.this.kPZ, R.drawable.corner_bg_radio_selected);
                b.this.kPZ.invalidate();
            }
        });
    }

    public void cTR() {
        if (this.kQb != null) {
            this.kQb.setVisibility(0);
        }
    }

    public void KM(String str) {
        int i;
        int i2 = 0;
        Bitmap In = In(str);
        if (In != null && In.getHeight() != 0) {
            if (In.getHeight() <= 0) {
                i = 0;
            } else if (In.getWidth() / In.getHeight() > l.getEquipmentWidth(this.kPN) / l.getDimens(this.kPN, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.kPN);
                if (In.getWidth() > 0) {
                    i2 = (int) ((i / In.getWidth()) * In.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.kPN, R.dimen.ds440);
                if (In.getWidth() > 0) {
                    i = (int) ((dimens / In.getHeight()) * In.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.kyN.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.kyN.setLayoutParams(layoutParams);
            this.kyN.setImageBitmap(In);
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
        this.kPN.getLayoutMode().setNightMode(i == 1);
        this.kPN.getLayoutMode().onModeChanged(this.eJp);
        this.mNavigationBar.onChangeSkinType(this.kPN.getPageContext(), i);
        SvgManager.aEp().a(this.kPT, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.kPO, R.color.cp_link_tip_a, 1);
        am.c(this.kPR, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.setViewTextColor(this.kQb, (int) R.color.cp_cont_e);
        this.kQc = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.kQc) {
            am.setBackgroundResource(this.kPZ, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.kPZ, R.drawable.corner_bg_radio_unselected);
        }
        if (this.kPR != null) {
            this.kPR.onChangeSkinType(i);
        }
        if (this.kPQ != null) {
            this.kPQ.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.kPP.getText() == null) {
            return null;
        }
        return this.kPP.getText().toString();
    }

    public long cTS() {
        if (this.kPP.getText() == null || this.kPP.getText().toString() == null) {
            return 0L;
        }
        return this.kPP.getText().length();
    }

    public WriteLocationView cTT() {
        return this.kPR;
    }

    public View cTU() {
        return this.kPO;
    }

    public View getBackButton() {
        return this.kPT;
    }

    public EditText cTV() {
        return this.kPP;
    }

    public StateSwitchView cTW() {
        return this.kPQ;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                KM(thumbPath);
                this.kyN.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kyN.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.kyN.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.kyK.setVideoPath(videoPath);
                this.kyK.start();
            }
        }
        if (!v.isEmpty(list)) {
            this.kPX.eD(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.kPP.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.kPX.eD(arrayList);
            this.kPP.setText("#" + videoTitleData.name + "#");
        }
    }

    public void cPm() {
        if (this.kyK != null) {
            this.kyK.resume();
            this.kyK.seekTo(this.kyU);
            this.kyK.start();
        }
    }

    public void bEG() {
        this.kyU = this.kyK.getCurrentPosition();
        if (this.kyK != null) {
            this.kyK.stopPlayback();
        }
    }

    public void KN(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.kPN.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.kPN.getResources().getString(R.string.post_to) + str);
        }
    }

    public void cTX() {
        this.kPU.aV(null);
        this.kPU.tC(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kPU.aV(postWriteCallBackData.getSensitiveWords());
            this.kPU.Kx(postWriteCallBackData.getErrorString());
            if (!v.isEmpty(this.kPU.cSK())) {
                tL(true);
            }
        }
    }

    public void tL(boolean z) {
        if (this.kPP.getText() != null) {
            int selectionEnd = this.kPP.getSelectionEnd();
            SpannableStringBuilder a = this.kPU.a(this.kPP.getText());
            if (a != null) {
                this.kPU.tD(true);
                this.kPP.setText(a);
                if (z && this.kPU.cSL() >= 0) {
                    this.kPP.requestFocus();
                    this.kPP.setSelection(this.kPU.cSL());
                } else {
                    this.kPP.setSelection(selectionEnd);
                }
                this.kPU.tC(this.kPU.cSL() >= 0);
            }
        }
    }

    public c cTY() {
        return this.kPU;
    }

    public void tM(boolean z) {
        if (z) {
            this.kPV.setVisibility(8);
            this.kPS.setVisibility(0);
            this.bfi.smoothScrollTo(0, this.kPS.getBottom());
        }
    }
}
