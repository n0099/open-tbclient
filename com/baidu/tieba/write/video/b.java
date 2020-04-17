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
    public static int lCk = 60;
    private ScrollView bHT;
    private RelativeLayout fsp;
    private ForumTabSelectedView lCA;
    private WriteVideoActivity lCl;
    private TextView lCm;
    private EditText lCn;
    private StateSwitchView lCo;
    private WriteLocationView lCp;
    private TextView lCq;
    private ImageView lCr;
    private c lCs;
    private LinearLayout lCt;
    private ListView lCu;
    private a lCv;
    private LinearLayout lCw;
    private TextView lCx;
    private TextView lCy;
    private CustomVideoView llY;
    private ImageView lmb;
    private int lmi;
    private StateSwitchView lzu;
    private NavigationBar mNavigationBar;
    private TextView mTitle;
    private boolean lCz = true;
    private boolean lCf = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.lCl = writeVideoActivity;
        this.lCl.setContentView(R.layout.write_video_activity);
        this.lCs = new c();
        this.lCs.EI(R.color.cp_cont_a);
        this.lCs.EJ(R.color.cp_cont_h_alpha85);
        xO();
        initView();
    }

    public void uX(boolean z) {
        this.lCf = z;
        if (z) {
            if (this.lCo != null) {
                this.lCo.setVisibility(8);
            }
            if (this.lCp != null) {
                this.lCp.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.lCl.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void xO() {
        this.fsp = (RelativeLayout) this.lCl.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.lCl.findViewById(R.id.navigation_bar);
        this.lCn = (EditText) this.lCl.findViewById(R.id.edit_content);
        this.lCq = (TextView) this.lCl.findViewById(R.id.text_content_size);
        this.lmb = (ImageView) this.lCl.findViewById(R.id.video_cover);
        this.llY = (CustomVideoView) this.lCl.findViewById(R.id.preview_videoview);
        this.bHT = (ScrollView) this.lCl.findViewById(R.id.write_scrollview);
        this.llY.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.llY.getWidth() != b.this.lmb.getWidth() || b.this.llY.getHeight() != b.this.lmb.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.lmb.getLayoutParams();
                    layoutParams.width = b.this.llY.getWidth();
                    layoutParams.height = b.this.llY.getHeight();
                    b.this.lmb.setLayoutParams(layoutParams);
                }
                b.this.lmb.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.llY.start();
                        b.this.lmb.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.llY.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cW(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.lCt = (LinearLayout) this.lCl.findViewById(R.id.video_activity_title_container);
        this.lCu = (ListView) this.lCl.findViewById(R.id.video_activity_title_list);
        this.lCu.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.lCt.setVisibility(8);
                b.this.lCq.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.lCn.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.lCn.requestFocus();
                    if (!TextUtils.isEmpty(b.this.lCn.getText())) {
                        b.this.lCn.setSelection(b.this.lCn.getText().length());
                    }
                    l.showSoftKeyPad(b.this.lCl, b.this.lCn);
                }
            }
        });
        this.lCw = (LinearLayout) this.lCl.findViewById(R.id.save_video_wrapper);
        this.lCx = (TextView) this.lCl.findViewById(R.id.save_video_ridiobutton);
        this.lCy = (TextView) this.lCl.findViewById(R.id.save_video_ridiotext);
        this.lCp = (WriteLocationView) this.lCl.findViewById(R.id.location);
        this.lCo = (StateSwitchView) this.lCl.findViewById(R.id.view_privacy);
        this.lCo.setStateString(this.lCl.getString(R.string.display_on_my_home_page), this.lCl.getString(R.string.display_on_my_home_page));
        this.lCo.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.lCo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.lCo.biK();
            }
        });
        this.lCo.setTextSize(0, this.lCl.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.lCA = (ForumTabSelectedView) this.lCl.findViewById(R.id.frs_tab_list);
        this.lCA.setData(frsTabInfoData);
        this.lCA.setActivity(this.lCl);
    }

    public ForumTabSelectedView dgn() {
        return this.lCA;
    }

    public boolean isToDynamic() {
        return this.lzu != null && this.lzu.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.lCl) / l.getDimens(this.lCl, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.lCl);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.lCl, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.llY.setVideoHeight(i4);
        this.llY.setVideoWidth(i3);
        this.llY.invalidate();
    }

    private void initView() {
        this.lCr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.lCl);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.lCl.getPageContext().getString(R.string.post_video_title));
        if (this.lCf) {
            this.mTitle.setText(this.lCl.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.lCm = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.lCl);
        this.lCm.setText(R.string.send_post);
        this.lCn.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.lCn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.lCv != null && b.this.lCv.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.lCl, b.this.lCn);
                    b.this.lCt.setVisibility(0);
                    b.this.lCq.setVisibility(8);
                }
                long dgo = b.lCk - b.this.dgo();
                if (dgo >= 0) {
                    am.setViewTextColor(b.this.lCq, (int) R.color.cp_cont_e);
                    b.this.lCq.setText(String.valueOf(dgo));
                    return;
                }
                b.this.lCq.setText("0");
                b.this.lCn.setText(b.this.lCn.getText().toString().substring(0, b.lCk));
                b.this.lCn.setSelection(b.this.lCn.getText().length());
                b.this.lCl.showToast(b.this.lCl.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.lCs != null) {
                    if (!b.this.lCs.deV()) {
                        b.this.uY(false);
                    }
                    b.this.lCs.uO(false);
                }
            }
        });
        this.lCv = new a();
        this.lCu.setAdapter((ListAdapter) this.lCv);
        this.lCz = com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.lCz) {
            am.setBackgroundResource(this.lCx, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.lCx, R.drawable.corner_bg_radio_unselected);
        }
        am.setViewTextColor(this.lCy, (int) R.color.cp_cont_g);
        this.lCw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.lCz) {
                    b.this.lCz = false;
                    com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    am.setBackgroundResource(b.this.lCx, R.drawable.corner_bg_radio_unselected);
                    b.this.lCx.invalidate();
                    return;
                }
                b.this.lCz = true;
                com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                am.setBackgroundResource(b.this.lCx, R.drawable.corner_bg_radio_selected);
                b.this.lCx.invalidate();
            }
        });
    }

    public void MG(String str) {
        int i;
        int i2 = 0;
        Bitmap Kf = Kf(str);
        if (Kf != null && Kf.getHeight() != 0) {
            if (Kf.getHeight() <= 0) {
                i = 0;
            } else if (Kf.getWidth() / Kf.getHeight() > l.getEquipmentWidth(this.lCl) / l.getDimens(this.lCl, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.lCl);
                if (Kf.getWidth() > 0) {
                    i2 = (int) ((i / Kf.getWidth()) * Kf.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.lCl, R.dimen.ds440);
                if (Kf.getWidth() > 0) {
                    i = (int) ((dimens / Kf.getHeight()) * Kf.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.lmb.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.lmb.setLayoutParams(layoutParams);
            this.lmb.setImageBitmap(Kf);
        }
    }

    private Bitmap Kf(String str) {
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
        this.lCl.getLayoutMode().setNightMode(i == 1);
        this.lCl.getLayoutMode().onModeChanged(this.fsp);
        this.mNavigationBar.onChangeSkinType(this.lCl.getPageContext(), i);
        SvgManager.aOU().a(this.lCr, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.lCm, R.color.cp_link_tip_a, 1);
        am.c(this.lCp, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.lCz = com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.lCz) {
            am.setBackgroundResource(this.lCx, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.lCx, R.drawable.corner_bg_radio_unselected);
        }
        if (this.lCp != null) {
            this.lCp.onChangeSkinType(i);
        }
        if (this.lCo != null) {
            this.lCo.onChangeSkinType(i);
        }
        if (this.lCA != null) {
            this.lCA.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.lCn.getText() == null) {
            return null;
        }
        return this.lCn.getText().toString();
    }

    public long dgo() {
        if (this.lCn.getText() == null || this.lCn.getText().toString() == null) {
            return 0L;
        }
        return this.lCn.getText().length();
    }

    public WriteLocationView dgp() {
        return this.lCp;
    }

    public View dgq() {
        return this.lCm;
    }

    public View getBackButton() {
        return this.lCr;
    }

    public EditText dgr() {
        return this.lCn;
    }

    public StateSwitchView dgs() {
        return this.lCo;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                MG(thumbPath);
                this.lmb.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lmb.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.lmb.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.llY.setVideoPath(videoPath);
                this.llY.start();
            }
        }
        if (!v.isEmpty(list)) {
            this.lCv.eN(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.lCn.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.lCv.eN(arrayList);
            this.lCn.setText("#" + videoTitleData.name + "#");
        }
    }

    public void dcb() {
        if (this.llY != null) {
            this.llY.resume();
            this.llY.seekTo(this.lmi);
            this.llY.start();
        }
    }

    public void bQY() {
        this.lmi = this.llY.getCurrentPosition();
        if (this.llY != null) {
            this.llY.stopPlayback();
        }
    }

    public void MH(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.lCl.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.lCl.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dgt() {
        this.lCs.aW(null);
        this.lCs.uN(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lCs.aW(postWriteCallBackData.getSensitiveWords());
            this.lCs.Mp(postWriteCallBackData.getErrorString());
            if (!v.isEmpty(this.lCs.deS())) {
                uY(true);
            }
        }
    }

    public void uY(boolean z) {
        if (this.lCn.getText() != null) {
            int selectionEnd = this.lCn.getSelectionEnd();
            SpannableStringBuilder a = this.lCs.a(this.lCn.getText());
            if (a != null) {
                this.lCs.uO(true);
                this.lCn.setText(a);
                if (z && this.lCs.deT() >= 0) {
                    this.lCn.requestFocus();
                    this.lCn.setSelection(this.lCs.deT());
                } else {
                    this.lCn.setSelection(selectionEnd);
                }
                this.lCs.uN(this.lCs.deT() >= 0);
            }
        }
    }

    public c dgu() {
        return this.lCs;
    }

    public void uZ(boolean z) {
        if (z) {
            this.lCt.setVisibility(8);
            this.lCq.setVisibility(0);
            this.bHT.smoothScrollTo(0, this.lCq.getBottom());
        }
    }
}
