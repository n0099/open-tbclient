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
    public static int mrk = 60;
    private ScrollView bVE;
    private RelativeLayout fRG;
    private CustomVideoView lZM;
    private ImageView lZP;
    private int lZW;
    private NavigationBar mNavigationBar;
    private TextView mTitle;
    private ForumTabSelectedView mrB;
    private WriteVideoActivity mrl;
    private TextView mrm;
    private EditText mrn;
    private StateSwitchView mro;
    private StateSwitchView mrp;
    private WriteLocationView mrq;
    private TextView mrr;
    private ImageView mrs;
    private c mrt;
    private LinearLayout mru;
    private ListView mrv;
    private a mrw;
    private LinearLayout mrx;
    private TextView mry;
    private TextView mrz;
    private boolean mrA = true;
    private boolean mrf = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.mrl = writeVideoActivity;
        this.mrl.setContentView(R.layout.write_video_activity);
        this.mrt = new c();
        this.mrt.Gz(R.color.cp_cont_a);
        this.mrt.GA(R.color.cp_cont_h_alpha85);
        zB();
        initView();
    }

    public void vQ(boolean z) {
        this.mrf = z;
        if (z) {
            if (this.mrp != null) {
                this.mrp.setVisibility(8);
            }
            if (this.mrq != null) {
                this.mrq.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.mrl.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void zB() {
        this.fRG = (RelativeLayout) this.mrl.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.mrl.findViewById(R.id.navigation_bar);
        this.mrn = (EditText) this.mrl.findViewById(R.id.edit_content);
        this.mrr = (TextView) this.mrl.findViewById(R.id.text_content_size);
        this.lZP = (ImageView) this.mrl.findViewById(R.id.video_cover);
        this.lZM = (CustomVideoView) this.mrl.findViewById(R.id.preview_videoview);
        this.bVE = (ScrollView) this.mrl.findViewById(R.id.write_scrollview);
        this.lZM.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.lZM.getWidth() != b.this.lZP.getWidth() || b.this.lZM.getHeight() != b.this.lZP.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.lZP.getLayoutParams();
                    layoutParams.width = b.this.lZM.getWidth();
                    layoutParams.height = b.this.lZM.getHeight();
                    b.this.lZP.setLayoutParams(layoutParams);
                }
                b.this.lZP.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lZM.start();
                        b.this.lZP.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.lZM.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.dh(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.mru = (LinearLayout) this.mrl.findViewById(R.id.video_activity_title_container);
        this.mrv = (ListView) this.mrl.findViewById(R.id.video_activity_title_list);
        this.mrv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.mru.setVisibility(8);
                b.this.mrr.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.mrn.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.mrn.requestFocus();
                    if (!TextUtils.isEmpty(b.this.mrn.getText())) {
                        b.this.mrn.setSelection(b.this.mrn.getText().length());
                    }
                    l.showSoftKeyPad(b.this.mrl, b.this.mrn);
                }
            }
        });
        this.mrx = (LinearLayout) this.mrl.findViewById(R.id.save_video_wrapper);
        this.mry = (TextView) this.mrl.findViewById(R.id.save_video_ridiobutton);
        this.mrz = (TextView) this.mrl.findViewById(R.id.save_video_ridiotext);
        this.mrq = (WriteLocationView) this.mrl.findViewById(R.id.location);
        this.mrp = (StateSwitchView) this.mrl.findViewById(R.id.view_privacy);
        this.mrp.setStateString(this.mrl.getString(R.string.display_on_my_home_page), this.mrl.getString(R.string.display_on_my_home_page));
        this.mrp.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.mrp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.mrp.aLf();
            }
        });
        this.mrp.setTextSize(0, this.mrl.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.mrB = (ForumTabSelectedView) this.mrl.findViewById(R.id.frs_tab_list);
        this.mrB.setData(frsTabInfoData);
        this.mrB.setActivity(this.mrl);
    }

    public ForumTabSelectedView dsh() {
        return this.mrB;
    }

    public boolean isToDynamic() {
        return this.mro != null && this.mro.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.mrl) / l.getDimens(this.mrl, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.mrl);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.mrl, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.lZM.setVideoHeight(i4);
        this.lZM.setVideoWidth(i3);
        this.lZM.invalidate();
    }

    private void initView() {
        this.mrs = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.mrl);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mrl.getPageContext().getString(R.string.post_video_title));
        if (this.mrf) {
            this.mTitle.setText(this.mrl.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.mrm = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.mrl);
        this.mrm.setText(R.string.send_post);
        this.mrn.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.mrn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.mrw != null && b.this.mrw.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.mrl, b.this.mrn);
                    b.this.mru.setVisibility(0);
                    b.this.mrr.setVisibility(8);
                }
                long dsi = b.mrk - b.this.dsi();
                if (dsi >= 0) {
                    an.setViewTextColor(b.this.mrr, (int) R.color.cp_cont_e);
                    b.this.mrr.setText(String.valueOf(dsi));
                    return;
                }
                b.this.mrr.setText("0");
                b.this.mrn.setText(b.this.mrn.getText().toString().substring(0, b.mrk));
                b.this.mrn.setSelection(b.this.mrn.getText().length());
                b.this.mrl.showToast(b.this.mrl.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.mrt != null) {
                    if (!b.this.mrt.dqP()) {
                        b.this.vR(false);
                    }
                    b.this.mrt.vF(false);
                }
            }
        });
        this.mrw = new a();
        this.mrv.setAdapter((ListAdapter) this.mrw);
        this.mrA = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.mrA) {
            an.setBackgroundResource(this.mry, R.drawable.corner_bg_radio_selected);
        } else {
            an.setBackgroundResource(this.mry, R.drawable.corner_bg_radio_unselected);
        }
        an.setViewTextColor(this.mrz, (int) R.color.cp_cont_g);
        this.mrx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mrA) {
                    b.this.mrA = false;
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    an.setBackgroundResource(b.this.mry, R.drawable.corner_bg_radio_unselected);
                    b.this.mry.invalidate();
                    return;
                }
                b.this.mrA = true;
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                an.setBackgroundResource(b.this.mry, R.drawable.corner_bg_radio_selected);
                b.this.mry.invalidate();
            }
        });
    }

    public void Pf(String str) {
        int i;
        int i2 = 0;
        Bitmap Mx = Mx(str);
        if (Mx != null && Mx.getHeight() != 0) {
            if (Mx.getHeight() <= 0) {
                i = 0;
            } else if (Mx.getWidth() / Mx.getHeight() > l.getEquipmentWidth(this.mrl) / l.getDimens(this.mrl, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.mrl);
                if (Mx.getWidth() > 0) {
                    i2 = (int) ((i / Mx.getWidth()) * Mx.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.mrl, R.dimen.ds440);
                if (Mx.getWidth() > 0) {
                    i = (int) ((dimens / Mx.getHeight()) * Mx.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.lZP.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.lZP.setLayoutParams(layoutParams);
            this.lZP.setImageBitmap(Mx);
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
        this.mrl.getLayoutMode().setNightMode(i == 1);
        this.mrl.getLayoutMode().onModeChanged(this.fRG);
        this.mNavigationBar.onChangeSkinType(this.mrl.getPageContext(), i);
        SvgManager.aWQ().a(this.mrs, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        an.setViewTextColor(this.mrm, R.color.cp_link_tip_a, 1);
        an.c(this.mrq, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.mrA = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.mrA) {
            an.setBackgroundResource(this.mry, R.drawable.corner_bg_radio_selected);
        } else {
            an.setBackgroundResource(this.mry, R.drawable.corner_bg_radio_unselected);
        }
        if (this.mrq != null) {
            this.mrq.onChangeSkinType(i);
        }
        if (this.mrp != null) {
            this.mrp.onChangeSkinType(i);
        }
        if (this.mrB != null) {
            this.mrB.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.mrn.getText() == null) {
            return null;
        }
        return this.mrn.getText().toString();
    }

    public long dsi() {
        if (this.mrn.getText() == null || this.mrn.getText().toString() == null) {
            return 0L;
        }
        return this.mrn.getText().length();
    }

    public WriteLocationView dsj() {
        return this.mrq;
    }

    public View dsk() {
        return this.mrm;
    }

    public View getBackButton() {
        return this.mrs;
    }

    public EditText dsl() {
        return this.mrn;
    }

    public StateSwitchView dsm() {
        return this.mrp;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                Pf(thumbPath);
                this.lZP.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lZP.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.lZP.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.lZM.setVideoPath(videoPath);
                this.lZM.start();
            }
        }
        if (!w.isEmpty(list)) {
            this.mrw.fj(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.mrn.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.mrw.fj(arrayList);
            this.mrn.setText("#" + videoTitleData.name + "#");
        }
    }

    public void dnS() {
        if (this.lZM != null) {
            this.lZM.resume();
            this.lZM.seekTo(this.lZW);
            this.lZM.start();
        }
    }

    public void caH() {
        this.lZW = this.lZM.getCurrentPosition();
        if (this.lZM != null) {
            this.lZM.stopPlayback();
        }
    }

    public void Pg(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.mrl.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.mrl.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dsn() {
        this.mrt.aY(null);
        this.mrt.vE(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.mrt.aY(postWriteCallBackData.getSensitiveWords());
            this.mrt.ON(postWriteCallBackData.getErrorString());
            if (!w.isEmpty(this.mrt.dqM())) {
                vR(true);
            }
        }
    }

    public void vR(boolean z) {
        if (this.mrn.getText() != null) {
            int selectionEnd = this.mrn.getSelectionEnd();
            SpannableStringBuilder d = this.mrt.d(this.mrn.getText());
            if (d != null) {
                this.mrt.vF(true);
                this.mrn.setText(d);
                if (z && this.mrt.dqN() >= 0) {
                    this.mrn.requestFocus();
                    this.mrn.setSelection(this.mrt.dqN());
                } else {
                    this.mrn.setSelection(selectionEnd);
                }
                this.mrt.vE(this.mrt.dqN() >= 0);
            }
        }
    }

    public c dso() {
        return this.mrt;
    }

    public void vS(boolean z) {
        if (z) {
            this.mru.setVisibility(8);
            this.mrr.setVisibility(0);
            this.bVE.smoothScrollTo(0, this.mrr.getBottom());
        }
    }
}
