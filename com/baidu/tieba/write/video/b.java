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
    public static int nDK = 60;
    private ScrollView czb;
    private RelativeLayout gMq;
    private NavigationBar mNavigationBar;
    private TextView mTitle;
    private WriteVideoActivity nDL;
    private TextView nDM;
    private EditText nDN;
    private StateSwitchView nDO;
    private StateSwitchView nDP;
    private WriteLocationView nDQ;
    private TextView nDR;
    private ImageView nDS;
    private c nDT;
    private LinearLayout nDU;
    private ListView nDV;
    private a nDW;
    private LinearLayout nDX;
    private TextView nDY;
    private TextView nDZ;
    private ForumTabSelectedView nEb;
    private CustomVideoView nle;
    private ImageView nlh;
    private int nlo;
    private boolean nEa = true;
    private boolean nDF = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.nDL = writeVideoActivity;
        this.nDL.setContentView(R.layout.write_video_activity);
        this.nDT = new c();
        this.nDT.KT(R.color.cp_cont_a);
        this.nDT.KU(R.color.cp_cont_h_alpha85);
        Hy();
        initView();
    }

    public void yt(boolean z) {
        this.nDF = z;
        if (z) {
            if (this.nDP != null) {
                this.nDP.setVisibility(8);
            }
            if (this.nDQ != null) {
                this.nDQ.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.nDL.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void Hy() {
        this.gMq = (RelativeLayout) this.nDL.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.nDL.findViewById(R.id.navigation_bar);
        this.nDN = (EditText) this.nDL.findViewById(R.id.edit_content);
        this.nDR = (TextView) this.nDL.findViewById(R.id.text_content_size);
        this.nlh = (ImageView) this.nDL.findViewById(R.id.video_cover);
        this.nle = (CustomVideoView) this.nDL.findViewById(R.id.preview_videoview);
        this.czb = (ScrollView) this.nDL.findViewById(R.id.write_scrollview);
        this.nle.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.nle.getWidth() != b.this.nlh.getWidth() || b.this.nle.getHeight() != b.this.nlh.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.nlh.getLayoutParams();
                    layoutParams.width = b.this.nle.getWidth();
                    layoutParams.height = b.this.nle.getHeight();
                    b.this.nlh.setLayoutParams(layoutParams);
                }
                b.this.nlh.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nle.start();
                        b.this.nlh.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.nle.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.dx(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.nDU = (LinearLayout) this.nDL.findViewById(R.id.video_activity_title_container);
        this.nDV = (ListView) this.nDL.findViewById(R.id.video_activity_title_list);
        this.nDV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.nDU.setVisibility(8);
                b.this.nDR.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.nDN.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.nDN.requestFocus();
                    if (!TextUtils.isEmpty(b.this.nDN.getText())) {
                        b.this.nDN.setSelection(b.this.nDN.getText().length());
                    }
                    l.showSoftKeyPad(b.this.nDL, b.this.nDN);
                }
            }
        });
        this.nDX = (LinearLayout) this.nDL.findViewById(R.id.save_video_wrapper);
        this.nDY = (TextView) this.nDL.findViewById(R.id.save_video_ridiobutton);
        this.nDZ = (TextView) this.nDL.findViewById(R.id.save_video_ridiotext);
        this.nDQ = (WriteLocationView) this.nDL.findViewById(R.id.location);
        this.nDP = (StateSwitchView) this.nDL.findViewById(R.id.view_privacy);
        this.nDP.setStateString(this.nDL.getString(R.string.display_on_my_home_page), this.nDL.getString(R.string.display_on_my_home_page));
        this.nDP.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
        this.nDP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.nDP.bcE();
            }
        });
        this.nDP.setTextSize(0, this.nDL.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void c(FrsTabInfoData frsTabInfoData) {
        this.nEb = (ForumTabSelectedView) this.nDL.findViewById(R.id.frs_tab_list);
        this.nEb.setData(frsTabInfoData);
        this.nEb.setActivity(this.nDL);
    }

    public ForumTabSelectedView dRN() {
        return this.nEb;
    }

    public boolean isToDynamic() {
        return this.nDO != null && this.nDO.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.nDL) / l.getDimens(this.nDL, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.nDL);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.nDL, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.nle.setVideoHeight(i4);
        this.nle.setVideoWidth(i3);
        this.nle.invalidate();
    }

    private void initView() {
        this.nDS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.nDL);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.nDL.getPageContext().getString(R.string.post_video_title));
        if (this.nDF) {
            this.mTitle.setText(this.nDL.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.nDM = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.nDL);
        this.nDM.setText(R.string.send_post);
        this.nDN.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.nDN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.nDW != null && b.this.nDW.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.nDL, b.this.nDN);
                    b.this.nDU.setVisibility(0);
                    b.this.nDR.setVisibility(8);
                }
                long dRO = b.nDK - b.this.dRO();
                if (dRO >= 0) {
                    ap.setViewTextColor(b.this.nDR, R.color.cp_cont_e);
                    b.this.nDR.setText(String.valueOf(dRO));
                    return;
                }
                b.this.nDR.setText("0");
                b.this.nDN.setText(b.this.nDN.getText().toString().substring(0, b.nDK));
                b.this.nDN.setSelection(b.this.nDN.getText().length());
                b.this.nDL.showToast(b.this.nDL.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.nDT != null) {
                    if (!b.this.nDT.dQu()) {
                        b.this.yu(false);
                    }
                    b.this.nDT.yh(false);
                }
            }
        });
        this.nDW = new a();
        this.nDV.setAdapter((ListAdapter) this.nDW);
        this.nEa = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.nEa) {
            ap.setBackgroundResource(this.nDY, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.nDY, R.drawable.corner_bg_radio_unselected);
        }
        ap.setViewTextColor(this.nDZ, R.color.cp_cont_g);
        this.nDX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.nEa) {
                    b.this.nEa = false;
                    com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    ap.setBackgroundResource(b.this.nDY, R.drawable.corner_bg_radio_unselected);
                    b.this.nDY.invalidate();
                    return;
                }
                b.this.nEa = true;
                com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                ap.setBackgroundResource(b.this.nDY, R.drawable.corner_bg_radio_selected);
                b.this.nDY.invalidate();
            }
        });
    }

    public void UB(String str) {
        int i;
        int i2 = 0;
        Bitmap RQ = RQ(str);
        if (RQ != null && RQ.getHeight() != 0) {
            if (RQ.getHeight() <= 0) {
                i = 0;
            } else if (RQ.getWidth() / RQ.getHeight() > l.getEquipmentWidth(this.nDL) / l.getDimens(this.nDL, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.nDL);
                if (RQ.getWidth() > 0) {
                    i2 = (int) ((i / RQ.getWidth()) * RQ.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.nDL, R.dimen.ds440);
                if (RQ.getWidth() > 0) {
                    i = (int) ((dimens / RQ.getHeight()) * RQ.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.nlh.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.nlh.setLayoutParams(layoutParams);
            this.nlh.setImageBitmap(RQ);
        }
    }

    private Bitmap RQ(String str) {
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
        this.nDL.getLayoutMode().setNightMode(i == 1);
        this.nDL.getLayoutMode().onModeChanged(this.gMq);
        this.mNavigationBar.onChangeSkinType(this.nDL.getPageContext(), i);
        SvgManager.boN().a(this.nDS, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.nDM, R.color.cp_link_tip_a, 1);
        ap.c(this.nDQ, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        this.nEa = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.nEa) {
            ap.setBackgroundResource(this.nDY, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.nDY, R.drawable.corner_bg_radio_unselected);
        }
        if (this.nDQ != null) {
            this.nDQ.onChangeSkinType(i);
        }
        if (this.nDP != null) {
            this.nDP.onChangeSkinType(i);
        }
        if (this.nEb != null) {
            this.nEb.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.nDN.getText() == null) {
            return null;
        }
        return this.nDN.getText().toString();
    }

    public long dRO() {
        if (this.nDN.getText() == null || this.nDN.getText().toString() == null) {
            return 0L;
        }
        return this.nDN.getText().length();
    }

    public WriteLocationView dRP() {
        return this.nDQ;
    }

    public View dRQ() {
        return this.nDM;
    }

    public View getBackButton() {
        return this.nDS;
    }

    public EditText dRR() {
        return this.nDN;
    }

    public StateSwitchView dRS() {
        return this.nDP;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                UB(thumbPath);
                this.nlh.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nlh.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.nlh.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.nle.setVideoPath(videoPath);
                this.nle.start();
            }
        }
        if (!y.isEmpty(list)) {
            this.nDW.fU(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.nDN.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.nDW.fU(arrayList);
            this.nDN.setText("#" + videoTitleData.name + "#");
        }
    }

    public void dNu() {
        if (this.nle != null) {
            this.nle.resume();
            this.nle.seekTo(this.nlo);
            this.nle.start();
        }
    }

    public void cyB() {
        this.nlo = this.nle.getCurrentPosition();
        if (this.nle != null) {
            this.nle.stopPlayback();
        }
    }

    public void UC(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.nDL.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.nDL.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dRT() {
        this.nDT.bk(null);
        this.nDT.yg(false);
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.nDT.bk(postWriteCallBackData.getSensitiveWords());
            this.nDT.Uj(postWriteCallBackData.getErrorString());
            if (!y.isEmpty(this.nDT.dQr())) {
                yu(true);
            }
        }
    }

    public void yu(boolean z) {
        if (this.nDN.getText() != null) {
            int selectionEnd = this.nDN.getSelectionEnd();
            SpannableStringBuilder c = this.nDT.c(this.nDN.getText());
            if (c != null) {
                this.nDT.yh(true);
                this.nDN.setText(c);
                if (z && this.nDT.dQs() >= 0) {
                    this.nDN.requestFocus();
                    this.nDN.setSelection(this.nDT.dQs());
                } else {
                    this.nDN.setSelection(selectionEnd);
                }
                this.nDT.yg(this.nDT.dQs() >= 0);
            }
        }
    }

    public c dRU() {
        return this.nDT;
    }

    public void yv(boolean z) {
        if (z) {
            this.nDU.setVisibility(8);
            this.nDR.setVisibility(0);
            this.czb.smoothScrollTo(0, this.nDR.getBottom());
        }
    }
}
