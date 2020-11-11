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
    public static int nJE = 60;
    private ScrollView cEU;
    private RelativeLayout gSP;
    private NavigationBar mNavigationBar;
    private TextView mTitle;
    private WriteVideoActivity nJF;
    private TextView nJG;
    private EditText nJH;
    private StateSwitchView nJI;
    private StateSwitchView nJJ;
    private WriteLocationView nJK;
    private TextView nJL;
    private ImageView nJM;
    private c nJN;
    private LinearLayout nJO;
    private ListView nJP;
    private a nJQ;
    private LinearLayout nJR;
    private TextView nJS;
    private TextView nJT;
    private ForumTabSelectedView nJV;
    private CustomVideoView nrb;
    private ImageView nre;
    private int nrl;
    private boolean nJU = true;
    private boolean nJz = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.nJF = writeVideoActivity;
        this.nJF.setContentView(R.layout.write_video_activity);
        this.nJN = new c();
        this.nJN.Lg(R.color.cp_cont_a);
        this.nJN.Lh(R.color.cp_cont_h_alpha85);
        HZ();
        initView();
    }

    public void yC(boolean z) {
        this.nJz = z;
        if (z) {
            if (this.nJJ != null) {
                this.nJJ.setVisibility(8);
            }
            if (this.nJK != null) {
                this.nJK.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.nJF.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void HZ() {
        this.gSP = (RelativeLayout) this.nJF.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.nJF.findViewById(R.id.navigation_bar);
        this.nJH = (EditText) this.nJF.findViewById(R.id.edit_content);
        this.nJL = (TextView) this.nJF.findViewById(R.id.text_content_size);
        this.nre = (ImageView) this.nJF.findViewById(R.id.video_cover);
        this.nrb = (CustomVideoView) this.nJF.findViewById(R.id.preview_videoview);
        this.cEU = (ScrollView) this.nJF.findViewById(R.id.write_scrollview);
        this.nrb.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.nrb.getWidth() != b.this.nre.getWidth() || b.this.nrb.getHeight() != b.this.nre.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.nre.getLayoutParams();
                    layoutParams.width = b.this.nrb.getWidth();
                    layoutParams.height = b.this.nrb.getHeight();
                    b.this.nre.setLayoutParams(layoutParams);
                }
                b.this.nre.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nrb.start();
                        b.this.nre.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.nrb.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.dz(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.nJO = (LinearLayout) this.nJF.findViewById(R.id.video_activity_title_container);
        this.nJP = (ListView) this.nJF.findViewById(R.id.video_activity_title_list);
        this.nJP.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.nJO.setVisibility(8);
                b.this.nJL.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.nJH.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.nJH.requestFocus();
                    if (!TextUtils.isEmpty(b.this.nJH.getText())) {
                        b.this.nJH.setSelection(b.this.nJH.getText().length());
                    }
                    l.showSoftKeyPad(b.this.nJF, b.this.nJH);
                }
            }
        });
        this.nJR = (LinearLayout) this.nJF.findViewById(R.id.save_video_wrapper);
        this.nJS = (TextView) this.nJF.findViewById(R.id.save_video_ridiobutton);
        this.nJT = (TextView) this.nJF.findViewById(R.id.save_video_ridiotext);
        this.nJK = (WriteLocationView) this.nJF.findViewById(R.id.location);
        this.nJJ = (StateSwitchView) this.nJF.findViewById(R.id.view_privacy);
        this.nJJ.setStateString(this.nJF.getString(R.string.display_on_my_home_page), this.nJF.getString(R.string.display_on_my_home_page));
        this.nJJ.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.nJJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.nJJ.bfe();
            }
        });
        this.nJJ.setTextSize(0, this.nJF.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void c(FrsTabInfoData frsTabInfoData) {
        this.nJV = (ForumTabSelectedView) this.nJF.findViewById(R.id.frs_tab_list);
        this.nJV.setData(frsTabInfoData);
        this.nJV.setActivity(this.nJF);
    }

    public ForumTabSelectedView dUn() {
        return this.nJV;
    }

    public boolean isToDynamic() {
        return this.nJI != null && this.nJI.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dz(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.nJF) / l.getDimens(this.nJF, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.nJF);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.nJF, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.nrb.setVideoHeight(i4);
        this.nrb.setVideoWidth(i3);
        this.nrb.invalidate();
    }

    private void initView() {
        this.nJM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.nJF);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.nJF.getPageContext().getString(R.string.post_video_title));
        if (this.nJz) {
            this.mTitle.setText(this.nJF.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.nJG = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.nJF);
        this.nJG.setText(R.string.send_post);
        this.nJH.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.nJH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.nJQ != null && b.this.nJQ.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.nJF, b.this.nJH);
                    b.this.nJO.setVisibility(0);
                    b.this.nJL.setVisibility(8);
                }
                long dUo = b.nJE - b.this.dUo();
                if (dUo >= 0) {
                    ap.setViewTextColor(b.this.nJL, R.color.cp_cont_e);
                    b.this.nJL.setText(String.valueOf(dUo));
                    return;
                }
                b.this.nJL.setText("0");
                b.this.nJH.setText(b.this.nJH.getText().toString().substring(0, b.nJE));
                b.this.nJH.setSelection(b.this.nJH.getText().length());
                b.this.nJF.showToast(b.this.nJF.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.nJN != null) {
                    if (!b.this.nJN.dSW()) {
                        b.this.yD(false);
                    }
                    b.this.nJN.yq(false);
                }
            }
        });
        this.nJQ = new a();
        this.nJP.setAdapter((ListAdapter) this.nJQ);
        this.nJU = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.nJU) {
            ap.setBackgroundResource(this.nJS, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.nJS, R.drawable.corner_bg_radio_unselected);
        }
        ap.setViewTextColor(this.nJT, R.color.cp_cont_g);
        this.nJR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.nJU) {
                    b.this.nJU = false;
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    ap.setBackgroundResource(b.this.nJS, R.drawable.corner_bg_radio_unselected);
                    b.this.nJS.invalidate();
                    return;
                }
                b.this.nJU = true;
                com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                ap.setBackgroundResource(b.this.nJS, R.drawable.corner_bg_radio_selected);
                b.this.nJS.invalidate();
            }
        });
    }

    public void US(String str) {
        int i;
        int i2 = 0;
        Bitmap Sh = Sh(str);
        if (Sh != null && Sh.getHeight() != 0) {
            if (Sh.getHeight() <= 0) {
                i = 0;
            } else if (Sh.getWidth() / Sh.getHeight() > l.getEquipmentWidth(this.nJF) / l.getDimens(this.nJF, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.nJF);
                if (Sh.getWidth() > 0) {
                    i2 = (int) ((i / Sh.getWidth()) * Sh.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.nJF, R.dimen.ds440);
                if (Sh.getWidth() > 0) {
                    i = (int) ((dimens / Sh.getHeight()) * Sh.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.nre.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.nre.setLayoutParams(layoutParams);
            this.nre.setImageBitmap(Sh);
        }
    }

    private Bitmap Sh(String str) {
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
        this.nJF.getLayoutMode().setNightMode(i == 1);
        this.nJF.getLayoutMode().onModeChanged(this.gSP);
        this.mNavigationBar.onChangeSkinType(this.nJF.getPageContext(), i);
        SvgManager.brn().a(this.nJM, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.nJG, R.color.cp_link_tip_a, 1);
        ap.c(this.nJK, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.nJU = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.nJU) {
            ap.setBackgroundResource(this.nJS, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.nJS, R.drawable.corner_bg_radio_unselected);
        }
        if (this.nJK != null) {
            this.nJK.onChangeSkinType(i);
        }
        if (this.nJJ != null) {
            this.nJJ.onChangeSkinType(i);
        }
        if (this.nJV != null) {
            this.nJV.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.nJH.getText() == null) {
            return null;
        }
        return this.nJH.getText().toString();
    }

    public long dUo() {
        if (this.nJH.getText() == null || this.nJH.getText().toString() == null) {
            return 0L;
        }
        return this.nJH.getText().length();
    }

    public WriteLocationView dUp() {
        return this.nJK;
    }

    public View dUq() {
        return this.nJG;
    }

    public View getBackButton() {
        return this.nJM;
    }

    public EditText dUr() {
        return this.nJH;
    }

    public StateSwitchView dUs() {
        return this.nJJ;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                US(thumbPath);
                this.nre.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nre.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.nre.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.nrb.setVideoPath(videoPath);
                this.nrb.start();
            }
        }
        if (!y.isEmpty(list)) {
            this.nJQ.gc(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.nJH.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.nJQ.gc(arrayList);
            this.nJH.setText("#" + videoTitleData.name + "#");
        }
    }

    public void dPW() {
        if (this.nrb != null) {
            this.nrb.resume();
            this.nrb.seekTo(this.nrl);
            this.nrb.start();
        }
    }

    public void cBc() {
        this.nrl = this.nrb.getCurrentPosition();
        if (this.nrb != null) {
            this.nrb.stopPlayback();
        }
    }

    public void UT(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.nJF.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.nJF.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dUt() {
        this.nJN.bk(null);
        this.nJN.yp(false);
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.nJN.bk(postWriteCallBackData.getSensitiveWords());
            this.nJN.UA(postWriteCallBackData.getErrorString());
            if (!y.isEmpty(this.nJN.dST())) {
                yD(true);
            }
        }
    }

    public void yD(boolean z) {
        if (this.nJH.getText() != null) {
            int selectionEnd = this.nJH.getSelectionEnd();
            SpannableStringBuilder c = this.nJN.c(this.nJH.getText());
            if (c != null) {
                this.nJN.yq(true);
                this.nJH.setText(c);
                if (z && this.nJN.dSU() >= 0) {
                    this.nJH.requestFocus();
                    this.nJH.setSelection(this.nJN.dSU());
                } else {
                    this.nJH.setSelection(selectionEnd);
                }
                this.nJN.yp(this.nJN.dSU() >= 0);
            }
        }
    }

    public c dUu() {
        return this.nJN;
    }

    public void yE(boolean z) {
        if (z) {
            this.nJO.setVisibility(8);
            this.nJL.setVisibility(0);
            this.cEU.smoothScrollTo(0, this.nJL.getBottom());
        }
    }
}
