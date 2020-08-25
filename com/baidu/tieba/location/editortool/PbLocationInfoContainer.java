package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, n {
    private boolean ibN;
    private TBSpecificationBtn jUZ;
    private EditorTools jVa;
    private int jVb;

    public PbLocationInfoContainer(Context context) {
        super(context);
        this.jVb = 0;
        this.ibN = true;
        initView();
    }

    private void initView() {
        setGravity(16);
        setOrientation(0);
        setPadding(l.getDimens(getContext(), R.dimen.ds20), 0, l.getDimens(getContext(), R.dimen.ds20), 0);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.ds48));
        layoutParams.setMargins(0, l.getDimens(getContext(), R.dimen.ds30), 0, l.getDimens(getContext(), R.dimen.ds12));
        setLayoutParams(layoutParams);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pd(R.color.cp_cont_b);
        bVar.a(R.drawable.ic_icon_pure_post_location16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.oY(R.color.cp_cont_e);
        bVar.ba(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        this.jUZ = new TBSpecificationBtn(getContext());
        this.jUZ.setConfig(bVar);
        this.jUZ.setTextSize(R.dimen.tbds32);
        this.jUZ.setOnClickListener(this);
        this.jUZ.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.jUZ, new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63)));
    }

    public void changeSkinType(int i) {
        this.jUZ.changeSkinType(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jUZ) {
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
                    this.jUZ.setText(getContext().getString(R.string.location_loading));
                } else if (!TextUtils.isEmpty(aVar2.addr)) {
                    this.jUZ.setText(aVar2.addr);
                } else {
                    this.jUZ.setText(getContext().getString(R.string.location_where_are_you));
                }
            } else if (aVar.code == 20) {
                hide();
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.jVa = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.jVa != null) {
            this.jVa.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.jVb = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.jVb;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.ibN) {
            this.ibN = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        this.jUZ.setText(getContext().getString(R.string.location_where_are_you));
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        changeSkinType(i);
    }
}
