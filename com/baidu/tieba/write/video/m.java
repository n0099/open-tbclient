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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class m {
    public static int gew = 31;
    private static int gex = -100;
    private ImageView aRg;
    private TbImageView aZE;
    private ImageView aZF;
    private View baM;
    private EditText geA;
    private TextView geB;
    private WriteLocationView geC;
    private HeadImageView geD;
    private WriteVideoActivity gey;
    private TextView gez;
    private NavigationBar mNavigationBar;

    public m(WriteVideoActivity writeVideoActivity) {
        this.gey = writeVideoActivity;
        this.gey.setContentView(r.h.write_video_activity);
        bsT();
        initView();
    }

    private void bsT() {
        this.baM = this.gey.findViewById(r.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.gey.findViewById(r.g.navigation_bar);
        this.geD = (HeadImageView) this.gey.findViewById(r.g.write_user_head_portrait);
        this.geA = (EditText) this.gey.findViewById(r.g.edit_content);
        this.geB = (TextView) this.gey.findViewById(r.g.text_content_size);
        this.aZE = (TbImageView) this.gey.findViewById(r.g.image_video);
        this.aZF = (ImageView) this.gey.findViewById(r.g.image_video_play);
        this.geC = (WriteLocationView) this.gey.findViewById(r.g.location);
    }

    private void initView() {
        this.aZE.setOnClickListener(this.gey);
        this.aRg = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.nav_close_layout, this.gey);
        this.mNavigationBar.setCenterTextTitle(this.gey.getPageContext().getString(r.j.new_video_post));
        this.gez = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.nav_text_send_layout, this.gey);
        this.geB.setText(String.valueOf(gew));
        this.geD.setIsRound(true);
        this.geD.setDrawBorder(false);
        this.geD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dm = q.dm(currentPortrait);
            this.geD.setUrl(dm);
            this.geD.c(dm, 12, false);
        }
        this.geA.addTextChangedListener(new n(this));
        this.geA.setOnKeyListener(new o(this));
    }

    public void sB(String str) {
        Bitmap sC = sC(str);
        if (sC != null) {
            this.aZE.setImageBitmap(sC);
        }
    }

    private Bitmap sC(String str) {
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
        this.gey.getLayoutMode().ah(i == 1);
        this.gey.getLayoutMode().x(this.baM);
        this.mNavigationBar.onChangeSkinType(this.gey.getPageContext(), i);
        av.c(this.aRg, r.f.icon_nav_close_selector);
        av.c(this.gez, r.d.cp_link_tip_a, 1);
        this.geC.wH();
    }

    public String getContent() {
        if (this.geA.getText() == null) {
            return null;
        }
        return this.geA.getText().toString();
    }

    public long bsU() {
        if (this.geA.getText() == null || this.geA.getText().toString() == null) {
            return 0L;
        }
        return g(this.geA.getText().toString().trim());
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

    public WriteLocationView bsV() {
        return this.geC;
    }

    public View bsW() {
        return this.aZE;
    }

    public View bsX() {
        return this.gez;
    }

    public View asj() {
        return this.aRg;
    }

    public View bsY() {
        return this.geA;
    }

    public void dc(long j) {
        if (this.aZE != null) {
            this.aZE.setContentDescription(String.valueOf(this.gey.getResources().getString(r.j.video)) + az.v(j));
        }
    }
}
