package com.baidu.tieba.write.video;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class m {
    private static int faE = 31;
    private static int faF = -100;
    private TbImageView aPJ;
    private ImageView aPK;
    private View aQQ;
    private View azx;
    private WriteVideoActivity faG;
    private TextView faH;
    private EditText faI;
    private TextView faJ;
    private WriteLocationView faK;
    private NavigationBar mNavigationBar;

    public m(WriteVideoActivity writeVideoActivity) {
        this.faG = writeVideoActivity;
        this.faG.setContentView(t.h.write_video_activity);
        bcE();
        initView();
    }

    private void bcE() {
        this.aQQ = this.faG.findViewById(t.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.faG.findViewById(t.g.navigation_bar);
        this.faI = (EditText) this.faG.findViewById(t.g.edit_content);
        this.faJ = (TextView) this.faG.findViewById(t.g.text_content_size);
        this.aPJ = (TbImageView) this.faG.findViewById(t.g.image_video);
        this.aPK = (ImageView) this.faG.findViewById(t.g.image_video_play);
        this.faK = (WriteLocationView) this.faG.findViewById(t.g.location);
    }

    private void initView() {
        this.aPJ.setOnClickListener(this.faG);
        this.azx = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.faG);
        this.mNavigationBar.setTitleText(this.faG.getPageContext().getString(t.j.new_video_post));
        this.faH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.faG.getResources().getString(t.j.publish), this.faG, true);
        this.faJ.setText(String.valueOf(faE));
        this.faI.addTextChangedListener(new n(this));
        this.faI.setOnKeyListener(new o(this));
    }

    public void pg(String str) {
        Bitmap ph = ph(str);
        if (ph != null) {
            this.aPJ.setImageBitmap(ph);
        }
    }

    private Bitmap ph(String str) {
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
        this.faG.getLayoutMode().ae(i == 1);
        this.faG.getLayoutMode().x(this.aQQ);
        this.mNavigationBar.onChangeSkinType(this.faG.getPageContext(), i);
        at.k(this.faH, t.f.s_navbar_button_bg);
        at.j((View) this.faH, t.d.navbar_btn_color);
        this.faK.vm();
    }

    public String getContent() {
        if (this.faI.getText() == null) {
            return null;
        }
        return this.faI.getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcF() {
        if (faE - bcG() < 0) {
            this.faH.setEnabled(false);
        } else {
            this.faH.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long bcG() {
        if (this.faI.getText() == null || this.faI.getText().toString() == null) {
            return 0L;
        }
        return g(this.faI.getText().toString().trim());
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

    public WriteLocationView bcH() {
        return this.faK;
    }

    public View bcI() {
        return this.aPJ;
    }

    public View bcJ() {
        return this.faH;
    }

    public View adW() {
        return this.azx;
    }

    public View bcK() {
        return this.faI;
    }

    public void ci(long j) {
        if (this.aPJ != null) {
            this.aPJ.setContentDescription(String.valueOf(this.faG.getResources().getString(t.j.video)) + ay.z(j));
        }
    }
}
