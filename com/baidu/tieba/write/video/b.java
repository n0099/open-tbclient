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
    public static int mzk = 60;
    private ScrollView bWv;
    private RelativeLayout fWZ;
    private NavigationBar mNavigationBar;
    private TextView mTitle;
    private CustomVideoView mhd;
    private ImageView mhg;
    private int mhn;
    private ForumTabSelectedView mzB;
    private WriteVideoActivity mzl;
    private TextView mzm;
    private EditText mzn;
    private StateSwitchView mzo;
    private StateSwitchView mzp;
    private WriteLocationView mzq;
    private TextView mzr;
    private ImageView mzs;
    private c mzt;
    private LinearLayout mzu;
    private ListView mzv;
    private a mzw;
    private LinearLayout mzx;
    private TextView mzy;
    private TextView mzz;
    private boolean mzA = true;
    private boolean mzf = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.mzl = writeVideoActivity;
        this.mzl.setContentView(R.layout.write_video_activity);
        this.mzt = new c();
        this.mzt.GV(R.color.cp_cont_a);
        this.mzt.GW(R.color.cp_cont_h_alpha85);
        Ad();
        initView();
    }

    public void wv(boolean z) {
        this.mzf = z;
        if (z) {
            if (this.mzp != null) {
                this.mzp.setVisibility(8);
            }
            if (this.mzq != null) {
                this.mzq.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.mzl.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void Ad() {
        this.fWZ = (RelativeLayout) this.mzl.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.mzl.findViewById(R.id.navigation_bar);
        this.mzn = (EditText) this.mzl.findViewById(R.id.edit_content);
        this.mzr = (TextView) this.mzl.findViewById(R.id.text_content_size);
        this.mhg = (ImageView) this.mzl.findViewById(R.id.video_cover);
        this.mhd = (CustomVideoView) this.mzl.findViewById(R.id.preview_videoview);
        this.bWv = (ScrollView) this.mzl.findViewById(R.id.write_scrollview);
        this.mhd.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.mhd.getWidth() != b.this.mhg.getWidth() || b.this.mhd.getHeight() != b.this.mhg.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.mhg.getLayoutParams();
                    layoutParams.width = b.this.mhd.getWidth();
                    layoutParams.height = b.this.mhd.getHeight();
                    b.this.mhg.setLayoutParams(layoutParams);
                }
                b.this.mhg.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mhd.start();
                        b.this.mhg.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.mhd.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.dj(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.mzu = (LinearLayout) this.mzl.findViewById(R.id.video_activity_title_container);
        this.mzv = (ListView) this.mzl.findViewById(R.id.video_activity_title_list);
        this.mzv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.mzu.setVisibility(8);
                b.this.mzr.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.mzn.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.mzn.requestFocus();
                    if (!TextUtils.isEmpty(b.this.mzn.getText())) {
                        b.this.mzn.setSelection(b.this.mzn.getText().length());
                    }
                    l.showSoftKeyPad(b.this.mzl, b.this.mzn);
                }
            }
        });
        this.mzx = (LinearLayout) this.mzl.findViewById(R.id.save_video_wrapper);
        this.mzy = (TextView) this.mzl.findViewById(R.id.save_video_ridiobutton);
        this.mzz = (TextView) this.mzl.findViewById(R.id.save_video_ridiotext);
        this.mzq = (WriteLocationView) this.mzl.findViewById(R.id.location);
        this.mzp = (StateSwitchView) this.mzl.findViewById(R.id.view_privacy);
        this.mzp.setStateString(this.mzl.getString(R.string.display_on_my_home_page), this.mzl.getString(R.string.display_on_my_home_page));
        this.mzp.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.mzp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.mzp.aOT();
            }
        });
        this.mzp.setTextSize(0, this.mzl.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.mzB = (ForumTabSelectedView) this.mzl.findViewById(R.id.frs_tab_list);
        this.mzB.setData(frsTabInfoData);
        this.mzB.setActivity(this.mzl);
    }

    public ForumTabSelectedView dvt() {
        return this.mzB;
    }

    public boolean isToDynamic() {
        return this.mzo != null && this.mzo.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.mzl) / l.getDimens(this.mzl, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.mzl);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.mzl, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.mhd.setVideoHeight(i4);
        this.mhd.setVideoWidth(i3);
        this.mhd.invalidate();
    }

    private void initView() {
        this.mzs = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.mzl);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mzl.getPageContext().getString(R.string.post_video_title));
        if (this.mzf) {
            this.mTitle.setText(this.mzl.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.mzm = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.mzl);
        this.mzm.setText(R.string.send_post);
        this.mzn.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.mzn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.mzw != null && b.this.mzw.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.mzl, b.this.mzn);
                    b.this.mzu.setVisibility(0);
                    b.this.mzr.setVisibility(8);
                }
                long dvu = b.mzk - b.this.dvu();
                if (dvu >= 0) {
                    ao.setViewTextColor(b.this.mzr, R.color.cp_cont_e);
                    b.this.mzr.setText(String.valueOf(dvu));
                    return;
                }
                b.this.mzr.setText("0");
                b.this.mzn.setText(b.this.mzn.getText().toString().substring(0, b.mzk));
                b.this.mzn.setSelection(b.this.mzn.getText().length());
                b.this.mzl.showToast(b.this.mzl.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.mzt != null) {
                    if (!b.this.mzt.dub()) {
                        b.this.ww(false);
                    }
                    b.this.mzt.wj(false);
                }
            }
        });
        this.mzw = new a();
        this.mzv.setAdapter((ListAdapter) this.mzw);
        this.mzA = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.mzA) {
            ao.setBackgroundResource(this.mzy, R.drawable.corner_bg_radio_selected);
        } else {
            ao.setBackgroundResource(this.mzy, R.drawable.corner_bg_radio_unselected);
        }
        ao.setViewTextColor(this.mzz, R.color.cp_cont_g);
        this.mzx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mzA) {
                    b.this.mzA = false;
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    ao.setBackgroundResource(b.this.mzy, R.drawable.corner_bg_radio_unselected);
                    b.this.mzy.invalidate();
                    return;
                }
                b.this.mzA = true;
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                ao.setBackgroundResource(b.this.mzy, R.drawable.corner_bg_radio_selected);
                b.this.mzy.invalidate();
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
            } else if (Nf.getWidth() / Nf.getHeight() > l.getEquipmentWidth(this.mzl) / l.getDimens(this.mzl, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.mzl);
                if (Nf.getWidth() > 0) {
                    i2 = (int) ((i / Nf.getWidth()) * Nf.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.mzl, R.dimen.ds440);
                if (Nf.getWidth() > 0) {
                    i = (int) ((dimens / Nf.getHeight()) * Nf.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.mhg.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.mhg.setLayoutParams(layoutParams);
            this.mhg.setImageBitmap(Nf);
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
        this.mzl.getLayoutMode().setNightMode(i == 1);
        this.mzl.getLayoutMode().onModeChanged(this.fWZ);
        this.mNavigationBar.onChangeSkinType(this.mzl.getPageContext(), i);
        SvgManager.baR().a(this.mzs, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setViewTextColor(this.mzm, R.color.cp_link_tip_a, 1);
        ao.c(this.mzq, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.mzA = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.mzA) {
            ao.setBackgroundResource(this.mzy, R.drawable.corner_bg_radio_selected);
        } else {
            ao.setBackgroundResource(this.mzy, R.drawable.corner_bg_radio_unselected);
        }
        if (this.mzq != null) {
            this.mzq.onChangeSkinType(i);
        }
        if (this.mzp != null) {
            this.mzp.onChangeSkinType(i);
        }
        if (this.mzB != null) {
            this.mzB.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.mzn.getText() == null) {
            return null;
        }
        return this.mzn.getText().toString();
    }

    public long dvu() {
        if (this.mzn.getText() == null || this.mzn.getText().toString() == null) {
            return 0L;
        }
        return this.mzn.getText().length();
    }

    public WriteLocationView dvv() {
        return this.mzq;
    }

    public View dvw() {
        return this.mzm;
    }

    public View getBackButton() {
        return this.mzs;
    }

    public EditText dvx() {
        return this.mzn;
    }

    public StateSwitchView dvy() {
        return this.mzp;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                PQ(thumbPath);
                this.mhg.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mhg.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.mhg.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.mhd.setVideoPath(videoPath);
                this.mhd.start();
            }
        }
        if (!x.isEmpty(list)) {
            this.mzw.fs(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.mzn.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.mzw.fs(arrayList);
            this.mzn.setText("#" + videoTitleData.name + "#");
        }
    }

    public void drb() {
        if (this.mhd != null) {
            this.mhd.resume();
            this.mhd.seekTo(this.mhn);
            this.mhd.start();
        }
    }

    public void cef() {
        this.mhn = this.mhd.getCurrentPosition();
        if (this.mhd != null) {
            this.mhd.stopPlayback();
        }
    }

    public void PR(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.mzl.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.mzl.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dvz() {
        this.mzt.aZ(null);
        this.mzt.wi(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.mzt.aZ(postWriteCallBackData.getSensitiveWords());
            this.mzt.Py(postWriteCallBackData.getErrorString());
            if (!x.isEmpty(this.mzt.dtY())) {
                ww(true);
            }
        }
    }

    public void ww(boolean z) {
        if (this.mzn.getText() != null) {
            int selectionEnd = this.mzn.getSelectionEnd();
            SpannableStringBuilder d = this.mzt.d(this.mzn.getText());
            if (d != null) {
                this.mzt.wj(true);
                this.mzn.setText(d);
                if (z && this.mzt.dtZ() >= 0) {
                    this.mzn.requestFocus();
                    this.mzn.setSelection(this.mzt.dtZ());
                } else {
                    this.mzn.setSelection(selectionEnd);
                }
                this.mzt.wi(this.mzt.dtZ() >= 0);
            }
        }
    }

    public c dvA() {
        return this.mzt;
    }

    public void wx(boolean z) {
        if (z) {
            this.mzu.setVisibility(8);
            this.mzr.setVisibility(0);
            this.bWv.smoothScrollTo(0, this.mzr.getBottom());
        }
    }
}
