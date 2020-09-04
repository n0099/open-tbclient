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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.c;
import com.baidu.tieba.write.editor.StateSwitchView;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static int mRU = 60;
    private ScrollView cch;
    private RelativeLayout gjc;
    private NavigationBar mNavigationBar;
    private WriteVideoActivity mRV;
    private TextView mRW;
    private EditText mRX;
    private StateSwitchView mRY;
    private StateSwitchView mRZ;
    private WriteLocationView mSa;
    private TextView mSb;
    private ImageView mSc;
    private c mSd;
    private LinearLayout mSe;
    private ListView mSf;
    private a mSg;
    private LinearLayout mSh;
    private TextView mSi;
    private TextView mSj;
    private ForumTabSelectedView mSl;
    private TextView mTitle;
    private CustomVideoView mzh;
    private ImageView mzk;
    private int mzr;
    private boolean mSk = true;
    private boolean mRP = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.mRV = writeVideoActivity;
        this.mRV.setContentView(R.layout.write_video_activity);
        this.mSd = new c();
        this.mSd.Jr(R.color.cp_cont_a);
        this.mSd.Js(R.color.cp_cont_h_alpha85);
        FG();
        initView();
    }

    public void xm(boolean z) {
        this.mRP = z;
        if (z) {
            if (this.mRZ != null) {
                this.mRZ.setVisibility(8);
            }
            if (this.mSa != null) {
                this.mSa.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.mRV.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void FG() {
        this.gjc = (RelativeLayout) this.mRV.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.mRV.findViewById(R.id.navigation_bar);
        this.mRX = (EditText) this.mRV.findViewById(R.id.edit_content);
        this.mSb = (TextView) this.mRV.findViewById(R.id.text_content_size);
        this.mzk = (ImageView) this.mRV.findViewById(R.id.video_cover);
        this.mzh = (CustomVideoView) this.mRV.findViewById(R.id.preview_videoview);
        this.cch = (ScrollView) this.mRV.findViewById(R.id.write_scrollview);
        this.mzh.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.mzh.getWidth() != b.this.mzk.getWidth() || b.this.mzh.getHeight() != b.this.mzk.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.mzk.getLayoutParams();
                    layoutParams.width = b.this.mzh.getWidth();
                    layoutParams.height = b.this.mzh.getHeight();
                    b.this.mzk.setLayoutParams(layoutParams);
                }
                b.this.mzk.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mzh.start();
                        b.this.mzk.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.mzh.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.dr(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.mSe = (LinearLayout) this.mRV.findViewById(R.id.video_activity_title_container);
        this.mSf = (ListView) this.mRV.findViewById(R.id.video_activity_title_list);
        this.mSf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.mSe.setVisibility(8);
                b.this.mSb.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.mRX.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.mRX.requestFocus();
                    if (!TextUtils.isEmpty(b.this.mRX.getText())) {
                        b.this.mRX.setSelection(b.this.mRX.getText().length());
                    }
                    l.showSoftKeyPad(b.this.mRV, b.this.mRX);
                }
            }
        });
        this.mSh = (LinearLayout) this.mRV.findViewById(R.id.save_video_wrapper);
        this.mSi = (TextView) this.mRV.findViewById(R.id.save_video_ridiobutton);
        this.mSj = (TextView) this.mRV.findViewById(R.id.save_video_ridiotext);
        this.mSa = (WriteLocationView) this.mRV.findViewById(R.id.location);
        this.mRZ = (StateSwitchView) this.mRV.findViewById(R.id.view_privacy);
        this.mRZ.setStateString(this.mRV.getString(R.string.display_on_my_home_page), this.mRV.getString(R.string.display_on_my_home_page));
        this.mRZ.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.mRZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.mRZ.aXr();
            }
        });
        this.mRZ.setTextSize(0, this.mRV.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void c(FrsTabInfoData frsTabInfoData) {
        this.mSl = (ForumTabSelectedView) this.mRV.findViewById(R.id.frs_tab_list);
        this.mSl.setData(frsTabInfoData);
        this.mSl.setActivity(this.mRV);
    }

    public ForumTabSelectedView dGZ() {
        return this.mSl;
    }

    public boolean isToDynamic() {
        return this.mRY != null && this.mRY.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dr(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.mRV) / l.getDimens(this.mRV, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.mRV);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.mRV, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.mzh.setVideoHeight(i4);
        this.mzh.setVideoWidth(i3);
        this.mzh.invalidate();
    }

    private void initView() {
        this.mSc = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.mRV);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mRV.getPageContext().getString(R.string.post_video_title));
        if (this.mRP) {
            this.mTitle.setText(this.mRV.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.mRW = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.mRV);
        this.mRW.setText(R.string.send_post);
        this.mRX.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.mRX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.mSg != null && b.this.mSg.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.mRV, b.this.mRX);
                    b.this.mSe.setVisibility(0);
                    b.this.mSb.setVisibility(8);
                }
                long dHa = b.mRU - b.this.dHa();
                if (dHa >= 0) {
                    ap.setViewTextColor(b.this.mSb, R.color.cp_cont_e);
                    b.this.mSb.setText(String.valueOf(dHa));
                    return;
                }
                b.this.mSb.setText("0");
                b.this.mRX.setText(b.this.mRX.getText().toString().substring(0, b.mRU));
                b.this.mRX.setSelection(b.this.mRX.getText().length());
                b.this.mRV.showToast(b.this.mRV.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.mSd != null) {
                    if (!b.this.mSd.dFG()) {
                        b.this.xn(false);
                    }
                    b.this.mSd.xa(false);
                }
            }
        });
        this.mSg = new a();
        this.mSf.setAdapter((ListAdapter) this.mSg);
        this.mSk = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.mSk) {
            ap.setBackgroundResource(this.mSi, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.mSi, R.drawable.corner_bg_radio_unselected);
        }
        ap.setViewTextColor(this.mSj, R.color.cp_cont_g);
        this.mSh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mSk) {
                    b.this.mSk = false;
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    ap.setBackgroundResource(b.this.mSi, R.drawable.corner_bg_radio_unselected);
                    b.this.mSi.invalidate();
                    return;
                }
                b.this.mSk = true;
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                ap.setBackgroundResource(b.this.mSi, R.drawable.corner_bg_radio_selected);
                b.this.mSi.invalidate();
            }
        });
    }

    public void SO(String str) {
        int i;
        int i2 = 0;
        Bitmap Qd = Qd(str);
        if (Qd != null && Qd.getHeight() != 0) {
            if (Qd.getHeight() <= 0) {
                i = 0;
            } else if (Qd.getWidth() / Qd.getHeight() > l.getEquipmentWidth(this.mRV) / l.getDimens(this.mRV, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.mRV);
                if (Qd.getWidth() > 0) {
                    i2 = (int) ((i / Qd.getWidth()) * Qd.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.mRV, R.dimen.ds440);
                if (Qd.getWidth() > 0) {
                    i = (int) ((dimens / Qd.getHeight()) * Qd.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.mzk.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.mzk.setLayoutParams(layoutParams);
            this.mzk.setImageBitmap(Qd);
        }
    }

    private Bitmap Qd(String str) {
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
        this.mRV.getLayoutMode().setNightMode(i == 1);
        this.mRV.getLayoutMode().onModeChanged(this.gjc);
        this.mNavigationBar.onChangeSkinType(this.mRV.getPageContext(), i);
        SvgManager.bjq().a(this.mSc, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mRW, R.color.cp_link_tip_a, 1);
        ap.c(this.mSa, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.mSk = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.mSk) {
            ap.setBackgroundResource(this.mSi, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.mSi, R.drawable.corner_bg_radio_unselected);
        }
        if (this.mSa != null) {
            this.mSa.onChangeSkinType(i);
        }
        if (this.mRZ != null) {
            this.mRZ.onChangeSkinType(i);
        }
        if (this.mSl != null) {
            this.mSl.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.mRX.getText() == null) {
            return null;
        }
        return this.mRX.getText().toString();
    }

    public long dHa() {
        if (this.mRX.getText() == null || this.mRX.getText().toString() == null) {
            return 0L;
        }
        return this.mRX.getText().length();
    }

    public WriteLocationView dHb() {
        return this.mSa;
    }

    public View dHc() {
        return this.mRW;
    }

    public View getBackButton() {
        return this.mSc;
    }

    public EditText dHd() {
        return this.mRX;
    }

    public StateSwitchView dHe() {
        return this.mRZ;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                SO(thumbPath);
                this.mzk.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mzk.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.mzk.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.mzh.setVideoPath(videoPath);
                this.mzh.start();
            }
        }
        if (!y.isEmpty(list)) {
            this.mSg.fA(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.mRX.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.mSg.fA(arrayList);
            this.mRX.setText("#" + videoTitleData.name + "#");
        }
    }

    public void dCG() {
        if (this.mzh != null) {
            this.mzh.resume();
            this.mzh.seekTo(this.mzr);
            this.mzh.start();
        }
    }

    public void coK() {
        this.mzr = this.mzh.getCurrentPosition();
        if (this.mzh != null) {
            this.mzh.stopPlayback();
        }
    }

    public void SP(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.mRV.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.mRV.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dHf() {
        this.mSd.bf(null);
        this.mSd.wZ(false);
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.mSd.bf(postWriteCallBackData.getSensitiveWords());
            this.mSd.Sw(postWriteCallBackData.getErrorString());
            if (!y.isEmpty(this.mSd.dFD())) {
                xn(true);
            }
        }
    }

    public void xn(boolean z) {
        if (this.mRX.getText() != null) {
            int selectionEnd = this.mRX.getSelectionEnd();
            SpannableStringBuilder c = this.mSd.c(this.mRX.getText());
            if (c != null) {
                this.mSd.xa(true);
                this.mRX.setText(c);
                if (z && this.mSd.dFE() >= 0) {
                    this.mRX.requestFocus();
                    this.mRX.setSelection(this.mSd.dFE());
                } else {
                    this.mRX.setSelection(selectionEnd);
                }
                this.mSd.wZ(this.mSd.dFE() >= 0);
            }
        }
    }

    public c dHg() {
        return this.mSd;
    }

    public void xo(boolean z) {
        if (z) {
            this.mSe.setVisibility(8);
            this.mSb.setVisibility(0);
            this.cch.smoothScrollTo(0, this.mSb.getBottom());
        }
    }
}
