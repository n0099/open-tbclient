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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.f.d;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.editor.StateSwitchView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static int jUr = 60;
    private ScrollView bcE;
    private RelativeLayout dGr;
    private CustomVideoView jCp;
    private ImageView jCs;
    private int jCz;
    private LinearLayout jUA;
    private ListView jUB;
    private a jUC;
    private LinearLayout jUD;
    private TextView jUE;
    private TextView jUF;
    private TextView jUG;
    private boolean jUH = true;
    private WriteVideoActivity jUs;
    private TextView jUt;
    private EditText jUu;
    private StateSwitchView jUv;
    private WriteLocationView jUw;
    private TextView jUx;
    private ImageView jUy;
    private com.baidu.tieba.write.b jUz;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.jUs = writeVideoActivity;
        this.jUs.setContentView(R.layout.write_video_activity);
        this.jUz = new com.baidu.tieba.write.b();
        this.jUz.CO(R.color.cp_cont_a);
        this.jUz.CP(R.color.cp_cont_h_alpha85);
        cCc();
        initView();
    }

    private void cCc() {
        this.dGr = (RelativeLayout) this.jUs.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.jUs.findViewById(R.id.navigation_bar);
        this.jUu = (EditText) this.jUs.findViewById(R.id.edit_content);
        this.jUx = (TextView) this.jUs.findViewById(R.id.text_content_size);
        this.jCs = (ImageView) this.jUs.findViewById(R.id.video_cover);
        this.jUw = (WriteLocationView) this.jUs.findViewById(R.id.location);
        this.jCp = (CustomVideoView) this.jUs.findViewById(R.id.preview_videoview);
        this.bcE = (ScrollView) this.jUs.findViewById(R.id.write_scrollview);
        this.jCp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.jCp.getWidth() != b.this.jCs.getWidth() || b.this.jCp.getHeight() != b.this.jCs.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.jCs.getLayoutParams();
                    layoutParams.width = b.this.jCp.getWidth();
                    layoutParams.height = b.this.jCp.getHeight();
                    b.this.jCs.setLayoutParams(layoutParams);
                }
                b.this.jCs.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jCp.start();
                        b.this.jCs.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.jCp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cF(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.jUA = (LinearLayout) this.jUs.findViewById(R.id.video_activity_title_container);
        this.jUB = (ListView) this.jUs.findViewById(R.id.video_activity_title_list);
        this.jUB.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.jUA.setVisibility(8);
                b.this.jUx.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.jUu.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.jUu.requestFocus();
                    if (!TextUtils.isEmpty(b.this.jUu.getText())) {
                        b.this.jUu.setSelection(b.this.jUu.getText().length());
                    }
                    l.c(b.this.jUs, b.this.jUu);
                }
            }
        });
        this.jUD = (LinearLayout) this.jUs.findViewById(R.id.save_video_wrapper);
        this.jUE = (TextView) this.jUs.findViewById(R.id.save_video_ridiobutton);
        this.jUF = (TextView) this.jUs.findViewById(R.id.save_video_ridiotext);
        this.jUG = (TextView) this.jUs.findViewById(R.id.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.af(this.jUs) / l.g(this.jUs, R.dimen.ds440)) {
            i3 = l.af(this.jUs);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int g = l.g(this.jUs, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((g / i2) * i);
                i4 = g;
            } else {
                i3 = 0;
                i4 = g;
            }
        }
        this.jCp.setVideoHeight(i4);
        this.jCp.setVideoWidth(i3);
        this.jCp.invalidate();
    }

    private void initView() {
        this.jUy = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.jUs);
        this.mNavigationBar.setCenterTextTitle(this.jUs.getPageContext().getString(R.string.post_video_title));
        this.jUt = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.jUs);
        this.jUt.setText(R.string.send_post);
        this.jUu.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.jUu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.jUC != null && b.this.jUC.getCount() > 0) {
                    l.b(b.this.jUs, b.this.jUu);
                    b.this.jUA.setVisibility(0);
                    b.this.jUx.setVisibility(8);
                }
                long cCe = b.jUr - b.this.cCe();
                if (cCe >= 0) {
                    am.j(b.this.jUx, R.color.cp_cont_e);
                    b.this.jUx.setText(String.valueOf(cCe));
                    return;
                }
                b.this.jUx.setText("0");
                b.this.jUu.setText(b.this.jUu.getText().toString().substring(0, b.jUr));
                b.this.jUu.setSelection(b.this.jUu.getText().length());
                b.this.jUs.showToast(b.this.jUs.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.jUz != null) {
                    if (!b.this.jUz.cAq()) {
                        b.this.sn(false);
                    }
                    b.this.jUz.se(false);
                }
            }
        });
        this.jUC = new a();
        this.jUB.setAdapter((ListAdapter) this.jUC);
        this.jUH = com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("write_video_activity_save_video", true);
        if (this.jUH) {
            am.k(this.jUE, R.drawable.corner_bg_radio_selected);
        } else {
            am.k(this.jUE, R.drawable.corner_bg_radio_unselected);
        }
        am.j(this.jUF, R.color.cp_cont_g);
        this.jUD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.jUH) {
                    b.this.jUH = false;
                    com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("write_video_activity_save_video", false);
                    am.k(b.this.jUE, R.drawable.corner_bg_radio_unselected);
                    b.this.jUE.invalidate();
                    return;
                }
                b.this.jUH = true;
                com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("write_video_activity_save_video", true);
                am.k(b.this.jUE, R.drawable.corner_bg_radio_selected);
                b.this.jUE.invalidate();
            }
        });
    }

    public void cCd() {
        if (this.jUG != null) {
            this.jUG.setVisibility(0);
        }
    }

    public void Ht(String str) {
        int i;
        int i2 = 0;
        Bitmap EL = EL(str);
        if (EL != null && EL.getHeight() != 0) {
            if (EL.getHeight() <= 0) {
                i = 0;
            } else if (EL.getWidth() / EL.getHeight() > l.af(this.jUs) / l.g(this.jUs, R.dimen.ds440)) {
                i = l.af(this.jUs);
                if (EL.getWidth() > 0) {
                    i2 = (int) ((i / EL.getWidth()) * EL.getHeight());
                }
            } else {
                int g = l.g(this.jUs, R.dimen.ds440);
                if (EL.getWidth() > 0) {
                    i = (int) ((g / EL.getHeight()) * EL.getWidth());
                    i2 = g;
                } else {
                    i = 0;
                    i2 = g;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jCs.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.jCs.setLayoutParams(layoutParams);
            this.jCs.setImageBitmap(EL);
        }
    }

    private Bitmap EL(String str) {
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
        this.jUs.getLayoutMode().setNightMode(i == 1);
        this.jUs.getLayoutMode().onModeChanged(this.dGr);
        this.mNavigationBar.onChangeSkinType(this.jUs.getPageContext(), i);
        SvgManager.ajv().a(this.jUy, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.f(this.jUt, R.color.cp_link_tip_a, 1);
        am.k(this.jUw, R.drawable.corner_bg);
        am.j(this.jUG, R.color.cp_cont_e);
        this.jUH = com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("write_video_activity_save_video", true);
        if (this.jUH) {
            am.k(this.jUE, R.drawable.corner_bg_radio_selected);
        } else {
            am.k(this.jUE, R.drawable.corner_bg_radio_unselected);
        }
        if (this.jUw != null) {
            this.jUw.onChangeSkinType(i);
        }
        if (this.jUv != null) {
            this.jUv.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.jUu.getText() == null) {
            return null;
        }
        return this.jUu.getText().toString();
    }

    public long cCe() {
        if (this.jUu.getText() == null || this.jUu.getText().toString() == null) {
            return 0L;
        }
        return this.jUu.getText().length();
    }

    public WriteLocationView cCf() {
        return this.jUw;
    }

    public View cCg() {
        return this.jUt;
    }

    public View getBackButton() {
        return this.jUy;
    }

    public EditText cCh() {
        return this.jUu;
    }

    public StateSwitchView cCi() {
        return this.jUv;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                Ht(thumbPath);
                this.jCs.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.jCs.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.jCs.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.jCp.setVideoPath(videoPath);
                this.jCp.start();
            }
        }
        if (!v.aa(list)) {
            this.jUC.ey(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.jUu.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.jUC.ey(arrayList);
            this.jUu.setText("#" + videoTitleData.name + "#");
        }
    }

    public void cwy() {
        if (this.jCp != null) {
            this.jCp.resume();
            this.jCp.seekTo(this.jCz);
            this.jCp.start();
        }
    }

    public void bpe() {
        this.jCz = this.jCp.getCurrentPosition();
        if (this.jCp != null) {
            this.jCp.stopPlayback();
        }
    }

    public void Hu(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.jUs.getResources().getString(R.string.post_to_home_page));
            cCj();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.jUs.getResources().getString(R.string.post_to) + str);
        cCk();
    }

    private void cCj() {
        this.jUv = new StateSwitchView(this.jUs);
        this.jUv.setStateString(this.jUs.getString(R.string.public_to_all), this.jUs.getString(R.string.public_to_me));
        am.g(this.jUv, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.jUv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jUv.aHw();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.g(this.jUs, R.dimen.ds34), l.g(this.jUs, R.dimen.ds16));
        this.dGr.addView(this.jUv, layoutParams);
    }

    private void cCk() {
        this.jUv = new StateSwitchView(this.jUs);
        this.jUv.setStateString(this.jUs.getString(R.string.display_to_home_page), this.jUs.getString(R.string.display_to_home_page));
        this.jUv.setLeftStateDrawable(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_stroke1_blue_h_svg), new d(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.jUv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jUv.aHw();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.g(this.jUs, R.dimen.ds34), l.g(this.jUs, R.dimen.ds16));
        this.jUv.setTextSize(0, this.jUs.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.dGr.addView(this.jUv, layoutParams);
    }

    public void cCl() {
        this.jUz.aI(null);
        this.jUz.sd(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jUz.aI(postWriteCallBackData.getSensitiveWords());
            this.jUz.Hb(postWriteCallBackData.getErrorString());
            if (!v.aa(this.jUz.cAn())) {
                sn(true);
            }
        }
    }

    public void sn(boolean z) {
        if (this.jUu.getText() != null) {
            int selectionEnd = this.jUu.getSelectionEnd();
            SpannableStringBuilder b = this.jUz.b(this.jUu.getText());
            if (b != null) {
                this.jUz.se(true);
                this.jUu.setText(b);
                if (z && this.jUz.cAo() >= 0) {
                    this.jUu.requestFocus();
                    this.jUu.setSelection(this.jUz.cAo());
                } else {
                    this.jUu.setSelection(selectionEnd);
                }
                this.jUz.sd(this.jUz.cAo() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b cCm() {
        return this.jUz;
    }

    public void so(boolean z) {
        if (z) {
            this.jUA.setVisibility(8);
            this.jUx.setVisibility(0);
            this.bcE.smoothScrollTo(0, this.jUx.getBottom());
        }
    }
}
