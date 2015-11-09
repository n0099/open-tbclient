package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c extends LinearLayout implements View.OnClickListener, x {
    private PbLocationInfoView bUq;
    private ImageView bUr;
    private View bUs;
    private j bUt;
    private int bUu;
    private boolean bvf;

    public c(Context context) {
        this(context, null);
        LayoutInflater.from(context).inflate(i.g.pb_editor_locationinfo_container, (ViewGroup) this, true);
        initView();
        vB();
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUu = 0;
        this.bvf = true;
        LayoutInflater.from(context).inflate(i.g.pb_editor_locationinfo_container, (ViewGroup) this, true);
        initView();
        vB();
    }

    private void initView() {
        this.bUq = (PbLocationInfoView) findViewById(i.f.location_info_view);
        this.bUs = findViewById(i.f.pb_editor_location_divider);
        this.bUr = (ImageView) findViewById(i.f.location_info_del);
        this.bUq.setOnClickListener(this);
        this.bUr.setOnClickListener(this);
    }

    public void vB() {
        this.bUq.tc();
        an.j(this.bUs, i.c.cp_cont_e);
        an.i(this, i.c.pb_editor_location_bg_alpha);
        an.c(this.bUr, i.e.icon_tips_close);
    }

    public void G(int i, String str) {
        this.bUq.r(i, str);
    }

    public void setLocationInfoViewState(int i) {
        G(i, null);
    }

    public int getLocationInfoViewState() {
        return this.bUq.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.bUq.getVisibility();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bUq) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.bUr) {
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
                com.baidu.tbadk.editortools.b.a aVar2 = (com.baidu.tbadk.editortools.b.a) aVar.data;
                if (aVar2.aqm) {
                    ox();
                    if (TextUtils.isEmpty(aVar2.addr)) {
                        setLocationInfoViewState(aVar2.state);
                        return;
                    } else {
                        G(aVar2.state, aVar2.addr);
                        return;
                    }
                }
                hide();
            } else if (aVar.code == 20) {
                hide();
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.x
    public void setEditorTools(j jVar) {
        this.bUt = jVar;
    }

    @Override // com.baidu.tbadk.editortools.x
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.bUt != null) {
            this.bUt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.x
    public void setToolId(int i) {
        this.bUu = i;
    }

    @Override // com.baidu.tbadk.editortools.x
    public int getToolId() {
        return this.bUu;
    }

    @Override // com.baidu.tbadk.editortools.x
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.x
    public void ox() {
        if (this.bvf) {
            this.bvf = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.x
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.x
    public void onChangeSkinType(int i) {
        vB();
    }
}
