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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes2.dex */
public class b {
    public static int lCo = 60;
    private ScrollView bHY;
    private RelativeLayout fsu;
    private LinearLayout lCA;
    private TextView lCB;
    private TextView lCC;
    private ForumTabSelectedView lCE;
    private WriteVideoActivity lCp;
    private TextView lCq;
    private EditText lCr;
    private StateSwitchView lCs;
    private WriteLocationView lCt;
    private TextView lCu;
    private ImageView lCv;
    private c lCw;
    private LinearLayout lCx;
    private ListView lCy;
    private a lCz;
    private CustomVideoView lmc;
    private ImageView lmf;
    private int lmm;
    private StateSwitchView lzy;
    private NavigationBar mNavigationBar;
    private TextView mTitle;
    private boolean lCD = true;
    private boolean lCj = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.lCp = writeVideoActivity;
        this.lCp.setContentView(R.layout.write_video_activity);
        this.lCw = new c();
        this.lCw.EI(R.color.cp_cont_a);
        this.lCw.EJ(R.color.cp_cont_h_alpha85);
        xN();
        initView();
    }

    public void uX(boolean z) {
        this.lCj = z;
        if (z) {
            if (this.lCs != null) {
                this.lCs.setVisibility(8);
            }
            if (this.lCt != null) {
                this.lCt.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.lCp.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void xN() {
        this.fsu = (RelativeLayout) this.lCp.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.lCp.findViewById(R.id.navigation_bar);
        this.lCr = (EditText) this.lCp.findViewById(R.id.edit_content);
        this.lCu = (TextView) this.lCp.findViewById(R.id.text_content_size);
        this.lmf = (ImageView) this.lCp.findViewById(R.id.video_cover);
        this.lmc = (CustomVideoView) this.lCp.findViewById(R.id.preview_videoview);
        this.bHY = (ScrollView) this.lCp.findViewById(R.id.write_scrollview);
        this.lmc.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.lmc.getWidth() != b.this.lmf.getWidth() || b.this.lmc.getHeight() != b.this.lmf.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.lmf.getLayoutParams();
                    layoutParams.width = b.this.lmc.getWidth();
                    layoutParams.height = b.this.lmc.getHeight();
                    b.this.lmf.setLayoutParams(layoutParams);
                }
                b.this.lmf.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lmc.start();
                        b.this.lmf.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.lmc.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cW(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.lCx = (LinearLayout) this.lCp.findViewById(R.id.video_activity_title_container);
        this.lCy = (ListView) this.lCp.findViewById(R.id.video_activity_title_list);
        this.lCy.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.lCx.setVisibility(8);
                b.this.lCu.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.lCr.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.lCr.requestFocus();
                    if (!TextUtils.isEmpty(b.this.lCr.getText())) {
                        b.this.lCr.setSelection(b.this.lCr.getText().length());
                    }
                    l.showSoftKeyPad(b.this.lCp, b.this.lCr);
                }
            }
        });
        this.lCA = (LinearLayout) this.lCp.findViewById(R.id.save_video_wrapper);
        this.lCB = (TextView) this.lCp.findViewById(R.id.save_video_ridiobutton);
        this.lCC = (TextView) this.lCp.findViewById(R.id.save_video_ridiotext);
        this.lCt = (WriteLocationView) this.lCp.findViewById(R.id.location);
        this.lCs = (StateSwitchView) this.lCp.findViewById(R.id.view_privacy);
        this.lCs.setStateString(this.lCp.getString(R.string.display_on_my_home_page), this.lCp.getString(R.string.display_on_my_home_page));
        this.lCs.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.lCs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.lCs.biI();
            }
        });
        this.lCs.setTextSize(0, this.lCp.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.lCE = (ForumTabSelectedView) this.lCp.findViewById(R.id.frs_tab_list);
        this.lCE.setData(frsTabInfoData);
        this.lCE.setActivity(this.lCp);
    }

    public ForumTabSelectedView dgk() {
        return this.lCE;
    }

    public boolean isToDynamic() {
        return this.lzy != null && this.lzy.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.lCp) / l.getDimens(this.lCp, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.lCp);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.lCp, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.lmc.setVideoHeight(i4);
        this.lmc.setVideoWidth(i3);
        this.lmc.invalidate();
    }

    private void initView() {
        this.lCv = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.lCp);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.lCp.getPageContext().getString(R.string.post_video_title));
        if (this.lCj) {
            this.mTitle.setText(this.lCp.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.lCq = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.lCp);
        this.lCq.setText(R.string.send_post);
        this.lCr.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.lCr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.lCz != null && b.this.lCz.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.lCp, b.this.lCr);
                    b.this.lCx.setVisibility(0);
                    b.this.lCu.setVisibility(8);
                }
                long dgl = b.lCo - b.this.dgl();
                if (dgl >= 0) {
                    am.setViewTextColor(b.this.lCu, (int) R.color.cp_cont_e);
                    b.this.lCu.setText(String.valueOf(dgl));
                    return;
                }
                b.this.lCu.setText("0");
                b.this.lCr.setText(b.this.lCr.getText().toString().substring(0, b.lCo));
                b.this.lCr.setSelection(b.this.lCr.getText().length());
                b.this.lCp.showToast(b.this.lCp.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.lCw != null) {
                    if (!b.this.lCw.deS()) {
                        b.this.uY(false);
                    }
                    b.this.lCw.uO(false);
                }
            }
        });
        this.lCz = new a();
        this.lCy.setAdapter((ListAdapter) this.lCz);
        this.lCD = com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.lCD) {
            am.setBackgroundResource(this.lCB, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.lCB, R.drawable.corner_bg_radio_unselected);
        }
        am.setViewTextColor(this.lCC, (int) R.color.cp_cont_g);
        this.lCA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.lCD) {
                    b.this.lCD = false;
                    com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    am.setBackgroundResource(b.this.lCB, R.drawable.corner_bg_radio_unselected);
                    b.this.lCB.invalidate();
                    return;
                }
                b.this.lCD = true;
                com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                am.setBackgroundResource(b.this.lCB, R.drawable.corner_bg_radio_selected);
                b.this.lCB.invalidate();
            }
        });
    }

    public void MJ(String str) {
        int i;
        int i2 = 0;
        Bitmap Ki = Ki(str);
        if (Ki != null && Ki.getHeight() != 0) {
            if (Ki.getHeight() <= 0) {
                i = 0;
            } else if (Ki.getWidth() / Ki.getHeight() > l.getEquipmentWidth(this.lCp) / l.getDimens(this.lCp, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.lCp);
                if (Ki.getWidth() > 0) {
                    i2 = (int) ((i / Ki.getWidth()) * Ki.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.lCp, R.dimen.ds440);
                if (Ki.getWidth() > 0) {
                    i = (int) ((dimens / Ki.getHeight()) * Ki.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.lmf.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.lmf.setLayoutParams(layoutParams);
            this.lmf.setImageBitmap(Ki);
        }
    }

    private Bitmap Ki(String str) {
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
        this.lCp.getLayoutMode().setNightMode(i == 1);
        this.lCp.getLayoutMode().onModeChanged(this.fsu);
        this.mNavigationBar.onChangeSkinType(this.lCp.getPageContext(), i);
        SvgManager.aOR().a(this.lCv, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.lCq, R.color.cp_link_tip_a, 1);
        am.c(this.lCt, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.lCD = com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.lCD) {
            am.setBackgroundResource(this.lCB, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.lCB, R.drawable.corner_bg_radio_unselected);
        }
        if (this.lCt != null) {
            this.lCt.onChangeSkinType(i);
        }
        if (this.lCs != null) {
            this.lCs.onChangeSkinType(i);
        }
        if (this.lCE != null) {
            this.lCE.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.lCr.getText() == null) {
            return null;
        }
        return this.lCr.getText().toString();
    }

    public long dgl() {
        if (this.lCr.getText() == null || this.lCr.getText().toString() == null) {
            return 0L;
        }
        return this.lCr.getText().length();
    }

    public WriteLocationView dgm() {
        return this.lCt;
    }

    public View dgn() {
        return this.lCq;
    }

    public View getBackButton() {
        return this.lCv;
    }

    public EditText dgo() {
        return this.lCr;
    }

    public StateSwitchView dgp() {
        return this.lCs;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                MJ(thumbPath);
                this.lmf.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.lmf.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.lmf.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.lmc.setVideoPath(videoPath);
                this.lmc.start();
            }
        }
        if (!v.isEmpty(list)) {
            this.lCz.eN(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.lCr.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.lCz.eN(arrayList);
            this.lCr.setText("#" + videoTitleData.name + "#");
        }
    }

    public void dbY() {
        if (this.lmc != null) {
            this.lmc.resume();
            this.lmc.seekTo(this.lmm);
            this.lmc.start();
        }
    }

    public void bQW() {
        this.lmm = this.lmc.getCurrentPosition();
        if (this.lmc != null) {
            this.lmc.stopPlayback();
        }
    }

    public void MK(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.lCp.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.lCp.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dgq() {
        this.lCw.aW(null);
        this.lCw.uN(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lCw.aW(postWriteCallBackData.getSensitiveWords());
            this.lCw.Ms(postWriteCallBackData.getErrorString());
            if (!v.isEmpty(this.lCw.deP())) {
                uY(true);
            }
        }
    }

    public void uY(boolean z) {
        if (this.lCr.getText() != null) {
            int selectionEnd = this.lCr.getSelectionEnd();
            SpannableStringBuilder a = this.lCw.a(this.lCr.getText());
            if (a != null) {
                this.lCw.uO(true);
                this.lCr.setText(a);
                if (z && this.lCw.deQ() >= 0) {
                    this.lCr.requestFocus();
                    this.lCr.setSelection(this.lCw.deQ());
                } else {
                    this.lCr.setSelection(selectionEnd);
                }
                this.lCw.uN(this.lCw.deQ() >= 0);
            }
        }
    }

    public c dgr() {
        return this.lCw;
    }

    public void uZ(boolean z) {
        if (z) {
            this.lCx.setVisibility(8);
            this.lCu.setVisibility(0);
            this.bHY.smoothScrollTo(0, this.lCu.getBottom());
        }
    }
}
