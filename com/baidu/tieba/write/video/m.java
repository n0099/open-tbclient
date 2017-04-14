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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class m {
    public static int fPa = 31;
    private static int fPb = -100;
    private ImageView bsB;
    private View bsx;
    private TbImageView bsz;
    private ImageView dFY;
    private WriteVideoActivity fPc;
    private TextView fPd;
    private EditText fPe;
    private TextView fPf;
    private WriteLocationView fPg;
    private HeadImageView fPh;
    private NavigationBar mNavigationBar;

    public m(WriteVideoActivity writeVideoActivity) {
        this.fPc = writeVideoActivity;
        this.fPc.setContentView(w.j.write_video_activity);
        bof();
        initView();
    }

    private void bof() {
        this.bsx = this.fPc.findViewById(w.h.layout_root);
        this.mNavigationBar = (NavigationBar) this.fPc.findViewById(w.h.navigation_bar);
        this.fPh = (HeadImageView) this.fPc.findViewById(w.h.write_user_head_portrait);
        this.fPe = (EditText) this.fPc.findViewById(w.h.edit_content);
        this.fPf = (TextView) this.fPc.findViewById(w.h.text_content_size);
        this.bsz = (TbImageView) this.fPc.findViewById(w.h.image_video);
        this.bsB = (ImageView) this.fPc.findViewById(w.h.image_video_play);
        this.fPg = (WriteLocationView) this.fPc.findViewById(w.h.location);
    }

    private void initView() {
        this.bsz.setOnClickListener(this.fPc);
        this.dFY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.nav_close_layout, this.fPc);
        this.mNavigationBar.setCenterTextTitle(this.fPc.getPageContext().getString(w.l.new_video_post));
        this.fPd = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nav_text_send_layout, this.fPc);
        this.fPf.setText(String.valueOf(fPa));
        this.fPh.setIsRound(true);
        this.fPh.setDrawBorder(false);
        this.fPh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dn = q.dn(currentPortrait);
            this.fPh.setUrl(dn);
            this.fPh.c(dn, 12, false);
        }
        this.fPe.addTextChangedListener(new n(this));
        this.fPe.setOnKeyListener(new o(this));
    }

    public void rf(String str) {
        Bitmap rg = rg(str);
        if (rg != null) {
            this.bsz.setImageBitmap(rg);
        }
    }

    private Bitmap rg(String str) {
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
        this.fPc.getLayoutMode().aj(i == 1);
        this.fPc.getLayoutMode().t(this.bsx);
        this.mNavigationBar.onChangeSkinType(this.fPc.getPageContext(), i);
        aq.c(this.dFY, w.g.icon_nav_close_selector);
        aq.c(this.fPd, w.e.cp_link_tip_a, 1);
        this.fPg.xl();
    }

    public String getContent() {
        if (this.fPe.getText() == null) {
            return null;
        }
        return this.fPe.getText().toString();
    }

    public long bog() {
        if (this.fPe.getText() == null || this.fPe.getText().toString() == null) {
            return 0L;
        }
        return g(this.fPe.getText().toString().trim());
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

    public WriteLocationView boh() {
        return this.fPg;
    }

    public View boi() {
        return this.bsz;
    }

    public View boj() {
        return this.fPd;
    }

    public View getBackButton() {
        return this.dFY;
    }

    public View bok() {
        return this.fPe;
    }

    public void cI(long j) {
        if (this.bsz != null) {
            this.bsz.setContentDescription(String.valueOf(this.fPc.getResources().getString(w.l.video)) + au.s(j));
        }
    }
}
