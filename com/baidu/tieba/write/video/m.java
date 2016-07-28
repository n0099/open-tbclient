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
    public static int fSh = 31;
    private static int fSi = -100;
    private ImageView aLj;
    private TbImageView aUb;
    private ImageView aUc;
    private View aVi;
    private WriteVideoActivity fSj;
    private TextView fSk;
    private EditText fSl;
    private TextView fSm;
    private WriteLocationView fSn;
    private HeadImageView fSo;
    private NavigationBar mNavigationBar;

    public m(WriteVideoActivity writeVideoActivity) {
        this.fSj = writeVideoActivity;
        this.fSj.setContentView(u.h.write_video_activity);
        bnY();
        initView();
    }

    private void bnY() {
        this.aVi = this.fSj.findViewById(u.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.fSj.findViewById(u.g.navigation_bar);
        this.fSo = (HeadImageView) this.fSj.findViewById(u.g.write_user_head_portrait);
        this.fSl = (EditText) this.fSj.findViewById(u.g.edit_content);
        this.fSm = (TextView) this.fSj.findViewById(u.g.text_content_size);
        this.aUb = (TbImageView) this.fSj.findViewById(u.g.image_video);
        this.aUc = (ImageView) this.fSj.findViewById(u.g.image_video_play);
        this.fSn = (WriteLocationView) this.fSj.findViewById(u.g.location);
    }

    private void initView() {
        this.aUb.setOnClickListener(this.fSj);
        this.aLj = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, u.h.nav_close_layout, this.fSj);
        this.mNavigationBar.setCenterTextTitle(this.fSj.getPageContext().getString(u.j.new_video_post));
        this.fSk = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.nav_text_send_layout, this.fSj);
        this.fSm.setText(String.valueOf(fSh));
        this.fSo.setIsRound(true);
        this.fSo.setDrawBorder(false);
        this.fSo.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dh = q.dh(currentPortrait);
            this.fSo.setUrl(dh);
            this.fSo.c(dh, 12, false);
        }
        this.fSl.addTextChangedListener(new n(this));
        this.fSl.setOnKeyListener(new o(this));
    }

    public void rC(String str) {
        Bitmap rD = rD(str);
        if (rD != null) {
            this.aUb.setImageBitmap(rD);
        }
    }

    private Bitmap rD(String str) {
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
        this.fSj.getLayoutMode().af(i == 1);
        this.fSj.getLayoutMode().w(this.aVi);
        this.mNavigationBar.onChangeSkinType(this.fSj.getPageContext(), i);
        av.c(this.aLj, u.f.icon_nav_close_selector);
        av.c(this.fSk, u.d.cp_link_tip_a, 1);
        this.fSn.vm();
    }

    public String getContent() {
        if (this.fSl.getText() == null) {
            return null;
        }
        return this.fSl.getText().toString();
    }

    public long bnZ() {
        if (this.fSl.getText() == null || this.fSl.getText().toString() == null) {
            return 0L;
        }
        return g(this.fSl.getText().toString().trim());
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

    public WriteLocationView boa() {
        return this.fSn;
    }

    public View bob() {
        return this.aUb;
    }

    public View boc() {
        return this.fSk;
    }

    public View amV() {
        return this.aLj;
    }

    public View bod() {
        return this.fSl;
    }

    public void cJ(long j) {
        if (this.aUb != null) {
            this.aUb.setContentDescription(String.valueOf(this.fSj.getResources().getString(u.j.video)) + ba.v(j));
        }
    }
}
