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
/* loaded from: classes10.dex */
public class b {
    public static int kMl = 60;
    private ScrollView bes;
    private RelativeLayout eIf;
    private StateSwitchView kJS;
    private TextView kMA;
    private boolean kMB = true;
    private WriteVideoActivity kMm;
    private TextView kMn;
    private EditText kMo;
    private StateSwitchView kMp;
    private WriteLocationView kMq;
    private TextView kMr;
    private ImageView kMs;
    private c kMt;
    private LinearLayout kMu;
    private ListView kMv;
    private a kMw;
    private LinearLayout kMx;
    private TextView kMy;
    private TextView kMz;
    private CustomVideoView kvh;
    private ImageView kvk;
    private int kvr;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.kMm = writeVideoActivity;
        this.kMm.setContentView(R.layout.write_video_activity);
        this.kMt = new c();
        this.kMt.DO(R.color.cp_cont_a);
        this.kMt.DP(R.color.cp_cont_h_alpha85);
        cSN();
        initView();
    }

    private void cSN() {
        this.eIf = (RelativeLayout) this.kMm.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.kMm.findViewById(R.id.navigation_bar);
        this.kMo = (EditText) this.kMm.findViewById(R.id.edit_content);
        this.kMr = (TextView) this.kMm.findViewById(R.id.text_content_size);
        this.kvk = (ImageView) this.kMm.findViewById(R.id.video_cover);
        this.kvh = (CustomVideoView) this.kMm.findViewById(R.id.preview_videoview);
        this.bes = (ScrollView) this.kMm.findViewById(R.id.write_scrollview);
        this.kvh.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.kvh.getWidth() != b.this.kvk.getWidth() || b.this.kvh.getHeight() != b.this.kvk.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.kvk.getLayoutParams();
                    layoutParams.width = b.this.kvh.getWidth();
                    layoutParams.height = b.this.kvh.getHeight();
                    b.this.kvk.setLayoutParams(layoutParams);
                }
                b.this.kvk.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kvh.start();
                        b.this.kvk.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.kvh.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cO(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.kMu = (LinearLayout) this.kMm.findViewById(R.id.video_activity_title_container);
        this.kMv = (ListView) this.kMm.findViewById(R.id.video_activity_title_list);
        this.kMv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.kMu.setVisibility(8);
                b.this.kMr.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.kMo.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.kMo.requestFocus();
                    if (!TextUtils.isEmpty(b.this.kMo.getText())) {
                        b.this.kMo.setSelection(b.this.kMo.getText().length());
                    }
                    l.showSoftKeyPad(b.this.kMm, b.this.kMo);
                }
            }
        });
        this.kMx = (LinearLayout) this.kMm.findViewById(R.id.save_video_wrapper);
        this.kMy = (TextView) this.kMm.findViewById(R.id.save_video_ridiobutton);
        this.kMz = (TextView) this.kMm.findViewById(R.id.save_video_ridiotext);
        this.kMA = (TextView) this.kMm.findViewById(R.id.display_in_nani_tip);
        this.kMq = (WriteLocationView) this.kMm.findViewById(R.id.location);
        this.kMp = (StateSwitchView) this.kMm.findViewById(R.id.view_privacy);
        this.kMp.setStateString(this.kMm.getString(R.string.display_on_my_home_page), this.kMm.getString(R.string.display_on_my_home_page));
        this.kMp.setLeftStateDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.e.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.kMp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kMp.aXR();
            }
        });
        this.kMp.setTextSize(0, this.kMm.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public boolean isToDynamic() {
        return this.kJS != null && this.kJS.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cO(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.kMm) / l.getDimens(this.kMm, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.kMm);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.kMm, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.kvh.setVideoHeight(i4);
        this.kvh.setVideoWidth(i3);
        this.kvh.invalidate();
    }

    private void initView() {
        this.kMs = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.kMm);
        this.mNavigationBar.setCenterTextTitle(this.kMm.getPageContext().getString(R.string.post_video_title));
        this.kMn = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.kMm);
        this.kMn.setText(R.string.send_post);
        this.kMo.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.kMo.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.kMw != null && b.this.kMw.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.kMm, b.this.kMo);
                    b.this.kMu.setVisibility(0);
                    b.this.kMr.setVisibility(8);
                }
                long cSP = b.kMl - b.this.cSP();
                if (cSP >= 0) {
                    am.setViewTextColor(b.this.kMr, (int) R.color.cp_cont_e);
                    b.this.kMr.setText(String.valueOf(cSP));
                    return;
                }
                b.this.kMr.setText("0");
                b.this.kMo.setText(b.this.kMo.getText().toString().substring(0, b.kMl));
                b.this.kMo.setSelection(b.this.kMo.getText().length());
                b.this.kMm.showToast(b.this.kMm.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.kMt != null) {
                    if (!b.this.kMt.cRK()) {
                        b.this.tz(false);
                    }
                    b.this.kMt.tr(false);
                }
            }
        });
        this.kMw = new a();
        this.kMv.setAdapter((ListAdapter) this.kMw);
        this.kMB = com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.kMB) {
            am.setBackgroundResource(this.kMy, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.kMy, R.drawable.corner_bg_radio_unselected);
        }
        am.setViewTextColor(this.kMz, (int) R.color.cp_cont_g);
        this.kMx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.kMB) {
                    b.this.kMB = false;
                    com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    am.setBackgroundResource(b.this.kMy, R.drawable.corner_bg_radio_unselected);
                    b.this.kMy.invalidate();
                    return;
                }
                b.this.kMB = true;
                com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                am.setBackgroundResource(b.this.kMy, R.drawable.corner_bg_radio_selected);
                b.this.kMy.invalidate();
            }
        });
    }

    public void cSO() {
        if (this.kMA != null) {
            this.kMA.setVisibility(0);
        }
    }

    public void KC(String str) {
        int i;
        int i2 = 0;
        Bitmap Id = Id(str);
        if (Id != null && Id.getHeight() != 0) {
            if (Id.getHeight() <= 0) {
                i = 0;
            } else if (Id.getWidth() / Id.getHeight() > l.getEquipmentWidth(this.kMm) / l.getDimens(this.kMm, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.kMm);
                if (Id.getWidth() > 0) {
                    i2 = (int) ((i / Id.getWidth()) * Id.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.kMm, R.dimen.ds440);
                if (Id.getWidth() > 0) {
                    i = (int) ((dimens / Id.getHeight()) * Id.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.kvk.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.kvk.setLayoutParams(layoutParams);
            this.kvk.setImageBitmap(Id);
        }
    }

    private Bitmap Id(String str) {
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
        this.kMm.getLayoutMode().setNightMode(i == 1);
        this.kMm.getLayoutMode().onModeChanged(this.eIf);
        this.mNavigationBar.onChangeSkinType(this.kMm.getPageContext(), i);
        SvgManager.aDW().a(this.kMs, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.kMn, R.color.cp_link_tip_a, 1);
        am.c(this.kMq, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.setViewTextColor(this.kMA, (int) R.color.cp_cont_e);
        this.kMB = com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.kMB) {
            am.setBackgroundResource(this.kMy, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.kMy, R.drawable.corner_bg_radio_unselected);
        }
        if (this.kMq != null) {
            this.kMq.onChangeSkinType(i);
        }
        if (this.kMp != null) {
            this.kMp.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.kMo.getText() == null) {
            return null;
        }
        return this.kMo.getText().toString();
    }

    public long cSP() {
        if (this.kMo.getText() == null || this.kMo.getText().toString() == null) {
            return 0L;
        }
        return this.kMo.getText().length();
    }

    public WriteLocationView cSQ() {
        return this.kMq;
    }

    public View cSR() {
        return this.kMn;
    }

    public View getBackButton() {
        return this.kMs;
    }

    public EditText cSS() {
        return this.kMo;
    }

    public StateSwitchView cST() {
        return this.kMp;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                KC(thumbPath);
                this.kvk.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kvk.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.kvk.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.kvh.setVideoPath(videoPath);
                this.kvh.start();
            }
        }
        if (!v.isEmpty(list)) {
            this.kMw.eD(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.kMo.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.kMw.eD(arrayList);
            this.kMo.setText("#" + videoTitleData.name + "#");
        }
    }

    public void cOj() {
        if (this.kvh != null) {
            this.kvh.resume();
            this.kvh.seekTo(this.kvr);
            this.kvh.start();
        }
    }

    public void bDE() {
        this.kvr = this.kvh.getCurrentPosition();
        if (this.kvh != null) {
            this.kvh.stopPlayback();
        }
    }

    public void KD(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.kMm.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.kMm.getResources().getString(R.string.post_to) + str);
        }
    }

    public void cSU() {
        this.kMt.aV(null);
        this.kMt.tq(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kMt.aV(postWriteCallBackData.getSensitiveWords());
            this.kMt.Kn(postWriteCallBackData.getErrorString());
            if (!v.isEmpty(this.kMt.cRH())) {
                tz(true);
            }
        }
    }

    public void tz(boolean z) {
        if (this.kMo.getText() != null) {
            int selectionEnd = this.kMo.getSelectionEnd();
            SpannableStringBuilder a = this.kMt.a(this.kMo.getText());
            if (a != null) {
                this.kMt.tr(true);
                this.kMo.setText(a);
                if (z && this.kMt.cRI() >= 0) {
                    this.kMo.requestFocus();
                    this.kMo.setSelection(this.kMt.cRI());
                } else {
                    this.kMo.setSelection(selectionEnd);
                }
                this.kMt.tq(this.kMt.cRI() >= 0);
            }
        }
    }

    public c cSV() {
        return this.kMt;
    }

    public void tA(boolean z) {
        if (z) {
            this.kMu.setVisibility(8);
            this.kMr.setVisibility(0);
            this.bes.smoothScrollTo(0, this.kMr.getBottom());
        }
    }
}
