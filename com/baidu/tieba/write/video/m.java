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
    private static int eJO = 31;
    private static int eJP = -100;
    private View aDt;
    private TbImageView aTv;
    private ImageView aTw;
    private View aUw;
    private WriteVideoActivity eJQ;
    private TextView eJR;
    private EditText eJS;
    private TextView eJT;
    private WriteLocationView eJU;
    private NavigationBar mNavigationBar;

    public m(WriteVideoActivity writeVideoActivity) {
        this.eJQ = writeVideoActivity;
        this.eJQ.setContentView(t.h.write_video_activity);
        bal();
        initView();
    }

    private void bal() {
        this.aUw = this.eJQ.findViewById(t.g.layout_root);
        this.mNavigationBar = (NavigationBar) this.eJQ.findViewById(t.g.navigation_bar);
        this.eJS = (EditText) this.eJQ.findViewById(t.g.edit_content);
        this.eJT = (TextView) this.eJQ.findViewById(t.g.text_content_size);
        this.aTv = (TbImageView) this.eJQ.findViewById(t.g.image_video);
        this.aTw = (ImageView) this.eJQ.findViewById(t.g.image_video_play);
        this.eJU = (WriteLocationView) this.eJQ.findViewById(t.g.location);
    }

    private void initView() {
        this.aTv.setOnClickListener(this.eJQ);
        this.aDt = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eJQ);
        this.mNavigationBar.setTitleText(this.eJQ.getPageContext().getString(t.j.new_video_post));
        this.eJR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.eJQ.getResources().getString(t.j.publish), this.eJQ, true);
        this.eJT.setText(String.valueOf(eJO));
        this.eJS.addTextChangedListener(new n(this));
        this.eJS.setOnKeyListener(new o(this));
    }

    public void oS(String str) {
        Bitmap oT = oT(str);
        if (oT != null) {
            this.aTv.setImageBitmap(oT);
        }
    }

    private Bitmap oT(String str) {
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
        this.eJQ.getLayoutMode().ab(i == 1);
        this.eJQ.getLayoutMode().x(this.aUw);
        this.mNavigationBar.onChangeSkinType(this.eJQ.getPageContext(), i);
        at.k(this.eJR, t.f.s_navbar_button_bg);
        this.eJU.xy();
    }

    public String getContent() {
        if (this.eJS.getText() == null) {
            return null;
        }
        return this.eJS.getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bam() {
        if (eJO - ban() < 0) {
            this.eJR.setEnabled(false);
        } else {
            this.eJR.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ban() {
        if (this.eJS.getText() == null || this.eJS.getText().toString() == null) {
            return 0L;
        }
        return g(this.eJS.getText().toString().trim());
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

    public WriteLocationView bao() {
        return this.eJU;
    }

    public View bap() {
        return this.aTv;
    }

    public View baq() {
        return this.eJR;
    }

    public View adU() {
        return this.aDt;
    }

    public View bar() {
        return this.eJS;
    }

    public void ch(long j) {
        if (this.aTv != null) {
            this.aTv.setContentDescription(String.valueOf(this.eJQ.getResources().getString(t.j.video)) + ay.y(j));
        }
    }
}
