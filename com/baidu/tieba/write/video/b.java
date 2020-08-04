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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    public static int mzm = 60;
    private ScrollView bWv;
    private RelativeLayout fWZ;
    private NavigationBar mNavigationBar;
    private TextView mTitle;
    private CustomVideoView mhf;
    private ImageView mhi;
    private int mhp;
    private TextView mzA;
    private TextView mzB;
    private ForumTabSelectedView mzD;
    private WriteVideoActivity mzn;
    private TextView mzo;
    private EditText mzp;
    private StateSwitchView mzq;
    private StateSwitchView mzr;
    private WriteLocationView mzs;
    private TextView mzt;
    private ImageView mzu;
    private c mzv;
    private LinearLayout mzw;
    private ListView mzx;
    private a mzy;
    private LinearLayout mzz;
    private boolean mzC = true;
    private boolean mzh = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.mzn = writeVideoActivity;
        this.mzn.setContentView(R.layout.write_video_activity);
        this.mzv = new c();
        this.mzv.GV(R.color.cp_cont_a);
        this.mzv.GW(R.color.cp_cont_h_alpha85);
        Ad();
        initView();
    }

    public void wv(boolean z) {
        this.mzh = z;
        if (z) {
            if (this.mzr != null) {
                this.mzr.setVisibility(8);
            }
            if (this.mzs != null) {
                this.mzs.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.mzn.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void Ad() {
        this.fWZ = (RelativeLayout) this.mzn.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.mzn.findViewById(R.id.navigation_bar);
        this.mzp = (EditText) this.mzn.findViewById(R.id.edit_content);
        this.mzt = (TextView) this.mzn.findViewById(R.id.text_content_size);
        this.mhi = (ImageView) this.mzn.findViewById(R.id.video_cover);
        this.mhf = (CustomVideoView) this.mzn.findViewById(R.id.preview_videoview);
        this.bWv = (ScrollView) this.mzn.findViewById(R.id.write_scrollview);
        this.mhf.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.mhf.getWidth() != b.this.mhi.getWidth() || b.this.mhf.getHeight() != b.this.mhi.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.mhi.getLayoutParams();
                    layoutParams.width = b.this.mhf.getWidth();
                    layoutParams.height = b.this.mhf.getHeight();
                    b.this.mhi.setLayoutParams(layoutParams);
                }
                b.this.mhi.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mhf.start();
                        b.this.mhi.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.mhf.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.dj(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.mzw = (LinearLayout) this.mzn.findViewById(R.id.video_activity_title_container);
        this.mzx = (ListView) this.mzn.findViewById(R.id.video_activity_title_list);
        this.mzx.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.mzw.setVisibility(8);
                b.this.mzt.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.mzp.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.mzp.requestFocus();
                    if (!TextUtils.isEmpty(b.this.mzp.getText())) {
                        b.this.mzp.setSelection(b.this.mzp.getText().length());
                    }
                    l.showSoftKeyPad(b.this.mzn, b.this.mzp);
                }
            }
        });
        this.mzz = (LinearLayout) this.mzn.findViewById(R.id.save_video_wrapper);
        this.mzA = (TextView) this.mzn.findViewById(R.id.save_video_ridiobutton);
        this.mzB = (TextView) this.mzn.findViewById(R.id.save_video_ridiotext);
        this.mzs = (WriteLocationView) this.mzn.findViewById(R.id.location);
        this.mzr = (StateSwitchView) this.mzn.findViewById(R.id.view_privacy);
        this.mzr.setStateString(this.mzn.getString(R.string.display_on_my_home_page), this.mzn.getString(R.string.display_on_my_home_page));
        this.mzr.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.mzr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.mzr.aOT();
            }
        });
        this.mzr.setTextSize(0, this.mzn.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.mzD = (ForumTabSelectedView) this.mzn.findViewById(R.id.frs_tab_list);
        this.mzD.setData(frsTabInfoData);
        this.mzD.setActivity(this.mzn);
    }

    public ForumTabSelectedView dvu() {
        return this.mzD;
    }

    public boolean isToDynamic() {
        return this.mzq != null && this.mzq.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.mzn) / l.getDimens(this.mzn, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.mzn);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.mzn, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.mhf.setVideoHeight(i4);
        this.mhf.setVideoWidth(i3);
        this.mhf.invalidate();
    }

    private void initView() {
        this.mzu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.mzn);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mzn.getPageContext().getString(R.string.post_video_title));
        if (this.mzh) {
            this.mTitle.setText(this.mzn.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.mzo = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.mzn);
        this.mzo.setText(R.string.send_post);
        this.mzp.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.mzp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.mzy != null && b.this.mzy.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.mzn, b.this.mzp);
                    b.this.mzw.setVisibility(0);
                    b.this.mzt.setVisibility(8);
                }
                long dvv = b.mzm - b.this.dvv();
                if (dvv >= 0) {
                    ao.setViewTextColor(b.this.mzt, R.color.cp_cont_e);
                    b.this.mzt.setText(String.valueOf(dvv));
                    return;
                }
                b.this.mzt.setText("0");
                b.this.mzp.setText(b.this.mzp.getText().toString().substring(0, b.mzm));
                b.this.mzp.setSelection(b.this.mzp.getText().length());
                b.this.mzn.showToast(b.this.mzn.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.mzv != null) {
                    if (!b.this.mzv.duc()) {
                        b.this.ww(false);
                    }
                    b.this.mzv.wj(false);
                }
            }
        });
        this.mzy = new a();
        this.mzx.setAdapter((ListAdapter) this.mzy);
        this.mzC = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.mzC) {
            ao.setBackgroundResource(this.mzA, R.drawable.corner_bg_radio_selected);
        } else {
            ao.setBackgroundResource(this.mzA, R.drawable.corner_bg_radio_unselected);
        }
        ao.setViewTextColor(this.mzB, R.color.cp_cont_g);
        this.mzz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mzC) {
                    b.this.mzC = false;
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    ao.setBackgroundResource(b.this.mzA, R.drawable.corner_bg_radio_unselected);
                    b.this.mzA.invalidate();
                    return;
                }
                b.this.mzC = true;
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                ao.setBackgroundResource(b.this.mzA, R.drawable.corner_bg_radio_selected);
                b.this.mzA.invalidate();
            }
        });
    }

    public void PQ(String str) {
        int i;
        int i2 = 0;
        Bitmap Nf = Nf(str);
        if (Nf != null && Nf.getHeight() != 0) {
            if (Nf.getHeight() <= 0) {
                i = 0;
            } else if (Nf.getWidth() / Nf.getHeight() > l.getEquipmentWidth(this.mzn) / l.getDimens(this.mzn, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.mzn);
                if (Nf.getWidth() > 0) {
                    i2 = (int) ((i / Nf.getWidth()) * Nf.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.mzn, R.dimen.ds440);
                if (Nf.getWidth() > 0) {
                    i = (int) ((dimens / Nf.getHeight()) * Nf.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.mhi.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.mhi.setLayoutParams(layoutParams);
            this.mhi.setImageBitmap(Nf);
        }
    }

    private Bitmap Nf(String str) {
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
        this.mzn.getLayoutMode().setNightMode(i == 1);
        this.mzn.getLayoutMode().onModeChanged(this.fWZ);
        this.mNavigationBar.onChangeSkinType(this.mzn.getPageContext(), i);
        SvgManager.baR().a(this.mzu, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setViewTextColor(this.mzo, R.color.cp_link_tip_a, 1);
        ao.c(this.mzs, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.mzC = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.mzC) {
            ao.setBackgroundResource(this.mzA, R.drawable.corner_bg_radio_selected);
        } else {
            ao.setBackgroundResource(this.mzA, R.drawable.corner_bg_radio_unselected);
        }
        if (this.mzs != null) {
            this.mzs.onChangeSkinType(i);
        }
        if (this.mzr != null) {
            this.mzr.onChangeSkinType(i);
        }
        if (this.mzD != null) {
            this.mzD.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.mzp.getText() == null) {
            return null;
        }
        return this.mzp.getText().toString();
    }

    public long dvv() {
        if (this.mzp.getText() == null || this.mzp.getText().toString() == null) {
            return 0L;
        }
        return this.mzp.getText().length();
    }

    public WriteLocationView dvw() {
        return this.mzs;
    }

    public View dvx() {
        return this.mzo;
    }

    public View getBackButton() {
        return this.mzu;
    }

    public EditText dvy() {
        return this.mzp;
    }

    public StateSwitchView dvz() {
        return this.mzr;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                PQ(thumbPath);
                this.mhi.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mhi.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.mhi.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.mhf.setVideoPath(videoPath);
                this.mhf.start();
            }
        }
        if (!x.isEmpty(list)) {
            this.mzy.fs(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.mzp.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.mzy.fs(arrayList);
            this.mzp.setText("#" + videoTitleData.name + "#");
        }
    }

    public void drc() {
        if (this.mhf != null) {
            this.mhf.resume();
            this.mhf.seekTo(this.mhp);
            this.mhf.start();
        }
    }

    public void cef() {
        this.mhp = this.mhf.getCurrentPosition();
        if (this.mhf != null) {
            this.mhf.stopPlayback();
        }
    }

    public void PR(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.mzn.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.mzn.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dvA() {
        this.mzv.aZ(null);
        this.mzv.wi(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.mzv.aZ(postWriteCallBackData.getSensitiveWords());
            this.mzv.Py(postWriteCallBackData.getErrorString());
            if (!x.isEmpty(this.mzv.dtZ())) {
                ww(true);
            }
        }
    }

    public void ww(boolean z) {
        if (this.mzp.getText() != null) {
            int selectionEnd = this.mzp.getSelectionEnd();
            SpannableStringBuilder d = this.mzv.d(this.mzp.getText());
            if (d != null) {
                this.mzv.wj(true);
                this.mzp.setText(d);
                if (z && this.mzv.dua() >= 0) {
                    this.mzp.requestFocus();
                    this.mzp.setSelection(this.mzv.dua());
                } else {
                    this.mzp.setSelection(selectionEnd);
                }
                this.mzv.wi(this.mzv.dua() >= 0);
            }
        }
    }

    public c dvB() {
        return this.mzv;
    }

    public void wx(boolean z) {
        if (z) {
            this.mzw.setVisibility(8);
            this.mzt.setVisibility(0);
            this.bWv.smoothScrollTo(0, this.mzt.getBottom());
        }
    }
}
