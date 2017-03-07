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
    public static int fNr = 31;
    private static int fNs = -100;
    private View bsF;
    private TbImageView bsH;
    private ImageView bsJ;
    private ImageView dJz;
    private WriteVideoActivity fNt;
    private TextView fNu;
    private EditText fNv;
    private TextView fNw;
    private WriteLocationView fNx;
    private HeadImageView fNy;
    private NavigationBar mNavigationBar;

    public m(WriteVideoActivity writeVideoActivity) {
        this.fNt = writeVideoActivity;
        this.fNt.setContentView(w.j.write_video_activity);
        bnv();
        initView();
    }

    private void bnv() {
        this.bsF = this.fNt.findViewById(w.h.layout_root);
        this.mNavigationBar = (NavigationBar) this.fNt.findViewById(w.h.navigation_bar);
        this.fNy = (HeadImageView) this.fNt.findViewById(w.h.write_user_head_portrait);
        this.fNv = (EditText) this.fNt.findViewById(w.h.edit_content);
        this.fNw = (TextView) this.fNt.findViewById(w.h.text_content_size);
        this.bsH = (TbImageView) this.fNt.findViewById(w.h.image_video);
        this.bsJ = (ImageView) this.fNt.findViewById(w.h.image_video_play);
        this.fNx = (WriteLocationView) this.fNt.findViewById(w.h.location);
    }

    private void initView() {
        this.bsH.setOnClickListener(this.fNt);
        this.dJz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.nav_close_layout, this.fNt);
        this.mNavigationBar.setCenterTextTitle(this.fNt.getPageContext().getString(w.l.new_video_post));
        this.fNu = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nav_text_send_layout, this.fNt);
        this.fNw.setText(String.valueOf(fNr));
        this.fNy.setIsRound(true);
        this.fNy.setDrawBorder(false);
        this.fNy.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dg = q.dg(currentPortrait);
            this.fNy.setUrl(dg);
            this.fNy.c(dg, 12, false);
        }
        this.fNv.addTextChangedListener(new n(this));
        this.fNv.setOnKeyListener(new o(this));
    }

    public void qL(String str) {
        Bitmap qM = qM(str);
        if (qM != null) {
            this.bsH.setImageBitmap(qM);
        }
    }

    private Bitmap qM(String str) {
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
        this.fNt.getLayoutMode().ah(i == 1);
        this.fNt.getLayoutMode().t(this.bsF);
        this.mNavigationBar.onChangeSkinType(this.fNt.getPageContext(), i);
        aq.c(this.dJz, w.g.icon_nav_close_selector);
        aq.c(this.fNu, w.e.cp_link_tip_a, 1);
        this.fNx.wP();
    }

    public String getContent() {
        if (this.fNv.getText() == null) {
            return null;
        }
        return this.fNv.getText().toString();
    }

    public long bnw() {
        if (this.fNv.getText() == null || this.fNv.getText().toString() == null) {
            return 0L;
        }
        return g(this.fNv.getText().toString().trim());
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

    public WriteLocationView bnx() {
        return this.fNx;
    }

    public View bny() {
        return this.bsH;
    }

    public View bnz() {
        return this.fNu;
    }

    public View apg() {
        return this.dJz;
    }

    public View bnA() {
        return this.fNv;
    }

    public void cI(long j) {
        if (this.bsH != null) {
            this.bsH.setContentDescription(String.valueOf(this.fNt.getResources().getString(w.l.video)) + au.s(j));
        }
    }
}
