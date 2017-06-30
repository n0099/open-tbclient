package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private ac geA;
    private f geB;
    private String gev;
    private String gew;
    private AlbumActivity gex;
    private Fragment[] gey;
    private String[] gez;

    public d(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.gev = "tag_image";
        this.gew = "tag_b_image";
        this.gex = albumActivity;
    }

    public void brT() {
        this.gey = new Fragment[2];
        this.gez = new String[2];
        this.geA = new ac();
        this.gey[0] = this.geA;
        this.gez[0] = this.gev;
        this.geB = new f();
        this.gey[1] = this.geB;
        this.gez[1] = this.gew;
    }

    public Fragment tB(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gey[i];
    }

    public String tC(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gez[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.gey.length) {
                if (this.gey[i3] != null && (this.gey[i3] instanceof ac)) {
                    ((ac) this.gey[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView brU() {
        if (this.geA == null) {
            return null;
        }
        return this.geA.brU();
    }

    public View brV() {
        if (this.geA == null) {
            return null;
        }
        return this.geA.bgZ();
    }

    public View brW() {
        if (this.geA == null) {
            return null;
        }
        return this.geA.bsw();
    }

    public View brX() {
        if (this.geB == null) {
            return null;
        }
        return this.geB.bgZ();
    }

    public View brY() {
        if (this.geB == null) {
            return null;
        }
        return this.geB.bsg();
    }

    public View brZ() {
        if (this.geB == null) {
            return null;
        }
        return this.geB.brZ();
    }

    public void onDestroy() {
        if (this.gex.akX() != null) {
            this.gex.akX().Ek();
        }
    }

    public f bsa() {
        return this.geB;
    }

    public ac bsb() {
        return this.geA;
    }
}
