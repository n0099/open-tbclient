package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.pb.PbNewLocationInfoView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, l {
    private PbNewLocationInfoView aNl;
    private ImageView aNn;
    private EditorTools eNK;
    private int eNL;
    private boolean egp;

    public PbLocationInfoContainer(Context context) {
        super(context);
        this.eNL = 0;
        this.egp = true;
        initView();
    }

    private void initView() {
        setGravity(16);
        setOrientation(0);
        setPadding(com.baidu.adp.lib.util.l.e(getContext(), d.e.ds20), 0, com.baidu.adp.lib.util.l.e(getContext(), d.e.ds20), 0);
        RawLayout.a aVar = new RawLayout.a(-2, com.baidu.adp.lib.util.l.e(getContext(), d.e.ds48));
        aVar.setMargins(0, com.baidu.adp.lib.util.l.e(getContext(), d.e.ds30), 0, com.baidu.adp.lib.util.l.e(getContext(), d.e.ds12));
        setLayoutParams(aVar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.e(getContext(), d.e.ds24), 0);
        this.aNl = new PbNewLocationInfoView(getContext());
        setOnClickListener(this);
        addView(this.aNl, layoutParams);
        this.aNn = new ImageView(getContext());
        this.aNn.setOnClickListener(this);
        addView(this.aNn, new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.e(getContext(), d.e.ds24), com.baidu.adp.lib.util.l.e(getContext(), d.e.ds24)));
    }

    public void Ay() {
        this.aNl.onChangeSkinType();
        al.i(this, d.f.pb_new_locatin_view_selector);
        al.c(this.aNn, d.f.icon_edit_close_n);
    }

    public void setLocationInfoViewState(int i, String str) {
        this.aNl.setState(i, str);
    }

    public void setLocationInfoViewState(int i) {
        setLocationInfoViewState(i, null);
    }

    public int getLocationInfoViewState() {
        return this.aNl.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.aNl.getVisibility();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.aNn) {
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
                if (aVar2.aMM) {
                    oD();
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
        this.eNK = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.eNK != null) {
            this.eNK.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.eNL = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.eNL;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oD() {
        if (this.egp) {
            this.egp = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        Ay();
    }
}
