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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, l {
    private PbNewLocationInfoView csI;
    private ImageView csK;
    private boolean fwo;
    private EditorTools hdH;
    private int hdI;

    public PbLocationInfoContainer(Context context) {
        super(context);
        this.hdI = 0;
        this.fwo = true;
        initView();
    }

    private void initView() {
        setGravity(16);
        setOrientation(0);
        setPadding(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds20), 0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds20), 0);
        RawLayout.a aVar = new RawLayout.a(-2, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds48));
        aVar.setMargins(0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds30), 0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds12));
        setLayoutParams(aVar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds24), 0);
        this.csI = new PbNewLocationInfoView(getContext());
        setOnClickListener(this);
        addView(this.csI, layoutParams);
        this.csK = new ImageView(getContext());
        this.csK.setOnClickListener(this);
        addView(this.csK, new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds24), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds24)));
    }

    public void ajG() {
        this.csI.onChangeSkinType();
        al.k(this, R.drawable.pb_new_locatin_view_selector);
        al.c(this.csK, (int) R.drawable.icon_edit_close_n);
    }

    public void setLocationInfoViewState(int i, String str) {
        this.csI.setState(i, str);
    }

    public void setLocationInfoViewState(int i) {
        setLocationInfoViewState(i, null);
    }

    public int getLocationInfoViewState() {
        return this.csI.getState();
    }

    public int getLocationInfoViewVisibility() {
        return this.csI.getVisibility();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.csK) {
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
                    pO();
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
        this.hdH = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.hdH != null) {
            this.hdH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.hdI = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.hdI;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pO() {
        if (this.fwo) {
            this.fwo = false;
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
        ajG();
    }
}
