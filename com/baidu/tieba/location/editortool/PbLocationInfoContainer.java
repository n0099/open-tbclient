package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, m {
    private boolean hNI;
    private TBSpecificationBtn jFI;
    private EditorTools jFJ;
    private int jFK;

    public PbLocationInfoContainer(Context context) {
        super(context);
        this.jFK = 0;
        this.hNI = true;
        initView();
    }

    private void initView() {
        setGravity(16);
        setOrientation(0);
        setPadding(l.getDimens(getContext(), R.dimen.ds20), 0, l.getDimens(getContext(), R.dimen.ds20), 0);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.ds48));
        layoutParams.setMargins(0, l.getDimens(getContext(), R.dimen.ds30), 0, l.getDimens(getContext(), R.dimen.ds12));
        setLayoutParams(layoutParams);
        c cVar = new c();
        cVar.mX(R.color.cp_cont_b);
        cVar.k(R.drawable.ic_icon_pure_post_location16_svg, 0, true);
        cVar.mS(R.color.cp_cont_e);
        cVar.aS(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        this.jFI = new TBSpecificationBtn(getContext());
        this.jFI.setConfig(cVar);
        this.jFI.setTextSize(R.dimen.tbds32);
        this.jFI.setOnClickListener(this);
        this.jFI.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.jFI, new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63)));
    }

    public void bci() {
        this.jFI.bci();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jFI) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
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
                if (aVar2.state == 1) {
                    this.jFI.setText(getContext().getString(R.string.location_loading));
                } else if (!TextUtils.isEmpty(aVar2.addr)) {
                    this.jFI.setText(aVar2.addr);
                } else {
                    this.jFI.setText(getContext().getString(R.string.location_where_are_you));
                }
            } else if (aVar.code == 20) {
                hide();
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.jFJ = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.jFJ != null) {
            this.jFJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.jFK = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.jFK;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.hNI) {
            this.hNI = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        this.jFI.setText(getContext().getString(R.string.location_where_are_you));
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        bci();
    }
}
