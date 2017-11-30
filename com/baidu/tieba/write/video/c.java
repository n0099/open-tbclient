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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.CustomVideoView;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.editor.StateSwitchView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    public static int hfz = 31;
    private RelativeLayout bvu;
    private ScrollView cFu;
    private ImageView etW;
    private CustomVideoView gSf;
    private ImageView gSi;
    private int gSp;
    private WriteVideoActivity hfA;
    private TextView hfB;
    private EditText hfC;
    private StateSwitchView hfD;
    private WriteLocationView hfE;
    private TextView hfF;
    private com.baidu.tieba.write.b hfG;
    private LinearLayout hfH;
    private ListView hfI;
    private b hfJ;
    private LinearLayout hfK;
    private TextView hfL;
    private TextView hfM;
    private boolean hfN = true;
    private NavigationBar mNavigationBar;

    public c(WriteVideoActivity writeVideoActivity) {
        this.hfA = writeVideoActivity;
        this.hfA.setContentView(d.h.write_video_activity);
        this.hfG = new com.baidu.tieba.write.b();
        this.hfG.vA(d.C0082d.cp_cont_i);
        this.hfG.vB(d.C0082d.cp_cont_h_alpha85);
        bGq();
        initView();
    }

    private void bGq() {
        this.bvu = (RelativeLayout) this.hfA.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hfA.findViewById(d.g.navigation_bar);
        this.hfC = (EditText) this.hfA.findViewById(d.g.edit_content);
        this.hfF = (TextView) this.hfA.findViewById(d.g.text_content_size);
        this.gSi = (ImageView) this.hfA.findViewById(d.g.video_cover);
        this.hfE = (WriteLocationView) this.hfA.findViewById(d.g.location);
        this.gSf = (CustomVideoView) this.hfA.findViewById(d.g.preview_videoview);
        this.cFu = (ScrollView) this.hfA.findViewById(d.g.write_scrollview);
        this.gSf.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.c.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (c.this.gSf.getWidth() != c.this.gSi.getWidth() || c.this.gSf.getHeight() != c.this.gSi.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = c.this.gSi.getLayoutParams();
                    layoutParams.width = c.this.gSf.getWidth();
                    layoutParams.height = c.this.gSf.getHeight();
                    c.this.gSi.setLayoutParams(layoutParams);
                }
                c.this.gSi.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.gSf.start();
                        c.this.gSi.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.gSf.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.c.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                c.this.cc(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hfH = (LinearLayout) this.hfA.findViewById(d.g.video_activity_title_container);
        this.hfI = (ListView) this.hfA.findViewById(d.g.video_activity_title_list);
        this.hfI.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.hfH.setVisibility(8);
                c.this.hfF.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    c.this.hfC.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    c.this.hfC.requestFocus();
                    if (!TextUtils.isEmpty(c.this.hfC.getText())) {
                        c.this.hfC.setSelection(c.this.hfC.getText().length());
                    }
                    l.b(c.this.hfA, c.this.hfC);
                }
            }
        });
        this.hfK = (LinearLayout) this.hfA.findViewById(d.g.save_video_wrapper);
        this.hfL = (TextView) this.hfA.findViewById(d.g.save_video_ridiobutton);
        this.hfM = (TextView) this.hfA.findViewById(d.g.save_video_ridiotext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ac(this.hfA) / l.f(this.hfA, d.e.ds440)) {
            i3 = l.ac(this.hfA);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.hfA, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.gSf.setVideoHeight(i4);
        this.gSf.setVideoWidth(i3);
        this.gSf.invalidate();
    }

    private void initView() {
        this.etW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.hfA);
        this.mNavigationBar.setCenterTextTitle(this.hfA.getPageContext().getString(d.j.post_video_title));
        this.hfB = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.hfA);
        this.hfB.setText(d.j.send_post);
        this.hfC.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.c.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hfC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.c.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && c.this.hfJ != null && c.this.hfJ.getCount() > 0) {
                    l.a(c.this.hfA, c.this.hfC);
                    c.this.hfH.setVisibility(0);
                    c.this.hfF.setVisibility(8);
                }
                long bGr = c.hfz - c.this.bGr();
                if (bGr >= 0) {
                    aj.i(c.this.hfF, d.C0082d.cp_cont_e);
                    c.this.hfF.setText(String.valueOf(bGr));
                    return;
                }
                c.this.hfF.setText("0");
                c.this.hfC.setText(c.this.hfC.getText().toString().substring(0, c.hfz));
                c.this.hfC.setSelection(c.this.hfC.getText().length());
                c.this.hfA.showToast(c.this.hfA.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (c.this.hfG != null) {
                    if (!c.this.hfG.bEV()) {
                        c.this.oa(false);
                    }
                    c.this.hfG.nT(false);
                }
            }
        });
        this.hfJ = new b();
        this.hfI.setAdapter((ListAdapter) this.hfJ);
        this.hfN = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hfN) {
            aj.j(this.hfL, d.f.corner_bg_radio_selected);
        } else {
            aj.j(this.hfL, d.f.corner_bg_radio_unselected);
        }
        aj.i(this.hfM, d.C0082d.cp_cont_g);
        this.hfK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hfN) {
                    c.this.hfN = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    aj.j(c.this.hfL, d.f.corner_bg_radio_unselected);
                    c.this.hfL.invalidate();
                    return;
                }
                c.this.hfN = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                aj.j(c.this.hfL, d.f.corner_bg_radio_selected);
                c.this.hfL.invalidate();
            }
        });
    }

    public void uJ(String str) {
        int i;
        int i2 = 0;
        Bitmap sl = sl(str);
        if (sl != null && sl.getHeight() != 0) {
            if (sl.getHeight() <= 0) {
                i = 0;
            } else if (sl.getWidth() / sl.getHeight() > l.ac(this.hfA) / l.f(this.hfA, d.e.ds440)) {
                i = l.ac(this.hfA);
                if (sl.getWidth() > 0) {
                    i2 = (int) ((i / sl.getWidth()) * sl.getHeight());
                }
            } else {
                int f = l.f(this.hfA, d.e.ds440);
                if (sl.getWidth() > 0) {
                    i = (int) ((f / sl.getHeight()) * sl.getWidth());
                    i2 = f;
                } else {
                    i = 0;
                    i2 = f;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.gSi.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.gSi.setLayoutParams(layoutParams);
            this.gSi.setImageBitmap(sl);
        }
    }

    private Bitmap sl(String str) {
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
        this.hfA.getLayoutMode().ag(i == 1);
        this.hfA.getLayoutMode().t(this.bvu);
        this.mNavigationBar.onChangeSkinType(this.hfA.getPageContext(), i);
        aj.c(this.etW, d.f.icon_return_bg_s);
        aj.c(this.hfB, d.C0082d.cp_link_tip_a, 1);
        aj.j(this.hfE, d.f.corner_bg);
        this.hfN = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hfN) {
            aj.j(this.hfL, d.f.corner_bg_radio_selected);
        } else {
            aj.j(this.hfL, d.f.corner_bg_radio_unselected);
        }
        if (this.hfE != null) {
            this.hfE.onChangeSkinType(i);
        }
        if (this.hfD != null) {
            this.hfD.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hfC.getText() == null) {
            return null;
        }
        return this.hfC.getText().toString();
    }

    public long bGr() {
        if (this.hfC.getText() == null || this.hfC.getText().toString() == null) {
            return 0L;
        }
        return this.hfC.getText().length();
    }

    public WriteLocationView bGs() {
        return this.hfE;
    }

    public View bGt() {
        return this.hfB;
    }

    public View getBackButton() {
        return this.etW;
    }

    public EditText bGu() {
        return this.hfC;
    }

    public StateSwitchView bGv() {
        return this.hfD;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                uJ(thumbPath);
                this.gSi.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.7
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.gSi.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.gSi.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.gSf.setVideoPath(videoPath);
                this.gSf.start();
            }
        }
        if (!v.w(list)) {
            this.hfJ.dY(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hfC.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hfJ.dY(arrayList);
            this.hfC.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bCi() {
        if (this.gSf != null) {
            this.gSf.resume();
            this.gSf.seekTo(this.gSp);
            this.gSf.start();
        }
    }

    public void amD() {
        this.gSp = this.gSf.getCurrentPosition();
        if (this.gSf != null) {
            this.gSf.stopPlayback();
        }
    }

    public void uK(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hfA.getResources().getString(d.j.post_to_home_page));
            bGw();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hfA.getResources().getString(d.j.post_to) + str);
        bGx();
    }

    private void bGw() {
        this.hfD = new StateSwitchView(this.hfA);
        this.hfD.cp(this.hfA.getString(d.j.public_to_all), this.hfA.getString(d.j.public_to_me));
        this.hfD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hfD.bGa();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.f(this.hfA, d.e.ds34), l.f(this.hfA, d.e.ds16));
        this.bvu.addView(this.hfD, layoutParams);
    }

    private void bGx() {
        this.hfD = new StateSwitchView(this.hfA);
        this.hfD.cp(this.hfA.getString(d.j.display_to_home_page), this.hfA.getString(d.j.display_to_home_page));
        this.hfD.cg(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.hfD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hfD.bGa();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.f(this.hfA, d.e.ds34), l.f(this.hfA, d.e.ds16));
        this.bvu.addView(this.hfD, layoutParams);
    }

    public void bGy() {
        this.hfG.aB(null);
        this.hfG.nS(false);
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hfG.aB(postWriteCallBackData.getSensitiveWords());
            this.hfG.uw(postWriteCallBackData.getErrorString());
            if (!v.w(this.hfG.bES())) {
                oa(true);
            }
        }
    }

    public void oa(boolean z) {
        if (this.hfC.getText() != null) {
            int selectionEnd = this.hfC.getSelectionEnd();
            SpannableStringBuilder b = this.hfG.b(this.hfC.getText());
            if (b != null) {
                this.hfG.nT(true);
                this.hfC.setText(b);
                if (z && this.hfG.bET() >= 0) {
                    this.hfC.requestFocus();
                    this.hfC.setSelection(this.hfG.bET());
                } else {
                    this.hfC.setSelection(selectionEnd);
                }
                this.hfG.nS(this.hfG.bET() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bGz() {
        return this.hfG;
    }

    public void ob(boolean z) {
        if (z) {
            this.hfH.setVisibility(8);
            this.hfF.setVisibility(0);
            this.cFu.smoothScrollTo(0, this.hfF.getBottom());
        }
    }
}
