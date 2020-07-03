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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
    public static int mrh = 60;
    private ScrollView bVE;
    private RelativeLayout fRG;
    private CustomVideoView lZJ;
    private ImageView lZM;
    private int lZT;
    private NavigationBar mNavigationBar;
    private TextView mTitle;
    private WriteVideoActivity mri;
    private TextView mrj;
    private EditText mrk;
    private StateSwitchView mrl;
    private StateSwitchView mrm;
    private WriteLocationView mrn;
    private TextView mro;
    private ImageView mrp;
    private c mrq;
    private LinearLayout mrr;
    private ListView mrs;
    private a mrt;
    private LinearLayout mru;
    private TextView mrv;
    private TextView mrw;
    private ForumTabSelectedView mry;
    private boolean mrx = true;
    private boolean mrc = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.mri = writeVideoActivity;
        this.mri.setContentView(R.layout.write_video_activity);
        this.mrq = new c();
        this.mrq.Gz(R.color.cp_cont_a);
        this.mrq.GA(R.color.cp_cont_h_alpha85);
        zB();
        initView();
    }

    public void vQ(boolean z) {
        this.mrc = z;
        if (z) {
            if (this.mrm != null) {
                this.mrm.setVisibility(8);
            }
            if (this.mrn != null) {
                this.mrn.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.mri.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void zB() {
        this.fRG = (RelativeLayout) this.mri.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.mri.findViewById(R.id.navigation_bar);
        this.mrk = (EditText) this.mri.findViewById(R.id.edit_content);
        this.mro = (TextView) this.mri.findViewById(R.id.text_content_size);
        this.lZM = (ImageView) this.mri.findViewById(R.id.video_cover);
        this.lZJ = (CustomVideoView) this.mri.findViewById(R.id.preview_videoview);
        this.bVE = (ScrollView) this.mri.findViewById(R.id.write_scrollview);
        this.lZJ.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.lZJ.getWidth() != b.this.lZM.getWidth() || b.this.lZJ.getHeight() != b.this.lZM.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.lZM.getLayoutParams();
                    layoutParams.width = b.this.lZJ.getWidth();
                    layoutParams.height = b.this.lZJ.getHeight();
                    b.this.lZM.setLayoutParams(layoutParams);
                }
                b.this.lZM.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lZJ.start();
                        b.this.lZM.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.lZJ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.dh(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.mrr = (LinearLayout) this.mri.findViewById(R.id.video_activity_title_container);
        this.mrs = (ListView) this.mri.findViewById(R.id.video_activity_title_list);
        this.mrs.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.mrr.setVisibility(8);
                b.this.mro.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.mrk.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.mrk.requestFocus();
                    if (!TextUtils.isEmpty(b.this.mrk.getText())) {
                        b.this.mrk.setSelection(b.this.mrk.getText().length());
                    }
                    l.showSoftKeyPad(b.this.mri, b.this.mrk);
                }
            }
        });
        this.mru = (LinearLayout) this.mri.findViewById(R.id.save_video_wrapper);
        this.mrv = (TextView) this.mri.findViewById(R.id.save_video_ridiobutton);
        this.mrw = (TextView) this.mri.findViewById(R.id.save_video_ridiotext);
        this.mrn = (WriteLocationView) this.mri.findViewById(R.id.location);
        this.mrm = (StateSwitchView) this.mri.findViewById(R.id.view_privacy);
        this.mrm.setStateString(this.mri.getString(R.string.display_on_my_home_page), this.mri.getString(R.string.display_on_my_home_page));
        this.mrm.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.mrm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.mrm.aLf();
            }
        });
        this.mrm.setTextSize(0, this.mri.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.mry = (ForumTabSelectedView) this.mri.findViewById(R.id.frs_tab_list);
        this.mry.setData(frsTabInfoData);
        this.mry.setActivity(this.mri);
    }

    public ForumTabSelectedView dsd() {
        return this.mry;
    }

    public boolean isToDynamic() {
        return this.mrl != null && this.mrl.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.mri) / l.getDimens(this.mri, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.mri);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.mri, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.lZJ.setVideoHeight(i4);
        this.lZJ.setVideoWidth(i3);
        this.lZJ.invalidate();
    }

    private void initView() {
        this.mrp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.mri);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mri.getPageContext().getString(R.string.post_video_title));
        if (this.mrc) {
            this.mTitle.setText(this.mri.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.mrj = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.mri);
        this.mrj.setText(R.string.send_post);
        this.mrk.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.mrk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.mrt != null && b.this.mrt.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.mri, b.this.mrk);
                    b.this.mrr.setVisibility(0);
                    b.this.mro.setVisibility(8);
                }
                long dse = b.mrh - b.this.dse();
                if (dse >= 0) {
                    an.setViewTextColor(b.this.mro, (int) R.color.cp_cont_e);
                    b.this.mro.setText(String.valueOf(dse));
                    return;
                }
                b.this.mro.setText("0");
                b.this.mrk.setText(b.this.mrk.getText().toString().substring(0, b.mrh));
                b.this.mrk.setSelection(b.this.mrk.getText().length());
                b.this.mri.showToast(b.this.mri.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.mrq != null) {
                    if (!b.this.mrq.dqL()) {
                        b.this.vR(false);
                    }
                    b.this.mrq.vF(false);
                }
            }
        });
        this.mrt = new a();
        this.mrs.setAdapter((ListAdapter) this.mrt);
        this.mrx = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.mrx) {
            an.setBackgroundResource(this.mrv, R.drawable.corner_bg_radio_selected);
        } else {
            an.setBackgroundResource(this.mrv, R.drawable.corner_bg_radio_unselected);
        }
        an.setViewTextColor(this.mrw, (int) R.color.cp_cont_g);
        this.mru.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mrx) {
                    b.this.mrx = false;
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    an.setBackgroundResource(b.this.mrv, R.drawable.corner_bg_radio_unselected);
                    b.this.mrv.invalidate();
                    return;
                }
                b.this.mrx = true;
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                an.setBackgroundResource(b.this.mrv, R.drawable.corner_bg_radio_selected);
                b.this.mrv.invalidate();
            }
        });
    }

    public void Pe(String str) {
        int i;
        int i2 = 0;
        Bitmap Mx = Mx(str);
        if (Mx != null && Mx.getHeight() != 0) {
            if (Mx.getHeight() <= 0) {
                i = 0;
            } else if (Mx.getWidth() / Mx.getHeight() > l.getEquipmentWidth(this.mri) / l.getDimens(this.mri, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.mri);
                if (Mx.getWidth() > 0) {
                    i2 = (int) ((i / Mx.getWidth()) * Mx.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.mri, R.dimen.ds440);
                if (Mx.getWidth() > 0) {
                    i = (int) ((dimens / Mx.getHeight()) * Mx.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.lZM.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.lZM.setLayoutParams(layoutParams);
            this.lZM.setImageBitmap(Mx);
        }
    }

    private Bitmap Mx(String str) {
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
        this.mri.getLayoutMode().setNightMode(i == 1);
        this.mri.getLayoutMode().onModeChanged(this.fRG);
        this.mNavigationBar.onChangeSkinType(this.mri.getPageContext(), i);
        SvgManager.aWQ().a(this.mrp, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        an.setViewTextColor(this.mrj, R.color.cp_link_tip_a, 1);
        an.c(this.mrn, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.mrx = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.mrx) {
            an.setBackgroundResource(this.mrv, R.drawable.corner_bg_radio_selected);
        } else {
            an.setBackgroundResource(this.mrv, R.drawable.corner_bg_radio_unselected);
        }
        if (this.mrn != null) {
            this.mrn.onChangeSkinType(i);
        }
        if (this.mrm != null) {
            this.mrm.onChangeSkinType(i);
        }
        if (this.mry != null) {
            this.mry.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.mrk.getText() == null) {
            return null;
        }
        return this.mrk.getText().toString();
    }

    public long dse() {
        if (this.mrk.getText() == null || this.mrk.getText().toString() == null) {
            return 0L;
        }
        return this.mrk.getText().length();
    }

    public WriteLocationView dsf() {
        return this.mrn;
    }

    public View dsg() {
        return this.mrj;
    }

    public View getBackButton() {
        return this.mrp;
    }

    public EditText dsh() {
        return this.mrk;
    }

    public StateSwitchView dsi() {
        return this.mrm;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                Pe(thumbPath);
                this.lZM.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lZM.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.lZM.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.lZJ.setVideoPath(videoPath);
                this.lZJ.start();
            }
        }
        if (!w.isEmpty(list)) {
            this.mrt.fj(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.mrk.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.mrt.fj(arrayList);
            this.mrk.setText("#" + videoTitleData.name + "#");
        }
    }

    public void dnO() {
        if (this.lZJ != null) {
            this.lZJ.resume();
            this.lZJ.seekTo(this.lZT);
            this.lZJ.start();
        }
    }

    public void caG() {
        this.lZT = this.lZJ.getCurrentPosition();
        if (this.lZJ != null) {
            this.lZJ.stopPlayback();
        }
    }

    public void Pf(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.mri.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.mri.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dsj() {
        this.mrq.aY(null);
        this.mrq.vE(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.mrq.aY(postWriteCallBackData.getSensitiveWords());
            this.mrq.OM(postWriteCallBackData.getErrorString());
            if (!w.isEmpty(this.mrq.dqI())) {
                vR(true);
            }
        }
    }

    public void vR(boolean z) {
        if (this.mrk.getText() != null) {
            int selectionEnd = this.mrk.getSelectionEnd();
            SpannableStringBuilder d = this.mrq.d(this.mrk.getText());
            if (d != null) {
                this.mrq.vF(true);
                this.mrk.setText(d);
                if (z && this.mrq.dqJ() >= 0) {
                    this.mrk.requestFocus();
                    this.mrk.setSelection(this.mrq.dqJ());
                } else {
                    this.mrk.setSelection(selectionEnd);
                }
                this.mrq.vE(this.mrq.dqJ() >= 0);
            }
        }
    }

    public c dsk() {
        return this.mrq;
    }

    public void vS(boolean z) {
        if (z) {
            this.mrr.setVisibility(8);
            this.mro.setVisibility(0);
            this.bVE.smoothScrollTo(0, this.mro.getBottom());
        }
    }
}
