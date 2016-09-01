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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class m {
    public static int gcm = 31;
    private static int gcn = -100;
    private ImageView aPU;
    private TbImageView aZj;
    private ImageView aZk;
    private View bav;
    private WriteVideoActivity gco;
    private TextView gcp;
    private EditText gcq;
    private TextView gcr;
    private WriteLocationView gcs;
    private HeadImageView gct;
    private NavigationBar mNavigationBar;

    public m(WriteVideoActivity writeVideoActivity) {
        this.gco = writeVideoActivity;
        this.gco.setContentView(t.h.write_video_activity);
        bsn();
        initView();
    }

    private void bsn() {
        this.bav = this.gco.findViewById(t.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.gco.findViewById(t.g.navigation_bar);
        this.gct = (HeadImageView) this.gco.findViewById(t.g.write_user_head_portrait);
        this.gcq = (EditText) this.gco.findViewById(t.g.edit_content);
        this.gcr = (TextView) this.gco.findViewById(t.g.text_content_size);
        this.aZj = (TbImageView) this.gco.findViewById(t.g.image_video);
        this.aZk = (ImageView) this.gco.findViewById(t.g.image_video_play);
        this.gcs = (WriteLocationView) this.gco.findViewById(t.g.location);
    }

    private void initView() {
        this.aZj.setOnClickListener(this.gco);
        this.aPU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.nav_close_layout, this.gco);
        this.mNavigationBar.setCenterTextTitle(this.gco.getPageContext().getString(t.j.new_video_post));
        this.gcp = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nav_text_send_layout, this.gco);
        this.gcr.setText(String.valueOf(gcm));
        this.gct.setIsRound(true);
        this.gct.setDrawBorder(false);
        this.gct.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dk = q.dk(currentPortrait);
            this.gct.setUrl(dk);
            this.gct.c(dk, 12, false);
        }
        this.gcq.addTextChangedListener(new n(this));
        this.gcq.setOnKeyListener(new o(this));
    }

    public void sm(String str) {
        Bitmap sn = sn(str);
        if (sn != null) {
            this.aZj.setImageBitmap(sn);
        }
    }

    private Bitmap sn(String str) {
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
        this.gco.getLayoutMode().ah(i == 1);
        this.gco.getLayoutMode().x(this.bav);
        this.mNavigationBar.onChangeSkinType(this.gco.getPageContext(), i);
        av.c(this.aPU, t.f.icon_nav_close_selector);
        av.c(this.gcp, t.d.cp_link_tip_a, 1);
        this.gcs.wq();
    }

    public String getContent() {
        if (this.gcq.getText() == null) {
            return null;
        }
        return this.gcq.getText().toString();
    }

    public long bso() {
        if (this.gcq.getText() == null || this.gcq.getText().toString() == null) {
            return 0L;
        }
        return g(this.gcq.getText().toString().trim());
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

    public WriteLocationView bsp() {
        return this.gcs;
    }

    public View bsq() {
        return this.aZj;
    }

    public View bsr() {
        return this.gcp;
    }

    public View arK() {
        return this.aPU;
    }

    public View bss() {
        return this.gcq;
    }

    public void dd(long j) {
        if (this.aZj != null) {
            this.aZj.setContentDescription(String.valueOf(this.gco.getResources().getString(t.j.video)) + ba.v(j));
        }
    }
}
