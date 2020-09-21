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
    public static int nbM = 60;
    private ScrollView cek;
    private RelativeLayout gmj;
    private CustomVideoView mIX;
    private ImageView mJa;
    private int mJh;
    private NavigationBar mNavigationBar;
    private TextView mTitle;
    private WriteVideoActivity nbN;
    private TextView nbO;
    private EditText nbP;
    private StateSwitchView nbQ;
    private StateSwitchView nbR;
    private WriteLocationView nbS;
    private TextView nbT;
    private ImageView nbU;
    private c nbV;
    private LinearLayout nbW;
    private ListView nbX;
    private a nbY;
    private LinearLayout nbZ;
    private TextView nca;
    private TextView ncb;
    private ForumTabSelectedView ncd;
    private boolean ncc = true;
    private boolean nbH = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.nbN = writeVideoActivity;
        this.nbN.setContentView(R.layout.write_video_activity);
        this.nbV = new c();
        this.nbV.JV(R.color.cp_cont_a);
        this.nbV.JW(R.color.cp_cont_h_alpha85);
        Gg();
        initView();
    }

    public void xv(boolean z) {
        this.nbH = z;
        if (z) {
            if (this.nbR != null) {
                this.nbR.setVisibility(8);
            }
            if (this.nbS != null) {
                this.nbS.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.nbN.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void Gg() {
        this.gmj = (RelativeLayout) this.nbN.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.nbN.findViewById(R.id.navigation_bar);
        this.nbP = (EditText) this.nbN.findViewById(R.id.edit_content);
        this.nbT = (TextView) this.nbN.findViewById(R.id.text_content_size);
        this.mJa = (ImageView) this.nbN.findViewById(R.id.video_cover);
        this.mIX = (CustomVideoView) this.nbN.findViewById(R.id.preview_videoview);
        this.cek = (ScrollView) this.nbN.findViewById(R.id.write_scrollview);
        this.mIX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.mIX.getWidth() != b.this.mJa.getWidth() || b.this.mIX.getHeight() != b.this.mJa.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.mJa.getLayoutParams();
                    layoutParams.width = b.this.mIX.getWidth();
                    layoutParams.height = b.this.mIX.getHeight();
                    b.this.mJa.setLayoutParams(layoutParams);
                }
                b.this.mJa.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mIX.start();
                        b.this.mJa.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.mIX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.dv(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.nbW = (LinearLayout) this.nbN.findViewById(R.id.video_activity_title_container);
        this.nbX = (ListView) this.nbN.findViewById(R.id.video_activity_title_list);
        this.nbX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.nbW.setVisibility(8);
                b.this.nbT.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.nbP.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.nbP.requestFocus();
                    if (!TextUtils.isEmpty(b.this.nbP.getText())) {
                        b.this.nbP.setSelection(b.this.nbP.getText().length());
                    }
                    l.showSoftKeyPad(b.this.nbN, b.this.nbP);
                }
            }
        });
        this.nbZ = (LinearLayout) this.nbN.findViewById(R.id.save_video_wrapper);
        this.nca = (TextView) this.nbN.findViewById(R.id.save_video_ridiobutton);
        this.ncb = (TextView) this.nbN.findViewById(R.id.save_video_ridiotext);
        this.nbS = (WriteLocationView) this.nbN.findViewById(R.id.location);
        this.nbR = (StateSwitchView) this.nbN.findViewById(R.id.view_privacy);
        this.nbR.setStateString(this.nbN.getString(R.string.display_on_my_home_page), this.nbN.getString(R.string.display_on_my_home_page));
        this.nbR.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.nbR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.nbR.aYd();
            }
        });
        this.nbR.setTextSize(0, this.nbN.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void c(FrsTabInfoData frsTabInfoData) {
        this.ncd = (ForumTabSelectedView) this.nbN.findViewById(R.id.frs_tab_list);
        this.ncd.setData(frsTabInfoData);
        this.ncd.setActivity(this.nbN);
    }

    public ForumTabSelectedView dKT() {
        return this.ncd;
    }

    public boolean isToDynamic() {
        return this.nbQ != null && this.nbQ.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dv(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.nbN) / l.getDimens(this.nbN, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.nbN);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.nbN, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.mIX.setVideoHeight(i4);
        this.mIX.setVideoWidth(i3);
        this.mIX.invalidate();
    }

    private void initView() {
        this.nbU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.nbN);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.nbN.getPageContext().getString(R.string.post_video_title));
        if (this.nbH) {
            this.mTitle.setText(this.nbN.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.nbO = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.nbN);
        this.nbO.setText(R.string.send_post);
        this.nbP.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.nbP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.nbY != null && b.this.nbY.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.nbN, b.this.nbP);
                    b.this.nbW.setVisibility(0);
                    b.this.nbT.setVisibility(8);
                }
                long dKU = b.nbM - b.this.dKU();
                if (dKU >= 0) {
                    ap.setViewTextColor(b.this.nbT, R.color.cp_cont_e);
                    b.this.nbT.setText(String.valueOf(dKU));
                    return;
                }
                b.this.nbT.setText("0");
                b.this.nbP.setText(b.this.nbP.getText().toString().substring(0, b.nbM));
                b.this.nbP.setSelection(b.this.nbP.getText().length());
                b.this.nbN.showToast(b.this.nbN.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.nbV != null) {
                    if (!b.this.nbV.dJA()) {
                        b.this.xw(false);
                    }
                    b.this.nbV.xj(false);
                }
            }
        });
        this.nbY = new a();
        this.nbX.setAdapter((ListAdapter) this.nbY);
        this.ncc = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.ncc) {
            ap.setBackgroundResource(this.nca, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.nca, R.drawable.corner_bg_radio_unselected);
        }
        ap.setViewTextColor(this.ncb, R.color.cp_cont_g);
        this.nbZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ncc) {
                    b.this.ncc = false;
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    ap.setBackgroundResource(b.this.nca, R.drawable.corner_bg_radio_unselected);
                    b.this.nca.invalidate();
                    return;
                }
                b.this.ncc = true;
                com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                ap.setBackgroundResource(b.this.nca, R.drawable.corner_bg_radio_selected);
                b.this.nca.invalidate();
            }
        });
    }

    public void To(String str) {
        int i;
        int i2 = 0;
        Bitmap QD = QD(str);
        if (QD != null && QD.getHeight() != 0) {
            if (QD.getHeight() <= 0) {
                i = 0;
            } else if (QD.getWidth() / QD.getHeight() > l.getEquipmentWidth(this.nbN) / l.getDimens(this.nbN, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.nbN);
                if (QD.getWidth() > 0) {
                    i2 = (int) ((i / QD.getWidth()) * QD.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.nbN, R.dimen.ds440);
                if (QD.getWidth() > 0) {
                    i = (int) ((dimens / QD.getHeight()) * QD.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.mJa.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.mJa.setLayoutParams(layoutParams);
            this.mJa.setImageBitmap(QD);
        }
    }

    private Bitmap QD(String str) {
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
        this.nbN.getLayoutMode().setNightMode(i == 1);
        this.nbN.getLayoutMode().onModeChanged(this.gmj);
        this.mNavigationBar.onChangeSkinType(this.nbN.getPageContext(), i);
        SvgManager.bkl().a(this.nbU, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.nbO, R.color.cp_link_tip_a, 1);
        ap.c(this.nbS, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.ncc = com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.ncc) {
            ap.setBackgroundResource(this.nca, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.nca, R.drawable.corner_bg_radio_unselected);
        }
        if (this.nbS != null) {
            this.nbS.onChangeSkinType(i);
        }
        if (this.nbR != null) {
            this.nbR.onChangeSkinType(i);
        }
        if (this.ncd != null) {
            this.ncd.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.nbP.getText() == null) {
            return null;
        }
        return this.nbP.getText().toString();
    }

    public long dKU() {
        if (this.nbP.getText() == null || this.nbP.getText().toString() == null) {
            return 0L;
        }
        return this.nbP.getText().length();
    }

    public WriteLocationView dKV() {
        return this.nbS;
    }

    public View dKW() {
        return this.nbO;
    }

    public View getBackButton() {
        return this.nbU;
    }

    public EditText dKX() {
        return this.nbP;
    }

    public StateSwitchView dKY() {
        return this.nbR;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                To(thumbPath);
                this.mJa.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mJa.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.mJa.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.mIX.setVideoPath(videoPath);
                this.mIX.start();
            }
        }
        if (!y.isEmpty(list)) {
            this.nbY.fJ(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.nbP.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.nbY.fJ(arrayList);
            this.nbP.setText("#" + videoTitleData.name + "#");
        }
    }

    public void dGA() {
        if (this.mIX != null) {
            this.mIX.resume();
            this.mIX.seekTo(this.mJh);
            this.mIX.start();
        }
    }

    public void crX() {
        this.mJh = this.mIX.getCurrentPosition();
        if (this.mIX != null) {
            this.mIX.stopPlayback();
        }
    }

    public void Tp(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.nbN.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.nbN.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dKZ() {
        this.nbV.bh(null);
        this.nbV.xi(false);
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.nbV.bh(postWriteCallBackData.getSensitiveWords());
            this.nbV.SW(postWriteCallBackData.getErrorString());
            if (!y.isEmpty(this.nbV.dJx())) {
                xw(true);
            }
        }
    }

    public void xw(boolean z) {
        if (this.nbP.getText() != null) {
            int selectionEnd = this.nbP.getSelectionEnd();
            SpannableStringBuilder c = this.nbV.c(this.nbP.getText());
            if (c != null) {
                this.nbV.xj(true);
                this.nbP.setText(c);
                if (z && this.nbV.dJy() >= 0) {
                    this.nbP.requestFocus();
                    this.nbP.setSelection(this.nbV.dJy());
                } else {
                    this.nbP.setSelection(selectionEnd);
                }
                this.nbV.xi(this.nbV.dJy() >= 0);
            }
        }
    }

    public c dLa() {
        return this.nbV;
    }

    public void xx(boolean z) {
        if (z) {
            this.nbW.setVisibility(8);
            this.nbT.setVisibility(0);
            this.cek.smoothScrollTo(0, this.nbT.getBottom());
        }
    }
}
