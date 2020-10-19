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
    public static int nrl = 60;
    private ScrollView cqA;
    private RelativeLayout gAC;
    private NavigationBar mNavigationBar;
    private TextView mTitle;
    private CustomVideoView mYE;
    private ImageView mYH;
    private int mYO;
    private TextView nrA;
    private ForumTabSelectedView nrC;
    private WriteVideoActivity nrm;
    private TextView nrn;
    private EditText nro;
    private StateSwitchView nrp;
    private StateSwitchView nrq;
    private WriteLocationView nrr;
    private TextView nrs;
    private ImageView nrt;
    private c nru;
    private LinearLayout nrv;
    private ListView nrw;
    private a nrx;
    private LinearLayout nry;
    private TextView nrz;
    private boolean nrB = true;
    private boolean nrg = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.nrm = writeVideoActivity;
        this.nrm.setContentView(R.layout.write_video_activity);
        this.nru = new c();
        this.nru.KB(R.color.cp_cont_a);
        this.nru.KC(R.color.cp_cont_h_alpha85);
        Hc();
        initView();
    }

    public void yc(boolean z) {
        this.nrg = z;
        if (z) {
            if (this.nrq != null) {
                this.nrq.setVisibility(8);
            }
            if (this.nrr != null) {
                this.nrr.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.nrm.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void Hc() {
        this.gAC = (RelativeLayout) this.nrm.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.nrm.findViewById(R.id.navigation_bar);
        this.nro = (EditText) this.nrm.findViewById(R.id.edit_content);
        this.nrs = (TextView) this.nrm.findViewById(R.id.text_content_size);
        this.mYH = (ImageView) this.nrm.findViewById(R.id.video_cover);
        this.mYE = (CustomVideoView) this.nrm.findViewById(R.id.preview_videoview);
        this.cqA = (ScrollView) this.nrm.findViewById(R.id.write_scrollview);
        this.mYE.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.mYE.getWidth() != b.this.mYH.getWidth() || b.this.mYE.getHeight() != b.this.mYH.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.mYH.getLayoutParams();
                    layoutParams.width = b.this.mYE.getWidth();
                    layoutParams.height = b.this.mYE.getHeight();
                    b.this.mYH.setLayoutParams(layoutParams);
                }
                b.this.mYH.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mYE.start();
                        b.this.mYH.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.mYE.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.dv(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.nrv = (LinearLayout) this.nrm.findViewById(R.id.video_activity_title_container);
        this.nrw = (ListView) this.nrm.findViewById(R.id.video_activity_title_list);
        this.nrw.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.nrv.setVisibility(8);
                b.this.nrs.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.nro.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.nro.requestFocus();
                    if (!TextUtils.isEmpty(b.this.nro.getText())) {
                        b.this.nro.setSelection(b.this.nro.getText().length());
                    }
                    l.showSoftKeyPad(b.this.nrm, b.this.nro);
                }
            }
        });
        this.nry = (LinearLayout) this.nrm.findViewById(R.id.save_video_wrapper);
        this.nrz = (TextView) this.nrm.findViewById(R.id.save_video_ridiobutton);
        this.nrA = (TextView) this.nrm.findViewById(R.id.save_video_ridiotext);
        this.nrr = (WriteLocationView) this.nrm.findViewById(R.id.location);
        this.nrq = (StateSwitchView) this.nrm.findViewById(R.id.view_privacy);
        this.nrq.setStateString(this.nrm.getString(R.string.display_on_my_home_page), this.nrm.getString(R.string.display_on_my_home_page));
        this.nrq.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.nrq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.nrq.baL();
            }
        });
        this.nrq.setTextSize(0, this.nrm.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void c(FrsTabInfoData frsTabInfoData) {
        this.nrC = (ForumTabSelectedView) this.nrm.findViewById(R.id.frs_tab_list);
        this.nrC.setData(frsTabInfoData);
        this.nrC.setActivity(this.nrm);
    }

    public ForumTabSelectedView dOF() {
        return this.nrC;
    }

    public boolean isToDynamic() {
        return this.nrp != null && this.nrp.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dv(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.nrm) / l.getDimens(this.nrm, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.nrm);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.nrm, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.mYE.setVideoHeight(i4);
        this.mYE.setVideoWidth(i3);
        this.mYE.invalidate();
    }

    private void initView() {
        this.nrt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.nrm);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.nrm.getPageContext().getString(R.string.post_video_title));
        if (this.nrg) {
            this.mTitle.setText(this.nrm.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.nrn = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.nrm);
        this.nrn.setText(R.string.send_post);
        this.nro.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.nro.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.nrx != null && b.this.nrx.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.nrm, b.this.nro);
                    b.this.nrv.setVisibility(0);
                    b.this.nrs.setVisibility(8);
                }
                long dOG = b.nrl - b.this.dOG();
                if (dOG >= 0) {
                    ap.setViewTextColor(b.this.nrs, R.color.cp_cont_e);
                    b.this.nrs.setText(String.valueOf(dOG));
                    return;
                }
                b.this.nrs.setText("0");
                b.this.nro.setText(b.this.nro.getText().toString().substring(0, b.nrl));
                b.this.nro.setSelection(b.this.nro.getText().length());
                b.this.nrm.showToast(b.this.nrm.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.nru != null) {
                    if (!b.this.nru.dNm()) {
                        b.this.yd(false);
                    }
                    b.this.nru.xQ(false);
                }
            }
        });
        this.nrx = new a();
        this.nrw.setAdapter((ListAdapter) this.nrx);
        this.nrB = com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.nrB) {
            ap.setBackgroundResource(this.nrz, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.nrz, R.drawable.corner_bg_radio_unselected);
        }
        ap.setViewTextColor(this.nrA, R.color.cp_cont_g);
        this.nry.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.nrB) {
                    b.this.nrB = false;
                    com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    ap.setBackgroundResource(b.this.nrz, R.drawable.corner_bg_radio_unselected);
                    b.this.nrz.invalidate();
                    return;
                }
                b.this.nrB = true;
                com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                ap.setBackgroundResource(b.this.nrz, R.drawable.corner_bg_radio_selected);
                b.this.nrz.invalidate();
            }
        });
    }

    public void Uc(String str) {
        int i;
        int i2 = 0;
        Bitmap Rr = Rr(str);
        if (Rr != null && Rr.getHeight() != 0) {
            if (Rr.getHeight() <= 0) {
                i = 0;
            } else if (Rr.getWidth() / Rr.getHeight() > l.getEquipmentWidth(this.nrm) / l.getDimens(this.nrm, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.nrm);
                if (Rr.getWidth() > 0) {
                    i2 = (int) ((i / Rr.getWidth()) * Rr.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.nrm, R.dimen.ds440);
                if (Rr.getWidth() > 0) {
                    i = (int) ((dimens / Rr.getHeight()) * Rr.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.mYH.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.mYH.setLayoutParams(layoutParams);
            this.mYH.setImageBitmap(Rr);
        }
    }

    private Bitmap Rr(String str) {
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
        this.nrm.getLayoutMode().setNightMode(i == 1);
        this.nrm.getLayoutMode().onModeChanged(this.gAC);
        this.mNavigationBar.onChangeSkinType(this.nrm.getPageContext(), i);
        SvgManager.bmU().a(this.nrt, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.nrn, R.color.cp_link_tip_a, 1);
        ap.c(this.nrr, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.nrB = com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.nrB) {
            ap.setBackgroundResource(this.nrz, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.nrz, R.drawable.corner_bg_radio_unselected);
        }
        if (this.nrr != null) {
            this.nrr.onChangeSkinType(i);
        }
        if (this.nrq != null) {
            this.nrq.onChangeSkinType(i);
        }
        if (this.nrC != null) {
            this.nrC.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.nro.getText() == null) {
            return null;
        }
        return this.nro.getText().toString();
    }

    public long dOG() {
        if (this.nro.getText() == null || this.nro.getText().toString() == null) {
            return 0L;
        }
        return this.nro.getText().length();
    }

    public WriteLocationView dOH() {
        return this.nrr;
    }

    public View dOI() {
        return this.nrn;
    }

    public View getBackButton() {
        return this.nrt;
    }

    public EditText dOJ() {
        return this.nro;
    }

    public StateSwitchView dOK() {
        return this.nrq;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                Uc(thumbPath);
                this.mYH.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mYH.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.mYH.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.mYE.setVideoPath(videoPath);
                this.mYE.start();
            }
        }
        if (!y.isEmpty(list)) {
            this.nrx.fM(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.nro.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.nrx.fM(arrayList);
            this.nro.setText("#" + videoTitleData.name + "#");
        }
    }

    public void dKm() {
        if (this.mYE != null) {
            this.mYE.resume();
            this.mYE.seekTo(this.mYO);
            this.mYE.start();
        }
    }

    public void cvu() {
        this.mYO = this.mYE.getCurrentPosition();
        if (this.mYE != null) {
            this.mYE.stopPlayback();
        }
    }

    public void Ud(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.nrm.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.nrm.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dOL() {
        this.nru.bh(null);
        this.nru.xP(false);
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.nru.bh(postWriteCallBackData.getSensitiveWords());
            this.nru.TK(postWriteCallBackData.getErrorString());
            if (!y.isEmpty(this.nru.dNj())) {
                yd(true);
            }
        }
    }

    public void yd(boolean z) {
        if (this.nro.getText() != null) {
            int selectionEnd = this.nro.getSelectionEnd();
            SpannableStringBuilder c = this.nru.c(this.nro.getText());
            if (c != null) {
                this.nru.xQ(true);
                this.nro.setText(c);
                if (z && this.nru.dNk() >= 0) {
                    this.nro.requestFocus();
                    this.nro.setSelection(this.nru.dNk());
                } else {
                    this.nro.setSelection(selectionEnd);
                }
                this.nru.xP(this.nru.dNk() >= 0);
            }
        }
    }

    public c dOM() {
        return this.nru;
    }

    public void ye(boolean z) {
        if (z) {
            this.nrv.setVisibility(8);
            this.nrs.setVisibility(0);
            this.cqA.smoothScrollTo(0, this.nrs.getBottom());
        }
    }
}
