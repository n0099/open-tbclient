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
    public static int jSq = 60;
    private ScrollView bvD;
    private RelativeLayout dTp;
    private CustomVideoView jCh;
    private ImageView jCk;
    private int jCr;
    private ListView jSA;
    private a jSB;
    private LinearLayout jSC;
    private TextView jSD;
    private TextView jSE;
    private TextView jSF;
    private boolean jSG = true;
    private WriteVideoActivity jSr;
    private TextView jSs;
    private EditText jSt;
    private StateSwitchView jSu;
    private WriteLocationView jSv;
    private TextView jSw;
    private ImageView jSx;
    private com.baidu.tieba.write.b jSy;
    private LinearLayout jSz;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.jSr = writeVideoActivity;
        this.jSr.setContentView(R.layout.write_video_activity);
        this.jSy = new com.baidu.tieba.write.b();
        this.jSy.Bs(R.color.cp_cont_a);
        this.jSy.Bt(R.color.cp_cont_h_alpha85);
        cyN();
        initView();
    }

    private void cyN() {
        this.dTp = (RelativeLayout) this.jSr.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.jSr.findViewById(R.id.navigation_bar);
        this.jSt = (EditText) this.jSr.findViewById(R.id.edit_content);
        this.jSw = (TextView) this.jSr.findViewById(R.id.text_content_size);
        this.jCk = (ImageView) this.jSr.findViewById(R.id.video_cover);
        this.jSv = (WriteLocationView) this.jSr.findViewById(R.id.location);
        this.jCh = (CustomVideoView) this.jSr.findViewById(R.id.preview_videoview);
        this.bvD = (ScrollView) this.jSr.findViewById(R.id.write_scrollview);
        this.jCh.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.jCh.getWidth() != b.this.jCk.getWidth() || b.this.jCh.getHeight() != b.this.jCk.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.jCk.getLayoutParams();
                    layoutParams.width = b.this.jCh.getWidth();
                    layoutParams.height = b.this.jCh.getHeight();
                    b.this.jCk.setLayoutParams(layoutParams);
                }
                b.this.jCk.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jCh.start();
                        b.this.jCk.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.jCh.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cy(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jSz = (LinearLayout) this.jSr.findViewById(R.id.video_activity_title_container);
        this.jSA = (ListView) this.jSr.findViewById(R.id.video_activity_title_list);
        this.jSA.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.jSz.setVisibility(8);
                b.this.jSw.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.jSt.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.jSt.requestFocus();
                    if (!TextUtils.isEmpty(b.this.jSt.getText())) {
                        b.this.jSt.setSelection(b.this.jSt.getText().length());
                    }
                    l.showSoftKeyPad(b.this.jSr, b.this.jSt);
                }
            }
        });
        this.jSC = (LinearLayout) this.jSr.findViewById(R.id.save_video_wrapper);
        this.jSD = (TextView) this.jSr.findViewById(R.id.save_video_ridiobutton);
        this.jSE = (TextView) this.jSr.findViewById(R.id.save_video_ridiotext);
        this.jSF = (TextView) this.jSr.findViewById(R.id.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.jSr) / l.getDimens(this.jSr, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.jSr);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.jSr, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.jCh.setVideoHeight(i4);
        this.jCh.setVideoWidth(i3);
        this.jCh.invalidate();
    }

    private void initView() {
        this.jSx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.jSr);
        this.mNavigationBar.setCenterTextTitle(this.jSr.getPageContext().getString(R.string.post_video_title));
        this.jSs = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.jSr);
        this.jSs.setText(R.string.send_post);
        this.jSt.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.jSt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.jSB != null && b.this.jSB.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.jSr, b.this.jSt);
                    b.this.jSz.setVisibility(0);
                    b.this.jSw.setVisibility(8);
                }
                long cyP = b.jSq - b.this.cyP();
                if (cyP >= 0) {
                    am.setViewTextColor(b.this.jSw, (int) R.color.cp_cont_e);
                    b.this.jSw.setText(String.valueOf(cyP));
                    return;
                }
                b.this.jSw.setText("0");
                b.this.jSt.setText(b.this.jSt.getText().toString().substring(0, b.jSq));
                b.this.jSt.setSelection(b.this.jSt.getText().length());
                b.this.jSr.showToast(b.this.jSr.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.jSy != null) {
                    if (!b.this.jSy.cxB()) {
                        b.this.rS(false);
                    }
                    b.this.jSy.rL(false);
                }
            }
        });
        this.jSB = new a();
        this.jSA.setAdapter((ListAdapter) this.jSB);
        this.jSG = com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.jSG) {
            am.setBackgroundResource(this.jSD, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.jSD, R.drawable.corner_bg_radio_unselected);
        }
        am.setViewTextColor(this.jSE, (int) R.color.cp_cont_g);
        this.jSC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jSG) {
                    b.this.jSG = false;
                    com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    am.setBackgroundResource(b.this.jSD, R.drawable.corner_bg_radio_unselected);
                    b.this.jSD.invalidate();
                    return;
                }
                b.this.jSG = true;
                com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                am.setBackgroundResource(b.this.jSD, R.drawable.corner_bg_radio_selected);
                b.this.jSD.invalidate();
            }
        });
    }

    public void cyO() {
        if (this.jSF != null) {
            this.jSF.setVisibility(0);
        }
    }

    public void FK(String str) {
        int i;
        int i2 = 0;
        Bitmap Dq = Dq(str);
        if (Dq != null && Dq.getHeight() != 0) {
            if (Dq.getHeight() <= 0) {
                i = 0;
            } else if (Dq.getWidth() / Dq.getHeight() > l.getEquipmentWidth(this.jSr) / l.getDimens(this.jSr, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.jSr);
                if (Dq.getWidth() > 0) {
                    i2 = (int) ((i / Dq.getWidth()) * Dq.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.jSr, R.dimen.ds440);
                if (Dq.getWidth() > 0) {
                    i = (int) ((dimens / Dq.getHeight()) * Dq.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jCk.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.jCk.setLayoutParams(layoutParams);
            this.jCk.setImageBitmap(Dq);
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
        this.jSr.getLayoutMode().setNightMode(i == 1);
        this.jSr.getLayoutMode().onModeChanged(this.dTp);
        this.mNavigationBar.onChangeSkinType(this.jSr.getPageContext(), i);
        SvgManager.amN().a(this.jSx, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.jSs, R.color.cp_link_tip_a, 1);
        am.setBackgroundResource(this.jSv, R.drawable.corner_bg);
        am.setViewTextColor(this.jSF, (int) R.color.cp_cont_e);
        this.jSG = com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.jSG) {
            am.setBackgroundResource(this.jSD, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.jSD, R.drawable.corner_bg_radio_unselected);
        }
        if (this.jSv != null) {
            this.jSv.onChangeSkinType(i);
        }
        if (this.jSu != null) {
            this.jSu.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.jSt.getText() == null) {
            return null;
        }
        return this.jSt.getText().toString();
    }

    public long cyP() {
        if (this.jSt.getText() == null || this.jSt.getText().toString() == null) {
            return 0L;
        }
        return this.jSt.getText().length();
    }

    public WriteLocationView cyQ() {
        return this.jSv;
    }

    public View cyR() {
        return this.jSs;
    }

    public View getBackButton() {
        return this.jSx;
    }

    public EditText cyS() {
        return this.jSt;
    }

    public StateSwitchView cyT() {
        return this.jSu;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                FK(thumbPath);
                this.jCk.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jCk.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.jCk.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.jCh.setVideoPath(videoPath);
                this.jCh.start();
            }
        }
        if (!v.isEmpty(list)) {
            this.jSB.eL(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.jSt.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.jSB.eL(arrayList);
            this.jSt.setText("#" + videoTitleData.name + "#");
        }
    }

    public void cum() {
        if (this.jCh != null) {
            this.jCh.resume();
            this.jCh.seekTo(this.jCr);
            this.jCh.start();
        }
    }

    public void bmj() {
        this.jCr = this.jCh.getCurrentPosition();
        if (this.jCh != null) {
            this.jCh.stopPlayback();
        }
    }

    public void FL(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.jSr.getResources().getString(R.string.post_to_home_page));
            cyU();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.jSr.getResources().getString(R.string.post_to) + str);
        cyV();
    }

    private void cyU() {
        this.jSu = new StateSwitchView(this.jSr);
        this.jSu.setStateString(this.jSr.getString(R.string.public_to_all), this.jSr.getString(R.string.public_to_me));
        am.e(this.jSu, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.jSu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jSu.aHJ();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.getDimens(this.jSr, R.dimen.ds34), l.getDimens(this.jSr, R.dimen.ds16));
        this.dTp.addView(this.jSu, layoutParams);
    }

    private void cyV() {
        this.jSu = new StateSwitchView(this.jSr);
        this.jSu.setStateString(this.jSr.getString(R.string.display_to_home_page), this.jSr.getString(R.string.display_to_home_page));
        this.jSu.setLeftStateDrawable(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_stroke1_blue_h_svg), new d(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.jSu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jSu.aHJ();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.getDimens(this.jSr, R.dimen.ds34), l.getDimens(this.jSr, R.dimen.ds16));
        this.jSu.setTextSize(0, this.jSr.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.dTp.addView(this.jSu, layoutParams);
    }

    public void cyW() {
        this.jSy.aM(null);
        this.jSy.rK(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jSy.aM(postWriteCallBackData.getSensitiveWords());
            this.jSy.Fv(postWriteCallBackData.getErrorString());
            if (!v.isEmpty(this.jSy.cxy())) {
                rS(true);
            }
        }
    }

    public void rS(boolean z) {
        if (this.jSt.getText() != null) {
            int selectionEnd = this.jSt.getSelectionEnd();
            SpannableStringBuilder a = this.jSy.a(this.jSt.getText());
            if (a != null) {
                this.jSy.rL(true);
                this.jSt.setText(a);
                if (z && this.jSy.cxz() >= 0) {
                    this.jSt.requestFocus();
                    this.jSt.setSelection(this.jSy.cxz());
                } else {
                    this.jSt.setSelection(selectionEnd);
                }
                this.jSy.rK(this.jSy.cxz() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b cyX() {
        return this.jSy;
    }

    public void rT(boolean z) {
        if (z) {
            this.jSz.setVisibility(8);
            this.jSw.setVisibility(0);
            this.bvD.smoothScrollTo(0, this.jSw.getBottom());
        }
    }
}
