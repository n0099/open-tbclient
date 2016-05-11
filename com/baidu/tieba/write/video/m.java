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
    private static int faF = 31;
    private static int faG = -100;
    private TbImageView aPJ;
    private ImageView aPK;
    private View aQQ;
    private View azx;
    private WriteVideoActivity faH;
    private TextView faI;
    private EditText faJ;
    private TextView faK;
    private WriteLocationView faL;
    private NavigationBar mNavigationBar;

    public m(WriteVideoActivity writeVideoActivity) {
        this.faH = writeVideoActivity;
        this.faH.setContentView(t.h.write_video_activity);
        bcx();
        initView();
    }

    private void bcx() {
        this.aQQ = this.faH.findViewById(t.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.faH.findViewById(t.g.navigation_bar);
        this.faJ = (EditText) this.faH.findViewById(t.g.edit_content);
        this.faK = (TextView) this.faH.findViewById(t.g.text_content_size);
        this.aPJ = (TbImageView) this.faH.findViewById(t.g.image_video);
        this.aPK = (ImageView) this.faH.findViewById(t.g.image_video_play);
        this.faL = (WriteLocationView) this.faH.findViewById(t.g.location);
    }

    private void initView() {
        this.aPJ.setOnClickListener(this.faH);
        this.azx = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.faH);
        this.mNavigationBar.setTitleText(this.faH.getPageContext().getString(t.j.new_video_post));
        this.faI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.faH.getResources().getString(t.j.publish), this.faH, true);
        this.faK.setText(String.valueOf(faF));
        this.faJ.addTextChangedListener(new n(this));
        this.faJ.setOnKeyListener(new o(this));
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
        this.faH.getLayoutMode().ae(i == 1);
        this.faH.getLayoutMode().x(this.aQQ);
        this.mNavigationBar.onChangeSkinType(this.faH.getPageContext(), i);
        at.k(this.faI, t.f.s_navbar_button_bg);
        at.j((View) this.faI, t.d.navbar_btn_color);
        this.faL.vl();
    }

    public String getContent() {
        if (this.faJ.getText() == null) {
            return null;
        }
        return this.faJ.getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcy() {
        if (faF - bcz() < 0) {
            this.faI.setEnabled(false);
        } else {
            this.faI.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long bcz() {
        if (this.faJ.getText() == null || this.faJ.getText().toString() == null) {
            return 0L;
        }
        return g(this.faJ.getText().toString().trim());
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

    public WriteLocationView bcA() {
        return this.faL;
    }

    public View bcB() {
        return this.aPJ;
    }

    public View bcC() {
        return this.faI;
    }

    public View adU() {
        return this.azx;
    }

    public View bcD() {
        return this.faJ;
    }

    public void ci(long j) {
        if (this.aPJ != null) {
            this.aPJ.setContentDescription(String.valueOf(this.faH.getResources().getString(t.j.video)) + ay.z(j));
        }
    }
}
