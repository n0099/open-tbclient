package com.baidu.tieba.write.video;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class m {
    public static int fIY = 31;
    private static int fIZ = -100;
    private View blM;
    private TbImageView blO;
    private ImageView blQ;
    private ImageView dGS;
    private WriteVideoActivity fJa;
    private TextView fJb;
    private EditText fJc;
    private TextView fJd;
    private WriteLocationView fJe;
    private HeadImageView fJf;
    private NavigationBar mNavigationBar;

    public m(WriteVideoActivity writeVideoActivity) {
        this.fJa = writeVideoActivity;
        this.fJa.setContentView(r.j.write_video_activity);
        bnI();
        initView();
    }

    private void bnI() {
        this.blM = this.fJa.findViewById(r.h.layout_root);
        this.mNavigationBar = (NavigationBar) this.fJa.findViewById(r.h.navigation_bar);
        this.fJf = (HeadImageView) this.fJa.findViewById(r.h.write_user_head_portrait);
        this.fJc = (EditText) this.fJa.findViewById(r.h.edit_content);
        this.fJd = (TextView) this.fJa.findViewById(r.h.text_content_size);
        this.blO = (TbImageView) this.fJa.findViewById(r.h.image_video);
        this.blQ = (ImageView) this.fJa.findViewById(r.h.image_video_play);
        this.fJe = (WriteLocationView) this.fJa.findViewById(r.h.location);
    }

    private void initView() {
        this.blO.setOnClickListener(this.fJa);
        this.dGS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.j.nav_close_layout, this.fJa);
        this.mNavigationBar.setCenterTextTitle(this.fJa.getPageContext().getString(r.l.new_video_post));
        this.fJb = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.nav_text_send_layout, this.fJa);
        this.fJd.setText(String.valueOf(fIY));
        this.fJf.setIsRound(true);
        this.fJf.setDrawBorder(false);
        this.fJf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dn = p.dn(currentPortrait);
            this.fJf.setUrl(dn);
            this.fJf.c(dn, 12, false);
        }
        this.fJc.addTextChangedListener(new n(this));
        this.fJc.setOnKeyListener(new o(this));
    }

    public void rD(String str) {
        Bitmap rE = rE(str);
        if (rE != null) {
            this.blO.setImageBitmap(rE);
        }
    }

    private Bitmap rE(String str) {
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
        this.fJa.getLayoutMode().ai(i == 1);
        this.fJa.getLayoutMode().v(this.blM);
        this.mNavigationBar.onChangeSkinType(this.fJa.getPageContext(), i);
        ap.c(this.dGS, r.g.icon_nav_close_selector);
        ap.c(this.fJb, r.e.cp_link_tip_a, 1);
        this.fJe.ws();
    }

    public String getContent() {
        if (this.fJc.getText() == null) {
            return null;
        }
        return this.fJc.getText().toString();
    }

    public long bnJ() {
        if (this.fJc.getText() == null || this.fJc.getText().toString() == null) {
            return 0L;
        }
        return g(this.fJc.getText().toString().trim());
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

    public WriteLocationView bnK() {
        return this.fJe;
    }

    public View bnL() {
        return this.blO;
    }

    public View bnM() {
        return this.fJb;
    }

    public View apM() {
        return this.dGS;
    }

    public View bnN() {
        return this.fJc;
    }

    public void cF(long j) {
        if (this.blO != null) {
            this.blO.setContentDescription(String.valueOf(this.fJa.getResources().getString(r.l.video)) + at.t(j));
        }
    }
}
