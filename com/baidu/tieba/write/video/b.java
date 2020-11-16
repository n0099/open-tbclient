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
    public static int nLf = 60;
    private ScrollView cDk;
    private RelativeLayout gSw;
    private NavigationBar mNavigationBar;
    private TextView mTitle;
    private WriteVideoActivity nLg;
    private TextView nLh;
    private EditText nLi;
    private StateSwitchView nLj;
    private StateSwitchView nLk;
    private WriteLocationView nLl;
    private TextView nLm;
    private ImageView nLn;
    private c nLo;
    private LinearLayout nLp;
    private ListView nLq;
    private a nLr;
    private LinearLayout nLs;
    private TextView nLt;
    private TextView nLu;
    private ForumTabSelectedView nLw;
    private CustomVideoView nsi;
    private ImageView nsl;
    private int nss;
    private boolean nLv = true;
    private boolean nLa = false;

    public b(WriteVideoActivity writeVideoActivity) {
        this.nLg = writeVideoActivity;
        this.nLg.setContentView(R.layout.write_video_activity);
        this.nLo = new c();
        this.nLo.LJ(R.color.CAM_X0101);
        this.nLo.LK(R.color.cp_cont_h_alpha85);
        Hq();
        initView();
    }

    public void yJ(boolean z) {
        this.nLa = z;
        if (z) {
            if (this.nLk != null) {
                this.nLk.setVisibility(8);
            }
            if (this.nLl != null) {
                this.nLl.setVisibility(8);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(this.nLg.getPageContext().getString(R.string.publish_video_to_dynamic_title));
            }
        }
    }

    private void Hq() {
        this.gSw = (RelativeLayout) this.nLg.findViewById(R.id.layout_root);
        this.mNavigationBar = (NavigationBar) this.nLg.findViewById(R.id.navigation_bar);
        this.nLi = (EditText) this.nLg.findViewById(R.id.edit_content);
        this.nLm = (TextView) this.nLg.findViewById(R.id.text_content_size);
        this.nsl = (ImageView) this.nLg.findViewById(R.id.video_cover);
        this.nsi = (CustomVideoView) this.nLg.findViewById(R.id.preview_videoview);
        this.cDk = (ScrollView) this.nLg.findViewById(R.id.write_scrollview);
        this.nsi.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.tieba.write.video.b.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (b.this.nsi.getWidth() != b.this.nsl.getWidth() || b.this.nsi.getHeight() != b.this.nsl.getHeight()) {
                    ViewGroup.LayoutParams layoutParams = b.this.nsl.getLayoutParams();
                    layoutParams.width = b.this.nsi.getWidth();
                    layoutParams.height = b.this.nsi.getHeight();
                    b.this.nsl.setLayoutParams(layoutParams);
                }
                b.this.nsl.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nsi.start();
                        b.this.nsl.setVisibility(8);
                    }
                }, 500L);
            }
        });
        this.nsi.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.write.video.b.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                b.this.dA(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        this.nLp = (LinearLayout) this.nLg.findViewById(R.id.video_activity_title_container);
        this.nLq = (ListView) this.nLg.findViewById(R.id.video_activity_title_list);
        this.nLq.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.video.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.nLp.setVisibility(8);
                b.this.nLm.setVisibility(0);
                if (adapterView != null && (adapterView.getItemAtPosition(i) instanceof VideoTitleData)) {
                    b.this.nLi.setText("#" + ((VideoTitleData) adapterView.getItemAtPosition(i)).name + "#");
                    b.this.nLi.requestFocus();
                    if (!TextUtils.isEmpty(b.this.nLi.getText())) {
                        b.this.nLi.setSelection(b.this.nLi.getText().length());
                    }
                    l.showSoftKeyPad(b.this.nLg, b.this.nLi);
                }
            }
        });
        this.nLs = (LinearLayout) this.nLg.findViewById(R.id.save_video_wrapper);
        this.nLt = (TextView) this.nLg.findViewById(R.id.save_video_ridiobutton);
        this.nLu = (TextView) this.nLg.findViewById(R.id.save_video_ridiotext);
        this.nLl = (WriteLocationView) this.nLg.findViewById(R.id.location);
        this.nLk = (StateSwitchView) this.nLg.findViewById(R.id.view_privacy);
        this.nLk.setStateString(this.nLg.getString(R.string.display_on_my_home_page), this.nLg.getString(R.string.display_on_my_home_page));
        this.nLk.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_stroke1_n_svg, R.color.CAM_X0106));
        this.nLk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.nLk.bex();
            }
        });
        this.nLk.setTextSize(0, this.nLg.getResources().getDimensionPixelSize(R.dimen.ds28));
    }

    public void c(FrsTabInfoData frsTabInfoData) {
        this.nLw = (ForumTabSelectedView) this.nLg.findViewById(R.id.frs_tab_list);
        this.nLw.setData(frsTabInfoData);
        this.nLw.setActivity(this.nLg);
    }

    public ForumTabSelectedView dUm() {
        return this.nLw;
    }

    public boolean isToDynamic() {
        return this.nLj != null && this.nLj.getState() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 <= 0) {
            i3 = 0;
        } else if (i / i2 > l.getEquipmentWidth(this.nLg) / l.getDimens(this.nLg, R.dimen.ds440)) {
            i3 = l.getEquipmentWidth(this.nLg);
            if (i > 0) {
                i4 = (int) ((i3 / i) * i2);
            }
        } else {
            int dimens = l.getDimens(this.nLg, R.dimen.ds440);
            if (i2 > 0) {
                i3 = (int) ((dimens / i2) * i);
                i4 = dimens;
            } else {
                i3 = 0;
                i4 = dimens;
            }
        }
        this.nsi.setVideoHeight(i4);
        this.nsi.setVideoWidth(i3);
        this.nsi.invalidate();
    }

    private void initView() {
        this.nLn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_close_layout, this.nLg);
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.nLg.getPageContext().getString(R.string.post_video_title));
        if (this.nLa) {
            this.mTitle.setText(this.nLg.getPageContext().getString(R.string.publish_video_to_dynamic_title));
        }
        this.nLh = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nav_text_send_layout, this.nLg);
        this.nLh.setText(R.string.send_post);
        this.nLi.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.b.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.nLi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.b.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if ("#".equals(charSequence.toString()) && b.this.nLr != null && b.this.nLr.getCount() > 0) {
                    l.hideSoftKeyPad(b.this.nLg, b.this.nLi);
                    b.this.nLp.setVisibility(0);
                    b.this.nLm.setVisibility(8);
                }
                long dUn = b.nLf - b.this.dUn();
                if (dUn >= 0) {
                    ap.setViewTextColor(b.this.nLm, R.color.CAM_X0110);
                    b.this.nLm.setText(String.valueOf(dUn));
                    return;
                }
                b.this.nLm.setText("0");
                b.this.nLi.setText(b.this.nLi.getText().toString().substring(0, b.nLf));
                b.this.nLi.setSelection(b.this.nLi.getText().length());
                b.this.nLg.showToast(b.this.nLg.getResources().getString(R.string.video_content_overflow));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (b.this.nLo != null) {
                    if (!b.this.nLo.dSV()) {
                        b.this.yK(false);
                    }
                    b.this.nLo.yx(false);
                }
            }
        });
        this.nLr = new a();
        this.nLq.setAdapter((ListAdapter) this.nLr);
        this.nLv = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.nLv) {
            ap.setBackgroundResource(this.nLt, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.nLt, R.drawable.corner_bg_radio_unselected);
        }
        ap.setViewTextColor(this.nLu, R.color.CAM_X0111);
        this.nLs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.video.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.nLv) {
                    b.this.nLv = false;
                    com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, false);
                    ap.setBackgroundResource(b.this.nLt, R.drawable.corner_bg_radio_unselected);
                    b.this.nLt.invalidate();
                    return;
                }
                b.this.nLv = true;
                com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                ap.setBackgroundResource(b.this.nLt, R.drawable.corner_bg_radio_selected);
                b.this.nLt.invalidate();
            }
        });
    }

    public void UD(String str) {
        int i;
        int i2 = 0;
        Bitmap RI = RI(str);
        if (RI != null && RI.getHeight() != 0) {
            if (RI.getHeight() <= 0) {
                i = 0;
            } else if (RI.getWidth() / RI.getHeight() > l.getEquipmentWidth(this.nLg) / l.getDimens(this.nLg, R.dimen.ds440)) {
                i = l.getEquipmentWidth(this.nLg);
                if (RI.getWidth() > 0) {
                    i2 = (int) ((i / RI.getWidth()) * RI.getHeight());
                }
            } else {
                int dimens = l.getDimens(this.nLg, R.dimen.ds440);
                if (RI.getWidth() > 0) {
                    i = (int) ((dimens / RI.getHeight()) * RI.getWidth());
                    i2 = dimens;
                } else {
                    i = 0;
                    i2 = dimens;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.nsl.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.nsl.setLayoutParams(layoutParams);
            this.nsl.setImageBitmap(RI);
        }
    }

    private Bitmap RI(String str) {
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
        this.nLg.getLayoutMode().setNightMode(i == 1);
        this.nLg.getLayoutMode().onModeChanged(this.gSw);
        this.mNavigationBar.onChangeSkinType(this.nLg.getPageContext(), i);
        SvgManager.bqB().a(this.nLn, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.nLh, R.color.CAM_X0302, 1);
        ap.c(this.nLl, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
        this.nLv = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
        if (this.nLv) {
            ap.setBackgroundResource(this.nLt, R.drawable.corner_bg_radio_selected);
        } else {
            ap.setBackgroundResource(this.nLt, R.drawable.corner_bg_radio_unselected);
        }
        if (this.nLl != null) {
            this.nLl.onChangeSkinType(i);
        }
        if (this.nLk != null) {
            this.nLk.onChangeSkinType(i);
        }
        if (this.nLw != null) {
            this.nLw.onChangeSkinType(i);
        }
    }

    public String getContent() {
        if (this.nLi.getText() == null) {
            return null;
        }
        return this.nLi.getText().toString();
    }

    public long dUn() {
        if (this.nLi.getText() == null || this.nLi.getText().toString() == null) {
            return 0L;
        }
        return this.nLi.getText().length();
    }

    public WriteLocationView dUo() {
        return this.nLl;
    }

    public View dUp() {
        return this.nLh;
    }

    public View getBackButton() {
        return this.nLn;
    }

    public EditText dUq() {
        return this.nLi;
    }

    public StateSwitchView dUr() {
        return this.nLk;
    }

    public void a(VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        if (videoInfo != null) {
            String videoPath = videoInfo.getVideoPath();
            String thumbPath = videoInfo.getThumbPath();
            if (!StringUtils.isNull(thumbPath)) {
                UD(thumbPath);
                this.nsl.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.video.b.8
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nsl.setVisibility(8);
                    }
                }, 500L);
            } else {
                this.nsl.setVisibility(8);
            }
            if (!StringUtils.isNull(videoPath)) {
                this.nsi.setVideoPath(videoPath);
                this.nsi.start();
            }
        }
        if (!y.isEmpty(list)) {
            this.nLr.gc(list);
            if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
                this.nLi.setText("#" + videoTitleData.name + "#");
            }
        } else if (videoTitleData != null && !StringUtils.isNull(videoTitleData.name)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoTitleData);
            this.nLr.gc(arrayList);
            this.nLi.setText("#" + videoTitleData.name + "#");
        }
    }

    public void dPV() {
        if (this.nsi != null) {
            this.nsi.resume();
            this.nsi.seekTo(this.nss);
            this.nsi.start();
        }
    }

    public void cAF() {
        this.nss = this.nsi.getCurrentPosition();
        if (this.nsi != null) {
            this.nsi.stopPlayback();
        }
    }

    public void UE(String str) {
        if (StringUtils.isNull(str)) {
            this.mNavigationBar.setCenterTextTitle(this.nLg.getResources().getString(R.string.post_to_home_page));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.nLg.getResources().getString(R.string.post_to) + str);
        }
    }

    public void dUs() {
        this.nLo.bl(null);
        this.nLo.yw(false);
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.nLo.bl(postWriteCallBackData.getSensitiveWords());
            this.nLo.Ul(postWriteCallBackData.getErrorString());
            if (!y.isEmpty(this.nLo.dSS())) {
                yK(true);
            }
        }
    }

    public void yK(boolean z) {
        if (this.nLi.getText() != null) {
            int selectionEnd = this.nLi.getSelectionEnd();
            SpannableStringBuilder c = this.nLo.c(this.nLi.getText());
            if (c != null) {
                this.nLo.yx(true);
                this.nLi.setText(c);
                if (z && this.nLo.dST() >= 0) {
                    this.nLi.requestFocus();
                    this.nLi.setSelection(this.nLo.dST());
                } else {
                    this.nLi.setSelection(selectionEnd);
                }
                this.nLo.yw(this.nLo.dST() >= 0);
            }
        }
    }

    public c dUt() {
        return this.nLo;
    }

    public void yL(boolean z) {
        if (z) {
            this.nLp.setVisibility(8);
            this.nLm.setVisibility(0);
            this.cDk.smoothScrollTo(0, this.nLm.getBottom());
        }
    }
}
