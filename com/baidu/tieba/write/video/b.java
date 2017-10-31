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
    public static int gTu = 31;
    private View bRL;
    private ScrollView cvX;
    private ImageView eob;
    private int gGD;
    private CustomVideoView gGt;
    private ImageView gGw;
    private TextView gTA;
    private com.baidu.tieba.write.b gTB;
    private LinearLayout gTC;
    private ListView gTD;
    private a gTE;
    private LinearLayout gTF;
    private TextView gTG;
    private TextView gTH;
    private boolean gTI = true;
    private WriteVideoActivity gTv;
    private TextView gTw;
    private EditText gTx;
    private TextView gTy;
    private WriteLocationView gTz;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.gTv = writeVideoActivity;
        this.gTv.setContentView(d.h.write_video_activity);
        this.gTB = new com.baidu.tieba.write.b();
        this.gTB.vc(d.C0080d.cp_cont_i);
        this.gTB.vd(d.C0080d.cp_cont_h_alpha85);
        bDy();
        initView();
    }

    private void bDy() {
        this.bRL = this.gTv.findViewById(d.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.gTv.findViewById(d.g.navigation_bar);
        this.gTx = (EditText) this.gTv.findViewById(d.g.edit_content);
        this.gTA = (TextView) this.gTv.findViewById(d.g.text_content_size);
        this.gTy = (TextView) this.gTv.findViewById(d.g.select_forum_btn);
        this.gGw = (ImageView) this.gTv.findViewById(d.g.video_cover);
        this.gTz = (WriteLocationView) this.gTv.findViewById(d.g.location);
        this.gGt = (CustomVideoView) this.gTv.findViewById(d.g.preview_videoview);
        this.cvX = (ScrollView) this.gTv.findViewById(d.g.write_scrollview);
        this.gTy.setOnClickListener(this.gTv);
        this.gGt.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.gGt.getWidth() != b.this.gGw.getWidth() || b.this.gGt.getHeight() != b.this.gGw.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.gGw.getLayoutParams();
                    layoutParams.width = b.this.gGt.getWidth();
                    layoutParams.height = b.this.gGt.getHeight();
                    b.this.gGw.setLayoutParams(layoutParams);
                }
                b.this.gGw.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.gGt.start();
                        b.this.gGw.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.gGt.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cc(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.gTC = (LinearLayout) this.gTv.findViewById(d.g.video_activity_title_container);
        this.gTD = (ListView) this.gTv.findViewById(d.g.video_activity_title_list);
        this.gTD.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gTC.setVisibility(8);
                b.this.gTA.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    String str = "#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#";
                    b.this.gTx.setText(str);
                    b.this.gTx.requestFocus();
                    b.this.gTx.setSelection(str.length());
                    l.b(b.this.gTv, b.this.gTx);
                }
            }
        });
        this.gTF = (LinearLayout) this.gTv.findViewById(d.g.save_video_wrapper);
        this.gTG = (TextView) this.gTv.findViewById(d.g.save_video_ridiobutton);
        this.gTH = (TextView) this.gTv.findViewById(d.g.save_video_ridiotext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.ac(this.gTv) / l.f(this.gTv, d.e.ds440)) {
            i3 = l.ac(this.gTv);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int f = l.f(this.gTv, d.e.ds440);
            if (i2 > 0) {
                i3 = (int) ((f / i2) * i);
                i4 = f;
            } else {
                i3 = 0;
                i4 = f;
            }
        }
        this.gGt.setVideoHeight(i4);
        this.gGt.setVideoWidth(i3);
        this.gGt.invalidate();
    }

    private void initView() {
        this.eob = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.nav_close_layout, this.gTv);
        this.mNavigationBar.setCenterTextTitle(this.gTv.getPageContext().getString(d.j.post_video_title));
        this.gTw = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.nav_text_send_layout, this.gTv);
        this.gTw.setText(d.j.send_post);
        this.gTx.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.gTx.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.gTE != null && b.this.gTE.getCount() > 0) {
                    l.a(b.this.gTv, b.this.gTx);
                    b.this.gTC.setVisibility(0);
                    b.this.gTA.setVisibility(8);
                }
                long bDz = b.gTu - b.this.bDz();
                if (bDz >= 0) {
                    aj.i(b.this.gTA, d.C0080d.cp_cont_e);
                    b.this.gTA.setText(String.valueOf(bDz));
                    return;
                }
                b.this.gTA.setText("0");
                b.this.gTx.setText(b.this.gTx.getText().toString().substring(0, b.gTu));
                b.this.gTx.setSelection(b.this.gTx.getText().length());
                b.this.gTv.showToast(b.this.gTv.getResources().getString(d.j.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.gTB != null) {
                    if (!b.this.gTB.bCg()) {
                        b.this.nr(false);
                    }
                    b.this.gTB.nj(false);
                }
            }
        });
        this.gTE = new a();
        this.gTD.setAdapter((ListAdapter) this.gTE);
        this.gTI = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.gTI) {
            aj.j(this.gTG, d.f.corner_bg_radio_selected);
        } else {
            aj.j(this.gTG, d.f.corner_bg_radio_unselected);
        }
        aj.i(this.gTH, d.C0080d.cp_cont_g);
        this.gTF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gTI) {
                    b.this.gTI = false;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", false);
                    aj.j(b.this.gTG, d.f.corner_bg_radio_unselected);
                    b.this.gTG.invalidate();
                    return;
                }
                b.this.gTI = true;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("write_video_activity_save_video", true);
                aj.j(b.this.gTG, d.f.corner_bg_radio_selected);
                b.this.gTG.invalidate();
            }
        });
    }

    public void tV(String str) {
        int i;
        int i2 = 0;
        Bitmap rI = rI(str);
        if (rI != null && rI.getHeight() != 0) {
            if (rI.getHeight() <= 0) {
                i = 0;
            } else if (rI.getWidth() / rI.getHeight() > l.ac(this.gTv) / l.f(this.gTv, d.e.ds440)) {
                i = l.ac(this.gTv);
                if (rI.getWidth() > 0) {
                    i2 = (int) ((i / rI.getWidth()) * rI.getHeight());
                }
            } else {
                int f = l.f(this.gTv, d.e.ds440);
                if (rI.getWidth() > 0) {
                    i = (int) ((f / rI.getHeight()) * rI.getWidth());
                    i2 = f;
                } else {
                    i = 0;
                    i2 = f;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.gGw.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.gGw.setLayoutParams(layoutParams);
            this.gGw.setImageBitmap(rI);
        }
    }

    private Bitmap rI(String str) {
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
        this.gTv.getLayoutMode().ag(i == 1);
        this.gTv.getLayoutMode().t(this.bRL);
        this.mNavigationBar.onChangeSkinType(this.gTv.getPageContext(), i);
        aj.c(this.eob, d.f.icon_return_bg_s);
        aj.c(this.gTw, d.C0080d.cp_link_tip_a, 1);
        aj.j(this.gTz, d.f.corner_bg);
        this.gTI = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("write_video_activity_save_video", true);
        if (this.gTI) {
            aj.j(this.gTG, d.f.corner_bg_radio_selected);
        } else {
            aj.j(this.gTG, d.f.corner_bg_radio_unselected);
        }
        if (this.gTz != null) {
            this.gTz.wB();
        }
    }

    public String getContent() {
        if (this.gTx.getText() == null) {
            return null;
        }
        return this.gTx.getText().toString();
    }

    public long bDz() {
        if (this.gTx.getText() == null || this.gTx.getText().toString() == null) {
            return 0L;
        }
        return this.gTx.getText().length();
    }

    public WriteLocationView bDA() {
        return this.gTz;
    }

    public View bDB() {
        return this.gTw;
    }

    public View getBackButton() {
        return this.eob;
    }

    public EditText bDC() {
        return this.gTx;
    }

    public TextView bDD() {
        return this.gTy;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                tV(thumbPath);
                this.gGw.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.7
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.gGw.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.gGw.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.gGt.setVideoPath(videoPath);
                this.gGt.start();
            }
        }
        if (!v.v(list)) {
            this.gTE.dK(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.gTx.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.gTE.dK(arrayList);
            this.gTx.setText("#" + videoTitleData.name + "#");
        }
    }

    public void bzy() {
        if (this.gGt != null) {
            this.gGt.resume();
            this.gGt.seekTo(this.gGD);
            this.gGt.start();
        }
    }

    public void akt() {
        this.gGD = this.gGt.getCurrentPosition();
        if (this.gGt != null) {
            this.gGt.stopPlayback();
        }
    }

    public void tW(String str) {
        if (StringUtils.isNull(str)) {
            this.gTy.setText(d.j.select_forum);
        } else {
            this.gTy.setText(str);
        }
    }

    public void bDE() {
        this.gTB.aB(null);
        this.gTB.ni(false);
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.gTB.aB(postWriteCallBackData.getSensitiveWords());
            this.gTB.tI(postWriteCallBackData.getErrorString());
            if (!v.v(this.gTB.bCd())) {
                nr(true);
            }
        }
    }

    public void nr(boolean z) {
        if (this.gTx.getText() != null) {
            int selectionEnd = this.gTx.getSelectionEnd();
            SpannableStringBuilder b = this.gTB.b(this.gTx.getText());
            if (b != null) {
                this.gTB.nj(true);
                this.gTx.setText(b);
                if (z && this.gTB.bCe() >= 0) {
                    this.gTx.requestFocus();
                    this.gTx.setSelection(this.gTB.bCe());
                } else {
                    this.gTx.setSelection(selectionEnd);
                }
                this.gTB.ni(this.gTB.bCe() >= 0);
            }
        }
    }

    public com.baidu.tieba.write.b bDF() {
        return this.gTB;
    }

    public void ns(boolean z) {
        if (z) {
            this.gTC.setVisibility(8);
            this.gTA.setVisibility(0);
            this.cvX.smoothScrollTo(0, this.gTA.getBottom());
        }
    }
}
