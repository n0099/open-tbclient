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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class n {
    public static int gis = 31;
    private static int git = -100;
    private View bBs;
    private TbImageView byK;
    private ImageView byL;
    private ImageView dQI;
    private WriteVideoActivity giu;
    private TextView giv;
    private EditText giw;
    private TextView gix;
    private WriteLocationView giy;
    private HeadImageView giz;
    private NavigationBar mNavigationBar;

    public n(WriteVideoActivity writeVideoActivity) {
        this.giu = writeVideoActivity;
        this.giu.setContentView(w.j.write_video_activity);
        bte();
        initView();
    }

    private void bte() {
        this.bBs = this.giu.findViewById(w.h.layout_root);
        this.mNavigationBar = (NavigationBar) this.giu.findViewById(w.h.navigation_bar);
        this.giz = (HeadImageView) this.giu.findViewById(w.h.write_user_head_portrait);
        this.giw = (EditText) this.giu.findViewById(w.h.edit_content);
        this.gix = (TextView) this.giu.findViewById(w.h.text_content_size);
        this.byK = (TbImageView) this.giu.findViewById(w.h.image_video);
        this.byL = (ImageView) this.giu.findViewById(w.h.image_video_play);
        this.giy = (WriteLocationView) this.giu.findViewById(w.h.location);
    }

    private void initView() {
        this.byK.setOnClickListener(this.giu);
        this.dQI = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.nav_close_layout, this.giu);
        this.mNavigationBar.setCenterTextTitle(this.giu.getPageContext().getString(w.l.new_video_post));
        this.giv = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nav_text_send_layout, this.giu);
        this.gix.setText(String.valueOf(gis));
        this.giz.setIsRound(true);
        this.giz.setDrawBorder(false);
        this.giz.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dC = s.dC(currentPortrait);
            this.giz.setUrl(dC);
            this.giz.c(dC, 12, false);
        }
        this.giw.addTextChangedListener(new o(this));
        this.giw.setOnKeyListener(new p(this));
    }

    public void sp(String str) {
        Bitmap sq = sq(str);
        if (sq != null) {
            this.byK.setImageBitmap(sq);
        }
    }

    private Bitmap sq(String str) {
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
        this.giu.getLayoutMode().ah(i == 1);
        this.giu.getLayoutMode().t(this.bBs);
        this.mNavigationBar.onChangeSkinType(this.giu.getPageContext(), i);
        as.c(this.dQI, w.g.icon_nav_close_selector);
        as.c(this.giv, w.e.cp_link_tip_a, 1);
        if (this.giy != null) {
            this.giy.wK();
        }
    }

    public String getContent() {
        if (this.giw.getText() == null) {
            return null;
        }
        return this.giw.getText().toString();
    }

    public long btf() {
        if (this.giw.getText() == null || this.giw.getText().toString() == null) {
            return 0L;
        }
        return g(this.giw.getText().toString().trim());
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

    public WriteLocationView btg() {
        return this.giy;
    }

    public View bth() {
        return this.byK;
    }

    public View bti() {
        return this.giv;
    }

    public View getBackButton() {
        return this.dQI;
    }

    public View btj() {
        return this.giw;
    }

    public void cO(long j) {
        if (this.byK != null) {
            this.byK.setContentDescription(String.valueOf(this.giu.getResources().getString(w.l.video)) + aw.s(j));
        }
    }

    public void sr(String str) {
        this.giw.setText(str);
    }
}
