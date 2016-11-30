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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class m {
    public static int glZ = 31;
    private static int gma = -100;
    private ImageView aTe;
    private TbImageView bcO;
    private ImageView bcP;
    private WriteVideoActivity gmb;
    private TextView gmc;
    private EditText gmd;
    private View gme;
    private TextView gmf;
    private WriteLocationView gmg;
    private HeadImageView gmh;
    private NavigationBar mNavigationBar;

    public m(WriteVideoActivity writeVideoActivity) {
        this.gmb = writeVideoActivity;
        this.gmb.setContentView(r.h.write_video_activity);
        bvo();
        initView();
    }

    private void bvo() {
        this.gme = this.gmb.findViewById(r.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.gmb.findViewById(r.g.navigation_bar);
        this.gmh = (HeadImageView) this.gmb.findViewById(r.g.write_user_head_portrait);
        this.gmd = (EditText) this.gmb.findViewById(r.g.edit_content);
        this.gmf = (TextView) this.gmb.findViewById(r.g.text_content_size);
        this.bcO = (TbImageView) this.gmb.findViewById(r.g.image_video);
        this.bcP = (ImageView) this.gmb.findViewById(r.g.image_video_play);
        this.gmg = (WriteLocationView) this.gmb.findViewById(r.g.location);
    }

    private void initView() {
        this.bcO.setOnClickListener(this.gmb);
        this.aTe = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.nav_close_layout, this.gmb);
        this.mNavigationBar.setCenterTextTitle(this.gmb.getPageContext().getString(r.j.new_video_post));
        this.gmc = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.nav_text_send_layout, this.gmb);
        this.gmf.setText(String.valueOf(glZ));
        this.gmh.setIsRound(true);
        this.gmh.setDrawBorder(false);
        this.gmh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String m11do = q.m11do(currentPortrait);
            this.gmh.setUrl(m11do);
            this.gmh.c(m11do, 12, false);
        }
        this.gmd.addTextChangedListener(new n(this));
        this.gmd.setOnKeyListener(new o(this));
    }

    public void sX(String str) {
        Bitmap sY = sY(str);
        if (sY != null) {
            this.bcO.setImageBitmap(sY);
        }
    }

    private Bitmap sY(String str) {
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
        this.gmb.getLayoutMode().ai(i == 1);
        this.gmb.getLayoutMode().x(this.gme);
        this.mNavigationBar.onChangeSkinType(this.gmb.getPageContext(), i);
        at.c(this.aTe, r.f.icon_nav_close_selector);
        at.c(this.gmc, r.d.cp_link_tip_a, 1);
        this.gmg.wM();
    }

    public String getContent() {
        if (this.gmd.getText() == null) {
            return null;
        }
        return this.gmd.getText().toString();
    }

    public long bvp() {
        if (this.gmd.getText() == null || this.gmd.getText().toString() == null) {
            return 0L;
        }
        return g(this.gmd.getText().toString().trim());
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

    public WriteLocationView bvq() {
        return this.gmg;
    }

    public View bvr() {
        return this.bcO;
    }

    public View bvs() {
        return this.gmc;
    }

    public View aug() {
        return this.aTe;
    }

    public View bvt() {
        return this.gmd;
    }

    public void dg(long j) {
        if (this.bcO != null) {
            this.bcO.setContentDescription(String.valueOf(this.gmb.getResources().getString(r.j.video)) + ax.u(j));
        }
    }
}
