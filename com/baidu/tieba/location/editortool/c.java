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
    private int aqQ;
    private boolean bKl;
    private PbLocationInfoView ckE;
    private ImageView ckF;
    private View ckG;
    private k ckH;

    public c(Context context) {
        this(context, null);
        LayoutInflater.from(context).inflate(n.g.pb_editor_locationinfo_container, (ViewGroup) this, true);
        initView();
        wh();
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqQ = 0;
        this.bKl = true;
        LayoutInflater.from(context).inflate(n.g.pb_editor_locationinfo_container, (ViewGroup) this, true);
        initView();
        wh();
    }

    private void initView() {
        this.ckE = (PbLocationInfoView) findViewById(n.f.location_info_view);
        this.ckG = findViewById(n.f.pb_editor_location_divider);
        this.ckF = (ImageView) findViewById(n.f.location_info_del);
        this.ckE.setOnClickListener(this);
        this.ckF.setOnClickListener(this);
    }

    public void wh() {
        this.ckE.tH();
        as.j(this.ckG, n.c.cp_cont_e);
        as.i(this, n.c.pb_editor_location_bg_alpha);
        as.c(this.ckF, n.e.icon_tips_close);
    }

    public void H(int i, String str) {
        this.ckE.s(i, str);
    }

    public void setLocationInfoViewState(int i) {
        H(i, null);
    }

    public int getLocationInfoViewState() {
        return this.ckE.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.ckE.getVisibility();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ckE) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.ckF) {
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
                if (aVar2.asq) {
                    oD();
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
        this.ckH = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ckH != null) {
            this.ckH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.aqQ = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.aqQ;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.z
    public void oD() {
        if (this.bKl) {
            this.bKl = false;
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
        wh();
    }
}
