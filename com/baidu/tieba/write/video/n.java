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
public class n {
    public static int fXs = 31;
    private static int fXt = -100;
    private View bAz;
    private TbImageView bvZ;
    private ImageView bwa;
    private ImageView dIj;
    private WriteVideoActivity fXu;
    private TextView fXv;
    private EditText fXw;
    private TextView fXx;
    private WriteLocationView fXy;
    private HeadImageView fXz;
    private NavigationBar mNavigationBar;

    public n(WriteVideoActivity writeVideoActivity) {
        this.fXu = writeVideoActivity;
        this.fXu.setContentView(w.j.write_video_activity);
        boG();
        initView();
    }

    private void boG() {
        this.bAz = this.fXu.findViewById(w.h.layout_root);
        this.mNavigationBar = (NavigationBar) this.fXu.findViewById(w.h.navigation_bar);
        this.fXz = (HeadImageView) this.fXu.findViewById(w.h.write_user_head_portrait);
        this.fXw = (EditText) this.fXu.findViewById(w.h.edit_content);
        this.fXx = (TextView) this.fXu.findViewById(w.h.text_content_size);
        this.bvZ = (TbImageView) this.fXu.findViewById(w.h.image_video);
        this.bwa = (ImageView) this.fXu.findViewById(w.h.image_video_play);
        this.fXy = (WriteLocationView) this.fXu.findViewById(w.h.location);
    }

    private void initView() {
        this.bvZ.setOnClickListener(this.fXu);
        this.dIj = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.nav_close_layout, this.fXu);
        this.mNavigationBar.setCenterTextTitle(this.fXu.getPageContext().getString(w.l.new_video_post));
        this.fXv = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nav_text_send_layout, this.fXu);
        this.fXx.setText(String.valueOf(fXs));
        this.fXz.setIsRound(true);
        this.fXz.setDrawBorder(false);
        this.fXz.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String di = q.di(currentPortrait);
            this.fXz.setUrl(di);
            this.fXz.c(di, 12, false);
        }
        this.fXw.addTextChangedListener(new o(this));
        this.fXw.setOnKeyListener(new p(this));
    }

    public void rq(String str) {
        Bitmap rr = rr(str);
        if (rr != null) {
            this.bvZ.setImageBitmap(rr);
        }
    }

    private Bitmap rr(String str) {
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
        this.fXu.getLayoutMode().ah(i == 1);
        this.fXu.getLayoutMode().t(this.bAz);
        this.mNavigationBar.onChangeSkinType(this.fXu.getPageContext(), i);
        aq.c(this.dIj, w.g.icon_nav_close_selector);
        aq.c(this.fXv, w.e.cp_link_tip_a, 1);
        if (this.fXy != null) {
            this.fXy.ws();
        }
    }

    public String getContent() {
        if (this.fXw.getText() == null) {
            return null;
        }
        return this.fXw.getText().toString();
    }

    public long boH() {
        if (this.fXw.getText() == null || this.fXw.getText().toString() == null) {
            return 0L;
        }
        return g(this.fXw.getText().toString().trim());
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

    public WriteLocationView boI() {
        return this.fXy;
    }

    public View boJ() {
        return this.bvZ;
    }

    public View boK() {
        return this.fXv;
    }

    public View getBackButton() {
        return this.dIj;
    }

    public View boL() {
        return this.fXw;
    }

    public void cz(long j) {
        if (this.bvZ != null) {
            this.bvZ.setContentDescription(String.valueOf(this.fXu.getResources().getString(w.l.video)) + au.s(j));
        }
    }
}
