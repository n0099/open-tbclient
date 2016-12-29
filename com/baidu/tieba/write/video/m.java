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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class m {
    public static int fAC = 31;
    private static int fAD = -100;
    private ImageView aSv;
    private TbImageView bcg;
    private ImageView bch;
    private WriteVideoActivity fAE;
    private TextView fAF;
    private EditText fAG;
    private View fAH;
    private TextView fAI;
    private WriteLocationView fAJ;
    private HeadImageView fAK;
    private NavigationBar mNavigationBar;

    public m(WriteVideoActivity writeVideoActivity) {
        this.fAE = writeVideoActivity;
        this.fAE.setContentView(r.h.write_video_activity);
        bmk();
        initView();
    }

    private void bmk() {
        this.fAH = this.fAE.findViewById(r.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.fAE.findViewById(r.g.navigation_bar);
        this.fAK = (HeadImageView) this.fAE.findViewById(r.g.write_user_head_portrait);
        this.fAG = (EditText) this.fAE.findViewById(r.g.edit_content);
        this.fAI = (TextView) this.fAE.findViewById(r.g.text_content_size);
        this.bcg = (TbImageView) this.fAE.findViewById(r.g.image_video);
        this.bch = (ImageView) this.fAE.findViewById(r.g.image_video_play);
        this.fAJ = (WriteLocationView) this.fAE.findViewById(r.g.location);
    }

    private void initView() {
        this.bcg.setOnClickListener(this.fAE);
        this.aSv = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.nav_close_layout, this.fAE);
        this.mNavigationBar.setCenterTextTitle(this.fAE.getPageContext().getString(r.j.new_video_post));
        this.fAF = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.nav_text_send_layout, this.fAE);
        this.fAI.setText(String.valueOf(fAC));
        this.fAK.setIsRound(true);
        this.fAK.setDrawBorder(false);
        this.fAK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dp = q.dp(currentPortrait);
            this.fAK.setUrl(dp);
            this.fAK.c(dp, 12, false);
        }
        this.fAG.addTextChangedListener(new n(this));
        this.fAG.setOnKeyListener(new o(this));
    }

    public void rk(String str) {
        Bitmap rl = rl(str);
        if (rl != null) {
            this.bcg.setImageBitmap(rl);
        }
    }

    private Bitmap rl(String str) {
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
        this.fAE.getLayoutMode().ai(i == 1);
        this.fAE.getLayoutMode().x(this.fAH);
        this.mNavigationBar.onChangeSkinType(this.fAE.getPageContext(), i);
        ar.c(this.aSv, r.f.icon_nav_close_selector);
        ar.c(this.fAF, r.d.cp_link_tip_a, 1);
        this.fAJ.wx();
    }

    public String getContent() {
        if (this.fAG.getText() == null) {
            return null;
        }
        return this.fAG.getText().toString();
    }

    public long bml() {
        if (this.fAG.getText() == null || this.fAG.getText().toString() == null) {
            return 0L;
        }
        return g(this.fAG.getText().toString().trim());
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

    public WriteLocationView bmm() {
        return this.fAJ;
    }

    public View bmn() {
        return this.bcg;
    }

    public View bmo() {
        return this.fAF;
    }

    public View aoF() {
        return this.aSv;
    }

    public View bmp() {
        return this.fAG;
    }

    public void cM(long j) {
        if (this.bcg != null) {
            this.bcg.setContentDescription(String.valueOf(this.fAE.getResources().getString(r.j.video)) + av.u(j));
        }
    }
}
