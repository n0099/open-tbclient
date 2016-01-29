package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.z;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends LinearLayout implements View.OnClickListener, z {
    private int atn;
    private boolean bRQ;
    private PbLocationInfoView cvr;
    private ImageView cvs;
    private View cvt;
    private k cvu;

    public c(Context context) {
        this(context, null);
        LayoutInflater.from(context).inflate(t.h.pb_editor_locationinfo_container, (ViewGroup) this, true);
        initView();
        xf();
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atn = 0;
        this.bRQ = true;
        LayoutInflater.from(context).inflate(t.h.pb_editor_locationinfo_container, (ViewGroup) this, true);
        initView();
        xf();
    }

    private void initView() {
        this.cvr = (PbLocationInfoView) findViewById(t.g.location_info_view);
        this.cvt = findViewById(t.g.pb_editor_location_divider);
        this.cvs = (ImageView) findViewById(t.g.location_info_del);
        this.cvr.setOnClickListener(this);
        this.cvs.setOnClickListener(this);
    }

    public void xf() {
        this.cvr.uv();
        ar.l(this.cvt, t.d.cp_cont_e);
        ar.k(this, t.d.pb_editor_location_bg_alpha);
        ar.c(this.cvs, t.f.icon_tips_close);
    }

    public void J(int i, String str) {
        this.cvr.s(i, str);
    }

    public void setLocationInfoViewState(int i) {
        J(i, null);
    }

    public int getLocationInfoViewState() {
        return this.cvr.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.cvr.getVisibility();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cvr) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.cvs) {
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
                if (aVar2.auM) {
                    ow();
                    if (TextUtils.isEmpty(aVar2.addr)) {
                        setLocationInfoViewState(aVar2.state);
                        return;
                    } else {
                        J(aVar2.state, aVar2.addr);
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
        this.cvu = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.cvu != null) {
            this.cvu.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.atn = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.atn;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void ow() {
        if (this.bRQ) {
            this.bRQ = false;
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
        xf();
    }
}
