package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.p;
import com.baidu.tbadk.editortools.pb.PbNewLocationInfoView;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends LinearLayout implements View.OnClickListener, s {
    private PbNewLocationInfoView buq;
    private ImageView bus;
    private boolean ezu;
    private i fgG;
    private int fgH;

    public c(Context context) {
        super(context);
        this.fgH = 0;
        this.ezu = true;
        initView();
    }

    private void initView() {
        setGravity(16);
        setOrientation(0);
        setPadding(l.t(getContext(), d.e.ds20), 0, l.t(getContext(), d.e.ds20), 0);
        p.a aVar = new p.a(-2, l.t(getContext(), d.e.ds48));
        aVar.setMargins(0, l.t(getContext(), d.e.ds30), 0, l.t(getContext(), d.e.ds12));
        setLayoutParams(aVar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.t(getContext(), d.e.ds24), 0);
        this.buq = new PbNewLocationInfoView(getContext());
        setOnClickListener(this);
        addView(this.buq, layoutParams);
        this.bus = new ImageView(getContext());
        this.bus.setOnClickListener(this);
        addView(this.bus, new LinearLayout.LayoutParams(l.t(getContext(), d.e.ds24), l.t(getContext(), d.e.ds24)));
    }

    public void En() {
        this.buq.onChangeSkinType();
        aj.s(this, d.f.pb_new_locatin_view_selector);
        aj.c(this.bus, d.f.icon_edit_close_n);
    }

    public void S(int i, String str) {
        this.buq.j(i, str);
    }

    public void setLocationInfoViewState(int i) {
        S(i, null);
    }

    public int getLocationInfoViewState() {
        return this.buq.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.buq.getVisibility();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.bus) {
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
                if (aVar2.btQ) {
                    th();
                    if (TextUtils.isEmpty(aVar2.addr)) {
                        setLocationInfoViewState(aVar2.state);
                        return;
                    } else {
                        S(aVar2.state, aVar2.addr);
                        return;
                    }
                }
                hide();
            } else if (aVar.code == 20) {
                hide();
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.fgG = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.fgG != null) {
            this.fgG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.fgH = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.fgH;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        if (this.ezu) {
            this.ezu = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        En();
    }
}
