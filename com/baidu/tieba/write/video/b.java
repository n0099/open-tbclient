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
/* loaded from: classes13.dex */
public class b {
    public static int kSk = 60;
    private ScrollView bjL;
    private RelativeLayout eNV;
    private CustomVideoView kBF;
    private ImageView kBI;
    private int kBP;
    private StateSwitchView kQc;
    private ForumTabSelectedView kSA;
    private WriteVideoActivity kSl;
    private TextView kSm;
    private EditText kSn;
    private StateSwitchView kSo;
    private WriteLocationView kSp;
    private TextView kSq;
    private ImageView kSr;
    private c kSs;
    private LinearLayout kSt;
    private ListView kSu;
    private a kSv;
    private LinearLayout kSw;
    private TextView kSx;
    private TextView kSy;
    private boolean kSz = true;
    private NavigationBar mNavigationBar;

    public b(WriteVideoActivity writeVideoActivity) {
        this.kSl = writeVideoActivity;
        this.kSl.setContentView(R.layout.write_video_activity);
        this.kSs = new c();
        this.kSs.Eh(R.color.cp_cont_a);
        this.kSs.Ei(R.color.cp_cont_h_alpha85);
        cVE();
        initView();
    }

    private void cVE() {
        this.eNV = (RelativeLayout) this.kSl.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.kSl.findViewById(R.id.navigation_bar);
        this.kSn = (EditText) this.kSl.findViewById(R.id.edit_content);
        this.kSq = (TextView) this.kSl.findViewById(R.id.text_content_size);
        this.kBI = (ImageView) this.kSl.findViewById(R.id.video_cover);
        this.kBF = (CustomVideoView) this.kSl.findViewById(R.id.preview_videoview);
        this.bjL = (ScrollView) this.kSl.findViewById(R.id.write_scrollview);
        this.kBF.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.kBF.getWidth() != b.this.kBI.getWidth() || b.this.kBF.getHeight() != b.this.kBI.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.kBI.getLayoutParams();
                    layoutParams.width = b.this.kBF.getWidth();
                    layoutParams.height = b.this.kBF.getHeight();
                    b.this.kBI.setLayoutParams(layoutParams);
                }
                b.this.kBI.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kBF.start();
                        b.this.kBI.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.kBF.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.cR(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.kSt = (LinearLayout) this.kSl.findViewById(R.id.video_activity_title_container);
        this.kSu = (ListView) this.kSl.findViewById(R.id.video_activity_title_list);
        this.kSu.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.kSt.setVisibility(8);
                b.this.kSq.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.kSn.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.kSn.requestFocus();
                    if (!TextUtils.isEmpty(b.this.kSn.getText())) {
                        b.this.kSn.setSelection(b.this.kSn.getText().length());
                    }
                    l.showSoftKeyPad(b.this.kSl, b.this.kSn);
                }
            }
        });
        this.kSw = (LinearLayout) this.kSl.findViewById(R.id.save_video_wrapper);
        this.kSx = (TextView) this.kSl.findViewById(R.id.save_video_ridiobutton);
        this.kSy = (TextView) this.kSl.findViewById(R.id.save_video_ridiotext);
        this.kSp = (WriteLocationView) this.kSl.findViewById(R.id.location);
        this.kSo = (StateSwitchView) this.kSl.findViewById(R.id.view_privacy);
        this.kSo.setStateString(this.kSl.getString(R.string.display_on_my_home_page), this.kSl.getString(R.string.display_on_my_home_page));
        this.kSo.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.kSo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kSo.baH();
            }
        });
        this.kSo.setTextSize(0, this.kSl.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.kSA = (ForumTabSelectedView) this.kSl.findViewById(R.id.frs_tab_list);
        this.kSA.setData(frsTabInfoData);
        this.kSA.setActivity(this.kSl);
    }

    public ForumTabSelectedView cVF() {
        return this.kSA;
    }

    public boolean isToDynamic() {
        return this.kQc != null && this.kQc.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cR(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.kSl) / l.getDimens(this.kSl, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.kSl);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.kSl, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.kBF.setVideoHeight(i4);
        this.kBF.setVideoWidth(i3);
        this.kBF.invalidate();
    }

    private void initView() {
        this.kSr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.kSl);
        this.mNavigationBar.setCenterTextTitle(this.kSl.getPageContext().getString(R.string.post_video_title));
        this.kSm = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.kSl);
        this.kSm.setText(R.string.send_post);
        this.kSn.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.kSn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.kSv != null && b.this.kSv.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.kSl, b.this.kSn);
                    b.this.kSt.setVisibility(0);
                    b.this.kSq.setVisibility(8);
                }
                long cVG = b.kSk - b.this.cVG();
                if (cVG >= 0) {
                    am.setViewTextColor(b.this.kSq, (int) R.color.cp_cont_e);
                    b.this.kSq.setText(String.valueOf(cVG));
                    return;
                }
                b.this.kSq.setText("0");
                b.this.kSn.setText(b.this.kSn.getText().toString().substring(0, b.kSk));
                b.this.kSn.setSelection(b.this.kSn.getText().length());
                b.this.kSl.showToast(b.this.kSl.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.kSs != null) {
                    if (!b.this.kSs.cUA()) {
                        b.this.tW(false);
                    }
                    b.this.kSs.tO(false);
                }
            }
        });
        this.kSv = new a();
        this.kSu.setAdapter((ListAdapter) this.kSv);
        this.kSz = com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.kSz) {
            am.setBackgroundResource(this.kSx, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.kSx, R.drawable.corner_bg_radio_unselected);
        }
        am.setViewTextColor(this.kSy, (int) R.color.cp_cont_g);
        this.kSw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.kSz) {
                    b.this.kSz = false;
                    com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    am.setBackgroundResource(b.this.kSx, R.drawable.corner_bg_radio_unselected);
                    b.this.kSx.invalidate();
                    return;
                }
                b.this.kSz = true;
                com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                am.setBackgroundResource(b.this.kSx, R.drawable.corner_bg_radio_selected);
                b.this.kSx.invalidate();
            }
        });
    }

    public void KZ(String str) {
        int i;
        int i2 = 0;
        Bitmap IB = IB(str);
        if (IB != null && IB.getHeight() != 0) {
            if (IB.getHeight() <= 0) {
                i = 0;
            } else if (IB.getWidth() / IB.getHeight() > l.getEquipmentWidth(this.kSl) / l.getDimens(this.kSl, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.kSl);
                if (IB.getWidth() > 0) {
                    i2 = (int) ((i / IB.getWidth()) * IB.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.kSl, R.dimen.ds440);
                if (IB.getWidth() > 0) {
                    i = (int) ((dimens / IB.getHeight()) * IB.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.kBI.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.kBI.setLayoutParams(layoutParams);
            this.kBI.setImageBitmap(IB);
        }
    }

    private Bitmap IB(String str) {
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
        this.kSl.getLayoutMode().setNightMode(i == 1);
        this.kSl.getLayoutMode().onModeChanged(this.eNV);
        this.mNavigationBar.onChangeSkinType(this.kSl.getPageContext(), i);
        SvgManager.aGG().a(this.kSr, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.kSm, R.color.cp_link_tip_a, 1);
        am.c(this.kSp, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.kSz = com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.kSz) {
            am.setBackgroundResource(this.kSx, R.drawable.corner_bg_radio_selected);
        } else {
            am.setBackgroundResource(this.kSx, R.drawable.corner_bg_radio_unselected);
        }
        if (this.kSp != null) {
            this.kSp.onChangeSkinType(i);
        }
        if (this.kSo != null) {
            this.kSo.onChangeSkinType(i);
        }
        if (this.kSA != null) {
            this.kSA.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.kSn.getText() == null) {
            return null;
        }
        return this.kSn.getText().toString();
    }

    public long cVG() {
        if (this.kSn.getText() == null || this.kSn.getText().toString() == null) {
            return 0L;
        }
        return this.kSn.getText().length();
    }

    public WriteLocationView cVH() {
        return this.kSp;
    }

    public View cVI() {
        return this.kSm;
    }

    public View getBackButton() {
        return this.kSr;
    }

    public EditText cVJ() {
        return this.kSn;
    }

    public StateSwitchView cVK() {
        return this.kSo;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                KZ(thumbPath);
                this.kBI.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.kBI.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.kBI.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.kBF.setVideoPath(videoPath);
                this.kBF.start();
            }
        }
        if (!v.isEmpty(list)) {
            this.kSv.ey(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.kSn.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.kSv.ey(arrayList);
            this.kSn.setText("#" + videoTitleData.name + "#");
        }
    }

    public void cRe() {
        if (this.kBF != null) {
            this.kBF.resume();
            this.kBF.seekTo(this.kBP);
            this.kBF.start();
        }
    }

    public void bGx() {
        this.kBP = this.kBF.getCurrentPosition();
        if (this.kBF != null) {
            this.kBF.stopPlayback();
        }
    }

    public void La(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.kSl.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.kSl.getResources().getString(R.string.post_to) + str);
        }
    }

    public void cVL() {
        this.kSs.aU(null);
        this.kSs.tN(false);
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kSs.aU(postWriteCallBackData.getSensitiveWords());
            this.kSs.KK(postWriteCallBackData.getErrorString());
            if (!v.isEmpty(this.kSs.cUx())) {
                tW(true);
            }
        }
    }

    public void tW(boolean z) {
        if (this.kSn.getText() != null) {
            int selectionEnd = this.kSn.getSelectionEnd();
            SpannableStringBuilder a = this.kSs.a(this.kSn.getText());
            if (a != null) {
                this.kSs.tO(true);
                this.kSn.setText(a);
                if (z && this.kSs.cUy() >= 0) {
                    this.kSn.requestFocus();
                    this.kSn.setSelection(this.kSs.cUy());
                } else {
                    this.kSn.setSelection(selectionEnd);
                }
                this.kSs.tN(this.kSs.cUy() >= 0);
            }
        }
    }

    public c cVM() {
        return this.kSs;
    }

    public void tX(boolean z) {
        if (z) {
            this.kSt.setVisibility(8);
            this.kSq.setVisibility(0);
            this.bjL.smoothScrollTo(0, this.kSq.getBottom());
        }
    }
}
