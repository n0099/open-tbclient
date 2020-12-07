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
    public static int nZl = 60;
    private ScrollView cKf;
    private RelativeLayout hbJ;
    private NavigationBar mNavigationBar;
    private TextView mTitle;
    private CustomVideoView nGj;
    private ImageView nGm;
    private int nGt;
    private TextView nZA;
    private ForumTabSelectedView nZC;
    private WriteVideoActivity nZm;
    private TextView nZn;
    private EditText nZo;
    private StateSwitchView nZp;
    private StateSwitchView nZq;
    private WriteLocationView nZr;
    private TextView nZs;
    private ImageView nZt;
    private c nZu;
    private LinearLayout nZv;
    private ListView nZw;
    private a nZx;
    private LinearLayout nZy;
    private TextView nZz;
    private boolean nZB = true;
    private boolean nZg = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.nZm = writeVideoActivity;
        this.nZm.setContentView(R.layout.write_video_activity);
        this.nZu = new c();
        this.nZu.MB(R.color.CAM_X0101);
        this.nZu.MC(R.color.cp_cont_h_alpha85);
        Jh();
        initView();
    }

    public void zo(boolean z) {
        this.nZg = z;
        if (z) {
            if (this.nZq != null) {
                this.nZq.setVisibility(8);
            }
            if (this.nZr != null) {
                this.nZr.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.nZm.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void Jh() {
        this.hbJ = (RelativeLayout) this.nZm.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.nZm.findViewById(R.id.navigation_bar);
        this.nZo = (EditText) this.nZm.findViewById(R.id.edit_content);
        this.nZs = (TextView) this.nZm.findViewById(R.id.text_content_size);
        this.nGm = (ImageView) this.nZm.findViewById(R.id.video_cover);
        this.nGj = (CustomVideoView) this.nZm.findViewById(R.id.preview_videoview);
        this.cKf = (ScrollView) this.nZm.findViewById(R.id.write_scrollview);
        this.nGj.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.nGj.getWidth() != b.this.nGm.getWidth() || b.this.nGj.getHeight() != b.this.nGm.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.nGm.getLayoutParams();
                    layoutParams.width = b.this.nGj.getWidth();
                    layoutParams.height = b.this.nGj.getHeight();
                    b.this.nGm.setLayoutParams(layoutParams);
                }
                b.this.nGm.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nGj.start();
                        b.this.nGm.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.nGj.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.dF(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.nZv = (LinearLayout) this.nZm.findViewById(R.id.video_activity_title_container);
        this.nZw = (ListView) this.nZm.findViewById(R.id.video_activity_title_list);
        this.nZw.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.nZv.setVisibility(8);
                b.this.nZs.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.nZo.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.nZo.requestFocus();
                    if (!TextUtils.isEmpty(b.this.nZo.getText())) {
                        b.this.nZo.setSelection(b.this.nZo.getText().length());
                    }
                    l.showSoftKeyPad(b.this.nZm, b.this.nZo);
                }
            }
        });
        this.nZy = (LinearLayout) this.nZm.findViewById(R.id.save_video_wrapper);
        this.nZz = (TextView) this.nZm.findViewById(R.id.save_video_ridiobutton);
        this.nZA = (TextView) this.nZm.findViewById(R.id.save_video_ridiotext);
        this.nZr = (WriteLocationView) this.nZm.findViewById(R.id.location);
        this.nZq = (StateSwitchView) this.nZm.findViewById(R.id.view_privacy);
        this.nZq.setStateString(this.nZm.getString(R.string.display_on_my_home_page), this.nZm.getString(R.string.display_on_my_home_page));
        this.nZq.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.CAM_X0106));
        this.nZq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.nZq.bhC();
            }
        });
        this.nZq.setTextSize(0, this.nZm.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void c(FrsTabInfoData frsTabInfoData) {
        this.nZC = (ForumTabSelectedView) this.nZm.findViewById(R.id.frs_tab_list);
        this.nZC.setData(frsTabInfoData);
        this.nZC.setActivity(this.nZm);
    }

    public ForumTabSelectedView dZG() {
        return this.nZC;
    }

    public boolean isToDynamic() {
        return this.nZp != null && this.nZp.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.nZm) / l.getDimens(this.nZm, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.nZm);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.nZm, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.nGj.setVideoHeight(i4);
        this.nGj.setVideoWidth(i3);
        this.nGj.invalidate();
    }

    private void initView() {
        this.nZt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.nZm);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.nZm.getPageContext().getString(R.string.post_video_title));
        if (this.nZg) {
            this.mTitle.setText(this.nZm.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.nZn = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.nZm);
        this.nZn.setText(R.string.send_post);
        this.nZo.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.nZo.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.nZx != null && b.this.nZx.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.nZm, b.this.nZo);
                    b.this.nZv.setVisibility(0);
                    b.this.nZs.setVisibility(8);
                }
                long dZH = b.nZl - b.this.dZH();
                if (dZH >= 0) {
                    ap.setViewTextColor(b.this.nZs, R.color.CAM_X0110);
                    b.this.nZs.setText(String.valueOf(dZH));
                    return;
                }
                b.this.nZs.setText("0");
                b.this.nZo.setText(b.this.nZo.getText().toString().substring(0, b.nZl));
                b.this.nZo.setSelection(b.this.nZo.getText().length());
                b.this.nZm.showToast(b.this.nZm.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.nZu != null) {
                    if (!b.this.nZu.dYp()) {
                        b.this.zp(false);
                    }
                    b.this.nZu.zc(false);
                }
            }
        });
        this.nZx = new a();
        this.nZw.setAdapter((ListAdapter) this.nZx);
        this.nZB = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.nZB) {
            ap.setBackgroundResource(this.nZz, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.nZz, R.drawable.corner_bg_radio_unselected);
        }
        ap.setViewTextColor(this.nZA, R.color.CAM_X0111);
        this.nZy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.nZB) {
                    b.this.nZB = false;
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    ap.setBackgroundResource(b.this.nZz, R.drawable.corner_bg_radio_unselected);
                    b.this.nZz.invalidate();
                    return;
                }
                b.this.nZB = true;
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                ap.setBackgroundResource(b.this.nZz, R.drawable.corner_bg_radio_selected);
                b.this.nZz.invalidate();
            }
        });
    }

    public void VS(String str) {
        int i;
        int i2 = 0;
        Bitmap SW = SW(str);
        if (SW != null && SW.getHeight() != 0) {
            if (SW.getHeight() <= 0) {
                i = 0;
            } else if (SW.getWidth() / SW.getHeight() > l.getEquipmentWidth(this.nZm) / l.getDimens(this.nZm, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.nZm);
                if (SW.getWidth() > 0) {
                    i2 = (int) ((i / SW.getWidth()) * SW.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.nZm, R.dimen.ds440);
                if (SW.getWidth() > 0) {
                    i = (int) ((dimens / SW.getHeight()) * SW.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.nGm.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.nGm.setLayoutParams(layoutParams);
            this.nGm.setImageBitmap(SW);
        }
    }

    private Bitmap SW(String str) {
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
        this.nZm.getLayoutMode().setNightMode(i == 1);
        this.nZm.getLayoutMode().onModeChanged(this.hbJ);
        this.mNavigationBar.onChangeSkinType(this.nZm.getPageContext(), i);
        SvgManager.btW().a(this.nZt, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.nZn, R.color.CAM_X0302, 1);
        ap.d(this.nZr, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
        this.nZB = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.nZB) {
            ap.setBackgroundResource(this.nZz, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.nZz, R.drawable.corner_bg_radio_unselected);
        }
        if (this.nZr != null) {
            this.nZr.onChangeSkinType(i);
        }
        if (this.nZq != null) {
            this.nZq.onChangeSkinType(i);
        }
        if (this.nZC != null) {
            this.nZC.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.nZo.getText() == null) {
            return null;
        }
        return this.nZo.getText().toString();
    }

    public long dZH() {
        if (this.nZo.getText() == null || this.nZo.getText().toString() == null) {
            return 0L;
        }
        return this.nZo.getText().length();
    }

    public WriteLocationView dZI() {
        return this.nZr;
    }

    public View dZJ() {
        return this.nZn;
    }

    public View getBackButton() {
        return this.nZt;
    }

    public EditText dZK() {
        return this.nZo;
    }

    public StateSwitchView dZL() {
        return this.nZq;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                VS(thumbPath);
                this.nGm.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nGm.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.nGm.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.nGj.setVideoPath(videoPath);
                this.nGj.start();
            }
        }
        if (!y.isEmpty(list)) {
            this.nZx.gq(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.nZo.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.nZx.gq(arrayList);
            this.nZo.setText("#" + videoTitleData.name + "#");
        }
    }

    public void dVp() {
        if (this.nGj != null) {
            this.nGj.resume();
            this.nGj.seekTo(this.nGt);
            this.nGj.start();
        }
    }

    public void cEV() {
        this.nGt = this.nGj.getCurrentPosition();
        if (this.nGj != null) {
            this.nGj.stopPlayback();
        }
    }

    public void VT(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.nZm.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.nZm.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dZM() {
        this.nZu.bn(null);
        this.nZu.zb(false);
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.nZu.bn(postWriteCallBackData.getSensitiveWords());
            this.nZu.VA(postWriteCallBackData.getErrorString());
            if (!y.isEmpty(this.nZu.dYm())) {
                zp(true);
            }
        }
    }

    public void zp(boolean z) {
        if (this.nZo.getText() != null) {
            int selectionEnd = this.nZo.getSelectionEnd();
            SpannableStringBuilder c = this.nZu.c(this.nZo.getText());
            if (c != null) {
                this.nZu.zc(true);
                this.nZo.setText(c);
                if (z && this.nZu.dYn() >= 0) {
                    this.nZo.requestFocus();
                    this.nZo.setSelection(this.nZu.dYn());
                } else {
                    this.nZo.setSelection(selectionEnd);
                }
                this.nZu.zb(this.nZu.dYn() >= 0);
            }
        }
    }

    public c dZN() {
        return this.nZu;
    }

    public void zq(boolean z) {
        if (z) {
            this.nZv.setVisibility(8);
            this.nZs.setVisibility(0);
            this.cKf.smoothScrollTo(0, this.nZs.getBottom());
        }
    }
}
