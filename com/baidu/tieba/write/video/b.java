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
    public static int mRC = 60;
    private ScrollView ccd;
    private RelativeLayout giY;
    private NavigationBar mNavigationBar;
    private WriteVideoActivity mRD;
    private TextView mRE;
    private EditText mRF;
    private StateSwitchView mRG;
    private StateSwitchView mRH;
    private WriteLocationView mRI;
    private TextView mRJ;
    private ImageView mRK;
    private c mRL;
    private LinearLayout mRM;
    private ListView mRN;
    private a mRO;
    private LinearLayout mRP;
    private TextView mRQ;
    private TextView mRR;
    private ForumTabSelectedView mRT;
    private TextView mTitle;
    private CustomVideoView myP;
    private ImageView myS;
    private int myZ;
    private boolean mRS = true;
    private boolean mRx = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.mRD = writeVideoActivity;
        this.mRD.setContentView(R.layout.write_video_activity);
        this.mRL = new c();
        this.mRL.Jr(R.color.cp_cont_a);
        this.mRL.Js(R.color.cp_cont_h_alpha85);
        FG();
        initView();
    }

    public void xk(boolean z) {
        this.mRx = z;
        if (z) {
            if (this.mRH != null) {
                this.mRH.setVisibility(8);
            }
            if (this.mRI != null) {
                this.mRI.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.mRD.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void FG() {
        this.giY = (RelativeLayout) this.mRD.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.mRD.findViewById(R.id.navigation_bar);
        this.mRF = (EditText) this.mRD.findViewById(R.id.edit_content);
        this.mRJ = (TextView) this.mRD.findViewById(R.id.text_content_size);
        this.myS = (ImageView) this.mRD.findViewById(R.id.video_cover);
        this.myP = (CustomVideoView) this.mRD.findViewById(R.id.preview_videoview);
        this.ccd = (ScrollView) this.mRD.findViewById(R.id.write_scrollview);
        this.myP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.myP.getWidth() != b.this.myS.getWidth() || b.this.myP.getHeight() != b.this.myS.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.myS.getLayoutParams();
                    layoutParams.width = b.this.myP.getWidth();
                    layoutParams.height = b.this.myP.getHeight();
                    b.this.myS.setLayoutParams(layoutParams);
                }
                b.this.myS.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.myP.start();
                        b.this.myS.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.myP.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.dr(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.mRM = (LinearLayout) this.mRD.findViewById(R.id.video_activity_title_container);
        this.mRN = (ListView) this.mRD.findViewById(R.id.video_activity_title_list);
        this.mRN.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.mRM.setVisibility(8);
                b.this.mRJ.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.mRF.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.mRF.requestFocus();
                    if (!TextUtils.isEmpty(b.this.mRF.getText())) {
                        b.this.mRF.setSelection(b.this.mRF.getText().length());
                    }
                    l.showSoftKeyPad(b.this.mRD, b.this.mRF);
                }
            }
        });
        this.mRP = (LinearLayout) this.mRD.findViewById(R.id.save_video_wrapper);
        this.mRQ = (TextView) this.mRD.findViewById(R.id.save_video_ridiobutton);
        this.mRR = (TextView) this.mRD.findViewById(R.id.save_video_ridiotext);
        this.mRI = (WriteLocationView) this.mRD.findViewById(R.id.location);
        this.mRH = (StateSwitchView) this.mRD.findViewById(R.id.view_privacy);
        this.mRH.setStateString(this.mRD.getString(R.string.display_on_my_home_page), this.mRD.getString(R.string.display_on_my_home_page));
        this.mRH.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.mRH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.mRH.aXr();
            }
        });
        this.mRH.setTextSize(0, this.mRD.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void c(FrsTabInfoData frsTabInfoData) {
        this.mRT = (ForumTabSelectedView) this.mRD.findViewById(R.id.frs_tab_list);
        this.mRT.setData(frsTabInfoData);
        this.mRT.setActivity(this.mRD);
    }

    public ForumTabSelectedView dGQ() {
        return this.mRT;
    }

    public boolean isToDynamic() {
        return this.mRG != null && this.mRG.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dr(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.mRD) / l.getDimens(this.mRD, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.mRD);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.mRD, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.myP.setVideoHeight(i4);
        this.myP.setVideoWidth(i3);
        this.myP.invalidate();
    }

    private void initView() {
        this.mRK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.mRD);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mRD.getPageContext().getString(R.string.post_video_title));
        if (this.mRx) {
            this.mTitle.setText(this.mRD.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.mRE = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.mRD);
        this.mRE.setText(R.string.send_post);
        this.mRF.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.mRF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.mRO != null && b.this.mRO.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.mRD, b.this.mRF);
                    b.this.mRM.setVisibility(0);
                    b.this.mRJ.setVisibility(8);
                }
                long dGR = b.mRC - b.this.dGR();
                if (dGR >= 0) {
                    ap.setViewTextColor(b.this.mRJ, R.color.cp_cont_e);
                    b.this.mRJ.setText(String.valueOf(dGR));
                    return;
                }
                b.this.mRJ.setText("0");
                b.this.mRF.setText(b.this.mRF.getText().toString().substring(0, b.mRC));
                b.this.mRF.setSelection(b.this.mRF.getText().length());
                b.this.mRD.showToast(b.this.mRD.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.mRL != null) {
                    if (!b.this.mRL.dFx()) {
                        b.this.xl(false);
                    }
                    b.this.mRL.wY(false);
                }
            }
        });
        this.mRO = new a();
        this.mRN.setAdapter((ListAdapter) this.mRO);
        this.mRS = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.mRS) {
            ap.setBackgroundResource(this.mRQ, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.mRQ, R.drawable.corner_bg_radio_unselected);
        }
        ap.setViewTextColor(this.mRR, R.color.cp_cont_g);
        this.mRP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mRS) {
                    b.this.mRS = false;
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    ap.setBackgroundResource(b.this.mRQ, R.drawable.corner_bg_radio_unselected);
                    b.this.mRQ.invalidate();
                    return;
                }
                b.this.mRS = true;
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                ap.setBackgroundResource(b.this.mRQ, R.drawable.corner_bg_radio_selected);
                b.this.mRQ.invalidate();
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
            } else if (Qd.getWidth() / Qd.getHeight() > l.getEquipmentWidth(this.mRD) / l.getDimens(this.mRD, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.mRD);
                if (Qd.getWidth() > 0) {
                    i2 = (int) ((i / Qd.getWidth()) * Qd.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.mRD, R.dimen.ds440);
                if (Qd.getWidth() > 0) {
                    i = (int) ((dimens / Qd.getHeight()) * Qd.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.myS.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.myS.setLayoutParams(layoutParams);
            this.myS.setImageBitmap(Qd);
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
        this.mRD.getLayoutMode().setNightMode(i == 1);
        this.mRD.getLayoutMode().onModeChanged(this.giY);
        this.mNavigationBar.onChangeSkinType(this.mRD.getPageContext(), i);
        SvgManager.bjq().a(this.mRK, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mRE, R.color.cp_link_tip_a, 1);
        ap.c(this.mRI, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.mRS = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.mRS) {
            ap.setBackgroundResource(this.mRQ, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.mRQ, R.drawable.corner_bg_radio_unselected);
        }
        if (this.mRI != null) {
            this.mRI.onChangeSkinType(i);
        }
        if (this.mRH != null) {
            this.mRH.onChangeSkinType(i);
        }
        if (this.mRT != null) {
            this.mRT.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.mRF.getText() == null) {
            return null;
        }
        return this.mRF.getText().toString();
    }

    public long dGR() {
        if (this.mRF.getText() == null || this.mRF.getText().toString() == null) {
            return 0L;
        }
        return this.mRF.getText().length();
    }

    public WriteLocationView dGS() {
        return this.mRI;
    }

    public View dGT() {
        return this.mRE;
    }

    public View getBackButton() {
        return this.mRK;
    }

    public EditText dGU() {
        return this.mRF;
    }

    public StateSwitchView dGV() {
        return this.mRH;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                SO(thumbPath);
                this.myS.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.myS.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.myS.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.myP.setVideoPath(videoPath);
                this.myP.start();
            }
        }
        if (!y.isEmpty(list)) {
            this.mRO.fA(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.mRF.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.mRO.fA(arrayList);
            this.mRF.setText("#" + videoTitleData.name + "#");
        }
    }

    public void dCx() {
        if (this.myP != null) {
            this.myP.resume();
            this.myP.seekTo(this.myZ);
            this.myP.start();
        }
    }

    public void coJ() {
        this.myZ = this.myP.getCurrentPosition();
        if (this.myP != null) {
            this.myP.stopPlayback();
        }
    }

    public void SP(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.mRD.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.mRD.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dGW() {
        this.mRL.bf(null);
        this.mRL.wX(false);
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.mRL.bf(postWriteCallBackData.getSensitiveWords());
            this.mRL.Sw(postWriteCallBackData.getErrorString());
            if (!y.isEmpty(this.mRL.dFu())) {
                xl(true);
            }
        }
    }

    public void xl(boolean z) {
        if (this.mRF.getText() != null) {
            int selectionEnd = this.mRF.getSelectionEnd();
            SpannableStringBuilder c = this.mRL.c(this.mRF.getText());
            if (c != null) {
                this.mRL.wY(true);
                this.mRF.setText(c);
                if (z && this.mRL.dFv() >= 0) {
                    this.mRF.requestFocus();
                    this.mRF.setSelection(this.mRL.dFv());
                } else {
                    this.mRF.setSelection(selectionEnd);
                }
                this.mRL.wX(this.mRL.dFv() >= 0);
            }
        }
    }

    public c dGX() {
        return this.mRL;
    }

    public void xm(boolean z) {
        if (z) {
            this.mRM.setVisibility(8);
            this.mRJ.setVisibility(0);
            this.ccd.smoothScrollTo(0, this.mRJ.getBottom());
        }
    }
}
