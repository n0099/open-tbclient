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
    private PbNewLocationInfoView baj;
    private ImageView bal;
    private boolean eLn;
    private EditorTools fsG;
    private int fsH;

    public PbLocationInfoContainer(Context context) {
        super(context);
        this.fsH = 0;
        this.eLn = true;
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
        this.baj = new PbNewLocationInfoView(getContext());
        setOnClickListener(this);
        addView(this.baj, layoutParams);
        this.bal = new ImageView(getContext());
        this.bal.setOnClickListener(this);
        addView(this.bal, new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds24), com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds24)));
    }

    public void Fj() {
        this.baj.onChangeSkinType();
        al.i(this, e.f.pb_new_locatin_view_selector);
        al.c(this.bal, e.f.icon_edit_close_n);
    }

    public void setLocationInfoViewState(int i, String str) {
        this.baj.setState(i, str);
    }

    public void setLocationInfoViewState(int i) {
        setLocationInfoViewState(i, null);
    }

    public int getLocationInfoViewState() {
        return this.baj.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.baj.getVisibility();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.bal) {
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
        this.fsG = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.fsG != null) {
            this.fsG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.fsH = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.fsH;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pN() {
        if (this.eLn) {
            this.eLn = false;
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
