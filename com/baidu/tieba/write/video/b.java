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
    public static int nZn = 60;
    private ScrollView cKf;
    private RelativeLayout hbL;
    private NavigationBar mNavigationBar;
    private TextView mTitle;
    private CustomVideoView nGl;
    private ImageView nGo;
    private int nGv;
    private LinearLayout nZA;
    private TextView nZB;
    private TextView nZC;
    private ForumTabSelectedView nZE;
    private WriteVideoActivity nZo;
    private TextView nZp;
    private EditText nZq;
    private StateSwitchView nZr;
    private StateSwitchView nZs;
    private WriteLocationView nZt;
    private TextView nZu;
    private ImageView nZv;
    private c nZw;
    private LinearLayout nZx;
    private ListView nZy;
    private a nZz;
    private boolean nZD = true;
    private boolean nZi = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.nZo = writeVideoActivity;
        this.nZo.setContentView(R.layout.write_video_activity);
        this.nZw = new c();
        this.nZw.MB(R.color.CAM_X0101);
        this.nZw.MC(R.color.cp_cont_h_alpha85);
        Jh();
        initView();
    }

    public void zo(boolean z) {
        this.nZi = z;
        if (z) {
            if (this.nZs != null) {
                this.nZs.setVisibility(8);
            }
            if (this.nZt != null) {
                this.nZt.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.nZo.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void Jh() {
        this.hbL = (RelativeLayout) this.nZo.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.nZo.findViewById(R.id.navigation_bar);
        this.nZq = (EditText) this.nZo.findViewById(R.id.edit_content);
        this.nZu = (TextView) this.nZo.findViewById(R.id.text_content_size);
        this.nGo = (ImageView) this.nZo.findViewById(R.id.video_cover);
        this.nGl = (CustomVideoView) this.nZo.findViewById(R.id.preview_videoview);
        this.cKf = (ScrollView) this.nZo.findViewById(R.id.write_scrollview);
        this.nGl.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.nGl.getWidth() != b.this.nGo.getWidth() || b.this.nGl.getHeight() != b.this.nGo.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.nGo.getLayoutParams();
                    layoutParams.width = b.this.nGl.getWidth();
                    layoutParams.height = b.this.nGl.getHeight();
                    b.this.nGo.setLayoutParams(layoutParams);
                }
                b.this.nGo.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nGl.start();
                        b.this.nGo.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.nGl.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.dF(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.nZx = (LinearLayout) this.nZo.findViewById(R.id.video_activity_title_container);
        this.nZy = (ListView) this.nZo.findViewById(R.id.video_activity_title_list);
        this.nZy.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.nZx.setVisibility(8);
                b.this.nZu.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.nZq.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.nZq.requestFocus();
                    if (!TextUtils.isEmpty(b.this.nZq.getText())) {
                        b.this.nZq.setSelection(b.this.nZq.getText().length());
                    }
                    l.showSoftKeyPad(b.this.nZo, b.this.nZq);
                }
            }
        });
        this.nZA = (LinearLayout) this.nZo.findViewById(R.id.save_video_wrapper);
        this.nZB = (TextView) this.nZo.findViewById(R.id.save_video_ridiobutton);
        this.nZC = (TextView) this.nZo.findViewById(R.id.save_video_ridiotext);
        this.nZt = (WriteLocationView) this.nZo.findViewById(R.id.location);
        this.nZs = (StateSwitchView) this.nZo.findViewById(R.id.view_privacy);
        this.nZs.setStateString(this.nZo.getString(R.string.display_on_my_home_page), this.nZo.getString(R.string.display_on_my_home_page));
        this.nZs.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.CAM_X0106));
        this.nZs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.nZs.bhC();
            }
        });
        this.nZs.setTextSize(0, this.nZo.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void c(FrsTabInfoData frsTabInfoData) {
        this.nZE = (ForumTabSelectedView) this.nZo.findViewById(R.id.frs_tab_list);
        this.nZE.setData(frsTabInfoData);
        this.nZE.setActivity(this.nZo);
    }

    public ForumTabSelectedView dZH() {
        return this.nZE;
    }

    public boolean isToDynamic() {
        return this.nZr != null && this.nZr.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.nZo) / l.getDimens(this.nZo, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.nZo);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.nZo, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.nGl.setVideoHeight(i4);
        this.nGl.setVideoWidth(i3);
        this.nGl.invalidate();
    }

    private void initView() {
        this.nZv = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.nZo);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.nZo.getPageContext().getString(R.string.post_video_title));
        if (this.nZi) {
            this.mTitle.setText(this.nZo.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.nZp = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.nZo);
        this.nZp.setText(R.string.send_post);
        this.nZq.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.nZq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.nZz != null && b.this.nZz.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.nZo, b.this.nZq);
                    b.this.nZx.setVisibility(0);
                    b.this.nZu.setVisibility(8);
                }
                long dZI = b.nZn - b.this.dZI();
                if (dZI >= 0) {
                    ap.setViewTextColor(b.this.nZu, R.color.CAM_X0110);
                    b.this.nZu.setText(String.valueOf(dZI));
                    return;
                }
                b.this.nZu.setText("0");
                b.this.nZq.setText(b.this.nZq.getText().toString().substring(0, b.nZn));
                b.this.nZq.setSelection(b.this.nZq.getText().length());
                b.this.nZo.showToast(b.this.nZo.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.nZw != null) {
                    if (!b.this.nZw.dYq()) {
                        b.this.zp(false);
                    }
                    b.this.nZw.zc(false);
                }
            }
        });
        this.nZz = new a();
        this.nZy.setAdapter((ListAdapter) this.nZz);
        this.nZD = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.nZD) {
            ap.setBackgroundResource(this.nZB, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.nZB, R.drawable.corner_bg_radio_unselected);
        }
        ap.setViewTextColor(this.nZC, R.color.CAM_X0111);
        this.nZA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.nZD) {
                    b.this.nZD = false;
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    ap.setBackgroundResource(b.this.nZB, R.drawable.corner_bg_radio_unselected);
                    b.this.nZB.invalidate();
                    return;
                }
                b.this.nZD = true;
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                ap.setBackgroundResource(b.this.nZB, R.drawable.corner_bg_radio_selected);
                b.this.nZB.invalidate();
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
            } else if (SW.getWidth() / SW.getHeight() > l.getEquipmentWidth(this.nZo) / l.getDimens(this.nZo, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.nZo);
                if (SW.getWidth() > 0) {
                    i2 = (int) ((i / SW.getWidth()) * SW.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.nZo, R.dimen.ds440);
                if (SW.getWidth() > 0) {
                    i = (int) ((dimens / SW.getHeight()) * SW.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.nGo.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.nGo.setLayoutParams(layoutParams);
            this.nGo.setImageBitmap(SW);
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
        this.nZo.getLayoutMode().setNightMode(i == 1);
        this.nZo.getLayoutMode().onModeChanged(this.hbL);
        this.mNavigationBar.onChangeSkinType(this.nZo.getPageContext(), i);
        SvgManager.btW().a(this.nZv, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.nZp, R.color.CAM_X0302, 1);
        ap.d(this.nZt, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
        this.nZD = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.nZD) {
            ap.setBackgroundResource(this.nZB, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.nZB, R.drawable.corner_bg_radio_unselected);
        }
        if (this.nZt != null) {
            this.nZt.onChangeSkinType(i);
        }
        if (this.nZs != null) {
            this.nZs.onChangeSkinType(i);
        }
        if (this.nZE != null) {
            this.nZE.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.nZq.getText() == null) {
            return null;
        }
        return this.nZq.getText().toString();
    }

    public long dZI() {
        if (this.nZq.getText() == null || this.nZq.getText().toString() == null) {
            return 0L;
        }
        return this.nZq.getText().length();
    }

    public WriteLocationView dZJ() {
        return this.nZt;
    }

    public View dZK() {
        return this.nZp;
    }

    public View getBackButton() {
        return this.nZv;
    }

    public EditText dZL() {
        return this.nZq;
    }

    public StateSwitchView dZM() {
        return this.nZs;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                VS(thumbPath);
                this.nGo.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nGo.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.nGo.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.nGl.setVideoPath(videoPath);
                this.nGl.start();
            }
        }
        if (!y.isEmpty(list)) {
            this.nZz.gq(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.nZq.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.nZz.gq(arrayList);
            this.nZq.setText("#" + videoTitleData.name + "#");
        }
    }

    public void dVq() {
        if (this.nGl != null) {
            this.nGl.resume();
            this.nGl.seekTo(this.nGv);
            this.nGl.start();
        }
    }

    public void cEW() {
        this.nGv = this.nGl.getCurrentPosition();
        if (this.nGl != null) {
            this.nGl.stopPlayback();
        }
    }

    public void VT(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.nZo.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.nZo.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dZN() {
        this.nZw.bn(null);
        this.nZw.zb(false);
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.nZw.bn(postWriteCallBackData.getSensitiveWords());
            this.nZw.VA(postWriteCallBackData.getErrorString());
            if (!y.isEmpty(this.nZw.dYn())) {
                zp(true);
            }
        }
    }

    public void zp(boolean z) {
        if (this.nZq.getText() != null) {
            int selectionEnd = this.nZq.getSelectionEnd();
            SpannableStringBuilder c = this.nZw.c(this.nZq.getText());
            if (c != null) {
                this.nZw.zc(true);
                this.nZq.setText(c);
                if (z && this.nZw.dYo() >= 0) {
                    this.nZq.requestFocus();
                    this.nZq.setSelection(this.nZw.dYo());
                } else {
                    this.nZq.setSelection(selectionEnd);
                }
                this.nZw.zb(this.nZw.dYo() >= 0);
            }
        }
    }

    public c dZO() {
        return this.nZw;
    }

    public void zq(boolean z) {
        if (z) {
            this.nZx.setVisibility(8);
            this.nZu.setVisibility(0);
            this.cKf.smoothScrollTo(0, this.nZu.getBottom());
        }
    }
}
