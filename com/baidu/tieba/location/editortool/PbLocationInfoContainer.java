package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.pb.PbNewLocationInfoView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, l {
    private PbNewLocationInfoView bam;
    private ImageView bao;
    private boolean eOe;
    private EditorTools fvy;
    private int fvz;

    public PbLocationInfoContainer(Context context) {
        super(context);
        this.fvz = 0;
        this.eOe = true;
        initView();
    }

    private void initView() {
        setGravity(16);
        setOrientation(0);
        setPadding(com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds20), 0, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds20), 0);
        RawLayout.a aVar = new RawLayout.a(-2, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds48));
        aVar.setMargins(0, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds30), 0, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds12));
        setLayoutParams(aVar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds24), 0);
        this.bam = new PbNewLocationInfoView(getContext());
        setOnClickListener(this);
        addView(this.bam, layoutParams);
        this.bao = new ImageView(getContext());
        this.bao.setOnClickListener(this);
        addView(this.bao, new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds24), com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds24)));
    }

    public void Fj() {
        this.bam.onChangeSkinType();
        al.i(this, e.f.pb_new_locatin_view_selector);
        al.c(this.bao, e.f.icon_edit_close_n);
    }

    public void setLocationInfoViewState(int i, String str) {
        this.bam.setState(i, str);
    }

    public void setLocationInfoViewState(int i) {
        setLocationInfoViewState(i, null);
    }

    public int getLocationInfoViewState() {
        return this.bam.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.bam.getVisibility();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.bao) {
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
                com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                if (aVar2.isShow) {
                    pN();
                    if (TextUtils.isEmpty(aVar2.addr)) {
                        setLocationInfoViewState(aVar2.state);
                        return;
                    } else {
                        setLocationInfoViewState(aVar2.state, aVar2.addr);
                        return;
                    }
                }
                hide();
            } else if (aVar.code == 20) {
                hide();
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.fvy = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.fvy != null) {
            this.fvy.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.fvz = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.fvz;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pN() {
        if (this.eOe) {
            this.eOe = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        Fj();
    }
}
