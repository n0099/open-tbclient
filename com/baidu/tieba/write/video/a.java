package com.baidu.tieba.write.video;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    public static int gEQ = 31;
    private static int gER = -100;
    private TbImageView bIv;
    private ImageView bIw;
    private View bLc;
    private ImageView ekw;
    private WriteVideoActivity gES;
    private TextView gET;
    private EditText gEU;
    private TextView gEV;
    private WriteLocationView gEW;
    private HeadImageView gEX;
    private NavigationBar mNavigationBar;

    public a(WriteVideoActivity writeVideoActivity) {
        this.gES = writeVideoActivity;
        this.gES.setContentView(d.j.write_video_activity);
        byS();
        initView();
    }

    private void byS() {
        this.bLc = this.gES.findViewById(d.h.layout_root);
        this.mNavigationBar = (NavigationBar) this.gES.findViewById(d.h.navigation_bar);
        this.gEX = (HeadImageView) this.gES.findViewById(d.h.write_user_head_portrait);
        this.gEU = (EditText) this.gES.findViewById(d.h.edit_content);
        this.gEV = (TextView) this.gES.findViewById(d.h.text_content_size);
        this.bIv = (TbImageView) this.gES.findViewById(d.h.image_video);
        this.bIw = (ImageView) this.gES.findViewById(d.h.image_video_play);
        this.gEW = (WriteLocationView) this.gES.findViewById(d.h.location);
    }

    private void initView() {
        this.bIv.setOnClickListener(this.gES);
        this.ekw = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.nav_close_layout, this.gES);
        this.mNavigationBar.setCenterTextTitle(this.gES.getPageContext().getString(d.l.new_video_post));
        this.gET = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nav_text_send_layout, this.gES);
        this.gEV.setText(String.valueOf(gEQ));
        this.gEX.setIsRound(true);
        this.gEX.setDrawBorder(false);
        this.gEX.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dG = o.dG(currentPortrait);
            this.gEX.setUrl(dG);
            this.gEX.c(dG, 12, false);
        }
        this.gEU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.a.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                long byT = a.gEQ - a.this.byT();
                if (byT >= 0) {
                    aj.i(a.this.gEV, d.e.cp_cont_e);
                } else {
                    aj.i(a.this.gEV, d.e.cp_cont_h);
                }
                if (byT <= a.gER) {
                    a.this.gEV.setText(am.vN());
                } else {
                    a.this.gEV.setText(String.valueOf(byT));
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gEU.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.a.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
    }

    public void te(String str) {
        Bitmap rs = rs(str);
        if (rs != null) {
            this.bIv.setImageBitmap(rs);
        }
    }

    private Bitmap rs(String str) {
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
        this.gES.getLayoutMode().ah(i == 1);
        this.gES.getLayoutMode().t(this.bLc);
        this.mNavigationBar.onChangeSkinType(this.gES.getPageContext(), i);
        aj.c(this.ekw, d.g.icon_nav_close_selector);
        aj.c(this.gET, d.e.cp_link_tip_a, 1);
        if (this.gEW != null) {
            this.gEW.xc();
        }
    }

    public String getContent() {
        if (this.gEU.getText() == null) {
            return null;
        }
        return this.gEU.getText().toString();
    }

    public long byT() {
        if (this.gEU.getText() == null || this.gEU.getText().toString() == null) {
            return 0L;
        }
        return g(this.gEU.getText().toString().trim());
    }

    public static long g(CharSequence charSequence) {
        if (charSequence == null) {
            return 0L;
        }
        double d = 0.0d;
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) > ' ') {
                d += 1.0d;
            }
        }
        return Math.round(d);
    }

    public WriteLocationView byU() {
        return this.gEW;
    }

    public View byV() {
        return this.bIv;
    }

    public View byW() {
        return this.gET;
    }

    public View getBackButton() {
        return this.ekw;
    }

    public View byX() {
        return this.gEU;
    }

    public void cW(long j) {
        if (this.bIv != null) {
            this.bIv.setContentDescription(this.gES.getResources().getString(d.l.video) + am.t(j));
        }
    }

    public void tf(String str) {
        this.gEU.setText(str);
    }
}
