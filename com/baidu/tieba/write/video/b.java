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
    public static int lVC = 60;
    private ScrollView bQQ;
    private RelativeLayout fGm;
    private CustomVideoView lEM;
    private ImageView lEP;
    private int lEW;
    private StateSwitchView lSN;
    private WriteVideoActivity lVD;
    private TextView lVE;
    private EditText lVF;
    private StateSwitchView lVG;
    private WriteLocationView lVH;
    private TextView lVI;
    private ImageView lVJ;
    private c lVK;
    private LinearLayout lVL;
    private ListView lVM;
    private a lVN;
    private LinearLayout lVO;
    private TextView lVP;
    private TextView lVQ;
    private ForumTabSelectedView lVS;
    private NavigationBar mNavigationBar;
    private TextView mTitle;
    private boolean lVR = true;
    private boolean lVx = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.lVD = writeVideoActivity;
        this.lVD.setContentView(R.layout.write_video_activity);
        this.lVK = new c();
        this.lVK.Ft(R.color.cp_cont_a);
        this.lVK.Fu(R.color.cp_cont_h_alpha85);
        zb();
        initView();
    }

    public void vv(boolean z) {
        this.lVx = z;
        if (z) {
            if (this.lVG != null) {
                this.lVG.setVisibility(8);
            }
            if (this.lVH != null) {
                this.lVH.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.lVD.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void zb() {
        this.fGm = (RelativeLayout) this.lVD.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.lVD.findViewById(R.id.navigation_bar);
        this.lVF = (EditText) this.lVD.findViewById(R.id.edit_content);
        this.lVI = (TextView) this.lVD.findViewById(R.id.text_content_size);
        this.lEP = (ImageView) this.lVD.findViewById(R.id.video_cover);
        this.lEM = (CustomVideoView) this.lVD.findViewById(R.id.preview_videoview);
        this.bQQ = (ScrollView) this.lVD.findViewById(R.id.write_scrollview);
        this.lEM.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.lEM.getWidth() != b.this.lEP.getWidth() || b.this.lEM.getHeight() != b.this.lEP.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.lEP.getLayoutParams();
                    layoutParams.width = b.this.lEM.getWidth();
                    layoutParams.height = b.this.lEM.getHeight();
                    b.this.lEP.setLayoutParams(layoutParams);
                }
                b.this.lEP.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lEM.start();
                        b.this.lEP.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.lEM.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.db(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.lVL = (LinearLayout) this.lVD.findViewById(R.id.video_activity_title_container);
        this.lVM = (ListView) this.lVD.findViewById(R.id.video_activity_title_list);
        this.lVM.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.lVL.setVisibility(8);
                b.this.lVI.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.lVF.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.lVF.requestFocus();
                    if (!TextUtils.isEmpty(b.this.lVF.getText())) {
                        b.this.lVF.setSelection(b.this.lVF.getText().length());
                    }
                    l.showSoftKeyPad(b.this.lVD, b.this.lVF);
                }
            }
        });
        this.lVO = (LinearLayout) this.lVD.findViewById(R.id.save_video_wrapper);
        this.lVP = (TextView) this.lVD.findViewById(R.id.save_video_ridiobutton);
        this.lVQ = (TextView) this.lVD.findViewById(R.id.save_video_ridiotext);
        this.lVH = (WriteLocationView) this.lVD.findViewById(R.id.location);
        this.lVG = (StateSwitchView) this.lVD.findViewById(R.id.view_privacy);
        this.lVG.setStateString(this.lVD.getString(R.string.display_on_my_home_page), this.lVD.getString(R.string.display_on_my_home_page));
        this.lVG.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.lVG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.lVG.aJZ();
            }
        });
        this.lVG.setTextSize(0, this.lVD.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.lVS = (ForumTabSelectedView) this.lVD.findViewById(R.id.frs_tab_list);
        this.lVS.setData(frsTabInfoData);
        this.lVS.setActivity(this.lVD);
    }

    public ForumTabSelectedView dnC() {
        return this.lVS;
    }

    public boolean isToDynamic() {
        return this.lSN != null && this.lSN.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.lVD) / l.getDimens(this.lVD, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.lVD);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.lVD, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.lEM.setVideoHeight(i4);
        this.lEM.setVideoWidth(i3);
        this.lEM.invalidate();
    }

    private void initView() {
        this.lVJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.lVD);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.lVD.getPageContext().getString(R.string.post_video_title));
        if (this.lVx) {
            this.mTitle.setText(this.lVD.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.lVE = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.lVD);
        this.lVE.setText(R.string.send_post);
        this.lVF.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.lVF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.lVN != null && b.this.lVN.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.lVD, b.this.lVF);
                    b.this.lVL.setVisibility(0);
                    b.this.lVI.setVisibility(8);
                }
                long dnD = b.lVC - b.this.dnD();
                if (dnD >= 0) {
                    am.setViewTextColor(b.this.lVI, (int) R.color.cp_cont_e);
                    b.this.lVI.setText(String.valueOf(dnD));
                    return;
                }
                b.this.lVI.setText("0");
                b.this.lVF.setText(b.this.lVF.getText().toString().substring(0, b.lVC));
                b.this.lVF.setSelection(b.this.lVF.getText().length());
                b.this.lVD.showToast(b.this.lVD.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.lVK != null) {
                    if (!b.this.lVK.dmj()) {
                        b.this.vw(false);
                    }
                    b.this.lVK.vm(false);
                }
            }
        });
        this.lVN = new a();
        this.lVM.setAdapter((ListAdapter) this.lVN);
        this.lVR = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.lVR) {
            am.setBackgroundResource(this.lVP, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.lVP, R.drawable.corner_bg_radio_unselected);
        }
        am.setViewTextColor(this.lVQ, (int) R.color.cp_cont_g);
        this.lVO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.lVR) {
                    b.this.lVR = false;
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    am.setBackgroundResource(b.this.lVP, R.drawable.corner_bg_radio_unselected);
                    b.this.lVP.invalidate();
                    return;
                }
                b.this.lVR = true;
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                am.setBackgroundResource(b.this.lVP, R.drawable.corner_bg_radio_selected);
                b.this.lVP.invalidate();
            }
        });
    }

    public void Ow(String str) {
        int i;
        int i2 = 0;
        Bitmap LU = LU(str);
        if (LU != null && LU.getHeight() != 0) {
            if (LU.getHeight() <= 0) {
                i = 0;
            } else if (LU.getWidth() / LU.getHeight() > l.getEquipmentWidth(this.lVD) / l.getDimens(this.lVD, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.lVD);
                if (LU.getWidth() > 0) {
                    i2 = (int) ((i / LU.getWidth()) * LU.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.lVD, R.dimen.ds440);
                if (LU.getWidth() > 0) {
                    i = (int) ((dimens / LU.getHeight()) * LU.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.lEP.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.lEP.setLayoutParams(layoutParams);
            this.lEP.setImageBitmap(LU);
        }
    }

    private Bitmap LU(String str) {
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
        this.lVD.getLayoutMode().setNightMode(i == 1);
        this.lVD.getLayoutMode().onModeChanged(this.fGm);
        this.mNavigationBar.onChangeSkinType(this.lVD.getPageContext(), i);
        SvgManager.aUV().a(this.lVJ, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.lVE, R.color.cp_link_tip_a, 1);
        am.c(this.lVH, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.lVR = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.lVR) {
            am.setBackgroundResource(this.lVP, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.lVP, R.drawable.corner_bg_radio_unselected);
        }
        if (this.lVH != null) {
            this.lVH.onChangeSkinType(i);
        }
        if (this.lVG != null) {
            this.lVG.onChangeSkinType(i);
        }
        if (this.lVS != null) {
            this.lVS.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.lVF.getText() == null) {
            return null;
        }
        return this.lVF.getText().toString();
    }

    public long dnD() {
        if (this.lVF.getText() == null || this.lVF.getText().toString() == null) {
            return 0L;
        }
        return this.lVF.getText().length();
    }

    public WriteLocationView dnE() {
        return this.lVH;
    }

    public View dnF() {
        return this.lVE;
    }

    public View getBackButton() {
        return this.lVJ;
    }

    public EditText dnG() {
        return this.lVF;
    }

    public StateSwitchView dnH() {
        return this.lVG;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                Ow(thumbPath);
                this.lEP.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lEP.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.lEP.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.lEM.setVideoPath(videoPath);
                this.lEM.start();
            }
        }
        if (!v.isEmpty(list)) {
            this.lVN.eU(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.lVF.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.lVN.eU(arrayList);
            this.lVF.setText("#" + videoTitleData.name + "#");
        }
    }

    public void djn() {
        if (this.lEM != null) {
            this.lEM.resume();
            this.lEM.seekTo(this.lEW);
            this.lEM.start();
        }
    }

    public void bXt() {
        this.lEW = this.lEM.getCurrentPosition();
        if (this.lEM != null) {
            this.lEM.stopPlayback();
        }
    }

    public void Ox(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.lVD.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.lVD.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dnI() {
        this.lVK.aX(null);
        this.lVK.vl(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lVK.aX(postWriteCallBackData.getSensitiveWords());
            this.lVK.Of(postWriteCallBackData.getErrorString());
            if (!v.isEmpty(this.lVK.dmg())) {
                vw(true);
            }
        }
    }

    public void vw(boolean z) {
        if (this.lVF.getText() != null) {
            int selectionEnd = this.lVF.getSelectionEnd();
            SpannableStringBuilder a = this.lVK.a(this.lVF.getText());
            if (a != null) {
                this.lVK.vm(true);
                this.lVF.setText(a);
                if (z && this.lVK.dmh() >= 0) {
                    this.lVF.requestFocus();
                    this.lVF.setSelection(this.lVK.dmh());
                } else {
                    this.lVF.setSelection(selectionEnd);
                }
                this.lVK.vl(this.lVK.dmh() >= 0);
            }
        }
    }

    public c dnJ() {
        return this.lVK;
    }

    public void vx(boolean z) {
        if (z) {
            this.lVL.setVisibility(8);
            this.lVI.setVisibility(0);
            this.bQQ.smoothScrollTo(0, this.lVI.getBottom());
        }
    }
}
