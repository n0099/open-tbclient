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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class m {
    public static int fGg = 31;
    private static int fGh = -100;
    private ImageView aKq;
    private TbImageView aTf;
    private ImageView aTg;
    private View aUm;
    private WriteVideoActivity fGi;
    private TextView fGj;
    private EditText fGk;
    private TextView fGl;
    private WriteLocationView fGm;
    private HeadImageView fGn;
    private NavigationBar mNavigationBar;

    public m(WriteVideoActivity writeVideoActivity) {
        this.fGi = writeVideoActivity;
        this.fGi.setContentView(u.h.write_video_activity);
        blc();
        initView();
    }

    private void blc() {
        this.aUm = this.fGi.findViewById(u.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.fGi.findViewById(u.g.navigation_bar);
        this.fGn = (HeadImageView) this.fGi.findViewById(u.g.write_user_head_portrait);
        this.fGk = (EditText) this.fGi.findViewById(u.g.edit_content);
        this.fGl = (TextView) this.fGi.findViewById(u.g.text_content_size);
        this.aTf = (TbImageView) this.fGi.findViewById(u.g.image_video);
        this.aTg = (ImageView) this.fGi.findViewById(u.g.image_video_play);
        this.fGm = (WriteLocationView) this.fGi.findViewById(u.g.location);
    }

    private void initView() {
        this.aTf.setOnClickListener(this.fGi);
        this.aKq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, u.h.nav_close_layout, this.fGi);
        this.mNavigationBar.setCenterTextTitle(this.fGi.getPageContext().getString(u.j.new_video_post));
        this.fGj = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.nav_text_send_layout, this.fGi);
        this.fGl.setText(String.valueOf(fGg));
        this.fGn.setIsRound(true);
        this.fGn.setDrawBorder(false);
        this.fGn.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String di = q.di(currentPortrait);
            this.fGn.setUrl(di);
            this.fGn.c(di, 12, false);
        }
        this.fGk.addTextChangedListener(new n(this));
        this.fGk.setOnKeyListener(new o(this));
    }

    public void qS(String str) {
        Bitmap qT = qT(str);
        if (qT != null) {
            this.aTf.setImageBitmap(qT);
        }
    }

    private Bitmap qT(String str) {
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
        this.fGi.getLayoutMode().ad(i == 1);
        this.fGi.getLayoutMode().w(this.aUm);
        this.mNavigationBar.onChangeSkinType(this.fGi.getPageContext(), i);
        av.c(this.aKq, u.f.icon_nav_close_selector);
        av.c(this.fGj, u.d.cp_link_tip_a, 1);
        this.fGm.vm();
    }

    public String getContent() {
        if (this.fGk.getText() == null) {
            return null;
        }
        return this.fGk.getText().toString();
    }

    public long bld() {
        if (this.fGk.getText() == null || this.fGk.getText().toString() == null) {
            return 0L;
        }
        return g(this.fGk.getText().toString().trim());
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

    public WriteLocationView ble() {
        return this.fGm;
    }

    public View blf() {
        return this.aTf;
    }

    public View blg() {
        return this.fGj;
    }

    public View aml() {
        return this.aKq;
    }

    public View blh() {
        return this.fGk;
    }

    public void cK(long j) {
        if (this.aTf != null) {
            this.aTf.setContentDescription(String.valueOf(this.fGi.getResources().getString(u.j.video)) + ba.A(j));
        }
    }
}
