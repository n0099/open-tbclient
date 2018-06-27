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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.editor.StateSwitchView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static int hvQ = 31;
    private RelativeLayout bGX;
    private ScrollView dhv;
    private ImageView eXy;
    private CustomVideoView hfI;
    private ImageView hfL;
    private int hfS;
    private WriteVideoActivity hvR;
    private TextView hvS;
    private EditText hvT;
    private StateSwitchView hvU;
    private WriteLocationView hvV;
    private TextView hvW;
    private com.baidu.tieba.write.b hvX;
    private LinearLayout hvY;
    private ListView hvZ;
    private a hwa;
    private LinearLayout hwb;
    private TextView hwc;
    private TextView hwd;
    private TextView hwe;
    private boolean hwf = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.hvR = writeVideoActivity;
        this.hvR.setContentView(d.i.write_video_activity);
        this.hvX = new com.baidu.tieba.write.b();
        this.hvX.vj(d.C0142d.cp_cont_i);
        this.hvX.vk(d.C0142d.cp_cont_h_alpha85);
        bHZ();
        initView();
    }

    private void bHZ() {
        this.bGX = (RelativeLayout) this.hvR.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hvR.findViewById(d.g.navigation_bar);
        this.hvT = (EditText) this.hvR.findViewById(d.g.edit_content);
        this.hvW = (TextView) this.hvR.findViewById(d.g.text_content_size);
        this.hfL = (ImageView) this.hvR.findViewById(d.g.video_cover);
        this.hvV = (WriteLocationView) this.hvR.findViewById(d.g.location);
        this.hfI = (CustomVideoView) this.hvR.findViewById(d.g.preview_videoview);
        this.dhv = (ScrollView) this.hvR.findViewById(d.g.write_scrollview);
        this.hfI.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.hfI.getWidth() != b.this.hfL.getWidth() || b.this.hfI.getHeight() != b.this.hfL.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.hfL.getLayoutParams();
                    layoutParams.width = b.this.hfI.getWidth();
                    layoutParams.height = b.this.hfI.getHeight();
                    b.this.hfL.setLayoutParams(layoutParams);
                }
                b.this.hfL.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hfI.start();
                        b.this.hfL.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.hfI.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.bO(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hvY = (LinearLayout) this.hvR.findViewById(d.g.video_activity_title_container);
        this.hvZ = (ListView) this.hvR.findViewById(d.g.video_activity_title_list);
        this.hvZ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.hvY.setVisibility(8);
                b.this.hvW.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.hvT.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.hvT.requestFocus();
                    if (!TextUtils.isEmpty(b.this.hvT.getText())) {
                        b.this.hvT.setSelection(b.this.hvT.getText().length());
                    }
                    l.c(b.this.hvR, b.this.hvT);
                }
            }
        });
        this.hwb = (LinearLayout) this.hvR.findViewById(d.g.save_video_wrapper);
        this.hwc = (TextView) this.hvR.findViewById(d.g.save_video_ridiobutton);
        this.hwd = (TextView) this.hvR.findViewById(d.g.save_video_ridiotext);
        this.hwe = (TextView) this.hvR.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ah(this.hvR) / l.e(this.hvR, d.e.ds440)) {
            i3 = l.ah(this.hvR);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int e = l.e(this.hvR, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((e / i2) * i);
                i4 = e;
            } else {
                i3 = 0;
                i4 = e;
            }
        }
        this.hfI.setVideoHeight(i4);
        this.hfI.setVideoWidth(i3);
        this.hfI.invalidate();
    }

    private void initView() {
        this.eXy = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.nav_close_layout, this.hvR);
        this.mNavigationBar.setCenterTextTitle(this.hvR.getPageContext().getString(d.k.post_video_title));
        this.hvS = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.nav_text_send_layout, this.hvR);
        this.hvS.setText(d.k.send_post);
        this.hvT.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hvT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.hwa != null && b.this.hwa.getCount() > 0) {
                    l.b(b.this.hvR, b.this.hvT);
                    b.this.hvY.setVisibility(0);
                    b.this.hvW.setVisibility(8);
                }
                long bIb = b.hvQ - b.this.bIb();
                if (bIb >= 0) {
                    am.h(b.this.hvW, d.C0142d.cp_cont_e);
                    b.this.hvW.setText(String.valueOf(bIb));
                    return;
                }
                b.this.hvW.setText("0");
                b.this.hvT.setText(b.this.hvT.getText().toString().substring(0, b.hvQ));
                b.this.hvT.setSelection(b.this.hvT.getText().length());
                b.this.hvR.showToast(b.this.hvR.getResources().getString(d.k.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.hvX != null) {
                    if (!b.this.hvX.bGB()) {
                        b.this.nJ(false);
                    }
                    b.this.hvX.nA(false);
                }
            }
        });
        this.hwa = new a();
        this.hvZ.setAdapter((ListAdapter) this.hwa);
        this.hwf = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hwf) {
            am.i(this.hwc, d.f.corner_bg_radio_selected);
        } else {
            am.i(this.hwc, d.f.corner_bg_radio_unselected);
        }
        am.h(this.hwd, d.C0142d.cp_cont_g);
        this.hwb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.hwf) {
                    b.this.hwf = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    am.i(b.this.hwc, d.f.corner_bg_radio_unselected);
                    b.this.hwc.invalidate();
                    return;
                }
                b.this.hwf = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                am.i(b.this.hwc, d.f.corner_bg_radio_selected);
                b.this.hwc.invalidate();
            }
        });
    }

    public void bIa() {
        if (this.hwe != null) {
            this.hwe.setVisibility(0);
        }
    }

    public void vK(String str) {
        int i;
        int i2 = 0;
        Bitmap tl = tl(str);
        if (tl != null && tl.getHeight() != 0) {
            if (tl.getHeight() <= 0) {
                i = 0;
            } else if (tl.getWidth() / tl.getHeight() > l.ah(this.hvR) / l.e(this.hvR, d.e.ds440)) {
                i = l.ah(this.hvR);
                if (tl.getWidth() > 0) {
                    i2 = (int) ((i / tl.getWidth()) * tl.getHeight());
                }
            } else {
                int e = l.e(this.hvR, d.e.ds440);
                if (tl.getWidth() > 0) {
                    i = (int) ((e / tl.getHeight()) * tl.getWidth());
                    i2 = e;
                } else {
                    i = 0;
                    i2 = e;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hfL.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hfL.setLayoutParams(layoutParams);
            this.hfL.setImageBitmap(tl);
        }
    }

    private Bitmap tl(String str) {
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

    public void onChangeSkinType(int i) {
        this.hvR.getLayoutMode().setNightMode(i == 1);
        this.hvR.getLayoutMode().onModeChanged(this.bGX);
        this.mNavigationBar.onChangeSkinType(this.hvR.getPageContext(), i);
        am.c(this.eXy, d.f.icon_return_bg_s);
        am.c(this.hvS, d.C0142d.cp_link_tip_a, 1);
        am.i(this.hvV, d.f.corner_bg);
        am.h(this.hwe, d.C0142d.cp_cont_e);
        this.hwf = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hwf) {
            am.i(this.hwc, d.f.corner_bg_radio_selected);
        } else {
            am.i(this.hwc, d.f.corner_bg_radio_unselected);
        }
        if (this.hvV != null) {
            this.hvV.onChangeSkinType(i);
        }
        if (this.hvU != null) {
            this.hvU.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hvT.getText() == null) {
            return null;
        }
        return this.hvT.getText().toString();
    }

    public long bIb() {
        if (this.hvT.getText() == null || this.hvT.getText().toString() == null) {
            return 0L;
        }
        return this.hvT.getText().length();
    }

    public WriteLocationView bIc() {
        return this.hvV;
    }

    public View bId() {
        return this.hvS;
    }

    public View getBackButton() {
        return this.eXy;
    }

    public EditText bIe() {
        return this.hvT;
    }

    public StateSwitchView bIf() {
        return this.hvU;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                vK(thumbPath);
                this.hfL.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hfL.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hfL.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.hfI.setVideoPath(videoPath);
                this.hfI.start();
            }
        }
        if (!w.A(list)) {
            this.hwa.dV(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hvT.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hwa.dV(arrayList);
            this.hvT.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bDh() {
        if (this.hfI != null) {
            this.hfI.resume();
            this.hfI.seekTo(this.hfS);
            this.hfI.start();
        }
    }

    public void avA() {
        this.hfS = this.hfI.getCurrentPosition();
        if (this.hfI != null) {
            this.hfI.stopPlayback();
        }
    }

    public void vL(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hvR.getResources().getString(d.k.post_to_home_page));
            bIg();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hvR.getResources().getString(d.k.post_to) + str);
        bIh();
    }

    private void bIg() {
        this.hvU = new StateSwitchView(this.hvR);
        this.hvU.setStateString(this.hvR.getString(d.k.public_to_all), this.hvR.getString(d.k.public_to_me));
        this.hvU.setBackgroundId(d.f.state_switch_bg);
        this.hvU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hvU.aki();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.e(this.hvR, d.e.ds34), l.e(this.hvR, d.e.ds16));
        this.bGX.addView(this.hvU, layoutParams);
    }

    private void bIh() {
        this.hvU = new StateSwitchView(this.hvR);
        this.hvU.setStateString(this.hvR.getString(d.k.display_to_home_page), this.hvR.getString(d.k.display_to_home_page));
        this.hvU.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.hvU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hvU.aki();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.e(this.hvR, d.e.ds34), l.e(this.hvR, d.e.ds16));
        this.hvU.setTextSize(0, this.hvR.getResources().getDimensionPixelSize(d.e.ds28));
        this.bGX.addView(this.hvU, layoutParams);
    }

    public void bIi() {
        this.hvX.aB(null);
        this.hvX.nz(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hvX.aB(postWriteCallBackData.getSensitiveWords());
            this.hvX.vu(postWriteCallBackData.getErrorString());
            if (!w.A(this.hvX.bGy())) {
                nJ(true);
            }
        }
    }

    public void nJ(boolean z) {
        if (this.hvT.getText() != null) {
            int selectionEnd = this.hvT.getSelectionEnd();
            SpannableStringBuilder b = this.hvX.b(this.hvT.getText());
            if (b != null) {
                this.hvX.nA(true);
                this.hvT.setText(b);
                if (z && this.hvX.bGz() >= 0) {
                    this.hvT.requestFocus();
                    this.hvT.setSelection(this.hvX.bGz());
                } else {
                    this.hvT.setSelection(selectionEnd);
                }
                this.hvX.nz(this.hvX.bGz() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bIj() {
        return this.hvX;
    }

    public void nK(boolean z) {
        if (z) {
            this.hvY.setVisibility(8);
            this.hvW.setVisibility(0);
            this.dhv.smoothScrollTo(0, this.hvW.getBottom());
        }
    }
}
