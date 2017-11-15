package com.baidu.tieba.write.video;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableStringBuilder;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    public static int gUE = 31;
    private View bRY;
    private ScrollView cwq;
    private ImageView eog;
    private CustomVideoView gHB;
    private ImageView gHE;
    private int gHL;
    private WriteVideoActivity gUF;
    private TextView gUG;
    private EditText gUH;
    private TextView gUI;
    private WriteLocationView gUJ;
    private TextView gUK;
    private com.baidu.tieba.write.b gUL;
    private LinearLayout gUM;
    private ListView gUN;
    private a gUO;
    private LinearLayout gUP;
    private TextView gUQ;
    private TextView gUR;
    private boolean gUS = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.gUF = writeVideoActivity;
        this.gUF.setContentView(d.h.write_video_activity);
        this.gUL = new com.baidu.tieba.write.b();
        this.gUL.vg(d.C0080d.cp_cont_i);
        this.gUL.vh(d.C0080d.cp_cont_h_alpha85);
        bDL();
        initView();
    }

    private void bDL() {
        this.bRY = this.gUF.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.gUF.findViewById(d.g.navigation_bar);
        this.gUH = (EditText) this.gUF.findViewById(d.g.edit_content);
        this.gUK = (TextView) this.gUF.findViewById(d.g.text_content_size);
        this.gUI = (TextView) this.gUF.findViewById(d.g.select_forum_btn);
        this.gHE = (ImageView) this.gUF.findViewById(d.g.video_cover);
        this.gUJ = (WriteLocationView) this.gUF.findViewById(d.g.location);
        this.gHB = (CustomVideoView) this.gUF.findViewById(d.g.preview_videoview);
        this.cwq = (ScrollView) this.gUF.findViewById(d.g.write_scrollview);
        this.gUI.setOnClickListener(this.gUF);
        this.gHB.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.gHB.getWidth() != b.this.gHE.getWidth() || b.this.gHB.getHeight() != b.this.gHE.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.gHE.getLayoutParams();
                    layoutParams.width = b.this.gHB.getWidth();
                    layoutParams.height = b.this.gHB.getHeight();
                    b.this.gHE.setLayoutParams(layoutParams);
                }
                b.this.gHE.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.gHB.start();
                        b.this.gHE.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.gHB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cb(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.gUM = (LinearLayout) this.gUF.findViewById(d.g.video_activity_title_container);
        this.gUN = (ListView) this.gUF.findViewById(d.g.video_activity_title_list);
        this.gUN.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gUM.setVisibility(8);
                b.this.gUK.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    String str = "#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#";
                    b.this.gUH.setText(str);
                    b.this.gUH.requestFocus();
                    b.this.gUH.setSelection(str.length());
                    l.b(b.this.gUF, b.this.gUH);
                }
            }
        });
        this.gUP = (LinearLayout) this.gUF.findViewById(d.g.save_video_wrapper);
        this.gUQ = (TextView) this.gUF.findViewById(d.g.save_video_ridiobutton);
        this.gUR = (TextView) this.gUF.findViewById(d.g.save_video_ridiotext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ac(this.gUF) / l.f(this.gUF, d.e.ds440)) {
            i3 = l.ac(this.gUF);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.gUF, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.gHB.setVideoHeight(i4);
        this.gHB.setVideoWidth(i3);
        this.gHB.invalidate();
    }

    private void initView() {
        this.eog = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.gUF);
        this.mNavigationBar.setCenterTextTitle(this.gUF.getPageContext().getString(d.j.post_video_title));
        this.gUG = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.gUF);
        this.gUG.setText(d.j.send_post);
        this.gUH.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.gUH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.gUO != null && b.this.gUO.getCount() > 0) {
                    l.a(b.this.gUF, b.this.gUH);
                    b.this.gUM.setVisibility(0);
                    b.this.gUK.setVisibility(8);
                }
                long bDM = b.gUE - b.this.bDM();
                if (bDM >= 0) {
                    aj.i(b.this.gUK, d.C0080d.cp_cont_e);
                    b.this.gUK.setText(String.valueOf(bDM));
                    return;
                }
                b.this.gUK.setText("0");
                b.this.gUH.setText(b.this.gUH.getText().toString().substring(0, b.gUE));
                b.this.gUH.setSelection(b.this.gUH.getText().length());
                b.this.gUF.showToast(b.this.gUF.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.gUL != null) {
                    if (!b.this.gUL.bCs()) {
                        b.this.nz(false);
                    }
                    b.this.gUL.nr(false);
                }
            }
        });
        this.gUO = new a();
        this.gUN.setAdapter((ListAdapter) this.gUO);
        this.gUS = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.gUS) {
            aj.j(this.gUQ, d.f.corner_bg_radio_selected);
        } else {
            aj.j(this.gUQ, d.f.corner_bg_radio_unselected);
        }
        aj.i(this.gUR, d.C0080d.cp_cont_g);
        this.gUP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gUS) {
                    b.this.gUS = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    aj.j(b.this.gUQ, d.f.corner_bg_radio_unselected);
                    b.this.gUQ.invalidate();
                    return;
                }
                b.this.gUS = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                aj.j(b.this.gUQ, d.f.corner_bg_radio_selected);
                b.this.gUQ.invalidate();
            }
        });
    }

    public void uc(String str) {
        int i;
        int i2 = 0;
        Bitmap rP = rP(str);
        if (rP != null && rP.getHeight() != 0) {
            if (rP.getHeight() <= 0) {
                i = 0;
            } else if (rP.getWidth() / rP.getHeight() > l.ac(this.gUF) / l.f(this.gUF, d.e.ds440)) {
                i = l.ac(this.gUF);
                if (rP.getWidth() > 0) {
                    i2 = (int) ((i / rP.getWidth()) * rP.getHeight());
                }
            } else {
                int f = l.f(this.gUF, d.e.ds440);
                if (rP.getWidth() > 0) {
                    i = (int) ((f / rP.getHeight()) * rP.getWidth());
                    i2 = f;
                } else {
                    i = 0;
                    i2 = f;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.gHE.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.gHE.setLayoutParams(layoutParams);
            this.gHE.setImageBitmap(rP);
        }
    }

    private Bitmap rP(String str) {
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
        this.gUF.getLayoutMode().ag(i == 1);
        this.gUF.getLayoutMode().t(this.bRY);
        this.mNavigationBar.onChangeSkinType(this.gUF.getPageContext(), i);
        aj.c(this.eog, d.f.icon_return_bg_s);
        aj.c(this.gUG, d.C0080d.cp_link_tip_a, 1);
        aj.j(this.gUJ, d.f.corner_bg);
        this.gUS = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.gUS) {
            aj.j(this.gUQ, d.f.corner_bg_radio_selected);
        } else {
            aj.j(this.gUQ, d.f.corner_bg_radio_unselected);
        }
        if (this.gUJ != null) {
            this.gUJ.wB();
        }
    }

    public String getContent() {
        if (this.gUH.getText() == null) {
            return null;
        }
        return this.gUH.getText().toString();
    }

    public long bDM() {
        if (this.gUH.getText() == null || this.gUH.getText().toString() == null) {
            return 0L;
        }
        return this.gUH.getText().length();
    }

    public WriteLocationView bDN() {
        return this.gUJ;
    }

    public View bDO() {
        return this.gUG;
    }

    public View getBackButton() {
        return this.eog;
    }

    public EditText bDP() {
        return this.gUH;
    }

    public TextView bDQ() {
        return this.gUI;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                uc(thumbPath);
                this.gHE.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.gHE.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.gHE.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.gHB.setVideoPath(videoPath);
                this.gHB.start();
            }
        }
        if (!v.v(list)) {
            this.gUO.dL(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.gUH.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.gUO.dL(arrayList);
            this.gUH.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bzK() {
        if (this.gHB != null) {
            this.gHB.resume();
            this.gHB.seekTo(this.gHL);
            this.gHB.start();
        }
    }

    public void akH() {
        this.gHL = this.gHB.getCurrentPosition();
        if (this.gHB != null) {
            this.gHB.stopPlayback();
        }
    }

    public void ud(String str) {
        if (StringUtils.isNull(str)) {
            this.gUI.setText(d.j.select_forum);
        } else {
            this.gUI.setText(str);
        }
    }

    public void bDR() {
        this.gUL.aB(null);
        this.gUL.nq(false);
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.gUL.aB(postWriteCallBackData.getSensitiveWords());
            this.gUL.tO(postWriteCallBackData.getErrorString());
            if (!v.v(this.gUL.bCp())) {
                nz(true);
            }
        }
    }

    public void nz(boolean z) {
        if (this.gUH.getText() != null) {
            int selectionEnd = this.gUH.getSelectionEnd();
            SpannableStringBuilder b = this.gUL.b(this.gUH.getText());
            if (b != null) {
                this.gUL.nr(true);
                this.gUH.setText(b);
                if (z && this.gUL.bCq() >= 0) {
                    this.gUH.requestFocus();
                    this.gUH.setSelection(this.gUL.bCq());
                } else {
                    this.gUH.setSelection(selectionEnd);
                }
                this.gUL.nq(this.gUL.bCq() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bDS() {
        return this.gUL;
    }

    public void nA(boolean z) {
        if (z) {
            this.gUM.setVisibility(8);
            this.gUK.setVisibility(0);
            this.cwq.smoothScrollTo(0, this.gUK.getBottom());
        }
    }
}
