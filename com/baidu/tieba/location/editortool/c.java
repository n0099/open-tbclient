package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.z;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c extends LinearLayout implements View.OnClickListener, z {
    private int asu;
    private boolean bNS;
    private PbLocationInfoView coI;
    private ImageView coJ;
    private View coK;
    private k coL;

    public c(Context context) {
        this(context, null);
        LayoutInflater.from(context).inflate(n.h.pb_editor_locationinfo_container, (ViewGroup) this, true);
        initView();
        vR();
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asu = 0;
        this.bNS = true;
        LayoutInflater.from(context).inflate(n.h.pb_editor_locationinfo_container, (ViewGroup) this, true);
        initView();
        vR();
    }

    private void initView() {
        this.coI = (PbLocationInfoView) findViewById(n.g.location_info_view);
        this.coK = findViewById(n.g.pb_editor_location_divider);
        this.coJ = (ImageView) findViewById(n.g.location_info_del);
        this.coI.setOnClickListener(this);
        this.coJ.setOnClickListener(this);
    }

    public void vR() {
        this.coI.tr();
        as.j(this.coK, n.d.cp_cont_e);
        as.i(this, n.d.pb_editor_location_bg_alpha);
        as.c(this.coJ, n.f.icon_tips_close);
    }

    public void H(int i, String str) {
        this.coI.s(i, str);
    }

    public void setLocationInfoViewState(int i) {
        H(i, null);
    }

    public int getLocationInfoViewState() {
        return this.coI.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.coI.getVisibility();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.coI) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.coJ) {
            hide();
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 19) {
                if (aVar.data == null) {
                    hide();
                    return;
                }
                com.baidu.tbadk.editortools.c.a aVar2 = (com.baidu.tbadk.editortools.c.a) aVar.data;
                if (aVar2.atU) {
                    ob();
                    if (TextUtils.isEmpty(aVar2.addr)) {
                        setLocationInfoViewState(aVar2.state);
                        return;
                    } else {
                        H(aVar2.state, aVar2.addr);
                        return;
                    }
                }
                hide();
            } else if (aVar.code == 20) {
                hide();
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(k kVar) {
        this.coL = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.coL != null) {
            this.coL.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.asu = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.asu;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void ob() {
        if (this.bNS) {
            this.bNS = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
        vR();
    }
}
