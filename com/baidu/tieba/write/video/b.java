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
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.c;
import com.baidu.tieba.write.editor.StateSwitchView;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    public static int lWN = 60;
    private ScrollView bQQ;
    private RelativeLayout fGx;
    private CustomVideoView lFV;
    private ImageView lFY;
    private int lGf;
    private StateSwitchView lTY;
    private WriteVideoActivity lWO;
    private TextView lWP;
    private EditText lWQ;
    private StateSwitchView lWR;
    private WriteLocationView lWS;
    private TextView lWT;
    private ImageView lWU;
    private c lWV;
    private LinearLayout lWW;
    private ListView lWX;
    private a lWY;
    private LinearLayout lWZ;
    private TextView lXa;
    private TextView lXb;
    private ForumTabSelectedView lXd;
    private NavigationBar mNavigationBar;
    private TextView mTitle;
    private boolean lXc = true;
    private boolean lWI = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.lWO = writeVideoActivity;
        this.lWO.setContentView(R.layout.write_video_activity);
        this.lWV = new c();
        this.lWV.Fv(R.color.cp_cont_a);
        this.lWV.Fw(R.color.cp_cont_h_alpha85);
        zb();
        initView();
    }

    public void vx(boolean z) {
        this.lWI = z;
        if (z) {
            if (this.lWR != null) {
                this.lWR.setVisibility(8);
            }
            if (this.lWS != null) {
                this.lWS.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.lWO.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void zb() {
        this.fGx = (RelativeLayout) this.lWO.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.lWO.findViewById(R.id.navigation_bar);
        this.lWQ = (EditText) this.lWO.findViewById(R.id.edit_content);
        this.lWT = (TextView) this.lWO.findViewById(R.id.text_content_size);
        this.lFY = (ImageView) this.lWO.findViewById(R.id.video_cover);
        this.lFV = (CustomVideoView) this.lWO.findViewById(R.id.preview_videoview);
        this.bQQ = (ScrollView) this.lWO.findViewById(R.id.write_scrollview);
        this.lFV.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.lFV.getWidth() != b.this.lFY.getWidth() || b.this.lFV.getHeight() != b.this.lFY.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.lFY.getLayoutParams();
                    layoutParams.width = b.this.lFV.getWidth();
                    layoutParams.height = b.this.lFV.getHeight();
                    b.this.lFY.setLayoutParams(layoutParams);
                }
                b.this.lFY.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lFV.start();
                        b.this.lFY.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.lFV.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.db(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.lWW = (LinearLayout) this.lWO.findViewById(R.id.video_activity_title_container);
        this.lWX = (ListView) this.lWO.findViewById(R.id.video_activity_title_list);
        this.lWX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.lWW.setVisibility(8);
                b.this.lWT.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.lWQ.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.lWQ.requestFocus();
                    if (!TextUtils.isEmpty(b.this.lWQ.getText())) {
                        b.this.lWQ.setSelection(b.this.lWQ.getText().length());
                    }
                    l.showSoftKeyPad(b.this.lWO, b.this.lWQ);
                }
            }
        });
        this.lWZ = (LinearLayout) this.lWO.findViewById(R.id.save_video_wrapper);
        this.lXa = (TextView) this.lWO.findViewById(R.id.save_video_ridiobutton);
        this.lXb = (TextView) this.lWO.findViewById(R.id.save_video_ridiotext);
        this.lWS = (WriteLocationView) this.lWO.findViewById(R.id.location);
        this.lWR = (StateSwitchView) this.lWO.findViewById(R.id.view_privacy);
        this.lWR.setStateString(this.lWO.getString(R.string.display_on_my_home_page), this.lWO.getString(R.string.display_on_my_home_page));
        this.lWR.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.lWR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.lWR.aJZ();
            }
        });
        this.lWR.setTextSize(0, this.lWO.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.lXd = (ForumTabSelectedView) this.lWO.findViewById(R.id.frs_tab_list);
        this.lXd.setData(frsTabInfoData);
        this.lXd.setActivity(this.lWO);
    }

    public ForumTabSelectedView dnR() {
        return this.lXd;
    }

    public boolean isToDynamic() {
        return this.lTY != null && this.lTY.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.lWO) / l.getDimens(this.lWO, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.lWO);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.lWO, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.lFV.setVideoHeight(i4);
        this.lFV.setVideoWidth(i3);
        this.lFV.invalidate();
    }

    private void initView() {
        this.lWU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.lWO);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.lWO.getPageContext().getString(R.string.post_video_title));
        if (this.lWI) {
            this.mTitle.setText(this.lWO.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.lWP = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.lWO);
        this.lWP.setText(R.string.send_post);
        this.lWQ.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.lWQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.lWY != null && b.this.lWY.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.lWO, b.this.lWQ);
                    b.this.lWW.setVisibility(0);
                    b.this.lWT.setVisibility(8);
                }
                long dnS = b.lWN - b.this.dnS();
                if (dnS >= 0) {
                    am.setViewTextColor(b.this.lWT, (int) R.color.cp_cont_e);
                    b.this.lWT.setText(String.valueOf(dnS));
                    return;
                }
                b.this.lWT.setText("0");
                b.this.lWQ.setText(b.this.lWQ.getText().toString().substring(0, b.lWN));
                b.this.lWQ.setSelection(b.this.lWQ.getText().length());
                b.this.lWO.showToast(b.this.lWO.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.lWV != null) {
                    if (!b.this.lWV.dmy()) {
                        b.this.vy(false);
                    }
                    b.this.lWV.vn(false);
                }
            }
        });
        this.lWY = new a();
        this.lWX.setAdapter((ListAdapter) this.lWY);
        this.lXc = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.lXc) {
            am.setBackgroundResource(this.lXa, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.lXa, R.drawable.corner_bg_radio_unselected);
        }
        am.setViewTextColor(this.lXb, (int) R.color.cp_cont_g);
        this.lWZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.lXc) {
                    b.this.lXc = false;
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    am.setBackgroundResource(b.this.lXa, R.drawable.corner_bg_radio_unselected);
                    b.this.lXa.invalidate();
                    return;
                }
                b.this.lXc = true;
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                am.setBackgroundResource(b.this.lXa, R.drawable.corner_bg_radio_selected);
                b.this.lXa.invalidate();
            }
        });
    }

    public void Ox(String str) {
        int i;
        int i2 = 0;
        Bitmap LV = LV(str);
        if (LV != null && LV.getHeight() != 0) {
            if (LV.getHeight() <= 0) {
                i = 0;
            } else if (LV.getWidth() / LV.getHeight() > l.getEquipmentWidth(this.lWO) / l.getDimens(this.lWO, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.lWO);
                if (LV.getWidth() > 0) {
                    i2 = (int) ((i / LV.getWidth()) * LV.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.lWO, R.dimen.ds440);
                if (LV.getWidth() > 0) {
                    i = (int) ((dimens / LV.getHeight()) * LV.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.lFY.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.lFY.setLayoutParams(layoutParams);
            this.lFY.setImageBitmap(LV);
        }
    }

    private Bitmap LV(String str) {
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
        this.lWO.getLayoutMode().setNightMode(i == 1);
        this.lWO.getLayoutMode().onModeChanged(this.fGx);
        this.mNavigationBar.onChangeSkinType(this.lWO.getPageContext(), i);
        SvgManager.aUW().a(this.lWU, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.lWP, R.color.cp_link_tip_a, 1);
        am.c(this.lWS, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.lXc = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.lXc) {
            am.setBackgroundResource(this.lXa, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.lXa, R.drawable.corner_bg_radio_unselected);
        }
        if (this.lWS != null) {
            this.lWS.onChangeSkinType(i);
        }
        if (this.lWR != null) {
            this.lWR.onChangeSkinType(i);
        }
        if (this.lXd != null) {
            this.lXd.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.lWQ.getText() == null) {
            return null;
        }
        return this.lWQ.getText().toString();
    }

    public long dnS() {
        if (this.lWQ.getText() == null || this.lWQ.getText().toString() == null) {
            return 0L;
        }
        return this.lWQ.getText().length();
    }

    public WriteLocationView dnT() {
        return this.lWS;
    }

    public View dnU() {
        return this.lWP;
    }

    public View getBackButton() {
        return this.lWU;
    }

    public EditText dnV() {
        return this.lWQ;
    }

    public StateSwitchView dnW() {
        return this.lWR;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                Ox(thumbPath);
                this.lFY.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lFY.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.lFY.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.lFV.setVideoPath(videoPath);
                this.lFV.start();
            }
        }
        if (!v.isEmpty(list)) {
            this.lWY.eW(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.lWQ.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.lWY.eW(arrayList);
            this.lWQ.setText("#" + videoTitleData.name + "#");
        }
    }

    public void djC() {
        if (this.lFV != null) {
            this.lFV.resume();
            this.lFV.seekTo(this.lGf);
            this.lFV.start();
        }
    }

    public void bXv() {
        this.lGf = this.lFV.getCurrentPosition();
        if (this.lFV != null) {
            this.lFV.stopPlayback();
        }
    }

    public void Oy(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.lWO.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.lWO.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dnX() {
        this.lWV.aX(null);
        this.lWV.vm(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lWV.aX(postWriteCallBackData.getSensitiveWords());
            this.lWV.Og(postWriteCallBackData.getErrorString());
            if (!v.isEmpty(this.lWV.dmv())) {
                vy(true);
            }
        }
    }

    public void vy(boolean z) {
        if (this.lWQ.getText() != null) {
            int selectionEnd = this.lWQ.getSelectionEnd();
            SpannableStringBuilder a = this.lWV.a(this.lWQ.getText());
            if (a != null) {
                this.lWV.vn(true);
                this.lWQ.setText(a);
                if (z && this.lWV.dmw() >= 0) {
                    this.lWQ.requestFocus();
                    this.lWQ.setSelection(this.lWV.dmw());
                } else {
                    this.lWQ.setSelection(selectionEnd);
                }
                this.lWV.vm(this.lWV.dmw() >= 0);
            }
        }
    }

    public c dnY() {
        return this.lWV;
    }

    public void vz(boolean z) {
        if (z) {
            this.lWW.setVisibility(8);
            this.lWT.setVisibility(0);
            this.bQQ.smoothScrollTo(0, this.lWT.getBottom());
        }
    }
}
