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
    public static int gDX = 31;
    private static int gDY = -100;
    private TbImageView bHE;
    private ImageView bHF;
    private View bKl;
    private ImageView ejC;
    private WriteVideoActivity gDZ;
    private TextView gEa;
    private EditText gEb;
    private TextView gEc;
    private WriteLocationView gEd;
    private HeadImageView gEe;
    private NavigationBar mNavigationBar;

    public a(WriteVideoActivity writeVideoActivity) {
        this.gDZ = writeVideoActivity;
        this.gDZ.setContentView(d.j.write_video_activity);
        byH();
        initView();
    }

    private void byH() {
        this.bKl = this.gDZ.findViewById(d.h.layout_root);
        this.mNavigationBar = (NavigationBar) this.gDZ.findViewById(d.h.navigation_bar);
        this.gEe = (HeadImageView) this.gDZ.findViewById(d.h.write_user_head_portrait);
        this.gEb = (EditText) this.gDZ.findViewById(d.h.edit_content);
        this.gEc = (TextView) this.gDZ.findViewById(d.h.text_content_size);
        this.bHE = (TbImageView) this.gDZ.findViewById(d.h.image_video);
        this.bHF = (ImageView) this.gDZ.findViewById(d.h.image_video_play);
        this.gEd = (WriteLocationView) this.gDZ.findViewById(d.h.location);
    }

    private void initView() {
        this.bHE.setOnClickListener(this.gDZ);
        this.ejC = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.nav_close_layout, this.gDZ);
        this.mNavigationBar.setCenterTextTitle(this.gDZ.getPageContext().getString(d.l.new_video_post));
        this.gEa = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nav_text_send_layout, this.gDZ);
        this.gEc.setText(String.valueOf(gDX));
        this.gEe.setIsRound(true);
        this.gEe.setDrawBorder(false);
        this.gEe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dG = o.dG(currentPortrait);
            this.gEe.setUrl(dG);
            this.gEe.c(dG, 12, false);
        }
        this.gEb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.video.a.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                long byI = a.gDX - a.this.byI();
                if (byI >= 0) {
                    aj.i(a.this.gEc, d.e.cp_cont_e);
                } else {
                    aj.i(a.this.gEc, d.e.cp_cont_h);
                }
                if (byI <= a.gDY) {
                    a.this.gEc.setText(am.vN());
                } else {
                    a.this.gEc.setText(String.valueOf(byI));
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gEb.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.write.video.a.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
    }

    public void tc(String str) {
        Bitmap rq = rq(str);
        if (rq != null) {
            this.bHE.setImageBitmap(rq);
        }
    }

    private Bitmap rq(String str) {
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
        this.gDZ.getLayoutMode().ah(i == 1);
        this.gDZ.getLayoutMode().t(this.bKl);
        this.mNavigationBar.onChangeSkinType(this.gDZ.getPageContext(), i);
        aj.c(this.ejC, d.g.icon_nav_close_selector);
        aj.c(this.gEa, d.e.cp_link_tip_a, 1);
        if (this.gEd != null) {
            this.gEd.xc();
        }
    }

    public String getContent() {
        if (this.gEb.getText() == null) {
            return null;
        }
        return this.gEb.getText().toString();
    }

    public long byI() {
        if (this.gEb.getText() == null || this.gEb.getText().toString() == null) {
            return 0L;
        }
        return g(this.gEb.getText().toString().trim());
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

    public WriteLocationView byJ() {
        return this.gEd;
    }

    public View byK() {
        return this.bHE;
    }

    public View byL() {
        return this.gEa;
    }

    public View getBackButton() {
        return this.ejC;
    }

    public View byM() {
        return this.gEb;
    }

    public void cW(long j) {
        if (this.bHE != null) {
            this.bHE.setContentDescription(this.gDZ.getResources().getString(d.l.video) + am.t(j));
        }
    }

    public void td(String str) {
        this.gEb.setText(str);
    }
}
