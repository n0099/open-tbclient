package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bbL;
    private String bvP;
    private String bvQ;
    private TbPageContext idM;
    private e nmM;
    private String[] nmN;
    private ImageListFragment nmO;
    private AlbumImageBrowseFragment nmP;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.bvP = "tag_image";
        this.bvQ = "tag_b_image";
        this.idM = tbPageContext;
        this.nmM = eVar;
    }

    public void Qj() {
        this.bbL = new Fragment[2];
        this.nmN = new String[2];
        this.nmO = new ImageListFragment();
        this.nmO.a(this.nmM);
        this.bbL[0] = this.nmO;
        this.nmN[0] = this.bvP;
        this.nmP = new AlbumImageBrowseFragment();
        this.nmP.a(this.nmM);
        this.bbL[1] = this.nmP;
        this.nmN[1] = this.bvQ;
    }

    public Fragment KH(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bbL[i];
    }

    public String KI(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.nmN[i];
    }

    public void a(NavigationBar navigationBar) {
        this.nmO.a(navigationBar);
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bbL.length) {
                if (this.bbL[i3] != null && (this.bbL[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bbL[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dNI() {
        if (this.nmO == null) {
            return null;
        }
        return this.nmO.dNI();
    }

    public void stopCamera() {
        TbCameraView dNI = dNI();
        if (dNI != null) {
            dNI.stopCamera();
            dNI.setVisibility(4);
        }
    }

    public void openCamera() {
        TbCameraView dNI = dNI();
        if (dNI != null) {
            dNI.setVisibility(0);
            dNI.xX(false);
        }
        if (this.nmO != null && this.nmO.dNT() != null) {
            this.nmO.dNT().QG();
        }
    }

    public void dNJ() {
        if (this.nmO != null) {
            this.nmO.QE();
        }
    }

    public View Qk() {
        if (this.nmO == null) {
            return null;
        }
        return this.nmO.QB();
    }

    public View Ql() {
        if (this.nmO == null) {
            return null;
        }
        return this.nmO.QF();
    }

    public View Qm() {
        if (this.nmP == null) {
            return null;
        }
        return this.nmP.QB();
    }

    public View Qn() {
        if (this.nmP == null) {
            return null;
        }
        return this.nmP.QC();
    }

    public View Qo() {
        if (this.nmP == null) {
            return null;
        }
        return this.nmP.Qo();
    }

    public View Qp() {
        if (this.nmO == null) {
            return null;
        }
        return this.nmO.Qo();
    }

    public void onDestroy() {
    }

    public ImageListFragment dNK() {
        return this.nmO;
    }

    public void cD(boolean z) {
        if (this.nmP != null) {
            this.nmP.cD(z);
        }
        if (this.nmO != null) {
            this.nmO.cD(z);
        }
    }

    public void a(j jVar) {
        if (this.nmO != null) {
            this.nmO.a(jVar);
        }
    }
}
