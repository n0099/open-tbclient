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
    public static int hGg = 31;
    private RelativeLayout ciJ;
    private ScrollView dzw;
    private ImageView fiF;
    private WriteVideoActivity hGh;
    private TextView hGi;
    private EditText hGj;
    private StateSwitchView hGk;
    private WriteLocationView hGl;
    private TextView hGm;
    private com.baidu.tieba.write.b hGn;
    private LinearLayout hGo;
    private ListView hGp;
    private b hGq;
    private LinearLayout hGr;
    private TextView hGs;
    private TextView hGt;
    private TextView hGu;
    private boolean hGv = true;
    private CustomVideoView hrA;
    private ImageView hrD;
    private int hrK;
    private NavigationBar mNavigationBar;

    public c(WriteVideoActivity writeVideoActivity) {
        this.hGh = writeVideoActivity;
        this.hGh.setContentView(d.h.write_video_activity);
        this.hGn = new com.baidu.tieba.write.b();
        this.hGn.xg(d.C0107d.cp_cont_i);
        this.hGn.xh(d.C0107d.cp_cont_h_alpha85);
        bGp();
        initView();
    }

    private void bGp() {
        this.ciJ = (RelativeLayout) this.hGh.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.hGh.findViewById(d.g.navigation_bar);
        this.hGj = (EditText) this.hGh.findViewById(d.g.edit_content);
        this.hGm = (TextView) this.hGh.findViewById(d.g.text_content_size);
        this.hrD = (ImageView) this.hGh.findViewById(d.g.video_cover);
        this.hGl = (WriteLocationView) this.hGh.findViewById(d.g.location);
        this.hrA = (CustomVideoView) this.hGh.findViewById(d.g.preview_videoview);
        this.dzw = (ScrollView) this.hGh.findViewById(d.g.write_scrollview);
        this.hrA.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.c.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (c.this.hrA.getWidth() != c.this.hrD.getWidth() || c.this.hrA.getHeight() != c.this.hrD.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = c.this.hrD.getLayoutParams();
                    layoutParams.width = c.this.hrA.getWidth();
                    layoutParams.height = c.this.hrA.getHeight();
                    c.this.hrD.setLayoutParams(layoutParams);
                }
                c.this.hrD.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.hrA.start();
                        c.this.hrD.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.hrA.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.c.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                c.this.cT(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.hGo = (LinearLayout) this.hGh.findViewById(d.g.video_activity_title_container);
        this.hGp = (ListView) this.hGh.findViewById(d.g.video_activity_title_list);
        this.hGp.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.hGo.setVisibility(8);
                c.this.hGm.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    c.this.hGj.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    c.this.hGj.requestFocus();
                    if (!TextUtils.isEmpty(c.this.hGj.getText())) {
                        c.this.hGj.setSelection(c.this.hGj.getText().length());
                    }
                    l.b(c.this.hGh, c.this.hGj);
                }
            }
        });
        this.hGr = (LinearLayout) this.hGh.findViewById(d.g.save_video_wrapper);
        this.hGs = (TextView) this.hGh.findViewById(d.g.save_video_ridiobutton);
        this.hGt = (TextView) this.hGh.findViewById(d.g.save_video_ridiotext);
        this.hGu = (TextView) this.hGh.findViewById(d.g.display_in_nani_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ao(this.hGh) / l.s(this.hGh, d.e.ds440)) {
            i3 = l.ao(this.hGh);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int s = l.s(this.hGh, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((s / i2) * i);
                i4 = s;
            } else {
                i3 = 0;
                i4 = s;
            }
        }
        this.hrA.setVideoHeight(i4);
        this.hrA.setVideoWidth(i3);
        this.hrA.invalidate();
    }

    private void initView() {
        this.fiF = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.hGh);
        this.mNavigationBar.setCenterTextTitle(this.hGh.getPageContext().getString(d.j.post_video_title));
        this.hGi = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.hGh);
        this.hGi.setText(d.j.send_post);
        this.hGj.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.c.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.hGj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.c.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && c.this.hGq != null && c.this.hGq.getCount() > 0) {
                    l.a(c.this.hGh, c.this.hGj);
                    c.this.hGo.setVisibility(0);
                    c.this.hGm.setVisibility(8);
                }
                long bGr = c.hGg - c.this.bGr();
                if (bGr >= 0) {
                    aj.r(c.this.hGm, d.C0107d.cp_cont_e);
                    c.this.hGm.setText(String.valueOf(bGr));
                    return;
                }
                c.this.hGm.setText("0");
                c.this.hGj.setText(c.this.hGj.getText().toString().substring(0, c.hGg));
                c.this.hGj.setSelection(c.this.hGj.getText().length());
                c.this.hGh.showToast(c.this.hGh.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (c.this.hGn != null) {
                    if (!c.this.hGn.bEP()) {
                        c.this.nz(false);
                    }
                    c.this.hGn.nr(false);
                }
            }
        });
        this.hGq = new b();
        this.hGp.setAdapter((ListAdapter) this.hGq);
        this.hGv = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hGv) {
            aj.s(this.hGs, d.f.corner_bg_radio_selected);
        } else {
            aj.s(this.hGs, d.f.corner_bg_radio_unselected);
        }
        aj.r(this.hGt, d.C0107d.cp_cont_g);
        this.hGr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.hGv) {
                    c.this.hGv = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    aj.s(c.this.hGs, d.f.corner_bg_radio_unselected);
                    c.this.hGs.invalidate();
                    return;
                }
                c.this.hGv = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                aj.s(c.this.hGs, d.f.corner_bg_radio_selected);
                c.this.hGs.invalidate();
            }
        });
    }

    public void bGq() {
        if (this.hGu != null) {
            this.hGu.setVisibility(0);
        }
    }

    public void up(String str) {
        int i;
        int i2 = 0;
        Bitmap rV = rV(str);
        if (rV != null && rV.getHeight() != 0) {
            if (rV.getHeight() <= 0) {
                i = 0;
            } else if (rV.getWidth() / rV.getHeight() > l.ao(this.hGh) / l.s(this.hGh, d.e.ds440)) {
                i = l.ao(this.hGh);
                if (rV.getWidth() > 0) {
                    i2 = (int) ((i / rV.getWidth()) * rV.getHeight());
                }
            } else {
                int s = l.s(this.hGh, d.e.ds440);
                if (rV.getWidth() > 0) {
                    i = (int) ((s / rV.getHeight()) * rV.getWidth());
                    i2 = s;
                } else {
                    i = 0;
                    i2 = s;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.hrD.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hrD.setLayoutParams(layoutParams);
            this.hrD.setImageBitmap(rV);
        }
    }

    private Bitmap rV(String str) {
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
        this.hGh.getLayoutMode().aM(i == 1);
        this.hGh.getLayoutMode().aM(this.ciJ);
        this.mNavigationBar.onChangeSkinType(this.hGh.getPageContext(), i);
        aj.c(this.fiF, d.f.icon_return_bg_s);
        aj.e(this.hGi, d.C0107d.cp_link_tip_a, 1);
        aj.s(this.hGl, d.f.corner_bg);
        aj.r(this.hGu, d.C0107d.cp_cont_e);
        this.hGv = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.hGv) {
            aj.s(this.hGs, d.f.corner_bg_radio_selected);
        } else {
            aj.s(this.hGs, d.f.corner_bg_radio_unselected);
        }
        if (this.hGl != null) {
            this.hGl.onChangeSkinType(i);
        }
        if (this.hGk != null) {
            this.hGk.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.hGj.getText() == null) {
            return null;
        }
        return this.hGj.getText().toString();
    }

    public long bGr() {
        if (this.hGj.getText() == null || this.hGj.getText().toString() == null) {
            return 0L;
        }
        return this.hGj.getText().length();
    }

    public WriteLocationView bGs() {
        return this.hGl;
    }

    public View bGt() {
        return this.hGi;
    }

    public View getBackButton() {
        return this.fiF;
    }

    public EditText bGu() {
        return this.hGj;
    }

    public StateSwitchView bGv() {
        return this.hGk;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                up(thumbPath);
                this.hrD.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.c.7
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.hrD.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.hrD.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.hrA.setVideoPath(videoPath);
                this.hrA.start();
            }
        }
        if (!v.E(list)) {
            this.hGq.dM(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.hGj.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.hGq.dM(arrayList);
            this.hGj.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bBI() {
        if (this.hrA != null) {
            this.hrA.resume();
            this.hrA.seekTo(this.hrK);
            this.hrA.start();
        }
    }

    public void avw() {
        this.hrK = this.hrA.getCurrentPosition();
        if (this.hrA != null) {
            this.hrA.stopPlayback();
        }
    }

    public void uq(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.hGh.getResources().getString(d.j.post_to_home_page));
            bGw();
            return;
        }
        this.mNavigationBar.setCenterTextTitle(this.hGh.getResources().getString(d.j.post_to) + str);
        bGx();
    }

    private void bGw() {
        this.hGk = new StateSwitchView(this.hGh);
        this.hGk.cl(this.hGh.getString(d.j.public_to_all), this.hGh.getString(d.j.public_to_me));
        this.hGk.setBackgroundId(d.f.state_switch_bg);
        this.hGk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hGk.bFZ();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.s(this.hGh, d.e.ds34), l.s(this.hGh, d.e.ds16));
        this.ciJ.addView(this.hGk, layoutParams);
    }

    private void bGx() {
        this.hGk = new StateSwitchView(this.hGh);
        this.hGk.cl(this.hGh.getString(d.j.display_to_home_page), this.hGh.getString(d.j.display_to_home_page));
        this.hGk.cX(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
        this.hGk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hGk.bFZ();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, l.s(this.hGh, d.e.ds34), l.s(this.hGh, d.e.ds16));
        this.hGk.setTextSize(0, this.hGh.getResources().getDimensionPixelSize(d.e.ds28));
        this.ciJ.addView(this.hGk, layoutParams);
    }

    public void bGy() {
        this.hGn.av(null);
        this.hGn.nq(false);
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hGn.av(postWriteCallBackData.getSensitiveWords());
            this.hGn.tZ(postWriteCallBackData.getErrorString());
            if (!v.E(this.hGn.bEM())) {
                nz(true);
            }
        }
    }

    public void nz(boolean z) {
        if (this.hGj.getText() != null) {
            int selectionEnd = this.hGj.getSelectionEnd();
            SpannableStringBuilder b = this.hGn.b(this.hGj.getText());
            if (b != null) {
                this.hGn.nr(true);
                this.hGj.setText(b);
                if (z && this.hGn.bEN() >= 0) {
                    this.hGj.requestFocus();
                    this.hGj.setSelection(this.hGn.bEN());
                } else {
                    this.hGj.setSelection(selectionEnd);
                }
                this.hGn.nq(this.hGn.bEN() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bGz() {
        return this.hGn;
    }

    public void nA(boolean z) {
        if (z) {
            this.hGo.setVisibility(8);
            this.hGm.setVisibility(0);
            this.dzw.smoothScrollTo(0, this.hGm.getBottom());
        }
    }
}
